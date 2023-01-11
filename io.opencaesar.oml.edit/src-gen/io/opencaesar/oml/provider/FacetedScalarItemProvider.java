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


import io.opencaesar.oml.FacetedScalar;
import io.opencaesar.oml.OmlFactory;
import io.opencaesar.oml.OmlPackage;

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
 * This is the item provider adapter for a {@link io.opencaesar.oml.FacetedScalar} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FacetedScalarItemProvider extends ScalarItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetedScalarItemProvider(AdapterFactory adapterFactory) {
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

			addRefPropertyDescriptor(object);
			addLengthPropertyDescriptor(object);
			addMinLengthPropertyDescriptor(object);
			addMaxLengthPropertyDescriptor(object);
			addPatternPropertyDescriptor(object);
			addLanguagePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_FacetedScalar_ref_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FacetedScalar_ref_feature", "_UI_FacetedScalar_type"),
				 OmlPackage.Literals.FACETED_SCALAR__REF,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Length feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLengthPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FacetedScalar_length_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FacetedScalar_length_feature", "_UI_FacetedScalar_type"),
				 OmlPackage.Literals.FACETED_SCALAR__LENGTH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Min Length feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinLengthPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FacetedScalar_minLength_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FacetedScalar_minLength_feature", "_UI_FacetedScalar_type"),
				 OmlPackage.Literals.FACETED_SCALAR__MIN_LENGTH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Length feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxLengthPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FacetedScalar_maxLength_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FacetedScalar_maxLength_feature", "_UI_FacetedScalar_type"),
				 OmlPackage.Literals.FACETED_SCALAR__MAX_LENGTH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Pattern feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPatternPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FacetedScalar_pattern_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FacetedScalar_pattern_feature", "_UI_FacetedScalar_type"),
				 OmlPackage.Literals.FACETED_SCALAR__PATTERN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Language feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLanguagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FacetedScalar_language_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FacetedScalar_language_feature", "_UI_FacetedScalar_type"),
				 OmlPackage.Literals.FACETED_SCALAR__LANGUAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(OmlPackage.Literals.FACETED_SCALAR__MIN_INCLUSIVE);
			childrenFeatures.add(OmlPackage.Literals.FACETED_SCALAR__MIN_EXCLUSIVE);
			childrenFeatures.add(OmlPackage.Literals.FACETED_SCALAR__MAX_INCLUSIVE);
			childrenFeatures.add(OmlPackage.Literals.FACETED_SCALAR__MAX_EXCLUSIVE);
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
	 * This returns FacetedScalar.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FacetedScalar"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((FacetedScalar)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_FacetedScalar_type") :
			getString("_UI_FacetedScalar_type") + " " + label;
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

		switch (notification.getFeatureID(FacetedScalar.class)) {
			case OmlPackage.FACETED_SCALAR__LENGTH:
			case OmlPackage.FACETED_SCALAR__MIN_LENGTH:
			case OmlPackage.FACETED_SCALAR__MAX_LENGTH:
			case OmlPackage.FACETED_SCALAR__PATTERN:
			case OmlPackage.FACETED_SCALAR__LANGUAGE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case OmlPackage.FACETED_SCALAR__MIN_INCLUSIVE:
			case OmlPackage.FACETED_SCALAR__MIN_EXCLUSIVE:
			case OmlPackage.FACETED_SCALAR__MAX_INCLUSIVE:
			case OmlPackage.FACETED_SCALAR__MAX_EXCLUSIVE:
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
				(OmlPackage.Literals.FACETED_SCALAR__MIN_INCLUSIVE,
				 OmlFactory.eINSTANCE.createQuotedLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.FACETED_SCALAR__MIN_INCLUSIVE,
				 OmlFactory.eINSTANCE.createIntegerLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.FACETED_SCALAR__MIN_INCLUSIVE,
				 OmlFactory.eINSTANCE.createDecimalLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.FACETED_SCALAR__MIN_INCLUSIVE,
				 OmlFactory.eINSTANCE.createDoubleLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.FACETED_SCALAR__MIN_INCLUSIVE,
				 OmlFactory.eINSTANCE.createBooleanLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.FACETED_SCALAR__MIN_EXCLUSIVE,
				 OmlFactory.eINSTANCE.createQuotedLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.FACETED_SCALAR__MIN_EXCLUSIVE,
				 OmlFactory.eINSTANCE.createIntegerLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.FACETED_SCALAR__MIN_EXCLUSIVE,
				 OmlFactory.eINSTANCE.createDecimalLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.FACETED_SCALAR__MIN_EXCLUSIVE,
				 OmlFactory.eINSTANCE.createDoubleLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.FACETED_SCALAR__MIN_EXCLUSIVE,
				 OmlFactory.eINSTANCE.createBooleanLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.FACETED_SCALAR__MAX_INCLUSIVE,
				 OmlFactory.eINSTANCE.createQuotedLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.FACETED_SCALAR__MAX_INCLUSIVE,
				 OmlFactory.eINSTANCE.createIntegerLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.FACETED_SCALAR__MAX_INCLUSIVE,
				 OmlFactory.eINSTANCE.createDecimalLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.FACETED_SCALAR__MAX_INCLUSIVE,
				 OmlFactory.eINSTANCE.createDoubleLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.FACETED_SCALAR__MAX_INCLUSIVE,
				 OmlFactory.eINSTANCE.createBooleanLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.FACETED_SCALAR__MAX_EXCLUSIVE,
				 OmlFactory.eINSTANCE.createQuotedLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.FACETED_SCALAR__MAX_EXCLUSIVE,
				 OmlFactory.eINSTANCE.createIntegerLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.FACETED_SCALAR__MAX_EXCLUSIVE,
				 OmlFactory.eINSTANCE.createDecimalLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.FACETED_SCALAR__MAX_EXCLUSIVE,
				 OmlFactory.eINSTANCE.createDoubleLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.FACETED_SCALAR__MAX_EXCLUSIVE,
				 OmlFactory.eINSTANCE.createBooleanLiteral()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == OmlPackage.Literals.FACETED_SCALAR__MIN_INCLUSIVE ||
			childFeature == OmlPackage.Literals.FACETED_SCALAR__MIN_EXCLUSIVE ||
			childFeature == OmlPackage.Literals.FACETED_SCALAR__MAX_INCLUSIVE ||
			childFeature == OmlPackage.Literals.FACETED_SCALAR__MAX_EXCLUSIVE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
