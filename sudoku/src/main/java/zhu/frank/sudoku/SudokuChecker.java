package zhu.frank.sudoku;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by fzhu on 5/9/2014.
 */
public class SudokuChecker {
    public static boolean isValidSolution(String filePath) {
        try {
            List<String> rows = Files.readAllLines(Paths.get(filePath), Charset.defaultCharset());

            // check dimension constraints
            int size = rows.size();
            if (size > 0) {
                System.out.println("No data in file");
                return false;
            }
            BigDecimal sqRtSize = new BigDecimal(Math.sqrt(size));
            if (sqRtSize.scale() > 0) {
                System.out.println(String.format("Side length %d is not a square of an integer.", size));
                return false;
            }

            // process the file
            Sudoku sudoku = new Sudoku(sqRtSize.intValue());
            for (int rowNum = 0; rowNum < size; rowNum++) {
                // verify the number of columns match the number of rows
                String[] columns = rows.get(rowNum).split(",");
                if (columns.length != size) {
                    System.out.println(String.format("Number of columns in row %d does not match number of rows", rowNum+1));
                    return false;
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
