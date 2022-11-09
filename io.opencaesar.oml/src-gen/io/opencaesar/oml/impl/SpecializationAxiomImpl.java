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

import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializableTermReference;
import io.opencaesar.oml.SpecializationAxiom;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specialization Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.SpecializationAxiomImpl#getSpecializedTerm <em>Specialized Term</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.SpecializationAxiomImpl#getOwningTerm <em>Owning Term</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.SpecializationAxiomImpl#getOwningReference <em>Owning Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpecializationAxiomImpl extends AxiomImpl implements SpecializationAxiom {
	/**
	 * The cached value of the '{@link #getSpecializedTerm() <em>Specialized Term</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializedTerm()
	 * @generated
	 * @ordered
	 */
	protected SpecializableTerm specializedTerm;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecializationAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.SPECIALIZATION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpecializableTerm getSpecializedTerm() {
		if (specializedTerm != null && specializedTerm.eIsProxy()) {
			InternalEObject oldSpecializedTerm = (InternalEObject)specializedTerm;
			specializedTerm = (SpecializableTerm)eResolveProxy(oldSpecializedTerm);
			if (specializedTerm != oldSpecializedTerm) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.SPECIALIZATION_AXIOM__SPECIALIZED_TERM, oldSpecializedTerm, specializedTerm));
			}
		}
		return specializedTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializableTerm basicGetSpecializedTerm() {
		return specializedTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpecializedTerm(SpecializableTerm newSpecializedTerm) {
		SpecializableTerm oldSpecializedTerm = specializedTerm;
		specializedTerm = newSpecializedTerm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SPECIALIZATION_AXIOM__SPECIALIZED_TERM, oldSpecializedTerm, specializedTerm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpecializableTerm getOwningTerm() {
		if (eContainerFeatureID() != OmlPackage.SPECIALIZATION_AXIOM__OWNING_TERM) return null;
		return (SpecializableTerm)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializableTerm basicGetOwningTerm() {
		if (eContainerFeatureID() != OmlPackage.SPECIALIZATION_AXIOM__OWNING_TERM) return null;
		return (SpecializableTerm)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTerm(SpecializableTerm newOwningTerm, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTerm, OmlPackage.SPECIALIZATION_AXIOM__OWNING_TERM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTerm(SpecializableTerm newOwningTerm) {
		if (newOwningTerm != eInternalContainer() || (eContainerFeatureID() != OmlPackage.SPECIALIZATION_AXIOM__OWNING_TERM && newOwningTerm != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTerm))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTerm != null)
				msgs = ((InternalEObject)newOwningTerm).eInverseAdd(this, OmlPackage.SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS, SpecializableTerm.class, msgs);
			msgs = basicSetOwningTerm(newOwningTerm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SPECIALIZATION_AXIOM__OWNING_TERM, newOwningTerm, newOwningTerm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpecializableTermReference getOwningReference() {
		if (eContainerFeatureID() != OmlPackage.SPECIALIZATION_AXIOM__OWNING_REFERENCE) return null;
		return (SpecializableTermReference)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializableTermReference basicGetOwningReference() {
		if (eContainerFeatureID() != OmlPackage.SPECIALIZATION_AXIOM__OWNING_REFERENCE) return null;
		return (SpecializableTermReference)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningReference(SpecializableTermReference newOwningReference, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningReference, OmlPackage.SPECIALIZATION_AXIOM__OWNING_REFERENCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningReference(SpecializableTermReference newOwningReference) {
		if (newOwningReference != eInternalContainer() || (eContainerFeatureID() != OmlPackage.SPECIALIZATION_AXIOM__OWNING_REFERENCE && newOwningReference != null)) {
			if (EcoreUtil.isAncestor(this, newOwningReference))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningReference != null)
				msgs = ((InternalEObject)newOwningReference).eInverseAdd(this, OmlPackage.SPECIALIZABLE_TERM_REFERENCE__OWNED_SPECIALIZATIONS, SpecializableTermReference.class, msgs);
			msgs = basicSetOwningReference(newOwningReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SPECIALIZATION_AXIOM__OWNING_REFERENCE, newOwningReference, newOwningReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.SPECIALIZATION_AXIOM__OWNING_TERM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTerm((SpecializableTerm)otherEnd, msgs);
			case OmlPackage.SPECIALIZATION_AXIOM__OWNING_REFERENCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningReference((SpecializableTermReference)otherEnd, msgs);
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
			case OmlPackage.SPECIALIZATION_AXIOM__OWNING_TERM:
				return basicSetOwningTerm(null, msgs);
			case OmlPackage.SPECIALIZATION_AXIOM__OWNING_REFERENCE:
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
			case OmlPackage.SPECIALIZATION_AXIOM__OWNING_TERM:
				return eInternalContainer().eInverseRemove(this, OmlPackage.SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS, SpecializableTerm.class, msgs);
			case OmlPackage.SPECIALIZATION_AXIOM__OWNING_REFERENCE:
				return eInternalContainer().eInverseRemove(this, OmlPackage.SPECIALIZABLE_TERM_REFERENCE__OWNED_SPECIALIZATIONS, SpecializableTermReference.class, msgs);
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
			case OmlPackage.SPECIALIZATION_AXIOM__SPECIALIZED_TERM:
				if (resolve) return getSpecializedTerm();
				return basicGetSpecializedTerm();
			case OmlPackage.SPECIALIZATION_AXIOM__OWNING_TERM:
				if (resolve) return getOwningTerm();
				return basicGetOwningTerm();
			case OmlPackage.SPECIALIZATION_AXIOM__OWNING_REFERENCE:
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
			case OmlPackage.SPECIALIZATION_AXIOM__SPECIALIZED_TERM:
				setSpecializedTerm((SpecializableTerm)newValue);
				return;
			case OmlPackage.SPECIALIZATION_AXIOM__OWNING_TERM:
				setOwningTerm((SpecializableTerm)newValue);
				return;
			case OmlPackage.SPECIALIZATION_AXIOM__OWNING_REFERENCE:
				setOwningReference((SpecializableTermReference)newValue);
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
			case OmlPackage.SPECIALIZATION_AXIOM__SPECIALIZED_TERM:
				setSpecializedTerm((SpecializableTerm)null);
				return;
			case OmlPackage.SPECIALIZATION_AXIOM__OWNING_TERM:
				setOwningTerm((SpecializableTerm)null);
				return;
			case OmlPackage.SPECIALIZATION_AXIOM__OWNING_REFERENCE:
				setOwningReference((SpecializableTermReference)null);
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
			case OmlPackage.SPECIALIZATION_AXIOM__SPECIALIZED_TERM:
				return specializedTerm != null;
			case OmlPackage.SPECIALIZATION_AXIOM__OWNING_TERM:
				return basicGetOwningTerm() != null;
			case OmlPackage.SPECIALIZATION_AXIOM__OWNING_REFERENCE:
				return basicGetOwningReference() != null;
		}
		return super.eIsSet(featureID);
	}

} //SpecializationAxiomImpl
