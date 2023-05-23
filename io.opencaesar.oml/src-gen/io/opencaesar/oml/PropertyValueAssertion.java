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
 * PropertyValueAssertion is an [=Assertion=]  that specifies a value for a [=property=] on an [=instance=]. The value is either a [=literal=] value
 * in the case of a [=ScalarProperty=], a contained [=StructureInstance=] value in the case of a [=StructuredProperty=], or a reference to a
 * [=NamedInstance=] value in the case of a [=Relation=].
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.PropertyValueAssertion#getProperty <em>Property</em>}</li>
 *   <li>{@link io.opencaesar.oml.PropertyValueAssertion#getLiteralValue <em>Literal Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.PropertyValueAssertion#getStructureInstanceValue <em>Structure Instance Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.PropertyValueAssertion#getNamedInstanceValue <em>Named Instance Value</em>}</li>
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
	 * Returns the value of the '<em><b>Literal Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An asserted literal value of a scalar property
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Literal Value</em>' containment reference.
	 * @see #setLiteralValue(Literal)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyValueAssertion_LiteralValue()
	 * @model containment="true"
	 * @generated
	 */
	Literal getLiteralValue();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyValueAssertion#getLiteralValue <em>Literal Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal Value</em>' containment reference.
	 * @see #getLiteralValue()
	 * @generated
	 */
	void setLiteralValue(Literal value);

	/**
	 * Returns the value of the '<em><b>Structure Instance Value</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.StructureInstance#getOwningAssertion <em>Owning Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An asserted structure instance value of a structured property
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Structure Instance Value</em>' containment reference.
	 * @see #setStructureInstanceValue(StructureInstance)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyValueAssertion_StructureInstanceValue()
	 * @see io.opencaesar.oml.StructureInstance#getOwningAssertion
	 * @model opposite="owningAssertion" containment="true"
	 * @generated
	 */
	StructureInstance getStructureInstanceValue();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyValueAssertion#getStructureInstanceValue <em>Structure Instance Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Structure Instance Value</em>' containment reference.
	 * @see #getStructureInstanceValue()
	 * @generated
	 */
	void setStructureInstanceValue(StructureInstance value);

	/**
	 * Returns the value of the '<em><b>Named Instance Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An asserted named instance value of a relation
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Named Instance Value</em>' reference.
	 * @see #setNamedInstanceValue(NamedInstance)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyValueAssertion_NamedInstanceValue()
	 * @model
	 * @generated
	 */
	NamedInstance getNamedInstanceValue();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyValueAssertion#getNamedInstanceValue <em>Named Instance Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Named Instance Value</em>' reference.
	 * @see #getNamedInstanceValue()
	 * @generated
	 */
	void setNamedInstanceValue(NamedInstance value);

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the asserted value
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Element getValue();

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
	Element getObject();

} // PropertyValueAssertion
