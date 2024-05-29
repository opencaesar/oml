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

import io.opencaesar.oml.AnonymousInstance;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Instance;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.PropertyValueAssertion;
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
 * An implementation of the model object '<em><b>Property Value Assertion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.PropertyValueAssertionImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PropertyValueAssertionImpl#getLiteralValue <em>Literal Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PropertyValueAssertionImpl#getContainedValue <em>Contained Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PropertyValueAssertionImpl#getReferencedValue <em>Referenced Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PropertyValueAssertionImpl#getOwningInstance <em>Owning Instance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyValueAssertionImpl extends AssertionImpl implements PropertyValueAssertion {
	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected SemanticProperty property;

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
	protected AnonymousInstance containedValue;

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
	protected PropertyValueAssertionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.PROPERTY_VALUE_ASSERTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SemanticProperty getProperty() {
		if (property != null && property.eIsProxy()) {
			InternalEObject oldProperty = (InternalEObject)property;
			property = (SemanticProperty)eResolveProxy(oldProperty);
			if (property != oldProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.PROPERTY_VALUE_ASSERTION__PROPERTY, oldProperty, property));
			}
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticProperty basicGetProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProperty(SemanticProperty newProperty) {
		SemanticProperty oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_VALUE_ASSERTION__PROPERTY, oldProperty, property));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUE, oldLiteralValue, newLiteralValue);
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
				msgs = ((InternalEObject)literalValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUE, null, msgs);
			if (newLiteralValue != null)
				msgs = ((InternalEObject)newLiteralValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUE, null, msgs);
			msgs = basicSetLiteralValue(newLiteralValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUE, newLiteralValue, newLiteralValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnonymousInstance getContainedValue() {
		return containedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainedValue(AnonymousInstance newContainedValue, NotificationChain msgs) {
		AnonymousInstance oldContainedValue = containedValue;
		containedValue = newContainedValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE, oldContainedValue, newContainedValue);
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
	public void setContainedValue(AnonymousInstance newContainedValue) {
		if (newContainedValue != containedValue) {
			NotificationChain msgs = null;
			if (containedValue != null)
				msgs = ((InternalEObject)containedValue).eInverseRemove(this, OmlPackage.ANONYMOUS_INSTANCE__OWNING_ASSERTION, AnonymousInstance.class, msgs);
			if (newContainedValue != null)
				msgs = ((InternalEObject)newContainedValue).eInverseAdd(this, OmlPackage.ANONYMOUS_INSTANCE__OWNING_ASSERTION, AnonymousInstance.class, msgs);
			msgs = basicSetContainedValue(newContainedValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE, newContainedValue, newContainedValue));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.PROPERTY_VALUE_ASSERTION__REFERENCED_VALUE, oldReferencedValue, referencedValue));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_VALUE_ASSERTION__REFERENCED_VALUE, oldReferencedValue, referencedValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Instance getOwningInstance() {
		if (eContainerFeatureID() != OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE) return null;
		return (Instance)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Instance basicGetOwningInstance() {
		if (eContainerFeatureID() != OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE) return null;
		return (Instance)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningInstance(Instance newOwningInstance, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningInstance, OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningInstance(Instance newOwningInstance) {
		if (newOwningInstance != eInternalContainer() || (eContainerFeatureID() != OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE && newOwningInstance != null)) {
			if (EcoreUtil.isAncestor(this, newOwningInstance))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningInstance != null)
				msgs = ((InternalEObject)newOwningInstance).eInverseAdd(this, OmlPackage.INSTANCE__OWNED_PROPERTY_VALUES, Instance.class, msgs);
			msgs = basicSetOwningInstance(newOwningInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE, newOwningInstance, newOwningInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Element getValue() {
		Element _xifexpression = null;
		Literal _literalValue = this.getLiteralValue();
		boolean _tripleNotEquals = (_literalValue != null);
		if (_tripleNotEquals) {
			_xifexpression = this.getLiteralValue();
		}
		else {
			Instance _xifexpression_1 = null;
			AnonymousInstance _containedValue = this.getContainedValue();
			boolean _tripleNotEquals_1 = (_containedValue != null);
			if (_tripleNotEquals_1) {
				_xifexpression_1 = this.getContainedValue();
			}
			else {
				NamedInstance _xifexpression_2 = null;
				NamedInstance _referencedValue = this.getReferencedValue();
				boolean _tripleNotEquals_2 = (_referencedValue != null);
				if (_tripleNotEquals_2) {
					_xifexpression_2 = this.getReferencedValue();
				}
				else {
					_xifexpression_2 = null;
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
	public Instance getSubject() {
		Instance _xifexpression = null;
		Instance _owningInstance = this.getOwningInstance();
		if ((_owningInstance instanceof NamedInstance)) {
			Instance _owningInstance_1 = this.getOwningInstance();
			Member _resolve = ((NamedInstance) _owningInstance_1).resolve();
			_xifexpression = ((NamedInstance) _resolve);
		}
		else {
			_xifexpression = this.getOwningInstance();
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Element getObject() {
		return this.getValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE:
				if (containedValue != null)
					msgs = ((InternalEObject)containedValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE, null, msgs);
				return basicSetContainedValue((AnonymousInstance)otherEnd, msgs);
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningInstance((Instance)otherEnd, msgs);
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUE:
				return basicSetLiteralValue(null, msgs);
			case OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE:
				return basicSetContainedValue(null, msgs);
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE:
				return basicSetOwningInstance(null, msgs);
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE:
				return eInternalContainer().eInverseRemove(this, OmlPackage.INSTANCE__OWNED_PROPERTY_VALUES, Instance.class, msgs);
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__PROPERTY:
				if (resolve) return getProperty();
				return basicGetProperty();
			case OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUE:
				return getLiteralValue();
			case OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE:
				return getContainedValue();
			case OmlPackage.PROPERTY_VALUE_ASSERTION__REFERENCED_VALUE:
				if (resolve) return getReferencedValue();
				return basicGetReferencedValue();
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE:
				if (resolve) return getOwningInstance();
				return basicGetOwningInstance();
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__PROPERTY:
				setProperty((SemanticProperty)newValue);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUE:
				setLiteralValue((Literal)newValue);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE:
				setContainedValue((AnonymousInstance)newValue);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__REFERENCED_VALUE:
				setReferencedValue((NamedInstance)newValue);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE:
				setOwningInstance((Instance)newValue);
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__PROPERTY:
				setProperty((SemanticProperty)null);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUE:
				setLiteralValue((Literal)null);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE:
				setContainedValue((AnonymousInstance)null);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__REFERENCED_VALUE:
				setReferencedValue((NamedInstance)null);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE:
				setOwningInstance((Instance)null);
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__PROPERTY:
				return property != null;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUE:
				return literalValue != null;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE:
				return containedValue != null;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__REFERENCED_VALUE:
				return referencedValue != null;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE:
				return basicGetOwningInstance() != null;
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION___GET_VALUE:
				return getValue();
			case OmlPackage.PROPERTY_VALUE_ASSERTION___GET_SUBJECT:
				return getSubject();
			case OmlPackage.PROPERTY_VALUE_ASSERTION___GET_OBJECT:
				return getObject();
		}
		return super.eInvoke(operationID, arguments);
	}

} //PropertyValueAssertionImpl
