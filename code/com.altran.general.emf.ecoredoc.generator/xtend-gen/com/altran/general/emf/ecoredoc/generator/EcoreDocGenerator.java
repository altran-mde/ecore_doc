package com.altran.general.emf.ecoredoc.generator;

import java.util.Arrays;
import java.util.Collection;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;

@SuppressWarnings("all")
public class EcoreDocGenerator {
  private final Collection<? extends EClassifier> input;
  
  private final StringBuilder output = new StringBuilder();
  
  public EcoreDocGenerator(final Collection<? extends EClassifier> input) {
    this.input = input;
  }
  
  public CharSequence generate() {
    for (final EClassifier classifier : this.input) {
      this.render(classifier);
    }
    return this.output.toString();
  }
  
  protected void _render(final EClass clazz) {
  }
  
  protected void _render(final EEnum eenum) {
  }
  
  public void render(final EClassifier eenum) {
    if (eenum instanceof EEnum) {
      _render((EEnum)eenum);
      return;
    } else if (eenum instanceof EClass) {
      _render((EClass)eenum);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eenum).toString());
    }
  }
}
