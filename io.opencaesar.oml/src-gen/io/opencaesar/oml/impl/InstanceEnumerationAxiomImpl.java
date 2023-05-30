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

import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.InstanceEnumerationAxiom;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.OmlPackage;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Enumeration Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.InstanceEnumerationAxiomImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.InstanceEnumerationAxiomImpl#getOwningConcept <em>Owning Concept</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InstanceEnumerationAxiomImpl extends AxiomImpl implements InstanceEnumerationAxiom {
	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ConceptInstance> instances;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceEnumerationAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.INSTANCE_ENUMERATION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConceptInstance> getInstances() {
		if (instances == null) {
			instances = new EObjectResolvingEList<ConceptInstance>(ConceptInstance.class, this, OmlPackage.INSTANCE_ENUMERATION_AXIOM__INSTANCES);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Concept getOwningConcept() {
		if (eContainerFeatureID() != OmlPackage.INSTANCE_ENUMERATION_AXIOM__OWNING_CONCEPT) return null;
		return (Concept)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concept basicGetOwningConcept() {
		if (eContainerFeatureID() != OmlPackage.INSTANCE_ENUMERATION_AXIOM__OWNING_CONCEPT) return null;
		return (Concept)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningConcept(Concept newOwningConcept, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningConcept, OmlPackage.INSTANCE_ENUMERATION_AXIOM__OWNING_CONCEPT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningConcept(Concept newOwningConcept) {
		if (newOwningConcept != eInternalContainer() || (eContainerFeatureID() != OmlPackage.INSTANCE_ENUMERATION_AXIOM__OWNING_CONCEPT && newOwningConcept != null)) {
			if (EcoreUtil.isAncestor(this, newOwningConcept))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningConcept != null)
				msgs = ((InternalEObject)newOwningConcept).eInverseAdd(this, OmlPackage.CONCEPT__OWNED_ENUMERATION, Concept.class, msgs);
			msgs = basicSetOwningConcept(newOwningConcept, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.INSTANCE_ENUMERATION_AXIOM__OWNING_CONCEPT, newOwningConcept, newOwningConcept));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Concept getEnumeratedConcept() {
		Member _resolve = this.getOwningConcept().resolve();
		return ((Concept) _resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Concept getCharacterizedTerm() {
		return this.getEnumeratedConcept();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.INSTANCE_ENUMERATION_AXIOM__OWNING_CONCEPT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningConcept((Concept)otherEnd, msgs);
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
			case OmlPackage.INSTANCE_ENUMERATION_AXIOM__OWNING_CONCEPT:
				return basicSetOwningConcept(null, msgs);
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
			case OmlPackage.INSTANCE_ENUMERATION_AXIOM__OWNING_CONCEPT:
				return eInternalContainer().eInverseRemove(this, OmlPackage.CONCEPT__OWNED_ENUMERATION, Concept.class, msgs);
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
			case OmlPackage.INSTANCE_ENUMERATION_AXIOM__INSTANCES:
				return getInstances();
			case OmlPackage.INSTANCE_ENUMERATION_AXIOM__OWNING_CONCEPT:
				if (resolve) return getOwningConcept();
				return basicGetOwningConcept();
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
			case OmlPackage.INSTANCE_ENUMERATION_AXIOM__INSTANCES:
				getInstances().clear();
				getInstances().addAll((Collection<? extends ConceptInstance>)newValue);
				return;
			case OmlPackage.INSTANCE_ENUMERATION_AXIOM__OWNING_CONCEPT:
				setOwningConcept((Concept)newValue);
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
			case OmlPackage.INSTANCE_ENUMERATION_AXIOM__INSTANCES:
				getInstances().clear();
				return;
			case OmlPackage.INSTANCE_ENUMERATION_AXIOM__OWNING_CONCEPT:
				setOwningConcept((Concept)null);
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
			case OmlPackage.INSTANCE_ENUMERATION_AXIOM__INSTANCES:
				return instances != null && !instances.isEmpty();
			case OmlPackage.INSTANCE_ENUMERATION_AXIOM__OWNING_CONCEPT:
				return basicGetOwningConcept() != null;
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
			case OmlPackage.INSTANCE_ENUMERATION_AXIOM___GET_ENUMERATED_CONCEPT:
				return getEnumeratedConcept();
			case OmlPackage.INSTANCE_ENUMERATION_AXIOM___GET_CHARACTERIZED_TERM:
				return getCharacterizedTerm();
		}
		return super.eInvoke(operationID, arguments);
	}

} //InstanceEnumerationAxiomImpl
