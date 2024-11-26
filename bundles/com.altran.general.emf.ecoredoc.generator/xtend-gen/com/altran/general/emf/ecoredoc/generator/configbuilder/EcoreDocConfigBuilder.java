package com.altran.general.emf.ecoredoc.generator.configbuilder;

import com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig;
import com.altran.general.emf.ecoredoc.generator.config.EClassConfig;
import com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig;
import com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig;
import com.altran.general.emf.ecoredoc.generator.config.EEnumConfig;
import com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig;
import com.altran.general.emf.ecoredoc.generator.config.EOperationConfig;
import com.altran.general.emf.ecoredoc.generator.config.EPackageConfig;
import com.altran.general.emf.ecoredoc.generator.config.EParameterConfig;
import com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigFactory;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;
import com.altran.general.emf.ecoredoc.generator.impl.extension.EcoreDocExtension;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Builds a fully populated config hierarchy for all input {@link EPackage}s.
 */
@SuppressWarnings("all")
public class EcoreDocConfigBuilder {
  @Extension
  private EcoreDocConfigFactory config = EcoreDocConfigFactory.eINSTANCE;
  
  @Extension
  private EcoreDocExtension _ecoreDocExtension = new EcoreDocExtension();
  
  private final EcoreDocGeneratorConfig result = this.config.createEcoreDocGeneratorConfig();
  
  public EcoreDocConfigBuilder() {
  }
  
  public EcoreDocConfigBuilder(final Collection<EPackage> ePackages) {
    final Consumer<EPackage> _function = (EPackage it) -> {
      this.add(it);
    };
    ePackages.forEach(_function);
  }
  
  public boolean add(final EPackage ePackage) {
    EList<EPackageConfig> _ePackages = this.result.getEPackages();
    EPackageConfig _createConfig = this.createConfig(ePackage);
    return _ePackages.add(_createConfig);
  }
  
  public EPackageConfig createConfig(final EPackage ePackage) {
    EPackageConfig _createEPackageConfig = this.config.createEPackageConfig();
    final Procedure1<EPackageConfig> _function = (EPackageConfig it) -> {
      it.setTargetEPackage(ePackage);
      final Consumer<EDataType> _function_1 = (EDataType eDataType) -> {
        EList<EDataTypeConfig> _eDataTypes = it.getEDataTypes();
        EDataTypeConfig _createConfig = this.createConfig(eDataType);
        _eDataTypes.add(_createConfig);
      };
      this._ecoreDocExtension.collectEDataTypes(ePackage.getEClassifiers()).forEach(_function_1);
      final Consumer<EEnum> _function_2 = (EEnum eEnum) -> {
        EList<EEnumConfig> _eEnums = it.getEEnums();
        EEnumConfig _createConfig = this.createConfig(eEnum);
        _eEnums.add(_createConfig);
      };
      this._ecoreDocExtension.collectEEnums(ePackage.getEClassifiers()).forEach(_function_2);
      final Consumer<EClass> _function_3 = (EClass eClass) -> {
        EList<EClassConfig> _eClasses = it.getEClasses();
        EClassConfig _createConfig = this.createConfig(eClass);
        _eClasses.add(_createConfig);
      };
      this._ecoreDocExtension.collectEClasses(ePackage.getEClassifiers()).forEach(_function_3);
    };
    EPackageConfig _doubleArrow = ObjectExtensions.<EPackageConfig>operator_doubleArrow(_createEPackageConfig, _function);
    return this.<EPackageConfig>parseAnnotations(_doubleArrow);
  }
  
  public EDataTypeConfig createConfig(final EDataType eDataType) {
    EDataTypeConfig _createEDataTypeConfig = this.config.createEDataTypeConfig();
    final Procedure1<EDataTypeConfig> _function = (EDataTypeConfig it) -> {
      it.setTargetEDataType(eDataType);
    };
    EDataTypeConfig _doubleArrow = ObjectExtensions.<EDataTypeConfig>operator_doubleArrow(_createEDataTypeConfig, _function);
    return this.<EDataTypeConfig>parseAnnotations(_doubleArrow);
  }
  
  public EEnumConfig createConfig(final EEnum eEnum) {
    EEnumConfig _createEEnumConfig = this.config.createEEnumConfig();
    final Procedure1<EEnumConfig> _function = (EEnumConfig it) -> {
      it.setTargetEEnum(eEnum);
      final Consumer<EEnumLiteral> _function_1 = (EEnumLiteral eEnumLiteral) -> {
        EList<EEnumLiteralConfig> _eEnumLiterals = it.getEEnumLiterals();
        EEnumLiteralConfig _createConfig = this.createConfig(eEnumLiteral);
        _eEnumLiterals.add(_createConfig);
      };
      eEnum.getELiterals().forEach(_function_1);
    };
    EEnumConfig _doubleArrow = ObjectExtensions.<EEnumConfig>operator_doubleArrow(_createEEnumConfig, _function);
    return this.<EEnumConfig>parseAnnotations(_doubleArrow);
  }
  
  public EEnumLiteralConfig createConfig(final EEnumLiteral eEnumLiteral) {
    EEnumLiteralConfig _createEEnumLiteralConfig = this.config.createEEnumLiteralConfig();
    final Procedure1<EEnumLiteralConfig> _function = (EEnumLiteralConfig it) -> {
      it.setTargetEEnumLiteral(eEnumLiteral);
    };
    EEnumLiteralConfig _doubleArrow = ObjectExtensions.<EEnumLiteralConfig>operator_doubleArrow(_createEEnumLiteralConfig, _function);
    return this.<EEnumLiteralConfig>parseAnnotations(_doubleArrow);
  }
  
  public EClassConfig createConfig(final EClass eClass) {
    EClassConfig _createEClassConfig = this.config.createEClassConfig();
    final Procedure1<EClassConfig> _function = (EClassConfig it) -> {
      it.setTargetEClass(eClass);
      final Consumer<EAttribute> _function_1 = (EAttribute eAttribute) -> {
        EList<EAttributeConfig> _eAttributes = it.getEAttributes();
        EAttributeConfig _createConfig = this.createConfig(eAttribute);
        _eAttributes.add(_createConfig);
      };
      eClass.getEAllAttributes().forEach(_function_1);
      final Consumer<EReference> _function_2 = (EReference eContainment) -> {
        EList<EContainmentConfig> _eContainments = it.getEContainments();
        EContainmentConfig _createContainmentConfig = this.createContainmentConfig(eContainment);
        _eContainments.add(_createContainmentConfig);
      };
      eClass.getEAllContainments().forEach(_function_2);
      final Function1<EReference, Boolean> _function_3 = (EReference it_1) -> {
        boolean _isContainment = it_1.isContainment();
        return Boolean.valueOf((!_isContainment));
      };
      final Consumer<EReference> _function_4 = (EReference eReference) -> {
        EList<EReferenceConfig> _eReferences = it.getEReferences();
        EReferenceConfig _createReferenceConfig = this.createReferenceConfig(eReference);
        _eReferences.add(_createReferenceConfig);
      };
      IterableExtensions.<EReference>filter(eClass.getEAllReferences(), _function_3).forEach(_function_4);
      final Function1<EOperation, Boolean> _function_5 = (EOperation it_1) -> {
        EObject _eContainer = it_1.eContainer();
        return Boolean.valueOf(Objects.equal(EcorePackage.Literals.EOBJECT, _eContainer));
      };
      final Consumer<EOperation> _function_6 = (EOperation eOperation) -> {
        EList<EOperationConfig> _eOperations = it.getEOperations();
        EOperationConfig _createConfig = this.createConfig(eOperation);
        _eOperations.add(_createConfig);
      };
      IterableExtensions.<EOperation>reject(eClass.getEAllOperations(), _function_5).forEach(_function_6);
    };
    EClassConfig _doubleArrow = ObjectExtensions.<EClassConfig>operator_doubleArrow(_createEClassConfig, _function);
    return this.<EClassConfig>parseAnnotations(_doubleArrow);
  }
  
  public EAttributeConfig createConfig(final EAttribute eAttribute) {
    EAttributeConfig _createEAttributeConfig = this.config.createEAttributeConfig();
    final Procedure1<EAttributeConfig> _function = (EAttributeConfig it) -> {
      it.setTargetEAttribute(eAttribute);
    };
    EAttributeConfig _doubleArrow = ObjectExtensions.<EAttributeConfig>operator_doubleArrow(_createEAttributeConfig, _function);
    return this.<EAttributeConfig>parseAnnotations(_doubleArrow);
  }
  
  public EContainmentConfig createContainmentConfig(final EReference eContainment) {
    EContainmentConfig _createEContainmentConfig = this.config.createEContainmentConfig();
    final Procedure1<EContainmentConfig> _function = (EContainmentConfig it) -> {
      it.setTargetEContainment(eContainment);
    };
    EContainmentConfig _doubleArrow = ObjectExtensions.<EContainmentConfig>operator_doubleArrow(_createEContainmentConfig, _function);
    return this.<EContainmentConfig>parseAnnotations(_doubleArrow);
  }
  
  public EReferenceConfig createReferenceConfig(final EReference eReference) {
    EReferenceConfig _createEReferenceConfig = this.config.createEReferenceConfig();
    final Procedure1<EReferenceConfig> _function = (EReferenceConfig it) -> {
      it.setTargetEReference(eReference);
    };
    EReferenceConfig _doubleArrow = ObjectExtensions.<EReferenceConfig>operator_doubleArrow(_createEReferenceConfig, _function);
    return this.<EReferenceConfig>parseAnnotations(_doubleArrow);
  }
  
  public EOperationConfig createConfig(final EOperation eOperation) {
    EOperationConfig _createEOperationConfig = this.config.createEOperationConfig();
    final Procedure1<EOperationConfig> _function = (EOperationConfig it) -> {
      it.setTargetEOperation(eOperation);
      final Consumer<EParameter> _function_1 = (EParameter eParameter) -> {
        EList<EParameterConfig> _eParameters = it.getEParameters();
        EParameterConfig _createConfig = this.createConfig(eParameter);
        _eParameters.add(_createConfig);
      };
      eOperation.getEParameters().forEach(_function_1);
    };
    EOperationConfig _doubleArrow = ObjectExtensions.<EOperationConfig>operator_doubleArrow(_createEOperationConfig, _function);
    return this.<EOperationConfig>parseAnnotations(_doubleArrow);
  }
  
  public EParameterConfig createConfig(final EParameter eParameter) {
    EParameterConfig _createEParameterConfig = this.config.createEParameterConfig();
    final Procedure1<EParameterConfig> _function = (EParameterConfig it) -> {
      it.setTargetEParameter(eParameter);
    };
    EParameterConfig _doubleArrow = ObjectExtensions.<EParameterConfig>operator_doubleArrow(_createEParameterConfig, _function);
    return this.<EParameterConfig>parseAnnotations(_doubleArrow);
  }
  
  public <T extends IENamedElementConfig> T parseAnnotations(final T config) {
    final Function1<EAnnotation, Boolean> _function = (EAnnotation it) -> {
      String _source = it.getSource();
      String _nsURI = EcoreDocConfigPackage.eINSTANCE.getNsURI();
      return Boolean.valueOf(Objects.equal(_source, _nsURI));
    };
    final Function1<EAnnotation, EMap<String, String>> _function_1 = (EAnnotation it) -> {
      return it.getDetails();
    };
    final Consumer<Map.Entry<String, String>> _function_2 = (Map.Entry<String, String> it) -> {
      final EStructuralFeature feature = config.eClass().getEStructuralFeature(it.getKey());
      if ((feature instanceof EAttribute)) {
        final Object convertedValue = EcoreUtil.createFromString(((EAttribute)feature).getEAttributeType(), it.getValue());
        config.eSet(feature, convertedValue);
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("invalid EcoreDoc annotation \"");
        String _key = it.getKey();
        _builder.append(_key);
        _builder.append("\" at ");
        ENamedElement _target = config.getTarget();
        _builder.append(_target);
        throw new IllegalArgumentException(_builder.toString());
      }
    };
    Iterables.<Map.Entry<String, String>>concat(IterableExtensions.<EAnnotation, EMap<String, String>>map(IterableExtensions.<EAnnotation>filter(config.getTarget().getEAnnotations(), _function), _function_1)).forEach(_function_2);
    return config;
  }
  
  public EcoreDocGeneratorConfig build() {
    return this.result;
  }
}
