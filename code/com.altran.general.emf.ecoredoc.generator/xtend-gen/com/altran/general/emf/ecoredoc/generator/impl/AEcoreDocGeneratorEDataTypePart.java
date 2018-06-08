package com.altran.general.emf.ecoredoc.generator.impl;

import com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.ecoredoc.generator.config.IEDataTypeConfig;
import com.altran.general.emf.ecoredoc.generator.impl.AEcoreDocGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension;
import com.google.common.collect.Multimap;
import java.util.Collections;
import java.util.Map;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public abstract class AEcoreDocGeneratorEDataTypePart extends AEcoreDocGeneratorPart {
  public AEcoreDocGeneratorEDataTypePart(final EcoreDocGeneratorConfig config, final Multimap<EPackage, EClassifier> ePackages) {
    super(config, ePackages);
  }
  
  protected void writeProperties(final Map.Entry<? extends EDataType, ? extends IEDataTypeConfig> entry) {
    final EDataType eDataType = entry.getKey();
    CharSequence _defineDefaultValue = this.defineDefaultValue(eDataType);
    CharSequence _defineInstanceClassName = this.defineInstanceClassName(eDataType);
    CharSequence _defineSerializable = this.defineSerializable(eDataType);
    this.getOutput().append(
      IterableExtensions.join(IterableExtensions.<CharSequence>filterNull(Collections.<CharSequence>unmodifiableList(CollectionLiterals.<CharSequence>newArrayList(_defineDefaultValue, _defineInstanceClassName, _defineSerializable))), EcoreDocExtension.ECLASSIFIER_PROPERTY_SEPARATOR));
    this.getOutput().append(EcoreDocExtension.newline());
  }
  
  protected CharSequence defineSerializable(final EDataType eDataType) {
    CharSequence _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("true");
      final String defaultValue = _builder.toString();
      final boolean value = eDataType.isSerializable();
      _xblockexpression = this.concatProperty("Serializable", defaultValue, Boolean.valueOf(value).toString());
    }
    return _xblockexpression;
  }
}
