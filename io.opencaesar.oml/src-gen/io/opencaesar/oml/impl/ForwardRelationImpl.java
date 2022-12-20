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
import io.opencaesar.oml.SemanticProperty;

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
 * An implementation of the model object '<em><b>Forward Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.ForwardRelationImpl#getRelationEntity <em>Relation Entity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForwardRelationImpl extends RelationImpl implements ForwardRelation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForwardRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.FORWARD_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationEntity getRelationEntity() {
		if (eContainerFeatureID() != OmlPackage.FORWARD_RELATION__RELATION_ENTITY) return null;
		return (RelationEntity)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationEntity basicGetRelationEntity() {
		if (eContainerFeatureID() != OmlPackage.FORWARD_RELATION__RELATION_ENTITY) return null;
		return (RelationEntity)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRelationEntity(RelationEntity newRelationEntity, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRelationEntity, OmlPackage.FORWARD_RELATION__RELATION_ENTITY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelationEntity(RelationEntity newRelationEntity) {
		if (newRelationEntity != eInternalContainer() || (eContainerFeatureID() != OmlPackage.FORWARD_RELATION__RELATION_ENTITY && newRelationEntity != null)) {
			if (EcoreUtil.isAncestor(this, newRelationEntity))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRelationEntity != null)
				msgs = ((InternalEObject)newRelationEntity).eInverseAdd(this, OmlPackage.RELATION_ENTITY__FORWARD_RELATION, RelationEntity.class, msgs);
			msgs = basicSetRelationEntity(newRelationEntity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.FORWARD_RELATION__RELATION_ENTITY, newRelationEntity, newRelationEntity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFunctional() {
		return this.getRelationEntity().isFunctional();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isInverseFunctional() {
		return this.getRelationEntity().isInverseFunctional();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSymmetric() {
		return this.getRelationEntity().isSymmetric();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAsymmetric() {
		return this.getRelationEntity().isAsymmetric();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isReflexive() {
		return this.getRelationEntity().isReflexive();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIrreflexive() {
		return this.getRelationEntity().isIrreflexive();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isTransitive() {
		return this.getRelationEntity().isTransitive();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity getDomain() {
		return this.getRelationEntity().getSource();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity getRange() {
		return this.getRelationEntity().getTarget();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getInverse() {
		return this.getRelationEntity().getReverseRelation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.FORWARD_RELATION__RELATION_ENTITY:
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
			case OmlPackage.FORWARD_RELATION__RELATION_ENTITY:
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
			case OmlPackage.FORWARD_RELATION__RELATION_ENTITY:
				return eInternalContainer().eInverseRemove(this, OmlPackage.RELATION_ENTITY__FORWARD_RELATION, RelationEntity.class, msgs);
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
			case OmlPackage.FORWARD_RELATION__RELATION_ENTITY:
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
			case OmlPackage.FORWARD_RELATION__RELATION_ENTITY:
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
			case OmlPackage.FORWARD_RELATION__RELATION_ENTITY:
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
			case OmlPackage.FORWARD_RELATION__RELATION_ENTITY:
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
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == SemanticProperty.class) {
			switch (baseOperationID) {
				case OmlPackage.SEMANTIC_PROPERTY___IS_FUNCTIONAL: return OmlPackage.FORWARD_RELATION___IS_FUNCTIONAL;
				case OmlPackage.SEMANTIC_PROPERTY___GET_DOMAIN: return OmlPackage.FORWARD_RELATION___GET_DOMAIN;
				case OmlPackage.SEMANTIC_PROPERTY___GET_RANGE: return OmlPackage.FORWARD_RELATION___GET_RANGE;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == Relation.class) {
			switch (baseOperationID) {
				case OmlPackage.RELATION___IS_INVERSE_FUNCTIONAL: return OmlPackage.FORWARD_RELATION___IS_INVERSE_FUNCTIONAL;
				case OmlPackage.RELATION___IS_SYMMETRIC: return OmlPackage.FORWARD_RELATION___IS_SYMMETRIC;
				case OmlPackage.RELATION___IS_ASYMMETRIC: return OmlPackage.FORWARD_RELATION___IS_ASYMMETRIC;
				case OmlPackage.RELATION___IS_REFLEXIVE: return OmlPackage.FORWARD_RELATION___IS_REFLEXIVE;
				case OmlPackage.RELATION___IS_IRREFLEXIVE: return OmlPackage.FORWARD_RELATION___IS_IRREFLEXIVE;
				case OmlPackage.RELATION___IS_TRANSITIVE: return OmlPackage.FORWARD_RELATION___IS_TRANSITIVE;
				case OmlPackage.RELATION___GET_DOMAIN: return OmlPackage.FORWARD_RELATION___GET_DOMAIN;
				case OmlPackage.RELATION___GET_RANGE: return OmlPackage.FORWARD_RELATION___GET_RANGE;
				case OmlPackage.RELATION___GET_INVERSE: return OmlPackage.FORWARD_RELATION___GET_INVERSE;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OmlPackage.FORWARD_RELATION___IS_FUNCTIONAL:
				return isFunctional();
			case OmlPackage.FORWARD_RELATION___IS_INVERSE_FUNCTIONAL:
				return isInverseFunctional();
			case OmlPackage.FORWARD_RELATION___IS_SYMMETRIC:
				return isSymmetric();
			case OmlPackage.FORWARD_RELATION___IS_ASYMMETRIC:
				return isAsymmetric();
			case OmlPackage.FORWARD_RELATION___IS_REFLEXIVE:
				return isReflexive();
			case OmlPackage.FORWARD_RELATION___IS_IRREFLEXIVE:
				return isIrreflexive();
			case OmlPackage.FORWARD_RELATION___IS_TRANSITIVE:
				return isTransitive();
			case OmlPackage.FORWARD_RELATION___GET_DOMAIN:
				return getDomain();
			case OmlPackage.FORWARD_RELATION___GET_RANGE:
				return getRange();
			case OmlPackage.FORWARD_RELATION___GET_INVERSE:
				return getInverse();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ForwardRelationImpl
