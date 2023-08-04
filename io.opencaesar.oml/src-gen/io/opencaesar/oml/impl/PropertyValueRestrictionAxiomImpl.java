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

import io.opencaesar.oml.Element;
import io.opencaesar.oml.Instance;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.PropertyValueRestrictionAxiom;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.SemanticProperty;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructuredProperty;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Value Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.PropertyValueRestrictionAxiomImpl#getLiteralValue <em>Literal Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PropertyValueRestrictionAxiomImpl#getContainedValue <em>Contained Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PropertyValueRestrictionAxiomImpl#getReferencedValue <em>Referenced Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyValueRestrictionAxiomImpl extends PropertyRestrictionAxiomImpl implements PropertyValueRestrictionAxiom {
	/**
	 * The cached value of the '{@link #getLiteralValue() <em>Literal Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteralValue()
	 * @generated
	 * @ordered
	 */
	protected Literal literalValue;

	/**
	 * The cached value of the '{@link #getContainedValue() <em>Contained Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedValue()
	 * @generated
	 * @ordered
	 */
	protected StructureInstance containedValue;

	/**
	 * The cached value of the '{@link #getReferencedValue() <em>Referenced Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedValue()
	 * @generated
	 * @ordered
	 */
	protected NamedInstance referencedValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyValueRestrictionAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.PROPERTY_VALUE_RESTRICTION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Literal getLiteralValue() {
		return literalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLiteralValue(Literal newLiteralValue, NotificationChain msgs) {
		Literal oldLiteralValue = literalValue;
		literalValue = newLiteralValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__LITERAL_VALUE, oldLiteralValue, newLiteralValue);
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
	public void setLiteralValue(Literal newLiteralValue) {
		if (newLiteralValue != literalValue) {
			NotificationChain msgs = null;
			if (literalValue != null)
				msgs = ((InternalEObject)literalValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__LITERAL_VALUE, null, msgs);
			if (newLiteralValue != null)
				msgs = ((InternalEObject)newLiteralValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__LITERAL_VALUE, null, msgs);
			msgs = basicSetLiteralValue(newLiteralValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__LITERAL_VALUE, newLiteralValue, newLiteralValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StructureInstance getContainedValue() {
		return containedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainedValue(StructureInstance newContainedValue, NotificationChain msgs) {
		StructureInstance oldContainedValue = containedValue;
		containedValue = newContainedValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__CONTAINED_VALUE, oldContainedValue, newContainedValue);
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
	public void setContainedValue(StructureInstance newContainedValue) {
		if (newContainedValue != containedValue) {
			NotificationChain msgs = null;
			if (containedValue != null)
				msgs = ((InternalEObject)containedValue).eInverseRemove(this, OmlPackage.STRUCTURE_INSTANCE__OWNING_AXIOM, StructureInstance.class, msgs);
			if (newContainedValue != null)
				msgs = ((InternalEObject)newContainedValue).eInverseAdd(this, OmlPackage.STRUCTURE_INSTANCE__OWNING_AXIOM, StructureInstance.class, msgs);
			msgs = basicSetContainedValue(newContainedValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__CONTAINED_VALUE, newContainedValue, newContainedValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedInstance getReferencedValue() {
		if (referencedValue != null && referencedValue.eIsProxy()) {
			InternalEObject oldReferencedValue = (InternalEObject)referencedValue;
			referencedValue = (NamedInstance)eResolveProxy(oldReferencedValue);
			if (referencedValue != oldReferencedValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__REFERENCED_VALUE, oldReferencedValue, referencedValue));
			}
		}
		return referencedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedInstance basicGetReferencedValue() {
		return referencedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferencedValue(NamedInstance newReferencedValue) {
		NamedInstance oldReferencedValue = referencedValue;
		referencedValue = newReferencedValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__REFERENCED_VALUE, oldReferencedValue, referencedValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Element getValue() {
		Element _xifexpression = null;
		SemanticProperty _property = this.getProperty();
		if ((_property instanceof ScalarProperty)) {
			_xifexpression = this.getLiteralValue();
		}
		else {
			Instance _xifexpression_1 = null;
			SemanticProperty _property_1 = this.getProperty();
			if ((_property_1 instanceof StructuredProperty)) {
				_xifexpression_1 = this.getContainedValue();
			}
			else {
				NamedInstance _xifexpression_2 = null;
				SemanticProperty _property_2 = this.getProperty();
				if ((_property_2 instanceof Relation)) {
					_xifexpression_2 = this.getReferencedValue();
				}
				_xifexpression_1 = _xifexpression_2;
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
			case OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__CONTAINED_VALUE:
				if (containedValue != null)
					msgs = ((InternalEObject)containedValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__CONTAINED_VALUE, null, msgs);
				return basicSetContainedValue((StructureInstance)otherEnd, msgs);
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
			case OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__LITERAL_VALUE:
				return basicSetLiteralValue(null, msgs);
			case OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__CONTAINED_VALUE:
				return basicSetContainedValue(null, msgs);
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
			case OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__LITERAL_VALUE:
				return getLiteralValue();
			case OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__CONTAINED_VALUE:
				return getContainedValue();
			case OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__REFERENCED_VALUE:
				if (resolve) return getReferencedValue();
				return basicGetReferencedValue();
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
			case OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__LITERAL_VALUE:
				setLiteralValue((Literal)newValue);
				return;
			case OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__CONTAINED_VALUE:
				setContainedValue((StructureInstance)newValue);
				return;
			case OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__REFERENCED_VALUE:
				setReferencedValue((NamedInstance)newValue);
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
			case OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__LITERAL_VALUE:
				setLiteralValue((Literal)null);
				return;
			case OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__CONTAINED_VALUE:
				setContainedValue((StructureInstance)null);
				return;
			case OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__REFERENCED_VALUE:
				setReferencedValue((NamedInstance)null);
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
			case OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__LITERAL_VALUE:
				return literalValue != null;
			case OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__CONTAINED_VALUE:
				return containedValue != null;
			case OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM__REFERENCED_VALUE:
				return referencedValue != null;
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
			case OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM___GET_VALUE:
				return getValue();
		}
		return super.eInvoke(operationID, arguments);
	}

} //PropertyValueRestrictionAxiomImpl
