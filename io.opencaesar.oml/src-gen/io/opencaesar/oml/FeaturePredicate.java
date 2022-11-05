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
 * A representation of the model object '<em><b>Feature Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * FeaturePredicate is a binary predicate that binds its `variable1` to an instance (subject), and either its
 *  `variable2`, `instance2`, or `literal2` as the value (object) of a specific feature (predicate).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.FeaturePredicate#getFeature <em>Feature</em>}</li>
 *   <li>{@link io.opencaesar.oml.FeaturePredicate#getLiteral2 <em>Literal2</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getFeaturePredicate()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Rules'"
 * @generated
 */
public interface FeaturePredicate extends BinaryPredicate {
	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The feature of the named instance whose value is bound or matched
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(Feature)
	 * @see io.opencaesar.oml.OmlPackage#getFeaturePredicate_Feature()
	 * @model required="true"
	 * @generated
	 */
	Feature getFeature();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.FeaturePredicate#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(Feature value);

	/**
	 * Returns the value of the '<em><b>Literal2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The optional literal2 that is matched as a value of the feature
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Literal2</em>' containment reference.
	 * @see #setLiteral2(Literal)
	 * @see io.opencaesar.oml.OmlPackage#getFeaturePredicate_Literal2()
	 * @model containment="true"
	 * @generated
	 */
	Literal getLiteral2();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.FeaturePredicate#getLiteral2 <em>Literal2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal2</em>' containment reference.
	 * @see #getLiteral2()
	 * @generated
	 */
	void setLiteral2(Literal value);

} // FeaturePredicate
