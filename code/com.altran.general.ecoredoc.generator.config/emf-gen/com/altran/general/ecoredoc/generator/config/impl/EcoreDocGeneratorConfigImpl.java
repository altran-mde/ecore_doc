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
import com.altran.general.ecoredoc.generator.config.IDefaultValueConfig;
import com.altran.general.ecoredoc.generator.config.IEAttributeConfig;
import com.altran.general.ecoredoc.generator.config.IEClassConfig;
import com.altran.general.ecoredoc.generator.config.IEClassifierConfig;
import com.altran.general.ecoredoc.generator.config.IEDataTypeConfig;
import com.altran.general.ecoredoc.generator.config.IEEnumConfig;
import com.altran.general.ecoredoc.generator.config.IEEnumLiteralConfig;
import com.altran.general.ecoredoc.generator.config.IENamedElementConfig;
import com.altran.general.ecoredoc.generator.config.IEReferenceConfig;
import com.altran.general.ecoredoc.generator.config.IEStructuralFeatureConfig;

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
 *   <li>{@link com.altran.general.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#isRender <em>Render</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#isRenderDefaults <em>Render Defaults</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#isRenderUseCases <em>Render Use Cases</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#isRepeatInherited <em>Repeat Inherited</em>}</li>
 *   <li>{@link com.altran.general.ecoredoc.generator.config.impl.EcoreDocGeneratorConfigImpl#getEPackages <em>EPackages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EcoreDocGeneratorConfigImpl extends MinimalEObjectImpl.Container implements EcoreDocGeneratorConfig {
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
	 * The default value of the '{@link #isRenderUseCases() <em>Render Use Cases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenderUseCases()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RENDER_USE_CASES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRenderUseCases() <em>Render Use Cases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenderUseCases()
	 * @generated
	 * @ordered
	 */
	protected boolean renderUseCases = RENDER_USE_CASES_EDEFAULT;

	/**
	 * This is true if the Render Use Cases attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean renderUseCasesESet;

	/**
	 * The default value of the '{@link #isRepeatInherited() <em>Repeat Inherited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRepeatInherited()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REPEAT_INHERITED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRepeatInherited() <em>Repeat Inherited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRepeatInherited()
	 * @generated
	 * @ordered
	 */
	protected boolean repeatInherited = REPEAT_INHERITED_EDEFAULT;

	/**
	 * This is true if the Repeat Inherited attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean repeatInheritedESet;

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
	public boolean isRenderUseCases() {
		return renderUseCases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRenderUseCases(boolean newRenderUseCases) {
		boolean oldRenderUseCases = renderUseCases;
		renderUseCases = newRenderUseCases;
		boolean oldRenderUseCasesESet = renderUseCasesESet;
		renderUseCasesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_USE_CASES, oldRenderUseCases, renderUseCases, !oldRenderUseCasesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRenderUseCases() {
		boolean oldRenderUseCases = renderUseCases;
		boolean oldRenderUseCasesESet = renderUseCasesESet;
		renderUseCases = RENDER_USE_CASES_EDEFAULT;
		renderUseCasesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_USE_CASES, oldRenderUseCases, RENDER_USE_CASES_EDEFAULT, oldRenderUseCasesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRenderUseCases() {
		return renderUseCasesESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRepeatInherited() {
		return repeatInherited;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepeatInherited(boolean newRepeatInherited) {
		boolean oldRepeatInherited = repeatInherited;
		repeatInherited = newRepeatInherited;
		boolean oldRepeatInheritedESet = repeatInheritedESet;
		repeatInheritedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__REPEAT_INHERITED, oldRepeatInherited, repeatInherited, !oldRepeatInheritedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRepeatInherited() {
		boolean oldRepeatInherited = repeatInherited;
		boolean oldRepeatInheritedESet = repeatInheritedESet;
		repeatInherited = REPEAT_INHERITED_EDEFAULT;
		repeatInheritedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__REPEAT_INHERITED, oldRepeatInherited, REPEAT_INHERITED_EDEFAULT, oldRepeatInheritedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRepeatInherited() {
		return repeatInheritedESet;
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
	public boolean shouldRenderUseCases() {
		boolean _xifexpression = false;
		boolean _isSetRenderUseCases = this.isSetRenderUseCases();
		if (_isSetRenderUseCases) {
			_xifexpression = this.isRenderUseCases();
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
	public IENamedElementConfig findConfig(final ENamedElement element) {
		Iterable<? extends IENamedElementConfig> _switchResult = null;
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
		final Function1<IENamedElementConfig, Boolean> _function = new Function1<IENamedElementConfig, Boolean>() {
			public Boolean apply(final IENamedElementConfig it) {
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
	public boolean shouldRepeatInherited() {
		boolean _xifexpression = false;
		boolean _isSetRepeatInherited = this.isSetRepeatInherited();
		if (_isSetRepeatInherited) {
			_xifexpression = this.isRepeatInherited();
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
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER:
				return isRender();
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS:
				return isRenderDefaults();
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_USE_CASES:
				return isRenderUseCases();
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__REPEAT_INHERITED:
				return isRepeatInherited();
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
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER:
				setRender((Boolean)newValue);
				return;
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS:
				setRenderDefaults((Boolean)newValue);
				return;
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_USE_CASES:
				setRenderUseCases((Boolean)newValue);
				return;
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__REPEAT_INHERITED:
				setRepeatInherited((Boolean)newValue);
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
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER:
				unsetRender();
				return;
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS:
				unsetRenderDefaults();
				return;
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_USE_CASES:
				unsetRenderUseCases();
				return;
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__REPEAT_INHERITED:
				unsetRepeatInherited();
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
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER:
				return isSetRender();
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS:
				return isSetRenderDefaults();
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_USE_CASES:
				return isSetRenderUseCases();
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__REPEAT_INHERITED:
				return isSetRepeatInherited();
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == IDefaultValueConfig.class) {
			switch (derivedFeatureID) {
				case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS: return ConfigPackage.IDEFAULT_VALUE_CONFIG__RENDER_DEFAULTS;
				default: return -1;
			}
		}
		if (baseClass == IEClassifierConfig.class) {
			switch (derivedFeatureID) {
				case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_USE_CASES: return ConfigPackage.IE_CLASSIFIER_CONFIG__RENDER_USE_CASES;
				default: return -1;
			}
		}
		if (baseClass == IEDataTypeConfig.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEEnumConfig.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEEnumLiteralConfig.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEClassConfig.class) {
			switch (derivedFeatureID) {
				case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__REPEAT_INHERITED: return ConfigPackage.IE_CLASS_CONFIG__REPEAT_INHERITED;
				default: return -1;
			}
		}
		if (baseClass == IEStructuralFeatureConfig.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEAttributeConfig.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEReferenceConfig.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == IDefaultValueConfig.class) {
			switch (baseFeatureID) {
				case ConfigPackage.IDEFAULT_VALUE_CONFIG__RENDER_DEFAULTS: return ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_DEFAULTS;
				default: return -1;
			}
		}
		if (baseClass == IEClassifierConfig.class) {
			switch (baseFeatureID) {
				case ConfigPackage.IE_CLASSIFIER_CONFIG__RENDER_USE_CASES: return ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__RENDER_USE_CASES;
				default: return -1;
			}
		}
		if (baseClass == IEDataTypeConfig.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEEnumConfig.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEEnumLiteralConfig.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEClassConfig.class) {
			switch (baseFeatureID) {
				case ConfigPackage.IE_CLASS_CONFIG__REPEAT_INHERITED: return ConfigPackage.ECORE_DOC_GENERATOR_CONFIG__REPEAT_INHERITED;
				default: return -1;
			}
		}
		if (baseClass == IEStructuralFeatureConfig.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEAttributeConfig.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IEReferenceConfig.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == IDefaultValueConfig.class) {
			switch (baseOperationID) {
				case ConfigPackage.IDEFAULT_VALUE_CONFIG___SHOULD_RENDER_DEFAULTS: return ConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_DEFAULTS;
				default: return -1;
			}
		}
		if (baseClass == IEClassifierConfig.class) {
			switch (baseOperationID) {
				case ConfigPackage.IE_CLASSIFIER_CONFIG___SHOULD_RENDER_USE_CASES: return ConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_USE_CASES;
				default: return -1;
			}
		}
		if (baseClass == IEDataTypeConfig.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == IEEnumConfig.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == IEEnumLiteralConfig.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == IEClassConfig.class) {
			switch (baseOperationID) {
				case ConfigPackage.IE_CLASS_CONFIG___SHOULD_REPEAT_INHERITED: return ConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_REPEAT_INHERITED;
				default: return -1;
			}
		}
		if (baseClass == IEStructuralFeatureConfig.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == IEAttributeConfig.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == IEReferenceConfig.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER:
				return shouldRender();
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_DEFAULTS:
				return shouldRenderDefaults();
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_RENDER_USE_CASES:
				return shouldRenderUseCases();
			case ConfigPackage.ECORE_DOC_GENERATOR_CONFIG___SHOULD_REPEAT_INHERITED:
				return shouldRepeatInherited();
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
		result.append(" (render: ");
		if (renderESet) result.append(render); else result.append("<unset>");
		result.append(", renderDefaults: ");
		if (renderDefaultsESet) result.append(renderDefaults); else result.append("<unset>");
		result.append(", renderUseCases: ");
		if (renderUseCasesESet) result.append(renderUseCases); else result.append("<unset>");
		result.append(", repeatInherited: ");
		if (repeatInheritedESet) result.append(repeatInherited); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //EcoreDocGeneratorConfigImpl
