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
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.RelationBase;
import io.opencaesar.oml.RelationEntity;
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
 * An implementation of the model object '<em><b>Relation Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.RelationEntityImpl#getSources <em>Sources</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationEntityImpl#getTargets <em>Targets</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationEntityImpl#getReverseRelation <em>Reverse Relation</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationEntityImpl#isFunctional <em>Functional</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationEntityImpl#isInverseFunctional <em>Inverse Functional</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationEntityImpl#isSymmetric <em>Symmetric</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationEntityImpl#isAsymmetric <em>Asymmetric</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationEntityImpl#isReflexive <em>Reflexive</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationEntityImpl#isIrreflexive <em>Irreflexive</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationEntityImpl#isTransitive <em>Transitive</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationEntityImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.RelationEntityImpl#getForwardRelation <em>Forward Relation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationEntityImpl extends EntityImpl implements RelationEntity {
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
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected RelationEntity ref;

	/**
	 * The cached value of the '{@link #getForwardRelation() <em>Forward Relation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForwardRelation()
	 * @generated
	 * @ordered
	 */
	protected ForwardRelation forwardRelation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.RELATION_ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Entity> getSources() {
		if (sources == null) {
			sources = new EObjectResolvingEList<Entity>(Entity.class, this, OmlPackage.RELATION_ENTITY__SOURCES);
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
			targets = new EObjectResolvingEList<Entity>(Entity.class, this, OmlPackage.RELATION_ENTITY__TARGETS);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY__REVERSE_RELATION, oldReverseRelation, newReverseRelation);
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY__REVERSE_RELATION, newReverseRelation, newReverseRelation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY__FUNCTIONAL, oldFunctional, functional));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY__INVERSE_FUNCTIONAL, oldInverseFunctional, inverseFunctional));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY__SYMMETRIC, oldSymmetric, symmetric));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY__ASYMMETRIC, oldAsymmetric, asymmetric));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY__REFLEXIVE, oldReflexive, reflexive));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY__IRREFLEXIVE, oldIrreflexive, irreflexive));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY__TRANSITIVE, oldTransitive, transitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationEntity getRef() {
		if (ref != null && ref.eIsProxy()) {
			InternalEObject oldRef = (InternalEObject)ref;
			ref = (RelationEntity)eResolveProxy(oldRef);
			if (ref != oldRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.RELATION_ENTITY__REF, oldRef, ref));
			}
		}
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationEntity basicGetRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRef(RelationEntity newRef) {
		RelationEntity oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForwardRelation getForwardRelation() {
		return forwardRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetForwardRelation(ForwardRelation newForwardRelation, NotificationChain msgs) {
		ForwardRelation oldForwardRelation = forwardRelation;
		forwardRelation = newForwardRelation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY__FORWARD_RELATION, oldForwardRelation, newForwardRelation);
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
	public void setForwardRelation(ForwardRelation newForwardRelation) {
		if (newForwardRelation != forwardRelation) {
			NotificationChain msgs = null;
			if (forwardRelation != null)
				msgs = ((InternalEObject)forwardRelation).eInverseRemove(this, OmlPackage.FORWARD_RELATION__RELATION_ENTITY, ForwardRelation.class, msgs);
			if (newForwardRelation != null)
				msgs = ((InternalEObject)newForwardRelation).eInverseAdd(this, OmlPackage.FORWARD_RELATION__RELATION_ENTITY, ForwardRelation.class, msgs);
			msgs = basicSetForwardRelation(newForwardRelation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.RELATION_ENTITY__FORWARD_RELATION, newForwardRelation, newForwardRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OmlPackage.RELATION_ENTITY__REVERSE_RELATION:
				if (reverseRelation != null)
					msgs = ((InternalEObject)reverseRelation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.RELATION_ENTITY__REVERSE_RELATION, null, msgs);
				return basicSetReverseRelation((ReverseRelation)otherEnd, msgs);
			case OmlPackage.RELATION_ENTITY__FORWARD_RELATION:
				if (forwardRelation != null)
					msgs = ((InternalEObject)forwardRelation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.RELATION_ENTITY__FORWARD_RELATION, null, msgs);
				return basicSetForwardRelation((ForwardRelation)otherEnd, msgs);
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
			case OmlPackage.RELATION_ENTITY__REVERSE_RELATION:
				return basicSetReverseRelation(null, msgs);
			case OmlPackage.RELATION_ENTITY__FORWARD_RELATION:
				return basicSetForwardRelation(null, msgs);
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
			case OmlPackage.RELATION_ENTITY__SOURCES:
				return getSources();
			case OmlPackage.RELATION_ENTITY__TARGETS:
				return getTargets();
			case OmlPackage.RELATION_ENTITY__REVERSE_RELATION:
				return getReverseRelation();
			case OmlPackage.RELATION_ENTITY__FUNCTIONAL:
				return isFunctional();
			case OmlPackage.RELATION_ENTITY__INVERSE_FUNCTIONAL:
				return isInverseFunctional();
			case OmlPackage.RELATION_ENTITY__SYMMETRIC:
				return isSymmetric();
			case OmlPackage.RELATION_ENTITY__ASYMMETRIC:
				return isAsymmetric();
			case OmlPackage.RELATION_ENTITY__REFLEXIVE:
				return isReflexive();
			case OmlPackage.RELATION_ENTITY__IRREFLEXIVE:
				return isIrreflexive();
			case OmlPackage.RELATION_ENTITY__TRANSITIVE:
				return isTransitive();
			case OmlPackage.RELATION_ENTITY__REF:
				if (resolve) return getRef();
				return basicGetRef();
			case OmlPackage.RELATION_ENTITY__FORWARD_RELATION:
				return getForwardRelation();
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
			case OmlPackage.RELATION_ENTITY__SOURCES:
				getSources().clear();
				getSources().addAll((Collection<? extends Entity>)newValue);
				return;
			case OmlPackage.RELATION_ENTITY__TARGETS:
				getTargets().clear();
				getTargets().addAll((Collection<? extends Entity>)newValue);
				return;
			case OmlPackage.RELATION_ENTITY__REVERSE_RELATION:
				setReverseRelation((ReverseRelation)newValue);
				return;
			case OmlPackage.RELATION_ENTITY__FUNCTIONAL:
				setFunctional((Boolean)newValue);
				return;
			case OmlPackage.RELATION_ENTITY__INVERSE_FUNCTIONAL:
				setInverseFunctional((Boolean)newValue);
				return;
			case OmlPackage.RELATION_ENTITY__SYMMETRIC:
				setSymmetric((Boolean)newValue);
				return;
			case OmlPackage.RELATION_ENTITY__ASYMMETRIC:
				setAsymmetric((Boolean)newValue);
				return;
			case OmlPackage.RELATION_ENTITY__REFLEXIVE:
				setReflexive((Boolean)newValue);
				return;
			case OmlPackage.RELATION_ENTITY__IRREFLEXIVE:
				setIrreflexive((Boolean)newValue);
				return;
			case OmlPackage.RELATION_ENTITY__TRANSITIVE:
				setTransitive((Boolean)newValue);
				return;
			case OmlPackage.RELATION_ENTITY__REF:
				setRef((RelationEntity)newValue);
				return;
			case OmlPackage.RELATION_ENTITY__FORWARD_RELATION:
				setForwardRelation((ForwardRelation)newValue);
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
			case OmlPackage.RELATION_ENTITY__SOURCES:
				getSources().clear();
				return;
			case OmlPackage.RELATION_ENTITY__TARGETS:
				getTargets().clear();
				return;
			case OmlPackage.RELATION_ENTITY__REVERSE_RELATION:
				setReverseRelation((ReverseRelation)null);
				return;
			case OmlPackage.RELATION_ENTITY__FUNCTIONAL:
				setFunctional(FUNCTIONAL_EDEFAULT);
				return;
			case OmlPackage.RELATION_ENTITY__INVERSE_FUNCTIONAL:
				setInverseFunctional(INVERSE_FUNCTIONAL_EDEFAULT);
				return;
			case OmlPackage.RELATION_ENTITY__SYMMETRIC:
				setSymmetric(SYMMETRIC_EDEFAULT);
				return;
			case OmlPackage.RELATION_ENTITY__ASYMMETRIC:
				setAsymmetric(ASYMMETRIC_EDEFAULT);
				return;
			case OmlPackage.RELATION_ENTITY__REFLEXIVE:
				setReflexive(REFLEXIVE_EDEFAULT);
				return;
			case OmlPackage.RELATION_ENTITY__IRREFLEXIVE:
				setIrreflexive(IRREFLEXIVE_EDEFAULT);
				return;
			case OmlPackage.RELATION_ENTITY__TRANSITIVE:
				setTransitive(TRANSITIVE_EDEFAULT);
				return;
			case OmlPackage.RELATION_ENTITY__REF:
				setRef((RelationEntity)null);
				return;
			case OmlPackage.RELATION_ENTITY__FORWARD_RELATION:
				setForwardRelation((ForwardRelation)null);
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
			case OmlPackage.RELATION_ENTITY__SOURCES:
				return sources != null && !sources.isEmpty();
			case OmlPackage.RELATION_ENTITY__TARGETS:
				return targets != null && !targets.isEmpty();
			case OmlPackage.RELATION_ENTITY__REVERSE_RELATION:
				return reverseRelation != null;
			case OmlPackage.RELATION_ENTITY__FUNCTIONAL:
				return functional != FUNCTIONAL_EDEFAULT;
			case OmlPackage.RELATION_ENTITY__INVERSE_FUNCTIONAL:
				return inverseFunctional != INVERSE_FUNCTIONAL_EDEFAULT;
			case OmlPackage.RELATION_ENTITY__SYMMETRIC:
				return symmetric != SYMMETRIC_EDEFAULT;
			case OmlPackage.RELATION_ENTITY__ASYMMETRIC:
				return asymmetric != ASYMMETRIC_EDEFAULT;
			case OmlPackage.RELATION_ENTITY__REFLEXIVE:
				return reflexive != REFLEXIVE_EDEFAULT;
			case OmlPackage.RELATION_ENTITY__IRREFLEXIVE:
				return irreflexive != IRREFLEXIVE_EDEFAULT;
			case OmlPackage.RELATION_ENTITY__TRANSITIVE:
				return transitive != TRANSITIVE_EDEFAULT;
			case OmlPackage.RELATION_ENTITY__REF:
				return ref != null;
			case OmlPackage.RELATION_ENTITY__FORWARD_RELATION:
				return forwardRelation != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == RelationBase.class) {
			switch (derivedFeatureID) {
				case OmlPackage.RELATION_ENTITY__SOURCES: return OmlPackage.RELATION_BASE__SOURCES;
				case OmlPackage.RELATION_ENTITY__TARGETS: return OmlPackage.RELATION_BASE__TARGETS;
				case OmlPackage.RELATION_ENTITY__REVERSE_RELATION: return OmlPackage.RELATION_BASE__REVERSE_RELATION;
				case OmlPackage.RELATION_ENTITY__FUNCTIONAL: return OmlPackage.RELATION_BASE__FUNCTIONAL;
				case OmlPackage.RELATION_ENTITY__INVERSE_FUNCTIONAL: return OmlPackage.RELATION_BASE__INVERSE_FUNCTIONAL;
				case OmlPackage.RELATION_ENTITY__SYMMETRIC: return OmlPackage.RELATION_BASE__SYMMETRIC;
				case OmlPackage.RELATION_ENTITY__ASYMMETRIC: return OmlPackage.RELATION_BASE__ASYMMETRIC;
				case OmlPackage.RELATION_ENTITY__REFLEXIVE: return OmlPackage.RELATION_BASE__REFLEXIVE;
				case OmlPackage.RELATION_ENTITY__IRREFLEXIVE: return OmlPackage.RELATION_BASE__IRREFLEXIVE;
				case OmlPackage.RELATION_ENTITY__TRANSITIVE: return OmlPackage.RELATION_BASE__TRANSITIVE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == RelationBase.class) {
			switch (baseFeatureID) {
				case OmlPackage.RELATION_BASE__SOURCES: return OmlPackage.RELATION_ENTITY__SOURCES;
				case OmlPackage.RELATION_BASE__TARGETS: return OmlPackage.RELATION_ENTITY__TARGETS;
				case OmlPackage.RELATION_BASE__REVERSE_RELATION: return OmlPackage.RELATION_ENTITY__REVERSE_RELATION;
				case OmlPackage.RELATION_BASE__FUNCTIONAL: return OmlPackage.RELATION_ENTITY__FUNCTIONAL;
				case OmlPackage.RELATION_BASE__INVERSE_FUNCTIONAL: return OmlPackage.RELATION_ENTITY__INVERSE_FUNCTIONAL;
				case OmlPackage.RELATION_BASE__SYMMETRIC: return OmlPackage.RELATION_ENTITY__SYMMETRIC;
				case OmlPackage.RELATION_BASE__ASYMMETRIC: return OmlPackage.RELATION_ENTITY__ASYMMETRIC;
				case OmlPackage.RELATION_BASE__REFLEXIVE: return OmlPackage.RELATION_ENTITY__REFLEXIVE;
				case OmlPackage.RELATION_BASE__IRREFLEXIVE: return OmlPackage.RELATION_ENTITY__IRREFLEXIVE;
				case OmlPackage.RELATION_BASE__TRANSITIVE: return OmlPackage.RELATION_ENTITY__TRANSITIVE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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

} //RelationEntityImpl
