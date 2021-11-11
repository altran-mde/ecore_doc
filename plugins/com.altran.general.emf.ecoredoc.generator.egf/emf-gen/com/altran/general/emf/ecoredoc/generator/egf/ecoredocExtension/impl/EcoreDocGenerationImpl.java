/**
 */
package com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.impl;

import com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration;
import com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoredocExtensionPackage;

import org.eclipse.egf.portfolio.genchain.generationChain.impl.EcoreElementImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ecore Doc Generation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.impl.EcoreDocGenerationImpl#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.impl.EcoreDocGenerationImpl#getOutputFolder <em>Output Folder</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.impl.EcoreDocGenerationImpl#isResolve <em>Resolve</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EcoreDocGenerationImpl extends EcoreElementImpl implements EcoreDocGeneration {
	/**
	 * The default value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected String projectName = PROJECT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputFolder() <em>Output Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputFolder()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_FOLDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputFolder() <em>Output Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputFolder()
	 * @generated
	 * @ordered
	 */
	protected String outputFolder = OUTPUT_FOLDER_EDEFAULT;

	/**
	 * The default value of the '{@link #isResolve() <em>Resolve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResolve()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESOLVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isResolve() <em>Resolve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResolve()
	 * @generated
	 * @ordered
	 */
	protected boolean resolve = RESOLVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EcoreDocGenerationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcoredocExtensionPackage.Literals.ECORE_DOC_GENERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProjectName() {
		return projectName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProjectName(String newProjectName) {
		String oldProjectName = projectName;
		projectName = newProjectName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EcoredocExtensionPackage.ECORE_DOC_GENERATION__PROJECT_NAME, oldProjectName, projectName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOutputFolder() {
		return outputFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOutputFolder(String newOutputFolder) {
		String oldOutputFolder = outputFolder;
		outputFolder = newOutputFolder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EcoredocExtensionPackage.ECORE_DOC_GENERATION__OUTPUT_FOLDER, oldOutputFolder, outputFolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isResolve() {
		return resolve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResolve(boolean newResolve) {
		boolean oldResolve = resolve;
		resolve = newResolve;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EcoredocExtensionPackage.ECORE_DOC_GENERATION__RESOLVE, oldResolve, resolve));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EcoredocExtensionPackage.ECORE_DOC_GENERATION__PROJECT_NAME:
			return getProjectName();
		case EcoredocExtensionPackage.ECORE_DOC_GENERATION__OUTPUT_FOLDER:
			return getOutputFolder();
		case EcoredocExtensionPackage.ECORE_DOC_GENERATION__RESOLVE:
			return isResolve();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case EcoredocExtensionPackage.ECORE_DOC_GENERATION__PROJECT_NAME:
			setProjectName((String) newValue);
			return;
		case EcoredocExtensionPackage.ECORE_DOC_GENERATION__OUTPUT_FOLDER:
			setOutputFolder((String) newValue);
			return;
		case EcoredocExtensionPackage.ECORE_DOC_GENERATION__RESOLVE:
			setResolve((Boolean) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case EcoredocExtensionPackage.ECORE_DOC_GENERATION__PROJECT_NAME:
			setProjectName(PROJECT_NAME_EDEFAULT);
			return;
		case EcoredocExtensionPackage.ECORE_DOC_GENERATION__OUTPUT_FOLDER:
			setOutputFolder(OUTPUT_FOLDER_EDEFAULT);
			return;
		case EcoredocExtensionPackage.ECORE_DOC_GENERATION__RESOLVE:
			setResolve(RESOLVE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case EcoredocExtensionPackage.ECORE_DOC_GENERATION__PROJECT_NAME:
			return PROJECT_NAME_EDEFAULT == null ? projectName != null : !PROJECT_NAME_EDEFAULT.equals(projectName);
		case EcoredocExtensionPackage.ECORE_DOC_GENERATION__OUTPUT_FOLDER:
			return OUTPUT_FOLDER_EDEFAULT == null ? outputFolder != null : !OUTPUT_FOLDER_EDEFAULT.equals(outputFolder);
		case EcoredocExtensionPackage.ECORE_DOC_GENERATION__RESOLVE:
			return resolve != RESOLVE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (projectName: ");
		result.append(projectName);
		result.append(", outputFolder: ");
		result.append(outputFolder);
		result.append(", resolve: ");
		result.append(resolve);
		result.append(')');
		return result.toString();
	}

} //EcoreDocGenerationImpl
