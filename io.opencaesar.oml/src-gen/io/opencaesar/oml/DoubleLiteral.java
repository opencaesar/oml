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
 * A representation of the model object '<em><b>Double Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * DoubleLiteral is a [=literal=] that represents a 64-bit double precision floating point value.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.DoubleLiteral#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getDoubleLiteral()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Literals'"
 * @generated
 */
public interface DoubleLiteral extends Literal {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The double value of this literal
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Double)
	 * @see io.opencaesar.oml.OmlPackage#getDoubleLiteral_Value()
	 * @model default="0.0" unique="false" dataType="io.opencaesar.oml.Double"
	 * @generated
	 */
	Double getValue();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.DoubleLiteral#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Double value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	String getTypeIri();

} // DoubleLiteral
