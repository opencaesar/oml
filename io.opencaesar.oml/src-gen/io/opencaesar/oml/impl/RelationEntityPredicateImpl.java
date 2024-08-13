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

import io.opencaesar.oml.Argument;
import io.opencaesar.oml.BinaryPredicate;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

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
 *   <li>{@link io.opencaesar.oml.impl.RelationEntityPredicateImpl#getArgument1 <em>Argument1</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationEntityPredicateImpl#getArgument2 <em>Argument2</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationEntityPredicateImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationEntityPredicateImpl extends UnaryPredicateImpl implements RelationEntityPredicate {
	/**
	 * The cached value of the '{@link #getArgument1() <em>Argument1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgument1()
	 * @generated
	 * @ordered
	 */
	protected Argument argument1;

	/**
	 * The cached value of the '{@link #getArgument2() <em>Argument2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgument2()
	 * @generated
	 * @ordered
	 */
	protected Argument argument2;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected RelationEntity type;

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
	public Argument getArgument1() {
		return argument1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArgument1(Argument newArgument1, NotificationChain msgs) {
		Argument oldArgument1 = argument1;
		argument1 = newArgument1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT1, oldArgument1, newArgument1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setArgument1(Argument newArgument1) {
		if (newArgument1 != argument1) {
			NotificationChain msgs = null;
			if (argument1 != null)
				msgs = ((InternalEObject)argument1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT1, null, msgs);
			if (newArgument1 != null)
				msgs = ((InternalEObject)newArgument1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT1, null, msgs);
			msgs = basicSetArgument1(newArgument1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT1, newArgument1, newArgument1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Argument getArgument2() {
		return argument2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArgument2(Argument newArgument2, NotificationChain msgs) {
		Argument oldArgument2 = argument2;
		argument2 = newArgument2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT2, oldArgument2, newArgument2);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setArgument2(Argument newArgument2) {
		if (newArgument2 != argument2) {
			NotificationChain msgs = null;
			if (argument2 != null)
				msgs = ((InternalEObject)argument2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT2, null, msgs);
			if (newArgument2 != null)
				msgs = ((InternalEObject)newArgument2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT2, null, msgs);
			msgs = basicSetArgument2(newArgument2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT2, newArgument2, newArgument2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationEntity getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (RelationEntity)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.RELATION_ENTITY_PREDICATE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationEntity basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(RelationEntity newType) {
		RelationEntity oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY_PREDICATE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT1:
				return basicSetArgument1(null, msgs);
			case OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT2:
				return basicSetArgument2(null, msgs);
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
			case OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT1:
				return getArgument1();
			case OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT2:
				return getArgument2();
			case OmlPackage.RELATION_ENTITY_PREDICATE__TYPE:
				if (resolve) return getType();
				return basicGetType();
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
			case OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT1:
				setArgument1((Argument)newValue);
				return;
			case OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT2:
				setArgument2((Argument)newValue);
				return;
			case OmlPackage.RELATION_ENTITY_PREDICATE__TYPE:
				setType((RelationEntity)newValue);
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
			case OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT1:
				setArgument1((Argument)null);
				return;
			case OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT2:
				setArgument2((Argument)null);
				return;
			case OmlPackage.RELATION_ENTITY_PREDICATE__TYPE:
				setType((RelationEntity)null);
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
			case OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT1:
				return argument1 != null;
			case OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT2:
				return argument2 != null;
			case OmlPackage.RELATION_ENTITY_PREDICATE__TYPE:
				return type != null;
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
				case OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT1: return OmlPackage.BINARY_PREDICATE__ARGUMENT1;
				case OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT2: return OmlPackage.BINARY_PREDICATE__ARGUMENT2;
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
				case OmlPackage.BINARY_PREDICATE__ARGUMENT1: return OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT1;
				case OmlPackage.BINARY_PREDICATE__ARGUMENT2: return OmlPackage.RELATION_ENTITY_PREDICATE__ARGUMENT2;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //RelationEntityPredicateImpl
