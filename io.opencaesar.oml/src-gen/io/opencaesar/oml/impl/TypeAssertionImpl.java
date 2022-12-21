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
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.NamedInstanceReference;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.TypeAssertion;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Assertion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.TypeAssertionImpl#getType <em>Type</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.TypeAssertionImpl#getOwningInstance <em>Owning Instance</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.TypeAssertionImpl#getOwningReference <em>Owning Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeAssertionImpl extends AssertionImpl implements TypeAssertion {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Entity type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeAssertionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.TYPE_ASSERTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Entity)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.TYPE_ASSERTION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(Entity newType) {
		Entity oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.TYPE_ASSERTION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedInstance getOwningInstance() {
		if (eContainerFeatureID() != OmlPackage.TYPE_ASSERTION__OWNING_INSTANCE) return null;
		return (NamedInstance)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedInstance basicGetOwningInstance() {
		if (eContainerFeatureID() != OmlPackage.TYPE_ASSERTION__OWNING_INSTANCE) return null;
		return (NamedInstance)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningInstance(NamedInstance newOwningInstance, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningInstance, OmlPackage.TYPE_ASSERTION__OWNING_INSTANCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningInstance(NamedInstance newOwningInstance) {
		if (newOwningInstance != eInternalContainer() || (eContainerFeatureID() != OmlPackage.TYPE_ASSERTION__OWNING_INSTANCE && newOwningInstance != null)) {
			if (EcoreUtil.isAncestor(this, newOwningInstance))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningInstance != null)
				msgs = ((InternalEObject)newOwningInstance).eInverseAdd(this, OmlPackage.NAMED_INSTANCE__OWNED_TYPES, NamedInstance.class, msgs);
			msgs = basicSetOwningInstance(newOwningInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.TYPE_ASSERTION__OWNING_INSTANCE, newOwningInstance, newOwningInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedInstanceReference getOwningReference() {
		if (eContainerFeatureID() != OmlPackage.TYPE_ASSERTION__OWNING_REFERENCE) return null;
		return (NamedInstanceReference)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedInstanceReference basicGetOwningReference() {
		if (eContainerFeatureID() != OmlPackage.TYPE_ASSERTION__OWNING_REFERENCE) return null;
		return (NamedInstanceReference)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningReference(NamedInstanceReference newOwningReference, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningReference, OmlPackage.TYPE_ASSERTION__OWNING_REFERENCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningReference(NamedInstanceReference newOwningReference) {
		if (newOwningReference != eInternalContainer() || (eContainerFeatureID() != OmlPackage.TYPE_ASSERTION__OWNING_REFERENCE && newOwningReference != null)) {
			if (EcoreUtil.isAncestor(this, newOwningReference))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningReference != null)
				msgs = ((InternalEObject)newOwningReference).eInverseAdd(this, OmlPackage.NAMED_INSTANCE_REFERENCE__OWNED_TYPES, NamedInstanceReference.class, msgs);
			msgs = basicSetOwningReference(newOwningReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.TYPE_ASSERTION__OWNING_REFERENCE, newOwningReference, newOwningReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.TYPE_ASSERTION__OWNING_INSTANCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningInstance((NamedInstance)otherEnd, msgs);
			case OmlPackage.TYPE_ASSERTION__OWNING_REFERENCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningReference((NamedInstanceReference)otherEnd, msgs);
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
			case OmlPackage.TYPE_ASSERTION__OWNING_INSTANCE:
				return basicSetOwningInstance(null, msgs);
			case OmlPackage.TYPE_ASSERTION__OWNING_REFERENCE:
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
			case OmlPackage.TYPE_ASSERTION__OWNING_INSTANCE:
				return eInternalContainer().eInverseRemove(this, OmlPackage.NAMED_INSTANCE__OWNED_TYPES, NamedInstance.class, msgs);
			case OmlPackage.TYPE_ASSERTION__OWNING_REFERENCE:
				return eInternalContainer().eInverseRemove(this, OmlPackage.NAMED_INSTANCE_REFERENCE__OWNED_TYPES, NamedInstanceReference.class, msgs);
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
			case OmlPackage.TYPE_ASSERTION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case OmlPackage.TYPE_ASSERTION__OWNING_INSTANCE:
				if (resolve) return getOwningInstance();
				return basicGetOwningInstance();
			case OmlPackage.TYPE_ASSERTION__OWNING_REFERENCE:
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
			case OmlPackage.TYPE_ASSERTION__TYPE:
				setType((Entity)newValue);
				return;
			case OmlPackage.TYPE_ASSERTION__OWNING_INSTANCE:
				setOwningInstance((NamedInstance)newValue);
				return;
			case OmlPackage.TYPE_ASSERTION__OWNING_REFERENCE:
				setOwningReference((NamedInstanceReference)newValue);
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
			case OmlPackage.TYPE_ASSERTION__TYPE:
				setType((Entity)null);
				return;
			case OmlPackage.TYPE_ASSERTION__OWNING_INSTANCE:
				setOwningInstance((NamedInstance)null);
				return;
			case OmlPackage.TYPE_ASSERTION__OWNING_REFERENCE:
				setOwningReference((NamedInstanceReference)null);
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
			case OmlPackage.TYPE_ASSERTION__TYPE:
				return type != null;
			case OmlPackage.TYPE_ASSERTION__OWNING_INSTANCE:
				return basicGetOwningInstance() != null;
			case OmlPackage.TYPE_ASSERTION__OWNING_REFERENCE:
				return basicGetOwningReference() != null;
		}
		return super.eIsSet(featureID);
	}

} //TypeAssertionImpl
