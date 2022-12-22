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
 * RelationEntityPredicate is a binary predicate that binds its `variable` to a relation instance,
 * its `variable1` to the source of that relation instance, and either its `variable2` or `instance2` as the target of
 * that relation instance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.RelationEntityPredicate#getEntity <em>Entity</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getRelationEntityPredicate()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Rules'"
 * @generated
 */
public interface RelationEntityPredicate extends UnaryPredicate, BinaryPredicate {
	/**
	 * Returns the value of the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of the relation instance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Entity</em>' reference.
	 * @see #setEntity(RelationEntity)
	 * @see io.opencaesar.oml.OmlPackage#getRelationEntityPredicate_Entity()
	 * @model required="true"
	 * @generated
	 */
	RelationEntity getEntity();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationEntityPredicate#getEntity <em>Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity</em>' reference.
	 * @see #getEntity()
	 * @generated
	 */
	void setEntity(RelationEntity value);

} // RelationEntityPredicate
