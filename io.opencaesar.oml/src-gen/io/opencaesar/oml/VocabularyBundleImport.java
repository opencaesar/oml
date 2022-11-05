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
 * A representation of the model object '<em><b>Vocabulary Bundle Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * VocabularyBundleImport is an import owned by a vocabulary bundle.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.VocabularyBundleImport#getOwningVocabularyBundle <em>Owning Vocabulary Bundle</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getVocabularyBundleImport()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Vocabularies'"
 * @generated
 */
public interface VocabularyBundleImport extends Import {
	/**
	 * Returns the value of the '<em><b>Owning Vocabulary Bundle</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.VocabularyBundle#getOwnedImports <em>Owned Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The vocabulary bundle that contains this import
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Vocabulary Bundle</em>' container reference.
	 * @see #setOwningVocabularyBundle(VocabularyBundle)
	 * @see io.opencaesar.oml.OmlPackage#getVocabularyBundleImport_OwningVocabularyBundle()
	 * @see io.opencaesar.oml.VocabularyBundle#getOwnedImports
	 * @model opposite="ownedImports" required="true" transient="false"
	 * @generated
	 */
	VocabularyBundle getOwningVocabularyBundle();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.VocabularyBundleImport#getOwningVocabularyBundle <em>Owning Vocabulary Bundle</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Vocabulary Bundle</em>' container reference.
	 * @see #getOwningVocabularyBundle()
	 * @generated
	 */
	void setOwningVocabularyBundle(VocabularyBundle value);

} // VocabularyBundleImport
