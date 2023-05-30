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
 * A representation of the model object '<em><b>Scalar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Scalar is a primitive [=type=] that represents a set of [=literals=]. Some scalars are considered standard (see below).
 * 
 * A standard scalar can have specialization axioms to other standard scalars.
 * 
 * Non-standard scalars cannot have specialization axioms, but can have scalar equivalence axioms.
 * 
 * The standard scalars are:
 * 
 * <i>Numeric scalars</i>:
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
 * <i>Time scalars</i>:
 * xsd:dateTime
 * xsd:dateTimeStamp
 * 
 * <i>Plain scalars</i>:
 * rdf:PlainLiteral
 * <i>String scalars</i>:
 * xsd:string,
 * xsd:normalizedString,
 * xsd:token,
 * xsd:language,
 * xsd:Name,
 * xsd:NCName,
 * xsd:NMTOKEN
 * xsd:anyURI
 * 
 * <i>Boolean scalars</i>:
 * xsd:boolean
 * 
 * </i>Binary scalars}</i>:
 * xsd:hexBinary
 * xsd:base64Binary
 * 
 * <i>XML scalars</i>:
 * rdf:XMLLiteral
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.Scalar#getRef <em>Ref</em>}</li>
 *   <li>{@link io.opencaesar.oml.Scalar#getOwnedEnumeration <em>Owned Enumeration</em>}</li>
 *   <li>{@link io.opencaesar.oml.Scalar#getOwnedEquivalences <em>Owned Equivalences</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getScalar()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Types'"
 * @generated
 */
public interface Scalar extends Type {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A ref to another scalar
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(Scalar)
	 * @see io.opencaesar.oml.OmlPackage#getScalar_Ref()
	 * @model
	 * @generated
	 */
	Scalar getRef();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Scalar#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(Scalar value);

	/**
	 * Returns the value of the '<em><b>Owned Enumeration</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.LiteralEnumerationAxiom#getOwningScalar <em>Owning Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An enumeration of literals of this scalar
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Enumeration</em>' containment reference.
	 * @see #setOwnedEnumeration(LiteralEnumerationAxiom)
	 * @see io.opencaesar.oml.OmlPackage#getScalar_OwnedEnumeration()
	 * @see io.opencaesar.oml.LiteralEnumerationAxiom#getOwningScalar
	 * @model opposite="owningScalar" containment="true"
	 * @generated
	 */
	LiteralEnumerationAxiom getOwnedEnumeration();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Scalar#getOwnedEnumeration <em>Owned Enumeration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Enumeration</em>' containment reference.
	 * @see #getOwnedEnumeration()
	 * @generated
	 */
	void setOwnedEnumeration(LiteralEnumerationAxiom value);

	/**
	 * Returns the value of the '<em><b>Owned Equivalences</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.ScalarEquivalenceAxiom}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.ScalarEquivalenceAxiom#getOwningScalar <em>Owning Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of scalar equivalence axioms of this scalar
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Equivalences</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getScalar_OwnedEquivalences()
	 * @see io.opencaesar.oml.ScalarEquivalenceAxiom#getOwningScalar
	 * @model opposite="owningScalar" containment="true"
	 * @generated
	 */
	EList<ScalarEquivalenceAxiom> getOwnedEquivalences();

} // Scalar
