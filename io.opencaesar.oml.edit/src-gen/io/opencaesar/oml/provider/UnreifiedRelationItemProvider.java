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
package io.opencaesar.oml.provider;


import io.opencaesar.oml.OmlFactory;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.UnreifiedRelation;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link io.opencaesar.oml.UnreifiedRelation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UnreifiedRelationItemProvider extends RelationItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnreifiedRelationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addOwningVocabularyPropertyDescriptor(object);
			addSourcePropertyDescriptor(object);
			addTargetPropertyDescriptor(object);
			addFunctionalPropertyDescriptor(object);
			addInverseFunctionalPropertyDescriptor(object);
			addSymmetricPropertyDescriptor(object);
			addAsymmetricPropertyDescriptor(object);
			addReflexivePropertyDescriptor(object);
			addIrreflexivePropertyDescriptor(object);
			addTransitivePropertyDescriptor(object);
			addRefPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Owning Vocabulary feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOwningVocabularyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_VocabularyStatement_owningVocabulary_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_VocabularyStatement_owningVocabulary_feature", "_UI_VocabularyStatement_type"),
				 OmlPackage.Literals.VOCABULARY_STATEMENT__OWNING_VOCABULARY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RelationBase_source_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RelationBase_source_feature", "_UI_RelationBase_type"),
				 OmlPackage.Literals.RELATION_BASE__SOURCE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RelationBase_target_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RelationBase_target_feature", "_UI_RelationBase_type"),
				 OmlPackage.Literals.RELATION_BASE__TARGET,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Functional feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFunctionalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RelationBase_functional_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RelationBase_functional_feature", "_UI_RelationBase_type"),
				 OmlPackage.Literals.RELATION_BASE__FUNCTIONAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Inverse Functional feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInverseFunctionalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RelationBase_inverseFunctional_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RelationBase_inverseFunctional_feature", "_UI_RelationBase_type"),
				 OmlPackage.Literals.RELATION_BASE__INVERSE_FUNCTIONAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Symmetric feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSymmetricPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RelationBase_symmetric_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RelationBase_symmetric_feature", "_UI_RelationBase_type"),
				 OmlPackage.Literals.RELATION_BASE__SYMMETRIC,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Asymmetric feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAsymmetricPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RelationBase_asymmetric_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RelationBase_asymmetric_feature", "_UI_RelationBase_type"),
				 OmlPackage.Literals.RELATION_BASE__ASYMMETRIC,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Reflexive feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReflexivePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RelationBase_reflexive_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RelationBase_reflexive_feature", "_UI_RelationBase_type"),
				 OmlPackage.Literals.RELATION_BASE__REFLEXIVE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Irreflexive feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIrreflexivePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RelationBase_irreflexive_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RelationBase_irreflexive_feature", "_UI_RelationBase_type"),
				 OmlPackage.Literals.RELATION_BASE__IRREFLEXIVE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Transitive feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTransitivePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RelationBase_transitive_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RelationBase_transitive_feature", "_UI_RelationBase_type"),
				 OmlPackage.Literals.RELATION_BASE__TRANSITIVE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ref feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRefPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UnreifiedRelation_ref_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UnreifiedRelation_ref_feature", "_UI_UnreifiedRelation_type"),
				 OmlPackage.Literals.UNREIFIED_RELATION__REF,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(OmlPackage.Literals.SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS);
			childrenFeatures.add(OmlPackage.Literals.RELATION_BASE__REVERSE_RELATION);
			childrenFeatures.add(OmlPackage.Literals.SPECIALIZABLE_PROPERTY__OWNED_EQUIVALENCES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns UnreifiedRelation.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/UnreifiedRelation"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((UnreifiedRelation)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_UnreifiedRelation_type") :
			getString("_UI_UnreifiedRelation_type") + " " + label;
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(UnreifiedRelation.class)) {
			case OmlPackage.UNREIFIED_RELATION__FUNCTIONAL:
			case OmlPackage.UNREIFIED_RELATION__INVERSE_FUNCTIONAL:
			case OmlPackage.UNREIFIED_RELATION__SYMMETRIC:
			case OmlPackage.UNREIFIED_RELATION__ASYMMETRIC:
			case OmlPackage.UNREIFIED_RELATION__REFLEXIVE:
			case OmlPackage.UNREIFIED_RELATION__IRREFLEXIVE:
			case OmlPackage.UNREIFIED_RELATION__TRANSITIVE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case OmlPackage.UNREIFIED_RELATION__OWNED_SPECIALIZATIONS:
			case OmlPackage.UNREIFIED_RELATION__REVERSE_RELATION:
			case OmlPackage.UNREIFIED_RELATION__OWNED_EQUIVALENCES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS,
				 OmlFactory.eINSTANCE.createSpecializationAxiom()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.RELATION_BASE__REVERSE_RELATION,
				 OmlFactory.eINSTANCE.createReverseRelation()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.SPECIALIZABLE_PROPERTY__OWNED_EQUIVALENCES,
				 OmlFactory.eINSTANCE.createPropertyEquivalenceAxiom()));
	}

}
