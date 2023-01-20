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
 * A representation of the model object '<em><b>Relation Entity Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * RelationEntityPredicate is a unary and binary predicate that holds when its argument is bound to an instance typed by the given relation
 * entity, its argument1 is bound to the source of that relation instance and its argument2 is bound to the target of that relation instance
 * .
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.RelationEntityPredicate#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getRelationEntityPredicate()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Rules'"
 * @generated
 */
public interface RelationEntityPredicate extends UnaryPredicate, BinaryPredicate {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of a relation instance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(RelationEntity)
	 * @see io.opencaesar.oml.OmlPackage#getRelationEntityPredicate_Type()
	 * @model required="true"
	 * @generated
	 */
	RelationEntity getType();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationEntityPredicate#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(RelationEntity value);

} // RelationEntityPredicate
