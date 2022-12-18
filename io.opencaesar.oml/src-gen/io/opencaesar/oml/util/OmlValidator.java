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
package io.opencaesar.oml.util;

import io.opencaesar.oml.*;

import java.math.BigDecimal;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see io.opencaesar.oml.OmlPackage
 * @generated
 */
public class OmlValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final OmlValidator INSTANCE = new OmlValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "io.opencaesar.oml";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Extra Validate' of 'Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ELEMENT__EXTRA_VALIDATE = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMLTypeValidator xmlTypeValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OmlValidator() {
		super();
		xmlTypeValidator = XMLTypeValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return OmlPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case OmlPackage.ELEMENT:
				return validateElement((Element)value, diagnostics, context);
			case OmlPackage.ANNOTATION:
				return validateAnnotation((Annotation)value, diagnostics, context);
			case OmlPackage.IDENTIFIED_ELEMENT:
				return validateIdentifiedElement((IdentifiedElement)value, diagnostics, context);
			case OmlPackage.IMPORT:
				return validateImport((Import)value, diagnostics, context);
			case OmlPackage.INSTANCE:
				return validateInstance((Instance)value, diagnostics, context);
			case OmlPackage.STATEMENT:
				return validateStatement((Statement)value, diagnostics, context);
			case OmlPackage.AXIOM:
				return validateAxiom((Axiom)value, diagnostics, context);
			case OmlPackage.ASSERTION:
				return validateAssertion((Assertion)value, diagnostics, context);
			case OmlPackage.PREDICATE:
				return validatePredicate((Predicate)value, diagnostics, context);
			case OmlPackage.LITERAL:
				return validateLiteral((Literal)value, diagnostics, context);
			case OmlPackage.ONTOLOGY:
				return validateOntology((Ontology)value, diagnostics, context);
			case OmlPackage.MEMBER:
				return validateMember((Member)value, diagnostics, context);
			case OmlPackage.VOCABULARY_BOX:
				return validateVocabularyBox((VocabularyBox)value, diagnostics, context);
			case OmlPackage.DESCRIPTION_BOX:
				return validateDescriptionBox((DescriptionBox)value, diagnostics, context);
			case OmlPackage.VOCABULARY:
				return validateVocabulary((Vocabulary)value, diagnostics, context);
			case OmlPackage.VOCABULARY_BUNDLE:
				return validateVocabularyBundle((VocabularyBundle)value, diagnostics, context);
			case OmlPackage.DESCRIPTION:
				return validateDescription((Description)value, diagnostics, context);
			case OmlPackage.DESCRIPTION_BUNDLE:
				return validateDescriptionBundle((DescriptionBundle)value, diagnostics, context);
			case OmlPackage.EXTENSION:
				return validateExtension((Extension)value, diagnostics, context);
			case OmlPackage.USAGE:
				return validateUsage((Usage)value, diagnostics, context);
			case OmlPackage.INCLUSION:
				return validateInclusion((Inclusion)value, diagnostics, context);
			case OmlPackage.VOCABULARY_STATEMENT:
				return validateVocabularyStatement((VocabularyStatement)value, diagnostics, context);
			case OmlPackage.DESCRIPTION_STATEMENT:
				return validateDescriptionStatement((DescriptionStatement)value, diagnostics, context);
			case OmlPackage.VOCABULARY_MEMBER:
				return validateVocabularyMember((VocabularyMember)value, diagnostics, context);
			case OmlPackage.DESCRIPTION_MEMBER:
				return validateDescriptionMember((DescriptionMember)value, diagnostics, context);
			case OmlPackage.TERM:
				return validateTerm((Term)value, diagnostics, context);
			case OmlPackage.RULE:
				return validateRule((Rule)value, diagnostics, context);
			case OmlPackage.SPECIALIZABLE_TERM:
				return validateSpecializableTerm((SpecializableTerm)value, diagnostics, context);
			case OmlPackage.PROPERTY:
				return validateProperty((Property)value, diagnostics, context);
			case OmlPackage.TYPE:
				return validateType((Type)value, diagnostics, context);
			case OmlPackage.RELATION_BASE:
				return validateRelationBase((RelationBase)value, diagnostics, context);
			case OmlPackage.CLASSIFIER:
				return validateClassifier((Classifier)value, diagnostics, context);
			case OmlPackage.SCALAR:
				return validateScalar((Scalar)value, diagnostics, context);
			case OmlPackage.ENTITY:
				return validateEntity((Entity)value, diagnostics, context);
			case OmlPackage.STRUCTURE:
				return validateStructure((Structure)value, diagnostics, context);
			case OmlPackage.ASPECT:
				return validateAspect((Aspect)value, diagnostics, context);
			case OmlPackage.CONCEPT:
				return validateConcept((Concept)value, diagnostics, context);
			case OmlPackage.RELATION_ENTITY:
				return validateRelationEntity((RelationEntity)value, diagnostics, context);
			case OmlPackage.FACETED_SCALAR:
				return validateFacetedScalar((FacetedScalar)value, diagnostics, context);
			case OmlPackage.ENUMERATED_SCALAR:
				return validateEnumeratedScalar((EnumeratedScalar)value, diagnostics, context);
			case OmlPackage.ANNOTATION_PROPERTY:
				return validateAnnotationProperty((AnnotationProperty)value, diagnostics, context);
			case OmlPackage.SEMANTIC_PROPERTY:
				return validateSemanticProperty((SemanticProperty)value, diagnostics, context);
			case OmlPackage.SCALAR_PROPERTY:
				return validateScalarProperty((ScalarProperty)value, diagnostics, context);
			case OmlPackage.STRUCTURED_PROPERTY:
				return validateStructuredProperty((StructuredProperty)value, diagnostics, context);
			case OmlPackage.RELATION:
				return validateRelation((Relation)value, diagnostics, context);
			case OmlPackage.FORWARD_RELATION:
				return validateForwardRelation((ForwardRelation)value, diagnostics, context);
			case OmlPackage.REVERSE_RELATION:
				return validateReverseRelation((ReverseRelation)value, diagnostics, context);
			case OmlPackage.UNREIFIED_RELATION:
				return validateUnreifiedRelation((UnreifiedRelation)value, diagnostics, context);
			case OmlPackage.NAMED_INSTANCE:
				return validateNamedInstance((NamedInstance)value, diagnostics, context);
			case OmlPackage.CONCEPT_INSTANCE:
				return validateConceptInstance((ConceptInstance)value, diagnostics, context);
			case OmlPackage.RELATION_INSTANCE:
				return validateRelationInstance((RelationInstance)value, diagnostics, context);
			case OmlPackage.STRUCTURE_INSTANCE:
				return validateStructureInstance((StructureInstance)value, diagnostics, context);
			case OmlPackage.KEY_AXIOM:
				return validateKeyAxiom((KeyAxiom)value, diagnostics, context);
			case OmlPackage.SPECIALIZATION_AXIOM:
				return validateSpecializationAxiom((SpecializationAxiom)value, diagnostics, context);
			case OmlPackage.RESTRICTION_AXIOM:
				return validateRestrictionAxiom((RestrictionAxiom)value, diagnostics, context);
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM:
				return validatePropertyRestrictionAxiom((PropertyRestrictionAxiom)value, diagnostics, context);
			case OmlPackage.SCALAR_PROPERTY_RESTRICTION_AXIOM:
				return validateScalarPropertyRestrictionAxiom((ScalarPropertyRestrictionAxiom)value, diagnostics, context);
			case OmlPackage.SCALAR_PROPERTY_RANGE_RESTRICTION_AXIOM:
				return validateScalarPropertyRangeRestrictionAxiom((ScalarPropertyRangeRestrictionAxiom)value, diagnostics, context);
			case OmlPackage.SCALAR_PROPERTY_CARDINALITY_RESTRICTION_AXIOM:
				return validateScalarPropertyCardinalityRestrictionAxiom((ScalarPropertyCardinalityRestrictionAxiom)value, diagnostics, context);
			case OmlPackage.SCALAR_PROPERTY_VALUE_RESTRICTION_AXIOM:
				return validateScalarPropertyValueRestrictionAxiom((ScalarPropertyValueRestrictionAxiom)value, diagnostics, context);
			case OmlPackage.STRUCTURED_PROPERTY_RESTRICTION_AXIOM:
				return validateStructuredPropertyRestrictionAxiom((StructuredPropertyRestrictionAxiom)value, diagnostics, context);
			case OmlPackage.STRUCTURED_PROPERTY_RANGE_RESTRICTION_AXIOM:
				return validateStructuredPropertyRangeRestrictionAxiom((StructuredPropertyRangeRestrictionAxiom)value, diagnostics, context);
			case OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM:
				return validateStructuredPropertyCardinalityRestrictionAxiom((StructuredPropertyCardinalityRestrictionAxiom)value, diagnostics, context);
			case OmlPackage.STRUCTURED_PROPERTY_VALUE_RESTRICTION_AXIOM:
				return validateStructuredPropertyValueRestrictionAxiom((StructuredPropertyValueRestrictionAxiom)value, diagnostics, context);
			case OmlPackage.RELATION_RESTRICTION_AXIOM:
				return validateRelationRestrictionAxiom((RelationRestrictionAxiom)value, diagnostics, context);
			case OmlPackage.RELATION_RANGE_RESTRICTION_AXIOM:
				return validateRelationRangeRestrictionAxiom((RelationRangeRestrictionAxiom)value, diagnostics, context);
			case OmlPackage.RELATION_CARDINALITY_RESTRICTION_AXIOM:
				return validateRelationCardinalityRestrictionAxiom((RelationCardinalityRestrictionAxiom)value, diagnostics, context);
			case OmlPackage.RELATION_TARGET_RESTRICTION_AXIOM:
				return validateRelationTargetRestrictionAxiom((RelationTargetRestrictionAxiom)value, diagnostics, context);
			case OmlPackage.TYPE_ASSERTION:
				return validateTypeAssertion((TypeAssertion)value, diagnostics, context);
			case OmlPackage.CONCEPT_TYPE_ASSERTION:
				return validateConceptTypeAssertion((ConceptTypeAssertion)value, diagnostics, context);
			case OmlPackage.RELATION_TYPE_ASSERTION:
				return validateRelationTypeAssertion((RelationTypeAssertion)value, diagnostics, context);
			case OmlPackage.PROPERTY_VALUE_ASSERTION:
				return validatePropertyValueAssertion((PropertyValueAssertion)value, diagnostics, context);
			case OmlPackage.SCALAR_PROPERTY_VALUE_ASSERTION:
				return validateScalarPropertyValueAssertion((ScalarPropertyValueAssertion)value, diagnostics, context);
			case OmlPackage.STRUCTURED_PROPERTY_VALUE_ASSERTION:
				return validateStructuredPropertyValueAssertion((StructuredPropertyValueAssertion)value, diagnostics, context);
			case OmlPackage.LINK_ASSERTION:
				return validateLinkAssertion((LinkAssertion)value, diagnostics, context);
			case OmlPackage.UNARY_PREDICATE:
				return validateUnaryPredicate((UnaryPredicate)value, diagnostics, context);
			case OmlPackage.BINARY_PREDICATE:
				return validateBinaryPredicate((BinaryPredicate)value, diagnostics, context);
			case OmlPackage.TYPE_PREDICATE:
				return validateTypePredicate((TypePredicate)value, diagnostics, context);
			case OmlPackage.RELATION_ENTITY_PREDICATE:
				return validateRelationEntityPredicate((RelationEntityPredicate)value, diagnostics, context);
			case OmlPackage.PROPERTY_PREDICATE:
				return validatePropertyPredicate((PropertyPredicate)value, diagnostics, context);
			case OmlPackage.SAME_AS_PREDICATE:
				return validateSameAsPredicate((SameAsPredicate)value, diagnostics, context);
			case OmlPackage.DIFFERENT_FROM_PREDICATE:
				return validateDifferentFromPredicate((DifferentFromPredicate)value, diagnostics, context);
			case OmlPackage.QUOTED_LITERAL:
				return validateQuotedLiteral((QuotedLiteral)value, diagnostics, context);
			case OmlPackage.INTEGER_LITERAL:
				return validateIntegerLiteral((IntegerLiteral)value, diagnostics, context);
			case OmlPackage.DECIMAL_LITERAL:
				return validateDecimalLiteral((DecimalLiteral)value, diagnostics, context);
			case OmlPackage.DOUBLE_LITERAL:
				return validateDoubleLiteral((DoubleLiteral)value, diagnostics, context);
			case OmlPackage.BOOLEAN_LITERAL:
				return validateBooleanLiteral((BooleanLiteral)value, diagnostics, context);
			case OmlPackage.REFERENCE:
				return validateReference((Reference)value, diagnostics, context);
			case OmlPackage.SPECIALIZABLE_TERM_REFERENCE:
				return validateSpecializableTermReference((SpecializableTermReference)value, diagnostics, context);
			case OmlPackage.CLASSIFIER_REFERENCE:
				return validateClassifierReference((ClassifierReference)value, diagnostics, context);
			case OmlPackage.ENTITY_REFERENCE:
				return validateEntityReference((EntityReference)value, diagnostics, context);
			case OmlPackage.ASPECT_REFERENCE:
				return validateAspectReference((AspectReference)value, diagnostics, context);
			case OmlPackage.CONCEPT_REFERENCE:
				return validateConceptReference((ConceptReference)value, diagnostics, context);
			case OmlPackage.RELATION_ENTITY_REFERENCE:
				return validateRelationEntityReference((RelationEntityReference)value, diagnostics, context);
			case OmlPackage.STRUCTURE_REFERENCE:
				return validateStructureReference((StructureReference)value, diagnostics, context);
			case OmlPackage.ANNOTATION_PROPERTY_REFERENCE:
				return validateAnnotationPropertyReference((AnnotationPropertyReference)value, diagnostics, context);
			case OmlPackage.SCALAR_PROPERTY_REFERENCE:
				return validateScalarPropertyReference((ScalarPropertyReference)value, diagnostics, context);
			case OmlPackage.STRUCTURED_PROPERTY_REFERENCE:
				return validateStructuredPropertyReference((StructuredPropertyReference)value, diagnostics, context);
			case OmlPackage.FACETED_SCALAR_REFERENCE:
				return validateFacetedScalarReference((FacetedScalarReference)value, diagnostics, context);
			case OmlPackage.ENUMERATED_SCALAR_REFERENCE:
				return validateEnumeratedScalarReference((EnumeratedScalarReference)value, diagnostics, context);
			case OmlPackage.RELATION_REFERENCE:
				return validateRelationReference((RelationReference)value, diagnostics, context);
			case OmlPackage.RULE_REFERENCE:
				return validateRuleReference((RuleReference)value, diagnostics, context);
			case OmlPackage.NAMED_INSTANCE_REFERENCE:
				return validateNamedInstanceReference((NamedInstanceReference)value, diagnostics, context);
			case OmlPackage.CONCEPT_INSTANCE_REFERENCE:
				return validateConceptInstanceReference((ConceptInstanceReference)value, diagnostics, context);
			case OmlPackage.RELATION_INSTANCE_REFERENCE:
				return validateRelationInstanceReference((RelationInstanceReference)value, diagnostics, context);
			case OmlPackage.SEPARATOR_KIND:
				return validateSeparatorKind((SeparatorKind)value, diagnostics, context);
			case OmlPackage.RANGE_RESTRICTION_KIND:
				return validateRangeRestrictionKind((RangeRestrictionKind)value, diagnostics, context);
			case OmlPackage.CARDINALITY_RESTRICTION_KIND:
				return validateCardinalityRestrictionKind((CardinalityRestrictionKind)value, diagnostics, context);
			case OmlPackage.UNSIGNED_INT:
				return validateUnsignedInt((Long)value, diagnostics, context);
			case OmlPackage.UNSIGNED_INTEGER:
				return validateUnsignedInteger((Long)value, diagnostics, context);
			case OmlPackage.DECIMAL:
				return validateDecimal((BigDecimal)value, diagnostics, context);
			case OmlPackage.ID:
				return validateID((String)value, diagnostics, context);
			case OmlPackage.NAMESPACE:
				return validateNamespace((String)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElement(Element element, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(element, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(element, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(element, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(element, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(element, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(element, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(element, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(element, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(element, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(element, diagnostics, context);
		return result;
	}

	/**
	 * Validates the extraValidate constraint of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElement_extraValidate(Element element, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return element.extraValidate(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnotation(Annotation annotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(annotation, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(annotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(annotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(annotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(annotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(annotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(annotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(annotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(annotation, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(annotation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIdentifiedElement(IdentifiedElement identifiedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(identifiedElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(identifiedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(identifiedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(identifiedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(identifiedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(identifiedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(identifiedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(identifiedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(identifiedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(identifiedElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImport(Import import_, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(import_, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(import_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(import_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(import_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(import_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(import_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(import_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(import_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(import_, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(import_, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstance(Instance instance, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(instance, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(instance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(instance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(instance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(instance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(instance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(instance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(instance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(instance, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(instance, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStatement(Statement statement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(statement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(statement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(statement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(statement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(statement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(statement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(statement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(statement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(statement, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(statement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAxiom(Axiom axiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(axiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(axiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(axiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(axiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(axiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(axiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(axiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(axiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(axiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(axiom, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssertion(Assertion assertion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(assertion, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(assertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(assertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(assertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(assertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(assertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(assertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(assertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(assertion, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(assertion, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePredicate(Predicate predicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(predicate, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(predicate, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLiteral(Literal literal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(literal, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(literal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(literal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(literal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(literal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(literal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(literal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(literal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(literal, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(literal, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOntology(Ontology ontology, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(ontology, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(ontology, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(ontology, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(ontology, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(ontology, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(ontology, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(ontology, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(ontology, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(ontology, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(ontology, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMember(Member member, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(member, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(member, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(member, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(member, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(member, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(member, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(member, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(member, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(member, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(member, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVocabularyBox(VocabularyBox vocabularyBox, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(vocabularyBox, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(vocabularyBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(vocabularyBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(vocabularyBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(vocabularyBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(vocabularyBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(vocabularyBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(vocabularyBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(vocabularyBox, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(vocabularyBox, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDescriptionBox(DescriptionBox descriptionBox, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(descriptionBox, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(descriptionBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(descriptionBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(descriptionBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(descriptionBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(descriptionBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(descriptionBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(descriptionBox, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(descriptionBox, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(descriptionBox, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVocabulary(Vocabulary vocabulary, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(vocabulary, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(vocabulary, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(vocabulary, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(vocabulary, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(vocabulary, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(vocabulary, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(vocabulary, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(vocabulary, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(vocabulary, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(vocabulary, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVocabularyBundle(VocabularyBundle vocabularyBundle, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(vocabularyBundle, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(vocabularyBundle, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(vocabularyBundle, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(vocabularyBundle, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(vocabularyBundle, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(vocabularyBundle, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(vocabularyBundle, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(vocabularyBundle, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(vocabularyBundle, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(vocabularyBundle, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDescription(Description description, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(description, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(description, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(description, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(description, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(description, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(description, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(description, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(description, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(description, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(description, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDescriptionBundle(DescriptionBundle descriptionBundle, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(descriptionBundle, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(descriptionBundle, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(descriptionBundle, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(descriptionBundle, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(descriptionBundle, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(descriptionBundle, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(descriptionBundle, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(descriptionBundle, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(descriptionBundle, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(descriptionBundle, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtension(Extension extension, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(extension, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(extension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(extension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(extension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(extension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(extension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(extension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(extension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(extension, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(extension, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUsage(Usage usage, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(usage, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(usage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(usage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(usage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(usage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(usage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(usage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(usage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(usage, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(usage, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInclusion(Inclusion inclusion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(inclusion, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(inclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(inclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(inclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(inclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(inclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(inclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(inclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(inclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(inclusion, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVocabularyStatement(VocabularyStatement vocabularyStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(vocabularyStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(vocabularyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(vocabularyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(vocabularyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(vocabularyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(vocabularyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(vocabularyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(vocabularyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(vocabularyStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(vocabularyStatement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDescriptionStatement(DescriptionStatement descriptionStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(descriptionStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(descriptionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(descriptionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(descriptionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(descriptionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(descriptionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(descriptionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(descriptionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(descriptionStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(descriptionStatement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVocabularyMember(VocabularyMember vocabularyMember, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(vocabularyMember, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(vocabularyMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(vocabularyMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(vocabularyMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(vocabularyMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(vocabularyMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(vocabularyMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(vocabularyMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(vocabularyMember, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(vocabularyMember, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDescriptionMember(DescriptionMember descriptionMember, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(descriptionMember, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(descriptionMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(descriptionMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(descriptionMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(descriptionMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(descriptionMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(descriptionMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(descriptionMember, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(descriptionMember, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(descriptionMember, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTerm(Term term, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(term, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(term, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(term, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(term, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(term, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(term, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(term, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(term, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(term, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(term, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRule(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(rule, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(rule, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSpecializableTerm(SpecializableTerm specializableTerm, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(specializableTerm, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(specializableTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(specializableTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(specializableTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(specializableTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(specializableTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(specializableTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(specializableTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(specializableTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(specializableTerm, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty(Property property, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(property, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(property, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(property, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateType(Type type, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(type, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(type, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(type, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationBase(RelationBase relationBase, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relationBase, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relationBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relationBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationBase, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(relationBase, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifier(Classifier classifier, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(classifier, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(classifier, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(classifier, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(classifier, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(classifier, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(classifier, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(classifier, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(classifier, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(classifier, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(classifier, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScalar(Scalar scalar, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(scalar, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(scalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(scalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(scalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(scalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(scalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(scalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(scalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(scalar, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(scalar, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntity(Entity entity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(entity, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(entity, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructure(Structure structure, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(structure, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(structure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(structure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(structure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(structure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(structure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(structure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(structure, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(structure, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(structure, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAspect(Aspect aspect, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(aspect, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(aspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(aspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(aspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(aspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(aspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(aspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(aspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(aspect, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(aspect, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConcept(Concept concept, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(concept, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(concept, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(concept, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(concept, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(concept, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(concept, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(concept, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(concept, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(concept, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(concept, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationEntity(RelationEntity relationEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relationEntity, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relationEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relationEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(relationEntity, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFacetedScalar(FacetedScalar facetedScalar, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(facetedScalar, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(facetedScalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(facetedScalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(facetedScalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(facetedScalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(facetedScalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(facetedScalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(facetedScalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(facetedScalar, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(facetedScalar, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumeratedScalar(EnumeratedScalar enumeratedScalar, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(enumeratedScalar, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(enumeratedScalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(enumeratedScalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(enumeratedScalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(enumeratedScalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(enumeratedScalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(enumeratedScalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(enumeratedScalar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(enumeratedScalar, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(enumeratedScalar, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnotationProperty(AnnotationProperty annotationProperty, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(annotationProperty, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(annotationProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(annotationProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(annotationProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(annotationProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(annotationProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(annotationProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(annotationProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(annotationProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(annotationProperty, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSemanticProperty(SemanticProperty semanticProperty, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(semanticProperty, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(semanticProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(semanticProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(semanticProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(semanticProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(semanticProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(semanticProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(semanticProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(semanticProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(semanticProperty, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScalarProperty(ScalarProperty scalarProperty, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(scalarProperty, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(scalarProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(scalarProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(scalarProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(scalarProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(scalarProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(scalarProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(scalarProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(scalarProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(scalarProperty, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuredProperty(StructuredProperty structuredProperty, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(structuredProperty, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(structuredProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(structuredProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(structuredProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(structuredProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(structuredProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(structuredProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(structuredProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(structuredProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(structuredProperty, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelation(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relation, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(relation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForwardRelation(ForwardRelation forwardRelation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(forwardRelation, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(forwardRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(forwardRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(forwardRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(forwardRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(forwardRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(forwardRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(forwardRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(forwardRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(forwardRelation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReverseRelation(ReverseRelation reverseRelation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(reverseRelation, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(reverseRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(reverseRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(reverseRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(reverseRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(reverseRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(reverseRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(reverseRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(reverseRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(reverseRelation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnreifiedRelation(UnreifiedRelation unreifiedRelation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(unreifiedRelation, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(unreifiedRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(unreifiedRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(unreifiedRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(unreifiedRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(unreifiedRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(unreifiedRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(unreifiedRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(unreifiedRelation, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(unreifiedRelation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedInstance(NamedInstance namedInstance, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(namedInstance, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(namedInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(namedInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(namedInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(namedInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(namedInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(namedInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(namedInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(namedInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(namedInstance, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConceptInstance(ConceptInstance conceptInstance, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(conceptInstance, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(conceptInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(conceptInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(conceptInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(conceptInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(conceptInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(conceptInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(conceptInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(conceptInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(conceptInstance, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationInstance(RelationInstance relationInstance, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relationInstance, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relationInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relationInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(relationInstance, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructureInstance(StructureInstance structureInstance, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(structureInstance, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(structureInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(structureInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(structureInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(structureInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(structureInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(structureInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(structureInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(structureInstance, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(structureInstance, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKeyAxiom(KeyAxiom keyAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(keyAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(keyAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(keyAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(keyAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(keyAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(keyAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(keyAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(keyAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(keyAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(keyAxiom, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSpecializationAxiom(SpecializationAxiom specializationAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(specializationAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(specializationAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(specializationAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(specializationAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(specializationAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(specializationAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(specializationAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(specializationAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(specializationAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(specializationAxiom, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRestrictionAxiom(RestrictionAxiom restrictionAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(restrictionAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(restrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(restrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(restrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(restrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(restrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(restrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(restrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(restrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(restrictionAxiom, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyRestrictionAxiom(PropertyRestrictionAxiom propertyRestrictionAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(propertyRestrictionAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(propertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(propertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(propertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(propertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(propertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(propertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(propertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(propertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(propertyRestrictionAxiom, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScalarPropertyRestrictionAxiom(ScalarPropertyRestrictionAxiom scalarPropertyRestrictionAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(scalarPropertyRestrictionAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(scalarPropertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(scalarPropertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(scalarPropertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(scalarPropertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(scalarPropertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(scalarPropertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(scalarPropertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(scalarPropertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(scalarPropertyRestrictionAxiom, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScalarPropertyRangeRestrictionAxiom(ScalarPropertyRangeRestrictionAxiom scalarPropertyRangeRestrictionAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(scalarPropertyRangeRestrictionAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(scalarPropertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(scalarPropertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(scalarPropertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(scalarPropertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(scalarPropertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(scalarPropertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(scalarPropertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(scalarPropertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(scalarPropertyRangeRestrictionAxiom, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScalarPropertyCardinalityRestrictionAxiom(ScalarPropertyCardinalityRestrictionAxiom scalarPropertyCardinalityRestrictionAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(scalarPropertyCardinalityRestrictionAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(scalarPropertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(scalarPropertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(scalarPropertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(scalarPropertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(scalarPropertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(scalarPropertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(scalarPropertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(scalarPropertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(scalarPropertyCardinalityRestrictionAxiom, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScalarPropertyValueRestrictionAxiom(ScalarPropertyValueRestrictionAxiom scalarPropertyValueRestrictionAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(scalarPropertyValueRestrictionAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(scalarPropertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(scalarPropertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(scalarPropertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(scalarPropertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(scalarPropertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(scalarPropertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(scalarPropertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(scalarPropertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(scalarPropertyValueRestrictionAxiom, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuredPropertyRestrictionAxiom(StructuredPropertyRestrictionAxiom structuredPropertyRestrictionAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(structuredPropertyRestrictionAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(structuredPropertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(structuredPropertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(structuredPropertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(structuredPropertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(structuredPropertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(structuredPropertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(structuredPropertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(structuredPropertyRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(structuredPropertyRestrictionAxiom, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuredPropertyRangeRestrictionAxiom(StructuredPropertyRangeRestrictionAxiom structuredPropertyRangeRestrictionAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(structuredPropertyRangeRestrictionAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(structuredPropertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(structuredPropertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(structuredPropertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(structuredPropertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(structuredPropertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(structuredPropertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(structuredPropertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(structuredPropertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(structuredPropertyRangeRestrictionAxiom, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuredPropertyCardinalityRestrictionAxiom(StructuredPropertyCardinalityRestrictionAxiom structuredPropertyCardinalityRestrictionAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(structuredPropertyCardinalityRestrictionAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(structuredPropertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(structuredPropertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(structuredPropertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(structuredPropertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(structuredPropertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(structuredPropertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(structuredPropertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(structuredPropertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(structuredPropertyCardinalityRestrictionAxiom, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuredPropertyValueRestrictionAxiom(StructuredPropertyValueRestrictionAxiom structuredPropertyValueRestrictionAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(structuredPropertyValueRestrictionAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(structuredPropertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(structuredPropertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(structuredPropertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(structuredPropertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(structuredPropertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(structuredPropertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(structuredPropertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(structuredPropertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(structuredPropertyValueRestrictionAxiom, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationRestrictionAxiom(RelationRestrictionAxiom relationRestrictionAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relationRestrictionAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relationRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relationRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(relationRestrictionAxiom, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationRangeRestrictionAxiom(RelationRangeRestrictionAxiom relationRangeRestrictionAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relationRangeRestrictionAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relationRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relationRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(relationRangeRestrictionAxiom, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationCardinalityRestrictionAxiom(RelationCardinalityRestrictionAxiom relationCardinalityRestrictionAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relationCardinalityRestrictionAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relationCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relationCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(relationCardinalityRestrictionAxiom, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationTargetRestrictionAxiom(RelationTargetRestrictionAxiom relationTargetRestrictionAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relationTargetRestrictionAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relationTargetRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationTargetRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationTargetRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relationTargetRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationTargetRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationTargetRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationTargetRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationTargetRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(relationTargetRestrictionAxiom, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeAssertion(TypeAssertion typeAssertion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeAssertion, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(typeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(typeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(typeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(typeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(typeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(typeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(typeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(typeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(typeAssertion, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConceptTypeAssertion(ConceptTypeAssertion conceptTypeAssertion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(conceptTypeAssertion, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(conceptTypeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(conceptTypeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(conceptTypeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(conceptTypeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(conceptTypeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(conceptTypeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(conceptTypeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(conceptTypeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(conceptTypeAssertion, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationTypeAssertion(RelationTypeAssertion relationTypeAssertion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relationTypeAssertion, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relationTypeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationTypeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationTypeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relationTypeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationTypeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationTypeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationTypeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationTypeAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(relationTypeAssertion, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyValueAssertion(PropertyValueAssertion propertyValueAssertion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(propertyValueAssertion, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(propertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(propertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(propertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(propertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(propertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(propertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(propertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(propertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(propertyValueAssertion, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScalarPropertyValueAssertion(ScalarPropertyValueAssertion scalarPropertyValueAssertion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(scalarPropertyValueAssertion, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(scalarPropertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(scalarPropertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(scalarPropertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(scalarPropertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(scalarPropertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(scalarPropertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(scalarPropertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(scalarPropertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(scalarPropertyValueAssertion, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuredPropertyValueAssertion(StructuredPropertyValueAssertion structuredPropertyValueAssertion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(structuredPropertyValueAssertion, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(structuredPropertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(structuredPropertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(structuredPropertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(structuredPropertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(structuredPropertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(structuredPropertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(structuredPropertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(structuredPropertyValueAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(structuredPropertyValueAssertion, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkAssertion(LinkAssertion linkAssertion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(linkAssertion, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(linkAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(linkAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(linkAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(linkAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(linkAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(linkAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(linkAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(linkAssertion, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(linkAssertion, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnaryPredicate(UnaryPredicate unaryPredicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(unaryPredicate, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(unaryPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(unaryPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(unaryPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(unaryPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(unaryPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(unaryPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(unaryPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(unaryPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(unaryPredicate, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryPredicate(BinaryPredicate binaryPredicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(binaryPredicate, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(binaryPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(binaryPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(binaryPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(binaryPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(binaryPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(binaryPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(binaryPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(binaryPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(binaryPredicate, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypePredicate(TypePredicate typePredicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typePredicate, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(typePredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(typePredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(typePredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(typePredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(typePredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(typePredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(typePredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(typePredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(typePredicate, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationEntityPredicate(RelationEntityPredicate relationEntityPredicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relationEntityPredicate, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relationEntityPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationEntityPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationEntityPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relationEntityPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationEntityPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationEntityPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationEntityPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationEntityPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(relationEntityPredicate, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyPredicate(PropertyPredicate propertyPredicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(propertyPredicate, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(propertyPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(propertyPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(propertyPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(propertyPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(propertyPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(propertyPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(propertyPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(propertyPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(propertyPredicate, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSameAsPredicate(SameAsPredicate sameAsPredicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sameAsPredicate, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sameAsPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sameAsPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sameAsPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(sameAsPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sameAsPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sameAsPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sameAsPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sameAsPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(sameAsPredicate, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDifferentFromPredicate(DifferentFromPredicate differentFromPredicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(differentFromPredicate, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(differentFromPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(differentFromPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(differentFromPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(differentFromPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(differentFromPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(differentFromPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(differentFromPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(differentFromPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(differentFromPredicate, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQuotedLiteral(QuotedLiteral quotedLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(quotedLiteral, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(quotedLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(quotedLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(quotedLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(quotedLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(quotedLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(quotedLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(quotedLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(quotedLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(quotedLiteral, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntegerLiteral(IntegerLiteral integerLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(integerLiteral, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(integerLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(integerLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(integerLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(integerLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(integerLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(integerLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(integerLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(integerLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(integerLiteral, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDecimalLiteral(DecimalLiteral decimalLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(decimalLiteral, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(decimalLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(decimalLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(decimalLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(decimalLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(decimalLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(decimalLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(decimalLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(decimalLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(decimalLiteral, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDoubleLiteral(DoubleLiteral doubleLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(doubleLiteral, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(doubleLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(doubleLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(doubleLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(doubleLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(doubleLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(doubleLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(doubleLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(doubleLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(doubleLiteral, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanLiteral(BooleanLiteral booleanLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(booleanLiteral, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(booleanLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(booleanLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(booleanLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(booleanLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(booleanLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(booleanLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(booleanLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(booleanLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(booleanLiteral, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReference(Reference reference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(reference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(reference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(reference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(reference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(reference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(reference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(reference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(reference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(reference, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(reference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSpecializableTermReference(SpecializableTermReference specializableTermReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(specializableTermReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(specializableTermReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(specializableTermReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(specializableTermReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(specializableTermReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(specializableTermReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(specializableTermReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(specializableTermReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(specializableTermReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(specializableTermReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierReference(ClassifierReference classifierReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(classifierReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(classifierReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(classifierReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(classifierReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(classifierReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(classifierReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(classifierReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(classifierReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(classifierReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(classifierReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntityReference(EntityReference entityReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(entityReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(entityReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(entityReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(entityReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(entityReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(entityReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(entityReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(entityReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(entityReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(entityReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAspectReference(AspectReference aspectReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(aspectReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(aspectReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(aspectReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(aspectReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(aspectReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(aspectReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(aspectReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(aspectReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(aspectReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(aspectReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConceptReference(ConceptReference conceptReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(conceptReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(conceptReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(conceptReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(conceptReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(conceptReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(conceptReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(conceptReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(conceptReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(conceptReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(conceptReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationEntityReference(RelationEntityReference relationEntityReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relationEntityReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relationEntityReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationEntityReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationEntityReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relationEntityReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationEntityReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationEntityReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationEntityReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationEntityReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(relationEntityReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructureReference(StructureReference structureReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(structureReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(structureReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(structureReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(structureReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(structureReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(structureReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(structureReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(structureReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(structureReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(structureReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnotationPropertyReference(AnnotationPropertyReference annotationPropertyReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(annotationPropertyReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(annotationPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(annotationPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(annotationPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(annotationPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(annotationPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(annotationPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(annotationPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(annotationPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(annotationPropertyReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScalarPropertyReference(ScalarPropertyReference scalarPropertyReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(scalarPropertyReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(scalarPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(scalarPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(scalarPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(scalarPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(scalarPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(scalarPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(scalarPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(scalarPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(scalarPropertyReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuredPropertyReference(StructuredPropertyReference structuredPropertyReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(structuredPropertyReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(structuredPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(structuredPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(structuredPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(structuredPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(structuredPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(structuredPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(structuredPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(structuredPropertyReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(structuredPropertyReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFacetedScalarReference(FacetedScalarReference facetedScalarReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(facetedScalarReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(facetedScalarReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(facetedScalarReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(facetedScalarReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(facetedScalarReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(facetedScalarReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(facetedScalarReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(facetedScalarReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(facetedScalarReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(facetedScalarReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumeratedScalarReference(EnumeratedScalarReference enumeratedScalarReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(enumeratedScalarReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(enumeratedScalarReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(enumeratedScalarReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(enumeratedScalarReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(enumeratedScalarReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(enumeratedScalarReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(enumeratedScalarReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(enumeratedScalarReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(enumeratedScalarReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(enumeratedScalarReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationReference(RelationReference relationReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relationReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relationReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relationReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(relationReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRuleReference(RuleReference ruleReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(ruleReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(ruleReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(ruleReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(ruleReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(ruleReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(ruleReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(ruleReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(ruleReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(ruleReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(ruleReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedInstanceReference(NamedInstanceReference namedInstanceReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(namedInstanceReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(namedInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(namedInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(namedInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(namedInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(namedInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(namedInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(namedInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(namedInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(namedInstanceReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConceptInstanceReference(ConceptInstanceReference conceptInstanceReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(conceptInstanceReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(conceptInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(conceptInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(conceptInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(conceptInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(conceptInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(conceptInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(conceptInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(conceptInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(conceptInstanceReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationInstanceReference(RelationInstanceReference relationInstanceReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relationInstanceReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relationInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relationInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationInstanceReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(relationInstanceReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSeparatorKind(SeparatorKind separatorKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRangeRestrictionKind(RangeRestrictionKind rangeRestrictionKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityRestrictionKind(CardinalityRestrictionKind cardinalityRestrictionKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnsignedInt(long unsignedInt, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateUnsignedInt_Min(unsignedInt, diagnostics, context);
		if (result || diagnostics != null) result &= validateUnsignedInt_Max(unsignedInt, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateUnsignedInt_Min
	 */
	public static final long UNSIGNED_INT__MIN__VALUE = 0L;

	/**
	 * Validates the Min constraint of '<em>Unsigned Int</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnsignedInt_Min(long unsignedInt, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = unsignedInt >= UNSIGNED_INT__MIN__VALUE;
		if (!result && diagnostics != null)
			reportMinViolation(OmlPackage.Literals.UNSIGNED_INT, unsignedInt, UNSIGNED_INT__MIN__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateUnsignedInt_Max
	 */
	public static final long UNSIGNED_INT__MAX__VALUE = 4294967295L;

	/**
	 * Validates the Max constraint of '<em>Unsigned Int</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnsignedInt_Max(long unsignedInt, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = unsignedInt <= UNSIGNED_INT__MAX__VALUE;
		if (!result && diagnostics != null)
			reportMaxViolation(OmlPackage.Literals.UNSIGNED_INT, unsignedInt, UNSIGNED_INT__MAX__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnsignedInteger(Long unsignedInteger, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateUnsignedInteger_Min(unsignedInteger, diagnostics, context);
		if (result || diagnostics != null) result &= validateUnsignedInteger_Max(unsignedInteger, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateUnsignedInteger_Min
	 */
	public static final Long UNSIGNED_INTEGER__MIN__VALUE = Long.valueOf(0L);

	/**
	 * Validates the Min constraint of '<em>Unsigned Integer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnsignedInteger_Min(Long unsignedInteger, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = unsignedInteger.compareTo(UNSIGNED_INTEGER__MIN__VALUE) >= 0;
		if (!result && diagnostics != null)
			reportMinViolation(OmlPackage.Literals.UNSIGNED_INTEGER, unsignedInteger, UNSIGNED_INTEGER__MIN__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateUnsignedInteger_Max
	 */
	public static final Long UNSIGNED_INTEGER__MAX__VALUE = Long.valueOf(4294967295L);

	/**
	 * Validates the Max constraint of '<em>Unsigned Integer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnsignedInteger_Max(Long unsignedInteger, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = unsignedInteger.compareTo(UNSIGNED_INTEGER__MAX__VALUE) <= 0;
		if (!result && diagnostics != null)
			reportMaxViolation(OmlPackage.Literals.UNSIGNED_INTEGER, unsignedInteger, UNSIGNED_INTEGER__MAX__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDecimal(BigDecimal decimal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateID(String id, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateID_Pattern(id, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateID_Pattern
	 */
	public static final  PatternMatcher [][] ID__PATTERN__VALUES =
		new PatternMatcher [][] {
			new PatternMatcher [] {
				XMLTypeUtil.createPatternMatcher("[a-zA-Z0-9_]([a-zA-Z0-9_\\-.$])*")
			}
		};

	/**
	 * Validates the Pattern constraint of '<em>ID</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateID_Pattern(String id, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validatePattern(OmlPackage.Literals.ID, id, ID__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamespace(String namespace, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateNamespace_Pattern(namespace, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamespace_MinLength(namespace, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateNamespace_Pattern
	 */
	public static final  PatternMatcher [][] NAMESPACE__PATTERN__VALUES =
		new PatternMatcher [][] {
			new PatternMatcher [] {
				XMLTypeUtil.createPatternMatcher("([^\\s#])*(#|/)")
			}
		};

	/**
	 * Validates the Pattern constraint of '<em>Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamespace_Pattern(String namespace, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validatePattern(OmlPackage.Literals.NAMESPACE, namespace, NAMESPACE__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * Validates the MinLength constraint of '<em>Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamespace_MinLength(String namespace, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = namespace.length();
		boolean result = length >= 2;
		if (!result && diagnostics != null)
			reportMinLengthViolation(OmlPackage.Literals.NAMESPACE, namespace, length, 2, diagnostics, context);
		return result;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //OmlValidator
