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
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.RuleImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RuleImpl#getAntecedent <em>Antecedent</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RuleImpl#getConsequent <em>Consequent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleImpl extends VocabularyStatementImpl implements Rule {
	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected Rule ref;

	/**
	 * The cached value of the '{@link #getAntecedent() <em>Antecedent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAntecedent()
	 * @generated
	 * @ordered
	 */
	protected EList<Predicate> antecedent;

	/**
	 * The cached value of the '{@link #getConsequent() <em>Consequent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsequent()
	 * @generated
	 * @ordered
	 */
	protected EList<Predicate> consequent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rule getRef() {
		if (ref != null && ref.eIsProxy()) {
			InternalEObject oldRef = (InternalEObject)ref;
			ref = (Rule)eResolveProxy(oldRef);
			if (ref != oldRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.RULE__REF, oldRef, ref));
			}
		}
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule basicGetRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRef(Rule newRef) {
		Rule oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RULE__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Predicate> getAntecedent() {
		if (antecedent == null) {
			antecedent = new EObjectContainmentWithInverseEList<Predicate>(Predicate.class, this, OmlPackage.RULE__ANTECEDENT, OmlPackage.PREDICATE__ANTECEDENT_RULE);
		}
		return antecedent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Predicate> getConsequent() {
		if (consequent == null) {
			consequent = new EObjectContainmentWithInverseEList<Predicate>(Predicate.class, this, OmlPackage.RULE__CONSEQUENT, OmlPackage.PREDICATE__CONSEQUENT_RULE);
		}
		return consequent;
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
			case OmlPackage.RULE__ANTECEDENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAntecedent()).basicAdd(otherEnd, msgs);
			case OmlPackage.RULE__CONSEQUENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConsequent()).basicAdd(otherEnd, msgs);
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
			case OmlPackage.RULE__ANTECEDENT:
				return ((InternalEList<?>)getAntecedent()).basicRemove(otherEnd, msgs);
			case OmlPackage.RULE__CONSEQUENT:
				return ((InternalEList<?>)getConsequent()).basicRemove(otherEnd, msgs);
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
			case OmlPackage.RULE__REF:
				if (resolve) return getRef();
				return basicGetRef();
			case OmlPackage.RULE__ANTECEDENT:
				return getAntecedent();
			case OmlPackage.RULE__CONSEQUENT:
				return getConsequent();
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
			case OmlPackage.RULE__REF:
				setRef((Rule)newValue);
				return;
			case OmlPackage.RULE__ANTECEDENT:
				getAntecedent().clear();
				getAntecedent().addAll((Collection<? extends Predicate>)newValue);
				return;
			case OmlPackage.RULE__CONSEQUENT:
				getConsequent().clear();
				getConsequent().addAll((Collection<? extends Predicate>)newValue);
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
			case OmlPackage.RULE__REF:
				setRef((Rule)null);
				return;
			case OmlPackage.RULE__ANTECEDENT:
				getAntecedent().clear();
				return;
			case OmlPackage.RULE__CONSEQUENT:
				getConsequent().clear();
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
			case OmlPackage.RULE__REF:
				return ref != null;
			case OmlPackage.RULE__ANTECEDENT:
				return antecedent != null && !antecedent.isEmpty();
			case OmlPackage.RULE__CONSEQUENT:
				return consequent != null && !consequent.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RuleImpl
