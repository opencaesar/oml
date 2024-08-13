/**
 * 
 * Copyright 2019-2022 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	 http://www.apache.org/licenses/LICENSE-2.0
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
import io.opencaesar.oml.AnonymousRelationInstance;
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

import org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Value Assertion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.PropertyValueAssertionImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PropertyValueAssertionImpl#getLiteralValues <em>Literal Values</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PropertyValueAssertionImpl#getContainedValues <em>Contained Values</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PropertyValueAssertionImpl#getReferencedValues <em>Referenced Values</em>}</li>
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
	 * The cached value of the '{@link #getLiteralValues() <em>Literal Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteralValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Literal> literalValues;

	/**
	 * The cached value of the '{@link #getContainedValues() <em>Contained Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedValues()
	 * @generated
	 * @ordered
	 */
	protected EList<AnonymousInstance> containedValues;

	/**
	 * The cached value of the '{@link #getReferencedValues() <em>Referenced Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedValues()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedInstance> referencedValues;

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
	public EList<Literal> getLiteralValues() {
		if (literalValues == null) {
			literalValues = new EObjectContainmentEList<Literal>(Literal.class, this, OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUES);
		}
		return literalValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AnonymousInstance> getContainedValues() {
		if (containedValues == null) {
			containedValues = new EObjectContainmentWithInverseEList<AnonymousInstance>(AnonymousInstance.class, this, OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUES, OmlPackage.ANONYMOUS_INSTANCE__OWNING_ASSERTION);
		}
		return containedValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NamedInstance> getReferencedValues() {
		if (referencedValues == null) {
			referencedValues = new EObjectResolvingEList<NamedInstance>(NamedInstance.class, this, OmlPackage.PROPERTY_VALUE_ASSERTION__REFERENCED_VALUES);
		}
		return referencedValues;
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
	public EList<Element> getValues() {
		EList<Element> _xifexpression = null;
		boolean _isEmpty = this.getLiteralValues().isEmpty();
		boolean _not = (!_isEmpty);
		if (_not) {
			_xifexpression = ECollections.<Element>unmodifiableEList(this.getLiteralValues());
		}
		else {
			EList<Element> _xifexpression_1 = null;
			boolean _isEmpty_1 = this.getContainedValues().isEmpty();
			boolean _not_1 = (!_isEmpty_1);
			if (_not_1) {
				_xifexpression_1 = ECollections.<Element>unmodifiableEList(this.getContainedValues());
			}
			else {
				EList<Element> _xifexpression_2 = null;
				boolean _isEmpty_2 = this.getReferencedValues().isEmpty();
				boolean _not_2 = (!_isEmpty_2);
				if (_not_2) {
					_xifexpression_2 = ECollections.<Element>unmodifiableEList(this.getReferencedValues());
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
	public Element getValue() {
		Element _xifexpression = null;
		boolean _isEmpty = this.getLiteralValues().isEmpty();
		boolean _not = (!_isEmpty);
		if (_not) {
			_xifexpression = this.getLiteralValue();
		}
		else {
			Instance _xifexpression_1 = null;
			boolean _isEmpty_1 = this.getContainedValues().isEmpty();
			boolean _not_1 = (!_isEmpty_1);
			if (_not_1) {
				_xifexpression_1 = this.getContainedValue();
			}
			else {
				NamedInstance _xifexpression_2 = null;
				boolean _isEmpty_2 = this.getReferencedValues().isEmpty();
				boolean _not_2 = (!_isEmpty_2);
				if (_not_2) {
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
	public Literal getLiteralValue() {
		Literal _xifexpression = null;
		boolean _isEmpty = this.getLiteralValues().isEmpty();
		boolean _not = (!_isEmpty);
		if (_not) {
			_xifexpression = this.getLiteralValues().get(0);
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiteralValue(final Literal value) {
		this.getLiteralValues().clear();
		this.getLiteralValues().add(value);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnonymousInstance getContainedValue() {
		AnonymousInstance _xifexpression = null;
		boolean _isEmpty = this.getContainedValues().isEmpty();
		boolean _not = (!_isEmpty);
		if (_not) {
			_xifexpression = this.getContainedValues().get(0);
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContainedValue(final AnonymousInstance value) {
		this.getContainedValues().clear();
		this.getContainedValues().add(value);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedInstance getReferencedValue() {
		NamedInstance _xifexpression = null;
		boolean _isEmpty = this.getReferencedValues().isEmpty();
		boolean _not = (!_isEmpty);
		if (_not) {
			_xifexpression = this.getReferencedValues().get(0);
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferencedValue(final NamedInstance value) {
		this.getReferencedValues().clear();
		this.getReferencedValues().add(value);
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
		EList<Element> _xifexpression = null;
		boolean _isEmpty = this.getContainedValues().isEmpty();
		boolean _not = (!_isEmpty);
		if (_not) {
			final Function1<AnonymousInstance, Element> _function = new Function1<AnonymousInstance, Element>() {
				public Element apply(final AnonymousInstance v) {
					Instance _xifexpression = null;
					if ((v instanceof AnonymousRelationInstance)) {
						_xifexpression = ((AnonymousRelationInstance)v).getTarget();
					}
					else {
						_xifexpression = v;
					}
					return _xifexpression;
				}
			};
			_xifexpression = XcoreEListExtensions.<AnonymousInstance, Element>map(this.getContainedValues(), _function);
		}
		else {
			_xifexpression = this.getValues();
		}
		return _xifexpression;
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContainedValues()).basicAdd(otherEnd, msgs);
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUES:
				return ((InternalEList<?>)getLiteralValues()).basicRemove(otherEnd, msgs);
			case OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUES:
				return ((InternalEList<?>)getContainedValues()).basicRemove(otherEnd, msgs);
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUES:
				return getLiteralValues();
			case OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUES:
				return getContainedValues();
			case OmlPackage.PROPERTY_VALUE_ASSERTION__REFERENCED_VALUES:
				return getReferencedValues();
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUES:
				getLiteralValues().clear();
				getLiteralValues().addAll((Collection<? extends Literal>)newValue);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUES:
				getContainedValues().clear();
				getContainedValues().addAll((Collection<? extends AnonymousInstance>)newValue);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__REFERENCED_VALUES:
				getReferencedValues().clear();
				getReferencedValues().addAll((Collection<? extends NamedInstance>)newValue);
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUES:
				getLiteralValues().clear();
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUES:
				getContainedValues().clear();
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__REFERENCED_VALUES:
				getReferencedValues().clear();
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUES:
				return literalValues != null && !literalValues.isEmpty();
			case OmlPackage.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUES:
				return containedValues != null && !containedValues.isEmpty();
			case OmlPackage.PROPERTY_VALUE_ASSERTION__REFERENCED_VALUES:
				return referencedValues != null && !referencedValues.isEmpty();
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION___GET_VALUES:
				return getValues();
			case OmlPackage.PROPERTY_VALUE_ASSERTION___GET_VALUE:
				return getValue();
			case OmlPackage.PROPERTY_VALUE_ASSERTION___GET_LITERAL_VALUE:
				return getLiteralValue();
			case OmlPackage.PROPERTY_VALUE_ASSERTION___SET_LITERAL_VALUE__LITERAL:
				setLiteralValue((Literal)arguments.get(0));
				return null;
			case OmlPackage.PROPERTY_VALUE_ASSERTION___GET_CONTAINED_VALUE:
				return getContainedValue();
			case OmlPackage.PROPERTY_VALUE_ASSERTION___SET_CONTAINED_VALUE__ANONYMOUSINSTANCE:
				setContainedValue((AnonymousInstance)arguments.get(0));
				return null;
			case OmlPackage.PROPERTY_VALUE_ASSERTION___GET_REFERENCED_VALUE:
				return getReferencedValue();
			case OmlPackage.PROPERTY_VALUE_ASSERTION___SET_REFERENCED_VALUE__NAMEDINSTANCE:
				setReferencedValue((NamedInstance)arguments.get(0));
				return null;
			case OmlPackage.PROPERTY_VALUE_ASSERTION___GET_SUBJECT:
				return getSubject();
			case OmlPackage.PROPERTY_VALUE_ASSERTION___GET_OBJECT:
				return getObject();
		}
		return super.eInvoke(operationID, arguments);
	}

} //PropertyValueAssertionImpl
