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
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Annotation is an element that specifies additional non-semantic statements on an annotated element. It can also be
 * specified on a reference to an ontology member, in which case it is interpreted as if it was specified on the
 * member itself. An annotation is specified with an annotation property and a (literal or reference) value. When
 * no value is specified, it is interpreted as the `true` boolean literal.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.Annotation#getProperty <em>Property</em>}</li>
 *   <li>{@link io.opencaesar.oml.Annotation#getLiteralValue <em>Literal Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.Annotation#getReferenceValue <em>Reference Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.Annotation#getOwningElement <em>Owning Element</em>}</li>
 *   <li>{@link io.opencaesar.oml.Annotation#getOwningReference <em>Owning Reference</em>}</li>
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
	 * Returns the value of the '<em><b>Literal Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A literal value specified by this annotation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Literal Value</em>' containment reference.
	 * @see #setLiteralValue(Literal)
	 * @see io.opencaesar.oml.OmlPackage#getAnnotation_LiteralValue()
	 * @model containment="true"
	 * @generated
	 */
	Literal getLiteralValue();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Annotation#getLiteralValue <em>Literal Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal Value</em>' containment reference.
	 * @see #getLiteralValue()
	 * @generated
	 */
	void setLiteralValue(Literal value);

	/**
	 * Returns the value of the '<em><b>Reference Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A reference (to a member) value specified by this annotation
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reference Value</em>' reference.
	 * @see #setReferenceValue(Member)
	 * @see io.opencaesar.oml.OmlPackage#getAnnotation_ReferenceValue()
	 * @model
	 * @generated
	 */
	Member getReferenceValue();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Annotation#getReferenceValue <em>Reference Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Value</em>' reference.
	 * @see #getReferenceValue()
	 * @generated
	 */
	void setReferenceValue(Member value);

	/**
	 * Returns the value of the '<em><b>Owning Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.IdentifiedElement#getOwnedAnnotations <em>Owned Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The annotated element that owns this annotation
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
	 * Returns the value of the '<em><b>Owning Reference</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.Reference#getOwnedAnnotations <em>Owned Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The reference that owns this annotation
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Reference</em>' container reference.
	 * @see #setOwningReference(Reference)
	 * @see io.opencaesar.oml.OmlPackage#getAnnotation_OwningReference()
	 * @see io.opencaesar.oml.Reference#getOwnedAnnotations
	 * @model opposite="ownedAnnotations" transient="false"
	 * @generated
	 */
	Reference getOwningReference();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.Annotation#getOwningReference <em>Owning Reference</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Reference</em>' container reference.
	 * @see #getOwningReference()
	 * @generated
	 */
	void setOwningReference(Reference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the value of the annotation
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Element getValue();

} // Annotation