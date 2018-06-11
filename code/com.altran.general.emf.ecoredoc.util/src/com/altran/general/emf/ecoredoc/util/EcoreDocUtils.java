package com.altran.general.emf.ecoredoc.util;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.change.ChangePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class EcoreDocUtils {
	private static EcoreDocUtils instance;
	
	public static EcoreDocUtils getInstance() {
		if (instance == null) {
			instance = new EcoreDocUtils();
		}
		
		return instance;
	}
	
	protected EcoreDocUtils() {
		// avoid instantiation
	}
	
	public void loadInputModels(final ResourceSetImpl resourceSet, final Collection<File> inputFiles)
			throws IOException {
		for (final File inputFile : inputFiles) {
			final URI uri = URI.createFileURI(inputFile.getAbsolutePath());

			final Resource resource = resourceSet.getResource(uri, true);

			resource.load(Collections.emptyMap());

		}
	}

	public ResourceSetImpl createResourceSet() {
		final ResourceSetImpl resourceSet = new ResourceSetImpl();
		return resourceSet;
	}

	public void setupEcoreStandalone() {
		final Registry packageRegistry = EPackage.Registry.INSTANCE;
		packageRegistry.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		final EcoreResourceFactoryImpl resourceFactory = new EcoreResourceFactoryImpl();
		final org.eclipse.emf.ecore.resource.Resource.Factory.Registry factoryRegistry = Resource.Factory.Registry.INSTANCE;
		factoryRegistry.getExtensionToFactoryMap().put("ecore", resourceFactory);
		factoryRegistry.getExtensionToFactoryMap().put("genmodel", resourceFactory);
		factoryRegistry.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		EcorePackage.eINSTANCE.getClass();
		EcoreFactory.eINSTANCE.getClass();

		ChangePackage.eINSTANCE.getClass();
	}

	public Set<EClassifier> collectInput(final ResourceSetImpl resourceSet) {
		final TreeIterator<Object> allContents = EcoreUtil.getAllContents(resourceSet, true);

		final Set<EClassifier> classifiers = StreamSupport
				.stream(Spliterators.spliteratorUnknownSize(allContents, Spliterator.NONNULL), false)
				.filter(EClassifier.class::isInstance)
				.map(EClassifier.class::cast)
				.collect(Collectors.toSet());
		return classifiers;
	}

	public void resolve(final ResourceSetImpl resourceSet, final boolean shouldResolve) {
		if (shouldResolve) {
			EcoreUtil.resolveAll(resourceSet);
		}
	}

	
}
