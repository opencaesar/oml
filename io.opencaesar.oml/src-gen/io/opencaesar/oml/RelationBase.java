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
package io.opencaesar.oml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * RelationBase is a specializable term that is the superclass of a relation from a source entity to a target entity.
 * It can optionally name a reverse property whose domain is the target and whose range is the source.
 * It can also be characterized with several boolean flags that represent its DL semantics.
 * Such flags apply conversely to the reverse property (if named).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.RelationBase#getSource <em>Source</em>}</li>
 *   <li>{@link io.opencaesar.oml.RelationBase#getTarget <em>Target</em>}</li>
 *   <li>{@link io.opencaesar.oml.RelationBase#getReverseRelation <em>Reverse Relation</em>}</li>
 *   <li>{@link io.opencaesar.oml.RelationBase#isFunctional <em>Functional</em>}</li>
 *   <li>{@link io.opencaesar.oml.RelationBase#isInverseFunctional <em>Inverse Functional</em>}</li>
 *   <li>{@link io.opencaesar.oml.RelationBase#isSymmetric <em>Symmetric</em>}</li>
 *   <li>{@link io.opencaesar.oml.RelationBase#isAsymmetric <em>Asymmetric</em>}</li>
 *   <li>{@link io.opencaesar.oml.RelationBase#isReflexive <em>Reflexive</em>}</li>
 *   <li>{@link io.opencaesar.oml.RelationBase#isIrreflexive <em>Irreflexive</em>}</li>
 *   <li>{@link io.opencaesar.oml.RelationBase#isTransitive <em>Transitive</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getRelationBase()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Properties'"
 * @generated
 */
public interface RelationBase extends SpecializableTerm {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The entity that represents the source of this relation base
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Entity)
	 * @see io.opencaesar.oml.OmlPackage#getRelationBase_Source()
	 * @model required="true"
	 * @generated
	 */
	Entity getSource();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationBase#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Entity value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The entity that represents the target of this relation base
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Entity)
	 * @see io.opencaesar.oml.OmlPackage#getRelationBase_Target()
	 * @model required="true"
	 * @generated
	 */
	Entity getTarget();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationBase#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Entity value);

	/**
	 * Returns the value of the '<em><b>Reverse Relation</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.ReverseRelation#getRelationBase <em>Relation Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The optional reverse relation of this relation base
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reverse Relation</em>' containment reference.
	 * @see #setReverseRelation(ReverseRelation)
	 * @see io.opencaesar.oml.OmlPackage#getRelationBase_ReverseRelation()
	 * @see io.opencaesar.oml.ReverseRelation#getRelationBase
	 * @model opposite="relationBase" containment="true"
	 * @generated
	 */
	ReverseRelation getReverseRelation();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationBase#getReverseRelation <em>Reverse Relation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reverse Relation</em>' containment reference.
	 * @see #getReverseRelation()
	 * @generated
	 */
	void setReverseRelation(ReverseRelation value);

	/**
	 * Returns the value of the '<em><b>Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this relation base is functional (i.e., {@code A -> B and A->C => B=C})
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Functional</em>' attribute.
	 * @see #setFunctional(boolean)
	 * @see io.opencaesar.oml.OmlPackage#getRelationBase_Functional()
	 * @model unique="false"
	 * @generated
	 */
	boolean isFunctional();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationBase#isFunctional <em>Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Functional</em>' attribute.
	 * @see #isFunctional()
	 * @generated
	 */
	void setFunctional(boolean value);

	/**
	 * Returns the value of the '<em><b>Inverse Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this relation base is inverse functional (i.e., {@code B->A and C->A => B=C})
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inverse Functional</em>' attribute.
	 * @see #setInverseFunctional(boolean)
	 * @see io.opencaesar.oml.OmlPackage#getRelationBase_InverseFunctional()
	 * @model unique="false"
	 * @generated
	 */
	boolean isInverseFunctional();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationBase#isInverseFunctional <em>Inverse Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inverse Functional</em>' attribute.
	 * @see #isInverseFunctional()
	 * @generated
	 */
	void setInverseFunctional(boolean value);

	/**
	 * Returns the value of the '<em><b>Symmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this relation base is symmetric (i.e., {@code A->B => B->A})
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Symmetric</em>' attribute.
	 * @see #setSymmetric(boolean)
	 * @see io.opencaesar.oml.OmlPackage#getRelationBase_Symmetric()
	 * @model unique="false"
	 * @generated
	 */
	boolean isSymmetric();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationBase#isSymmetric <em>Symmetric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symmetric</em>' attribute.
	 * @see #isSymmetric()
	 * @generated
	 */
	void setSymmetric(boolean value);

	/**
	 * Returns the value of the '<em><b>Asymmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this relation base is asymmetric (i.e., {@code A->B => !(B->A)})
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Asymmetric</em>' attribute.
	 * @see #setAsymmetric(boolean)
	 * @see io.opencaesar.oml.OmlPackage#getRelationBase_Asymmetric()
	 * @model unique="false"
	 * @generated
	 */
	boolean isAsymmetric();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationBase#isAsymmetric <em>Asymmetric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asymmetric</em>' attribute.
	 * @see #isAsymmetric()
	 * @generated
	 */
	void setAsymmetric(boolean value);

	/**
	 * Returns the value of the '<em><b>Reflexive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this relation base is reflexive (i.e., {@code A => A->A})
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reflexive</em>' attribute.
	 * @see #setReflexive(boolean)
	 * @see io.opencaesar.oml.OmlPackage#getRelationBase_Reflexive()
	 * @model unique="false"
	 * @generated
	 */
	boolean isReflexive();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationBase#isReflexive <em>Reflexive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reflexive</em>' attribute.
	 * @see #isReflexive()
	 * @generated
	 */
	void setReflexive(boolean value);

	/**
	 * Returns the value of the '<em><b>Irreflexive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this relation base is irreflexive (i.e., {@code A => !(A->A)})
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Irreflexive</em>' attribute.
	 * @see #setIrreflexive(boolean)
	 * @see io.opencaesar.oml.OmlPackage#getRelationBase_Irreflexive()
	 * @model unique="false"
	 * @generated
	 */
	boolean isIrreflexive();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationBase#isIrreflexive <em>Irreflexive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Irreflexive</em>' attribute.
	 * @see #isIrreflexive()
	 * @generated
	 */
	void setIrreflexive(boolean value);

	/**
	 * Returns the value of the '<em><b>Transitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this relation base is transitive (i.e., {@code A->B and B->C => A->C})
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Transitive</em>' attribute.
	 * @see #setTransitive(boolean)
	 * @see io.opencaesar.oml.OmlPackage#getRelationBase_Transitive()
	 * @model unique="false"
	 * @generated
	 */
	boolean isTransitive();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationBase#isTransitive <em>Transitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transitive</em>' attribute.
	 * @see #isTransitive()
	 * @generated
	 */
	void setTransitive(boolean value);

} // RelationBase
