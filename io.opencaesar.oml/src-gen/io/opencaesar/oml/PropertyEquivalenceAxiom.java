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
 * A representation of the model object '<em><b>Property Equivalence Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * PropertyEquivalenceAxiom is an [=Axiom=] specified on a subject [=Property=] that states that it is equivalent
 * to another property. This axiom implies that the equivalent properties are super properties of the subject property
 * (and vice versa).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.PropertyEquivalenceAxiom#getSuperProperty <em>Super Property</em>}</li>
 *   <li>{@link io.opencaesar.oml.PropertyEquivalenceAxiom#getOwningProperty <em>Owning Property</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getPropertyEquivalenceAxiom()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Axioms'"
 * @generated
 */
public interface PropertyEquivalenceAxiom extends Axiom {
	/**
	 * Returns the value of the '<em><b>Super Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The super property specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Super Property</em>' reference.
	 * @see #setSuperProperty(Property)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyEquivalenceAxiom_SuperProperty()
	 * @model required="true"
	 * @generated
	 */
	Property getSuperProperty();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyEquivalenceAxiom#getSuperProperty <em>Super Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Property</em>' reference.
	 * @see #getSuperProperty()
	 * @generated
	 */
	void setSuperProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Owning Property</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.SpecializableProperty#getOwnedEquivalences <em>Owned Equivalences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The owning property specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Property</em>' container reference.
	 * @see #setOwningProperty(SpecializableProperty)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyEquivalenceAxiom_OwningProperty()
	 * @see io.opencaesar.oml.SpecializableProperty#getOwnedEquivalences
	 * @model opposite="ownedEquivalences" transient="false"
	 * @generated
	 */
	SpecializableProperty getOwningProperty();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyEquivalenceAxiom#getOwningProperty <em>Owning Property</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Property</em>' container reference.
	 * @see #getOwningProperty()
	 * @generated
	 */
	void setOwningProperty(SpecializableProperty value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the sub property of this axiom
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Property getSubProperty();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Property getCharacterizedTerm();

} // PropertyEquivalenceAxiom
