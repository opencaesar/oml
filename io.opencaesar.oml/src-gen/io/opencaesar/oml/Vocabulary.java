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
 * A representation of the model object '<em><b>Vocabulary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Vocabulary is a vocabulary box that allows making statements about its own terms and rules
 * or about others that are imported.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.Vocabulary#getOwnedImports <em>Owned Imports</em>}</li>
 *   <li>{@link io.opencaesar.oml.Vocabulary#getOwnedStatements <em>Owned Statements</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getVocabulary()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Vocabularies'"
 * @generated
 */
public interface Vocabulary extends VocabularyBox {
	/**
	 * Returns the value of the '<em><b>Owned Imports</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.VocabularyImport}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.VocabularyImport#getOwningVocabulary <em>Owning Vocabulary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of imports this vocabulary has to other ontologies
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Imports</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getVocabulary_OwnedImports()
	 * @see io.opencaesar.oml.VocabularyImport#getOwningVocabulary
	 * @model opposite="owningVocabulary" containment="true"
	 * @generated
	 */
	EList<VocabularyImport> getOwnedImports();

	/**
	 * Returns the value of the '<em><b>Owned Statements</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.VocabularyStatement}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.VocabularyStatement#getOwningVocabulary <em>Owning Vocabulary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of statements contained by this vocabulary
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Statements</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getVocabulary_OwnedStatements()
	 * @see io.opencaesar.oml.VocabularyStatement#getOwningVocabulary
	 * @model opposite="owningVocabulary" containment="true"
	 * @generated
	 */
	EList<VocabularyStatement> getOwnedStatements();

} // Vocabulary
