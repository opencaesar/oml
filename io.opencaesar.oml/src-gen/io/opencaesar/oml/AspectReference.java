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
 * A representation of the model object '<em><b>Aspect Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * AspectReference is a reference to an aspect.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.AspectReference#getAspect <em>Aspect</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getAspectReference()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='References'"
 * @generated
 */
public interface AspectReference extends EntityReference {
	/**
	 * Returns the value of the '<em><b>Aspect</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The aspect referenced by this reference
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Aspect</em>' reference.
	 * @see #setAspect(Aspect)
	 * @see io.opencaesar.oml.OmlPackage#getAspectReference_Aspect()
	 * @model required="true"
	 * @generated
	 */
	Aspect getAspect();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.AspectReference#getAspect <em>Aspect</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aspect</em>' reference.
	 * @see #getAspect()
	 * @generated
	 */
	void setAspect(Aspect value);

} // AspectReference
