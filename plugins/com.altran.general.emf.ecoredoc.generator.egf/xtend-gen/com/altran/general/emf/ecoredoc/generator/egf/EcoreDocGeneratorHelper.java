package com.altran.general.emf.ecoredoc.generator.egf;

import com.altran.general.emf.ecoredoc.generator.egf.Activator;
import com.altran.general.emf.ecoredoc.generator.egf.EcoreDocGeneratorTask;
import com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.domain.TypeDomain;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.Viewpoint;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.types.Type;
import org.eclipse.egf.model.types.TypeBoolean;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.egf.portfolio.genchain.tools.utils.ActivityInvocationHelper;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class EcoreDocGeneratorHelper {
  @Extension
  private static final DomainFactory f_domain = DomainFactory.eINSTANCE;
  
  @Extension
  private static final TypesFactory f_types = TypesFactory.eINSTANCE;
  
  private EcoreDocGeneratorHelper() {
  }
  
  public static void addEcoreDocInvocation(final FactoryComponent factoryComponent, final EcoreDocGeneration ecoreDocGeneration) {
    final ResourceSet resourceSet = factoryComponent.eResource().getResourceSet();
    Orchestration _orchestration = factoryComponent.getOrchestration();
    final ProductionPlan pp = ((ProductionPlan) _orchestration);
    EObject _eObject = resourceSet.getEObject(EcoreDocGeneratorHelper.getEcoreDocGeneratorURI(), true);
    final Activity activity = ((Activity) _eObject);
    Viewpoint _viewpoint = factoryComponent.getViewpointContainer().getViewpoint(DomainViewpoint.class);
    final DomainViewpoint dvp = ((DomainViewpoint) _viewpoint);
    final URI uri = URI.createPlatformResourceURI(ecoreDocGeneration.getModelPath(), false);
    Map<String, Type> contract2type = CollectionLiterals.<String, Type>newHashMap();
    TypeDomain _createTypeDomain = EcoreDocGeneratorHelper.f_domain.createTypeDomain();
    final Procedure1<TypeDomain> _function = (TypeDomain it) -> {
      it.setDomain(ActivityInvocationHelper.getDomain(dvp, uri));
    };
    TypeDomain _doubleArrow = ObjectExtensions.<TypeDomain>operator_doubleArrow(_createTypeDomain, _function);
    contract2type.put(EcoreDocGeneratorTask.IN_DOMAIN, _doubleArrow);
    TypeString _createTypeString = EcoreDocGeneratorHelper.f_types.createTypeString();
    final Procedure1<TypeString> _function_1 = (TypeString it) -> {
      it.setValue(ecoreDocGeneration.getOutputFolder());
    };
    TypeString _doubleArrow_1 = ObjectExtensions.<TypeString>operator_doubleArrow(_createTypeString, _function_1);
    contract2type.put(EcoreDocGeneratorTask.IN_OUTPUT_FOLDER, _doubleArrow_1);
    TypeString _createTypeString_1 = EcoreDocGeneratorHelper.f_types.createTypeString();
    final Procedure1<TypeString> _function_2 = (TypeString it) -> {
      it.setValue(ecoreDocGeneration.getProjectName());
    };
    TypeString _doubleArrow_2 = ObjectExtensions.<TypeString>operator_doubleArrow(_createTypeString_1, _function_2);
    contract2type.put(EcoreDocGeneratorTask.IN_PROJECT_NAME, _doubleArrow_2);
    TypeBoolean _createTypeBoolean = EcoreDocGeneratorHelper.f_types.createTypeBoolean();
    final Procedure1<TypeBoolean> _function_3 = (TypeBoolean it) -> {
      it.setValue(Boolean.valueOf(ecoreDocGeneration.isResolve()));
    };
    TypeBoolean _doubleArrow_3 = ObjectExtensions.<TypeBoolean>operator_doubleArrow(_createTypeBoolean, _function_3);
    contract2type.put(EcoreDocGeneratorTask.IN_RESOLVE, _doubleArrow_3);
    ActivityInvocationHelper.addInvocation(pp, activity, contract2type);
  }
  
  public static Set<EClassifier> collectInput(final Iterable<EObject> content) {
    final Function1<EObject, TreeIterator<EObject>> _function = (EObject it) -> {
      return it.eAllContents();
    };
    final Iterator<EObject> eAllSubContents = IteratorExtensions.<EObject, EObject>flatMap(content.iterator(), _function);
    return IteratorExtensions.<EClassifier>toSet(Iterators.<EClassifier>filter(Iterators.<EObject>concat(content.iterator(), eAllSubContents), EClassifier.class));
  }
  
  static URI getEcoreDocGenerationPatternURI() {
    return EcoreDocGeneratorHelper.getEcoreDocFCoreURI().appendFragment("_SV4bABvZEeyUtojcEsGn2w");
  }
  
  static URI getEcoreDocGeneratorURI() {
    return EcoreDocGeneratorHelper.getEcoreDocFCoreURI().appendFragment("_IHAmUBukEey30riYJtK3gQ");
  }
  
  private static URI getEcoreDocFCoreURI() {
    return URI.createPlatformPluginURI(Activator.getPluginID(), false).appendSegment("egf").appendSegment("ecoredoc.fcore");
  }
}
