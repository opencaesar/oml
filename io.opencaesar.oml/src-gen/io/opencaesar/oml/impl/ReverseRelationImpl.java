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
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.ReverseRelation;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reverse Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.ReverseRelationImpl#getRelationEntity <em>Relation Entity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReverseRelationImpl extends RelationImpl implements ReverseRelation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReverseRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.REVERSE_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationEntity getRelationEntity() {
		if (eContainerFeatureID() != OmlPackage.REVERSE_RELATION__RELATION_ENTITY) return null;
		return (RelationEntity)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationEntity basicGetRelationEntity() {
		if (eContainerFeatureID() != OmlPackage.REVERSE_RELATION__RELATION_ENTITY) return null;
		return (RelationEntity)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRelationEntity(RelationEntity newRelationEntity, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRelationEntity, OmlPackage.REVERSE_RELATION__RELATION_ENTITY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelationEntity(RelationEntity newRelationEntity) {
		if (newRelationEntity != eInternalContainer() || (eContainerFeatureID() != OmlPackage.REVERSE_RELATION__RELATION_ENTITY && newRelationEntity != null)) {
			if (EcoreUtil.isAncestor(this, newRelationEntity))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRelationEntity != null)
				msgs = ((InternalEObject)newRelationEntity).eInverseAdd(this, OmlPackage.RELATION_ENTITY__REVERSE_RELATION, RelationEntity.class, msgs);
			msgs = basicSetRelationEntity(newRelationEntity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.REVERSE_RELATION__RELATION_ENTITY, newRelationEntity, newRelationEntity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity deriveDomain() {
		Entity _xifexpression = null;
		RelationEntity _relationEntity = this.getRelationEntity();
		boolean _tripleNotEquals = (_relationEntity != null);
		if (_tripleNotEquals) {
			_xifexpression = this.getRelationEntity().getTarget();
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity deriveRange() {
		Entity _xifexpression = null;
		RelationEntity _relationEntity = this.getRelationEntity();
		boolean _tripleNotEquals = (_relationEntity != null);
		if (_tripleNotEquals) {
			_xifexpression = this.getRelationEntity().getSource();
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation deriveInverse() {
		ForwardRelation _xifexpression = null;
		RelationEntity _relationEntity = this.getRelationEntity();
		boolean _tripleNotEquals = (_relationEntity != null);
		if (_tripleNotEquals) {
			_xifexpression = this.getRelationEntity().getForwardRelation();
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.REVERSE_RELATION__RELATION_ENTITY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRelationEntity((RelationEntity)otherEnd, msgs);
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
			case OmlPackage.REVERSE_RELATION__RELATION_ENTITY:
				return basicSetRelationEntity(null, msgs);
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
			case OmlPackage.REVERSE_RELATION__RELATION_ENTITY:
				return eInternalContainer().eInverseRemove(this, OmlPackage.RELATION_ENTITY__REVERSE_RELATION, RelationEntity.class, msgs);
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
			case OmlPackage.REVERSE_RELATION__RELATION_ENTITY:
				if (resolve) return getRelationEntity();
				return basicGetRelationEntity();
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
			case OmlPackage.REVERSE_RELATION__RELATION_ENTITY:
				setRelationEntity((RelationEntity)newValue);
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
			case OmlPackage.REVERSE_RELATION__RELATION_ENTITY:
				setRelationEntity((RelationEntity)null);
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
			case OmlPackage.REVERSE_RELATION__RELATION_ENTITY:
				return basicGetRelationEntity() != null;
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
			case OmlPackage.REVERSE_RELATION___DERIVE_DOMAIN:
				return deriveDomain();
			case OmlPackage.REVERSE_RELATION___DERIVE_RANGE:
				return deriveRange();
			case OmlPackage.REVERSE_RELATION___DERIVE_INVERSE:
				return deriveInverse();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ReverseRelationImpl
