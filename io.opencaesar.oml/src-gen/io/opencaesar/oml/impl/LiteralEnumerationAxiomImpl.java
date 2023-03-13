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

import io.opencaesar.oml.Literal;
import io.opencaesar.oml.LiteralEnumerationAxiom;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Scalar;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Literal Enumeration Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.LiteralEnumerationAxiomImpl#getLiterals <em>Literals</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.LiteralEnumerationAxiomImpl#getOwningScalar <em>Owning Scalar</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LiteralEnumerationAxiomImpl extends AxiomImpl implements LiteralEnumerationAxiom {
	/**
	 * The cached value of the '{@link #getLiterals() <em>Literals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiterals()
	 * @generated
	 * @ordered
	 */
	protected EList<Literal> literals;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LiteralEnumerationAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.LITERAL_ENUMERATION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Literal> getLiterals() {
		if (literals == null) {
			literals = new EObjectContainmentEList<Literal>(Literal.class, this, OmlPackage.LITERAL_ENUMERATION_AXIOM__LITERALS);
		}
		return literals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Scalar getOwningScalar() {
		if (eContainerFeatureID() != OmlPackage.LITERAL_ENUMERATION_AXIOM__OWNING_SCALAR) return null;
		return (Scalar)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scalar basicGetOwningScalar() {
		if (eContainerFeatureID() != OmlPackage.LITERAL_ENUMERATION_AXIOM__OWNING_SCALAR) return null;
		return (Scalar)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningScalar(Scalar newOwningScalar, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningScalar, OmlPackage.LITERAL_ENUMERATION_AXIOM__OWNING_SCALAR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningScalar(Scalar newOwningScalar) {
		if (newOwningScalar != eInternalContainer() || (eContainerFeatureID() != OmlPackage.LITERAL_ENUMERATION_AXIOM__OWNING_SCALAR && newOwningScalar != null)) {
			if (EcoreUtil.isAncestor(this, newOwningScalar))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningScalar != null)
				msgs = ((InternalEObject)newOwningScalar).eInverseAdd(this, OmlPackage.SCALAR__OWNED_ENUMERATION, Scalar.class, msgs);
			msgs = basicSetOwningScalar(newOwningScalar, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.LITERAL_ENUMERATION_AXIOM__OWNING_SCALAR, newOwningScalar, newOwningScalar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Scalar getEnumeratedScalar() {
		Member _resolve = this.getOwningScalar().resolve();
		return ((Scalar) _resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.LITERAL_ENUMERATION_AXIOM__OWNING_SCALAR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningScalar((Scalar)otherEnd, msgs);
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
			case OmlPackage.LITERAL_ENUMERATION_AXIOM__LITERALS:
				return ((InternalEList<?>)getLiterals()).basicRemove(otherEnd, msgs);
			case OmlPackage.LITERAL_ENUMERATION_AXIOM__OWNING_SCALAR:
				return basicSetOwningScalar(null, msgs);
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
			case OmlPackage.LITERAL_ENUMERATION_AXIOM__OWNING_SCALAR:
				return eInternalContainer().eInverseRemove(this, OmlPackage.SCALAR__OWNED_ENUMERATION, Scalar.class, msgs);
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
			case OmlPackage.LITERAL_ENUMERATION_AXIOM__LITERALS:
				return getLiterals();
			case OmlPackage.LITERAL_ENUMERATION_AXIOM__OWNING_SCALAR:
				if (resolve) return getOwningScalar();
				return basicGetOwningScalar();
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
			case OmlPackage.LITERAL_ENUMERATION_AXIOM__LITERALS:
				getLiterals().clear();
				getLiterals().addAll((Collection<? extends Literal>)newValue);
				return;
			case OmlPackage.LITERAL_ENUMERATION_AXIOM__OWNING_SCALAR:
				setOwningScalar((Scalar)newValue);
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
			case OmlPackage.LITERAL_ENUMERATION_AXIOM__LITERALS:
				getLiterals().clear();
				return;
			case OmlPackage.LITERAL_ENUMERATION_AXIOM__OWNING_SCALAR:
				setOwningScalar((Scalar)null);
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
			case OmlPackage.LITERAL_ENUMERATION_AXIOM__LITERALS:
				return literals != null && !literals.isEmpty();
			case OmlPackage.LITERAL_ENUMERATION_AXIOM__OWNING_SCALAR:
				return basicGetOwningScalar() != null;
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
			case OmlPackage.LITERAL_ENUMERATION_AXIOM___GET_ENUMERATED_SCALAR:
				return getEnumeratedScalar();
		}
		return super.eInvoke(operationID, arguments);
	}

} //LiteralEnumerationAxiomImpl
