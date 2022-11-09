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
package io.opencaesar.oml.impl;

import io.opencaesar.oml.EntityReference;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.RelationRestrictionAxiom;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.EntityReferenceImpl#getOwnedRelationRestrictions <em>Owned Relation Restrictions</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.EntityReferenceImpl#getOwnedKeys <em>Owned Keys</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EntityReferenceImpl extends ClassifierReferenceImpl implements EntityReference {
	/**
	 * The cached value of the '{@link #getOwnedRelationRestrictions() <em>Owned Relation Restrictions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRelationRestrictions()
	 * @generated
	 * @ordered
	 */
	protected EList<RelationRestrictionAxiom> ownedRelationRestrictions;

	/**
	 * The cached value of the '{@link #getOwnedKeys() <em>Owned Keys</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedKeys()
	 * @generated
	 * @ordered
	 */
	protected EList<KeyAxiom> ownedKeys;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.ENTITY_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelationRestrictionAxiom> getOwnedRelationRestrictions() {
		if (ownedRelationRestrictions == null) {
			ownedRelationRestrictions = new EObjectContainmentWithInverseEList<RelationRestrictionAxiom>(RelationRestrictionAxiom.class, this, OmlPackage.ENTITY_REFERENCE__OWNED_RELATION_RESTRICTIONS, OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_REFERENCE);
		}
		return ownedRelationRestrictions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<KeyAxiom> getOwnedKeys() {
		if (ownedKeys == null) {
			ownedKeys = new EObjectContainmentWithInverseEList<KeyAxiom>(KeyAxiom.class, this, OmlPackage.ENTITY_REFERENCE__OWNED_KEYS, OmlPackage.KEY_AXIOM__OWNING_REFERENCE);
		}
		return ownedKeys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.ENTITY_REFERENCE__OWNED_RELATION_RESTRICTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRelationRestrictions()).basicAdd(otherEnd, msgs);
			case OmlPackage.ENTITY_REFERENCE__OWNED_KEYS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedKeys()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.ENTITY_REFERENCE__OWNED_RELATION_RESTRICTIONS:
				return ((InternalEList<?>)getOwnedRelationRestrictions()).basicRemove(otherEnd, msgs);
			case OmlPackage.ENTITY_REFERENCE__OWNED_KEYS:
				return ((InternalEList<?>)getOwnedKeys()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OmlPackage.ENTITY_REFERENCE__OWNED_RELATION_RESTRICTIONS:
				return getOwnedRelationRestrictions();
			case OmlPackage.ENTITY_REFERENCE__OWNED_KEYS:
				return getOwnedKeys();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OmlPackage.ENTITY_REFERENCE__OWNED_RELATION_RESTRICTIONS:
				getOwnedRelationRestrictions().clear();
				getOwnedRelationRestrictions().addAll((Collection<? extends RelationRestrictionAxiom>)newValue);
				return;
			case OmlPackage.ENTITY_REFERENCE__OWNED_KEYS:
				getOwnedKeys().clear();
				getOwnedKeys().addAll((Collection<? extends KeyAxiom>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OmlPackage.ENTITY_REFERENCE__OWNED_RELATION_RESTRICTIONS:
				getOwnedRelationRestrictions().clear();
				return;
			case OmlPackage.ENTITY_REFERENCE__OWNED_KEYS:
				getOwnedKeys().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OmlPackage.ENTITY_REFERENCE__OWNED_RELATION_RESTRICTIONS:
				return ownedRelationRestrictions != null && !ownedRelationRestrictions.isEmpty();
			case OmlPackage.ENTITY_REFERENCE__OWNED_KEYS:
				return ownedKeys != null && !ownedKeys.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EntityReferenceImpl
