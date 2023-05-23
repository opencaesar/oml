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
 * A representation of the model object '<em><b>Property Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * PropertyPredicate is a [=BinaryPredicate=] that holds when its argument1 is bound to an [=NamedInstance=] and its argument2 is bound to a
 * a value of a given [=property=] on that instance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.PropertyPredicate#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getPropertyPredicate()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Predicates'"
 * @generated
 */
public interface PropertyPredicate extends BinaryPredicate {
	/**
	 * Returns the value of the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property of an instance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Property</em>' reference.
	 * @see #setProperty(Property)
	 * @see io.opencaesar.oml.OmlPackage#getPropertyPredicate_Property()
	 * @model required="true"
	 * @generated
	 */
	Property getProperty();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.PropertyPredicate#getProperty <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(Property value);

} // PropertyPredicate
