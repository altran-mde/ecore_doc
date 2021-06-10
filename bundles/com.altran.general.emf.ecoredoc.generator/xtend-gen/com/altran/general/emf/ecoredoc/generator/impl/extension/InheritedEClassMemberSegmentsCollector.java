package com.altran.general.emf.ecoredoc.generator.impl.extension;

import com.altran.general.emf.ecoredoc.generator.impl.extension.EcoreDocExtension;
import com.google.common.collect.Iterables;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class InheritedEClassMemberSegmentsCollector {
  @Extension
  private EcoreDocExtension _ecoreDocExtension = new EcoreDocExtension();
  
  protected String[] _collectInheritedEClassMemberSegments(final EOperation eOperation, final EClass eClassThatInherits) {
    Iterable<String> _xblockexpression = null;
    {
      final String ePackageName = this._ecoreDocExtension.getEPackage(eClassThatInherits).getName();
      final String eClassName = eClassThatInherits.getName();
      final String eStructuralFeatureName = eOperation.getName();
      final Function1<EParameter, String> _function = (EParameter it) -> {
        String _name = this._ecoreDocExtension.getEPackage(it.getEType()).getName();
        String _plus = (_name + "_");
        String _name_1 = it.getEType().getName();
        return (_plus + _name_1);
      };
      List<String> _map = ListExtensions.<EParameter, String>map(eOperation.getEParameters(), _function);
      _xblockexpression = Iterables.<String>concat(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(ePackageName, eClassName, eStructuralFeatureName)), _map);
    }
    return ((String[])Conversions.unwrapArray(_xblockexpression, String.class));
  }
  
  protected String[] _collectInheritedEClassMemberSegments(final EStructuralFeature eStructuralFeature, final EClass eClassThatInherits) {
    String[] _xblockexpression = null;
    {
      final String ePackageName = this._ecoreDocExtension.getEPackage(eClassThatInherits).getName();
      final String eClassName = eClassThatInherits.getName();
      final String eStructuralFeatureName = eStructuralFeature.getName();
      _xblockexpression = new String[] { ePackageName, eClassName, eStructuralFeatureName };
    }
    return _xblockexpression;
  }
  
  protected String[] _collectInheritedEClassMemberSegments(final EParameter eParameter, final EClass eClassThatInherits) {
    EObject _eContainer = eParameter.eContainer();
    String[] __collectInheritedEClassMemberSegments = this._collectInheritedEClassMemberSegments(((EOperation) _eContainer), eClassThatInherits);
    String _name = eParameter.getName();
    return ((String[])Conversions.unwrapArray(Iterables.<String>concat(((Iterable<? extends String>)Conversions.doWrapArray(__collectInheritedEClassMemberSegments)), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_name))), String.class));
  }
  
  public String[] collectInheritedEClassMemberSegments(final ETypedElement eOperation, final EClass eClassThatInherits) {
    if (eOperation instanceof EOperation) {
      return _collectInheritedEClassMemberSegments((EOperation)eOperation, eClassThatInherits);
    } else if (eOperation instanceof EParameter) {
      return _collectInheritedEClassMemberSegments((EParameter)eOperation, eClassThatInherits);
    } else if (eOperation instanceof EStructuralFeature) {
      return _collectInheritedEClassMemberSegments((EStructuralFeature)eOperation, eClassThatInherits);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eOperation, eClassThatInherits).toString());
    }
  }
}
