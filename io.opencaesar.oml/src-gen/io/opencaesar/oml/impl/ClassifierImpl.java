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

import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.ClassifierEquivalenceAxiom;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.PropertyRestrictionAxiom;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.ClassifierImpl#getOwnedEquivalences <em>Owned Equivalences</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ClassifierImpl#getOwnedPropertyRestrictions <em>Owned Property Restrictions</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ClassifierImpl extends TypeImpl implements Classifier {
	/**
	 * The cached value of the '{@link #getOwnedEquivalences() <em>Owned Equivalences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEquivalences()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassifierEquivalenceAxiom> ownedEquivalences;

	/**
	 * The cached value of the '{@link #getOwnedPropertyRestrictions() <em>Owned Property Restrictions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPropertyRestrictions()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyRestrictionAxiom> ownedPropertyRestrictions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.CLASSIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ClassifierEquivalenceAxiom> getOwnedEquivalences() {
		if (ownedEquivalences == null) {
			ownedEquivalences = new EObjectContainmentWithInverseEList<ClassifierEquivalenceAxiom>(ClassifierEquivalenceAxiom.class, this, OmlPackage.CLASSIFIER__OWNED_EQUIVALENCES, OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNING_CLASSIFIER);
		}
		return ownedEquivalences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PropertyRestrictionAxiom> getOwnedPropertyRestrictions() {
		if (ownedPropertyRestrictions == null) {
			ownedPropertyRestrictions = new EObjectContainmentWithInverseEList<PropertyRestrictionAxiom>(PropertyRestrictionAxiom.class, this, OmlPackage.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER);
		}
		return ownedPropertyRestrictions;
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
			case OmlPackage.CLASSIFIER__OWNED_EQUIVALENCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedEquivalences()).basicAdd(otherEnd, msgs);
			case OmlPackage.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedPropertyRestrictions()).basicAdd(otherEnd, msgs);
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
			case OmlPackage.CLASSIFIER__OWNED_EQUIVALENCES:
				return ((InternalEList<?>)getOwnedEquivalences()).basicRemove(otherEnd, msgs);
			case OmlPackage.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS:
				return ((InternalEList<?>)getOwnedPropertyRestrictions()).basicRemove(otherEnd, msgs);
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
			case OmlPackage.CLASSIFIER__OWNED_EQUIVALENCES:
				return getOwnedEquivalences();
			case OmlPackage.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS:
				return getOwnedPropertyRestrictions();
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
			case OmlPackage.CLASSIFIER__OWNED_EQUIVALENCES:
				getOwnedEquivalences().clear();
				getOwnedEquivalences().addAll((Collection<? extends ClassifierEquivalenceAxiom>)newValue);
				return;
			case OmlPackage.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS:
				getOwnedPropertyRestrictions().clear();
				getOwnedPropertyRestrictions().addAll((Collection<? extends PropertyRestrictionAxiom>)newValue);
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
			case OmlPackage.CLASSIFIER__OWNED_EQUIVALENCES:
				getOwnedEquivalences().clear();
				return;
			case OmlPackage.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS:
				getOwnedPropertyRestrictions().clear();
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
			case OmlPackage.CLASSIFIER__OWNED_EQUIVALENCES:
				return ownedEquivalences != null && !ownedEquivalences.isEmpty();
			case OmlPackage.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS:
				return ownedPropertyRestrictions != null && !ownedPropertyRestrictions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClassifierImpl
