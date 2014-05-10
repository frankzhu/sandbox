package zhu.frank.sudoku;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Data structure to represent a Sudoku puzzle.
 *
 * @author Frank Zhu
 */
public class Sudoku {

    private int size;
    private int sqRtSize;
    private int[][] rows;
    private int[][] cols;
    private int[][] squares;

    public Sudoku(int sqRtSize) {
        this.sqRtSize = sqRtSize;
        this.size = sqRtSize * sqRtSize;

        this.rows = new int[size][size];
        this.cols = new int[size][size];
        this.squares = new int[size][size];
    }

    public void setValue(int row, int col, int value) {
        List<String> errors = new ArrayList<>();
        this.rows[row][value - 1]++;
        this.cols[col][value - 1]++;

        int squareNum = determineSquareNum(row, col);
        this.squares[squareNum][value - 1]++;
    }

    private int determineSquareNum(int row, int col) {
        int squareRow = (row) / sqRtSize;
        int squareCol = (col) / sqRtSize;
        int squareNum = squareRow * sqRtSize + squareCol;
        return squareNum;
    }
}
