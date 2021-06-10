package com.altran.general.emf.ecoredoc.generator.impl.extension;

import com.altran.general.emf.ecoredoc.generator.impl.extension.EcoreDocExtension;
import com.altran.general.emf.ecoredoc.generator.impl.extension.InheritedEClassMemberSegmentsCollector;
import com.altran.general.emf.ecoredoc.generator.impl.extension.TypeSegmentsCollector;
import java.util.Arrays;
import java.util.Collection;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AnchorExtension {
  public static final String ANCHOR_SEPARATOR = "-";
  
  public static final String REFERENCE_SEPARATOR = ".{zwsp}";
  
  @Extension
  private EcoreDocExtension _ecoreDocExtension = new EcoreDocExtension();
  
  @Extension
  private TypeSegmentsCollector _typeSegmentsCollector = new TypeSegmentsCollector();
  
  @Extension
  private InheritedEClassMemberSegmentsCollector _inheritedEClassMemberSegmentsCollector = new InheritedEClassMemberSegmentsCollector();
  
  public CharSequence joinAnchor(final Collection<? extends CharSequence> segments) {
    final Function1<CharSequence, String> _function = (CharSequence it) -> {
      return it.toString();
    };
    final Function1<String, Boolean> _function_1 = (String it) -> {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
      return Boolean.valueOf((!_isNullOrEmpty));
    };
    final Function1<String, String> _function_2 = (String it) -> {
      return it.replaceAll("[^a-zA-Z0-9_-]", ":");
    };
    return IterableExtensions.join(IterableExtensions.<String, String>map(IterableExtensions.<String>filter(IterableExtensions.map(segments, _function), _function_1), _function_2), AnchorExtension.ANCHOR_SEPARATOR);
  }
  
  public CharSequence joinReference(final Collection<? extends CharSequence> segments) {
    final Function1<CharSequence, String> _function = (CharSequence it) -> {
      return it.toString();
    };
    final Function1<String, Boolean> _function_1 = (String it) -> {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
      return Boolean.valueOf((!_isNullOrEmpty));
    };
    return IterableExtensions.join(IterableExtensions.<String>filter(IterableExtensions.map(segments, _function), _function_1), AnchorExtension.REFERENCE_SEPARATOR);
  }
  
  protected CharSequence _concatAnchor(final ENamedElement eNamedElement) {
    return this.joinAnchor(((Collection<? extends CharSequence>)Conversions.doWrapArray(this._typeSegmentsCollector.collectTypeSegments(eNamedElement))));
  }
  
  protected CharSequence _concatAnchor(final EDataType eDataType) {
    CharSequence _xifexpression = null;
    boolean _isDefaultEDataType = this._ecoreDocExtension.isDefaultEDataType(eDataType);
    boolean _not = (!_isDefaultEDataType);
    if (_not) {
      _xifexpression = this.joinAnchor(((Collection<? extends CharSequence>)Conversions.doWrapArray(this._typeSegmentsCollector.collectTypeSegments(eDataType))));
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  protected CharSequence _concatAnchor(final EOperation eOperation) {
    EObject _eContainer = eOperation.eContainer();
    return this.joinAnchor(((Collection<? extends CharSequence>)Conversions.doWrapArray(this._inheritedEClassMemberSegmentsCollector.collectInheritedEClassMemberSegments(eOperation, ((EClass) _eContainer)))));
  }
  
  protected CharSequence _concatReferenceName(final ENamedElement eNamedElement) {
    return this.joinReference(((Collection<? extends CharSequence>)Conversions.doWrapArray(this._typeSegmentsCollector.collectTypeSegments(eNamedElement))));
  }
  
  protected CharSequence _concatReferenceName(final EOperation eOperation) {
    CharSequence _joinReference = this.joinReference(((Collection<? extends CharSequence>)Conversions.doWrapArray(this._typeSegmentsCollector.collectTypeSegments(eOperation))));
    String _plus = (_joinReference + "(");
    final Function1<EParameter, String> _function = (EParameter it) -> {
      return it.getName();
    };
    String _join = IterableExtensions.join(ListExtensions.<EParameter, String>map(eOperation.getEParameters(), _function), ", ");
    String _plus_1 = (_plus + _join);
    return (_plus_1 + ")");
  }
  
  public CharSequence concatAnchor(final ENamedElement eDataType) {
    if (eDataType instanceof EDataType) {
      return _concatAnchor((EDataType)eDataType);
    } else if (eDataType instanceof EOperation) {
      return _concatAnchor((EOperation)eDataType);
    } else if (eDataType != null) {
      return _concatAnchor(eDataType);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eDataType).toString());
    }
  }
  
  public CharSequence concatReferenceName(final ENamedElement eOperation) {
    if (eOperation instanceof EOperation) {
      return _concatReferenceName((EOperation)eOperation);
    } else if (eOperation != null) {
      return _concatReferenceName(eOperation);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eOperation).toString());
    }
  }
}
