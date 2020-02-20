/** 
 * Copyright 2019 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.opencaesar.oml.util;

import io.opencaesar.oml.*;

public class OmlVisitor<T> extends OmlSwitch<T> {

	@Override
	public T caseElement(Element object) {
		return null;
	}

	@Override
	public T caseAnnotation(Annotation object) {
		return null;
	}

	@Override
	public T caseAnnotatedElement(AnnotatedElement object) {
		return null;
	}

	@Override
	public T caseIdentifiedElement(IdentifiedElement object) {
		return null;
	}

	@Override
	public T caseOntology(Ontology object) {
		return null;
	}

	@Override
	public T caseTerminology(Terminology object) {
		return null;
	}

	@Override
	public T caseVocabulary(Vocabulary object) {
		return null;
	}

	@Override
	public T caseBundle(Bundle object) {
		return null;
	}

	@Override
	public T caseDescription(Description object) {
		return null;
	}

	@Override
	public T caseMember(Member object) {
		return null;
	}

	@Override
	public T caseTerm(Term object) {
		return null;
	}

	@Override
	public T caseSpecializableTerm(SpecializableTerm object) {
		return null;
	}

	@Override
	public T caseType(Type object) {
		return null;
	}

	@Override
	public T caseClassifier(Classifier object) {
		return null;
	}

	@Override
	public T caseEntity(Entity object) {
		return null;
	}

	@Override
	public T caseAspect(Aspect object) {
		return null;
	}

	@Override
	public T caseConcept(Concept object) {
		return null;
	}

	@Override
	public T caseRelationEntity(RelationEntity object) {
		return null;
	}

	@Override
	public T caseStructure(Structure object) {
		return null;
	}

	@Override
	public T caseProperty(Property object) {
		return null;
	}

	@Override
	public T caseAnnotationProperty(AnnotationProperty object) {
		return null;
	}

	@Override
	public T caseFeatureProperty(FeatureProperty object) {
		return null;
	}

	@Override
	public T caseScalarProperty(ScalarProperty object) {
		return null;
	}

	@Override
	public T caseStructuredProperty(StructuredProperty object) {
		return null;
	}

	@Override
	public T caseScalar(Scalar object) {
		return null;
	}

	@Override
	public T caseFacetedScalar(FacetedScalar object) {
		return null;
	}

	@Override
	public T caseEnumeratedScalar(EnumeratedScalar object) {
		return null;
	}

	@Override
	public T caseRelation(Relation object) {
		return null;
	}

	@Override
	public T caseForwardRelation(ForwardRelation object) {
		return null;
	}

	@Override
	public T caseInverseRelation(InverseRelation object) {
		return null;
	}

	@Override
	public T caseRule(Rule object) {
		return null;
	}

	@Override
	public T caseInstance(Instance object) {
		return null;
	}

	@Override
	public T caseStructureInstance(StructureInstance object) {
		return null;
	}

	@Override
	public T caseNamedInstance(NamedInstance object) {
		return null;
	}

	@Override
	public T caseConceptInstance(ConceptInstance object) {
		return null;
	}

	@Override
	public T caseRelationInstance(RelationInstance object) {
		return null;
	}

	@Override
	public T caseReference(Reference object) {
		return null;
	}

	@Override
	public T caseVocabularyMemberReference(VocabularyMemberReference object) {
		return null;
	}

	@Override
	public T caseSpecializableTermReference(SpecializableTermReference object) {
		return null;
	}

	@Override
	public T caseClassifierReference(ClassifierReference object) {
		return null;
	}

	@Override
	public T caseEntityReference(EntityReference object) {
		return null;
	}

	@Override
	public T caseAspectReference(AspectReference object) {
		return null;
	}

	@Override
	public T caseConceptReference(ConceptReference object) {
		return null;
	}

	@Override
	public T caseRelationEntityReference(RelationEntityReference object) {
		return null;
	}

	@Override
	public T caseStructureReference(StructureReference object) {
		return null;
	}

	@Override
	public T caseAnnotationPropertyReference(AnnotationPropertyReference object) {
		return null;
	}

	@Override
	public T caseScalarPropertyReference(ScalarPropertyReference object) {
		return null;
	}

	@Override
	public T caseStructuredPropertyReference(StructuredPropertyReference object) {
		return null;
	}

	@Override
	public T caseFacetedScalarReference(FacetedScalarReference object) {
		return null;
	}

	@Override
	public T caseEnumeratedScalarReference(EnumeratedScalarReference object) {
		return null;
	}

	@Override
	public T caseRelationReference(RelationReference object) {
		return null;
	}

	@Override
	public T caseRuleReference(RuleReference object) {
		return null;
	}

	@Override
	public T caseDescriptionMemberReference(DescriptionMemberReference object) {
		return null;
	}

	@Override
	public T caseNamedInstanceReference(NamedInstanceReference object) {
		return null;
	}

	@Override
	public T caseConceptInstanceReference(ConceptInstanceReference object) {
		return null;
	}

	@Override
	public T caseRelationInstanceReference(RelationInstanceReference object) {
		return null;
	}

	@Override
	public T caseStatement(Statement object) {
		return null;
	}

	@Override
	public T caseVocabularyStatement(VocabularyStatement object) {
		return null;
	}

	@Override
	public T caseDescriptionStatement(DescriptionStatement object) {
		return null;
	}

	@Override
	public T caseImport(Import object) {
		return null;
	}

	@Override
	public T caseVocabularyImport(VocabularyImport object) {
		return null;
	}

	@Override
	public T caseVocabularyExtension(VocabularyExtension object) {
		return null;
	}

	@Override
	public T caseBundleImport(BundleImport object) {
		return null;
	}

	@Override
	public T caseBundleInclusion(BundleInclusion object) {
		return null;
	}

	@Override
	public T caseBundleExtension(BundleExtension object) {
		return null;
	}

	@Override
	public T caseDescriptionImport(DescriptionImport object) {
		return null;
	}

	@Override
	public T caseDescriptionUsage(DescriptionUsage object) {
		return null;
	}

	@Override
	public T caseDescriptionExtension(DescriptionExtension object) {
		return null;
	}

	@Override
	public T caseAxiom(Axiom object) {
		return null;
	}

	@Override
	public T caseSpecializationAxiom(SpecializationAxiom object) {
		return null;
	}

	@Override
	public T caseRestrictionAxiom(RestrictionAxiom object) {
		return null;
	}

	@Override
	public T casePropertyRestrictionAxiom(PropertyRestrictionAxiom object) {
		return null;
	}

	@Override
	public T caseScalarPropertyRestrictionAxiom(ScalarPropertyRestrictionAxiom object) {
		return null;
	}

	@Override
	public T caseScalarPropertyRangeRestrictionAxiom(ScalarPropertyRangeRestrictionAxiom object) {
		return null;
	}

	@Override
	public T caseScalarPropertyValueRestrictionAxiom(ScalarPropertyValueRestrictionAxiom object) {
		return null;
	}

	@Override
	public T caseStructuredPropertyRestrictionAxiom(StructuredPropertyRestrictionAxiom object) {
		return null;
	}

	@Override
	public T caseStructuredPropertyRangeRestrictionAxiom(StructuredPropertyRangeRestrictionAxiom object) {
		return null;
	}

	@Override
	public T caseStructuredPropertyValueRestrictionAxiom(StructuredPropertyValueRestrictionAxiom object) {
		return null;
	}

	@Override
	public T caseRelationRestrictionAxiom(RelationRestrictionAxiom object) {
		return null;
	}

	@Override
	public T caseRelationRangeRestrictionAxiom(RelationRangeRestrictionAxiom object) {
		return null;
	}

	@Override
	public T caseRelationCardinalityRestrictionAxiom(RelationCardinalityRestrictionAxiom object) {
		return null;
	}

	@Override
	public T caseKeyAxiom(KeyAxiom object) {
		return null;
	}

	@Override
	public T caseAssertion(Assertion object) {
		return null;
	}

	@Override
	public T caseTypeAssertion(TypeAssertion object) {
		return null;
	}

	@Override
	public T caseConceptTypeAssertion(ConceptTypeAssertion object) {
		return null;
	}

	@Override
	public T caseRelationTypeAssertion(RelationTypeAssertion object) {
		return null;
	}

	@Override
	public T casePropertyValueAssertion(PropertyValueAssertion object) {
		return null;
	}

	@Override
	public T caseScalarPropertyValueAssertion(ScalarPropertyValueAssertion object) {
		return null;
	}

	@Override
	public T caseStructuredPropertyValueAssertion(StructuredPropertyValueAssertion object) {
		return null;
	}

	@Override
	public T caseLinkAssertion(LinkAssertion object) {
		return null;
	}

	@Override
	public T casePredicate(Predicate object) {
		return null;
	}

	@Override
	public T caseUnaryPredicate(UnaryPredicate object) {
		return null;
	}

	@Override
	public T caseEntityPredicate(EntityPredicate object) {
		return null;
	}

	@Override
	public T caseBinaryPredicate(BinaryPredicate object) {
		return null;
	}

	@Override
	public T caseRelationEntityPredicate(RelationEntityPredicate object) {
		return null;
	}

	@Override
	public T caseRelationPredicate(RelationPredicate object) {
		return null;
	}

	@Override
	public T caseLiteral(Literal object) {
		return null;
	}

	@Override
	public T caseQuotedLiteral(QuotedLiteral object) {
		return null;
	}

	@Override
	public T caseIntegerLiteral(IntegerLiteral object) {
		return null;
	}

	@Override
	public T caseDecimalLiteral(DecimalLiteral object) {
		return null;
	}

	@Override
	public T caseDoubleLiteral(DoubleLiteral object) {
		return null;
	}

	@Override
	public T caseBooleanLiteral(BooleanLiteral object) {
		return null;
	}

}
