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
 * A representation of the model object '<em><b>Property Value Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * PropertyValueAssertion is an assertion that specifies a value for a property on an instance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.PropertyValueAssertion#getOwningInstance <em>Owning Instance</em>}</li>
 *   <li>{@link io.opencaesar.oml.PropertyValueAssertion#getOwningReference <em>Owning Reference</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getPropertyValueAssertion()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Assertions'"
 * @generated
 */
public interface PropertyValueAssertion extends Assertion {
	/**
	 * Returns the value of the '<em><b>Owning Instance</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.Instance#getOwnedPropertyValues <em>Owned Property Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The instance that this property value assertion is about
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Instance</em>' container reference.
	 * @see #setOwningInstance(Instance)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyValueAssertion_OwningInstance()
	 * @see io.opencaesar.oml.Instance#getOwnedPropertyValues
	 * @model opposite="ownedPropertyValues" transient="false"
	 * @generated
	 */
	Instance getOwningInstance();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyValueAssertion#getOwningInstance <em>Owning Instance</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Instance</em>' container reference.
	 * @see #getOwningInstance()
	 * @generated
	 */
	void setOwningInstance(Instance value);

	/**
	 * Returns the value of the '<em><b>Owning Reference</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.NamedInstanceReference#getOwnedPropertyValues <em>Owned Property Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The reference to an instance that this property value assertion is about
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Reference</em>' container reference.
	 * @see #setOwningReference(NamedInstanceReference)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyValueAssertion_OwningReference()
	 * @see io.opencaesar.oml.NamedInstanceReference#getOwnedPropertyValues
	 * @model opposite="ownedPropertyValues" transient="false"
	 * @generated
	 */
	NamedInstanceReference getOwningReference();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyValueAssertion#getOwningReference <em>Owning Reference</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Reference</em>' container reference.
	 * @see #getOwningReference()
	 * @generated
	 */
	void setOwningReference(NamedInstanceReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the property referenced by this assertion
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	SemanticProperty getProperty();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the value specified by this assertion
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Element getValue();

} // PropertyValueAssertion
