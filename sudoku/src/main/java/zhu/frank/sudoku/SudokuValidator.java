package zhu.frank.sudoku;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Check validity of a Sudoku solution.
 *
 */
public class SudokuValidator {

    public static SudokuValidatorResult validate(URI uri) {
        try {
            Path path = Paths.get(uri);
            List<String> lines = Files.readAllLines(path, Charset.defaultCharset());

            // check if numRows is a square of an integer
            int size = lines.size();
            if (size == 0) {
                return new SudokuValidatorResult(SudokuResultType.BAD_INPUT, "No data in file");
            }
            BigDecimal sqRtSize = new BigDecimal(Math.sqrt(size));
            if (sqRtSize.scale() > 0) {
                return new SudokuValidatorResult(SudokuResultType.BAD_INPUT, "Number of rows is not the square of an " +
                        "integer");
            }

            // parse the file
            SudokuGrid sudokuGrid = new SudokuGrid(sqRtSize.intValue());
            for (int rowNum = 0; rowNum < size; rowNum++) {
                String[] row = lines.get(rowNum).split(",");
                if (size != row.length) {
                    return new SudokuValidatorResult(SudokuResultType.BAD_INPUT, String.format("Number of columns in " +
                            "row %d does not match number of rows", rowNum + 1));
                }

                for (int colNum = 0; colNum < row.length; colNum++) {
                    String rawValue = row[colNum];
                    try {
                        Integer value = Integer.valueOf(rawValue);
                        if (value > 0 && value <= size) {
                            sudokuGrid.setValue(rowNum, colNum, value);
                        } else {
                            return new SudokuValidatorResult(SudokuResultType.BAD_INPUT,
                                    String.format("Value %s at row %d, col %d is not valid", rawValue, rowNum + 1,
                                            colNum + 1));
                        }
                    } catch (NumberFormatException e) {
                        return new SudokuValidatorResult(SudokuResultType.BAD_INPUT,
                                String.format("Value %s at row %d, col %d is not an integer", rawValue, rowNum + 1,
                                        colNum + 1));
                    }
                }
            }

            // File parsed. Check validity of solution.
            List<String> errors = sudokuGrid.getErrors();
            if (errors.size() > 0) {
                return new SudokuValidatorResult(SudokuResultType.INVALID, errors);
            } else {
                return new SudokuValidatorResult(SudokuResultType.VALID);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new SudokuValidatorResult(SudokuResultType.BAD_INPUT, "Error reading input");
        }
    }
}
