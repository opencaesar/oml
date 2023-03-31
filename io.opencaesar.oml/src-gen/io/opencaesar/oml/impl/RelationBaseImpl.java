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
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.RelationBase;
import io.opencaesar.oml.ReverseRelation;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Base</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.RelationBaseImpl#getSources <em>Sources</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationBaseImpl#getTargets <em>Targets</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationBaseImpl#getReverseRelation <em>Reverse Relation</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationBaseImpl#isFunctional <em>Functional</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationBaseImpl#isInverseFunctional <em>Inverse Functional</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationBaseImpl#isSymmetric <em>Symmetric</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationBaseImpl#isAsymmetric <em>Asymmetric</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationBaseImpl#isReflexive <em>Reflexive</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationBaseImpl#isIrreflexive <em>Irreflexive</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationBaseImpl#isTransitive <em>Transitive</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RelationBaseImpl extends SpecializableTermImpl implements RelationBase {
	/**
	 * The cached value of the '{@link #getSources() <em>Sources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSources()
	 * @generated
	 * @ordered
	 */
	protected EList<Entity> sources;

	/**
	 * The cached value of the '{@link #getTargets() <em>Targets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargets()
	 * @generated
	 * @ordered
	 */
	protected EList<Entity> targets;

	/**
	 * The cached value of the '{@link #getReverseRelation() <em>Reverse Relation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReverseRelation()
	 * @generated
	 * @ordered
	 */
	protected ReverseRelation reverseRelation;

	/**
	 * The default value of the '{@link #isFunctional() <em>Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFunctional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FUNCTIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFunctional() <em>Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFunctional()
	 * @generated
	 * @ordered
	 */
	protected boolean functional = FUNCTIONAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isInverseFunctional() <em>Inverse Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInverseFunctional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INVERSE_FUNCTIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInverseFunctional() <em>Inverse Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInverseFunctional()
	 * @generated
	 * @ordered
	 */
	protected boolean inverseFunctional = INVERSE_FUNCTIONAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isSymmetric() <em>Symmetric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSymmetric()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SYMMETRIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSymmetric() <em>Symmetric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSymmetric()
	 * @generated
	 * @ordered
	 */
	protected boolean symmetric = SYMMETRIC_EDEFAULT;

	/**
	 * The default value of the '{@link #isAsymmetric() <em>Asymmetric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAsymmetric()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ASYMMETRIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAsymmetric() <em>Asymmetric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAsymmetric()
	 * @generated
	 * @ordered
	 */
	protected boolean asymmetric = ASYMMETRIC_EDEFAULT;

	/**
	 * The default value of the '{@link #isReflexive() <em>Reflexive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReflexive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REFLEXIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReflexive() <em>Reflexive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReflexive()
	 * @generated
	 * @ordered
	 */
	protected boolean reflexive = REFLEXIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIrreflexive() <em>Irreflexive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIrreflexive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IRREFLEXIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIrreflexive() <em>Irreflexive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIrreflexive()
	 * @generated
	 * @ordered
	 */
	protected boolean irreflexive = IRREFLEXIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isTransitive() <em>Transitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransitive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSITIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTransitive() <em>Transitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransitive()
	 * @generated
	 * @ordered
	 */
	protected boolean transitive = TRANSITIVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationBaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.RELATION_BASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Entity> getSources() {
		if (sources == null) {
			sources = new EObjectResolvingEList<Entity>(Entity.class, this, OmlPackage.RELATION_BASE__SOURCES);
		}
		return sources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Entity> getTargets() {
		if (targets == null) {
			targets = new EObjectResolvingEList<Entity>(Entity.class, this, OmlPackage.RELATION_BASE__TARGETS);
		}
		return targets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReverseRelation getReverseRelation() {
		return reverseRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReverseRelation(ReverseRelation newReverseRelation, NotificationChain msgs) {
		ReverseRelation oldReverseRelation = reverseRelation;
		reverseRelation = newReverseRelation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_BASE__REVERSE_RELATION, oldReverseRelation, newReverseRelation);
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
	public void setReverseRelation(ReverseRelation newReverseRelation) {
		if (newReverseRelation != reverseRelation) {
			NotificationChain msgs = null;
			if (reverseRelation != null)
				msgs = ((InternalEObject)reverseRelation).eInverseRemove(this, OmlPackage.REVERSE_RELATION__RELATION_BASE, ReverseRelation.class, msgs);
			if (newReverseRelation != null)
				msgs = ((InternalEObject)newReverseRelation).eInverseAdd(this, OmlPackage.REVERSE_RELATION__RELATION_BASE, ReverseRelation.class, msgs);
			msgs = basicSetReverseRelation(newReverseRelation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_BASE__REVERSE_RELATION, newReverseRelation, newReverseRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFunctional() {
		return functional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFunctional(boolean newFunctional) {
		boolean oldFunctional = functional;
		functional = newFunctional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_BASE__FUNCTIONAL, oldFunctional, functional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isInverseFunctional() {
		return inverseFunctional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInverseFunctional(boolean newInverseFunctional) {
		boolean oldInverseFunctional = inverseFunctional;
		inverseFunctional = newInverseFunctional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_BASE__INVERSE_FUNCTIONAL, oldInverseFunctional, inverseFunctional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSymmetric() {
		return symmetric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSymmetric(boolean newSymmetric) {
		boolean oldSymmetric = symmetric;
		symmetric = newSymmetric;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_BASE__SYMMETRIC, oldSymmetric, symmetric));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAsymmetric() {
		return asymmetric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAsymmetric(boolean newAsymmetric) {
		boolean oldAsymmetric = asymmetric;
		asymmetric = newAsymmetric;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_BASE__ASYMMETRIC, oldAsymmetric, asymmetric));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isReflexive() {
		return reflexive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReflexive(boolean newReflexive) {
		boolean oldReflexive = reflexive;
		reflexive = newReflexive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_BASE__REFLEXIVE, oldReflexive, reflexive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIrreflexive() {
		return irreflexive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIrreflexive(boolean newIrreflexive) {
		boolean oldIrreflexive = irreflexive;
		irreflexive = newIrreflexive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_BASE__IRREFLEXIVE, oldIrreflexive, irreflexive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isTransitive() {
		return transitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransitive(boolean newTransitive) {
		boolean oldTransitive = transitive;
		transitive = newTransitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_BASE__TRANSITIVE, oldTransitive, transitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.RELATION_BASE__REVERSE_RELATION:
				if (reverseRelation != null)
					msgs = ((InternalEObject)reverseRelation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.RELATION_BASE__REVERSE_RELATION, null, msgs);
				return basicSetReverseRelation((ReverseRelation)otherEnd, msgs);
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
			case OmlPackage.RELATION_BASE__REVERSE_RELATION:
				return basicSetReverseRelation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OmlPackage.RELATION_BASE__SOURCES:
				return getSources();
			case OmlPackage.RELATION_BASE__TARGETS:
				return getTargets();
			case OmlPackage.RELATION_BASE__REVERSE_RELATION:
				return getReverseRelation();
			case OmlPackage.RELATION_BASE__FUNCTIONAL:
				return isFunctional();
			case OmlPackage.RELATION_BASE__INVERSE_FUNCTIONAL:
				return isInverseFunctional();
			case OmlPackage.RELATION_BASE__SYMMETRIC:
				return isSymmetric();
			case OmlPackage.RELATION_BASE__ASYMMETRIC:
				return isAsymmetric();
			case OmlPackage.RELATION_BASE__REFLEXIVE:
				return isReflexive();
			case OmlPackage.RELATION_BASE__IRREFLEXIVE:
				return isIrreflexive();
			case OmlPackage.RELATION_BASE__TRANSITIVE:
				return isTransitive();
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
			case OmlPackage.RELATION_BASE__SOURCES:
				getSources().clear();
				getSources().addAll((Collection<? extends Entity>)newValue);
				return;
			case OmlPackage.RELATION_BASE__TARGETS:
				getTargets().clear();
				getTargets().addAll((Collection<? extends Entity>)newValue);
				return;
			case OmlPackage.RELATION_BASE__REVERSE_RELATION:
				setReverseRelation((ReverseRelation)newValue);
				return;
			case OmlPackage.RELATION_BASE__FUNCTIONAL:
				setFunctional((Boolean)newValue);
				return;
			case OmlPackage.RELATION_BASE__INVERSE_FUNCTIONAL:
				setInverseFunctional((Boolean)newValue);
				return;
			case OmlPackage.RELATION_BASE__SYMMETRIC:
				setSymmetric((Boolean)newValue);
				return;
			case OmlPackage.RELATION_BASE__ASYMMETRIC:
				setAsymmetric((Boolean)newValue);
				return;
			case OmlPackage.RELATION_BASE__REFLEXIVE:
				setReflexive((Boolean)newValue);
				return;
			case OmlPackage.RELATION_BASE__IRREFLEXIVE:
				setIrreflexive((Boolean)newValue);
				return;
			case OmlPackage.RELATION_BASE__TRANSITIVE:
				setTransitive((Boolean)newValue);
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
			case OmlPackage.RELATION_BASE__SOURCES:
				getSources().clear();
				return;
			case OmlPackage.RELATION_BASE__TARGETS:
				getTargets().clear();
				return;
			case OmlPackage.RELATION_BASE__REVERSE_RELATION:
				setReverseRelation((ReverseRelation)null);
				return;
			case OmlPackage.RELATION_BASE__FUNCTIONAL:
				setFunctional(FUNCTIONAL_EDEFAULT);
				return;
			case OmlPackage.RELATION_BASE__INVERSE_FUNCTIONAL:
				setInverseFunctional(INVERSE_FUNCTIONAL_EDEFAULT);
				return;
			case OmlPackage.RELATION_BASE__SYMMETRIC:
				setSymmetric(SYMMETRIC_EDEFAULT);
				return;
			case OmlPackage.RELATION_BASE__ASYMMETRIC:
				setAsymmetric(ASYMMETRIC_EDEFAULT);
				return;
			case OmlPackage.RELATION_BASE__REFLEXIVE:
				setReflexive(REFLEXIVE_EDEFAULT);
				return;
			case OmlPackage.RELATION_BASE__IRREFLEXIVE:
				setIrreflexive(IRREFLEXIVE_EDEFAULT);
				return;
			case OmlPackage.RELATION_BASE__TRANSITIVE:
				setTransitive(TRANSITIVE_EDEFAULT);
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
			case OmlPackage.RELATION_BASE__SOURCES:
				return sources != null && !sources.isEmpty();
			case OmlPackage.RELATION_BASE__TARGETS:
				return targets != null && !targets.isEmpty();
			case OmlPackage.RELATION_BASE__REVERSE_RELATION:
				return reverseRelation != null;
			case OmlPackage.RELATION_BASE__FUNCTIONAL:
				return functional != FUNCTIONAL_EDEFAULT;
			case OmlPackage.RELATION_BASE__INVERSE_FUNCTIONAL:
				return inverseFunctional != INVERSE_FUNCTIONAL_EDEFAULT;
			case OmlPackage.RELATION_BASE__SYMMETRIC:
				return symmetric != SYMMETRIC_EDEFAULT;
			case OmlPackage.RELATION_BASE__ASYMMETRIC:
				return asymmetric != ASYMMETRIC_EDEFAULT;
			case OmlPackage.RELATION_BASE__REFLEXIVE:
				return reflexive != REFLEXIVE_EDEFAULT;
			case OmlPackage.RELATION_BASE__IRREFLEXIVE:
				return irreflexive != IRREFLEXIVE_EDEFAULT;
			case OmlPackage.RELATION_BASE__TRANSITIVE:
				return transitive != TRANSITIVE_EDEFAULT;
		}
		return super.eIsSet(featureID);
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
		result.append(" (functional: ");
		result.append(functional);
		result.append(", inverseFunctional: ");
		result.append(inverseFunctional);
		result.append(", symmetric: ");
		result.append(symmetric);
		result.append(", asymmetric: ");
		result.append(asymmetric);
		result.append(", reflexive: ");
		result.append(reflexive);
		result.append(", irreflexive: ");
		result.append(irreflexive);
		result.append(", transitive: ");
		result.append(transitive);
		result.append(')');
		return result.toString();
	}

} //RelationBaseImpl
