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
import io.opencaesar.oml.Rule;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link io.opencaesar.oml.Rule} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RuleItemProvider extends VocabularyMemberItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(OmlPackage.Literals.RULE__ANTECEDENT);
			childrenFeatures.add(OmlPackage.Literals.RULE__CONSEQUENT);
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
	 * This returns Rule.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Rule"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Rule)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Rule_type") :
			getString("_UI_Rule_type") + " " + label;
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

		switch (notification.getFeatureID(Rule.class)) {
			case OmlPackage.RULE__ANTECEDENT:
			case OmlPackage.RULE__CONSEQUENT:
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
				(OmlPackage.Literals.RULE__ANTECEDENT,
				 OmlFactory.eINSTANCE.createTypePredicate()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.RULE__ANTECEDENT,
				 OmlFactory.eINSTANCE.createRelationEntityPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.RULE__ANTECEDENT,
				 OmlFactory.eINSTANCE.createPropertyPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.RULE__ANTECEDENT,
				 OmlFactory.eINSTANCE.createSameAsPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.RULE__ANTECEDENT,
				 OmlFactory.eINSTANCE.createDifferentFromPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.RULE__CONSEQUENT,
				 OmlFactory.eINSTANCE.createTypePredicate()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.RULE__CONSEQUENT,
				 OmlFactory.eINSTANCE.createRelationEntityPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.RULE__CONSEQUENT,
				 OmlFactory.eINSTANCE.createPropertyPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.RULE__CONSEQUENT,
				 OmlFactory.eINSTANCE.createSameAsPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(OmlPackage.Literals.RULE__CONSEQUENT,
				 OmlFactory.eINSTANCE.createDifferentFromPredicate()));
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
			childFeature == OmlPackage.Literals.RULE__ANTECEDENT ||
			childFeature == OmlPackage.Literals.RULE__CONSEQUENT;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
