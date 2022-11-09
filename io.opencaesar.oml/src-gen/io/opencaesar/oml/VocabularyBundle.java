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
 * A representation of the model object '<em><b>Vocabulary Bundle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * VocabularyBundle is a vocabulary box that allows importing other vocabulary boxes and flagging them
 * as disjoint from one another.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.VocabularyBundle#getOwnedImports <em>Owned Imports</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getVocabularyBundle()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Vocabularies'"
 * @generated
 */
public interface VocabularyBundle extends VocabularyBox {
	/**
	 * Returns the value of the '<em><b>Owned Imports</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.VocabularyBundleImport}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.VocabularyBundleImport#getOwningVocabularyBundle <em>Owning Vocabulary Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of imports this vocabulary bundle has of other vocabularies
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Imports</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getVocabularyBundle_OwnedImports()
	 * @see io.opencaesar.oml.VocabularyBundleImport#getOwningVocabularyBundle
	 * @model opposite="owningVocabularyBundle" containment="true"
	 * @generated
	 */
	EList<VocabularyBundleImport> getOwnedImports();

} // VocabularyBundle
