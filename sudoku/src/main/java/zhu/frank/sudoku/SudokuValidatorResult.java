package zhu.frank.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Result of SudokuValidator. Indicates the result type and a list of errors.
 */
public class SudokuValidatorResult {
    private SudokuResultType resultType;
    private List<String> errors = new ArrayList<>();

    public SudokuValidatorResult(SudokuResultType resultType) {
        this.resultType = resultType;
    }

    public SudokuValidatorResult(SudokuResultType resultType, String errorMessage) {
        this.resultType = resultType;
        this.errors = Arrays.asList(errorMessage);
    }

    public SudokuValidatorResult(SudokuResultType resultType, List<String> errors) {
        this.resultType = resultType;
        this.errors = errors;
    }

    public SudokuResultType getResultType() {
        return resultType;
    }

    public List<String> getErrors() {
        return errors;
    }
}
