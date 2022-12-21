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

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.IdentifiedElement;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Reference;

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
 * An implementation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.AnnotationImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.AnnotationImpl#getLiteralValue <em>Literal Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.AnnotationImpl#getReferenceValue <em>Reference Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.AnnotationImpl#getOwningElement <em>Owning Element</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.AnnotationImpl#getOwningReference <em>Owning Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnnotationImpl extends ElementImpl implements Annotation {
	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected AnnotationProperty property;

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
	 * The cached value of the '{@link #getReferenceValue() <em>Reference Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceValue()
	 * @generated
	 * @ordered
	 */
	protected Member referenceValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnnotationProperty getProperty() {
		if (property != null && property.eIsProxy()) {
			InternalEObject oldProperty = (InternalEObject)property;
			property = (AnnotationProperty)eResolveProxy(oldProperty);
			if (property != oldProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.ANNOTATION__PROPERTY, oldProperty, property));
			}
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationProperty basicGetProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProperty(AnnotationProperty newProperty) {
		AnnotationProperty oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.ANNOTATION__PROPERTY, oldProperty, property));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.ANNOTATION__LITERAL_VALUE, oldLiteralValue, newLiteralValue);
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
				msgs = ((InternalEObject)literalValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.ANNOTATION__LITERAL_VALUE, null, msgs);
			if (newLiteralValue != null)
				msgs = ((InternalEObject)newLiteralValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OmlPackage.ANNOTATION__LITERAL_VALUE, null, msgs);
			msgs = basicSetLiteralValue(newLiteralValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.ANNOTATION__LITERAL_VALUE, newLiteralValue, newLiteralValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Member getReferenceValue() {
		if (referenceValue != null && referenceValue.eIsProxy()) {
			InternalEObject oldReferenceValue = (InternalEObject)referenceValue;
			referenceValue = (Member)eResolveProxy(oldReferenceValue);
			if (referenceValue != oldReferenceValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.ANNOTATION__REFERENCE_VALUE, oldReferenceValue, referenceValue));
			}
		}
		return referenceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Member basicGetReferenceValue() {
		return referenceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferenceValue(Member newReferenceValue) {
		Member oldReferenceValue = referenceValue;
		referenceValue = newReferenceValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.ANNOTATION__REFERENCE_VALUE, oldReferenceValue, referenceValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IdentifiedElement getOwningElement() {
		if (eContainerFeatureID() != OmlPackage.ANNOTATION__OWNING_ELEMENT) return null;
		return (IdentifiedElement)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifiedElement basicGetOwningElement() {
		if (eContainerFeatureID() != OmlPackage.ANNOTATION__OWNING_ELEMENT) return null;
		return (IdentifiedElement)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningElement(IdentifiedElement newOwningElement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningElement, OmlPackage.ANNOTATION__OWNING_ELEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningElement(IdentifiedElement newOwningElement) {
		if (newOwningElement != eInternalContainer() || (eContainerFeatureID() != OmlPackage.ANNOTATION__OWNING_ELEMENT && newOwningElement != null)) {
			if (EcoreUtil.isAncestor(this, newOwningElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningElement != null)
				msgs = ((InternalEObject)newOwningElement).eInverseAdd(this, OmlPackage.IDENTIFIED_ELEMENT__OWNED_ANNOTATIONS, IdentifiedElement.class, msgs);
			msgs = basicSetOwningElement(newOwningElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.ANNOTATION__OWNING_ELEMENT, newOwningElement, newOwningElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Reference getOwningReference() {
		if (eContainerFeatureID() != OmlPackage.ANNOTATION__OWNING_REFERENCE) return null;
		return (Reference)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference basicGetOwningReference() {
		if (eContainerFeatureID() != OmlPackage.ANNOTATION__OWNING_REFERENCE) return null;
		return (Reference)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningReference(Reference newOwningReference, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningReference, OmlPackage.ANNOTATION__OWNING_REFERENCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningReference(Reference newOwningReference) {
		if (newOwningReference != eInternalContainer() || (eContainerFeatureID() != OmlPackage.ANNOTATION__OWNING_REFERENCE && newOwningReference != null)) {
			if (EcoreUtil.isAncestor(this, newOwningReference))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningReference != null)
				msgs = ((InternalEObject)newOwningReference).eInverseAdd(this, OmlPackage.REFERENCE__OWNED_ANNOTATIONS, Reference.class, msgs);
			msgs = basicSetOwningReference(newOwningReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.ANNOTATION__OWNING_REFERENCE, newOwningReference, newOwningReference));
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
			Member _xifexpression_1 = null;
			Member _referenceValue = this.getReferenceValue();
			boolean _tripleNotEquals_1 = (_referenceValue != null);
			if (_tripleNotEquals_1) {
				_xifexpression_1 = this.getReferenceValue();
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
			case OmlPackage.ANNOTATION__OWNING_ELEMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningElement((IdentifiedElement)otherEnd, msgs);
			case OmlPackage.ANNOTATION__OWNING_REFERENCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningReference((Reference)otherEnd, msgs);
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
			case OmlPackage.ANNOTATION__LITERAL_VALUE:
				return basicSetLiteralValue(null, msgs);
			case OmlPackage.ANNOTATION__OWNING_ELEMENT:
				return basicSetOwningElement(null, msgs);
			case OmlPackage.ANNOTATION__OWNING_REFERENCE:
				return basicSetOwningReference(null, msgs);
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
			case OmlPackage.ANNOTATION__OWNING_ELEMENT:
				return eInternalContainer().eInverseRemove(this, OmlPackage.IDENTIFIED_ELEMENT__OWNED_ANNOTATIONS, IdentifiedElement.class, msgs);
			case OmlPackage.ANNOTATION__OWNING_REFERENCE:
				return eInternalContainer().eInverseRemove(this, OmlPackage.REFERENCE__OWNED_ANNOTATIONS, Reference.class, msgs);
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
			case OmlPackage.ANNOTATION__PROPERTY:
				if (resolve) return getProperty();
				return basicGetProperty();
			case OmlPackage.ANNOTATION__LITERAL_VALUE:
				return getLiteralValue();
			case OmlPackage.ANNOTATION__REFERENCE_VALUE:
				if (resolve) return getReferenceValue();
				return basicGetReferenceValue();
			case OmlPackage.ANNOTATION__OWNING_ELEMENT:
				if (resolve) return getOwningElement();
				return basicGetOwningElement();
			case OmlPackage.ANNOTATION__OWNING_REFERENCE:
				if (resolve) return getOwningReference();
				return basicGetOwningReference();
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
			case OmlPackage.ANNOTATION__PROPERTY:
				setProperty((AnnotationProperty)newValue);
				return;
			case OmlPackage.ANNOTATION__LITERAL_VALUE:
				setLiteralValue((Literal)newValue);
				return;
			case OmlPackage.ANNOTATION__REFERENCE_VALUE:
				setReferenceValue((Member)newValue);
				return;
			case OmlPackage.ANNOTATION__OWNING_ELEMENT:
				setOwningElement((IdentifiedElement)newValue);
				return;
			case OmlPackage.ANNOTATION__OWNING_REFERENCE:
				setOwningReference((Reference)newValue);
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
			case OmlPackage.ANNOTATION__PROPERTY:
				setProperty((AnnotationProperty)null);
				return;
			case OmlPackage.ANNOTATION__LITERAL_VALUE:
				setLiteralValue((Literal)null);
				return;
			case OmlPackage.ANNOTATION__REFERENCE_VALUE:
				setReferenceValue((Member)null);
				return;
			case OmlPackage.ANNOTATION__OWNING_ELEMENT:
				setOwningElement((IdentifiedElement)null);
				return;
			case OmlPackage.ANNOTATION__OWNING_REFERENCE:
				setOwningReference((Reference)null);
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
			case OmlPackage.ANNOTATION__PROPERTY:
				return property != null;
			case OmlPackage.ANNOTATION__LITERAL_VALUE:
				return literalValue != null;
			case OmlPackage.ANNOTATION__REFERENCE_VALUE:
				return referenceValue != null;
			case OmlPackage.ANNOTATION__OWNING_ELEMENT:
				return basicGetOwningElement() != null;
			case OmlPackage.ANNOTATION__OWNING_REFERENCE:
				return basicGetOwningReference() != null;
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
			case OmlPackage.ANNOTATION___GET_VALUE:
				return getValue();
		}
		return super.eInvoke(operationID, arguments);
	}

} //AnnotationImpl
