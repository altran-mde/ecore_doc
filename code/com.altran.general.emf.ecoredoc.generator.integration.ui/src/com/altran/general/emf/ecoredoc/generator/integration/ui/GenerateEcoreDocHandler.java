package com.altran.general.ecoredoc.generator.integration.ui;


import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.io.input.CharSequenceInputStream;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.altran.general.emf.ecoredoc.generator.EcoreDocGenerator;


public class GenerateEcoreDocHandler extends AbstractHandler {
	// All the commented code relates to
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=536644
	//
	// public GenerateEcoreDocHandler() {
	// new EcoreSupport().registerServices(false);
	// new GenModelSupport().registerServices(false);
	//
	// registerEPackageIfMissing(XcorePackage.eNS_URI, XcorePackage.eINSTANCE);
	// registerEPackageIfMissing(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
	// registerEPackageIfMissing(XbasePackage.eNS_URI, XbasePackage.eINSTANCE);
	// registerEPackageIfMissing(TypesPackage.eNS_URI, TypesPackage.eINSTANCE);
	// registerEPackageIfMissing(XtypePackage.eNS_URI, XtypePackage.eINSTANCE);
	// registerEPackageIfMissing(XtextPackage.eNS_URI, XtextPackage.eINSTANCE);
	// registerEPackageIfMissing(GenModelPackage.eNS_URI,
	// GenModelPackage.eINSTANCE);
	// registerEPackageIfMissing(XMLTypePackage.eNS_URI,
	// XMLTypePackage.eINSTANCE);
	// registerEPackageIfMissing(XMLNamespacePackage.eNS_URI,
	// XMLNamespacePackage.eINSTANCE);
	//
	// final EcoreResourceFactoryImpl resourceFactory = new
	// EcoreResourceFactoryImpl();
	// registerResourceFactoryIfMissing("ecore", resourceFactory);
	// registerResourceFactoryIfMissing("genmodel", resourceFactory);
	// registerResourceFactoryIfMissing("xmi", new XMIResourceFactoryImpl());
	// registerResourceFactoryIfMissing("xtextbin", new
	// BinaryGrammarResourceFactoryImpl());
	// }
	
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {

		final ISelection selection = HandlerUtil.getCurrentSelection(event);

		if (selection instanceof IStructuredSelection) {
			final IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			@SuppressWarnings("unchecked")
			final
			Iterator<Object> elements = structuredSelection.iterator();

			// final Injector injector = XcoreActivator.getInstance()
			// .getInjector(XcoreActivator.ORG_ECLIPSE_EMF_ECORE_XCORE_XCORE);
			//
			// final ResourceSet resourceSet =
			// injector.getInstance(ResourceSet.class);
			final ResourceSet resourceSet = new ResourceSetImpl();

			IFile firstFile = null;

			while (elements.hasNext()) {
				final Object element = elements.next();
				if (element instanceof IFile) {
					final IFile file = (IFile) element;
					if (firstFile == null) {
						firstFile = file;
					}
					final String fileName = file.getFullPath().toPortableString();
					final URI uri = URI.createURI(fileName);

					resourceSet.getResource(uri, true);
				}
			}

			if (firstFile != null) {
				final Set<EClassifier> eClassifiers = StreamSupport
						.stream(Spliterators.spliteratorUnknownSize(EcoreUtil.getAllContents(resourceSet, true),
								Spliterator.NONNULL), false)
						.filter(EClassifier.class::isInstance)
						.map(EClassifier.class::cast)
						.collect(Collectors.toSet());

				if (!eClassifiers.isEmpty()) {
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
		}

		return null;
	}

	private void registerEPackageIfMissing(final String nsUri, final EPackage ePackage) {
		final Registry packageRegistry = EPackage.Registry.INSTANCE;
		if (!packageRegistry.containsKey(nsUri)) {
			packageRegistry.put(nsUri, ePackage);
		}
	}

	private void registerResourceFactoryIfMissing(final String extension, final Resource.Factory resourceFactory) {
		final Map<String, Object> extensionRegistry = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		if (!extensionRegistry.containsKey(extension)) {
			extensionRegistry.put(extension, resourceFactory);
		}
	}
}
