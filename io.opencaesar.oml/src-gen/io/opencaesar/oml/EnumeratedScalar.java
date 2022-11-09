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
 * A representation of the model object '<em><b>Enumerated Scalar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * EnumeratedScalar is a scalar that represents a finite set of literals. It can specialize another enumerated scalar, but in
 * this case, it cannot define its own literals; rather, it will simply be considered an alias to the specialized scalar.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.EnumeratedScalar#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getEnumeratedScalar()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Types'"
 * @generated
 */
public interface EnumeratedScalar extends Scalar {
	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.Literal}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of enumerated literals that are represented by this scalar
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getEnumeratedScalar_Literals()
	 * @model containment="true"
	 * @generated
	 */
	EList<Literal> getLiterals();

} // EnumeratedScalar
