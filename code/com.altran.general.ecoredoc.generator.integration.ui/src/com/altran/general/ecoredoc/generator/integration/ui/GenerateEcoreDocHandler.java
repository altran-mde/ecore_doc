package com.altran.general.ecoredoc.generator.integration.ui;


import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xcore.XcoreStandaloneSetup;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.altran.general.emf.ecoredoc.generator.EcoreDocGenerator;
import com.google.inject.Injector;


public class GenerateEcoreDocHandler extends AbstractHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		boolean isStructuredSelection = selection instanceof IStructuredSelection;
			
		if (isStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			@SuppressWarnings("unchecked")
			Iterator<Object> elements = structuredSelection.iterator();
			
			LinkedHashSet<EClassifier> eClassifiers = new LinkedHashSet<EClassifier>();
			
			while(elements.hasNext()) {
				Object element = elements.next();
				boolean isIFile = element instanceof IFile;
				
				if(isIFile) {
					IFile file = (IFile) element;
					String fileName = file.getName();
					URI uri = URI.createURI(fileName);
				
					XcoreStandaloneSetup xcore = new XcoreStandaloneSetup();
					Injector injector = xcore.createInjectorAndDoEMFRegistration();
//					ResourceSet resourceSet = injector.getInstance(ResourceSet);
//					Resource resource = resourceSet.getResource(uri, true);
//					List<EObject> eObjects = resource.getContents();
//					
//					for(EObject eObject : eObjects) {
//						boolean isEPackage = eObject instanceof EPackage;
//						
//						if(isEPackage) {
//							EPackage ePackage = (EPackage) eObject;
//							eClassifiers.addAll(ePackage.getEClassifiers());
//						}
//					}
				}
			}
			
			EcoreDocGenerator generator = new EcoreDocGenerator(eClassifiers);
					
		} 
			
		return null;
	}

}
