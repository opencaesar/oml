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
			public Adapter caseArgument(Argument object) {
				return createArgumentAdapter();
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
			public Adapter caseStatement(Statement object) {
				return createStatementAdapter();
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
			public Adapter caseVocabularyStatement(VocabularyStatement object) {
				return createVocabularyStatementAdapter();
			}
			@Override
			public Adapter caseDescriptionStatement(DescriptionStatement object) {
				return createDescriptionStatementAdapter();
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
			public Adapter caseBuiltIn(BuiltIn object) {
				return createBuiltInAdapter();
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
			public Adapter caseSpecializableProperty(SpecializableProperty object) {
				return createSpecializablePropertyAdapter();
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
			public Adapter caseInstanceEnumerationAxiom(InstanceEnumerationAxiom object) {
				return createInstanceEnumerationAxiomAdapter();
			}
			@Override
			public Adapter casePropertyRestrictionAxiom(PropertyRestrictionAxiom object) {
				return createPropertyRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseLiteralEnumerationAxiom(LiteralEnumerationAxiom object) {
				return createLiteralEnumerationAxiomAdapter();
			}
			@Override
			public Adapter caseClassifierEquivalenceAxiom(ClassifierEquivalenceAxiom object) {
				return createClassifierEquivalenceAxiomAdapter();
			}
			@Override
			public Adapter casePropertyEquivalenceAxiom(PropertyEquivalenceAxiom object) {
				return createPropertyEquivalenceAxiomAdapter();
			}
			@Override
			public Adapter casePropertyRangeRestrictionAxiom(PropertyRangeRestrictionAxiom object) {
				return createPropertyRangeRestrictionAxiomAdapter();
			}
			@Override
			public Adapter casePropertyCardinalityRestrictionAxiom(PropertyCardinalityRestrictionAxiom object) {
				return createPropertyCardinalityRestrictionAxiomAdapter();
			}
			@Override
			public Adapter casePropertyValueRestrictionAxiom(PropertyValueRestrictionAxiom object) {
				return createPropertyValueRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseTypeAssertion(TypeAssertion object) {
				return createTypeAssertionAdapter();
			}
			@Override
			public Adapter casePropertyValueAssertion(PropertyValueAssertion object) {
				return createPropertyValueAssertionAdapter();
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
			public Adapter caseBuiltInPredicate(BuiltInPredicate object) {
				return createBuiltInPredicateAdapter();
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
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.Argument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.Argument
	 * @generated
	 */
	public Adapter createArgumentAdapter() {
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
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.BuiltIn <em>Built In</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.BuiltIn
	 * @generated
	 */
	public Adapter createBuiltInAdapter() {
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
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.SpecializableProperty <em>Specializable Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.SpecializableProperty
	 * @generated
	 */
	public Adapter createSpecializablePropertyAdapter() {
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
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.InstanceEnumerationAxiom <em>Instance Enumeration Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.InstanceEnumerationAxiom
	 * @generated
	 */
	public Adapter createInstanceEnumerationAxiomAdapter() {
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
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.LiteralEnumerationAxiom <em>Literal Enumeration Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.LiteralEnumerationAxiom
	 * @generated
	 */
	public Adapter createLiteralEnumerationAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.ClassifierEquivalenceAxiom <em>Classifier Equivalence Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.ClassifierEquivalenceAxiom
	 * @generated
	 */
	public Adapter createClassifierEquivalenceAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.PropertyEquivalenceAxiom <em>Property Equivalence Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.PropertyEquivalenceAxiom
	 * @generated
	 */
	public Adapter createPropertyEquivalenceAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.PropertyRangeRestrictionAxiom <em>Property Range Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.PropertyRangeRestrictionAxiom
	 * @generated
	 */
	public Adapter createPropertyRangeRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.PropertyCardinalityRestrictionAxiom <em>Property Cardinality Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.PropertyCardinalityRestrictionAxiom
	 * @generated
	 */
	public Adapter createPropertyCardinalityRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.PropertyValueRestrictionAxiom <em>Property Value Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.PropertyValueRestrictionAxiom
	 * @generated
	 */
	public Adapter createPropertyValueRestrictionAxiomAdapter() {
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
	 * Creates a new adapter for an object of class '{@link io.opencaesar.oml.BuiltInPredicate <em>Built In Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see io.opencaesar.oml.BuiltInPredicate
	 * @generated
	 */
	public Adapter createBuiltInPredicateAdapter() {
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
