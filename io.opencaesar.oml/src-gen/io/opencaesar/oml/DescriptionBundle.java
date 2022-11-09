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
 * A representation of the model object '<em><b>Description Bundle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * DescriptionBundle is a description box that allows importing other description boxes and flagging them
 * as a set that is analyzed together for consistency and satisfiabilty.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.DescriptionBundle#getOwnedImports <em>Owned Imports</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getDescriptionBundle()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Descriptions'"
 * @generated
 */
public interface DescriptionBundle extends DescriptionBox {
	/**
	 * Returns the value of the '<em><b>Owned Imports</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.DescriptionBundleImport}.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.DescriptionBundleImport#getOwningDescriptionBundle <em>Owning Description Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of imports this description bundle has of other descriptions
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Imports</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getDescriptionBundle_OwnedImports()
	 * @see io.opencaesar.oml.DescriptionBundleImport#getOwningDescriptionBundle
	 * @model opposite="owningDescriptionBundle" containment="true"
	 * @generated
	 */
	EList<DescriptionBundleImport> getOwnedImports();

} // DescriptionBundle
