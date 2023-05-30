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
import io.opencaesar.oml.Member;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.PropertyRestrictionAxiom;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier Equivalence Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.ClassifierEquivalenceAxiomImpl#getSuperClassifiers <em>Super Classifiers</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ClassifierEquivalenceAxiomImpl#getOwnedPropertyRestrictions <em>Owned Property Restrictions</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ClassifierEquivalenceAxiomImpl#getOwningClassifier <em>Owning Classifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassifierEquivalenceAxiomImpl extends AxiomImpl implements ClassifierEquivalenceAxiom {
	/**
	 * The cached value of the '{@link #getSuperClassifiers() <em>Super Classifiers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClassifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<Classifier> superClassifiers;

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
	protected ClassifierEquivalenceAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.CLASSIFIER_EQUIVALENCE_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Classifier> getSuperClassifiers() {
		if (superClassifiers == null) {
			superClassifiers = new EObjectResolvingEList<Classifier>(Classifier.class, this, OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__SUPER_CLASSIFIERS);
		}
		return superClassifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PropertyRestrictionAxiom> getOwnedPropertyRestrictions() {
		if (ownedPropertyRestrictions == null) {
			ownedPropertyRestrictions = new EObjectContainmentWithInverseEList<PropertyRestrictionAxiom>(PropertyRestrictionAxiom.class, this, OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM);
		}
		return ownedPropertyRestrictions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Classifier getOwningClassifier() {
		if (eContainerFeatureID() != OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNING_CLASSIFIER) return null;
		return (Classifier)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier basicGetOwningClassifier() {
		if (eContainerFeatureID() != OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNING_CLASSIFIER) return null;
		return (Classifier)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningClassifier(Classifier newOwningClassifier, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningClassifier, OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNING_CLASSIFIER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningClassifier(Classifier newOwningClassifier) {
		if (newOwningClassifier != eInternalContainer() || (eContainerFeatureID() != OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNING_CLASSIFIER && newOwningClassifier != null)) {
			if (EcoreUtil.isAncestor(this, newOwningClassifier))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningClassifier != null)
				msgs = ((InternalEObject)newOwningClassifier).eInverseAdd(this, OmlPackage.CLASSIFIER__OWNED_EQUIVALENCES, Classifier.class, msgs);
			msgs = basicSetOwningClassifier(newOwningClassifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNING_CLASSIFIER, newOwningClassifier, newOwningClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Classifier getSubClassifier() {
		Member _resolve = this.getOwningClassifier().resolve();
		return ((Classifier) _resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Classifier getCharacterizedTerm() {
		return this.getSubClassifier();
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
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedPropertyRestrictions()).basicAdd(otherEnd, msgs);
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNING_CLASSIFIER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningClassifier((Classifier)otherEnd, msgs);
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
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS:
				return ((InternalEList<?>)getOwnedPropertyRestrictions()).basicRemove(otherEnd, msgs);
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNING_CLASSIFIER:
				return basicSetOwningClassifier(null, msgs);
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
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNING_CLASSIFIER:
				return eInternalContainer().eInverseRemove(this, OmlPackage.CLASSIFIER__OWNED_EQUIVALENCES, Classifier.class, msgs);
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
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__SUPER_CLASSIFIERS:
				return getSuperClassifiers();
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS:
				return getOwnedPropertyRestrictions();
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNING_CLASSIFIER:
				if (resolve) return getOwningClassifier();
				return basicGetOwningClassifier();
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
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__SUPER_CLASSIFIERS:
				getSuperClassifiers().clear();
				getSuperClassifiers().addAll((Collection<? extends Classifier>)newValue);
				return;
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS:
				getOwnedPropertyRestrictions().clear();
				getOwnedPropertyRestrictions().addAll((Collection<? extends PropertyRestrictionAxiom>)newValue);
				return;
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNING_CLASSIFIER:
				setOwningClassifier((Classifier)newValue);
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
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__SUPER_CLASSIFIERS:
				getSuperClassifiers().clear();
				return;
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS:
				getOwnedPropertyRestrictions().clear();
				return;
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNING_CLASSIFIER:
				setOwningClassifier((Classifier)null);
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
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__SUPER_CLASSIFIERS:
				return superClassifiers != null && !superClassifiers.isEmpty();
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS:
				return ownedPropertyRestrictions != null && !ownedPropertyRestrictions.isEmpty();
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM__OWNING_CLASSIFIER:
				return basicGetOwningClassifier() != null;
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
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM___GET_SUB_CLASSIFIER:
				return getSubClassifier();
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM___GET_CHARACTERIZED_TERM:
				return getCharacterizedTerm();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ClassifierEquivalenceAxiomImpl
