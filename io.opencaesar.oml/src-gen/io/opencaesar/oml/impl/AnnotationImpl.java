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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

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
 *   <li>{@link io.opencaesar.oml.impl.AnnotationImpl#getReferencedValue <em>Referenced Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.AnnotationImpl#getOwningElement <em>Owning Element</em>}</li>
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
	 * The cached value of the '{@link #getLiteralValue() <em>Literal Value</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteralValue()
	 * @generated
	 * @ordered
	 */
	protected EList<Literal> literalValue;

	/**
	 * The cached value of the '{@link #getReferencedValue() <em>Referenced Value</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedValue()
	 * @generated
	 * @ordered
	 */
	protected EList<Member> referencedValue;

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
	public EList<Literal> getLiteralValue() {
		if (literalValue == null) {
			literalValue = new EObjectContainmentEList<Literal>(Literal.class, this, OmlPackage.ANNOTATION__LITERAL_VALUE);
		}
		return literalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Member> getReferencedValue() {
		if (referencedValue == null) {
			referencedValue = new EObjectResolvingEList<Member>(Member.class, this, OmlPackage.ANNOTATION__REFERENCED_VALUE);
		}
		return referencedValue;
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
	public EList<Element> getValue() {
		EList<Element> _xifexpression = null;
		boolean _isEmpty = this.getLiteralValue().isEmpty();
		boolean _not = (!_isEmpty);
		if (_not) {
			_xifexpression = ECollections.<Element>unmodifiableEList(this.getLiteralValue());
		}
		else {
			EList<Element> _xifexpression_1 = null;
			boolean _isEmpty_1 = this.getReferencedValue().isEmpty();
			boolean _not_1 = (!_isEmpty_1);
			if (_not_1) {
				_xifexpression_1 = ECollections.<Element>unmodifiableEList(this.getReferencedValue());
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
	public IdentifiedElement getAnnotatedElement() {
		IdentifiedElement _owningElement = this.getOwningElement();
		if ((_owningElement instanceof Member)) {
			IdentifiedElement _owningElement_1 = this.getOwningElement();
			return ((Member) _owningElement_1).resolve();
		}
		return this.getOwningElement();
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
				return ((InternalEList<?>)getLiteralValue()).basicRemove(otherEnd, msgs);
			case OmlPackage.ANNOTATION__OWNING_ELEMENT:
				return basicSetOwningElement(null, msgs);
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
			case OmlPackage.ANNOTATION__REFERENCED_VALUE:
				return getReferencedValue();
			case OmlPackage.ANNOTATION__OWNING_ELEMENT:
				if (resolve) return getOwningElement();
				return basicGetOwningElement();
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
			case OmlPackage.ANNOTATION__PROPERTY:
				setProperty((AnnotationProperty)newValue);
				return;
			case OmlPackage.ANNOTATION__LITERAL_VALUE:
				getLiteralValue().clear();
				getLiteralValue().addAll((Collection<? extends Literal>)newValue);
				return;
			case OmlPackage.ANNOTATION__REFERENCED_VALUE:
				getReferencedValue().clear();
				getReferencedValue().addAll((Collection<? extends Member>)newValue);
				return;
			case OmlPackage.ANNOTATION__OWNING_ELEMENT:
				setOwningElement((IdentifiedElement)newValue);
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
				getLiteralValue().clear();
				return;
			case OmlPackage.ANNOTATION__REFERENCED_VALUE:
				getReferencedValue().clear();
				return;
			case OmlPackage.ANNOTATION__OWNING_ELEMENT:
				setOwningElement((IdentifiedElement)null);
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
				return literalValue != null && !literalValue.isEmpty();
			case OmlPackage.ANNOTATION__REFERENCED_VALUE:
				return referencedValue != null && !referencedValue.isEmpty();
			case OmlPackage.ANNOTATION__OWNING_ELEMENT:
				return basicGetOwningElement() != null;
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
			case OmlPackage.ANNOTATION___GET_ANNOTATED_ELEMENT:
				return getAnnotatedElement();
		}
		return super.eInvoke(operationID, arguments);
	}

} //AnnotationImpl
