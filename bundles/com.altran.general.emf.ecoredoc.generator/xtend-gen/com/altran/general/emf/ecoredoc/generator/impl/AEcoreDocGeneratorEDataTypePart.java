package com.altran.general.emf.ecoredoc.generator.impl;

import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.emf.ecoredoc.generator.configbuilder.IEDataTypeConfigPair;
import com.altran.general.emf.ecoredoc.generator.impl.AEcoreDocGeneratorEClassifierPart;
import com.altran.general.emf.ecoredoc.generator.impl.extension.EcoreDocExtension;
import com.google.common.collect.Multimap;
import com.google.inject.Injector;
import java.util.Collections;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public abstract class AEcoreDocGeneratorEDataTypePart extends AEcoreDocGeneratorEClassifierPart {
  public AEcoreDocGeneratorEDataTypePart(final EcoreDocGeneratorConfig config, final Multimap<EPackage, EClassifier> ePackages, final Injector xcoreInjector) {
    super(config, ePackages, xcoreInjector);
  }
  
  protected void writeProperties(final IEDataTypeConfigPair<?, ?> pair) {
    CharSequence _defineDefaultValue = this.defineDefaultValue(pair);
    CharSequence _defineInstanceClassName = this.defineInstanceClassName(pair);
    CharSequence _defineSerializable = this.defineSerializable(pair);
    this.getOutput().append(
      IterableExtensions.join(IterableExtensions.<CharSequence>filterNull(Collections.<CharSequence>unmodifiableList(CollectionLiterals.<CharSequence>newArrayList(_defineDefaultValue, _defineInstanceClassName, _defineSerializable))), EcoreDocExtension.ECLASSIFIER_PROPERTY_SEPARATOR));
    this.getOutput().append(EcoreDocExtension.newline());
  }
  
  protected CharSequence defineSerializable(final IEDataTypeConfigPair<?, ?> pair) {
    CharSequence _xblockexpression = null;
    {
      final EDataType eDataType = pair.getElement();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("true");
      final String defaultValue = _builder.toString();
      String _xifexpression = null;
      boolean _eIsSet = eDataType.eIsSet(EcorePackage.eINSTANCE.getEDataType_Serializable());
      if (_eIsSet) {
        _xifexpression = Boolean.valueOf(eDataType.isSerializable()).toString();
      } else {
        _xifexpression = null;
      }
      final String value = _xifexpression;
      _xblockexpression = this.concatProperty("Serializable", defaultValue, value, pair);
    }
    return _xblockexpression;
  }
}
