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
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationReference;
import io.opencaesar.oml.Statement;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyStatement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.RelationReferenceImpl#getOwningVocabulary <em>Owning Vocabulary</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationReferenceImpl#getRelation <em>Relation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationReferenceImpl extends ReferenceImpl implements RelationReference {
	/**
	 * The cached value of the '{@link #getRelation() <em>Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected Relation relation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.RELATION_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vocabulary getOwningVocabulary() {
		if (eContainerFeatureID() != OmlPackage.RELATION_REFERENCE__OWNING_VOCABULARY) return null;
		return (Vocabulary)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vocabulary basicGetOwningVocabulary() {
		if (eContainerFeatureID() != OmlPackage.RELATION_REFERENCE__OWNING_VOCABULARY) return null;
		return (Vocabulary)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningVocabulary(Vocabulary newOwningVocabulary, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningVocabulary, OmlPackage.RELATION_REFERENCE__OWNING_VOCABULARY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningVocabulary(Vocabulary newOwningVocabulary) {
		if (newOwningVocabulary != eInternalContainer() || (eContainerFeatureID() != OmlPackage.RELATION_REFERENCE__OWNING_VOCABULARY && newOwningVocabulary != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_REFERENCE__OWNING_VOCABULARY, newOwningVocabulary, newOwningVocabulary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getRelation() {
		if (relation != null && relation.eIsProxy()) {
			InternalEObject oldRelation = (InternalEObject)relation;
			relation = (Relation)eResolveProxy(oldRelation);
			if (relation != oldRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.RELATION_REFERENCE__RELATION, oldRelation, relation));
			}
		}
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetRelation() {
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelation(Relation newRelation) {
		Relation oldRelation = relation;
		relation = newRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_REFERENCE__RELATION, oldRelation, relation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.RELATION_REFERENCE__OWNING_VOCABULARY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningVocabulary((Vocabulary)otherEnd, msgs);
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
			case OmlPackage.RELATION_REFERENCE__OWNING_VOCABULARY:
				return basicSetOwningVocabulary(null, msgs);
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
			case OmlPackage.RELATION_REFERENCE__OWNING_VOCABULARY:
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
			case OmlPackage.RELATION_REFERENCE__OWNING_VOCABULARY:
				if (resolve) return getOwningVocabulary();
				return basicGetOwningVocabulary();
			case OmlPackage.RELATION_REFERENCE__RELATION:
				if (resolve) return getRelation();
				return basicGetRelation();
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
			case OmlPackage.RELATION_REFERENCE__OWNING_VOCABULARY:
				setOwningVocabulary((Vocabulary)newValue);
				return;
			case OmlPackage.RELATION_REFERENCE__RELATION:
				setRelation((Relation)newValue);
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
			case OmlPackage.RELATION_REFERENCE__OWNING_VOCABULARY:
				setOwningVocabulary((Vocabulary)null);
				return;
			case OmlPackage.RELATION_REFERENCE__RELATION:
				setRelation((Relation)null);
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
			case OmlPackage.RELATION_REFERENCE__OWNING_VOCABULARY:
				return basicGetOwningVocabulary() != null;
			case OmlPackage.RELATION_REFERENCE__RELATION:
				return relation != null;
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
				case OmlPackage.RELATION_REFERENCE__OWNING_VOCABULARY: return OmlPackage.VOCABULARY_STATEMENT__OWNING_VOCABULARY;
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
				case OmlPackage.VOCABULARY_STATEMENT__OWNING_VOCABULARY: return OmlPackage.RELATION_REFERENCE__OWNING_VOCABULARY;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //RelationReferenceImpl
