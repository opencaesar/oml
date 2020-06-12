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

import io.opencaesar.oml.Annotation
import io.opencaesar.oml.AnnotationProperty
import io.opencaesar.oml.AnnotationPropertyReference
import io.opencaesar.oml.Aspect
import io.opencaesar.oml.AspectReference
import io.opencaesar.oml.Classifier
import io.opencaesar.oml.Concept
import io.opencaesar.oml.ConceptInstance
import io.opencaesar.oml.ConceptInstanceReference
import io.opencaesar.oml.ConceptReference
import io.opencaesar.oml.ConceptTypeAssertion
import io.opencaesar.oml.Element
import io.opencaesar.oml.Entity
import io.opencaesar.oml.EntityPredicate
import io.opencaesar.oml.EnumeratedScalar
import io.opencaesar.oml.EnumeratedScalarReference
import io.opencaesar.oml.FacetedScalar
import io.opencaesar.oml.FacetedScalarReference
import io.opencaesar.oml.FeatureProperty
import io.opencaesar.oml.KeyAxiom
import io.opencaesar.oml.LinkAssertion
import io.opencaesar.oml.Literal
import io.opencaesar.oml.NamedInstance
import io.opencaesar.oml.OmlPackage
import io.opencaesar.oml.Relation
import io.opencaesar.oml.RelationCardinalityRestrictionAxiom
import io.opencaesar.oml.RelationEntity
import io.opencaesar.oml.RelationEntityPredicate
import io.opencaesar.oml.RelationEntityReference
import io.opencaesar.oml.RelationInstance
import io.opencaesar.oml.RelationInstanceReference
import io.opencaesar.oml.RelationPredicate
import io.opencaesar.oml.RelationRangeRestrictionAxiom
import io.opencaesar.oml.RelationReference
import io.opencaesar.oml.RelationRestrictionAxiom
import io.opencaesar.oml.RelationTargetRestrictionAxiom
import io.opencaesar.oml.RelationTypeAssertion
import io.opencaesar.oml.Rule
import io.opencaesar.oml.RuleReference
import io.opencaesar.oml.Scalar
import io.opencaesar.oml.ScalarProperty
import io.opencaesar.oml.ScalarPropertyCardinalityRestrictionAxiom
import io.opencaesar.oml.ScalarPropertyRangeRestrictionAxiom
import io.opencaesar.oml.ScalarPropertyReference
import io.opencaesar.oml.ScalarPropertyRestrictionAxiom
import io.opencaesar.oml.ScalarPropertyValueAssertion
import io.opencaesar.oml.SpecializableTerm
import io.opencaesar.oml.SpecializationAxiom
import io.opencaesar.oml.Structure
import io.opencaesar.oml.StructureInstance
import io.opencaesar.oml.StructureReference
import io.opencaesar.oml.StructuredProperty
import io.opencaesar.oml.StructuredPropertyCardinalityRestrictionAxiom
import io.opencaesar.oml.StructuredPropertyRangeRestrictionAxiom
import io.opencaesar.oml.StructuredPropertyReference
import io.opencaesar.oml.StructuredPropertyRestrictionAxiom
import io.opencaesar.oml.StructuredPropertyValueAssertion
import java.util.HashSet
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer

/*
 * This API assumes the resource set has a CrossReferenceAdapter installed on all EObjects
 */
class OmlIndex {

	// Core Index API
	
	private static def Iterable<EObject> findInverseReferencers(Element element, String eReferenceName) {
        val referencers = new HashSet<EObject>
        val adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(element)
		val settings =  if (adapter !== null) {
			// the fast method
			adapter.getInverseReferences(element, true)
		} else {
			// the slow method
			searchForReferences(element)
		}
        for (setting : settings) {
            if (setting.EStructuralFeature.name == eReferenceName) {
                referencers.add(setting.EObject)
            }
        }
        referencers
    }

	private static def searchForReferences(EObject element) {
		val resource = element.eResource
	    if (resource === null) {
			val rootEObject = EcoreUtil.getRootContainer(element);
	    	UsageCrossReferencer.find(element, rootEObject);
	    } else {
			val resourceSet = resource.getResourceSet();
			if (resourceSet === null) {
	        	UsageCrossReferencer.find(element, resource);
	      	} else {
	        	UsageCrossReferencer.find(element, resourceSet);
	      	}
	    }
	}

	private static def <T extends EObject> Iterable<T> findInverseReferencers(Element element, Class<T> type, EReference eReference) {
        val referencers = new HashSet<T>
		findInverseReferencers(element, eReference.name).forEach[referencer|
			if (type.isInstance(referencer)) {
				referencers.add(referencer as T)
			}
		]
		referencers
    }


	// Element

	// Annotation

	// AnnotatedElement

	// IdentifiedElement
	
	// Ontology

	// VocabularyBox

	// Vocabulary

	// VocabularyBundle
	
	// DescriptionBox

	// Description
	
	// DescriptionBundle

	// Member
	
	// Term

	// SpecializableTerm

	static def Iterable<SpecializationAxiom> findSpecializationAxiomsWithSpecializedTerm(SpecializableTerm term) {
		term.findInverseReferencers(SpecializationAxiom, OmlPackage.Literals.SPECIALIZATION_AXIOM__SPECIALIZED_TERM)
	}

	// Type

	// Classifier
	
	static def Iterable<FeatureProperty> findFeaturePropertiesWithDomain(Classifier classifier) {
		classifier.findInverseReferencers(FeatureProperty, OmlPackage.Literals.FEATURE_PROPERTY__DOMAIN)
	}

	// Entity

	static def Iterable<RelationEntity> findRelationEntitiesWithSource(Entity entity) {
		entity.findInverseReferencers(RelationEntity, OmlPackage.Literals.RELATION_ENTITY__SOURCE)
	}

	static def Iterable<RelationEntity> findRelationEntitiesWithTarget(Entity entity) {
		entity.findInverseReferencers(RelationEntity, OmlPackage.Literals.RELATION_ENTITY__TARGET)
	}

	static def Iterable<RelationRangeRestrictionAxiom> findRelationRangeRestrictionAxiomsWithRange(Entity entity) {
		entity.findInverseReferencers(RelationRangeRestrictionAxiom, OmlPackage.Literals.RELATION_RANGE_RESTRICTION_AXIOM__RANGE)
	}

	static def Iterable<RelationCardinalityRestrictionAxiom> findRelationCardinalityRestrictionAxiomsWithRange(Entity entity) {
		entity.findInverseReferencers(RelationCardinalityRestrictionAxiom, OmlPackage.Literals.RELATION_CARDINALITY_RESTRICTION_AXIOM__RANGE)
	}

	static def Iterable<EntityPredicate> findEntityPredicatesWithEntity(Entity entity) {
		entity.findInverseReferencers(EntityPredicate, OmlPackage.Literals.ENTITY_PREDICATE__ENTITY)
	}

	// Aspect

	static  def Iterable<AspectReference> findAspectReferencesWithAspect(Aspect aspect) {
		aspect.findInverseReferencers(AspectReference, OmlPackage.Literals.ASPECT_REFERENCE__ASPECT)
	}

	// Concept

	static  def Iterable<ConceptReference> findConceptReferencesWithConcept(Concept concept) {
		concept.findInverseReferencers(ConceptReference, OmlPackage.Literals.CONCEPT_REFERENCE__CONCEPT)
	}

	static def Iterable<ConceptTypeAssertion> findConceptTypeAssertionsWithType(Concept concept) {
		concept.findInverseReferencers(ConceptTypeAssertion, OmlPackage.Literals.CONCEPT_TYPE_ASSERTION__TYPE)
	}

	// RelationEntity
	
	static  def Iterable<RelationEntityReference> findRelationEntityReferencesWithEntity(RelationEntity entity) {
		entity.findInverseReferencers(RelationEntityReference, OmlPackage.Literals.RELATION_ENTITY_REFERENCE__ENTITY)
	}

	static def Iterable<RelationTypeAssertion> findRelationTypeAssertionsWithType(RelationEntity entity) {
		entity.findInverseReferencers(RelationTypeAssertion, OmlPackage.Literals.RELATION_TYPE_ASSERTION__TYPE)
	}

	static def Iterable<RelationEntityPredicate> findRelationEntityPredicatesWithEntity(RelationEntity entity) {
		entity.findInverseReferencers(RelationEntityPredicate, OmlPackage.Literals.RELATION_ENTITY_PREDICATE__ENTITY)
	}

	// Structure

	static def Iterable<StructuredProperty> findStructuredPropertiesWithRange(Structure structure) {
		structure.findInverseReferencers(StructuredProperty, OmlPackage.Literals.STRUCTURED_PROPERTY__RANGE)
	}

	static def Iterable<StructureInstance> findStructureInstancesWithType(Structure structure) {
		structure.findInverseReferencers(StructureInstance, OmlPackage.Literals.STRUCTURE_INSTANCE__TYPE)
	}

	static  def Iterable<StructureReference> findStructureReferencesWithStructure(Structure structure) {
		structure.findInverseReferencers(StructureReference, OmlPackage.Literals.STRUCTURE_REFERENCE__STRUCTURE)
	}

	static  def Iterable<StructuredPropertyRangeRestrictionAxiom> findStructuredPropertyRangeRestrictionAxiomsWithRange(Structure structure) {
		structure.findInverseReferencers(StructuredPropertyRangeRestrictionAxiom, OmlPackage.Literals.STRUCTURED_PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE)
	}

	static  def Iterable<StructuredPropertyCardinalityRestrictionAxiom> findStructuredPropertyCardinalityRestrictionAxiomsWithRange(Structure structure) {
		structure.findInverseReferencers(StructuredPropertyCardinalityRestrictionAxiom, OmlPackage.Literals.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE)
	}

	// Property

	// AnnotationProperty

	static def Iterable<AnnotationPropertyReference> findAnnotationPropertyReferencesWithProperty(AnnotationProperty property) {
		property.findInverseReferencers(AnnotationPropertyReference, OmlPackage.Literals.ANNOTATION_PROPERTY_REFERENCE__PROPERTY)
	}

	static def Iterable<Annotation> findAnnotationsWithProperty(AnnotationProperty property) {
		property.findInverseReferencers(Annotation, OmlPackage.Literals.ANNOTATION__PROPERTY)
	}

	// FeatureProperty

	// ScalarProperty

	static  def Iterable<ScalarPropertyReference> findScalarPropertyReferencesWithProperty(ScalarProperty property) {
		property.findInverseReferencers(ScalarPropertyReference, OmlPackage.Literals.SCALAR_PROPERTY_REFERENCE__PROPERTY)
	}

	static  def Iterable<ScalarPropertyRestrictionAxiom> findScalarPropertyRestrictionAxiomsWithProperty(ScalarProperty property) {
		property.findInverseReferencers(ScalarPropertyRestrictionAxiom, OmlPackage.Literals.SCALAR_PROPERTY_RESTRICTION_AXIOM__PROPERTY)
	}

	static  def Iterable<ScalarPropertyValueAssertion> findScalarPropertyValueAssertionsWithProperty(ScalarProperty property) {
		property.findInverseReferencers(ScalarPropertyValueAssertion, OmlPackage.Literals.SCALAR_PROPERTY_VALUE_ASSERTION__PROPERTY)
	}

	static  def Iterable<KeyAxiom> findKeyAxiomWithProperty(ScalarProperty property) {
		property.findInverseReferencers(KeyAxiom, OmlPackage.Literals.KEY_AXIOM__PROPERTIES)
	}

	// StructuredProperty

	static  def Iterable<StructuredPropertyReference> findStructuredPropertyReferencesWithProperty(StructuredProperty property) {
		property.findInverseReferencers(StructuredPropertyReference, OmlPackage.Literals.STRUCTURED_PROPERTY_REFERENCE__PROPERTY)
	}

	static  def Iterable<StructuredPropertyRestrictionAxiom> findStructuredPropertyRestrictionAxiomsWithProperty(StructuredProperty property) {
		property.findInverseReferencers(StructuredPropertyRestrictionAxiom, OmlPackage.Literals.STRUCTURED_PROPERTY_RESTRICTION_AXIOM__PROPERTY)
	}

	static  def Iterable<StructuredPropertyValueAssertion> findStructuredPropertyValueAssertionsWithProperty(StructuredProperty property) {
		property.findInverseReferencers(StructuredPropertyValueAssertion, OmlPackage.Literals.STRUCTURED_PROPERTY_VALUE_ASSERTION__PROPERTY)
	}

	// Scalar

	static def Iterable<ScalarProperty> findScalarPropertiesWithRange(Scalar scalar) {
		scalar.findInverseReferencers(ScalarProperty, OmlPackage.Literals.SCALAR_PROPERTY__RANGE)
	}

	static def Iterable<ScalarPropertyRangeRestrictionAxiom> findScalarPropertyRangeRestrictionAxiomsWithRange(Scalar scalar) {
		scalar.findInverseReferencers(ScalarPropertyRangeRestrictionAxiom, OmlPackage.Literals.SCALAR_PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE)
	}

	static def Iterable<ScalarPropertyCardinalityRestrictionAxiom> findScalarPropertyCardinalityRestrictionAxiomsWithRange(Scalar scalar) {
		scalar.findInverseReferencers(ScalarPropertyCardinalityRestrictionAxiom, OmlPackage.Literals.SCALAR_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE)
	}

	static def Iterable<Literal> findLiteralsWithType(Scalar scalar) {
		scalar.findInverseReferencers(Literal, OmlPackage.Literals.LITERAL__TYPE)
	}

	// FacetedScalar

	static  def Iterable<FacetedScalarReference> findFacetedScalarReferencesWithScalar(FacetedScalar scalar) {
		scalar.findInverseReferencers(FacetedScalarReference, OmlPackage.Literals.FACETED_SCALAR_REFERENCE__SCALAR)
	}

	// EnumeratedScalar

	static  def Iterable<EnumeratedScalarReference> findEnumeratedScalarReferencesWithScalar(EnumeratedScalar scalar) {
		scalar.findInverseReferencers(EnumeratedScalarReference, OmlPackage.Literals.ENUMERATED_SCALAR_REFERENCE__SCALAR)
	}

	// Relation

	static  def Iterable<RelationReference> findRelationReferencesWithRelation(Relation relation) {
		relation.findInverseReferencers(RelationReference, OmlPackage.Literals.RELATION_REFERENCE__RELATION)
	}

	static def Iterable<RelationRestrictionAxiom> findRelationRestrictionAxiomsWithRelation(Relation relation) {
		relation.findInverseReferencers(RelationRestrictionAxiom, OmlPackage.Literals.RELATION_RESTRICTION_AXIOM__RELATION)
	}

	static def Iterable<LinkAssertion> findLinkAssertionsWithRelation(Relation relation) {
		relation.findInverseReferencers(LinkAssertion, OmlPackage.Literals.LINK_ASSERTION__RELATION)
	}

	static def Iterable<RelationPredicate> findRelationPredicatesWithRelation(Relation relation) {
		relation.findInverseReferencers(RelationPredicate, OmlPackage.Literals.RELATION_PREDICATE__RELATION)
	}

	// ForwardRelation

	// ReverseRelation

	// Rule

	static  def Iterable<RuleReference> findRuleReferencesWithRule(Rule rule) {
		rule.findInverseReferencers(RuleReference, OmlPackage.Literals.RULE_REFERENCE__RULE)
	}

	// Instance

	// StructureInstance

	// NamedInstance

	static def Iterable<RelationInstance> findRelationInstancesWithSource(NamedInstance instance) {
		instance.findInverseReferencers(RelationInstance, OmlPackage.Literals.RELATION_INSTANCE__SOURCE)
	}
	
	static def Iterable<RelationInstance> findRelationInstancesWithTarget(NamedInstance instance) {
		instance.findInverseReferencers(RelationInstance, OmlPackage.Literals.RELATION_INSTANCE__TARGET)
	}

	static def Iterable<LinkAssertion> findLinkAssertionsWithTarget(NamedInstance instance) {
		instance.findInverseReferencers(LinkAssertion, OmlPackage.Literals.LINK_ASSERTION__TARGET)
	}

	static def Iterable<RelationTargetRestrictionAxiom> findRelationTargetRestrictionAxiomsWithTarget(NamedInstance instance) {
		instance.findInverseReferencers(RelationTargetRestrictionAxiom, OmlPackage.Literals.RELATION_TARGET_RESTRICTION_AXIOM__TARGET)
	}

	// ConceptInstance

	static  def Iterable<ConceptInstanceReference> findConceptInstanceReferencesWithInstance(ConceptInstance instance) {
		instance.findInverseReferencers(ConceptInstanceReference, OmlPackage.Literals.CONCEPT_INSTANCE_REFERENCE__INSTANCE)
	}

	// RelationInstance

	static  def Iterable<RelationInstanceReference> findRelationInstanceReferencesWithInstance(RelationInstance instance) {
		instance.findInverseReferencers(RelationInstanceReference, OmlPackage.Literals.RELATION_INSTANCE_REFERENCE__INSTANCE)
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

	// RelationypeAssertion

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