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

import io.opencaesar.oml.Entity;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationEntity;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.RelationImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationImpl#getRange <em>Range</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationImpl#getInverse <em>Inverse</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RelationImpl extends FeatureImpl implements Relation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity getDomain() {
		Entity domain = basicGetDomain();
		return domain != null && domain.eIsProxy() ? (Entity)eResolveProxy((InternalEObject)domain) : domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetDomain() {
		return this.deriveDomain();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity getRange() {
		Entity range = basicGetRange();
		return range != null && range.eIsProxy() ? (Entity)eResolveProxy((InternalEObject)range) : range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetRange() {
		return this.deriveRange();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getInverse() {
		Relation inverse = basicGetInverse();
		return inverse != null && inverse.eIsProxy() ? (Relation)eResolveProxy((InternalEObject)inverse) : inverse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetInverse() {
		return this.deriveInverse();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationEntity getRelationEntity() {
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
	public Entity deriveDomain() {
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
	public Entity deriveRange() {
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
	public Relation deriveInverse() {
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OmlPackage.RELATION__DOMAIN:
				if (resolve) return getDomain();
				return basicGetDomain();
			case OmlPackage.RELATION__RANGE:
				if (resolve) return getRange();
				return basicGetRange();
			case OmlPackage.RELATION__INVERSE:
				if (resolve) return getInverse();
				return basicGetInverse();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OmlPackage.RELATION__DOMAIN:
				return basicGetDomain() != null;
			case OmlPackage.RELATION__RANGE:
				return basicGetRange() != null;
			case OmlPackage.RELATION__INVERSE:
				return basicGetInverse() != null;
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
			case OmlPackage.RELATION___GET_RELATION_ENTITY:
				return getRelationEntity();
			case OmlPackage.RELATION___DERIVE_DOMAIN:
				return deriveDomain();
			case OmlPackage.RELATION___DERIVE_RANGE:
				return deriveRange();
			case OmlPackage.RELATION___DERIVE_INVERSE:
				return deriveInverse();
		}
		return super.eInvoke(operationID, arguments);
	}

} //RelationImpl
