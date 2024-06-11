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

import io.opencaesar.oml.AnonymousInstance;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.PropertyValueRestrictionAxiom;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Anonymous Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.AnonymousInstanceImpl#getOwningAssertion <em>Owning Assertion</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.AnonymousInstanceImpl#getOwningAxiom <em>Owning Axiom</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AnonymousInstanceImpl extends InstanceImpl implements AnonymousInstance {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnonymousInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.ANONYMOUS_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyValueAssertion getOwningAssertion() {
		if (eContainerFeatureID() != OmlPackage.ANONYMOUS_INSTANCE__OWNING_ASSERTION) return null;
		return (PropertyValueAssertion)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyValueAssertion basicGetOwningAssertion() {
		if (eContainerFeatureID() != OmlPackage.ANONYMOUS_INSTANCE__OWNING_ASSERTION) return null;
		return (PropertyValueAssertion)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningAssertion(PropertyValueAssertion newOwningAssertion, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningAssertion, OmlPackage.ANONYMOUS_INSTANCE__OWNING_ASSERTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningAssertion(PropertyValueAssertion newOwningAssertion) {
		if (newOwningAssertion != eInternalContainer() || (eContainerFeatureID() != OmlPackage.ANONYMOUS_INSTANCE__OWNING_ASSERTION && newOwningAssertion != null)) {
			if (EcoreUtil.isAncestor(this, newOwningAssertion))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningAssertion != null)
				msgs = ((InternalEObject)newOwningAssertion).eInverseAdd(this, OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE, PropertyValueAssertion.class, msgs);
			msgs = basicSetOwningAssertion(newOwningAssertion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.ANONYMOUS_INSTANCE__OWNING_ASSERTION, newOwningAssertion, newOwningAssertion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyValueRestrictionAxiom getOwningAxiom() {
		if (eContainerFeatureID() != OmlPackage.ANONYMOUS_INSTANCE__OWNING_AXIOM) return null;
		return (PropertyValueRestrictionAxiom)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyValueRestrictionAxiom basicGetOwningAxiom() {
		if (eContainerFeatureID() != OmlPackage.ANONYMOUS_INSTANCE__OWNING_AXIOM) return null;
		return (PropertyValueRestrictionAxiom)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningAxiom(PropertyValueRestrictionAxiom newOwningAxiom, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningAxiom, OmlPackage.ANONYMOUS_INSTANCE__OWNING_AXIOM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningAxiom(PropertyValueRestrictionAxiom newOwningAxiom) {
		if (newOwningAxiom != eInternalContainer() || (eContainerFeatureID() != OmlPackage.ANONYMOUS_INSTANCE__OWNING_AXIOM && newOwningAxiom != null)) {
			if (EcoreUtil.isAncestor(this, newOwningAxiom))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningAxiom != null)
				msgs = ((InternalEObject)newOwningAxiom).eInverseAdd(this, OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__CONTAINED_VALUE, PropertyValueRestrictionAxiom.class, msgs);
			msgs = basicSetOwningAxiom(newOwningAxiom, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.ANONYMOUS_INSTANCE__OWNING_AXIOM, newOwningAxiom, newOwningAxiom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Classifier getType() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Classifier> getTypes() {
		return ECollections.<Classifier>singletonEList(this.getType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.ANONYMOUS_INSTANCE__OWNING_ASSERTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningAssertion((PropertyValueAssertion)otherEnd, msgs);
			case OmlPackage.ANONYMOUS_INSTANCE__OWNING_AXIOM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningAxiom((PropertyValueRestrictionAxiom)otherEnd, msgs);
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
			case OmlPackage.ANONYMOUS_INSTANCE__OWNING_ASSERTION:
				return basicSetOwningAssertion(null, msgs);
			case OmlPackage.ANONYMOUS_INSTANCE__OWNING_AXIOM:
				return basicSetOwningAxiom(null, msgs);
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
			case OmlPackage.ANONYMOUS_INSTANCE__OWNING_ASSERTION:
				return eInternalContainer().eInverseRemove(this, OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE, PropertyValueAssertion.class, msgs);
			case OmlPackage.ANONYMOUS_INSTANCE__OWNING_AXIOM:
				return eInternalContainer().eInverseRemove(this, OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__CONTAINED_VALUE, PropertyValueRestrictionAxiom.class, msgs);
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
			case OmlPackage.ANONYMOUS_INSTANCE__OWNING_ASSERTION:
				if (resolve) return getOwningAssertion();
				return basicGetOwningAssertion();
			case OmlPackage.ANONYMOUS_INSTANCE__OWNING_AXIOM:
				if (resolve) return getOwningAxiom();
				return basicGetOwningAxiom();
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
			case OmlPackage.ANONYMOUS_INSTANCE__OWNING_ASSERTION:
				setOwningAssertion((PropertyValueAssertion)newValue);
				return;
			case OmlPackage.ANONYMOUS_INSTANCE__OWNING_AXIOM:
				setOwningAxiom((PropertyValueRestrictionAxiom)newValue);
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
			case OmlPackage.ANONYMOUS_INSTANCE__OWNING_ASSERTION:
				setOwningAssertion((PropertyValueAssertion)null);
				return;
			case OmlPackage.ANONYMOUS_INSTANCE__OWNING_AXIOM:
				setOwningAxiom((PropertyValueRestrictionAxiom)null);
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
			case OmlPackage.ANONYMOUS_INSTANCE__OWNING_ASSERTION:
				return basicGetOwningAssertion() != null;
			case OmlPackage.ANONYMOUS_INSTANCE__OWNING_AXIOM:
				return basicGetOwningAxiom() != null;
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
			case OmlPackage.ANONYMOUS_INSTANCE___GET_TYPE:
				return getType();
			case OmlPackage.ANONYMOUS_INSTANCE___GET_TYPES:
				return getTypes();
		}
		return super.eInvoke(operationID, arguments);
	}

} //AnonymousInstanceImpl
