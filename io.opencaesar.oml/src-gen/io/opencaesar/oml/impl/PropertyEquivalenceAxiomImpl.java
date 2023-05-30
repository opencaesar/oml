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

import io.opencaesar.oml.Member;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Property;
import io.opencaesar.oml.PropertyEquivalenceAxiom;
import io.opencaesar.oml.SpecializableProperty;

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
 * An implementation of the model object '<em><b>Property Equivalence Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.PropertyEquivalenceAxiomImpl#getSuperProperty <em>Super Property</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PropertyEquivalenceAxiomImpl#getOwningProperty <em>Owning Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyEquivalenceAxiomImpl extends AxiomImpl implements PropertyEquivalenceAxiom {
	/**
	 * The cached value of the '{@link #getSuperProperty() <em>Super Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperProperty()
	 * @generated
	 * @ordered
	 */
	protected Property superProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyEquivalenceAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.PROPERTY_EQUIVALENCE_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getSuperProperty() {
		if (superProperty != null && superProperty.eIsProxy()) {
			InternalEObject oldSuperProperty = (InternalEObject)superProperty;
			superProperty = (Property)eResolveProxy(oldSuperProperty);
			if (superProperty != oldSuperProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__SUPER_PROPERTY, oldSuperProperty, superProperty));
			}
		}
		return superProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetSuperProperty() {
		return superProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSuperProperty(Property newSuperProperty) {
		Property oldSuperProperty = superProperty;
		superProperty = newSuperProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__SUPER_PROPERTY, oldSuperProperty, superProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpecializableProperty getOwningProperty() {
		if (eContainerFeatureID() != OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__OWNING_PROPERTY) return null;
		return (SpecializableProperty)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializableProperty basicGetOwningProperty() {
		if (eContainerFeatureID() != OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__OWNING_PROPERTY) return null;
		return (SpecializableProperty)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningProperty(SpecializableProperty newOwningProperty, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningProperty, OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__OWNING_PROPERTY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningProperty(SpecializableProperty newOwningProperty) {
		if (newOwningProperty != eInternalContainer() || (eContainerFeatureID() != OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__OWNING_PROPERTY && newOwningProperty != null)) {
			if (EcoreUtil.isAncestor(this, newOwningProperty))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningProperty != null)
				msgs = ((InternalEObject)newOwningProperty).eInverseAdd(this, OmlPackage.SPECIALIZABLE_PROPERTY__OWNED_EQUIVALENCES, SpecializableProperty.class, msgs);
			msgs = basicSetOwningProperty(newOwningProperty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__OWNING_PROPERTY, newOwningProperty, newOwningProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getSubProperty() {
		Member _resolve = this.getOwningProperty().resolve();
		return ((Property) _resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getCharacterizedTerm() {
		return this.getSubProperty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__OWNING_PROPERTY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningProperty((SpecializableProperty)otherEnd, msgs);
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
			case OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__OWNING_PROPERTY:
				return basicSetOwningProperty(null, msgs);
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
			case OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__OWNING_PROPERTY:
				return eInternalContainer().eInverseRemove(this, OmlPackage.SPECIALIZABLE_PROPERTY__OWNED_EQUIVALENCES, SpecializableProperty.class, msgs);
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
			case OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__SUPER_PROPERTY:
				if (resolve) return getSuperProperty();
				return basicGetSuperProperty();
			case OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__OWNING_PROPERTY:
				if (resolve) return getOwningProperty();
				return basicGetOwningProperty();
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
			case OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__SUPER_PROPERTY:
				setSuperProperty((Property)newValue);
				return;
			case OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__OWNING_PROPERTY:
				setOwningProperty((SpecializableProperty)newValue);
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
			case OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__SUPER_PROPERTY:
				setSuperProperty((Property)null);
				return;
			case OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__OWNING_PROPERTY:
				setOwningProperty((SpecializableProperty)null);
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
			case OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__SUPER_PROPERTY:
				return superProperty != null;
			case OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__OWNING_PROPERTY:
				return basicGetOwningProperty() != null;
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
			case OmlPackage.PROPERTY_EQUIVALENCE_AXIOM___GET_SUB_PROPERTY:
				return getSubProperty();
			case OmlPackage.PROPERTY_EQUIVALENCE_AXIOM___GET_CHARACTERIZED_TERM:
				return getCharacterizedTerm();
		}
		return super.eInvoke(operationID, arguments);
	}

} //PropertyEquivalenceAxiomImpl
