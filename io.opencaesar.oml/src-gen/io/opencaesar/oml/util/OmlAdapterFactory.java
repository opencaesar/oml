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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see io.opencaesar.oml.OmlPackage
 * @generated
 */
public class OmlAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OmlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OmlAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = OmlPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OmlSwitch<Adapter> modelSwitch =
		new OmlSwitch<Adapter>() {
			@Override
			public Adapter caseElement(Element object) {
				return createElementAdapter();
			}
			@Override
			public Adapter caseAnnotation(Annotation object) {
				return createAnnotationAdapter();
			}
			@Override
			public Adapter caseIdentifiedElement(IdentifiedElement object) {
				return createIdentifiedElementAdapter();
			}
			@Override
			public Adapter caseImport(Import object) {
				return createImportAdapter();
			}
			@Override
			public Adapter caseInstance(Instance object) {
				return createInstanceAdapter();
			}
			@Override
			public Adapter caseStatement(Statement object) {
				return createStatementAdapter();
			}
			@Override
			public Adapter caseAxiom(Axiom object) {
				return createAxiomAdapter();
			}
			@Override
			public Adapter caseAssertion(Assertion object) {
				return createAssertionAdapter();
			}
			@Override
			public Adapter casePredicate(Predicate object) {
				return createPredicateAdapter();
			}
			@Override
			public Adapter caseLiteral(Literal object) {
				return createLiteralAdapter();
			}
			@Override
			public Adapter caseOntology(Ontology object) {
				return createOntologyAdapter();
			}
			@Override
			public Adapter caseMember(Member object) {
				return createMemberAdapter();
			}
			@Override
			public Adapter caseVocabularyBox(VocabularyBox object) {
				return createVocabularyBoxAdapter();
			}
			@Override
			public Adapter caseDescriptionBox(DescriptionBox object) {
				return createDescriptionBoxAdapter();
			}
			@Override
			public Adapter caseVocabulary(Vocabulary object) {
				return createVocabularyAdapter();
			}
			@Override
			public Adapter caseVocabularyBundle(VocabularyBundle object) {
				return createVocabularyBundleAdapter();
			}
			@Override
			public Adapter caseDescription(Description object) {
				return createDescriptionAdapter();
			}
			@Override
			public Adapter caseDescriptionBundle(DescriptionBundle object) {
				return createDescriptionBundleAdapter();
			}
			@Override
			public Adapter caseExtension(Extension object) {
				return createExtensionAdapter();
			}
			@Override
			public Adapter caseUsage(Usage object) {
				return createUsageAdapter();
			}
			@Override
			public Adapter caseInclusion(Inclusion object) {
				return createInclusionAdapter();
			}
			@Override
			public Adapter caseVocabularyStatement(VocabularyStatement object) {
				return createVocabularyStatementAdapter();
			}
			@Override
			public Adapter caseDescriptionStatement(DescriptionStatement object) {
				return createDescriptionStatementAdapter();
			}
			@Override
			public Adapter caseVocabularyMember(VocabularyMember object) {
				return createVocabularyMemberAdapter();
			}
			@Override
			public Adapter caseDescriptionMember(DescriptionMember object) {
				return createDescriptionMemberAdapter();
			}
			@Override
			public Adapter caseTerm(Term object) {
				return createTermAdapter();
			}
			@Override
			public Adapter caseRule(Rule object) {
				return createRuleAdapter();
			}
			@Override
			public Adapter caseSpecializableTerm(SpecializableTerm object) {
				return createSpecializableTermAdapter();
			}
			@Override
			public Adapter caseProperty(Property object) {
				return createPropertyAdapter();
			}
			@Override
			public Adapter caseType(Type object) {
				return createTypeAdapter();
			}
			@Override
			public Adapter caseRelationBase(RelationBase object) {
				return createRelationBaseAdapter();
			}
			@Override
			public Adapter caseClassifier(Classifier object) {
				return createClassifierAdapter();
			}
			@Override
			public Adapter caseScalar(Scalar object) {
				return createScalarAdapter();
			}
			@Override
			public Adapter caseEntity(Entity object) {
				return createEntityAdapter();
			}
			@Override
			public Adapter caseStructure(Structure object) {
				return createStructureAdapter();
			}
			@Override
			public Adapter caseAspect(Aspect object) {
				return createAspectAdapter();
			}
			@Override
			public Adapter caseConcept(Concept object) {
				return createConceptAdapter();
			}
			@Override
			public Adapter caseRelationEntity(RelationEntity object) {
				return createRelationEntityAdapter();
			}
			@Override
			public Adapter caseFacetedScalar(FacetedScalar object) {
				return createFacetedScalarAdapter();
			}
			@Override
			public Adapter caseEnumeratedScalar(EnumeratedScalar object) {
				return createEnumeratedScalarAdapter();
			}
			@Override
			public Adapter caseAnnotationProperty(AnnotationProperty object) {
				return createAnnotationPropertyAdapter();
			}
			@Override
			public Adapter caseSemanticProperty(SemanticProperty object) {
				return createSemanticPropertyAdapter();
			}
			@Override
			public Adapter caseScalarProperty(ScalarProperty object) {
				return createScalarPropertyAdapter();
			}
			@Override
			public Adapter caseStructuredProperty(StructuredProperty object) {
				return createStructuredPropertyAdapter();
			}
			@Override
			public Adapter caseRelation(Relation object) {
				return createRelationAdapter();
			}
			@Override
			public Adapter caseForwardRelation(ForwardRelation object) {
				return createForwardRelationAdapter();
			}
			@Override
			public Adapter caseReverseRelation(ReverseRelation object) {
				return createReverseRelationAdapter();
			}
			@Override
			public Adapter caseUnreifiedRelation(UnreifiedRelation object) {
				return createUnreifiedRelationAdapter();
			}
			@Override
			public Adapter caseNamedInstance(NamedInstance object) {
				return createNamedInstanceAdapter();
			}
			@Override
			public Adapter caseConceptInstance(ConceptInstance object) {
				return createConceptInstanceAdapter();
			}
			@Override
			public Adapter caseRelationInstance(RelationInstance object) {
				return createRelationInstanceAdapter();
			}
			@Override
			public Adapter caseStructureInstance(StructureInstance object) {
				return createStructureInstanceAdapter();
			}
			@Override
			public Adapter caseKeyAxiom(KeyAxiom object) {
				return createKeyAxiomAdapter();
			}
			@Override
			public Adapter caseSpecializationAxiom(SpecializationAxiom object) {
				return createSpecializationAxiomAdapter();
			}
			@Override
			public Adapter casePropertyRestrictionAxiom(PropertyRestrictionAxiom object) {
				return createPropertyRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseScalarPropertyRestrictionAxiom(ScalarPropertyRestrictionAxiom object) {
				return createScalarPropertyRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseScalarPropertyRangeRestrictionAxiom(ScalarPropertyRangeRestrictionAxiom object) {
				return createScalarPropertyRangeRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseScalarPropertyCardinalityRestrictionAxiom(ScalarPropertyCardinalityRestrictionAxiom object) {
				return createScalarPropertyCardinalityRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseScalarPropertyValueRestrictionAxiom(ScalarPropertyValueRestrictionAxiom object) {
				return createScalarPropertyValueRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseStructuredPropertyRestrictionAxiom(StructuredPropertyRestrictionAxiom object) {
				return createStructuredPropertyRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseStructuredPropertyRangeRestrictionAxiom(StructuredPropertyRangeRestrictionAxiom object) {
				return createStructuredPropertyRangeRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseStructuredPropertyCardinalityRestrictionAxiom(StructuredPropertyCardinalityRestrictionAxiom object) {
				return createStructuredPropertyCardinalityRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseStructuredPropertyValueRestrictionAxiom(StructuredPropertyValueRestrictionAxiom object) {
				return createStructuredPropertyValueRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseRelationRestrictionAxiom(RelationRestrictionAxiom object) {
				return createRelationRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseRelationRangeRestrictionAxiom(RelationRangeRestrictionAxiom object) {
				return createRelationRangeRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseRelationCardinalityRestrictionAxiom(RelationCardinalityRestrictionAxiom object) {
				return createRelationCardinalityRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseRelationValueRestrictionAxiom(RelationValueRestrictionAxiom object) {
				return createRelationValueRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseTypeAssertion(TypeAssertion object) {
				return createTypeAssertionAdapter();
			}
			@Override
			public Adapter caseConceptTypeAssertion(ConceptTypeAssertion object) {
				return createConceptTypeAssertionAdapter();
			}
			@Override
			public Adapter caseRelationTypeAssertion(RelationTypeAssertion object) {
				return createRelationTypeAssertionAdapter();
			}
			@Override
			public Adapter casePropertyValueAssertion(PropertyValueAssertion object) {
				return createPropertyValueAssertionAdapter();
			}
			@Override
			public Adapter caseScalarPropertyValueAssertion(ScalarPropertyValueAssertion object) {
				return createScalarPropertyValueAssertionAdapter();
			}
			@Override
			public Adapter caseStructuredPropertyValueAssertion(StructuredPropertyValueAssertion object) {
				return createStructuredPropertyValueAssertionAdapter();
			}
			@Override
			public Adapter caseLinkAssertion(LinkAssertion object) {
				return createLinkAssertionAdapter();
			}
			@Override
			public Adapter caseUnaryPredicate(UnaryPredicate object) {
				return createUnaryPredicateAdapter();
			}
			@Override
			public Adapter caseBinaryPredicate(BinaryPredicate object) {
				return createBinaryPredicateAdapter();
			}
			@Override
			public Adapter caseTypePredicate(TypePredicate object) {
				return createTypePredicateAdapter();
			}
			@Override
			public Adapter caseRelationEntityPredicate(RelationEntityPredicate object) {
				return createRelationEntityPredicateAdapter();
			}
			@Override
			public Adapter casePropertyPredicate(PropertyPredicate object) {
				return createPropertyPredicateAdapter();
			}
			@Override
			public Adapter caseSameAsPredicate(SameAsPredicate object) {
				return createSameAsPredicateAdapter();
			}
			@Override
			public Adapter caseDifferentFromPredicate(DifferentFromPredicate object) {
				return createDifferentFromPredicateAdapter();
			}
			@Override
			public Adapter caseQuotedLiteral(QuotedLiteral object) {
				return createQuotedLiteralAdapter();
			}
			@Override
			public Adapter caseIntegerLiteral(IntegerLiteral object) {
				return createIntegerLiteralAdapter();
			}
			@Override
			public Adapter caseDecimalLiteral(DecimalLiteral object) {
				return createDecimalLiteralAdapter();
			}
			@Override
			public Adapter caseDoubleLiteral(DoubleLiteral object) {
				return createDoubleLiteralAdapter();
			}
			@Override
			public Adapter caseBooleanLiteral(BooleanLiteral object) {
				return createBooleanLiteralAdapter();
			}
			@Override
			public Adapter caseReference(Reference object) {
				return createReferenceAdapter();
			}
			@Override
			public Adapter caseSpecializableTermReference(SpecializableTermReference object) {
				return createSpecializableTermReferenceAdapter();
			}
			@Override
			public Adapter caseClassifierReference(ClassifierReference object) {
				return createClassifierReferenceAdapter();
			}
			@Override
			public Adapter caseEntityReference(EntityReference object) {
				return createEntityReferenceAdapter();
			}
			@Override
			public Adapter caseAspectReference(AspectReference object) {
				return createAspectReferenceAdapter();
			}
			@Override
			public Adapter caseConceptReference(ConceptReference object) {
				return createConceptReferenceAdapter();
			}
			@Override
			public Adapter caseRelationEntityReference(RelationEntityReference object) {
				return createRelationEntityReferenceAdapter();
			}
			@Override
			public Adapter caseStructureReference(StructureReference object) {
				return createStructureReferenceAdapter();
			}
			@Override
			public Adapter caseAnnotationPropertyReference(AnnotationPropertyReference object) {
				return createAnnotationPropertyReferenceAdapter();
			}
			@Override
			public Adapter caseScalarPropertyReference(ScalarPropertyReference object) {
				return createScalarPropertyReferenceAdapter();
			}
			@Override
			public Adapter caseStructuredPropertyReference(StructuredPropertyReference object) {
				return createStructuredPropertyReferenceAdapter();
			}
			@Override
			public Adapter caseFacetedScalarReference(FacetedScalarReference object) {
				return createFacetedScalarReferenceAdapter();
			}
			@Override
			public Adapter caseEnumeratedScalarReference(EnumeratedScalarReference object) {
				return createEnumeratedScalarReferenceAdapter();
			}
			@Override
			public Adapter caseRelationReference(RelationReference object) {
				return createRelationReferenceAdapter();
			}
			@Override
			public Adapter caseRuleReference(RuleReference object) {
				return createRuleReferenceAdapter();
			}
			@Override
			public Adapter caseNamedInstanceReference(NamedInstanceReference object) {
				return createNamedInstanceReferenceAdapter();
			}
			@Override
			public Adapter caseConceptInstanceReference(ConceptInstanceReference object) {
				return createConceptInstanceReferenceAdapter();
			}
			@Override
			public Adapter caseRelationInstanceReference(RelationInstanceReference object) {
				return createRelationInstanceReferenceAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Annotation
	 * @generated
	 */
	public Adapter createAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.IdentifiedElement <em>Identified Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.IdentifiedElement
	 * @generated
	 */
	public Adapter createIdentifiedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Import
	 * @generated
	 */
	public Adapter createImportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Instance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Instance
	 * @generated
	 */
	public Adapter createInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Statement
	 * @generated
	 */
	public Adapter createStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Axiom <em>Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Axiom
	 * @generated
	 */
	public Adapter createAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Assertion <em>Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Assertion
	 * @generated
	 */
	public Adapter createAssertionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Predicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Predicate
	 * @generated
	 */
	public Adapter createPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Literal
	 * @generated
	 */
	public Adapter createLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Ontology <em>Ontology</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Ontology
	 * @generated
	 */
	public Adapter createOntologyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Member <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Member
	 * @generated
	 */
	public Adapter createMemberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.VocabularyBox <em>Vocabulary Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.VocabularyBox
	 * @generated
	 */
	public Adapter createVocabularyBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.DescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.DescriptionBox
	 * @generated
	 */
	public Adapter createDescriptionBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Vocabulary <em>Vocabulary</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Vocabulary
	 * @generated
	 */
	public Adapter createVocabularyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.VocabularyBundle <em>Vocabulary Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.VocabularyBundle
	 * @generated
	 */
	public Adapter createVocabularyBundleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Description <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Description
	 * @generated
	 */
	public Adapter createDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.DescriptionBundle <em>Description Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.DescriptionBundle
	 * @generated
	 */
	public Adapter createDescriptionBundleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Extension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Extension
	 * @generated
	 */
	public Adapter createExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Usage <em>Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Usage
	 * @generated
	 */
	public Adapter createUsageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Inclusion <em>Inclusion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Inclusion
	 * @generated
	 */
	public Adapter createInclusionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.VocabularyStatement <em>Vocabulary Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.VocabularyStatement
	 * @generated
	 */
	public Adapter createVocabularyStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.DescriptionStatement <em>Description Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.DescriptionStatement
	 * @generated
	 */
	public Adapter createDescriptionStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.VocabularyMember <em>Vocabulary Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.VocabularyMember
	 * @generated
	 */
	public Adapter createVocabularyMemberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.DescriptionMember <em>Description Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.DescriptionMember
	 * @generated
	 */
	public Adapter createDescriptionMemberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Term <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Term
	 * @generated
	 */
	public Adapter createTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Rule
	 * @generated
	 */
	public Adapter createRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.SpecializableTerm <em>Specializable Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.SpecializableTerm
	 * @generated
	 */
	public Adapter createSpecializableTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.RelationBase <em>Relation Base</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.RelationBase
	 * @generated
	 */
	public Adapter createRelationBaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Classifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Classifier
	 * @generated
	 */
	public Adapter createClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Scalar <em>Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Scalar
	 * @generated
	 */
	public Adapter createScalarAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Entity
	 * @generated
	 */
	public Adapter createEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Structure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Structure
	 * @generated
	 */
	public Adapter createStructureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Aspect <em>Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Aspect
	 * @generated
	 */
	public Adapter createAspectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Concept <em>Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Concept
	 * @generated
	 */
	public Adapter createConceptAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.RelationEntity <em>Relation Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.RelationEntity
	 * @generated
	 */
	public Adapter createRelationEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.FacetedScalar <em>Faceted Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.FacetedScalar
	 * @generated
	 */
	public Adapter createFacetedScalarAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.EnumeratedScalar <em>Enumerated Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.EnumeratedScalar
	 * @generated
	 */
	public Adapter createEnumeratedScalarAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.AnnotationProperty <em>Annotation Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.AnnotationProperty
	 * @generated
	 */
	public Adapter createAnnotationPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.SemanticProperty <em>Semantic Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.SemanticProperty
	 * @generated
	 */
	public Adapter createSemanticPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.ScalarProperty <em>Scalar Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.ScalarProperty
	 * @generated
	 */
	public Adapter createScalarPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.StructuredProperty <em>Structured Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.StructuredProperty
	 * @generated
	 */
	public Adapter createStructuredPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Relation
	 * @generated
	 */
	public Adapter createRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.ForwardRelation <em>Forward Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.ForwardRelation
	 * @generated
	 */
	public Adapter createForwardRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.ReverseRelation <em>Reverse Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.ReverseRelation
	 * @generated
	 */
	public Adapter createReverseRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.UnreifiedRelation <em>Unreified Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.UnreifiedRelation
	 * @generated
	 */
	public Adapter createUnreifiedRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.NamedInstance <em>Named Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.NamedInstance
	 * @generated
	 */
	public Adapter createNamedInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.ConceptInstance <em>Concept Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.ConceptInstance
	 * @generated
	 */
	public Adapter createConceptInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.RelationInstance <em>Relation Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.RelationInstance
	 * @generated
	 */
	public Adapter createRelationInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.StructureInstance <em>Structure Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.StructureInstance
	 * @generated
	 */
	public Adapter createStructureInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.KeyAxiom <em>Key Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.KeyAxiom
	 * @generated
	 */
	public Adapter createKeyAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.SpecializationAxiom <em>Specialization Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.SpecializationAxiom
	 * @generated
	 */
	public Adapter createSpecializationAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.PropertyRestrictionAxiom <em>Property Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.PropertyRestrictionAxiom
	 * @generated
	 */
	public Adapter createPropertyRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.ScalarPropertyRestrictionAxiom <em>Scalar Property Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.ScalarPropertyRestrictionAxiom
	 * @generated
	 */
	public Adapter createScalarPropertyRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.ScalarPropertyRangeRestrictionAxiom <em>Scalar Property Range Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.ScalarPropertyRangeRestrictionAxiom
	 * @generated
	 */
	public Adapter createScalarPropertyRangeRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.ScalarPropertyCardinalityRestrictionAxiom <em>Scalar Property Cardinality Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.ScalarPropertyCardinalityRestrictionAxiom
	 * @generated
	 */
	public Adapter createScalarPropertyCardinalityRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.ScalarPropertyValueRestrictionAxiom <em>Scalar Property Value Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.ScalarPropertyValueRestrictionAxiom
	 * @generated
	 */
	public Adapter createScalarPropertyValueRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.StructuredPropertyRestrictionAxiom <em>Structured Property Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.StructuredPropertyRestrictionAxiom
	 * @generated
	 */
	public Adapter createStructuredPropertyRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.StructuredPropertyRangeRestrictionAxiom <em>Structured Property Range Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.StructuredPropertyRangeRestrictionAxiom
	 * @generated
	 */
	public Adapter createStructuredPropertyRangeRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.StructuredPropertyCardinalityRestrictionAxiom <em>Structured Property Cardinality Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.StructuredPropertyCardinalityRestrictionAxiom
	 * @generated
	 */
	public Adapter createStructuredPropertyCardinalityRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.StructuredPropertyValueRestrictionAxiom <em>Structured Property Value Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.StructuredPropertyValueRestrictionAxiom
	 * @generated
	 */
	public Adapter createStructuredPropertyValueRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.RelationRestrictionAxiom <em>Relation Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.RelationRestrictionAxiom
	 * @generated
	 */
	public Adapter createRelationRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.RelationRangeRestrictionAxiom <em>Relation Range Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.RelationRangeRestrictionAxiom
	 * @generated
	 */
	public Adapter createRelationRangeRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.RelationCardinalityRestrictionAxiom <em>Relation Cardinality Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.RelationCardinalityRestrictionAxiom
	 * @generated
	 */
	public Adapter createRelationCardinalityRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.RelationValueRestrictionAxiom <em>Relation Value Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.RelationValueRestrictionAxiom
	 * @generated
	 */
	public Adapter createRelationValueRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.TypeAssertion <em>Type Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.TypeAssertion
	 * @generated
	 */
	public Adapter createTypeAssertionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.ConceptTypeAssertion <em>Concept Type Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.ConceptTypeAssertion
	 * @generated
	 */
	public Adapter createConceptTypeAssertionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.RelationTypeAssertion <em>Relation Type Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.RelationTypeAssertion
	 * @generated
	 */
	public Adapter createRelationTypeAssertionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.PropertyValueAssertion <em>Property Value Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.PropertyValueAssertion
	 * @generated
	 */
	public Adapter createPropertyValueAssertionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.ScalarPropertyValueAssertion <em>Scalar Property Value Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.ScalarPropertyValueAssertion
	 * @generated
	 */
	public Adapter createScalarPropertyValueAssertionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.StructuredPropertyValueAssertion <em>Structured Property Value Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.StructuredPropertyValueAssertion
	 * @generated
	 */
	public Adapter createStructuredPropertyValueAssertionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.LinkAssertion <em>Link Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.LinkAssertion
	 * @generated
	 */
	public Adapter createLinkAssertionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.UnaryPredicate <em>Unary Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.UnaryPredicate
	 * @generated
	 */
	public Adapter createUnaryPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.BinaryPredicate <em>Binary Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.BinaryPredicate
	 * @generated
	 */
	public Adapter createBinaryPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.TypePredicate <em>Type Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.TypePredicate
	 * @generated
	 */
	public Adapter createTypePredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.RelationEntityPredicate <em>Relation Entity Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.RelationEntityPredicate
	 * @generated
	 */
	public Adapter createRelationEntityPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.PropertyPredicate <em>Property Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.PropertyPredicate
	 * @generated
	 */
	public Adapter createPropertyPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.SameAsPredicate <em>Same As Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.SameAsPredicate
	 * @generated
	 */
	public Adapter createSameAsPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.DifferentFromPredicate <em>Different From Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.DifferentFromPredicate
	 * @generated
	 */
	public Adapter createDifferentFromPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.QuotedLiteral <em>Quoted Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.QuotedLiteral
	 * @generated
	 */
	public Adapter createQuotedLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.IntegerLiteral <em>Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.IntegerLiteral
	 * @generated
	 */
	public Adapter createIntegerLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.DecimalLiteral <em>Decimal Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.DecimalLiteral
	 * @generated
	 */
	public Adapter createDecimalLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.DoubleLiteral <em>Double Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.DoubleLiteral
	 * @generated
	 */
	public Adapter createDoubleLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.BooleanLiteral
	 * @generated
	 */
	public Adapter createBooleanLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Reference
	 * @generated
	 */
	public Adapter createReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.SpecializableTermReference <em>Specializable Term Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.SpecializableTermReference
	 * @generated
	 */
	public Adapter createSpecializableTermReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.ClassifierReference <em>Classifier Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.ClassifierReference
	 * @generated
	 */
	public Adapter createClassifierReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.EntityReference <em>Entity Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.EntityReference
	 * @generated
	 */
	public Adapter createEntityReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.AspectReference <em>Aspect Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.AspectReference
	 * @generated
	 */
	public Adapter createAspectReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.ConceptReference <em>Concept Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.ConceptReference
	 * @generated
	 */
	public Adapter createConceptReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.RelationEntityReference <em>Relation Entity Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.RelationEntityReference
	 * @generated
	 */
	public Adapter createRelationEntityReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.StructureReference <em>Structure Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.StructureReference
	 * @generated
	 */
	public Adapter createStructureReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.AnnotationPropertyReference <em>Annotation Property Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.AnnotationPropertyReference
	 * @generated
	 */
	public Adapter createAnnotationPropertyReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.ScalarPropertyReference <em>Scalar Property Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.ScalarPropertyReference
	 * @generated
	 */
	public Adapter createScalarPropertyReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.StructuredPropertyReference <em>Structured Property Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.StructuredPropertyReference
	 * @generated
	 */
	public Adapter createStructuredPropertyReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.FacetedScalarReference <em>Faceted Scalar Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.FacetedScalarReference
	 * @generated
	 */
	public Adapter createFacetedScalarReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.EnumeratedScalarReference <em>Enumerated Scalar Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.EnumeratedScalarReference
	 * @generated
	 */
	public Adapter createEnumeratedScalarReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.RelationReference <em>Relation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.RelationReference
	 * @generated
	 */
	public Adapter createRelationReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.RuleReference <em>Rule Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.RuleReference
	 * @generated
	 */
	public Adapter createRuleReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.NamedInstanceReference <em>Named Instance Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.NamedInstanceReference
	 * @generated
	 */
	public Adapter createNamedInstanceReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.ConceptInstanceReference <em>Concept Instance Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.ConceptInstanceReference
	 * @generated
	 */
	public Adapter createConceptInstanceReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.RelationInstanceReference <em>Relation Instance Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.RelationInstanceReference
	 * @generated
	 */
	public Adapter createRelationInstanceReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //OmlAdapterFactory
