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
 * A representation of the model object '<em><b>Reverse Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ReverseRelation is a relation that is defined by a relation base and represents its inverse relation. Its domain
 * is the target of the relation base, and its range is the source of the relation base. The DL semantics of a reverse property are
 * derived from those of its relation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.ReverseRelation#getRelationBase <em>Relation Base</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getReverseRelation()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Properties'"
 * @generated
 */
public interface ReverseRelation extends Relation {
	/**
	 * Returns the value of the '<em><b>Relation Base</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.RelationBase#getReverseRelation <em>Reverse Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The relation that owns this reverse property
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Relation Base</em>' container reference.
	 * @see #setRelationBase(RelationBase)
	 * @see io.opencaesar.oml.OmlPackage#getReverseRelation_RelationBase()
	 * @see io.opencaesar.oml.RelationBase#getReverseRelation
	 * @model opposite="reverseRelation" required="true" transient="false"
	 * @generated
	 */
	RelationBase getRelationBase();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.ReverseRelation#getRelationBase <em>Relation Base</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation Base</em>' container reference.
	 * @see #getRelationBase()
	 * @generated
	 */
	void setRelationBase(RelationBase value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Member getRef();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	boolean isFunctional();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	boolean isInverseFunctional();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	boolean isSymmetric();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	boolean isAsymmetric();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	boolean isReflexive();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	boolean isIrreflexive();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	boolean isTransitive();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Entity getDomain();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Entity getRange();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Relation getInverse();

} // ReverseRelation
