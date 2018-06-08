package com.altran.general.emf.ecoredoc.generator.config;

import com.altran.general.ecoredoc.generator.config.ConfigFactory;
import com.altran.general.ecoredoc.generator.config.EAttributeConfig;
import com.altran.general.ecoredoc.generator.config.EClassConfig;
import com.altran.general.ecoredoc.generator.config.EContainmentConfig;
import com.altran.general.ecoredoc.generator.config.EDataTypeConfig;
import com.altran.general.ecoredoc.generator.config.EEnumConfig;
import com.altran.general.ecoredoc.generator.config.EEnumLiteralConfig;
import com.altran.general.ecoredoc.generator.config.EPackageConfig;
import com.altran.general.ecoredoc.generator.config.EReferenceConfig;
import com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension;
import java.util.Collection;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class EcoreDocConfigBuilder {
  @Extension
  private ConfigFactory config = ConfigFactory.eINSTANCE;
  
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
    return ObjectExtensions.<EPackageConfig>operator_doubleArrow(_createEPackageConfig, _function);
  }
  
  public EDataTypeConfig createConfig(final EDataType eDataType) {
    EDataTypeConfig _createEDataTypeConfig = this.config.createEDataTypeConfig();
    final Procedure1<EDataTypeConfig> _function = (EDataTypeConfig it) -> {
      it.setTargetEDataType(eDataType);
    };
    return ObjectExtensions.<EDataTypeConfig>operator_doubleArrow(_createEDataTypeConfig, _function);
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
    return ObjectExtensions.<EEnumConfig>operator_doubleArrow(_createEEnumConfig, _function);
  }
  
  public EEnumLiteralConfig createConfig(final EEnumLiteral eEnumLiteral) {
    EEnumLiteralConfig _createEEnumLiteralConfig = this.config.createEEnumLiteralConfig();
    final Procedure1<EEnumLiteralConfig> _function = (EEnumLiteralConfig it) -> {
      it.setTargetEEnumLiteral(eEnumLiteral);
    };
    return ObjectExtensions.<EEnumLiteralConfig>operator_doubleArrow(_createEEnumLiteralConfig, _function);
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
    };
    return ObjectExtensions.<EClassConfig>operator_doubleArrow(_createEClassConfig, _function);
  }
  
  public EAttributeConfig createConfig(final EAttribute eAttribute) {
    EAttributeConfig _createEAttributeConfig = this.config.createEAttributeConfig();
    final Procedure1<EAttributeConfig> _function = (EAttributeConfig it) -> {
      it.setTargetEAttribute(eAttribute);
    };
    return ObjectExtensions.<EAttributeConfig>operator_doubleArrow(_createEAttributeConfig, _function);
  }
  
  public EContainmentConfig createContainmentConfig(final EReference eContainment) {
    EContainmentConfig _createEContainmentConfig = this.config.createEContainmentConfig();
    final Procedure1<EContainmentConfig> _function = (EContainmentConfig it) -> {
      it.setTargetEContainment(eContainment);
    };
    return ObjectExtensions.<EContainmentConfig>operator_doubleArrow(_createEContainmentConfig, _function);
  }
  
  public EReferenceConfig createReferenceConfig(final EReference eReference) {
    EReferenceConfig _createEReferenceConfig = this.config.createEReferenceConfig();
    final Procedure1<EReferenceConfig> _function = (EReferenceConfig it) -> {
      it.setTargetEReference(eReference);
    };
    return ObjectExtensions.<EReferenceConfig>operator_doubleArrow(_createEReferenceConfig, _function);
  }
  
  public EcoreDocGeneratorConfig build() {
    return this.result;
  }
}
