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
import io.opencaesar.oml.DescriptionImport;
import io.opencaesar.oml.DescriptionStatement;
import io.opencaesar.oml.OmlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.DescriptionImpl#getOwnedImports <em>Owned Imports</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.DescriptionImpl#getOwnedStatements <em>Owned Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DescriptionImpl extends DescriptionBoxImpl implements Description {
	/**
	 * The cached value of the '{@link #getOwnedImports() <em>Owned Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedImports()
	 * @generated
	 * @ordered
	 */
	protected EList<DescriptionImport> ownedImports;

	/**
	 * The cached value of the '{@link #getOwnedStatements() <em>Owned Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<DescriptionStatement> ownedStatements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DescriptionImport> getOwnedImports() {
		if (ownedImports == null) {
			ownedImports = new EObjectContainmentWithInverseEList<DescriptionImport>(DescriptionImport.class, this, OmlPackage.DESCRIPTION__OWNED_IMPORTS, OmlPackage.DESCRIPTION_IMPORT__OWNING_DESCRIPTION);
		}
		return ownedImports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DescriptionStatement> getOwnedStatements() {
		if (ownedStatements == null) {
			ownedStatements = new EObjectContainmentWithInverseEList<DescriptionStatement>(DescriptionStatement.class, this, OmlPackage.DESCRIPTION__OWNED_STATEMENTS, OmlPackage.DESCRIPTION_STATEMENT__OWNING_DESCRIPTION);
		}
		return ownedStatements;
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
			case OmlPackage.DESCRIPTION__OWNED_IMPORTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedImports()).basicAdd(otherEnd, msgs);
			case OmlPackage.DESCRIPTION__OWNED_STATEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedStatements()).basicAdd(otherEnd, msgs);
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
			case OmlPackage.DESCRIPTION__OWNED_IMPORTS:
				return ((InternalEList<?>)getOwnedImports()).basicRemove(otherEnd, msgs);
			case OmlPackage.DESCRIPTION__OWNED_STATEMENTS:
				return ((InternalEList<?>)getOwnedStatements()).basicRemove(otherEnd, msgs);
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
			case OmlPackage.DESCRIPTION__OWNED_IMPORTS:
				return getOwnedImports();
			case OmlPackage.DESCRIPTION__OWNED_STATEMENTS:
				return getOwnedStatements();
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
			case OmlPackage.DESCRIPTION__OWNED_IMPORTS:
				getOwnedImports().clear();
				getOwnedImports().addAll((Collection<? extends DescriptionImport>)newValue);
				return;
			case OmlPackage.DESCRIPTION__OWNED_STATEMENTS:
				getOwnedStatements().clear();
				getOwnedStatements().addAll((Collection<? extends DescriptionStatement>)newValue);
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
			case OmlPackage.DESCRIPTION__OWNED_IMPORTS:
				getOwnedImports().clear();
				return;
			case OmlPackage.DESCRIPTION__OWNED_STATEMENTS:
				getOwnedStatements().clear();
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
			case OmlPackage.DESCRIPTION__OWNED_IMPORTS:
				return ownedImports != null && !ownedImports.isEmpty();
			case OmlPackage.DESCRIPTION__OWNED_STATEMENTS:
				return ownedStatements != null && !ownedStatements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DescriptionImpl
