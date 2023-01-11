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

import io.opencaesar.oml.Instance;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.TypeAssertion;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.NamedInstanceImpl#getOwnedPropertyValues <em>Owned Property Values</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.NamedInstanceImpl#getOwnedTypes <em>Owned Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NamedInstanceImpl extends DescriptionStatementImpl implements NamedInstance {
	/**
	 * The cached value of the '{@link #getOwnedPropertyValues() <em>Owned Property Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPropertyValues()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyValueAssertion> ownedPropertyValues;

	/**
	 * The cached value of the '{@link #getOwnedTypes() <em>Owned Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeAssertion> ownedTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.NAMED_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PropertyValueAssertion> getOwnedPropertyValues() {
		if (ownedPropertyValues == null) {
			ownedPropertyValues = new EObjectContainmentWithInverseEList<PropertyValueAssertion>(PropertyValueAssertion.class, this, OmlPackage.NAMED_INSTANCE__OWNED_PROPERTY_VALUES, OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE);
		}
		return ownedPropertyValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TypeAssertion> getOwnedTypes() {
		if (ownedTypes == null) {
			ownedTypes = new EObjectContainmentWithInverseEList<TypeAssertion>(TypeAssertion.class, this, OmlPackage.NAMED_INSTANCE__OWNED_TYPES, OmlPackage.TYPE_ASSERTION__OWNING_INSTANCE);
		}
		return ownedTypes;
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
			case OmlPackage.NAMED_INSTANCE__OWNED_PROPERTY_VALUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedPropertyValues()).basicAdd(otherEnd, msgs);
			case OmlPackage.NAMED_INSTANCE__OWNED_TYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTypes()).basicAdd(otherEnd, msgs);
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
			case OmlPackage.NAMED_INSTANCE__OWNED_PROPERTY_VALUES:
				return ((InternalEList<?>)getOwnedPropertyValues()).basicRemove(otherEnd, msgs);
			case OmlPackage.NAMED_INSTANCE__OWNED_TYPES:
				return ((InternalEList<?>)getOwnedTypes()).basicRemove(otherEnd, msgs);
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
			case OmlPackage.NAMED_INSTANCE__OWNED_PROPERTY_VALUES:
				return getOwnedPropertyValues();
			case OmlPackage.NAMED_INSTANCE__OWNED_TYPES:
				return getOwnedTypes();
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
			case OmlPackage.NAMED_INSTANCE__OWNED_PROPERTY_VALUES:
				getOwnedPropertyValues().clear();
				getOwnedPropertyValues().addAll((Collection<? extends PropertyValueAssertion>)newValue);
				return;
			case OmlPackage.NAMED_INSTANCE__OWNED_TYPES:
				getOwnedTypes().clear();
				getOwnedTypes().addAll((Collection<? extends TypeAssertion>)newValue);
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
			case OmlPackage.NAMED_INSTANCE__OWNED_PROPERTY_VALUES:
				getOwnedPropertyValues().clear();
				return;
			case OmlPackage.NAMED_INSTANCE__OWNED_TYPES:
				getOwnedTypes().clear();
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
			case OmlPackage.NAMED_INSTANCE__OWNED_PROPERTY_VALUES:
				return ownedPropertyValues != null && !ownedPropertyValues.isEmpty();
			case OmlPackage.NAMED_INSTANCE__OWNED_TYPES:
				return ownedTypes != null && !ownedTypes.isEmpty();
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
		if (baseClass == Instance.class) {
			switch (derivedFeatureID) {
				case OmlPackage.NAMED_INSTANCE__OWNED_PROPERTY_VALUES: return OmlPackage.INSTANCE__OWNED_PROPERTY_VALUES;
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
		if (baseClass == Instance.class) {
			switch (baseFeatureID) {
				case OmlPackage.INSTANCE__OWNED_PROPERTY_VALUES: return OmlPackage.NAMED_INSTANCE__OWNED_PROPERTY_VALUES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //NamedInstanceImpl
