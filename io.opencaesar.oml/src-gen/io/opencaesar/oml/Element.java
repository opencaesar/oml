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

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Element is the root supertype in OML. All objects in an OML ontology are elements.
 * <!-- end-model-doc -->
 *
 *
 * @see io.opencaesar.oml.OmlPackage#getElement()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Elements'"
 * @generated
 */
public interface Element extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the ontology that defines this element
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Ontology getOntology();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Validates this element by extra validation rules
	 * @param diagnostics validation error diagnostics
	 * @param context object-to-object map used in producing messages
	 * <!-- end-model-doc -->
	 * @model unique="false" diagnosticsUnique="false" contextUnique="false"
	 * @generated
	 */
	boolean extraValidate(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Element
