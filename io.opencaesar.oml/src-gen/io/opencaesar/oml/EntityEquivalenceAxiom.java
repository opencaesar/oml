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
 * A representation of the model object '<em><b>Entity Equivalence Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * EntityEquivalenceAxiom is an [=Axiom=] specified on a subject [=Entity=] that states that it is equivalent to the intersection
 * of [=Entities=] and/or [=PropertyRestrictionAxioms=]. This axiom implies that the [=entities=] are super types of the subject entity.
 * It also implies that when an instance is classified by this intersection, then it follows that it is also classified by the
 * subject entity. Conversely, when an instance is classified by the subject entity, then it follows that it is also classified
 * by the intersection. In other words, this axiom enables bi-directional (or two-way) inferencing.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.EntityEquivalenceAxiom#getSuperEntities <em>Super Entities</em>}</li>
 *   <li>{@link io.opencaesar.oml.EntityEquivalenceAxiom#getOwnedPropertyRestrictions <em>Owned Property Restrictions</em>}</li>
 *   <li>{@link io.opencaesar.oml.EntityEquivalenceAxiom#getOwningEntity <em>Owning Entity</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getEntityEquivalenceAxiom()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Axioms'"
 * @generated
 */
public interface EntityEquivalenceAxiom extends Axiom {
	/**
	 * Returns the value of the '<em><b>Super Entities</b></em>' reference list.
	 * The list contents are of type {@link io.opencaesar.oml.Entity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The super entity specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Super Entities</em>' reference list.
	 * @see io.opencaesar.oml.OmlPackage#getEntityEquivalenceAxiom_SuperEntities()
	 * @model
	 * @generated
	 */
	EList<Entity> getSuperEntities();

	/**
	 * Returns the value of the '<em><b>Owned Property Restrictions</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.PropertyRestrictionAxiom}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.PropertyRestrictionAxiom#getOwningAxiom <em>Owning Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property restrictions specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Property Restrictions</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getEntityEquivalenceAxiom_OwnedPropertyRestrictions()
	 * @see io.opencaesar.oml.PropertyRestrictionAxiom#getOwningAxiom
	 * @model opposite="owningAxiom" containment="true"
	 * @generated
	 */
	EList<PropertyRestrictionAxiom> getOwnedPropertyRestrictions();

	/**
	 * Returns the value of the '<em><b>Owning Entity</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.Entity#getOwnedEquivalences <em>Owned Equivalences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The owning entity specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Entity</em>' container reference.
	 * @see #setOwningEntity(Entity)
	 * @see io.opencaesar.oml.OmlPackage#getEntityEquivalenceAxiom_OwningEntity()
	 * @see io.opencaesar.oml.Entity#getOwnedEquivalences
	 * @model opposite="ownedEquivalences" transient="false"
	 * @generated
	 */
	Entity getOwningEntity();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.EntityEquivalenceAxiom#getOwningEntity <em>Owning Entity</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Entity</em>' container reference.
	 * @see #getOwningEntity()
	 * @generated
	 */
	void setOwningEntity(Entity value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the sub entity of this axiom
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Entity getSubEntity();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Entity getCharacterizedTerm();

} // EntityEquivalenceAxiom
