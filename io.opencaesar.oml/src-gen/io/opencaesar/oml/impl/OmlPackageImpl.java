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

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.Argument;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.Assertion;
import io.opencaesar.oml.Axiom;
import io.opencaesar.oml.BinaryPredicate;
import io.opencaesar.oml.BooleanLiteral;
import io.opencaesar.oml.BuiltIn;
import io.opencaesar.oml.BuiltInPredicate;
import io.opencaesar.oml.CardinalityRestrictionKind;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.ClassifierEquivalenceAxiom;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.DecimalLiteral;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBox;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.DescriptionMember;
import io.opencaesar.oml.DescriptionStatement;
import io.opencaesar.oml.DifferentFromPredicate;
import io.opencaesar.oml.DoubleLiteral;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.IdentifiedElement;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.ImportKind;
import io.opencaesar.oml.Instance;
import io.opencaesar.oml.InstanceEnumerationAxiom;
import io.opencaesar.oml.IntegerLiteral;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.LiteralEnumerationAxiom;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.OmlFactory;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.Predicate;
import io.opencaesar.oml.Property;
import io.opencaesar.oml.PropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.PropertyEquivalenceAxiom;
import io.opencaesar.oml.PropertyPredicate;
import io.opencaesar.oml.PropertyRangeRestrictionAxiom;
import io.opencaesar.oml.PropertyRestrictionAxiom;
import io.opencaesar.oml.PropertySelfRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.PropertyValueRestrictionAxiom;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.RangeRestrictionKind;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationBase;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.ReverseRelation;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.SameAsPredicate;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarEquivalenceAxiom;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.SemanticProperty;
import io.opencaesar.oml.SeparatorKind;
import io.opencaesar.oml.SpecializableProperty;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Statement;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.Term;
import io.opencaesar.oml.Type;
import io.opencaesar.oml.TypeAssertion;
import io.opencaesar.oml.TypePredicate;
import io.opencaesar.oml.UnaryPredicate;
import io.opencaesar.oml.UnreifiedRelation;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyBox;
import io.opencaesar.oml.VocabularyBundle;
import io.opencaesar.oml.VocabularyMember;
import io.opencaesar.oml.VocabularyStatement;

import io.opencaesar.oml.util.OmlValidator;

import java.math.BigDecimal;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OmlPackageImpl extends EPackageImpl implements OmlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifiedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass axiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assertionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass argumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ontologyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vocabularyBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vocabularyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vocabularyBundleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionBundleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vocabularyMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vocabularyStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass termEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass builtInEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specializableTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationBaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specializablePropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aspectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass semanticPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuredPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forwardRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reverseRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unreifiedRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keyAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specializationAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceEnumerationAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalEnumerationAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierEquivalenceAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarEquivalenceAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEquivalenceAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyRangeRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyCardinalityRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyValueRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertySelfRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeAssertionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyValueAssertionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass builtInPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typePredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationEntityPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sameAsPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass differentFromPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quotedLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decimalLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum separatorKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum rangeRestrictionKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cardinalityRestrictionKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum importKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType unsignedIntEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType unsignedIntegerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType decimalEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType doubleEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType idEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType namespaceEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see io.opencaesar.oml.OmlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OmlPackageImpl() {
		super(eNS_URI, OmlFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link OmlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OmlPackage init() {
		if (isInited) return (OmlPackage)EPackage.Registry.INSTANCE.getEPackage(OmlPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredOmlPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		OmlPackageImpl theOmlPackage = registeredOmlPackage instanceof OmlPackageImpl ? (OmlPackageImpl)registeredOmlPackage : new OmlPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOmlPackage.createPackageContents();

		// Initialize created meta-data
		theOmlPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theOmlPackage,
			 new EValidator.Descriptor() {
				 @Override
				 public EValidator getEValidator() {
					 return OmlValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theOmlPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OmlPackage.eNS_URI, theOmlPackage);
		return theOmlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getElement() {
		return elementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getElement__GetOntology() {
		return elementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getElement__ExtraValidate__DiagnosticChain_Map() {
		return elementEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAnnotation() {
		return annotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAnnotation_Property() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAnnotation_LiteralValue() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAnnotation_ReferencedValue() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAnnotation_OwningElement() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAnnotation__GetValue() {
		return annotationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAnnotation__GetAnnotatedElement() {
		return annotationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIdentifiedElement() {
		return identifiedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIdentifiedElement_OwnedAnnotations() {
		return (EReference)identifiedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getIdentifiedElement__GetIri() {
		return identifiedElementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImport() {
		return importEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImport_Kind() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImport_Namespace() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImport_Prefix() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImport_OwningOntology() {
		return (EReference)importEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getImport__GetIri() {
		return importEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getImport__GetSeparator() {
		return importEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInstance() {
		return instanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInstance_OwnedPropertyValues() {
		return (EReference)instanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getInstance__GetTypes() {
		return instanceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAxiom() {
		return axiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAxiom__GetCharacterizedTerm() {
		return axiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssertion() {
		return assertionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAssertion__GetSubject() {
		return assertionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAssertion__GetObject() {
		return assertionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPredicate() {
		return predicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPredicate_AntecedentRule() {
		return (EReference)predicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPredicate_ConsequentRule() {
		return (EReference)predicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getArgument() {
		return argumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getArgument_Variable() {
		return (EAttribute)argumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArgument_Literal() {
		return (EReference)argumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArgument_Instance() {
		return (EReference)argumentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getArgument__GetValue() {
		return argumentEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteral() {
		return literalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getLiteral__GetValue() {
		return literalEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getLiteral__GetStringValue() {
		return literalEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getLiteral__GetLexicalValue() {
		return literalEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getLiteral__GetTypeIri() {
		return literalEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOntology() {
		return ontologyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOntology_Namespace() {
		return (EAttribute)ontologyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOntology_Prefix() {
		return (EAttribute)ontologyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOntology_OwnedImports() {
		return (EReference)ontologyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getOntology__GetIri() {
		return ontologyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getOntology__GetSeparator() {
		return ontologyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMember() {
		return memberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMember_Name() {
		return (EAttribute)memberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMember__GetRef() {
		return memberEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMember__IsRef() {
		return memberEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMember__Resolve() {
		return memberEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMember__GetIri() {
		return memberEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMember__GetAbbreviatedIri() {
		return memberEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVocabularyBox() {
		return vocabularyBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptionBox() {
		return descriptionBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVocabulary() {
		return vocabularyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVocabulary_OwnedStatements() {
		return (EReference)vocabularyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVocabularyBundle() {
		return vocabularyBundleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescription() {
		return descriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDescription_OwnedStatements() {
		return (EReference)descriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptionBundle() {
		return descriptionBundleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStatement() {
		return statementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVocabularyMember() {
		return vocabularyMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptionMember() {
		return descriptionMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVocabularyStatement() {
		return vocabularyStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVocabularyStatement_OwningVocabulary() {
		return (EReference)vocabularyStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptionStatement() {
		return descriptionStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDescriptionStatement_OwningDescription() {
		return (EReference)descriptionStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTerm() {
		return termEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRule() {
		return ruleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRule_Ref() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRule_Antecedent() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRule_Consequent() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBuiltIn() {
		return builtInEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBuiltIn_Ref() {
		return (EReference)builtInEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSpecializableTerm() {
		return specializableTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpecializableTerm_OwnedSpecializations() {
		return (EReference)specializableTermEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationBase() {
		return relationBaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationBase_Sources() {
		return (EReference)relationBaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationBase_Targets() {
		return (EReference)relationBaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationBase_ReverseRelation() {
		return (EReference)relationBaseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationBase_Functional() {
		return (EAttribute)relationBaseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationBase_InverseFunctional() {
		return (EAttribute)relationBaseEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationBase_Symmetric() {
		return (EAttribute)relationBaseEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationBase_Asymmetric() {
		return (EAttribute)relationBaseEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationBase_Reflexive() {
		return (EAttribute)relationBaseEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationBase_Irreflexive() {
		return (EAttribute)relationBaseEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationBase_Transitive() {
		return (EAttribute)relationBaseEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSpecializableProperty() {
		return specializablePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpecializableProperty_OwnedEquivalences() {
		return (EReference)specializablePropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getClassifier() {
		return classifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassifier_OwnedEquivalences() {
		return (EReference)classifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassifier_OwnedPropertyRestrictions() {
		return (EReference)classifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScalar() {
		return scalarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalar_Ref() {
		return (EReference)scalarEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalar_OwnedEnumeration() {
		return (EReference)scalarEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalar_OwnedEquivalences() {
		return (EReference)scalarEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntity() {
		return entityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEntity_OwnedKeys() {
		return (EReference)entityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStructure() {
		return structureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructure_Ref() {
		return (EReference)structureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAspect() {
		return aspectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAspect_Ref() {
		return (EReference)aspectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConcept() {
		return conceptEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConcept_Ref() {
		return (EReference)conceptEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConcept_OwnedEnumeration() {
		return (EReference)conceptEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationEntity() {
		return relationEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationEntity_Ref() {
		return (EReference)relationEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationEntity_ForwardRelation() {
		return (EReference)relationEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAnnotationProperty() {
		return annotationPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAnnotationProperty_Ref() {
		return (EReference)annotationPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSemanticProperty() {
		return semanticPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSemanticProperty__IsFunctional() {
		return semanticPropertyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSemanticProperty__GetDomainList() {
		return semanticPropertyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSemanticProperty__GetRangeList() {
		return semanticPropertyEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScalarProperty() {
		return scalarPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalarProperty_Ref() {
		return (EReference)scalarPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScalarProperty_Functional() {
		return (EAttribute)scalarPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalarProperty_Domains() {
		return (EReference)scalarPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalarProperty_Ranges() {
		return (EReference)scalarPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getScalarProperty__GetDomainList() {
		return scalarPropertyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getScalarProperty__GetRangeList() {
		return scalarPropertyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStructuredProperty() {
		return structuredPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructuredProperty_Ref() {
		return (EReference)structuredPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStructuredProperty_Functional() {
		return (EAttribute)structuredPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructuredProperty_Domains() {
		return (EReference)structuredPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructuredProperty_Ranges() {
		return (EReference)structuredPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getStructuredProperty__GetDomainList() {
		return structuredPropertyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getStructuredProperty__GetRangeList() {
		return structuredPropertyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelation() {
		return relationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelation__IsInverseFunctional() {
		return relationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelation__IsSymmetric() {
		return relationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelation__IsAsymmetric() {
		return relationEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelation__IsReflexive() {
		return relationEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelation__IsIrreflexive() {
		return relationEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelation__IsTransitive() {
		return relationEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelation__GetDomains() {
		return relationEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelation__GetRanges() {
		return relationEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelation__GetInverse() {
		return relationEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelation__GetDomainList() {
		return relationEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelation__GetRangeList() {
		return relationEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getForwardRelation() {
		return forwardRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForwardRelation_RelationEntity() {
		return (EReference)forwardRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getForwardRelation__GetRef() {
		return forwardRelationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getForwardRelation__IsFunctional() {
		return forwardRelationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getForwardRelation__IsInverseFunctional() {
		return forwardRelationEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getForwardRelation__IsSymmetric() {
		return forwardRelationEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getForwardRelation__IsAsymmetric() {
		return forwardRelationEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getForwardRelation__IsReflexive() {
		return forwardRelationEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getForwardRelation__IsIrreflexive() {
		return forwardRelationEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getForwardRelation__IsTransitive() {
		return forwardRelationEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getForwardRelation__GetDomains() {
		return forwardRelationEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getForwardRelation__GetRanges() {
		return forwardRelationEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getForwardRelation__GetInverse() {
		return forwardRelationEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReverseRelation() {
		return reverseRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getReverseRelation_RelationBase() {
		return (EReference)reverseRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getReverseRelation__GetRef() {
		return reverseRelationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getReverseRelation__IsFunctional() {
		return reverseRelationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getReverseRelation__IsInverseFunctional() {
		return reverseRelationEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getReverseRelation__IsSymmetric() {
		return reverseRelationEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getReverseRelation__IsAsymmetric() {
		return reverseRelationEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getReverseRelation__IsReflexive() {
		return reverseRelationEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getReverseRelation__IsIrreflexive() {
		return reverseRelationEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getReverseRelation__IsTransitive() {
		return reverseRelationEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getReverseRelation__GetDomains() {
		return reverseRelationEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getReverseRelation__GetRanges() {
		return reverseRelationEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getReverseRelation__GetInverse() {
		return reverseRelationEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUnreifiedRelation() {
		return unreifiedRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUnreifiedRelation_Ref() {
		return (EReference)unreifiedRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getUnreifiedRelation__GetDomains() {
		return unreifiedRelationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getUnreifiedRelation__GetRanges() {
		return unreifiedRelationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getUnreifiedRelation__GetInverse() {
		return unreifiedRelationEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNamedInstance() {
		return namedInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNamedInstance_OwnedTypes() {
		return (EReference)namedInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNamedInstance__GetEntityTypes() {
		return namedInstanceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNamedInstance__GetTypes() {
		return namedInstanceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConceptInstance() {
		return conceptInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConceptInstance_Ref() {
		return (EReference)conceptInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationInstance() {
		return relationInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationInstance_Ref() {
		return (EReference)relationInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationInstance_Sources() {
		return (EReference)relationInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationInstance_Targets() {
		return (EReference)relationInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStructureInstance() {
		return structureInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructureInstance_Type() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructureInstance_OwningAxiom() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructureInstance_OwningAssertion() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getStructureInstance__GetTypes() {
		return structureInstanceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getKeyAxiom() {
		return keyAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getKeyAxiom_Properties() {
		return (EReference)keyAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getKeyAxiom_OwningEntity() {
		return (EReference)keyAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getKeyAxiom__GetKeyedEntity() {
		return keyAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getKeyAxiom__GetCharacterizedTerm() {
		return keyAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSpecializationAxiom() {
		return specializationAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpecializationAxiom_SuperTerm() {
		return (EReference)specializationAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpecializationAxiom_OwningTerm() {
		return (EReference)specializationAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSpecializationAxiom__GetSubTerm() {
		return specializationAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSpecializationAxiom__GetCharacterizedTerm() {
		return specializationAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInstanceEnumerationAxiom() {
		return instanceEnumerationAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInstanceEnumerationAxiom_Instances() {
		return (EReference)instanceEnumerationAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInstanceEnumerationAxiom_OwningConcept() {
		return (EReference)instanceEnumerationAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getInstanceEnumerationAxiom__GetEnumeratedConcept() {
		return instanceEnumerationAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getInstanceEnumerationAxiom__GetCharacterizedTerm() {
		return instanceEnumerationAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyRestrictionAxiom() {
		return propertyRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyRestrictionAxiom_Property() {
		return (EReference)propertyRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyRestrictionAxiom_OwningClassifier() {
		return (EReference)propertyRestrictionAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyRestrictionAxiom_OwningAxiom() {
		return (EReference)propertyRestrictionAxiomEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyRestrictionAxiom__GetRestrictingDomain() {
		return propertyRestrictionAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyRestrictionAxiom__GetCharacterizedTerm() {
		return propertyRestrictionAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralEnumerationAxiom() {
		return literalEnumerationAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteralEnumerationAxiom_Literals() {
		return (EReference)literalEnumerationAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteralEnumerationAxiom_OwningScalar() {
		return (EReference)literalEnumerationAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getLiteralEnumerationAxiom__GetEnumeratedScalar() {
		return literalEnumerationAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getLiteralEnumerationAxiom__GetCharacterizedTerm() {
		return literalEnumerationAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getClassifierEquivalenceAxiom() {
		return classifierEquivalenceAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassifierEquivalenceAxiom_SuperClassifiers() {
		return (EReference)classifierEquivalenceAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassifierEquivalenceAxiom_OwnedPropertyRestrictions() {
		return (EReference)classifierEquivalenceAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassifierEquivalenceAxiom_OwningClassifier() {
		return (EReference)classifierEquivalenceAxiomEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getClassifierEquivalenceAxiom__GetSubClassifier() {
		return classifierEquivalenceAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getClassifierEquivalenceAxiom__GetCharacterizedTerm() {
		return classifierEquivalenceAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScalarEquivalenceAxiom() {
		return scalarEquivalenceAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalarEquivalenceAxiom_SuperScalar() {
		return (EReference)scalarEquivalenceAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalarEquivalenceAxiom_OwningScalar() {
		return (EReference)scalarEquivalenceAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScalarEquivalenceAxiom_Length() {
		return (EAttribute)scalarEquivalenceAxiomEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScalarEquivalenceAxiom_MinLength() {
		return (EAttribute)scalarEquivalenceAxiomEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScalarEquivalenceAxiom_MaxLength() {
		return (EAttribute)scalarEquivalenceAxiomEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScalarEquivalenceAxiom_Pattern() {
		return (EAttribute)scalarEquivalenceAxiomEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScalarEquivalenceAxiom_Language() {
		return (EAttribute)scalarEquivalenceAxiomEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalarEquivalenceAxiom_MinInclusive() {
		return (EReference)scalarEquivalenceAxiomEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalarEquivalenceAxiom_MinExclusive() {
		return (EReference)scalarEquivalenceAxiomEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalarEquivalenceAxiom_MaxInclusive() {
		return (EReference)scalarEquivalenceAxiomEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalarEquivalenceAxiom_MaxExclusive() {
		return (EReference)scalarEquivalenceAxiomEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getScalarEquivalenceAxiom__GetSubScalar() {
		return scalarEquivalenceAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getScalarEquivalenceAxiom__GetCharacterizedTerm() {
		return scalarEquivalenceAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyEquivalenceAxiom() {
		return propertyEquivalenceAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyEquivalenceAxiom_SuperProperty() {
		return (EReference)propertyEquivalenceAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyEquivalenceAxiom_OwningProperty() {
		return (EReference)propertyEquivalenceAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyEquivalenceAxiom__GetSubProperty() {
		return propertyEquivalenceAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyEquivalenceAxiom__GetCharacterizedTerm() {
		return propertyEquivalenceAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyRangeRestrictionAxiom() {
		return propertyRangeRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPropertyRangeRestrictionAxiom_Kind() {
		return (EAttribute)propertyRangeRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyRangeRestrictionAxiom_Range() {
		return (EReference)propertyRangeRestrictionAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyCardinalityRestrictionAxiom() {
		return propertyCardinalityRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPropertyCardinalityRestrictionAxiom_Kind() {
		return (EAttribute)propertyCardinalityRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPropertyCardinalityRestrictionAxiom_Cardinality() {
		return (EAttribute)propertyCardinalityRestrictionAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyCardinalityRestrictionAxiom_Range() {
		return (EReference)propertyCardinalityRestrictionAxiomEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyValueRestrictionAxiom() {
		return propertyValueRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyValueRestrictionAxiom_LiteralValue() {
		return (EReference)propertyValueRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyValueRestrictionAxiom_ContainedValue() {
		return (EReference)propertyValueRestrictionAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyValueRestrictionAxiom_ReferencedValue() {
		return (EReference)propertyValueRestrictionAxiomEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyValueRestrictionAxiom__GetValue() {
		return propertyValueRestrictionAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertySelfRestrictionAxiom() {
		return propertySelfRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeAssertion() {
		return typeAssertionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypeAssertion_Type() {
		return (EReference)typeAssertionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypeAssertion_OwningInstance() {
		return (EReference)typeAssertionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTypeAssertion__GetSubject() {
		return typeAssertionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTypeAssertion__GetObject() {
		return typeAssertionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyValueAssertion() {
		return propertyValueAssertionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyValueAssertion_Property() {
		return (EReference)propertyValueAssertionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyValueAssertion_LiteralValue() {
		return (EReference)propertyValueAssertionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyValueAssertion_ContainedValue() {
		return (EReference)propertyValueAssertionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyValueAssertion_ReferencedValue() {
		return (EReference)propertyValueAssertionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyValueAssertion_OwningInstance() {
		return (EReference)propertyValueAssertionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyValueAssertion__GetValue() {
		return propertyValueAssertionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyValueAssertion__GetSubject() {
		return propertyValueAssertionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyValueAssertion__GetObject() {
		return propertyValueAssertionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUnaryPredicate() {
		return unaryPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUnaryPredicate_Argument() {
		return (EReference)unaryPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBinaryPredicate() {
		return binaryPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBinaryPredicate_Argument1() {
		return (EReference)binaryPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBinaryPredicate_Argument2() {
		return (EReference)binaryPredicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBuiltInPredicate() {
		return builtInPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBuiltInPredicate_BuiltIn() {
		return (EReference)builtInPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBuiltInPredicate_Arguments() {
		return (EReference)builtInPredicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypePredicate() {
		return typePredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypePredicate_Type() {
		return (EReference)typePredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationEntityPredicate() {
		return relationEntityPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationEntityPredicate_Type() {
		return (EReference)relationEntityPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyPredicate() {
		return propertyPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyPredicate_Property() {
		return (EReference)propertyPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSameAsPredicate() {
		return sameAsPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDifferentFromPredicate() {
		return differentFromPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getQuotedLiteral() {
		return quotedLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getQuotedLiteral_Value() {
		return (EAttribute)quotedLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getQuotedLiteral_LangTag() {
		return (EAttribute)quotedLiteralEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQuotedLiteral_Type() {
		return (EReference)quotedLiteralEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getQuotedLiteral__GetLexicalValue() {
		return quotedLiteralEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getQuotedLiteral__GetTypeIri() {
		return quotedLiteralEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntegerLiteral() {
		return integerLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntegerLiteral_Value() {
		return (EAttribute)integerLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getIntegerLiteral__GetTypeIri() {
		return integerLiteralEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDecimalLiteral() {
		return decimalLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDecimalLiteral_Value() {
		return (EAttribute)decimalLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDecimalLiteral__GetTypeIri() {
		return decimalLiteralEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDoubleLiteral() {
		return doubleLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDoubleLiteral_Value() {
		return (EAttribute)doubleLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDoubleLiteral__GetTypeIri() {
		return doubleLiteralEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBooleanLiteral() {
		return booleanLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBooleanLiteral_Value() {
		return (EAttribute)booleanLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getBooleanLiteral__IsValue() {
		return booleanLiteralEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getBooleanLiteral__GetTypeIri() {
		return booleanLiteralEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getSeparatorKind() {
		return separatorKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getRangeRestrictionKind() {
		return rangeRestrictionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getCardinalityRestrictionKind() {
		return cardinalityRestrictionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getImportKind() {
		return importKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getUnsignedInt() {
		return unsignedIntEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getUnsignedInteger() {
		return unsignedIntegerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getDecimal() {
		return decimalEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getDouble() {
		return doubleEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getID() {
		return idEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getNamespace() {
		return namespaceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OmlFactory getOmlFactory() {
		return (OmlFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		elementEClass = createEClass(ELEMENT);
		createEOperation(elementEClass, ELEMENT___GET_ONTOLOGY);
		createEOperation(elementEClass, ELEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP);

		annotationEClass = createEClass(ANNOTATION);
		createEReference(annotationEClass, ANNOTATION__PROPERTY);
		createEReference(annotationEClass, ANNOTATION__LITERAL_VALUE);
		createEReference(annotationEClass, ANNOTATION__REFERENCED_VALUE);
		createEReference(annotationEClass, ANNOTATION__OWNING_ELEMENT);
		createEOperation(annotationEClass, ANNOTATION___GET_VALUE);
		createEOperation(annotationEClass, ANNOTATION___GET_ANNOTATED_ELEMENT);

		identifiedElementEClass = createEClass(IDENTIFIED_ELEMENT);
		createEReference(identifiedElementEClass, IDENTIFIED_ELEMENT__OWNED_ANNOTATIONS);
		createEOperation(identifiedElementEClass, IDENTIFIED_ELEMENT___GET_IRI);

		importEClass = createEClass(IMPORT);
		createEAttribute(importEClass, IMPORT__KIND);
		createEAttribute(importEClass, IMPORT__NAMESPACE);
		createEAttribute(importEClass, IMPORT__PREFIX);
		createEReference(importEClass, IMPORT__OWNING_ONTOLOGY);
		createEOperation(importEClass, IMPORT___GET_IRI);
		createEOperation(importEClass, IMPORT___GET_SEPARATOR);

		instanceEClass = createEClass(INSTANCE);
		createEReference(instanceEClass, INSTANCE__OWNED_PROPERTY_VALUES);
		createEOperation(instanceEClass, INSTANCE___GET_TYPES);

		axiomEClass = createEClass(AXIOM);
		createEOperation(axiomEClass, AXIOM___GET_CHARACTERIZED_TERM);

		assertionEClass = createEClass(ASSERTION);
		createEOperation(assertionEClass, ASSERTION___GET_SUBJECT);
		createEOperation(assertionEClass, ASSERTION___GET_OBJECT);

		predicateEClass = createEClass(PREDICATE);
		createEReference(predicateEClass, PREDICATE__ANTECEDENT_RULE);
		createEReference(predicateEClass, PREDICATE__CONSEQUENT_RULE);

		argumentEClass = createEClass(ARGUMENT);
		createEAttribute(argumentEClass, ARGUMENT__VARIABLE);
		createEReference(argumentEClass, ARGUMENT__LITERAL);
		createEReference(argumentEClass, ARGUMENT__INSTANCE);
		createEOperation(argumentEClass, ARGUMENT___GET_VALUE);

		literalEClass = createEClass(LITERAL);
		createEOperation(literalEClass, LITERAL___GET_VALUE);
		createEOperation(literalEClass, LITERAL___GET_STRING_VALUE);
		createEOperation(literalEClass, LITERAL___GET_LEXICAL_VALUE);
		createEOperation(literalEClass, LITERAL___GET_TYPE_IRI);

		ontologyEClass = createEClass(ONTOLOGY);
		createEAttribute(ontologyEClass, ONTOLOGY__NAMESPACE);
		createEAttribute(ontologyEClass, ONTOLOGY__PREFIX);
		createEReference(ontologyEClass, ONTOLOGY__OWNED_IMPORTS);
		createEOperation(ontologyEClass, ONTOLOGY___GET_IRI);
		createEOperation(ontologyEClass, ONTOLOGY___GET_SEPARATOR);

		memberEClass = createEClass(MEMBER);
		createEAttribute(memberEClass, MEMBER__NAME);
		createEOperation(memberEClass, MEMBER___GET_REF);
		createEOperation(memberEClass, MEMBER___IS_REF);
		createEOperation(memberEClass, MEMBER___RESOLVE);
		createEOperation(memberEClass, MEMBER___GET_IRI);
		createEOperation(memberEClass, MEMBER___GET_ABBREVIATED_IRI);

		vocabularyBoxEClass = createEClass(VOCABULARY_BOX);

		descriptionBoxEClass = createEClass(DESCRIPTION_BOX);

		vocabularyEClass = createEClass(VOCABULARY);
		createEReference(vocabularyEClass, VOCABULARY__OWNED_STATEMENTS);

		vocabularyBundleEClass = createEClass(VOCABULARY_BUNDLE);

		descriptionEClass = createEClass(DESCRIPTION);
		createEReference(descriptionEClass, DESCRIPTION__OWNED_STATEMENTS);

		descriptionBundleEClass = createEClass(DESCRIPTION_BUNDLE);

		statementEClass = createEClass(STATEMENT);

		vocabularyMemberEClass = createEClass(VOCABULARY_MEMBER);

		descriptionMemberEClass = createEClass(DESCRIPTION_MEMBER);

		vocabularyStatementEClass = createEClass(VOCABULARY_STATEMENT);
		createEReference(vocabularyStatementEClass, VOCABULARY_STATEMENT__OWNING_VOCABULARY);

		descriptionStatementEClass = createEClass(DESCRIPTION_STATEMENT);
		createEReference(descriptionStatementEClass, DESCRIPTION_STATEMENT__OWNING_DESCRIPTION);

		termEClass = createEClass(TERM);

		ruleEClass = createEClass(RULE);
		createEReference(ruleEClass, RULE__REF);
		createEReference(ruleEClass, RULE__ANTECEDENT);
		createEReference(ruleEClass, RULE__CONSEQUENT);

		builtInEClass = createEClass(BUILT_IN);
		createEReference(builtInEClass, BUILT_IN__REF);

		specializableTermEClass = createEClass(SPECIALIZABLE_TERM);
		createEReference(specializableTermEClass, SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS);

		propertyEClass = createEClass(PROPERTY);

		typeEClass = createEClass(TYPE);

		relationBaseEClass = createEClass(RELATION_BASE);
		createEReference(relationBaseEClass, RELATION_BASE__SOURCES);
		createEReference(relationBaseEClass, RELATION_BASE__TARGETS);
		createEReference(relationBaseEClass, RELATION_BASE__REVERSE_RELATION);
		createEAttribute(relationBaseEClass, RELATION_BASE__FUNCTIONAL);
		createEAttribute(relationBaseEClass, RELATION_BASE__INVERSE_FUNCTIONAL);
		createEAttribute(relationBaseEClass, RELATION_BASE__SYMMETRIC);
		createEAttribute(relationBaseEClass, RELATION_BASE__ASYMMETRIC);
		createEAttribute(relationBaseEClass, RELATION_BASE__REFLEXIVE);
		createEAttribute(relationBaseEClass, RELATION_BASE__IRREFLEXIVE);
		createEAttribute(relationBaseEClass, RELATION_BASE__TRANSITIVE);

		specializablePropertyEClass = createEClass(SPECIALIZABLE_PROPERTY);
		createEReference(specializablePropertyEClass, SPECIALIZABLE_PROPERTY__OWNED_EQUIVALENCES);

		classifierEClass = createEClass(CLASSIFIER);
		createEReference(classifierEClass, CLASSIFIER__OWNED_EQUIVALENCES);
		createEReference(classifierEClass, CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS);

		scalarEClass = createEClass(SCALAR);
		createEReference(scalarEClass, SCALAR__REF);
		createEReference(scalarEClass, SCALAR__OWNED_ENUMERATION);
		createEReference(scalarEClass, SCALAR__OWNED_EQUIVALENCES);

		entityEClass = createEClass(ENTITY);
		createEReference(entityEClass, ENTITY__OWNED_KEYS);

		structureEClass = createEClass(STRUCTURE);
		createEReference(structureEClass, STRUCTURE__REF);

		aspectEClass = createEClass(ASPECT);
		createEReference(aspectEClass, ASPECT__REF);

		conceptEClass = createEClass(CONCEPT);
		createEReference(conceptEClass, CONCEPT__REF);
		createEReference(conceptEClass, CONCEPT__OWNED_ENUMERATION);

		relationEntityEClass = createEClass(RELATION_ENTITY);
		createEReference(relationEntityEClass, RELATION_ENTITY__REF);
		createEReference(relationEntityEClass, RELATION_ENTITY__FORWARD_RELATION);

		annotationPropertyEClass = createEClass(ANNOTATION_PROPERTY);
		createEReference(annotationPropertyEClass, ANNOTATION_PROPERTY__REF);

		semanticPropertyEClass = createEClass(SEMANTIC_PROPERTY);
		createEOperation(semanticPropertyEClass, SEMANTIC_PROPERTY___IS_FUNCTIONAL);
		createEOperation(semanticPropertyEClass, SEMANTIC_PROPERTY___GET_DOMAIN_LIST);
		createEOperation(semanticPropertyEClass, SEMANTIC_PROPERTY___GET_RANGE_LIST);

		scalarPropertyEClass = createEClass(SCALAR_PROPERTY);
		createEReference(scalarPropertyEClass, SCALAR_PROPERTY__REF);
		createEAttribute(scalarPropertyEClass, SCALAR_PROPERTY__FUNCTIONAL);
		createEReference(scalarPropertyEClass, SCALAR_PROPERTY__DOMAINS);
		createEReference(scalarPropertyEClass, SCALAR_PROPERTY__RANGES);
		createEOperation(scalarPropertyEClass, SCALAR_PROPERTY___GET_DOMAIN_LIST);
		createEOperation(scalarPropertyEClass, SCALAR_PROPERTY___GET_RANGE_LIST);

		structuredPropertyEClass = createEClass(STRUCTURED_PROPERTY);
		createEReference(structuredPropertyEClass, STRUCTURED_PROPERTY__REF);
		createEAttribute(structuredPropertyEClass, STRUCTURED_PROPERTY__FUNCTIONAL);
		createEReference(structuredPropertyEClass, STRUCTURED_PROPERTY__DOMAINS);
		createEReference(structuredPropertyEClass, STRUCTURED_PROPERTY__RANGES);
		createEOperation(structuredPropertyEClass, STRUCTURED_PROPERTY___GET_DOMAIN_LIST);
		createEOperation(structuredPropertyEClass, STRUCTURED_PROPERTY___GET_RANGE_LIST);

		relationEClass = createEClass(RELATION);
		createEOperation(relationEClass, RELATION___IS_INVERSE_FUNCTIONAL);
		createEOperation(relationEClass, RELATION___IS_SYMMETRIC);
		createEOperation(relationEClass, RELATION___IS_ASYMMETRIC);
		createEOperation(relationEClass, RELATION___IS_REFLEXIVE);
		createEOperation(relationEClass, RELATION___IS_IRREFLEXIVE);
		createEOperation(relationEClass, RELATION___IS_TRANSITIVE);
		createEOperation(relationEClass, RELATION___GET_DOMAINS);
		createEOperation(relationEClass, RELATION___GET_RANGES);
		createEOperation(relationEClass, RELATION___GET_INVERSE);
		createEOperation(relationEClass, RELATION___GET_DOMAIN_LIST);
		createEOperation(relationEClass, RELATION___GET_RANGE_LIST);

		forwardRelationEClass = createEClass(FORWARD_RELATION);
		createEReference(forwardRelationEClass, FORWARD_RELATION__RELATION_ENTITY);
		createEOperation(forwardRelationEClass, FORWARD_RELATION___GET_REF);
		createEOperation(forwardRelationEClass, FORWARD_RELATION___IS_FUNCTIONAL);
		createEOperation(forwardRelationEClass, FORWARD_RELATION___IS_INVERSE_FUNCTIONAL);
		createEOperation(forwardRelationEClass, FORWARD_RELATION___IS_SYMMETRIC);
		createEOperation(forwardRelationEClass, FORWARD_RELATION___IS_ASYMMETRIC);
		createEOperation(forwardRelationEClass, FORWARD_RELATION___IS_REFLEXIVE);
		createEOperation(forwardRelationEClass, FORWARD_RELATION___IS_IRREFLEXIVE);
		createEOperation(forwardRelationEClass, FORWARD_RELATION___IS_TRANSITIVE);
		createEOperation(forwardRelationEClass, FORWARD_RELATION___GET_DOMAINS);
		createEOperation(forwardRelationEClass, FORWARD_RELATION___GET_RANGES);
		createEOperation(forwardRelationEClass, FORWARD_RELATION___GET_INVERSE);

		reverseRelationEClass = createEClass(REVERSE_RELATION);
		createEReference(reverseRelationEClass, REVERSE_RELATION__RELATION_BASE);
		createEOperation(reverseRelationEClass, REVERSE_RELATION___GET_REF);
		createEOperation(reverseRelationEClass, REVERSE_RELATION___IS_FUNCTIONAL);
		createEOperation(reverseRelationEClass, REVERSE_RELATION___IS_INVERSE_FUNCTIONAL);
		createEOperation(reverseRelationEClass, REVERSE_RELATION___IS_SYMMETRIC);
		createEOperation(reverseRelationEClass, REVERSE_RELATION___IS_ASYMMETRIC);
		createEOperation(reverseRelationEClass, REVERSE_RELATION___IS_REFLEXIVE);
		createEOperation(reverseRelationEClass, REVERSE_RELATION___IS_IRREFLEXIVE);
		createEOperation(reverseRelationEClass, REVERSE_RELATION___IS_TRANSITIVE);
		createEOperation(reverseRelationEClass, REVERSE_RELATION___GET_DOMAINS);
		createEOperation(reverseRelationEClass, REVERSE_RELATION___GET_RANGES);
		createEOperation(reverseRelationEClass, REVERSE_RELATION___GET_INVERSE);

		unreifiedRelationEClass = createEClass(UNREIFIED_RELATION);
		createEReference(unreifiedRelationEClass, UNREIFIED_RELATION__REF);
		createEOperation(unreifiedRelationEClass, UNREIFIED_RELATION___GET_DOMAINS);
		createEOperation(unreifiedRelationEClass, UNREIFIED_RELATION___GET_RANGES);
		createEOperation(unreifiedRelationEClass, UNREIFIED_RELATION___GET_INVERSE);

		namedInstanceEClass = createEClass(NAMED_INSTANCE);
		createEReference(namedInstanceEClass, NAMED_INSTANCE__OWNED_TYPES);
		createEOperation(namedInstanceEClass, NAMED_INSTANCE___GET_ENTITY_TYPES);
		createEOperation(namedInstanceEClass, NAMED_INSTANCE___GET_TYPES);

		conceptInstanceEClass = createEClass(CONCEPT_INSTANCE);
		createEReference(conceptInstanceEClass, CONCEPT_INSTANCE__REF);

		relationInstanceEClass = createEClass(RELATION_INSTANCE);
		createEReference(relationInstanceEClass, RELATION_INSTANCE__REF);
		createEReference(relationInstanceEClass, RELATION_INSTANCE__SOURCES);
		createEReference(relationInstanceEClass, RELATION_INSTANCE__TARGETS);

		structureInstanceEClass = createEClass(STRUCTURE_INSTANCE);
		createEReference(structureInstanceEClass, STRUCTURE_INSTANCE__TYPE);
		createEReference(structureInstanceEClass, STRUCTURE_INSTANCE__OWNING_AXIOM);
		createEReference(structureInstanceEClass, STRUCTURE_INSTANCE__OWNING_ASSERTION);
		createEOperation(structureInstanceEClass, STRUCTURE_INSTANCE___GET_TYPES);

		keyAxiomEClass = createEClass(KEY_AXIOM);
		createEReference(keyAxiomEClass, KEY_AXIOM__PROPERTIES);
		createEReference(keyAxiomEClass, KEY_AXIOM__OWNING_ENTITY);
		createEOperation(keyAxiomEClass, KEY_AXIOM___GET_KEYED_ENTITY);
		createEOperation(keyAxiomEClass, KEY_AXIOM___GET_CHARACTERIZED_TERM);

		specializationAxiomEClass = createEClass(SPECIALIZATION_AXIOM);
		createEReference(specializationAxiomEClass, SPECIALIZATION_AXIOM__SUPER_TERM);
		createEReference(specializationAxiomEClass, SPECIALIZATION_AXIOM__OWNING_TERM);
		createEOperation(specializationAxiomEClass, SPECIALIZATION_AXIOM___GET_SUB_TERM);
		createEOperation(specializationAxiomEClass, SPECIALIZATION_AXIOM___GET_CHARACTERIZED_TERM);

		instanceEnumerationAxiomEClass = createEClass(INSTANCE_ENUMERATION_AXIOM);
		createEReference(instanceEnumerationAxiomEClass, INSTANCE_ENUMERATION_AXIOM__INSTANCES);
		createEReference(instanceEnumerationAxiomEClass, INSTANCE_ENUMERATION_AXIOM__OWNING_CONCEPT);
		createEOperation(instanceEnumerationAxiomEClass, INSTANCE_ENUMERATION_AXIOM___GET_ENUMERATED_CONCEPT);
		createEOperation(instanceEnumerationAxiomEClass, INSTANCE_ENUMERATION_AXIOM___GET_CHARACTERIZED_TERM);

		propertyRestrictionAxiomEClass = createEClass(PROPERTY_RESTRICTION_AXIOM);
		createEReference(propertyRestrictionAxiomEClass, PROPERTY_RESTRICTION_AXIOM__PROPERTY);
		createEReference(propertyRestrictionAxiomEClass, PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER);
		createEReference(propertyRestrictionAxiomEClass, PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM);
		createEOperation(propertyRestrictionAxiomEClass, PROPERTY_RESTRICTION_AXIOM___GET_RESTRICTING_DOMAIN);
		createEOperation(propertyRestrictionAxiomEClass, PROPERTY_RESTRICTION_AXIOM___GET_CHARACTERIZED_TERM);

		literalEnumerationAxiomEClass = createEClass(LITERAL_ENUMERATION_AXIOM);
		createEReference(literalEnumerationAxiomEClass, LITERAL_ENUMERATION_AXIOM__LITERALS);
		createEReference(literalEnumerationAxiomEClass, LITERAL_ENUMERATION_AXIOM__OWNING_SCALAR);
		createEOperation(literalEnumerationAxiomEClass, LITERAL_ENUMERATION_AXIOM___GET_ENUMERATED_SCALAR);
		createEOperation(literalEnumerationAxiomEClass, LITERAL_ENUMERATION_AXIOM___GET_CHARACTERIZED_TERM);

		classifierEquivalenceAxiomEClass = createEClass(CLASSIFIER_EQUIVALENCE_AXIOM);
		createEReference(classifierEquivalenceAxiomEClass, CLASSIFIER_EQUIVALENCE_AXIOM__SUPER_CLASSIFIERS);
		createEReference(classifierEquivalenceAxiomEClass, CLASSIFIER_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS);
		createEReference(classifierEquivalenceAxiomEClass, CLASSIFIER_EQUIVALENCE_AXIOM__OWNING_CLASSIFIER);
		createEOperation(classifierEquivalenceAxiomEClass, CLASSIFIER_EQUIVALENCE_AXIOM___GET_SUB_CLASSIFIER);
		createEOperation(classifierEquivalenceAxiomEClass, CLASSIFIER_EQUIVALENCE_AXIOM___GET_CHARACTERIZED_TERM);

		scalarEquivalenceAxiomEClass = createEClass(SCALAR_EQUIVALENCE_AXIOM);
		createEReference(scalarEquivalenceAxiomEClass, SCALAR_EQUIVALENCE_AXIOM__SUPER_SCALAR);
		createEReference(scalarEquivalenceAxiomEClass, SCALAR_EQUIVALENCE_AXIOM__OWNING_SCALAR);
		createEAttribute(scalarEquivalenceAxiomEClass, SCALAR_EQUIVALENCE_AXIOM__LENGTH);
		createEAttribute(scalarEquivalenceAxiomEClass, SCALAR_EQUIVALENCE_AXIOM__MIN_LENGTH);
		createEAttribute(scalarEquivalenceAxiomEClass, SCALAR_EQUIVALENCE_AXIOM__MAX_LENGTH);
		createEAttribute(scalarEquivalenceAxiomEClass, SCALAR_EQUIVALENCE_AXIOM__PATTERN);
		createEAttribute(scalarEquivalenceAxiomEClass, SCALAR_EQUIVALENCE_AXIOM__LANGUAGE);
		createEReference(scalarEquivalenceAxiomEClass, SCALAR_EQUIVALENCE_AXIOM__MIN_INCLUSIVE);
		createEReference(scalarEquivalenceAxiomEClass, SCALAR_EQUIVALENCE_AXIOM__MIN_EXCLUSIVE);
		createEReference(scalarEquivalenceAxiomEClass, SCALAR_EQUIVALENCE_AXIOM__MAX_INCLUSIVE);
		createEReference(scalarEquivalenceAxiomEClass, SCALAR_EQUIVALENCE_AXIOM__MAX_EXCLUSIVE);
		createEOperation(scalarEquivalenceAxiomEClass, SCALAR_EQUIVALENCE_AXIOM___GET_SUB_SCALAR);
		createEOperation(scalarEquivalenceAxiomEClass, SCALAR_EQUIVALENCE_AXIOM___GET_CHARACTERIZED_TERM);

		propertyEquivalenceAxiomEClass = createEClass(PROPERTY_EQUIVALENCE_AXIOM);
		createEReference(propertyEquivalenceAxiomEClass, PROPERTY_EQUIVALENCE_AXIOM__SUPER_PROPERTY);
		createEReference(propertyEquivalenceAxiomEClass, PROPERTY_EQUIVALENCE_AXIOM__OWNING_PROPERTY);
		createEOperation(propertyEquivalenceAxiomEClass, PROPERTY_EQUIVALENCE_AXIOM___GET_SUB_PROPERTY);
		createEOperation(propertyEquivalenceAxiomEClass, PROPERTY_EQUIVALENCE_AXIOM___GET_CHARACTERIZED_TERM);

		propertyRangeRestrictionAxiomEClass = createEClass(PROPERTY_RANGE_RESTRICTION_AXIOM);
		createEAttribute(propertyRangeRestrictionAxiomEClass, PROPERTY_RANGE_RESTRICTION_AXIOM__KIND);
		createEReference(propertyRangeRestrictionAxiomEClass, PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE);

		propertyCardinalityRestrictionAxiomEClass = createEClass(PROPERTY_CARDINALITY_RESTRICTION_AXIOM);
		createEAttribute(propertyCardinalityRestrictionAxiomEClass, PROPERTY_CARDINALITY_RESTRICTION_AXIOM__KIND);
		createEAttribute(propertyCardinalityRestrictionAxiomEClass, PROPERTY_CARDINALITY_RESTRICTION_AXIOM__CARDINALITY);
		createEReference(propertyCardinalityRestrictionAxiomEClass, PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE);

		propertyValueRestrictionAxiomEClass = createEClass(PROPERTY_VALUE_RESTRICTION_AXIOM);
		createEReference(propertyValueRestrictionAxiomEClass, PROPERTY_VALUE_RESTRICTION_AXIOM__LITERAL_VALUE);
		createEReference(propertyValueRestrictionAxiomEClass, PROPERTY_VALUE_RESTRICTION_AXIOM__CONTAINED_VALUE);
		createEReference(propertyValueRestrictionAxiomEClass, PROPERTY_VALUE_RESTRICTION_AXIOM__REFERENCED_VALUE);
		createEOperation(propertyValueRestrictionAxiomEClass, PROPERTY_VALUE_RESTRICTION_AXIOM___GET_VALUE);

		propertySelfRestrictionAxiomEClass = createEClass(PROPERTY_SELF_RESTRICTION_AXIOM);

		typeAssertionEClass = createEClass(TYPE_ASSERTION);
		createEReference(typeAssertionEClass, TYPE_ASSERTION__TYPE);
		createEReference(typeAssertionEClass, TYPE_ASSERTION__OWNING_INSTANCE);
		createEOperation(typeAssertionEClass, TYPE_ASSERTION___GET_SUBJECT);
		createEOperation(typeAssertionEClass, TYPE_ASSERTION___GET_OBJECT);

		propertyValueAssertionEClass = createEClass(PROPERTY_VALUE_ASSERTION);
		createEReference(propertyValueAssertionEClass, PROPERTY_VALUE_ASSERTION__PROPERTY);
		createEReference(propertyValueAssertionEClass, PROPERTY_VALUE_ASSERTION__LITERAL_VALUE);
		createEReference(propertyValueAssertionEClass, PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE);
		createEReference(propertyValueAssertionEClass, PROPERTY_VALUE_ASSERTION__REFERENCED_VALUE);
		createEReference(propertyValueAssertionEClass, PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE);
		createEOperation(propertyValueAssertionEClass, PROPERTY_VALUE_ASSERTION___GET_VALUE);
		createEOperation(propertyValueAssertionEClass, PROPERTY_VALUE_ASSERTION___GET_SUBJECT);
		createEOperation(propertyValueAssertionEClass, PROPERTY_VALUE_ASSERTION___GET_OBJECT);

		unaryPredicateEClass = createEClass(UNARY_PREDICATE);
		createEReference(unaryPredicateEClass, UNARY_PREDICATE__ARGUMENT);

		binaryPredicateEClass = createEClass(BINARY_PREDICATE);
		createEReference(binaryPredicateEClass, BINARY_PREDICATE__ARGUMENT1);
		createEReference(binaryPredicateEClass, BINARY_PREDICATE__ARGUMENT2);

		builtInPredicateEClass = createEClass(BUILT_IN_PREDICATE);
		createEReference(builtInPredicateEClass, BUILT_IN_PREDICATE__BUILT_IN);
		createEReference(builtInPredicateEClass, BUILT_IN_PREDICATE__ARGUMENTS);

		typePredicateEClass = createEClass(TYPE_PREDICATE);
		createEReference(typePredicateEClass, TYPE_PREDICATE__TYPE);

		relationEntityPredicateEClass = createEClass(RELATION_ENTITY_PREDICATE);
		createEReference(relationEntityPredicateEClass, RELATION_ENTITY_PREDICATE__TYPE);

		propertyPredicateEClass = createEClass(PROPERTY_PREDICATE);
		createEReference(propertyPredicateEClass, PROPERTY_PREDICATE__PROPERTY);

		sameAsPredicateEClass = createEClass(SAME_AS_PREDICATE);

		differentFromPredicateEClass = createEClass(DIFFERENT_FROM_PREDICATE);

		quotedLiteralEClass = createEClass(QUOTED_LITERAL);
		createEAttribute(quotedLiteralEClass, QUOTED_LITERAL__VALUE);
		createEAttribute(quotedLiteralEClass, QUOTED_LITERAL__LANG_TAG);
		createEReference(quotedLiteralEClass, QUOTED_LITERAL__TYPE);
		createEOperation(quotedLiteralEClass, QUOTED_LITERAL___GET_LEXICAL_VALUE);
		createEOperation(quotedLiteralEClass, QUOTED_LITERAL___GET_TYPE_IRI);

		integerLiteralEClass = createEClass(INTEGER_LITERAL);
		createEAttribute(integerLiteralEClass, INTEGER_LITERAL__VALUE);
		createEOperation(integerLiteralEClass, INTEGER_LITERAL___GET_TYPE_IRI);

		decimalLiteralEClass = createEClass(DECIMAL_LITERAL);
		createEAttribute(decimalLiteralEClass, DECIMAL_LITERAL__VALUE);
		createEOperation(decimalLiteralEClass, DECIMAL_LITERAL___GET_TYPE_IRI);

		doubleLiteralEClass = createEClass(DOUBLE_LITERAL);
		createEAttribute(doubleLiteralEClass, DOUBLE_LITERAL__VALUE);
		createEOperation(doubleLiteralEClass, DOUBLE_LITERAL___GET_TYPE_IRI);

		booleanLiteralEClass = createEClass(BOOLEAN_LITERAL);
		createEAttribute(booleanLiteralEClass, BOOLEAN_LITERAL__VALUE);
		createEOperation(booleanLiteralEClass, BOOLEAN_LITERAL___IS_VALUE);
		createEOperation(booleanLiteralEClass, BOOLEAN_LITERAL___GET_TYPE_IRI);

		// Create enums
		separatorKindEEnum = createEEnum(SEPARATOR_KIND);
		rangeRestrictionKindEEnum = createEEnum(RANGE_RESTRICTION_KIND);
		cardinalityRestrictionKindEEnum = createEEnum(CARDINALITY_RESTRICTION_KIND);
		importKindEEnum = createEEnum(IMPORT_KIND);

		// Create data types
		unsignedIntEDataType = createEDataType(UNSIGNED_INT);
		unsignedIntegerEDataType = createEDataType(UNSIGNED_INTEGER);
		decimalEDataType = createEDataType(DECIMAL);
		doubleEDataType = createEDataType(DOUBLE);
		idEDataType = createEDataType(ID);
		namespaceEDataType = createEDataType(NAMESPACE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		annotationEClass.getESuperTypes().add(this.getElement());
		identifiedElementEClass.getESuperTypes().add(this.getElement());
		importEClass.getESuperTypes().add(this.getElement());
		instanceEClass.getESuperTypes().add(this.getElement());
		axiomEClass.getESuperTypes().add(this.getElement());
		assertionEClass.getESuperTypes().add(this.getElement());
		predicateEClass.getESuperTypes().add(this.getElement());
		argumentEClass.getESuperTypes().add(this.getElement());
		literalEClass.getESuperTypes().add(this.getElement());
		ontologyEClass.getESuperTypes().add(this.getIdentifiedElement());
		memberEClass.getESuperTypes().add(this.getIdentifiedElement());
		vocabularyBoxEClass.getESuperTypes().add(this.getOntology());
		descriptionBoxEClass.getESuperTypes().add(this.getOntology());
		vocabularyEClass.getESuperTypes().add(this.getVocabularyBox());
		vocabularyBundleEClass.getESuperTypes().add(this.getVocabularyBox());
		descriptionEClass.getESuperTypes().add(this.getDescriptionBox());
		descriptionBundleEClass.getESuperTypes().add(this.getDescriptionBox());
		statementEClass.getESuperTypes().add(this.getMember());
		vocabularyMemberEClass.getESuperTypes().add(this.getMember());
		descriptionMemberEClass.getESuperTypes().add(this.getMember());
		vocabularyStatementEClass.getESuperTypes().add(this.getStatement());
		vocabularyStatementEClass.getESuperTypes().add(this.getVocabularyMember());
		descriptionStatementEClass.getESuperTypes().add(this.getStatement());
		descriptionStatementEClass.getESuperTypes().add(this.getDescriptionMember());
		termEClass.getESuperTypes().add(this.getVocabularyMember());
		ruleEClass.getESuperTypes().add(this.getVocabularyStatement());
		builtInEClass.getESuperTypes().add(this.getVocabularyStatement());
		specializableTermEClass.getESuperTypes().add(this.getTerm());
		specializableTermEClass.getESuperTypes().add(this.getVocabularyStatement());
		propertyEClass.getESuperTypes().add(this.getTerm());
		typeEClass.getESuperTypes().add(this.getSpecializableTerm());
		relationBaseEClass.getESuperTypes().add(this.getSpecializableTerm());
		specializablePropertyEClass.getESuperTypes().add(this.getSpecializableTerm());
		specializablePropertyEClass.getESuperTypes().add(this.getProperty());
		classifierEClass.getESuperTypes().add(this.getType());
		scalarEClass.getESuperTypes().add(this.getType());
		entityEClass.getESuperTypes().add(this.getClassifier());
		structureEClass.getESuperTypes().add(this.getClassifier());
		aspectEClass.getESuperTypes().add(this.getEntity());
		conceptEClass.getESuperTypes().add(this.getEntity());
		relationEntityEClass.getESuperTypes().add(this.getEntity());
		relationEntityEClass.getESuperTypes().add(this.getRelationBase());
		annotationPropertyEClass.getESuperTypes().add(this.getSpecializableProperty());
		semanticPropertyEClass.getESuperTypes().add(this.getProperty());
		scalarPropertyEClass.getESuperTypes().add(this.getSemanticProperty());
		scalarPropertyEClass.getESuperTypes().add(this.getSpecializableProperty());
		structuredPropertyEClass.getESuperTypes().add(this.getSemanticProperty());
		structuredPropertyEClass.getESuperTypes().add(this.getSpecializableProperty());
		relationEClass.getESuperTypes().add(this.getSemanticProperty());
		forwardRelationEClass.getESuperTypes().add(this.getRelation());
		reverseRelationEClass.getESuperTypes().add(this.getRelation());
		unreifiedRelationEClass.getESuperTypes().add(this.getRelation());
		unreifiedRelationEClass.getESuperTypes().add(this.getRelationBase());
		unreifiedRelationEClass.getESuperTypes().add(this.getSpecializableProperty());
		namedInstanceEClass.getESuperTypes().add(this.getDescriptionStatement());
		namedInstanceEClass.getESuperTypes().add(this.getInstance());
		conceptInstanceEClass.getESuperTypes().add(this.getNamedInstance());
		relationInstanceEClass.getESuperTypes().add(this.getNamedInstance());
		structureInstanceEClass.getESuperTypes().add(this.getInstance());
		keyAxiomEClass.getESuperTypes().add(this.getAxiom());
		specializationAxiomEClass.getESuperTypes().add(this.getAxiom());
		instanceEnumerationAxiomEClass.getESuperTypes().add(this.getAxiom());
		propertyRestrictionAxiomEClass.getESuperTypes().add(this.getAxiom());
		literalEnumerationAxiomEClass.getESuperTypes().add(this.getAxiom());
		classifierEquivalenceAxiomEClass.getESuperTypes().add(this.getAxiom());
		scalarEquivalenceAxiomEClass.getESuperTypes().add(this.getAxiom());
		propertyEquivalenceAxiomEClass.getESuperTypes().add(this.getAxiom());
		propertyRangeRestrictionAxiomEClass.getESuperTypes().add(this.getPropertyRestrictionAxiom());
		propertyCardinalityRestrictionAxiomEClass.getESuperTypes().add(this.getPropertyRestrictionAxiom());
		propertyValueRestrictionAxiomEClass.getESuperTypes().add(this.getPropertyRestrictionAxiom());
		propertySelfRestrictionAxiomEClass.getESuperTypes().add(this.getPropertyRestrictionAxiom());
		typeAssertionEClass.getESuperTypes().add(this.getAssertion());
		propertyValueAssertionEClass.getESuperTypes().add(this.getAssertion());
		unaryPredicateEClass.getESuperTypes().add(this.getPredicate());
		binaryPredicateEClass.getESuperTypes().add(this.getPredicate());
		builtInPredicateEClass.getESuperTypes().add(this.getPredicate());
		typePredicateEClass.getESuperTypes().add(this.getUnaryPredicate());
		relationEntityPredicateEClass.getESuperTypes().add(this.getUnaryPredicate());
		relationEntityPredicateEClass.getESuperTypes().add(this.getBinaryPredicate());
		propertyPredicateEClass.getESuperTypes().add(this.getBinaryPredicate());
		sameAsPredicateEClass.getESuperTypes().add(this.getBinaryPredicate());
		differentFromPredicateEClass.getESuperTypes().add(this.getBinaryPredicate());
		quotedLiteralEClass.getESuperTypes().add(this.getLiteral());
		integerLiteralEClass.getESuperTypes().add(this.getLiteral());
		decimalLiteralEClass.getESuperTypes().add(this.getLiteral());
		doubleLiteralEClass.getESuperTypes().add(this.getLiteral());
		booleanLiteralEClass.getESuperTypes().add(this.getLiteral());

		// Initialize classes, features, and operations; add parameters
		initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getElement__GetOntology(), this.getOntology(), "getOntology", 0, 1, !IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getElement__ExtraValidate__DiagnosticChain_Map(), theEcorePackage.getEBoolean(), "extraValidate", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, !IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(theEcorePackage.getEMap());
		EGenericType g2 = createEGenericType(theEcorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(annotationEClass, Annotation.class, "Annotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotation_Property(), this.getAnnotationProperty(), null, "property", null, 1, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_LiteralValue(), this.getLiteral(), null, "literalValue", null, 0, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_ReferencedValue(), this.getMember(), null, "referencedValue", null, 0, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_OwningElement(), this.getIdentifiedElement(), this.getIdentifiedElement_OwnedAnnotations(), "owningElement", null, 0, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAnnotation__GetValue(), this.getElement(), "getValue", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getAnnotation__GetAnnotatedElement(), this.getIdentifiedElement(), "getAnnotatedElement", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(identifiedElementEClass, IdentifiedElement.class, "IdentifiedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIdentifiedElement_OwnedAnnotations(), this.getAnnotation(), this.getAnnotation_OwningElement(), "ownedAnnotations", null, 0, -1, IdentifiedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getIdentifiedElement__GetIri(), theEcorePackage.getEString(), "getIri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImport_Kind(), this.getImportKind(), "kind", null, 1, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImport_Namespace(), this.getNamespace(), "namespace", null, 1, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImport_Prefix(), this.getID(), "prefix", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImport_OwningOntology(), this.getOntology(), this.getOntology_OwnedImports(), "owningOntology", null, 1, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getImport__GetIri(), theEcorePackage.getEString(), "getIri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getImport__GetSeparator(), this.getSeparatorKind(), "getSeparator", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(instanceEClass, Instance.class, "Instance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstance_OwnedPropertyValues(), this.getPropertyValueAssertion(), this.getPropertyValueAssertion_OwningInstance(), "ownedPropertyValues", null, 0, -1, Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getInstance__GetTypes(), this.getClassifier(), "getTypes", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(axiomEClass, Axiom.class, "Axiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getAxiom__GetCharacterizedTerm(), this.getTerm(), "getCharacterizedTerm", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(assertionEClass, Assertion.class, "Assertion", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getAssertion__GetSubject(), this.getInstance(), "getSubject", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getAssertion__GetObject(), this.getElement(), "getObject", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(predicateEClass, Predicate.class, "Predicate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPredicate_AntecedentRule(), this.getRule(), this.getRule_Antecedent(), "antecedentRule", null, 0, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPredicate_ConsequentRule(), this.getRule(), this.getRule_Consequent(), "consequentRule", null, 0, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(argumentEClass, Argument.class, "Argument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArgument_Variable(), this.getID(), "variable", null, 0, 1, Argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArgument_Literal(), this.getLiteral(), null, "literal", null, 0, 1, Argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArgument_Instance(), this.getNamedInstance(), null, "instance", null, 0, 1, Argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getArgument__GetValue(), theEcorePackage.getEJavaObject(), "getValue", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(literalEClass, Literal.class, "Literal", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getLiteral__GetValue(), theEcorePackage.getEJavaObject(), "getValue", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getLiteral__GetStringValue(), theEcorePackage.getEString(), "getStringValue", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getLiteral__GetLexicalValue(), theEcorePackage.getEString(), "getLexicalValue", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getLiteral__GetTypeIri(), theEcorePackage.getEString(), "getTypeIri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(ontologyEClass, Ontology.class, "Ontology", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOntology_Namespace(), this.getNamespace(), "namespace", null, 1, 1, Ontology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOntology_Prefix(), this.getID(), "prefix", null, 1, 1, Ontology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOntology_OwnedImports(), this.getImport(), this.getImport_OwningOntology(), "ownedImports", null, 0, -1, Ontology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getOntology__GetIri(), theEcorePackage.getEString(), "getIri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getOntology__GetSeparator(), this.getSeparatorKind(), "getSeparator", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(memberEClass, Member.class, "Member", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMember_Name(), this.getID(), "name", null, 0, 1, Member.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMember__GetRef(), this.getMember(), "getRef", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getMember__IsRef(), theEcorePackage.getEBoolean(), "isRef", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getMember__Resolve(), this.getMember(), "resolve", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getMember__GetIri(), theEcorePackage.getEString(), "getIri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getMember__GetAbbreviatedIri(), theEcorePackage.getEString(), "getAbbreviatedIri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(vocabularyBoxEClass, VocabularyBox.class, "VocabularyBox", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(descriptionBoxEClass, DescriptionBox.class, "DescriptionBox", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(vocabularyEClass, Vocabulary.class, "Vocabulary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVocabulary_OwnedStatements(), this.getVocabularyStatement(), this.getVocabularyStatement_OwningVocabulary(), "ownedStatements", null, 0, -1, Vocabulary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vocabularyBundleEClass, VocabularyBundle.class, "VocabularyBundle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(descriptionEClass, Description.class, "Description", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescription_OwnedStatements(), this.getDescriptionStatement(), this.getDescriptionStatement_OwningDescription(), "ownedStatements", null, 0, -1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptionBundleEClass, DescriptionBundle.class, "DescriptionBundle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(statementEClass, Statement.class, "Statement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(vocabularyMemberEClass, VocabularyMember.class, "VocabularyMember", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(descriptionMemberEClass, DescriptionMember.class, "DescriptionMember", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(vocabularyStatementEClass, VocabularyStatement.class, "VocabularyStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVocabularyStatement_OwningVocabulary(), this.getVocabulary(), this.getVocabulary_OwnedStatements(), "owningVocabulary", null, 1, 1, VocabularyStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptionStatementEClass, DescriptionStatement.class, "DescriptionStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptionStatement_OwningDescription(), this.getDescription(), this.getDescription_OwnedStatements(), "owningDescription", null, 1, 1, DescriptionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(termEClass, Term.class, "Term", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRule_Ref(), this.getRule(), null, "ref", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_Antecedent(), this.getPredicate(), this.getPredicate_AntecedentRule(), "antecedent", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_Consequent(), this.getPredicate(), this.getPredicate_ConsequentRule(), "consequent", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(builtInEClass, BuiltIn.class, "BuiltIn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBuiltIn_Ref(), this.getBuiltIn(), null, "ref", null, 0, 1, BuiltIn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(specializableTermEClass, SpecializableTerm.class, "SpecializableTerm", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecializableTerm_OwnedSpecializations(), this.getSpecializationAxiom(), this.getSpecializationAxiom_OwningTerm(), "ownedSpecializations", null, 0, -1, SpecializableTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relationBaseEClass, RelationBase.class, "RelationBase", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationBase_Sources(), this.getEntity(), null, "sources", null, 0, -1, RelationBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationBase_Targets(), this.getEntity(), null, "targets", null, 0, -1, RelationBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationBase_ReverseRelation(), this.getReverseRelation(), this.getReverseRelation_RelationBase(), "reverseRelation", null, 0, 1, RelationBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationBase_Functional(), theEcorePackage.getEBoolean(), "functional", null, 0, 1, RelationBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationBase_InverseFunctional(), theEcorePackage.getEBoolean(), "inverseFunctional", null, 0, 1, RelationBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationBase_Symmetric(), theEcorePackage.getEBoolean(), "symmetric", null, 0, 1, RelationBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationBase_Asymmetric(), theEcorePackage.getEBoolean(), "asymmetric", null, 0, 1, RelationBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationBase_Reflexive(), theEcorePackage.getEBoolean(), "reflexive", null, 0, 1, RelationBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationBase_Irreflexive(), theEcorePackage.getEBoolean(), "irreflexive", null, 0, 1, RelationBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationBase_Transitive(), theEcorePackage.getEBoolean(), "transitive", null, 0, 1, RelationBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(specializablePropertyEClass, SpecializableProperty.class, "SpecializableProperty", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecializableProperty_OwnedEquivalences(), this.getPropertyEquivalenceAxiom(), this.getPropertyEquivalenceAxiom_OwningProperty(), "ownedEquivalences", null, 0, -1, SpecializableProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classifierEClass, Classifier.class, "Classifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassifier_OwnedEquivalences(), this.getClassifierEquivalenceAxiom(), this.getClassifierEquivalenceAxiom_OwningClassifier(), "ownedEquivalences", null, 0, -1, Classifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifier_OwnedPropertyRestrictions(), this.getPropertyRestrictionAxiom(), this.getPropertyRestrictionAxiom_OwningClassifier(), "ownedPropertyRestrictions", null, 0, -1, Classifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scalarEClass, Scalar.class, "Scalar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScalar_Ref(), this.getScalar(), null, "ref", null, 0, 1, Scalar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalar_OwnedEnumeration(), this.getLiteralEnumerationAxiom(), this.getLiteralEnumerationAxiom_OwningScalar(), "ownedEnumeration", null, 0, 1, Scalar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalar_OwnedEquivalences(), this.getScalarEquivalenceAxiom(), this.getScalarEquivalenceAxiom_OwningScalar(), "ownedEquivalences", null, 0, -1, Scalar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityEClass, Entity.class, "Entity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntity_OwnedKeys(), this.getKeyAxiom(), this.getKeyAxiom_OwningEntity(), "ownedKeys", null, 0, -1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structureEClass, Structure.class, "Structure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructure_Ref(), this.getStructure(), null, "ref", null, 0, 1, Structure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aspectEClass, Aspect.class, "Aspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAspect_Ref(), this.getAspect(), null, "ref", null, 0, 1, Aspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptEClass, Concept.class, "Concept", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConcept_Ref(), this.getConcept(), null, "ref", null, 0, 1, Concept.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcept_OwnedEnumeration(), this.getInstanceEnumerationAxiom(), this.getInstanceEnumerationAxiom_OwningConcept(), "ownedEnumeration", null, 0, 1, Concept.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationEntityEClass, RelationEntity.class, "RelationEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationEntity_Ref(), this.getRelationEntity(), null, "ref", null, 0, 1, RelationEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationEntity_ForwardRelation(), this.getForwardRelation(), this.getForwardRelation_RelationEntity(), "forwardRelation", null, 0, 1, RelationEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationPropertyEClass, AnnotationProperty.class, "AnnotationProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotationProperty_Ref(), this.getAnnotationProperty(), null, "ref", null, 0, 1, AnnotationProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(semanticPropertyEClass, SemanticProperty.class, "SemanticProperty", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getSemanticProperty__IsFunctional(), theEcorePackage.getEBoolean(), "isFunctional", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSemanticProperty__GetDomainList(), this.getClassifier(), "getDomainList", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSemanticProperty__GetRangeList(), this.getType(), "getRangeList", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(scalarPropertyEClass, ScalarProperty.class, "ScalarProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScalarProperty_Ref(), this.getScalarProperty(), null, "ref", null, 0, 1, ScalarProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScalarProperty_Functional(), theEcorePackage.getEBoolean(), "functional", null, 0, 1, ScalarProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalarProperty_Domains(), this.getClassifier(), null, "domains", null, 0, -1, ScalarProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalarProperty_Ranges(), this.getScalar(), null, "ranges", null, 0, -1, ScalarProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getScalarProperty__GetDomainList(), this.getClassifier(), "getDomainList", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getScalarProperty__GetRangeList(), this.getType(), "getRangeList", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(structuredPropertyEClass, StructuredProperty.class, "StructuredProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructuredProperty_Ref(), this.getStructuredProperty(), null, "ref", null, 0, 1, StructuredProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructuredProperty_Functional(), theEcorePackage.getEBoolean(), "functional", null, 0, 1, StructuredProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructuredProperty_Domains(), this.getClassifier(), null, "domains", null, 0, -1, StructuredProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructuredProperty_Ranges(), this.getStructure(), null, "ranges", null, 0, -1, StructuredProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getStructuredProperty__GetDomainList(), this.getClassifier(), "getDomainList", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getStructuredProperty__GetRangeList(), this.getType(), "getRangeList", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(relationEClass, Relation.class, "Relation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getRelation__IsInverseFunctional(), theEcorePackage.getEBoolean(), "isInverseFunctional", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelation__IsSymmetric(), theEcorePackage.getEBoolean(), "isSymmetric", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelation__IsAsymmetric(), theEcorePackage.getEBoolean(), "isAsymmetric", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelation__IsReflexive(), theEcorePackage.getEBoolean(), "isReflexive", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelation__IsIrreflexive(), theEcorePackage.getEBoolean(), "isIrreflexive", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelation__IsTransitive(), theEcorePackage.getEBoolean(), "isTransitive", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelation__GetDomains(), this.getEntity(), "getDomains", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelation__GetRanges(), this.getEntity(), "getRanges", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelation__GetInverse(), this.getRelation(), "getInverse", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelation__GetDomainList(), this.getClassifier(), "getDomainList", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelation__GetRangeList(), this.getType(), "getRangeList", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(forwardRelationEClass, ForwardRelation.class, "ForwardRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForwardRelation_RelationEntity(), this.getRelationEntity(), this.getRelationEntity_ForwardRelation(), "relationEntity", null, 1, 1, ForwardRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getForwardRelation__GetRef(), this.getMember(), "getRef", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getForwardRelation__IsFunctional(), theEcorePackage.getEBoolean(), "isFunctional", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getForwardRelation__IsInverseFunctional(), theEcorePackage.getEBoolean(), "isInverseFunctional", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getForwardRelation__IsSymmetric(), theEcorePackage.getEBoolean(), "isSymmetric", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getForwardRelation__IsAsymmetric(), theEcorePackage.getEBoolean(), "isAsymmetric", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getForwardRelation__IsReflexive(), theEcorePackage.getEBoolean(), "isReflexive", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getForwardRelation__IsIrreflexive(), theEcorePackage.getEBoolean(), "isIrreflexive", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getForwardRelation__IsTransitive(), theEcorePackage.getEBoolean(), "isTransitive", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getForwardRelation__GetDomains(), this.getEntity(), "getDomains", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getForwardRelation__GetRanges(), this.getEntity(), "getRanges", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getForwardRelation__GetInverse(), this.getRelation(), "getInverse", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(reverseRelationEClass, ReverseRelation.class, "ReverseRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReverseRelation_RelationBase(), this.getRelationBase(), this.getRelationBase_ReverseRelation(), "relationBase", null, 1, 1, ReverseRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getReverseRelation__GetRef(), this.getMember(), "getRef", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReverseRelation__IsFunctional(), theEcorePackage.getEBoolean(), "isFunctional", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReverseRelation__IsInverseFunctional(), theEcorePackage.getEBoolean(), "isInverseFunctional", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReverseRelation__IsSymmetric(), theEcorePackage.getEBoolean(), "isSymmetric", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReverseRelation__IsAsymmetric(), theEcorePackage.getEBoolean(), "isAsymmetric", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReverseRelation__IsReflexive(), theEcorePackage.getEBoolean(), "isReflexive", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReverseRelation__IsIrreflexive(), theEcorePackage.getEBoolean(), "isIrreflexive", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReverseRelation__IsTransitive(), theEcorePackage.getEBoolean(), "isTransitive", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReverseRelation__GetDomains(), this.getEntity(), "getDomains", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReverseRelation__GetRanges(), this.getEntity(), "getRanges", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReverseRelation__GetInverse(), this.getRelation(), "getInverse", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(unreifiedRelationEClass, UnreifiedRelation.class, "UnreifiedRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnreifiedRelation_Ref(), this.getRelation(), null, "ref", null, 0, 1, UnreifiedRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getUnreifiedRelation__GetDomains(), this.getEntity(), "getDomains", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getUnreifiedRelation__GetRanges(), this.getEntity(), "getRanges", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getUnreifiedRelation__GetInverse(), this.getRelation(), "getInverse", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(namedInstanceEClass, NamedInstance.class, "NamedInstance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNamedInstance_OwnedTypes(), this.getTypeAssertion(), this.getTypeAssertion_OwningInstance(), "ownedTypes", null, 0, -1, NamedInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getNamedInstance__GetEntityTypes(), this.getEntity(), "getEntityTypes", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getNamedInstance__GetTypes(), this.getClassifier(), "getTypes", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(conceptInstanceEClass, ConceptInstance.class, "ConceptInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptInstance_Ref(), this.getConceptInstance(), null, "ref", null, 0, 1, ConceptInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationInstanceEClass, RelationInstance.class, "RelationInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationInstance_Ref(), this.getRelationInstance(), null, "ref", null, 0, 1, RelationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationInstance_Sources(), this.getNamedInstance(), null, "sources", null, 0, -1, RelationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationInstance_Targets(), this.getNamedInstance(), null, "targets", null, 0, -1, RelationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structureInstanceEClass, StructureInstance.class, "StructureInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructureInstance_Type(), this.getStructure(), null, "type", null, 1, 1, StructureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureInstance_OwningAxiom(), this.getPropertyValueRestrictionAxiom(), this.getPropertyValueRestrictionAxiom_ContainedValue(), "owningAxiom", null, 0, 1, StructureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureInstance_OwningAssertion(), this.getPropertyValueAssertion(), this.getPropertyValueAssertion_ContainedValue(), "owningAssertion", null, 0, 1, StructureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getStructureInstance__GetTypes(), this.getClassifier(), "getTypes", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(keyAxiomEClass, KeyAxiom.class, "KeyAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKeyAxiom_Properties(), this.getProperty(), null, "properties", null, 1, -1, KeyAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKeyAxiom_OwningEntity(), this.getEntity(), this.getEntity_OwnedKeys(), "owningEntity", null, 0, 1, KeyAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getKeyAxiom__GetKeyedEntity(), this.getEntity(), "getKeyedEntity", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getKeyAxiom__GetCharacterizedTerm(), this.getEntity(), "getCharacterizedTerm", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(specializationAxiomEClass, SpecializationAxiom.class, "SpecializationAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecializationAxiom_SuperTerm(), this.getTerm(), null, "superTerm", null, 1, 1, SpecializationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecializationAxiom_OwningTerm(), this.getSpecializableTerm(), this.getSpecializableTerm_OwnedSpecializations(), "owningTerm", null, 0, 1, SpecializationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getSpecializationAxiom__GetSubTerm(), this.getTerm(), "getSubTerm", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSpecializationAxiom__GetCharacterizedTerm(), this.getTerm(), "getCharacterizedTerm", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(instanceEnumerationAxiomEClass, InstanceEnumerationAxiom.class, "InstanceEnumerationAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstanceEnumerationAxiom_Instances(), this.getConceptInstance(), null, "instances", null, 1, -1, InstanceEnumerationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstanceEnumerationAxiom_OwningConcept(), this.getConcept(), this.getConcept_OwnedEnumeration(), "owningConcept", null, 0, 1, InstanceEnumerationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getInstanceEnumerationAxiom__GetEnumeratedConcept(), this.getConcept(), "getEnumeratedConcept", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getInstanceEnumerationAxiom__GetCharacterizedTerm(), this.getConcept(), "getCharacterizedTerm", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(propertyRestrictionAxiomEClass, PropertyRestrictionAxiom.class, "PropertyRestrictionAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyRestrictionAxiom_Property(), this.getSemanticProperty(), null, "property", null, 1, 1, PropertyRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyRestrictionAxiom_OwningClassifier(), this.getClassifier(), this.getClassifier_OwnedPropertyRestrictions(), "owningClassifier", null, 0, 1, PropertyRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyRestrictionAxiom_OwningAxiom(), this.getClassifierEquivalenceAxiom(), this.getClassifierEquivalenceAxiom_OwnedPropertyRestrictions(), "owningAxiom", null, 0, 1, PropertyRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getPropertyRestrictionAxiom__GetRestrictingDomain(), this.getClassifier(), "getRestrictingDomain", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getPropertyRestrictionAxiom__GetCharacterizedTerm(), this.getClassifier(), "getCharacterizedTerm", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(literalEnumerationAxiomEClass, LiteralEnumerationAxiom.class, "LiteralEnumerationAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiteralEnumerationAxiom_Literals(), this.getLiteral(), null, "literals", null, 1, -1, LiteralEnumerationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLiteralEnumerationAxiom_OwningScalar(), this.getScalar(), this.getScalar_OwnedEnumeration(), "owningScalar", null, 0, 1, LiteralEnumerationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getLiteralEnumerationAxiom__GetEnumeratedScalar(), this.getScalar(), "getEnumeratedScalar", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getLiteralEnumerationAxiom__GetCharacterizedTerm(), this.getScalar(), "getCharacterizedTerm", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(classifierEquivalenceAxiomEClass, ClassifierEquivalenceAxiom.class, "ClassifierEquivalenceAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassifierEquivalenceAxiom_SuperClassifiers(), this.getClassifier(), null, "superClassifiers", null, 0, -1, ClassifierEquivalenceAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierEquivalenceAxiom_OwnedPropertyRestrictions(), this.getPropertyRestrictionAxiom(), this.getPropertyRestrictionAxiom_OwningAxiom(), "ownedPropertyRestrictions", null, 0, -1, ClassifierEquivalenceAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierEquivalenceAxiom_OwningClassifier(), this.getClassifier(), this.getClassifier_OwnedEquivalences(), "owningClassifier", null, 0, 1, ClassifierEquivalenceAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getClassifierEquivalenceAxiom__GetSubClassifier(), this.getClassifier(), "getSubClassifier", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClassifierEquivalenceAxiom__GetCharacterizedTerm(), this.getClassifier(), "getCharacterizedTerm", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(scalarEquivalenceAxiomEClass, ScalarEquivalenceAxiom.class, "ScalarEquivalenceAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScalarEquivalenceAxiom_SuperScalar(), this.getScalar(), null, "superScalar", null, 1, 1, ScalarEquivalenceAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalarEquivalenceAxiom_OwningScalar(), this.getScalar(), this.getScalar_OwnedEquivalences(), "owningScalar", null, 1, 1, ScalarEquivalenceAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScalarEquivalenceAxiom_Length(), this.getUnsignedInteger(), "length", null, 0, 1, ScalarEquivalenceAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScalarEquivalenceAxiom_MinLength(), this.getUnsignedInteger(), "minLength", null, 0, 1, ScalarEquivalenceAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScalarEquivalenceAxiom_MaxLength(), this.getUnsignedInteger(), "maxLength", null, 0, 1, ScalarEquivalenceAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScalarEquivalenceAxiom_Pattern(), theEcorePackage.getEString(), "pattern", null, 0, 1, ScalarEquivalenceAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScalarEquivalenceAxiom_Language(), theEcorePackage.getEString(), "language", null, 0, 1, ScalarEquivalenceAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalarEquivalenceAxiom_MinInclusive(), this.getLiteral(), null, "minInclusive", null, 0, 1, ScalarEquivalenceAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalarEquivalenceAxiom_MinExclusive(), this.getLiteral(), null, "minExclusive", null, 0, 1, ScalarEquivalenceAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalarEquivalenceAxiom_MaxInclusive(), this.getLiteral(), null, "maxInclusive", null, 0, 1, ScalarEquivalenceAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalarEquivalenceAxiom_MaxExclusive(), this.getLiteral(), null, "maxExclusive", null, 0, 1, ScalarEquivalenceAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getScalarEquivalenceAxiom__GetSubScalar(), this.getScalar(), "getSubScalar", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getScalarEquivalenceAxiom__GetCharacterizedTerm(), this.getScalar(), "getCharacterizedTerm", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(propertyEquivalenceAxiomEClass, PropertyEquivalenceAxiom.class, "PropertyEquivalenceAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyEquivalenceAxiom_SuperProperty(), this.getProperty(), null, "superProperty", null, 1, 1, PropertyEquivalenceAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyEquivalenceAxiom_OwningProperty(), this.getSpecializableProperty(), this.getSpecializableProperty_OwnedEquivalences(), "owningProperty", null, 0, 1, PropertyEquivalenceAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getPropertyEquivalenceAxiom__GetSubProperty(), this.getProperty(), "getSubProperty", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getPropertyEquivalenceAxiom__GetCharacterizedTerm(), this.getProperty(), "getCharacterizedTerm", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(propertyRangeRestrictionAxiomEClass, PropertyRangeRestrictionAxiom.class, "PropertyRangeRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyRangeRestrictionAxiom_Kind(), this.getRangeRestrictionKind(), "kind", "all", 1, 1, PropertyRangeRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyRangeRestrictionAxiom_Range(), this.getType(), null, "range", null, 1, 1, PropertyRangeRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyCardinalityRestrictionAxiomEClass, PropertyCardinalityRestrictionAxiom.class, "PropertyCardinalityRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyCardinalityRestrictionAxiom_Kind(), this.getCardinalityRestrictionKind(), "kind", "exactly", 1, 1, PropertyCardinalityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyCardinalityRestrictionAxiom_Cardinality(), this.getUnsignedInt(), "cardinality", "1", 1, 1, PropertyCardinalityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyCardinalityRestrictionAxiom_Range(), this.getType(), null, "range", null, 0, 1, PropertyCardinalityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyValueRestrictionAxiomEClass, PropertyValueRestrictionAxiom.class, "PropertyValueRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyValueRestrictionAxiom_LiteralValue(), this.getLiteral(), null, "literalValue", null, 0, 1, PropertyValueRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyValueRestrictionAxiom_ContainedValue(), this.getStructureInstance(), this.getStructureInstance_OwningAxiom(), "containedValue", null, 0, 1, PropertyValueRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyValueRestrictionAxiom_ReferencedValue(), this.getNamedInstance(), null, "referencedValue", null, 0, 1, PropertyValueRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getPropertyValueRestrictionAxiom__GetValue(), this.getElement(), "getValue", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(propertySelfRestrictionAxiomEClass, PropertySelfRestrictionAxiom.class, "PropertySelfRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeAssertionEClass, TypeAssertion.class, "TypeAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeAssertion_Type(), this.getEntity(), null, "type", null, 1, 1, TypeAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeAssertion_OwningInstance(), this.getNamedInstance(), this.getNamedInstance_OwnedTypes(), "owningInstance", null, 0, 1, TypeAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getTypeAssertion__GetSubject(), this.getNamedInstance(), "getSubject", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTypeAssertion__GetObject(), this.getElement(), "getObject", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(propertyValueAssertionEClass, PropertyValueAssertion.class, "PropertyValueAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyValueAssertion_Property(), this.getSemanticProperty(), null, "property", null, 1, 1, PropertyValueAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyValueAssertion_LiteralValue(), this.getLiteral(), null, "literalValue", null, 0, 1, PropertyValueAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyValueAssertion_ContainedValue(), this.getStructureInstance(), this.getStructureInstance_OwningAssertion(), "containedValue", null, 0, 1, PropertyValueAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyValueAssertion_ReferencedValue(), this.getNamedInstance(), null, "referencedValue", null, 0, 1, PropertyValueAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyValueAssertion_OwningInstance(), this.getInstance(), this.getInstance_OwnedPropertyValues(), "owningInstance", null, 0, 1, PropertyValueAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getPropertyValueAssertion__GetValue(), this.getElement(), "getValue", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getPropertyValueAssertion__GetSubject(), this.getInstance(), "getSubject", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getPropertyValueAssertion__GetObject(), this.getElement(), "getObject", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(unaryPredicateEClass, UnaryPredicate.class, "UnaryPredicate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnaryPredicate_Argument(), this.getArgument(), null, "argument", null, 1, 1, UnaryPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryPredicateEClass, BinaryPredicate.class, "BinaryPredicate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryPredicate_Argument1(), this.getArgument(), null, "argument1", null, 1, 1, BinaryPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryPredicate_Argument2(), this.getArgument(), null, "argument2", null, 1, 1, BinaryPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(builtInPredicateEClass, BuiltInPredicate.class, "BuiltInPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBuiltInPredicate_BuiltIn(), this.getBuiltIn(), null, "builtIn", null, 1, 1, BuiltInPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuiltInPredicate_Arguments(), this.getArgument(), null, "arguments", null, 1, -1, BuiltInPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typePredicateEClass, TypePredicate.class, "TypePredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypePredicate_Type(), this.getType(), null, "type", null, 1, 1, TypePredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationEntityPredicateEClass, RelationEntityPredicate.class, "RelationEntityPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationEntityPredicate_Type(), this.getRelationEntity(), null, "type", null, 1, 1, RelationEntityPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyPredicateEClass, PropertyPredicate.class, "PropertyPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyPredicate_Property(), this.getProperty(), null, "property", null, 1, 1, PropertyPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sameAsPredicateEClass, SameAsPredicate.class, "SameAsPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(differentFromPredicateEClass, DifferentFromPredicate.class, "DifferentFromPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(quotedLiteralEClass, QuotedLiteral.class, "QuotedLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQuotedLiteral_Value(), theEcorePackage.getEString(), "value", null, 1, 1, QuotedLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQuotedLiteral_LangTag(), theEcorePackage.getEString(), "langTag", null, 0, 1, QuotedLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQuotedLiteral_Type(), this.getScalar(), null, "type", null, 0, 1, QuotedLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getQuotedLiteral__GetLexicalValue(), theEcorePackage.getEString(), "getLexicalValue", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getQuotedLiteral__GetTypeIri(), theEcorePackage.getEString(), "getTypeIri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(integerLiteralEClass, IntegerLiteral.class, "IntegerLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerLiteral_Value(), theEcorePackage.getEIntegerObject(), "value", "0", 0, 1, IntegerLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getIntegerLiteral__GetTypeIri(), theEcorePackage.getEString(), "getTypeIri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(decimalLiteralEClass, DecimalLiteral.class, "DecimalLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDecimalLiteral_Value(), this.getDecimal(), "value", "0.0", 1, 1, DecimalLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getDecimalLiteral__GetTypeIri(), theEcorePackage.getEString(), "getTypeIri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(doubleLiteralEClass, DoubleLiteral.class, "DoubleLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleLiteral_Value(), this.getDouble(), "value", "0.0", 0, 1, DoubleLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getDoubleLiteral__GetTypeIri(), theEcorePackage.getEString(), "getTypeIri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(booleanLiteralEClass, BooleanLiteral.class, "BooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanLiteral_Value(), theEcorePackage.getEBooleanObject(), "value", "false", 0, 1, BooleanLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getBooleanLiteral__IsValue(), theEcorePackage.getEBoolean(), "isValue", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getBooleanLiteral__GetTypeIri(), theEcorePackage.getEString(), "getTypeIri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(separatorKindEEnum, SeparatorKind.class, "SeparatorKind");
		addEEnumLiteral(separatorKindEEnum, SeparatorKind.HASH);
		addEEnumLiteral(separatorKindEEnum, SeparatorKind.SLASH);

		initEEnum(rangeRestrictionKindEEnum, RangeRestrictionKind.class, "RangeRestrictionKind");
		addEEnumLiteral(rangeRestrictionKindEEnum, RangeRestrictionKind.ALL);
		addEEnumLiteral(rangeRestrictionKindEEnum, RangeRestrictionKind.SOME);

		initEEnum(cardinalityRestrictionKindEEnum, CardinalityRestrictionKind.class, "CardinalityRestrictionKind");
		addEEnumLiteral(cardinalityRestrictionKindEEnum, CardinalityRestrictionKind.EXACTLY);
		addEEnumLiteral(cardinalityRestrictionKindEEnum, CardinalityRestrictionKind.MIN);
		addEEnumLiteral(cardinalityRestrictionKindEEnum, CardinalityRestrictionKind.MAX);

		initEEnum(importKindEEnum, ImportKind.class, "ImportKind");
		addEEnumLiteral(importKindEEnum, ImportKind.EXTENSION);
		addEEnumLiteral(importKindEEnum, ImportKind.USAGE);
		addEEnumLiteral(importKindEEnum, ImportKind.INCLUSION);

		// Initialize data types
		initEDataType(unsignedIntEDataType, int.class, "UnsignedInt", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(unsignedIntegerEDataType, Integer.class, "UnsignedInteger", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(decimalEDataType, BigDecimal.class, "Decimal", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(doubleEDataType, Double.class, "Double", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(idEDataType, String.class, "ID", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(namespaceEDataType, String.class, "Namespace", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// https://tabatkins.github.io/bikeshed/headings
		createHeadingsAnnotations();
		// https://tabatkins.github.io/bikeshed
		createBikeshedAnnotations();
		// http://www.eclipse.org/emf/2011/Xcore
		createXcoreAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>https://tabatkins.github.io/bikeshed/headings</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createHeadingsAnnotations() {
		String source = "https://tabatkins.github.io/bikeshed/headings";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "Elements", "",
			   "Literals", "",
			   "Vocabularies", "",
			   "Types", "",
			   "Properties", "",
			   "Relations", "",
			   "Predicates", "",
			   "Axioms", "",
			   "Descriptions", "",
			   "Instances", "",
			   "Assertions", "",
			   "Enumerations", ""
		   });
	}

	/**
	 * Initializes the annotations for <b>https://tabatkins.github.io/bikeshed</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createBikeshedAnnotations() {
		String source = "https://tabatkins.github.io/bikeshed";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "heading", "Abstract-Syntax"
		   });
		addAnnotation
		  (elementEClass,
		   source,
		   new String[] {
			   "heading", "Elements"
		   });
		addAnnotation
		  (annotationEClass,
		   source,
		   new String[] {
			   "heading", "Elements"
		   });
		addAnnotation
		  (identifiedElementEClass,
		   source,
		   new String[] {
			   "heading", "Elements"
		   });
		addAnnotation
		  (importEClass,
		   source,
		   new String[] {
			   "heading", "Elements"
		   });
		addAnnotation
		  (instanceEClass,
		   source,
		   new String[] {
			   "heading", "Instances"
		   });
		addAnnotation
		  (axiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (assertionEClass,
		   source,
		   new String[] {
			   "heading", "Assertions"
		   });
		addAnnotation
		  (predicateEClass,
		   source,
		   new String[] {
			   "heading", "Predicates"
		   });
		addAnnotation
		  (argumentEClass,
		   source,
		   new String[] {
			   "heading", "Predicates"
		   });
		addAnnotation
		  (literalEClass,
		   source,
		   new String[] {
			   "heading", "Literals"
		   });
		addAnnotation
		  (ontologyEClass,
		   source,
		   new String[] {
			   "heading", "Elements"
		   });
		addAnnotation
		  (memberEClass,
		   source,
		   new String[] {
			   "heading", "Elements"
		   });
		addAnnotation
		  (vocabularyBoxEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (descriptionBoxEClass,
		   source,
		   new String[] {
			   "heading", "Descriptions"
		   });
		addAnnotation
		  (vocabularyEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (vocabularyBundleEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (descriptionEClass,
		   source,
		   new String[] {
			   "heading", "Descriptions"
		   });
		addAnnotation
		  (descriptionBundleEClass,
		   source,
		   new String[] {
			   "heading", "Descriptions"
		   });
		addAnnotation
		  (statementEClass,
		   source,
		   new String[] {
			   "heading", "Elements"
		   });
		addAnnotation
		  (vocabularyMemberEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (descriptionMemberEClass,
		   source,
		   new String[] {
			   "heading", "Descriptions"
		   });
		addAnnotation
		  (vocabularyStatementEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (descriptionStatementEClass,
		   source,
		   new String[] {
			   "heading", "Descriptions"
		   });
		addAnnotation
		  (termEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (ruleEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (builtInEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (specializableTermEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (propertyEClass,
		   source,
		   new String[] {
			   "heading", "Properties"
		   });
		addAnnotation
		  (typeEClass,
		   source,
		   new String[] {
			   "heading", "Types"
		   });
		addAnnotation
		  (relationBaseEClass,
		   source,
		   new String[] {
			   "heading", "Relations"
		   });
		addAnnotation
		  (specializablePropertyEClass,
		   source,
		   new String[] {
			   "heading", "Properties"
		   });
		addAnnotation
		  (classifierEClass,
		   source,
		   new String[] {
			   "heading", "Types"
		   });
		addAnnotation
		  (scalarEClass,
		   source,
		   new String[] {
			   "heading", "Types"
		   });
		addAnnotation
		  (entityEClass,
		   source,
		   new String[] {
			   "heading", "Types"
		   });
		addAnnotation
		  (structureEClass,
		   source,
		   new String[] {
			   "heading", "Types"
		   });
		addAnnotation
		  (aspectEClass,
		   source,
		   new String[] {
			   "heading", "Types"
		   });
		addAnnotation
		  (conceptEClass,
		   source,
		   new String[] {
			   "heading", "Types"
		   });
		addAnnotation
		  (relationEntityEClass,
		   source,
		   new String[] {
			   "heading", "Relations"
		   });
		addAnnotation
		  (annotationPropertyEClass,
		   source,
		   new String[] {
			   "heading", "Properties"
		   });
		addAnnotation
		  (semanticPropertyEClass,
		   source,
		   new String[] {
			   "heading", "Properties"
		   });
		addAnnotation
		  (scalarPropertyEClass,
		   source,
		   new String[] {
			   "heading", "Properties"
		   });
		addAnnotation
		  (structuredPropertyEClass,
		   source,
		   new String[] {
			   "heading", "Properties"
		   });
		addAnnotation
		  (relationEClass,
		   source,
		   new String[] {
			   "heading", "Properties"
		   });
		addAnnotation
		  (forwardRelationEClass,
		   source,
		   new String[] {
			   "heading", "Relations"
		   });
		addAnnotation
		  (reverseRelationEClass,
		   source,
		   new String[] {
			   "heading", "Relations"
		   });
		addAnnotation
		  (unreifiedRelationEClass,
		   source,
		   new String[] {
			   "heading", "Relations"
		   });
		addAnnotation
		  (namedInstanceEClass,
		   source,
		   new String[] {
			   "heading", "Instances"
		   });
		addAnnotation
		  (conceptInstanceEClass,
		   source,
		   new String[] {
			   "heading", "Instances"
		   });
		addAnnotation
		  (relationInstanceEClass,
		   source,
		   new String[] {
			   "heading", "Instances"
		   });
		addAnnotation
		  (structureInstanceEClass,
		   source,
		   new String[] {
			   "heading", "Instances"
		   });
		addAnnotation
		  (keyAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (specializationAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (instanceEnumerationAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (propertyRestrictionAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (literalEnumerationAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (classifierEquivalenceAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (scalarEquivalenceAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (propertyEquivalenceAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (propertyRangeRestrictionAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (propertyCardinalityRestrictionAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (propertyValueRestrictionAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (propertySelfRestrictionAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (typeAssertionEClass,
		   source,
		   new String[] {
			   "heading", "Assertions"
		   });
		addAnnotation
		  (propertyValueAssertionEClass,
		   source,
		   new String[] {
			   "heading", "Assertions"
		   });
		addAnnotation
		  (unaryPredicateEClass,
		   source,
		   new String[] {
			   "heading", "Predicates"
		   });
		addAnnotation
		  (binaryPredicateEClass,
		   source,
		   new String[] {
			   "heading", "Predicates"
		   });
		addAnnotation
		  (builtInPredicateEClass,
		   source,
		   new String[] {
			   "heading", "Predicates"
		   });
		addAnnotation
		  (typePredicateEClass,
		   source,
		   new String[] {
			   "heading", "Predicates"
		   });
		addAnnotation
		  (relationEntityPredicateEClass,
		   source,
		   new String[] {
			   "heading", "Predicates"
		   });
		addAnnotation
		  (propertyPredicateEClass,
		   source,
		   new String[] {
			   "heading", "Predicates"
		   });
		addAnnotation
		  (sameAsPredicateEClass,
		   source,
		   new String[] {
			   "heading", "Predicates"
		   });
		addAnnotation
		  (differentFromPredicateEClass,
		   source,
		   new String[] {
			   "heading", "Predicates"
		   });
		addAnnotation
		  (quotedLiteralEClass,
		   source,
		   new String[] {
			   "heading", "Literals"
		   });
		addAnnotation
		  (integerLiteralEClass,
		   source,
		   new String[] {
			   "heading", "Literals"
		   });
		addAnnotation
		  (decimalLiteralEClass,
		   source,
		   new String[] {
			   "heading", "Literals"
		   });
		addAnnotation
		  (doubleLiteralEClass,
		   source,
		   new String[] {
			   "heading", "Literals"
		   });
		addAnnotation
		  (booleanLiteralEClass,
		   source,
		   new String[] {
			   "heading", "Literals"
		   });
		addAnnotation
		  (separatorKindEEnum,
		   source,
		   new String[] {
			   "heading", "Elements"
		   });
		addAnnotation
		  (rangeRestrictionKindEEnum,
		   source,
		   new String[] {
			   "heading", "Properties"
		   });
		addAnnotation
		  (cardinalityRestrictionKindEEnum,
		   source,
		   new String[] {
			   "heading", "Properties"
		   });
		addAnnotation
		  (importKindEEnum,
		   source,
		   new String[] {
			   "heading", "Elements"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2011/Xcore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createXcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2011/Xcore";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "Bikeshed", "https://tabatkins.github.io/bikeshed",
			   "BikeshedHeadings", "https://tabatkins.github.io/bikeshed/headings"
		   });
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
		addAnnotation
		  (unsignedIntEDataType,
		   source,
		   new String[] {
			   "minInclusive", "0",
			   "maxInclusive", "2147483647"
		   });
		addAnnotation
		  (unsignedIntegerEDataType,
		   source,
		   new String[] {
			   "minInclusive", "0",
			   "maxInclusive", "2147483647"
		   });
		addAnnotation
		  (decimalEDataType,
		   source,
		   new String[] {
			   "baseType", "http://www.w3.org/2001/XMLSchema#decimal"
		   });
		addAnnotation
		  (idEDataType,
		   source,
		   new String[] {
			   "pattern", "[a-zA-Z0-9_]([a-zA-Z0-9_\\-.$])*"
		   });
		addAnnotation
		  (namespaceEDataType,
		   source,
		   new String[] {
			   "pattern", "([^\\s#])*(#|/)",
			   "minLength", "2"
		   });
	}

} //OmlPackageImpl
