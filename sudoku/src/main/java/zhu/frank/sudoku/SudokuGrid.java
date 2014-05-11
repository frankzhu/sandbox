package zhu.frank.sudoku;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Data structure to keep track of a Sudoku solution's validity. Each row, column, and square is represented by a
 * BitSet where the bit at index N is set to true if N exists in that row, column, or square.
 *
 * @author Frank Zhu
 */
public class SudokuGrid {

    private int size;
    private int sqRtSize;

    private BitSet[] rows;
    private BitSet[] cols;
    private BitSet[] squares;

    /**
     * Create new Sudoku instance.
     *
     * @param sqRtSize square root of length of sides
     */
    public SudokuGrid(int sqRtSize) {
        this.sqRtSize = sqRtSize;
        this.size = sqRtSize * sqRtSize;

        this.rows = new BitSet[size];
        this.cols = new BitSet[size];
        this.squares = new BitSet[size];
        for (int i = 0; i < size; i++) {
            this.rows[i] = new BitSet(size);
            this.cols[i] = new BitSet(size);
            this.squares[i] = new BitSet(size);
        }
    }

    /**
     * Sets a cell value.
     *
     * @param row 0-indexed
     * @param col 0-indexed
     * @param value
     */
    public void setValue(int row, int col, int value) {
        this.rows[row].set(value - 1);
        this.cols[col].set(value - 1);
        this.squares[determineSquareNum(row, col)].set(value - 1);
    }

    /**
     * Determine which square number a cell belongs to.
     *
     * @param row
     * @param col
     * @return
     */
    private int determineSquareNum(int row, int col) {
        int squareRow = row / sqRtSize;
        int squareCol = col / sqRtSize;
        int squareNum = squareRow * sqRtSize + squareCol;
        return squareNum;
    }

    /**
     *
     * @return a list of error messages indicating which rows, columns, and squares are invalid.
     */
    public List<String> getErrors() {
        List<String> errors = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (rows[i].cardinality() != size) {
                errors.add(String.format("Row %d is not valid", i + 1));
            }
            if (cols[i].cardinality() != size) {
                errors.add(String.format("Column %d is not valid", i + 1));
            }
            if (squares[i].cardinality() != size) {
                errors.add(String.format("Square %d is not valid", i + 1));
            }
        }
        return errors;
    }
}
