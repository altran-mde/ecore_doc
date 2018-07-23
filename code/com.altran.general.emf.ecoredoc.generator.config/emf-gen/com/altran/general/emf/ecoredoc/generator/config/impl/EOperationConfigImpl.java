/**
 */
package com.altran.general.emf.ecoredoc.generator.config.impl;

import com.altran.general.emf.ecoredoc.generator.config.EOperationConfig;
import com.altran.general.emf.ecoredoc.generator.config.EParameterConfig;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage;

import com.google.common.collect.Iterables;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EOperation Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EOperationConfigImpl#getTargetEOperation <em>Target EOperation</em>}</li>
 *   <li>{@link com.altran.general.emf.ecoredoc.generator.config.impl.EOperationConfigImpl#getEParameters <em>EParameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EOperationConfigImpl extends AEReferenceConfigImpl implements EOperationConfig {
	/**
	 * The cached value of the '{@link #getTargetEOperation() <em>Target EOperation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetEOperation()
	 * @generated
	 * @ordered
	 */
	protected EOperation targetEOperation;

	/**
	 * The cached value of the '{@link #getEParameters() <em>EParameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<EParameterConfig> eParameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EOperationConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcoreDocConfigPackage.Literals.EOPERATION_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTargetEOperation() {
		if (targetEOperation != null && targetEOperation.eIsProxy()) {
			InternalEObject oldTargetEOperation = (InternalEObject)targetEOperation;
			targetEOperation = (EOperation)eResolveProxy(oldTargetEOperation);
			if (targetEOperation != oldTargetEOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EcoreDocConfigPackage.EOPERATION_CONFIG__TARGET_EOPERATION, oldTargetEOperation, targetEOperation));
			}
		}
		return targetEOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation basicGetTargetEOperation() {
		return targetEOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetEOperation(EOperation newTargetEOperation) {
		EOperation oldTargetEOperation = targetEOperation;
		targetEOperation = newTargetEOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcoreDocConfigPackage.EOPERATION_CONFIG__TARGET_EOPERATION, oldTargetEOperation, targetEOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EParameterConfig> getEParameters() {
		if (eParameters == null) {
			eParameters = new EObjectContainmentEList<EParameterConfig>(EParameterConfig.class, this, EcoreDocConfigPackage.EOPERATION_CONFIG__EPARAMETERS);
		}
		return eParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ENamedElement getTarget() {
		return this.getTargetEOperation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addEParameters(final List<EParameterConfig> eParameterConfig) {
		EList<EParameterConfig> _eParameters = this.getEParameters();
		Iterables.<EParameterConfig>addAll(_eParameters, eParameterConfig);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EcoreDocConfigPackage.EOPERATION_CONFIG__EPARAMETERS:
				return ((InternalEList<?>)getEParameters()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EcoreDocConfigPackage.EOPERATION_CONFIG__TARGET_EOPERATION:
				if (resolve) return getTargetEOperation();
				return basicGetTargetEOperation();
			case EcoreDocConfigPackage.EOPERATION_CONFIG__EPARAMETERS:
				return getEParameters();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EcoreDocConfigPackage.EOPERATION_CONFIG__TARGET_EOPERATION:
				setTargetEOperation((EOperation)newValue);
				return;
			case EcoreDocConfigPackage.EOPERATION_CONFIG__EPARAMETERS:
				getEParameters().clear();
				getEParameters().addAll((Collection<? extends EParameterConfig>)newValue);
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
			case EcoreDocConfigPackage.EOPERATION_CONFIG__TARGET_EOPERATION:
				setTargetEOperation((EOperation)null);
				return;
			case EcoreDocConfigPackage.EOPERATION_CONFIG__EPARAMETERS:
				getEParameters().clear();
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
			case EcoreDocConfigPackage.EOPERATION_CONFIG__TARGET_EOPERATION:
				return targetEOperation != null;
			case EcoreDocConfigPackage.EOPERATION_CONFIG__EPARAMETERS:
				return eParameters != null && !eParameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case EcoreDocConfigPackage.EOPERATION_CONFIG___GET_TARGET:
				return getTarget();
			case EcoreDocConfigPackage.EOPERATION_CONFIG___ADD_EPARAMETERS__LIST:
				addEParameters((List<EParameterConfig>)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //EOperationConfigImpl
