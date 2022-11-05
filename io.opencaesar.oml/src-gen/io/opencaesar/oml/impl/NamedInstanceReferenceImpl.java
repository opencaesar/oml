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

import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionStatement;
import io.opencaesar.oml.LinkAssertion;
import io.opencaesar.oml.NamedInstanceReference;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.Statement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Instance Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.NamedInstanceReferenceImpl#getOwningDescription <em>Owning Description</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.NamedInstanceReferenceImpl#getOwnedPropertyValues <em>Owned Property Values</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.NamedInstanceReferenceImpl#getOwnedLinks <em>Owned Links</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NamedInstanceReferenceImpl extends ReferenceImpl implements NamedInstanceReference {
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
	 * The cached value of the '{@link #getOwnedLinks() <em>Owned Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<LinkAssertion> ownedLinks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedInstanceReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.NAMED_INSTANCE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Description getOwningDescription() {
		if (eContainerFeatureID() != OmlPackage.NAMED_INSTANCE_REFERENCE__OWNING_DESCRIPTION) return null;
		return (Description)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Description basicGetOwningDescription() {
		if (eContainerFeatureID() != OmlPackage.NAMED_INSTANCE_REFERENCE__OWNING_DESCRIPTION) return null;
		return (Description)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningDescription(Description newOwningDescription, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningDescription, OmlPackage.NAMED_INSTANCE_REFERENCE__OWNING_DESCRIPTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningDescription(Description newOwningDescription) {
		if (newOwningDescription != eInternalContainer() || (eContainerFeatureID() != OmlPackage.NAMED_INSTANCE_REFERENCE__OWNING_DESCRIPTION && newOwningDescription != null)) {
			if (EcoreUtil.isAncestor(this, newOwningDescription))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningDescription != null)
				msgs = ((InternalEObject)newOwningDescription).eInverseAdd(this, OmlPackage.DESCRIPTION__OWNED_STATEMENTS, Description.class, msgs);
			msgs = basicSetOwningDescription(newOwningDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.NAMED_INSTANCE_REFERENCE__OWNING_DESCRIPTION, newOwningDescription, newOwningDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PropertyValueAssertion> getOwnedPropertyValues() {
		if (ownedPropertyValues == null) {
			ownedPropertyValues = new EObjectContainmentWithInverseEList<PropertyValueAssertion>(PropertyValueAssertion.class, this, OmlPackage.NAMED_INSTANCE_REFERENCE__OWNED_PROPERTY_VALUES, OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_REFERENCE);
		}
		return ownedPropertyValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LinkAssertion> getOwnedLinks() {
		if (ownedLinks == null) {
			ownedLinks = new EObjectContainmentWithInverseEList<LinkAssertion>(LinkAssertion.class, this, OmlPackage.NAMED_INSTANCE_REFERENCE__OWNED_LINKS, OmlPackage.LINK_ASSERTION__OWNING_REFERENCE);
		}
		return ownedLinks;
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
			case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNING_DESCRIPTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningDescription((Description)otherEnd, msgs);
			case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNED_PROPERTY_VALUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedPropertyValues()).basicAdd(otherEnd, msgs);
			case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNED_LINKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedLinks()).basicAdd(otherEnd, msgs);
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
			case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNING_DESCRIPTION:
				return basicSetOwningDescription(null, msgs);
			case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNED_PROPERTY_VALUES:
				return ((InternalEList<?>)getOwnedPropertyValues()).basicRemove(otherEnd, msgs);
			case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNED_LINKS:
				return ((InternalEList<?>)getOwnedLinks()).basicRemove(otherEnd, msgs);
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
			case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNING_DESCRIPTION:
				return eInternalContainer().eInverseRemove(this, OmlPackage.DESCRIPTION__OWNED_STATEMENTS, Description.class, msgs);
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
			case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNING_DESCRIPTION:
				if (resolve) return getOwningDescription();
				return basicGetOwningDescription();
			case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNED_PROPERTY_VALUES:
				return getOwnedPropertyValues();
			case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNED_LINKS:
				return getOwnedLinks();
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
			case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNING_DESCRIPTION:
				setOwningDescription((Description)newValue);
				return;
			case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNED_PROPERTY_VALUES:
				getOwnedPropertyValues().clear();
				getOwnedPropertyValues().addAll((Collection<? extends PropertyValueAssertion>)newValue);
				return;
			case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNED_LINKS:
				getOwnedLinks().clear();
				getOwnedLinks().addAll((Collection<? extends LinkAssertion>)newValue);
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
			case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNING_DESCRIPTION:
				setOwningDescription((Description)null);
				return;
			case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNED_PROPERTY_VALUES:
				getOwnedPropertyValues().clear();
				return;
			case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNED_LINKS:
				getOwnedLinks().clear();
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
			case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNING_DESCRIPTION:
				return basicGetOwningDescription() != null;
			case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNED_PROPERTY_VALUES:
				return ownedPropertyValues != null && !ownedPropertyValues.isEmpty();
			case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNED_LINKS:
				return ownedLinks != null && !ownedLinks.isEmpty();
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
		if (baseClass == Statement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == DescriptionStatement.class) {
			switch (derivedFeatureID) {
				case OmlPackage.NAMED_INSTANCE_REFERENCE__OWNING_DESCRIPTION: return OmlPackage.DESCRIPTION_STATEMENT__OWNING_DESCRIPTION;
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
		if (baseClass == Statement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == DescriptionStatement.class) {
			switch (baseFeatureID) {
				case OmlPackage.DESCRIPTION_STATEMENT__OWNING_DESCRIPTION: return OmlPackage.NAMED_INSTANCE_REFERENCE__OWNING_DESCRIPTION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //NamedInstanceReferenceImpl
