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
 * A representation of the model object '<em><b>Specializable Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * SpecializableProperty is a [=property=] that can be specialized. It can also specify [=PropertyEquivalenceAxioms=].
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.SpecializableProperty#getOwnedEquivalences <em>Owned Equivalences</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getSpecializableProperty()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Properties'"
 * @generated
 */
public interface SpecializableProperty extends SpecializableTerm, Property {
	/**
	 * Returns the value of the '<em><b>Owned Equivalences</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.PropertyEquivalenceAxiom}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.PropertyEquivalenceAxiom#getOwningProperty <em>Owning Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of property equivalence axioms of this property
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Equivalences</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getSpecializableProperty_OwnedEquivalences()
	 * @see io.opencaesar.oml.PropertyEquivalenceAxiom#getOwningProperty
	 * @model opposite="owningProperty" containment="true"
	 * @generated
	 */
	EList<PropertyEquivalenceAxiom> getOwnedEquivalences();

} // SpecializableProperty
