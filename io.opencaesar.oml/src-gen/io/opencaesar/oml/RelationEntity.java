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
 * A representation of the model object '<em><b>Relation Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * RelationEntity is an [=entity=] that represents a reified relation from a source entity to a target entity.
 * It can optionally name a [=ForwardRelation=] whose domain is the source and whose range is the target.
 * If both are named, such [=ForwardRelation=] becomes the inverse of the entity's [=ReverseRelation=] .
 * If not, then a default [=ForwardRelation=]  with the name 'has<Relation>Forward' is assumed.
 * A relation entity ref cannot specify a [=ForwardRelation=].
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.RelationEntity#getRef <em>Ref</em>}</li>
 *   <li>{@link io.opencaesar.oml.RelationEntity#getForwardRelation <em>Forward Relation</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getRelationEntity()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Relations'"
 * @generated
 */
public interface RelationEntity extends Entity, RelationBase {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A ref to another relation entity
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(RelationEntity)
	 * @see io.opencaesar.oml.OmlPackage#getRelationEntity_Ref()
	 * @model
	 * @generated
	 */
	RelationEntity getRef();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationEntity#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(RelationEntity value);

	/**
	 * Returns the value of the '<em><b>Forward Relation</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.ForwardRelation#getRelationEntity <em>Relation Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The optional forward relation of this relation entity
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Forward Relation</em>' containment reference.
	 * @see #setForwardRelation(ForwardRelation)
	 * @see io.opencaesar.oml.OmlPackage#getRelationEntity_ForwardRelation()
	 * @see io.opencaesar.oml.ForwardRelation#getRelationEntity
	 * @model opposite="relationEntity" containment="true"
	 * @generated
	 */
	ForwardRelation getForwardRelation();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationEntity#getForwardRelation <em>Forward Relation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Forward Relation</em>' containment reference.
	 * @see #getForwardRelation()
	 * @generated
	 */
	void setForwardRelation(ForwardRelation value);

} // RelationEntity
