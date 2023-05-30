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
 * A representation of the model object '<em><b>Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Argument is an element that represents a variable name, a [=Literal=], or an [=NamedInstance=] specified in a [=predicate=].
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.Argument#getVariable <em>Variable</em>}</li>
 *   <li>{@link io.opencaesar.oml.Argument#getLiteral <em>Literal</em>}</li>
 *   <li>{@link io.opencaesar.oml.Argument#getInstance <em>Instance</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getArgument()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Predicates'"
 * @generated
 */
public interface Argument extends Element {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional variable specified by this argument
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variable</em>' attribute.
	 * @see #setVariable(String)
	 * @see io.opencaesar.oml.OmlPackage#getArgument_Variable()
	 * @model unique="false" dataType="io.opencaesar.oml.ID"
	 * @generated
	 */
	String getVariable();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Argument#getVariable <em>Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' attribute.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(String value);

	/**
	 * Returns the value of the '<em><b>Literal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional literal specified by this argument
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Literal</em>' containment reference.
	 * @see #setLiteral(Literal)
	 * @see io.opencaesar.oml.OmlPackage#getArgument_Literal()
	 * @model containment="true"
	 * @generated
	 */
	Literal getLiteral();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Argument#getLiteral <em>Literal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' containment reference.
	 * @see #getLiteral()
	 * @generated
	 */
	void setLiteral(Literal value);

	/**
	 * Returns the value of the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional instance specified by this argument
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Instance</em>' reference.
	 * @see #setInstance(NamedInstance)
	 * @see io.opencaesar.oml.OmlPackage#getArgument_Instance()
	 * @model
	 * @generated
	 */
	NamedInstance getInstance();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Argument#getInstance <em>Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance</em>' reference.
	 * @see #getInstance()
	 * @generated
	 */
	void setInstance(NamedInstance value);

} // Argument
