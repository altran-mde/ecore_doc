/**
 */
package com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.provider;

import com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration;
import com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoredocExtensionPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.egf.portfolio.genchain.generationChain.provider.EcoreElementItemProvider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EcoreDocGenerationItemProvider extends EcoreElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoreDocGenerationItemProvider(AdapterFactory adapterFactory) {
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

			addProjectNamePropertyDescriptor(object);
			addOutputFolderPropertyDescriptor(object);
			addResolvePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Project Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProjectNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_EcoreDocGeneration_projectName_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_EcoreDocGeneration_projectName_feature",
								"_UI_EcoreDocGeneration_type"),
						EcoredocExtensionPackage.Literals.ECORE_DOC_GENERATION__PROJECT_NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Output Folder feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOutputFolderPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_EcoreDocGeneration_outputFolder_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_EcoreDocGeneration_outputFolder_feature",
								"_UI_EcoreDocGeneration_type"),
						EcoredocExtensionPackage.Literals.ECORE_DOC_GENERATION__OUTPUT_FOLDER, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Resolve feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResolvePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_EcoreDocGeneration_resolve_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_EcoreDocGeneration_resolve_feature",
						"_UI_EcoreDocGeneration_type"),
				EcoredocExtensionPackage.Literals.ECORE_DOC_GENERATION__RESOLVE, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns EcoreDocGeneration.png.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EcoreDocGeneration.png"));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((EcoreDocGeneration) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_EcoreDocGeneration_type")
				: label + " [" + getString("_UI_EcoreDocGeneration_type") + "]";
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

		switch (notification.getFeatureID(EcoreDocGeneration.class)) {
		case EcoredocExtensionPackage.ECORE_DOC_GENERATION__PROJECT_NAME:
		case EcoredocExtensionPackage.ECORE_DOC_GENERATION__OUTPUT_FOLDER:
		case EcoredocExtensionPackage.ECORE_DOC_GENERATION__RESOLVE:
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

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return EcoredocExtensionEditPlugin.INSTANCE;
	}

}
