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
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Annotation is an element that specifies non-semantic information on an [=IdentifiedElement=].
 * An annotation is specified with an [=AnnotationProperty=] and [=Literal=] values or [=Member=] (referenced) values.
 * When no value is specified, the boolean literal `true` is assumed to be specified as a value.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.Annotation#getProperty <em>Property</em>}</li>
 *   <li>{@link io.opencaesar.oml.Annotation#getLiteralValue <em>Literal Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.Annotation#getReferencedValue <em>Referenced Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.Annotation#getOwningElement <em>Owning Element</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getAnnotation()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Elements'"
 * @generated
 */
public interface Annotation extends Element {
	/**
	 * Returns the value of the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The annotation property specified by this annotation
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Property</em>' reference.
	 * @see #setProperty(AnnotationProperty)
	 * @see io.opencaesar.oml.OmlPackage#getAnnotation_Property()
	 * @model required="true"
	 * @generated
	 */
	AnnotationProperty getProperty();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Annotation#getProperty <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(AnnotationProperty value);

	/**
	 * Returns the value of the '<em><b>Literal Value</b></em>' containment reference list.
	 * The list contents are of type {@link io.opencaesar.oml.Literal}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The literal values specified by this annotation
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Literal Value</em>' containment reference list.
	 * @see io.opencaesar.oml.OmlPackage#getAnnotation_LiteralValue()
	 * @model containment="true"
	 * @generated
	 */
	EList<Literal> getLiteralValue();

	/**
	 * Returns the value of the '<em><b>Referenced Value</b></em>' reference list.
	 * The list contents are of type {@link io.opencaesar.oml.Member}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referenced values (iris of members) specified by this annotation
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referenced Value</em>' reference list.
	 * @see io.opencaesar.oml.OmlPackage#getAnnotation_ReferencedValue()
	 * @model
	 * @generated
	 */
	EList<Member> getReferencedValue();

	/**
	 * Returns the value of the '<em><b>Owning Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.IdentifiedElement#getOwnedAnnotations <em>Owned Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The identified element that owns this annotation
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Element</em>' container reference.
	 * @see #setOwningElement(IdentifiedElement)
	 * @see io.opencaesar.oml.OmlPackage#getAnnotation_OwningElement()
	 * @see io.opencaesar.oml.IdentifiedElement#getOwnedAnnotations
	 * @model opposite="ownedAnnotations" transient="false"
	 * @generated
	 */
	IdentifiedElement getOwningElement();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Annotation#getOwningElement <em>Owning Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Element</em>' container reference.
	 * @see #getOwningElement()
	 * @generated
	 */
	void setOwningElement(IdentifiedElement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the values of the annotation
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<Element> getValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the identified element annotated by this annotation
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	IdentifiedElement getAnnotatedElement();

} // Annotation
