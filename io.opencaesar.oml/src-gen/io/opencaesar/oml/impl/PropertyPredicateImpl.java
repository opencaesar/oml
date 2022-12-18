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

import io.opencaesar.oml.Literal;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Property;
import io.opencaesar.oml.PropertyPredicate;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.PropertyPredicateImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PropertyPredicateImpl#getLiteral2 <em>Literal2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyPredicateImpl extends BinaryPredicateImpl implements PropertyPredicate {
	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected Property property;

	/**
	 * The cached value of the '{@link #getLiteral2() <em>Literal2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteral2()
	 * @generated
	 * @ordered
	 */
	protected Literal literal2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyPredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.PROPERTY_PREDICATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getProperty() {
		if (property != null && property.eIsProxy()) {
			InternalEObject oldProperty = (InternalEObject)property;
			property = (Property)eResolveProxy(oldProperty);
			if (property != oldProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.PROPERTY_PREDICATE__PROPERTY, oldProperty, property));
			}
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProperty(Property newProperty) {
		Property oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_PREDICATE__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Literal getLiteral2() {
		return literal2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLiteral2(Literal newLiteral2, NotificationChain msgs) {
		Literal oldLiteral2 = literal2;
		literal2 = newLiteral2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_PREDICATE__LITERAL2, oldLiteral2, newLiteral2);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiteral2(Literal newLiteral2) {
		if (newLiteral2 != literal2) {
			NotificationChain msgs = null;
			if (literal2 != null)
				msgs = ((InternalEObject)literal2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.PROPERTY_PREDICATE__LITERAL2, null, msgs);
			if (newLiteral2 != null)
				msgs = ((InternalEObject)newLiteral2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OmlPackage.PROPERTY_PREDICATE__LITERAL2, null, msgs);
			msgs = basicSetLiteral2(newLiteral2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_PREDICATE__LITERAL2, newLiteral2, newLiteral2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.PROPERTY_PREDICATE__LITERAL2:
				return basicSetLiteral2(null, msgs);
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
			case OmlPackage.PROPERTY_PREDICATE__PROPERTY:
				if (resolve) return getProperty();
				return basicGetProperty();
			case OmlPackage.PROPERTY_PREDICATE__LITERAL2:
				return getLiteral2();
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
			case OmlPackage.PROPERTY_PREDICATE__PROPERTY:
				setProperty((Property)newValue);
				return;
			case OmlPackage.PROPERTY_PREDICATE__LITERAL2:
				setLiteral2((Literal)newValue);
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
			case OmlPackage.PROPERTY_PREDICATE__PROPERTY:
				setProperty((Property)null);
				return;
			case OmlPackage.PROPERTY_PREDICATE__LITERAL2:
				setLiteral2((Literal)null);
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
			case OmlPackage.PROPERTY_PREDICATE__PROPERTY:
				return property != null;
			case OmlPackage.PROPERTY_PREDICATE__LITERAL2:
				return literal2 != null;
		}
		return super.eIsSet(featureID);
	}

} //PropertyPredicateImpl
