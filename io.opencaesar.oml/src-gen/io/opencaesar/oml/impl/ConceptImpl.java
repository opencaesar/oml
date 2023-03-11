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
import io.opencaesar.oml.EnumerationAxiom;
import io.opencaesar.oml.OmlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.ConceptImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ConceptImpl#getOwnedEnumeration <em>Owned Enumeration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptImpl extends EntityImpl implements Concept {
	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected Concept ref;

	/**
	 * The cached value of the '{@link #getOwnedEnumeration() <em>Owned Enumeration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEnumeration()
	 * @generated
	 * @ordered
	 */
	protected EnumerationAxiom ownedEnumeration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.CONCEPT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Concept getRef() {
		if (ref != null && ref.eIsProxy()) {
			InternalEObject oldRef = (InternalEObject)ref;
			ref = (Concept)eResolveProxy(oldRef);
			if (ref != oldRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.CONCEPT__REF, oldRef, ref));
			}
		}
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concept basicGetRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRef(Concept newRef) {
		Concept oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.CONCEPT__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumerationAxiom getOwnedEnumeration() {
		return ownedEnumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedEnumeration(EnumerationAxiom newOwnedEnumeration, NotificationChain msgs) {
		EnumerationAxiom oldOwnedEnumeration = ownedEnumeration;
		ownedEnumeration = newOwnedEnumeration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.CONCEPT__OWNED_ENUMERATION, oldOwnedEnumeration, newOwnedEnumeration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedEnumeration(EnumerationAxiom newOwnedEnumeration) {
		if (newOwnedEnumeration != ownedEnumeration) {
			NotificationChain msgs = null;
			if (ownedEnumeration != null)
				msgs = ((InternalEObject)ownedEnumeration).eInverseRemove(this, OmlPackage.ENUMERATION_AXIOM__OWNING_CONCEPT, EnumerationAxiom.class, msgs);
			if (newOwnedEnumeration != null)
				msgs = ((InternalEObject)newOwnedEnumeration).eInverseAdd(this, OmlPackage.ENUMERATION_AXIOM__OWNING_CONCEPT, EnumerationAxiom.class, msgs);
			msgs = basicSetOwnedEnumeration(newOwnedEnumeration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.CONCEPT__OWNED_ENUMERATION, newOwnedEnumeration, newOwnedEnumeration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.CONCEPT__OWNED_ENUMERATION:
				if (ownedEnumeration != null)
					msgs = ((InternalEObject)ownedEnumeration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.CONCEPT__OWNED_ENUMERATION, null, msgs);
				return basicSetOwnedEnumeration((EnumerationAxiom)otherEnd, msgs);
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
			case OmlPackage.CONCEPT__OWNED_ENUMERATION:
				return basicSetOwnedEnumeration(null, msgs);
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
			case OmlPackage.CONCEPT__REF:
				if (resolve) return getRef();
				return basicGetRef();
			case OmlPackage.CONCEPT__OWNED_ENUMERATION:
				return getOwnedEnumeration();
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
			case OmlPackage.CONCEPT__REF:
				setRef((Concept)newValue);
				return;
			case OmlPackage.CONCEPT__OWNED_ENUMERATION:
				setOwnedEnumeration((EnumerationAxiom)newValue);
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
			case OmlPackage.CONCEPT__REF:
				setRef((Concept)null);
				return;
			case OmlPackage.CONCEPT__OWNED_ENUMERATION:
				setOwnedEnumeration((EnumerationAxiom)null);
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
			case OmlPackage.CONCEPT__REF:
				return ref != null;
			case OmlPackage.CONCEPT__OWNED_ENUMERATION:
				return ownedEnumeration != null;
		}
		return super.eIsSet(featureID);
	}

} //ConceptImpl
