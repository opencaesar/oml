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

import io.opencaesar.oml.EnumeratedScalar;
import io.opencaesar.oml.EnumeratedScalarReference;
import io.opencaesar.oml.OmlPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumerated Scalar Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.EnumeratedScalarReferenceImpl#getScalar <em>Scalar</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumeratedScalarReferenceImpl extends SpecializableTermReferenceImpl implements EnumeratedScalarReference {
	/**
	 * The cached value of the '{@link #getScalar() <em>Scalar</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScalar()
	 * @generated
	 * @ordered
	 */
	protected EnumeratedScalar scalar;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumeratedScalarReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.ENUMERATED_SCALAR_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumeratedScalar getScalar() {
		if (scalar != null && scalar.eIsProxy()) {
			InternalEObject oldScalar = (InternalEObject)scalar;
			scalar = (EnumeratedScalar)eResolveProxy(oldScalar);
			if (scalar != oldScalar) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.ENUMERATED_SCALAR_REFERENCE__SCALAR, oldScalar, scalar));
			}
		}
		return scalar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumeratedScalar basicGetScalar() {
		return scalar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScalar(EnumeratedScalar newScalar) {
		EnumeratedScalar oldScalar = scalar;
		scalar = newScalar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.ENUMERATED_SCALAR_REFERENCE__SCALAR, oldScalar, scalar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OmlPackage.ENUMERATED_SCALAR_REFERENCE__SCALAR:
				if (resolve) return getScalar();
				return basicGetScalar();
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
			case OmlPackage.ENUMERATED_SCALAR_REFERENCE__SCALAR:
				setScalar((EnumeratedScalar)newValue);
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
			case OmlPackage.ENUMERATED_SCALAR_REFERENCE__SCALAR:
				setScalar((EnumeratedScalar)null);
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
			case OmlPackage.ENUMERATED_SCALAR_REFERENCE__SCALAR:
				return scalar != null;
		}
		return super.eIsSet(featureID);
	}

} //EnumeratedScalarReferenceImpl
