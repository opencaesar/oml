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
 * A representation of the model object '<em><b>Link Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * LinkAssertion is an assertion that specifies a link from the asserting named instance as a source to another
 * named instance as a target. Unlike a relation instance, which is typed by a relation entity, a link references
 * a relation that has the type of the source instance as a conforming domain and the type of the target instance
 * as a conforming range.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.LinkAssertion#getRelation <em>Relation</em>}</li>
 *   <li>{@link io.opencaesar.oml.LinkAssertion#getTarget <em>Target</em>}</li>
 *   <li>{@link io.opencaesar.oml.LinkAssertion#getOwningInstance <em>Owning Instance</em>}</li>
 *   <li>{@link io.opencaesar.oml.LinkAssertion#getOwningReference <em>Owning Reference</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getLinkAssertion()
 * @model annotation="https://tabatkins.github.io/bikeshed heading='Assertions'"
 * @generated
 */
public interface LinkAssertion extends Assertion {
	/**
	 * Returns the value of the '<em><b>Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The relation referenced by this link
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Relation</em>' reference.
	 * @see #setRelation(Relation)
	 * @see io.opencaesar.oml.OmlPackage#getLinkAssertion_Relation()
	 * @model required="true"
	 * @generated
	 */
	Relation getRelation();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.LinkAssertion#getRelation <em>Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation</em>' reference.
	 * @see #getRelation()
	 * @generated
	 */
	void setRelation(Relation value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The named instance that is target of this link
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(NamedInstance)
	 * @see io.opencaesar.oml.OmlPackage#getLinkAssertion_Target()
	 * @model required="true"
	 * @generated
	 */
	NamedInstance getTarget();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.LinkAssertion#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(NamedInstance value);

	/**
	 * Returns the value of the '<em><b>Owning Instance</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.NamedInstance#getOwnedLinks <em>Owned Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The named instance that is the source of this link
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Instance</em>' container reference.
	 * @see #setOwningInstance(NamedInstance)
	 * @see io.opencaesar.oml.OmlPackage#getLinkAssertion_OwningInstance()
	 * @see io.opencaesar.oml.NamedInstance#getOwnedLinks
	 * @model opposite="ownedLinks" transient="false"
	 * @generated
	 */
	NamedInstance getOwningInstance();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.LinkAssertion#getOwningInstance <em>Owning Instance</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Instance</em>' container reference.
	 * @see #getOwningInstance()
	 * @generated
	 */
	void setOwningInstance(NamedInstance value);

	/**
	 * Returns the value of the '<em><b>Owning Reference</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.NamedInstanceReference#getOwnedLinks <em>Owned Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The reference to a named instance that this the source of this link
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Reference</em>' container reference.
	 * @see #setOwningReference(NamedInstanceReference)
	 * @see io.opencaesar.oml.OmlPackage#getLinkAssertion_OwningReference()
	 * @see io.opencaesar.oml.NamedInstanceReference#getOwnedLinks
	 * @model opposite="ownedLinks" transient="false"
	 * @generated
	 */
	NamedInstanceReference getOwningReference();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.LinkAssertion#getOwningReference <em>Owning Reference</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Reference</em>' container reference.
	 * @see #getOwningReference()
	 * @generated
	 */
	void setOwningReference(NamedInstanceReference value);

} // LinkAssertion
