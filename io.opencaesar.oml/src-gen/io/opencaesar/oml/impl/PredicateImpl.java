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
import io.opencaesar.oml.Predicate;
import io.opencaesar.oml.Rule;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.PredicateImpl#getAntecedentRule <em>Antecedent Rule</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PredicateImpl#getConsequentRule <em>Consequent Rule</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PredicateImpl extends ElementImpl implements Predicate {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.PREDICATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rule getAntecedentRule() {
		if (eContainerFeatureID() != OmlPackage.PREDICATE__ANTECEDENT_RULE) return null;
		return (Rule)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule basicGetAntecedentRule() {
		if (eContainerFeatureID() != OmlPackage.PREDICATE__ANTECEDENT_RULE) return null;
		return (Rule)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAntecedentRule(Rule newAntecedentRule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAntecedentRule, OmlPackage.PREDICATE__ANTECEDENT_RULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAntecedentRule(Rule newAntecedentRule) {
		if (newAntecedentRule != eInternalContainer() || (eContainerFeatureID() != OmlPackage.PREDICATE__ANTECEDENT_RULE && newAntecedentRule != null)) {
			if (EcoreUtil.isAncestor(this, newAntecedentRule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAntecedentRule != null)
				msgs = ((InternalEObject)newAntecedentRule).eInverseAdd(this, OmlPackage.RULE__ANTECEDENT, Rule.class, msgs);
			msgs = basicSetAntecedentRule(newAntecedentRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PREDICATE__ANTECEDENT_RULE, newAntecedentRule, newAntecedentRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rule getConsequentRule() {
		if (eContainerFeatureID() != OmlPackage.PREDICATE__CONSEQUENT_RULE) return null;
		return (Rule)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule basicGetConsequentRule() {
		if (eContainerFeatureID() != OmlPackage.PREDICATE__CONSEQUENT_RULE) return null;
		return (Rule)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConsequentRule(Rule newConsequentRule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConsequentRule, OmlPackage.PREDICATE__CONSEQUENT_RULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConsequentRule(Rule newConsequentRule) {
		if (newConsequentRule != eInternalContainer() || (eContainerFeatureID() != OmlPackage.PREDICATE__CONSEQUENT_RULE && newConsequentRule != null)) {
			if (EcoreUtil.isAncestor(this, newConsequentRule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConsequentRule != null)
				msgs = ((InternalEObject)newConsequentRule).eInverseAdd(this, OmlPackage.RULE__CONSEQUENT, Rule.class, msgs);
			msgs = basicSetConsequentRule(newConsequentRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PREDICATE__CONSEQUENT_RULE, newConsequentRule, newConsequentRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.PREDICATE__ANTECEDENT_RULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAntecedentRule((Rule)otherEnd, msgs);
			case OmlPackage.PREDICATE__CONSEQUENT_RULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConsequentRule((Rule)otherEnd, msgs);
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
			case OmlPackage.PREDICATE__ANTECEDENT_RULE:
				return basicSetAntecedentRule(null, msgs);
			case OmlPackage.PREDICATE__CONSEQUENT_RULE:
				return basicSetConsequentRule(null, msgs);
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
			case OmlPackage.PREDICATE__ANTECEDENT_RULE:
				return eInternalContainer().eInverseRemove(this, OmlPackage.RULE__ANTECEDENT, Rule.class, msgs);
			case OmlPackage.PREDICATE__CONSEQUENT_RULE:
				return eInternalContainer().eInverseRemove(this, OmlPackage.RULE__CONSEQUENT, Rule.class, msgs);
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
			case OmlPackage.PREDICATE__ANTECEDENT_RULE:
				if (resolve) return getAntecedentRule();
				return basicGetAntecedentRule();
			case OmlPackage.PREDICATE__CONSEQUENT_RULE:
				if (resolve) return getConsequentRule();
				return basicGetConsequentRule();
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
			case OmlPackage.PREDICATE__ANTECEDENT_RULE:
				setAntecedentRule((Rule)newValue);
				return;
			case OmlPackage.PREDICATE__CONSEQUENT_RULE:
				setConsequentRule((Rule)newValue);
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
			case OmlPackage.PREDICATE__ANTECEDENT_RULE:
				setAntecedentRule((Rule)null);
				return;
			case OmlPackage.PREDICATE__CONSEQUENT_RULE:
				setConsequentRule((Rule)null);
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
			case OmlPackage.PREDICATE__ANTECEDENT_RULE:
				return basicGetAntecedentRule() != null;
			case OmlPackage.PREDICATE__CONSEQUENT_RULE:
				return basicGetConsequentRule() != null;
		}
		return super.eIsSet(featureID);
	}

} //PredicateImpl
