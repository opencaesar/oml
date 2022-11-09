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
 * A representation of the model object '<em><b>Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Predicate is an element that represents an ontology statement to match, when used in a rule's antecedent,
 * or to infer, when used in a rule's consequent.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.Predicate#getAntecedentRule <em>Antecedent Rule</em>}</li>
 *   <li>{@link io.opencaesar.oml.Predicate#getConsequentRule <em>Consequent Rule</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getPredicate()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Rules'"
 * @generated
 */
public interface Predicate extends Element {
	/**
	 * Returns the value of the '<em><b>Antecedent Rule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.Rule#getAntecedent <em>Antecedent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The rule that specifies this predicate in its antecedent
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Antecedent Rule</em>' container reference.
	 * @see #setAntecedentRule(Rule)
	 * @see io.opencaesar.oml.OmlPackage#getPredicate_AntecedentRule()
	 * @see io.opencaesar.oml.Rule#getAntecedent
	 * @model opposite="antecedent" transient="false"
	 * @generated
	 */
	Rule getAntecedentRule();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Predicate#getAntecedentRule <em>Antecedent Rule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Antecedent Rule</em>' container reference.
	 * @see #getAntecedentRule()
	 * @generated
	 */
	void setAntecedentRule(Rule value);

	/**
	 * Returns the value of the '<em><b>Consequent Rule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.Rule#getConsequent <em>Consequent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The rule that specifies this predicate in its consequent
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Consequent Rule</em>' container reference.
	 * @see #setConsequentRule(Rule)
	 * @see io.opencaesar.oml.OmlPackage#getPredicate_ConsequentRule()
	 * @see io.opencaesar.oml.Rule#getConsequent
	 * @model opposite="consequent" transient="false"
	 * @generated
	 */
	Rule getConsequentRule();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Predicate#getConsequentRule <em>Consequent Rule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consequent Rule</em>' container reference.
	 * @see #getConsequentRule()
	 * @generated
	 */
	void setConsequentRule(Rule value);

} // Predicate
