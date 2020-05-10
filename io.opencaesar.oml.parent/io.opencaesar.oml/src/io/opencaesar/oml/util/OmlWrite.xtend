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
import io.opencaesar.oml.BooleanLiteral
import io.opencaesar.oml.Bundle
import io.opencaesar.oml.BundleExtension
import io.opencaesar.oml.BundleInclusion
import io.opencaesar.oml.Concept
import io.opencaesar.oml.ConceptInstance
import io.opencaesar.oml.ConceptInstanceReference
import io.opencaesar.oml.ConceptReference
import io.opencaesar.oml.ConceptTypeAssertion
import io.opencaesar.oml.DecimalLiteral
import io.opencaesar.oml.Description
import io.opencaesar.oml.DescriptionExtension
import io.opencaesar.oml.DescriptionUsage
import io.opencaesar.oml.DifferentFromPredicate
import io.opencaesar.oml.DoubleLiteral
import io.opencaesar.oml.EntityPredicate
import io.opencaesar.oml.EnumeratedScalar
import io.opencaesar.oml.EnumeratedScalarReference
import io.opencaesar.oml.FacetedScalar
import io.opencaesar.oml.FacetedScalarReference
import io.opencaesar.oml.ForwardRelation
import io.opencaesar.oml.IntegerLiteral
import io.opencaesar.oml.KeyAxiom
import io.opencaesar.oml.LinkAssertion
import io.opencaesar.oml.OmlFactory
import io.opencaesar.oml.QuotedLiteral
import io.opencaesar.oml.RelationCardinalityRestrictionAxiom
import io.opencaesar.oml.RelationEntity
import io.opencaesar.oml.RelationEntityPredicate
import io.opencaesar.oml.RelationEntityReference
import io.opencaesar.oml.RelationInstance
import io.opencaesar.oml.RelationInstanceReference
import io.opencaesar.oml.RelationPredicate
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
import io.opencaesar.oml.SpecializationAxiom
import io.opencaesar.oml.Structure
import io.opencaesar.oml.StructureInstance
import io.opencaesar.oml.StructureReference
import io.opencaesar.oml.StructuredProperty
import io.opencaesar.oml.StructuredPropertyCardinalityRestrictionAxiom
import io.opencaesar.oml.StructuredPropertyRangeRestrictionAxiom
import io.opencaesar.oml.StructuredPropertyReference
import io.opencaesar.oml.StructuredPropertyValueAssertion
import io.opencaesar.oml.StructuredPropertyValueRestrictionAxiom
import io.opencaesar.oml.Vocabulary
import io.opencaesar.oml.VocabularyExtension
import io.opencaesar.oml.VocabularyUsage

class OmlWrite {
	
	static val factory = OmlFactory.eINSTANCE
	
	public static val INSTANCE = new OmlWrite
	
	private new() {}
	
	def <T> T create(Class<T> type) {
		switch(type) {
			case Annotation: factory.createAnnotation
			case Vocabulary: factory.createVocabulary
			case Bundle: factory.createBundle
			case Description: factory.createDescription
			case Aspect: factory.createAspect
			case Concept: factory.createConcept
			case RelationEntity: factory.createRelationEntity
			case Structure: factory.createStructure
			case FacetedScalar: factory.createFacetedScalar
			case EnumeratedScalar: factory.createEnumeratedScalar
			case AnnotationProperty: factory.createAnnotationProperty
			case ScalarProperty: factory.createScalarProperty
			case StructuredProperty: factory.createStructuredProperty
			case ForwardRelation: factory.createForwardRelation
			case ReverseRelation: factory.createReverseRelation
			case Rule: factory.createRule
			case StructureInstance: factory.createStructureInstance
			case ConceptInstance: factory.createConceptInstance
			case RelationInstance: factory.createRelationInstance
			case AspectReference: factory.createAspectReference
			case ConceptReference: factory.createConceptReference
			case RelationEntityReference: factory.createRelationEntityReference
			case StructureReference: factory.createStructureReference
			case AnnotationPropertyReference: factory.createAnnotationPropertyReference
			case ScalarPropertyReference: factory.createScalarPropertyReference
			case StructuredPropertyReference: factory.createStructuredPropertyReference
			case FacetedScalarReference: factory.createFacetedScalarReference
			case EnumeratedScalarReference: factory.createEnumeratedScalarReference
			case RelationReference: factory.createRelationReference
			case RuleReference: factory.createRuleReference
			case ConceptInstanceReference: factory.createConceptInstanceReference
			case RelationInstanceReference: factory.createRelationInstanceReference
			case VocabularyExtension: factory.createVocabularyExtension
			case VocabularyUsage: factory.createVocabularyUsage
			case BundleInclusion: factory.createBundleInclusion
			case BundleExtension: factory.createBundleExtension
			case DescriptionUsage: factory.createDescriptionUsage
			case DescriptionExtension: factory.createDescriptionExtension
			case SpecializationAxiom: factory.createSpecializationAxiom
			case ScalarPropertyRangeRestrictionAxiom: factory.createScalarPropertyRangeRestrictionAxiom
			case ScalarPropertyCardinalityRestrictionAxiom: factory.createScalarPropertyCardinalityRestrictionAxiom
			case ScalarPropertyValueRestrictionAxiom: factory.createScalarPropertyValueRestrictionAxiom
			case StructuredPropertyRangeRestrictionAxiom: factory.createStructuredPropertyRangeRestrictionAxiom
			case StructuredPropertyCardinalityRestrictionAxiom: factory.createStructuredPropertyCardinalityRestrictionAxiom
			case StructuredPropertyValueRestrictionAxiom: factory.createStructuredPropertyValueRestrictionAxiom
			case RelationRangeRestrictionAxiom: factory.createRelationRangeRestrictionAxiom
			case RelationCardinalityRestrictionAxiom: factory.createRelationCardinalityRestrictionAxiom
			case RelationTargetRestrictionAxiom: factory.createRelationTargetRestrictionAxiom
			case KeyAxiom: factory.createKeyAxiom
			case ConceptTypeAssertion: factory.createConceptTypeAssertion
			case RelationTypeAssertion: factory.createRelationTypeAssertion
			case ScalarPropertyValueAssertion: factory.createScalarPropertyValueAssertion
			case StructuredPropertyValueAssertion: factory.createStructuredPropertyValueAssertion
			case LinkAssertion: factory.createLinkAssertion
			case EntityPredicate: factory.createEntityPredicate
			case RelationPredicate: factory.createRelationPredicate
			case SameAsPredicate: factory.createSameAsPredicate
			case DifferentFromPredicate: factory.createDifferentFromPredicate
			case RelationEntityPredicate: factory.createRelationEntityPredicate
			case QuotedLiteral: factory.createQuotedLiteral
			case IntegerLiteral: factory.createIntegerLiteral
			case DecimalLiteral: factory.createDecimalLiteral
			case DoubleLiteral: factory.createDoubleLiteral
			case BooleanLiteral: factory.createBooleanLiteral
		} as T
	}
}