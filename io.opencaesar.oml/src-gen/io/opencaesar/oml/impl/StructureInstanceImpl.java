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

import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.PropertyValueRestrictionAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structure Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.StructureInstanceImpl#getType <em>Type</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.StructureInstanceImpl#getOwningAxiom <em>Owning Axiom</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.StructureInstanceImpl#getOwningAssertion <em>Owning Assertion</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StructureInstanceImpl extends InstanceImpl implements StructureInstance {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Structure type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructureInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.STRUCTURE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Structure getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Structure)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.STRUCTURE_INSTANCE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Structure basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(Structure newType) {
		Structure oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.STRUCTURE_INSTANCE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyValueRestrictionAxiom getOwningAxiom() {
		if (eContainerFeatureID() != OmlPackage.STRUCTURE_INSTANCE__OWNING_AXIOM) return null;
		return (PropertyValueRestrictionAxiom)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyValueRestrictionAxiom basicGetOwningAxiom() {
		if (eContainerFeatureID() != OmlPackage.STRUCTURE_INSTANCE__OWNING_AXIOM) return null;
		return (PropertyValueRestrictionAxiom)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningAxiom(PropertyValueRestrictionAxiom newOwningAxiom, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningAxiom, OmlPackage.STRUCTURE_INSTANCE__OWNING_AXIOM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningAxiom(PropertyValueRestrictionAxiom newOwningAxiom) {
		if (newOwningAxiom != eInternalContainer() || (eContainerFeatureID() != OmlPackage.STRUCTURE_INSTANCE__OWNING_AXIOM && newOwningAxiom != null)) {
			if (EcoreUtil.isAncestor(this, newOwningAxiom))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningAxiom != null)
				msgs = ((InternalEObject)newOwningAxiom).eInverseAdd(this, OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__CONTAINED_VALUE, PropertyValueRestrictionAxiom.class, msgs);
			msgs = basicSetOwningAxiom(newOwningAxiom, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.STRUCTURE_INSTANCE__OWNING_AXIOM, newOwningAxiom, newOwningAxiom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyValueAssertion getOwningAssertion() {
		if (eContainerFeatureID() != OmlPackage.STRUCTURE_INSTANCE__OWNING_ASSERTION) return null;
		return (PropertyValueAssertion)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyValueAssertion basicGetOwningAssertion() {
		if (eContainerFeatureID() != OmlPackage.STRUCTURE_INSTANCE__OWNING_ASSERTION) return null;
		return (PropertyValueAssertion)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningAssertion(PropertyValueAssertion newOwningAssertion, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningAssertion, OmlPackage.STRUCTURE_INSTANCE__OWNING_ASSERTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningAssertion(PropertyValueAssertion newOwningAssertion) {
		if (newOwningAssertion != eInternalContainer() || (eContainerFeatureID() != OmlPackage.STRUCTURE_INSTANCE__OWNING_ASSERTION && newOwningAssertion != null)) {
			if (EcoreUtil.isAncestor(this, newOwningAssertion))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningAssertion != null)
				msgs = ((InternalEObject)newOwningAssertion).eInverseAdd(this, OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE, PropertyValueAssertion.class, msgs);
			msgs = basicSetOwningAssertion(newOwningAssertion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.STRUCTURE_INSTANCE__OWNING_ASSERTION, newOwningAssertion, newOwningAssertion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Classifier> getTypes() {
		return ECollections.<Classifier>singletonEList(this.getType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.STRUCTURE_INSTANCE__OWNING_AXIOM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningAxiom((PropertyValueRestrictionAxiom)otherEnd, msgs);
			case OmlPackage.STRUCTURE_INSTANCE__OWNING_ASSERTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningAssertion((PropertyValueAssertion)otherEnd, msgs);
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
			case OmlPackage.STRUCTURE_INSTANCE__OWNING_AXIOM:
				return basicSetOwningAxiom(null, msgs);
			case OmlPackage.STRUCTURE_INSTANCE__OWNING_ASSERTION:
				return basicSetOwningAssertion(null, msgs);
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
			case OmlPackage.STRUCTURE_INSTANCE__OWNING_AXIOM:
				return eInternalContainer().eInverseRemove(this, OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__CONTAINED_VALUE, PropertyValueRestrictionAxiom.class, msgs);
			case OmlPackage.STRUCTURE_INSTANCE__OWNING_ASSERTION:
				return eInternalContainer().eInverseRemove(this, OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE, PropertyValueAssertion.class, msgs);
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
			case OmlPackage.STRUCTURE_INSTANCE__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case OmlPackage.STRUCTURE_INSTANCE__OWNING_AXIOM:
				if (resolve) return getOwningAxiom();
				return basicGetOwningAxiom();
			case OmlPackage.STRUCTURE_INSTANCE__OWNING_ASSERTION:
				if (resolve) return getOwningAssertion();
				return basicGetOwningAssertion();
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
			case OmlPackage.STRUCTURE_INSTANCE__TYPE:
				setType((Structure)newValue);
				return;
			case OmlPackage.STRUCTURE_INSTANCE__OWNING_AXIOM:
				setOwningAxiom((PropertyValueRestrictionAxiom)newValue);
				return;
			case OmlPackage.STRUCTURE_INSTANCE__OWNING_ASSERTION:
				setOwningAssertion((PropertyValueAssertion)newValue);
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
			case OmlPackage.STRUCTURE_INSTANCE__TYPE:
				setType((Structure)null);
				return;
			case OmlPackage.STRUCTURE_INSTANCE__OWNING_AXIOM:
				setOwningAxiom((PropertyValueRestrictionAxiom)null);
				return;
			case OmlPackage.STRUCTURE_INSTANCE__OWNING_ASSERTION:
				setOwningAssertion((PropertyValueAssertion)null);
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
			case OmlPackage.STRUCTURE_INSTANCE__TYPE:
				return type != null;
			case OmlPackage.STRUCTURE_INSTANCE__OWNING_AXIOM:
				return basicGetOwningAxiom() != null;
			case OmlPackage.STRUCTURE_INSTANCE__OWNING_ASSERTION:
				return basicGetOwningAssertion() != null;
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
			case OmlPackage.STRUCTURE_INSTANCE___GET_TYPES:
				return getTypes();
		}
		return super.eInvoke(operationID, arguments);
	}

} //StructureInstanceImpl
