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
 * A representation of the model object '<em><b>Concept Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ConceptInstance is a [=NamedInstance=] that can be typed by [=Concepts=] or [=Aspects=].
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.ConceptInstance#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getConceptInstance()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Instances'"
 * @generated
 */
public interface ConceptInstance extends NamedInstance {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A ref to another concept instance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(ConceptInstance)
	 * @see io.opencaesar.oml.OmlPackage#getConceptInstance_Ref()
	 * @model
	 * @generated
	 */
	ConceptInstance getRef();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.ConceptInstance#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(ConceptInstance value);

} // ConceptInstance
