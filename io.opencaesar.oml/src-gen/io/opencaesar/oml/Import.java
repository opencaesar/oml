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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Import is an element owned by an ontology to specify that it imports another ontology.
 * The imported ontology is specified by its IRI, and optionally a separator character and local prefix
 * if members of the imported ontology will also be referenced by the importing ontology
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.Import#getKind <em>Kind</em>}</li>
 *   <li>{@link io.opencaesar.oml.Import#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link io.opencaesar.oml.Import#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link io.opencaesar.oml.Import#getOwningOntology <em>Owning Ontology</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getImport()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Elements'"
 * @generated
 */
public interface Import extends Element {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link io.opencaesar.oml.ImportKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The kind of this import
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see io.opencaesar.oml.ImportKind
	 * @see #setKind(ImportKind)
	 * @see io.opencaesar.oml.OmlPackage#getImport_Kind()
	 * @model unique="false" required="true"
	 * @generated
	 */
	ImportKind getKind();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Import#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see io.opencaesar.oml.ImportKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ImportKind value);

	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The namespace of the imported ontology
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(String)
	 * @see io.opencaesar.oml.OmlPackage#getImport_Namespace()
	 * @model unique="false" dataType="io.opencaesar.oml.Namespace" required="true"
	 * @generated
	 */
	String getNamespace();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Import#getNamespace <em>Namespace</em>}' attribute.
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
	 * The local prefix of the imported ontology's namespace
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see #setPrefix(String)
	 * @see io.opencaesar.oml.OmlPackage#getImport_Prefix()
	 * @model unique="false" dataType="io.opencaesar.oml.ID"
	 * @generated
	 */
	String getPrefix();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Import#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Owning Ontology</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.Ontology#getOwnedImports <em>Owned Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ontology that owns this import
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Ontology</em>' container reference.
	 * @see #setOwningOntology(Ontology)
	 * @see io.opencaesar.oml.OmlPackage#getImport_OwningOntology()
	 * @see io.opencaesar.oml.Ontology#getOwnedImports
	 * @model opposite="ownedImports" required="true" transient="false"
	 * @generated
	 */
	Ontology getOwningOntology();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Import#getOwningOntology <em>Owning Ontology</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Ontology</em>' container reference.
	 * @see #getOwningOntology()
	 * @generated
	 */
	void setOwningOntology(Ontology value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the import's iri
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	String getIri();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the import's separator char
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	SeparatorKind getSeparator();

} // Import
