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
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Entity is a structured [=type=] that represent a set of [=Instances=]. it can specify a set of [=PropertyRestrictionAxioms=],
 * set of [=EntityEquivalenceAxioms=], and a set of [=KeyAxioms=].
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.Entity#getOwnedEquivalences <em>Owned Equivalences</em>}</li>
 *   <li>{@link io.opencaesar.oml.Entity#getOwnedPropertyRestrictions <em>Owned Property Restrictions</em>}</li>
 *   <li>{@link io.opencaesar.oml.Entity#getOwnedKeys <em>Owned Keys</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getEntity()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Types'"
 * @generated
 */
public interface Entity extends Type {
	/**
	 * Returns the value of the '<em><b>Owned Equivalences</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.EntityEquivalenceAxiom}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.EntityEquivalenceAxiom#getOwningEntity <em>Owning Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of entity equivalence axioms of this entity
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Equivalences</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getEntity_OwnedEquivalences()
	 * @see io.opencaesar.oml.EntityEquivalenceAxiom#getOwningEntity
	 * @model opposite="owningEntity" containment="true"
	 * @generated
	 */
	EList<EntityEquivalenceAxiom> getOwnedEquivalences();

	/**
	 * Returns the value of the '<em><b>Owned Property Restrictions</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.PropertyRestrictionAxiom}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.PropertyRestrictionAxiom#getOwningEntity <em>Owning Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of property restriction axioms of this entity
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Property Restrictions</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getEntity_OwnedPropertyRestrictions()
	 * @see io.opencaesar.oml.PropertyRestrictionAxiom#getOwningEntity
	 * @model opposite="owningEntity" containment="true"
	 * @generated
	 */
	EList<PropertyRestrictionAxiom> getOwnedPropertyRestrictions();

	/**
	 * Returns the value of the '<em><b>Owned Keys</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.KeyAxiom}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.KeyAxiom#getOwningEntity <em>Owning Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The unique keys of this entity
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Keys</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getEntity_OwnedKeys()
	 * @see io.opencaesar.oml.KeyAxiom#getOwningEntity
	 * @model opposite="owningEntity" containment="true"
	 * @generated
	 */
	EList<KeyAxiom> getOwnedKeys();

} // Entity
