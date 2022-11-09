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
 * A representation of the model object '<em><b>Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Classifier is a type that classifies a set of instances and characterizes them with properties
 * (i.e., becomes a domain of these properties). It also inherits properties in the domain of its specialized
 * types. In addition, it can specify constraints on (direct or inherited) properties in its domain.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.Classifier#getOwnedPropertyRestrictions <em>Owned Property Restrictions</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getClassifier()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Types'"
 * @generated
 */
public interface Classifier extends Type {
	/**
	 * Returns the value of the '<em><b>Owned Property Restrictions</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.PropertyRestrictionAxiom}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.PropertyRestrictionAxiom#getOwningClassifier <em>Owning Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of restriction axioms on properties of this classifier
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Property Restrictions</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getClassifier_OwnedPropertyRestrictions()
	 * @see io.opencaesar.oml.PropertyRestrictionAxiom#getOwningClassifier
	 * @model opposite="owningClassifier" containment="true"
	 * @generated
	 */
	EList<PropertyRestrictionAxiom> getOwnedPropertyRestrictions();

} // Classifier
