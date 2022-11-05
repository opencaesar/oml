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
 * A representation of the model object '<em><b>Quoted Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * QuotedLiteral is a literal that specifies its lexical value as a quoted string along with a language tag, a scalar type, or neither.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.QuotedLiteral#getValue <em>Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.QuotedLiteral#getLangTag <em>Lang Tag</em>}</li>
 *   <li>{@link io.opencaesar.oml.QuotedLiteral#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getQuotedLiteral()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Literals'"
 * @generated
 */
public interface QuotedLiteral extends Literal {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value of this literal represented as a string
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see io.opencaesar.oml.OmlPackage#getQuotedLiteral_Value()
	 * @model unique="false" required="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.QuotedLiteral#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Lang Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The langTag of this literal
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Lang Tag</em>' attribute.
	 * @see #setLangTag(String)
	 * @see io.opencaesar.oml.OmlPackage#getQuotedLiteral_LangTag()
	 * @model unique="false"
	 * @generated
	 */
	String getLangTag();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.QuotedLiteral#getLangTag <em>Lang Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lang Tag</em>' attribute.
	 * @see #getLangTag()
	 * @generated
	 */
	void setLangTag(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The scalar that is the type of this literal
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Scalar)
	 * @see io.opencaesar.oml.OmlPackage#getQuotedLiteral_Type()
	 * @model
	 * @generated
	 */
	Scalar getType();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.QuotedLiteral#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Scalar value);

} // QuotedLiteral
