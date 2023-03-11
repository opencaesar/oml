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
package io.opencaesar.oml.impl;

import io.opencaesar.oml.*;

import java.math.BigDecimal;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OmlFactoryImpl extends EFactoryImpl implements OmlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OmlFactory init() {
		try {
			OmlFactory theOmlFactory = (OmlFactory)EPackage.Registry.INSTANCE.getEFactory(OmlPackage.eNS_URI);
			if (theOmlFactory != null) {
				return theOmlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OmlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OmlFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OmlPackage.ANNOTATION: return createAnnotation();
			case OmlPackage.IMPORT: return createImport();
			case OmlPackage.ARGUMENT: return createArgument();
			case OmlPackage.VOCABULARY: return createVocabulary();
			case OmlPackage.VOCABULARY_BUNDLE: return createVocabularyBundle();
			case OmlPackage.DESCRIPTION: return createDescription();
			case OmlPackage.DESCRIPTION_BUNDLE: return createDescriptionBundle();
			case OmlPackage.RULE: return createRule();
			case OmlPackage.BUILT_IN: return createBuiltIn();
			case OmlPackage.STRUCTURE: return createStructure();
			case OmlPackage.ASPECT: return createAspect();
			case OmlPackage.CONCEPT: return createConcept();
			case OmlPackage.RELATION_ENTITY: return createRelationEntity();
			case OmlPackage.FACETED_SCALAR: return createFacetedScalar();
			case OmlPackage.ENUMERATED_SCALAR: return createEnumeratedScalar();
			case OmlPackage.ANNOTATION_PROPERTY: return createAnnotationProperty();
			case OmlPackage.SCALAR_PROPERTY: return createScalarProperty();
			case OmlPackage.STRUCTURED_PROPERTY: return createStructuredProperty();
			case OmlPackage.FORWARD_RELATION: return createForwardRelation();
			case OmlPackage.REVERSE_RELATION: return createReverseRelation();
			case OmlPackage.UNREIFIED_RELATION: return createUnreifiedRelation();
			case OmlPackage.CONCEPT_INSTANCE: return createConceptInstance();
			case OmlPackage.RELATION_INSTANCE: return createRelationInstance();
			case OmlPackage.STRUCTURE_INSTANCE: return createStructureInstance();
			case OmlPackage.KEY_AXIOM: return createKeyAxiom();
			case OmlPackage.SPECIALIZATION_AXIOM: return createSpecializationAxiom();
			case OmlPackage.ENUMERATION_AXIOM: return createEnumerationAxiom();
			case OmlPackage.PROPERTY_RANGE_RESTRICTION_AXIOM: return createPropertyRangeRestrictionAxiom();
			case OmlPackage.PROPERTY_CARDINALITY_RESTRICTION_AXIOM: return createPropertyCardinalityRestrictionAxiom();
			case OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM: return createPropertyValueRestrictionAxiom();
			case OmlPackage.TYPE_ASSERTION: return createTypeAssertion();
			case OmlPackage.PROPERTY_VALUE_ASSERTION: return createPropertyValueAssertion();
			case OmlPackage.BUILT_IN_PREDICATE: return createBuiltInPredicate();
			case OmlPackage.TYPE_PREDICATE: return createTypePredicate();
			case OmlPackage.RELATION_ENTITY_PREDICATE: return createRelationEntityPredicate();
			case OmlPackage.PROPERTY_PREDICATE: return createPropertyPredicate();
			case OmlPackage.SAME_AS_PREDICATE: return createSameAsPredicate();
			case OmlPackage.DIFFERENT_FROM_PREDICATE: return createDifferentFromPredicate();
			case OmlPackage.QUOTED_LITERAL: return createQuotedLiteral();
			case OmlPackage.INTEGER_LITERAL: return createIntegerLiteral();
			case OmlPackage.DECIMAL_LITERAL: return createDecimalLiteral();
			case OmlPackage.DOUBLE_LITERAL: return createDoubleLiteral();
			case OmlPackage.BOOLEAN_LITERAL: return createBooleanLiteral();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case OmlPackage.SEPARATOR_KIND:
				return createSeparatorKindFromString(eDataType, initialValue);
			case OmlPackage.RANGE_RESTRICTION_KIND:
				return createRangeRestrictionKindFromString(eDataType, initialValue);
			case OmlPackage.CARDINALITY_RESTRICTION_KIND:
				return createCardinalityRestrictionKindFromString(eDataType, initialValue);
			case OmlPackage.IMPORT_KIND:
				return createImportKindFromString(eDataType, initialValue);
			case OmlPackage.UNSIGNED_INT:
				return createUnsignedIntFromString(eDataType, initialValue);
			case OmlPackage.UNSIGNED_INTEGER:
				return createUnsignedIntegerFromString(eDataType, initialValue);
			case OmlPackage.DECIMAL:
				return createDecimalFromString(eDataType, initialValue);
			case OmlPackage.ID:
				return createIDFromString(eDataType, initialValue);
			case OmlPackage.NAMESPACE:
				return createNamespaceFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case OmlPackage.SEPARATOR_KIND:
				return convertSeparatorKindToString(eDataType, instanceValue);
			case OmlPackage.RANGE_RESTRICTION_KIND:
				return convertRangeRestrictionKindToString(eDataType, instanceValue);
			case OmlPackage.CARDINALITY_RESTRICTION_KIND:
				return convertCardinalityRestrictionKindToString(eDataType, instanceValue);
			case OmlPackage.IMPORT_KIND:
				return convertImportKindToString(eDataType, instanceValue);
			case OmlPackage.UNSIGNED_INT:
				return convertUnsignedIntToString(eDataType, instanceValue);
			case OmlPackage.UNSIGNED_INTEGER:
				return convertUnsignedIntegerToString(eDataType, instanceValue);
			case OmlPackage.DECIMAL:
				return convertDecimalToString(eDataType, instanceValue);
			case OmlPackage.ID:
				return convertIDToString(eDataType, instanceValue);
			case OmlPackage.NAMESPACE:
				return convertNamespaceToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Annotation createAnnotation() {
		AnnotationImpl annotation = new AnnotationImpl();
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Import createImport() {
		ImportImpl import_ = new ImportImpl();
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Argument createArgument() {
		ArgumentImpl argument = new ArgumentImpl();
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vocabulary createVocabulary() {
		VocabularyImpl vocabulary = new VocabularyImpl();
		return vocabulary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VocabularyBundle createVocabularyBundle() {
		VocabularyBundleImpl vocabularyBundle = new VocabularyBundleImpl();
		return vocabularyBundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Description createDescription() {
		DescriptionImpl description = new DescriptionImpl();
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DescriptionBundle createDescriptionBundle() {
		DescriptionBundleImpl descriptionBundle = new DescriptionBundleImpl();
		return descriptionBundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rule createRule() {
		RuleImpl rule = new RuleImpl();
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BuiltIn createBuiltIn() {
		BuiltInImpl builtIn = new BuiltInImpl();
		return builtIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Structure createStructure() {
		StructureImpl structure = new StructureImpl();
		return structure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Aspect createAspect() {
		AspectImpl aspect = new AspectImpl();
		return aspect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Concept createConcept() {
		ConceptImpl concept = new ConceptImpl();
		return concept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationEntity createRelationEntity() {
		RelationEntityImpl relationEntity = new RelationEntityImpl();
		return relationEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FacetedScalar createFacetedScalar() {
		FacetedScalarImpl facetedScalar = new FacetedScalarImpl();
		return facetedScalar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumeratedScalar createEnumeratedScalar() {
		EnumeratedScalarImpl enumeratedScalar = new EnumeratedScalarImpl();
		return enumeratedScalar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnnotationProperty createAnnotationProperty() {
		AnnotationPropertyImpl annotationProperty = new AnnotationPropertyImpl();
		return annotationProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScalarProperty createScalarProperty() {
		ScalarPropertyImpl scalarProperty = new ScalarPropertyImpl();
		return scalarProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StructuredProperty createStructuredProperty() {
		StructuredPropertyImpl structuredProperty = new StructuredPropertyImpl();
		return structuredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForwardRelation createForwardRelation() {
		ForwardRelationImpl forwardRelation = new ForwardRelationImpl();
		return forwardRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReverseRelation createReverseRelation() {
		ReverseRelationImpl reverseRelation = new ReverseRelationImpl();
		return reverseRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnreifiedRelation createUnreifiedRelation() {
		UnreifiedRelationImpl unreifiedRelation = new UnreifiedRelationImpl();
		return unreifiedRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConceptInstance createConceptInstance() {
		ConceptInstanceImpl conceptInstance = new ConceptInstanceImpl();
		return conceptInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationInstance createRelationInstance() {
		RelationInstanceImpl relationInstance = new RelationInstanceImpl();
		return relationInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StructureInstance createStructureInstance() {
		StructureInstanceImpl structureInstance = new StructureInstanceImpl();
		return structureInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public KeyAxiom createKeyAxiom() {
		KeyAxiomImpl keyAxiom = new KeyAxiomImpl();
		return keyAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpecializationAxiom createSpecializationAxiom() {
		SpecializationAxiomImpl specializationAxiom = new SpecializationAxiomImpl();
		return specializationAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumerationAxiom createEnumerationAxiom() {
		EnumerationAxiomImpl enumerationAxiom = new EnumerationAxiomImpl();
		return enumerationAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyRangeRestrictionAxiom createPropertyRangeRestrictionAxiom() {
		PropertyRangeRestrictionAxiomImpl propertyRangeRestrictionAxiom = new PropertyRangeRestrictionAxiomImpl();
		return propertyRangeRestrictionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyCardinalityRestrictionAxiom createPropertyCardinalityRestrictionAxiom() {
		PropertyCardinalityRestrictionAxiomImpl propertyCardinalityRestrictionAxiom = new PropertyCardinalityRestrictionAxiomImpl();
		return propertyCardinalityRestrictionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyValueRestrictionAxiom createPropertyValueRestrictionAxiom() {
		PropertyValueRestrictionAxiomImpl propertyValueRestrictionAxiom = new PropertyValueRestrictionAxiomImpl();
		return propertyValueRestrictionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeAssertion createTypeAssertion() {
		TypeAssertionImpl typeAssertion = new TypeAssertionImpl();
		return typeAssertion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyValueAssertion createPropertyValueAssertion() {
		PropertyValueAssertionImpl propertyValueAssertion = new PropertyValueAssertionImpl();
		return propertyValueAssertion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BuiltInPredicate createBuiltInPredicate() {
		BuiltInPredicateImpl builtInPredicate = new BuiltInPredicateImpl();
		return builtInPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypePredicate createTypePredicate() {
		TypePredicateImpl typePredicate = new TypePredicateImpl();
		return typePredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationEntityPredicate createRelationEntityPredicate() {
		RelationEntityPredicateImpl relationEntityPredicate = new RelationEntityPredicateImpl();
		return relationEntityPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyPredicate createPropertyPredicate() {
		PropertyPredicateImpl propertyPredicate = new PropertyPredicateImpl();
		return propertyPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SameAsPredicate createSameAsPredicate() {
		SameAsPredicateImpl sameAsPredicate = new SameAsPredicateImpl();
		return sameAsPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DifferentFromPredicate createDifferentFromPredicate() {
		DifferentFromPredicateImpl differentFromPredicate = new DifferentFromPredicateImpl();
		return differentFromPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QuotedLiteral createQuotedLiteral() {
		QuotedLiteralImpl quotedLiteral = new QuotedLiteralImpl();
		return quotedLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntegerLiteral createIntegerLiteral() {
		IntegerLiteralImpl integerLiteral = new IntegerLiteralImpl();
		return integerLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DecimalLiteral createDecimalLiteral() {
		DecimalLiteralImpl decimalLiteral = new DecimalLiteralImpl();
		return decimalLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DoubleLiteral createDoubleLiteral() {
		DoubleLiteralImpl doubleLiteral = new DoubleLiteralImpl();
		return doubleLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BooleanLiteral createBooleanLiteral() {
		BooleanLiteralImpl booleanLiteral = new BooleanLiteralImpl();
		return booleanLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeparatorKind createSeparatorKindFromString(EDataType eDataType, String initialValue) {
		SeparatorKind result = SeparatorKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSeparatorKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeRestrictionKind createRangeRestrictionKindFromString(EDataType eDataType, String initialValue) {
		RangeRestrictionKind result = RangeRestrictionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRangeRestrictionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CardinalityRestrictionKind createCardinalityRestrictionKindFromString(EDataType eDataType, String initialValue) {
		CardinalityRestrictionKind result = CardinalityRestrictionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCardinalityRestrictionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportKind createImportKindFromString(EDataType eDataType, String initialValue) {
		ImportKind result = ImportKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertImportKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long createUnsignedIntFromString(EDataType eDataType, String initialValue) {
		return (Long)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnsignedIntToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long createUnsignedIntegerFromString(EDataType eDataType, String initialValue) {
		return (Long)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnsignedIntegerToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal createDecimalFromString(EDataType eDataType, String initialValue) {
		return (BigDecimal)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.DECIMAL, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDecimalToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.DECIMAL, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createIDFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIDToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNamespaceFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNamespaceToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OmlPackage getOmlPackage() {
		return (OmlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OmlPackage getPackage() {
		return OmlPackage.eINSTANCE;
	}

} //OmlFactoryImpl
