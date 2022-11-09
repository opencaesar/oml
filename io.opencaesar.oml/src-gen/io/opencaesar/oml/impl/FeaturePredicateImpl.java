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

import io.opencaesar.oml.Feature;
import io.opencaesar.oml.FeaturePredicate;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.OmlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.FeaturePredicateImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.FeaturePredicateImpl#getLiteral2 <em>Literal2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeaturePredicateImpl extends BinaryPredicateImpl implements FeaturePredicate {
	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected Feature feature;

	/**
	 * The cached value of the '{@link #getLiteral2() <em>Literal2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteral2()
	 * @generated
	 * @ordered
	 */
	protected Literal literal2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeaturePredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.FEATURE_PREDICATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Feature getFeature() {
		if (feature != null && feature.eIsProxy()) {
			InternalEObject oldFeature = (InternalEObject)feature;
			feature = (Feature)eResolveProxy(oldFeature);
			if (feature != oldFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.FEATURE_PREDICATE__FEATURE, oldFeature, feature));
			}
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFeature(Feature newFeature) {
		Feature oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.FEATURE_PREDICATE__FEATURE, oldFeature, feature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Literal getLiteral2() {
		return literal2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLiteral2(Literal newLiteral2, NotificationChain msgs) {
		Literal oldLiteral2 = literal2;
		literal2 = newLiteral2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.FEATURE_PREDICATE__LITERAL2, oldLiteral2, newLiteral2);
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
	public void setLiteral2(Literal newLiteral2) {
		if (newLiteral2 != literal2) {
			NotificationChain msgs = null;
			if (literal2 != null)
				msgs = ((InternalEObject)literal2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.FEATURE_PREDICATE__LITERAL2, null, msgs);
			if (newLiteral2 != null)
				msgs = ((InternalEObject)newLiteral2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OmlPackage.FEATURE_PREDICATE__LITERAL2, null, msgs);
			msgs = basicSetLiteral2(newLiteral2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.FEATURE_PREDICATE__LITERAL2, newLiteral2, newLiteral2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.FEATURE_PREDICATE__LITERAL2:
				return basicSetLiteral2(null, msgs);
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
			case OmlPackage.FEATURE_PREDICATE__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
			case OmlPackage.FEATURE_PREDICATE__LITERAL2:
				return getLiteral2();
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
			case OmlPackage.FEATURE_PREDICATE__FEATURE:
				setFeature((Feature)newValue);
				return;
			case OmlPackage.FEATURE_PREDICATE__LITERAL2:
				setLiteral2((Literal)newValue);
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
			case OmlPackage.FEATURE_PREDICATE__FEATURE:
				setFeature((Feature)null);
				return;
			case OmlPackage.FEATURE_PREDICATE__LITERAL2:
				setLiteral2((Literal)null);
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
			case OmlPackage.FEATURE_PREDICATE__FEATURE:
				return feature != null;
			case OmlPackage.FEATURE_PREDICATE__LITERAL2:
				return literal2 != null;
		}
		return super.eIsSet(featureID);
	}

} //FeaturePredicateImpl
