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
 * A representation of the model object '<em><b>Instance Enumeration Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * InstanceEnumerationAxiom is an [=Axiom=] specified on a [=Concept=] that states that it classifies an enumerated set of [=instances=].
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.InstanceEnumerationAxiom#getInstances <em>Instances</em>}</li>
 *   <li>{@link io.opencaesar.oml.InstanceEnumerationAxiom#getOwningConcept <em>Owning Concept</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getInstanceEnumerationAxiom()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Axioms'"
 * @generated
 */
public interface InstanceEnumerationAxiom extends Axiom {
	/**
	 * Returns the value of the '<em><b>Instances</b></em>' reference list.
	 * The list contents are of type {@link io.opencaesar.oml.ConceptInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of enumerated instances specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Instances</em>' reference list.
	 * @see io.opencaesar.oml.OmlPackage#getInstanceEnumerationAxiom_Instances()
	 * @model required="true"
	 * @generated
	 */
	EList<ConceptInstance> getInstances();

	/**
	 * Returns the value of the '<em><b>Owning Concept</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.Concept#getOwnedEnumeration <em>Owned Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The owning concept specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Concept</em>' container reference.
	 * @see #setOwningConcept(Concept)
	 * @see io.opencaesar.oml.OmlPackage#getInstanceEnumerationAxiom_OwningConcept()
	 * @see io.opencaesar.oml.Concept#getOwnedEnumeration
	 * @model opposite="ownedEnumeration" transient="false"
	 * @generated
	 */
	Concept getOwningConcept();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.InstanceEnumerationAxiom#getOwningConcept <em>Owning Concept</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Concept</em>' container reference.
	 * @see #getOwningConcept()
	 * @generated
	 */
	void setOwningConcept(Concept value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the concept that defines the given enumeration axiom
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Concept getEnumeratedConcept();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Concept getCharacterizedTerm();

} // InstanceEnumerationAxiom
