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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * PropertyRestrictionAxiom is an [=Axiom=] specified on a [=Entity=] that places some restriction on the value of a [=SemanticProperty=]
 * in the context of the entity.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.PropertyRestrictionAxiom#getProperty <em>Property</em>}</li>
 *   <li>{@link io.opencaesar.oml.PropertyRestrictionAxiom#getOwningEntity <em>Owning Entity</em>}</li>
 *   <li>{@link io.opencaesar.oml.PropertyRestrictionAxiom#getOwningAxiom <em>Owning Axiom</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getPropertyRestrictionAxiom()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Axioms'"
 * @generated
 */
public interface PropertyRestrictionAxiom extends Axiom {
	/**
	 * Returns the value of the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The restricted property specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Property</em>' reference.
	 * @see #setProperty(SemanticProperty)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyRestrictionAxiom_Property()
	 * @model required="true"
	 * @generated
	 */
	SemanticProperty getProperty();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyRestrictionAxiom#getProperty <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(SemanticProperty value);

	/**
	 * Returns the value of the '<em><b>Owning Entity</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.Entity#getOwnedPropertyRestrictions <em>Owned Property Restrictions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The owning entity specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Entity</em>' container reference.
	 * @see #setOwningEntity(Entity)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyRestrictionAxiom_OwningEntity()
	 * @see io.opencaesar.oml.Entity#getOwnedPropertyRestrictions
	 * @model opposite="ownedPropertyRestrictions" transient="false"
	 * @generated
	 */
	Entity getOwningEntity();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyRestrictionAxiom#getOwningEntity <em>Owning Entity</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Entity</em>' container reference.
	 * @see #getOwningEntity()
	 * @generated
	 */
	void setOwningEntity(Entity value);

	/**
	 * Returns the value of the '<em><b>Owning Axiom</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.EntityEquivalenceAxiom#getOwnedPropertyRestrictions <em>Owned Property Restrictions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The owning entity equivalence axiom specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Axiom</em>' container reference.
	 * @see #setOwningAxiom(EntityEquivalenceAxiom)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyRestrictionAxiom_OwningAxiom()
	 * @see io.opencaesar.oml.EntityEquivalenceAxiom#getOwnedPropertyRestrictions
	 * @model opposite="ownedPropertyRestrictions" transient="false"
	 * @generated
	 */
	EntityEquivalenceAxiom getOwningAxiom();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyRestrictionAxiom#getOwningAxiom <em>Owning Axiom</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Axiom</em>' container reference.
	 * @see #getOwningAxiom()
	 * @generated
	 */
	void setOwningAxiom(EntityEquivalenceAxiom value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the restricting domain of the given property restriction axiom
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Entity getRestrictingDomain();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Entity getCharacterizedTerm();

} // PropertyRestrictionAxiom
