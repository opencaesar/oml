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

import io.opencaesar.oml.BinaryPredicate;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Entity Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.RelationEntityPredicateImpl#getVariable1 <em>Variable1</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationEntityPredicateImpl#getVariable2 <em>Variable2</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationEntityPredicateImpl#getInstance2 <em>Instance2</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationEntityPredicateImpl#getEntity <em>Entity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationEntityPredicateImpl extends UnaryPredicateImpl implements RelationEntityPredicate {
	/**
	 * The default value of the '{@link #getVariable1() <em>Variable1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable1()
	 * @generated
	 * @ordered
	 */
	protected static final String VARIABLE1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariable1() <em>Variable1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable1()
	 * @generated
	 * @ordered
	 */
	protected String variable1 = VARIABLE1_EDEFAULT;

	/**
	 * The default value of the '{@link #getVariable2() <em>Variable2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable2()
	 * @generated
	 * @ordered
	 */
	protected static final String VARIABLE2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariable2() <em>Variable2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable2()
	 * @generated
	 * @ordered
	 */
	protected String variable2 = VARIABLE2_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInstance2() <em>Instance2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstance2()
	 * @generated
	 * @ordered
	 */
	protected NamedInstance instance2;

	/**
	 * The cached value of the '{@link #getEntity() <em>Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntity()
	 * @generated
	 * @ordered
	 */
	protected RelationEntity entity;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationEntityPredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.RELATION_ENTITY_PREDICATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVariable1() {
		return variable1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVariable1(String newVariable1) {
		String oldVariable1 = variable1;
		variable1 = newVariable1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY_PREDICATE__VARIABLE1, oldVariable1, variable1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVariable2() {
		return variable2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVariable2(String newVariable2) {
		String oldVariable2 = variable2;
		variable2 = newVariable2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY_PREDICATE__VARIABLE2, oldVariable2, variable2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedInstance getInstance2() {
		if (instance2 != null && instance2.eIsProxy()) {
			InternalEObject oldInstance2 = (InternalEObject)instance2;
			instance2 = (NamedInstance)eResolveProxy(oldInstance2);
			if (instance2 != oldInstance2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.RELATION_ENTITY_PREDICATE__INSTANCE2, oldInstance2, instance2));
			}
		}
		return instance2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedInstance basicGetInstance2() {
		return instance2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstance2(NamedInstance newInstance2) {
		NamedInstance oldInstance2 = instance2;
		instance2 = newInstance2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY_PREDICATE__INSTANCE2, oldInstance2, instance2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationEntity getEntity() {
		if (entity != null && entity.eIsProxy()) {
			InternalEObject oldEntity = (InternalEObject)entity;
			entity = (RelationEntity)eResolveProxy(oldEntity);
			if (entity != oldEntity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.RELATION_ENTITY_PREDICATE__ENTITY, oldEntity, entity));
			}
		}
		return entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationEntity basicGetEntity() {
		return entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEntity(RelationEntity newEntity) {
		RelationEntity oldEntity = entity;
		entity = newEntity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY_PREDICATE__ENTITY, oldEntity, entity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OmlPackage.RELATION_ENTITY_PREDICATE__VARIABLE1:
				return getVariable1();
			case OmlPackage.RELATION_ENTITY_PREDICATE__VARIABLE2:
				return getVariable2();
			case OmlPackage.RELATION_ENTITY_PREDICATE__INSTANCE2:
				if (resolve) return getInstance2();
				return basicGetInstance2();
			case OmlPackage.RELATION_ENTITY_PREDICATE__ENTITY:
				if (resolve) return getEntity();
				return basicGetEntity();
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
			case OmlPackage.RELATION_ENTITY_PREDICATE__VARIABLE1:
				setVariable1((String)newValue);
				return;
			case OmlPackage.RELATION_ENTITY_PREDICATE__VARIABLE2:
				setVariable2((String)newValue);
				return;
			case OmlPackage.RELATION_ENTITY_PREDICATE__INSTANCE2:
				setInstance2((NamedInstance)newValue);
				return;
			case OmlPackage.RELATION_ENTITY_PREDICATE__ENTITY:
				setEntity((RelationEntity)newValue);
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
			case OmlPackage.RELATION_ENTITY_PREDICATE__VARIABLE1:
				setVariable1(VARIABLE1_EDEFAULT);
				return;
			case OmlPackage.RELATION_ENTITY_PREDICATE__VARIABLE2:
				setVariable2(VARIABLE2_EDEFAULT);
				return;
			case OmlPackage.RELATION_ENTITY_PREDICATE__INSTANCE2:
				setInstance2((NamedInstance)null);
				return;
			case OmlPackage.RELATION_ENTITY_PREDICATE__ENTITY:
				setEntity((RelationEntity)null);
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
			case OmlPackage.RELATION_ENTITY_PREDICATE__VARIABLE1:
				return VARIABLE1_EDEFAULT == null ? variable1 != null : !VARIABLE1_EDEFAULT.equals(variable1);
			case OmlPackage.RELATION_ENTITY_PREDICATE__VARIABLE2:
				return VARIABLE2_EDEFAULT == null ? variable2 != null : !VARIABLE2_EDEFAULT.equals(variable2);
			case OmlPackage.RELATION_ENTITY_PREDICATE__INSTANCE2:
				return instance2 != null;
			case OmlPackage.RELATION_ENTITY_PREDICATE__ENTITY:
				return entity != null;
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
		if (baseClass == BinaryPredicate.class) {
			switch (derivedFeatureID) {
				case OmlPackage.RELATION_ENTITY_PREDICATE__VARIABLE1: return OmlPackage.BINARY_PREDICATE__VARIABLE1;
				case OmlPackage.RELATION_ENTITY_PREDICATE__VARIABLE2: return OmlPackage.BINARY_PREDICATE__VARIABLE2;
				case OmlPackage.RELATION_ENTITY_PREDICATE__INSTANCE2: return OmlPackage.BINARY_PREDICATE__INSTANCE2;
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
		if (baseClass == BinaryPredicate.class) {
			switch (baseFeatureID) {
				case OmlPackage.BINARY_PREDICATE__VARIABLE1: return OmlPackage.RELATION_ENTITY_PREDICATE__VARIABLE1;
				case OmlPackage.BINARY_PREDICATE__VARIABLE2: return OmlPackage.RELATION_ENTITY_PREDICATE__VARIABLE2;
				case OmlPackage.BINARY_PREDICATE__INSTANCE2: return OmlPackage.RELATION_ENTITY_PREDICATE__INSTANCE2;
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
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (variable1: ");
		result.append(variable1);
		result.append(", variable2: ");
		result.append(variable2);
		result.append(')');
		return result.toString();
	}

} //RelationEntityPredicateImpl
