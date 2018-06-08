/**
 */
package com.altran.general.ecoredoc.generator.config.impl;

import com.altran.general.ecoredoc.generator.config.ConfigPackage;
import com.altran.general.ecoredoc.generator.config.EAttributeConfig;
import com.altran.general.ecoredoc.generator.config.EClassConfig;
import com.altran.general.ecoredoc.generator.config.EContainmentConfig;
import com.altran.general.ecoredoc.generator.config.EDataTypeConfig;
import com.altran.general.ecoredoc.generator.config.EEnumConfig;
import com.altran.general.ecoredoc.generator.config.EEnumLiteralConfig;
import com.altran.general.ecoredoc.generator.config.EPackageConfig;
import com.altran.general.ecoredoc.generator.config.EReferenceConfig;
import com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig;

import com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig;
import com.google.common.base.Objects;
import java.lang.Iterable;
import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ecore Doc Generator Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#isRenderDefaults <em>Render Defaults</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#isRender <em>Render</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#getEPackages <em>EPackages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EcoreDocGeneratorConfigImpl extends MinimalEObjectImpl.Container implements EcoreDocGeneratorConfig {
	/**
	 * The default value of the '{@link #isRenderDefaults() <em>Render Defaults</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenderDefaults()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RENDER_DEFAULTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRenderDefaults() <em>Render Defaults</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenderDefaults()
	 * @generated
	 * @ordered
	 */
	protected boolean renderDefaults = RENDER_DEFAULTS_EDEFAULT;

	/**
	 * This is true if the Render Defaults attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean renderDefaultsESet;

	/**
	 * The default value of the '{@link #isRender() <em>Render</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRender()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RENDER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRender() <em>Render</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRender()
	 * @generated
	 * @ordered
	 */
	protected boolean render = RENDER_EDEFAULT;

	/**
	 * This is true if the Render attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean renderESet;

	/**
	 * The cached value of the '{@link #getEPackages() <em>EPackages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<EPackageConfig> ePackages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EcoreDocGeneratorConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.ECORE_DOC_GENERATOR_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRenderDefaults() {
		return renderDefaults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRenderDefaults(boolean newRenderDefaults) {
		boolean oldRenderDefaults = renderDefaults;
		renderDefaults = newRenderDefaults;
		boolean oldRenderDefaultsESet = renderDefaultsESet;
		renderDefaultsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS, oldRenderDefaults, renderDefaults, !oldRenderDefaultsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRenderDefaults() {
		boolean oldRenderDefaults = renderDefaults;
		boolean oldRenderDefaultsESet = renderDefaultsESet;
		renderDefaults = RENDER_DEFAULTS_EDEFAULT;
		renderDefaultsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS, oldRenderDefaults, RENDER_DEFAULTS_EDEFAULT, oldRenderDefaultsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRenderDefaults() {
		return renderDefaultsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRender() {
		return render;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRender(boolean newRender) {
		boolean oldRender = render;
		render = newRender;
		boolean oldRenderESet = renderESet;
		renderESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER, oldRender, render, !oldRenderESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRender() {
		boolean oldRender = render;
		boolean oldRenderESet = renderESet;
		render = RENDER_EDEFAULT;
		renderESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER, oldRender, RENDER_EDEFAULT, oldRenderESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRender() {
		return renderESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EPackageConfig> getEPackages() {
		if (ePackages == null) {
			ePackages = new EObjectContainmentEList<EPackageConfig>(EPackageConfig.class, this, ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EPACKAGES);
		}
		return ePackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean shouldRenderDefaults() {
		boolean _xifexpression = false;
		boolean _isSetRenderDefaults = this.isSetRenderDefaults();
		if (_isSetRenderDefaults) {
			_xifexpression = this.isRenderDefaults();
		}
		else {
			_xifexpression = true;
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean shouldRender() {
		boolean _xifexpression = false;
		boolean _isSetRender = this.isSetRender();
		if (_isSetRender) {
			_xifexpression = this.isRender();
		}
		else {
			_xifexpression = true;
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IEcoreDocGeneratorConfig findConfig(final ENamedElement element) {
		Iterable<? extends IEcoreDocGeneratorConfig> _switchResult = null;
		boolean _matched = false;
		if (element instanceof EPackage) {
			_matched=true;
			_switchResult = this.getEPackages();
		}
		if (!_matched) {
			if (element instanceof EEnum) {
				_matched=true;
				final Function1<EPackageConfig, EList<EEnumConfig>> _function = new Function1<EPackageConfig, EList<EEnumConfig>>() {
					public EList<EEnumConfig> apply(final EPackageConfig it) {
						return it.getEEnums();
					}
				};
				_switchResult = IterableExtensions.<EPackageConfig, EEnumConfig>flatMap(this.getEPackages(), _function);
			}
		}
		if (!_matched) {
			if (element instanceof EDataType) {
				_matched=true;
				final Function1<EPackageConfig, EList<EDataTypeConfig>> _function = new Function1<EPackageConfig, EList<EDataTypeConfig>>() {
					public EList<EDataTypeConfig> apply(final EPackageConfig it) {
						return it.getEDataTypes();
					}
				};
				_switchResult = IterableExtensions.<EPackageConfig, EDataTypeConfig>flatMap(this.getEPackages(), _function);
			}
		}
		if (!_matched) {
			if (element instanceof EEnumLiteral) {
				_matched=true;
				final Function1<EPackageConfig, EList<EEnumConfig>> _function = new Function1<EPackageConfig, EList<EEnumConfig>>() {
					public EList<EEnumConfig> apply(final EPackageConfig it) {
						return it.getEEnums();
					}
				};
				final Function1<EEnumConfig, EList<EEnumLiteralConfig>> _function_1 = new Function1<EEnumConfig, EList<EEnumLiteralConfig>>() {
					public EList<EEnumLiteralConfig> apply(final EEnumConfig it) {
						return it.getEEnumLiterals();
					}
				};
				_switchResult = IterableExtensions.<EEnumConfig, EEnumLiteralConfig>flatMap(IterableExtensions.<EPackageConfig, EEnumConfig>flatMap(this.getEPackages(), _function), _function_1);
			}
		}
		if (!_matched) {
			if (element instanceof EClass) {
				_matched=true;
				final Function1<EPackageConfig, EList<EClassConfig>> _function = new Function1<EPackageConfig, EList<EClassConfig>>() {
					public EList<EClassConfig> apply(final EPackageConfig it) {
						return it.getEClasses();
					}
				};
				_switchResult = IterableExtensions.<EPackageConfig, EClassConfig>flatMap(this.getEPackages(), _function);
			}
		}
		if (!_matched) {
			if (element instanceof EAttribute) {
				_matched=true;
				final Function1<EPackageConfig, EList<EClassConfig>> _function = new Function1<EPackageConfig, EList<EClassConfig>>() {
					public EList<EClassConfig> apply(final EPackageConfig it) {
						return it.getEClasses();
					}
				};
				final Function1<EClassConfig, EList<EAttributeConfig>> _function_1 = new Function1<EClassConfig, EList<EAttributeConfig>>() {
					public EList<EAttributeConfig> apply(final EClassConfig it) {
						return it.getEAttributes();
					}
				};
				_switchResult = IterableExtensions.<EClassConfig, EAttributeConfig>flatMap(IterableExtensions.<EPackageConfig, EClassConfig>flatMap(this.getEPackages(), _function), _function_1);
			}
		}
		if (!_matched) {
			if (element instanceof EReference) {
				boolean _isContainment = ((EReference)element).isContainment();
				if (_isContainment) {
					_matched=true;
					final Function1<EPackageConfig, EList<EClassConfig>> _function = new Function1<EPackageConfig, EList<EClassConfig>>() {
						public EList<EClassConfig> apply(final EPackageConfig it) {
							return it.getEClasses();
						}
					};
					final Function1<EClassConfig, EList<EContainmentConfig>> _function_1 = new Function1<EClassConfig, EList<EContainmentConfig>>() {
						public EList<EContainmentConfig> apply(final EClassConfig it) {
							return it.getEContainments();
						}
					};
					_switchResult = IterableExtensions.<EClassConfig, EContainmentConfig>flatMap(IterableExtensions.<EPackageConfig, EClassConfig>flatMap(this.getEPackages(), _function), _function_1);
				}
			}
		}
		if (!_matched) {
			if (element instanceof EReference) {
				boolean _isContainment = ((EReference)element).isContainment();
				boolean _not = (!_isContainment);
				if (_not) {
					_matched=true;
					final Function1<EPackageConfig, EList<EClassConfig>> _function = new Function1<EPackageConfig, EList<EClassConfig>>() {
						public EList<EClassConfig> apply(final EPackageConfig it) {
							return it.getEClasses();
						}
					};
					final Function1<EClassConfig, EList<EReferenceConfig>> _function_1 = new Function1<EClassConfig, EList<EReferenceConfig>>() {
						public EList<EReferenceConfig> apply(final EClassConfig it) {
							return it.getEReferences();
						}
					};
					_switchResult = IterableExtensions.<EClassConfig, EReferenceConfig>flatMap(IterableExtensions.<EPackageConfig, EClassConfig>flatMap(this.getEPackages(), _function), _function_1);
				}
			}
		}
		final Function1<IEcoreDocGeneratorConfig, Boolean> _function = new Function1<IEcoreDocGeneratorConfig, Boolean>() {
			public Boolean apply(final IEcoreDocGeneratorConfig it) {
				ENamedElement _target = it.getTarget();
				return Boolean.valueOf(Objects.equal(_target, element));
			}
		};
		return IterableExtensions.findFirst(_switchResult, _function);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ENamedElement getTarget() {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EPACKAGES:
				return ((InternalEList<?>)getEPackages()).basicRemove(otherEnd, msgs);
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
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS:
				return isRenderDefaults();
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER:
				return isRender();
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EPACKAGES:
				return getEPackages();
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
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS:
				setRenderDefaults((Boolean)newValue);
				return;
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER:
				setRender((Boolean)newValue);
				return;
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EPACKAGES:
				getEPackages().clear();
				getEPackages().addAll((Collection<? extends EPackageConfig>)newValue);
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
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS:
				unsetRenderDefaults();
				return;
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER:
				unsetRender();
				return;
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EPACKAGES:
				getEPackages().clear();
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
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS:
				return isSetRenderDefaults();
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER:
				return isSetRender();
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__EPACKAGES:
				return ePackages != null && !ePackages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_DEFAULTS:
				return shouldRenderDefaults();
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER:
				return shouldRender();
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG___FIND_CONFIG__ENAMEDELEMENT:
				return findConfig((ENamedElement)arguments.get(0));
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG___GET_TARGET:
				return getTarget();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (renderDefaults: ");
		if (renderDefaultsESet) result.append(renderDefaults); else result.append("<unset>");
		result.append(", render: ");
		if (renderESet) result.append(render); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //EcoreDocGeneratorConfigImpl
