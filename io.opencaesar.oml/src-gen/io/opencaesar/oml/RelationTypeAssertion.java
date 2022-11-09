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
 * A representation of the model object '<em><b>Relation Type Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * RelationTypeAssertion is a type assertion specifying a relation entity as a type of a relation instance. It can be specified
 * directly on a relation instance, or indirectly on a reference to one.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.RelationTypeAssertion#getType <em>Type</em>}</li>
 *   <li>{@link io.opencaesar.oml.RelationTypeAssertion#getOwningInstance <em>Owning Instance</em>}</li>
 *   <li>{@link io.opencaesar.oml.RelationTypeAssertion#getOwningReference <em>Owning Reference</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getRelationTypeAssertion()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Assertions'"
 * @generated
 */
public interface RelationTypeAssertion extends TypeAssertion {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The relation entity that is the type of the relation instance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(RelationEntity)
	 * @see io.opencaesar.oml.OmlPackage#getRelationTypeAssertion_Type()
	 * @model required="true"
	 * @generated
	 */
	RelationEntity getType();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationTypeAssertion#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(RelationEntity value);

	/**
	 * Returns the value of the '<em><b>Owning Instance</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.RelationInstance#getOwnedTypes <em>Owned Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The relation instance that this type assertion is about
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Instance</em>' container reference.
	 * @see #setOwningInstance(RelationInstance)
	 * @see io.opencaesar.oml.OmlPackage#getRelationTypeAssertion_OwningInstance()
	 * @see io.opencaesar.oml.RelationInstance#getOwnedTypes
	 * @model opposite="ownedTypes" transient="false"
	 * @generated
	 */
	RelationInstance getOwningInstance();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationTypeAssertion#getOwningInstance <em>Owning Instance</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Instance</em>' container reference.
	 * @see #getOwningInstance()
	 * @generated
	 */
	void setOwningInstance(RelationInstance value);

	/**
	 * Returns the value of the '<em><b>Owning Reference</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.RelationInstanceReference#getOwnedTypes <em>Owned Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The reference to a relation instance that this type assertion is about
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Reference</em>' container reference.
	 * @see #setOwningReference(RelationInstanceReference)
	 * @see io.opencaesar.oml.OmlPackage#getRelationTypeAssertion_OwningReference()
	 * @see io.opencaesar.oml.RelationInstanceReference#getOwnedTypes
	 * @model opposite="ownedTypes" transient="false"
	 * @generated
	 */
	RelationInstanceReference getOwningReference();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationTypeAssertion#getOwningReference <em>Owning Reference</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Reference</em>' container reference.
	 * @see #getOwningReference()
	 * @generated
	 */
	void setOwningReference(RelationInstanceReference value);

} // RelationTypeAssertion
