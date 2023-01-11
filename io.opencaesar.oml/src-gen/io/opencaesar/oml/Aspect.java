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
 * A representation of the model object '<em><b>Aspect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Aspect is an entity that represents a concern that cuts across multiple entities. It does not directly
 * classify instances, but it does so indirectly by being specialized by other entities. However, an aspect can only
 * specialize other aspects.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.Aspect#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getAspect()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Types'"
 * @generated
 */
public interface Aspect extends Entity {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A ref to another aspect
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(Aspect)
	 * @see io.opencaesar.oml.OmlPackage#getAspect_Ref()
	 * @model
	 * @generated
	 */
	Aspect getRef();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Aspect#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(Aspect value);

} // Aspect
