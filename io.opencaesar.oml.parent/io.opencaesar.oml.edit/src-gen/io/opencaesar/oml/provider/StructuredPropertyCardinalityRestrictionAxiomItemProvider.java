/**
 * 
 * Copyright 2019 California Institute of Technology ("Caltech").
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


import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.StructuredPropertyCardinalityRestrictionAxiom;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link io.opencaesar.oml.StructuredPropertyCardinalityRestrictionAxiom} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StructuredPropertyCardinalityRestrictionAxiomItemProvider extends StructuredPropertyRestrictionAxiomItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuredPropertyCardinalityRestrictionAxiomItemProvider(AdapterFactory adapterFactory) {
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

			addCardinalityPropertyDescriptor(object);
			addKindPropertyDescriptor(object);
			addRangePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Cardinality feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCardinalityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StructuredPropertyCardinalityRestrictionAxiom_cardinality_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StructuredPropertyCardinalityRestrictionAxiom_cardinality_feature", "_UI_StructuredPropertyCardinalityRestrictionAxiom_type"),
				 OmlPackage.Literals.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__CARDINALITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Kind feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addKindPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StructuredPropertyCardinalityRestrictionAxiom_kind_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StructuredPropertyCardinalityRestrictionAxiom_kind_feature", "_UI_StructuredPropertyCardinalityRestrictionAxiom_type"),
				 OmlPackage.Literals.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__KIND,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Range feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRangePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StructuredPropertyCardinalityRestrictionAxiom_range_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StructuredPropertyCardinalityRestrictionAxiom_range_feature", "_UI_StructuredPropertyCardinalityRestrictionAxiom_type"),
				 OmlPackage.Literals.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns StructuredPropertyCardinalityRestrictionAxiom.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/StructuredPropertyCardinalityRestrictionAxiom"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		StructuredPropertyCardinalityRestrictionAxiom structuredPropertyCardinalityRestrictionAxiom = (StructuredPropertyCardinalityRestrictionAxiom)object;
		return getString("_UI_StructuredPropertyCardinalityRestrictionAxiom_type") + " " + structuredPropertyCardinalityRestrictionAxiom.getCardinality();
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

		switch (notification.getFeatureID(StructuredPropertyCardinalityRestrictionAxiom.class)) {
			case OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__CARDINALITY:
			case OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__KIND:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

}
