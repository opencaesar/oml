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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

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
	 * The cached value of the '{@link #getLiteralValue() <em>Literal Value</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteralValue()
	 * @generated
	 * @ordered
	 */
	protected EList<Literal> literalValue;

	/**
	 * The cached value of the '{@link #getContainedValue() <em>Contained Value</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedValue()
	 * @generated
	 * @ordered
	 */
	protected EList<AnonymousInstance> containedValue;

	/**
	 * The cached value of the '{@link #getReferencedValue() <em>Referenced Value</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedValue()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedInstance> referencedValue;

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
	public EList<Literal> getLiteralValue() {
		if (literalValue == null) {
			literalValue = new EObjectContainmentEList<Literal>(Literal.class, this, OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUE);
		}
		return literalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AnonymousInstance> getContainedValue() {
		if (containedValue == null) {
			containedValue = new EObjectContainmentWithInverseEList<AnonymousInstance>(AnonymousInstance.class, this, OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE, OmlPackage.ANONYMOUS_INSTANCE__OWNING_ASSERTION);
		}
		return containedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NamedInstance> getReferencedValue() {
		if (referencedValue == null) {
			referencedValue = new EObjectResolvingEList<NamedInstance>(NamedInstance.class, this, OmlPackage.PROPERTY_VALUE_ASSERTION__REFERENCED_VALUE);
		}
		return referencedValue;
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
	public EList<Element> getValue() {
		EList<Element> _xifexpression = null;
		boolean _isEmpty = this.getLiteralValue().isEmpty();
		boolean _not = (!_isEmpty);
		if (_not) {
			_xifexpression = ECollections.<Element>unmodifiableEList(this.getLiteralValue());
		}
		else {
			EList<Element> _xifexpression_1 = null;
			boolean _isEmpty_1 = this.getContainedValue().isEmpty();
			boolean _not_1 = (!_isEmpty_1);
			if (_not_1) {
				_xifexpression_1 = ECollections.<Element>unmodifiableEList(this.getContainedValue());
			}
			else {
				EList<Element> _xifexpression_2 = null;
				boolean _isEmpty_2 = this.getReferencedValue().isEmpty();
				boolean _not_2 = (!_isEmpty_2);
				if (_not_2) {
					_xifexpression_2 = ECollections.<Element>unmodifiableEList(this.getReferencedValue());
				}
				else {
					_xifexpression_2 = ECollections.<Element>emptyEList();
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
	public EList<Element> getObject() {
		return this.getValue();
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContainedValue()).basicAdd(otherEnd, msgs);
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
				return ((InternalEList<?>)getLiteralValue()).basicRemove(otherEnd, msgs);
			case OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE:
				return ((InternalEList<?>)getContainedValue()).basicRemove(otherEnd, msgs);
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
				return getReferencedValue();
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OmlPackage.PROPERTY_VALUE_ASSERTION__PROPERTY:
				setProperty((SemanticProperty)newValue);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUE:
				getLiteralValue().clear();
				getLiteralValue().addAll((Collection<? extends Literal>)newValue);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE:
				getContainedValue().clear();
				getContainedValue().addAll((Collection<? extends AnonymousInstance>)newValue);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__REFERENCED_VALUE:
				getReferencedValue().clear();
				getReferencedValue().addAll((Collection<? extends NamedInstance>)newValue);
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
				getLiteralValue().clear();
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE:
				getContainedValue().clear();
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__REFERENCED_VALUE:
				getReferencedValue().clear();
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
				return literalValue != null && !literalValue.isEmpty();
			case OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUE:
				return containedValue != null && !containedValue.isEmpty();
			case OmlPackage.PROPERTY_VALUE_ASSERTION__REFERENCED_VALUE:
				return referencedValue != null && !referencedValue.isEmpty();
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
