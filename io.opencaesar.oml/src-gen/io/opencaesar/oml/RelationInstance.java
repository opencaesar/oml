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
 * A representation of the model object '<em><b>Relation Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * RelationInstance is a named instance that can be typed by relation entities and that goes from one or more
 * named instances as sources to one or more named instances as target.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.RelationInstance#getOwnedTypes <em>Owned Types</em>}</li>
 *   <li>{@link io.opencaesar.oml.RelationInstance#getSources <em>Sources</em>}</li>
 *   <li>{@link io.opencaesar.oml.RelationInstance#getTargets <em>Targets</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getRelationInstance()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Instances'"
 * @generated
 */
public interface RelationInstance extends NamedInstance {
	/**
	 * Returns the value of the '<em><b>Owned Types</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.RelationTypeAssertion}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.RelationTypeAssertion#getOwningInstance <em>Owning Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The types of this instance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Types</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getRelationInstance_OwnedTypes()
	 * @see io.opencaesar.oml.RelationTypeAssertion#getOwningInstance
	 * @model opposite="owningInstance" containment="true"
	 * @generated
	 */
	EList<RelationTypeAssertion> getOwnedTypes();

	/**
	 * Returns the value of the '<em><b>Sources</b></em>' reference list.
	 * The list contents are of type {@link io.opencaesar.oml.NamedInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The named instances that are the sources of this relation instance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sources</em>' reference list.
	 * @see io.opencaesar.oml.OmlPackage#getRelationInstance_Sources()
	 * @model required="true"
	 * @generated
	 */
	EList<NamedInstance> getSources();

	/**
	 * Returns the value of the '<em><b>Targets</b></em>' reference list.
	 * The list contents are of type {@link io.opencaesar.oml.NamedInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The named instances that are the targets of this relation instance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Targets</em>' reference list.
	 * @see io.opencaesar.oml.OmlPackage#getRelationInstance_Targets()
	 * @model required="true"
	 * @generated
	 */
	EList<NamedInstance> getTargets();

} // RelationInstance
