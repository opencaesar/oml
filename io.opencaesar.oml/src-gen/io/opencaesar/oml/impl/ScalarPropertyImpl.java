/**
 * 
 * Copyright 2019-2022 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	 http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package io.opencaesar.oml.impl;

import io.opencaesar.oml.Entity;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.PropertyEquivalenceAxiom;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.SpecializableProperty;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Statement;
import io.opencaesar.oml.Type;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyStatement;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
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
 * An implementation of the model object '<em><b>Scalar Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.ScalarPropertyImpl#getOwningVocabulary <em>Owning Vocabulary</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ScalarPropertyImpl#getOwnedSpecializations <em>Owned Specializations</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ScalarPropertyImpl#getOwnedEquivalences <em>Owned Equivalences</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ScalarPropertyImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ScalarPropertyImpl#isFunctional <em>Functional</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ScalarPropertyImpl#getDomains <em>Domains</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ScalarPropertyImpl#getRanges <em>Ranges</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScalarPropertyImpl extends SemanticPropertyImpl implements ScalarProperty {
	/**
	 * The cached value of the '{@link #getOwnedSpecializations() <em>Owned Specializations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSpecializations()
	 * @generated
	 * @ordered
	 */
	protected EList<SpecializationAxiom> ownedSpecializations;

	/**
	 * The cached value of the '{@link #getOwnedEquivalences() <em>Owned Equivalences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEquivalences()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyEquivalenceAxiom> ownedEquivalences;

	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected ScalarProperty ref;

	/**
	 * The default value of the '{@link #isFunctional() <em>Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFunctional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FUNCTIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFunctional() <em>Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFunctional()
	 * @generated
	 * @ordered
	 */
	protected boolean functional = FUNCTIONAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDomains() <em>Domains</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomains()
	 * @generated
	 * @ordered
	 */
	protected EList<Entity> domains;

	/**
	 * The cached value of the '{@link #getRanges() <em>Ranges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRanges()
	 * @generated
	 * @ordered
	 */
	protected EList<Scalar> ranges;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScalarPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.SCALAR_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vocabulary getOwningVocabulary() {
		if (eContainerFeatureID() != OmlPackage.SCALAR_PROPERTY__OWNING_VOCABULARY) return null;
		return (Vocabulary)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vocabulary basicGetOwningVocabulary() {
		if (eContainerFeatureID() != OmlPackage.SCALAR_PROPERTY__OWNING_VOCABULARY) return null;
		return (Vocabulary)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningVocabulary(Vocabulary newOwningVocabulary, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningVocabulary, OmlPackage.SCALAR_PROPERTY__OWNING_VOCABULARY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningVocabulary(Vocabulary newOwningVocabulary) {
		if (newOwningVocabulary != eInternalContainer() || (eContainerFeatureID() != OmlPackage.SCALAR_PROPERTY__OWNING_VOCABULARY && newOwningVocabulary != null)) {
			if (EcoreUtil.isAncestor(this, newOwningVocabulary))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningVocabulary != null)
				msgs = ((InternalEObject)newOwningVocabulary).eInverseAdd(this, OmlPackage.VOCABULARY__OWNED_STATEMENTS, Vocabulary.class, msgs);
			msgs = basicSetOwningVocabulary(newOwningVocabulary, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR_PROPERTY__OWNING_VOCABULARY, newOwningVocabulary, newOwningVocabulary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SpecializationAxiom> getOwnedSpecializations() {
		if (ownedSpecializations == null) {
			ownedSpecializations = new EObjectContainmentWithInverseEList<SpecializationAxiom>(SpecializationAxiom.class, this, OmlPackage.SCALAR_PROPERTY__OWNED_SPECIALIZATIONS, OmlPackage.SPECIALIZATION_AXIOM__OWNING_TERM);
		}
		return ownedSpecializations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PropertyEquivalenceAxiom> getOwnedEquivalences() {
		if (ownedEquivalences == null) {
			ownedEquivalences = new EObjectContainmentWithInverseEList<PropertyEquivalenceAxiom>(PropertyEquivalenceAxiom.class, this, OmlPackage.SCALAR_PROPERTY__OWNED_EQUIVALENCES, OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__OWNING_PROPERTY);
		}
		return ownedEquivalences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScalarProperty getRef() {
		if (ref != null && ref.eIsProxy()) {
			InternalEObject oldRef = (InternalEObject)ref;
			ref = (ScalarProperty)eResolveProxy(oldRef);
			if (ref != oldRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.SCALAR_PROPERTY__REF, oldRef, ref));
			}
		}
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScalarProperty basicGetRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRef(ScalarProperty newRef) {
		ScalarProperty oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR_PROPERTY__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFunctional() {
		return functional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFunctional(boolean newFunctional) {
		boolean oldFunctional = functional;
		functional = newFunctional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR_PROPERTY__FUNCTIONAL, oldFunctional, functional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Entity> getDomains() {
		if (domains == null) {
			domains = new EObjectResolvingEList<Entity>(Entity.class, this, OmlPackage.SCALAR_PROPERTY__DOMAINS);
		}
		return domains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Scalar> getRanges() {
		if (ranges == null) {
			ranges = new EObjectResolvingEList<Scalar>(Scalar.class, this, OmlPackage.SCALAR_PROPERTY__RANGES);
		}
		return ranges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Entity> getDomainList() {
		return this.getDomains();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Type> getRangeList() {
		return ECollections.<Type>toEList(this.getRanges());
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
			case OmlPackage.SCALAR_PROPERTY__OWNING_VOCABULARY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningVocabulary((Vocabulary)otherEnd, msgs);
			case OmlPackage.SCALAR_PROPERTY__OWNED_SPECIALIZATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedSpecializations()).basicAdd(otherEnd, msgs);
			case OmlPackage.SCALAR_PROPERTY__OWNED_EQUIVALENCES:
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
			case OmlPackage.SCALAR_PROPERTY__OWNING_VOCABULARY:
				return basicSetOwningVocabulary(null, msgs);
			case OmlPackage.SCALAR_PROPERTY__OWNED_SPECIALIZATIONS:
				return ((InternalEList<?>)getOwnedSpecializations()).basicRemove(otherEnd, msgs);
			case OmlPackage.SCALAR_PROPERTY__OWNED_EQUIVALENCES:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case OmlPackage.SCALAR_PROPERTY__OWNING_VOCABULARY:
				return eInternalContainer().eInverseRemove(this, OmlPackage.VOCABULARY__OWNED_STATEMENTS, Vocabulary.class, msgs);
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
			case OmlPackage.SCALAR_PROPERTY__OWNING_VOCABULARY:
				if (resolve) return getOwningVocabulary();
				return basicGetOwningVocabulary();
			case OmlPackage.SCALAR_PROPERTY__OWNED_SPECIALIZATIONS:
				return getOwnedSpecializations();
			case OmlPackage.SCALAR_PROPERTY__OWNED_EQUIVALENCES:
				return getOwnedEquivalences();
			case OmlPackage.SCALAR_PROPERTY__REF:
				if (resolve) return getRef();
				return basicGetRef();
			case OmlPackage.SCALAR_PROPERTY__FUNCTIONAL:
				return isFunctional();
			case OmlPackage.SCALAR_PROPERTY__DOMAINS:
				return getDomains();
			case OmlPackage.SCALAR_PROPERTY__RANGES:
				return getRanges();
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
			case OmlPackage.SCALAR_PROPERTY__OWNING_VOCABULARY:
				setOwningVocabulary((Vocabulary)newValue);
				return;
			case OmlPackage.SCALAR_PROPERTY__OWNED_SPECIALIZATIONS:
				getOwnedSpecializations().clear();
				getOwnedSpecializations().addAll((Collection<? extends SpecializationAxiom>)newValue);
				return;
			case OmlPackage.SCALAR_PROPERTY__OWNED_EQUIVALENCES:
				getOwnedEquivalences().clear();
				getOwnedEquivalences().addAll((Collection<? extends PropertyEquivalenceAxiom>)newValue);
				return;
			case OmlPackage.SCALAR_PROPERTY__REF:
				setRef((ScalarProperty)newValue);
				return;
			case OmlPackage.SCALAR_PROPERTY__FUNCTIONAL:
				setFunctional((Boolean)newValue);
				return;
			case OmlPackage.SCALAR_PROPERTY__DOMAINS:
				getDomains().clear();
				getDomains().addAll((Collection<? extends Entity>)newValue);
				return;
			case OmlPackage.SCALAR_PROPERTY__RANGES:
				getRanges().clear();
				getRanges().addAll((Collection<? extends Scalar>)newValue);
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
			case OmlPackage.SCALAR_PROPERTY__OWNING_VOCABULARY:
				setOwningVocabulary((Vocabulary)null);
				return;
			case OmlPackage.SCALAR_PROPERTY__OWNED_SPECIALIZATIONS:
				getOwnedSpecializations().clear();
				return;
			case OmlPackage.SCALAR_PROPERTY__OWNED_EQUIVALENCES:
				getOwnedEquivalences().clear();
				return;
			case OmlPackage.SCALAR_PROPERTY__REF:
				setRef((ScalarProperty)null);
				return;
			case OmlPackage.SCALAR_PROPERTY__FUNCTIONAL:
				setFunctional(FUNCTIONAL_EDEFAULT);
				return;
			case OmlPackage.SCALAR_PROPERTY__DOMAINS:
				getDomains().clear();
				return;
			case OmlPackage.SCALAR_PROPERTY__RANGES:
				getRanges().clear();
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
			case OmlPackage.SCALAR_PROPERTY__OWNING_VOCABULARY:
				return basicGetOwningVocabulary() != null;
			case OmlPackage.SCALAR_PROPERTY__OWNED_SPECIALIZATIONS:
				return ownedSpecializations != null && !ownedSpecializations.isEmpty();
			case OmlPackage.SCALAR_PROPERTY__OWNED_EQUIVALENCES:
				return ownedEquivalences != null && !ownedEquivalences.isEmpty();
			case OmlPackage.SCALAR_PROPERTY__REF:
				return ref != null;
			case OmlPackage.SCALAR_PROPERTY__FUNCTIONAL:
				return functional != FUNCTIONAL_EDEFAULT;
			case OmlPackage.SCALAR_PROPERTY__DOMAINS:
				return domains != null && !domains.isEmpty();
			case OmlPackage.SCALAR_PROPERTY__RANGES:
				return ranges != null && !ranges.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Statement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == VocabularyStatement.class) {
			switch (derivedFeatureID) {
				case OmlPackage.SCALAR_PROPERTY__OWNING_VOCABULARY: return OmlPackage.VOCABULARY_STATEMENT__OWNING_VOCABULARY;
				default: return -1;
			}
		}
		if (baseClass == SpecializableTerm.class) {
			switch (derivedFeatureID) {
				case OmlPackage.SCALAR_PROPERTY__OWNED_SPECIALIZATIONS: return OmlPackage.SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS;
				default: return -1;
			}
		}
		if (baseClass == SpecializableProperty.class) {
			switch (derivedFeatureID) {
				case OmlPackage.SCALAR_PROPERTY__OWNED_EQUIVALENCES: return OmlPackage.SPECIALIZABLE_PROPERTY__OWNED_EQUIVALENCES;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Statement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == VocabularyStatement.class) {
			switch (baseFeatureID) {
				case OmlPackage.VOCABULARY_STATEMENT__OWNING_VOCABULARY: return OmlPackage.SCALAR_PROPERTY__OWNING_VOCABULARY;
				default: return -1;
			}
		}
		if (baseClass == SpecializableTerm.class) {
			switch (baseFeatureID) {
				case OmlPackage.SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS: return OmlPackage.SCALAR_PROPERTY__OWNED_SPECIALIZATIONS;
				default: return -1;
			}
		}
		if (baseClass == SpecializableProperty.class) {
			switch (baseFeatureID) {
				case OmlPackage.SPECIALIZABLE_PROPERTY__OWNED_EQUIVALENCES: return OmlPackage.SCALAR_PROPERTY__OWNED_EQUIVALENCES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OmlPackage.SCALAR_PROPERTY___GET_DOMAIN_LIST:
				return getDomainList();
			case OmlPackage.SCALAR_PROPERTY___GET_RANGE_LIST:
				return getRangeList();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (functional: ");
		result.append(functional);
		result.append(')');
		return result.toString();
	}

} //ScalarPropertyImpl
