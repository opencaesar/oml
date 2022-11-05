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
import io.opencaesar.oml.Feature;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.OmlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Key Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.KeyAxiomImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.KeyAxiomImpl#getOwningEntity <em>Owning Entity</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.KeyAxiomImpl#getOwningReference <em>Owning Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class KeyAxiomImpl extends AxiomImpl implements KeyAxiom {
	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KeyAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.KEY_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Feature> getProperties() {
		if (properties == null) {
			properties = new EObjectResolvingEList<Feature>(Feature.class, this, OmlPackage.KEY_AXIOM__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity getOwningEntity() {
		if (eContainerFeatureID() != OmlPackage.KEY_AXIOM__OWNING_ENTITY) return null;
		return (Entity)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetOwningEntity() {
		if (eContainerFeatureID() != OmlPackage.KEY_AXIOM__OWNING_ENTITY) return null;
		return (Entity)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningEntity(Entity newOwningEntity, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningEntity, OmlPackage.KEY_AXIOM__OWNING_ENTITY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningEntity(Entity newOwningEntity) {
		if (newOwningEntity != eInternalContainer() || (eContainerFeatureID() != OmlPackage.KEY_AXIOM__OWNING_ENTITY && newOwningEntity != null)) {
			if (EcoreUtil.isAncestor(this, newOwningEntity))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningEntity != null)
				msgs = ((InternalEObject)newOwningEntity).eInverseAdd(this, OmlPackage.ENTITY__OWNED_KEYS, Entity.class, msgs);
			msgs = basicSetOwningEntity(newOwningEntity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.KEY_AXIOM__OWNING_ENTITY, newOwningEntity, newOwningEntity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EntityReference getOwningReference() {
		if (eContainerFeatureID() != OmlPackage.KEY_AXIOM__OWNING_REFERENCE) return null;
		return (EntityReference)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityReference basicGetOwningReference() {
		if (eContainerFeatureID() != OmlPackage.KEY_AXIOM__OWNING_REFERENCE) return null;
		return (EntityReference)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningReference(EntityReference newOwningReference, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningReference, OmlPackage.KEY_AXIOM__OWNING_REFERENCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningReference(EntityReference newOwningReference) {
		if (newOwningReference != eInternalContainer() || (eContainerFeatureID() != OmlPackage.KEY_AXIOM__OWNING_REFERENCE && newOwningReference != null)) {
			if (EcoreUtil.isAncestor(this, newOwningReference))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningReference != null)
				msgs = ((InternalEObject)newOwningReference).eInverseAdd(this, OmlPackage.ENTITY_REFERENCE__OWNED_KEYS, EntityReference.class, msgs);
			msgs = basicSetOwningReference(newOwningReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.KEY_AXIOM__OWNING_REFERENCE, newOwningReference, newOwningReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.KEY_AXIOM__OWNING_ENTITY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningEntity((Entity)otherEnd, msgs);
			case OmlPackage.KEY_AXIOM__OWNING_REFERENCE:
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
			case OmlPackage.KEY_AXIOM__OWNING_ENTITY:
				return basicSetOwningEntity(null, msgs);
			case OmlPackage.KEY_AXIOM__OWNING_REFERENCE:
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
			case OmlPackage.KEY_AXIOM__OWNING_ENTITY:
				return eInternalContainer().eInverseRemove(this, OmlPackage.ENTITY__OWNED_KEYS, Entity.class, msgs);
			case OmlPackage.KEY_AXIOM__OWNING_REFERENCE:
				return eInternalContainer().eInverseRemove(this, OmlPackage.ENTITY_REFERENCE__OWNED_KEYS, EntityReference.class, msgs);
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
			case OmlPackage.KEY_AXIOM__PROPERTIES:
				return getProperties();
			case OmlPackage.KEY_AXIOM__OWNING_ENTITY:
				if (resolve) return getOwningEntity();
				return basicGetOwningEntity();
			case OmlPackage.KEY_AXIOM__OWNING_REFERENCE:
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OmlPackage.KEY_AXIOM__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends Feature>)newValue);
				return;
			case OmlPackage.KEY_AXIOM__OWNING_ENTITY:
				setOwningEntity((Entity)newValue);
				return;
			case OmlPackage.KEY_AXIOM__OWNING_REFERENCE:
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
			case OmlPackage.KEY_AXIOM__PROPERTIES:
				getProperties().clear();
				return;
			case OmlPackage.KEY_AXIOM__OWNING_ENTITY:
				setOwningEntity((Entity)null);
				return;
			case OmlPackage.KEY_AXIOM__OWNING_REFERENCE:
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
			case OmlPackage.KEY_AXIOM__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case OmlPackage.KEY_AXIOM__OWNING_ENTITY:
				return basicGetOwningEntity() != null;
			case OmlPackage.KEY_AXIOM__OWNING_REFERENCE:
				return basicGetOwningReference() != null;
		}
		return super.eIsSet(featureID);
	}

} //KeyAxiomImpl
