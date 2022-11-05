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

import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EntityReference;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationRestrictionAxiom;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.RelationRestrictionAxiomImpl#getRelation <em>Relation</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationRestrictionAxiomImpl#getOwningEntity <em>Owning Entity</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationRestrictionAxiomImpl#getOwningReference <em>Owning Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RelationRestrictionAxiomImpl extends RestrictionAxiomImpl implements RelationRestrictionAxiom {
	/**
	 * The cached value of the '{@link #getRelation() <em>Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected Relation relation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationRestrictionAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.RELATION_RESTRICTION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getRelation() {
		if (relation != null && relation.eIsProxy()) {
			InternalEObject oldRelation = (InternalEObject)relation;
			relation = (Relation)eResolveProxy(oldRelation);
			if (relation != oldRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.RELATION_RESTRICTION_AXIOM__RELATION, oldRelation, relation));
			}
		}
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetRelation() {
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelation(Relation newRelation) {
		Relation oldRelation = relation;
		relation = newRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_RESTRICTION_AXIOM__RELATION, oldRelation, relation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity getOwningEntity() {
		if (eContainerFeatureID() != OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_ENTITY) return null;
		return (Entity)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetOwningEntity() {
		if (eContainerFeatureID() != OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_ENTITY) return null;
		return (Entity)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningEntity(Entity newOwningEntity, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningEntity, OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_ENTITY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningEntity(Entity newOwningEntity) {
		if (newOwningEntity != eInternalContainer() || (eContainerFeatureID() != OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_ENTITY && newOwningEntity != null)) {
			if (EcoreUtil.isAncestor(this, newOwningEntity))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningEntity != null)
				msgs = ((InternalEObject)newOwningEntity).eInverseAdd(this, OmlPackage.ENTITY__OWNED_RELATION_RESTRICTIONS, Entity.class, msgs);
			msgs = basicSetOwningEntity(newOwningEntity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_ENTITY, newOwningEntity, newOwningEntity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EntityReference getOwningReference() {
		if (eContainerFeatureID() != OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_REFERENCE) return null;
		return (EntityReference)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityReference basicGetOwningReference() {
		if (eContainerFeatureID() != OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_REFERENCE) return null;
		return (EntityReference)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningReference(EntityReference newOwningReference, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningReference, OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_REFERENCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningReference(EntityReference newOwningReference) {
		if (newOwningReference != eInternalContainer() || (eContainerFeatureID() != OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_REFERENCE && newOwningReference != null)) {
			if (EcoreUtil.isAncestor(this, newOwningReference))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningReference != null)
				msgs = ((InternalEObject)newOwningReference).eInverseAdd(this, OmlPackage.ENTITY_REFERENCE__OWNED_RELATION_RESTRICTIONS, EntityReference.class, msgs);
			msgs = basicSetOwningReference(newOwningReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_REFERENCE, newOwningReference, newOwningReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_ENTITY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningEntity((Entity)otherEnd, msgs);
			case OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_REFERENCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningReference((EntityReference)otherEnd, msgs);
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
			case OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_ENTITY:
				return basicSetOwningEntity(null, msgs);
			case OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_REFERENCE:
				return basicSetOwningReference(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_ENTITY:
				return eInternalContainer().eInverseRemove(this, OmlPackage.ENTITY__OWNED_RELATION_RESTRICTIONS, Entity.class, msgs);
			case OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_REFERENCE:
				return eInternalContainer().eInverseRemove(this, OmlPackage.ENTITY_REFERENCE__OWNED_RELATION_RESTRICTIONS, EntityReference.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OmlPackage.RELATION_RESTRICTION_AXIOM__RELATION:
				if (resolve) return getRelation();
				return basicGetRelation();
			case OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_ENTITY:
				if (resolve) return getOwningEntity();
				return basicGetOwningEntity();
			case OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_REFERENCE:
				if (resolve) return getOwningReference();
				return basicGetOwningReference();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OmlPackage.RELATION_RESTRICTION_AXIOM__RELATION:
				setRelation((Relation)newValue);
				return;
			case OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_ENTITY:
				setOwningEntity((Entity)newValue);
				return;
			case OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_REFERENCE:
				setOwningReference((EntityReference)newValue);
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
			case OmlPackage.RELATION_RESTRICTION_AXIOM__RELATION:
				setRelation((Relation)null);
				return;
			case OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_ENTITY:
				setOwningEntity((Entity)null);
				return;
			case OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_REFERENCE:
				setOwningReference((EntityReference)null);
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
			case OmlPackage.RELATION_RESTRICTION_AXIOM__RELATION:
				return relation != null;
			case OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_ENTITY:
				return basicGetOwningEntity() != null;
			case OmlPackage.RELATION_RESTRICTION_AXIOM__OWNING_REFERENCE:
				return basicGetOwningReference() != null;
		}
		return super.eIsSet(featureID);
	}

} //RelationRestrictionAxiomImpl
