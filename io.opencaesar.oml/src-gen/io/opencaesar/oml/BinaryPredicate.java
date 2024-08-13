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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * BinaryPredicate is a [=Predicate=] that has two [=arguments=]: argument1 and argument2
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.BinaryPredicate#getArgument1 <em>Argument1</em>}</li>
 *   <li>{@link io.opencaesar.oml.BinaryPredicate#getArgument2 <em>Argument2</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getBinaryPredicate()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Predicates'"
 * @generated
 */
public interface BinaryPredicate extends Predicate {
	/**
	 * Returns the value of the '<em><b>Argument1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An argument of the predicate
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Argument1</em>' containment reference.
	 * @see #setArgument1(Argument)
	 * @see io.opencaesar.oml.OmlPackage#getBinaryPredicate_Argument1()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Argument getArgument1();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.BinaryPredicate#getArgument1 <em>Argument1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Argument1</em>' containment reference.
	 * @see #getArgument1()
	 * @generated
	 */
	void setArgument1(Argument value);

	/**
	 * Returns the value of the '<em><b>Argument2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An argument of the predicate
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Argument2</em>' containment reference.
	 * @see #setArgument2(Argument)
	 * @see io.opencaesar.oml.OmlPackage#getBinaryPredicate_Argument2()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Argument getArgument2();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.BinaryPredicate#getArgument2 <em>Argument2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Argument2</em>' containment reference.
	 * @see #getArgument2()
	 * @generated
	 */
	void setArgument2(Argument value);

} // BinaryPredicate
