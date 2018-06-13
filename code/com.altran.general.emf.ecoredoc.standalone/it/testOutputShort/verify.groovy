import org.apache.commons.io.FileUtils;
import static org.junit.Assert.*;

File notActualFile = new File(basedir, "EPackage1.ecore.adoc")
assertFalse(notActualFile.exists());

File actualFile = new File(basedir, "output.adoc");
assertTrue(actualFile.isFile());

File expectedFile = new File(basedir, "expected.adoc");
assertTrue(actualFile.isFile());

String actual = FileUtils.readFileToString(actualFile);
String expected = FileUtils.readFileToString(expectedFile);

assertEquals(expected, actual);
