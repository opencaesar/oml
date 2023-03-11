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
			case OmlPackage.AXIOM:
				return validateAxiom((Axiom)value, diagnostics, context);
			case OmlPackage.ASSERTION:
				return validateAssertion((Assertion)value, diagnostics, context);
			case OmlPackage.PREDICATE:
				return validatePredicate((Predicate)value, diagnostics, context);
			case OmlPackage.ARGUMENT:
				return validateArgument((Argument)value, diagnostics, context);
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
			case OmlPackage.STATEMENT:
				return validateStatement((Statement)value, diagnostics, context);
			case OmlPackage.VOCABULARY_MEMBER:
				return validateVocabularyMember((VocabularyMember)value, diagnostics, context);
			case OmlPackage.DESCRIPTION_MEMBER:
				return validateDescriptionMember((DescriptionMember)value, diagnostics, context);
			case OmlPackage.VOCABULARY_STATEMENT:
				return validateVocabularyStatement((VocabularyStatement)value, diagnostics, context);
			case OmlPackage.DESCRIPTION_STATEMENT:
				return validateDescriptionStatement((DescriptionStatement)value, diagnostics, context);
			case OmlPackage.TERM:
				return validateTerm((Term)value, diagnostics, context);
			case OmlPackage.RULE:
				return validateRule((Rule)value, diagnostics, context);
			case OmlPackage.BUILT_IN:
				return validateBuiltIn((BuiltIn)value, diagnostics, context);
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
			case OmlPackage.ENUMERATION_AXIOM:
				return validateEnumerationAxiom((EnumerationAxiom)value, diagnostics, context);
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM:
				return validatePropertyRestrictionAxiom((PropertyRestrictionAxiom)value, diagnostics, context);
			case OmlPackage.PROPERTY_RANGE_RESTRICTION_AXIOM:
				return validatePropertyRangeRestrictionAxiom((PropertyRangeRestrictionAxiom)value, diagnostics, context);
			case OmlPackage.PROPERTY_CARDINALITY_RESTRICTION_AXIOM:
				return validatePropertyCardinalityRestrictionAxiom((PropertyCardinalityRestrictionAxiom)value, diagnostics, context);
			case OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM:
				return validatePropertyValueRestrictionAxiom((PropertyValueRestrictionAxiom)value, diagnostics, context);
			case OmlPackage.TYPE_ASSERTION:
				return validateTypeAssertion((TypeAssertion)value, diagnostics, context);
			case OmlPackage.PROPERTY_VALUE_ASSERTION:
				return validatePropertyValueAssertion((PropertyValueAssertion)value, diagnostics, context);
			case OmlPackage.UNARY_PREDICATE:
				return validateUnaryPredicate((UnaryPredicate)value, diagnostics, context);
			case OmlPackage.BINARY_PREDICATE:
				return validateBinaryPredicate((BinaryPredicate)value, diagnostics, context);
			case OmlPackage.BUILT_IN_PREDICATE:
				return validateBuiltInPredicate((BuiltInPredicate)value, diagnostics, context);
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
			case OmlPackage.SEPARATOR_KIND:
				return validateSeparatorKind((SeparatorKind)value, diagnostics, context);
			case OmlPackage.RANGE_RESTRICTION_KIND:
				return validateRangeRestrictionKind((RangeRestrictionKind)value, diagnostics, context);
			case OmlPackage.CARDINALITY_RESTRICTION_KIND:
				return validateCardinalityRestrictionKind((CardinalityRestrictionKind)value, diagnostics, context);
			case OmlPackage.IMPORT_KIND:
				return validateImportKind((ImportKind)value, diagnostics, context);
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
	public boolean validateArgument(Argument argument, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(argument, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(argument, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(argument, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(argument, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(argument, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(argument, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(argument, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(argument, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(argument, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(argument, diagnostics, context);
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
	public boolean validateBuiltIn(BuiltIn builtIn, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(builtIn, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(builtIn, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(builtIn, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(builtIn, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(builtIn, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(builtIn, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(builtIn, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(builtIn, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(builtIn, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(builtIn, diagnostics, context);
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
	public boolean validateEnumerationAxiom(EnumerationAxiom enumerationAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(enumerationAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(enumerationAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(enumerationAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(enumerationAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(enumerationAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(enumerationAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(enumerationAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(enumerationAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(enumerationAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(enumerationAxiom, diagnostics, context);
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
	public boolean validatePropertyRangeRestrictionAxiom(PropertyRangeRestrictionAxiom propertyRangeRestrictionAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(propertyRangeRestrictionAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(propertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(propertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(propertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(propertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(propertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(propertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(propertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(propertyRangeRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(propertyRangeRestrictionAxiom, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyCardinalityRestrictionAxiom(PropertyCardinalityRestrictionAxiom propertyCardinalityRestrictionAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(propertyCardinalityRestrictionAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(propertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(propertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(propertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(propertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(propertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(propertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(propertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(propertyCardinalityRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(propertyCardinalityRestrictionAxiom, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyValueRestrictionAxiom(PropertyValueRestrictionAxiom propertyValueRestrictionAxiom, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(propertyValueRestrictionAxiom, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(propertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(propertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(propertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(propertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(propertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(propertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(propertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(propertyValueRestrictionAxiom, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(propertyValueRestrictionAxiom, diagnostics, context);
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
	public boolean validateBuiltInPredicate(BuiltInPredicate builtInPredicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(builtInPredicate, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(builtInPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(builtInPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(builtInPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(builtInPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(builtInPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(builtInPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(builtInPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(builtInPredicate, diagnostics, context);
		if (result || diagnostics != null) result &= validateElement_extraValidate(builtInPredicate, diagnostics, context);
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
	public boolean validateImportKind(ImportKind importKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
