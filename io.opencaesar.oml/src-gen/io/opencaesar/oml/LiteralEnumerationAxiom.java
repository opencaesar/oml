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
 * A representation of the model object '<em><b>Literal Enumeration Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * LiteralEnumerationAxiom is an axiom specified on a scalar that states that it classifies an enumerated set of literals.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.LiteralEnumerationAxiom#getLiterals <em>Literals</em>}</li>
 *   <li>{@link io.opencaesar.oml.LiteralEnumerationAxiom#getOwningScalar <em>Owning Scalar</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getLiteralEnumerationAxiom()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Axioms'"
 * @generated
 */
public interface LiteralEnumerationAxiom extends Axiom {
	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.Literal}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of enumerated literals specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getLiteralEnumerationAxiom_Literals()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Literal> getLiterals();

	/**
	 * Returns the value of the '<em><b>Owning Scalar</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.Scalar#getOwnedEnumeration <em>Owned Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The owning scalar specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Scalar</em>' container reference.
	 * @see #setOwningScalar(Scalar)
	 * @see io.opencaesar.oml.OmlPackage#getLiteralEnumerationAxiom_OwningScalar()
	 * @see io.opencaesar.oml.Scalar#getOwnedEnumeration
	 * @model opposite="ownedEnumeration" transient="false"
	 * @generated
	 */
	Scalar getOwningScalar();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.LiteralEnumerationAxiom#getOwningScalar <em>Owning Scalar</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Scalar</em>' container reference.
	 * @see #getOwningScalar()
	 * @generated
	 */
	void setOwningScalar(Scalar value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the scalar that defines the given enumeration axiom
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Scalar getEnumeratedScalar();

} // LiteralEnumerationAxiom
