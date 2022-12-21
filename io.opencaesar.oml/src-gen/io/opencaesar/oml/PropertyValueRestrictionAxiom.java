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
 * A representation of the model object '<em><b>Property Value Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * PropertyValueRestrictionAxiom is a property restriction axiom that restricts a property in a given domain to a specific
 * value. The value is either a literal value in the case of a scalar property, a contained (structure) instance value in the case of
 * a structured property, or a referenced (named) instance value in the case of a relation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.PropertyValueRestrictionAxiom#getLiteralValue <em>Literal Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.PropertyValueRestrictionAxiom#getStructureInstanceValue <em>Structure Instance Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.PropertyValueRestrictionAxiom#getNamedInstanceValue <em>Named Instance Value</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getPropertyValueRestrictionAxiom()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Axioms'"
 * @generated
 */
public interface PropertyValueRestrictionAxiom extends PropertyRestrictionAxiom {
	/**
	 * Returns the value of the '<em><b>Literal Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A restricted literal value (of a scalar property)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Literal Value</em>' containment reference.
	 * @see #setLiteralValue(Literal)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyValueRestrictionAxiom_LiteralValue()
	 * @model containment="true"
	 * @generated
	 */
	Literal getLiteralValue();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyValueRestrictionAxiom#getLiteralValue <em>Literal Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal Value</em>' containment reference.
	 * @see #getLiteralValue()
	 * @generated
	 */
	void setLiteralValue(Literal value);

	/**
	 * Returns the value of the '<em><b>Structure Instance Value</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.StructureInstance#getOwningAxiom <em>Owning Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A restricted structure instance value (of a structured property)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Structure Instance Value</em>' containment reference.
	 * @see #setStructureInstanceValue(StructureInstance)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyValueRestrictionAxiom_StructureInstanceValue()
	 * @see io.opencaesar.oml.StructureInstance#getOwningAxiom
	 * @model opposite="owningAxiom" containment="true"
	 * @generated
	 */
	StructureInstance getStructureInstanceValue();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyValueRestrictionAxiom#getStructureInstanceValue <em>Structure Instance Value</em>}' containment reference.
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
	 * A restricted named instance value (of a relation)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Named Instance Value</em>' reference.
	 * @see #setNamedInstanceValue(NamedInstance)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyValueRestrictionAxiom_NamedInstanceValue()
	 * @model
	 * @generated
	 */
	NamedInstance getNamedInstanceValue();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyValueRestrictionAxiom#getNamedInstanceValue <em>Named Instance Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Named Instance Value</em>' reference.
	 * @see #getNamedInstanceValue()
	 * @generated
	 */
	void setNamedInstanceValue(NamedInstance value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the restricted value
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Element getValue();

} // PropertyValueRestrictionAxiom
