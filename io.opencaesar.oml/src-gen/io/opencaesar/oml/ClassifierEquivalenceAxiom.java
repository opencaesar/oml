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
 * A representation of the model object '<em><b>Classifier Equivalence Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ClassifierEquivalenceAxiom is an axiom specified on a classifier that states that it is equivalent to the intersection of named classifiers
 * and property restrictions. This axiom implies that the named classifiers are super types of the subject classifier. It also implies
 * that when an instance is classified by this intersection, then it follows that it is also classified by the subject classifier.
 * Conversely, when an instance is classified by the subject classifier, then it follows that it is also classified by the intersection.
 * In other words, this axiom enables bi-directional (or two-way) inferencing.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.ClassifierEquivalenceAxiom#getSuperClassifiers <em>Super Classifiers</em>}</li>
 *   <li>{@link io.opencaesar.oml.ClassifierEquivalenceAxiom#getOwnedPropertyRestrictions <em>Owned Property Restrictions</em>}</li>
 *   <li>{@link io.opencaesar.oml.ClassifierEquivalenceAxiom#getOwningClassifier <em>Owning Classifier</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getClassifierEquivalenceAxiom()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Axioms'"
 * @generated
 */
public interface ClassifierEquivalenceAxiom extends Axiom {
	/**
	 * Returns the value of the '<em><b>Super Classifiers</b></em>' reference list.
	 * The list contents are of type {@link io.opencaesar.oml.Classifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The super classifiers specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Super Classifiers</em>' reference list.
	 * @see io.opencaesar.oml.OmlPackage#getClassifierEquivalenceAxiom_SuperClassifiers()
	 * @model
	 * @generated
	 */
	EList<Classifier> getSuperClassifiers();

	/**
	 * Returns the value of the '<em><b>Owned Property Restrictions</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.PropertyRestrictionAxiom}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.PropertyRestrictionAxiom#getOwningAxiom <em>Owning Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property restrictions specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Property Restrictions</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getClassifierEquivalenceAxiom_OwnedPropertyRestrictions()
	 * @see io.opencaesar.oml.PropertyRestrictionAxiom#getOwningAxiom
	 * @model opposite="owningAxiom" containment="true"
	 * @generated
	 */
	EList<PropertyRestrictionAxiom> getOwnedPropertyRestrictions();

	/**
	 * Returns the value of the '<em><b>Owning Classifier</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.Classifier#getOwnedEquivalences <em>Owned Equivalences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The owning classifier specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Classifier</em>' container reference.
	 * @see #setOwningClassifier(Classifier)
	 * @see io.opencaesar.oml.OmlPackage#getClassifierEquivalenceAxiom_OwningClassifier()
	 * @see io.opencaesar.oml.Classifier#getOwnedEquivalences
	 * @model opposite="ownedEquivalences" transient="false"
	 * @generated
	 */
	Classifier getOwningClassifier();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.ClassifierEquivalenceAxiom#getOwningClassifier <em>Owning Classifier</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Classifier</em>' container reference.
	 * @see #getOwningClassifier()
	 * @generated
	 */
	void setOwningClassifier(Classifier value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the sub classifier of this axiom
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Classifier getSubClassifier();

} // ClassifierEquivalenceAxiom
