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
			case OmlPackage.VOCABULARY: return createVocabulary();
			case OmlPackage.VOCABULARY_BUNDLE: return createVocabularyBundle();
			case OmlPackage.DESCRIPTION: return createDescription();
			case OmlPackage.DESCRIPTION_BUNDLE: return createDescriptionBundle();
			case OmlPackage.EXTENSION: return createExtension();
			case OmlPackage.USAGE: return createUsage();
			case OmlPackage.INCLUSION: return createInclusion();
			case OmlPackage.RULE: return createRule();
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
			case OmlPackage.SCALAR_PROPERTY_RANGE_RESTRICTION_AXIOM: return createScalarPropertyRangeRestrictionAxiom();
			case OmlPackage.SCALAR_PROPERTY_CARDINALITY_RESTRICTION_AXIOM: return createScalarPropertyCardinalityRestrictionAxiom();
			case OmlPackage.SCALAR_PROPERTY_VALUE_RESTRICTION_AXIOM: return createScalarPropertyValueRestrictionAxiom();
			case OmlPackage.STRUCTURED_PROPERTY_RANGE_RESTRICTION_AXIOM: return createStructuredPropertyRangeRestrictionAxiom();
			case OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM: return createStructuredPropertyCardinalityRestrictionAxiom();
			case OmlPackage.STRUCTURED_PROPERTY_VALUE_RESTRICTION_AXIOM: return createStructuredPropertyValueRestrictionAxiom();
			case OmlPackage.RELATION_RANGE_RESTRICTION_AXIOM: return createRelationRangeRestrictionAxiom();
			case OmlPackage.RELATION_CARDINALITY_RESTRICTION_AXIOM: return createRelationCardinalityRestrictionAxiom();
			case OmlPackage.RELATION_TARGET_RESTRICTION_AXIOM: return createRelationTargetRestrictionAxiom();
			case OmlPackage.CONCEPT_TYPE_ASSERTION: return createConceptTypeAssertion();
			case OmlPackage.RELATION_TYPE_ASSERTION: return createRelationTypeAssertion();
			case OmlPackage.SCALAR_PROPERTY_VALUE_ASSERTION: return createScalarPropertyValueAssertion();
			case OmlPackage.STRUCTURED_PROPERTY_VALUE_ASSERTION: return createStructuredPropertyValueAssertion();
			case OmlPackage.LINK_ASSERTION: return createLinkAssertion();
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
			case OmlPackage.ASPECT_REFERENCE: return createAspectReference();
			case OmlPackage.CONCEPT_REFERENCE: return createConceptReference();
			case OmlPackage.RELATION_ENTITY_REFERENCE: return createRelationEntityReference();
			case OmlPackage.STRUCTURE_REFERENCE: return createStructureReference();
			case OmlPackage.ANNOTATION_PROPERTY_REFERENCE: return createAnnotationPropertyReference();
			case OmlPackage.SCALAR_PROPERTY_REFERENCE: return createScalarPropertyReference();
			case OmlPackage.STRUCTURED_PROPERTY_REFERENCE: return createStructuredPropertyReference();
			case OmlPackage.FACETED_SCALAR_REFERENCE: return createFacetedScalarReference();
			case OmlPackage.ENUMERATED_SCALAR_REFERENCE: return createEnumeratedScalarReference();
			case OmlPackage.RELATION_REFERENCE: return createRelationReference();
			case OmlPackage.RULE_REFERENCE: return createRuleReference();
			case OmlPackage.CONCEPT_INSTANCE_REFERENCE: return createConceptInstanceReference();
			case OmlPackage.RELATION_INSTANCE_REFERENCE: return createRelationInstanceReference();
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
	public Extension createExtension() {
		ExtensionImpl extension = new ExtensionImpl();
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Usage createUsage() {
		UsageImpl usage = new UsageImpl();
		return usage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Inclusion createInclusion() {
		InclusionImpl inclusion = new InclusionImpl();
		return inclusion;
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
	public ScalarPropertyRangeRestrictionAxiom createScalarPropertyRangeRestrictionAxiom() {
		ScalarPropertyRangeRestrictionAxiomImpl scalarPropertyRangeRestrictionAxiom = new ScalarPropertyRangeRestrictionAxiomImpl();
		return scalarPropertyRangeRestrictionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScalarPropertyCardinalityRestrictionAxiom createScalarPropertyCardinalityRestrictionAxiom() {
		ScalarPropertyCardinalityRestrictionAxiomImpl scalarPropertyCardinalityRestrictionAxiom = new ScalarPropertyCardinalityRestrictionAxiomImpl();
		return scalarPropertyCardinalityRestrictionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScalarPropertyValueRestrictionAxiom createScalarPropertyValueRestrictionAxiom() {
		ScalarPropertyValueRestrictionAxiomImpl scalarPropertyValueRestrictionAxiom = new ScalarPropertyValueRestrictionAxiomImpl();
		return scalarPropertyValueRestrictionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StructuredPropertyRangeRestrictionAxiom createStructuredPropertyRangeRestrictionAxiom() {
		StructuredPropertyRangeRestrictionAxiomImpl structuredPropertyRangeRestrictionAxiom = new StructuredPropertyRangeRestrictionAxiomImpl();
		return structuredPropertyRangeRestrictionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StructuredPropertyCardinalityRestrictionAxiom createStructuredPropertyCardinalityRestrictionAxiom() {
		StructuredPropertyCardinalityRestrictionAxiomImpl structuredPropertyCardinalityRestrictionAxiom = new StructuredPropertyCardinalityRestrictionAxiomImpl();
		return structuredPropertyCardinalityRestrictionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StructuredPropertyValueRestrictionAxiom createStructuredPropertyValueRestrictionAxiom() {
		StructuredPropertyValueRestrictionAxiomImpl structuredPropertyValueRestrictionAxiom = new StructuredPropertyValueRestrictionAxiomImpl();
		return structuredPropertyValueRestrictionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationRangeRestrictionAxiom createRelationRangeRestrictionAxiom() {
		RelationRangeRestrictionAxiomImpl relationRangeRestrictionAxiom = new RelationRangeRestrictionAxiomImpl();
		return relationRangeRestrictionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationCardinalityRestrictionAxiom createRelationCardinalityRestrictionAxiom() {
		RelationCardinalityRestrictionAxiomImpl relationCardinalityRestrictionAxiom = new RelationCardinalityRestrictionAxiomImpl();
		return relationCardinalityRestrictionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationTargetRestrictionAxiom createRelationTargetRestrictionAxiom() {
		RelationTargetRestrictionAxiomImpl relationTargetRestrictionAxiom = new RelationTargetRestrictionAxiomImpl();
		return relationTargetRestrictionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConceptTypeAssertion createConceptTypeAssertion() {
		ConceptTypeAssertionImpl conceptTypeAssertion = new ConceptTypeAssertionImpl();
		return conceptTypeAssertion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationTypeAssertion createRelationTypeAssertion() {
		RelationTypeAssertionImpl relationTypeAssertion = new RelationTypeAssertionImpl();
		return relationTypeAssertion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScalarPropertyValueAssertion createScalarPropertyValueAssertion() {
		ScalarPropertyValueAssertionImpl scalarPropertyValueAssertion = new ScalarPropertyValueAssertionImpl();
		return scalarPropertyValueAssertion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StructuredPropertyValueAssertion createStructuredPropertyValueAssertion() {
		StructuredPropertyValueAssertionImpl structuredPropertyValueAssertion = new StructuredPropertyValueAssertionImpl();
		return structuredPropertyValueAssertion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LinkAssertion createLinkAssertion() {
		LinkAssertionImpl linkAssertion = new LinkAssertionImpl();
		return linkAssertion;
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
	@Override
	public AspectReference createAspectReference() {
		AspectReferenceImpl aspectReference = new AspectReferenceImpl();
		return aspectReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConceptReference createConceptReference() {
		ConceptReferenceImpl conceptReference = new ConceptReferenceImpl();
		return conceptReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationEntityReference createRelationEntityReference() {
		RelationEntityReferenceImpl relationEntityReference = new RelationEntityReferenceImpl();
		return relationEntityReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StructureReference createStructureReference() {
		StructureReferenceImpl structureReference = new StructureReferenceImpl();
		return structureReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnnotationPropertyReference createAnnotationPropertyReference() {
		AnnotationPropertyReferenceImpl annotationPropertyReference = new AnnotationPropertyReferenceImpl();
		return annotationPropertyReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScalarPropertyReference createScalarPropertyReference() {
		ScalarPropertyReferenceImpl scalarPropertyReference = new ScalarPropertyReferenceImpl();
		return scalarPropertyReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StructuredPropertyReference createStructuredPropertyReference() {
		StructuredPropertyReferenceImpl structuredPropertyReference = new StructuredPropertyReferenceImpl();
		return structuredPropertyReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FacetedScalarReference createFacetedScalarReference() {
		FacetedScalarReferenceImpl facetedScalarReference = new FacetedScalarReferenceImpl();
		return facetedScalarReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumeratedScalarReference createEnumeratedScalarReference() {
		EnumeratedScalarReferenceImpl enumeratedScalarReference = new EnumeratedScalarReferenceImpl();
		return enumeratedScalarReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationReference createRelationReference() {
		RelationReferenceImpl relationReference = new RelationReferenceImpl();
		return relationReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RuleReference createRuleReference() {
		RuleReferenceImpl ruleReference = new RuleReferenceImpl();
		return ruleReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConceptInstanceReference createConceptInstanceReference() {
		ConceptInstanceReferenceImpl conceptInstanceReference = new ConceptInstanceReferenceImpl();
		return conceptInstanceReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationInstanceReference createRelationInstanceReference() {
		RelationInstanceReferenceImpl relationInstanceReference = new RelationInstanceReferenceImpl();
		return relationInstanceReference;
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
