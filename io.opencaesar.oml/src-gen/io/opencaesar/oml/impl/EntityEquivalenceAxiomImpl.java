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

import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EntityEquivalenceAxiom;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.PropertyRestrictionAxiom;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Equivalence Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.EntityEquivalenceAxiomImpl#getSuperEntities <em>Super Entities</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.EntityEquivalenceAxiomImpl#getOwnedPropertyRestrictions <em>Owned Property Restrictions</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.EntityEquivalenceAxiomImpl#getOwningEntity <em>Owning Entity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntityEquivalenceAxiomImpl extends AxiomImpl implements EntityEquivalenceAxiom {
	/**
	 * The cached value of the '{@link #getSuperEntities() <em>Super Entities</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperEntities()
	 * @generated
	 * @ordered
	 */
	protected EList<Entity> superEntities;

	/**
	 * The cached value of the '{@link #getOwnedPropertyRestrictions() <em>Owned Property Restrictions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPropertyRestrictions()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyRestrictionAxiom> ownedPropertyRestrictions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityEquivalenceAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.ENTITY_EQUIVALENCE_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Entity> getSuperEntities() {
		if (superEntities == null) {
			superEntities = new EObjectResolvingEList<Entity>(Entity.class, this, OmlPackage.ENTITY_EQUIVALENCE_AXIOM__SUPER_ENTITIES);
		}
		return superEntities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PropertyRestrictionAxiom> getOwnedPropertyRestrictions() {
		if (ownedPropertyRestrictions == null) {
			ownedPropertyRestrictions = new EObjectContainmentWithInverseEList<PropertyRestrictionAxiom>(PropertyRestrictionAxiom.class, this, OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.PROPERTY_RESTRICTION_AXIOM__OWNING_AXIOM);
		}
		return ownedPropertyRestrictions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity getOwningEntity() {
		if (eContainerFeatureID() != OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNING_ENTITY) return null;
		return (Entity)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetOwningEntity() {
		if (eContainerFeatureID() != OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNING_ENTITY) return null;
		return (Entity)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningEntity(Entity newOwningEntity, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningEntity, OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNING_ENTITY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningEntity(Entity newOwningEntity) {
		if (newOwningEntity != eInternalContainer() || (eContainerFeatureID() != OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNING_ENTITY && newOwningEntity != null)) {
			if (EcoreUtil.isAncestor(this, newOwningEntity))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningEntity != null)
				msgs = ((InternalEObject)newOwningEntity).eInverseAdd(this, OmlPackage.ENTITY__OWNED_EQUIVALENCES, Entity.class, msgs);
			msgs = basicSetOwningEntity(newOwningEntity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNING_ENTITY, newOwningEntity, newOwningEntity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity getSubEntity() {
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
		return this.getSubEntity();
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
			case OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedPropertyRestrictions()).basicAdd(otherEnd, msgs);
			case OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNING_ENTITY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningEntity((Entity)otherEnd, msgs);
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
			case OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS:
				return ((InternalEList<?>)getOwnedPropertyRestrictions()).basicRemove(otherEnd, msgs);
			case OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNING_ENTITY:
				return basicSetOwningEntity(null, msgs);
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
			case OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNING_ENTITY:
				return eInternalContainer().eInverseRemove(this, OmlPackage.ENTITY__OWNED_EQUIVALENCES, Entity.class, msgs);
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
			case OmlPackage.ENTITY_EQUIVALENCE_AXIOM__SUPER_ENTITIES:
				return getSuperEntities();
			case OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS:
				return getOwnedPropertyRestrictions();
			case OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNING_ENTITY:
				if (resolve) return getOwningEntity();
				return basicGetOwningEntity();
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
			case OmlPackage.ENTITY_EQUIVALENCE_AXIOM__SUPER_ENTITIES:
				getSuperEntities().clear();
				getSuperEntities().addAll((Collection<? extends Entity>)newValue);
				return;
			case OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS:
				getOwnedPropertyRestrictions().clear();
				getOwnedPropertyRestrictions().addAll((Collection<? extends PropertyRestrictionAxiom>)newValue);
				return;
			case OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNING_ENTITY:
				setOwningEntity((Entity)newValue);
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
			case OmlPackage.ENTITY_EQUIVALENCE_AXIOM__SUPER_ENTITIES:
				getSuperEntities().clear();
				return;
			case OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS:
				getOwnedPropertyRestrictions().clear();
				return;
			case OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNING_ENTITY:
				setOwningEntity((Entity)null);
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
			case OmlPackage.ENTITY_EQUIVALENCE_AXIOM__SUPER_ENTITIES:
				return superEntities != null && !superEntities.isEmpty();
			case OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS:
				return ownedPropertyRestrictions != null && !ownedPropertyRestrictions.isEmpty();
			case OmlPackage.ENTITY_EQUIVALENCE_AXIOM__OWNING_ENTITY:
				return basicGetOwningEntity() != null;
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
			case OmlPackage.ENTITY_EQUIVALENCE_AXIOM___GET_SUB_ENTITY:
				return getSubEntity();
			case OmlPackage.ENTITY_EQUIVALENCE_AXIOM___GET_CHARACTERIZED_TERM:
				return getCharacterizedTerm();
		}
		return super.eInvoke(operationID, arguments);
	}

} //EntityEquivalenceAxiomImpl
