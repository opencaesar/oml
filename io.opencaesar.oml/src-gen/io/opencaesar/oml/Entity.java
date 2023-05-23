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
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Entity is a [=classifier=] whose instances are [=NamedInstances=]. It can also specify a set of [=KeyAxioms=].
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.Entity#getOwnedKeys <em>Owned Keys</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getEntity()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Types'"
 * @generated
 */
public interface Entity extends Classifier {
	/**
	 * Returns the value of the '<em><b>Owned Keys</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.KeyAxiom}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.KeyAxiom#getOwningEntity <em>Owning Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The unique keys of this entity
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Keys</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getEntity_OwnedKeys()
	 * @see io.opencaesar.oml.KeyAxiom#getOwningEntity
	 * @model opposite="owningEntity" containment="true"
	 * @generated
	 */
	EList<KeyAxiom> getOwnedKeys();

} // Entity
