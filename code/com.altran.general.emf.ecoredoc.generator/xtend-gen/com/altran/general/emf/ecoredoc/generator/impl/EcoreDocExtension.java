package com.altran.general.emf.ecoredoc.generator.impl;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.util.EcoreUtil;

@SuppressWarnings("all")
public class EcoreDocExtension {
  public String newline() {
    return System.getProperty("line.separator");
  }
  
  public CharSequence getDocumentation(final EModelElement modelElement) {
    final String documentation = EcoreUtil.getDocumentation(modelElement);
    if ((documentation != null)) {
      String _newline = this.newline();
      return (documentation + _newline);
    } else {
      return "";
    }
  }
}
