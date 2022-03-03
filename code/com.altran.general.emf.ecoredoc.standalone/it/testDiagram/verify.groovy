import org.apache.commons.io.FileUtils
import org.apache.commons.lang3.StringUtils
import static org.junit.Assert.*

assertContentEquals(
	new File(basedir, "EPackage1.ecore.adoc"),
	new File(basedir, "expected.adoc")
)

// Utilities

def assertDoesntExist(File file) {
	assertFalse("exists: " + file, file.exists())
}

def assertIsFile(File file) {
	assertTrue("isFile: " + file, file.isFile())
}

def assertContentEquals(File expectedFile, File actualFile) {
	assertIsFile(actualFile)
	assertIsFile(expectedFile)

	String expected = FileUtils.readFileToString(expectedFile)
	String actual = FileUtils.readFileToString(actualFile)

	assertEquals(normalizeNewline(expected), normalizeNewline(actual))
}

def normalizeNewline(String text) {
	return StringUtils.replaceEach(
		text, 
		(String[]) ["\r\n", "\n\r", "\r"], 
		(String[]) ["\n", "\n", "\n"]
	)
}
