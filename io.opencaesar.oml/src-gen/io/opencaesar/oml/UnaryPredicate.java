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
 * A representation of the model object '<em><b>Unary Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * UnaryPredicate is a predicate that binds one variable
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.UnaryPredicate#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getUnaryPredicate()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Rules'"
 * @generated
 */
public interface UnaryPredicate extends Predicate {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The variable name specified by the predicate
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variable</em>' attribute.
	 * @see #setVariable(String)
	 * @see io.opencaesar.oml.OmlPackage#getUnaryPredicate_Variable()
	 * @model unique="false" dataType="io.opencaesar.oml.ID" required="true"
	 * @generated
	 */
	String getVariable();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.UnaryPredicate#getVariable <em>Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' attribute.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(String value);

} // UnaryPredicate
