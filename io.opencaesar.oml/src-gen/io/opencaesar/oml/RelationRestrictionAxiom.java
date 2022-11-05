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
 * A representation of the model object '<em><b>Relation Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * RelationRestrictionAxiom is an axiom that places some restriction on the target of a relation in the context of
 * the restricting classifier domain. It can be specified directly on the classifier or indirectly on a reference to it.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.RelationRestrictionAxiom#getRelation <em>Relation</em>}</li>
 *   <li>{@link io.opencaesar.oml.RelationRestrictionAxiom#getOwningEntity <em>Owning Entity</em>}</li>
 *   <li>{@link io.opencaesar.oml.RelationRestrictionAxiom#getOwningReference <em>Owning Reference</em>}</li>
 * </ul>
 *
 * @see io.opencaesar.oml.OmlPackage#getRelationRestrictionAxiom()
 * @model abstract="true"
 *        annotation="https://tabatkins.github.io/bikeshed heading='Axioms'"
 * @generated
 */
public interface RelationRestrictionAxiom extends RestrictionAxiom {
	/**
	 * Returns the value of the '<em><b>Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The restricted relation specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Relation</em>' reference.
	 * @see #setRelation(Relation)
	 * @see io.opencaesar.oml.OmlPackage#getRelationRestrictionAxiom_Relation()
	 * @model required="true"
	 * @generated
	 */
	Relation getRelation();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationRestrictionAxiom#getRelation <em>Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation</em>' reference.
	 * @see #getRelation()
	 * @generated
	 */
	void setRelation(Relation value);

	/**
	 * Returns the value of the '<em><b>Owning Entity</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.Entity#getOwnedRelationRestrictions <em>Owned Relation Restrictions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The restricting entity specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Entity</em>' container reference.
	 * @see #setOwningEntity(Entity)
	 * @see io.opencaesar.oml.OmlPackage#getRelationRestrictionAxiom_OwningEntity()
	 * @see io.opencaesar.oml.Entity#getOwnedRelationRestrictions
	 * @model opposite="ownedRelationRestrictions" transient="false"
	 * @generated
	 */
	Entity getOwningEntity();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationRestrictionAxiom#getOwningEntity <em>Owning Entity</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Entity</em>' container reference.
	 * @see #getOwningEntity()
	 * @generated
	 */
	void setOwningEntity(Entity value);

	/**
	 * Returns the value of the '<em><b>Owning Reference</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link io.opencaesar.oml.EntityReference#getOwnedRelationRestrictions <em>Owned Relation Restrictions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The reference to a restricting entity specified by this axiom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Reference</em>' container reference.
	 * @see #setOwningReference(EntityReference)
	 * @see io.opencaesar.oml.OmlPackage#getRelationRestrictionAxiom_OwningReference()
	 * @see io.opencaesar.oml.EntityReference#getOwnedRelationRestrictions
	 * @model opposite="ownedRelationRestrictions" transient="false"
	 * @generated
	 */
	EntityReference getOwningReference();

	/**
	 * Sets the value of the '{@link io.opencaesar.oml.RelationRestrictionAxiom#getOwningReference <em>Owning Reference</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Reference</em>' container reference.
	 * @see #getOwningReference()
	 * @generated
	 */
	void setOwningReference(EntityReference value);

} // RelationRestrictionAxiom
