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

import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Statement;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyStatement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.AnnotationPropertyImpl#getOwningVocabulary <em>Owning Vocabulary</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.AnnotationPropertyImpl#getOwnedSpecializations <em>Owned Specializations</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.AnnotationPropertyImpl#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnnotationPropertyImpl extends PropertyImpl implements AnnotationProperty {
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
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected AnnotationProperty ref;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.ANNOTATION_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vocabulary getOwningVocabulary() {
		if (eContainerFeatureID() != OmlPackage.ANNOTATION_PROPERTY__OWNING_VOCABULARY) return null;
		return (Vocabulary)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vocabulary basicGetOwningVocabulary() {
		if (eContainerFeatureID() != OmlPackage.ANNOTATION_PROPERTY__OWNING_VOCABULARY) return null;
		return (Vocabulary)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningVocabulary(Vocabulary newOwningVocabulary, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningVocabulary, OmlPackage.ANNOTATION_PROPERTY__OWNING_VOCABULARY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningVocabulary(Vocabulary newOwningVocabulary) {
		if (newOwningVocabulary != eInternalContainer() || (eContainerFeatureID() != OmlPackage.ANNOTATION_PROPERTY__OWNING_VOCABULARY && newOwningVocabulary != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.ANNOTATION_PROPERTY__OWNING_VOCABULARY, newOwningVocabulary, newOwningVocabulary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SpecializationAxiom> getOwnedSpecializations() {
		if (ownedSpecializations == null) {
			ownedSpecializations = new EObjectContainmentWithInverseEList<SpecializationAxiom>(SpecializationAxiom.class, this, OmlPackage.ANNOTATION_PROPERTY__OWNED_SPECIALIZATIONS, OmlPackage.SPECIALIZATION_AXIOM__OWNING_TERM);
		}
		return ownedSpecializations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnnotationProperty getRef() {
		if (ref != null && ref.eIsProxy()) {
			InternalEObject oldRef = (InternalEObject)ref;
			ref = (AnnotationProperty)eResolveProxy(oldRef);
			if (ref != oldRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.ANNOTATION_PROPERTY__REF, oldRef, ref));
			}
		}
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationProperty basicGetRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRef(AnnotationProperty newRef) {
		AnnotationProperty oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.ANNOTATION_PROPERTY__REF, oldRef, ref));
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
			case OmlPackage.ANNOTATION_PROPERTY__OWNING_VOCABULARY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningVocabulary((Vocabulary)otherEnd, msgs);
			case OmlPackage.ANNOTATION_PROPERTY__OWNED_SPECIALIZATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedSpecializations()).basicAdd(otherEnd, msgs);
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
			case OmlPackage.ANNOTATION_PROPERTY__OWNING_VOCABULARY:
				return basicSetOwningVocabulary(null, msgs);
			case OmlPackage.ANNOTATION_PROPERTY__OWNED_SPECIALIZATIONS:
				return ((InternalEList<?>)getOwnedSpecializations()).basicRemove(otherEnd, msgs);
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
			case OmlPackage.ANNOTATION_PROPERTY__OWNING_VOCABULARY:
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
			case OmlPackage.ANNOTATION_PROPERTY__OWNING_VOCABULARY:
				if (resolve) return getOwningVocabulary();
				return basicGetOwningVocabulary();
			case OmlPackage.ANNOTATION_PROPERTY__OWNED_SPECIALIZATIONS:
				return getOwnedSpecializations();
			case OmlPackage.ANNOTATION_PROPERTY__REF:
				if (resolve) return getRef();
				return basicGetRef();
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
			case OmlPackage.ANNOTATION_PROPERTY__OWNING_VOCABULARY:
				setOwningVocabulary((Vocabulary)newValue);
				return;
			case OmlPackage.ANNOTATION_PROPERTY__OWNED_SPECIALIZATIONS:
				getOwnedSpecializations().clear();
				getOwnedSpecializations().addAll((Collection<? extends SpecializationAxiom>)newValue);
				return;
			case OmlPackage.ANNOTATION_PROPERTY__REF:
				setRef((AnnotationProperty)newValue);
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
			case OmlPackage.ANNOTATION_PROPERTY__OWNING_VOCABULARY:
				setOwningVocabulary((Vocabulary)null);
				return;
			case OmlPackage.ANNOTATION_PROPERTY__OWNED_SPECIALIZATIONS:
				getOwnedSpecializations().clear();
				return;
			case OmlPackage.ANNOTATION_PROPERTY__REF:
				setRef((AnnotationProperty)null);
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
			case OmlPackage.ANNOTATION_PROPERTY__OWNING_VOCABULARY:
				return basicGetOwningVocabulary() != null;
			case OmlPackage.ANNOTATION_PROPERTY__OWNED_SPECIALIZATIONS:
				return ownedSpecializations != null && !ownedSpecializations.isEmpty();
			case OmlPackage.ANNOTATION_PROPERTY__REF:
				return ref != null;
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
				case OmlPackage.ANNOTATION_PROPERTY__OWNING_VOCABULARY: return OmlPackage.VOCABULARY_STATEMENT__OWNING_VOCABULARY;
				default: return -1;
			}
		}
		if (baseClass == SpecializableTerm.class) {
			switch (derivedFeatureID) {
				case OmlPackage.ANNOTATION_PROPERTY__OWNED_SPECIALIZATIONS: return OmlPackage.SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS;
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
				case OmlPackage.VOCABULARY_STATEMENT__OWNING_VOCABULARY: return OmlPackage.ANNOTATION_PROPERTY__OWNING_VOCABULARY;
				default: return -1;
			}
		}
		if (baseClass == SpecializableTerm.class) {
			switch (baseFeatureID) {
				case OmlPackage.SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS: return OmlPackage.ANNOTATION_PROPERTY__OWNED_SPECIALIZATIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //AnnotationPropertyImpl
