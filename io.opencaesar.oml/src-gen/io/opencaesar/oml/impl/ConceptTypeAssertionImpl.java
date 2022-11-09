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

import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.ConceptInstanceReference;
import io.opencaesar.oml.ConceptTypeAssertion;
import io.opencaesar.oml.OmlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept Type Assertion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.ConceptTypeAssertionImpl#getType <em>Type</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ConceptTypeAssertionImpl#getOwningInstance <em>Owning Instance</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ConceptTypeAssertionImpl#getOwningReference <em>Owning Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptTypeAssertionImpl extends TypeAssertionImpl implements ConceptTypeAssertion {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Concept type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptTypeAssertionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.CONCEPT_TYPE_ASSERTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Concept getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Concept)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.CONCEPT_TYPE_ASSERTION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concept basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(Concept newType) {
		Concept oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.CONCEPT_TYPE_ASSERTION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConceptInstance getOwningInstance() {
		if (eContainerFeatureID() != OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_INSTANCE) return null;
		return (ConceptInstance)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptInstance basicGetOwningInstance() {
		if (eContainerFeatureID() != OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_INSTANCE) return null;
		return (ConceptInstance)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningInstance(ConceptInstance newOwningInstance, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningInstance, OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_INSTANCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningInstance(ConceptInstance newOwningInstance) {
		if (newOwningInstance != eInternalContainer() || (eContainerFeatureID() != OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_INSTANCE && newOwningInstance != null)) {
			if (EcoreUtil.isAncestor(this, newOwningInstance))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningInstance != null)
				msgs = ((InternalEObject)newOwningInstance).eInverseAdd(this, OmlPackage.CONCEPT_INSTANCE__OWNED_TYPES, ConceptInstance.class, msgs);
			msgs = basicSetOwningInstance(newOwningInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_INSTANCE, newOwningInstance, newOwningInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConceptInstanceReference getOwningReference() {
		if (eContainerFeatureID() != OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_REFERENCE) return null;
		return (ConceptInstanceReference)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptInstanceReference basicGetOwningReference() {
		if (eContainerFeatureID() != OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_REFERENCE) return null;
		return (ConceptInstanceReference)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningReference(ConceptInstanceReference newOwningReference, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningReference, OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_REFERENCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningReference(ConceptInstanceReference newOwningReference) {
		if (newOwningReference != eInternalContainer() || (eContainerFeatureID() != OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_REFERENCE && newOwningReference != null)) {
			if (EcoreUtil.isAncestor(this, newOwningReference))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningReference != null)
				msgs = ((InternalEObject)newOwningReference).eInverseAdd(this, OmlPackage.CONCEPT_INSTANCE_REFERENCE__OWNED_TYPES, ConceptInstanceReference.class, msgs);
			msgs = basicSetOwningReference(newOwningReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_REFERENCE, newOwningReference, newOwningReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_INSTANCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningInstance((ConceptInstance)otherEnd, msgs);
			case OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_REFERENCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningReference((ConceptInstanceReference)otherEnd, msgs);
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
			case OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_INSTANCE:
				return basicSetOwningInstance(null, msgs);
			case OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_REFERENCE:
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
			case OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_INSTANCE:
				return eInternalContainer().eInverseRemove(this, OmlPackage.CONCEPT_INSTANCE__OWNED_TYPES, ConceptInstance.class, msgs);
			case OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_REFERENCE:
				return eInternalContainer().eInverseRemove(this, OmlPackage.CONCEPT_INSTANCE_REFERENCE__OWNED_TYPES, ConceptInstanceReference.class, msgs);
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
			case OmlPackage.CONCEPT_TYPE_ASSERTION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_INSTANCE:
				if (resolve) return getOwningInstance();
				return basicGetOwningInstance();
			case OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_REFERENCE:
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
			case OmlPackage.CONCEPT_TYPE_ASSERTION__TYPE:
				setType((Concept)newValue);
				return;
			case OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_INSTANCE:
				setOwningInstance((ConceptInstance)newValue);
				return;
			case OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_REFERENCE:
				setOwningReference((ConceptInstanceReference)newValue);
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
			case OmlPackage.CONCEPT_TYPE_ASSERTION__TYPE:
				setType((Concept)null);
				return;
			case OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_INSTANCE:
				setOwningInstance((ConceptInstance)null);
				return;
			case OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_REFERENCE:
				setOwningReference((ConceptInstanceReference)null);
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
			case OmlPackage.CONCEPT_TYPE_ASSERTION__TYPE:
				return type != null;
			case OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_INSTANCE:
				return basicGetOwningInstance() != null;
			case OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_REFERENCE:
				return basicGetOwningReference() != null;
		}
		return super.eIsSet(featureID);
	}

} //ConceptTypeAssertionImpl
