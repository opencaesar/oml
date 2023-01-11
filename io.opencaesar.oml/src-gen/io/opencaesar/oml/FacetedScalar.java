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
 * A representation of the model object '<em><b>Faceted Scalar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * FacetedScalar is a scalar that represents a (possibly infinite) set of literals and can constrain them with some facets. It
 * can also specialize other faceted scalars. OML considers some faceted scalars, those defined by the OWL2 specification
 * (https://www.w3.org/TR/owl2-syntax/#Datatype_Maps) and listed below, as standard. Other non-standard scalars can specialize directly
 * or transitively from this standard set and optionally specify facets (restrictions on their lexical or value spaces).
 * A scalar that specifies facets can only have a single supertype, which must be a standard one. Otherwise, it must have at least one
 * supertype that is considered to be an alias.
 * 
 * Numeric scalars (facets: minInclusive, maxInclusive, minExclusive, maxExclusive):
 * owl:real
 * owl:rational
 * xsd:decimal
 * xsd:integer
 * xsd:nonNegativeInteger
 * xsd:nonPositiveInteger
 * xsd:positiveInteger
 * xsd:negativeInteger
 * xsd:long
 * xsd:int
 * xsd:short
 * xsd:byte
 * xsd:unsignedLong
 * xsd:unsignedInt
 * xsd:unsignedShort
 * xsd:unsignedByte
 * xsd:double
 * xsd:float
 * 
 * Time scalars (facets: minInclusive, maxInclusive, minExclusive, maxExclusive):
 * xsd:dateTime
 * xsd:dateTimeStamp
 * 
 * Plain scalars (facets: length, minLength, maxLength, pattern, language):
 * rdf:PlainLiteral
 * String scalars (facets: length, minLength, maxLength, pattern)
 * xsd:string,
 * xsd:normalizedString,
 * xsd:token,
 * xsd:language,
 * xsd:Name,
 * xsd:NCName,
 * xsd:NMTOKEN
 * xsd:anyURI
 * 
 * Boolean scalars (no facets):
 * xsd:boolean
 * 
 * Binary scalars (facets: length, minLength, maxLength):
 * xsd:hexBinary
 * xsd:base64Binary
 * 
 * XML scalars (no facets):
 * rdf:XMLLiteral
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.FacetedScalar#getRef <em>Ref</em>}</li>
 *   <li>{@link io.opencaesar.oml.FacetedScalar#getLength <em>Length</em>}</li>
 *   <li>{@link io.opencaesar.oml.FacetedScalar#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link io.opencaesar.oml.FacetedScalar#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link io.opencaesar.oml.FacetedScalar#getPattern <em>Pattern</em>}</li>
 *   <li>{@link io.opencaesar.oml.FacetedScalar#getLanguage <em>Language</em>}</li>
 *   <li>{@link io.opencaesar.oml.FacetedScalar#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link io.opencaesar.oml.FacetedScalar#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link io.opencaesar.oml.FacetedScalar#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link io.opencaesar.oml.FacetedScalar#getMaxExclusive <em>Max Exclusive</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getFacetedScalar()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Types'"
 * @generated
 */
public interface FacetedScalar extends Scalar {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A ref to another faceted scalar
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(FacetedScalar)
	 * @see io.opencaesar.oml.OmlPackage#getFacetedScalar_Ref()
	 * @model
	 * @generated
	 */
	FacetedScalar getRef();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.FacetedScalar#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(FacetedScalar value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The exact length of the literals of this scalar
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(Long)
	 * @see io.opencaesar.oml.OmlPackage#getFacetedScalar_Length()
	 * @model unique="false" dataType="io.opencaesar.oml.UnsignedInteger"
	 * @generated
	 */
	Long getLength();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.FacetedScalar#getLength <em>Length</em>}' attribute.
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
	 * @see io.opencaesar.oml.OmlPackage#getFacetedScalar_MinLength()
	 * @model unique="false" dataType="io.opencaesar.oml.UnsignedInteger"
	 * @generated
	 */
	Long getMinLength();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.FacetedScalar#getMinLength <em>Min Length</em>}' attribute.
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
	 * @see io.opencaesar.oml.OmlPackage#getFacetedScalar_MaxLength()
	 * @model unique="false" dataType="io.opencaesar.oml.UnsignedInteger"
	 * @generated
	 */
	Long getMaxLength();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.FacetedScalar#getMaxLength <em>Max Length</em>}' attribute.
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
	 * @see io.opencaesar.oml.OmlPackage#getFacetedScalar_Pattern()
	 * @model unique="false"
	 * @generated
	 */
	String getPattern();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.FacetedScalar#getPattern <em>Pattern</em>}' attribute.
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
	 * @see io.opencaesar.oml.OmlPackage#getFacetedScalar_Language()
	 * @model unique="false"
	 * @generated
	 */
	String getLanguage();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.FacetedScalar#getLanguage <em>Language</em>}' attribute.
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
	 * @see io.opencaesar.oml.OmlPackage#getFacetedScalar_MinInclusive()
	 * @model containment="true"
	 * @generated
	 */
	Literal getMinInclusive();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.FacetedScalar#getMinInclusive <em>Min Inclusive</em>}' containment reference.
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
	 * @see io.opencaesar.oml.OmlPackage#getFacetedScalar_MinExclusive()
	 * @model containment="true"
	 * @generated
	 */
	Literal getMinExclusive();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.FacetedScalar#getMinExclusive <em>Min Exclusive</em>}' containment reference.
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
	 * @see io.opencaesar.oml.OmlPackage#getFacetedScalar_MaxInclusive()
	 * @model containment="true"
	 * @generated
	 */
	Literal getMaxInclusive();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.FacetedScalar#getMaxInclusive <em>Max Inclusive</em>}' containment reference.
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
	 * @see io.opencaesar.oml.OmlPackage#getFacetedScalar_MaxExclusive()
	 * @model containment="true"
	 * @generated
	 */
	Literal getMaxExclusive();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.FacetedScalar#getMaxExclusive <em>Max Exclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Exclusive</em>' containment reference.
	 * @see #getMaxExclusive()
	 * @generated
	 */
	void setMaxExclusive(Literal value);

} // FacetedScalar
