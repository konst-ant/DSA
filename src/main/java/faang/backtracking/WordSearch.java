package faang.backtracking;

/**
 * LC 79: Word Search.
 * Determines whether a given word can be constructed from adjacent cells in a grid,
 * where each cell may be used at most once.
 * Precondition: board and word must be non-null, and the board must have at least one cell.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            throw new IllegalArgumentException("board and word must not be null");
        }
        if (board.length == 0 || board[0].length == 0) {
            throw new IllegalArgumentException("board must have at least one cell");
        }
        int rows = board.length;
        int cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, r, c, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }
        char temp = board[r][c];
        board[r][c] = '#';
        boolean found = dfs(board, r + 1, c, word, index + 1)
                || dfs(board, r - 1, c, word, index + 1)
                || dfs(board, r, c + 1, word, index + 1)
                || dfs(board, r, c - 1, word, index + 1);
        board[r][c] = temp;
        return found;
    }

    public static void main(String[] args) {
        WordSearch solver = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(solver.exist(board, "ABCCED"));
        System.out.println(solver.exist(board, "SEE"));
        System.out.println(solver.exist(board, "ABCB"));
    }
}
