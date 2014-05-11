package zhu.frank.sudoku;

import java.io.File;

/**
 * Command line driver
 */
public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments provided!");
        } else {
            SudokuValidatorResult result = SudokuValidator.validate(new File(args[0]).toURI());
            for (String error : result.getErrors()) {
                System.out.println(error);
            }
            System.out.println(result.getResultType().name());
        }
    }
}
