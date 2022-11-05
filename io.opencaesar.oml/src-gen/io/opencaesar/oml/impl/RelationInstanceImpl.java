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

import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.RelationTypeAssertion;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.RelationInstanceImpl#getOwnedTypes <em>Owned Types</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationInstanceImpl#getSources <em>Sources</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationInstanceImpl#getTargets <em>Targets</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationInstanceImpl extends NamedInstanceImpl implements RelationInstance {
	/**
	 * The cached value of the '{@link #getOwnedTypes() <em>Owned Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<RelationTypeAssertion> ownedTypes;

	/**
	 * The cached value of the '{@link #getSources() <em>Sources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSources()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedInstance> sources;

	/**
	 * The cached value of the '{@link #getTargets() <em>Targets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargets()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedInstance> targets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.RELATION_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelationTypeAssertion> getOwnedTypes() {
		if (ownedTypes == null) {
			ownedTypes = new EObjectContainmentWithInverseEList<RelationTypeAssertion>(RelationTypeAssertion.class, this, OmlPackage.RELATION_INSTANCE__OWNED_TYPES, OmlPackage.RELATION_TYPE_ASSERTION__OWNING_INSTANCE);
		}
		return ownedTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NamedInstance> getSources() {
		if (sources == null) {
			sources = new EObjectResolvingEList<NamedInstance>(NamedInstance.class, this, OmlPackage.RELATION_INSTANCE__SOURCES);
		}
		return sources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NamedInstance> getTargets() {
		if (targets == null) {
			targets = new EObjectResolvingEList<NamedInstance>(NamedInstance.class, this, OmlPackage.RELATION_INSTANCE__TARGETS);
		}
		return targets;
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
			case OmlPackage.RELATION_INSTANCE__OWNED_TYPES:
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
			case OmlPackage.RELATION_INSTANCE__OWNED_TYPES:
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
			case OmlPackage.RELATION_INSTANCE__OWNED_TYPES:
				return getOwnedTypes();
			case OmlPackage.RELATION_INSTANCE__SOURCES:
				return getSources();
			case OmlPackage.RELATION_INSTANCE__TARGETS:
				return getTargets();
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
			case OmlPackage.RELATION_INSTANCE__OWNED_TYPES:
				getOwnedTypes().clear();
				getOwnedTypes().addAll((Collection<? extends RelationTypeAssertion>)newValue);
				return;
			case OmlPackage.RELATION_INSTANCE__SOURCES:
				getSources().clear();
				getSources().addAll((Collection<? extends NamedInstance>)newValue);
				return;
			case OmlPackage.RELATION_INSTANCE__TARGETS:
				getTargets().clear();
				getTargets().addAll((Collection<? extends NamedInstance>)newValue);
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
			case OmlPackage.RELATION_INSTANCE__OWNED_TYPES:
				getOwnedTypes().clear();
				return;
			case OmlPackage.RELATION_INSTANCE__SOURCES:
				getSources().clear();
				return;
			case OmlPackage.RELATION_INSTANCE__TARGETS:
				getTargets().clear();
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
			case OmlPackage.RELATION_INSTANCE__OWNED_TYPES:
				return ownedTypes != null && !ownedTypes.isEmpty();
			case OmlPackage.RELATION_INSTANCE__SOURCES:
				return sources != null && !sources.isEmpty();
			case OmlPackage.RELATION_INSTANCE__TARGETS:
				return targets != null && !targets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RelationInstanceImpl
