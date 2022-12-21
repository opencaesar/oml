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
 * A representation of the model object '<em><b>Property Range Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * PropertyRangeRestrictionAxiom is a property restriction axiom that restricts the range of a property to
 * a type that specializes the original range. This restrictions may apply to all or to some values of the property
 * that have the restricting classifier as a domain.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.PropertyRangeRestrictionAxiom#getKind <em>Kind</em>}</li>
 *   <li>{@link io.opencaesar.oml.PropertyRangeRestrictionAxiom#getRange <em>Range</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getPropertyRangeRestrictionAxiom()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Axioms'"
 * @generated
 */
public interface PropertyRangeRestrictionAxiom extends PropertyRestrictionAxiom {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The default value is <code>"all"</code>.
	 * The literals are from the enumeration {@link io.opencaesar.oml.RangeRestrictionKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The range restriction kind specified by this axiom (default is all)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see io.opencaesar.oml.RangeRestrictionKind
	 * @see #setKind(RangeRestrictionKind)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyRangeRestrictionAxiom_Kind()
	 * @model default="all" unique="false" required="true"
	 * @generated
	 */
	RangeRestrictionKind getKind();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyRangeRestrictionAxiom#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see io.opencaesar.oml.RangeRestrictionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(RangeRestrictionKind value);

	/**
	 * Returns the value of the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The restricted range specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Range</em>' reference.
	 * @see #setRange(Type)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyRangeRestrictionAxiom_Range()
	 * @model required="true"
	 * @generated
	 */
	Type getRange();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyRangeRestrictionAxiom#getRange <em>Range</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' reference.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(Type value);

} // PropertyRangeRestrictionAxiom
