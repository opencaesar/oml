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
 * A representation of the model object '<em><b>Built In Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * BuiltInPredicate is a [=Predicate=] that has two [=arguments=]: argument1 and argument2
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.BuiltInPredicate#getBuiltIn <em>Built In</em>}</li>
 *   <li>{@link io.opencaesar.oml.BuiltInPredicate#getArguments <em>Arguments</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getBuiltInPredicate()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Predicates'"
 * @generated
 */
public interface BuiltInPredicate extends Predicate {
	/**
	 * Returns the value of the '<em><b>Built In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The called builtin
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Built In</em>' reference.
	 * @see #setBuiltIn(BuiltIn)
	 * @see io.opencaesar.oml.OmlPackage#getBuiltInPredicate_BuiltIn()
	 * @model required="true"
	 * @generated
	 */
	BuiltIn getBuiltIn();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.BuiltInPredicate#getBuiltIn <em>Built In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Built In</em>' reference.
	 * @see #getBuiltIn()
	 * @generated
	 */
	void setBuiltIn(BuiltIn value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.Argument}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An argument of the predicate
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getBuiltInPredicate_Arguments()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Argument> getArguments();

} // BuiltInPredicate
