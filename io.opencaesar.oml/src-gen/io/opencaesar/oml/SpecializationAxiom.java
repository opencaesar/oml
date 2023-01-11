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
 * A representation of the model object '<em><b>Specialization Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * SpecializationAxiom is an axiom specified on a specializing term that states that one specializable term specializes another.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.SpecializationAxiom#getSpecializedTerm <em>Specialized Term</em>}</li>
 *   <li>{@link io.opencaesar.oml.SpecializationAxiom#getOwningTerm <em>Owning Term</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getSpecializationAxiom()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Axioms'"
 * @generated
 */
public interface SpecializationAxiom extends Axiom {
	/**
	 * Returns the value of the '<em><b>Specialized Term</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The specialized term specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Specialized Term</em>' reference.
	 * @see #setSpecializedTerm(SpecializableTerm)
	 * @see io.opencaesar.oml.OmlPackage#getSpecializationAxiom_SpecializedTerm()
	 * @model required="true"
	 * @generated
	 */
	SpecializableTerm getSpecializedTerm();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.SpecializationAxiom#getSpecializedTerm <em>Specialized Term</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specialized Term</em>' reference.
	 * @see #getSpecializedTerm()
	 * @generated
	 */
	void setSpecializedTerm(SpecializableTerm value);

	/**
	 * Returns the value of the '<em><b>Owning Term</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.SpecializableTerm#getOwnedSpecializations <em>Owned Specializations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The specializing term specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Term</em>' container reference.
	 * @see #setOwningTerm(SpecializableTerm)
	 * @see io.opencaesar.oml.OmlPackage#getSpecializationAxiom_OwningTerm()
	 * @see io.opencaesar.oml.SpecializableTerm#getOwnedSpecializations
	 * @model opposite="ownedSpecializations" transient="false"
	 * @generated
	 */
	SpecializableTerm getOwningTerm();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.SpecializationAxiom#getOwningTerm <em>Owning Term</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Term</em>' container reference.
	 * @see #getOwningTerm()
	 * @generated
	 */
	void setOwningTerm(SpecializableTerm value);

} // SpecializationAxiom
