/**
 * 
 * Copyright 2019-2022 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	 http://www.apache.org/licenses/LICENSE-2.0
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
 * A representation of the model object '<em><b>Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Instance is an element that represents a instance of one or more [=Entities=].
 * It can assert a set of values for those entities' [=properties=].
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.Instance#getOwnedPropertyValues <em>Owned Property Values</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getInstance()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Instances'"
 * @generated
 */
public interface Instance extends Element {
	/**
	 * Returns the value of the '<em><b>Owned Property Values</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.PropertyValueAssertion}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.PropertyValueAssertion#getOwningInstance <em>Owning Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property value assertions owned by this instance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Property Values</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getInstance_OwnedPropertyValues()
	 * @see io.opencaesar.oml.PropertyValueAssertion#getOwningInstance
	 * @model opposite="owningInstance" containment="true"
	 * @generated
	 */
	EList<PropertyValueAssertion> getOwnedPropertyValues();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the instance's types
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<Entity> getTypes();

} // Instance
