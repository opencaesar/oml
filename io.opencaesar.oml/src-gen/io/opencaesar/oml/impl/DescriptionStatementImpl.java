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
import io.opencaesar.oml.OmlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Description Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.DescriptionStatementImpl#getOwningDescription <em>Owning Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DescriptionStatementImpl extends StatementImpl implements DescriptionStatement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DescriptionStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.DESCRIPTION_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Description getOwningDescription() {
		if (eContainerFeatureID() != OmlPackage.DESCRIPTION_STATEMENT__OWNING_DESCRIPTION) return null;
		return (Description)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Description basicGetOwningDescription() {
		if (eContainerFeatureID() != OmlPackage.DESCRIPTION_STATEMENT__OWNING_DESCRIPTION) return null;
		return (Description)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningDescription(Description newOwningDescription, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningDescription, OmlPackage.DESCRIPTION_STATEMENT__OWNING_DESCRIPTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningDescription(Description newOwningDescription) {
		if (newOwningDescription != eInternalContainer() || (eContainerFeatureID() != OmlPackage.DESCRIPTION_STATEMENT__OWNING_DESCRIPTION && newOwningDescription != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.DESCRIPTION_STATEMENT__OWNING_DESCRIPTION, newOwningDescription, newOwningDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.DESCRIPTION_STATEMENT__OWNING_DESCRIPTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningDescription((Description)otherEnd, msgs);
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
			case OmlPackage.DESCRIPTION_STATEMENT__OWNING_DESCRIPTION:
				return basicSetOwningDescription(null, msgs);
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
			case OmlPackage.DESCRIPTION_STATEMENT__OWNING_DESCRIPTION:
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
			case OmlPackage.DESCRIPTION_STATEMENT__OWNING_DESCRIPTION:
				if (resolve) return getOwningDescription();
				return basicGetOwningDescription();
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
			case OmlPackage.DESCRIPTION_STATEMENT__OWNING_DESCRIPTION:
				setOwningDescription((Description)newValue);
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
			case OmlPackage.DESCRIPTION_STATEMENT__OWNING_DESCRIPTION:
				setOwningDescription((Description)null);
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
			case OmlPackage.DESCRIPTION_STATEMENT__OWNING_DESCRIPTION:
				return basicGetOwningDescription() != null;
		}
		return super.eIsSet(featureID);
	}

} //DescriptionStatementImpl
