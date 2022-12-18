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
 * ReverseRelation is a relation that is defined along side a relation entity, whose domain is the target of
 * the relation entity, and whose range is the source of the relation entity. A reverse relation has DL semantics that
 * are the inverse of its entity's forward relation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.ReverseRelation#getRelationBase <em>Relation Base</em>}</li>
 *   <li>{@link io.opencaesar.oml.ReverseRelation#isFunctional <em>Functional</em>}</li>
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
	 * The relation base that owns this reverse relation
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
	 * Returns the value of the '<em><b>Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this property is functional (has a max of one value per instance)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Functional</em>' attribute.
	 * @see io.opencaesar.oml.OmlPackage#getReverseRelation_Functional()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isFunctional();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 * @generated
	 */
	Entity deriveDomain();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 * @generated
	 */
	Entity deriveRange();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 * @generated
	 */
	Relation deriveInverse();

} // ReverseRelation
