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
 * A representation of the model object '<em><b>Property Cardinality Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * PropertyCardinalityRestrictionAxiom is a property restriction axiom that restricts the cardinality of a property
 * to an exact value, a minimum value or a maximum value. This restrictions can apply either to all values of the property
 * in the restricting classifier, or only to those values classified by a specific subtype of the range.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.PropertyCardinalityRestrictionAxiom#getKind <em>Kind</em>}</li>
 *   <li>{@link io.opencaesar.oml.PropertyCardinalityRestrictionAxiom#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link io.opencaesar.oml.PropertyCardinalityRestrictionAxiom#getRange <em>Range</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getPropertyCardinalityRestrictionAxiom()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Axioms'"
 * @generated
 */
public interface PropertyCardinalityRestrictionAxiom extends PropertyRestrictionAxiom {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The default value is <code>"exactly"</code>.
	 * The literals are from the enumeration {@link io.opencaesar.oml.CardinalityRestrictionKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The kind of cardinality restriction specified by this axiom (default is exactly)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see io.opencaesar.oml.CardinalityRestrictionKind
	 * @see #setKind(CardinalityRestrictionKind)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyCardinalityRestrictionAxiom_Kind()
	 * @model default="exactly" unique="false" required="true"
	 * @generated
	 */
	CardinalityRestrictionKind getKind();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyCardinalityRestrictionAxiom#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see io.opencaesar.oml.CardinalityRestrictionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(CardinalityRestrictionKind value);

	/**
	 * Returns the value of the '<em><b>Cardinality</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value of the cardinality specified by this axiom (default is 1)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cardinality</em>' attribute.
	 * @see #setCardinality(long)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyCardinalityRestrictionAxiom_Cardinality()
	 * @model default="1" unique="false" dataType="io.opencaesar.oml.UnsignedInt" required="true"
	 * @generated
	 */
	long getCardinality();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyCardinalityRestrictionAxiom#getCardinality <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinality</em>' attribute.
	 * @see #getCardinality()
	 * @generated
	 */
	void setCardinality(long value);

	/**
	 * Returns the value of the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The optional restricted range specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Range</em>' reference.
	 * @see #setRange(Type)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyCardinalityRestrictionAxiom_Range()
	 * @model
	 * @generated
	 */
	Type getRange();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyCardinalityRestrictionAxiom#getRange <em>Range</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' reference.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(Type value);

} // PropertyCardinalityRestrictionAxiom
