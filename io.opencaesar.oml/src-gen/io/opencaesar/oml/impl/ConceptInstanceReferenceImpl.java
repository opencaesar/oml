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

import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.ConceptInstanceReference;
import io.opencaesar.oml.ConceptTypeAssertion;
import io.opencaesar.oml.OmlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept Instance Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.ConceptInstanceReferenceImpl#getInstance <em>Instance</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ConceptInstanceReferenceImpl#getOwnedTypes <em>Owned Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptInstanceReferenceImpl extends NamedInstanceReferenceImpl implements ConceptInstanceReference {
	/**
	 * The cached value of the '{@link #getInstance() <em>Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstance()
	 * @generated
	 * @ordered
	 */
	protected ConceptInstance instance;

	/**
	 * The cached value of the '{@link #getOwnedTypes() <em>Owned Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ConceptTypeAssertion> ownedTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptInstanceReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.CONCEPT_INSTANCE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConceptInstance getInstance() {
		if (instance != null && instance.eIsProxy()) {
			InternalEObject oldInstance = (InternalEObject)instance;
			instance = (ConceptInstance)eResolveProxy(oldInstance);
			if (instance != oldInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.CONCEPT_INSTANCE_REFERENCE__INSTANCE, oldInstance, instance));
			}
		}
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptInstance basicGetInstance() {
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstance(ConceptInstance newInstance) {
		ConceptInstance oldInstance = instance;
		instance = newInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.CONCEPT_INSTANCE_REFERENCE__INSTANCE, oldInstance, instance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConceptTypeAssertion> getOwnedTypes() {
		if (ownedTypes == null) {
			ownedTypes = new EObjectContainmentWithInverseEList<ConceptTypeAssertion>(ConceptTypeAssertion.class, this, OmlPackage.CONCEPT_INSTANCE_REFERENCE__OWNED_TYPES, OmlPackage.CONCEPT_TYPE_ASSERTION__OWNING_REFERENCE);
		}
		return ownedTypes;
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
			case OmlPackage.CONCEPT_INSTANCE_REFERENCE__OWNED_TYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTypes()).basicAdd(otherEnd, msgs);
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
			case OmlPackage.CONCEPT_INSTANCE_REFERENCE__OWNED_TYPES:
				return ((InternalEList<?>)getOwnedTypes()).basicRemove(otherEnd, msgs);
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
			case OmlPackage.CONCEPT_INSTANCE_REFERENCE__INSTANCE:
				if (resolve) return getInstance();
				return basicGetInstance();
			case OmlPackage.CONCEPT_INSTANCE_REFERENCE__OWNED_TYPES:
				return getOwnedTypes();
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
			case OmlPackage.CONCEPT_INSTANCE_REFERENCE__INSTANCE:
				setInstance((ConceptInstance)newValue);
				return;
			case OmlPackage.CONCEPT_INSTANCE_REFERENCE__OWNED_TYPES:
				getOwnedTypes().clear();
				getOwnedTypes().addAll((Collection<? extends ConceptTypeAssertion>)newValue);
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
			case OmlPackage.CONCEPT_INSTANCE_REFERENCE__INSTANCE:
				setInstance((ConceptInstance)null);
				return;
			case OmlPackage.CONCEPT_INSTANCE_REFERENCE__OWNED_TYPES:
				getOwnedTypes().clear();
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
			case OmlPackage.CONCEPT_INSTANCE_REFERENCE__INSTANCE:
				return instance != null;
			case OmlPackage.CONCEPT_INSTANCE_REFERENCE__OWNED_TYPES:
				return ownedTypes != null && !ownedTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConceptInstanceReferenceImpl
