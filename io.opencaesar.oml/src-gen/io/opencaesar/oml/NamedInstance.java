/**
 * 
 * Copyright 2019-2022 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	 http://www.apache.org/licenses/LICENSE-2.0
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
 * A representation of the model object '<em><b>Named Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * NamedInstance is an [=Instance=] that is a member of a [=description=].
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.NamedInstance#getOwnedTypes <em>Owned Types</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getNamedInstance()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Instances'"
 * @generated
 */
public interface NamedInstance extends DescriptionStatement, Instance {
	/**
	 * Returns the value of the '<em><b>Owned Types</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.TypeAssertion}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.TypeAssertion#getOwningInstance <em>Owning Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The types of this instance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Types</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getNamedInstance_OwnedTypes()
	 * @see io.opencaesar.oml.TypeAssertion#getOwningInstance
	 * @model opposite="owningInstance" containment="true"
	 * @generated
	 */
	EList<TypeAssertion> getOwnedTypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the instance's entity types
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<Entity> getEntityTypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<Entity> getTypes();

} // NamedInstance
