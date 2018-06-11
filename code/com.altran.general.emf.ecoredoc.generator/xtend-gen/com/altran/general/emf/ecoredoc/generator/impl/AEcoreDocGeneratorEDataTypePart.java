package com.altran.general.emf.ecoredoc.generator.impl;

import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEDataTypeConfig;
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
    CharSequence _defineDefaultValue = this.defineDefaultValue(entry);
    CharSequence _defineInstanceClassName = this.defineInstanceClassName(entry);
    CharSequence _defineSerializable = this.defineSerializable(entry);
    this.getOutput().append(
      IterableExtensions.join(IterableExtensions.<CharSequence>filterNull(Collections.<CharSequence>unmodifiableList(CollectionLiterals.<CharSequence>newArrayList(_defineDefaultValue, _defineInstanceClassName, _defineSerializable))), EcoreDocExtension.ECLASSIFIER_PROPERTY_SEPARATOR));
    this.getOutput().append(EcoreDocExtension.newline());
  }
  
  protected CharSequence defineSerializable(final Map.Entry<? extends EDataType, ? extends IEDataTypeConfig> entry) {
    CharSequence _xblockexpression = null;
    {
      final EDataType eDataType = entry.getKey();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("true");
      final String defaultValue = _builder.toString();
      final boolean value = eDataType.isSerializable();
      _xblockexpression = this.concatProperty("Serializable", defaultValue, Boolean.valueOf(value).toString(), entry);
    }
    return _xblockexpression;
  }
}
