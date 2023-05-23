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

import io.opencaesar.oml.LiteralEnumerationAxiom;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarEquivalenceAxiom;

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
 * An implementation of the model object '<em><b>Scalar</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.ScalarImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ScalarImpl#getOwnedEnumeration <em>Owned Enumeration</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ScalarImpl#getOwnedEquivalences <em>Owned Equivalences</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScalarImpl extends TypeImpl implements Scalar {
	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected Scalar ref;

	/**
	 * The cached value of the '{@link #getOwnedEnumeration() <em>Owned Enumeration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEnumeration()
	 * @generated
	 * @ordered
	 */
	protected LiteralEnumerationAxiom ownedEnumeration;

	/**
	 * The cached value of the '{@link #getOwnedEquivalences() <em>Owned Equivalences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEquivalences()
	 * @generated
	 * @ordered
	 */
	protected EList<ScalarEquivalenceAxiom> ownedEquivalences;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScalarImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.SCALAR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Scalar getRef() {
		if (ref != null && ref.eIsProxy()) {
			InternalEObject oldRef = (InternalEObject)ref;
			ref = (Scalar)eResolveProxy(oldRef);
			if (ref != oldRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.SCALAR__REF, oldRef, ref));
			}
		}
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scalar basicGetRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRef(Scalar newRef) {
		Scalar oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralEnumerationAxiom getOwnedEnumeration() {
		return ownedEnumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedEnumeration(LiteralEnumerationAxiom newOwnedEnumeration, NotificationChain msgs) {
		LiteralEnumerationAxiom oldOwnedEnumeration = ownedEnumeration;
		ownedEnumeration = newOwnedEnumeration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR__OWNED_ENUMERATION, oldOwnedEnumeration, newOwnedEnumeration);
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
	public void setOwnedEnumeration(LiteralEnumerationAxiom newOwnedEnumeration) {
		if (newOwnedEnumeration != ownedEnumeration) {
			NotificationChain msgs = null;
			if (ownedEnumeration != null)
				msgs = ((InternalEObject)ownedEnumeration).eInverseRemove(this, OmlPackage.LITERAL_ENUMERATION_AXIOM__OWNING_SCALAR, LiteralEnumerationAxiom.class, msgs);
			if (newOwnedEnumeration != null)
				msgs = ((InternalEObject)newOwnedEnumeration).eInverseAdd(this, OmlPackage.LITERAL_ENUMERATION_AXIOM__OWNING_SCALAR, LiteralEnumerationAxiom.class, msgs);
			msgs = basicSetOwnedEnumeration(newOwnedEnumeration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR__OWNED_ENUMERATION, newOwnedEnumeration, newOwnedEnumeration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ScalarEquivalenceAxiom> getOwnedEquivalences() {
		if (ownedEquivalences == null) {
			ownedEquivalences = new EObjectContainmentWithInverseEList<ScalarEquivalenceAxiom>(ScalarEquivalenceAxiom.class, this, OmlPackage.SCALAR__OWNED_EQUIVALENCES, OmlPackage.SCALAR_EQUIVALENCE_AXIOM__OWNING_SCALAR);
		}
		return ownedEquivalences;
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
			case OmlPackage.SCALAR__OWNED_ENUMERATION:
				if (ownedEnumeration != null)
					msgs = ((InternalEObject)ownedEnumeration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.SCALAR__OWNED_ENUMERATION, null, msgs);
				return basicSetOwnedEnumeration((LiteralEnumerationAxiom)otherEnd, msgs);
			case OmlPackage.SCALAR__OWNED_EQUIVALENCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedEquivalences()).basicAdd(otherEnd, msgs);
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
			case OmlPackage.SCALAR__OWNED_ENUMERATION:
				return basicSetOwnedEnumeration(null, msgs);
			case OmlPackage.SCALAR__OWNED_EQUIVALENCES:
				return ((InternalEList<?>)getOwnedEquivalences()).basicRemove(otherEnd, msgs);
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
			case OmlPackage.SCALAR__REF:
				if (resolve) return getRef();
				return basicGetRef();
			case OmlPackage.SCALAR__OWNED_ENUMERATION:
				return getOwnedEnumeration();
			case OmlPackage.SCALAR__OWNED_EQUIVALENCES:
				return getOwnedEquivalences();
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
			case OmlPackage.SCALAR__REF:
				setRef((Scalar)newValue);
				return;
			case OmlPackage.SCALAR__OWNED_ENUMERATION:
				setOwnedEnumeration((LiteralEnumerationAxiom)newValue);
				return;
			case OmlPackage.SCALAR__OWNED_EQUIVALENCES:
				getOwnedEquivalences().clear();
				getOwnedEquivalences().addAll((Collection<? extends ScalarEquivalenceAxiom>)newValue);
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
			case OmlPackage.SCALAR__REF:
				setRef((Scalar)null);
				return;
			case OmlPackage.SCALAR__OWNED_ENUMERATION:
				setOwnedEnumeration((LiteralEnumerationAxiom)null);
				return;
			case OmlPackage.SCALAR__OWNED_EQUIVALENCES:
				getOwnedEquivalences().clear();
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
			case OmlPackage.SCALAR__REF:
				return ref != null;
			case OmlPackage.SCALAR__OWNED_ENUMERATION:
				return ownedEnumeration != null;
			case OmlPackage.SCALAR__OWNED_EQUIVALENCES:
				return ownedEquivalences != null && !ownedEquivalences.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ScalarImpl
