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
 * A representation of the model object '<em><b>Relation Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * RelationRestrictionAxiom is an axiom that places some restriction on a relation in the context of
 * a restricting classifier domain. It can be specified directly on the classifier or indirectly on a reference to it.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.RelationRestrictionAxiom#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getRelationRestrictionAxiom()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Axioms'"
 * @generated
 */
public interface RelationRestrictionAxiom extends PropertyRestrictionAxiom {
	/**
	 * Returns the value of the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The restricted relation specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Property</em>' reference.
	 * @see #setProperty(Relation)
	 * @see io.opencaesar.oml.OmlPackage#getRelationRestrictionAxiom_Property()
	 * @model required="true"
	 * @generated
	 */
	Relation getProperty();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationRestrictionAxiom#getProperty <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(Relation value);

} // RelationRestrictionAxiom
