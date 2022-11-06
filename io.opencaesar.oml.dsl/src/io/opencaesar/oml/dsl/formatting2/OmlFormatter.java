/**
 * Copyright 2019 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.opencaesar.oml.dsl.formatting2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.formatting2.AbstractJavaFormatter;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.inject.Inject;

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.AnnotationPropertyReference;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.AspectReference;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.ConceptInstanceReference;
import io.opencaesar.oml.ConceptReference;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.DescriptionBundleExtension;
import io.opencaesar.oml.DescriptionBundleImport;
import io.opencaesar.oml.DescriptionBundleInclusion;
import io.opencaesar.oml.DescriptionBundleUsage;
import io.opencaesar.oml.DescriptionExtension;
import io.opencaesar.oml.DescriptionImport;
import io.opencaesar.oml.DescriptionStatement;
import io.opencaesar.oml.DescriptionUsage;
import io.opencaesar.oml.DifferentFromPredicate;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EnumeratedScalar;
import io.opencaesar.oml.EnumeratedScalarReference;
import io.opencaesar.oml.FacetedScalar;
import io.opencaesar.oml.FacetedScalarReference;
import io.opencaesar.oml.FeaturePredicate;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.LinkAssertion;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Predicate;
import io.opencaesar.oml.PropertyRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.RelationCardinalityRestrictionAxiom;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;
import io.opencaesar.oml.RelationEntityReference;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.RelationInstanceReference;
import io.opencaesar.oml.RelationRangeRestrictionAxiom;
import io.opencaesar.oml.RelationReference;
import io.opencaesar.oml.RelationRestrictionAxiom;
import io.opencaesar.oml.RelationTargetRestrictionAxiom;
import io.opencaesar.oml.ReverseRelation;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.RuleReference;
import io.opencaesar.oml.SameAsPredicate;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.ScalarPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyReference;
import io.opencaesar.oml.ScalarPropertyValueAssertion;
import io.opencaesar.oml.ScalarPropertyValueRestrictionAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructureReference;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.StructuredPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyReference;
import io.opencaesar.oml.StructuredPropertyValueAssertion;
import io.opencaesar.oml.StructuredPropertyValueRestrictionAxiom;
import io.opencaesar.oml.TypePredicate;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyBundle;
import io.opencaesar.oml.VocabularyBundleExtension;
import io.opencaesar.oml.VocabularyBundleImport;
import io.opencaesar.oml.VocabularyBundleInclusion;
import io.opencaesar.oml.VocabularyExtension;
import io.opencaesar.oml.VocabularyImport;
import io.opencaesar.oml.VocabularyStatement;
import io.opencaesar.oml.VocabularyUsage;
import io.opencaesar.oml.dsl.services.OmlGrammarAccess;

@SuppressWarnings("all")
public class OmlFormatter extends AbstractJavaFormatter {

	@Inject
	protected OmlGrammarAccess oml;

	@Inject
	protected IIndentationInformation indent;

	@Override
	protected void initialize(FormatterRequest request) {
		final var preferences = request.getPreferences();
		if (preferences instanceof MapBasedPreferenceValues) {
			((MapBasedPreferenceValues) preferences).put(FormatterPreferenceKeys.indentation, indent.getIndentString());
		}
		super.initialize(request);
	}

	protected void _format(Annotation annotation, IFormattableDocument doc) {
		doc.append(keyword(annotation, oml.getAnnotationAccess().getCommercialAtKeyword_0()), noSpace());
		ifNotNull(annotation.getValue(), i -> doc.prepend(doc.format(i), oneSpace()));
	}

	protected void _format(Vocabulary vocabulary, IFormattableDocument doc) {
		doc.prepend(vocabulary, compose(setNewLines(0, 0, 0), noSpace()));
		vocabulary.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(vocabulary, oml.getVocabularyAccess().getVocabularyKeyword_1()), oneSpace());
		doc.surround(keyword(vocabulary, oml.getVocabularyAccess().getAsKeyword_3()), oneSpace());
		formatBraces(vocabulary, doc);
		vocabulary.getOwnedImports().forEach(i -> doc.prepend(doc.format(i), newLines(2)));
		vocabulary.getOwnedStatements().forEach(i -> doc.prepend(doc.format(i), newLines(2)));
	}

	protected void _format(VocabularyBundle bundle, IFormattableDocument doc) {
		doc.prepend(bundle, compose(setNewLines(0, 0, 0), noSpace()));
		bundle.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(bundle, oml.getVocabularyBundleAccess().getVocabularyKeyword_1()), oneSpace());
		doc.surround(keyword(bundle, oml.getVocabularyBundleAccess().getBundleKeyword_2()), oneSpace());
		doc.surround(keyword(bundle, oml.getVocabularyBundleAccess().getAsKeyword_4()), oneSpace());
		formatBraces(bundle, doc);
		bundle.getOwnedImports().forEach(i -> doc.prepend(doc.format(i), newLines(2)));
	}

	protected void _format(Description description, IFormattableDocument doc) {
		doc.prepend(description, compose(setNewLines(0, 0, 0), noSpace()));
		description.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(description, oml.getDescriptionAccess().getDescriptionKeyword_1()), oneSpace());
		doc.surround(keyword(description, oml.getDescriptionAccess().getAsKeyword_3()), oneSpace());
		formatBraces(description, doc);
		description.getOwnedImports().forEach(i -> doc.prepend(doc.format(i), newLines(2)));
		description.getOwnedStatements().forEach(i -> doc.prepend(doc.format(i), newLines(2)));
	}

	protected void _format(DescriptionBundle bundle, IFormattableDocument doc) {
		doc.prepend(bundle, compose(setNewLines(0, 0, 0), noSpace()));
		bundle.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(bundle, oml.getDescriptionBundleAccess().getDescriptionKeyword_1()), oneSpace());
		doc.surround(keyword(bundle, oml.getDescriptionBundleAccess().getBundleKeyword_2()), oneSpace());
		doc.surround(keyword(bundle, oml.getDescriptionBundleAccess().getAsKeyword_4()), oneSpace());
		formatBraces(bundle, doc);
		bundle.getOwnedImports().forEach(i -> doc.prepend(doc.format(i), newLines(2)));
	}

	protected void _format(Aspect aspect, IFormattableDocument doc) {
		aspect.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(aspect, oml.getAspectAccess().getAspectKeyword_1()), oneSpace());
		doc.surround(keyword(aspect, oml.getAspectAccess().getColonGreaterThanSignKeyword_3_0()), oneSpace());
		formatCommas(aspect, doc);
		formatBrackets(aspect, doc);
		aspect.getOwnedKeys().forEach(i -> doc.prepend(doc.format(i), newLine()));
		aspect.getOwnedPropertyRestrictions().forEach(i -> doc.prepend(doc.format(i), newLine()));
		aspect.getOwnedRelationRestrictions().forEach(i -> doc.prepend(doc.format(i), newLine()));
	}

	protected void _format(Concept concept, IFormattableDocument doc) {
		concept.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(concept, oml.getConceptAccess().getConceptKeyword_1()), oneSpace());
		doc.surround(keyword(concept, oml.getConceptAccess().getColonGreaterThanSignKeyword_3_0()), oneSpace());
		formatCommas(concept, doc);
		formatBrackets(concept, doc);
		concept.getOwnedKeys().forEach(i -> doc.prepend(doc.format(i), newLine()));
		concept.getOwnedPropertyRestrictions().forEach(i -> doc.prepend(doc.format(i), newLine()));
		concept.getOwnedRelationRestrictions().forEach(i -> doc.prepend(doc.format(i), newLine()));
		ifNotEmpty(concept.getEnumeratedInstances(), i -> {
			doc.prepend(keyword(concept, oml.getConceptAccess().getEnumeratesKeyword_4_2_0()), newLine());
			i.forEach(j -> doc.append(doc.prepend(doc.format(j), oneSpace()), noSpace()));
		});
	}

	protected void _format(RelationEntity entity, IFormattableDocument doc) {
		entity.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(entity, oml.getRelationEntityAccess().getRelationKeyword_1()), oneSpace());
		doc.surround(keyword(entity, oml.getRelationEntityAccess().getEntityKeyword_2()), oneSpace());
		formatCommas(entity, doc);
		formatBrackets(entity, doc);
		doc.append(doc.prepend(keyword(entity, oml.getRelationEntityAccess().getFromKeyword_6()), newLine()), oneSpace());
		doc.append(doc.prepend(keyword(entity, oml.getRelationEntityAccess().getToKeyword_8()), newLine()), oneSpace());
		ifNotNull(entity.getForwardRelation(), i -> doc.prepend(doc.format(i), newLine()));
		ifNotNull(entity.getReverseRelation(), i -> doc.prepend(doc.format(i), newLine()));
		doc.prepend(keyword(entity, oml.getRelationEntityAccess().getFunctionalFunctionalKeyword_11_0_0()), newLine());
		doc.prepend(keyword(entity, oml.getRelationEntityAccess().getInverseFunctionalInverseKeyword_11_1_0_0()), newLine());
		doc.prepend(keyword(entity, oml.getRelationEntityAccess().getSymmetricSymmetricKeyword_11_2_0()), newLine());
		doc.prepend(keyword(entity, oml.getRelationEntityAccess().getAsymmetricAsymmetricKeyword_11_3_0()), newLine());
		doc.prepend(keyword(entity, oml.getRelationEntityAccess().getReflexiveReflexiveKeyword_11_4_0()), newLine());
		doc.prepend(keyword(entity, oml.getRelationEntityAccess().getIrreflexiveIrreflexiveKeyword_11_5_0()), newLine());
		doc.prepend(keyword(entity, oml.getRelationEntityAccess().getTransitiveTransitiveKeyword_11_6_0()), newLine());
		entity.getOwnedKeys().forEach(i -> doc.prepend(doc.format(i), newLine()));
		entity.getOwnedPropertyRestrictions().forEach(i -> doc.prepend(doc.format(i), newLine()));
		entity.getOwnedRelationRestrictions().forEach(i -> doc.prepend(doc.format(i), newLine()));
	}

	protected void _format(Structure structure, IFormattableDocument doc) {
		structure.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(structure, oml.getStructureAccess().getStructureKeyword_1()), oneSpace());
		formatCommas(structure, doc);
		formatBrackets(structure, doc);
		structure.getOwnedPropertyRestrictions().forEach(i -> doc.prepend(doc.format(i), newLine()));
	}

	protected void _format(AnnotationProperty property, IFormattableDocument doc) {
		property.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(property, oml.getAnnotationPropertyAccess().getAnnotationKeyword_1()), oneSpace());
		doc.surround(keyword(property, oml.getAnnotationPropertyAccess().getPropertyKeyword_2()), oneSpace());
		formatCommas(property, doc);
	}

	protected void _format(ScalarProperty property, IFormattableDocument doc) {
		property.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(property, oml.getScalarPropertyAccess().getScalarKeyword_1()), oneSpace());
		doc.surround(keyword(property, oml.getScalarPropertyAccess().getPropertyKeyword_2()), oneSpace());
		formatCommas(property, doc);
		formatBrackets(property, doc);
		doc.prepend(keyword(property, oml.getScalarPropertyAccess().getDomainKeyword_5_1()), newLine());
		doc.prepend(keyword(property, oml.getScalarPropertyAccess().getRangeKeyword_5_3()), newLine());
		doc.prepend(keyword(property, oml.getScalarPropertyAccess().getFunctionalFunctionalKeyword_5_5_0()), newLine());
	}

	protected void _format(StructuredProperty property, IFormattableDocument doc) {
		property.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(property, oml.getStructuredPropertyAccess().getStructuredKeyword_1()), oneSpace());
		doc.surround(keyword(property, oml.getStructuredPropertyAccess().getPropertyKeyword_2()), oneSpace());
		formatCommas(property, doc);
		formatBrackets(property, doc);
		doc.prepend(keyword(property, oml.getStructuredPropertyAccess().getDomainKeyword_5_1()), newLine());
		doc.prepend(keyword(property, oml.getStructuredPropertyAccess().getRangeKeyword_5_3()), newLine());
		doc.prepend(keyword(property, oml.getStructuredPropertyAccess().getFunctionalFunctionalKeyword_5_5_0()), newLine());
	}

	protected void _format(FacetedScalar scalar, IFormattableDocument doc) {
		scalar.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(scalar, oml.getFacetedScalarAccess().getScalarKeyword_1()), oneSpace());
		formatCommas(scalar, doc);
		formatBrackets(scalar, doc);
		doc.prepend(keyword(scalar, oml.getFacetedScalarAccess().getLengthKeyword_4_1_0_0()), newLine());
		doc.prepend(keyword(scalar, oml.getFacetedScalarAccess().getMinLengthKeyword_4_1_1_0()), newLine());
		doc.prepend(keyword(scalar, oml.getFacetedScalarAccess().getMaxLengthKeyword_4_1_2_0()), newLine());
		doc.prepend(keyword(scalar, oml.getFacetedScalarAccess().getPatternKeyword_4_1_3_0()), newLine());
		doc.prepend(keyword(scalar, oml.getFacetedScalarAccess().getLanguageKeyword_4_1_4_0()), newLine());
		doc.prepend(keyword(scalar, oml.getFacetedScalarAccess().getMinInclusiveKeyword_4_1_5_0()), newLine());
		ifNotNull(scalar.getMinInclusive(), i -> doc.prepend(doc.format(i), oneSpace()));
		doc.prepend(keyword(scalar, oml.getFacetedScalarAccess().getMaxInclusiveKeyword_4_1_7_0()), newLine());
		ifNotNull(scalar.getMaxInclusive(), i -> doc.prepend(doc.format(i), oneSpace()));
		doc.prepend(keyword(scalar, oml.getFacetedScalarAccess().getMinExclusiveKeyword_4_1_6_0()), newLine());
		ifNotNull(scalar.getMinExclusive(), i -> doc.prepend(doc.format(i), oneSpace()));
		doc.prepend(keyword(scalar, oml.getFacetedScalarAccess().getMaxExclusiveKeyword_4_1_8_0()), newLine());
		ifNotNull(scalar.getMaxExclusive(), i -> doc.prepend(doc.format(i), oneSpace()));
	}

	protected void _format(EnumeratedScalar scalar, IFormattableDocument doc) {
		scalar.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(scalar, oml.getEnumeratedScalarAccess().getEnumeratedKeyword_1()), oneSpace());
		doc.surround(keyword(scalar, oml.getEnumeratedScalarAccess().getScalarKeyword_2()), oneSpace());
		formatCommas(scalar, doc);
		formatBrackets(scalar, doc);
		scalar.getLiterals().forEach(i -> doc.prepend(doc.format(i), newLine()));
	}

	protected void _format(ForwardRelation relation, IFormattableDocument doc) {
		relation.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(relation, oml.getForwardRelationAccess().getForwardKeyword_1()), oneSpace());
	}

	protected void _format(ReverseRelation relation, IFormattableDocument doc) {
		relation.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(relation, oml.getReverseRelationAccess().getReverseKeyword_1()), oneSpace());
	}

	protected void _format(Rule rule, IFormattableDocument doc) {
		rule.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(rule, oml.getRuleAccess().getRuleKeyword_1()), oneSpace());
		formatBrackets(rule, doc);
		ifNotEmpty(rule.getAntecedent(), i -> doc.prepend(doc.format(i.get(0)), newLine()));
		keywords(rule, "^").forEach(i -> doc.surround(i, oneSpace()));
		rule.getAntecedent().forEach(i -> doc.format(i));
		doc.surround(keyword(rule, oml.getRuleAccess().getHyphenMinusGreaterThanSignKeyword_6()), oneSpace());
		rule.getConsequent().forEach(i -> doc.format(i));
	}

	protected void _format(ConceptInstance instance, IFormattableDocument doc) {
		instance.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(instance, oml.getConceptInstanceAccess().getCiKeyword_1()), oneSpace());
		doc.surround(keyword(instance, oml.getConceptInstanceAccess().getColonKeyword_3_0()), oneSpace());
		formatCommas(instance, doc);
		formatBrackets(instance, doc);
		instance.getOwnedPropertyValues().forEach(i -> doc.prepend(doc.format(i), newLine()));
		instance.getOwnedLinks().forEach(i -> doc.prepend(doc.format(i), newLine()));
	}

	protected void _format(RelationInstance instance, IFormattableDocument doc) {
		instance.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(instance, oml.getRelationInstanceAccess().getRiKeyword_1()), oneSpace());
		doc.surround(keyword(instance, oml.getRelationInstanceAccess().getColonKeyword_3_0()), oneSpace());
		formatCommas(instance, doc);
		formatBrackets(instance, doc);
		doc.append(doc.prepend(keyword(instance, oml.getRelationInstanceAccess().getFromKeyword_5()), newLine()), oneSpace());
		instance.getSources().forEach(i -> doc.prepend(doc.format(i), oneSpace()));
		doc.append(doc.prepend(keyword(instance, oml.getRelationInstanceAccess().getToKeyword_8()), newLine()), oneSpace());
		instance.getTargets().forEach(i -> doc.prepend(doc.format(i), oneSpace()));
		instance.getOwnedPropertyValues().forEach(i -> doc.prepend(doc.format(i), newLine()));
		instance.getOwnedLinks().forEach(i -> doc.prepend(doc.format(i), newLine()));
	}

	protected void _format(StructureInstance instance, IFormattableDocument doc) {
		formatBrackets(instance, doc);
		instance.getOwnedPropertyValues().forEach(i -> doc.prepend(doc.format(i), newLine()));
	}

	protected void _format(AspectReference reference, IFormattableDocument doc) {
		reference.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(reference, oml.getAspectReferenceAccess().getRefKeyword_1()), oneSpace());
		doc.surround(keyword(reference, oml.getAspectReferenceAccess().getAspectKeyword_2()), oneSpace());
		formatCommas(reference, doc);
		formatBrackets(reference, doc);
		reference.getOwnedKeys().forEach(i -> doc.prepend(doc.format(i), newLine()));
		reference.getOwnedPropertyRestrictions().forEach(i -> doc.prepend(doc.format(i), newLine()));
		reference.getOwnedRelationRestrictions().forEach(i -> doc.prepend(doc.format(i), newLine()));
	}

	protected void _format(ConceptReference reference, IFormattableDocument doc) {
		reference.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(reference, oml.getConceptReferenceAccess().getRefKeyword_1()), oneSpace());
		doc.surround(keyword(reference, oml.getConceptReferenceAccess().getConceptKeyword_2()), oneSpace());
		formatCommas(reference, doc);
		formatBrackets(reference, doc);
		reference.getOwnedKeys().forEach(i -> doc.prepend(doc.format(i), newLine()));
		reference.getOwnedPropertyRestrictions().forEach(i -> doc.prepend(doc.format(i), newLine()));
		reference.getOwnedRelationRestrictions().forEach(i -> doc.prepend(doc.format(i), newLine()));
	}

	protected void _format(RelationEntityReference reference, IFormattableDocument doc) {
		reference.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(reference, oml.getRelationEntityReferenceAccess().getRefKeyword_1()), oneSpace());
		doc.surround(keyword(reference, oml.getRelationEntityReferenceAccess().getRelationKeyword_2()), oneSpace());
		doc.surround(keyword(reference, oml.getRelationEntityReferenceAccess().getEntityKeyword_3()), oneSpace());
		formatCommas(reference, doc);
		formatBrackets(reference, doc);
		reference.getOwnedKeys().forEach(i -> doc.prepend(doc.format(i), newLine()));
		reference.getOwnedPropertyRestrictions().forEach(i -> doc.prepend(doc.format(i), newLine()));
		reference.getOwnedRelationRestrictions().forEach(i -> doc.prepend(doc.format(i), newLine()));
	}

	protected void _format(StructureReference reference, IFormattableDocument doc) {
		reference.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(reference, oml.getStructureReferenceAccess().getRefKeyword_1()), oneSpace());
		doc.surround(keyword(reference, oml.getStructureReferenceAccess().getStructureKeyword_2()), oneSpace());
		formatCommas(reference, doc);
		formatBrackets(reference, doc);
		reference.getOwnedPropertyRestrictions().forEach(i -> doc.prepend(doc.format(i), newLine()));
	}

	protected void _format(AnnotationPropertyReference reference, IFormattableDocument doc) {
		reference.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(reference, oml.getAnnotationPropertyReferenceAccess().getRefKeyword_1()), oneSpace());
		doc.surround(keyword(reference, oml.getAnnotationPropertyReferenceAccess().getAnnotationKeyword_2()), oneSpace());
		doc.surround(keyword(reference, oml.getAnnotationPropertyReferenceAccess().getPropertyKeyword_3()), oneSpace());
		formatCommas(reference, doc);
	}

	protected void _format(ScalarPropertyReference reference, IFormattableDocument doc) {
		reference.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(reference, oml.getScalarPropertyReferenceAccess().getRefKeyword_1()), oneSpace());
		doc.surround(keyword(reference, oml.getScalarPropertyReferenceAccess().getScalarKeyword_2()), oneSpace());
		doc.surround(keyword(reference, oml.getScalarPropertyReferenceAccess().getPropertyKeyword_3()), oneSpace());
		formatCommas(reference, doc);
	}

	protected void _format(StructuredPropertyReference reference, IFormattableDocument doc) {
		reference.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(reference, oml.getStructuredPropertyReferenceAccess().getRefKeyword_1()), oneSpace());
		doc.surround(keyword(reference, oml.getStructuredPropertyReferenceAccess().getStructuredKeyword_2()), oneSpace());
		doc.surround(keyword(reference, oml.getStructuredPropertyReferenceAccess().getPropertyKeyword_3()), oneSpace());
		formatCommas(reference, doc);
	}

	protected void _format(FacetedScalarReference reference, IFormattableDocument doc) {
		reference.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(reference, oml.getFacetedScalarReferenceAccess().getRefKeyword_1()), oneSpace());
		doc.surround(keyword(reference, oml.getFacetedScalarReferenceAccess().getScalarKeyword_2()), oneSpace());
		formatCommas(reference, doc);
	}

	protected void _format(EnumeratedScalarReference reference, IFormattableDocument doc) {
		reference.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(reference, oml.getEnumeratedScalarReferenceAccess().getRefKeyword_1()), oneSpace());
		doc.surround(keyword(reference, oml.getEnumeratedScalarReferenceAccess().getEnumeratedKeyword_2()), oneSpace());
		doc.surround(keyword(reference, oml.getEnumeratedScalarReferenceAccess().getScalarKeyword_3()), oneSpace());
		formatCommas(reference, doc);
	}

	protected void _format(RelationReference reference, IFormattableDocument doc) {
		reference.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(reference, oml.getRelationReferenceAccess().getRefKeyword_1()), oneSpace());
		doc.surround(keyword(reference, oml.getRelationReferenceAccess().getRelationKeyword_2()), oneSpace());
	}

	protected void _format(RuleReference reference, IFormattableDocument doc) {
		reference.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(reference, oml.getRuleReferenceAccess().getRefKeyword_1()), oneSpace());
		doc.surround(keyword(reference, oml.getRuleReferenceAccess().getRuleKeyword_2()), oneSpace());
	}

	protected void _format(ConceptInstanceReference reference, IFormattableDocument doc) {
		reference.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(reference, oml.getConceptInstanceReferenceAccess().getRefKeyword_1()), oneSpace());
		doc.surround(keyword(reference, oml.getConceptInstanceReferenceAccess().getCiKeyword_2()), oneSpace());
		formatCommas(reference, doc);
		formatBrackets(reference, doc);
		reference.getOwnedPropertyValues().forEach(i -> doc.prepend(doc.format(i), newLine()));
		reference.getOwnedLinks().forEach(i -> doc.prepend(doc.format(i), newLine()));
	}

	protected void _format(RelationInstanceReference reference, IFormattableDocument doc) {
		reference.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(reference, oml.getRelationInstanceReferenceAccess().getRefKeyword_1()), oneSpace());
		doc.surround(keyword(reference, oml.getRelationInstanceReferenceAccess().getRiKeyword_2()), oneSpace());
		formatCommas(reference, doc);
		formatBrackets(reference, doc);
		reference.getOwnedPropertyValues().forEach(i -> doc.prepend(doc.format(i), newLine()));
		reference.getOwnedLinks().forEach(i -> doc.prepend(doc.format(i), newLine()));
	}

	protected void _format(VocabularyExtension extension, IFormattableDocument doc) {
		extension.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(extension, oml.getVocabularyExtensionAccess().getExtendsKeyword_1()), oneSpace());
		doc.surround(keyword(extension, oml.getVocabularyExtensionAccess().getAsKeyword_3_0()), oneSpace());
	}

	protected void _format(VocabularyUsage usage, IFormattableDocument doc) {
		usage.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(usage, oml.getVocabularyUsageAccess().getUsesKeyword_1()), oneSpace());
		doc.surround(keyword(usage, oml.getVocabularyUsageAccess().getAsKeyword_3_0()), oneSpace());
	}

	protected void _format(VocabularyBundleExtension extension, IFormattableDocument doc) {
		extension.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(extension, oml.getVocabularyBundleExtensionAccess().getExtendsKeyword_1()), oneSpace());
		doc.surround(keyword(extension, oml.getVocabularyBundleExtensionAccess().getAsKeyword_3_0()), oneSpace());
	}

	protected void _format(VocabularyBundleInclusion inclusion, IFormattableDocument doc) {
		inclusion.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(inclusion, oml.getVocabularyBundleInclusionAccess().getIncludesKeyword_1()), oneSpace());
		doc.surround(keyword(inclusion, oml.getVocabularyBundleInclusionAccess().getAsKeyword_3_0()), oneSpace());
	}

	protected void _format(DescriptionExtension extension, IFormattableDocument doc) {
		extension.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(extension, oml.getDescriptionExtensionAccess().getExtendsKeyword_1()), oneSpace());
		doc.surround(keyword(extension, oml.getDescriptionExtensionAccess().getAsKeyword_3_0()), oneSpace());
	}

	protected void _format(DescriptionUsage usage, IFormattableDocument doc) {
		usage.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(usage, oml.getDescriptionUsageAccess().getUsesKeyword_1()), oneSpace());
		doc.surround(keyword(usage, oml.getDescriptionUsageAccess().getAsKeyword_3_0()), oneSpace());
	}

	protected void _format(DescriptionBundleExtension extension, IFormattableDocument doc) {
		extension.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(extension, oml.getDescriptionBundleExtensionAccess().getExtendsKeyword_1()), oneSpace());
		doc.surround(keyword(extension, oml.getDescriptionBundleExtensionAccess().getAsKeyword_3_0()), oneSpace());
	}

	protected void _format(DescriptionBundleInclusion inclusion, IFormattableDocument doc) {
		inclusion.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(inclusion, oml.getDescriptionBundleInclusionAccess().getIncludesKeyword_1()), oneSpace());
		doc.surround(keyword(inclusion, oml.getDescriptionBundleInclusionAccess().getAsKeyword_3_0()), oneSpace());
	}

	protected void _format(DescriptionBundleUsage usage, IFormattableDocument doc) {
		usage.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		doc.append(keyword(usage, oml.getDescriptionBundleUsageAccess().getUsesKeyword_1()), oneSpace());
		doc.surround(keyword(usage, oml.getDescriptionBundleUsageAccess().getAsKeyword_3_0()), oneSpace());
	}

	protected void _format(ScalarPropertyRangeRestrictionAxiom axiom, IFormattableDocument doc) {
		doc.append(keyword(axiom, oml.getScalarPropertyRangeRestrictionAxiomAccess().getRestrictsKeyword_0()), oneSpace());
		doc.surround(keyword(axiom, oml.getScalarPropertyRangeRestrictionAxiomAccess().getScalarKeyword_2()), oneSpace());
		doc.surround(keyword(axiom, oml.getScalarPropertyRangeRestrictionAxiomAccess().getPropertyKeyword_3()), oneSpace());
		doc.surround(keyword(axiom, oml.getScalarPropertyRangeRestrictionAxiomAccess().getToKeyword_5()), oneSpace());
	}

	protected void _format(ScalarPropertyCardinalityRestrictionAxiom axiom, IFormattableDocument doc) {
		doc.append(keyword(axiom, oml.getScalarPropertyCardinalityRestrictionAxiomAccess().getRestrictsKeyword_0()), oneSpace());
		doc.surround(keyword(axiom, oml.getScalarPropertyCardinalityRestrictionAxiomAccess().getScalarKeyword_1()), oneSpace());
		doc.surround(keyword(axiom, oml.getScalarPropertyCardinalityRestrictionAxiomAccess().getPropertyKeyword_2()), oneSpace());
		doc.surround(keyword(axiom, oml.getScalarPropertyCardinalityRestrictionAxiomAccess().getToKeyword_4()), oneSpace());
		doc.surround(feature(axiom, OmlPackage.Literals.SCALAR_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__KIND), oneSpace());
		ifNotNull(axiom.getRange(), i -> doc.prepend(feature(i, OmlPackage.Literals.SCALAR_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE), oneSpace()));
	}

	protected void _format(ScalarPropertyValueRestrictionAxiom axiom, IFormattableDocument doc) {
		doc.append(keyword(axiom, oml.getScalarPropertyValueRestrictionAxiomAccess().getRestrictsKeyword_0()), oneSpace());
		doc.surround(keyword(axiom, oml.getScalarPropertyValueRestrictionAxiomAccess().getScalarKeyword_1()), oneSpace());
		doc.surround(keyword(axiom, oml.getScalarPropertyValueRestrictionAxiomAccess().getPropertyKeyword_2()), oneSpace());
		doc.surround(keyword(axiom, oml.getScalarPropertyValueRestrictionAxiomAccess().getToKeyword_4()), oneSpace());
	}

	protected void _format(StructuredPropertyRangeRestrictionAxiom axiom, IFormattableDocument doc) {
		doc.append(keyword(axiom, oml.getStructuredPropertyRangeRestrictionAxiomAccess().getRestrictsKeyword_0()), oneSpace());
		doc.surround(keyword(axiom, oml.getStructuredPropertyRangeRestrictionAxiomAccess().getStructuredKeyword_2()), oneSpace());
		doc.surround(keyword(axiom, oml.getStructuredPropertyRangeRestrictionAxiomAccess().getPropertyKeyword_3()), oneSpace());
		doc.surround(keyword(axiom, oml.getStructuredPropertyRangeRestrictionAxiomAccess().getToKeyword_5()), oneSpace());
	}

	protected void _format(StructuredPropertyCardinalityRestrictionAxiom axiom, IFormattableDocument doc) {
		doc.append(keyword(axiom, oml.getStructuredPropertyCardinalityRestrictionAxiomAccess().getRestrictsKeyword_0()), oneSpace());
		doc.surround(keyword(axiom, oml.getStructuredPropertyCardinalityRestrictionAxiomAccess().getStructuredKeyword_1()), oneSpace());
		doc.surround(keyword(axiom, oml.getStructuredPropertyCardinalityRestrictionAxiomAccess().getPropertyKeyword_2()), oneSpace());
		doc.surround(keyword(axiom, oml.getStructuredPropertyCardinalityRestrictionAxiomAccess().getToKeyword_4()), oneSpace());
		doc.surround(feature(axiom, OmlPackage.Literals.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__KIND), oneSpace());
		ifNotNull(axiom.getRange(), i -> doc.prepend(feature(i, OmlPackage.Literals.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE), oneSpace()));
	}

	protected void _format(StructuredPropertyValueRestrictionAxiom axiom, IFormattableDocument doc) {
		doc.append(keyword(axiom, oml.getStructuredPropertyValueRestrictionAxiomAccess().getRestrictsKeyword_0()), oneSpace());
		doc.surround(keyword(axiom, oml.getStructuredPropertyValueRestrictionAxiomAccess().getStructuredKeyword_1()), oneSpace());
		doc.surround(keyword(axiom, oml.getStructuredPropertyValueRestrictionAxiomAccess().getPropertyKeyword_2()), oneSpace());
		doc.surround(keyword(axiom, oml.getStructuredPropertyValueRestrictionAxiomAccess().getToKeyword_4()), oneSpace());
	}

	protected void _format(RelationRangeRestrictionAxiom axiom, IFormattableDocument doc) {
		doc.append(keyword(axiom, oml.getRelationRangeRestrictionAxiomAccess().getRestrictsKeyword_0()), oneSpace());
		doc.surround(keyword(axiom, oml.getRelationRangeRestrictionAxiomAccess().getRelationKeyword_2()), oneSpace());
		doc.surround(keyword(axiom, oml.getRelationRangeRestrictionAxiomAccess().getToKeyword_4()), oneSpace());
	}

	protected void _format(RelationCardinalityRestrictionAxiom axiom, IFormattableDocument doc) {
		doc.append(keyword(axiom, oml.getRelationCardinalityRestrictionAxiomAccess().getRestrictsKeyword_0()), oneSpace());
		doc.surround(keyword(axiom, oml.getRelationCardinalityRestrictionAxiomAccess().getRelationKeyword_1()), oneSpace());
		doc.surround(keyword(axiom, oml.getRelationCardinalityRestrictionAxiomAccess().getToKeyword_3()), oneSpace());
		doc.surround(feature(axiom, OmlPackage.Literals.RELATION_CARDINALITY_RESTRICTION_AXIOM__KIND), oneSpace());
		ifNotNull(axiom.getRange(), i -> doc.prepend(feature(i, OmlPackage.Literals.RELATION_CARDINALITY_RESTRICTION_AXIOM__RANGE), oneSpace()));
	}

	protected void _format(RelationTargetRestrictionAxiom axiom, IFormattableDocument doc) {
		doc.append(keyword(axiom, oml.getRelationTargetRestrictionAxiomAccess().getRestrictsKeyword_0()), oneSpace());
		doc.surround(keyword(axiom, oml.getRelationTargetRestrictionAxiomAccess().getRelationKeyword_1()), oneSpace());
		doc.surround(keyword(axiom, oml.getRelationTargetRestrictionAxiomAccess().getToKeyword_3()), oneSpace());
		doc.surround(feature(axiom, OmlPackage.Literals.RELATION_TARGET_RESTRICTION_AXIOM__TARGET), oneSpace());
	}

	protected void _format(KeyAxiom axiom, IFormattableDocument doc) {
		doc.append(keyword(axiom, oml.getKeyAxiomAccess().getKeyKeyword_0()), oneSpace());
		formatCommas(axiom, doc);
	}

	protected void _format(ScalarPropertyValueAssertion assertion, IFormattableDocument doc) {
		doc.append(feature(assertion, OmlPackage.Literals.SCALAR_PROPERTY_VALUE_ASSERTION__PROPERTY), oneSpace());
		ifNotNull(assertion.getValue(), i -> doc.prepend(doc.format(i), oneSpace()));
	}

	protected void _format(StructuredPropertyValueAssertion assertion, IFormattableDocument doc) {
		doc.append(feature(assertion, OmlPackage.Literals.STRUCTURED_PROPERTY_VALUE_ASSERTION__PROPERTY), oneSpace());
	}

	protected void _format(LinkAssertion assertion, IFormattableDocument doc) {
		doc.append(feature(assertion, OmlPackage.Literals.LINK_ASSERTION__RELATION), oneSpace());
	}

	protected void _format(TypePredicate predicate, IFormattableDocument doc) {
		doc.surround(keyword(predicate, oml.getTypePredicateAccess().getLeftParenthesisKeyword_1()), noSpace());
		doc.prepend(keyword(predicate, oml.getTypePredicateAccess().getRightParenthesisKeyword_3()), noSpace());
	}

	protected void _format(RelationEntityPredicate predicate, IFormattableDocument doc) {
		doc.surround(keyword(predicate, oml.getRelationEntityPredicateAccess().getLeftParenthesisKeyword_1()), noSpace());
		formatCommas(predicate, doc);
		doc.prepend(keyword(predicate, oml.getRelationEntityPredicateAccess().getRightParenthesisKeyword_7()), noSpace());
    }

	protected void _format(FeaturePredicate predicate, IFormattableDocument doc) {
		doc.surround(keyword(predicate, oml.getFeaturePredicateAccess().getLeftParenthesisKeyword_1()), noSpace());
		formatCommas(predicate, doc);
		doc.prepend(keyword(predicate, oml.getFeaturePredicateAccess().getRightParenthesisKeyword_5()), noSpace());
	}

	protected void _format(SameAsPredicate predicate, IFormattableDocument doc) {
		doc.surround(keyword(predicate, oml.getSameAsPredicateAccess().getLeftParenthesisKeyword_1()), noSpace());
		formatCommas(predicate, doc);
		doc.prepend(keyword(predicate, oml.getSameAsPredicateAccess().getRightParenthesisKeyword_5()), noSpace());
	}

	protected void _format(DifferentFromPredicate predicate, IFormattableDocument doc) {
		doc.surround(keyword(predicate, oml.getDifferentFromPredicateAccess().getLeftParenthesisKeyword_1()), noSpace());
		formatCommas(predicate, doc);
		doc.prepend(keyword(predicate, oml.getDifferentFromPredicateAccess().getRightParenthesisKeyword_5()), noSpace());
	}

	protected void _format(QuotedLiteral literal, IFormattableDocument doc) {
		doc.surround(keyword(literal, oml.getQuotedLiteralAccess().getCircumflexAccentCircumflexAccentKeyword_1_0_0()), noSpace());
		doc.surround(keyword(literal, oml.getQuotedLiteralAccess().getDollarSignKeyword_1_1_0()), noSpace());
	}

	/************** UTILITIES **************/

	private List<Method> formatMethods;
	
	@Override public void format(Object object, IFormattableDocument doc) {
		if (formatMethods == null) {
			formatMethods = new ArrayList<>();
	        for (Method method : this.getClass().getDeclaredMethods()) {
	            try {
	            	if (method.getName().equals("_format")) {
	            		formatMethods.add(method);
	            	}
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
		}
		if (object instanceof Element) {
	        for (Method method : formatMethods) {
	            try {
	                final Class<?> paramType = method.getParameterTypes()[0];
	                if (paramType.isAssignableFrom(object.getClass())) {
	                	method.invoke(this, object, doc);
	                	return;
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
		}
        super.format(object, doc);
	}	
	
	protected void formatBrackets(EObject e, IFormattableDocument doc) {
		final var open = keyword(e, "[");
		doc.prepend(open, oneSpace());
		final var close = keyword(e, "]");
		doc.prepend(close, newLine());
		doc.interior(open, close, indent());
	}

	protected void formatBraces(EObject e, IFormattableDocument doc) {
		final var open = keyword(e, "{");
		doc.prepend(open, oneSpace());
		final var close = keyword(e, "}");
		doc.prepend(close, newLine());
		doc.interior(open, close, indent());
	}

	protected void formatCommas(EObject e, IFormattableDocument doc) {
		keywords(e, ",").forEach(i -> doc.append(doc.prepend(i, noSpace()), oneSpace()));
	}

	protected ISemanticRegion feature(EObject obj, EStructuralFeature feature) {
		return textRegionExtensions.regionFor(obj).feature(feature);
	}

	protected ISemanticRegion keyword(EObject obj, Keyword keyword) {
		return textRegionExtensions.regionFor(obj).keyword(keyword);
	}

	protected ISemanticRegion keyword(EObject obj, String keyword) {
		return textRegionExtensions.regionFor(obj).keyword(keyword);
	}

	protected List<ISemanticRegion> keywords(EObject obj, String keyword) {
		return textRegionExtensions.regionFor(obj).keywords(keyword);
	}

	@SafeVarargs
	private Procedure1<IHiddenRegionFormatter> compose(Procedure1<IHiddenRegionFormatter>... lambdas) {
		return i -> {
			for (var lambda : lambdas) {
				lambda.apply(i);
			}
		};
	}

	protected Procedure1<IHiddenRegionFormatter> newLine() {
		return i -> i.newLine();
	}

	protected Procedure1<IHiddenRegionFormatter> newLines(int n) {
		return i -> i.setNewLines(n);
	}

	protected Procedure1<IHiddenRegionFormatter> setNewLines(int n1, int n2, int n3) {
		return i -> i.setNewLines(n1, n2, n3);
	}

	protected Procedure1<IHiddenRegionFormatter> oneSpace() {
		return i -> i.oneSpace();
	}

	protected Procedure1<IHiddenRegionFormatter> indent() {
		return i -> i.indent();
	}

	protected Procedure1<IHiddenRegionFormatter> noSpace() {
		return i -> i.noSpace();
	}

	protected <T> void ifNotNull(T obj, Procedure1<T> proc) {
		if (obj != null) {
			proc.apply(obj);
		}
	}

	protected <T> void ifNotEmpty(List<T> list, Procedure1<List<T>> proc) {
		if (!list.isEmpty()) {
			proc.apply(list);
		}
	}
}
