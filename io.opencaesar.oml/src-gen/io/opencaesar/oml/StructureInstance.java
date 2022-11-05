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
 * A representation of the model object '<em><b>Structure Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * StructureInstance is an instance that can be typed by a structure. It is anonymous and gets assigned as
 * a value for structured properties, either as part of value restrictions on entities, or value assertions on instances.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.StructureInstance#getType <em>Type</em>}</li>
 *   <li>{@link io.opencaesar.oml.StructureInstance#getOwningAxiom <em>Owning Axiom</em>}</li>
 *   <li>{@link io.opencaesar.oml.StructureInstance#getOwningAssertion <em>Owning Assertion</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getStructureInstance()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Instances'"
 * @generated
 */
public interface StructureInstance extends Instance {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of this instance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Structure)
	 * @see io.opencaesar.oml.OmlPackage#getStructureInstance_Type()
	 * @model required="true"
	 * @generated
	 */
	Structure getType();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.StructureInstance#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Structure value);

	/**
	 * Returns the value of the '<em><b>Owning Axiom</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.StructuredPropertyValueRestrictionAxiom#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property value restriction axiom that assigns this instance as a restricted value
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Axiom</em>' container reference.
	 * @see #setOwningAxiom(StructuredPropertyValueRestrictionAxiom)
	 * @see io.opencaesar.oml.OmlPackage#getStructureInstance_OwningAxiom()
	 * @see io.opencaesar.oml.StructuredPropertyValueRestrictionAxiom#getValue
	 * @model opposite="value" transient="false"
	 * @generated
	 */
	StructuredPropertyValueRestrictionAxiom getOwningAxiom();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.StructureInstance#getOwningAxiom <em>Owning Axiom</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Axiom</em>' container reference.
	 * @see #getOwningAxiom()
	 * @generated
	 */
	void setOwningAxiom(StructuredPropertyValueRestrictionAxiom value);

	/**
	 * Returns the value of the '<em><b>Owning Assertion</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.StructuredPropertyValueAssertion#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property value assertion axiom that assigns this instance as a value
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Assertion</em>' container reference.
	 * @see #setOwningAssertion(StructuredPropertyValueAssertion)
	 * @see io.opencaesar.oml.OmlPackage#getStructureInstance_OwningAssertion()
	 * @see io.opencaesar.oml.StructuredPropertyValueAssertion#getValue
	 * @model opposite="value" transient="false"
	 * @generated
	 */
	StructuredPropertyValueAssertion getOwningAssertion();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.StructureInstance#getOwningAssertion <em>Owning Assertion</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Assertion</em>' container reference.
	 * @see #getOwningAssertion()
	 * @generated
	 */
	void setOwningAssertion(StructuredPropertyValueAssertion value);

} // StructureInstance
