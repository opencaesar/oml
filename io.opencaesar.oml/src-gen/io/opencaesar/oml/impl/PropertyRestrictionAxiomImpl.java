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

import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EntityEquivalenceAxiom;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.PropertyRestrictionAxiom;
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
 * An implementation of the model object '<em><b>Property Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.PropertyRestrictionAxiomImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PropertyRestrictionAxiomImpl#getOwningEntity <em>Owning Entity</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.PropertyRestrictionAxiomImpl#getOwningAxiom <em>Owning Axiom</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PropertyRestrictionAxiomImpl extends AxiomImpl implements PropertyRestrictionAxiom {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyRestrictionAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.PROPERTY_RESTRICTION_AXIOM__PROPERTY, oldProperty, property));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_RESTRICTION_AXIOM__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity getOwningEntity() {
		if (eContainerFeatureID() != OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_ENTITY) return null;
		return (Entity)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetOwningEntity() {
		if (eContainerFeatureID() != OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_ENTITY) return null;
		return (Entity)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningEntity(Entity newOwningEntity, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningEntity, OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_ENTITY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningEntity(Entity newOwningEntity) {
		if (newOwningEntity != eInternalContainer() || (eContainerFeatureID() != OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_ENTITY && newOwningEntity != null)) {
			if (EcoreUtil.isAncestor(this, newOwningEntity))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningEntity != null)
				msgs = ((InternalEObject)newOwningEntity).eInverseAdd(this, OmlPackage.ENTITY__OWNED_PROPERTY_RESTRICTIONS, Entity.class, msgs);
			msgs = basicSetOwningEntity(newOwningEntity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_ENTITY, newOwningEntity, newOwningEntity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EntityEquivalenceAxiom getOwningAxiom() {
		if (eContainerFeatureID() != OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM) return null;
		return (EntityEquivalenceAxiom)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityEquivalenceAxiom basicGetOwningAxiom() {
		if (eContainerFeatureID() != OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM) return null;
		return (EntityEquivalenceAxiom)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningAxiom(EntityEquivalenceAxiom newOwningAxiom, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningAxiom, OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningAxiom(EntityEquivalenceAxiom newOwningAxiom) {
		if (newOwningAxiom != eInternalContainer() || (eContainerFeatureID() != OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM && newOwningAxiom != null)) {
			if (EcoreUtil.isAncestor(this, newOwningAxiom))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningAxiom != null)
				msgs = ((InternalEObject)newOwningAxiom).eInverseAdd(this, OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS, EntityEquivalenceAxiom.class, msgs);
			msgs = basicSetOwningAxiom(newOwningAxiom, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM, newOwningAxiom, newOwningAxiom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity getRestrictingDomain() {
		EntityEquivalenceAxiom _owningAxiom = this.getOwningAxiom();
		boolean _tripleNotEquals = (_owningAxiom != null);
		if (_tripleNotEquals) {
			return this.getOwningAxiom().getSubEntity();
		}
		Member _resolve = this.getOwningEntity().resolve();
		return ((Entity) _resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity getCharacterizedTerm() {
		return this.getRestrictingDomain();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_ENTITY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningEntity((Entity)otherEnd, msgs);
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningAxiom((EntityEquivalenceAxiom)otherEnd, msgs);
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
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_ENTITY:
				return basicSetOwningEntity(null, msgs);
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM:
				return basicSetOwningAxiom(null, msgs);
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
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_ENTITY:
				return eInternalContainer().eInverseRemove(this, OmlPackage.ENTITY__OWNED_PROPERTY_RESTRICTIONS, Entity.class, msgs);
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM:
				return eInternalContainer().eInverseRemove(this, OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS, EntityEquivalenceAxiom.class, msgs);
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
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__PROPERTY:
				if (resolve) return getProperty();
				return basicGetProperty();
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_ENTITY:
				if (resolve) return getOwningEntity();
				return basicGetOwningEntity();
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM:
				if (resolve) return getOwningAxiom();
				return basicGetOwningAxiom();
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
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__PROPERTY:
				setProperty((SemanticProperty)newValue);
				return;
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_ENTITY:
				setOwningEntity((Entity)newValue);
				return;
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM:
				setOwningAxiom((EntityEquivalenceAxiom)newValue);
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
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__PROPERTY:
				setProperty((SemanticProperty)null);
				return;
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_ENTITY:
				setOwningEntity((Entity)null);
				return;
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM:
				setOwningAxiom((EntityEquivalenceAxiom)null);
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
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__PROPERTY:
				return property != null;
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_ENTITY:
				return basicGetOwningEntity() != null;
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM:
				return basicGetOwningAxiom() != null;
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
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM___GET_RESTRICTING_DOMAIN:
				return getRestrictingDomain();
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM___GET_CHARACTERIZED_TERM:
				return getCharacterizedTerm();
		}
		return super.eInvoke(operationID, arguments);
	}

} //PropertyRestrictionAxiomImpl
