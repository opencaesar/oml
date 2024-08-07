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
 * A representation of the model object '<em><b>Property Value Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * PropertyValueAssertion is an [=Assertion=]  that specifies values for a [=property=] on an [=instance=]. The values are either
 * [=literal=] values, contained [=AnonymousInstance=] values, or referenced [=NamedInstance=] values.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.PropertyValueAssertion#getProperty <em>Property</em>}</li>
 *   <li>{@link io.opencaesar.oml.PropertyValueAssertion#getLiteralValues <em>Literal Values</em>}</li>
 *   <li>{@link io.opencaesar.oml.PropertyValueAssertion#getContainedValues <em>Contained Values</em>}</li>
 *   <li>{@link io.opencaesar.oml.PropertyValueAssertion#getReferencedValues <em>Referenced Values</em>}</li>
 *   <li>{@link io.opencaesar.oml.PropertyValueAssertion#getOwningInstance <em>Owning Instance</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getPropertyValueAssertion()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Assertions'"
 * @generated
 */
public interface PropertyValueAssertion extends Assertion {
	/**
	 * Returns the value of the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property referenced by this assertion
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Property</em>' reference.
	 * @see #setProperty(SemanticProperty)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyValueAssertion_Property()
	 * @model required="true"
	 * @generated
	 */
	SemanticProperty getProperty();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyValueAssertion#getProperty <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(SemanticProperty value);

	/**
	 * Returns the value of the '<em><b>Literal Values</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.Literal}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The literal values of this assertion
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Literal Values</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getPropertyValueAssertion_LiteralValues()
	 * @model containment="true"
	 * @generated
	 */
	EList<Literal> getLiteralValues();

	/**
	 * Returns the value of the '<em><b>Contained Values</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.AnonymousInstance}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.AnonymousInstance#getOwningAssertion <em>Owning Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The contained values of this assertion
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Contained Values</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getPropertyValueAssertion_ContainedValues()
	 * @see io.opencaesar.oml.AnonymousInstance#getOwningAssertion
	 * @model opposite="owningAssertion" containment="true"
	 * @generated
	 */
	EList<AnonymousInstance> getContainedValues();

	/**
	 * Returns the value of the '<em><b>Referenced Values</b></em>' reference list.
	 * The list contents are of type {@link io.opencaesar.oml.NamedInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referenced values of this assertion
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referenced Values</em>' reference list.
	 * @see io.opencaesar.oml.OmlPackage#getPropertyValueAssertion_ReferencedValues()
	 * @model
	 * @generated
	 */
	EList<NamedInstance> getReferencedValues();

	/**
	 * Returns the value of the '<em><b>Owning Instance</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.Instance#getOwnedPropertyValues <em>Owned Property Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The instance that owns this assertion
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the asserted values
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<Element> getValues();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the first asserted value of the annotation
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Element getValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the first literal value
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Literal getLiteralValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets the first literal value
	 * <!-- end-model-doc -->
	 * @model valueUnique="false"
	 * @generated
	 */
	void setLiteralValue(Literal value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the first contained value
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	AnonymousInstance getContainedValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets the first contained value
	 * <!-- end-model-doc -->
	 * @model valueUnique="false"
	 * @generated
	 */
	void setContainedValue(AnonymousInstance value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the first reference value
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	NamedInstance getReferencedValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets the first reference value
	 * <!-- end-model-doc -->
	 * @model valueUnique="false"
	 * @generated
	 */
	void setReferencedValue(NamedInstance value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Instance getSubject();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<Element> getObject();

} // PropertyValueAssertion
