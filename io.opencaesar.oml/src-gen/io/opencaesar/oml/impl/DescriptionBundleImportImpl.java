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

import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.DescriptionBundleImport;
import io.opencaesar.oml.OmlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Description Bundle Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.DescriptionBundleImportImpl#getOwningDescriptionBundle <em>Owning Description Bundle</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DescriptionBundleImportImpl extends ImportImpl implements DescriptionBundleImport {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DescriptionBundleImportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.DESCRIPTION_BUNDLE_IMPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DescriptionBundle getOwningDescriptionBundle() {
		if (eContainerFeatureID() != OmlPackage.DESCRIPTION_BUNDLE_IMPORT__OWNING_DESCRIPTION_BUNDLE) return null;
		return (DescriptionBundle)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBundle basicGetOwningDescriptionBundle() {
		if (eContainerFeatureID() != OmlPackage.DESCRIPTION_BUNDLE_IMPORT__OWNING_DESCRIPTION_BUNDLE) return null;
		return (DescriptionBundle)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningDescriptionBundle(DescriptionBundle newOwningDescriptionBundle, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningDescriptionBundle, OmlPackage.DESCRIPTION_BUNDLE_IMPORT__OWNING_DESCRIPTION_BUNDLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningDescriptionBundle(DescriptionBundle newOwningDescriptionBundle) {
		if (newOwningDescriptionBundle != eInternalContainer() || (eContainerFeatureID() != OmlPackage.DESCRIPTION_BUNDLE_IMPORT__OWNING_DESCRIPTION_BUNDLE && newOwningDescriptionBundle != null)) {
			if (EcoreUtil.isAncestor(this, newOwningDescriptionBundle))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningDescriptionBundle != null)
				msgs = ((InternalEObject)newOwningDescriptionBundle).eInverseAdd(this, OmlPackage.DESCRIPTION_BUNDLE__OWNED_IMPORTS, DescriptionBundle.class, msgs);
			msgs = basicSetOwningDescriptionBundle(newOwningDescriptionBundle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.DESCRIPTION_BUNDLE_IMPORT__OWNING_DESCRIPTION_BUNDLE, newOwningDescriptionBundle, newOwningDescriptionBundle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.DESCRIPTION_BUNDLE_IMPORT__OWNING_DESCRIPTION_BUNDLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningDescriptionBundle((DescriptionBundle)otherEnd, msgs);
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
			case OmlPackage.DESCRIPTION_BUNDLE_IMPORT__OWNING_DESCRIPTION_BUNDLE:
				return basicSetOwningDescriptionBundle(null, msgs);
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
			case OmlPackage.DESCRIPTION_BUNDLE_IMPORT__OWNING_DESCRIPTION_BUNDLE:
				return eInternalContainer().eInverseRemove(this, OmlPackage.DESCRIPTION_BUNDLE__OWNED_IMPORTS, DescriptionBundle.class, msgs);
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
			case OmlPackage.DESCRIPTION_BUNDLE_IMPORT__OWNING_DESCRIPTION_BUNDLE:
				if (resolve) return getOwningDescriptionBundle();
				return basicGetOwningDescriptionBundle();
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
			case OmlPackage.DESCRIPTION_BUNDLE_IMPORT__OWNING_DESCRIPTION_BUNDLE:
				setOwningDescriptionBundle((DescriptionBundle)newValue);
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
			case OmlPackage.DESCRIPTION_BUNDLE_IMPORT__OWNING_DESCRIPTION_BUNDLE:
				setOwningDescriptionBundle((DescriptionBundle)null);
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
			case OmlPackage.DESCRIPTION_BUNDLE_IMPORT__OWNING_DESCRIPTION_BUNDLE:
				return basicGetOwningDescriptionBundle() != null;
		}
		return super.eIsSet(featureID);
	}

} //DescriptionBundleImportImpl
