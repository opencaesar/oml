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
 * A representation of the model object '<em><b>Key Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * KeyAxiom is an axiom that specifies that a set of properties form a unique key for an entity. This means that all
 * instances of that entity must have unique values for those keys.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.KeyAxiom#getProperties <em>Properties</em>}</li>
 *   <li>{@link io.opencaesar.oml.KeyAxiom#getOwningEntity <em>Owning Entity</em>}</li>
 *   <li>{@link io.opencaesar.oml.KeyAxiom#getOwningReference <em>Owning Reference</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getKeyAxiom()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Axioms'"
 * @generated
 */
public interface KeyAxiom extends Axiom {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' reference list.
	 * The list contents are of type {@link io.opencaesar.oml.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of properties specified by this axiom as a key
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Properties</em>' reference list.
	 * @see io.opencaesar.oml.OmlPackage#getKeyAxiom_Properties()
	 * @model required="true"
	 * @generated
	 */
	EList<Property> getProperties();

	/**
	 * Returns the value of the '<em><b>Owning Entity</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.Entity#getOwnedKeys <em>Owned Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The entity that owns this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Entity</em>' container reference.
	 * @see #setOwningEntity(Entity)
	 * @see io.opencaesar.oml.OmlPackage#getKeyAxiom_OwningEntity()
	 * @see io.opencaesar.oml.Entity#getOwnedKeys
	 * @model opposite="ownedKeys" transient="false"
	 * @generated
	 */
	Entity getOwningEntity();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.KeyAxiom#getOwningEntity <em>Owning Entity</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Entity</em>' container reference.
	 * @see #getOwningEntity()
	 * @generated
	 */
	void setOwningEntity(Entity value);

	/**
	 * Returns the value of the '<em><b>Owning Reference</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.EntityReference#getOwnedKeys <em>Owned Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The reference to an entity that owns this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Reference</em>' container reference.
	 * @see #setOwningReference(EntityReference)
	 * @see io.opencaesar.oml.OmlPackage#getKeyAxiom_OwningReference()
	 * @see io.opencaesar.oml.EntityReference#getOwnedKeys
	 * @model opposite="ownedKeys" transient="false"
	 * @generated
	 */
	EntityReference getOwningReference();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.KeyAxiom#getOwningReference <em>Owning Reference</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Reference</em>' container reference.
	 * @see #getOwningReference()
	 * @generated
	 */
	void setOwningReference(EntityReference value);

} // KeyAxiom
