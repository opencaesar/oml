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
 * A representation of the model object '<em><b>Forward Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ForwardRelation is a relation that is defined along side a relation entity, whose domain is the source of the relation
 * entity, and whose range is the target of the relation entity. A forward relation has DL semantics that are specified
 * by the boolean flags of its relation entity.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.ForwardRelation#getRelationEntity <em>Relation Entity</em>}</li>
 *   <li>{@link io.opencaesar.oml.ForwardRelation#isFunctional <em>Functional</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getForwardRelation()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Properties'"
 * @generated
 */
public interface ForwardRelation extends Relation {
	/**
	 * Returns the value of the '<em><b>Relation Entity</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.RelationEntity#getForwardRelation <em>Forward Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The relation entity that owns this relation as forward
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Relation Entity</em>' container reference.
	 * @see #setRelationEntity(RelationEntity)
	 * @see io.opencaesar.oml.OmlPackage#getForwardRelation_RelationEntity()
	 * @see io.opencaesar.oml.RelationEntity#getForwardRelation
	 * @model opposite="forwardRelation" required="true" transient="false"
	 * @generated
	 */
	RelationEntity getRelationEntity();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.ForwardRelation#getRelationEntity <em>Relation Entity</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation Entity</em>' container reference.
	 * @see #getRelationEntity()
	 * @generated
	 */
	void setRelationEntity(RelationEntity value);

	/**
	 * Returns the value of the '<em><b>Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this property is functional (has a max of one value per instance)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Functional</em>' attribute.
	 * @see io.opencaesar.oml.OmlPackage#getForwardRelation_Functional()
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

} // ForwardRelation
