import org.apache.commons.io.FileUtils;
import static org.junit.Assert.*;

File actualFile = new File(basedir, "EPackage1.ecore.adoc");
assertTrue(actualFile.isFile());

File expectedFile = new File(basedir, "expected.adoc");
assertTrue(actualFile.isFile());

String actual = FileUtils.readFileToString(actualFile);
String expected = FileUtils.readFileToString(expectedFile);

assertEquals(expected, actual);
