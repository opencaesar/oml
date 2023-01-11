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
import java.util.List;

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
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.inject.Inject;

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.DifferentFromPredicate;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.EnumeratedScalar;
import io.opencaesar.oml.FacetedScalar;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.PropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.PropertyPredicate;
import io.opencaesar.oml.PropertyRangeRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.PropertyValueRestrictionAxiom;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.ReverseRelation;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.SameAsPredicate;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.TypePredicate;
import io.opencaesar.oml.UnreifiedRelation;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyBundle;
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
		if (aspect.getName() != null) {
			doc.append(keyword(aspect, oml.getAspectAccess().getAspectKeyword_1_0_0()), oneSpace());
		} else if (aspect.getRef() != null) {
			doc.append(keyword(aspect, oml.getAspectAccess().getRefKeyword_1_1_0()), oneSpace());
			doc.append(keyword(aspect, oml.getAspectAccess().getAspectKeyword_1_1_1()), oneSpace());
		}
		doc.surround(keyword(aspect, oml.getAspectAccess().getColonGreaterThanSignKeyword_2_0()), oneSpace());
		formatCommas(aspect, doc);
		formatBrackets(aspect, doc);
		aspect.getOwnedKeys().forEach(i -> doc.prepend(doc.format(i), newLine()));
		aspect.getOwnedPropertyRestrictions().forEach(i -> doc.prepend(doc.format(i), newLine()));
	}

	protected void _format(Concept concept, IFormattableDocument doc) {
		concept.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		if (concept.getName() != null) {	
			doc.append(keyword(concept, oml.getConceptAccess().getConceptKeyword_1_0_0()), oneSpace());
		} else if (concept.getRef() != null) {
			doc.append(keyword(concept, oml.getConceptAccess().getRefKeyword_1_1_0()), oneSpace());
			doc.append(keyword(concept, oml.getConceptAccess().getConceptKeyword_1_1_1()), oneSpace());
		}
		doc.surround(keyword(concept, oml.getConceptAccess().getColonGreaterThanSignKeyword_2_0()), oneSpace());
		formatCommas(concept, doc);
		formatBrackets(concept, doc);
		concept.getOwnedKeys().forEach(i -> doc.prepend(doc.format(i), newLine()));
		concept.getOwnedPropertyRestrictions().forEach(i -> doc.prepend(doc.format(i), newLine()));
		ifNotEmpty(concept.getEnumeratedInstances(), i -> {
			doc.prepend(keyword(concept, oml.getConceptAccess().getEnumeratesKeyword_3_2_0()), newLine());
			i.forEach(j -> doc.append(doc.prepend(doc.format(j), oneSpace()), noSpace()));
		});
	}

	protected void _format(RelationEntity entity, IFormattableDocument doc) {
		entity.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		if (entity.getName() != null) {
			doc.append(keyword(entity, oml.getRelationEntityAccess().getRelationKeyword_1_0_0()), oneSpace());
			doc.append(keyword(entity, oml.getRelationEntityAccess().getEntityKeyword_1_0_1()), oneSpace());
		} else if (entity.getRef() != null) {
			doc.append(keyword(entity, oml.getRelationEntityAccess().getRefKeyword_1_1_0()), oneSpace());
			doc.append(keyword(entity, oml.getRelationEntityAccess().getRelationKeyword_1_1_1()), oneSpace());
			doc.append(keyword(entity, oml.getRelationEntityAccess().getEntityKeyword_1_1_2()), oneSpace());
		}
		doc.surround(keyword(entity, oml.getRelationEntityAccess().getColonGreaterThanSignKeyword_2_0()), oneSpace());
		formatCommas(entity, doc);
		formatBrackets(entity, doc);
		doc.append(doc.prepend(keyword(entity, oml.getRelationEntityAccess().getFromKeyword_3_1_0()), newLine()), oneSpace());
		doc.append(doc.prepend(keyword(entity, oml.getRelationEntityAccess().getToKeyword_3_2_0()), newLine()), oneSpace());
		ifNotNull(entity.getForwardRelation(), i -> doc.prepend(doc.format(i), newLine()));
		ifNotNull(entity.getReverseRelation(), i -> doc.prepend(doc.format(i), newLine()));
		doc.prepend(keyword(entity, oml.getRelationEntityAccess().getFunctionalFunctionalKeyword_3_4_0_0()), newLine());
		doc.prepend(keyword(entity, oml.getRelationEntityAccess().getInverseFunctionalInverseKeyword_3_4_1_0_0()), newLine());
		doc.prepend(keyword(entity, oml.getRelationEntityAccess().getSymmetricSymmetricKeyword_3_4_2_0()), newLine());
		doc.prepend(keyword(entity, oml.getRelationEntityAccess().getAsymmetricAsymmetricKeyword_3_4_3_0()), newLine());
		doc.prepend(keyword(entity, oml.getRelationEntityAccess().getReflexiveReflexiveKeyword_3_4_4_0()), newLine());
		doc.prepend(keyword(entity, oml.getRelationEntityAccess().getIrreflexiveIrreflexiveKeyword_3_4_5_0()), newLine());
		doc.prepend(keyword(entity, oml.getRelationEntityAccess().getTransitiveTransitiveKeyword_3_4_6_0()), newLine());
		entity.getOwnedKeys().forEach(i -> doc.prepend(doc.format(i), newLine()));
		entity.getOwnedPropertyRestrictions().forEach(i -> doc.prepend(doc.format(i), newLine()));
	}

	protected void _format(Structure structure, IFormattableDocument doc) {
		structure.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		if (structure.getName() != null) {
			doc.append(keyword(structure, oml.getStructureAccess().getStructureKeyword_1_0_0()), oneSpace());
		} else if (structure.getRef() != null) {
			doc.append(keyword(structure, oml.getStructureAccess().getRefKeyword_1_1_0()), oneSpace());
			doc.append(keyword(structure, oml.getStructureAccess().getStructureKeyword_1_1_1()), oneSpace());
		}
		doc.surround(keyword(structure, oml.getStructureAccess().getColonGreaterThanSignKeyword_2_0()), oneSpace());
		formatCommas(structure, doc);
		formatBrackets(structure, doc);
		structure.getOwnedPropertyRestrictions().forEach(i -> doc.prepend(doc.format(i), newLine()));
	}

	protected void _format(AnnotationProperty property, IFormattableDocument doc) {
		property.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		if (property.getName() != null) {
			doc.append(keyword(property, oml.getAnnotationPropertyAccess().getAnnotationKeyword_1_0_0()), oneSpace());
			doc.append(keyword(property, oml.getAnnotationPropertyAccess().getPropertyKeyword_1_0_1()), oneSpace());
		} else if (property.getRef() != null) {
			doc.append(keyword(property, oml.getAnnotationPropertyAccess().getRefKeyword_1_1_0()), oneSpace());
			doc.append(keyword(property, oml.getAnnotationPropertyAccess().getAnnotationKeyword_1_1_1()), oneSpace());
			doc.append(keyword(property, oml.getAnnotationPropertyAccess().getPropertyKeyword_1_1_2()), oneSpace());
		}
		doc.surround(keyword(property, oml.getAnnotationPropertyAccess().getColonGreaterThanSignKeyword_2_0()), oneSpace());
		formatCommas(property, doc);
	}

	protected void _format(ScalarProperty property, IFormattableDocument doc) {
		property.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		if (property.getName() != null) {
			doc.append(keyword(property, oml.getScalarPropertyAccess().getScalarKeyword_1_0_0()), oneSpace());
			doc.append(keyword(property, oml.getScalarPropertyAccess().getPropertyKeyword_1_0_1()), oneSpace());
		} else if (property.getRef() != null) {
			doc.append(keyword(property, oml.getScalarPropertyAccess().getRefKeyword_1_1_0()), oneSpace());
			doc.append(keyword(property, oml.getScalarPropertyAccess().getScalarKeyword_1_1_1()), oneSpace());
			doc.append(keyword(property, oml.getScalarPropertyAccess().getPropertyKeyword_1_1_2()), oneSpace());
		}
		doc.surround(keyword(property, oml.getScalarPropertyAccess().getColonGreaterThanSignKeyword_2_0()), oneSpace());
		formatCommas(property, doc);
		formatBrackets(property, doc);
		doc.prepend(keyword(property, oml.getScalarPropertyAccess().getDomainKeyword_6()), newLine());
		doc.prepend(keyword(property, oml.getScalarPropertyAccess().getRangeKeyword_8()), newLine());
		doc.prepend(keyword(property, oml.getScalarPropertyAccess().getFunctionalFunctionalKeyword_10_0()), newLine());
	}

	protected void _format(StructuredProperty property, IFormattableDocument doc) {
		property.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		if (property.getName() != null) {
			doc.append(keyword(property, oml.getStructuredPropertyAccess().getStructuredKeyword_1_0_0()), oneSpace());
			doc.append(keyword(property, oml.getStructuredPropertyAccess().getPropertyKeyword_1_0_1()), oneSpace());
		} else if (property.getRef() != null) {
			doc.append(keyword(property, oml.getStructuredPropertyAccess().getRefKeyword_1_1_0()), oneSpace());
			doc.append(keyword(property, oml.getStructuredPropertyAccess().getStructuredKeyword_1_1_1()), oneSpace());
			doc.append(keyword(property, oml.getStructuredPropertyAccess().getPropertyKeyword_1_1_2()), oneSpace());
		}
		doc.surround(keyword(property, oml.getStructuredPropertyAccess().getColonGreaterThanSignKeyword_2_0()), oneSpace());
		formatCommas(property, doc);
		formatBrackets(property, doc);
		doc.prepend(keyword(property, oml.getStructuredPropertyAccess().getDomainKeyword_6()), newLine());
		doc.prepend(keyword(property, oml.getStructuredPropertyAccess().getRangeKeyword_8()), newLine());
		doc.prepend(keyword(property, oml.getStructuredPropertyAccess().getFunctionalFunctionalKeyword_10_0()), newLine());
	}

	protected void _format(FacetedScalar scalar, IFormattableDocument doc) {
		scalar.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		if (scalar.getName() != null) {
			doc.append(keyword(scalar, oml.getFacetedScalarAccess().getScalarKeyword_1_0_0()), oneSpace());
		} else if (scalar.getRef() != null) {
			doc.append(keyword(scalar, oml.getFacetedScalarAccess().getRefKeyword_1_1_0()), oneSpace());
			doc.append(keyword(scalar, oml.getFacetedScalarAccess().getScalarKeyword_1_1_1()), oneSpace());
		}
		doc.surround(keyword(scalar, oml.getFacetedScalarAccess().getColonGreaterThanSignKeyword_2_0()), oneSpace());
		formatCommas(scalar, doc);
		formatBrackets(scalar, doc);
		doc.prepend(keyword(scalar, oml.getFacetedScalarAccess().getLengthKeyword_3_1_0_0()), newLine());
		doc.prepend(keyword(scalar, oml.getFacetedScalarAccess().getMinLengthKeyword_3_1_1_0()), newLine());
		doc.prepend(keyword(scalar, oml.getFacetedScalarAccess().getMaxLengthKeyword_3_1_2_0()), newLine());
		doc.prepend(keyword(scalar, oml.getFacetedScalarAccess().getPatternKeyword_3_1_3_0()), newLine());
		doc.prepend(keyword(scalar, oml.getFacetedScalarAccess().getLanguageKeyword_3_1_4_0()), newLine());
		doc.prepend(keyword(scalar, oml.getFacetedScalarAccess().getMinInclusiveKeyword_3_1_5_0()), newLine());
		ifNotNull(scalar.getMinInclusive(), i -> doc.prepend(doc.format(i), oneSpace()));
		doc.prepend(keyword(scalar, oml.getFacetedScalarAccess().getMaxInclusiveKeyword_3_1_7_0()), newLine());
		ifNotNull(scalar.getMaxInclusive(), i -> doc.prepend(doc.format(i), oneSpace()));
		doc.prepend(keyword(scalar, oml.getFacetedScalarAccess().getMinExclusiveKeyword_3_1_6_0()), newLine());
		ifNotNull(scalar.getMinExclusive(), i -> doc.prepend(doc.format(i), oneSpace()));
		doc.prepend(keyword(scalar, oml.getFacetedScalarAccess().getMaxExclusiveKeyword_3_1_8_0()), newLine());
		ifNotNull(scalar.getMaxExclusive(), i -> doc.prepend(doc.format(i), oneSpace()));
	}

	protected void _format(EnumeratedScalar scalar, IFormattableDocument doc) {
		scalar.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		if (scalar.getName() != null) {
			doc.append(keyword(scalar, oml.getEnumeratedScalarAccess().getEnumeratedKeyword_1_0_0()), oneSpace());
			doc.append(keyword(scalar, oml.getEnumeratedScalarAccess().getScalarKeyword_1_0_1()), oneSpace());
		} else if (scalar.getRef() != null) {
			doc.append(keyword(scalar, oml.getEnumeratedScalarAccess().getRefKeyword_1_1_0()), oneSpace());
			doc.append(keyword(scalar, oml.getEnumeratedScalarAccess().getEnumeratedKeyword_1_1_1()), oneSpace());
			doc.append(keyword(scalar, oml.getEnumeratedScalarAccess().getScalarKeyword_1_1_2()), oneSpace());
		}
		doc.surround(keyword(scalar, oml.getEnumeratedScalarAccess().getColonGreaterThanSignKeyword_2_0()), oneSpace());
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

	protected void _format(UnreifiedRelation relation, IFormattableDocument doc) {
		relation.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		if (relation.getName() != null) {
			doc.append(keyword(relation, oml.getUnreifiedRelationAccess().getRelationKeyword_1_0_0()), oneSpace());
		} else if (relation.getRef() != null) {
			doc.append(keyword(relation, oml.getUnreifiedRelationAccess().getRefKeyword_1_1_0()), oneSpace());
			doc.append(keyword(relation, oml.getUnreifiedRelationAccess().getRelationKeyword_1_1_1()), oneSpace());
		}
		doc.surround(keyword(relation, oml.getUnreifiedRelationAccess().getColonGreaterThanSignKeyword_2_0()), oneSpace());
		formatCommas(relation, doc);
		formatBrackets(relation, doc);
		doc.append(doc.prepend(keyword(relation, oml.getUnreifiedRelationAccess().getFromKeyword_3_1_0()), newLine()), oneSpace());
		doc.append(doc.prepend(keyword(relation, oml.getUnreifiedRelationAccess().getToKeyword_3_2_0()), newLine()), oneSpace());
		ifNotNull(relation.getReverseRelation(), i -> doc.prepend(doc.format(i), newLine()));
		doc.prepend(keyword(relation, oml.getUnreifiedRelationAccess().getFunctionalFunctionalKeyword_3_4_0_0()), newLine());
		doc.prepend(keyword(relation, oml.getUnreifiedRelationAccess().getInverseFunctionalInverseKeyword_3_4_1_0_0()), newLine());
		doc.prepend(keyword(relation, oml.getUnreifiedRelationAccess().getSymmetricSymmetricKeyword_3_4_2_0()), newLine());
		doc.prepend(keyword(relation, oml.getUnreifiedRelationAccess().getAsymmetricAsymmetricKeyword_3_4_3_0()), newLine());
		doc.prepend(keyword(relation, oml.getUnreifiedRelationAccess().getReflexiveReflexiveKeyword_3_4_4_0()), newLine());
		doc.prepend(keyword(relation, oml.getUnreifiedRelationAccess().getIrreflexiveIrreflexiveKeyword_3_4_5_0()), newLine());
		doc.prepend(keyword(relation, oml.getUnreifiedRelationAccess().getTransitiveTransitiveKeyword_3_4_6_0()), newLine());
	}

	protected void _format(Rule rule, IFormattableDocument doc) {
		rule.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		if (rule.getName() != null) {
			doc.append(keyword(rule, oml.getRuleAccess().getRuleKeyword_1_0_0()), oneSpace());
		} else if (rule.getRef() != null) {
			doc.append(keyword(rule, oml.getRuleAccess().getRefKeyword_1_1_0()), oneSpace());
			doc.append(keyword(rule, oml.getRuleAccess().getRuleKeyword_1_1_1()), oneSpace());
		}
		formatBrackets(rule, doc);
		ifNotEmpty(rule.getAntecedent(), i -> doc.prepend(doc.format(i.get(0)), newLine()));
		keywords(rule, "^").forEach(i -> doc.surround(i, oneSpace()));
		rule.getAntecedent().forEach(i -> doc.format(i));
		doc.surround(keyword(rule, oml.getRuleAccess().getHyphenMinusGreaterThanSignKeyword_2_1_2()), oneSpace());
		rule.getConsequent().forEach(i -> doc.format(i));
	}

	protected void _format(ConceptInstance instance, IFormattableDocument doc) {
		instance.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		if (instance.getName() != null) {
			doc.append(keyword(instance, oml.getConceptInstanceAccess().getCiKeyword_1_0_0()), oneSpace());
		} else if (instance.getRef() != null) {
			doc.append(keyword(instance, oml.getConceptInstanceAccess().getRefKeyword_1_1_0()), oneSpace());
			doc.append(keyword(instance, oml.getConceptInstanceAccess().getCiKeyword_1_1_1()), oneSpace());
		}
		doc.surround(keyword(instance, oml.getConceptInstanceAccess().getColonKeyword_2_0()), oneSpace());
		formatCommas(instance, doc);
		formatBrackets(instance, doc);
		instance.getOwnedPropertyValues().forEach(i -> doc.prepend(doc.format(i), newLine()));
	}

	protected void _format(RelationInstance instance, IFormattableDocument doc) {
		instance.getOwnedAnnotations().forEach(i -> doc.append(doc.format(i), newLine()));
		if (instance.getName() != null) {
			doc.append(keyword(instance, oml.getRelationInstanceAccess().getRiKeyword_1_0_0()), oneSpace());
		} else if (instance.getRef() != null) {
			doc.append(keyword(instance, oml.getRelationInstanceAccess().getRefKeyword_1_1_0()), oneSpace());
			doc.append(keyword(instance, oml.getRelationInstanceAccess().getRiKeyword_1_1_1()), oneSpace());
		}
		doc.surround(keyword(instance, oml.getRelationInstanceAccess().getColonKeyword_2_0()), oneSpace());
		formatCommas(instance, doc);
		formatBrackets(instance, doc);
		doc.append(doc.prepend(keyword(instance, oml.getRelationInstanceAccess().getFromKeyword_3_1_0()), newLine()), oneSpace());
		instance.getSources().forEach(i -> doc.prepend(doc.format(i), oneSpace()));
		doc.append(doc.prepend(keyword(instance, oml.getRelationInstanceAccess().getToKeyword_3_2_0()), newLine()), oneSpace());
		instance.getTargets().forEach(i -> doc.prepend(doc.format(i), oneSpace()));
		instance.getOwnedPropertyValues().forEach(i -> doc.prepend(doc.format(i), newLine()));
	}

	protected void _format(StructureInstance instance, IFormattableDocument doc) {
		formatBrackets(instance, doc);
		instance.getOwnedPropertyValues().forEach(i -> doc.prepend(doc.format(i), newLine()));
	}

	protected void _format(Import import_, IFormattableDocument doc) {
		doc.surround(feature(import_, OmlPackage.Literals.IMPORT__KIND), oneSpace());
		doc.surround(keyword(import_, oml.getExtensionAccess().getAsKeyword_2_0()), oneSpace());
	}

	protected void _format(PropertyRangeRestrictionAxiom axiom, IFormattableDocument doc) {
		if (axiom.getProperty() instanceof ScalarProperty) {
			doc.append(keyword(axiom, oml.getScalarPropertyRangeRestrictionAxiomAccess().getRestrictsKeyword_0()), oneSpace());
			doc.surround(keyword(axiom, oml.getScalarPropertyRangeRestrictionAxiomAccess().getScalarKeyword_2()), oneSpace());
			doc.surround(keyword(axiom, oml.getScalarPropertyRangeRestrictionAxiomAccess().getPropertyKeyword_3()), oneSpace());
			doc.surround(keyword(axiom, oml.getScalarPropertyRangeRestrictionAxiomAccess().getToKeyword_5()), oneSpace());
		} else if (axiom.getProperty() instanceof StructuredProperty) {
			doc.append(keyword(axiom, oml.getStructuredPropertyRangeRestrictionAxiomAccess().getRestrictsKeyword_0()), oneSpace());
			doc.surround(keyword(axiom, oml.getStructuredPropertyRangeRestrictionAxiomAccess().getStructuredKeyword_2()), oneSpace());
			doc.surround(keyword(axiom, oml.getStructuredPropertyRangeRestrictionAxiomAccess().getPropertyKeyword_3()), oneSpace());
			doc.surround(keyword(axiom, oml.getStructuredPropertyRangeRestrictionAxiomAccess().getToKeyword_5()), oneSpace());
		} else if (axiom.getProperty() instanceof Relation) {
			doc.append(keyword(axiom, oml.getRelationRangeRestrictionAxiomAccess().getRestrictsKeyword_0()), oneSpace());
			doc.surround(keyword(axiom, oml.getRelationRangeRestrictionAxiomAccess().getRelationKeyword_2()), oneSpace());
			doc.surround(keyword(axiom, oml.getRelationRangeRestrictionAxiomAccess().getToKeyword_4()), oneSpace());
		}
	}

	protected void _format(PropertyCardinalityRestrictionAxiom axiom, IFormattableDocument doc) {
		if (axiom.getProperty() instanceof ScalarProperty) {
			doc.append(keyword(axiom, oml.getScalarPropertyCardinalityRestrictionAxiomAccess().getRestrictsKeyword_0()), oneSpace());
			doc.surround(keyword(axiom, oml.getScalarPropertyCardinalityRestrictionAxiomAccess().getScalarKeyword_1()), oneSpace());
			doc.surround(keyword(axiom, oml.getScalarPropertyCardinalityRestrictionAxiomAccess().getPropertyKeyword_2()), oneSpace());
			doc.surround(keyword(axiom, oml.getScalarPropertyCardinalityRestrictionAxiomAccess().getToKeyword_4()), oneSpace());
		} else if (axiom.getProperty() instanceof StructuredProperty) {
			doc.append(keyword(axiom, oml.getStructuredPropertyCardinalityRestrictionAxiomAccess().getRestrictsKeyword_0()), oneSpace());
			doc.surround(keyword(axiom, oml.getStructuredPropertyCardinalityRestrictionAxiomAccess().getStructuredKeyword_1()), oneSpace());
			doc.surround(keyword(axiom, oml.getStructuredPropertyCardinalityRestrictionAxiomAccess().getPropertyKeyword_2()), oneSpace());
			doc.surround(keyword(axiom, oml.getStructuredPropertyCardinalityRestrictionAxiomAccess().getToKeyword_4()), oneSpace());
		} else if (axiom.getProperty() instanceof Relation) {
			doc.append(keyword(axiom, oml.getRelationCardinalityRestrictionAxiomAccess().getRestrictsKeyword_0()), oneSpace());
			doc.surround(keyword(axiom, oml.getRelationCardinalityRestrictionAxiomAccess().getRelationKeyword_1()), oneSpace());
			doc.surround(keyword(axiom, oml.getRelationCardinalityRestrictionAxiomAccess().getToKeyword_3()), oneSpace());
		}
		doc.surround(feature(axiom, OmlPackage.Literals.PROPERTY_CARDINALITY_RESTRICTION_AXIOM__KIND), oneSpace());
		ifNotNull(axiom.getRange(), i -> doc.prepend(feature(i, OmlPackage.Literals.PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE), oneSpace()));
	}

	protected void _format(PropertyValueRestrictionAxiom axiom, IFormattableDocument doc) {
		if (axiom.getProperty() instanceof ScalarProperty) {
			doc.append(keyword(axiom, oml.getScalarPropertyValueRestrictionAxiomAccess().getRestrictsKeyword_0()), oneSpace());
			doc.surround(keyword(axiom, oml.getScalarPropertyValueRestrictionAxiomAccess().getScalarKeyword_1()), oneSpace());
			doc.surround(keyword(axiom, oml.getScalarPropertyValueRestrictionAxiomAccess().getPropertyKeyword_2()), oneSpace());
			doc.surround(keyword(axiom, oml.getScalarPropertyValueRestrictionAxiomAccess().getToKeyword_4()), oneSpace());
		} else if (axiom.getProperty() instanceof StructuredProperty) {
			doc.append(keyword(axiom, oml.getStructuredPropertyValueRestrictionAxiomAccess().getRestrictsKeyword_0()), oneSpace());
			doc.surround(keyword(axiom, oml.getStructuredPropertyValueRestrictionAxiomAccess().getStructuredKeyword_1()), oneSpace());
			doc.surround(keyword(axiom, oml.getStructuredPropertyValueRestrictionAxiomAccess().getPropertyKeyword_2()), oneSpace());
			doc.surround(keyword(axiom, oml.getStructuredPropertyValueRestrictionAxiomAccess().getToKeyword_4()), oneSpace());
		} else if (axiom.getProperty() instanceof Relation) {
			doc.append(keyword(axiom, oml.getRelationValueRestrictionAxiomAccess().getRestrictsKeyword_0()), oneSpace());
			doc.surround(keyword(axiom, oml.getRelationValueRestrictionAxiomAccess().getRelationKeyword_1()), oneSpace());
			doc.surround(keyword(axiom, oml.getRelationValueRestrictionAxiomAccess().getToKeyword_3()), oneSpace());
		}
	}

	protected void _format(KeyAxiom axiom, IFormattableDocument doc) {
		doc.append(keyword(axiom, oml.getKeyAxiomAccess().getKeyKeyword_0()), oneSpace());
		formatCommas(axiom, doc);
	}

	protected void _format(PropertyValueAssertion assertion, IFormattableDocument doc) {
		doc.append(feature(assertion, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY), oneSpace());
		ifNotNull(assertion.getValue(), i -> doc.prepend(doc.format(i), oneSpace()));
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

	protected void _format(PropertyPredicate predicate, IFormattableDocument doc) {
		doc.surround(keyword(predicate, oml.getPropertyPredicateAccess().getLeftParenthesisKeyword_1()), noSpace());
		formatCommas(predicate, doc);
		doc.prepend(keyword(predicate, oml.getPropertyPredicateAccess().getRightParenthesisKeyword_5()), noSpace());
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
