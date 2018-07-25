package com.altran.general.emf.ecoredoc.maven;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.lang.reflect.Field;

import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.testing.MojoRule;
import org.eclipse.emf.common.util.EList;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig;
import com.altran.general.emf.ecoredoc.generator.config.EClassConfig;
import com.altran.general.emf.ecoredoc.generator.config.EEnumConfig;
import com.altran.general.emf.ecoredoc.generator.config.EPackageConfig;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;

public class EcoreDocMavenTest {
	@Rule
	public MojoRule rule = new MojoRule() {
		@Override
		protected void before() throws Throwable {
		}
		
		@Override
		protected void after() {
		}
	};
	
	@Test
	public void testBasic() throws Exception {
		executeTest("target/test-classes/testBasic/", "target/test-classes/testBasic/expected.adoc");
	}

	@Test
	public void testOperation() throws Exception {
		executeTest("target/test-classes/testOperation/", "target/test-classes/testOperation/expected.adoc");
	}

	@Test
	public void testNoRepeatInherited() throws Exception {
		executeTest("target/test-classes/testNoRepeatInherited/",
				"target/test-classes/testNoRepeatInherited/expected.adoc");
	}
	
	@Test
	public void testNoDefaults() throws Exception {
		executeTest("target/test-classes/testNoDefaults/", "target/test-classes/testNoDefaults/expected.adoc");
	}
	
	@Test
	public void testNoDefaultsButBounds() throws Exception {
		executeTest("target/test-classes/testNoDefaultsButBounds/",
				"target/test-classes/testNoDefaultsButBounds/expected.adoc");
	}
	
	@Test
	public void testReorderNoUseCases() throws Exception {
		executeTest("target/test-classes/testReorderNoUseCases/",
				"target/test-classes/testReorderNoUseCases/expected.adoc");
	}
	
	@Test
	public void testGeneratorConfig() throws Exception {
		executeTest("target/test-classes/testGeneratorConfig/",
				"target/test-classes/testGeneratorConfig/expected.adoc");
	}
	
	@Ignore
	@Test
	public void testSpecificConfig() throws Exception {
		final File pom = new File("target/test-classes/testSpecificConfig/");
		assertNotNull(pom);
		assertTrue(pom.exists());
		
		final EcoredocMavenPlugin ecoredocMojo = (EcoredocMavenPlugin) this.rule.lookupConfiguredMojo(pom, "ecoredoc");
		assertNotNull(ecoredocMojo);
		ecoredocMojo.execute();

		final Field field = ecoredocMojo.getClass().getDeclaredField("config");
		field.setAccessible(true);
		final EcoreDocGeneratorConfig config = (EcoreDocGeneratorConfig) field.get(ecoredocMojo);
		assertFalse(config.isSetRender());
		assertFalse(config.isRenderDefaults());
		final EPackageConfig ePackage1 = findFirst(config.getEPackages(), "EPackage1");
		assertNotNull(ePackage1);
		assertFalse(ePackage1.isSetRenderDefaults());
		final EClassConfig myEClass = findFirst(ePackage1.getEClasses(), "MyEClass");
		assertNotNull(myEClass);
		assertFalse(myEClass.isRepeatInherited());
		final EClassConfig class3 = findFirst(ePackage1.getEClasses(), "Class3");
		final EAttributeConfig specialNumber = findFirst(class3.getEAttributes(), "specialNumber");
		assertNotNull(specialNumber);
		assertFalse(specialNumber.isSetRenderDefaults());
		assertFalse(specialNumber.isRender());
		final EEnumConfig enum1 = findFirst(ePackage1.getEEnums(), "Enum1");
		assertNotNull(enum1);
		assertFalse(enum1.isSetRenderUseCases());
		assertTrue(enum1.isRenderDefaults());
		final EPackageConfig ePackage2 = findFirst(config.getEPackages(), "EPackage2");
		assertNotNull(ePackage2);
		assertTrue(ePackage2.isRenderDefaults());
		
		final File outputFile = (File) this.rule.getVariableValueFromObject(ecoredocMojo, "outputFile");
		assertNotNull(outputFile);
		assertTrue(outputFile.exists());

		final String expected = FileUtils
				.readFileToString(new File("target/test-classes/testSpecificConfig/expected.adoc"));
		final String actual = FileUtils.readFileToString(outputFile);

		assertEquals(expected, actual);
	}

	protected void executeTest(final String pomDir, final String expectedOutputPath) throws Exception {
		final File pom = new File(pomDir);
		assertNotNull(pom);
		assertTrue(pom.exists());
		
		final EcoredocMavenPlugin ecoredocMojo = (EcoredocMavenPlugin) this.rule.lookupConfiguredMojo(pom, "ecoredoc");
		assertNotNull(ecoredocMojo);
		ecoredocMojo.execute();
		
		final File outputFile = (File) this.rule.getVariableValueFromObject(ecoredocMojo, "outputFile");
		assertNotNull(outputFile);
		assertTrue(outputFile.exists());

		final String expected = FileUtils.readFileToString(new File(expectedOutputPath));
		final String actual = FileUtils.readFileToString(outputFile);

		assertEquals(expected, actual);
	}

	protected <T extends IENamedElementConfig> T findFirst(final EList<T> list, final String name) {
		return list.stream()
				.filter(p -> p.getTarget() != null && name.equals(p.getTarget().getName()))
				.findAny()
				.orElse(null);
	}
}

