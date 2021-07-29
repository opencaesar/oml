/**
 * 
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
 * 
 */
package io.opencaesar.oml.dsl.formatting2

import com.google.inject.Inject
import io.opencaesar.oml.Annotation
import io.opencaesar.oml.AnnotationProperty
import io.opencaesar.oml.AnnotationPropertyReference
import io.opencaesar.oml.Aspect
import io.opencaesar.oml.AspectReference
import io.opencaesar.oml.Concept
import io.opencaesar.oml.ConceptInstance
import io.opencaesar.oml.ConceptInstanceReference
import io.opencaesar.oml.ConceptReference
import io.opencaesar.oml.ConceptTypeAssertion
import io.opencaesar.oml.Description
import io.opencaesar.oml.DescriptionBundle
import io.opencaesar.oml.DescriptionBundleExtension
import io.opencaesar.oml.DescriptionBundleInclusion
import io.opencaesar.oml.DescriptionBundleUsage
import io.opencaesar.oml.DescriptionExtension
import io.opencaesar.oml.DescriptionUsage
import io.opencaesar.oml.DifferentFromPredicate
import io.opencaesar.oml.EnumeratedScalar
import io.opencaesar.oml.EnumeratedScalarReference
import io.opencaesar.oml.FacetedScalar
import io.opencaesar.oml.FacetedScalarReference
import io.opencaesar.oml.FeaturePredicate
import io.opencaesar.oml.ForwardRelation
import io.opencaesar.oml.KeyAxiom
import io.opencaesar.oml.LinkAssertion
import io.opencaesar.oml.OmlPackage
import io.opencaesar.oml.QuotedLiteral
import io.opencaesar.oml.RelationCardinalityRestrictionAxiom
import io.opencaesar.oml.RelationEntity
import io.opencaesar.oml.RelationEntityPredicate
import io.opencaesar.oml.RelationEntityReference
import io.opencaesar.oml.RelationInstance
import io.opencaesar.oml.RelationInstanceReference
import io.opencaesar.oml.RelationRangeRestrictionAxiom
import io.opencaesar.oml.RelationReference
import io.opencaesar.oml.RelationTargetRestrictionAxiom
import io.opencaesar.oml.RelationTypeAssertion
import io.opencaesar.oml.ReverseRelation
import io.opencaesar.oml.Rule
import io.opencaesar.oml.RuleReference
import io.opencaesar.oml.SameAsPredicate
import io.opencaesar.oml.ScalarProperty
import io.opencaesar.oml.ScalarPropertyCardinalityRestrictionAxiom
import io.opencaesar.oml.ScalarPropertyRangeRestrictionAxiom
import io.opencaesar.oml.ScalarPropertyReference
import io.opencaesar.oml.ScalarPropertyValueAssertion
import io.opencaesar.oml.ScalarPropertyValueRestrictionAxiom
import io.opencaesar.oml.Structure
import io.opencaesar.oml.StructureInstance
import io.opencaesar.oml.StructureReference
import io.opencaesar.oml.StructuredProperty
import io.opencaesar.oml.StructuredPropertyCardinalityRestrictionAxiom
import io.opencaesar.oml.StructuredPropertyRangeRestrictionAxiom
import io.opencaesar.oml.StructuredPropertyReference
import io.opencaesar.oml.StructuredPropertyValueAssertion
import io.opencaesar.oml.StructuredPropertyValueRestrictionAxiom
import io.opencaesar.oml.TypePredicate
import io.opencaesar.oml.Vocabulary
import io.opencaesar.oml.VocabularyBundle
import io.opencaesar.oml.VocabularyBundleExtension
import io.opencaesar.oml.VocabularyBundleInclusion
import io.opencaesar.oml.VocabularyExtension
import io.opencaesar.oml.VocabularyUsage
import io.opencaesar.oml.dsl.services.OmlGrammarAccess
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.formatting.IIndentationInformation
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys
import org.eclipse.xtext.formatting2.FormatterRequest
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.preferences.MapBasedPreferenceValues

class OmlFormatter extends AbstractFormatter2 {
	
	@Inject extension OmlGrammarAccess
    @Inject IIndentationInformation indentationInformation


	override protected initialize(FormatterRequest request) {
        val preferences = request.preferences
        if (preferences instanceof MapBasedPreferenceValues) {
            preferences.put(FormatterPreferenceKeys.indentation, indentationInformation.indentString)
        }
        super.initialize(request)
    }

	def dispatch void format(Annotation _annotation, extension IFormattableDocument document) {
		_annotation.regionFor.keyword(annotationAccess.commercialAtKeyword_0).append[noSpace]
		_annotation.value?.format.prepend[oneSpace]
	}
	
	def dispatch void format(Vocabulary vocabulary, extension IFormattableDocument document) {
		vocabulary.prepend[setNewLines(0, 0, 0); noSpace]
		vocabulary.ownedAnnotations.forEach[format.append[newLine]]
        vocabulary.regionFor.keyword(vocabularyAccess.vocabularyKeyword_1).append[oneSpace]
        vocabulary.regionFor.keyword(vocabularyAccess.withKeyword_3_0).surround[oneSpace]
        vocabulary.regionFor.keyword(vocabularyAccess.asKeyword_4).surround[oneSpace]
		vocabulary.formatBraces(document)
		vocabulary.ownedImports.forEach[format.prepend[newLines = 2]]
		vocabulary.ownedStatements.forEach[format.prepend[newLines = 2]]
	}
	
	def dispatch void format(VocabularyBundle bundle, extension IFormattableDocument document) {
		bundle.prepend[setNewLines(0, 0, 0); noSpace]
		bundle.ownedAnnotations.forEach[format.append[newLine]]
        bundle.regionFor.keyword(vocabularyBundleAccess.vocabularyKeyword_1).append[oneSpace]
        bundle.regionFor.keyword(vocabularyBundleAccess.bundleKeyword_2).surround[oneSpace]
        bundle.regionFor.keyword(vocabularyBundleAccess.withKeyword_4_0).surround[oneSpace]
        bundle.regionFor.keyword(vocabularyBundleAccess.asKeyword_5).surround[oneSpace]
		bundle.formatBraces(document)
		bundle.ownedImports.forEach[format.prepend[newLines = 2]]
	}
	
	def dispatch void format(Description description, extension IFormattableDocument document) {
		description.prepend[setNewLines(0, 0, 0); noSpace]
		description.ownedAnnotations.forEach[format.append[newLine]]
        description.regionFor.keyword(descriptionAccess.descriptionKeyword_1).append[oneSpace]
        description.regionFor.keyword(descriptionAccess.withKeyword_3_0).surround[oneSpace]
        description.regionFor.keyword(descriptionAccess.asKeyword_4).surround[oneSpace]
		description.formatBraces(document)
		description.ownedImports.forEach[format.prepend[newLines = 2]]
		description.ownedStatements.forEach[format.prepend[newLines = 2]]
	}

	def dispatch void format(DescriptionBundle bundle, extension IFormattableDocument document) {
		bundle.prepend[setNewLines(0, 0, 0); noSpace]
		bundle.ownedAnnotations.forEach[format.append[newLine]]
        bundle.regionFor.keyword(descriptionBundleAccess.descriptionKeyword_1).append[oneSpace]
        bundle.regionFor.keyword(descriptionBundleAccess.bundleKeyword_2).append[oneSpace]
        bundle.regionFor.keyword(descriptionBundleAccess.withKeyword_4_0).surround[oneSpace]
        bundle.regionFor.keyword(descriptionBundleAccess.asKeyword_5).surround[oneSpace]
		bundle.formatBraces(document)
		bundle.ownedImports.forEach[format.prepend[newLines = 2]]
	}
	
	def dispatch void format(Aspect aspect, extension IFormattableDocument document) {
		aspect.ownedAnnotations.forEach[format.append[newLine]]
		aspect.regionFor.keyword(aspectAccess.aspectKeyword_1).append[oneSpace]
		aspect.regionFor.keyword(aspectAccess.colonGreaterThanSignKeyword_3_0).surround[oneSpace]
		aspect.formatCommas(document)
		aspect.formatBrackets(document)
		aspect.ownedKeys.forEach[format.prepend[newLine]]
		aspect.ownedPropertyRestrictions.forEach[format.prepend[newLine]]
		aspect.ownedRelationRestrictions.forEach[format.prepend[newLine]]
	}

	def dispatch void format(Concept concept, extension IFormattableDocument document) {
		concept.ownedAnnotations.forEach[format.append[newLine]]
		concept.regionFor.keyword(conceptAccess.conceptKeyword_1).append[oneSpace]
		concept.regionFor.keyword(conceptAccess.colonGreaterThanSignKeyword_3_0).surround[oneSpace]
		concept.formatCommas(document)
		concept.formatBrackets(document)
		concept.ownedKeys.forEach[format.prepend[newLine]]
		concept.ownedPropertyRestrictions.forEach[format.prepend[newLine]]
		concept.ownedRelationRestrictions.forEach[format.prepend[newLine]]
	}

	def dispatch void format(RelationEntity entity, extension IFormattableDocument document) {
		entity.ownedAnnotations.forEach[format.append[newLine]]
		entity.regionFor.keyword(relationEntityAccess.relationKeyword_1).append[oneSpace]
		entity.regionFor.keyword(relationEntityAccess.entityKeyword_2).surround[oneSpace]
		entity.formatCommas(document)
		entity.formatBrackets(document)
		entity.regionFor.keyword(relationEntityAccess.fromKeyword_6).prepend[newLine].append[oneSpace]
		entity.regionFor.keyword(relationEntityAccess.toKeyword_8).prepend[newLine].append[oneSpace]
		entity.forwardRelation?.format.prepend[newLine]
		entity.reverseRelation?.format.prepend[newLine]
		entity.regionFor.keyword(relationEntityAccess.functionalFunctionalKeyword_11_0_0).prepend[newLine]
		entity.regionFor.keyword(relationEntityAccess.inverseFunctionalInverseKeyword_11_1_0_0).prepend[newLine]
		entity.regionFor.keyword(relationEntityAccess.symmetricSymmetricKeyword_11_2_0).prepend[newLine]
		entity.regionFor.keyword(relationEntityAccess.asymmetricAsymmetricKeyword_11_3_0).prepend[newLine]
		entity.regionFor.keyword(relationEntityAccess.reflexiveReflexiveKeyword_11_4_0).prepend[newLine]
		entity.regionFor.keyword(relationEntityAccess.irreflexiveIrreflexiveKeyword_11_5_0).prepend[newLine]
		entity.regionFor.keyword(relationEntityAccess.transitiveTransitiveKeyword_11_6_0).prepend[newLine]
		entity.ownedKeys.forEach[format.prepend[newLine]]
		entity.ownedPropertyRestrictions.forEach[format.prepend[newLine]]
		entity.ownedRelationRestrictions.forEach[format.prepend[newLine]]
	}

	def dispatch void format(Structure structure, extension IFormattableDocument document) {
		structure.ownedAnnotations.forEach[format.append[newLine]]
		structure.regionFor.keyword(structureAccess.structureKeyword_1).append[oneSpace]
		structure.formatCommas(document)
		structure.formatBrackets(document)
		structure.ownedPropertyRestrictions.forEach[format.prepend[newLine]]
	}

	def dispatch void format(AnnotationProperty property, extension IFormattableDocument document) {
		property.ownedAnnotations.forEach[format.append[newLine]]
		property.regionFor.keyword(annotationPropertyAccess.annotationKeyword_1).append[oneSpace]
		property.regionFor.keyword(annotationPropertyAccess.propertyKeyword_2).surround[oneSpace]
		property.formatCommas(document)
	}

	def dispatch void format(ScalarProperty property, extension IFormattableDocument document) {
		property.ownedAnnotations.forEach[format.append[newLine]]
		property.regionFor.keyword(scalarPropertyAccess.scalarKeyword_1).append[oneSpace]
		property.regionFor.keyword(scalarPropertyAccess.propertyKeyword_2).surround[oneSpace]
		property.formatCommas(document)
		property.formatBrackets(document)
		property.regionFor.keyword(scalarPropertyAccess.domainKeyword_5_1).prepend[newLine]
		property.regionFor.keyword(scalarPropertyAccess.rangeKeyword_5_3).prepend[newLine]
		property.regionFor.keyword(scalarPropertyAccess.functionalFunctionalKeyword_5_5_0).prepend[newLine]
	}

	def dispatch void format(StructuredProperty property, extension IFormattableDocument document) {
		property.ownedAnnotations.forEach[format.append[newLine]]
		property.regionFor.keyword(structuredPropertyAccess.structuredKeyword_1).append[oneSpace]
		property.regionFor.keyword(structuredPropertyAccess.propertyKeyword_2).surround[oneSpace]
		property.formatCommas(document)
		property.formatBrackets(document)
		property.regionFor.keyword(structuredPropertyAccess.domainKeyword_5_1).prepend[newLine]
		property.regionFor.keyword(structuredPropertyAccess.rangeKeyword_5_3).prepend[newLine]
		property.regionFor.keyword(structuredPropertyAccess.functionalFunctionalKeyword_5_5_0).prepend[newLine]
	}

	def dispatch void format(FacetedScalar scalar, extension IFormattableDocument document) {
		scalar.ownedAnnotations.forEach[format.append[newLine]]
		scalar.regionFor.keyword(facetedScalarAccess.scalarKeyword_1).append[oneSpace]
		scalar.formatCommas(document)
		scalar.formatBrackets(document)
		scalar.regionFor.keyword(facetedScalarAccess.lengthKeyword_4_1_0_0).prepend[newLine]
		scalar.regionFor.keyword(facetedScalarAccess.minLengthKeyword_4_1_1_0).prepend[newLine]
		scalar.regionFor.keyword(facetedScalarAccess.maxLengthKeyword_4_1_2_0).prepend[newLine]
		scalar.regionFor.keyword(facetedScalarAccess.patternKeyword_4_1_3_0).prepend[newLine]
		scalar.regionFor.keyword(facetedScalarAccess.languageKeyword_4_1_4_0).prepend[newLine]
		scalar.regionFor.keyword(facetedScalarAccess.minInclusiveKeyword_4_1_5_0).prepend[newLine]
		scalar.minInclusive?.format.prepend[oneSpace]
		scalar.regionFor.keyword(facetedScalarAccess.maxInclusiveKeyword_4_1_7_0).prepend[newLine]
		scalar.maxInclusive?.format.prepend[oneSpace]
		scalar.regionFor.keyword(facetedScalarAccess.minExclusiveKeyword_4_1_6_0).prepend[newLine]
		scalar.minExclusive?.format.prepend[oneSpace]
		scalar.regionFor.keyword(facetedScalarAccess.maxExclusiveKeyword_4_1_8_0).prepend[newLine]
		scalar.maxExclusive?.format.prepend[oneSpace]
	}

	def dispatch void format(EnumeratedScalar scalar, extension IFormattableDocument document) {
		scalar.ownedAnnotations.forEach[format.append[newLine]]
		scalar.regionFor.keyword(enumeratedScalarAccess.enumeratedKeyword_1).append[oneSpace]
		scalar.regionFor.keyword(enumeratedScalarAccess.scalarKeyword_2).surround[oneSpace]
		scalar.formatCommas(document)
		scalar.formatBrackets(document)
		scalar.literals.forEach[format.prepend[newLine]]
	}

	def dispatch void format(ForwardRelation relation, extension IFormattableDocument document) {
		relation.ownedAnnotations.forEach[format.append[newLine]]
		relation.regionFor.keyword(forwardRelationAccess.forwardKeyword_1).append[oneSpace]
	}

	def dispatch void format(ReverseRelation relation, extension IFormattableDocument document) {
		relation.ownedAnnotations.forEach[format.append[newLine]]
		relation.regionFor.keyword(reverseRelationAccess.reverseKeyword_1).append[oneSpace]
	}

	def dispatch void format(Rule rule, extension IFormattableDocument document) {
		rule.ownedAnnotations.forEach[format.append[newLine]]
		rule.regionFor.keyword(ruleAccess.ruleKeyword_1).append[oneSpace]
		rule.formatBrackets(document)
		rule.antecedent.head?.format.prepend[newLine]
		rule.regionFor.keywords('^').forEach[surround[oneSpace]]
		rule.antecedent.forEach[format]
		rule.regionFor.keyword(ruleAccess.hyphenMinusGreaterThanSignKeyword_6).surround[oneSpace]
		rule.consequent.forEach[format]
	}

	def dispatch void format(ConceptInstance instance, extension IFormattableDocument document) {
		instance.ownedAnnotations.forEach[format.append[newLine]]
		instance.regionFor.keyword(conceptInstanceAccess.ciKeyword_1).append[oneSpace]
		instance.regionFor.keyword(conceptInstanceAccess.colonKeyword_3_0).surround[oneSpace]
		instance.formatCommas(document)
		instance.formatBrackets(document)
		instance.ownedPropertyValues.forEach[format.prepend[newLine]]
		instance.ownedLinks.forEach[format.prepend[newLine]]
	}

	def dispatch void format(RelationInstance instance, extension IFormattableDocument document) {
		instance.ownedAnnotations.forEach[format.append[newLine]]
		instance.regionFor.keyword(relationInstanceAccess.riKeyword_1).append[oneSpace]
		instance.regionFor.keyword(relationInstanceAccess.colonKeyword_3_0).surround[oneSpace]
		instance.formatCommas(document)
		instance.formatBrackets(document)
		instance.regionFor.keyword(relationInstanceAccess.fromKeyword_5).prepend[newLine].append[oneSpace]
		instance.sources.forEach[format.prepend[oneSpace]]
		instance.regionFor.keyword(relationInstanceAccess.toKeyword_8).prepend[newLine].append[oneSpace]
        instance.targets.forEach[format.prepend[oneSpace]]
		instance.ownedPropertyValues.forEach[format.prepend[newLine]]
		instance.ownedLinks.forEach[format.prepend[newLine]]
	}

	def dispatch void format(StructureInstance instance, extension IFormattableDocument document) {
		instance.ownedAnnotations.forEach[format.append[newLine]]
		instance.formatBrackets(document)
		instance.ownedPropertyValues.forEach[format.prepend[newLine]]
	}

	def dispatch void format(AspectReference reference, extension IFormattableDocument document) {
		reference.ownedAnnotations.forEach[format.append[newLine]]
		reference.regionFor.keyword(aspectReferenceAccess.refKeyword_1).append[oneSpace]
		reference.regionFor.keyword(aspectReferenceAccess.aspectKeyword_2).surround[oneSpace]
		reference.formatCommas(document)
		reference.formatBrackets(document)
		reference.ownedKeys.forEach[format.prepend[newLine]]
		reference.ownedPropertyRestrictions.forEach[format.prepend[newLine]]
		reference.ownedRelationRestrictions.forEach[format.prepend[newLine]]
	}

	def dispatch void format(ConceptReference reference, extension IFormattableDocument document) {
		reference.ownedAnnotations.forEach[format.append[newLine]]
		reference.regionFor.keyword(conceptReferenceAccess.refKeyword_1).append[oneSpace]
		reference.regionFor.keyword(conceptReferenceAccess.conceptKeyword_2).surround[oneSpace]
		reference.formatCommas(document)
		reference.formatBrackets(document)
		reference.ownedKeys.forEach[format.prepend[newLine]]
		reference.ownedPropertyRestrictions.forEach[format.prepend[newLine]]
		reference.ownedRelationRestrictions.forEach[format.prepend[newLine]]
	}

	def dispatch void format(RelationEntityReference reference, extension IFormattableDocument document) {
		reference.ownedAnnotations.forEach[format.append[newLine]]
		reference.regionFor.keyword(relationEntityReferenceAccess.refKeyword_1).append[oneSpace]
		reference.regionFor.keyword(relationEntityReferenceAccess.relationKeyword_2).surround[oneSpace]
		reference.regionFor.keyword(relationEntityReferenceAccess.entityKeyword_3).surround[oneSpace]
		reference.formatCommas(document)
		reference.formatBrackets(document)
		reference.ownedKeys.forEach[format.prepend[newLine]]
		reference.ownedPropertyRestrictions.forEach[format.prepend[newLine]]
		reference.ownedRelationRestrictions.forEach[format.prepend[newLine]]
	}

	def dispatch void format(StructureReference reference, extension IFormattableDocument document) {
		reference.ownedAnnotations.forEach[format.append[newLine]]
		reference.regionFor.keyword(structureReferenceAccess.refKeyword_1).append[oneSpace]
		reference.regionFor.keyword(structureReferenceAccess.structureKeyword_2).surround[oneSpace]
		reference.formatCommas(document)
		reference.formatBrackets(document)
		reference.ownedPropertyRestrictions.forEach[format.prepend[newLine]]
	}

	def dispatch void format(AnnotationPropertyReference reference, extension IFormattableDocument document) {
		reference.ownedAnnotations.forEach[format.append[newLine]]
		reference.regionFor.keyword(annotationPropertyReferenceAccess.refKeyword_1).append[oneSpace]
		reference.regionFor.keyword(annotationPropertyReferenceAccess.annotationKeyword_2).surround[oneSpace]
		reference.regionFor.keyword(annotationPropertyReferenceAccess.propertyKeyword_3).surround[oneSpace]
		reference.formatCommas(document)
	}

	def dispatch void format(ScalarPropertyReference reference, extension IFormattableDocument document) {
		reference.ownedAnnotations.forEach[format.append[newLine]]
		reference.regionFor.keyword(scalarPropertyReferenceAccess.refKeyword_1).append[oneSpace]
		reference.regionFor.keyword(scalarPropertyReferenceAccess.scalarKeyword_2).surround[oneSpace]
		reference.regionFor.keyword(scalarPropertyReferenceAccess.propertyKeyword_3).surround[oneSpace]
		reference.formatCommas(document)
	}

	def dispatch void format(StructuredPropertyReference reference, extension IFormattableDocument document) {
		reference.ownedAnnotations.forEach[format.append[newLine]]
		reference.regionFor.keyword(structuredPropertyReferenceAccess.refKeyword_1).append[oneSpace]
		reference.regionFor.keyword(structuredPropertyReferenceAccess.structuredKeyword_2).surround[oneSpace]
		reference.regionFor.keyword(structuredPropertyReferenceAccess.propertyKeyword_3).surround[oneSpace]
		reference.formatCommas(document)
	}
	
	def dispatch void format(FacetedScalarReference reference, extension IFormattableDocument document) {
		reference.ownedAnnotations.forEach[format.append[newLine]]
		reference.regionFor.keyword(facetedScalarReferenceAccess.refKeyword_1).append[oneSpace]
		reference.regionFor.keyword(facetedScalarReferenceAccess.scalarKeyword_2).surround[oneSpace]
		reference.formatCommas(document)
	}

	def dispatch void format(EnumeratedScalarReference reference, extension IFormattableDocument document) {
		reference.ownedAnnotations.forEach[format.append[newLine]]
		reference.regionFor.keyword(enumeratedScalarReferenceAccess.refKeyword_1).append[oneSpace]
		reference.regionFor.keyword(enumeratedScalarReferenceAccess.enumeratedKeyword_2).surround[oneSpace]
		reference.regionFor.keyword(enumeratedScalarReferenceAccess.scalarKeyword_3).surround[oneSpace]
		reference.formatCommas(document)
	}

	def dispatch void format(RelationReference reference, extension IFormattableDocument document) {
		reference.ownedAnnotations.forEach[format.append[newLine]]
		reference.regionFor.keyword(relationReferenceAccess.refKeyword_1).append[oneSpace]
		reference.regionFor.keyword(relationReferenceAccess.relationKeyword_2).surround[oneSpace]
	}

	def dispatch void format(RuleReference reference, extension IFormattableDocument document) {
		reference.ownedAnnotations.forEach[format.append[newLine]]
		reference.regionFor.keyword(ruleReferenceAccess.refKeyword_1).append[oneSpace]
		reference.regionFor.keyword(ruleReferenceAccess.ruleKeyword_2).surround[oneSpace]
	}

	def dispatch void format(ConceptInstanceReference reference, extension IFormattableDocument document) {
		reference.ownedAnnotations.forEach[format.append[newLine]]
		reference.regionFor.keyword(conceptInstanceReferenceAccess.refKeyword_1).append[oneSpace]
		reference.regionFor.keyword(conceptInstanceReferenceAccess.ciKeyword_2).surround[oneSpace]
		reference.formatCommas(document)
		reference.formatBrackets(document)
		reference.ownedPropertyValues.forEach[format.prepend[newLine]]
		reference.ownedLinks.forEach[format.prepend[newLine]]
	}

	def dispatch void format(RelationInstanceReference reference, extension IFormattableDocument document) {
		reference.ownedAnnotations.forEach[format.append[newLine]]
		reference.regionFor.keyword(relationInstanceReferenceAccess.refKeyword_1).append[oneSpace]
		reference.regionFor.keyword(relationInstanceReferenceAccess.riKeyword_2).surround[oneSpace]
		reference.formatCommas(document)
		reference.formatBrackets(document)
		reference.ownedPropertyValues.forEach[format.prepend[newLine]]
		reference.ownedLinks.forEach[format.prepend[newLine]]
	}

	def dispatch void format(VocabularyExtension _extension, extension IFormattableDocument document) {
		_extension.ownedAnnotations.forEach[format.append[newLine]]
		_extension.regionFor.keyword(vocabularyExtensionAccess.extendsKeyword_1).append[oneSpace]
		_extension.regionFor.keyword(vocabularyExtensionAccess.withKeyword_3_0).append[oneSpace]
		_extension.regionFor.keyword(vocabularyExtensionAccess.asKeyword_4).append[oneSpace]
	}

	def dispatch void format(VocabularyUsage usage, extension IFormattableDocument document) {
		usage.ownedAnnotations.forEach[format.append[newLine]]
		usage.regionFor.keyword(vocabularyUsageAccess.usesKeyword_1).append[oneSpace]
		usage.regionFor.keyword(vocabularyUsageAccess.withKeyword_3_0).append[oneSpace]
		usage.regionFor.keyword(vocabularyUsageAccess.asKeyword_4).append[oneSpace]
	}

	def dispatch void format(VocabularyBundleExtension _extension, extension IFormattableDocument document) {
		_extension.ownedAnnotations.forEach[format.append[newLine]]
		_extension.regionFor.keyword(vocabularyBundleExtensionAccess.extendsKeyword_1).append[oneSpace]
		_extension.regionFor.keyword(vocabularyBundleExtensionAccess.withKeyword_3_0).append[oneSpace]
		_extension.regionFor.keyword(vocabularyBundleExtensionAccess.asKeyword_4).append[oneSpace]
	}

	def dispatch void format(VocabularyBundleInclusion inclusion, extension IFormattableDocument document) {
		inclusion.ownedAnnotations.forEach[format.append[newLine]]
		inclusion.regionFor.keyword(vocabularyBundleInclusionAccess.includesKeyword_1).append[oneSpace]
		inclusion.regionFor.keyword(vocabularyBundleInclusionAccess.withKeyword_3_0).append[oneSpace]
		inclusion.regionFor.keyword(vocabularyBundleInclusionAccess.asKeyword_4).append[oneSpace]
	}

	def dispatch void format(DescriptionExtension _extension, extension IFormattableDocument document) {
		_extension.ownedAnnotations.forEach[format.append[newLine]]
		_extension.regionFor.keyword(descriptionExtensionAccess.extendsKeyword_1).append[oneSpace]
		_extension.regionFor.keyword(descriptionExtensionAccess.withKeyword_3_0).append[oneSpace]
		_extension.regionFor.keyword(descriptionExtensionAccess.asKeyword_4).append[oneSpace]
	}

	def dispatch void format(DescriptionUsage usage, extension IFormattableDocument document) {
		usage.ownedAnnotations.forEach[format.append[newLine]]
		usage.regionFor.keyword(descriptionUsageAccess.usesKeyword_1).append[oneSpace]
		usage.regionFor.keyword(descriptionUsageAccess.withKeyword_3_0).append[oneSpace]
		usage.regionFor.keyword(descriptionUsageAccess.asKeyword_4).append[oneSpace]
	}

	def dispatch void format(DescriptionBundleExtension _extension, extension IFormattableDocument document) {
		_extension.ownedAnnotations.forEach[format.append[newLine]]
		_extension.regionFor.keyword(descriptionBundleExtensionAccess.extendsKeyword_1).append[oneSpace]
		_extension.regionFor.keyword(descriptionBundleExtensionAccess.withKeyword_3_0).append[oneSpace]
		_extension.regionFor.keyword(descriptionBundleExtensionAccess.asKeyword_4).append[oneSpace]
	}

	def dispatch void format(DescriptionBundleInclusion inclusion, extension IFormattableDocument document) {
		inclusion.ownedAnnotations.forEach[format.append[newLine]]
		inclusion.regionFor.keyword(descriptionBundleInclusionAccess.includesKeyword_1).append[oneSpace]
		inclusion.regionFor.keyword(descriptionBundleInclusionAccess.withKeyword_3_0).append[oneSpace]
		inclusion.regionFor.keyword(descriptionBundleInclusionAccess.asKeyword_4).append[oneSpace]
	}

	def dispatch void format(DescriptionBundleUsage usage, extension IFormattableDocument document) {
		usage.ownedAnnotations.forEach[format.append[newLine]]
		usage.regionFor.keyword(descriptionBundleUsageAccess.usesKeyword_1).append[oneSpace]
		usage.regionFor.keyword(descriptionBundleUsageAccess.withKeyword_3_0).append[oneSpace]
		usage.regionFor.keyword(descriptionBundleUsageAccess.asKeyword_4).append[oneSpace]
	}

	def dispatch void format(ScalarPropertyRangeRestrictionAxiom axiom, extension IFormattableDocument document) {
		axiom.ownedAnnotations.forEach[format.append[newLine]]
		axiom.regionFor.keyword(scalarPropertyRangeRestrictionAxiomAccess.restrictsKeyword_1).append[oneSpace]
		axiom.regionFor.keyword(scalarPropertyRangeRestrictionAxiomAccess.scalarKeyword_3).surround[oneSpace]
		axiom.regionFor.keyword(scalarPropertyRangeRestrictionAxiomAccess.propertyKeyword_4).surround[oneSpace]
		axiom.regionFor.keyword(scalarPropertyRangeRestrictionAxiomAccess.toKeyword_6).surround[oneSpace]
	}

	def dispatch void format(ScalarPropertyCardinalityRestrictionAxiom axiom, extension IFormattableDocument document) {
		axiom.ownedAnnotations.forEach[format.append[newLine]]
		axiom.regionFor.keyword(scalarPropertyCardinalityRestrictionAxiomAccess.restrictsKeyword_1).append[oneSpace]
		axiom.regionFor.keyword(scalarPropertyCardinalityRestrictionAxiomAccess.scalarKeyword_2).surround[oneSpace]
		axiom.regionFor.keyword(scalarPropertyCardinalityRestrictionAxiomAccess.propertyKeyword_3).surround[oneSpace]
		axiom.regionFor.keyword(scalarPropertyCardinalityRestrictionAxiomAccess.toKeyword_5).surround[oneSpace]
		axiom.regionFor.feature(OmlPackage.Literals.SCALAR_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__KIND).surround[oneSpace]
		if (axiom.range !== null) {
			axiom.regionFor.feature(OmlPackage.Literals.SCALAR_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE).prepend[oneSpace]
		}
	}

	def dispatch void format(ScalarPropertyValueRestrictionAxiom axiom, extension IFormattableDocument document) {
		axiom.ownedAnnotations.forEach[format.append[newLine]]
		axiom.regionFor.keyword(scalarPropertyValueRestrictionAxiomAccess.restrictsKeyword_1).append[oneSpace]
		axiom.regionFor.keyword(scalarPropertyValueRestrictionAxiomAccess.scalarKeyword_2).surround[oneSpace]
		axiom.regionFor.keyword(scalarPropertyValueRestrictionAxiomAccess.propertyKeyword_3).surround[oneSpace]
		axiom.regionFor.keyword(scalarPropertyValueRestrictionAxiomAccess.toKeyword_5).surround[oneSpace]
	}

	def dispatch void format(StructuredPropertyRangeRestrictionAxiom axiom, extension IFormattableDocument document) {
		axiom.ownedAnnotations.forEach[format.append[newLine]]
		axiom.regionFor.keyword(structuredPropertyRangeRestrictionAxiomAccess.restrictsKeyword_1).append[oneSpace]
		axiom.regionFor.keyword(structuredPropertyRangeRestrictionAxiomAccess.structuredKeyword_3).surround[oneSpace]
		axiom.regionFor.keyword(structuredPropertyRangeRestrictionAxiomAccess.propertyKeyword_4).surround[oneSpace]
		axiom.regionFor.keyword(structuredPropertyRangeRestrictionAxiomAccess.toKeyword_6).surround[oneSpace]
	}

	def dispatch void format(StructuredPropertyCardinalityRestrictionAxiom axiom, extension IFormattableDocument document) {
		axiom.ownedAnnotations.forEach[format.append[newLine]]
		axiom.regionFor.keyword(structuredPropertyCardinalityRestrictionAxiomAccess.restrictsKeyword_1).append[oneSpace]
		axiom.regionFor.keyword(structuredPropertyCardinalityRestrictionAxiomAccess.structuredKeyword_2).surround[oneSpace]
		axiom.regionFor.keyword(structuredPropertyCardinalityRestrictionAxiomAccess.propertyKeyword_3).surround[oneSpace]
		axiom.regionFor.keyword(structuredPropertyCardinalityRestrictionAxiomAccess.toKeyword_5).surround[oneSpace]
		axiom.regionFor.feature(OmlPackage.Literals.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__KIND).surround[oneSpace]
		if (axiom.range !== null) {
			axiom.regionFor.feature(OmlPackage.Literals.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE).prepend[oneSpace]
		}
	}

	def dispatch void format(StructuredPropertyValueRestrictionAxiom axiom, extension IFormattableDocument document) {
		axiom.ownedAnnotations.forEach[format.append[newLine]]
		axiom.regionFor.keyword(structuredPropertyValueRestrictionAxiomAccess.restrictsKeyword_1).append[oneSpace]
		axiom.regionFor.keyword(structuredPropertyValueRestrictionAxiomAccess.structuredKeyword_2).surround[oneSpace]
		axiom.regionFor.keyword(structuredPropertyValueRestrictionAxiomAccess.propertyKeyword_3).surround[oneSpace]
		axiom.regionFor.keyword(structuredPropertyValueRestrictionAxiomAccess.toKeyword_5).surround[oneSpace]
	}

	def dispatch void format(RelationRangeRestrictionAxiom axiom, extension IFormattableDocument document) {
		axiom.ownedAnnotations.forEach[format.append[newLine]]
		axiom.regionFor.keyword(relationRangeRestrictionAxiomAccess.restrictsKeyword_1).append[oneSpace]
		axiom.regionFor.keyword(relationRangeRestrictionAxiomAccess.relationKeyword_3).surround[oneSpace]
		axiom.regionFor.keyword(relationRangeRestrictionAxiomAccess.toKeyword_5).surround[oneSpace]
	}

	def dispatch void format(RelationCardinalityRestrictionAxiom axiom, extension IFormattableDocument document) {
		axiom.ownedAnnotations.forEach[format.append[newLine]]
		axiom.regionFor.keyword(relationCardinalityRestrictionAxiomAccess.restrictsKeyword_1).append[oneSpace]
		axiom.regionFor.keyword(relationCardinalityRestrictionAxiomAccess.relationKeyword_2).surround[oneSpace]
		axiom.regionFor.keyword(relationCardinalityRestrictionAxiomAccess.toKeyword_4).surround[oneSpace]
		axiom.regionFor.feature(OmlPackage.Literals.RELATION_CARDINALITY_RESTRICTION_AXIOM__KIND).surround[oneSpace]
		if (axiom.range !== null) {
			axiom.regionFor.feature(OmlPackage.Literals.RELATION_CARDINALITY_RESTRICTION_AXIOM__RANGE).prepend[oneSpace]
		}
	}

	def dispatch void format(RelationTargetRestrictionAxiom axiom, extension IFormattableDocument document) {
		axiom.ownedAnnotations.forEach[format.append[newLine]]
		axiom.regionFor.keyword(relationTargetRestrictionAxiomAccess.restrictsKeyword_1).append[oneSpace]
		axiom.regionFor.keyword(relationTargetRestrictionAxiomAccess.relationKeyword_2).surround[oneSpace]
		axiom.regionFor.keyword(relationTargetRestrictionAxiomAccess.toKeyword_4).surround[oneSpace]
		axiom.regionFor.feature(OmlPackage.Literals.RELATION_TARGET_RESTRICTION_AXIOM__TARGET).surround[oneSpace]
	}

	def dispatch void format(KeyAxiom axiom, extension IFormattableDocument document) {
		axiom.ownedAnnotations.forEach[format.append[newLine]]
		axiom.regionFor.keyword(keyAxiomAccess.keyKeyword_0).append[oneSpace]
		axiom.formatCommas(document)
	}

	def dispatch void format(ConceptTypeAssertion assertion, extension IFormattableDocument document) {
		assertion.ownedAnnotations.forEach[format.append[newLine]]
	}

	def dispatch void format(RelationTypeAssertion assertion, extension IFormattableDocument document) {
		assertion.ownedAnnotations.forEach[format.append[newLine]]
	}

	def dispatch void format(ScalarPropertyValueAssertion assertion, extension IFormattableDocument document) {
		assertion.ownedAnnotations.forEach[format.append[newLine]]
		assertion.regionFor.feature(OmlPackage.Literals.SCALAR_PROPERTY_VALUE_ASSERTION__PROPERTY).append[oneSpace]
		assertion.value?.format.prepend[oneSpace]
	}

	def dispatch void format(StructuredPropertyValueAssertion assertion, extension IFormattableDocument document) {
		assertion.ownedAnnotations.forEach[format.append[newLine]]
		assertion.regionFor.feature(OmlPackage.Literals.STRUCTURED_PROPERTY_VALUE_ASSERTION__PROPERTY).append[oneSpace]
	}

	def dispatch void format(LinkAssertion assertion, extension IFormattableDocument document) {
		assertion.ownedAnnotations.forEach[format.append[newLine]]
		assertion.regionFor.feature(OmlPackage.Literals.LINK_ASSERTION__RELATION).append[oneSpace]
	}

	def dispatch void format(TypePredicate predicate, extension IFormattableDocument document) {
		predicate.regionFor.keyword(typePredicateAccess.leftParenthesisKeyword_2).surround[noSpace]
		predicate.regionFor.keyword(typePredicateAccess.rightParenthesisKeyword_4).prepend[noSpace]
	}

    def dispatch void format(RelationEntityPredicate predicate, extension IFormattableDocument document) {
        predicate.regionFor.keyword(relationEntityPredicateAccess.leftParenthesisKeyword_2).surround[noSpace]
        predicate.formatCommas(document)
        predicate.regionFor.keyword(relationEntityPredicateAccess.rightParenthesisKeyword_8).prepend[noSpace]
    }

	def dispatch void format(FeaturePredicate predicate, extension IFormattableDocument document) {
		predicate.regionFor.keyword(featurePredicateAccess.leftParenthesisKeyword_2).surround[noSpace]
		predicate.formatCommas(document)
		predicate.regionFor.keyword(featurePredicateAccess.rightParenthesisKeyword_6).prepend[noSpace]
	}

	def dispatch void format(SameAsPredicate predicate, extension IFormattableDocument document) {
		predicate.regionFor.keyword(sameAsPredicateAccess.leftParenthesisKeyword_2).surround[noSpace]
		predicate.formatCommas(document)
		predicate.regionFor.keyword(sameAsPredicateAccess.rightParenthesisKeyword_6).prepend[noSpace]
	}

	def dispatch void format(DifferentFromPredicate predicate, extension IFormattableDocument document) {
		predicate.regionFor.keyword(differentFromPredicateAccess.leftParenthesisKeyword_2).surround[noSpace]
		predicate.formatCommas(document)
        predicate.regionFor.keyword(differentFromPredicateAccess.rightParenthesisKeyword_6).prepend[noSpace]
	}

	def dispatch void format(QuotedLiteral literal, extension IFormattableDocument document) {
		literal.regionFor.keyword(quotedLiteralAccess.circumflexAccentCircumflexAccentKeyword_1_0_0).surround[noSpace]
		literal.regionFor.keyword(quotedLiteralAccess.dollarSignKeyword_1_1_0).surround[noSpace]
	}

	def formatBrackets(EObject e, extension IFormattableDocument document) {
		val open = e.regionFor.keyword("[")
		open.prepend[oneSpace]
		val close = e.regionFor.keyword("]")
		close.prepend[newLine]
		interior(open, close)[indent]
	}
	
	def formatBraces(EObject e, extension IFormattableDocument document) {
		val open = e.regionFor.keyword("{")
		open.prepend[oneSpace]
		val close = e.regionFor.keyword("}")
		close.prepend[newLine]
		interior(open, close)[indent]
	}

	def formatCommas(EObject e, extension IFormattableDocument document) {
		e.regionFor.keywords(',').forEach[prepend[noSpace].append[oneSpace]]
	}

}
