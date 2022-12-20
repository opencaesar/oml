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
import io.opencaesar.oml.ClassifierReference;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Property;
import io.opencaesar.oml.PropertyRestrictionAxiom;

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
 * An implementation of the model object '<em><b>Property Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.PropertyRestrictionAxiomImpl#getOwningClassifier <em>Owning Classifier</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PropertyRestrictionAxiomImpl#getOwningReference <em>Owning Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PropertyRestrictionAxiomImpl extends AxiomImpl implements PropertyRestrictionAxiom {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyRestrictionAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Classifier getOwningClassifier() {
		if (eContainerFeatureID() != OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER) return null;
		return (Classifier)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier basicGetOwningClassifier() {
		if (eContainerFeatureID() != OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER) return null;
		return (Classifier)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningClassifier(Classifier newOwningClassifier, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningClassifier, OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningClassifier(Classifier newOwningClassifier) {
		if (newOwningClassifier != eInternalContainer() || (eContainerFeatureID() != OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER && newOwningClassifier != null)) {
			if (EcoreUtil.isAncestor(this, newOwningClassifier))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningClassifier != null)
				msgs = ((InternalEObject)newOwningClassifier).eInverseAdd(this, OmlPackage.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, Classifier.class, msgs);
			msgs = basicSetOwningClassifier(newOwningClassifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER, newOwningClassifier, newOwningClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassifierReference getOwningReference() {
		if (eContainerFeatureID() != OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_REFERENCE) return null;
		return (ClassifierReference)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierReference basicGetOwningReference() {
		if (eContainerFeatureID() != OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_REFERENCE) return null;
		return (ClassifierReference)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningReference(ClassifierReference newOwningReference, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningReference, OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_REFERENCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningReference(ClassifierReference newOwningReference) {
		if (newOwningReference != eInternalContainer() || (eContainerFeatureID() != OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_REFERENCE && newOwningReference != null)) {
			if (EcoreUtil.isAncestor(this, newOwningReference))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningReference != null)
				msgs = ((InternalEObject)newOwningReference).eInverseAdd(this, OmlPackage.CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS, ClassifierReference.class, msgs);
			msgs = basicSetOwningReference(newOwningReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_REFERENCE, newOwningReference, newOwningReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getProperty() {
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningClassifier((Classifier)otherEnd, msgs);
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_REFERENCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningReference((ClassifierReference)otherEnd, msgs);
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
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER:
				return basicSetOwningClassifier(null, msgs);
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_REFERENCE:
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
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER:
				return eInternalContainer().eInverseRemove(this, OmlPackage.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, Classifier.class, msgs);
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_REFERENCE:
				return eInternalContainer().eInverseRemove(this, OmlPackage.CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS, ClassifierReference.class, msgs);
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
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER:
				if (resolve) return getOwningClassifier();
				return basicGetOwningClassifier();
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_REFERENCE:
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
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER:
				setOwningClassifier((Classifier)newValue);
				return;
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_REFERENCE:
				setOwningReference((ClassifierReference)newValue);
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
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER:
				setOwningClassifier((Classifier)null);
				return;
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_REFERENCE:
				setOwningReference((ClassifierReference)null);
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
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER:
				return basicGetOwningClassifier() != null;
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_REFERENCE:
				return basicGetOwningReference() != null;
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
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM___GET_PROPERTY:
				return getProperty();
		}
		return super.eInvoke(operationID, arguments);
	}

} //PropertyRestrictionAxiomImpl
