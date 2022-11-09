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

import io.opencaesar.oml.AnnotatedElement;
import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Reference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

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
 *   <li>{@link io.opencaesar.oml.impl.AnnotationImpl#getValue <em>Value</em>}</li>
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
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Literal value;

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
	public Literal getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(Literal newValue, NotificationChain msgs) {
		Literal oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.ANNOTATION__VALUE, oldValue, newValue);
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
	public void setValue(Literal newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.ANNOTATION__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OmlPackage.ANNOTATION__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.ANNOTATION__VALUE, newValue, newValue));
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
	public AnnotatedElement getOwningElement() {
		if (eContainerFeatureID() != OmlPackage.ANNOTATION__OWNING_ELEMENT) return null;
		return (AnnotatedElement)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotatedElement basicGetOwningElement() {
		if (eContainerFeatureID() != OmlPackage.ANNOTATION__OWNING_ELEMENT) return null;
		return (AnnotatedElement)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningElement(AnnotatedElement newOwningElement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningElement, OmlPackage.ANNOTATION__OWNING_ELEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningElement(AnnotatedElement newOwningElement) {
		if (newOwningElement != eInternalContainer() || (eContainerFeatureID() != OmlPackage.ANNOTATION__OWNING_ELEMENT && newOwningElement != null)) {
			if (EcoreUtil.isAncestor(this, newOwningElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningElement != null)
				msgs = ((InternalEObject)newOwningElement).eInverseAdd(this, OmlPackage.ANNOTATED_ELEMENT__OWNED_ANNOTATIONS, AnnotatedElement.class, msgs);
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.ANNOTATION__OWNING_ELEMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningElement((AnnotatedElement)otherEnd, msgs);
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
			case OmlPackage.ANNOTATION__VALUE:
				return basicSetValue(null, msgs);
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
				return eInternalContainer().eInverseRemove(this, OmlPackage.ANNOTATED_ELEMENT__OWNED_ANNOTATIONS, AnnotatedElement.class, msgs);
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
			case OmlPackage.ANNOTATION__VALUE:
				return getValue();
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
			case OmlPackage.ANNOTATION__VALUE:
				setValue((Literal)newValue);
				return;
			case OmlPackage.ANNOTATION__REFERENCE_VALUE:
				setReferenceValue((Member)newValue);
				return;
			case OmlPackage.ANNOTATION__OWNING_ELEMENT:
				setOwningElement((AnnotatedElement)newValue);
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
			case OmlPackage.ANNOTATION__VALUE:
				setValue((Literal)null);
				return;
			case OmlPackage.ANNOTATION__REFERENCE_VALUE:
				setReferenceValue((Member)null);
				return;
			case OmlPackage.ANNOTATION__OWNING_ELEMENT:
				setOwningElement((AnnotatedElement)null);
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
			case OmlPackage.ANNOTATION__VALUE:
				return value != null;
			case OmlPackage.ANNOTATION__REFERENCE_VALUE:
				return referenceValue != null;
			case OmlPackage.ANNOTATION__OWNING_ELEMENT:
				return basicGetOwningElement() != null;
			case OmlPackage.ANNOTATION__OWNING_REFERENCE:
				return basicGetOwningReference() != null;
		}
		return super.eIsSet(featureID);
	}

} //AnnotationImpl
