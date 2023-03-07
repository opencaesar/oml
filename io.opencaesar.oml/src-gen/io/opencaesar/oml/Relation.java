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
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Relation is a feature that represents a relation from its domain entity to its range entity. It is the super type of
 * two concrete relations: [=ForwardRelation=] and [=ReverseRelation] that are specified by a relation entity. When a relation
 * entity specifies both kinds of relations, they become inverse of each other.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.Relation#getDomain <em>Domain</em>}</li>
 *   <li>{@link io.opencaesar.oml.Relation#getRange <em>Range</em>}</li>
 *   <li>{@link io.opencaesar.oml.Relation#getInverse <em>Inverse</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getRelation()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Features'"
 * @generated
 */
public interface Relation extends Feature {
	/**
	 * Returns the value of the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The entity that represents the domain of this relation
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domain</em>' reference.
	 * @see io.opencaesar.oml.OmlPackage#getRelation_Domain()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Entity getDomain();

	/**
	 * Returns the value of the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The entity that represents the range of this relation
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Range</em>' reference.
	 * @see io.opencaesar.oml.OmlPackage#getRelation_Range()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Entity getRange();

	/**
	 * Returns the value of the '<em><b>Inverse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The relation (if any) that is the inverse of this relation
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inverse</em>' reference.
	 * @see io.opencaesar.oml.OmlPackage#getRelation_Inverse()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Relation getInverse();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the relation entity of this relation
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="https://www.eclipse.org/emf/2002/Ecore getterOf='relationEntity'"
	 * @generated
	 */
	RelationEntity getRelationEntity();

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

} // Relation
