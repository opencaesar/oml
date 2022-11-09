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
 * A representation of the model object '<em><b>Entity Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * EntityReference is a reference to an entity that can be used to add other relation restrictions to it.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.EntityReference#getOwnedRelationRestrictions <em>Owned Relation Restrictions</em>}</li>
 *   <li>{@link io.opencaesar.oml.EntityReference#getOwnedKeys <em>Owned Keys</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getEntityReference()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='References'"
 * @generated
 */
public interface EntityReference extends ClassifierReference {
	/**
	 * Returns the value of the '<em><b>Owned Relation Restrictions</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.RelationRestrictionAxiom}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.RelationRestrictionAxiom#getOwningReference <em>Owning Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of relation restriction axioms added to the referenced entity by this reference
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Relation Restrictions</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getEntityReference_OwnedRelationRestrictions()
	 * @see io.opencaesar.oml.RelationRestrictionAxiom#getOwningReference
	 * @model opposite="owningReference" containment="true"
	 * @generated
	 */
	EList<RelationRestrictionAxiom> getOwnedRelationRestrictions();

	/**
	 * Returns the value of the '<em><b>Owned Keys</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.KeyAxiom}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.KeyAxiom#getOwningReference <em>Owning Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The keys of the referenced entity specified by this reference
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Keys</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getEntityReference_OwnedKeys()
	 * @see io.opencaesar.oml.KeyAxiom#getOwningReference
	 * @model opposite="owningReference" containment="true"
	 * @generated
	 */
	EList<KeyAxiom> getOwnedKeys();

} // EntityReference
