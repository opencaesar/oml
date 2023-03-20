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
import io.opencaesar.oml.PropertyEquivalenceAxiom;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationBase;
import io.opencaesar.oml.ReverseRelation;
import io.opencaesar.oml.SemanticProperty;
import io.opencaesar.oml.SpecializableProperty;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Statement;
import io.opencaesar.oml.UnreifiedRelation;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyStatement;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unreified Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.UnreifiedRelationImpl#getOwningVocabulary <em>Owning Vocabulary</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.UnreifiedRelationImpl#getOwnedSpecializations <em>Owned Specializations</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.UnreifiedRelationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.UnreifiedRelationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.UnreifiedRelationImpl#getReverseRelation <em>Reverse Relation</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.UnreifiedRelationImpl#isFunctional <em>Functional</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.UnreifiedRelationImpl#isInverseFunctional <em>Inverse Functional</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.UnreifiedRelationImpl#isSymmetric <em>Symmetric</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.UnreifiedRelationImpl#isAsymmetric <em>Asymmetric</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.UnreifiedRelationImpl#isReflexive <em>Reflexive</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.UnreifiedRelationImpl#isIrreflexive <em>Irreflexive</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.UnreifiedRelationImpl#isTransitive <em>Transitive</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.UnreifiedRelationImpl#getOwnedEquivalences <em>Owned Equivalences</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.UnreifiedRelationImpl#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnreifiedRelationImpl extends RelationImpl implements UnreifiedRelation {
	/**
	 * The cached value of the '{@link #getOwnedSpecializations() <em>Owned Specializations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSpecializations()
	 * @generated
	 * @ordered
	 */
	protected EList<SpecializationAxiom> ownedSpecializations;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Entity source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Entity target;

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
	 * The cached value of the '{@link #getOwnedEquivalences() <em>Owned Equivalences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEquivalences()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyEquivalenceAxiom> ownedEquivalences;

	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected Relation ref;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnreifiedRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.UNREIFIED_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vocabulary getOwningVocabulary() {
		if (eContainerFeatureID() != OmlPackage.UNREIFIED_RELATION__OWNING_VOCABULARY) return null;
		return (Vocabulary)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vocabulary basicGetOwningVocabulary() {
		if (eContainerFeatureID() != OmlPackage.UNREIFIED_RELATION__OWNING_VOCABULARY) return null;
		return (Vocabulary)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningVocabulary(Vocabulary newOwningVocabulary, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningVocabulary, OmlPackage.UNREIFIED_RELATION__OWNING_VOCABULARY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningVocabulary(Vocabulary newOwningVocabulary) {
		if (newOwningVocabulary != eInternalContainer() || (eContainerFeatureID() != OmlPackage.UNREIFIED_RELATION__OWNING_VOCABULARY && newOwningVocabulary != null)) {
			if (EcoreUtil.isAncestor(this, newOwningVocabulary))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningVocabulary != null)
				msgs = ((InternalEObject)newOwningVocabulary).eInverseAdd(this, OmlPackage.VOCABULARY__OWNED_STATEMENTS, Vocabulary.class, msgs);
			msgs = basicSetOwningVocabulary(newOwningVocabulary, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.UNREIFIED_RELATION__OWNING_VOCABULARY, newOwningVocabulary, newOwningVocabulary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SpecializationAxiom> getOwnedSpecializations() {
		if (ownedSpecializations == null) {
			ownedSpecializations = new EObjectContainmentWithInverseEList<SpecializationAxiom>(SpecializationAxiom.class, this, OmlPackage.UNREIFIED_RELATION__OWNED_SPECIALIZATIONS, OmlPackage.SPECIALIZATION_AXIOM__OWNING_TERM);
		}
		return ownedSpecializations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Entity)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.UNREIFIED_RELATION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(Entity newSource) {
		Entity oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.UNREIFIED_RELATION__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Entity)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.UNREIFIED_RELATION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTarget(Entity newTarget) {
		Entity oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.UNREIFIED_RELATION__TARGET, oldTarget, target));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OmlPackage.UNREIFIED_RELATION__REVERSE_RELATION, oldReverseRelation, newReverseRelation);
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.UNREIFIED_RELATION__REVERSE_RELATION, newReverseRelation, newReverseRelation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.UNREIFIED_RELATION__FUNCTIONAL, oldFunctional, functional));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.UNREIFIED_RELATION__INVERSE_FUNCTIONAL, oldInverseFunctional, inverseFunctional));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.UNREIFIED_RELATION__SYMMETRIC, oldSymmetric, symmetric));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.UNREIFIED_RELATION__ASYMMETRIC, oldAsymmetric, asymmetric));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.UNREIFIED_RELATION__REFLEXIVE, oldReflexive, reflexive));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.UNREIFIED_RELATION__IRREFLEXIVE, oldIrreflexive, irreflexive));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.UNREIFIED_RELATION__TRANSITIVE, oldTransitive, transitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PropertyEquivalenceAxiom> getOwnedEquivalences() {
		if (ownedEquivalences == null) {
			ownedEquivalences = new EObjectContainmentWithInverseEList<PropertyEquivalenceAxiom>(PropertyEquivalenceAxiom.class, this, OmlPackage.UNREIFIED_RELATION__OWNED_EQUIVALENCES, OmlPackage.PROPERTY_EQUIVALENCE_AXIOM__OWNING_PROPERTY);
		}
		return ownedEquivalences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getRef() {
		if (ref != null && ref.eIsProxy()) {
			InternalEObject oldRef = (InternalEObject)ref;
			ref = (Relation)eResolveProxy(oldRef);
			if (ref != oldRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.UNREIFIED_RELATION__REF, oldRef, ref));
			}
		}
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRef(Relation newRef) {
		Relation oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.UNREIFIED_RELATION__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity getDomain() {
		return this.getSource();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity getRange() {
		return this.getTarget();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getInverse() {
		return this.getReverseRelation();
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
			case OmlPackage.UNREIFIED_RELATION__OWNING_VOCABULARY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningVocabulary((Vocabulary)otherEnd, msgs);
			case OmlPackage.UNREIFIED_RELATION__OWNED_SPECIALIZATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedSpecializations()).basicAdd(otherEnd, msgs);
			case OmlPackage.UNREIFIED_RELATION__REVERSE_RELATION:
				if (reverseRelation != null)
					msgs = ((InternalEObject)reverseRelation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OmlPackage.UNREIFIED_RELATION__REVERSE_RELATION, null, msgs);
				return basicSetReverseRelation((ReverseRelation)otherEnd, msgs);
			case OmlPackage.UNREIFIED_RELATION__OWNED_EQUIVALENCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedEquivalences()).basicAdd(otherEnd, msgs);
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
			case OmlPackage.UNREIFIED_RELATION__OWNING_VOCABULARY:
				return basicSetOwningVocabulary(null, msgs);
			case OmlPackage.UNREIFIED_RELATION__OWNED_SPECIALIZATIONS:
				return ((InternalEList<?>)getOwnedSpecializations()).basicRemove(otherEnd, msgs);
			case OmlPackage.UNREIFIED_RELATION__REVERSE_RELATION:
				return basicSetReverseRelation(null, msgs);
			case OmlPackage.UNREIFIED_RELATION__OWNED_EQUIVALENCES:
				return ((InternalEList<?>)getOwnedEquivalences()).basicRemove(otherEnd, msgs);
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
			case OmlPackage.UNREIFIED_RELATION__OWNING_VOCABULARY:
				return eInternalContainer().eInverseRemove(this, OmlPackage.VOCABULARY__OWNED_STATEMENTS, Vocabulary.class, msgs);
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
			case OmlPackage.UNREIFIED_RELATION__OWNING_VOCABULARY:
				if (resolve) return getOwningVocabulary();
				return basicGetOwningVocabulary();
			case OmlPackage.UNREIFIED_RELATION__OWNED_SPECIALIZATIONS:
				return getOwnedSpecializations();
			case OmlPackage.UNREIFIED_RELATION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case OmlPackage.UNREIFIED_RELATION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case OmlPackage.UNREIFIED_RELATION__REVERSE_RELATION:
				return getReverseRelation();
			case OmlPackage.UNREIFIED_RELATION__FUNCTIONAL:
				return isFunctional();
			case OmlPackage.UNREIFIED_RELATION__INVERSE_FUNCTIONAL:
				return isInverseFunctional();
			case OmlPackage.UNREIFIED_RELATION__SYMMETRIC:
				return isSymmetric();
			case OmlPackage.UNREIFIED_RELATION__ASYMMETRIC:
				return isAsymmetric();
			case OmlPackage.UNREIFIED_RELATION__REFLEXIVE:
				return isReflexive();
			case OmlPackage.UNREIFIED_RELATION__IRREFLEXIVE:
				return isIrreflexive();
			case OmlPackage.UNREIFIED_RELATION__TRANSITIVE:
				return isTransitive();
			case OmlPackage.UNREIFIED_RELATION__OWNED_EQUIVALENCES:
				return getOwnedEquivalences();
			case OmlPackage.UNREIFIED_RELATION__REF:
				if (resolve) return getRef();
				return basicGetRef();
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
			case OmlPackage.UNREIFIED_RELATION__OWNING_VOCABULARY:
				setOwningVocabulary((Vocabulary)newValue);
				return;
			case OmlPackage.UNREIFIED_RELATION__OWNED_SPECIALIZATIONS:
				getOwnedSpecializations().clear();
				getOwnedSpecializations().addAll((Collection<? extends SpecializationAxiom>)newValue);
				return;
			case OmlPackage.UNREIFIED_RELATION__SOURCE:
				setSource((Entity)newValue);
				return;
			case OmlPackage.UNREIFIED_RELATION__TARGET:
				setTarget((Entity)newValue);
				return;
			case OmlPackage.UNREIFIED_RELATION__REVERSE_RELATION:
				setReverseRelation((ReverseRelation)newValue);
				return;
			case OmlPackage.UNREIFIED_RELATION__FUNCTIONAL:
				setFunctional((Boolean)newValue);
				return;
			case OmlPackage.UNREIFIED_RELATION__INVERSE_FUNCTIONAL:
				setInverseFunctional((Boolean)newValue);
				return;
			case OmlPackage.UNREIFIED_RELATION__SYMMETRIC:
				setSymmetric((Boolean)newValue);
				return;
			case OmlPackage.UNREIFIED_RELATION__ASYMMETRIC:
				setAsymmetric((Boolean)newValue);
				return;
			case OmlPackage.UNREIFIED_RELATION__REFLEXIVE:
				setReflexive((Boolean)newValue);
				return;
			case OmlPackage.UNREIFIED_RELATION__IRREFLEXIVE:
				setIrreflexive((Boolean)newValue);
				return;
			case OmlPackage.UNREIFIED_RELATION__TRANSITIVE:
				setTransitive((Boolean)newValue);
				return;
			case OmlPackage.UNREIFIED_RELATION__OWNED_EQUIVALENCES:
				getOwnedEquivalences().clear();
				getOwnedEquivalences().addAll((Collection<? extends PropertyEquivalenceAxiom>)newValue);
				return;
			case OmlPackage.UNREIFIED_RELATION__REF:
				setRef((Relation)newValue);
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
			case OmlPackage.UNREIFIED_RELATION__OWNING_VOCABULARY:
				setOwningVocabulary((Vocabulary)null);
				return;
			case OmlPackage.UNREIFIED_RELATION__OWNED_SPECIALIZATIONS:
				getOwnedSpecializations().clear();
				return;
			case OmlPackage.UNREIFIED_RELATION__SOURCE:
				setSource((Entity)null);
				return;
			case OmlPackage.UNREIFIED_RELATION__TARGET:
				setTarget((Entity)null);
				return;
			case OmlPackage.UNREIFIED_RELATION__REVERSE_RELATION:
				setReverseRelation((ReverseRelation)null);
				return;
			case OmlPackage.UNREIFIED_RELATION__FUNCTIONAL:
				setFunctional(FUNCTIONAL_EDEFAULT);
				return;
			case OmlPackage.UNREIFIED_RELATION__INVERSE_FUNCTIONAL:
				setInverseFunctional(INVERSE_FUNCTIONAL_EDEFAULT);
				return;
			case OmlPackage.UNREIFIED_RELATION__SYMMETRIC:
				setSymmetric(SYMMETRIC_EDEFAULT);
				return;
			case OmlPackage.UNREIFIED_RELATION__ASYMMETRIC:
				setAsymmetric(ASYMMETRIC_EDEFAULT);
				return;
			case OmlPackage.UNREIFIED_RELATION__REFLEXIVE:
				setReflexive(REFLEXIVE_EDEFAULT);
				return;
			case OmlPackage.UNREIFIED_RELATION__IRREFLEXIVE:
				setIrreflexive(IRREFLEXIVE_EDEFAULT);
				return;
			case OmlPackage.UNREIFIED_RELATION__TRANSITIVE:
				setTransitive(TRANSITIVE_EDEFAULT);
				return;
			case OmlPackage.UNREIFIED_RELATION__OWNED_EQUIVALENCES:
				getOwnedEquivalences().clear();
				return;
			case OmlPackage.UNREIFIED_RELATION__REF:
				setRef((Relation)null);
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
			case OmlPackage.UNREIFIED_RELATION__OWNING_VOCABULARY:
				return basicGetOwningVocabulary() != null;
			case OmlPackage.UNREIFIED_RELATION__OWNED_SPECIALIZATIONS:
				return ownedSpecializations != null && !ownedSpecializations.isEmpty();
			case OmlPackage.UNREIFIED_RELATION__SOURCE:
				return source != null;
			case OmlPackage.UNREIFIED_RELATION__TARGET:
				return target != null;
			case OmlPackage.UNREIFIED_RELATION__REVERSE_RELATION:
				return reverseRelation != null;
			case OmlPackage.UNREIFIED_RELATION__FUNCTIONAL:
				return functional != FUNCTIONAL_EDEFAULT;
			case OmlPackage.UNREIFIED_RELATION__INVERSE_FUNCTIONAL:
				return inverseFunctional != INVERSE_FUNCTIONAL_EDEFAULT;
			case OmlPackage.UNREIFIED_RELATION__SYMMETRIC:
				return symmetric != SYMMETRIC_EDEFAULT;
			case OmlPackage.UNREIFIED_RELATION__ASYMMETRIC:
				return asymmetric != ASYMMETRIC_EDEFAULT;
			case OmlPackage.UNREIFIED_RELATION__REFLEXIVE:
				return reflexive != REFLEXIVE_EDEFAULT;
			case OmlPackage.UNREIFIED_RELATION__IRREFLEXIVE:
				return irreflexive != IRREFLEXIVE_EDEFAULT;
			case OmlPackage.UNREIFIED_RELATION__TRANSITIVE:
				return transitive != TRANSITIVE_EDEFAULT;
			case OmlPackage.UNREIFIED_RELATION__OWNED_EQUIVALENCES:
				return ownedEquivalences != null && !ownedEquivalences.isEmpty();
			case OmlPackage.UNREIFIED_RELATION__REF:
				return ref != null;
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
		if (baseClass == Statement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == VocabularyStatement.class) {
			switch (derivedFeatureID) {
				case OmlPackage.UNREIFIED_RELATION__OWNING_VOCABULARY: return OmlPackage.VOCABULARY_STATEMENT__OWNING_VOCABULARY;
				default: return -1;
			}
		}
		if (baseClass == SpecializableTerm.class) {
			switch (derivedFeatureID) {
				case OmlPackage.UNREIFIED_RELATION__OWNED_SPECIALIZATIONS: return OmlPackage.SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS;
				default: return -1;
			}
		}
		if (baseClass == RelationBase.class) {
			switch (derivedFeatureID) {
				case OmlPackage.UNREIFIED_RELATION__SOURCE: return OmlPackage.RELATION_BASE__SOURCE;
				case OmlPackage.UNREIFIED_RELATION__TARGET: return OmlPackage.RELATION_BASE__TARGET;
				case OmlPackage.UNREIFIED_RELATION__REVERSE_RELATION: return OmlPackage.RELATION_BASE__REVERSE_RELATION;
				case OmlPackage.UNREIFIED_RELATION__FUNCTIONAL: return OmlPackage.RELATION_BASE__FUNCTIONAL;
				case OmlPackage.UNREIFIED_RELATION__INVERSE_FUNCTIONAL: return OmlPackage.RELATION_BASE__INVERSE_FUNCTIONAL;
				case OmlPackage.UNREIFIED_RELATION__SYMMETRIC: return OmlPackage.RELATION_BASE__SYMMETRIC;
				case OmlPackage.UNREIFIED_RELATION__ASYMMETRIC: return OmlPackage.RELATION_BASE__ASYMMETRIC;
				case OmlPackage.UNREIFIED_RELATION__REFLEXIVE: return OmlPackage.RELATION_BASE__REFLEXIVE;
				case OmlPackage.UNREIFIED_RELATION__IRREFLEXIVE: return OmlPackage.RELATION_BASE__IRREFLEXIVE;
				case OmlPackage.UNREIFIED_RELATION__TRANSITIVE: return OmlPackage.RELATION_BASE__TRANSITIVE;
				default: return -1;
			}
		}
		if (baseClass == SpecializableProperty.class) {
			switch (derivedFeatureID) {
				case OmlPackage.UNREIFIED_RELATION__OWNED_EQUIVALENCES: return OmlPackage.SPECIALIZABLE_PROPERTY__OWNED_EQUIVALENCES;
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
		if (baseClass == Statement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == VocabularyStatement.class) {
			switch (baseFeatureID) {
				case OmlPackage.VOCABULARY_STATEMENT__OWNING_VOCABULARY: return OmlPackage.UNREIFIED_RELATION__OWNING_VOCABULARY;
				default: return -1;
			}
		}
		if (baseClass == SpecializableTerm.class) {
			switch (baseFeatureID) {
				case OmlPackage.SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS: return OmlPackage.UNREIFIED_RELATION__OWNED_SPECIALIZATIONS;
				default: return -1;
			}
		}
		if (baseClass == RelationBase.class) {
			switch (baseFeatureID) {
				case OmlPackage.RELATION_BASE__SOURCE: return OmlPackage.UNREIFIED_RELATION__SOURCE;
				case OmlPackage.RELATION_BASE__TARGET: return OmlPackage.UNREIFIED_RELATION__TARGET;
				case OmlPackage.RELATION_BASE__REVERSE_RELATION: return OmlPackage.UNREIFIED_RELATION__REVERSE_RELATION;
				case OmlPackage.RELATION_BASE__FUNCTIONAL: return OmlPackage.UNREIFIED_RELATION__FUNCTIONAL;
				case OmlPackage.RELATION_BASE__INVERSE_FUNCTIONAL: return OmlPackage.UNREIFIED_RELATION__INVERSE_FUNCTIONAL;
				case OmlPackage.RELATION_BASE__SYMMETRIC: return OmlPackage.UNREIFIED_RELATION__SYMMETRIC;
				case OmlPackage.RELATION_BASE__ASYMMETRIC: return OmlPackage.UNREIFIED_RELATION__ASYMMETRIC;
				case OmlPackage.RELATION_BASE__REFLEXIVE: return OmlPackage.UNREIFIED_RELATION__REFLEXIVE;
				case OmlPackage.RELATION_BASE__IRREFLEXIVE: return OmlPackage.UNREIFIED_RELATION__IRREFLEXIVE;
				case OmlPackage.RELATION_BASE__TRANSITIVE: return OmlPackage.UNREIFIED_RELATION__TRANSITIVE;
				default: return -1;
			}
		}
		if (baseClass == SpecializableProperty.class) {
			switch (baseFeatureID) {
				case OmlPackage.SPECIALIZABLE_PROPERTY__OWNED_EQUIVALENCES: return OmlPackage.UNREIFIED_RELATION__OWNED_EQUIVALENCES;
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
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == SemanticProperty.class) {
			switch (baseOperationID) {
				case OmlPackage.SEMANTIC_PROPERTY___GET_DOMAIN: return OmlPackage.UNREIFIED_RELATION___GET_DOMAIN;
				case OmlPackage.SEMANTIC_PROPERTY___GET_RANGE: return OmlPackage.UNREIFIED_RELATION___GET_RANGE;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == Relation.class) {
			switch (baseOperationID) {
				case OmlPackage.RELATION___GET_DOMAIN: return OmlPackage.UNREIFIED_RELATION___GET_DOMAIN;
				case OmlPackage.RELATION___GET_RANGE: return OmlPackage.UNREIFIED_RELATION___GET_RANGE;
				case OmlPackage.RELATION___GET_INVERSE: return OmlPackage.UNREIFIED_RELATION___GET_INVERSE;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == Statement.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == VocabularyStatement.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == SpecializableTerm.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == RelationBase.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == SpecializableProperty.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OmlPackage.UNREIFIED_RELATION___GET_DOMAIN:
				return getDomain();
			case OmlPackage.UNREIFIED_RELATION___GET_RANGE:
				return getRange();
			case OmlPackage.UNREIFIED_RELATION___GET_INVERSE:
				return getInverse();
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

} //UnreifiedRelationImpl
