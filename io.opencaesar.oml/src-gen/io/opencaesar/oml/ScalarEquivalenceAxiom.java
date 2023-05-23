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
 * A representation of the model object '<em><b>Scalar Equivalence Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ScalarEquivalenceAxiom is an [=Axiom=] specified on a subject [=Scalar=] that states that it is equivalent to another
 * [=Scalar=]. When the equivalent scalar is one of the standard scalars (see {@link Scalar}), the equivalence may specify
 * some restriction facets. The applicable facets depend on the restricted standard scalar (see below).
 * 
 * This axiom implies that the subject scalar is a subtype of the equivalent scalar. When there are no facets specified,
 * then it also implies that the equivalent scalar is also a subtype of the subject scalar.
 * 
 * The following is the set of allowed facets for each standard scalar:
 * 
 * Numeric scalars (facets: minInclusive, maxInclusive, minExclusive, maxExclusive, literals):
 * Time scalars (facets: minInclusive, maxInclusive, minExclusive, maxExclusive, literals):
 * Plain scalars (facets: length, minLength, maxLength, pattern, language, literals):
 * String scalars (facets: length, minLength, maxLength, pattern, literals)
 * Binary scalars (facets: length, minLength, maxLength, literals):
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getSuperScalar <em>Super Scalar</em>}</li>
 *   <li>{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getOwningScalar <em>Owning Scalar</em>}</li>
 *   <li>{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getLength <em>Length</em>}</li>
 *   <li>{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getPattern <em>Pattern</em>}</li>
 *   <li>{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getLanguage <em>Language</em>}</li>
 *   <li>{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getMaxExclusive <em>Max Exclusive</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getScalarEquivalenceAxiom()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Axioms'"
 * @generated
 */
public interface ScalarEquivalenceAxiom extends Axiom {
	/**
	 * Returns the value of the '<em><b>Super Scalar</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The super scalar specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Super Scalar</em>' reference.
	 * @see #setSuperScalar(Scalar)
	 * @see io.opencaesar.oml.OmlPackage#getScalarEquivalenceAxiom_SuperScalar()
	 * @model required="true"
	 * @generated
	 */
	Scalar getSuperScalar();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getSuperScalar <em>Super Scalar</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Scalar</em>' reference.
	 * @see #getSuperScalar()
	 * @generated
	 */
	void setSuperScalar(Scalar value);

	/**
	 * Returns the value of the '<em><b>Owning Scalar</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.Scalar#getOwnedEquivalences <em>Owned Equivalences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The owning scalar specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Scalar</em>' container reference.
	 * @see #setOwningScalar(Scalar)
	 * @see io.opencaesar.oml.OmlPackage#getScalarEquivalenceAxiom_OwningScalar()
	 * @see io.opencaesar.oml.Scalar#getOwnedEquivalences
	 * @model opposite="ownedEquivalences" required="true" transient="false"
	 * @generated
	 */
	Scalar getOwningScalar();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getOwningScalar <em>Owning Scalar</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Scalar</em>' container reference.
	 * @see #getOwningScalar()
	 * @generated
	 */
	void setOwningScalar(Scalar value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The exact length of the literals of this scalar
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(Long)
	 * @see io.opencaesar.oml.OmlPackage#getScalarEquivalenceAxiom_Length()
	 * @model unique="false" dataType="io.opencaesar.oml.UnsignedInteger"
	 * @generated
	 */
	Long getLength();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(Long value);

	/**
	 * Returns the value of the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum length of the literals of this scalar
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Length</em>' attribute.
	 * @see #setMinLength(Long)
	 * @see io.opencaesar.oml.OmlPackage#getScalarEquivalenceAxiom_MinLength()
	 * @model unique="false" dataType="io.opencaesar.oml.UnsignedInteger"
	 * @generated
	 */
	Long getMinLength();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getMinLength <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Length</em>' attribute.
	 * @see #getMinLength()
	 * @generated
	 */
	void setMinLength(Long value);

	/**
	 * Returns the value of the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum length of the literals of this scalar
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Length</em>' attribute.
	 * @see #setMaxLength(Long)
	 * @see io.opencaesar.oml.OmlPackage#getScalarEquivalenceAxiom_MaxLength()
	 * @model unique="false" dataType="io.opencaesar.oml.UnsignedInteger"
	 * @generated
	 */
	Long getMaxLength();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getMaxLength <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Length</em>' attribute.
	 * @see #getMaxLength()
	 * @generated
	 */
	void setMaxLength(Long value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The pattern that the literals of this scalar conforms to
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see #setPattern(String)
	 * @see io.opencaesar.oml.OmlPackage#getScalarEquivalenceAxiom_Pattern()
	 * @model unique="false"
	 * @generated
	 */
	String getPattern();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(String value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The language range that the literals of this scalar belong to
	 * (based on http://www.rfc-editor.org/rfc/bcp/bcp47.txt)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see #setLanguage(String)
	 * @see io.opencaesar.oml.OmlPackage#getScalarEquivalenceAxiom_Language()
	 * @model unique="false"
	 * @generated
	 */
	String getLanguage();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Min Inclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum inclusive value of numeric literals of this scalar
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Inclusive</em>' containment reference.
	 * @see #setMinInclusive(Literal)
	 * @see io.opencaesar.oml.OmlPackage#getScalarEquivalenceAxiom_MinInclusive()
	 * @model containment="true"
	 * @generated
	 */
	Literal getMinInclusive();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getMinInclusive <em>Min Inclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Inclusive</em>' containment reference.
	 * @see #getMinInclusive()
	 * @generated
	 */
	void setMinInclusive(Literal value);

	/**
	 * Returns the value of the '<em><b>Min Exclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum exclusive value of numeric literals of this scalar
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Exclusive</em>' containment reference.
	 * @see #setMinExclusive(Literal)
	 * @see io.opencaesar.oml.OmlPackage#getScalarEquivalenceAxiom_MinExclusive()
	 * @model containment="true"
	 * @generated
	 */
	Literal getMinExclusive();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getMinExclusive <em>Min Exclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Exclusive</em>' containment reference.
	 * @see #getMinExclusive()
	 * @generated
	 */
	void setMinExclusive(Literal value);

	/**
	 * Returns the value of the '<em><b>Max Inclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum inclusive value of numeric literals of this scalar
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Inclusive</em>' containment reference.
	 * @see #setMaxInclusive(Literal)
	 * @see io.opencaesar.oml.OmlPackage#getScalarEquivalenceAxiom_MaxInclusive()
	 * @model containment="true"
	 * @generated
	 */
	Literal getMaxInclusive();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getMaxInclusive <em>Max Inclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Inclusive</em>' containment reference.
	 * @see #getMaxInclusive()
	 * @generated
	 */
	void setMaxInclusive(Literal value);

	/**
	 * Returns the value of the '<em><b>Max Exclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum exclusive value of numeric literals of this scalar
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Exclusive</em>' containment reference.
	 * @see #setMaxExclusive(Literal)
	 * @see io.opencaesar.oml.OmlPackage#getScalarEquivalenceAxiom_MaxExclusive()
	 * @model containment="true"
	 * @generated
	 */
	Literal getMaxExclusive();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getMaxExclusive <em>Max Exclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Exclusive</em>' containment reference.
	 * @see #getMaxExclusive()
	 * @generated
	 */
	void setMaxExclusive(Literal value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the sub scalar of this axiom
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Scalar getSubScalar();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Scalar getCharacterizedTerm();

} // ScalarEquivalenceAxiom
