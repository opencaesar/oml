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
import io.opencaesar.oml.Member;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarEquivalenceAxiom;

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
 * An implementation of the model object '<em><b>Scalar Equivalence Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.ScalarEquivalenceAxiomImpl#getSuperScalar <em>Super Scalar</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ScalarEquivalenceAxiomImpl#getOwningScalar <em>Owning Scalar</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ScalarEquivalenceAxiomImpl#getLength <em>Length</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ScalarEquivalenceAxiomImpl#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ScalarEquivalenceAxiomImpl#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ScalarEquivalenceAxiomImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ScalarEquivalenceAxiomImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ScalarEquivalenceAxiomImpl#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ScalarEquivalenceAxiomImpl#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ScalarEquivalenceAxiomImpl#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.ScalarEquivalenceAxiomImpl#getMaxExclusive <em>Max Exclusive</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScalarEquivalenceAxiomImpl extends AxiomImpl implements ScalarEquivalenceAxiom {
	/**
	 * The cached value of the '{@link #getSuperScalar() <em>Super Scalar</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperScalar()
	 * @generated
	 * @ordered
	 */
	protected Scalar superScalar;

	/**
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected static final Long LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected Long length = LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinLength() <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinLength()
	 * @generated
	 * @ordered
	 */
	protected static final Long MIN_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinLength() <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinLength()
	 * @generated
	 * @ordered
	 */
	protected Long minLength = MIN_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLength()
	 * @generated
	 * @ordered
	 */
	protected static final Long MAX_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLength()
	 * @generated
	 * @ordered
	 */
	protected Long maxLength = MAX_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected String pattern = PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected String language = LANGUAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMinInclusive() <em>Min Inclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinInclusive()
	 * @generated
	 * @ordered
	 */
	protected Literal minInclusive;

	/**
	 * The cached value of the '{@link #getMinExclusive() <em>Min Exclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinExclusive()
	 * @generated
	 * @ordered
	 */
	protected Literal minExclusive;

	/**
	 * The cached value of the '{@link #getMaxInclusive() <em>Max Inclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxInclusive()
	 * @generated
	 * @ordered
	 */
	protected Literal maxInclusive;

	/**
	 * The cached value of the '{@link #getMaxExclusive() <em>Max Exclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxExclusive()
	 * @generated
	 * @ordered
	 */
	protected Literal maxExclusive;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScalarEquivalenceAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.SCALAR_EQUIVALENCE_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Scalar getSuperScalar() {
		if (superScalar != null && superScalar.eIsProxy()) {
			InternalEObject oldSuperScalar = (InternalEObject)superScalar;
			superScalar = (Scalar)eResolveProxy(oldSuperScalar);
			if (superScalar != oldSuperScalar) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.SCALAR_EQUIVALENCE_AXIOM__SUPER_SCALAR, oldSuperScalar, superScalar));
			}
		}
		return superScalar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scalar basicGetSuperScalar() {
		return superScalar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSuperScalar(Scalar newSuperScalar) {
		Scalar oldSuperScalar = superScalar;
		superScalar = newSuperScalar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR_EQUIVALENCE_AXIOM__SUPER_SCALAR, oldSuperScalar, superScalar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Scalar getOwningScalar() {
		if (eContainerFeatureID() != OmlPackage.SCALAR_EQUIVALENCE_AXIOM__OWNING_SCALAR) return null;
		return (Scalar)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scalar basicGetOwningScalar() {
		if (eContainerFeatureID() != OmlPackage.SCALAR_EQUIVALENCE_AXIOM__OWNING_SCALAR) return null;
		return (Scalar)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningScalar(Scalar newOwningScalar, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningScalar, OmlPackage.SCALAR_EQUIVALENCE_AXIOM__OWNING_SCALAR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningScalar(Scalar newOwningScalar) {
		if (newOwningScalar != eInternalContainer() || (eContainerFeatureID() != OmlPackage.SCALAR_EQUIVALENCE_AXIOM__OWNING_SCALAR && newOwningScalar != null)) {
			if (EcoreUtil.isAncestor(this, newOwningScalar))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningScalar != null)
				msgs = ((InternalEObject)newOwningScalar).eInverseAdd(this, OmlPackage.SCALAR__OWNED_EQUIVALENCES, Scalar.class, msgs);
			msgs = basicSetOwningScalar(newOwningScalar, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR_EQUIVALENCE_AXIOM__OWNING_SCALAR, newOwningScalar, newOwningScalar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getLength() {
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLength(Long newLength) {
		Long oldLength = length;
		length = newLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR_EQUIVALENCE_AXIOM__LENGTH, oldLength, length));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getMinLength() {
		return minLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinLength(Long newMinLength) {
		Long oldMinLength = minLength;
		minLength = newMinLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_LENGTH, oldMinLength, minLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getMaxLength() {
		return maxLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaxLength(Long newMaxLength) {
		Long oldMaxLength = maxLength;
		maxLength = newMaxLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_LENGTH, oldMaxLength, maxLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPattern(String newPattern) {
		String oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR_EQUIVALENCE_AXIOM__PATTERN, oldPattern, pattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLanguage(String newLanguage) {
		String oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR_EQUIVALENCE_AXIOM__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Literal getMinInclusive() {
		return minInclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMinInclusive(Literal newMinInclusive, NotificationChain msgs) {
		Literal oldMinInclusive = minInclusive;
		minInclusive = newMinInclusive;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_INCLUSIVE, oldMinInclusive, newMinInclusive);
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
	public void setMinInclusive(Literal newMinInclusive) {
		if (newMinInclusive != minInclusive) {
			NotificationChain msgs = null;
			if (minInclusive != null)
				msgs = ((InternalEObject)minInclusive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_INCLUSIVE, null, msgs);
			if (newMinInclusive != null)
				msgs = ((InternalEObject)newMinInclusive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_INCLUSIVE, null, msgs);
			msgs = basicSetMinInclusive(newMinInclusive, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_INCLUSIVE, newMinInclusive, newMinInclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Literal getMinExclusive() {
		return minExclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMinExclusive(Literal newMinExclusive, NotificationChain msgs) {
		Literal oldMinExclusive = minExclusive;
		minExclusive = newMinExclusive;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_EXCLUSIVE, oldMinExclusive, newMinExclusive);
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
	public void setMinExclusive(Literal newMinExclusive) {
		if (newMinExclusive != minExclusive) {
			NotificationChain msgs = null;
			if (minExclusive != null)
				msgs = ((InternalEObject)minExclusive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_EXCLUSIVE, null, msgs);
			if (newMinExclusive != null)
				msgs = ((InternalEObject)newMinExclusive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_EXCLUSIVE, null, msgs);
			msgs = basicSetMinExclusive(newMinExclusive, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_EXCLUSIVE, newMinExclusive, newMinExclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Literal getMaxInclusive() {
		return maxInclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaxInclusive(Literal newMaxInclusive, NotificationChain msgs) {
		Literal oldMaxInclusive = maxInclusive;
		maxInclusive = newMaxInclusive;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_INCLUSIVE, oldMaxInclusive, newMaxInclusive);
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
	public void setMaxInclusive(Literal newMaxInclusive) {
		if (newMaxInclusive != maxInclusive) {
			NotificationChain msgs = null;
			if (maxInclusive != null)
				msgs = ((InternalEObject)maxInclusive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_INCLUSIVE, null, msgs);
			if (newMaxInclusive != null)
				msgs = ((InternalEObject)newMaxInclusive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_INCLUSIVE, null, msgs);
			msgs = basicSetMaxInclusive(newMaxInclusive, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_INCLUSIVE, newMaxInclusive, newMaxInclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Literal getMaxExclusive() {
		return maxExclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaxExclusive(Literal newMaxExclusive, NotificationChain msgs) {
		Literal oldMaxExclusive = maxExclusive;
		maxExclusive = newMaxExclusive;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_EXCLUSIVE, oldMaxExclusive, newMaxExclusive);
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
	public void setMaxExclusive(Literal newMaxExclusive) {
		if (newMaxExclusive != maxExclusive) {
			NotificationChain msgs = null;
			if (maxExclusive != null)
				msgs = ((InternalEObject)maxExclusive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_EXCLUSIVE, null, msgs);
			if (newMaxExclusive != null)
				msgs = ((InternalEObject)newMaxExclusive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_EXCLUSIVE, null, msgs);
			msgs = basicSetMaxExclusive(newMaxExclusive, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_EXCLUSIVE, newMaxExclusive, newMaxExclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Scalar getSubScalar() {
		Member _resolve = this.getOwningScalar().resolve();
		return ((Scalar) _resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Scalar getCharacterizedTerm() {
		return this.getSubScalar();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__OWNING_SCALAR:
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
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__OWNING_SCALAR:
				return basicSetOwningScalar(null, msgs);
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_INCLUSIVE:
				return basicSetMinInclusive(null, msgs);
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_EXCLUSIVE:
				return basicSetMinExclusive(null, msgs);
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_INCLUSIVE:
				return basicSetMaxInclusive(null, msgs);
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_EXCLUSIVE:
				return basicSetMaxExclusive(null, msgs);
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
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__OWNING_SCALAR:
				return eInternalContainer().eInverseRemove(this, OmlPackage.SCALAR__OWNED_EQUIVALENCES, Scalar.class, msgs);
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
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__SUPER_SCALAR:
				if (resolve) return getSuperScalar();
				return basicGetSuperScalar();
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__OWNING_SCALAR:
				if (resolve) return getOwningScalar();
				return basicGetOwningScalar();
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__LENGTH:
				return getLength();
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_LENGTH:
				return getMinLength();
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_LENGTH:
				return getMaxLength();
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__PATTERN:
				return getPattern();
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__LANGUAGE:
				return getLanguage();
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_INCLUSIVE:
				return getMinInclusive();
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_EXCLUSIVE:
				return getMinExclusive();
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_INCLUSIVE:
				return getMaxInclusive();
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_EXCLUSIVE:
				return getMaxExclusive();
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
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__SUPER_SCALAR:
				setSuperScalar((Scalar)newValue);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__OWNING_SCALAR:
				setOwningScalar((Scalar)newValue);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__LENGTH:
				setLength((Long)newValue);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_LENGTH:
				setMinLength((Long)newValue);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_LENGTH:
				setMaxLength((Long)newValue);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__PATTERN:
				setPattern((String)newValue);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__LANGUAGE:
				setLanguage((String)newValue);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_INCLUSIVE:
				setMinInclusive((Literal)newValue);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_EXCLUSIVE:
				setMinExclusive((Literal)newValue);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_INCLUSIVE:
				setMaxInclusive((Literal)newValue);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_EXCLUSIVE:
				setMaxExclusive((Literal)newValue);
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
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__SUPER_SCALAR:
				setSuperScalar((Scalar)null);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__OWNING_SCALAR:
				setOwningScalar((Scalar)null);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_LENGTH:
				setMinLength(MIN_LENGTH_EDEFAULT);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_LENGTH:
				setMaxLength(MAX_LENGTH_EDEFAULT);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__PATTERN:
				setPattern(PATTERN_EDEFAULT);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_INCLUSIVE:
				setMinInclusive((Literal)null);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_EXCLUSIVE:
				setMinExclusive((Literal)null);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_INCLUSIVE:
				setMaxInclusive((Literal)null);
				return;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_EXCLUSIVE:
				setMaxExclusive((Literal)null);
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
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__SUPER_SCALAR:
				return superScalar != null;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__OWNING_SCALAR:
				return basicGetOwningScalar() != null;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__LENGTH:
				return LENGTH_EDEFAULT == null ? length != null : !LENGTH_EDEFAULT.equals(length);
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_LENGTH:
				return MIN_LENGTH_EDEFAULT == null ? minLength != null : !MIN_LENGTH_EDEFAULT.equals(minLength);
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_LENGTH:
				return MAX_LENGTH_EDEFAULT == null ? maxLength != null : !MAX_LENGTH_EDEFAULT.equals(maxLength);
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__PATTERN:
				return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals(pattern);
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_INCLUSIVE:
				return minInclusive != null;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MIN_EXCLUSIVE:
				return minExclusive != null;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_INCLUSIVE:
				return maxInclusive != null;
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM__MAX_EXCLUSIVE:
				return maxExclusive != null;
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
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM___GET_SUB_SCALAR:
				return getSubScalar();
			case OmlPackage.SCALAR_EQUIVALENCE_AXIOM___GET_CHARACTERIZED_TERM:
				return getCharacterizedTerm();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (length: ");
		result.append(length);
		result.append(", minLength: ");
		result.append(minLength);
		result.append(", maxLength: ");
		result.append(maxLength);
		result.append(", pattern: ");
		result.append(pattern);
		result.append(", language: ");
		result.append(language);
		result.append(')');
		return result.toString();
	}

} //ScalarEquivalenceAxiomImpl
