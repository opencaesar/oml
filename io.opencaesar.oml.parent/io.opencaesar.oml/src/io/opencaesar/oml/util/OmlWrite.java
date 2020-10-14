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
package io.opencaesar.oml.util;

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.AnnotationPropertyReference;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.AspectReference;
import io.opencaesar.oml.BooleanLiteral;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.ConceptInstanceReference;
import io.opencaesar.oml.ConceptReference;
import io.opencaesar.oml.ConceptTypeAssertion;
import io.opencaesar.oml.DecimalLiteral;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.DescriptionBundleExtension;
import io.opencaesar.oml.DescriptionBundleInclusion;
import io.opencaesar.oml.DescriptionBundleUsage;
import io.opencaesar.oml.DescriptionExtension;
import io.opencaesar.oml.DescriptionUsage;
import io.opencaesar.oml.DifferentFromPredicate;
import io.opencaesar.oml.DoubleLiteral;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.EntityPredicate;
import io.opencaesar.oml.EnumeratedScalar;
import io.opencaesar.oml.EnumeratedScalarReference;
import io.opencaesar.oml.FacetedScalar;
import io.opencaesar.oml.FacetedScalarReference;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.IntegerLiteral;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.LinkAssertion;
import io.opencaesar.oml.OmlFactory;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.RelationCardinalityRestrictionAxiom;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;
import io.opencaesar.oml.RelationEntityReference;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.RelationInstanceReference;
import io.opencaesar.oml.RelationPredicate;
import io.opencaesar.oml.RelationRangeRestrictionAxiom;
import io.opencaesar.oml.RelationReference;
import io.opencaesar.oml.RelationTargetRestrictionAxiom;
import io.opencaesar.oml.RelationTypeAssertion;
import io.opencaesar.oml.ReverseRelation;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.RuleReference;
import io.opencaesar.oml.SameAsPredicate;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.ScalarPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyReference;
import io.opencaesar.oml.ScalarPropertyValueAssertion;
import io.opencaesar.oml.ScalarPropertyValueRestrictionAxiom;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructureReference;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.StructuredPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyReference;
import io.opencaesar.oml.StructuredPropertyValueAssertion;
import io.opencaesar.oml.StructuredPropertyValueRestrictionAxiom;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyBundle;
import io.opencaesar.oml.VocabularyBundleExtension;
import io.opencaesar.oml.VocabularyBundleInclusion;
import io.opencaesar.oml.VocabularyExtension;
import io.opencaesar.oml.VocabularyUsage;

public class OmlWrite {

	static final OmlFactory FACTORY = OmlFactory.eINSTANCE;

	public static OmlWrite INSTANCE = new OmlWrite();

	private OmlWrite() {
	}

	public <T extends Element> T create(final Class<T> type) {
		Element element = null;

		if (type == Annotation.class) {
			element = FACTORY.createAnnotation();
		}
		else if (type == Vocabulary.class) {
			element = FACTORY.createVocabulary();
		}
		else if (type == VocabularyBundle.class) {
			element = FACTORY.createVocabularyBundle();
		}
		else if (type == Description.class) {
			element = FACTORY.createDescription();
		}
		else if (type == DescriptionBundle.class) {
			element = FACTORY.createDescriptionBundle();
		}
		else if (type == Aspect.class) {
			element = FACTORY.createAspect();
		}
		else if (type == Concept.class) {
			element = FACTORY.createConcept();
		}
		else if (type == RelationEntity.class) {
			element = FACTORY.createRelationEntity();
		}
		else if (type == Structure.class) {
			element = FACTORY.createStructure();
		}
		else if (type == FacetedScalar.class) {
			element = FACTORY.createFacetedScalar();
		}
		else if (type == EnumeratedScalar.class) {
			element = FACTORY.createEnumeratedScalar();
		}
		else if (type == AnnotationProperty.class) {
			element = FACTORY.createAnnotationProperty();
		}
		else if (type == ScalarProperty.class) {
			element = FACTORY.createScalarProperty();
		}
		else if (type == StructuredProperty.class) {
			element = FACTORY.createStructuredProperty();
		}
		else if (type == ForwardRelation.class) {
			element = FACTORY.createForwardRelation();
		}
		else if (type == ReverseRelation.class) {
			element = FACTORY.createReverseRelation();
		}
		else if (type == Rule.class) {
			element = FACTORY.createRule();
		}
		else if (type == StructureInstance.class) {
			element = FACTORY.createStructureInstance();
		}
		else if (type == ConceptInstance.class) {
			element = FACTORY.createConceptInstance();
		}
		else if (type == RelationInstance.class) {
			element = FACTORY.createRelationInstance();
		}
		else if (type == AspectReference.class) {
			element = FACTORY.createAspectReference();
		}
		else if (type == ConceptReference.class) {
			element = FACTORY.createConceptReference();
		}
		else if (type == RelationEntityReference.class) {
			element = FACTORY.createRelationEntityReference();
		}
		else if (type == StructureReference.class) {
			element = FACTORY.createStructureReference();
		}
		else if (type == AnnotationPropertyReference.class) {
			element = FACTORY.createAnnotationPropertyReference();
		}
		else if (type == ScalarPropertyReference.class) {
			element = FACTORY.createScalarPropertyReference();
		}
		else if (type == StructuredPropertyReference.class) {
			element = FACTORY.createStructuredPropertyReference();
		}
		else if (type == FacetedScalarReference.class) {
			element = FACTORY.createFacetedScalarReference();
		}
		else if (type == EnumeratedScalarReference.class) {
			element = FACTORY.createEnumeratedScalarReference();
		}
		else if (type == RelationReference.class) {
			element = FACTORY.createRelationReference();
		}
		else if (type == RuleReference.class) {
			element = FACTORY.createRuleReference();
		}
		else if (type == ConceptInstanceReference.class) {
			element = FACTORY.createConceptInstanceReference();
		}
		else if (type == RelationInstanceReference.class) {
			element = FACTORY.createRelationInstanceReference();
		}
		else if (type == VocabularyExtension.class) {
			element = FACTORY.createVocabularyExtension();
		}
		else if (type == VocabularyUsage.class) {
			element = FACTORY.createVocabularyUsage();
		}
		else if (type == VocabularyBundleExtension.class) {
			element = FACTORY.createVocabularyBundleExtension();
		}
		else if (type == VocabularyBundleInclusion.class) {
			element = FACTORY.createVocabularyBundleInclusion();
		}
		else if (type == DescriptionExtension.class) {
			element = FACTORY.createDescriptionExtension();
		}
		else if (type == DescriptionUsage.class) {
			element = FACTORY.createDescriptionUsage();
		}
		else if (type == DescriptionBundleExtension.class) {
			element = FACTORY.createDescriptionBundleExtension();
		}
		else if (type == DescriptionBundleInclusion.class) {
			element = FACTORY.createDescriptionBundleInclusion();
		}
		else if (type == DescriptionBundleUsage.class) {
			element = FACTORY.createDescriptionBundleUsage();
		}
		else if (type == SpecializationAxiom.class) {
			element = FACTORY.createSpecializationAxiom();
		}
		else if (type == ScalarPropertyRangeRestrictionAxiom.class) {
			element = FACTORY.createScalarPropertyRangeRestrictionAxiom();
		}
		else if (type == ScalarPropertyCardinalityRestrictionAxiom.class) {
			element = FACTORY.createScalarPropertyCardinalityRestrictionAxiom();
		}
		else if (type == ScalarPropertyValueRestrictionAxiom.class) {
			element = FACTORY.createScalarPropertyValueRestrictionAxiom();
		}
		else if (type == StructuredPropertyRangeRestrictionAxiom.class) {
			element = FACTORY.createStructuredPropertyRangeRestrictionAxiom();
		}
		else if (type == StructuredPropertyCardinalityRestrictionAxiom.class) {
			element = FACTORY.createStructuredPropertyCardinalityRestrictionAxiom();
		}
		else if (type == StructuredPropertyValueRestrictionAxiom.class) {
			element = FACTORY.createStructuredPropertyValueRestrictionAxiom();
		}
		else if (type == RelationRangeRestrictionAxiom.class) {
			element = FACTORY.createRelationRangeRestrictionAxiom();
		}
		else if (type == RelationCardinalityRestrictionAxiom.class) {
			element = FACTORY.createRelationCardinalityRestrictionAxiom();
		}
		else if (type == RelationTargetRestrictionAxiom.class) {
			element = FACTORY.createRelationTargetRestrictionAxiom();
		}
		else if (type == KeyAxiom.class) {
			element = FACTORY.createKeyAxiom();
		}
		else if (type == ConceptTypeAssertion.class) {
			element = FACTORY.createConceptTypeAssertion();
		}

		else if (type == RelationTypeAssertion.class) {
			element = FACTORY.createRelationTypeAssertion();
		}
		else if (type == ScalarPropertyValueAssertion.class) {
			element = FACTORY.createScalarPropertyValueAssertion();
		}
		else if (type == StructuredPropertyValueAssertion.class) {
			element = FACTORY.createStructuredPropertyValueAssertion();
		}
		else if (type == LinkAssertion.class) {
			element = FACTORY.createLinkAssertion();
		}
		else if (type == EntityPredicate.class) {
			element = FACTORY.createEntityPredicate();
		}
		else if (type == RelationPredicate.class) {
			element = FACTORY.createRelationPredicate();
		}
		else if (type == SameAsPredicate.class) {
			element = FACTORY.createSameAsPredicate();
		}
		else if (type == DifferentFromPredicate.class) {
			element = FACTORY.createDifferentFromPredicate();
		}
		else if (type == RelationEntityPredicate.class) {
			element = FACTORY.createRelationEntityPredicate();
		}
		else if (type == QuotedLiteral.class) {
			element = FACTORY.createQuotedLiteral();
		}
		else if (type == IntegerLiteral.class) {
			element = FACTORY.createIntegerLiteral();
		}
		else if (type == DecimalLiteral.class) {
			element = FACTORY.createDecimalLiteral();
		}
		else if (type == DoubleLiteral.class) {
			element = FACTORY.createDoubleLiteral();
		}
		else if (type == BooleanLiteral.class) {
			element = FACTORY.createBooleanLiteral();
		}
		
		return type.cast(element);
	}
}