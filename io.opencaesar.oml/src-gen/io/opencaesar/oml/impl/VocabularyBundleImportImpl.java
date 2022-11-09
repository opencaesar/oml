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
import io.opencaesar.oml.VocabularyBundle;
import io.opencaesar.oml.VocabularyBundleImport;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vocabulary Bundle Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.VocabularyBundleImportImpl#getOwningVocabularyBundle <em>Owning Vocabulary Bundle</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class VocabularyBundleImportImpl extends ImportImpl implements VocabularyBundleImport {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VocabularyBundleImportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.VOCABULARY_BUNDLE_IMPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VocabularyBundle getOwningVocabularyBundle() {
		if (eContainerFeatureID() != OmlPackage.VOCABULARY_BUNDLE_IMPORT__OWNING_VOCABULARY_BUNDLE) return null;
		return (VocabularyBundle)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VocabularyBundle basicGetOwningVocabularyBundle() {
		if (eContainerFeatureID() != OmlPackage.VOCABULARY_BUNDLE_IMPORT__OWNING_VOCABULARY_BUNDLE) return null;
		return (VocabularyBundle)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningVocabularyBundle(VocabularyBundle newOwningVocabularyBundle, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningVocabularyBundle, OmlPackage.VOCABULARY_BUNDLE_IMPORT__OWNING_VOCABULARY_BUNDLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningVocabularyBundle(VocabularyBundle newOwningVocabularyBundle) {
		if (newOwningVocabularyBundle != eInternalContainer() || (eContainerFeatureID() != OmlPackage.VOCABULARY_BUNDLE_IMPORT__OWNING_VOCABULARY_BUNDLE && newOwningVocabularyBundle != null)) {
			if (EcoreUtil.isAncestor(this, newOwningVocabularyBundle))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningVocabularyBundle != null)
				msgs = ((InternalEObject)newOwningVocabularyBundle).eInverseAdd(this, OmlPackage.VOCABULARY_BUNDLE__OWNED_IMPORTS, VocabularyBundle.class, msgs);
			msgs = basicSetOwningVocabularyBundle(newOwningVocabularyBundle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.VOCABULARY_BUNDLE_IMPORT__OWNING_VOCABULARY_BUNDLE, newOwningVocabularyBundle, newOwningVocabularyBundle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.VOCABULARY_BUNDLE_IMPORT__OWNING_VOCABULARY_BUNDLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningVocabularyBundle((VocabularyBundle)otherEnd, msgs);
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
			case OmlPackage.VOCABULARY_BUNDLE_IMPORT__OWNING_VOCABULARY_BUNDLE:
				return basicSetOwningVocabularyBundle(null, msgs);
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
			case OmlPackage.VOCABULARY_BUNDLE_IMPORT__OWNING_VOCABULARY_BUNDLE:
				return eInternalContainer().eInverseRemove(this, OmlPackage.VOCABULARY_BUNDLE__OWNED_IMPORTS, VocabularyBundle.class, msgs);
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
			case OmlPackage.VOCABULARY_BUNDLE_IMPORT__OWNING_VOCABULARY_BUNDLE:
				if (resolve) return getOwningVocabularyBundle();
				return basicGetOwningVocabularyBundle();
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
			case OmlPackage.VOCABULARY_BUNDLE_IMPORT__OWNING_VOCABULARY_BUNDLE:
				setOwningVocabularyBundle((VocabularyBundle)newValue);
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
			case OmlPackage.VOCABULARY_BUNDLE_IMPORT__OWNING_VOCABULARY_BUNDLE:
				setOwningVocabularyBundle((VocabularyBundle)null);
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
			case OmlPackage.VOCABULARY_BUNDLE_IMPORT__OWNING_VOCABULARY_BUNDLE:
				return basicGetOwningVocabularyBundle() != null;
		}
		return super.eIsSet(featureID);
	}

} //VocabularyBundleImportImpl
