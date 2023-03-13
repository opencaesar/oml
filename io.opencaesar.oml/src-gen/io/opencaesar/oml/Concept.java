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
 * A representation of the model object '<em><b>Concept</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Concept is a concrete entity that classifies a set of concept instances. It can also specialize other concepts and/or aspects.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.Concept#getRef <em>Ref</em>}</li>
 *   <li>{@link io.opencaesar.oml.Concept#getOwnedEnumeration <em>Owned Enumeration</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getConcept()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Types'"
 * @generated
 */
public interface Concept extends Entity {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A ref to another concept
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(Concept)
	 * @see io.opencaesar.oml.OmlPackage#getConcept_Ref()
	 * @model
	 * @generated
	 */
	Concept getRef();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Concept#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(Concept value);

	/**
	 * Returns the value of the '<em><b>Owned Enumeration</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.InstanceEnumerationAxiom#getOwningConcept <em>Owning Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An enumeration of instances of this concept
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Enumeration</em>' containment reference.
	 * @see #setOwnedEnumeration(InstanceEnumerationAxiom)
	 * @see io.opencaesar.oml.OmlPackage#getConcept_OwnedEnumeration()
	 * @see io.opencaesar.oml.InstanceEnumerationAxiom#getOwningConcept
	 * @model opposite="owningConcept" containment="true"
	 * @generated
	 */
	InstanceEnumerationAxiom getOwnedEnumeration();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Concept#getOwnedEnumeration <em>Owned Enumeration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Enumeration</em>' containment reference.
	 * @see #getOwnedEnumeration()
	 * @generated
	 */
	void setOwnedEnumeration(InstanceEnumerationAxiom value);

} // Concept
