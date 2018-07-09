package com.altran.general.emf.ecoredoc.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.change.ChangePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xcore.XcoreStandaloneSetup;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.altran.general.emf.ecoredoc.generator.config.ConfigPackage;

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
			final URI uri = toUri(inputFile);
			
			final Resource resource = resourceSet.getResource(uri, true);
			
			resource.load(Collections.emptyMap());
		}
	}
	
	protected URI toUri(final File file) {
		return URI.createFileURI(file.getAbsolutePath());
	}
	
	public ResourceSetImpl createResourceSet() {
		final ResourceSetImpl resourceSet = new ResourceSetImpl();
		loadEcoreGenmodelForXcorePrimitiveTypes(resourceSet);
		return resourceSet;
	}

	/**
	 * Fix for https://bugs.eclipse.org/bugs/show_bug.cgi?id=536644
	 */
	protected void loadEcoreGenmodelForXcorePrimitiveTypes(final ResourceSet resourceSet) {
		try {
			final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
			final URL resource = contextClassLoader.getResource("model/Ecore.genmodel");
			final URI tgt = URI.createURI(resource.toURI().toString());
			resourceSet.getResource(tgt, true);
		} catch (final URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void setupEcoreStandalone() {
		final Registry packageRegistry = EPackage.Registry.INSTANCE;
		packageRegistry.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		packageRegistry.put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
		
		final EcoreResourceFactoryImpl resourceFactory = new EcoreResourceFactoryImpl();
		final org.eclipse.emf.ecore.resource.Resource.Factory.Registry factoryRegistry = Resource.Factory.Registry.INSTANCE;
		factoryRegistry.getExtensionToFactoryMap().put("ecore", resourceFactory);
		factoryRegistry.getExtensionToFactoryMap().put("genmodel", resourceFactory);
		factoryRegistry.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		
		EcorePackage.eINSTANCE.getClass();
		EcoreFactory.eINSTANCE.getClass();
		
		ChangePackage.eINSTANCE.getClass();

		ConfigPackage.eINSTANCE.getClass();
	}

	public void setupXcoreStandalone() {
		new XcoreStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	public Set<EClassifier> collectInput(final ResourceSetImpl resourceSet, final Collection<File> inputFiles) {
		return inputFiles.stream()
				.map(this::toUri)
				.map(u -> resourceSet.getResource(u, true))
				.map(r -> EcoreUtil.getAllContents(r, false))
				.flatMap(a -> StreamSupport.stream(Spliterators.spliteratorUnknownSize(a, Spliterator.NONNULL), false))
				.filter(EClassifier.class::isInstance)
				.map(EClassifier.class::cast)
				.collect(Collectors.toSet());
	}
	
	public void resolve(final ResourceSetImpl resourceSet, final boolean shouldResolve) {
		if (shouldResolve) {
			EcoreUtil.resolveAll(resourceSet);
		}
	}
}
