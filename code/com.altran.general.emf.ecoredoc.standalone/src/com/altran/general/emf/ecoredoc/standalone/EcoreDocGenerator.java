package com.altran.general.emf.ecoredoc.standalone;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
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

public class EcoreDocGenerator {

	private final Collection<File> inputFiles;

	private boolean resolve = false;

	private File outputFile;

	public static void main(String[] args) {
		if (args.length > 0) {
			List<File> files = new ArrayList<>();

			Boolean resolve = null;
			File output = null;

			for (int i = 0; i < args.length; i++) {
				String arg = args[i];
				switch (arg.toLowerCase()) {
				case "-r":
				case "--resolve":
					resolve = true;
					break;

				case "-o":
				case "--output":
					if (args.length > i) {
						i++;
						output = new File(args[i]);
						if (output.isDirectory() || (output.exists() && !output.canWrite())) {
							System.err.println("Cannot write to output " + output);
							System.exit(-2);
						}
					}
					break;

				default:
					File file = new File(arg);
					if (file.canRead() && file.isFile()) {
						files.add(file);
					} else {
						System.err.println("Cannot read, ignoring input " + file);
					}
					break;
				}
			}

			if (!files.isEmpty()) {
				try {
					final EcoreDocGenerator ecoreDocGenerator = new EcoreDocGenerator(files);

					if (resolve != null) {
						ecoreDocGenerator.setResolve(resolve);
					}

					if (output != null) {
						ecoreDocGenerator.setOutputFile(output);
					}

					final File result = ecoreDocGenerator.generate();
					System.out.println("Generated " + result);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.err.println("Cannot read any file");
				System.exit(-1);
			}
		} else {
			printUsage();
		}
	}

	private static void printUsage() {
		System.out.println("Generates reference documentation for ecore models.\n" + 
				"\n" + 
				"The output is inspired by JavaDoc and formatted in AsciiDoctor format.\n" + 
				"AsciiDoctor can easily be rendered to HTML, PDF, or Eclipse help.\n" + 
				"\n" + 
				"\n" + 
				"Usage:\n" + 
				"\n" + 
				"EcoreDocGenerator [parameters] [List of ecore files to generate]\n" + 
				"\n" + 
				"If unspecified, the output file name will be \"<firstEcoreFile.ecore>.adoc\"\n" + 
				"\n" + 
				"\n" + 
				"Parameters:\n" + 
				"\n" + 
				"  -r,\n" + 
				"  --resolve: Resolve external references\n" + 
				"  \n" + 
				"  -o <outputFile>,\n" + 
				"  --output <outputFile>: Specifiy output file name.\n" + 
				"\n" + 
				"\n" + 
				"Examples:\n" + 
				"\n" + 
				"  EcoreDocGenerator my.ecore\n" + 
				"  Generates the documentation of my.ecore into my.ecore.adoc\n" + 
				"  \n" + 
				"  EcoreDocGenerator some/path/to/my.ecore other.ecore\n" + 
				"  Generates the documentation of some/path/to/my.ecore and other.ecore into some/path/to/my.ecore.adoc\n" + 
				"  \n" + 
				"  EcoreDocGenerator -r my.ecore\n" + 
				"  Tries to resolve all external references in my.ecore and generates the documentation of my.ecore and referenced models into my.ecore.adoc\n" + 
				"  \n" + 
				"  EcoreDocGenerator -o output.adoc my.ecore other.ecore\n" + 
				"  Generates the documentation of my.ecore and other.ecore into output.adoc\n");
	}

	public EcoreDocGenerator(File... inputFiles) {
		this(Arrays.asList(inputFiles));
	}

	public EcoreDocGenerator(Collection<File> inputFiles) {
		this.inputFiles = inputFiles;
	}

	public File generate() throws IOException {

		setupEcoreStandalone();

		final ResourceSetImpl resourceSet = createResourceSet();

		loadInputModels(resourceSet);
		
		resolve(resourceSet);

		final Set<EClassifier> classifiers = collectInput(resourceSet);

		final CharSequence result = generate(classifiers);

		final File output = writeOutput(result);

		return output;
	}

	private File writeOutput(final CharSequence result) throws IOException {
		final File output = getOutputFile();
		try (final FileWriter outputWriter = new FileWriter(output)) {
			outputWriter.append(result);
		}
		return output;
	}

	private CharSequence generate(final Set<EClassifier> classifiers) {
		final com.altran.general.emf.ecoredoc.generator.EcoreDocGenerator generator = new com.altran.general.emf.ecoredoc.generator.EcoreDocGenerator(
				classifiers);

		final CharSequence result = generator.generate();
		return result;
	}

	private Set<EClassifier> collectInput(final ResourceSetImpl resourceSet) {
		final TreeIterator<Object> allContents = EcoreUtil.getAllContents(resourceSet, true);

		final Set<EClassifier> classifiers = StreamSupport
				.stream(Spliterators.spliteratorUnknownSize(allContents, Spliterator.NONNULL), false)
				.filter(EClassifier.class::isInstance)
				.map(EClassifier.class::cast)
				.collect(Collectors.toSet());
		return classifiers;
	}

	private void resolve(final ResourceSetImpl resourceSet) {
		if (shouldResolve()) {
			EcoreUtil.resolveAll(resourceSet);
		}
	}

	private void loadInputModels(final ResourceSetImpl resourceSet) throws IOException {
		for (File inputFile : this.inputFiles) {
			final URI uri = URI.createFileURI(inputFile.getAbsolutePath());

			final Resource resource = resourceSet.getResource(uri, true);

			resource.load(Collections.emptyMap());

		}
	}

	private ResourceSetImpl createResourceSet() {
		final ResourceSetImpl resourceSet = new ResourceSetImpl();

//		final Map<URI, URI> computePlatformURIMap = EcorePlugin.computePlatformURIMap(true);
//		final Map<URI, URI> uriMap = resourceSet.getURIConverter().getURIMap();
//		uriMap.putAll(computePlatformURIMap);
		return resourceSet;
	}

	private void setupEcoreStandalone() {
		final Registry packageRegistry = EPackage.Registry.INSTANCE;
		packageRegistry.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		EcoreResourceFactoryImpl resourceFactory = new EcoreResourceFactoryImpl();
		final org.eclipse.emf.ecore.resource.Resource.Factory.Registry factoryRegistry = Resource.Factory.Registry.INSTANCE;
		factoryRegistry.getExtensionToFactoryMap().put("ecore", resourceFactory);
		factoryRegistry.getExtensionToFactoryMap().put("genmodel", resourceFactory);
		factoryRegistry.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		EcorePackage.eINSTANCE.getClass();
		EcoreFactory.eINSTANCE.getClass();

		ChangePackage.eINSTANCE.getClass();
	}

	public boolean shouldResolve() {
		return resolve;
	}

	public void setResolve(boolean resolve) {
		this.resolve = resolve;
	}

	public File getOutputFile() {
		if (this.outputFile != null) {
			return outputFile;
		} else {
			File firstInputFile = this.inputFiles.iterator().next();
			return new File(firstInputFile.getParentFile(), firstInputFile.getName() + ".adoc");
		}
	}

	public void setOutputFile(File outputFile) {
		this.outputFile = outputFile;
	}
}
