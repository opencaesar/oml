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
 * A representation of the model object '<em><b>Description Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * DescriptionStatement is a statement owned by a description.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.DescriptionStatement#getOwningDescription <em>Owning Description</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getDescriptionStatement()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Descriptions'"
 * @generated
 */
public interface DescriptionStatement extends Statement, DescriptionMember {
	/**
	 * Returns the value of the '<em><b>Owning Description</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.Description#getOwnedStatements <em>Owned Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The description that owns this statement
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Description</em>' container reference.
	 * @see #setOwningDescription(Description)
	 * @see io.opencaesar.oml.OmlPackage#getDescriptionStatement_OwningDescription()
	 * @see io.opencaesar.oml.Description#getOwnedStatements
	 * @model opposite="ownedStatements" required="true" transient="false"
	 * @generated
	 */
	Description getOwningDescription();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.DescriptionStatement#getOwningDescription <em>Owning Description</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Description</em>' container reference.
	 * @see #getOwningDescription()
	 * @generated
	 */
	void setOwningDescription(Description value);

} // DescriptionStatement
