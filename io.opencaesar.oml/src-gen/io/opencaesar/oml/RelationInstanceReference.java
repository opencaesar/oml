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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Instance Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * RelationInstanceReference is a reference to a relation instance that can be used to add other types to it.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.RelationInstanceReference#getInstance <em>Instance</em>}</li>
 *   <li>{@link io.opencaesar.oml.RelationInstanceReference#getOwnedTypes <em>Owned Types</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getRelationInstanceReference()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='References'"
 * @generated
 */
public interface RelationInstanceReference extends NamedInstanceReference {
	/**
	 * Returns the value of the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referenced relation instance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Instance</em>' reference.
	 * @see #setInstance(RelationInstance)
	 * @see io.opencaesar.oml.OmlPackage#getRelationInstanceReference_Instance()
	 * @model required="true"
	 * @generated
	 */
	RelationInstance getInstance();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationInstanceReference#getInstance <em>Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance</em>' reference.
	 * @see #getInstance()
	 * @generated
	 */
	void setInstance(RelationInstance value);

	/**
	 * Returns the value of the '<em><b>Owned Types</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.RelationTypeAssertion}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.RelationTypeAssertion#getOwningReference <em>Owning Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of type assertions added to the referenced relation instance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Types</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getRelationInstanceReference_OwnedTypes()
	 * @see io.opencaesar.oml.RelationTypeAssertion#getOwningReference
	 * @model opposite="owningReference" containment="true"
	 * @generated
	 */
	EList<RelationTypeAssertion> getOwnedTypes();

} // RelationInstanceReference
