package com.altran.general.emf.ecoredoc.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class EcoreDocGenerator {
  private final Collection<? extends EClassifier> input;
  
  private final StringBuilder output = new StringBuilder();
  
  private Multimap<EPackage, EClassifier> packages = TreeMultimap.<EPackage, EClassifier>create(
    ((Comparator<EPackage>) (EPackage o1, EPackage o2) -> {
      return o1.getName().compareTo(o2.getName());
    }), 
    ((Comparator<EClassifier>) (EClassifier o1, EClassifier o2) -> {
      return o1.getName().compareTo(o2.getName());
    }));
  
  public EcoreDocGenerator(final Collection<? extends EClassifier> input) {
    this.input = input;
  }
  
  public CharSequence generate() {
    this.writeIntro();
    this.collectPackages();
    Set<EPackage> _keySet = this.packages.keySet();
    for (final EPackage pack : _keySet) {
      {
        this.writePackageIntro(pack.getName());
        final Collection<EDataType> dataTypes = this.collectDataTypes(pack);
        final List<EClass> eclasses = this.collectPackageEClasses(pack);
        final Collection<EEnum> eenums = this.collectEEnums(pack);
        this.writeDataTypes(dataTypes);
        this.writeEnumerations(eenums);
        this.writeClasses(eclasses);
        for (final EClass ec : eclasses) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("EClass ");
          String _name = ec.getName();
          _builder.append(_name);
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          String _writeDescription = this.writeDescription(ec);
          _builder.append(_writeDescription);
          _builder.newLineIfNotEmpty();
          this.output.append(_builder);
        }
      }
    }
    return this.output.toString();
  }
  
  public void writeClasses(final Collection<EClass> classes) {
    boolean _isEmpty = classes.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeClassesHeader();
      final EPackage pack = this.getPackage(((EClassifier[])Conversions.unwrapArray(classes, EClassifier.class))[0]);
      for (final EClass eclass : classes) {
        {
          this.writeEClassHeader(eclass);
          this.writeEClass(eclass);
        }
      }
    }
  }
  
  public void writeAttributes(final EClass eclass) {
    final String packageName = this.getPackage(eclass).getName();
    EList<EAttribute> _eAllAttributes = eclass.getEAllAttributes();
    for (final EAttribute attr : _eAllAttributes) {
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
      this.output.append(_builder);
    }
  }
  
  public CharSequence writeAttributesHeader(final EClass eclass) {
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
  
  public CharSequence writeCols() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[cols=\"<15m,<15,<15m,<15m,<40a\",options=\"header\"]");
    return _builder;
  }
  
  public void writeEClass(final EClass eclass) {
    StringConcatenation _builder = new StringConcatenation();
    String _writeDescription = this.writeDescription(eclass);
    _builder.append(_writeDescription);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _writeSuperTypes = this.writeSuperTypes(eclass);
    _builder.append(_writeSuperTypes);
    _builder.newLineIfNotEmpty();
    CharSequence _writeAttributesHeader = this.writeAttributesHeader(eclass);
    _builder.append(_writeAttributesHeader);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    this.output.append(_builder);
    this.writeAttributes(eclass);
  }
  
  public CharSequence writeSuperTypes(final EClass eclass) {
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
  
  public StringBuilder writeClassesHeader() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("=== Classes");
    _builder.newLine();
    _builder.newLine();
    return this.output.append(_builder);
  }
  
  public StringBuilder writeIntro() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// White Up-Pointing Triangle");
    _builder.newLine();
    _builder.append(":wupt: &#9651;");
    _builder.newLine();
    _builder.newLine();
    _builder.append(":inherited: {wupt}{nbsp}");
    _builder.newLine();
    _builder.newLine();
    _builder.append(":table-caption!:");
    _builder.newLine();
    _builder.newLine();
    _builder.append("= Ecore Documentation");
    _builder.newLine();
    _builder.append(":toc:");
    _builder.newLine();
    _builder.append(":toclevels: 4");
    _builder.newLine();
    _builder.newLine();
    return this.output.append(_builder);
  }
  
  public StringBuilder writePackageIntro(final String packageName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[[");
    _builder.append(packageName);
    _builder.append("]]");
    _builder.newLineIfNotEmpty();
    _builder.append("== Contents of ");
    _builder.append(packageName);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return this.output.append(_builder);
  }
  
  public void writeEnumerations(final Collection<EEnum> eenums) {
    boolean _isEmpty = eenums.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeEnumerationsHeader();
      final EPackage pack = this.getPackage(((EClassifier[])Conversions.unwrapArray(eenums, EClassifier.class))[0]);
      for (final EEnum eenum : eenums) {
        {
          this.writeEnumHeader(eenum);
          this.writeEnumLiterals(eenum, pack);
          this.writeUseCases(eenum);
        }
      }
    }
  }
  
  public StringBuilder writeEnumHeader(final EEnum eenum) {
    StringBuilder _xblockexpression = null;
    {
      this.writeEClassifierHeader(eenum);
      StringConcatenation _builder = new StringConcatenation();
      String _writeDescription = this.writeDescription(eenum);
      _builder.append(_writeDescription);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append(".Literals");
      _builder.newLine();
      _builder.append("[cols=\"<20m,>10m,<70a\",options=\"header\"]");
      _builder.newLine();
      _builder.append("|===");
      _builder.newLine();
      _builder.append("|Symbol");
      _builder.newLine();
      _builder.append("|Value");
      _builder.newLine();
      _builder.append("|Description");
      _builder.newLine();
      _builder.newLine();
      _xblockexpression = this.output.append(_builder);
    }
    return _xblockexpression;
  }
  
  public String writeDescription(final EClassifier eclassifier) {
    return EcoreUtil.getDocumentation(eclassifier);
  }
  
  public StringBuilder writeEClassifierHeader(final EClassifier eclassifier) {
    StringBuilder _xblockexpression = null;
    {
      final EPackage pack = this.getPackage(eclassifier);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[[");
      String _name = pack.getName();
      _builder.append(_name);
      _builder.append("-");
      String _name_1 = eclassifier.getName();
      _builder.append(_name_1);
      _builder.append("]]");
      _builder.newLineIfNotEmpty();
      _builder.append("==== ");
      String _name_2 = eclassifier.getName();
      _builder.append(_name_2);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = this.output.append(_builder);
    }
    return _xblockexpression;
  }
  
  public StringBuilder writeEClassHeader(final EClass eclass) {
    StringBuilder _xblockexpression = null;
    {
      final EPackage pack = this.getPackage(eclass);
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
      _xblockexpression = this.output.append(_builder);
    }
    return _xblockexpression;
  }
  
  public StringBuilder writeEnumerationsHeader() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("=== Enumerations");
    _builder.newLine();
    _builder.newLine();
    return this.output.append(_builder);
  }
  
  public StringBuilder writeEnumLiterals(final EEnum eenum, final EPackage pack) {
    StringBuilder _xblockexpression = null;
    {
      EList<EEnumLiteral> _eLiterals = eenum.getELiterals();
      for (final EEnumLiteral literal : _eLiterals) {
        this.writeLiteral(literal);
      }
      _xblockexpression = this.writeBlockClosure();
    }
    return _xblockexpression;
  }
  
  public StringBuilder writeBlockClosure() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("|===");
    _builder.newLine();
    _builder.newLine();
    return this.output.append(_builder);
  }
  
  public StringBuilder writeLiteral(final EEnumLiteral literal) {
    StringBuilder _xblockexpression = null;
    {
      EObject _eContainer = literal.eContainer();
      final EEnum eenum = ((EEnum) _eContainer);
      EObject _eContainer_1 = eenum.eContainer();
      final EPackage pack = ((EPackage) _eContainer_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("|");
      String _name = literal.getName();
      _builder.append(_name);
      _builder.append("[[");
      String _name_1 = pack.getName();
      _builder.append(_name_1);
      _builder.append("-");
      String _name_2 = eenum.getName();
      _builder.append(_name_2);
      _builder.append("-");
      String _name_3 = literal.getName();
      _builder.append(_name_3);
      _builder.append("]]");
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      int _value = literal.getValue();
      _builder.append(_value);
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      String _documentation = EcoreUtil.getDocumentation(literal);
      _builder.append(_documentation);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = this.output.append(_builder);
    }
    return _xblockexpression;
  }
  
  public EPackage getPackage(final EClassifier eclassifier) {
    EObject _eContainer = eclassifier.eContainer();
    return ((EPackage) _eContainer);
  }
  
  /**
   * Displays the dataTypes of the EPackage and where they are used in.
   */
  public void writeDataTypes(final Collection<EDataType> dataTypes) {
    boolean _isEmpty = dataTypes.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeDataTypesHeader();
      final EPackage pack = this.getPackage(((EClassifier[])Conversions.unwrapArray(dataTypes, EClassifier.class))[0]);
      for (final EDataType dataType : dataTypes) {
        {
          this.writeDataType(pack.getName(), dataType.getName());
          this.writeUseCases(dataType);
        }
      }
    }
  }
  
  public StringBuilder writeDataType(final String packageName, final String dataTypeName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[[");
    _builder.append(packageName);
    _builder.append("-");
    _builder.append(dataTypeName);
    _builder.append("]]");
    _builder.newLineIfNotEmpty();
    _builder.append("==== ");
    _builder.append(dataTypeName);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return this.output.append(_builder);
  }
  
  public StringBuilder writeDataTypesHeader() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("=== Data Types");
    _builder.newLine();
    _builder.newLine();
    _builder.append("TODO: Create template for EDataType");
    _builder.newLine();
    _builder.newLine();
    return this.output.append(_builder);
  }
  
  /**
   * Displays in which classes the given dataType is used.
   * Goes through every class and then every attribute and it compare the dataType.name with the attribute type name.
   */
  public void writeUseCases(final EClassifier target) {
    boolean anyMatch = false;
    final Function1<EClass, Boolean> _function = (EClass it) -> {
      return Boolean.valueOf(Objects.equal(it, target));
    };
    final Iterable<EClass> eclasses = IterableExtensions.<EClass>reject(this.collectAllEClasses(), _function);
    final ArrayList<String> useCaseStrings = CollectionLiterals.<String>newArrayList();
    for (final EClass eclass : eclasses) {
      EList<EStructuralFeature> _eAllStructuralFeatures = eclass.getEAllStructuralFeatures();
      for (final EStructuralFeature feature : _eAllStructuralFeatures) {
        EClassifier _eType = feature.getEType();
        boolean _equals = Objects.equal(_eType, target);
        if (_equals) {
          anyMatch = true;
          EObject _eContainer = eclass.eContainer();
          final String packageName = ((EPackage) _eContainer).getName();
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("* <<");
          _builder.append(packageName);
          _builder.append("-");
          String _name = eclass.getName();
          _builder.append(_name);
          _builder.append("-");
          String _name_1 = feature.getName();
          _builder.append(_name_1);
          _builder.append(", ");
          _builder.append(packageName);
          _builder.append(".");
          String _name_2 = eclass.getName();
          _builder.append(_name_2);
          _builder.append(".");
          String _name_3 = feature.getName();
          _builder.append(_name_3);
          _builder.append(">>");
          _builder.newLineIfNotEmpty();
          useCaseStrings.add(_builder.toString());
        }
      }
    }
    if (anyMatch) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(".Used at");
      _builder_1.newLine();
      this.output.append(_builder_1);
      List<String> _sort = IterableExtensions.<String>sort(useCaseStrings);
      for (final String useCaseString : _sort) {
        this.output.append(useCaseString);
      }
      this.output.append(this.newline());
    }
  }
  
  public String newline() {
    return System.getProperty("line.separator");
  }
  
  public void collectPackages() {
    for (final EClassifier eclassifier : this.input) {
      EObject _eContainer = eclassifier.eContainer();
      this.packages.put(((EPackage) _eContainer), eclassifier);
    }
  }
  
  public Collection<EEnum> collectEEnums(final EPackage pack) {
    return IterableExtensions.<EEnum>toSet(Iterables.<EEnum>filter(this.packages.get(pack), EEnum.class));
  }
  
  public Collection<EClass> collectAllEClasses() {
    return IterableExtensions.<EClass>toSet(Iterables.<EClass>filter(this.packages.values(), EClass.class));
  }
  
  public List<EClass> collectPackageEClasses(final EPackage pack) {
    final Function1<EClass, String> _function = (EClass it) -> {
      return it.getName();
    };
    return IterableExtensions.<EClass, String>sortBy(Iterables.<EClass>filter(this.packages.get(pack), EClass.class), _function);
  }
  
  public Collection<EDataType> collectDataTypes(final EPackage pack) {
    final Function1<EDataType, Boolean> _function = (EDataType it) -> {
      return Boolean.valueOf((!(it instanceof EEnum)));
    };
    return IterableExtensions.<EDataType>toSet(IterableExtensions.<EDataType>filter(Iterables.<EDataType>filter(this.packages.get(pack), EDataType.class), _function));
  }
  
  protected CharSequence _writeEClassifierType(final EClass clazz) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Class");
    return _builder;
  }
  
  protected CharSequence _writeEClassifierType(final EEnum eenum) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Enum");
    return _builder;
  }
  
  protected CharSequence _writeEClassifierType(final EDataType dataType) {
    return null;
  }
  
  public CharSequence writeEClassifierType(final EClassifier eenum) {
    if (eenum instanceof EEnum) {
      return _writeEClassifierType((EEnum)eenum);
    } else if (eenum instanceof EClass) {
      return _writeEClassifierType((EClass)eenum);
    } else if (eenum instanceof EDataType) {
      return _writeEClassifierType((EDataType)eenum);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eenum).toString());
    }
  }
}
