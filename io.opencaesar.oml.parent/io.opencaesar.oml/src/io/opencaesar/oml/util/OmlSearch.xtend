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
package io.opencaesar.oml.util

import io.opencaesar.oml.AnnotatedElement
import io.opencaesar.oml.Annotation
import io.opencaesar.oml.AnnotationProperty
import io.opencaesar.oml.Aspect
import io.opencaesar.oml.Classifier
import io.opencaesar.oml.ClassifierReference
import io.opencaesar.oml.Concept
import io.opencaesar.oml.ConceptInstance
import io.opencaesar.oml.ConceptInstanceReference
import io.opencaesar.oml.ConceptTypeAssertion
import io.opencaesar.oml.Description
import io.opencaesar.oml.DescriptionBox
import io.opencaesar.oml.DescriptionBundle
import io.opencaesar.oml.DescriptionBundleExtension
import io.opencaesar.oml.DescriptionBundleInclusion
import io.opencaesar.oml.DescriptionBundleUsage
import io.opencaesar.oml.DescriptionExtension
import io.opencaesar.oml.DescriptionUsage
import io.opencaesar.oml.Element
import io.opencaesar.oml.Entity
import io.opencaesar.oml.EntityReference
import io.opencaesar.oml.EnumeratedScalar
import io.opencaesar.oml.FacetedScalar
import io.opencaesar.oml.Import
import io.opencaesar.oml.Instance
import io.opencaesar.oml.KeyAxiom
import io.opencaesar.oml.LinkAssertion
import io.opencaesar.oml.Literal
import io.opencaesar.oml.Member
import io.opencaesar.oml.NamedInstance
import io.opencaesar.oml.NamedInstanceReference
import io.opencaesar.oml.Ontology
import io.opencaesar.oml.PropertyRestrictionAxiom
import io.opencaesar.oml.PropertyValueAssertion
import io.opencaesar.oml.Reference
import io.opencaesar.oml.Relation
import io.opencaesar.oml.RelationEntity
import io.opencaesar.oml.RelationInstance
import io.opencaesar.oml.RelationInstanceReference
import io.opencaesar.oml.RelationRestrictionAxiom
import io.opencaesar.oml.RelationTypeAssertion
import io.opencaesar.oml.Rule
import io.opencaesar.oml.ScalarProperty
import io.opencaesar.oml.SpecializableTerm
import io.opencaesar.oml.SpecializableTermReference
import io.opencaesar.oml.SpecializationAxiom
import io.opencaesar.oml.Structure
import io.opencaesar.oml.StructureInstance
import io.opencaesar.oml.StructuredProperty
import io.opencaesar.oml.TypeAssertion
import io.opencaesar.oml.Vocabulary
import io.opencaesar.oml.VocabularyBox
import io.opencaesar.oml.VocabularyBundle
import io.opencaesar.oml.VocabularyBundleExtension
import io.opencaesar.oml.VocabularyBundleInclusion
import io.opencaesar.oml.VocabularyExtension
import io.opencaesar.oml.VocabularyUsage
import java.util.ArrayList
import java.util.Collections

import static extension io.opencaesar.oml.util.OmlRead.*

/*
 * This API assumes the resource set has a CrossReferenceAdapter installed on all EObjects
 */
class OmlSearch extends OmlIndex {

	// Element

	// Annotation

	// AnnotatedElement

	static dispatch def Iterable<Annotation> findAnnotations(AnnotatedElement element) {
		element.ownedAnnotations
	}

	static def findAnnotationValues(AnnotatedElement element, String annotationPropertyIri) {
		element.findAnnotations.filter[property.iri == annotationPropertyIri].map[value]
	}
	
	static def findAnnotationLexicalValue(AnnotatedElement element, String annotationPropertyIri) {
		element.findAnnotationValues(annotationPropertyIri)?.head?.lexicalValue
	}
	
	// IdentifiedElement
	
	// Ontology

	static def Iterable<Import> findImportsWithTarget(Ontology ontology) {
		val ontologies = ontology.eResource?.resourceSet?.ontologies
		ontologies.map[importsWithSource].flatten.filter[importedOntology === ontology]
	}

	static def Iterable<Ontology> findImportingOntologies(Ontology ontology) {
		ontology.findImportsWithTarget.map[importingOntology]
	}

	// VocabularyBox

	static def Iterable<DescriptionUsage> findDescriptionUsagesWithUsedVocabularyBox(VocabularyBox box) {
		box.findImportsWithTarget.filter(DescriptionUsage)
	}

	static def Iterable<Description> findUsingDescriptions(VocabularyBox box) {
		box.findDescriptionUsagesWithUsedVocabularyBox.map[usingDescription]
	}

	// Vocabulary

	static def Iterable<VocabularyExtension> findVocabularyExtensionsWithExtendedVocabulary(Vocabulary vocabulary) {
		vocabulary.findImportsWithTarget.filter(VocabularyExtension)
	}

	static def Iterable<Vocabulary> findExtendingVocabularies(Vocabulary vocabulary) {
		vocabulary.findVocabularyExtensionsWithExtendedVocabulary.map[extendingVocabulary]
	}

	static def Iterable<VocabularyBundleInclusion> findVocabularyBundleInclusionsWithIncludedVocabulary(Vocabulary vocabulary) {
		vocabulary.findImportsWithTarget.filter(VocabularyBundleInclusion)
	}

	static def Iterable<VocabularyBundle> findIncludingVocabularyBundles(Vocabulary vocabulary) {
		vocabulary.findVocabularyBundleInclusionsWithIncludedVocabulary.map[includingVocabularyBundle]
	}

	// VocabularyBundle
	
	static def Iterable<VocabularyBundleExtension> findVocabularyBundleExtensionsWithExtendedVocabularyBundle(VocabularyBundle bundle) {
		bundle.findImportsWithTarget.filter(VocabularyBundleExtension)
	}

	static def Iterable<VocabularyBundle> findExtendingVocabularyBundles(VocabularyBundle bundle) {
		bundle.findVocabularyBundleExtensionsWithExtendedVocabularyBundle.map[extendingVocabularyBundle]
	}

	static def Iterable<DescriptionBundleUsage> findDescriptionBundleUsagesWithUsedVocabularyBundle(VocabularyBundle bundle) {
		bundle.findImportsWithTarget.filter(DescriptionBundleUsage)
	}

	static def Iterable<DescriptionBundle> findUsingDescriptionBundles(VocabularyBundle bundle) {
		bundle.findDescriptionBundleUsagesWithUsedVocabularyBundle.map[usingDescriptionBundle]
	}

	// DescriptionBox

	static def Iterable<VocabularyUsage> findVocabularyUsagesWithUsedDescriptionBox(DescriptionBox box) {
		box.findImportsWithTarget.filter(VocabularyUsage)
	}

	static def Iterable<Vocabulary> findUsingVocabularies(DescriptionBox box) {
		box.findVocabularyUsagesWithUsedDescriptionBox.map[usingVocabulary]
	}

	// Description
	
	static def Iterable<DescriptionExtension> findDescriptionExtensionsWithExtendedDescription(Description description) {
		description.findImportsWithTarget.filter(DescriptionExtension)
	}

	static def Iterable<Description> findExtendingDescriptions(Description description) {
		description.findDescriptionExtensionsWithExtendedDescription.map[extendingDescription]
	}

	static def Iterable<DescriptionBundleInclusion> findDescriptionBundleInclusionsWithIncludedDescription(Description description) {
		description.findImportsWithTarget.filter(DescriptionBundleInclusion)
	}

	static def Iterable<DescriptionBundle> findIncludingDescriptionBundles(Description description) {
		description.findDescriptionBundleInclusionsWithIncludedDescription.map[includingDescriptionBundle]
	}

	// DescriptionBundle
	
	static def Iterable<DescriptionBundleExtension> findDescriptionBundleExtensionsWithExtendedDescriptionBundle(DescriptionBundle bundle) {
		bundle.findImportsWithTarget.filter(DescriptionBundleExtension)
	}

	static def Iterable<DescriptionBundle> findExtendingDescriptionBundles(DescriptionBundle bundle) {
		bundle.findDescriptionBundleExtensionsWithExtendedDescriptionBundle.map[extendingDescriptionBundle]
	}

	// Member
	
	static dispatch def Iterable<Reference> findReferences(Member member) {
		Collections.EMPTY_LIST
	}

	static dispatch def Iterable<Annotation> findAnnotations(Member member) {
		val terms = new ArrayList<Annotation>
		terms += member.ownedAnnotations
		terms += member.findReferences.flatMap[ownedAnnotations]
		terms
	}

	// Term

	// SpecializableTerm

	static def Iterable<SpecializationAxiom> findSpecializationsWithSource(SpecializableTerm term) {
		val specializations = new ArrayList<SpecializationAxiom>
		specializations += term.ownedSpecializations
		specializations += term.findReferences.filter(SpecializableTermReference).flatMap[ownedSpecializations]
		specializations
	}

	static def Iterable<SpecializableTerm> findSpecializedTerms(SpecializableTerm term) {
		term.findSpecializationsWithSource.map[specializedTerm]
	}
		
	static def Iterable<SpecializationAxiom> findSpecializationsWithTarget(SpecializableTerm term) {
		term.findSpecializationAxiomsWithSpecializedTerm
	}

	static def Iterable<SpecializableTerm> findSpecializingTerms(SpecializableTerm term) {
		term.findSpecializationsWithTarget.map[specializingTerm]
	}

	// Type

	// Classifier
	
	static def Iterable<PropertyRestrictionAxiom> findPropertyRestrictions(Classifier classifier) {
		val restrictions = new ArrayList<PropertyRestrictionAxiom>
		restrictions += classifier.ownedPropertyRestrictions
		restrictions += classifier.findReferences.filter(ClassifierReference).flatMap[ownedPropertyRestrictions]
		restrictions
	}

	// Entity

	static def Iterable<Relation> findRelationsWithSource(Entity entity) {
		val relations = new ArrayList<Relation>
		relations += entity.findRelationEntitiesWithSource.map[forward]
		relations += entity.findRelationEntitiesWithTarget.map[reverse].reject[null]
		relations
	}

	static def Iterable<Relation> findRelationsWithTarget(Entity entity) {
		val relations = new ArrayList<Relation>
		relations += entity.findRelationEntitiesWithTarget.map[forward]
		relations += entity.findRelationEntitiesWithSource.map[reverse].reject[null]
		relations
	}

	static def Iterable<RelationRestrictionAxiom> findRelationRestrictions(Entity entity) {
		val restrictions = new ArrayList<RelationRestrictionAxiom>
		restrictions += entity.ownedRelationRestrictions
		restrictions += entity.findReferences.filter(EntityReference).flatMap[ownedRelationRestrictions]
		restrictions
	}

	static def Iterable<KeyAxiom> findKeys(Entity entity) {
		val keys = new ArrayList<KeyAxiom>
		keys += entity.ownedKeys
		keys += entity.findReferences.filter(EntityReference).flatMap[ownedKeys]
		keys
	}

	static dispatch def Iterable<TypeAssertion> findTypeAssertionsWithType(Entity entity) {
		Collections.EMPTY_LIST
	}

	static dispatch def Iterable<NamedInstance> findNamedInstancesWithType(Entity entity) {
		Collections.EMPTY_LIST
	}

	// Aspect

	static dispatch def Iterable<Reference> findReferences(Aspect member) {
		member.findAspectReferencesWithAspect.filter(Reference)
	}

	// Concept

	static dispatch def Iterable<Reference> findReferences(Concept member) {
		member.findConceptReferencesWithConcept.filter(Reference)
	}

	static dispatch def Iterable<TypeAssertion> findTypeAssertionsWithType(Concept entity) {
		entity.findConceptTypeAssertionsWithType.filter(TypeAssertion)
	}
	
	static dispatch def Iterable<NamedInstance> findNamedInstancesWithType(Concept entity) {
		entity.findConceptInstancesWithType
	}

	static def Iterable<NamedInstance> findConceptInstancesWithType(Concept entity) {
		entity.findConceptTypeAssertionsWithType.map[conceptInstance]
	}

	// RelationEntity
	
	static dispatch def Iterable<Reference> findReferences(RelationEntity member) {
		member.findRelationEntityReferencesWithEntity.filter(Reference)
	}

	static dispatch def Iterable<TypeAssertion> findTypeAssertionsWithType(RelationEntity entity) {
		entity.findRelationTypeAssertionsWithType.filter(TypeAssertion)
	}
	
	static dispatch def Iterable<NamedInstance> findNamedInstancesWithType(RelationEntity entity) {
		entity.findRelationInstancesWithType.filter(NamedInstance)
	}

	static def Iterable<RelationInstance> findRelationInstancesWithType(RelationEntity entity) {
		entity.findRelationTypeAssertionsWithType.map[relationInstance]
	}

	// Structure

	static dispatch def Iterable<Reference> findReferences(Structure member) {
		member.findStructureReferencesWithStructure.filter(Reference)
	}

	// Property

	// AnnotationProperty

	static dispatch def Iterable<Reference> findReferences(AnnotationProperty member) {
		member.findAnnotationPropertyReferencesWithProperty.filter(Reference)
	}

	// FeatureProperty

	// ScalarProperty

	static dispatch def Iterable<Reference> findReferences(ScalarProperty member) {
		member.findScalarPropertyReferencesWithProperty.filter(Reference)
	}

	static def Iterable<Entity> findEntitiesWithKeyProperty(ScalarProperty property) {
		property.findKeyAxiomWithProperty.map[keyedEntity]
	}

	// StructuredProperty

	static dispatch def Iterable<Reference> findReferences(StructuredProperty member) {
		member.findStructuredPropertyReferencesWithProperty.filter(Reference)
	}

	// Scalar

	// FacetedScalar

	static dispatch def Iterable<Reference> findReferences(FacetedScalar member) {
		member.findFacetedScalarReferencesWithScalar.filter(Reference)
	}

	// EnumeratedScalar

	static dispatch def Iterable<Reference> findReferences(EnumeratedScalar member) {
		member.findEnumeratedScalarReferencesWithScalar.filter(Reference)
	}

	// Relation

	static dispatch def Iterable<Reference> findReferences(Relation member) {
		member.findRelationReferencesWithRelation.filter(Reference)
	}

	// ForwardRelation

	// ReverseRelation

	// Rule

	static dispatch def Iterable<Reference> findReferences(Rule member) {
		member.findRuleReferencesWithRule.filter(Reference)
	}

	// Instance

	static dispatch def Iterable<PropertyValueAssertion> findPropertyValueAssertions(Instance instance) {
		instance.ownedPropertyValues
	}

	static def Iterable<Element> findPropertyValues(Instance instance, String propertyIri) {
		instance.findPropertyValueAssertions.filter[property.iri == propertyIri].map[value]
	}
	
	static def Iterable<Literal> findScalarPropertyValues(Instance instance, String propertyIri) {
		instance.findPropertyValues(propertyIri).filter(Literal)
	}

	static def Iterable<StructureInstance> findStructuredPropertyValues(Instance instance, String propertyIri) {
		instance.findPropertyValues(propertyIri).filter(StructureInstance)
	}

	// StructureInstance

	// NamedInstance

	static dispatch def Iterable<PropertyValueAssertion> findPropertyValueAssertions(NamedInstance instance) {
		val relations = new ArrayList<PropertyValueAssertion>
		relations += instance.ownedPropertyValues
		relations += instance.findReferences.filter(NamedInstanceReference).flatMap[ownedPropertyValues]
		relations
	}

	static def Iterable<LinkAssertion> findLinkAssertionsWithSource(NamedInstance instance) {
		val relations = new ArrayList<LinkAssertion>
		relations += instance.ownedLinks
		relations += instance.findReferences.filter(NamedInstanceReference).flatMap[ownedLinks]
		relations
	}

	static def Iterable<NamedInstance> findInstancesRelatedAsTargetOf(NamedInstance instance, String relationIri) {
		val instances = new ArrayList<NamedInstance>
		instances += instance.findLinkAssertionsWithSource.filter[relation.iri == relationIri].map[target]
		instances += instance.findRelationInstancesWithSource.filter[findTypes.exists[iri == relationIri]].map[target]
		instances
	}
	
	static def Iterable<NamedInstance> findInstancesRelatedAsSourceOf(NamedInstance instance, String relationIri) {
		val instances = new ArrayList<NamedInstance>
		instances += instance.findLinkAssertionsWithTarget.filter[relation.iri == relationIri].map[source]
		instances += instance.findRelationInstancesWithTarget.filter[findTypes.exists[iri == relationIri]].map[source]
		instances
	}

	static dispatch def Iterable<TypeAssertion> findTypeAssertions(NamedInstance instance) {
		Collections.EMPTY_LIST
	}
	
	static def Iterable<Entity> findTypes(NamedInstance instance) {
		instance.findTypeAssertions.map[type]
	}

	// ConceptInstance

	static dispatch def Iterable<Reference> findReferences(ConceptInstance member) {
		member.findConceptInstanceReferencesWithInstance.filter(Reference)
	}

	static dispatch def Iterable<ConceptTypeAssertion> findTypeAssertions(ConceptInstance instance) {
		val relations = new ArrayList<ConceptTypeAssertion>
		relations += instance.ownedTypes
		relations += instance.findReferences.filter(ConceptInstanceReference).flatMap[ownedTypes]
		relations
	}

	// RelationInstance

	static dispatch def Iterable<Reference> findReferences(RelationInstance member) {
		member.findRelationInstanceReferencesWithInstance.filter(Reference)
	}

	static dispatch def Iterable<RelationTypeAssertion> findTypeAssertions(RelationInstance instance) {
		val relations = new ArrayList<RelationTypeAssertion>
		relations += instance.ownedTypes
		relations += instance.findReferences.filter(RelationInstanceReference).flatMap[ownedTypes]
		relations
	}

	// Statement

	// VocabularyStatement
	
	// DescriptionStatement

	// Import
		
	// VocabularyImport
	
	// VocabularyExtension
	
	// VocabularyUsage

	// VocabularyBundleImport

	// VocabularyBundleInclusion
	
	// VocabularyBundleExtension
	
	// DescriptionImport

	// DescriptionUsage

	// DescriptionExtension	

	// DescriptionBundleImport

	// DescriptionBundleInclusion
	
	// DescriptionBundleExtension

	// DescriptionBundleUsage

	// Axiom

	// SpecializationAxiom

	// RestrictionAxiom

	// PropertyRestrictionAxiom

	// ScalarPropertyRestrictionAxiom

	// ScalarPropertyRangeRestrictionAxiom

	// ScalarPropertyCardinalityRestrictionAxiom

	// ScalarPropertyValueRestrictionAxiom

	// StructuredPropertyRestrictionAxiom

	// StructuredPropertyRangeRestrictionAxiom

	// StructuredPropertyCardinalityRestrictionAxiom

	// StructuredPropertyValueRestrictionAxiom
	
	// RelationRestrictionAxiom

	// RelationRangeRestrictionAxiom
	
	// RelationCardinalityRestrictionAxiom

	// RelationTargetRestrictionAxiom

	// Assertion
	
	// TypeAssertion

	// ConceptTypeAssertion

	// RelationTypeAssertion

	// PropertyValueAssertion

	// ScalarPropertyValueAssertion

	// StructuredPropertyValueAssertion

	// LinkAssertion

	// Predicate

	// UnaryPredicate

	// EntityPredicate

	// BinaryPredicate

	// RelationPredicate

	// SameAsPredicate

	// DifferentFromPredicate

	// RelationEntityPredicate
			
}