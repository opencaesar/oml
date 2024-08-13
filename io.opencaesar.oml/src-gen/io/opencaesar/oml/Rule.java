/**
 * 
 * Copyright 2019-2022 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	 http://www.apache.org/licenses/LICENSE-2.0
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
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Rule is a [=member=] of a [=vocabulary=] that adds a new inference rule to the set supported natively by DL. A rule must specify a set of one or
 * more antecedent [=predicates=] that forms a conjunction that infers, when it holds, a set of one or more consequent [=predicates=].
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.Rule#getRef <em>Ref</em>}</li>
 *   <li>{@link io.opencaesar.oml.Rule#getAntecedent <em>Antecedent</em>}</li>
 *   <li>{@link io.opencaesar.oml.Rule#getConsequent <em>Consequent</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getRule()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Vocabularies'"
 * @generated
 */
public interface Rule extends VocabularyStatement {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A ref to another rule
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(Rule)
	 * @see io.opencaesar.oml.OmlPackage#getRule_Ref()
	 * @model
	 * @generated
	 */
	Rule getRef();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Rule#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(Rule value);

	/**
	 * Returns the value of the '<em><b>Antecedent</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.Predicate}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.Predicate#getAntecedentRule <em>Antecedent Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of predicates that form the antecedent of this rule
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Antecedent</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getRule_Antecedent()
	 * @see io.opencaesar.oml.Predicate#getAntecedentRule
	 * @model opposite="antecedentRule" containment="true"
	 * @generated
	 */
	EList<Predicate> getAntecedent();

	/**
	 * Returns the value of the '<em><b>Consequent</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.Predicate}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.Predicate#getConsequentRule <em>Consequent Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The predicate that is the consequent of this rule
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Consequent</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getRule_Consequent()
	 * @see io.opencaesar.oml.Predicate#getConsequentRule
	 * @model opposite="consequentRule" containment="true"
	 * @generated
	 */
	EList<Predicate> getConsequent();

} // Rule
