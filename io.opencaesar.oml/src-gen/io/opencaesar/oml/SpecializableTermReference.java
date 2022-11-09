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
 * A representation of the model object '<em><b>Specializable Term Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * SpecializableTermReference is a reference to a specializable term that can be used to add other
 * specializations to it.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.SpecializableTermReference#getOwnedSpecializations <em>Owned Specializations</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getSpecializableTermReference()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='References'"
 * @generated
 */
public interface SpecializableTermReference extends Reference, VocabularyStatement {
	/**
	 * Returns the value of the '<em><b>Owned Specializations</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.SpecializationAxiom}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.SpecializationAxiom#getOwningReference <em>Owning Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of specialization axioms added to the referenced term by this reference
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Specializations</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getSpecializableTermReference_OwnedSpecializations()
	 * @see io.opencaesar.oml.SpecializationAxiom#getOwningReference
	 * @model opposite="owningReference" containment="true"
	 * @generated
	 */
	EList<SpecializationAxiom> getOwnedSpecializations();

} // SpecializableTermReference
