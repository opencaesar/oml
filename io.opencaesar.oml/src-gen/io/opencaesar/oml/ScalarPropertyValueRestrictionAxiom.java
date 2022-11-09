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
 * A representation of the model object '<em><b>Scalar Property Value Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ScalarPropertyValueRestrictionAxiom is a scalar property restriction axiom that restricts the value of the property
 * that has the restricting classifier as a domain to a specific literal.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.ScalarPropertyValueRestrictionAxiom#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getScalarPropertyValueRestrictionAxiom()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Axioms'"
 * @generated
 */
public interface ScalarPropertyValueRestrictionAxiom extends ScalarPropertyRestrictionAxiom {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The literal specified as a restricted property value by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(Literal)
	 * @see io.opencaesar.oml.OmlPackage#getScalarPropertyValueRestrictionAxiom_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Literal getValue();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.ScalarPropertyValueRestrictionAxiom#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Literal value);

} // ScalarPropertyValueRestrictionAxiom
