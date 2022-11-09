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
 * A representation of the model object '<em><b>Concept</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Concept is a concrete entity that classifies a (possibly enumerated) set of concept instances.
 * It can also specialize other concepts and/or aspects.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.Concept#getEnumeratedInstances <em>Enumerated Instances</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getConcept()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Types'"
 * @generated
 */
public interface Concept extends Entity {
	/**
	 * Returns the value of the '<em><b>Enumerated Instances</b></em>' reference list.
	 * The list contents are of type {@link io.opencaesar.oml.ConceptInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of enumerated instances of this concept
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Enumerated Instances</em>' reference list.
	 * @see io.opencaesar.oml.OmlPackage#getConcept_EnumeratedInstances()
	 * @model
	 * @generated
	 */
	EList<ConceptInstance> getEnumeratedInstances();

} // Concept
