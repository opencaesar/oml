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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * BinaryPredicate is a predicate that takes two arguments: the first is a `variable1` to match to some
 * instance, and the second is either a `variable2` to match to some instance or a specific `instance2`.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.BinaryPredicate#getVariable1 <em>Variable1</em>}</li>
 *   <li>{@link io.opencaesar.oml.BinaryPredicate#getVariable2 <em>Variable2</em>}</li>
 *   <li>{@link io.opencaesar.oml.BinaryPredicate#getInstance2 <em>Instance2</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getBinaryPredicate()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Rules'"
 * @generated
 */
public interface BinaryPredicate extends Predicate {
	/**
	 * Returns the value of the '<em><b>Variable1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The variable1 specified by the predicate
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variable1</em>' attribute.
	 * @see #setVariable1(String)
	 * @see io.opencaesar.oml.OmlPackage#getBinaryPredicate_Variable1()
	 * @model unique="false" dataType="io.opencaesar.oml.ID" required="true"
	 * @generated
	 */
	String getVariable1();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.BinaryPredicate#getVariable1 <em>Variable1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable1</em>' attribute.
	 * @see #getVariable1()
	 * @generated
	 */
	void setVariable1(String value);

	/**
	 * Returns the value of the '<em><b>Variable2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The optional variable2 specified by the predicate
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variable2</em>' attribute.
	 * @see #setVariable2(String)
	 * @see io.opencaesar.oml.OmlPackage#getBinaryPredicate_Variable2()
	 * @model unique="false" dataType="io.opencaesar.oml.ID"
	 * @generated
	 */
	String getVariable2();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.BinaryPredicate#getVariable2 <em>Variable2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable2</em>' attribute.
	 * @see #getVariable2()
	 * @generated
	 */
	void setVariable2(String value);

	/**
	 * Returns the value of the '<em><b>Instance2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The optional instance2 specified by the predicate
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Instance2</em>' reference.
	 * @see #setInstance2(NamedInstance)
	 * @see io.opencaesar.oml.OmlPackage#getBinaryPredicate_Instance2()
	 * @model
	 * @generated
	 */
	NamedInstance getInstance2();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.BinaryPredicate#getInstance2 <em>Instance2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance2</em>' reference.
	 * @see #getInstance2()
	 * @generated
	 */
	void setInstance2(NamedInstance value);

} // BinaryPredicate
