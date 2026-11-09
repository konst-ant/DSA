package faang.arrayshashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 36: Valid Sudoku.
 * Determine if a 9x9 Sudoku board is valid: each row, column, and 3x3 sub-box has no repeated digits.
 * Throws IllegalArgumentException if board is null or is not exactly 9x9.
 */
public class ValidSudoku {

    private static final int BOARD_SIZE = 9;
    private static final int BOX_SIZE = 3;
    private static final char EMPTY_CELL = '.';

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != BOARD_SIZE) {
            throw new IllegalArgumentException("board must not be null and must have exactly 9 rows");
        }
        Set<String> seen = new HashSet<>();
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (board[row] == null || board[row].length != BOARD_SIZE) {
                throw new IllegalArgumentException("each board row must not be null and must have exactly 9 columns");
            }
            for (int col = 0; col < BOARD_SIZE; col++) {
                char value = board[row][col];
                if (value == EMPTY_CELL) {
                    continue;
                }
                String rowKey = "r" + row + value;
                String colKey = "c" + col + value;
                String boxKey = "b" + (row / BOX_SIZE) + (col / BOX_SIZE) + value;
                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku solution = new ValidSudoku();
        char[][] valid = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] invalid = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(solution.isValidSudoku(valid));
        System.out.println(solution.isValidSudoku(invalid));

        char[][] allEmpty = new char[BOARD_SIZE][BOARD_SIZE];
        for (char[] boardRow : allEmpty) {
            Arrays.fill(boardRow, EMPTY_CELL);
        }
        System.out.println(solution.isValidSudoku(allEmpty)); // all-empty board edge case
    }
}
