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
import io.opencaesar.oml.NamedInstanceReference;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.PropertyValueAssertion;
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

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Value Assertion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.PropertyValueAssertionImpl#getOwningInstance <em>Owning Instance</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PropertyValueAssertionImpl#getOwningReference <em>Owning Reference</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PropertyValueAssertionImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PropertyValueAssertionImpl#getLiteralValue <em>Literal Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PropertyValueAssertionImpl#getStructureInstanceValue <em>Structure Instance Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PropertyValueAssertionImpl#getNamedInstanceValue <em>Named Instance Value</em>}</li>
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
	 * The cached value of the '{@link #getStructureInstanceValue() <em>Structure Instance Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructureInstanceValue()
	 * @generated
	 * @ordered
	 */
	protected StructureInstance structureInstanceValue;

	/**
	 * The cached value of the '{@link #getNamedInstanceValue() <em>Named Instance Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamedInstanceValue()
	 * @generated
	 * @ordered
	 */
	protected NamedInstance namedInstanceValue;

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
	public NamedInstanceReference getOwningReference() {
		if (eContainerFeatureID() != OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_REFERENCE) return null;
		return (NamedInstanceReference)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedInstanceReference basicGetOwningReference() {
		if (eContainerFeatureID() != OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_REFERENCE) return null;
		return (NamedInstanceReference)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningReference(NamedInstanceReference newOwningReference, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningReference, OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_REFERENCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningReference(NamedInstanceReference newOwningReference) {
		if (newOwningReference != eInternalContainer() || (eContainerFeatureID() != OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_REFERENCE && newOwningReference != null)) {
			if (EcoreUtil.isAncestor(this, newOwningReference))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningReference != null)
				msgs = ((InternalEObject)newOwningReference).eInverseAdd(this, OmlPackage.NAMED_INSTANCE_REFERENCE__OWNED_PROPERTY_VALUES, NamedInstanceReference.class, msgs);
			msgs = basicSetOwningReference(newOwningReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_REFERENCE, newOwningReference, newOwningReference));
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
	public StructureInstance getStructureInstanceValue() {
		return structureInstanceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStructureInstanceValue(StructureInstance newStructureInstanceValue, NotificationChain msgs) {
		StructureInstance oldStructureInstanceValue = structureInstanceValue;
		structureInstanceValue = newStructureInstanceValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_VALUE_ASSERTION__STRUCTURE_INSTANCE_VALUE, oldStructureInstanceValue, newStructureInstanceValue);
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
	public void setStructureInstanceValue(StructureInstance newStructureInstanceValue) {
		if (newStructureInstanceValue != structureInstanceValue) {
			NotificationChain msgs = null;
			if (structureInstanceValue != null)
				msgs = ((InternalEObject)structureInstanceValue).eInverseRemove(this, OmlPackage.STRUCTURE_INSTANCE__OWNING_ASSERTION, StructureInstance.class, msgs);
			if (newStructureInstanceValue != null)
				msgs = ((InternalEObject)newStructureInstanceValue).eInverseAdd(this, OmlPackage.STRUCTURE_INSTANCE__OWNING_ASSERTION, StructureInstance.class, msgs);
			msgs = basicSetStructureInstanceValue(newStructureInstanceValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_VALUE_ASSERTION__STRUCTURE_INSTANCE_VALUE, newStructureInstanceValue, newStructureInstanceValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedInstance getNamedInstanceValue() {
		if (namedInstanceValue != null && namedInstanceValue.eIsProxy()) {
			InternalEObject oldNamedInstanceValue = (InternalEObject)namedInstanceValue;
			namedInstanceValue = (NamedInstance)eResolveProxy(oldNamedInstanceValue);
			if (namedInstanceValue != oldNamedInstanceValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.PROPERTY_VALUE_ASSERTION__NAMED_INSTANCE_VALUE, oldNamedInstanceValue, namedInstanceValue));
			}
		}
		return namedInstanceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedInstance basicGetNamedInstanceValue() {
		return namedInstanceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNamedInstanceValue(NamedInstance newNamedInstanceValue) {
		NamedInstance oldNamedInstanceValue = namedInstanceValue;
		namedInstanceValue = newNamedInstanceValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_VALUE_ASSERTION__NAMED_INSTANCE_VALUE, oldNamedInstanceValue, namedInstanceValue));
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
				_xifexpression_1 = this.getStructureInstanceValue();
			}
			else {
				NamedInstance _xifexpression_2 = null;
				SemanticProperty _property_2 = this.getProperty();
				if ((_property_2 instanceof Relation)) {
					_xifexpression_2 = this.getNamedInstanceValue();
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningInstance((Instance)otherEnd, msgs);
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_REFERENCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningReference((NamedInstanceReference)otherEnd, msgs);
			case OmlPackage.PROPERTY_VALUE_ASSERTION__STRUCTURE_INSTANCE_VALUE:
				if (structureInstanceValue != null)
					msgs = ((InternalEObject)structureInstanceValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.PROPERTY_VALUE_ASSERTION__STRUCTURE_INSTANCE_VALUE, null, msgs);
				return basicSetStructureInstanceValue((StructureInstance)otherEnd, msgs);
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE:
				return basicSetOwningInstance(null, msgs);
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_REFERENCE:
				return basicSetOwningReference(null, msgs);
			case OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUE:
				return basicSetLiteralValue(null, msgs);
			case OmlPackage.PROPERTY_VALUE_ASSERTION__STRUCTURE_INSTANCE_VALUE:
				return basicSetStructureInstanceValue(null, msgs);
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_REFERENCE:
				return eInternalContainer().eInverseRemove(this, OmlPackage.NAMED_INSTANCE_REFERENCE__OWNED_PROPERTY_VALUES, NamedInstanceReference.class, msgs);
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE:
				if (resolve) return getOwningInstance();
				return basicGetOwningInstance();
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_REFERENCE:
				if (resolve) return getOwningReference();
				return basicGetOwningReference();
			case OmlPackage.PROPERTY_VALUE_ASSERTION__PROPERTY:
				if (resolve) return getProperty();
				return basicGetProperty();
			case OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUE:
				return getLiteralValue();
			case OmlPackage.PROPERTY_VALUE_ASSERTION__STRUCTURE_INSTANCE_VALUE:
				return getStructureInstanceValue();
			case OmlPackage.PROPERTY_VALUE_ASSERTION__NAMED_INSTANCE_VALUE:
				if (resolve) return getNamedInstanceValue();
				return basicGetNamedInstanceValue();
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE:
				setOwningInstance((Instance)newValue);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_REFERENCE:
				setOwningReference((NamedInstanceReference)newValue);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__PROPERTY:
				setProperty((SemanticProperty)newValue);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUE:
				setLiteralValue((Literal)newValue);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__STRUCTURE_INSTANCE_VALUE:
				setStructureInstanceValue((StructureInstance)newValue);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__NAMED_INSTANCE_VALUE:
				setNamedInstanceValue((NamedInstance)newValue);
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE:
				setOwningInstance((Instance)null);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_REFERENCE:
				setOwningReference((NamedInstanceReference)null);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__PROPERTY:
				setProperty((SemanticProperty)null);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUE:
				setLiteralValue((Literal)null);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__STRUCTURE_INSTANCE_VALUE:
				setStructureInstanceValue((StructureInstance)null);
				return;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__NAMED_INSTANCE_VALUE:
				setNamedInstanceValue((NamedInstance)null);
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
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE:
				return basicGetOwningInstance() != null;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__OWNING_REFERENCE:
				return basicGetOwningReference() != null;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__PROPERTY:
				return property != null;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__LITERAL_VALUE:
				return literalValue != null;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__STRUCTURE_INSTANCE_VALUE:
				return structureInstanceValue != null;
			case OmlPackage.PROPERTY_VALUE_ASSERTION__NAMED_INSTANCE_VALUE:
				return namedInstanceValue != null;
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
		}
		return super.eInvoke(operationID, arguments);
	}

} //PropertyValueAssertionImpl
