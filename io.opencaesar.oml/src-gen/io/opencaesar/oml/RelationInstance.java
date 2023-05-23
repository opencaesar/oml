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
 * RelationInstance is a [=NamedInstance=] that can be typed by [=RelationEntities=] and represents a link from one or
 * more [=NamedInstances=] as sources to one or more [=NamedInstances=] as targets.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.RelationInstance#getRef <em>Ref</em>}</li>
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
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A ref to another relation instance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(RelationInstance)
	 * @see io.opencaesar.oml.OmlPackage#getRelationInstance_Ref()
	 * @model
	 * @generated
	 */
	RelationInstance getRef();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationInstance#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(RelationInstance value);

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
	 * @model
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
	 * @model
	 * @generated
	 */
	EList<NamedInstance> getTargets();

} // RelationInstance
