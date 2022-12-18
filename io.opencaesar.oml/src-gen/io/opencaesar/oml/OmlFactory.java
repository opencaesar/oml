/**
 * 
 * Copyright 2019-2022 California Institute of Technology ("Caltech").
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
package io.opencaesar.oml;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see io.opencaesar.oml.OmlPackage
 * @generated
 */
public interface OmlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OmlFactory eINSTANCE = io.opencaesar.oml.impl.OmlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation</em>'.
	 * @generated
	 */
	Annotation createAnnotation();

	/**
	 * Returns a new object of class '<em>Vocabulary</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vocabulary</em>'.
	 * @generated
	 */
	Vocabulary createVocabulary();

	/**
	 * Returns a new object of class '<em>Vocabulary Bundle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vocabulary Bundle</em>'.
	 * @generated
	 */
	VocabularyBundle createVocabularyBundle();

	/**
	 * Returns a new object of class '<em>Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Description</em>'.
	 * @generated
	 */
	Description createDescription();

	/**
	 * Returns a new object of class '<em>Description Bundle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Description Bundle</em>'.
	 * @generated
	 */
	DescriptionBundle createDescriptionBundle();

	/**
	 * Returns a new object of class '<em>Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension</em>'.
	 * @generated
	 */
	Extension createExtension();

	/**
	 * Returns a new object of class '<em>Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Usage</em>'.
	 * @generated
	 */
	Usage createUsage();

	/**
	 * Returns a new object of class '<em>Inclusion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inclusion</em>'.
	 * @generated
	 */
	Inclusion createInclusion();

	/**
	 * Returns a new object of class '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule</em>'.
	 * @generated
	 */
	Rule createRule();

	/**
	 * Returns a new object of class '<em>Structure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structure</em>'.
	 * @generated
	 */
	Structure createStructure();

	/**
	 * Returns a new object of class '<em>Aspect</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aspect</em>'.
	 * @generated
	 */
	Aspect createAspect();

	/**
	 * Returns a new object of class '<em>Concept</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concept</em>'.
	 * @generated
	 */
	Concept createConcept();

	/**
	 * Returns a new object of class '<em>Relation Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Entity</em>'.
	 * @generated
	 */
	RelationEntity createRelationEntity();

	/**
	 * Returns a new object of class '<em>Faceted Scalar</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Faceted Scalar</em>'.
	 * @generated
	 */
	FacetedScalar createFacetedScalar();

	/**
	 * Returns a new object of class '<em>Enumerated Scalar</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumerated Scalar</em>'.
	 * @generated
	 */
	EnumeratedScalar createEnumeratedScalar();

	/**
	 * Returns a new object of class '<em>Annotation Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation Property</em>'.
	 * @generated
	 */
	AnnotationProperty createAnnotationProperty();

	/**
	 * Returns a new object of class '<em>Scalar Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scalar Property</em>'.
	 * @generated
	 */
	ScalarProperty createScalarProperty();

	/**
	 * Returns a new object of class '<em>Structured Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structured Property</em>'.
	 * @generated
	 */
	StructuredProperty createStructuredProperty();

	/**
	 * Returns a new object of class '<em>Forward Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Forward Relation</em>'.
	 * @generated
	 */
	ForwardRelation createForwardRelation();

	/**
	 * Returns a new object of class '<em>Reverse Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reverse Relation</em>'.
	 * @generated
	 */
	ReverseRelation createReverseRelation();

	/**
	 * Returns a new object of class '<em>Unreified Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unreified Relation</em>'.
	 * @generated
	 */
	UnreifiedRelation createUnreifiedRelation();

	/**
	 * Returns a new object of class '<em>Concept Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concept Instance</em>'.
	 * @generated
	 */
	ConceptInstance createConceptInstance();

	/**
	 * Returns a new object of class '<em>Relation Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Instance</em>'.
	 * @generated
	 */
	RelationInstance createRelationInstance();

	/**
	 * Returns a new object of class '<em>Structure Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structure Instance</em>'.
	 * @generated
	 */
	StructureInstance createStructureInstance();

	/**
	 * Returns a new object of class '<em>Key Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Key Axiom</em>'.
	 * @generated
	 */
	KeyAxiom createKeyAxiom();

	/**
	 * Returns a new object of class '<em>Specialization Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specialization Axiom</em>'.
	 * @generated
	 */
	SpecializationAxiom createSpecializationAxiom();

	/**
	 * Returns a new object of class '<em>Scalar Property Range Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scalar Property Range Restriction Axiom</em>'.
	 * @generated
	 */
	ScalarPropertyRangeRestrictionAxiom createScalarPropertyRangeRestrictionAxiom();

	/**
	 * Returns a new object of class '<em>Scalar Property Cardinality Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scalar Property Cardinality Restriction Axiom</em>'.
	 * @generated
	 */
	ScalarPropertyCardinalityRestrictionAxiom createScalarPropertyCardinalityRestrictionAxiom();

	/**
	 * Returns a new object of class '<em>Scalar Property Value Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scalar Property Value Restriction Axiom</em>'.
	 * @generated
	 */
	ScalarPropertyValueRestrictionAxiom createScalarPropertyValueRestrictionAxiom();

	/**
	 * Returns a new object of class '<em>Structured Property Range Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structured Property Range Restriction Axiom</em>'.
	 * @generated
	 */
	StructuredPropertyRangeRestrictionAxiom createStructuredPropertyRangeRestrictionAxiom();

	/**
	 * Returns a new object of class '<em>Structured Property Cardinality Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structured Property Cardinality Restriction Axiom</em>'.
	 * @generated
	 */
	StructuredPropertyCardinalityRestrictionAxiom createStructuredPropertyCardinalityRestrictionAxiom();

	/**
	 * Returns a new object of class '<em>Structured Property Value Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structured Property Value Restriction Axiom</em>'.
	 * @generated
	 */
	StructuredPropertyValueRestrictionAxiom createStructuredPropertyValueRestrictionAxiom();

	/**
	 * Returns a new object of class '<em>Relation Range Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Range Restriction Axiom</em>'.
	 * @generated
	 */
	RelationRangeRestrictionAxiom createRelationRangeRestrictionAxiom();

	/**
	 * Returns a new object of class '<em>Relation Cardinality Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Cardinality Restriction Axiom</em>'.
	 * @generated
	 */
	RelationCardinalityRestrictionAxiom createRelationCardinalityRestrictionAxiom();

	/**
	 * Returns a new object of class '<em>Relation Target Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Target Restriction Axiom</em>'.
	 * @generated
	 */
	RelationTargetRestrictionAxiom createRelationTargetRestrictionAxiom();

	/**
	 * Returns a new object of class '<em>Concept Type Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concept Type Assertion</em>'.
	 * @generated
	 */
	ConceptTypeAssertion createConceptTypeAssertion();

	/**
	 * Returns a new object of class '<em>Relation Type Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Type Assertion</em>'.
	 * @generated
	 */
	RelationTypeAssertion createRelationTypeAssertion();

	/**
	 * Returns a new object of class '<em>Scalar Property Value Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scalar Property Value Assertion</em>'.
	 * @generated
	 */
	ScalarPropertyValueAssertion createScalarPropertyValueAssertion();

	/**
	 * Returns a new object of class '<em>Structured Property Value Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structured Property Value Assertion</em>'.
	 * @generated
	 */
	StructuredPropertyValueAssertion createStructuredPropertyValueAssertion();

	/**
	 * Returns a new object of class '<em>Link Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Assertion</em>'.
	 * @generated
	 */
	LinkAssertion createLinkAssertion();

	/**
	 * Returns a new object of class '<em>Type Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Predicate</em>'.
	 * @generated
	 */
	TypePredicate createTypePredicate();

	/**
	 * Returns a new object of class '<em>Relation Entity Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Entity Predicate</em>'.
	 * @generated
	 */
	RelationEntityPredicate createRelationEntityPredicate();

	/**
	 * Returns a new object of class '<em>Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Predicate</em>'.
	 * @generated
	 */
	PropertyPredicate createPropertyPredicate();

	/**
	 * Returns a new object of class '<em>Same As Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Same As Predicate</em>'.
	 * @generated
	 */
	SameAsPredicate createSameAsPredicate();

	/**
	 * Returns a new object of class '<em>Different From Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Different From Predicate</em>'.
	 * @generated
	 */
	DifferentFromPredicate createDifferentFromPredicate();

	/**
	 * Returns a new object of class '<em>Quoted Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quoted Literal</em>'.
	 * @generated
	 */
	QuotedLiteral createQuotedLiteral();

	/**
	 * Returns a new object of class '<em>Integer Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Literal</em>'.
	 * @generated
	 */
	IntegerLiteral createIntegerLiteral();

	/**
	 * Returns a new object of class '<em>Decimal Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Decimal Literal</em>'.
	 * @generated
	 */
	DecimalLiteral createDecimalLiteral();

	/**
	 * Returns a new object of class '<em>Double Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Literal</em>'.
	 * @generated
	 */
	DoubleLiteral createDoubleLiteral();

	/**
	 * Returns a new object of class '<em>Boolean Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Literal</em>'.
	 * @generated
	 */
	BooleanLiteral createBooleanLiteral();

	/**
	 * Returns a new object of class '<em>Aspect Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aspect Reference</em>'.
	 * @generated
	 */
	AspectReference createAspectReference();

	/**
	 * Returns a new object of class '<em>Concept Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concept Reference</em>'.
	 * @generated
	 */
	ConceptReference createConceptReference();

	/**
	 * Returns a new object of class '<em>Relation Entity Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Entity Reference</em>'.
	 * @generated
	 */
	RelationEntityReference createRelationEntityReference();

	/**
	 * Returns a new object of class '<em>Structure Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structure Reference</em>'.
	 * @generated
	 */
	StructureReference createStructureReference();

	/**
	 * Returns a new object of class '<em>Annotation Property Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation Property Reference</em>'.
	 * @generated
	 */
	AnnotationPropertyReference createAnnotationPropertyReference();

	/**
	 * Returns a new object of class '<em>Scalar Property Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scalar Property Reference</em>'.
	 * @generated
	 */
	ScalarPropertyReference createScalarPropertyReference();

	/**
	 * Returns a new object of class '<em>Structured Property Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structured Property Reference</em>'.
	 * @generated
	 */
	StructuredPropertyReference createStructuredPropertyReference();

	/**
	 * Returns a new object of class '<em>Faceted Scalar Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Faceted Scalar Reference</em>'.
	 * @generated
	 */
	FacetedScalarReference createFacetedScalarReference();

	/**
	 * Returns a new object of class '<em>Enumerated Scalar Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumerated Scalar Reference</em>'.
	 * @generated
	 */
	EnumeratedScalarReference createEnumeratedScalarReference();

	/**
	 * Returns a new object of class '<em>Relation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Reference</em>'.
	 * @generated
	 */
	RelationReference createRelationReference();

	/**
	 * Returns a new object of class '<em>Rule Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Reference</em>'.
	 * @generated
	 */
	RuleReference createRuleReference();

	/**
	 * Returns a new object of class '<em>Concept Instance Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concept Instance Reference</em>'.
	 * @generated
	 */
	ConceptInstanceReference createConceptInstanceReference();

	/**
	 * Returns a new object of class '<em>Relation Instance Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Instance Reference</em>'.
	 * @generated
	 */
	RelationInstanceReference createRelationInstanceReference();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OmlPackage getOmlPackage();

} //OmlFactory
