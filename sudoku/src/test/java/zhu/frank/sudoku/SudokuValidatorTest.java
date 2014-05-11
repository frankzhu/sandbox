package zhu.frank.sudoku;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

/**
 * Tests SudokuValidator
 */
@RunWith(JUnit4.class)
public class SudokuValidatorTest {

    /**
     * Test all files under /resources/bad_input
     */
    @Test
    public void testBadInput() {
        runTest("/bad_input", SudokuResultType.BAD_INPUT);
    }

    /**
     * Test all files under /resources/invalid
     */
    @Test
    public void testInvalid() {
        runTest("/invalid", SudokuResultType.INVALID);
    }

    /**
     * Test all files under /resources/valid
     */
    @Test
    public void testValid() {
        runTest("/valid", SudokuResultType.VALID);
    }

    private void runTest(String resourceDirectory, SudokuResultType expectedResultType) {
        try {
            File directory = new File(getClass().getResource(resourceDirectory).toURI());
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.getName().toLowerCase().endsWith(".txt")) {
                    SudokuValidatorResult result = SudokuValidator.validate(file.toURI());
                    assertEquals(String.format("File %s returned %s, expected %s. Found errors: %s", file.getPath(),
                                    result.getResultType(), expectedResultType, result.getErrors()),
                            expectedResultType, result.getResultType()
                    );
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
