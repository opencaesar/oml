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
 * A representation of the model object '<em><b>Faceted Scalar Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * FacetedScalarReference is a reference to a faceted scalar.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.FacetedScalarReference#getScalar <em>Scalar</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getFacetedScalarReference()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='References'"
 * @generated
 */
public interface FacetedScalarReference extends SpecializableTermReference {
	/**
	 * Returns the value of the '<em><b>Scalar</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The faceted scalar referenced by this reference
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Scalar</em>' reference.
	 * @see #setScalar(FacetedScalar)
	 * @see io.opencaesar.oml.OmlPackage#getFacetedScalarReference_Scalar()
	 * @model required="true"
	 * @generated
	 */
	FacetedScalar getScalar();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.FacetedScalarReference#getScalar <em>Scalar</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scalar</em>' reference.
	 * @see #getScalar()
	 * @generated
	 */
	void setScalar(FacetedScalar value);

} // FacetedScalarReference
