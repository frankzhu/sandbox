package zhu.frank.sudoku;

/**
 * Possible result types for the SudokuValidator.
 */
public enum SudokuResultType {
    BAD_INPUT,  // error reading file or bad input (empty file, wrong dimensions, or bad cell values)
    VALID,      // valid solution
    INVALID;    // invalid solution (missing/duplicate values in a row, column, or square)
}
