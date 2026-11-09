package faang.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 51: N-Queens.
 * Returns all distinct board configurations where n queens are placed on an
 * n x n chessboard such that no two queens attack each other.
 * Precondition: n must be positive.
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be positive");
        }
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n];
        // Tracking occupied columns/diagonals in boolean arrays lets each candidate placement
        // be rejected in O(1) instead of rescanning all previously placed rows (O(row)); the
        // check happens before recursing, so an invalid branch is pruned without ever building
        // a partial (let alone full) board for it.
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // index by (row - col + n - 1)
        boolean[] diag2 = new boolean[2 * n - 1]; // index by (row + col)
        backtrack(0, n, queens, cols, diag1, diag2, result);
        return result;
    }

    private void backtrack(int row, int n, int[] queens, boolean[] cols, boolean[] diag1,
                            boolean[] diag2, List<List<String>> result) {
        if (row == n) {
            result.add(buildBoard(queens, n));
            return;
        }
        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1;
            int d2 = row + col;
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }
            queens[row] = col;
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;
            backtrack(row + 1, n, queens, cols, diag1, diag2, result);
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    private List<String> buildBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int col : queens) {
            StringBuilder row = new StringBuilder();
            for (int c = 0; c < n; c++) {
                row.append(c == col ? 'Q' : '.');
            }
            board.add(row.toString());
        }
        return board;
    }

    public static void main(String[] args) {
        NQueens solver = new NQueens();
        System.out.println(solver.solveNQueens(4));
        System.out.println(solver.solveNQueens(1));

        // Edge case: n = 2 and n = 3 have no valid placement at all.
        System.out.println(solver.solveNQueens(2));
    }
}
