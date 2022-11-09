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
 * A representation of the model object '<em><b>Concept Type Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ConceptTypeAssertion is a type assertion specifying a type for a concept instance. It can be specified directly on an
 * concept instance, or indirectly on a reference to one.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.ConceptTypeAssertion#getType <em>Type</em>}</li>
 *   <li>{@link io.opencaesar.oml.ConceptTypeAssertion#getOwningInstance <em>Owning Instance</em>}</li>
 *   <li>{@link io.opencaesar.oml.ConceptTypeAssertion#getOwningReference <em>Owning Reference</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getConceptTypeAssertion()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Assertions'"
 * @generated
 */
public interface ConceptTypeAssertion extends TypeAssertion {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The concept specified as the type of the instance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Concept)
	 * @see io.opencaesar.oml.OmlPackage#getConceptTypeAssertion_Type()
	 * @model required="true"
	 * @generated
	 */
	Concept getType();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.ConceptTypeAssertion#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Concept value);

	/**
	 * Returns the value of the '<em><b>Owning Instance</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.ConceptInstance#getOwnedTypes <em>Owned Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The instance that this type assertion is about
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Instance</em>' container reference.
	 * @see #setOwningInstance(ConceptInstance)
	 * @see io.opencaesar.oml.OmlPackage#getConceptTypeAssertion_OwningInstance()
	 * @see io.opencaesar.oml.ConceptInstance#getOwnedTypes
	 * @model opposite="ownedTypes" transient="false"
	 * @generated
	 */
	ConceptInstance getOwningInstance();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.ConceptTypeAssertion#getOwningInstance <em>Owning Instance</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Instance</em>' container reference.
	 * @see #getOwningInstance()
	 * @generated
	 */
	void setOwningInstance(ConceptInstance value);

	/**
	 * Returns the value of the '<em><b>Owning Reference</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.ConceptInstanceReference#getOwnedTypes <em>Owned Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The reference to a concept instance that this type assertion is about
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Reference</em>' container reference.
	 * @see #setOwningReference(ConceptInstanceReference)
	 * @see io.opencaesar.oml.OmlPackage#getConceptTypeAssertion_OwningReference()
	 * @see io.opencaesar.oml.ConceptInstanceReference#getOwnedTypes
	 * @model opposite="ownedTypes" transient="false"
	 * @generated
	 */
	ConceptInstanceReference getOwningReference();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.ConceptTypeAssertion#getOwningReference <em>Owning Reference</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Reference</em>' container reference.
	 * @see #getOwningReference()
	 * @generated
	 */
	void setOwningReference(ConceptInstanceReference value);

} // ConceptTypeAssertion
