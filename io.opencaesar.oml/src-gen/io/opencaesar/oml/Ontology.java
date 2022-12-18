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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ontology</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Ontology is an identified element that represents a namespace for its members. The namespace is defined
 * by a globally unique namespace (an iri and a namespace separator that can be # or /) and can be abbreviated with a prefix.
 * An ontology can import other ontologies, and can make statements about its own as well as imported members.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.Ontology#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link io.opencaesar.oml.Ontology#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link io.opencaesar.oml.Ontology#getOwnedImports <em>Owned Imports</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getOntology()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Elements'"
 * @generated
 */
public interface Ontology extends IdentifiedElement {
	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The globally unique namespace of this ontology
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(String)
	 * @see io.opencaesar.oml.OmlPackage#getOntology_Namespace()
	 * @model unique="false" dataType="io.opencaesar.oml.Namespace" required="true"
	 * @generated
	 */
	String getNamespace();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Ontology#getNamespace <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' attribute.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(String value);

	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The prefix of this ontology's namespace
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see #setPrefix(String)
	 * @see io.opencaesar.oml.OmlPackage#getOntology_Prefix()
	 * @model unique="false" dataType="io.opencaesar.oml.ID" required="true"
	 * @generated
	 */
	String getPrefix();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Ontology#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Owned Imports</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.Import}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.Import#getOwningOntology <em>Owning Ontology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of imports this ontology has to other ontologies
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Imports</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getOntology_OwnedImports()
	 * @see io.opencaesar.oml.Import#getOwningOntology
	 * @model opposite="owningOntology" containment="true"
	 * @generated
	 */
	EList<Import> getOwnedImports();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the namespace's iri
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	String getIri();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the namespace's separator char
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	SeparatorKind getSeparator();

} // Ontology
