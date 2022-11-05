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

import io.opencaesar.oml.CardinalityRestrictionKind;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructuredPropertyCardinalityRestrictionAxiom;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structured Property Cardinality Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.StructuredPropertyCardinalityRestrictionAxiomImpl#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.StructuredPropertyCardinalityRestrictionAxiomImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.StructuredPropertyCardinalityRestrictionAxiomImpl#getRange <em>Range</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StructuredPropertyCardinalityRestrictionAxiomImpl extends StructuredPropertyRestrictionAxiomImpl implements StructuredPropertyCardinalityRestrictionAxiom {
	/**
	 * The default value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCardinality()
	 * @generated
	 * @ordered
	 */
	protected static final long CARDINALITY_EDEFAULT = 1L;

	/**
	 * The cached value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCardinality()
	 * @generated
	 * @ordered
	 */
	protected long cardinality = CARDINALITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final CardinalityRestrictionKind KIND_EDEFAULT = CardinalityRestrictionKind.EXACTLY;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected CardinalityRestrictionKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRange() <em>Range</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected Structure range;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructuredPropertyCardinalityRestrictionAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getCardinality() {
		return cardinality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCardinality(long newCardinality) {
		long oldCardinality = cardinality;
		cardinality = newCardinality;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__CARDINALITY, oldCardinality, cardinality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CardinalityRestrictionKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKind(CardinalityRestrictionKind newKind) {
		CardinalityRestrictionKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Structure getRange() {
		if (range != null && range.eIsProxy()) {
			InternalEObject oldRange = (InternalEObject)range;
			range = (Structure)eResolveProxy(oldRange);
			if (range != oldRange) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE, oldRange, range));
			}
		}
		return range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Structure basicGetRange() {
		return range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRange(Structure newRange) {
		Structure oldRange = range;
		range = newRange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE, oldRange, range));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__CARDINALITY:
				return getCardinality();
			case OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__KIND:
				return getKind();
			case OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE:
				if (resolve) return getRange();
				return basicGetRange();
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
			case OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__CARDINALITY:
				setCardinality((Long)newValue);
				return;
			case OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__KIND:
				setKind((CardinalityRestrictionKind)newValue);
				return;
			case OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE:
				setRange((Structure)newValue);
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
			case OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__CARDINALITY:
				setCardinality(CARDINALITY_EDEFAULT);
				return;
			case OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE:
				setRange((Structure)null);
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
			case OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__CARDINALITY:
				return cardinality != CARDINALITY_EDEFAULT;
			case OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__KIND:
				return kind != KIND_EDEFAULT;
			case OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE:
				return range != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (cardinality: ");
		result.append(cardinality);
		result.append(", kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //StructuredPropertyCardinalityRestrictionAxiomImpl
