package com.altran.general.emf.ecoredoc.standalone;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigFactory;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.emf.ecoredoc.util.EcoreDocUtils;
import com.altran.general.emf.ecoredoc.util.EcoreMerger;

public class EcoreDocGenerator {
	
	private final Collection<File> inputFiles;
	
	private boolean resolve = false;
	
	private File outputFile;
	
	private EcoreDocGeneratorConfig config;
	
	public static void main(final String[] args) {
		if (args.length > 0) {
			final List<File> files = new ArrayList<>();
			
			Boolean resolve = null;
			File output = null;
			
			final EcoreDocGeneratorConfig cfg = EcoreDocConfigFactory.eINSTANCE.createEcoreDocGeneratorConfig();
			
			for (int i = 0; i < args.length; i++) {
				final String arg = args[i];
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
						
					case "-defaults":
						cfg.setRenderDefaults(false);
						break;
					case "+defaults":
						cfg.setRenderDefaults(true);
						break;
						
					case "-bounds":
						cfg.setRenderBounds(false);
						break;
					case "+bounds":
						cfg.setRenderBounds(true);
						break;
						
					case "-inherited":
						cfg.setRepeatInherited(false);
						break;
					case "+inherited":
						cfg.setRepeatInherited(true);
						break;
						
					case "-usecases":
						cfg.setRenderUseCases(false);
						break;
					case "+usecases":
						cfg.setRenderUseCases(true);
						break;
						
					case "-subtypes":
						cfg.setRenderSubTypes(false);
						break;
					case "+subtypes":
						cfg.setRenderSubTypes(true);
						break;
						
					case "-supertypes":
						cfg.setRenderSuperTypes(false);
						break;
					case "+supertypes":
						cfg.setRenderSuperTypes(true);
						break;
						
					case "--positionedatatypes":
						i = setInt(args, i, pos -> cfg.setPositionEDataTypes(pos));
						break;
						
					case "--positioneenums":
						i = setInt(args, i, pos -> cfg.setPositionEEnums(pos));
						break;
						
					case "--positioneclasses":
						i = setInt(args, i, pos -> cfg.setPositionEClasses(pos));
						break;
						
					default:
						final File file = new File(arg);
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
					
					if (cfg != null) {
						ecoreDocGenerator.setConfig(cfg);
					}
					
					final File result = ecoreDocGenerator.generate();
					System.out.println("Generated " + result);
				} catch (final IOException e) {
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
	
	protected static int setInt(final String[] args, final int i, final Consumer<Integer> setter) {
		int result = i;
		
		if (args.length > result) {
			result++;
			try {
				final int pos = Integer.parseInt(args[result]);
				setter.accept(pos);
			} catch (final NumberFormatException e) {
				// do nothing
			}
		}
		
		return result;
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
				"  --output <outputFile>: Specify output file name.\n" +
				"  \n" +
				"  --positionEDataTypes <pos>: Set rendering position of all EDataTypes within EPackage\n" +
				"  \n" +
				"  --positionEEnums <pos>:     Set rendering position of all EEnums within EPackage\n" +
				"  \n" +
				"  --positionEClasses <pos>:   Set rendering position of all EClasses within EPackage\n" +
				"  \n" +
				"  [+|-]defaults:   [Enable|disable] rendering of default values\n" +
				"  \n" +
				"  [+|-]bounds:     [Enable|disable] rendering of multiplicity bounds (overwrites defaults parameter)\n"
				+
				"  \n" +
				"  [+|-]inherited:  [Enable|disable] repetition of inherited features\n" +
				"  \n" +
				"  [+|-]useCases:   [Enable|disable] rendering of use cases (references to other usages of this element)\n"
				+
				"  \n" +
				"  [+|-]subTypes:   [Enable|disable] rendering of sub-types\n" +
				"  \n" +
				"  [+|-]superTypes: [Enable|disable] rendering of super-types\n" +
				"\n" +
				"\n" +
				"Examples:\n" +
				"\n" +
				"  EcoreDocGenerator my.ecore\n" +
				"  Generates the documentation of my.ecore into my.ecore.adoc\n" +
				"  \n" +
				"  EcoreDocGenerator some/path/to/my.ecore other.ecore\n" +
				"  Generates the documentation of some/path/to/my.ecore and other.ecore into some/path/to/my.ecore.adoc\n"
				+
				"  \n" +
				"  EcoreDocGenerator -r my.ecore\n" +
				"  Tries to resolve all external references in my.ecore and generates the documentation of my.ecore and referenced models into my.ecore.adoc\n"
				+
				"  \n" +
				"  EcoreDocGenerator -defaults +bounds my.ecore\n" +
				"  Generates the documentation of my.ecore and referenced models into my.ecore.adoc without rendering default values, but still rendering multiplicity bounds\n"
				+
				"  \n" +
				"  EcoreDocGenerator --positionEClasses 1 --positionEEnums 2 --positionEDataTypes 3 my.ecore\n" +
				"  Generates the documentation of my.ecore and referenced models into my.ecore.adoc with all EClasses first, then all EEnums, and finally all EDataTypes\n"
				+
				"  \n" +
				"  EcoreDocGenerator -o output.adoc my.ecore other.ecore\n" +
				"  Generates the documentation of my.ecore and other.ecore into output.adoc\n");
	}
	
	public EcoreDocGenerator(final File... inputFiles) {
		this(Arrays.asList(inputFiles));
	}
	
	public EcoreDocGenerator(final Collection<File> inputFiles) {
		this.inputFiles = inputFiles;
	}
	
	public File generate() throws IOException {
		
		EcoreDocUtils.getInstance().setupEcoreStandalone();
		EcoreDocUtils.getInstance().setupXcoreStandalone();
		
		final ResourceSetImpl resourceSet = EcoreDocUtils.getInstance().createResourceSet();
		
		EcoreDocUtils.getInstance().loadInputModels(resourceSet, this.inputFiles);
		
		EcoreDocUtils.getInstance().resolve(resourceSet, shouldResolve());
		
		final Set<EClassifier> classifiers = EcoreDocUtils.getInstance().collectInput(resourceSet, this.inputFiles);
		
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
		
		if (getConfig() != null) {
			new EcoreMerger<>(generator.getConfig()).merge(getConfig());
		}
		
		final CharSequence result = generator.generate();
		return result;
	}
	
	public boolean shouldResolve() {
		return this.resolve;
	}
	
	public void setResolve(final boolean resolve) {
		this.resolve = resolve;
	}
	
	public File getOutputFile() {
		if (this.outputFile != null) {
			return this.outputFile;
		} else {
			final File firstInputFile = this.inputFiles.iterator().next();
			return new File(firstInputFile.getParentFile(), firstInputFile.getName() + ".adoc");
		}
	}
	
	public void setOutputFile(final File outputFile) {
		this.outputFile = outputFile;
	}
	
	public EcoreDocGeneratorConfig getConfig() {
		return this.config;
	}
	
	public void setConfig(final EcoreDocGeneratorConfig config) {
		this.config = config;
	}
}
