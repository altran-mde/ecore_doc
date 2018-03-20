package com.altran.general.emf.ecoredoc.generator;

import com.altran.general.emf.ecoredoc.generator.AEcoreDocGeneratorPart;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ClassGeneratorPart extends AEcoreDocGeneratorPart {
  public ClassGeneratorPart(final Multimap<EPackage, EClassifier> packages) {
    super(packages);
  }
  
  @Override
  public StringBuilder write(final EPackage pack) {
    final List<EClass> eclasses = this.collectPackageEClasses(pack);
    this.writeClasses(eclasses);
    return this.getOutput();
  }
  
  protected List<EClass> collectPackageEClasses(final EPackage pack) {
    final Function1<EClass, String> _function = (EClass it) -> {
      return it.getName();
    };
    return IterableExtensions.<EClass, String>sortBy(Iterables.<EClass>filter(this.getPackages().get(pack), EClass.class), _function);
  }
  
  protected void writeClasses(final Collection<EClass> classes) {
    boolean _isEmpty = classes.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeClassesHeader();
      for (final EClass eclass : classes) {
        {
          this.writeEClassHeader(eclass);
          this.writeEClass(eclass);
        }
      }
    }
  }
  
  protected StringBuilder writeClassesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("=== Classes");
    _builder.newLine();
    _builder.newLine();
    return _output.append(_builder);
  }
  
  protected StringBuilder writeEClassHeader(final EClass eclass) {
    StringBuilder _xblockexpression = null;
    {
      final EPackage pack = this.getPackage(eclass);
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[[");
      String _name = pack.getName();
      _builder.append(_name);
      _builder.append("-");
      String _name_1 = eclass.getName();
      _builder.append(_name_1);
      _builder.append("]]");
      _builder.newLineIfNotEmpty();
      _builder.append("==== ");
      {
        if ((eclass.isAbstract() && (!eclass.isInterface()))) {
          _builder.append("Abstract ");
        }
      }
      {
        boolean _isInterface = eclass.isInterface();
        if (_isInterface) {
          _builder.append("Interface");
        } else {
          _builder.append("Class");
        }
      }
      _builder.append(" ");
      String _name_2 = eclass.getName();
      _builder.append(_name_2);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _output.append(_builder);
    }
    return _xblockexpression;
  }
  
  protected void writeEClass(final EClass eclass) {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _documentation = this.getDocumentation(eclass);
    _builder.append(_documentation);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _writeSuperTypes = this.writeSuperTypes(eclass);
    _builder.append(_writeSuperTypes);
    _builder.newLineIfNotEmpty();
    CharSequence _writeAttributesHeader = this.writeAttributesHeader(eclass);
    _builder.append(_writeAttributesHeader);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _output.append(_builder);
    this.writeAttributes(eclass);
  }
  
  protected CharSequence writeSuperTypes(final EClass eclass) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(".Supertypes");
    _builder.newLine();
    {
      EList<EClass> _eAllSuperTypes = eclass.getEAllSuperTypes();
      for(final EClass supertype : _eAllSuperTypes) {
        _builder.append("* <<");
        {
          if ((supertype instanceof EClass)) {
            String _name = this.getPackage(supertype).getName();
            _builder.append(_name);
            _builder.append("-");
            String _name_1 = supertype.getName();
            _builder.append(_name_1);
            _builder.append(", ");
            String _name_2 = this.getPackage(supertype).getName();
            _builder.append(_name_2);
            _builder.append(".");
            String _name_3 = supertype.getName();
            _builder.append(_name_3);
          }
        }
        _builder.append(">>");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence writeAttributesHeader(final EClass eclass) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(".Attributes");
    _builder.newLine();
    CharSequence _writeCols = this.writeCols();
    _builder.append(_writeCols);
    _builder.newLineIfNotEmpty();
    _builder.append("|===");
    _builder.newLine();
    _builder.append("|Name");
    _builder.newLine();
    _builder.append("|Type");
    _builder.newLine();
    _builder.append("|Multiplicity{nbsp}/ Order");
    _builder.newLine();
    _builder.append("|Default Value");
    _builder.newLine();
    _builder.append("|Description");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence writeCols() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[cols=\"<15m,<15,<15m,<15m,<40a\",options=\"header\"]");
    return _builder;
  }
  
  protected void writeAttributes(final EClass eclass) {
    final String packageName = this.getPackage(eclass).getName();
    EList<EAttribute> _eAllAttributes = eclass.getEAllAttributes();
    for (final EAttribute attr : _eAllAttributes) {
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("|");
      String _name = attr.getName();
      _builder.append(_name);
      _builder.append("[[");
      _builder.append(packageName);
      _builder.append("-");
      String _name_1 = eclass.getName();
      _builder.append(_name_1);
      _builder.append("-");
      String _name_2 = attr.getName();
      _builder.append(_name_2);
      _builder.append("]]");
      _builder.newLineIfNotEmpty();
      _builder.append("|<<");
      _builder.append(packageName);
      _builder.append("-");
      String _name_3 = attr.getEAttributeType().getName();
      _builder.append(_name_3);
      _builder.append(", ");
      _builder.append(packageName);
      _builder.append(".");
      String _name_4 = attr.getEAttributeType().getName();
      _builder.append(_name_4);
      _builder.append(">>");
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      _builder.newLine();
      _builder.append("|");
      _builder.newLine();
      _builder.append("|");
      String _documentation = EcoreUtil.getDocumentation(attr);
      _builder.append(_documentation);
      _builder.newLineIfNotEmpty();
      _output.append(_builder);
    }
  }
}
