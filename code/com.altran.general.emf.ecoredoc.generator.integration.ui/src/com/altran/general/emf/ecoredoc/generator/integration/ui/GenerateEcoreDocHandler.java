package com.altran.general.emf.ecoredoc.generator.integration.ui;


import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.input.CharSequenceInputStream;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.altran.general.emf.ecoredoc.generator.EcoreDocGenerator;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;


public class GenerateEcoreDocHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		
		final ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (selection instanceof IStructuredSelection) {
			final IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			@SuppressWarnings("unchecked")
			final Iterator<Object> elements = structuredSelection.iterator();
			
			final ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap(true));

			IFile firstFile = null;
			final Set<EClassifier> eClassifiers = Sets.newLinkedHashSet();
			
			while (elements.hasNext()) {
				final Object element = elements.next();
				if (element instanceof IFile) {
					final IFile file = (IFile) element;
					if (firstFile == null) {
						firstFile = file;
					}
					final String fileName = file.getFullPath().toPortableString();
					final URI uri = URI.createURI(fileName);
					
					final Resource resource = resourceSet.getResource(uri, true);
					eClassifiers.addAll(Sets.newHashSet(
							Iterators.filter(EcoreUtil.getAllContents(resource, false), EClassifier.class)));
				}
			}
			
			if (firstFile != null && !eClassifiers.isEmpty()) {
				final EcoreDocGenerator generator = new EcoreDocGenerator(eClassifiers);
				
				final CharSequence text = generator.generate();
				
				final IFile outputFile = firstFile.getParent().getFile(new Path(firstFile.getName() + ".adoc"));
				try {
					outputFile.create(new CharSequenceInputStream(text, "utf-8"), true, null);
					outputFile.setCharset("utf-8", null);
				} catch (final CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
}
