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

import io.opencaesar.oml.Member;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Term;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link io.opencaesar.oml.impl.SpecializationAxiomImpl#getSuperTerm <em>Super Term</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.SpecializationAxiomImpl#getOwningTerm <em>Owning Term</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpecializationAxiomImpl extends AxiomImpl implements SpecializationAxiom {
	/**
	 * The cached value of the '{@link #getSuperTerm() <em>Super Term</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperTerm()
	 * @generated
	 * @ordered
	 */
	protected Term superTerm;

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
	public Term getSuperTerm() {
		if (superTerm != null && superTerm.eIsProxy()) {
			InternalEObject oldSuperTerm = (InternalEObject)superTerm;
			superTerm = (Term)eResolveProxy(oldSuperTerm);
			if (superTerm != oldSuperTerm) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.SPECIALIZATION_AXIOM__SUPER_TERM, oldSuperTerm, superTerm));
			}
		}
		return superTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Term basicGetSuperTerm() {
		return superTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSuperTerm(Term newSuperTerm) {
		Term oldSuperTerm = superTerm;
		superTerm = newSuperTerm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SPECIALIZATION_AXIOM__SUPER_TERM, oldSuperTerm, superTerm));
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
	public Term getSubTerm() {
		Member _resolve = this.getOwningTerm().resolve();
		return ((Term) _resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Term getCharacterizedTerm() {
		return this.getSubTerm();
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
			case OmlPackage.SPECIALIZATION_AXIOM__SUPER_TERM:
				if (resolve) return getSuperTerm();
				return basicGetSuperTerm();
			case OmlPackage.SPECIALIZATION_AXIOM__OWNING_TERM:
				if (resolve) return getOwningTerm();
				return basicGetOwningTerm();
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
			case OmlPackage.SPECIALIZATION_AXIOM__SUPER_TERM:
				setSuperTerm((Term)newValue);
				return;
			case OmlPackage.SPECIALIZATION_AXIOM__OWNING_TERM:
				setOwningTerm((SpecializableTerm)newValue);
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
			case OmlPackage.SPECIALIZATION_AXIOM__SUPER_TERM:
				setSuperTerm((Term)null);
				return;
			case OmlPackage.SPECIALIZATION_AXIOM__OWNING_TERM:
				setOwningTerm((SpecializableTerm)null);
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
			case OmlPackage.SPECIALIZATION_AXIOM__SUPER_TERM:
				return superTerm != null;
			case OmlPackage.SPECIALIZATION_AXIOM__OWNING_TERM:
				return basicGetOwningTerm() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OmlPackage.SPECIALIZATION_AXIOM___GET_SUB_TERM:
				return getSubTerm();
			case OmlPackage.SPECIALIZATION_AXIOM___GET_CHARACTERIZED_TERM:
				return getCharacterizedTerm();
		}
		return super.eInvoke(operationID, arguments);
	}

} //SpecializationAxiomImpl
