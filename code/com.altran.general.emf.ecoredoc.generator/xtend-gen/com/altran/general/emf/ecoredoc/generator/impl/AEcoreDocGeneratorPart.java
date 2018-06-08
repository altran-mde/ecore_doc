package com.altran.general.emf.ecoredoc.generator.impl;

import com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig;
import com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig;
import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public abstract class AEcoreDocGeneratorPart {
  @Extension
  protected EcoreDocExtension _ecoreDocExtension = new EcoreDocExtension();
  
  private final EcoreDocGeneratorConfig config;
  
  private final Multimap<EPackage, EClassifier> ePackages;
  
  private StringBuilder output;
  
  public AEcoreDocGeneratorPart(final EcoreDocGeneratorConfig config, final Multimap<EPackage, EClassifier> ePackages) {
    this.config = config;
    this.ePackages = ePackages;
  }
  
  protected abstract StringBuilder write(final EPackage ePackage);
  
  protected void clearOutput() {
    StringBuilder _stringBuilder = new StringBuilder();
    this.output = _stringBuilder;
  }
  
  protected Multimap<EPackage, EClassifier> getEPackages() {
    return this.ePackages;
  }
  
  protected EcoreDocGeneratorConfig getConfig() {
    return this.config;
  }
  
  protected StringBuilder getOutput() {
    StringBuilder _xblockexpression = null;
    {
      if ((this.output == null)) {
        throw new IllegalStateException("Tried to write to output before clearing it");
      }
      _xblockexpression = this.output;
    }
    return _xblockexpression;
  }
  
  protected CharSequence concatReferenceName(final ENamedElement eNamedElement) {
    return this._ecoreDocExtension.joinReference(((Collection<? extends CharSequence>)Conversions.doWrapArray(this._ecoreDocExtension.collectTypeSegments(eNamedElement))));
  }
  
  protected CharSequence _concatLinkTo(final ENamedElement eNamedElement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("`<<");
    CharSequence _concatAnchor = this._ecoreDocExtension.concatAnchor(eNamedElement);
    _builder.append(_concatAnchor);
    _builder.append(", ");
    CharSequence _concatReferenceName = this.concatReferenceName(eNamedElement);
    _builder.append(_concatReferenceName);
    _builder.append(">>`");
    return _builder;
  }
  
  protected CharSequence _concatLinkTo(final EDataType eDataType) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultDataType = this._ecoreDocExtension.isDefaultEDataType(eDataType);
      CharSequence _xifexpression = null;
      if (defaultDataType) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("`");
        String _name = eDataType.getName();
        _builder.append(_name);
        _builder.append("`");
        _xifexpression = _builder;
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("`<<");
        CharSequence _concatAnchor = this._ecoreDocExtension.concatAnchor(eDataType);
        _builder_1.append(_concatAnchor);
        _builder_1.append(", ");
        CharSequence _concatReferenceName = this.concatReferenceName(eDataType);
        _builder_1.append(_concatReferenceName);
        _builder_1.append(">>`");
        _xifexpression = _builder_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected CharSequence concatUsedLink(final EStructuralFeature eStructuralFeature, final EClass eClassThatInherits) {
    CharSequence _xblockexpression = null;
    {
      final String[] inheritedFeatureSegments = this.collectInheritedFeatureSegments(eStructuralFeature, eClassThatInherits);
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _joinAnchor = this._ecoreDocExtension.joinAnchor(((Collection<? extends CharSequence>)Conversions.doWrapArray(inheritedFeatureSegments)));
      _builder.append(_joinAnchor);
      final CharSequence anchor = _builder;
      StringConcatenation _builder_1 = new StringConcatenation();
      CharSequence _joinReference = this._ecoreDocExtension.joinReference(((Collection<? extends CharSequence>)Conversions.doWrapArray(inheritedFeatureSegments)));
      _builder_1.append(_joinReference);
      final CharSequence reference = _builder_1;
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("`<<");
      _builder_2.append(anchor);
      _builder_2.append(", ");
      _builder_2.append(reference);
      _builder_2.append(">>`");
      _xblockexpression = _builder_2;
    }
    return _xblockexpression;
  }
  
  protected String[] collectInheritedFeatureSegments(final EStructuralFeature eStructuralFeature, final EClass eClassThatInherits) {
    String[] _xblockexpression = null;
    {
      final String ePackageName = this._ecoreDocExtension.getEPackage(eClassThatInherits).getName();
      final String eClassName = eClassThatInherits.getName();
      final String eStructuralFeatureName = eStructuralFeature.getName();
      _xblockexpression = new String[] { ePackageName, eClassName, eStructuralFeatureName };
    }
    return _xblockexpression;
  }
  
  protected void writeUseCases(final Pair<? extends EClassifier, ? extends IEcoreDocGeneratorConfig> pair) {
    EClassifier _key = pair.getKey();
    IEcoreDocGeneratorConfig _value = pair.getValue();
    AbstractMap.SimpleEntry<EClassifier, IEcoreDocGeneratorPartConfig> _simpleEntry = new AbstractMap.SimpleEntry<EClassifier, IEcoreDocGeneratorPartConfig>(_key, ((IEcoreDocGeneratorPartConfig) _value));
    this.writeUseCases(_simpleEntry);
  }
  
  protected void writeUseCases(final Map.Entry<? extends EClassifier, ? extends IEcoreDocGeneratorPartConfig> entry) {
    final EClassifier target = entry.getKey();
    boolean anyMatch = false;
    final Collection<EClass> eClasses = this.collectAllEClasses();
    final ArrayList<String> useCaseStrings = CollectionLiterals.<String>newArrayList();
    final Function1<EClass, String> _function = (EClass it) -> {
      String _elvis = null;
      String _name = it.getName();
      if (_name != null) {
        _elvis = _name;
      } else {
        _elvis = "";
      }
      return _elvis;
    };
    final List<EClass> sortedEClasses = IterableExtensions.<EClass, String>sortBy(eClasses, _function);
    for (final EClass eClass : sortedEClasses) {
      {
        final Function1<EStructuralFeature, String> _function_1 = (EStructuralFeature it) -> {
          String _elvis = null;
          String _name = it.getName();
          if (_name != null) {
            _elvis = _name;
          } else {
            _elvis = "";
          }
          return _elvis;
        };
        final List<EStructuralFeature> sortedEStructuralFeatures = IterableExtensions.<EStructuralFeature, String>sortBy(eClass.getEAllStructuralFeatures(), _function_1);
        for (final EStructuralFeature feature : sortedEStructuralFeatures) {
          EClassifier _eType = feature.getEType();
          boolean _equals = Objects.equal(_eType, target);
          if (_equals) {
            anyMatch = true;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("* ");
            CharSequence _concatUsedLink = this.concatUsedLink(feature, eClass);
            _builder.append(_concatUsedLink);
            _builder.newLineIfNotEmpty();
            useCaseStrings.add(_builder.toString());
          }
        }
      }
    }
    if (anyMatch) {
      StringConcatenation _builder = new StringConcatenation();
      String _newline = EcoreDocExtension.newline();
      _builder.append(_newline);
      _builder.newLineIfNotEmpty();
      _builder.append(".Used at");
      _builder.newLine();
      this.output.append(_builder);
      List<String> _sort = IterableExtensions.<String>sort(useCaseStrings);
      for (final String useCaseString : _sort) {
        this.output.append(useCaseString);
      }
    }
  }
  
  protected CharSequence defineDefaultValue(final EClassifier eClassifier) {
    CharSequence _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_undefined_");
      final String defaultValue = _builder.toString();
      String _xifexpression = null;
      boolean _eIsSet = eClassifier.eIsSet(EcorePackage.eINSTANCE.getEClassifier_DefaultValue());
      if (_eIsSet) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("`");
        Object _defaultValue = eClassifier.getDefaultValue();
        _builder_1.append(_defaultValue);
        _builder_1.append("`");
        _xifexpression = _builder_1.toString();
      } else {
        _xifexpression = null;
      }
      final String value = _xifexpression;
      _xblockexpression = this.concatProperty("Default Value", defaultValue, value);
    }
    return _xblockexpression;
  }
  
  protected CharSequence defineInstanceClassName(final EClassifier eClassifier) {
    CharSequence _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_undefined_");
      final String defaultValue = _builder.toString();
      String _xifexpression = null;
      boolean _eIsSet = eClassifier.eIsSet(EcorePackage.eINSTANCE.getEClassifier_InstanceClassName());
      if (_eIsSet) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("`");
        String _instanceClassName = eClassifier.getInstanceClassName();
        _builder_1.append(_instanceClassName);
        _builder_1.append("`");
        _xifexpression = _builder_1.toString();
      } else {
        _xifexpression = null;
      }
      final String value = _xifexpression;
      _xblockexpression = this.concatProperty("Instance Type Name", defaultValue, value);
    }
    return _xblockexpression;
  }
  
  protected CharSequence concatProperty(final String name, final String defaultValue, final String value) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(name);
    _builder.append(":: ");
    {
      if ((value != null)) {
        _builder.append(value);
      } else {
        _builder.append(defaultValue);
      }
    }
    return _builder;
  }
  
  protected CharSequence tableFooter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("|===");
    _builder.newLine();
    return _builder;
  }
  
  protected Collection<EClass> collectAllEClasses() {
    return IterableExtensions.<EClass>toSet(Iterables.<EClass>filter(this.ePackages.values(), EClass.class));
  }
  
  protected CharSequence concatLinkTo(final ENamedElement eDataType) {
    if (eDataType instanceof EDataType) {
      return _concatLinkTo((EDataType)eDataType);
    } else if (eDataType != null) {
      return _concatLinkTo(eDataType);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eDataType).toString());
    }
  }
}
