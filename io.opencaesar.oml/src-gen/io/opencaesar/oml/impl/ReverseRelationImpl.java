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
import io.opencaesar.oml.Member;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationBase;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.ReverseRelation;
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
 * An implementation of the model object '<em><b>Reverse Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.ReverseRelationImpl#getRelationBase <em>Relation Base</em>}</li>
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
	public RelationBase getRelationBase() {
		if (eContainerFeatureID() != OmlPackage.REVERSE_RELATION__RELATION_BASE) return null;
		return (RelationBase)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationBase basicGetRelationBase() {
		if (eContainerFeatureID() != OmlPackage.REVERSE_RELATION__RELATION_BASE) return null;
		return (RelationBase)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRelationBase(RelationBase newRelationBase, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRelationBase, OmlPackage.REVERSE_RELATION__RELATION_BASE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelationBase(RelationBase newRelationBase) {
		if (newRelationBase != eInternalContainer() || (eContainerFeatureID() != OmlPackage.REVERSE_RELATION__RELATION_BASE && newRelationBase != null)) {
			if (EcoreUtil.isAncestor(this, newRelationBase))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRelationBase != null)
				msgs = ((InternalEObject)newRelationBase).eInverseAdd(this, OmlPackage.RELATION_BASE__REVERSE_RELATION, RelationBase.class, msgs);
			msgs = basicSetRelationBase(newRelationBase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.REVERSE_RELATION__RELATION_BASE, newRelationBase, newRelationBase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Member getRef() {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFunctional() {
		return this.getRelationBase().isInverseFunctional();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isInverseFunctional() {
		return this.getRelationBase().isInverseFunctional();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSymmetric() {
		return this.getRelationBase().isSymmetric();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAsymmetric() {
		return this.getRelationBase().isAsymmetric();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isReflexive() {
		return this.getRelationBase().isReflexive();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIrreflexive() {
		return this.getRelationBase().isIrreflexive();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isTransitive() {
		return this.getRelationBase().isTransitive();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity getDomain() {
		return this.getRelationBase().getTarget();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity getRange() {
		return this.getRelationBase().getSource();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getInverse() {
		Relation _xifexpression = null;
		RelationBase _relationBase = this.getRelationBase();
		if ((_relationBase instanceof RelationEntity)) {
			RelationBase _relationBase_1 = this.getRelationBase();
			_xifexpression = ((RelationEntity) _relationBase_1).getForwardRelation();
		}
		else {
			Relation _xifexpression_1 = null;
			RelationBase _relationBase_2 = this.getRelationBase();
			if ((_relationBase_2 instanceof Relation)) {
				RelationBase _relationBase_3 = this.getRelationBase();
				_xifexpression_1 = ((Relation) _relationBase_3);
			}
			_xifexpression = _xifexpression_1;
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
			case OmlPackage.REVERSE_RELATION__RELATION_BASE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRelationBase((RelationBase)otherEnd, msgs);
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
			case OmlPackage.REVERSE_RELATION__RELATION_BASE:
				return basicSetRelationBase(null, msgs);
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
			case OmlPackage.REVERSE_RELATION__RELATION_BASE:
				return eInternalContainer().eInverseRemove(this, OmlPackage.RELATION_BASE__REVERSE_RELATION, RelationBase.class, msgs);
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
			case OmlPackage.REVERSE_RELATION__RELATION_BASE:
				if (resolve) return getRelationBase();
				return basicGetRelationBase();
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
			case OmlPackage.REVERSE_RELATION__RELATION_BASE:
				setRelationBase((RelationBase)newValue);
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
			case OmlPackage.REVERSE_RELATION__RELATION_BASE:
				setRelationBase((RelationBase)null);
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
			case OmlPackage.REVERSE_RELATION__RELATION_BASE:
				return basicGetRelationBase() != null;
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
		if (baseClass == Member.class) {
			switch (baseOperationID) {
				case OmlPackage.MEMBER___GET_REF: return OmlPackage.REVERSE_RELATION___GET_REF;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == SemanticProperty.class) {
			switch (baseOperationID) {
				case OmlPackage.SEMANTIC_PROPERTY___IS_FUNCTIONAL: return OmlPackage.REVERSE_RELATION___IS_FUNCTIONAL;
				case OmlPackage.SEMANTIC_PROPERTY___GET_DOMAIN: return OmlPackage.REVERSE_RELATION___GET_DOMAIN;
				case OmlPackage.SEMANTIC_PROPERTY___GET_RANGE: return OmlPackage.REVERSE_RELATION___GET_RANGE;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == Relation.class) {
			switch (baseOperationID) {
				case OmlPackage.RELATION___IS_INVERSE_FUNCTIONAL: return OmlPackage.REVERSE_RELATION___IS_INVERSE_FUNCTIONAL;
				case OmlPackage.RELATION___IS_SYMMETRIC: return OmlPackage.REVERSE_RELATION___IS_SYMMETRIC;
				case OmlPackage.RELATION___IS_ASYMMETRIC: return OmlPackage.REVERSE_RELATION___IS_ASYMMETRIC;
				case OmlPackage.RELATION___IS_REFLEXIVE: return OmlPackage.REVERSE_RELATION___IS_REFLEXIVE;
				case OmlPackage.RELATION___IS_IRREFLEXIVE: return OmlPackage.REVERSE_RELATION___IS_IRREFLEXIVE;
				case OmlPackage.RELATION___IS_TRANSITIVE: return OmlPackage.REVERSE_RELATION___IS_TRANSITIVE;
				case OmlPackage.RELATION___GET_DOMAIN: return OmlPackage.REVERSE_RELATION___GET_DOMAIN;
				case OmlPackage.RELATION___GET_RANGE: return OmlPackage.REVERSE_RELATION___GET_RANGE;
				case OmlPackage.RELATION___GET_INVERSE: return OmlPackage.REVERSE_RELATION___GET_INVERSE;
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
			case OmlPackage.REVERSE_RELATION___GET_REF:
				return getRef();
			case OmlPackage.REVERSE_RELATION___IS_FUNCTIONAL:
				return isFunctional();
			case OmlPackage.REVERSE_RELATION___IS_INVERSE_FUNCTIONAL:
				return isInverseFunctional();
			case OmlPackage.REVERSE_RELATION___IS_SYMMETRIC:
				return isSymmetric();
			case OmlPackage.REVERSE_RELATION___IS_ASYMMETRIC:
				return isAsymmetric();
			case OmlPackage.REVERSE_RELATION___IS_REFLEXIVE:
				return isReflexive();
			case OmlPackage.REVERSE_RELATION___IS_IRREFLEXIVE:
				return isIrreflexive();
			case OmlPackage.REVERSE_RELATION___IS_TRANSITIVE:
				return isTransitive();
			case OmlPackage.REVERSE_RELATION___GET_DOMAIN:
				return getDomain();
			case OmlPackage.REVERSE_RELATION___GET_RANGE:
				return getRange();
			case OmlPackage.REVERSE_RELATION___GET_INVERSE:
				return getInverse();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ReverseRelationImpl
