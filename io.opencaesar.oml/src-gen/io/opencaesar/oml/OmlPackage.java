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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * This Ecore package specifies the syntax (metamodel) of the Ontological Modeling Language. OML models are instances of
 * this metamodel and can be manipulated using its API.
 * <!-- end-model-doc -->
 * @see io.opencaesar.oml.OmlFactory
 * @model kind="package"
 *        annotation="https://tabatkins.github.io/bikeshed/headings Elements='' Literals='' Vocabularies='' Types='' Properties='' Relations='' Predicates='' Axioms='' Descriptions='' Instances='' Assertions='' Enumerations=''"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Abstract-Syntax'"
 *        annotation="http://www.eclipse.org/emf/2011/Xcore Bikeshed='https://tabatkins.github.io/bikeshed' BikeshedHeadings='https://tabatkins.github.io/bikeshed/headings'"
 * @generated
 */
public interface OmlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "oml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://opencaesar.io/oml";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "oml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OmlPackage eINSTANCE = io.opencaesar.oml.impl.OmlPackageImpl.init();

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.ElementImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT___GET_ONTOLOGY = 0;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = 1;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.AnnotationImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 1;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__PROPERTY = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Literal Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__LITERAL_VALUE = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referenced Value</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__REFERENCED_VALUE = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owning Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__OWNING_ELEMENT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION___GET_ONTOLOGY = ELEMENT___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = ELEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION___GET_VALUE = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Annotated Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION___GET_ANNOTATED_ELEMENT = ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.IdentifiedElementImpl <em>Identified Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.IdentifiedElementImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getIdentifiedElement()
	 * @generated
	 */
	int IDENTIFIED_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIED_ELEMENT__OWNED_ANNOTATIONS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Identified Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIED_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIED_ELEMENT___GET_ONTOLOGY = ELEMENT___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIED_ELEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = ELEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIED_ELEMENT___GET_IRI = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Identified Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIED_ELEMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.ImportImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 3;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__KIND = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__NAMESPACE = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__PREFIX = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owning Ontology</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__OWNING_ONTOLOGY = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT___GET_ONTOLOGY = ELEMENT___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = ELEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT___GET_IRI = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Separator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT___GET_SEPARATOR = ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.InstanceImpl <em>Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.InstanceImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getInstance()
	 * @generated
	 */
	int INSTANCE = 4;

	/**
	 * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__OWNED_PROPERTY_VALUES = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE___GET_ONTOLOGY = ELEMENT___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = ELEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE___GET_TYPES = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.AxiomImpl <em>Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.AxiomImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getAxiom()
	 * @generated
	 */
	int AXIOM = 5;

	/**
	 * The number of structural features of the '<em>Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIOM_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIOM___GET_ONTOLOGY = ELEMENT___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = ELEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Characterized Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIOM___GET_CHARACTERIZED_TERM = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIOM_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.AssertionImpl <em>Assertion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.AssertionImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getAssertion()
	 * @generated
	 */
	int ASSERTION = 6;

	/**
	 * The number of structural features of the '<em>Assertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION___GET_ONTOLOGY = ELEMENT___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = ELEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Subject</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION___GET_SUBJECT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION___GET_OBJECT = ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Assertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.PredicateImpl <em>Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.PredicateImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getPredicate()
	 * @generated
	 */
	int PREDICATE = 7;

	/**
	 * The feature id for the '<em><b>Antecedent Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__ANTECEDENT_RULE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Consequent Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__CONSEQUENT_RULE = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE___GET_ONTOLOGY = ELEMENT___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = ELEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.ArgumentImpl <em>Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.ArgumentImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getArgument()
	 * @generated
	 */
	int ARGUMENT = 8;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__VARIABLE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__LITERAL = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__INSTANCE = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT___GET_ONTOLOGY = ELEMENT___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = ELEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT___GET_VALUE = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.LiteralImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getLiteral()
	 * @generated
	 */
	int LITERAL = 9;

	/**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL___GET_ONTOLOGY = ELEMENT___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = ELEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL___GET_VALUE = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL___GET_STRING_VALUE = ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Lexical Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL___GET_LEXICAL_VALUE = ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Type Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL___GET_TYPE_IRI = ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.OntologyImpl <em>Ontology</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.OntologyImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getOntology()
	 * @generated
	 */
	int ONTOLOGY = 10;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGY__OWNED_ANNOTATIONS = IDENTIFIED_ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGY__NAMESPACE = IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGY__PREFIX = IDENTIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGY__OWNED_IMPORTS = IDENTIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Ontology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGY_FEATURE_COUNT = IDENTIFIED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGY___GET_ONTOLOGY = IDENTIFIED_ELEMENT___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = IDENTIFIED_ELEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGY___GET_IRI = IDENTIFIED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Separator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGY___GET_SEPARATOR = IDENTIFIED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Ontology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGY_OPERATION_COUNT = IDENTIFIED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.MemberImpl <em>Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.MemberImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getMember()
	 * @generated
	 */
	int MEMBER = 11;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER__OWNED_ANNOTATIONS = IDENTIFIED_ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER__NAME = IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_FEATURE_COUNT = IDENTIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER___GET_ONTOLOGY = IDENTIFIED_ELEMENT___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = IDENTIFIED_ELEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER___GET_REF = IDENTIFIED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER___IS_REF = IDENTIFIED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER___RESOLVE = IDENTIFIED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER___GET_IRI = IDENTIFIED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER___GET_ABBREVIATED_IRI = IDENTIFIED_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_OPERATION_COUNT = IDENTIFIED_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.VocabularyBoxImpl <em>Vocabulary Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.VocabularyBoxImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getVocabularyBox()
	 * @generated
	 */
	int VOCABULARY_BOX = 12;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BOX__OWNED_ANNOTATIONS = ONTOLOGY__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BOX__NAMESPACE = ONTOLOGY__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BOX__PREFIX = ONTOLOGY__PREFIX;

	/**
	 * The feature id for the '<em><b>Owned Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BOX__OWNED_IMPORTS = ONTOLOGY__OWNED_IMPORTS;

	/**
	 * The number of structural features of the '<em>Vocabulary Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BOX_FEATURE_COUNT = ONTOLOGY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BOX___GET_ONTOLOGY = ONTOLOGY___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BOX___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = ONTOLOGY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BOX___GET_IRI = ONTOLOGY___GET_IRI;

	/**
	 * The operation id for the '<em>Get Separator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BOX___GET_SEPARATOR = ONTOLOGY___GET_SEPARATOR;

	/**
	 * The number of operations of the '<em>Vocabulary Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BOX_OPERATION_COUNT = ONTOLOGY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.DescriptionBoxImpl <em>Description Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.DescriptionBoxImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDescriptionBox()
	 * @generated
	 */
	int DESCRIPTION_BOX = 13;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX__OWNED_ANNOTATIONS = ONTOLOGY__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX__NAMESPACE = ONTOLOGY__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX__PREFIX = ONTOLOGY__PREFIX;

	/**
	 * The feature id for the '<em><b>Owned Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX__OWNED_IMPORTS = ONTOLOGY__OWNED_IMPORTS;

	/**
	 * The number of structural features of the '<em>Description Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_FEATURE_COUNT = ONTOLOGY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX___GET_ONTOLOGY = ONTOLOGY___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = ONTOLOGY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX___GET_IRI = ONTOLOGY___GET_IRI;

	/**
	 * The operation id for the '<em>Get Separator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX___GET_SEPARATOR = ONTOLOGY___GET_SEPARATOR;

	/**
	 * The number of operations of the '<em>Description Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_OPERATION_COUNT = ONTOLOGY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.VocabularyImpl <em>Vocabulary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.VocabularyImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getVocabulary()
	 * @generated
	 */
	int VOCABULARY = 14;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY__OWNED_ANNOTATIONS = VOCABULARY_BOX__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY__NAMESPACE = VOCABULARY_BOX__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY__PREFIX = VOCABULARY_BOX__PREFIX;

	/**
	 * The feature id for the '<em><b>Owned Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY__OWNED_IMPORTS = VOCABULARY_BOX__OWNED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Owned Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY__OWNED_STATEMENTS = VOCABULARY_BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Vocabulary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_FEATURE_COUNT = VOCABULARY_BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY___GET_ONTOLOGY = VOCABULARY_BOX___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = VOCABULARY_BOX___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY___GET_IRI = VOCABULARY_BOX___GET_IRI;

	/**
	 * The operation id for the '<em>Get Separator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY___GET_SEPARATOR = VOCABULARY_BOX___GET_SEPARATOR;

	/**
	 * The number of operations of the '<em>Vocabulary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_OPERATION_COUNT = VOCABULARY_BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.VocabularyBundleImpl <em>Vocabulary Bundle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.VocabularyBundleImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getVocabularyBundle()
	 * @generated
	 */
	int VOCABULARY_BUNDLE = 15;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BUNDLE__OWNED_ANNOTATIONS = VOCABULARY_BOX__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BUNDLE__NAMESPACE = VOCABULARY_BOX__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BUNDLE__PREFIX = VOCABULARY_BOX__PREFIX;

	/**
	 * The feature id for the '<em><b>Owned Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BUNDLE__OWNED_IMPORTS = VOCABULARY_BOX__OWNED_IMPORTS;

	/**
	 * The number of structural features of the '<em>Vocabulary Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BUNDLE_FEATURE_COUNT = VOCABULARY_BOX_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BUNDLE___GET_ONTOLOGY = VOCABULARY_BOX___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BUNDLE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = VOCABULARY_BOX___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BUNDLE___GET_IRI = VOCABULARY_BOX___GET_IRI;

	/**
	 * The operation id for the '<em>Get Separator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BUNDLE___GET_SEPARATOR = VOCABULARY_BOX___GET_SEPARATOR;

	/**
	 * The number of operations of the '<em>Vocabulary Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_BUNDLE_OPERATION_COUNT = VOCABULARY_BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.DescriptionImpl <em>Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.DescriptionImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDescription()
	 * @generated
	 */
	int DESCRIPTION = 16;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__OWNED_ANNOTATIONS = DESCRIPTION_BOX__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__NAMESPACE = DESCRIPTION_BOX__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__PREFIX = DESCRIPTION_BOX__PREFIX;

	/**
	 * The feature id for the '<em><b>Owned Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__OWNED_IMPORTS = DESCRIPTION_BOX__OWNED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Owned Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__OWNED_STATEMENTS = DESCRIPTION_BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_FEATURE_COUNT = DESCRIPTION_BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION___GET_ONTOLOGY = DESCRIPTION_BOX___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = DESCRIPTION_BOX___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION___GET_IRI = DESCRIPTION_BOX___GET_IRI;

	/**
	 * The operation id for the '<em>Get Separator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION___GET_SEPARATOR = DESCRIPTION_BOX___GET_SEPARATOR;

	/**
	 * The number of operations of the '<em>Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_OPERATION_COUNT = DESCRIPTION_BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.DescriptionBundleImpl <em>Description Bundle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.DescriptionBundleImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDescriptionBundle()
	 * @generated
	 */
	int DESCRIPTION_BUNDLE = 17;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BUNDLE__OWNED_ANNOTATIONS = DESCRIPTION_BOX__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BUNDLE__NAMESPACE = DESCRIPTION_BOX__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BUNDLE__PREFIX = DESCRIPTION_BOX__PREFIX;

	/**
	 * The feature id for the '<em><b>Owned Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BUNDLE__OWNED_IMPORTS = DESCRIPTION_BOX__OWNED_IMPORTS;

	/**
	 * The number of structural features of the '<em>Description Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BUNDLE_FEATURE_COUNT = DESCRIPTION_BOX_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BUNDLE___GET_ONTOLOGY = DESCRIPTION_BOX___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BUNDLE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = DESCRIPTION_BOX___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BUNDLE___GET_IRI = DESCRIPTION_BOX___GET_IRI;

	/**
	 * The operation id for the '<em>Get Separator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BUNDLE___GET_SEPARATOR = DESCRIPTION_BOX___GET_SEPARATOR;

	/**
	 * The number of operations of the '<em>Description Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BUNDLE_OPERATION_COUNT = DESCRIPTION_BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.StatementImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 18;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__OWNED_ANNOTATIONS = MEMBER__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__NAME = MEMBER__NAME;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = MEMBER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT___GET_ONTOLOGY = MEMBER___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = MEMBER___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT___GET_REF = MEMBER___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT___IS_REF = MEMBER___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT___RESOLVE = MEMBER___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT___GET_IRI = MEMBER___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT___GET_ABBREVIATED_IRI = MEMBER___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_OPERATION_COUNT = MEMBER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.VocabularyMemberImpl <em>Vocabulary Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.VocabularyMemberImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getVocabularyMember()
	 * @generated
	 */
	int VOCABULARY_MEMBER = 19;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_MEMBER__OWNED_ANNOTATIONS = MEMBER__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_MEMBER__NAME = MEMBER__NAME;

	/**
	 * The number of structural features of the '<em>Vocabulary Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_MEMBER_FEATURE_COUNT = MEMBER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_MEMBER___GET_ONTOLOGY = MEMBER___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_MEMBER___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = MEMBER___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_MEMBER___GET_REF = MEMBER___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_MEMBER___IS_REF = MEMBER___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_MEMBER___RESOLVE = MEMBER___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_MEMBER___GET_IRI = MEMBER___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_MEMBER___GET_ABBREVIATED_IRI = MEMBER___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Vocabulary Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_MEMBER_OPERATION_COUNT = MEMBER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.DescriptionMemberImpl <em>Description Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.DescriptionMemberImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDescriptionMember()
	 * @generated
	 */
	int DESCRIPTION_MEMBER = 20;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_MEMBER__OWNED_ANNOTATIONS = MEMBER__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_MEMBER__NAME = MEMBER__NAME;

	/**
	 * The number of structural features of the '<em>Description Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_MEMBER_FEATURE_COUNT = MEMBER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_MEMBER___GET_ONTOLOGY = MEMBER___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_MEMBER___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = MEMBER___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_MEMBER___GET_REF = MEMBER___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_MEMBER___IS_REF = MEMBER___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_MEMBER___RESOLVE = MEMBER___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_MEMBER___GET_IRI = MEMBER___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_MEMBER___GET_ABBREVIATED_IRI = MEMBER___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Description Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_MEMBER_OPERATION_COUNT = MEMBER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.VocabularyStatementImpl <em>Vocabulary Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.VocabularyStatementImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getVocabularyStatement()
	 * @generated
	 */
	int VOCABULARY_STATEMENT = 21;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_STATEMENT__OWNED_ANNOTATIONS = STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_STATEMENT__NAME = STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owning Vocabulary</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_STATEMENT__OWNING_VOCABULARY = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Vocabulary Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_STATEMENT___GET_ONTOLOGY = STATEMENT___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_STATEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = STATEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_STATEMENT___GET_REF = STATEMENT___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_STATEMENT___IS_REF = STATEMENT___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_STATEMENT___RESOLVE = STATEMENT___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_STATEMENT___GET_IRI = STATEMENT___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_STATEMENT___GET_ABBREVIATED_IRI = STATEMENT___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Vocabulary Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.DescriptionStatementImpl <em>Description Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.DescriptionStatementImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDescriptionStatement()
	 * @generated
	 */
	int DESCRIPTION_STATEMENT = 22;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_STATEMENT__OWNED_ANNOTATIONS = STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_STATEMENT__NAME = STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owning Description</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_STATEMENT__OWNING_DESCRIPTION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Description Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_STATEMENT___GET_ONTOLOGY = STATEMENT___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_STATEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = STATEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_STATEMENT___GET_REF = STATEMENT___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_STATEMENT___IS_REF = STATEMENT___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_STATEMENT___RESOLVE = STATEMENT___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_STATEMENT___GET_IRI = STATEMENT___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_STATEMENT___GET_ABBREVIATED_IRI = STATEMENT___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Description Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.TermImpl <em>Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.TermImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getTerm()
	 * @generated
	 */
	int TERM = 23;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__OWNED_ANNOTATIONS = VOCABULARY_MEMBER__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__NAME = VOCABULARY_MEMBER__NAME;

	/**
	 * The number of structural features of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_FEATURE_COUNT = VOCABULARY_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM___GET_ONTOLOGY = VOCABULARY_MEMBER___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = VOCABULARY_MEMBER___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM___GET_REF = VOCABULARY_MEMBER___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM___IS_REF = VOCABULARY_MEMBER___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM___RESOLVE = VOCABULARY_MEMBER___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM___GET_IRI = VOCABULARY_MEMBER___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM___GET_ABBREVIATED_IRI = VOCABULARY_MEMBER___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_OPERATION_COUNT = VOCABULARY_MEMBER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.RuleImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 24;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__OWNED_ANNOTATIONS = VOCABULARY_STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__NAME = VOCABULARY_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owning Vocabulary</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__OWNING_VOCABULARY = VOCABULARY_STATEMENT__OWNING_VOCABULARY;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__REF = VOCABULARY_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Antecedent</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__ANTECEDENT = VOCABULARY_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Consequent</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__CONSEQUENT = VOCABULARY_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = VOCABULARY_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE___GET_ONTOLOGY = VOCABULARY_STATEMENT___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = VOCABULARY_STATEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE___GET_REF = VOCABULARY_STATEMENT___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE___IS_REF = VOCABULARY_STATEMENT___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE___RESOLVE = VOCABULARY_STATEMENT___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE___GET_IRI = VOCABULARY_STATEMENT___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE___GET_ABBREVIATED_IRI = VOCABULARY_STATEMENT___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_OPERATION_COUNT = VOCABULARY_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.BuiltInImpl <em>Built In</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.BuiltInImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getBuiltIn()
	 * @generated
	 */
	int BUILT_IN = 25;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN__OWNED_ANNOTATIONS = VOCABULARY_STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN__NAME = VOCABULARY_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owning Vocabulary</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN__OWNING_VOCABULARY = VOCABULARY_STATEMENT__OWNING_VOCABULARY;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN__REF = VOCABULARY_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Built In</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_FEATURE_COUNT = VOCABULARY_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN___GET_ONTOLOGY = VOCABULARY_STATEMENT___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = VOCABULARY_STATEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN___GET_REF = VOCABULARY_STATEMENT___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN___IS_REF = VOCABULARY_STATEMENT___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN___RESOLVE = VOCABULARY_STATEMENT___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN___GET_IRI = VOCABULARY_STATEMENT___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN___GET_ABBREVIATED_IRI = VOCABULARY_STATEMENT___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Built In</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_OPERATION_COUNT = VOCABULARY_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.SpecializableTermImpl <em>Specializable Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.SpecializableTermImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getSpecializableTerm()
	 * @generated
	 */
	int SPECIALIZABLE_TERM = 26;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_TERM__OWNED_ANNOTATIONS = TERM__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_TERM__NAME = TERM__NAME;

	/**
	 * The feature id for the '<em><b>Owning Vocabulary</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_TERM__OWNING_VOCABULARY = TERM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Specializations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS = TERM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Specializable Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_TERM_FEATURE_COUNT = TERM_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_TERM___GET_ONTOLOGY = TERM___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_TERM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = TERM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_TERM___GET_REF = TERM___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_TERM___IS_REF = TERM___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_TERM___RESOLVE = TERM___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_TERM___GET_IRI = TERM___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_TERM___GET_ABBREVIATED_IRI = TERM___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Specializable Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_TERM_OPERATION_COUNT = TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.PropertyImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 27;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__OWNED_ANNOTATIONS = TERM__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = TERM__NAME;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = TERM_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___GET_ONTOLOGY = TERM___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = TERM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___GET_REF = TERM___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___IS_REF = TERM___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___RESOLVE = TERM___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___GET_IRI = TERM___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___GET_ABBREVIATED_IRI = TERM___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.TypeImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 28;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__OWNED_ANNOTATIONS = SPECIALIZABLE_TERM__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAME = SPECIALIZABLE_TERM__NAME;

	/**
	 * The feature id for the '<em><b>Owning Vocabulary</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__OWNING_VOCABULARY = SPECIALIZABLE_TERM__OWNING_VOCABULARY;

	/**
	 * The feature id for the '<em><b>Owned Specializations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__OWNED_SPECIALIZATIONS = SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = SPECIALIZABLE_TERM_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___GET_ONTOLOGY = SPECIALIZABLE_TERM___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = SPECIALIZABLE_TERM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___GET_REF = SPECIALIZABLE_TERM___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___IS_REF = SPECIALIZABLE_TERM___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___RESOLVE = SPECIALIZABLE_TERM___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___GET_IRI = SPECIALIZABLE_TERM___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___GET_ABBREVIATED_IRI = SPECIALIZABLE_TERM___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OPERATION_COUNT = SPECIALIZABLE_TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.RelationBaseImpl <em>Relation Base</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.RelationBaseImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getRelationBase()
	 * @generated
	 */
	int RELATION_BASE = 29;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE__OWNED_ANNOTATIONS = SPECIALIZABLE_TERM__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE__NAME = SPECIALIZABLE_TERM__NAME;

	/**
	 * The feature id for the '<em><b>Owning Vocabulary</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE__OWNING_VOCABULARY = SPECIALIZABLE_TERM__OWNING_VOCABULARY;

	/**
	 * The feature id for the '<em><b>Owned Specializations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE__OWNED_SPECIALIZATIONS = SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE__SOURCES = SPECIALIZABLE_TERM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE__TARGETS = SPECIALIZABLE_TERM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reverse Relation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE__REVERSE_RELATION = SPECIALIZABLE_TERM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE__FUNCTIONAL = SPECIALIZABLE_TERM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Inverse Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE__INVERSE_FUNCTIONAL = SPECIALIZABLE_TERM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Symmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE__SYMMETRIC = SPECIALIZABLE_TERM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Asymmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE__ASYMMETRIC = SPECIALIZABLE_TERM_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Reflexive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE__REFLEXIVE = SPECIALIZABLE_TERM_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Irreflexive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE__IRREFLEXIVE = SPECIALIZABLE_TERM_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Transitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE__TRANSITIVE = SPECIALIZABLE_TERM_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Relation Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE_FEATURE_COUNT = SPECIALIZABLE_TERM_FEATURE_COUNT + 10;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE___GET_ONTOLOGY = SPECIALIZABLE_TERM___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = SPECIALIZABLE_TERM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE___GET_REF = SPECIALIZABLE_TERM___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE___IS_REF = SPECIALIZABLE_TERM___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE___RESOLVE = SPECIALIZABLE_TERM___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE___GET_IRI = SPECIALIZABLE_TERM___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE___GET_ABBREVIATED_IRI = SPECIALIZABLE_TERM___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Relation Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_BASE_OPERATION_COUNT = SPECIALIZABLE_TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.SpecializablePropertyImpl <em>Specializable Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.SpecializablePropertyImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getSpecializableProperty()
	 * @generated
	 */
	int SPECIALIZABLE_PROPERTY = 30;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_PROPERTY__OWNED_ANNOTATIONS = SPECIALIZABLE_TERM__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_PROPERTY__NAME = SPECIALIZABLE_TERM__NAME;

	/**
	 * The feature id for the '<em><b>Owning Vocabulary</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_PROPERTY__OWNING_VOCABULARY = SPECIALIZABLE_TERM__OWNING_VOCABULARY;

	/**
	 * The feature id for the '<em><b>Owned Specializations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_PROPERTY__OWNED_SPECIALIZATIONS = SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS;

	/**
	 * The feature id for the '<em><b>Owned Equivalences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_PROPERTY__OWNED_EQUIVALENCES = SPECIALIZABLE_TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specializable Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_PROPERTY_FEATURE_COUNT = SPECIALIZABLE_TERM_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_PROPERTY___GET_ONTOLOGY = SPECIALIZABLE_TERM___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_PROPERTY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = SPECIALIZABLE_TERM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_PROPERTY___GET_REF = SPECIALIZABLE_TERM___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_PROPERTY___IS_REF = SPECIALIZABLE_TERM___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_PROPERTY___RESOLVE = SPECIALIZABLE_TERM___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_PROPERTY___GET_IRI = SPECIALIZABLE_TERM___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_PROPERTY___GET_ABBREVIATED_IRI = SPECIALIZABLE_TERM___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Specializable Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZABLE_PROPERTY_OPERATION_COUNT = SPECIALIZABLE_TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.ClassifierImpl <em>Classifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.ClassifierImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getClassifier()
	 * @generated
	 */
	int CLASSIFIER = 31;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__OWNED_ANNOTATIONS = TYPE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Vocabulary</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__OWNING_VOCABULARY = TYPE__OWNING_VOCABULARY;

	/**
	 * The feature id for the '<em><b>Owned Specializations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__OWNED_SPECIALIZATIONS = TYPE__OWNED_SPECIALIZATIONS;

	/**
	 * The feature id for the '<em><b>Owned Equivalences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__OWNED_EQUIVALENCES = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Property Restrictions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER___GET_ONTOLOGY = TYPE___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = TYPE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER___GET_REF = TYPE___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER___IS_REF = TYPE___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER___RESOLVE = TYPE___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER___GET_IRI = TYPE___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER___GET_ABBREVIATED_IRI = TYPE___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.ScalarImpl <em>Scalar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.ScalarImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getScalar()
	 * @generated
	 */
	int SCALAR = 32;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR__OWNED_ANNOTATIONS = TYPE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Vocabulary</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR__OWNING_VOCABULARY = TYPE__OWNING_VOCABULARY;

	/**
	 * The feature id for the '<em><b>Owned Specializations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR__OWNED_SPECIALIZATIONS = TYPE__OWNED_SPECIALIZATIONS;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR__REF = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Enumeration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR__OWNED_ENUMERATION = TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Equivalences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR__OWNED_EQUIVALENCES = TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Scalar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_FEATURE_COUNT = TYPE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR___GET_ONTOLOGY = TYPE___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = TYPE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR___GET_REF = TYPE___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR___IS_REF = TYPE___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR___RESOLVE = TYPE___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR___GET_IRI = TYPE___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR___GET_ABBREVIATED_IRI = TYPE___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Scalar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.EntityImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 33;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__OWNED_ANNOTATIONS = CLASSIFIER__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Owning Vocabulary</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__OWNING_VOCABULARY = CLASSIFIER__OWNING_VOCABULARY;

	/**
	 * The feature id for the '<em><b>Owned Specializations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__OWNED_SPECIALIZATIONS = CLASSIFIER__OWNED_SPECIALIZATIONS;

	/**
	 * The feature id for the '<em><b>Owned Equivalences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__OWNED_EQUIVALENCES = CLASSIFIER__OWNED_EQUIVALENCES;

	/**
	 * The feature id for the '<em><b>Owned Property Restrictions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__OWNED_PROPERTY_RESTRICTIONS = CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS;

	/**
	 * The feature id for the '<em><b>Owned Keys</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__OWNED_KEYS = CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY___GET_ONTOLOGY = CLASSIFIER___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = CLASSIFIER___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY___GET_REF = CLASSIFIER___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY___IS_REF = CLASSIFIER___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY___RESOLVE = CLASSIFIER___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY___GET_IRI = CLASSIFIER___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY___GET_ABBREVIATED_IRI = CLASSIFIER___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_OPERATION_COUNT = CLASSIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.StructureImpl <em>Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.StructureImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getStructure()
	 * @generated
	 */
	int STRUCTURE = 34;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__OWNED_ANNOTATIONS = CLASSIFIER__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__NAME = CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Owning Vocabulary</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__OWNING_VOCABULARY = CLASSIFIER__OWNING_VOCABULARY;

	/**
	 * The feature id for the '<em><b>Owned Specializations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__OWNED_SPECIALIZATIONS = CLASSIFIER__OWNED_SPECIALIZATIONS;

	/**
	 * The feature id for the '<em><b>Owned Equivalences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__OWNED_EQUIVALENCES = CLASSIFIER__OWNED_EQUIVALENCES;

	/**
	 * The feature id for the '<em><b>Owned Property Restrictions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__OWNED_PROPERTY_RESTRICTIONS = CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__REF = CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_FEATURE_COUNT = CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___GET_ONTOLOGY = CLASSIFIER___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = CLASSIFIER___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___GET_REF = CLASSIFIER___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___IS_REF = CLASSIFIER___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___RESOLVE = CLASSIFIER___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___GET_IRI = CLASSIFIER___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___GET_ABBREVIATED_IRI = CLASSIFIER___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_OPERATION_COUNT = CLASSIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.AspectImpl <em>Aspect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.AspectImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getAspect()
	 * @generated
	 */
	int ASPECT = 35;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__OWNED_ANNOTATIONS = ENTITY__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Owning Vocabulary</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__OWNING_VOCABULARY = ENTITY__OWNING_VOCABULARY;

	/**
	 * The feature id for the '<em><b>Owned Specializations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__OWNED_SPECIALIZATIONS = ENTITY__OWNED_SPECIALIZATIONS;

	/**
	 * The feature id for the '<em><b>Owned Equivalences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__OWNED_EQUIVALENCES = ENTITY__OWNED_EQUIVALENCES;

	/**
	 * The feature id for the '<em><b>Owned Property Restrictions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__OWNED_PROPERTY_RESTRICTIONS = ENTITY__OWNED_PROPERTY_RESTRICTIONS;

	/**
	 * The feature id for the '<em><b>Owned Keys</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__OWNED_KEYS = ENTITY__OWNED_KEYS;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__REF = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Aspect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT___GET_ONTOLOGY = ENTITY___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = ENTITY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT___GET_REF = ENTITY___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT___IS_REF = ENTITY___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT___RESOLVE = ENTITY___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT___GET_IRI = ENTITY___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT___GET_ABBREVIATED_IRI = ENTITY___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Aspect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_OPERATION_COUNT = ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.ConceptImpl <em>Concept</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.ConceptImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getConcept()
	 * @generated
	 */
	int CONCEPT = 36;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT__OWNED_ANNOTATIONS = ENTITY__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Owning Vocabulary</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT__OWNING_VOCABULARY = ENTITY__OWNING_VOCABULARY;

	/**
	 * The feature id for the '<em><b>Owned Specializations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT__OWNED_SPECIALIZATIONS = ENTITY__OWNED_SPECIALIZATIONS;

	/**
	 * The feature id for the '<em><b>Owned Equivalences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT__OWNED_EQUIVALENCES = ENTITY__OWNED_EQUIVALENCES;

	/**
	 * The feature id for the '<em><b>Owned Property Restrictions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT__OWNED_PROPERTY_RESTRICTIONS = ENTITY__OWNED_PROPERTY_RESTRICTIONS;

	/**
	 * The feature id for the '<em><b>Owned Keys</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT__OWNED_KEYS = ENTITY__OWNED_KEYS;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT__REF = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Enumeration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT__OWNED_ENUMERATION = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Concept</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT___GET_ONTOLOGY = ENTITY___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = ENTITY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT___GET_REF = ENTITY___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT___IS_REF = ENTITY___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT___RESOLVE = ENTITY___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT___GET_IRI = ENTITY___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT___GET_ABBREVIATED_IRI = ENTITY___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Concept</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_OPERATION_COUNT = ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.RelationEntityImpl <em>Relation Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.RelationEntityImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getRelationEntity()
	 * @generated
	 */
	int RELATION_ENTITY = 37;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY__OWNED_ANNOTATIONS = ENTITY__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Owning Vocabulary</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY__OWNING_VOCABULARY = ENTITY__OWNING_VOCABULARY;

	/**
	 * The feature id for the '<em><b>Owned Specializations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY__OWNED_SPECIALIZATIONS = ENTITY__OWNED_SPECIALIZATIONS;

	/**
	 * The feature id for the '<em><b>Owned Equivalences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY__OWNED_EQUIVALENCES = ENTITY__OWNED_EQUIVALENCES;

	/**
	 * The feature id for the '<em><b>Owned Property Restrictions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY__OWNED_PROPERTY_RESTRICTIONS = ENTITY__OWNED_PROPERTY_RESTRICTIONS;

	/**
	 * The feature id for the '<em><b>Owned Keys</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY__OWNED_KEYS = ENTITY__OWNED_KEYS;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY__SOURCES = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY__TARGETS = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reverse Relation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY__REVERSE_RELATION = ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY__FUNCTIONAL = ENTITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Inverse Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY__INVERSE_FUNCTIONAL = ENTITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Symmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY__SYMMETRIC = ENTITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Asymmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY__ASYMMETRIC = ENTITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Reflexive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY__REFLEXIVE = ENTITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Irreflexive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY__IRREFLEXIVE = ENTITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Transitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY__TRANSITIVE = ENTITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY__REF = ENTITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Forward Relation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY__FORWARD_RELATION = ENTITY_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Relation Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 12;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY___GET_ONTOLOGY = ENTITY___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = ENTITY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY___GET_REF = ENTITY___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY___IS_REF = ENTITY___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY___RESOLVE = ENTITY___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY___GET_IRI = ENTITY___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY___GET_ABBREVIATED_IRI = ENTITY___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Relation Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY_OPERATION_COUNT = ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.AnnotationPropertyImpl <em>Annotation Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.AnnotationPropertyImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getAnnotationProperty()
	 * @generated
	 */
	int ANNOTATION_PROPERTY = 38;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY__OWNED_ANNOTATIONS = SPECIALIZABLE_PROPERTY__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY__NAME = SPECIALIZABLE_PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Owning Vocabulary</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY__OWNING_VOCABULARY = SPECIALIZABLE_PROPERTY__OWNING_VOCABULARY;

	/**
	 * The feature id for the '<em><b>Owned Specializations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY__OWNED_SPECIALIZATIONS = SPECIALIZABLE_PROPERTY__OWNED_SPECIALIZATIONS;

	/**
	 * The feature id for the '<em><b>Owned Equivalences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY__OWNED_EQUIVALENCES = SPECIALIZABLE_PROPERTY__OWNED_EQUIVALENCES;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY__REF = SPECIALIZABLE_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Annotation Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY_FEATURE_COUNT = SPECIALIZABLE_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY___GET_ONTOLOGY = SPECIALIZABLE_PROPERTY___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = SPECIALIZABLE_PROPERTY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY___GET_REF = SPECIALIZABLE_PROPERTY___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY___IS_REF = SPECIALIZABLE_PROPERTY___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY___RESOLVE = SPECIALIZABLE_PROPERTY___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY___GET_IRI = SPECIALIZABLE_PROPERTY___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY___GET_ABBREVIATED_IRI = SPECIALIZABLE_PROPERTY___GET_ABBREVIATED_IRI;

	/**
	 * The number of operations of the '<em>Annotation Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY_OPERATION_COUNT = SPECIALIZABLE_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.SemanticPropertyImpl <em>Semantic Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.SemanticPropertyImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getSemanticProperty()
	 * @generated
	 */
	int SEMANTIC_PROPERTY = 39;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_PROPERTY__OWNED_ANNOTATIONS = PROPERTY__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_PROPERTY__NAME = PROPERTY__NAME;

	/**
	 * The number of structural features of the '<em>Semantic Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_PROPERTY___GET_ONTOLOGY = PROPERTY___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_PROPERTY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = PROPERTY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_PROPERTY___GET_REF = PROPERTY___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_PROPERTY___IS_REF = PROPERTY___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_PROPERTY___RESOLVE = PROPERTY___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_PROPERTY___GET_IRI = PROPERTY___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_PROPERTY___GET_ABBREVIATED_IRI = PROPERTY___GET_ABBREVIATED_IRI;

	/**
	 * The operation id for the '<em>Is Functional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_PROPERTY___IS_FUNCTIONAL = PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Domain List</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_PROPERTY___GET_DOMAIN_LIST = PROPERTY_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Range List</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_PROPERTY___GET_RANGE_LIST = PROPERTY_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Semantic Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_PROPERTY_OPERATION_COUNT = PROPERTY_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.ScalarPropertyImpl <em>Scalar Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.ScalarPropertyImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getScalarProperty()
	 * @generated
	 */
	int SCALAR_PROPERTY = 40;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY__OWNED_ANNOTATIONS = SEMANTIC_PROPERTY__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY__NAME = SEMANTIC_PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Owning Vocabulary</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY__OWNING_VOCABULARY = SEMANTIC_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Specializations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY__OWNED_SPECIALIZATIONS = SEMANTIC_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Equivalences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY__OWNED_EQUIVALENCES = SEMANTIC_PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY__REF = SEMANTIC_PROPERTY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY__FUNCTIONAL = SEMANTIC_PROPERTY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Domains</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY__DOMAINS = SEMANTIC_PROPERTY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Ranges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY__RANGES = SEMANTIC_PROPERTY_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Scalar Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY_FEATURE_COUNT = SEMANTIC_PROPERTY_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY___GET_ONTOLOGY = SEMANTIC_PROPERTY___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = SEMANTIC_PROPERTY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY___GET_REF = SEMANTIC_PROPERTY___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY___IS_REF = SEMANTIC_PROPERTY___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY___RESOLVE = SEMANTIC_PROPERTY___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY___GET_IRI = SEMANTIC_PROPERTY___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY___GET_ABBREVIATED_IRI = SEMANTIC_PROPERTY___GET_ABBREVIATED_IRI;

	/**
	 * The operation id for the '<em>Is Functional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY___IS_FUNCTIONAL = SEMANTIC_PROPERTY___IS_FUNCTIONAL;

	/**
	 * The operation id for the '<em>Get Domain List</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY___GET_DOMAIN_LIST = SEMANTIC_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Range List</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY___GET_RANGE_LIST = SEMANTIC_PROPERTY_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Scalar Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_PROPERTY_OPERATION_COUNT = SEMANTIC_PROPERTY_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.StructuredPropertyImpl <em>Structured Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.StructuredPropertyImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getStructuredProperty()
	 * @generated
	 */
	int STRUCTURED_PROPERTY = 41;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY__OWNED_ANNOTATIONS = SEMANTIC_PROPERTY__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY__NAME = SEMANTIC_PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Owning Vocabulary</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY__OWNING_VOCABULARY = SEMANTIC_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Specializations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY__OWNED_SPECIALIZATIONS = SEMANTIC_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Equivalences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY__OWNED_EQUIVALENCES = SEMANTIC_PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY__REF = SEMANTIC_PROPERTY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY__FUNCTIONAL = SEMANTIC_PROPERTY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Domains</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY__DOMAINS = SEMANTIC_PROPERTY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Ranges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY__RANGES = SEMANTIC_PROPERTY_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Structured Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY_FEATURE_COUNT = SEMANTIC_PROPERTY_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY___GET_ONTOLOGY = SEMANTIC_PROPERTY___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = SEMANTIC_PROPERTY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY___GET_REF = SEMANTIC_PROPERTY___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY___IS_REF = SEMANTIC_PROPERTY___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY___RESOLVE = SEMANTIC_PROPERTY___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY___GET_IRI = SEMANTIC_PROPERTY___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY___GET_ABBREVIATED_IRI = SEMANTIC_PROPERTY___GET_ABBREVIATED_IRI;

	/**
	 * The operation id for the '<em>Is Functional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY___IS_FUNCTIONAL = SEMANTIC_PROPERTY___IS_FUNCTIONAL;

	/**
	 * The operation id for the '<em>Get Domain List</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY___GET_DOMAIN_LIST = SEMANTIC_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Range List</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY___GET_RANGE_LIST = SEMANTIC_PROPERTY_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Structured Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY_OPERATION_COUNT = SEMANTIC_PROPERTY_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.RelationImpl <em>Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.RelationImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getRelation()
	 * @generated
	 */
	int RELATION = 42;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__OWNED_ANNOTATIONS = SEMANTIC_PROPERTY__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__NAME = SEMANTIC_PROPERTY__NAME;

	/**
	 * The number of structural features of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_FEATURE_COUNT = SEMANTIC_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___GET_ONTOLOGY = SEMANTIC_PROPERTY___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = SEMANTIC_PROPERTY___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___GET_REF = SEMANTIC_PROPERTY___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___IS_REF = SEMANTIC_PROPERTY___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___RESOLVE = SEMANTIC_PROPERTY___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___GET_IRI = SEMANTIC_PROPERTY___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___GET_ABBREVIATED_IRI = SEMANTIC_PROPERTY___GET_ABBREVIATED_IRI;

	/**
	 * The operation id for the '<em>Is Functional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___IS_FUNCTIONAL = SEMANTIC_PROPERTY___IS_FUNCTIONAL;

	/**
	 * The operation id for the '<em>Is Inverse Functional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___IS_INVERSE_FUNCTIONAL = SEMANTIC_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Symmetric</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___IS_SYMMETRIC = SEMANTIC_PROPERTY_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Asymmetric</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___IS_ASYMMETRIC = SEMANTIC_PROPERTY_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Reflexive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___IS_REFLEXIVE = SEMANTIC_PROPERTY_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Irreflexive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___IS_IRREFLEXIVE = SEMANTIC_PROPERTY_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Transitive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___IS_TRANSITIVE = SEMANTIC_PROPERTY_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Domains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___GET_DOMAINS = SEMANTIC_PROPERTY_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Get Ranges</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___GET_RANGES = SEMANTIC_PROPERTY_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Inverse</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___GET_INVERSE = SEMANTIC_PROPERTY_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Get Domain List</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___GET_DOMAIN_LIST = SEMANTIC_PROPERTY_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Get Range List</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___GET_RANGE_LIST = SEMANTIC_PROPERTY_OPERATION_COUNT + 10;

	/**
	 * The number of operations of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_OPERATION_COUNT = SEMANTIC_PROPERTY_OPERATION_COUNT + 11;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.ForwardRelationImpl <em>Forward Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.ForwardRelationImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getForwardRelation()
	 * @generated
	 */
	int FORWARD_RELATION = 43;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION__OWNED_ANNOTATIONS = RELATION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION__NAME = RELATION__NAME;

	/**
	 * The feature id for the '<em><b>Relation Entity</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION__RELATION_ENTITY = RELATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Forward Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION_FEATURE_COUNT = RELATION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION___GET_ONTOLOGY = RELATION___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = RELATION___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION___IS_REF = RELATION___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION___RESOLVE = RELATION___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION___GET_IRI = RELATION___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION___GET_ABBREVIATED_IRI = RELATION___GET_ABBREVIATED_IRI;

	/**
	 * The operation id for the '<em>Get Domain List</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION___GET_DOMAIN_LIST = RELATION___GET_DOMAIN_LIST;

	/**
	 * The operation id for the '<em>Get Range List</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION___GET_RANGE_LIST = RELATION___GET_RANGE_LIST;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION___GET_REF = RELATION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Functional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION___IS_FUNCTIONAL = RELATION_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Inverse Functional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION___IS_INVERSE_FUNCTIONAL = RELATION_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Symmetric</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION___IS_SYMMETRIC = RELATION_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Asymmetric</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION___IS_ASYMMETRIC = RELATION_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Reflexive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION___IS_REFLEXIVE = RELATION_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Irreflexive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION___IS_IRREFLEXIVE = RELATION_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Transitive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION___IS_TRANSITIVE = RELATION_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Domains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION___GET_DOMAINS = RELATION_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Get Ranges</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION___GET_RANGES = RELATION_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Get Inverse</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION___GET_INVERSE = RELATION_OPERATION_COUNT + 10;

	/**
	 * The number of operations of the '<em>Forward Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_RELATION_OPERATION_COUNT = RELATION_OPERATION_COUNT + 11;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.ReverseRelationImpl <em>Reverse Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.ReverseRelationImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getReverseRelation()
	 * @generated
	 */
	int REVERSE_RELATION = 44;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION__OWNED_ANNOTATIONS = RELATION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION__NAME = RELATION__NAME;

	/**
	 * The feature id for the '<em><b>Relation Base</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION__RELATION_BASE = RELATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reverse Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION_FEATURE_COUNT = RELATION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION___GET_ONTOLOGY = RELATION___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = RELATION___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION___IS_REF = RELATION___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION___RESOLVE = RELATION___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION___GET_IRI = RELATION___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION___GET_ABBREVIATED_IRI = RELATION___GET_ABBREVIATED_IRI;

	/**
	 * The operation id for the '<em>Get Domain List</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION___GET_DOMAIN_LIST = RELATION___GET_DOMAIN_LIST;

	/**
	 * The operation id for the '<em>Get Range List</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION___GET_RANGE_LIST = RELATION___GET_RANGE_LIST;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION___GET_REF = RELATION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Functional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION___IS_FUNCTIONAL = RELATION_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Inverse Functional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION___IS_INVERSE_FUNCTIONAL = RELATION_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Symmetric</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION___IS_SYMMETRIC = RELATION_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Asymmetric</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION___IS_ASYMMETRIC = RELATION_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Reflexive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION___IS_REFLEXIVE = RELATION_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Irreflexive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION___IS_IRREFLEXIVE = RELATION_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Transitive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION___IS_TRANSITIVE = RELATION_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Domains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION___GET_DOMAINS = RELATION_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Get Ranges</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION___GET_RANGES = RELATION_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Get Inverse</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION___GET_INVERSE = RELATION_OPERATION_COUNT + 10;

	/**
	 * The number of operations of the '<em>Reverse Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVERSE_RELATION_OPERATION_COUNT = RELATION_OPERATION_COUNT + 11;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.UnreifiedRelationImpl <em>Unreified Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.UnreifiedRelationImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getUnreifiedRelation()
	 * @generated
	 */
	int UNREIFIED_RELATION = 45;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION__OWNED_ANNOTATIONS = RELATION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION__NAME = RELATION__NAME;

	/**
	 * The feature id for the '<em><b>Owning Vocabulary</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION__OWNING_VOCABULARY = RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Specializations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION__OWNED_SPECIALIZATIONS = RELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION__SOURCES = RELATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION__TARGETS = RELATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Reverse Relation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION__REVERSE_RELATION = RELATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION__FUNCTIONAL = RELATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Inverse Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION__INVERSE_FUNCTIONAL = RELATION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Symmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION__SYMMETRIC = RELATION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Asymmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION__ASYMMETRIC = RELATION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Reflexive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION__REFLEXIVE = RELATION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Irreflexive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION__IRREFLEXIVE = RELATION_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Transitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION__TRANSITIVE = RELATION_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Owned Equivalences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION__OWNED_EQUIVALENCES = RELATION_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION__REF = RELATION_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Unreified Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION_FEATURE_COUNT = RELATION_FEATURE_COUNT + 14;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION___GET_ONTOLOGY = RELATION___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = RELATION___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION___GET_REF = RELATION___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION___IS_REF = RELATION___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION___RESOLVE = RELATION___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION___GET_IRI = RELATION___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION___GET_ABBREVIATED_IRI = RELATION___GET_ABBREVIATED_IRI;

	/**
	 * The operation id for the '<em>Is Functional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION___IS_FUNCTIONAL = RELATION___IS_FUNCTIONAL;

	/**
	 * The operation id for the '<em>Is Inverse Functional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION___IS_INVERSE_FUNCTIONAL = RELATION___IS_INVERSE_FUNCTIONAL;

	/**
	 * The operation id for the '<em>Is Symmetric</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION___IS_SYMMETRIC = RELATION___IS_SYMMETRIC;

	/**
	 * The operation id for the '<em>Is Asymmetric</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION___IS_ASYMMETRIC = RELATION___IS_ASYMMETRIC;

	/**
	 * The operation id for the '<em>Is Reflexive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION___IS_REFLEXIVE = RELATION___IS_REFLEXIVE;

	/**
	 * The operation id for the '<em>Is Irreflexive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION___IS_IRREFLEXIVE = RELATION___IS_IRREFLEXIVE;

	/**
	 * The operation id for the '<em>Is Transitive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION___IS_TRANSITIVE = RELATION___IS_TRANSITIVE;

	/**
	 * The operation id for the '<em>Get Domain List</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION___GET_DOMAIN_LIST = RELATION___GET_DOMAIN_LIST;

	/**
	 * The operation id for the '<em>Get Range List</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION___GET_RANGE_LIST = RELATION___GET_RANGE_LIST;

	/**
	 * The operation id for the '<em>Get Domains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION___GET_DOMAINS = RELATION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Ranges</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION___GET_RANGES = RELATION_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Inverse</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION___GET_INVERSE = RELATION_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Unreified Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATION_OPERATION_COUNT = RELATION_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.NamedInstanceImpl <em>Named Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.NamedInstanceImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getNamedInstance()
	 * @generated
	 */
	int NAMED_INSTANCE = 46;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_INSTANCE__OWNED_ANNOTATIONS = DESCRIPTION_STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_INSTANCE__NAME = DESCRIPTION_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owning Description</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_INSTANCE__OWNING_DESCRIPTION = DESCRIPTION_STATEMENT__OWNING_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_INSTANCE__OWNED_PROPERTY_VALUES = DESCRIPTION_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_INSTANCE__OWNED_TYPES = DESCRIPTION_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Named Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_INSTANCE_FEATURE_COUNT = DESCRIPTION_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_INSTANCE___GET_ONTOLOGY = DESCRIPTION_STATEMENT___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_INSTANCE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = DESCRIPTION_STATEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_INSTANCE___GET_REF = DESCRIPTION_STATEMENT___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_INSTANCE___IS_REF = DESCRIPTION_STATEMENT___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_INSTANCE___RESOLVE = DESCRIPTION_STATEMENT___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_INSTANCE___GET_IRI = DESCRIPTION_STATEMENT___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_INSTANCE___GET_ABBREVIATED_IRI = DESCRIPTION_STATEMENT___GET_ABBREVIATED_IRI;

	/**
	 * The operation id for the '<em>Get Entity Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_INSTANCE___GET_ENTITY_TYPES = DESCRIPTION_STATEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_INSTANCE___GET_TYPES = DESCRIPTION_STATEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Named Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_INSTANCE_OPERATION_COUNT = DESCRIPTION_STATEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.AnonymousInstanceImpl <em>Anonymous Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.AnonymousInstanceImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getAnonymousInstance()
	 * @generated
	 */
	int ANONYMOUS_INSTANCE = 47;

	/**
	 * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_INSTANCE__OWNED_PROPERTY_VALUES = INSTANCE__OWNED_PROPERTY_VALUES;

	/**
	 * The feature id for the '<em><b>Owning Assertion</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_INSTANCE__OWNING_ASSERTION = INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Axiom</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_INSTANCE__OWNING_AXIOM = INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Anonymous Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_INSTANCE_FEATURE_COUNT = INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_INSTANCE___GET_ONTOLOGY = INSTANCE___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_INSTANCE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = INSTANCE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_INSTANCE___GET_TYPE = INSTANCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_INSTANCE___GET_TYPES = INSTANCE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Anonymous Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_INSTANCE_OPERATION_COUNT = INSTANCE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.ConceptInstanceImpl <em>Concept Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.ConceptInstanceImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getConceptInstance()
	 * @generated
	 */
	int CONCEPT_INSTANCE = 48;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE__OWNED_ANNOTATIONS = NAMED_INSTANCE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE__NAME = NAMED_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Description</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE__OWNING_DESCRIPTION = NAMED_INSTANCE__OWNING_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE__OWNED_PROPERTY_VALUES = NAMED_INSTANCE__OWNED_PROPERTY_VALUES;

	/**
	 * The feature id for the '<em><b>Owned Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE__OWNED_TYPES = NAMED_INSTANCE__OWNED_TYPES;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE__REF = NAMED_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Concept Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE_FEATURE_COUNT = NAMED_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE___GET_ONTOLOGY = NAMED_INSTANCE___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = NAMED_INSTANCE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE___GET_REF = NAMED_INSTANCE___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE___IS_REF = NAMED_INSTANCE___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE___RESOLVE = NAMED_INSTANCE___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE___GET_IRI = NAMED_INSTANCE___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE___GET_ABBREVIATED_IRI = NAMED_INSTANCE___GET_ABBREVIATED_IRI;

	/**
	 * The operation id for the '<em>Get Entity Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE___GET_ENTITY_TYPES = NAMED_INSTANCE___GET_ENTITY_TYPES;

	/**
	 * The operation id for the '<em>Get Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE___GET_TYPES = NAMED_INSTANCE___GET_TYPES;

	/**
	 * The number of operations of the '<em>Concept Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE_OPERATION_COUNT = NAMED_INSTANCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.RelationInstanceImpl <em>Relation Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.RelationInstanceImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getRelationInstance()
	 * @generated
	 */
	int RELATION_INSTANCE = 49;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_INSTANCE__OWNED_ANNOTATIONS = NAMED_INSTANCE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_INSTANCE__NAME = NAMED_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Description</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_INSTANCE__OWNING_DESCRIPTION = NAMED_INSTANCE__OWNING_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_INSTANCE__OWNED_PROPERTY_VALUES = NAMED_INSTANCE__OWNED_PROPERTY_VALUES;

	/**
	 * The feature id for the '<em><b>Owned Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_INSTANCE__OWNED_TYPES = NAMED_INSTANCE__OWNED_TYPES;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_INSTANCE__REF = NAMED_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_INSTANCE__SOURCES = NAMED_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_INSTANCE__TARGETS = NAMED_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Relation Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_INSTANCE_FEATURE_COUNT = NAMED_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_INSTANCE___GET_ONTOLOGY = NAMED_INSTANCE___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_INSTANCE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = NAMED_INSTANCE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_INSTANCE___GET_REF = NAMED_INSTANCE___GET_REF;

	/**
	 * The operation id for the '<em>Is Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_INSTANCE___IS_REF = NAMED_INSTANCE___IS_REF;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_INSTANCE___RESOLVE = NAMED_INSTANCE___RESOLVE;

	/**
	 * The operation id for the '<em>Get Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_INSTANCE___GET_IRI = NAMED_INSTANCE___GET_IRI;

	/**
	 * The operation id for the '<em>Get Abbreviated Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_INSTANCE___GET_ABBREVIATED_IRI = NAMED_INSTANCE___GET_ABBREVIATED_IRI;

	/**
	 * The operation id for the '<em>Get Entity Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_INSTANCE___GET_ENTITY_TYPES = NAMED_INSTANCE___GET_ENTITY_TYPES;

	/**
	 * The operation id for the '<em>Get Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_INSTANCE___GET_TYPES = NAMED_INSTANCE___GET_TYPES;

	/**
	 * The number of operations of the '<em>Relation Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_INSTANCE_OPERATION_COUNT = NAMED_INSTANCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.StructureInstanceImpl <em>Structure Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.StructureInstanceImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getStructureInstance()
	 * @generated
	 */
	int STRUCTURE_INSTANCE = 50;

	/**
	 * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE__OWNED_PROPERTY_VALUES = ANONYMOUS_INSTANCE__OWNED_PROPERTY_VALUES;

	/**
	 * The feature id for the '<em><b>Owning Assertion</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE__OWNING_ASSERTION = ANONYMOUS_INSTANCE__OWNING_ASSERTION;

	/**
	 * The feature id for the '<em><b>Owning Axiom</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE__OWNING_AXIOM = ANONYMOUS_INSTANCE__OWNING_AXIOM;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE__TYPE = ANONYMOUS_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Structure Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE_FEATURE_COUNT = ANONYMOUS_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE___GET_ONTOLOGY = ANONYMOUS_INSTANCE___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = ANONYMOUS_INSTANCE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE___GET_TYPE = ANONYMOUS_INSTANCE___GET_TYPE;

	/**
	 * The operation id for the '<em>Get Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE___GET_TYPES = ANONYMOUS_INSTANCE___GET_TYPES;

	/**
	 * The number of operations of the '<em>Structure Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE_OPERATION_COUNT = ANONYMOUS_INSTANCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.KeyAxiomImpl <em>Key Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.KeyAxiomImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getKeyAxiom()
	 * @generated
	 */
	int KEY_AXIOM = 51;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_AXIOM__PROPERTIES = AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Entity</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_AXIOM__OWNING_ENTITY = AXIOM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Key Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_AXIOM_FEATURE_COUNT = AXIOM_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_AXIOM___GET_ONTOLOGY = AXIOM___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Keyed Entity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_AXIOM___GET_KEYED_ENTITY = AXIOM_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Characterized Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_AXIOM___GET_CHARACTERIZED_TERM = AXIOM_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Key Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_AXIOM_OPERATION_COUNT = AXIOM_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.SpecializationAxiomImpl <em>Specialization Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.SpecializationAxiomImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getSpecializationAxiom()
	 * @generated
	 */
	int SPECIALIZATION_AXIOM = 52;

	/**
	 * The feature id for the '<em><b>Super Term</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_AXIOM__SUPER_TERM = AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Term</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_AXIOM__OWNING_TERM = AXIOM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Specialization Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_AXIOM_FEATURE_COUNT = AXIOM_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_AXIOM___GET_ONTOLOGY = AXIOM___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Sub Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_AXIOM___GET_SUB_TERM = AXIOM_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Characterized Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_AXIOM___GET_CHARACTERIZED_TERM = AXIOM_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Specialization Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_AXIOM_OPERATION_COUNT = AXIOM_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.InstanceEnumerationAxiomImpl <em>Instance Enumeration Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.InstanceEnumerationAxiomImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getInstanceEnumerationAxiom()
	 * @generated
	 */
	int INSTANCE_ENUMERATION_AXIOM = 53;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_ENUMERATION_AXIOM__INSTANCES = AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Concept</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_ENUMERATION_AXIOM__OWNING_CONCEPT = AXIOM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Instance Enumeration Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_ENUMERATION_AXIOM_FEATURE_COUNT = AXIOM_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_ENUMERATION_AXIOM___GET_ONTOLOGY = AXIOM___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_ENUMERATION_AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Enumerated Concept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_ENUMERATION_AXIOM___GET_ENUMERATED_CONCEPT = AXIOM_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Characterized Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_ENUMERATION_AXIOM___GET_CHARACTERIZED_TERM = AXIOM_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Instance Enumeration Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_ENUMERATION_AXIOM_OPERATION_COUNT = AXIOM_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.PropertyRestrictionAxiomImpl <em>Property Restriction Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.PropertyRestrictionAxiomImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getPropertyRestrictionAxiom()
	 * @generated
	 */
	int PROPERTY_RESTRICTION_AXIOM = 54;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RESTRICTION_AXIOM__PROPERTY = AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Classifier</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER = AXIOM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owning Axiom</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM = AXIOM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Property Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT = AXIOM_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RESTRICTION_AXIOM___GET_ONTOLOGY = AXIOM___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RESTRICTION_AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Restricting Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RESTRICTION_AXIOM___GET_RESTRICTING_DOMAIN = AXIOM_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Characterized Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RESTRICTION_AXIOM___GET_CHARACTERIZED_TERM = AXIOM_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Property Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RESTRICTION_AXIOM_OPERATION_COUNT = AXIOM_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.LiteralEnumerationAxiomImpl <em>Literal Enumeration Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.LiteralEnumerationAxiomImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getLiteralEnumerationAxiom()
	 * @generated
	 */
	int LITERAL_ENUMERATION_AXIOM = 55;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ENUMERATION_AXIOM__LITERALS = AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Scalar</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ENUMERATION_AXIOM__OWNING_SCALAR = AXIOM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Literal Enumeration Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ENUMERATION_AXIOM_FEATURE_COUNT = AXIOM_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ENUMERATION_AXIOM___GET_ONTOLOGY = AXIOM___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ENUMERATION_AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Enumerated Scalar</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ENUMERATION_AXIOM___GET_ENUMERATED_SCALAR = AXIOM_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Characterized Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ENUMERATION_AXIOM___GET_CHARACTERIZED_TERM = AXIOM_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Enumeration Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_ENUMERATION_AXIOM_OPERATION_COUNT = AXIOM_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.ClassifierEquivalenceAxiomImpl <em>Classifier Equivalence Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.ClassifierEquivalenceAxiomImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getClassifierEquivalenceAxiom()
	 * @generated
	 */
	int CLASSIFIER_EQUIVALENCE_AXIOM = 56;

	/**
	 * The feature id for the '<em><b>Super Classifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_EQUIVALENCE_AXIOM__SUPER_CLASSIFIERS = AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Property Restrictions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS = AXIOM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owning Classifier</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_EQUIVALENCE_AXIOM__OWNING_CLASSIFIER = AXIOM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Classifier Equivalence Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_EQUIVALENCE_AXIOM_FEATURE_COUNT = AXIOM_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_EQUIVALENCE_AXIOM___GET_ONTOLOGY = AXIOM___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_EQUIVALENCE_AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Sub Classifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_EQUIVALENCE_AXIOM___GET_SUB_CLASSIFIER = AXIOM_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Characterized Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_EQUIVALENCE_AXIOM___GET_CHARACTERIZED_TERM = AXIOM_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Classifier Equivalence Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_EQUIVALENCE_AXIOM_OPERATION_COUNT = AXIOM_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.ScalarEquivalenceAxiomImpl <em>Scalar Equivalence Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.ScalarEquivalenceAxiomImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getScalarEquivalenceAxiom()
	 * @generated
	 */
	int SCALAR_EQUIVALENCE_AXIOM = 57;

	/**
	 * The feature id for the '<em><b>Super Scalar</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_EQUIVALENCE_AXIOM__SUPER_SCALAR = AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Scalar</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_EQUIVALENCE_AXIOM__OWNING_SCALAR = AXIOM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_EQUIVALENCE_AXIOM__LENGTH = AXIOM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_EQUIVALENCE_AXIOM__MIN_LENGTH = AXIOM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_EQUIVALENCE_AXIOM__MAX_LENGTH = AXIOM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_EQUIVALENCE_AXIOM__PATTERN = AXIOM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_EQUIVALENCE_AXIOM__LANGUAGE = AXIOM_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Min Inclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_EQUIVALENCE_AXIOM__MIN_INCLUSIVE = AXIOM_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Min Exclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_EQUIVALENCE_AXIOM__MIN_EXCLUSIVE = AXIOM_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Max Inclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_EQUIVALENCE_AXIOM__MAX_INCLUSIVE = AXIOM_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Max Exclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_EQUIVALENCE_AXIOM__MAX_EXCLUSIVE = AXIOM_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Scalar Equivalence Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_EQUIVALENCE_AXIOM_FEATURE_COUNT = AXIOM_FEATURE_COUNT + 11;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_EQUIVALENCE_AXIOM___GET_ONTOLOGY = AXIOM___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_EQUIVALENCE_AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Sub Scalar</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_EQUIVALENCE_AXIOM___GET_SUB_SCALAR = AXIOM_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Characterized Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_EQUIVALENCE_AXIOM___GET_CHARACTERIZED_TERM = AXIOM_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Scalar Equivalence Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_EQUIVALENCE_AXIOM_OPERATION_COUNT = AXIOM_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.PropertyEquivalenceAxiomImpl <em>Property Equivalence Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.PropertyEquivalenceAxiomImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getPropertyEquivalenceAxiom()
	 * @generated
	 */
	int PROPERTY_EQUIVALENCE_AXIOM = 58;

	/**
	 * The feature id for the '<em><b>Super Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EQUIVALENCE_AXIOM__SUPER_PROPERTY = AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EQUIVALENCE_AXIOM__OWNING_PROPERTY = AXIOM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property Equivalence Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EQUIVALENCE_AXIOM_FEATURE_COUNT = AXIOM_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EQUIVALENCE_AXIOM___GET_ONTOLOGY = AXIOM___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EQUIVALENCE_AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Sub Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EQUIVALENCE_AXIOM___GET_SUB_PROPERTY = AXIOM_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Characterized Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EQUIVALENCE_AXIOM___GET_CHARACTERIZED_TERM = AXIOM_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Property Equivalence Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EQUIVALENCE_AXIOM_OPERATION_COUNT = AXIOM_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.PropertyRangeRestrictionAxiomImpl <em>Property Range Restriction Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.PropertyRangeRestrictionAxiomImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getPropertyRangeRestrictionAxiom()
	 * @generated
	 */
	int PROPERTY_RANGE_RESTRICTION_AXIOM = 59;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RANGE_RESTRICTION_AXIOM__PROPERTY = PROPERTY_RESTRICTION_AXIOM__PROPERTY;

	/**
	 * The feature id for the '<em><b>Owning Classifier</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RANGE_RESTRICTION_AXIOM__OWNING_CLASSIFIER = PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Owning Axiom</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RANGE_RESTRICTION_AXIOM__OWNING_AXIOM = PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RANGE_RESTRICTION_AXIOM__KIND = PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE = PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property Range Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RANGE_RESTRICTION_AXIOM_FEATURE_COUNT = PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RANGE_RESTRICTION_AXIOM___GET_ONTOLOGY = PROPERTY_RESTRICTION_AXIOM___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RANGE_RESTRICTION_AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = PROPERTY_RESTRICTION_AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Restricting Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RANGE_RESTRICTION_AXIOM___GET_RESTRICTING_DOMAIN = PROPERTY_RESTRICTION_AXIOM___GET_RESTRICTING_DOMAIN;

	/**
	 * The operation id for the '<em>Get Characterized Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RANGE_RESTRICTION_AXIOM___GET_CHARACTERIZED_TERM = PROPERTY_RESTRICTION_AXIOM___GET_CHARACTERIZED_TERM;

	/**
	 * The number of operations of the '<em>Property Range Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_RANGE_RESTRICTION_AXIOM_OPERATION_COUNT = PROPERTY_RESTRICTION_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.PropertyCardinalityRestrictionAxiomImpl <em>Property Cardinality Restriction Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.PropertyCardinalityRestrictionAxiomImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getPropertyCardinalityRestrictionAxiom()
	 * @generated
	 */
	int PROPERTY_CARDINALITY_RESTRICTION_AXIOM = 60;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CARDINALITY_RESTRICTION_AXIOM__PROPERTY = PROPERTY_RESTRICTION_AXIOM__PROPERTY;

	/**
	 * The feature id for the '<em><b>Owning Classifier</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CARDINALITY_RESTRICTION_AXIOM__OWNING_CLASSIFIER = PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Owning Axiom</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CARDINALITY_RESTRICTION_AXIOM__OWNING_AXIOM = PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CARDINALITY_RESTRICTION_AXIOM__KIND = PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CARDINALITY_RESTRICTION_AXIOM__CARDINALITY = PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE = PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Property Cardinality Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CARDINALITY_RESTRICTION_AXIOM_FEATURE_COUNT = PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CARDINALITY_RESTRICTION_AXIOM___GET_ONTOLOGY = PROPERTY_RESTRICTION_AXIOM___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CARDINALITY_RESTRICTION_AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = PROPERTY_RESTRICTION_AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Restricting Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CARDINALITY_RESTRICTION_AXIOM___GET_RESTRICTING_DOMAIN = PROPERTY_RESTRICTION_AXIOM___GET_RESTRICTING_DOMAIN;

	/**
	 * The operation id for the '<em>Get Characterized Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CARDINALITY_RESTRICTION_AXIOM___GET_CHARACTERIZED_TERM = PROPERTY_RESTRICTION_AXIOM___GET_CHARACTERIZED_TERM;

	/**
	 * The number of operations of the '<em>Property Cardinality Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CARDINALITY_RESTRICTION_AXIOM_OPERATION_COUNT = PROPERTY_RESTRICTION_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.PropertyValueRestrictionAxiomImpl <em>Property Value Restriction Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.PropertyValueRestrictionAxiomImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getPropertyValueRestrictionAxiom()
	 * @generated
	 */
	int PROPERTY_VALUE_RESTRICTION_AXIOM = 61;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_RESTRICTION_AXIOM__PROPERTY = PROPERTY_RESTRICTION_AXIOM__PROPERTY;

	/**
	 * The feature id for the '<em><b>Owning Classifier</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_RESTRICTION_AXIOM__OWNING_CLASSIFIER = PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Owning Axiom</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_RESTRICTION_AXIOM__OWNING_AXIOM = PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM;

	/**
	 * The feature id for the '<em><b>Literal Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_RESTRICTION_AXIOM__LITERAL_VALUE = PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contained Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_RESTRICTION_AXIOM__CONTAINED_VALUE = PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referenced Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_RESTRICTION_AXIOM__REFERENCED_VALUE = PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Property Value Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_RESTRICTION_AXIOM_FEATURE_COUNT = PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_RESTRICTION_AXIOM___GET_ONTOLOGY = PROPERTY_RESTRICTION_AXIOM___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_RESTRICTION_AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = PROPERTY_RESTRICTION_AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Restricting Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_RESTRICTION_AXIOM___GET_RESTRICTING_DOMAIN = PROPERTY_RESTRICTION_AXIOM___GET_RESTRICTING_DOMAIN;

	/**
	 * The operation id for the '<em>Get Characterized Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_RESTRICTION_AXIOM___GET_CHARACTERIZED_TERM = PROPERTY_RESTRICTION_AXIOM___GET_CHARACTERIZED_TERM;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_RESTRICTION_AXIOM___GET_VALUE = PROPERTY_RESTRICTION_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Property Value Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_RESTRICTION_AXIOM_OPERATION_COUNT = PROPERTY_RESTRICTION_AXIOM_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.PropertySelfRestrictionAxiomImpl <em>Property Self Restriction Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.PropertySelfRestrictionAxiomImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getPropertySelfRestrictionAxiom()
	 * @generated
	 */
	int PROPERTY_SELF_RESTRICTION_AXIOM = 62;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SELF_RESTRICTION_AXIOM__PROPERTY = PROPERTY_RESTRICTION_AXIOM__PROPERTY;

	/**
	 * The feature id for the '<em><b>Owning Classifier</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SELF_RESTRICTION_AXIOM__OWNING_CLASSIFIER = PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Owning Axiom</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SELF_RESTRICTION_AXIOM__OWNING_AXIOM = PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM;

	/**
	 * The number of structural features of the '<em>Property Self Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SELF_RESTRICTION_AXIOM_FEATURE_COUNT = PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SELF_RESTRICTION_AXIOM___GET_ONTOLOGY = PROPERTY_RESTRICTION_AXIOM___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SELF_RESTRICTION_AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = PROPERTY_RESTRICTION_AXIOM___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Restricting Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SELF_RESTRICTION_AXIOM___GET_RESTRICTING_DOMAIN = PROPERTY_RESTRICTION_AXIOM___GET_RESTRICTING_DOMAIN;

	/**
	 * The operation id for the '<em>Get Characterized Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SELF_RESTRICTION_AXIOM___GET_CHARACTERIZED_TERM = PROPERTY_RESTRICTION_AXIOM___GET_CHARACTERIZED_TERM;

	/**
	 * The number of operations of the '<em>Property Self Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SELF_RESTRICTION_AXIOM_OPERATION_COUNT = PROPERTY_RESTRICTION_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.TypeAssertionImpl <em>Type Assertion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.TypeAssertionImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getTypeAssertion()
	 * @generated
	 */
	int TYPE_ASSERTION = 63;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ASSERTION__TYPE = ASSERTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ASSERTION__OWNING_INSTANCE = ASSERTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Assertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ASSERTION_FEATURE_COUNT = ASSERTION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ASSERTION___GET_ONTOLOGY = ASSERTION___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ASSERTION___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = ASSERTION___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ASSERTION___GET_OBJECT = ASSERTION___GET_OBJECT;

	/**
	 * The operation id for the '<em>Get Subject</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ASSERTION___GET_SUBJECT = ASSERTION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Objects</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ASSERTION___GET_OBJECTS = ASSERTION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Type Assertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ASSERTION_OPERATION_COUNT = ASSERTION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.PropertyValueAssertionImpl <em>Property Value Assertion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.PropertyValueAssertionImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getPropertyValueAssertion()
	 * @generated
	 */
	int PROPERTY_VALUE_ASSERTION = 64;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_ASSERTION__PROPERTY = ASSERTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Literal Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_ASSERTION__LITERAL_VALUE = ASSERTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Contained Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE = ASSERTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Referenced Value</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_ASSERTION__REFERENCED_VALUE = ASSERTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owning Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE = ASSERTION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Property Value Assertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_ASSERTION_FEATURE_COUNT = ASSERTION_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_ASSERTION___GET_ONTOLOGY = ASSERTION___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_ASSERTION___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = ASSERTION___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_ASSERTION___GET_VALUE = ASSERTION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Subject</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_ASSERTION___GET_SUBJECT = ASSERTION_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_ASSERTION___GET_OBJECT = ASSERTION_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Property Value Assertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_ASSERTION_OPERATION_COUNT = ASSERTION_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.UnaryPredicateImpl <em>Unary Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.UnaryPredicateImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getUnaryPredicate()
	 * @generated
	 */
	int UNARY_PREDICATE = 65;

	/**
	 * The feature id for the '<em><b>Antecedent Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_PREDICATE__ANTECEDENT_RULE = PREDICATE__ANTECEDENT_RULE;

	/**
	 * The feature id for the '<em><b>Consequent Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_PREDICATE__CONSEQUENT_RULE = PREDICATE__CONSEQUENT_RULE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_PREDICATE__ARGUMENT = PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unary Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_PREDICATE_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_PREDICATE___GET_ONTOLOGY = PREDICATE___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_PREDICATE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = PREDICATE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Unary Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_PREDICATE_OPERATION_COUNT = PREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.BinaryPredicateImpl <em>Binary Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.BinaryPredicateImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getBinaryPredicate()
	 * @generated
	 */
	int BINARY_PREDICATE = 66;

	/**
	 * The feature id for the '<em><b>Antecedent Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_PREDICATE__ANTECEDENT_RULE = PREDICATE__ANTECEDENT_RULE;

	/**
	 * The feature id for the '<em><b>Consequent Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_PREDICATE__CONSEQUENT_RULE = PREDICATE__CONSEQUENT_RULE;

	/**
	 * The feature id for the '<em><b>Argument1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_PREDICATE__ARGUMENT1 = PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Argument2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_PREDICATE__ARGUMENT2 = PREDICATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_PREDICATE_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_PREDICATE___GET_ONTOLOGY = PREDICATE___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_PREDICATE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = PREDICATE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Binary Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_PREDICATE_OPERATION_COUNT = PREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.BuiltInPredicateImpl <em>Built In Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.BuiltInPredicateImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getBuiltInPredicate()
	 * @generated
	 */
	int BUILT_IN_PREDICATE = 67;

	/**
	 * The feature id for the '<em><b>Antecedent Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_PREDICATE__ANTECEDENT_RULE = PREDICATE__ANTECEDENT_RULE;

	/**
	 * The feature id for the '<em><b>Consequent Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_PREDICATE__CONSEQUENT_RULE = PREDICATE__CONSEQUENT_RULE;

	/**
	 * The feature id for the '<em><b>Built In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_PREDICATE__BUILT_IN = PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_PREDICATE__ARGUMENTS = PREDICATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Built In Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_PREDICATE_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_PREDICATE___GET_ONTOLOGY = PREDICATE___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_PREDICATE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = PREDICATE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Built In Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_PREDICATE_OPERATION_COUNT = PREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.TypePredicateImpl <em>Type Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.TypePredicateImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getTypePredicate()
	 * @generated
	 */
	int TYPE_PREDICATE = 68;

	/**
	 * The feature id for the '<em><b>Antecedent Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PREDICATE__ANTECEDENT_RULE = UNARY_PREDICATE__ANTECEDENT_RULE;

	/**
	 * The feature id for the '<em><b>Consequent Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PREDICATE__CONSEQUENT_RULE = UNARY_PREDICATE__CONSEQUENT_RULE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PREDICATE__ARGUMENT = UNARY_PREDICATE__ARGUMENT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PREDICATE__TYPE = UNARY_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PREDICATE_FEATURE_COUNT = UNARY_PREDICATE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PREDICATE___GET_ONTOLOGY = UNARY_PREDICATE___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PREDICATE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = UNARY_PREDICATE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Type Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PREDICATE_OPERATION_COUNT = UNARY_PREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.RelationEntityPredicateImpl <em>Relation Entity Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.RelationEntityPredicateImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getRelationEntityPredicate()
	 * @generated
	 */
	int RELATION_ENTITY_PREDICATE = 69;

	/**
	 * The feature id for the '<em><b>Antecedent Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY_PREDICATE__ANTECEDENT_RULE = UNARY_PREDICATE__ANTECEDENT_RULE;

	/**
	 * The feature id for the '<em><b>Consequent Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY_PREDICATE__CONSEQUENT_RULE = UNARY_PREDICATE__CONSEQUENT_RULE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY_PREDICATE__ARGUMENT = UNARY_PREDICATE__ARGUMENT;

	/**
	 * The feature id for the '<em><b>Argument1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY_PREDICATE__ARGUMENT1 = UNARY_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Argument2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY_PREDICATE__ARGUMENT2 = UNARY_PREDICATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY_PREDICATE__TYPE = UNARY_PREDICATE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Relation Entity Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY_PREDICATE_FEATURE_COUNT = UNARY_PREDICATE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY_PREDICATE___GET_ONTOLOGY = UNARY_PREDICATE___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY_PREDICATE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = UNARY_PREDICATE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Relation Entity Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ENTITY_PREDICATE_OPERATION_COUNT = UNARY_PREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.PropertyPredicateImpl <em>Property Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.PropertyPredicateImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getPropertyPredicate()
	 * @generated
	 */
	int PROPERTY_PREDICATE = 70;

	/**
	 * The feature id for the '<em><b>Antecedent Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PREDICATE__ANTECEDENT_RULE = BINARY_PREDICATE__ANTECEDENT_RULE;

	/**
	 * The feature id for the '<em><b>Consequent Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PREDICATE__CONSEQUENT_RULE = BINARY_PREDICATE__CONSEQUENT_RULE;

	/**
	 * The feature id for the '<em><b>Argument1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PREDICATE__ARGUMENT1 = BINARY_PREDICATE__ARGUMENT1;

	/**
	 * The feature id for the '<em><b>Argument2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PREDICATE__ARGUMENT2 = BINARY_PREDICATE__ARGUMENT2;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PREDICATE__PROPERTY = BINARY_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PREDICATE_FEATURE_COUNT = BINARY_PREDICATE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PREDICATE___GET_ONTOLOGY = BINARY_PREDICATE___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PREDICATE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = BINARY_PREDICATE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Property Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PREDICATE_OPERATION_COUNT = BINARY_PREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.SameAsPredicateImpl <em>Same As Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.SameAsPredicateImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getSameAsPredicate()
	 * @generated
	 */
	int SAME_AS_PREDICATE = 71;

	/**
	 * The feature id for the '<em><b>Antecedent Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAME_AS_PREDICATE__ANTECEDENT_RULE = BINARY_PREDICATE__ANTECEDENT_RULE;

	/**
	 * The feature id for the '<em><b>Consequent Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAME_AS_PREDICATE__CONSEQUENT_RULE = BINARY_PREDICATE__CONSEQUENT_RULE;

	/**
	 * The feature id for the '<em><b>Argument1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAME_AS_PREDICATE__ARGUMENT1 = BINARY_PREDICATE__ARGUMENT1;

	/**
	 * The feature id for the '<em><b>Argument2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAME_AS_PREDICATE__ARGUMENT2 = BINARY_PREDICATE__ARGUMENT2;

	/**
	 * The number of structural features of the '<em>Same As Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAME_AS_PREDICATE_FEATURE_COUNT = BINARY_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAME_AS_PREDICATE___GET_ONTOLOGY = BINARY_PREDICATE___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAME_AS_PREDICATE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = BINARY_PREDICATE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Same As Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAME_AS_PREDICATE_OPERATION_COUNT = BINARY_PREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.DifferentFromPredicateImpl <em>Different From Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.DifferentFromPredicateImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDifferentFromPredicate()
	 * @generated
	 */
	int DIFFERENT_FROM_PREDICATE = 72;

	/**
	 * The feature id for the '<em><b>Antecedent Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENT_FROM_PREDICATE__ANTECEDENT_RULE = BINARY_PREDICATE__ANTECEDENT_RULE;

	/**
	 * The feature id for the '<em><b>Consequent Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENT_FROM_PREDICATE__CONSEQUENT_RULE = BINARY_PREDICATE__CONSEQUENT_RULE;

	/**
	 * The feature id for the '<em><b>Argument1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENT_FROM_PREDICATE__ARGUMENT1 = BINARY_PREDICATE__ARGUMENT1;

	/**
	 * The feature id for the '<em><b>Argument2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENT_FROM_PREDICATE__ARGUMENT2 = BINARY_PREDICATE__ARGUMENT2;

	/**
	 * The number of structural features of the '<em>Different From Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENT_FROM_PREDICATE_FEATURE_COUNT = BINARY_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENT_FROM_PREDICATE___GET_ONTOLOGY = BINARY_PREDICATE___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENT_FROM_PREDICATE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = BINARY_PREDICATE___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Different From Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENT_FROM_PREDICATE_OPERATION_COUNT = BINARY_PREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.QuotedLiteralImpl <em>Quoted Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.QuotedLiteralImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getQuotedLiteral()
	 * @generated
	 */
	int QUOTED_LITERAL = 73;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lang Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_LITERAL__LANG_TAG = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_LITERAL__TYPE = LITERAL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Quoted Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_LITERAL___GET_ONTOLOGY = LITERAL___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_LITERAL___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = LITERAL___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_LITERAL___GET_VALUE = LITERAL___GET_VALUE;

	/**
	 * The operation id for the '<em>Get String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_LITERAL___GET_STRING_VALUE = LITERAL___GET_STRING_VALUE;

	/**
	 * The operation id for the '<em>Get Lexical Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_LITERAL___GET_LEXICAL_VALUE = LITERAL_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Type Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_LITERAL___GET_TYPE_IRI = LITERAL_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Quoted Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_LITERAL_OPERATION_COUNT = LITERAL_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.IntegerLiteralImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getIntegerLiteral()
	 * @generated
	 */
	int INTEGER_LITERAL = 74;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL___GET_ONTOLOGY = LITERAL___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = LITERAL___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL___GET_VALUE = LITERAL___GET_VALUE;

	/**
	 * The operation id for the '<em>Get String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL___GET_STRING_VALUE = LITERAL___GET_STRING_VALUE;

	/**
	 * The operation id for the '<em>Get Lexical Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL___GET_LEXICAL_VALUE = LITERAL___GET_LEXICAL_VALUE;

	/**
	 * The operation id for the '<em>Get Type Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL___GET_TYPE_IRI = LITERAL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Integer Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_OPERATION_COUNT = LITERAL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.DecimalLiteralImpl <em>Decimal Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.DecimalLiteralImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDecimalLiteral()
	 * @generated
	 */
	int DECIMAL_LITERAL = 75;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECIMAL_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Decimal Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECIMAL_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECIMAL_LITERAL___GET_ONTOLOGY = LITERAL___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECIMAL_LITERAL___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = LITERAL___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECIMAL_LITERAL___GET_VALUE = LITERAL___GET_VALUE;

	/**
	 * The operation id for the '<em>Get String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECIMAL_LITERAL___GET_STRING_VALUE = LITERAL___GET_STRING_VALUE;

	/**
	 * The operation id for the '<em>Get Lexical Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECIMAL_LITERAL___GET_LEXICAL_VALUE = LITERAL___GET_LEXICAL_VALUE;

	/**
	 * The operation id for the '<em>Get Type Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECIMAL_LITERAL___GET_TYPE_IRI = LITERAL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Decimal Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECIMAL_LITERAL_OPERATION_COUNT = LITERAL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.DoubleLiteralImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDoubleLiteral()
	 * @generated
	 */
	int DOUBLE_LITERAL = 76;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Double Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL___GET_ONTOLOGY = LITERAL___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = LITERAL___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL___GET_VALUE = LITERAL___GET_VALUE;

	/**
	 * The operation id for the '<em>Get String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL___GET_STRING_VALUE = LITERAL___GET_STRING_VALUE;

	/**
	 * The operation id for the '<em>Get Lexical Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL___GET_LEXICAL_VALUE = LITERAL___GET_LEXICAL_VALUE;

	/**
	 * The operation id for the '<em>Get Type Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL___GET_TYPE_IRI = LITERAL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Double Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL_OPERATION_COUNT = LITERAL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.BooleanLiteralImpl
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getBooleanLiteral()
	 * @generated
	 */
	int BOOLEAN_LITERAL = 77;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Ontology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL___GET_ONTOLOGY = LITERAL___GET_ONTOLOGY;

	/**
	 * The operation id for the '<em>Extra Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = LITERAL___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL___GET_VALUE = LITERAL___GET_VALUE;

	/**
	 * The operation id for the '<em>Get String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL___GET_STRING_VALUE = LITERAL___GET_STRING_VALUE;

	/**
	 * The operation id for the '<em>Get Lexical Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL___GET_LEXICAL_VALUE = LITERAL___GET_LEXICAL_VALUE;

	/**
	 * The operation id for the '<em>Is Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL___IS_VALUE = LITERAL_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Type Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL___GET_TYPE_IRI = LITERAL_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_OPERATION_COUNT = LITERAL_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.SeparatorKind <em>Separator Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.SeparatorKind
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getSeparatorKind()
	 * @generated
	 */
	int SEPARATOR_KIND = 78;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.RangeRestrictionKind <em>Range Restriction Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.RangeRestrictionKind
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getRangeRestrictionKind()
	 * @generated
	 */
	int RANGE_RESTRICTION_KIND = 79;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.CardinalityRestrictionKind <em>Cardinality Restriction Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.CardinalityRestrictionKind
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getCardinalityRestrictionKind()
	 * @generated
	 */
	int CARDINALITY_RESTRICTION_KIND = 80;

	/**
	 * The meta object id for the '{@link io.opencaesar.oml.ImportKind <em>Import Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.ImportKind
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getImportKind()
	 * @generated
	 */
	int IMPORT_KIND = 81;

	/**
	 * The meta object id for the '<em>Unsigned Int</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getUnsignedInt()
	 * @generated
	 */
	int UNSIGNED_INT = 82;

	/**
	 * The meta object id for the '<em>Unsigned Integer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Integer
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getUnsignedInteger()
	 * @generated
	 */
	int UNSIGNED_INTEGER = 83;

	/**
	 * The meta object id for the '<em>Decimal</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.math.BigDecimal
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDecimal()
	 * @generated
	 */
	int DECIMAL = 84;

	/**
	 * The meta object id for the '<em>Double</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Double
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDouble()
	 * @generated
	 */
	int DOUBLE = 85;

	/**
	 * The meta object id for the '<em>ID</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getID()
	 * @generated
	 */
	int ID = 86;

	/**
	 * The meta object id for the '<em>Namespace</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see io.opencaesar.oml.impl.OmlPackageImpl#getNamespace()
	 * @generated
	 */
	int NAMESPACE = 87;


	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see io.opencaesar.oml.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Element#getOntology() <em>Get Ontology</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Ontology</em>' operation.
	 * @see io.opencaesar.oml.Element#getOntology()
	 * @generated
	 */
	EOperation getElement__GetOntology();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Element#extraValidate(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Extra Validate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Extra Validate</em>' operation.
	 * @see io.opencaesar.oml.Element#extraValidate(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getElement__ExtraValidate__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see io.opencaesar.oml.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.Annotation#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see io.opencaesar.oml.Annotation#getProperty()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_Property();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.Annotation#getLiteralValue <em>Literal Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literal Value</em>'.
	 * @see io.opencaesar.oml.Annotation#getLiteralValue()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_LiteralValue();

	/**
	 * Returns the meta object for the reference list '{@link io.opencaesar.oml.Annotation#getReferencedValue <em>Referenced Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced Value</em>'.
	 * @see io.opencaesar.oml.Annotation#getReferencedValue()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_ReferencedValue();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.Annotation#getOwningElement <em>Owning Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Element</em>'.
	 * @see io.opencaesar.oml.Annotation#getOwningElement()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_OwningElement();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Annotation#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see io.opencaesar.oml.Annotation#getValue()
	 * @generated
	 */
	EOperation getAnnotation__GetValue();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Annotation#getAnnotatedElement() <em>Get Annotated Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Annotated Element</em>' operation.
	 * @see io.opencaesar.oml.Annotation#getAnnotatedElement()
	 * @generated
	 */
	EOperation getAnnotation__GetAnnotatedElement();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.IdentifiedElement <em>Identified Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identified Element</em>'.
	 * @see io.opencaesar.oml.IdentifiedElement
	 * @generated
	 */
	EClass getIdentifiedElement();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.IdentifiedElement#getOwnedAnnotations <em>Owned Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Annotations</em>'.
	 * @see io.opencaesar.oml.IdentifiedElement#getOwnedAnnotations()
	 * @see #getIdentifiedElement()
	 * @generated
	 */
	EReference getIdentifiedElement_OwnedAnnotations();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.IdentifiedElement#getIri() <em>Get Iri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Iri</em>' operation.
	 * @see io.opencaesar.oml.IdentifiedElement#getIri()
	 * @generated
	 */
	EOperation getIdentifiedElement__GetIri();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see io.opencaesar.oml.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.Import#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see io.opencaesar.oml.Import#getKind()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_Kind();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.Import#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see io.opencaesar.oml.Import#getNamespace()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_Namespace();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.Import#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see io.opencaesar.oml.Import#getPrefix()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_Prefix();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.Import#getOwningOntology <em>Owning Ontology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Ontology</em>'.
	 * @see io.opencaesar.oml.Import#getOwningOntology()
	 * @see #getImport()
	 * @generated
	 */
	EReference getImport_OwningOntology();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Import#getIri() <em>Get Iri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Iri</em>' operation.
	 * @see io.opencaesar.oml.Import#getIri()
	 * @generated
	 */
	EOperation getImport__GetIri();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Import#getSeparator() <em>Get Separator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Separator</em>' operation.
	 * @see io.opencaesar.oml.Import#getSeparator()
	 * @generated
	 */
	EOperation getImport__GetSeparator();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Instance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance</em>'.
	 * @see io.opencaesar.oml.Instance
	 * @generated
	 */
	EClass getInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.Instance#getOwnedPropertyValues <em>Owned Property Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Property Values</em>'.
	 * @see io.opencaesar.oml.Instance#getOwnedPropertyValues()
	 * @see #getInstance()
	 * @generated
	 */
	EReference getInstance_OwnedPropertyValues();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Instance#getTypes() <em>Get Types</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Types</em>' operation.
	 * @see io.opencaesar.oml.Instance#getTypes()
	 * @generated
	 */
	EOperation getInstance__GetTypes();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Axiom <em>Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Axiom</em>'.
	 * @see io.opencaesar.oml.Axiom
	 * @generated
	 */
	EClass getAxiom();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Axiom#getCharacterizedTerm() <em>Get Characterized Term</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Characterized Term</em>' operation.
	 * @see io.opencaesar.oml.Axiom#getCharacterizedTerm()
	 * @generated
	 */
	EOperation getAxiom__GetCharacterizedTerm();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Assertion <em>Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assertion</em>'.
	 * @see io.opencaesar.oml.Assertion
	 * @generated
	 */
	EClass getAssertion();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Assertion#getSubject() <em>Get Subject</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Subject</em>' operation.
	 * @see io.opencaesar.oml.Assertion#getSubject()
	 * @generated
	 */
	EOperation getAssertion__GetSubject();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Assertion#getObject() <em>Get Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Object</em>' operation.
	 * @see io.opencaesar.oml.Assertion#getObject()
	 * @generated
	 */
	EOperation getAssertion__GetObject();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Predicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate</em>'.
	 * @see io.opencaesar.oml.Predicate
	 * @generated
	 */
	EClass getPredicate();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.Predicate#getAntecedentRule <em>Antecedent Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Antecedent Rule</em>'.
	 * @see io.opencaesar.oml.Predicate#getAntecedentRule()
	 * @see #getPredicate()
	 * @generated
	 */
	EReference getPredicate_AntecedentRule();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.Predicate#getConsequentRule <em>Consequent Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Consequent Rule</em>'.
	 * @see io.opencaesar.oml.Predicate#getConsequentRule()
	 * @see #getPredicate()
	 * @generated
	 */
	EReference getPredicate_ConsequentRule();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Argument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Argument</em>'.
	 * @see io.opencaesar.oml.Argument
	 * @generated
	 */
	EClass getArgument();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.Argument#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable</em>'.
	 * @see io.opencaesar.oml.Argument#getVariable()
	 * @see #getArgument()
	 * @generated
	 */
	EAttribute getArgument_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link io.opencaesar.oml.Argument#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Literal</em>'.
	 * @see io.opencaesar.oml.Argument#getLiteral()
	 * @see #getArgument()
	 * @generated
	 */
	EReference getArgument_Literal();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.Argument#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance</em>'.
	 * @see io.opencaesar.oml.Argument#getInstance()
	 * @see #getArgument()
	 * @generated
	 */
	EReference getArgument_Instance();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Argument#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see io.opencaesar.oml.Argument#getValue()
	 * @generated
	 */
	EOperation getArgument__GetValue();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see io.opencaesar.oml.Literal
	 * @generated
	 */
	EClass getLiteral();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Literal#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see io.opencaesar.oml.Literal#getValue()
	 * @generated
	 */
	EOperation getLiteral__GetValue();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Literal#getStringValue() <em>Get String Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get String Value</em>' operation.
	 * @see io.opencaesar.oml.Literal#getStringValue()
	 * @generated
	 */
	EOperation getLiteral__GetStringValue();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Literal#getLexicalValue() <em>Get Lexical Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Lexical Value</em>' operation.
	 * @see io.opencaesar.oml.Literal#getLexicalValue()
	 * @generated
	 */
	EOperation getLiteral__GetLexicalValue();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Literal#getTypeIri() <em>Get Type Iri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Iri</em>' operation.
	 * @see io.opencaesar.oml.Literal#getTypeIri()
	 * @generated
	 */
	EOperation getLiteral__GetTypeIri();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Ontology <em>Ontology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ontology</em>'.
	 * @see io.opencaesar.oml.Ontology
	 * @generated
	 */
	EClass getOntology();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.Ontology#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see io.opencaesar.oml.Ontology#getNamespace()
	 * @see #getOntology()
	 * @generated
	 */
	EAttribute getOntology_Namespace();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.Ontology#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see io.opencaesar.oml.Ontology#getPrefix()
	 * @see #getOntology()
	 * @generated
	 */
	EAttribute getOntology_Prefix();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.Ontology#getOwnedImports <em>Owned Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Imports</em>'.
	 * @see io.opencaesar.oml.Ontology#getOwnedImports()
	 * @see #getOntology()
	 * @generated
	 */
	EReference getOntology_OwnedImports();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Ontology#getIri() <em>Get Iri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Iri</em>' operation.
	 * @see io.opencaesar.oml.Ontology#getIri()
	 * @generated
	 */
	EOperation getOntology__GetIri();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Ontology#getSeparator() <em>Get Separator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Separator</em>' operation.
	 * @see io.opencaesar.oml.Ontology#getSeparator()
	 * @generated
	 */
	EOperation getOntology__GetSeparator();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Member <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Member</em>'.
	 * @see io.opencaesar.oml.Member
	 * @generated
	 */
	EClass getMember();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.Member#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see io.opencaesar.oml.Member#getName()
	 * @see #getMember()
	 * @generated
	 */
	EAttribute getMember_Name();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Member#getRef() <em>Get Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Ref</em>' operation.
	 * @see io.opencaesar.oml.Member#getRef()
	 * @generated
	 */
	EOperation getMember__GetRef();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Member#isRef() <em>Is Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Ref</em>' operation.
	 * @see io.opencaesar.oml.Member#isRef()
	 * @generated
	 */
	EOperation getMember__IsRef();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Member#resolve() <em>Resolve</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Resolve</em>' operation.
	 * @see io.opencaesar.oml.Member#resolve()
	 * @generated
	 */
	EOperation getMember__Resolve();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Member#getIri() <em>Get Iri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Iri</em>' operation.
	 * @see io.opencaesar.oml.Member#getIri()
	 * @generated
	 */
	EOperation getMember__GetIri();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Member#getAbbreviatedIri() <em>Get Abbreviated Iri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Abbreviated Iri</em>' operation.
	 * @see io.opencaesar.oml.Member#getAbbreviatedIri()
	 * @generated
	 */
	EOperation getMember__GetAbbreviatedIri();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.VocabularyBox <em>Vocabulary Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vocabulary Box</em>'.
	 * @see io.opencaesar.oml.VocabularyBox
	 * @generated
	 */
	EClass getVocabularyBox();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.DescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description Box</em>'.
	 * @see io.opencaesar.oml.DescriptionBox
	 * @generated
	 */
	EClass getDescriptionBox();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Vocabulary <em>Vocabulary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vocabulary</em>'.
	 * @see io.opencaesar.oml.Vocabulary
	 * @generated
	 */
	EClass getVocabulary();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.Vocabulary#getOwnedStatements <em>Owned Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Statements</em>'.
	 * @see io.opencaesar.oml.Vocabulary#getOwnedStatements()
	 * @see #getVocabulary()
	 * @generated
	 */
	EReference getVocabulary_OwnedStatements();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.VocabularyBundle <em>Vocabulary Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vocabulary Bundle</em>'.
	 * @see io.opencaesar.oml.VocabularyBundle
	 * @generated
	 */
	EClass getVocabularyBundle();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Description <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description</em>'.
	 * @see io.opencaesar.oml.Description
	 * @generated
	 */
	EClass getDescription();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.Description#getOwnedStatements <em>Owned Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Statements</em>'.
	 * @see io.opencaesar.oml.Description#getOwnedStatements()
	 * @see #getDescription()
	 * @generated
	 */
	EReference getDescription_OwnedStatements();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.DescriptionBundle <em>Description Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description Bundle</em>'.
	 * @see io.opencaesar.oml.DescriptionBundle
	 * @generated
	 */
	EClass getDescriptionBundle();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see io.opencaesar.oml.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.VocabularyMember <em>Vocabulary Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vocabulary Member</em>'.
	 * @see io.opencaesar.oml.VocabularyMember
	 * @generated
	 */
	EClass getVocabularyMember();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.DescriptionMember <em>Description Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description Member</em>'.
	 * @see io.opencaesar.oml.DescriptionMember
	 * @generated
	 */
	EClass getDescriptionMember();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.VocabularyStatement <em>Vocabulary Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vocabulary Statement</em>'.
	 * @see io.opencaesar.oml.VocabularyStatement
	 * @generated
	 */
	EClass getVocabularyStatement();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.VocabularyStatement#getOwningVocabulary <em>Owning Vocabulary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Vocabulary</em>'.
	 * @see io.opencaesar.oml.VocabularyStatement#getOwningVocabulary()
	 * @see #getVocabularyStatement()
	 * @generated
	 */
	EReference getVocabularyStatement_OwningVocabulary();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.DescriptionStatement <em>Description Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description Statement</em>'.
	 * @see io.opencaesar.oml.DescriptionStatement
	 * @generated
	 */
	EClass getDescriptionStatement();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.DescriptionStatement#getOwningDescription <em>Owning Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Description</em>'.
	 * @see io.opencaesar.oml.DescriptionStatement#getOwningDescription()
	 * @see #getDescriptionStatement()
	 * @generated
	 */
	EReference getDescriptionStatement_OwningDescription();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Term <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term</em>'.
	 * @see io.opencaesar.oml.Term
	 * @generated
	 */
	EClass getTerm();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see io.opencaesar.oml.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.Rule#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see io.opencaesar.oml.Rule#getRef()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Ref();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.Rule#getAntecedent <em>Antecedent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Antecedent</em>'.
	 * @see io.opencaesar.oml.Rule#getAntecedent()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Antecedent();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.Rule#getConsequent <em>Consequent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Consequent</em>'.
	 * @see io.opencaesar.oml.Rule#getConsequent()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Consequent();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.BuiltIn <em>Built In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Built In</em>'.
	 * @see io.opencaesar.oml.BuiltIn
	 * @generated
	 */
	EClass getBuiltIn();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.BuiltIn#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see io.opencaesar.oml.BuiltIn#getRef()
	 * @see #getBuiltIn()
	 * @generated
	 */
	EReference getBuiltIn_Ref();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.SpecializableTerm <em>Specializable Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specializable Term</em>'.
	 * @see io.opencaesar.oml.SpecializableTerm
	 * @generated
	 */
	EClass getSpecializableTerm();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.SpecializableTerm#getOwnedSpecializations <em>Owned Specializations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Specializations</em>'.
	 * @see io.opencaesar.oml.SpecializableTerm#getOwnedSpecializations()
	 * @see #getSpecializableTerm()
	 * @generated
	 */
	EReference getSpecializableTerm_OwnedSpecializations();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see io.opencaesar.oml.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see io.opencaesar.oml.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.RelationBase <em>Relation Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Base</em>'.
	 * @see io.opencaesar.oml.RelationBase
	 * @generated
	 */
	EClass getRelationBase();

	/**
	 * Returns the meta object for the reference list '{@link io.opencaesar.oml.RelationBase#getSources <em>Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sources</em>'.
	 * @see io.opencaesar.oml.RelationBase#getSources()
	 * @see #getRelationBase()
	 * @generated
	 */
	EReference getRelationBase_Sources();

	/**
	 * Returns the meta object for the reference list '{@link io.opencaesar.oml.RelationBase#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Targets</em>'.
	 * @see io.opencaesar.oml.RelationBase#getTargets()
	 * @see #getRelationBase()
	 * @generated
	 */
	EReference getRelationBase_Targets();

	/**
	 * Returns the meta object for the containment reference '{@link io.opencaesar.oml.RelationBase#getReverseRelation <em>Reverse Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reverse Relation</em>'.
	 * @see io.opencaesar.oml.RelationBase#getReverseRelation()
	 * @see #getRelationBase()
	 * @generated
	 */
	EReference getRelationBase_ReverseRelation();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.RelationBase#isFunctional <em>Functional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Functional</em>'.
	 * @see io.opencaesar.oml.RelationBase#isFunctional()
	 * @see #getRelationBase()
	 * @generated
	 */
	EAttribute getRelationBase_Functional();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.RelationBase#isInverseFunctional <em>Inverse Functional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inverse Functional</em>'.
	 * @see io.opencaesar.oml.RelationBase#isInverseFunctional()
	 * @see #getRelationBase()
	 * @generated
	 */
	EAttribute getRelationBase_InverseFunctional();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.RelationBase#isSymmetric <em>Symmetric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symmetric</em>'.
	 * @see io.opencaesar.oml.RelationBase#isSymmetric()
	 * @see #getRelationBase()
	 * @generated
	 */
	EAttribute getRelationBase_Symmetric();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.RelationBase#isAsymmetric <em>Asymmetric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Asymmetric</em>'.
	 * @see io.opencaesar.oml.RelationBase#isAsymmetric()
	 * @see #getRelationBase()
	 * @generated
	 */
	EAttribute getRelationBase_Asymmetric();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.RelationBase#isReflexive <em>Reflexive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reflexive</em>'.
	 * @see io.opencaesar.oml.RelationBase#isReflexive()
	 * @see #getRelationBase()
	 * @generated
	 */
	EAttribute getRelationBase_Reflexive();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.RelationBase#isIrreflexive <em>Irreflexive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Irreflexive</em>'.
	 * @see io.opencaesar.oml.RelationBase#isIrreflexive()
	 * @see #getRelationBase()
	 * @generated
	 */
	EAttribute getRelationBase_Irreflexive();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.RelationBase#isTransitive <em>Transitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transitive</em>'.
	 * @see io.opencaesar.oml.RelationBase#isTransitive()
	 * @see #getRelationBase()
	 * @generated
	 */
	EAttribute getRelationBase_Transitive();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.SpecializableProperty <em>Specializable Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specializable Property</em>'.
	 * @see io.opencaesar.oml.SpecializableProperty
	 * @generated
	 */
	EClass getSpecializableProperty();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.SpecializableProperty#getOwnedEquivalences <em>Owned Equivalences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Equivalences</em>'.
	 * @see io.opencaesar.oml.SpecializableProperty#getOwnedEquivalences()
	 * @see #getSpecializableProperty()
	 * @generated
	 */
	EReference getSpecializableProperty_OwnedEquivalences();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Classifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier</em>'.
	 * @see io.opencaesar.oml.Classifier
	 * @generated
	 */
	EClass getClassifier();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.Classifier#getOwnedEquivalences <em>Owned Equivalences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Equivalences</em>'.
	 * @see io.opencaesar.oml.Classifier#getOwnedEquivalences()
	 * @see #getClassifier()
	 * @generated
	 */
	EReference getClassifier_OwnedEquivalences();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.Classifier#getOwnedPropertyRestrictions <em>Owned Property Restrictions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Property Restrictions</em>'.
	 * @see io.opencaesar.oml.Classifier#getOwnedPropertyRestrictions()
	 * @see #getClassifier()
	 * @generated
	 */
	EReference getClassifier_OwnedPropertyRestrictions();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Scalar <em>Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scalar</em>'.
	 * @see io.opencaesar.oml.Scalar
	 * @generated
	 */
	EClass getScalar();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.Scalar#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see io.opencaesar.oml.Scalar#getRef()
	 * @see #getScalar()
	 * @generated
	 */
	EReference getScalar_Ref();

	/**
	 * Returns the meta object for the containment reference '{@link io.opencaesar.oml.Scalar#getOwnedEnumeration <em>Owned Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Enumeration</em>'.
	 * @see io.opencaesar.oml.Scalar#getOwnedEnumeration()
	 * @see #getScalar()
	 * @generated
	 */
	EReference getScalar_OwnedEnumeration();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.Scalar#getOwnedEquivalences <em>Owned Equivalences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Equivalences</em>'.
	 * @see io.opencaesar.oml.Scalar#getOwnedEquivalences()
	 * @see #getScalar()
	 * @generated
	 */
	EReference getScalar_OwnedEquivalences();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see io.opencaesar.oml.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.Entity#getOwnedKeys <em>Owned Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Keys</em>'.
	 * @see io.opencaesar.oml.Entity#getOwnedKeys()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_OwnedKeys();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Structure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure</em>'.
	 * @see io.opencaesar.oml.Structure
	 * @generated
	 */
	EClass getStructure();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.Structure#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see io.opencaesar.oml.Structure#getRef()
	 * @see #getStructure()
	 * @generated
	 */
	EReference getStructure_Ref();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Aspect <em>Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aspect</em>'.
	 * @see io.opencaesar.oml.Aspect
	 * @generated
	 */
	EClass getAspect();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.Aspect#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see io.opencaesar.oml.Aspect#getRef()
	 * @see #getAspect()
	 * @generated
	 */
	EReference getAspect_Ref();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Concept <em>Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept</em>'.
	 * @see io.opencaesar.oml.Concept
	 * @generated
	 */
	EClass getConcept();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.Concept#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see io.opencaesar.oml.Concept#getRef()
	 * @see #getConcept()
	 * @generated
	 */
	EReference getConcept_Ref();

	/**
	 * Returns the meta object for the containment reference '{@link io.opencaesar.oml.Concept#getOwnedEnumeration <em>Owned Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Enumeration</em>'.
	 * @see io.opencaesar.oml.Concept#getOwnedEnumeration()
	 * @see #getConcept()
	 * @generated
	 */
	EReference getConcept_OwnedEnumeration();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.RelationEntity <em>Relation Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Entity</em>'.
	 * @see io.opencaesar.oml.RelationEntity
	 * @generated
	 */
	EClass getRelationEntity();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.RelationEntity#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see io.opencaesar.oml.RelationEntity#getRef()
	 * @see #getRelationEntity()
	 * @generated
	 */
	EReference getRelationEntity_Ref();

	/**
	 * Returns the meta object for the containment reference '{@link io.opencaesar.oml.RelationEntity#getForwardRelation <em>Forward Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Forward Relation</em>'.
	 * @see io.opencaesar.oml.RelationEntity#getForwardRelation()
	 * @see #getRelationEntity()
	 * @generated
	 */
	EReference getRelationEntity_ForwardRelation();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.AnnotationProperty <em>Annotation Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Property</em>'.
	 * @see io.opencaesar.oml.AnnotationProperty
	 * @generated
	 */
	EClass getAnnotationProperty();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.AnnotationProperty#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see io.opencaesar.oml.AnnotationProperty#getRef()
	 * @see #getAnnotationProperty()
	 * @generated
	 */
	EReference getAnnotationProperty_Ref();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.SemanticProperty <em>Semantic Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Semantic Property</em>'.
	 * @see io.opencaesar.oml.SemanticProperty
	 * @generated
	 */
	EClass getSemanticProperty();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.SemanticProperty#isFunctional() <em>Is Functional</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Functional</em>' operation.
	 * @see io.opencaesar.oml.SemanticProperty#isFunctional()
	 * @generated
	 */
	EOperation getSemanticProperty__IsFunctional();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.SemanticProperty#getDomainList() <em>Get Domain List</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Domain List</em>' operation.
	 * @see io.opencaesar.oml.SemanticProperty#getDomainList()
	 * @generated
	 */
	EOperation getSemanticProperty__GetDomainList();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.SemanticProperty#getRangeList() <em>Get Range List</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Range List</em>' operation.
	 * @see io.opencaesar.oml.SemanticProperty#getRangeList()
	 * @generated
	 */
	EOperation getSemanticProperty__GetRangeList();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.ScalarProperty <em>Scalar Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scalar Property</em>'.
	 * @see io.opencaesar.oml.ScalarProperty
	 * @generated
	 */
	EClass getScalarProperty();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.ScalarProperty#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see io.opencaesar.oml.ScalarProperty#getRef()
	 * @see #getScalarProperty()
	 * @generated
	 */
	EReference getScalarProperty_Ref();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.ScalarProperty#isFunctional <em>Functional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Functional</em>'.
	 * @see io.opencaesar.oml.ScalarProperty#isFunctional()
	 * @see #getScalarProperty()
	 * @generated
	 */
	EAttribute getScalarProperty_Functional();

	/**
	 * Returns the meta object for the reference list '{@link io.opencaesar.oml.ScalarProperty#getDomains <em>Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Domains</em>'.
	 * @see io.opencaesar.oml.ScalarProperty#getDomains()
	 * @see #getScalarProperty()
	 * @generated
	 */
	EReference getScalarProperty_Domains();

	/**
	 * Returns the meta object for the reference list '{@link io.opencaesar.oml.ScalarProperty#getRanges <em>Ranges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ranges</em>'.
	 * @see io.opencaesar.oml.ScalarProperty#getRanges()
	 * @see #getScalarProperty()
	 * @generated
	 */
	EReference getScalarProperty_Ranges();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ScalarProperty#getDomainList() <em>Get Domain List</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Domain List</em>' operation.
	 * @see io.opencaesar.oml.ScalarProperty#getDomainList()
	 * @generated
	 */
	EOperation getScalarProperty__GetDomainList();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ScalarProperty#getRangeList() <em>Get Range List</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Range List</em>' operation.
	 * @see io.opencaesar.oml.ScalarProperty#getRangeList()
	 * @generated
	 */
	EOperation getScalarProperty__GetRangeList();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.StructuredProperty <em>Structured Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structured Property</em>'.
	 * @see io.opencaesar.oml.StructuredProperty
	 * @generated
	 */
	EClass getStructuredProperty();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.StructuredProperty#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see io.opencaesar.oml.StructuredProperty#getRef()
	 * @see #getStructuredProperty()
	 * @generated
	 */
	EReference getStructuredProperty_Ref();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.StructuredProperty#isFunctional <em>Functional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Functional</em>'.
	 * @see io.opencaesar.oml.StructuredProperty#isFunctional()
	 * @see #getStructuredProperty()
	 * @generated
	 */
	EAttribute getStructuredProperty_Functional();

	/**
	 * Returns the meta object for the reference list '{@link io.opencaesar.oml.StructuredProperty#getDomains <em>Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Domains</em>'.
	 * @see io.opencaesar.oml.StructuredProperty#getDomains()
	 * @see #getStructuredProperty()
	 * @generated
	 */
	EReference getStructuredProperty_Domains();

	/**
	 * Returns the meta object for the reference list '{@link io.opencaesar.oml.StructuredProperty#getRanges <em>Ranges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ranges</em>'.
	 * @see io.opencaesar.oml.StructuredProperty#getRanges()
	 * @see #getStructuredProperty()
	 * @generated
	 */
	EReference getStructuredProperty_Ranges();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.StructuredProperty#getDomainList() <em>Get Domain List</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Domain List</em>' operation.
	 * @see io.opencaesar.oml.StructuredProperty#getDomainList()
	 * @generated
	 */
	EOperation getStructuredProperty__GetDomainList();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.StructuredProperty#getRangeList() <em>Get Range List</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Range List</em>' operation.
	 * @see io.opencaesar.oml.StructuredProperty#getRangeList()
	 * @generated
	 */
	EOperation getStructuredProperty__GetRangeList();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation</em>'.
	 * @see io.opencaesar.oml.Relation
	 * @generated
	 */
	EClass getRelation();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Relation#isInverseFunctional() <em>Is Inverse Functional</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Inverse Functional</em>' operation.
	 * @see io.opencaesar.oml.Relation#isInverseFunctional()
	 * @generated
	 */
	EOperation getRelation__IsInverseFunctional();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Relation#isSymmetric() <em>Is Symmetric</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Symmetric</em>' operation.
	 * @see io.opencaesar.oml.Relation#isSymmetric()
	 * @generated
	 */
	EOperation getRelation__IsSymmetric();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Relation#isAsymmetric() <em>Is Asymmetric</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Asymmetric</em>' operation.
	 * @see io.opencaesar.oml.Relation#isAsymmetric()
	 * @generated
	 */
	EOperation getRelation__IsAsymmetric();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Relation#isReflexive() <em>Is Reflexive</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Reflexive</em>' operation.
	 * @see io.opencaesar.oml.Relation#isReflexive()
	 * @generated
	 */
	EOperation getRelation__IsReflexive();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Relation#isIrreflexive() <em>Is Irreflexive</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Irreflexive</em>' operation.
	 * @see io.opencaesar.oml.Relation#isIrreflexive()
	 * @generated
	 */
	EOperation getRelation__IsIrreflexive();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Relation#isTransitive() <em>Is Transitive</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Transitive</em>' operation.
	 * @see io.opencaesar.oml.Relation#isTransitive()
	 * @generated
	 */
	EOperation getRelation__IsTransitive();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Relation#getDomains() <em>Get Domains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Domains</em>' operation.
	 * @see io.opencaesar.oml.Relation#getDomains()
	 * @generated
	 */
	EOperation getRelation__GetDomains();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Relation#getRanges() <em>Get Ranges</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Ranges</em>' operation.
	 * @see io.opencaesar.oml.Relation#getRanges()
	 * @generated
	 */
	EOperation getRelation__GetRanges();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Relation#getInverse() <em>Get Inverse</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Inverse</em>' operation.
	 * @see io.opencaesar.oml.Relation#getInverse()
	 * @generated
	 */
	EOperation getRelation__GetInverse();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Relation#getDomainList() <em>Get Domain List</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Domain List</em>' operation.
	 * @see io.opencaesar.oml.Relation#getDomainList()
	 * @generated
	 */
	EOperation getRelation__GetDomainList();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.Relation#getRangeList() <em>Get Range List</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Range List</em>' operation.
	 * @see io.opencaesar.oml.Relation#getRangeList()
	 * @generated
	 */
	EOperation getRelation__GetRangeList();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.ForwardRelation <em>Forward Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Forward Relation</em>'.
	 * @see io.opencaesar.oml.ForwardRelation
	 * @generated
	 */
	EClass getForwardRelation();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.ForwardRelation#getRelationEntity <em>Relation Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Relation Entity</em>'.
	 * @see io.opencaesar.oml.ForwardRelation#getRelationEntity()
	 * @see #getForwardRelation()
	 * @generated
	 */
	EReference getForwardRelation_RelationEntity();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ForwardRelation#getRef() <em>Get Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Ref</em>' operation.
	 * @see io.opencaesar.oml.ForwardRelation#getRef()
	 * @generated
	 */
	EOperation getForwardRelation__GetRef();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ForwardRelation#isFunctional() <em>Is Functional</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Functional</em>' operation.
	 * @see io.opencaesar.oml.ForwardRelation#isFunctional()
	 * @generated
	 */
	EOperation getForwardRelation__IsFunctional();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ForwardRelation#isInverseFunctional() <em>Is Inverse Functional</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Inverse Functional</em>' operation.
	 * @see io.opencaesar.oml.ForwardRelation#isInverseFunctional()
	 * @generated
	 */
	EOperation getForwardRelation__IsInverseFunctional();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ForwardRelation#isSymmetric() <em>Is Symmetric</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Symmetric</em>' operation.
	 * @see io.opencaesar.oml.ForwardRelation#isSymmetric()
	 * @generated
	 */
	EOperation getForwardRelation__IsSymmetric();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ForwardRelation#isAsymmetric() <em>Is Asymmetric</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Asymmetric</em>' operation.
	 * @see io.opencaesar.oml.ForwardRelation#isAsymmetric()
	 * @generated
	 */
	EOperation getForwardRelation__IsAsymmetric();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ForwardRelation#isReflexive() <em>Is Reflexive</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Reflexive</em>' operation.
	 * @see io.opencaesar.oml.ForwardRelation#isReflexive()
	 * @generated
	 */
	EOperation getForwardRelation__IsReflexive();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ForwardRelation#isIrreflexive() <em>Is Irreflexive</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Irreflexive</em>' operation.
	 * @see io.opencaesar.oml.ForwardRelation#isIrreflexive()
	 * @generated
	 */
	EOperation getForwardRelation__IsIrreflexive();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ForwardRelation#isTransitive() <em>Is Transitive</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Transitive</em>' operation.
	 * @see io.opencaesar.oml.ForwardRelation#isTransitive()
	 * @generated
	 */
	EOperation getForwardRelation__IsTransitive();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ForwardRelation#getDomains() <em>Get Domains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Domains</em>' operation.
	 * @see io.opencaesar.oml.ForwardRelation#getDomains()
	 * @generated
	 */
	EOperation getForwardRelation__GetDomains();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ForwardRelation#getRanges() <em>Get Ranges</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Ranges</em>' operation.
	 * @see io.opencaesar.oml.ForwardRelation#getRanges()
	 * @generated
	 */
	EOperation getForwardRelation__GetRanges();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ForwardRelation#getInverse() <em>Get Inverse</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Inverse</em>' operation.
	 * @see io.opencaesar.oml.ForwardRelation#getInverse()
	 * @generated
	 */
	EOperation getForwardRelation__GetInverse();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.ReverseRelation <em>Reverse Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reverse Relation</em>'.
	 * @see io.opencaesar.oml.ReverseRelation
	 * @generated
	 */
	EClass getReverseRelation();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.ReverseRelation#getRelationBase <em>Relation Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Relation Base</em>'.
	 * @see io.opencaesar.oml.ReverseRelation#getRelationBase()
	 * @see #getReverseRelation()
	 * @generated
	 */
	EReference getReverseRelation_RelationBase();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ReverseRelation#getRef() <em>Get Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Ref</em>' operation.
	 * @see io.opencaesar.oml.ReverseRelation#getRef()
	 * @generated
	 */
	EOperation getReverseRelation__GetRef();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ReverseRelation#isFunctional() <em>Is Functional</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Functional</em>' operation.
	 * @see io.opencaesar.oml.ReverseRelation#isFunctional()
	 * @generated
	 */
	EOperation getReverseRelation__IsFunctional();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ReverseRelation#isInverseFunctional() <em>Is Inverse Functional</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Inverse Functional</em>' operation.
	 * @see io.opencaesar.oml.ReverseRelation#isInverseFunctional()
	 * @generated
	 */
	EOperation getReverseRelation__IsInverseFunctional();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ReverseRelation#isSymmetric() <em>Is Symmetric</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Symmetric</em>' operation.
	 * @see io.opencaesar.oml.ReverseRelation#isSymmetric()
	 * @generated
	 */
	EOperation getReverseRelation__IsSymmetric();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ReverseRelation#isAsymmetric() <em>Is Asymmetric</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Asymmetric</em>' operation.
	 * @see io.opencaesar.oml.ReverseRelation#isAsymmetric()
	 * @generated
	 */
	EOperation getReverseRelation__IsAsymmetric();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ReverseRelation#isReflexive() <em>Is Reflexive</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Reflexive</em>' operation.
	 * @see io.opencaesar.oml.ReverseRelation#isReflexive()
	 * @generated
	 */
	EOperation getReverseRelation__IsReflexive();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ReverseRelation#isIrreflexive() <em>Is Irreflexive</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Irreflexive</em>' operation.
	 * @see io.opencaesar.oml.ReverseRelation#isIrreflexive()
	 * @generated
	 */
	EOperation getReverseRelation__IsIrreflexive();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ReverseRelation#isTransitive() <em>Is Transitive</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Transitive</em>' operation.
	 * @see io.opencaesar.oml.ReverseRelation#isTransitive()
	 * @generated
	 */
	EOperation getReverseRelation__IsTransitive();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ReverseRelation#getDomains() <em>Get Domains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Domains</em>' operation.
	 * @see io.opencaesar.oml.ReverseRelation#getDomains()
	 * @generated
	 */
	EOperation getReverseRelation__GetDomains();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ReverseRelation#getRanges() <em>Get Ranges</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Ranges</em>' operation.
	 * @see io.opencaesar.oml.ReverseRelation#getRanges()
	 * @generated
	 */
	EOperation getReverseRelation__GetRanges();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ReverseRelation#getInverse() <em>Get Inverse</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Inverse</em>' operation.
	 * @see io.opencaesar.oml.ReverseRelation#getInverse()
	 * @generated
	 */
	EOperation getReverseRelation__GetInverse();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.UnreifiedRelation <em>Unreified Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unreified Relation</em>'.
	 * @see io.opencaesar.oml.UnreifiedRelation
	 * @generated
	 */
	EClass getUnreifiedRelation();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.UnreifiedRelation#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see io.opencaesar.oml.UnreifiedRelation#getRef()
	 * @see #getUnreifiedRelation()
	 * @generated
	 */
	EReference getUnreifiedRelation_Ref();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.UnreifiedRelation#getDomains() <em>Get Domains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Domains</em>' operation.
	 * @see io.opencaesar.oml.UnreifiedRelation#getDomains()
	 * @generated
	 */
	EOperation getUnreifiedRelation__GetDomains();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.UnreifiedRelation#getRanges() <em>Get Ranges</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Ranges</em>' operation.
	 * @see io.opencaesar.oml.UnreifiedRelation#getRanges()
	 * @generated
	 */
	EOperation getUnreifiedRelation__GetRanges();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.UnreifiedRelation#getInverse() <em>Get Inverse</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Inverse</em>' operation.
	 * @see io.opencaesar.oml.UnreifiedRelation#getInverse()
	 * @generated
	 */
	EOperation getUnreifiedRelation__GetInverse();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.NamedInstance <em>Named Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Instance</em>'.
	 * @see io.opencaesar.oml.NamedInstance
	 * @generated
	 */
	EClass getNamedInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.NamedInstance#getOwnedTypes <em>Owned Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Types</em>'.
	 * @see io.opencaesar.oml.NamedInstance#getOwnedTypes()
	 * @see #getNamedInstance()
	 * @generated
	 */
	EReference getNamedInstance_OwnedTypes();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.NamedInstance#getEntityTypes() <em>Get Entity Types</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Entity Types</em>' operation.
	 * @see io.opencaesar.oml.NamedInstance#getEntityTypes()
	 * @generated
	 */
	EOperation getNamedInstance__GetEntityTypes();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.NamedInstance#getTypes() <em>Get Types</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Types</em>' operation.
	 * @see io.opencaesar.oml.NamedInstance#getTypes()
	 * @generated
	 */
	EOperation getNamedInstance__GetTypes();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.AnonymousInstance <em>Anonymous Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Anonymous Instance</em>'.
	 * @see io.opencaesar.oml.AnonymousInstance
	 * @generated
	 */
	EClass getAnonymousInstance();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.AnonymousInstance#getOwningAssertion <em>Owning Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Assertion</em>'.
	 * @see io.opencaesar.oml.AnonymousInstance#getOwningAssertion()
	 * @see #getAnonymousInstance()
	 * @generated
	 */
	EReference getAnonymousInstance_OwningAssertion();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.AnonymousInstance#getOwningAxiom <em>Owning Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Axiom</em>'.
	 * @see io.opencaesar.oml.AnonymousInstance#getOwningAxiom()
	 * @see #getAnonymousInstance()
	 * @generated
	 */
	EReference getAnonymousInstance_OwningAxiom();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.AnonymousInstance#getType() <em>Get Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type</em>' operation.
	 * @see io.opencaesar.oml.AnonymousInstance#getType()
	 * @generated
	 */
	EOperation getAnonymousInstance__GetType();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.AnonymousInstance#getTypes() <em>Get Types</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Types</em>' operation.
	 * @see io.opencaesar.oml.AnonymousInstance#getTypes()
	 * @generated
	 */
	EOperation getAnonymousInstance__GetTypes();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.ConceptInstance <em>Concept Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept Instance</em>'.
	 * @see io.opencaesar.oml.ConceptInstance
	 * @generated
	 */
	EClass getConceptInstance();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.ConceptInstance#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see io.opencaesar.oml.ConceptInstance#getRef()
	 * @see #getConceptInstance()
	 * @generated
	 */
	EReference getConceptInstance_Ref();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.RelationInstance <em>Relation Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Instance</em>'.
	 * @see io.opencaesar.oml.RelationInstance
	 * @generated
	 */
	EClass getRelationInstance();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.RelationInstance#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see io.opencaesar.oml.RelationInstance#getRef()
	 * @see #getRelationInstance()
	 * @generated
	 */
	EReference getRelationInstance_Ref();

	/**
	 * Returns the meta object for the reference list '{@link io.opencaesar.oml.RelationInstance#getSources <em>Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sources</em>'.
	 * @see io.opencaesar.oml.RelationInstance#getSources()
	 * @see #getRelationInstance()
	 * @generated
	 */
	EReference getRelationInstance_Sources();

	/**
	 * Returns the meta object for the reference list '{@link io.opencaesar.oml.RelationInstance#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Targets</em>'.
	 * @see io.opencaesar.oml.RelationInstance#getTargets()
	 * @see #getRelationInstance()
	 * @generated
	 */
	EReference getRelationInstance_Targets();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.StructureInstance <em>Structure Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure Instance</em>'.
	 * @see io.opencaesar.oml.StructureInstance
	 * @generated
	 */
	EClass getStructureInstance();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.StructureInstance#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see io.opencaesar.oml.StructureInstance#getType()
	 * @see #getStructureInstance()
	 * @generated
	 */
	EReference getStructureInstance_Type();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.KeyAxiom <em>Key Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Axiom</em>'.
	 * @see io.opencaesar.oml.KeyAxiom
	 * @generated
	 */
	EClass getKeyAxiom();

	/**
	 * Returns the meta object for the reference list '{@link io.opencaesar.oml.KeyAxiom#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Properties</em>'.
	 * @see io.opencaesar.oml.KeyAxiom#getProperties()
	 * @see #getKeyAxiom()
	 * @generated
	 */
	EReference getKeyAxiom_Properties();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.KeyAxiom#getOwningEntity <em>Owning Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Entity</em>'.
	 * @see io.opencaesar.oml.KeyAxiom#getOwningEntity()
	 * @see #getKeyAxiom()
	 * @generated
	 */
	EReference getKeyAxiom_OwningEntity();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.KeyAxiom#getKeyedEntity() <em>Get Keyed Entity</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Keyed Entity</em>' operation.
	 * @see io.opencaesar.oml.KeyAxiom#getKeyedEntity()
	 * @generated
	 */
	EOperation getKeyAxiom__GetKeyedEntity();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.KeyAxiom#getCharacterizedTerm() <em>Get Characterized Term</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Characterized Term</em>' operation.
	 * @see io.opencaesar.oml.KeyAxiom#getCharacterizedTerm()
	 * @generated
	 */
	EOperation getKeyAxiom__GetCharacterizedTerm();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.SpecializationAxiom <em>Specialization Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specialization Axiom</em>'.
	 * @see io.opencaesar.oml.SpecializationAxiom
	 * @generated
	 */
	EClass getSpecializationAxiom();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.SpecializationAxiom#getSuperTerm <em>Super Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super Term</em>'.
	 * @see io.opencaesar.oml.SpecializationAxiom#getSuperTerm()
	 * @see #getSpecializationAxiom()
	 * @generated
	 */
	EReference getSpecializationAxiom_SuperTerm();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.SpecializationAxiom#getOwningTerm <em>Owning Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Term</em>'.
	 * @see io.opencaesar.oml.SpecializationAxiom#getOwningTerm()
	 * @see #getSpecializationAxiom()
	 * @generated
	 */
	EReference getSpecializationAxiom_OwningTerm();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.SpecializationAxiom#getSubTerm() <em>Get Sub Term</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Sub Term</em>' operation.
	 * @see io.opencaesar.oml.SpecializationAxiom#getSubTerm()
	 * @generated
	 */
	EOperation getSpecializationAxiom__GetSubTerm();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.SpecializationAxiom#getCharacterizedTerm() <em>Get Characterized Term</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Characterized Term</em>' operation.
	 * @see io.opencaesar.oml.SpecializationAxiom#getCharacterizedTerm()
	 * @generated
	 */
	EOperation getSpecializationAxiom__GetCharacterizedTerm();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.InstanceEnumerationAxiom <em>Instance Enumeration Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Enumeration Axiom</em>'.
	 * @see io.opencaesar.oml.InstanceEnumerationAxiom
	 * @generated
	 */
	EClass getInstanceEnumerationAxiom();

	/**
	 * Returns the meta object for the reference list '{@link io.opencaesar.oml.InstanceEnumerationAxiom#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Instances</em>'.
	 * @see io.opencaesar.oml.InstanceEnumerationAxiom#getInstances()
	 * @see #getInstanceEnumerationAxiom()
	 * @generated
	 */
	EReference getInstanceEnumerationAxiom_Instances();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.InstanceEnumerationAxiom#getOwningConcept <em>Owning Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Concept</em>'.
	 * @see io.opencaesar.oml.InstanceEnumerationAxiom#getOwningConcept()
	 * @see #getInstanceEnumerationAxiom()
	 * @generated
	 */
	EReference getInstanceEnumerationAxiom_OwningConcept();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.InstanceEnumerationAxiom#getEnumeratedConcept() <em>Get Enumerated Concept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Enumerated Concept</em>' operation.
	 * @see io.opencaesar.oml.InstanceEnumerationAxiom#getEnumeratedConcept()
	 * @generated
	 */
	EOperation getInstanceEnumerationAxiom__GetEnumeratedConcept();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.InstanceEnumerationAxiom#getCharacterizedTerm() <em>Get Characterized Term</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Characterized Term</em>' operation.
	 * @see io.opencaesar.oml.InstanceEnumerationAxiom#getCharacterizedTerm()
	 * @generated
	 */
	EOperation getInstanceEnumerationAxiom__GetCharacterizedTerm();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.PropertyRestrictionAxiom <em>Property Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Restriction Axiom</em>'.
	 * @see io.opencaesar.oml.PropertyRestrictionAxiom
	 * @generated
	 */
	EClass getPropertyRestrictionAxiom();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.PropertyRestrictionAxiom#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see io.opencaesar.oml.PropertyRestrictionAxiom#getProperty()
	 * @see #getPropertyRestrictionAxiom()
	 * @generated
	 */
	EReference getPropertyRestrictionAxiom_Property();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.PropertyRestrictionAxiom#getOwningClassifier <em>Owning Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Classifier</em>'.
	 * @see io.opencaesar.oml.PropertyRestrictionAxiom#getOwningClassifier()
	 * @see #getPropertyRestrictionAxiom()
	 * @generated
	 */
	EReference getPropertyRestrictionAxiom_OwningClassifier();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.PropertyRestrictionAxiom#getOwningAxiom <em>Owning Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Axiom</em>'.
	 * @see io.opencaesar.oml.PropertyRestrictionAxiom#getOwningAxiom()
	 * @see #getPropertyRestrictionAxiom()
	 * @generated
	 */
	EReference getPropertyRestrictionAxiom_OwningAxiom();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.PropertyRestrictionAxiom#getRestrictingDomain() <em>Get Restricting Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Restricting Domain</em>' operation.
	 * @see io.opencaesar.oml.PropertyRestrictionAxiom#getRestrictingDomain()
	 * @generated
	 */
	EOperation getPropertyRestrictionAxiom__GetRestrictingDomain();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.PropertyRestrictionAxiom#getCharacterizedTerm() <em>Get Characterized Term</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Characterized Term</em>' operation.
	 * @see io.opencaesar.oml.PropertyRestrictionAxiom#getCharacterizedTerm()
	 * @generated
	 */
	EOperation getPropertyRestrictionAxiom__GetCharacterizedTerm();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.LiteralEnumerationAxiom <em>Literal Enumeration Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Enumeration Axiom</em>'.
	 * @see io.opencaesar.oml.LiteralEnumerationAxiom
	 * @generated
	 */
	EClass getLiteralEnumerationAxiom();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.LiteralEnumerationAxiom#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see io.opencaesar.oml.LiteralEnumerationAxiom#getLiterals()
	 * @see #getLiteralEnumerationAxiom()
	 * @generated
	 */
	EReference getLiteralEnumerationAxiom_Literals();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.LiteralEnumerationAxiom#getOwningScalar <em>Owning Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Scalar</em>'.
	 * @see io.opencaesar.oml.LiteralEnumerationAxiom#getOwningScalar()
	 * @see #getLiteralEnumerationAxiom()
	 * @generated
	 */
	EReference getLiteralEnumerationAxiom_OwningScalar();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.LiteralEnumerationAxiom#getEnumeratedScalar() <em>Get Enumerated Scalar</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Enumerated Scalar</em>' operation.
	 * @see io.opencaesar.oml.LiteralEnumerationAxiom#getEnumeratedScalar()
	 * @generated
	 */
	EOperation getLiteralEnumerationAxiom__GetEnumeratedScalar();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.LiteralEnumerationAxiom#getCharacterizedTerm() <em>Get Characterized Term</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Characterized Term</em>' operation.
	 * @see io.opencaesar.oml.LiteralEnumerationAxiom#getCharacterizedTerm()
	 * @generated
	 */
	EOperation getLiteralEnumerationAxiom__GetCharacterizedTerm();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.ClassifierEquivalenceAxiom <em>Classifier Equivalence Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier Equivalence Axiom</em>'.
	 * @see io.opencaesar.oml.ClassifierEquivalenceAxiom
	 * @generated
	 */
	EClass getClassifierEquivalenceAxiom();

	/**
	 * Returns the meta object for the reference list '{@link io.opencaesar.oml.ClassifierEquivalenceAxiom#getSuperClassifiers <em>Super Classifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Classifiers</em>'.
	 * @see io.opencaesar.oml.ClassifierEquivalenceAxiom#getSuperClassifiers()
	 * @see #getClassifierEquivalenceAxiom()
	 * @generated
	 */
	EReference getClassifierEquivalenceAxiom_SuperClassifiers();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.ClassifierEquivalenceAxiom#getOwnedPropertyRestrictions <em>Owned Property Restrictions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Property Restrictions</em>'.
	 * @see io.opencaesar.oml.ClassifierEquivalenceAxiom#getOwnedPropertyRestrictions()
	 * @see #getClassifierEquivalenceAxiom()
	 * @generated
	 */
	EReference getClassifierEquivalenceAxiom_OwnedPropertyRestrictions();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.ClassifierEquivalenceAxiom#getOwningClassifier <em>Owning Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Classifier</em>'.
	 * @see io.opencaesar.oml.ClassifierEquivalenceAxiom#getOwningClassifier()
	 * @see #getClassifierEquivalenceAxiom()
	 * @generated
	 */
	EReference getClassifierEquivalenceAxiom_OwningClassifier();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ClassifierEquivalenceAxiom#getSubClassifier() <em>Get Sub Classifier</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Sub Classifier</em>' operation.
	 * @see io.opencaesar.oml.ClassifierEquivalenceAxiom#getSubClassifier()
	 * @generated
	 */
	EOperation getClassifierEquivalenceAxiom__GetSubClassifier();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ClassifierEquivalenceAxiom#getCharacterizedTerm() <em>Get Characterized Term</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Characterized Term</em>' operation.
	 * @see io.opencaesar.oml.ClassifierEquivalenceAxiom#getCharacterizedTerm()
	 * @generated
	 */
	EOperation getClassifierEquivalenceAxiom__GetCharacterizedTerm();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.ScalarEquivalenceAxiom <em>Scalar Equivalence Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scalar Equivalence Axiom</em>'.
	 * @see io.opencaesar.oml.ScalarEquivalenceAxiom
	 * @generated
	 */
	EClass getScalarEquivalenceAxiom();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getSuperScalar <em>Super Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super Scalar</em>'.
	 * @see io.opencaesar.oml.ScalarEquivalenceAxiom#getSuperScalar()
	 * @see #getScalarEquivalenceAxiom()
	 * @generated
	 */
	EReference getScalarEquivalenceAxiom_SuperScalar();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getOwningScalar <em>Owning Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Scalar</em>'.
	 * @see io.opencaesar.oml.ScalarEquivalenceAxiom#getOwningScalar()
	 * @see #getScalarEquivalenceAxiom()
	 * @generated
	 */
	EReference getScalarEquivalenceAxiom_OwningScalar();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see io.opencaesar.oml.ScalarEquivalenceAxiom#getLength()
	 * @see #getScalarEquivalenceAxiom()
	 * @generated
	 */
	EAttribute getScalarEquivalenceAxiom_Length();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getMinLength <em>Min Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Length</em>'.
	 * @see io.opencaesar.oml.ScalarEquivalenceAxiom#getMinLength()
	 * @see #getScalarEquivalenceAxiom()
	 * @generated
	 */
	EAttribute getScalarEquivalenceAxiom_MinLength();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getMaxLength <em>Max Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Length</em>'.
	 * @see io.opencaesar.oml.ScalarEquivalenceAxiom#getMaxLength()
	 * @see #getScalarEquivalenceAxiom()
	 * @generated
	 */
	EAttribute getScalarEquivalenceAxiom_MaxLength();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see io.opencaesar.oml.ScalarEquivalenceAxiom#getPattern()
	 * @see #getScalarEquivalenceAxiom()
	 * @generated
	 */
	EAttribute getScalarEquivalenceAxiom_Pattern();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see io.opencaesar.oml.ScalarEquivalenceAxiom#getLanguage()
	 * @see #getScalarEquivalenceAxiom()
	 * @generated
	 */
	EAttribute getScalarEquivalenceAxiom_Language();

	/**
	 * Returns the meta object for the containment reference '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getMinInclusive <em>Min Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Min Inclusive</em>'.
	 * @see io.opencaesar.oml.ScalarEquivalenceAxiom#getMinInclusive()
	 * @see #getScalarEquivalenceAxiom()
	 * @generated
	 */
	EReference getScalarEquivalenceAxiom_MinInclusive();

	/**
	 * Returns the meta object for the containment reference '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getMinExclusive <em>Min Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Min Exclusive</em>'.
	 * @see io.opencaesar.oml.ScalarEquivalenceAxiom#getMinExclusive()
	 * @see #getScalarEquivalenceAxiom()
	 * @generated
	 */
	EReference getScalarEquivalenceAxiom_MinExclusive();

	/**
	 * Returns the meta object for the containment reference '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getMaxInclusive <em>Max Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Max Inclusive</em>'.
	 * @see io.opencaesar.oml.ScalarEquivalenceAxiom#getMaxInclusive()
	 * @see #getScalarEquivalenceAxiom()
	 * @generated
	 */
	EReference getScalarEquivalenceAxiom_MaxInclusive();

	/**
	 * Returns the meta object for the containment reference '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getMaxExclusive <em>Max Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Max Exclusive</em>'.
	 * @see io.opencaesar.oml.ScalarEquivalenceAxiom#getMaxExclusive()
	 * @see #getScalarEquivalenceAxiom()
	 * @generated
	 */
	EReference getScalarEquivalenceAxiom_MaxExclusive();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getSubScalar() <em>Get Sub Scalar</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Sub Scalar</em>' operation.
	 * @see io.opencaesar.oml.ScalarEquivalenceAxiom#getSubScalar()
	 * @generated
	 */
	EOperation getScalarEquivalenceAxiom__GetSubScalar();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getCharacterizedTerm() <em>Get Characterized Term</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Characterized Term</em>' operation.
	 * @see io.opencaesar.oml.ScalarEquivalenceAxiom#getCharacterizedTerm()
	 * @generated
	 */
	EOperation getScalarEquivalenceAxiom__GetCharacterizedTerm();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.PropertyEquivalenceAxiom <em>Property Equivalence Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Equivalence Axiom</em>'.
	 * @see io.opencaesar.oml.PropertyEquivalenceAxiom
	 * @generated
	 */
	EClass getPropertyEquivalenceAxiom();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.PropertyEquivalenceAxiom#getSuperProperty <em>Super Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super Property</em>'.
	 * @see io.opencaesar.oml.PropertyEquivalenceAxiom#getSuperProperty()
	 * @see #getPropertyEquivalenceAxiom()
	 * @generated
	 */
	EReference getPropertyEquivalenceAxiom_SuperProperty();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.PropertyEquivalenceAxiom#getOwningProperty <em>Owning Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Property</em>'.
	 * @see io.opencaesar.oml.PropertyEquivalenceAxiom#getOwningProperty()
	 * @see #getPropertyEquivalenceAxiom()
	 * @generated
	 */
	EReference getPropertyEquivalenceAxiom_OwningProperty();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.PropertyEquivalenceAxiom#getSubProperty() <em>Get Sub Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Sub Property</em>' operation.
	 * @see io.opencaesar.oml.PropertyEquivalenceAxiom#getSubProperty()
	 * @generated
	 */
	EOperation getPropertyEquivalenceAxiom__GetSubProperty();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.PropertyEquivalenceAxiom#getCharacterizedTerm() <em>Get Characterized Term</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Characterized Term</em>' operation.
	 * @see io.opencaesar.oml.PropertyEquivalenceAxiom#getCharacterizedTerm()
	 * @generated
	 */
	EOperation getPropertyEquivalenceAxiom__GetCharacterizedTerm();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.PropertyRangeRestrictionAxiom <em>Property Range Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Range Restriction Axiom</em>'.
	 * @see io.opencaesar.oml.PropertyRangeRestrictionAxiom
	 * @generated
	 */
	EClass getPropertyRangeRestrictionAxiom();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.PropertyRangeRestrictionAxiom#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see io.opencaesar.oml.PropertyRangeRestrictionAxiom#getKind()
	 * @see #getPropertyRangeRestrictionAxiom()
	 * @generated
	 */
	EAttribute getPropertyRangeRestrictionAxiom_Kind();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.PropertyRangeRestrictionAxiom#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Range</em>'.
	 * @see io.opencaesar.oml.PropertyRangeRestrictionAxiom#getRange()
	 * @see #getPropertyRangeRestrictionAxiom()
	 * @generated
	 */
	EReference getPropertyRangeRestrictionAxiom_Range();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.PropertyCardinalityRestrictionAxiom <em>Property Cardinality Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Cardinality Restriction Axiom</em>'.
	 * @see io.opencaesar.oml.PropertyCardinalityRestrictionAxiom
	 * @generated
	 */
	EClass getPropertyCardinalityRestrictionAxiom();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.PropertyCardinalityRestrictionAxiom#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see io.opencaesar.oml.PropertyCardinalityRestrictionAxiom#getKind()
	 * @see #getPropertyCardinalityRestrictionAxiom()
	 * @generated
	 */
	EAttribute getPropertyCardinalityRestrictionAxiom_Kind();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.PropertyCardinalityRestrictionAxiom#getCardinality <em>Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cardinality</em>'.
	 * @see io.opencaesar.oml.PropertyCardinalityRestrictionAxiom#getCardinality()
	 * @see #getPropertyCardinalityRestrictionAxiom()
	 * @generated
	 */
	EAttribute getPropertyCardinalityRestrictionAxiom_Cardinality();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.PropertyCardinalityRestrictionAxiom#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Range</em>'.
	 * @see io.opencaesar.oml.PropertyCardinalityRestrictionAxiom#getRange()
	 * @see #getPropertyCardinalityRestrictionAxiom()
	 * @generated
	 */
	EReference getPropertyCardinalityRestrictionAxiom_Range();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.PropertyValueRestrictionAxiom <em>Property Value Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Value Restriction Axiom</em>'.
	 * @see io.opencaesar.oml.PropertyValueRestrictionAxiom
	 * @generated
	 */
	EClass getPropertyValueRestrictionAxiom();

	/**
	 * Returns the meta object for the containment reference '{@link io.opencaesar.oml.PropertyValueRestrictionAxiom#getLiteralValue <em>Literal Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Literal Value</em>'.
	 * @see io.opencaesar.oml.PropertyValueRestrictionAxiom#getLiteralValue()
	 * @see #getPropertyValueRestrictionAxiom()
	 * @generated
	 */
	EReference getPropertyValueRestrictionAxiom_LiteralValue();

	/**
	 * Returns the meta object for the containment reference '{@link io.opencaesar.oml.PropertyValueRestrictionAxiom#getContainedValue <em>Contained Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Contained Value</em>'.
	 * @see io.opencaesar.oml.PropertyValueRestrictionAxiom#getContainedValue()
	 * @see #getPropertyValueRestrictionAxiom()
	 * @generated
	 */
	EReference getPropertyValueRestrictionAxiom_ContainedValue();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.PropertyValueRestrictionAxiom#getReferencedValue <em>Referenced Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Value</em>'.
	 * @see io.opencaesar.oml.PropertyValueRestrictionAxiom#getReferencedValue()
	 * @see #getPropertyValueRestrictionAxiom()
	 * @generated
	 */
	EReference getPropertyValueRestrictionAxiom_ReferencedValue();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.PropertyValueRestrictionAxiom#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see io.opencaesar.oml.PropertyValueRestrictionAxiom#getValue()
	 * @generated
	 */
	EOperation getPropertyValueRestrictionAxiom__GetValue();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.PropertySelfRestrictionAxiom <em>Property Self Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Self Restriction Axiom</em>'.
	 * @see io.opencaesar.oml.PropertySelfRestrictionAxiom
	 * @generated
	 */
	EClass getPropertySelfRestrictionAxiom();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.TypeAssertion <em>Type Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Assertion</em>'.
	 * @see io.opencaesar.oml.TypeAssertion
	 * @generated
	 */
	EClass getTypeAssertion();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.TypeAssertion#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see io.opencaesar.oml.TypeAssertion#getType()
	 * @see #getTypeAssertion()
	 * @generated
	 */
	EReference getTypeAssertion_Type();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.TypeAssertion#getOwningInstance <em>Owning Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Instance</em>'.
	 * @see io.opencaesar.oml.TypeAssertion#getOwningInstance()
	 * @see #getTypeAssertion()
	 * @generated
	 */
	EReference getTypeAssertion_OwningInstance();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.TypeAssertion#getSubject() <em>Get Subject</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Subject</em>' operation.
	 * @see io.opencaesar.oml.TypeAssertion#getSubject()
	 * @generated
	 */
	EOperation getTypeAssertion__GetSubject();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.TypeAssertion#getObjects() <em>Get Objects</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Objects</em>' operation.
	 * @see io.opencaesar.oml.TypeAssertion#getObjects()
	 * @generated
	 */
	EOperation getTypeAssertion__GetObjects();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.PropertyValueAssertion <em>Property Value Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Value Assertion</em>'.
	 * @see io.opencaesar.oml.PropertyValueAssertion
	 * @generated
	 */
	EClass getPropertyValueAssertion();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.PropertyValueAssertion#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see io.opencaesar.oml.PropertyValueAssertion#getProperty()
	 * @see #getPropertyValueAssertion()
	 * @generated
	 */
	EReference getPropertyValueAssertion_Property();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.PropertyValueAssertion#getLiteralValue <em>Literal Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literal Value</em>'.
	 * @see io.opencaesar.oml.PropertyValueAssertion#getLiteralValue()
	 * @see #getPropertyValueAssertion()
	 * @generated
	 */
	EReference getPropertyValueAssertion_LiteralValue();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.PropertyValueAssertion#getContainedValue <em>Contained Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contained Value</em>'.
	 * @see io.opencaesar.oml.PropertyValueAssertion#getContainedValue()
	 * @see #getPropertyValueAssertion()
	 * @generated
	 */
	EReference getPropertyValueAssertion_ContainedValue();

	/**
	 * Returns the meta object for the reference list '{@link io.opencaesar.oml.PropertyValueAssertion#getReferencedValue <em>Referenced Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced Value</em>'.
	 * @see io.opencaesar.oml.PropertyValueAssertion#getReferencedValue()
	 * @see #getPropertyValueAssertion()
	 * @generated
	 */
	EReference getPropertyValueAssertion_ReferencedValue();

	/**
	 * Returns the meta object for the container reference '{@link io.opencaesar.oml.PropertyValueAssertion#getOwningInstance <em>Owning Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Instance</em>'.
	 * @see io.opencaesar.oml.PropertyValueAssertion#getOwningInstance()
	 * @see #getPropertyValueAssertion()
	 * @generated
	 */
	EReference getPropertyValueAssertion_OwningInstance();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.PropertyValueAssertion#getValue() <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see io.opencaesar.oml.PropertyValueAssertion#getValue()
	 * @generated
	 */
	EOperation getPropertyValueAssertion__GetValue();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.PropertyValueAssertion#getSubject() <em>Get Subject</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Subject</em>' operation.
	 * @see io.opencaesar.oml.PropertyValueAssertion#getSubject()
	 * @generated
	 */
	EOperation getPropertyValueAssertion__GetSubject();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.PropertyValueAssertion#getObject() <em>Get Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Object</em>' operation.
	 * @see io.opencaesar.oml.PropertyValueAssertion#getObject()
	 * @generated
	 */
	EOperation getPropertyValueAssertion__GetObject();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.UnaryPredicate <em>Unary Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Predicate</em>'.
	 * @see io.opencaesar.oml.UnaryPredicate
	 * @generated
	 */
	EClass getUnaryPredicate();

	/**
	 * Returns the meta object for the containment reference '{@link io.opencaesar.oml.UnaryPredicate#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Argument</em>'.
	 * @see io.opencaesar.oml.UnaryPredicate#getArgument()
	 * @see #getUnaryPredicate()
	 * @generated
	 */
	EReference getUnaryPredicate_Argument();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.BinaryPredicate <em>Binary Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Predicate</em>'.
	 * @see io.opencaesar.oml.BinaryPredicate
	 * @generated
	 */
	EClass getBinaryPredicate();

	/**
	 * Returns the meta object for the containment reference '{@link io.opencaesar.oml.BinaryPredicate#getArgument1 <em>Argument1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Argument1</em>'.
	 * @see io.opencaesar.oml.BinaryPredicate#getArgument1()
	 * @see #getBinaryPredicate()
	 * @generated
	 */
	EReference getBinaryPredicate_Argument1();

	/**
	 * Returns the meta object for the containment reference '{@link io.opencaesar.oml.BinaryPredicate#getArgument2 <em>Argument2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Argument2</em>'.
	 * @see io.opencaesar.oml.BinaryPredicate#getArgument2()
	 * @see #getBinaryPredicate()
	 * @generated
	 */
	EReference getBinaryPredicate_Argument2();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.BuiltInPredicate <em>Built In Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Built In Predicate</em>'.
	 * @see io.opencaesar.oml.BuiltInPredicate
	 * @generated
	 */
	EClass getBuiltInPredicate();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.BuiltInPredicate#getBuiltIn <em>Built In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Built In</em>'.
	 * @see io.opencaesar.oml.BuiltInPredicate#getBuiltIn()
	 * @see #getBuiltInPredicate()
	 * @generated
	 */
	EReference getBuiltInPredicate_BuiltIn();

	/**
	 * Returns the meta object for the containment reference list '{@link io.opencaesar.oml.BuiltInPredicate#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see io.opencaesar.oml.BuiltInPredicate#getArguments()
	 * @see #getBuiltInPredicate()
	 * @generated
	 */
	EReference getBuiltInPredicate_Arguments();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.TypePredicate <em>Type Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Predicate</em>'.
	 * @see io.opencaesar.oml.TypePredicate
	 * @generated
	 */
	EClass getTypePredicate();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.TypePredicate#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see io.opencaesar.oml.TypePredicate#getType()
	 * @see #getTypePredicate()
	 * @generated
	 */
	EReference getTypePredicate_Type();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.RelationEntityPredicate <em>Relation Entity Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Entity Predicate</em>'.
	 * @see io.opencaesar.oml.RelationEntityPredicate
	 * @generated
	 */
	EClass getRelationEntityPredicate();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.RelationEntityPredicate#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see io.opencaesar.oml.RelationEntityPredicate#getType()
	 * @see #getRelationEntityPredicate()
	 * @generated
	 */
	EReference getRelationEntityPredicate_Type();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.PropertyPredicate <em>Property Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Predicate</em>'.
	 * @see io.opencaesar.oml.PropertyPredicate
	 * @generated
	 */
	EClass getPropertyPredicate();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.PropertyPredicate#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see io.opencaesar.oml.PropertyPredicate#getProperty()
	 * @see #getPropertyPredicate()
	 * @generated
	 */
	EReference getPropertyPredicate_Property();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.SameAsPredicate <em>Same As Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Same As Predicate</em>'.
	 * @see io.opencaesar.oml.SameAsPredicate
	 * @generated
	 */
	EClass getSameAsPredicate();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.DifferentFromPredicate <em>Different From Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Different From Predicate</em>'.
	 * @see io.opencaesar.oml.DifferentFromPredicate
	 * @generated
	 */
	EClass getDifferentFromPredicate();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.QuotedLiteral <em>Quoted Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quoted Literal</em>'.
	 * @see io.opencaesar.oml.QuotedLiteral
	 * @generated
	 */
	EClass getQuotedLiteral();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.QuotedLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see io.opencaesar.oml.QuotedLiteral#getValue()
	 * @see #getQuotedLiteral()
	 * @generated
	 */
	EAttribute getQuotedLiteral_Value();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.QuotedLiteral#getLangTag <em>Lang Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lang Tag</em>'.
	 * @see io.opencaesar.oml.QuotedLiteral#getLangTag()
	 * @see #getQuotedLiteral()
	 * @generated
	 */
	EAttribute getQuotedLiteral_LangTag();

	/**
	 * Returns the meta object for the reference '{@link io.opencaesar.oml.QuotedLiteral#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see io.opencaesar.oml.QuotedLiteral#getType()
	 * @see #getQuotedLiteral()
	 * @generated
	 */
	EReference getQuotedLiteral_Type();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.QuotedLiteral#getLexicalValue() <em>Get Lexical Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Lexical Value</em>' operation.
	 * @see io.opencaesar.oml.QuotedLiteral#getLexicalValue()
	 * @generated
	 */
	EOperation getQuotedLiteral__GetLexicalValue();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.QuotedLiteral#getTypeIri() <em>Get Type Iri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Iri</em>' operation.
	 * @see io.opencaesar.oml.QuotedLiteral#getTypeIri()
	 * @generated
	 */
	EOperation getQuotedLiteral__GetTypeIri();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.IntegerLiteral <em>Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal</em>'.
	 * @see io.opencaesar.oml.IntegerLiteral
	 * @generated
	 */
	EClass getIntegerLiteral();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.IntegerLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see io.opencaesar.oml.IntegerLiteral#getValue()
	 * @see #getIntegerLiteral()
	 * @generated
	 */
	EAttribute getIntegerLiteral_Value();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.IntegerLiteral#getTypeIri() <em>Get Type Iri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Iri</em>' operation.
	 * @see io.opencaesar.oml.IntegerLiteral#getTypeIri()
	 * @generated
	 */
	EOperation getIntegerLiteral__GetTypeIri();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.DecimalLiteral <em>Decimal Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decimal Literal</em>'.
	 * @see io.opencaesar.oml.DecimalLiteral
	 * @generated
	 */
	EClass getDecimalLiteral();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.DecimalLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see io.opencaesar.oml.DecimalLiteral#getValue()
	 * @see #getDecimalLiteral()
	 * @generated
	 */
	EAttribute getDecimalLiteral_Value();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.DecimalLiteral#getTypeIri() <em>Get Type Iri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Iri</em>' operation.
	 * @see io.opencaesar.oml.DecimalLiteral#getTypeIri()
	 * @generated
	 */
	EOperation getDecimalLiteral__GetTypeIri();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.DoubleLiteral <em>Double Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Literal</em>'.
	 * @see io.opencaesar.oml.DoubleLiteral
	 * @generated
	 */
	EClass getDoubleLiteral();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.DoubleLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see io.opencaesar.oml.DoubleLiteral#getValue()
	 * @see #getDoubleLiteral()
	 * @generated
	 */
	EAttribute getDoubleLiteral_Value();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.DoubleLiteral#getTypeIri() <em>Get Type Iri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Iri</em>' operation.
	 * @see io.opencaesar.oml.DoubleLiteral#getTypeIri()
	 * @generated
	 */
	EOperation getDoubleLiteral__GetTypeIri();

	/**
	 * Returns the meta object for class '{@link io.opencaesar.oml.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal</em>'.
	 * @see io.opencaesar.oml.BooleanLiteral
	 * @generated
	 */
	EClass getBooleanLiteral();

	/**
	 * Returns the meta object for the attribute '{@link io.opencaesar.oml.BooleanLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see io.opencaesar.oml.BooleanLiteral#getValue()
	 * @see #getBooleanLiteral()
	 * @generated
	 */
	EAttribute getBooleanLiteral_Value();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.BooleanLiteral#isValue() <em>Is Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Value</em>' operation.
	 * @see io.opencaesar.oml.BooleanLiteral#isValue()
	 * @generated
	 */
	EOperation getBooleanLiteral__IsValue();

	/**
	 * Returns the meta object for the '{@link io.opencaesar.oml.BooleanLiteral#getTypeIri() <em>Get Type Iri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Iri</em>' operation.
	 * @see io.opencaesar.oml.BooleanLiteral#getTypeIri()
	 * @generated
	 */
	EOperation getBooleanLiteral__GetTypeIri();

	/**
	 * Returns the meta object for enum '{@link io.opencaesar.oml.SeparatorKind <em>Separator Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Separator Kind</em>'.
	 * @see io.opencaesar.oml.SeparatorKind
	 * @generated
	 */
	EEnum getSeparatorKind();

	/**
	 * Returns the meta object for enum '{@link io.opencaesar.oml.RangeRestrictionKind <em>Range Restriction Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Range Restriction Kind</em>'.
	 * @see io.opencaesar.oml.RangeRestrictionKind
	 * @generated
	 */
	EEnum getRangeRestrictionKind();

	/**
	 * Returns the meta object for enum '{@link io.opencaesar.oml.CardinalityRestrictionKind <em>Cardinality Restriction Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cardinality Restriction Kind</em>'.
	 * @see io.opencaesar.oml.CardinalityRestrictionKind
	 * @generated
	 */
	EEnum getCardinalityRestrictionKind();

	/**
	 * Returns the meta object for enum '{@link io.opencaesar.oml.ImportKind <em>Import Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Import Kind</em>'.
	 * @see io.opencaesar.oml.ImportKind
	 * @generated
	 */
	EEnum getImportKind();

	/**
	 * Returns the meta object for data type '<em>Unsigned Int</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Unsigned Int</em>'.
	 * @model instanceClass="int"
	 *        extendedMetaData="minInclusive='0' maxInclusive='2147483647'"
	 * @generated
	 */
	EDataType getUnsignedInt();

	/**
	 * Returns the meta object for data type '{@link java.lang.Integer <em>Unsigned Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Unsigned Integer</em>'.
	 * @see java.lang.Integer
	 * @model instanceClass="java.lang.Integer"
	 *        extendedMetaData="minInclusive='0' maxInclusive='2147483647'"
	 * @generated
	 */
	EDataType getUnsignedInteger();

	/**
	 * Returns the meta object for data type '{@link java.math.BigDecimal <em>Decimal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Decimal</em>'.
	 * @see java.math.BigDecimal
	 * @model instanceClass="java.math.BigDecimal"
	 *        extendedMetaData="baseType='http://www.w3.org/2001/XMLSchema#decimal'"
	 * @generated
	 */
	EDataType getDecimal();

	/**
	 * Returns the meta object for data type '{@link java.lang.Double <em>Double</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Double</em>'.
	 * @see java.lang.Double
	 * @model instanceClass="java.lang.Double"
	 * @generated
	 */
	EDataType getDouble();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>ID</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="pattern='[a-zA-Z0-9_\\-.%~]([a-zA-Z0-9_\\-.%~$])*'"
	 * @generated
	 */
	EDataType getID();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Namespace</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="pattern='([^\\s#])*(#|/)' minLength='2'"
	 * @generated
	 */
	EDataType getNamespace();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OmlFactory getOmlFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.ElementImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Get Ontology</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ELEMENT___GET_ONTOLOGY = eINSTANCE.getElement__GetOntology();

		/**
		 * The meta object literal for the '<em><b>Extra Validate</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ELEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getElement__ExtraValidate__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.AnnotationImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__PROPERTY = eINSTANCE.getAnnotation_Property();

		/**
		 * The meta object literal for the '<em><b>Literal Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__LITERAL_VALUE = eINSTANCE.getAnnotation_LiteralValue();

		/**
		 * The meta object literal for the '<em><b>Referenced Value</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__REFERENCED_VALUE = eINSTANCE.getAnnotation_ReferencedValue();

		/**
		 * The meta object literal for the '<em><b>Owning Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__OWNING_ELEMENT = eINSTANCE.getAnnotation_OwningElement();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ANNOTATION___GET_VALUE = eINSTANCE.getAnnotation__GetValue();

		/**
		 * The meta object literal for the '<em><b>Get Annotated Element</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ANNOTATION___GET_ANNOTATED_ELEMENT = eINSTANCE.getAnnotation__GetAnnotatedElement();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.IdentifiedElementImpl <em>Identified Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.IdentifiedElementImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getIdentifiedElement()
		 * @generated
		 */
		EClass IDENTIFIED_ELEMENT = eINSTANCE.getIdentifiedElement();

		/**
		 * The meta object literal for the '<em><b>Owned Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIED_ELEMENT__OWNED_ANNOTATIONS = eINSTANCE.getIdentifiedElement_OwnedAnnotations();

		/**
		 * The meta object literal for the '<em><b>Get Iri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IDENTIFIED_ELEMENT___GET_IRI = eINSTANCE.getIdentifiedElement__GetIri();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.ImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.ImportImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getImport()
		 * @generated
		 */
		EClass IMPORT = eINSTANCE.getImport();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__KIND = eINSTANCE.getImport_Kind();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__NAMESPACE = eINSTANCE.getImport_Namespace();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__PREFIX = eINSTANCE.getImport_Prefix();

		/**
		 * The meta object literal for the '<em><b>Owning Ontology</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT__OWNING_ONTOLOGY = eINSTANCE.getImport_OwningOntology();

		/**
		 * The meta object literal for the '<em><b>Get Iri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IMPORT___GET_IRI = eINSTANCE.getImport__GetIri();

		/**
		 * The meta object literal for the '<em><b>Get Separator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IMPORT___GET_SEPARATOR = eINSTANCE.getImport__GetSeparator();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.InstanceImpl <em>Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.InstanceImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getInstance()
		 * @generated
		 */
		EClass INSTANCE = eINSTANCE.getInstance();

		/**
		 * The meta object literal for the '<em><b>Owned Property Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE__OWNED_PROPERTY_VALUES = eINSTANCE.getInstance_OwnedPropertyValues();

		/**
		 * The meta object literal for the '<em><b>Get Types</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INSTANCE___GET_TYPES = eINSTANCE.getInstance__GetTypes();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.AxiomImpl <em>Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.AxiomImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getAxiom()
		 * @generated
		 */
		EClass AXIOM = eINSTANCE.getAxiom();

		/**
		 * The meta object literal for the '<em><b>Get Characterized Term</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation AXIOM___GET_CHARACTERIZED_TERM = eINSTANCE.getAxiom__GetCharacterizedTerm();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.AssertionImpl <em>Assertion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.AssertionImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getAssertion()
		 * @generated
		 */
		EClass ASSERTION = eINSTANCE.getAssertion();

		/**
		 * The meta object literal for the '<em><b>Get Subject</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ASSERTION___GET_SUBJECT = eINSTANCE.getAssertion__GetSubject();

		/**
		 * The meta object literal for the '<em><b>Get Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ASSERTION___GET_OBJECT = eINSTANCE.getAssertion__GetObject();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.PredicateImpl <em>Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.PredicateImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getPredicate()
		 * @generated
		 */
		EClass PREDICATE = eINSTANCE.getPredicate();

		/**
		 * The meta object literal for the '<em><b>Antecedent Rule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE__ANTECEDENT_RULE = eINSTANCE.getPredicate_AntecedentRule();

		/**
		 * The meta object literal for the '<em><b>Consequent Rule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE__CONSEQUENT_RULE = eINSTANCE.getPredicate_ConsequentRule();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.ArgumentImpl <em>Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.ArgumentImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getArgument()
		 * @generated
		 */
		EClass ARGUMENT = eINSTANCE.getArgument();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARGUMENT__VARIABLE = eINSTANCE.getArgument_Variable();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARGUMENT__LITERAL = eINSTANCE.getArgument_Literal();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARGUMENT__INSTANCE = eINSTANCE.getArgument_Instance();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ARGUMENT___GET_VALUE = eINSTANCE.getArgument__GetValue();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.LiteralImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getLiteral()
		 * @generated
		 */
		EClass LITERAL = eINSTANCE.getLiteral();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL___GET_VALUE = eINSTANCE.getLiteral__GetValue();

		/**
		 * The meta object literal for the '<em><b>Get String Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL___GET_STRING_VALUE = eINSTANCE.getLiteral__GetStringValue();

		/**
		 * The meta object literal for the '<em><b>Get Lexical Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL___GET_LEXICAL_VALUE = eINSTANCE.getLiteral__GetLexicalValue();

		/**
		 * The meta object literal for the '<em><b>Get Type Iri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL___GET_TYPE_IRI = eINSTANCE.getLiteral__GetTypeIri();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.OntologyImpl <em>Ontology</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.OntologyImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getOntology()
		 * @generated
		 */
		EClass ONTOLOGY = eINSTANCE.getOntology();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ONTOLOGY__NAMESPACE = eINSTANCE.getOntology_Namespace();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ONTOLOGY__PREFIX = eINSTANCE.getOntology_Prefix();

		/**
		 * The meta object literal for the '<em><b>Owned Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ONTOLOGY__OWNED_IMPORTS = eINSTANCE.getOntology_OwnedImports();

		/**
		 * The meta object literal for the '<em><b>Get Iri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ONTOLOGY___GET_IRI = eINSTANCE.getOntology__GetIri();

		/**
		 * The meta object literal for the '<em><b>Get Separator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ONTOLOGY___GET_SEPARATOR = eINSTANCE.getOntology__GetSeparator();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.MemberImpl <em>Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.MemberImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getMember()
		 * @generated
		 */
		EClass MEMBER = eINSTANCE.getMember();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBER__NAME = eINSTANCE.getMember_Name();

		/**
		 * The meta object literal for the '<em><b>Get Ref</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MEMBER___GET_REF = eINSTANCE.getMember__GetRef();

		/**
		 * The meta object literal for the '<em><b>Is Ref</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MEMBER___IS_REF = eINSTANCE.getMember__IsRef();

		/**
		 * The meta object literal for the '<em><b>Resolve</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MEMBER___RESOLVE = eINSTANCE.getMember__Resolve();

		/**
		 * The meta object literal for the '<em><b>Get Iri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MEMBER___GET_IRI = eINSTANCE.getMember__GetIri();

		/**
		 * The meta object literal for the '<em><b>Get Abbreviated Iri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MEMBER___GET_ABBREVIATED_IRI = eINSTANCE.getMember__GetAbbreviatedIri();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.VocabularyBoxImpl <em>Vocabulary Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.VocabularyBoxImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getVocabularyBox()
		 * @generated
		 */
		EClass VOCABULARY_BOX = eINSTANCE.getVocabularyBox();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.DescriptionBoxImpl <em>Description Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.DescriptionBoxImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDescriptionBox()
		 * @generated
		 */
		EClass DESCRIPTION_BOX = eINSTANCE.getDescriptionBox();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.VocabularyImpl <em>Vocabulary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.VocabularyImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getVocabulary()
		 * @generated
		 */
		EClass VOCABULARY = eINSTANCE.getVocabulary();

		/**
		 * The meta object literal for the '<em><b>Owned Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOCABULARY__OWNED_STATEMENTS = eINSTANCE.getVocabulary_OwnedStatements();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.VocabularyBundleImpl <em>Vocabulary Bundle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.VocabularyBundleImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getVocabularyBundle()
		 * @generated
		 */
		EClass VOCABULARY_BUNDLE = eINSTANCE.getVocabularyBundle();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.DescriptionImpl <em>Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.DescriptionImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDescription()
		 * @generated
		 */
		EClass DESCRIPTION = eINSTANCE.getDescription();

		/**
		 * The meta object literal for the '<em><b>Owned Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTION__OWNED_STATEMENTS = eINSTANCE.getDescription_OwnedStatements();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.DescriptionBundleImpl <em>Description Bundle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.DescriptionBundleImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDescriptionBundle()
		 * @generated
		 */
		EClass DESCRIPTION_BUNDLE = eINSTANCE.getDescriptionBundle();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.StatementImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.VocabularyMemberImpl <em>Vocabulary Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.VocabularyMemberImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getVocabularyMember()
		 * @generated
		 */
		EClass VOCABULARY_MEMBER = eINSTANCE.getVocabularyMember();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.DescriptionMemberImpl <em>Description Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.DescriptionMemberImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDescriptionMember()
		 * @generated
		 */
		EClass DESCRIPTION_MEMBER = eINSTANCE.getDescriptionMember();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.VocabularyStatementImpl <em>Vocabulary Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.VocabularyStatementImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getVocabularyStatement()
		 * @generated
		 */
		EClass VOCABULARY_STATEMENT = eINSTANCE.getVocabularyStatement();

		/**
		 * The meta object literal for the '<em><b>Owning Vocabulary</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOCABULARY_STATEMENT__OWNING_VOCABULARY = eINSTANCE.getVocabularyStatement_OwningVocabulary();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.DescriptionStatementImpl <em>Description Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.DescriptionStatementImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDescriptionStatement()
		 * @generated
		 */
		EClass DESCRIPTION_STATEMENT = eINSTANCE.getDescriptionStatement();

		/**
		 * The meta object literal for the '<em><b>Owning Description</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTION_STATEMENT__OWNING_DESCRIPTION = eINSTANCE.getDescriptionStatement_OwningDescription();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.TermImpl <em>Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.TermImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getTerm()
		 * @generated
		 */
		EClass TERM = eINSTANCE.getTerm();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.RuleImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__REF = eINSTANCE.getRule_Ref();

		/**
		 * The meta object literal for the '<em><b>Antecedent</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__ANTECEDENT = eINSTANCE.getRule_Antecedent();

		/**
		 * The meta object literal for the '<em><b>Consequent</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__CONSEQUENT = eINSTANCE.getRule_Consequent();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.BuiltInImpl <em>Built In</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.BuiltInImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getBuiltIn()
		 * @generated
		 */
		EClass BUILT_IN = eINSTANCE.getBuiltIn();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUILT_IN__REF = eINSTANCE.getBuiltIn_Ref();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.SpecializableTermImpl <em>Specializable Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.SpecializableTermImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getSpecializableTerm()
		 * @generated
		 */
		EClass SPECIALIZABLE_TERM = eINSTANCE.getSpecializableTerm();

		/**
		 * The meta object literal for the '<em><b>Owned Specializations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS = eINSTANCE.getSpecializableTerm_OwnedSpecializations();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.PropertyImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.TypeImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.RelationBaseImpl <em>Relation Base</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.RelationBaseImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getRelationBase()
		 * @generated
		 */
		EClass RELATION_BASE = eINSTANCE.getRelationBase();

		/**
		 * The meta object literal for the '<em><b>Sources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_BASE__SOURCES = eINSTANCE.getRelationBase_Sources();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_BASE__TARGETS = eINSTANCE.getRelationBase_Targets();

		/**
		 * The meta object literal for the '<em><b>Reverse Relation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_BASE__REVERSE_RELATION = eINSTANCE.getRelationBase_ReverseRelation();

		/**
		 * The meta object literal for the '<em><b>Functional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_BASE__FUNCTIONAL = eINSTANCE.getRelationBase_Functional();

		/**
		 * The meta object literal for the '<em><b>Inverse Functional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_BASE__INVERSE_FUNCTIONAL = eINSTANCE.getRelationBase_InverseFunctional();

		/**
		 * The meta object literal for the '<em><b>Symmetric</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_BASE__SYMMETRIC = eINSTANCE.getRelationBase_Symmetric();

		/**
		 * The meta object literal for the '<em><b>Asymmetric</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_BASE__ASYMMETRIC = eINSTANCE.getRelationBase_Asymmetric();

		/**
		 * The meta object literal for the '<em><b>Reflexive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_BASE__REFLEXIVE = eINSTANCE.getRelationBase_Reflexive();

		/**
		 * The meta object literal for the '<em><b>Irreflexive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_BASE__IRREFLEXIVE = eINSTANCE.getRelationBase_Irreflexive();

		/**
		 * The meta object literal for the '<em><b>Transitive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_BASE__TRANSITIVE = eINSTANCE.getRelationBase_Transitive();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.SpecializablePropertyImpl <em>Specializable Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.SpecializablePropertyImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getSpecializableProperty()
		 * @generated
		 */
		EClass SPECIALIZABLE_PROPERTY = eINSTANCE.getSpecializableProperty();

		/**
		 * The meta object literal for the '<em><b>Owned Equivalences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIALIZABLE_PROPERTY__OWNED_EQUIVALENCES = eINSTANCE.getSpecializableProperty_OwnedEquivalences();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.ClassifierImpl <em>Classifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.ClassifierImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getClassifier()
		 * @generated
		 */
		EClass CLASSIFIER = eINSTANCE.getClassifier();

		/**
		 * The meta object literal for the '<em><b>Owned Equivalences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER__OWNED_EQUIVALENCES = eINSTANCE.getClassifier_OwnedEquivalences();

		/**
		 * The meta object literal for the '<em><b>Owned Property Restrictions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS = eINSTANCE.getClassifier_OwnedPropertyRestrictions();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.ScalarImpl <em>Scalar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.ScalarImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getScalar()
		 * @generated
		 */
		EClass SCALAR = eINSTANCE.getScalar();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCALAR__REF = eINSTANCE.getScalar_Ref();

		/**
		 * The meta object literal for the '<em><b>Owned Enumeration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCALAR__OWNED_ENUMERATION = eINSTANCE.getScalar_OwnedEnumeration();

		/**
		 * The meta object literal for the '<em><b>Owned Equivalences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCALAR__OWNED_EQUIVALENCES = eINSTANCE.getScalar_OwnedEquivalences();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.EntityImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '<em><b>Owned Keys</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__OWNED_KEYS = eINSTANCE.getEntity_OwnedKeys();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.StructureImpl <em>Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.StructureImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getStructure()
		 * @generated
		 */
		EClass STRUCTURE = eINSTANCE.getStructure();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE__REF = eINSTANCE.getStructure_Ref();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.AspectImpl <em>Aspect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.AspectImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getAspect()
		 * @generated
		 */
		EClass ASPECT = eINSTANCE.getAspect();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASPECT__REF = eINSTANCE.getAspect_Ref();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.ConceptImpl <em>Concept</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.ConceptImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getConcept()
		 * @generated
		 */
		EClass CONCEPT = eINSTANCE.getConcept();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT__REF = eINSTANCE.getConcept_Ref();

		/**
		 * The meta object literal for the '<em><b>Owned Enumeration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT__OWNED_ENUMERATION = eINSTANCE.getConcept_OwnedEnumeration();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.RelationEntityImpl <em>Relation Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.RelationEntityImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getRelationEntity()
		 * @generated
		 */
		EClass RELATION_ENTITY = eINSTANCE.getRelationEntity();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_ENTITY__REF = eINSTANCE.getRelationEntity_Ref();

		/**
		 * The meta object literal for the '<em><b>Forward Relation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_ENTITY__FORWARD_RELATION = eINSTANCE.getRelationEntity_ForwardRelation();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.AnnotationPropertyImpl <em>Annotation Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.AnnotationPropertyImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getAnnotationProperty()
		 * @generated
		 */
		EClass ANNOTATION_PROPERTY = eINSTANCE.getAnnotationProperty();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_PROPERTY__REF = eINSTANCE.getAnnotationProperty_Ref();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.SemanticPropertyImpl <em>Semantic Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.SemanticPropertyImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getSemanticProperty()
		 * @generated
		 */
		EClass SEMANTIC_PROPERTY = eINSTANCE.getSemanticProperty();

		/**
		 * The meta object literal for the '<em><b>Is Functional</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SEMANTIC_PROPERTY___IS_FUNCTIONAL = eINSTANCE.getSemanticProperty__IsFunctional();

		/**
		 * The meta object literal for the '<em><b>Get Domain List</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SEMANTIC_PROPERTY___GET_DOMAIN_LIST = eINSTANCE.getSemanticProperty__GetDomainList();

		/**
		 * The meta object literal for the '<em><b>Get Range List</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SEMANTIC_PROPERTY___GET_RANGE_LIST = eINSTANCE.getSemanticProperty__GetRangeList();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.ScalarPropertyImpl <em>Scalar Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.ScalarPropertyImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getScalarProperty()
		 * @generated
		 */
		EClass SCALAR_PROPERTY = eINSTANCE.getScalarProperty();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCALAR_PROPERTY__REF = eINSTANCE.getScalarProperty_Ref();

		/**
		 * The meta object literal for the '<em><b>Functional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALAR_PROPERTY__FUNCTIONAL = eINSTANCE.getScalarProperty_Functional();

		/**
		 * The meta object literal for the '<em><b>Domains</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCALAR_PROPERTY__DOMAINS = eINSTANCE.getScalarProperty_Domains();

		/**
		 * The meta object literal for the '<em><b>Ranges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCALAR_PROPERTY__RANGES = eINSTANCE.getScalarProperty_Ranges();

		/**
		 * The meta object literal for the '<em><b>Get Domain List</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCALAR_PROPERTY___GET_DOMAIN_LIST = eINSTANCE.getScalarProperty__GetDomainList();

		/**
		 * The meta object literal for the '<em><b>Get Range List</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCALAR_PROPERTY___GET_RANGE_LIST = eINSTANCE.getScalarProperty__GetRangeList();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.StructuredPropertyImpl <em>Structured Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.StructuredPropertyImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getStructuredProperty()
		 * @generated
		 */
		EClass STRUCTURED_PROPERTY = eINSTANCE.getStructuredProperty();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURED_PROPERTY__REF = eINSTANCE.getStructuredProperty_Ref();

		/**
		 * The meta object literal for the '<em><b>Functional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURED_PROPERTY__FUNCTIONAL = eINSTANCE.getStructuredProperty_Functional();

		/**
		 * The meta object literal for the '<em><b>Domains</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURED_PROPERTY__DOMAINS = eINSTANCE.getStructuredProperty_Domains();

		/**
		 * The meta object literal for the '<em><b>Ranges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURED_PROPERTY__RANGES = eINSTANCE.getStructuredProperty_Ranges();

		/**
		 * The meta object literal for the '<em><b>Get Domain List</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STRUCTURED_PROPERTY___GET_DOMAIN_LIST = eINSTANCE.getStructuredProperty__GetDomainList();

		/**
		 * The meta object literal for the '<em><b>Get Range List</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STRUCTURED_PROPERTY___GET_RANGE_LIST = eINSTANCE.getStructuredProperty__GetRangeList();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.RelationImpl <em>Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.RelationImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getRelation()
		 * @generated
		 */
		EClass RELATION = eINSTANCE.getRelation();

		/**
		 * The meta object literal for the '<em><b>Is Inverse Functional</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION___IS_INVERSE_FUNCTIONAL = eINSTANCE.getRelation__IsInverseFunctional();

		/**
		 * The meta object literal for the '<em><b>Is Symmetric</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION___IS_SYMMETRIC = eINSTANCE.getRelation__IsSymmetric();

		/**
		 * The meta object literal for the '<em><b>Is Asymmetric</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION___IS_ASYMMETRIC = eINSTANCE.getRelation__IsAsymmetric();

		/**
		 * The meta object literal for the '<em><b>Is Reflexive</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION___IS_REFLEXIVE = eINSTANCE.getRelation__IsReflexive();

		/**
		 * The meta object literal for the '<em><b>Is Irreflexive</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION___IS_IRREFLEXIVE = eINSTANCE.getRelation__IsIrreflexive();

		/**
		 * The meta object literal for the '<em><b>Is Transitive</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION___IS_TRANSITIVE = eINSTANCE.getRelation__IsTransitive();

		/**
		 * The meta object literal for the '<em><b>Get Domains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION___GET_DOMAINS = eINSTANCE.getRelation__GetDomains();

		/**
		 * The meta object literal for the '<em><b>Get Ranges</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION___GET_RANGES = eINSTANCE.getRelation__GetRanges();

		/**
		 * The meta object literal for the '<em><b>Get Inverse</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION___GET_INVERSE = eINSTANCE.getRelation__GetInverse();

		/**
		 * The meta object literal for the '<em><b>Get Domain List</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION___GET_DOMAIN_LIST = eINSTANCE.getRelation__GetDomainList();

		/**
		 * The meta object literal for the '<em><b>Get Range List</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION___GET_RANGE_LIST = eINSTANCE.getRelation__GetRangeList();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.ForwardRelationImpl <em>Forward Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.ForwardRelationImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getForwardRelation()
		 * @generated
		 */
		EClass FORWARD_RELATION = eINSTANCE.getForwardRelation();

		/**
		 * The meta object literal for the '<em><b>Relation Entity</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORWARD_RELATION__RELATION_ENTITY = eINSTANCE.getForwardRelation_RelationEntity();

		/**
		 * The meta object literal for the '<em><b>Get Ref</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORWARD_RELATION___GET_REF = eINSTANCE.getForwardRelation__GetRef();

		/**
		 * The meta object literal for the '<em><b>Is Functional</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORWARD_RELATION___IS_FUNCTIONAL = eINSTANCE.getForwardRelation__IsFunctional();

		/**
		 * The meta object literal for the '<em><b>Is Inverse Functional</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORWARD_RELATION___IS_INVERSE_FUNCTIONAL = eINSTANCE.getForwardRelation__IsInverseFunctional();

		/**
		 * The meta object literal for the '<em><b>Is Symmetric</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORWARD_RELATION___IS_SYMMETRIC = eINSTANCE.getForwardRelation__IsSymmetric();

		/**
		 * The meta object literal for the '<em><b>Is Asymmetric</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORWARD_RELATION___IS_ASYMMETRIC = eINSTANCE.getForwardRelation__IsAsymmetric();

		/**
		 * The meta object literal for the '<em><b>Is Reflexive</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORWARD_RELATION___IS_REFLEXIVE = eINSTANCE.getForwardRelation__IsReflexive();

		/**
		 * The meta object literal for the '<em><b>Is Irreflexive</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORWARD_RELATION___IS_IRREFLEXIVE = eINSTANCE.getForwardRelation__IsIrreflexive();

		/**
		 * The meta object literal for the '<em><b>Is Transitive</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORWARD_RELATION___IS_TRANSITIVE = eINSTANCE.getForwardRelation__IsTransitive();

		/**
		 * The meta object literal for the '<em><b>Get Domains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORWARD_RELATION___GET_DOMAINS = eINSTANCE.getForwardRelation__GetDomains();

		/**
		 * The meta object literal for the '<em><b>Get Ranges</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORWARD_RELATION___GET_RANGES = eINSTANCE.getForwardRelation__GetRanges();

		/**
		 * The meta object literal for the '<em><b>Get Inverse</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORWARD_RELATION___GET_INVERSE = eINSTANCE.getForwardRelation__GetInverse();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.ReverseRelationImpl <em>Reverse Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.ReverseRelationImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getReverseRelation()
		 * @generated
		 */
		EClass REVERSE_RELATION = eINSTANCE.getReverseRelation();

		/**
		 * The meta object literal for the '<em><b>Relation Base</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVERSE_RELATION__RELATION_BASE = eINSTANCE.getReverseRelation_RelationBase();

		/**
		 * The meta object literal for the '<em><b>Get Ref</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REVERSE_RELATION___GET_REF = eINSTANCE.getReverseRelation__GetRef();

		/**
		 * The meta object literal for the '<em><b>Is Functional</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REVERSE_RELATION___IS_FUNCTIONAL = eINSTANCE.getReverseRelation__IsFunctional();

		/**
		 * The meta object literal for the '<em><b>Is Inverse Functional</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REVERSE_RELATION___IS_INVERSE_FUNCTIONAL = eINSTANCE.getReverseRelation__IsInverseFunctional();

		/**
		 * The meta object literal for the '<em><b>Is Symmetric</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REVERSE_RELATION___IS_SYMMETRIC = eINSTANCE.getReverseRelation__IsSymmetric();

		/**
		 * The meta object literal for the '<em><b>Is Asymmetric</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REVERSE_RELATION___IS_ASYMMETRIC = eINSTANCE.getReverseRelation__IsAsymmetric();

		/**
		 * The meta object literal for the '<em><b>Is Reflexive</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REVERSE_RELATION___IS_REFLEXIVE = eINSTANCE.getReverseRelation__IsReflexive();

		/**
		 * The meta object literal for the '<em><b>Is Irreflexive</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REVERSE_RELATION___IS_IRREFLEXIVE = eINSTANCE.getReverseRelation__IsIrreflexive();

		/**
		 * The meta object literal for the '<em><b>Is Transitive</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REVERSE_RELATION___IS_TRANSITIVE = eINSTANCE.getReverseRelation__IsTransitive();

		/**
		 * The meta object literal for the '<em><b>Get Domains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REVERSE_RELATION___GET_DOMAINS = eINSTANCE.getReverseRelation__GetDomains();

		/**
		 * The meta object literal for the '<em><b>Get Ranges</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REVERSE_RELATION___GET_RANGES = eINSTANCE.getReverseRelation__GetRanges();

		/**
		 * The meta object literal for the '<em><b>Get Inverse</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REVERSE_RELATION___GET_INVERSE = eINSTANCE.getReverseRelation__GetInverse();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.UnreifiedRelationImpl <em>Unreified Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.UnreifiedRelationImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getUnreifiedRelation()
		 * @generated
		 */
		EClass UNREIFIED_RELATION = eINSTANCE.getUnreifiedRelation();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNREIFIED_RELATION__REF = eINSTANCE.getUnreifiedRelation_Ref();

		/**
		 * The meta object literal for the '<em><b>Get Domains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation UNREIFIED_RELATION___GET_DOMAINS = eINSTANCE.getUnreifiedRelation__GetDomains();

		/**
		 * The meta object literal for the '<em><b>Get Ranges</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation UNREIFIED_RELATION___GET_RANGES = eINSTANCE.getUnreifiedRelation__GetRanges();

		/**
		 * The meta object literal for the '<em><b>Get Inverse</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation UNREIFIED_RELATION___GET_INVERSE = eINSTANCE.getUnreifiedRelation__GetInverse();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.NamedInstanceImpl <em>Named Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.NamedInstanceImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getNamedInstance()
		 * @generated
		 */
		EClass NAMED_INSTANCE = eINSTANCE.getNamedInstance();

		/**
		 * The meta object literal for the '<em><b>Owned Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_INSTANCE__OWNED_TYPES = eINSTANCE.getNamedInstance_OwnedTypes();

		/**
		 * The meta object literal for the '<em><b>Get Entity Types</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NAMED_INSTANCE___GET_ENTITY_TYPES = eINSTANCE.getNamedInstance__GetEntityTypes();

		/**
		 * The meta object literal for the '<em><b>Get Types</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NAMED_INSTANCE___GET_TYPES = eINSTANCE.getNamedInstance__GetTypes();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.AnonymousInstanceImpl <em>Anonymous Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.AnonymousInstanceImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getAnonymousInstance()
		 * @generated
		 */
		EClass ANONYMOUS_INSTANCE = eINSTANCE.getAnonymousInstance();

		/**
		 * The meta object literal for the '<em><b>Owning Assertion</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANONYMOUS_INSTANCE__OWNING_ASSERTION = eINSTANCE.getAnonymousInstance_OwningAssertion();

		/**
		 * The meta object literal for the '<em><b>Owning Axiom</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANONYMOUS_INSTANCE__OWNING_AXIOM = eINSTANCE.getAnonymousInstance_OwningAxiom();

		/**
		 * The meta object literal for the '<em><b>Get Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ANONYMOUS_INSTANCE___GET_TYPE = eINSTANCE.getAnonymousInstance__GetType();

		/**
		 * The meta object literal for the '<em><b>Get Types</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ANONYMOUS_INSTANCE___GET_TYPES = eINSTANCE.getAnonymousInstance__GetTypes();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.ConceptInstanceImpl <em>Concept Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.ConceptInstanceImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getConceptInstance()
		 * @generated
		 */
		EClass CONCEPT_INSTANCE = eINSTANCE.getConceptInstance();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_INSTANCE__REF = eINSTANCE.getConceptInstance_Ref();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.RelationInstanceImpl <em>Relation Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.RelationInstanceImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getRelationInstance()
		 * @generated
		 */
		EClass RELATION_INSTANCE = eINSTANCE.getRelationInstance();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_INSTANCE__REF = eINSTANCE.getRelationInstance_Ref();

		/**
		 * The meta object literal for the '<em><b>Sources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_INSTANCE__SOURCES = eINSTANCE.getRelationInstance_Sources();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_INSTANCE__TARGETS = eINSTANCE.getRelationInstance_Targets();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.StructureInstanceImpl <em>Structure Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.StructureInstanceImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getStructureInstance()
		 * @generated
		 */
		EClass STRUCTURE_INSTANCE = eINSTANCE.getStructureInstance();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_INSTANCE__TYPE = eINSTANCE.getStructureInstance_Type();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.KeyAxiomImpl <em>Key Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.KeyAxiomImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getKeyAxiom()
		 * @generated
		 */
		EClass KEY_AXIOM = eINSTANCE.getKeyAxiom();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_AXIOM__PROPERTIES = eINSTANCE.getKeyAxiom_Properties();

		/**
		 * The meta object literal for the '<em><b>Owning Entity</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_AXIOM__OWNING_ENTITY = eINSTANCE.getKeyAxiom_OwningEntity();

		/**
		 * The meta object literal for the '<em><b>Get Keyed Entity</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KEY_AXIOM___GET_KEYED_ENTITY = eINSTANCE.getKeyAxiom__GetKeyedEntity();

		/**
		 * The meta object literal for the '<em><b>Get Characterized Term</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KEY_AXIOM___GET_CHARACTERIZED_TERM = eINSTANCE.getKeyAxiom__GetCharacterizedTerm();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.SpecializationAxiomImpl <em>Specialization Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.SpecializationAxiomImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getSpecializationAxiom()
		 * @generated
		 */
		EClass SPECIALIZATION_AXIOM = eINSTANCE.getSpecializationAxiom();

		/**
		 * The meta object literal for the '<em><b>Super Term</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIALIZATION_AXIOM__SUPER_TERM = eINSTANCE.getSpecializationAxiom_SuperTerm();

		/**
		 * The meta object literal for the '<em><b>Owning Term</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIALIZATION_AXIOM__OWNING_TERM = eINSTANCE.getSpecializationAxiom_OwningTerm();

		/**
		 * The meta object literal for the '<em><b>Get Sub Term</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SPECIALIZATION_AXIOM___GET_SUB_TERM = eINSTANCE.getSpecializationAxiom__GetSubTerm();

		/**
		 * The meta object literal for the '<em><b>Get Characterized Term</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SPECIALIZATION_AXIOM___GET_CHARACTERIZED_TERM = eINSTANCE.getSpecializationAxiom__GetCharacterizedTerm();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.InstanceEnumerationAxiomImpl <em>Instance Enumeration Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.InstanceEnumerationAxiomImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getInstanceEnumerationAxiom()
		 * @generated
		 */
		EClass INSTANCE_ENUMERATION_AXIOM = eINSTANCE.getInstanceEnumerationAxiom();

		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_ENUMERATION_AXIOM__INSTANCES = eINSTANCE.getInstanceEnumerationAxiom_Instances();

		/**
		 * The meta object literal for the '<em><b>Owning Concept</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_ENUMERATION_AXIOM__OWNING_CONCEPT = eINSTANCE.getInstanceEnumerationAxiom_OwningConcept();

		/**
		 * The meta object literal for the '<em><b>Get Enumerated Concept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INSTANCE_ENUMERATION_AXIOM___GET_ENUMERATED_CONCEPT = eINSTANCE.getInstanceEnumerationAxiom__GetEnumeratedConcept();

		/**
		 * The meta object literal for the '<em><b>Get Characterized Term</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INSTANCE_ENUMERATION_AXIOM___GET_CHARACTERIZED_TERM = eINSTANCE.getInstanceEnumerationAxiom__GetCharacterizedTerm();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.PropertyRestrictionAxiomImpl <em>Property Restriction Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.PropertyRestrictionAxiomImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getPropertyRestrictionAxiom()
		 * @generated
		 */
		EClass PROPERTY_RESTRICTION_AXIOM = eINSTANCE.getPropertyRestrictionAxiom();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_RESTRICTION_AXIOM__PROPERTY = eINSTANCE.getPropertyRestrictionAxiom_Property();

		/**
		 * The meta object literal for the '<em><b>Owning Classifier</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER = eINSTANCE.getPropertyRestrictionAxiom_OwningClassifier();

		/**
		 * The meta object literal for the '<em><b>Owning Axiom</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM = eINSTANCE.getPropertyRestrictionAxiom_OwningAxiom();

		/**
		 * The meta object literal for the '<em><b>Get Restricting Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_RESTRICTION_AXIOM___GET_RESTRICTING_DOMAIN = eINSTANCE.getPropertyRestrictionAxiom__GetRestrictingDomain();

		/**
		 * The meta object literal for the '<em><b>Get Characterized Term</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_RESTRICTION_AXIOM___GET_CHARACTERIZED_TERM = eINSTANCE.getPropertyRestrictionAxiom__GetCharacterizedTerm();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.LiteralEnumerationAxiomImpl <em>Literal Enumeration Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.LiteralEnumerationAxiomImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getLiteralEnumerationAxiom()
		 * @generated
		 */
		EClass LITERAL_ENUMERATION_AXIOM = eINSTANCE.getLiteralEnumerationAxiom();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_ENUMERATION_AXIOM__LITERALS = eINSTANCE.getLiteralEnumerationAxiom_Literals();

		/**
		 * The meta object literal for the '<em><b>Owning Scalar</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_ENUMERATION_AXIOM__OWNING_SCALAR = eINSTANCE.getLiteralEnumerationAxiom_OwningScalar();

		/**
		 * The meta object literal for the '<em><b>Get Enumerated Scalar</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL_ENUMERATION_AXIOM___GET_ENUMERATED_SCALAR = eINSTANCE.getLiteralEnumerationAxiom__GetEnumeratedScalar();

		/**
		 * The meta object literal for the '<em><b>Get Characterized Term</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL_ENUMERATION_AXIOM___GET_CHARACTERIZED_TERM = eINSTANCE.getLiteralEnumerationAxiom__GetCharacterizedTerm();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.ClassifierEquivalenceAxiomImpl <em>Classifier Equivalence Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.ClassifierEquivalenceAxiomImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getClassifierEquivalenceAxiom()
		 * @generated
		 */
		EClass CLASSIFIER_EQUIVALENCE_AXIOM = eINSTANCE.getClassifierEquivalenceAxiom();

		/**
		 * The meta object literal for the '<em><b>Super Classifiers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_EQUIVALENCE_AXIOM__SUPER_CLASSIFIERS = eINSTANCE.getClassifierEquivalenceAxiom_SuperClassifiers();

		/**
		 * The meta object literal for the '<em><b>Owned Property Restrictions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS = eINSTANCE.getClassifierEquivalenceAxiom_OwnedPropertyRestrictions();

		/**
		 * The meta object literal for the '<em><b>Owning Classifier</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_EQUIVALENCE_AXIOM__OWNING_CLASSIFIER = eINSTANCE.getClassifierEquivalenceAxiom_OwningClassifier();

		/**
		 * The meta object literal for the '<em><b>Get Sub Classifier</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASSIFIER_EQUIVALENCE_AXIOM___GET_SUB_CLASSIFIER = eINSTANCE.getClassifierEquivalenceAxiom__GetSubClassifier();

		/**
		 * The meta object literal for the '<em><b>Get Characterized Term</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASSIFIER_EQUIVALENCE_AXIOM___GET_CHARACTERIZED_TERM = eINSTANCE.getClassifierEquivalenceAxiom__GetCharacterizedTerm();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.ScalarEquivalenceAxiomImpl <em>Scalar Equivalence Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.ScalarEquivalenceAxiomImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getScalarEquivalenceAxiom()
		 * @generated
		 */
		EClass SCALAR_EQUIVALENCE_AXIOM = eINSTANCE.getScalarEquivalenceAxiom();

		/**
		 * The meta object literal for the '<em><b>Super Scalar</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCALAR_EQUIVALENCE_AXIOM__SUPER_SCALAR = eINSTANCE.getScalarEquivalenceAxiom_SuperScalar();

		/**
		 * The meta object literal for the '<em><b>Owning Scalar</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCALAR_EQUIVALENCE_AXIOM__OWNING_SCALAR = eINSTANCE.getScalarEquivalenceAxiom_OwningScalar();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALAR_EQUIVALENCE_AXIOM__LENGTH = eINSTANCE.getScalarEquivalenceAxiom_Length();

		/**
		 * The meta object literal for the '<em><b>Min Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALAR_EQUIVALENCE_AXIOM__MIN_LENGTH = eINSTANCE.getScalarEquivalenceAxiom_MinLength();

		/**
		 * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALAR_EQUIVALENCE_AXIOM__MAX_LENGTH = eINSTANCE.getScalarEquivalenceAxiom_MaxLength();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALAR_EQUIVALENCE_AXIOM__PATTERN = eINSTANCE.getScalarEquivalenceAxiom_Pattern();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALAR_EQUIVALENCE_AXIOM__LANGUAGE = eINSTANCE.getScalarEquivalenceAxiom_Language();

		/**
		 * The meta object literal for the '<em><b>Min Inclusive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCALAR_EQUIVALENCE_AXIOM__MIN_INCLUSIVE = eINSTANCE.getScalarEquivalenceAxiom_MinInclusive();

		/**
		 * The meta object literal for the '<em><b>Min Exclusive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCALAR_EQUIVALENCE_AXIOM__MIN_EXCLUSIVE = eINSTANCE.getScalarEquivalenceAxiom_MinExclusive();

		/**
		 * The meta object literal for the '<em><b>Max Inclusive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCALAR_EQUIVALENCE_AXIOM__MAX_INCLUSIVE = eINSTANCE.getScalarEquivalenceAxiom_MaxInclusive();

		/**
		 * The meta object literal for the '<em><b>Max Exclusive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCALAR_EQUIVALENCE_AXIOM__MAX_EXCLUSIVE = eINSTANCE.getScalarEquivalenceAxiom_MaxExclusive();

		/**
		 * The meta object literal for the '<em><b>Get Sub Scalar</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCALAR_EQUIVALENCE_AXIOM___GET_SUB_SCALAR = eINSTANCE.getScalarEquivalenceAxiom__GetSubScalar();

		/**
		 * The meta object literal for the '<em><b>Get Characterized Term</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCALAR_EQUIVALENCE_AXIOM___GET_CHARACTERIZED_TERM = eINSTANCE.getScalarEquivalenceAxiom__GetCharacterizedTerm();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.PropertyEquivalenceAxiomImpl <em>Property Equivalence Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.PropertyEquivalenceAxiomImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getPropertyEquivalenceAxiom()
		 * @generated
		 */
		EClass PROPERTY_EQUIVALENCE_AXIOM = eINSTANCE.getPropertyEquivalenceAxiom();

		/**
		 * The meta object literal for the '<em><b>Super Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_EQUIVALENCE_AXIOM__SUPER_PROPERTY = eINSTANCE.getPropertyEquivalenceAxiom_SuperProperty();

		/**
		 * The meta object literal for the '<em><b>Owning Property</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_EQUIVALENCE_AXIOM__OWNING_PROPERTY = eINSTANCE.getPropertyEquivalenceAxiom_OwningProperty();

		/**
		 * The meta object literal for the '<em><b>Get Sub Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_EQUIVALENCE_AXIOM___GET_SUB_PROPERTY = eINSTANCE.getPropertyEquivalenceAxiom__GetSubProperty();

		/**
		 * The meta object literal for the '<em><b>Get Characterized Term</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_EQUIVALENCE_AXIOM___GET_CHARACTERIZED_TERM = eINSTANCE.getPropertyEquivalenceAxiom__GetCharacterizedTerm();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.PropertyRangeRestrictionAxiomImpl <em>Property Range Restriction Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.PropertyRangeRestrictionAxiomImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getPropertyRangeRestrictionAxiom()
		 * @generated
		 */
		EClass PROPERTY_RANGE_RESTRICTION_AXIOM = eINSTANCE.getPropertyRangeRestrictionAxiom();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_RANGE_RESTRICTION_AXIOM__KIND = eINSTANCE.getPropertyRangeRestrictionAxiom_Kind();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE = eINSTANCE.getPropertyRangeRestrictionAxiom_Range();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.PropertyCardinalityRestrictionAxiomImpl <em>Property Cardinality Restriction Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.PropertyCardinalityRestrictionAxiomImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getPropertyCardinalityRestrictionAxiom()
		 * @generated
		 */
		EClass PROPERTY_CARDINALITY_RESTRICTION_AXIOM = eINSTANCE.getPropertyCardinalityRestrictionAxiom();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_CARDINALITY_RESTRICTION_AXIOM__KIND = eINSTANCE.getPropertyCardinalityRestrictionAxiom_Kind();

		/**
		 * The meta object literal for the '<em><b>Cardinality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_CARDINALITY_RESTRICTION_AXIOM__CARDINALITY = eINSTANCE.getPropertyCardinalityRestrictionAxiom_Cardinality();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE = eINSTANCE.getPropertyCardinalityRestrictionAxiom_Range();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.PropertyValueRestrictionAxiomImpl <em>Property Value Restriction Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.PropertyValueRestrictionAxiomImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getPropertyValueRestrictionAxiom()
		 * @generated
		 */
		EClass PROPERTY_VALUE_RESTRICTION_AXIOM = eINSTANCE.getPropertyValueRestrictionAxiom();

		/**
		 * The meta object literal for the '<em><b>Literal Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_VALUE_RESTRICTION_AXIOM__LITERAL_VALUE = eINSTANCE.getPropertyValueRestrictionAxiom_LiteralValue();

		/**
		 * The meta object literal for the '<em><b>Contained Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_VALUE_RESTRICTION_AXIOM__CONTAINED_VALUE = eINSTANCE.getPropertyValueRestrictionAxiom_ContainedValue();

		/**
		 * The meta object literal for the '<em><b>Referenced Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_VALUE_RESTRICTION_AXIOM__REFERENCED_VALUE = eINSTANCE.getPropertyValueRestrictionAxiom_ReferencedValue();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_VALUE_RESTRICTION_AXIOM___GET_VALUE = eINSTANCE.getPropertyValueRestrictionAxiom__GetValue();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.PropertySelfRestrictionAxiomImpl <em>Property Self Restriction Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.PropertySelfRestrictionAxiomImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getPropertySelfRestrictionAxiom()
		 * @generated
		 */
		EClass PROPERTY_SELF_RESTRICTION_AXIOM = eINSTANCE.getPropertySelfRestrictionAxiom();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.TypeAssertionImpl <em>Type Assertion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.TypeAssertionImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getTypeAssertion()
		 * @generated
		 */
		EClass TYPE_ASSERTION = eINSTANCE.getTypeAssertion();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_ASSERTION__TYPE = eINSTANCE.getTypeAssertion_Type();

		/**
		 * The meta object literal for the '<em><b>Owning Instance</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_ASSERTION__OWNING_INSTANCE = eINSTANCE.getTypeAssertion_OwningInstance();

		/**
		 * The meta object literal for the '<em><b>Get Subject</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_ASSERTION___GET_SUBJECT = eINSTANCE.getTypeAssertion__GetSubject();

		/**
		 * The meta object literal for the '<em><b>Get Objects</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_ASSERTION___GET_OBJECTS = eINSTANCE.getTypeAssertion__GetObjects();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.PropertyValueAssertionImpl <em>Property Value Assertion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.PropertyValueAssertionImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getPropertyValueAssertion()
		 * @generated
		 */
		EClass PROPERTY_VALUE_ASSERTION = eINSTANCE.getPropertyValueAssertion();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_VALUE_ASSERTION__PROPERTY = eINSTANCE.getPropertyValueAssertion_Property();

		/**
		 * The meta object literal for the '<em><b>Literal Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_VALUE_ASSERTION__LITERAL_VALUE = eINSTANCE.getPropertyValueAssertion_LiteralValue();

		/**
		 * The meta object literal for the '<em><b>Contained Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE = eINSTANCE.getPropertyValueAssertion_ContainedValue();

		/**
		 * The meta object literal for the '<em><b>Referenced Value</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_VALUE_ASSERTION__REFERENCED_VALUE = eINSTANCE.getPropertyValueAssertion_ReferencedValue();

		/**
		 * The meta object literal for the '<em><b>Owning Instance</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE = eINSTANCE.getPropertyValueAssertion_OwningInstance();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_VALUE_ASSERTION___GET_VALUE = eINSTANCE.getPropertyValueAssertion__GetValue();

		/**
		 * The meta object literal for the '<em><b>Get Subject</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_VALUE_ASSERTION___GET_SUBJECT = eINSTANCE.getPropertyValueAssertion__GetSubject();

		/**
		 * The meta object literal for the '<em><b>Get Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_VALUE_ASSERTION___GET_OBJECT = eINSTANCE.getPropertyValueAssertion__GetObject();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.UnaryPredicateImpl <em>Unary Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.UnaryPredicateImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getUnaryPredicate()
		 * @generated
		 */
		EClass UNARY_PREDICATE = eINSTANCE.getUnaryPredicate();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_PREDICATE__ARGUMENT = eINSTANCE.getUnaryPredicate_Argument();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.BinaryPredicateImpl <em>Binary Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.BinaryPredicateImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getBinaryPredicate()
		 * @generated
		 */
		EClass BINARY_PREDICATE = eINSTANCE.getBinaryPredicate();

		/**
		 * The meta object literal for the '<em><b>Argument1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_PREDICATE__ARGUMENT1 = eINSTANCE.getBinaryPredicate_Argument1();

		/**
		 * The meta object literal for the '<em><b>Argument2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_PREDICATE__ARGUMENT2 = eINSTANCE.getBinaryPredicate_Argument2();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.BuiltInPredicateImpl <em>Built In Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.BuiltInPredicateImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getBuiltInPredicate()
		 * @generated
		 */
		EClass BUILT_IN_PREDICATE = eINSTANCE.getBuiltInPredicate();

		/**
		 * The meta object literal for the '<em><b>Built In</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUILT_IN_PREDICATE__BUILT_IN = eINSTANCE.getBuiltInPredicate_BuiltIn();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUILT_IN_PREDICATE__ARGUMENTS = eINSTANCE.getBuiltInPredicate_Arguments();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.TypePredicateImpl <em>Type Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.TypePredicateImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getTypePredicate()
		 * @generated
		 */
		EClass TYPE_PREDICATE = eINSTANCE.getTypePredicate();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_PREDICATE__TYPE = eINSTANCE.getTypePredicate_Type();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.RelationEntityPredicateImpl <em>Relation Entity Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.RelationEntityPredicateImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getRelationEntityPredicate()
		 * @generated
		 */
		EClass RELATION_ENTITY_PREDICATE = eINSTANCE.getRelationEntityPredicate();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_ENTITY_PREDICATE__TYPE = eINSTANCE.getRelationEntityPredicate_Type();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.PropertyPredicateImpl <em>Property Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.PropertyPredicateImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getPropertyPredicate()
		 * @generated
		 */
		EClass PROPERTY_PREDICATE = eINSTANCE.getPropertyPredicate();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_PREDICATE__PROPERTY = eINSTANCE.getPropertyPredicate_Property();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.SameAsPredicateImpl <em>Same As Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.SameAsPredicateImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getSameAsPredicate()
		 * @generated
		 */
		EClass SAME_AS_PREDICATE = eINSTANCE.getSameAsPredicate();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.DifferentFromPredicateImpl <em>Different From Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.DifferentFromPredicateImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDifferentFromPredicate()
		 * @generated
		 */
		EClass DIFFERENT_FROM_PREDICATE = eINSTANCE.getDifferentFromPredicate();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.QuotedLiteralImpl <em>Quoted Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.QuotedLiteralImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getQuotedLiteral()
		 * @generated
		 */
		EClass QUOTED_LITERAL = eINSTANCE.getQuotedLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUOTED_LITERAL__VALUE = eINSTANCE.getQuotedLiteral_Value();

		/**
		 * The meta object literal for the '<em><b>Lang Tag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUOTED_LITERAL__LANG_TAG = eINSTANCE.getQuotedLiteral_LangTag();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUOTED_LITERAL__TYPE = eINSTANCE.getQuotedLiteral_Type();

		/**
		 * The meta object literal for the '<em><b>Get Lexical Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation QUOTED_LITERAL___GET_LEXICAL_VALUE = eINSTANCE.getQuotedLiteral__GetLexicalValue();

		/**
		 * The meta object literal for the '<em><b>Get Type Iri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation QUOTED_LITERAL___GET_TYPE_IRI = eINSTANCE.getQuotedLiteral__GetTypeIri();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.IntegerLiteralImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getIntegerLiteral()
		 * @generated
		 */
		EClass INTEGER_LITERAL = eINSTANCE.getIntegerLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL__VALUE = eINSTANCE.getIntegerLiteral_Value();

		/**
		 * The meta object literal for the '<em><b>Get Type Iri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INTEGER_LITERAL___GET_TYPE_IRI = eINSTANCE.getIntegerLiteral__GetTypeIri();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.DecimalLiteralImpl <em>Decimal Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.DecimalLiteralImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDecimalLiteral()
		 * @generated
		 */
		EClass DECIMAL_LITERAL = eINSTANCE.getDecimalLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECIMAL_LITERAL__VALUE = eINSTANCE.getDecimalLiteral_Value();

		/**
		 * The meta object literal for the '<em><b>Get Type Iri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DECIMAL_LITERAL___GET_TYPE_IRI = eINSTANCE.getDecimalLiteral__GetTypeIri();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.DoubleLiteralImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDoubleLiteral()
		 * @generated
		 */
		EClass DOUBLE_LITERAL = eINSTANCE.getDoubleLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_LITERAL__VALUE = eINSTANCE.getDoubleLiteral_Value();

		/**
		 * The meta object literal for the '<em><b>Get Type Iri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOUBLE_LITERAL___GET_TYPE_IRI = eINSTANCE.getDoubleLiteral__GetTypeIri();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.BooleanLiteralImpl
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getBooleanLiteral()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL__VALUE = eINSTANCE.getBooleanLiteral_Value();

		/**
		 * The meta object literal for the '<em><b>Is Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOOLEAN_LITERAL___IS_VALUE = eINSTANCE.getBooleanLiteral__IsValue();

		/**
		 * The meta object literal for the '<em><b>Get Type Iri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOOLEAN_LITERAL___GET_TYPE_IRI = eINSTANCE.getBooleanLiteral__GetTypeIri();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.SeparatorKind <em>Separator Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.SeparatorKind
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getSeparatorKind()
		 * @generated
		 */
		EEnum SEPARATOR_KIND = eINSTANCE.getSeparatorKind();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.RangeRestrictionKind <em>Range Restriction Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.RangeRestrictionKind
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getRangeRestrictionKind()
		 * @generated
		 */
		EEnum RANGE_RESTRICTION_KIND = eINSTANCE.getRangeRestrictionKind();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.CardinalityRestrictionKind <em>Cardinality Restriction Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.CardinalityRestrictionKind
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getCardinalityRestrictionKind()
		 * @generated
		 */
		EEnum CARDINALITY_RESTRICTION_KIND = eINSTANCE.getCardinalityRestrictionKind();

		/**
		 * The meta object literal for the '{@link io.opencaesar.oml.ImportKind <em>Import Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.ImportKind
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getImportKind()
		 * @generated
		 */
		EEnum IMPORT_KIND = eINSTANCE.getImportKind();

		/**
		 * The meta object literal for the '<em>Unsigned Int</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getUnsignedInt()
		 * @generated
		 */
		EDataType UNSIGNED_INT = eINSTANCE.getUnsignedInt();

		/**
		 * The meta object literal for the '<em>Unsigned Integer</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Integer
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getUnsignedInteger()
		 * @generated
		 */
		EDataType UNSIGNED_INTEGER = eINSTANCE.getUnsignedInteger();

		/**
		 * The meta object literal for the '<em>Decimal</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.math.BigDecimal
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDecimal()
		 * @generated
		 */
		EDataType DECIMAL = eINSTANCE.getDecimal();

		/**
		 * The meta object literal for the '<em>Double</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Double
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getDouble()
		 * @generated
		 */
		EDataType DOUBLE = eINSTANCE.getDouble();

		/**
		 * The meta object literal for the '<em>ID</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getID()
		 * @generated
		 */
		EDataType ID = eINSTANCE.getID();

		/**
		 * The meta object literal for the '<em>Namespace</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see io.opencaesar.oml.impl.OmlPackageImpl#getNamespace()
		 * @generated
		 */
		EDataType NAMESPACE = eINSTANCE.getNamespace();

	}

} //OmlPackage
