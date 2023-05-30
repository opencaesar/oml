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
 * A representation of the model object '<em><b>Structured Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * StructuredProperty is a [=SemanticProperty=] whose range is a [=Structure=]. It can specialize other [=StructuredProperties=].
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.StructuredProperty#getRef <em>Ref</em>}</li>
 *   <li>{@link io.opencaesar.oml.StructuredProperty#isFunctional <em>Functional</em>}</li>
 *   <li>{@link io.opencaesar.oml.StructuredProperty#getDomains <em>Domains</em>}</li>
 *   <li>{@link io.opencaesar.oml.StructuredProperty#getRanges <em>Ranges</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getStructuredProperty()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Properties'"
 * @generated
 */
public interface StructuredProperty extends SemanticProperty, SpecializableProperty {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A ref to another structured property
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(StructuredProperty)
	 * @see io.opencaesar.oml.OmlPackage#getStructuredProperty_Ref()
	 * @model
	 * @generated
	 */
	StructuredProperty getRef();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.StructuredProperty#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(StructuredProperty value);

	/**
	 * Returns the value of the '<em><b>Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this property is functional (has a max of one value per instance)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Functional</em>' attribute.
	 * @see #setFunctional(boolean)
	 * @see io.opencaesar.oml.OmlPackage#getStructuredProperty_Functional()
	 * @model unique="false"
	 * @generated
	 */
	boolean isFunctional();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.StructuredProperty#isFunctional <em>Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Functional</em>' attribute.
	 * @see #isFunctional()
	 * @generated
	 */
	void setFunctional(boolean value);

	/**
	 * Returns the value of the '<em><b>Domains</b></em>' reference list.
	 * The list contents are of type {@link io.opencaesar.oml.Classifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The classifiers that are the domains of this property
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domains</em>' reference list.
	 * @see io.opencaesar.oml.OmlPackage#getStructuredProperty_Domains()
	 * @model
	 * @generated
	 */
	EList<Classifier> getDomains();

	/**
	 * Returns the value of the '<em><b>Ranges</b></em>' reference list.
	 * The list contents are of type {@link io.opencaesar.oml.Structure}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The structures that are the range of this property
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ranges</em>' reference list.
	 * @see io.opencaesar.oml.OmlPackage#getStructuredProperty_Ranges()
	 * @model
	 * @generated
	 */
	EList<Structure> getRanges();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<Classifier> getDomainList();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<Type> getRangeList();

} // StructuredProperty
