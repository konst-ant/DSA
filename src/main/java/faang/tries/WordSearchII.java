package faang.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC 212: Word Search II.
 * Given a board of characters and a list of words, find all words present on the board
 * by building a Trie of the words and running DFS from each cell.
 * Preconditions: board and words must be non-null; an empty board or empty word list
 * simply yields no matches rather than throwing.
 */
public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || words == null) {
            throw new IllegalArgumentException("board and words must not be null");
        }
        if (board.length == 0 || board[0].length == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        // Building one Trie of all words up front and running a single DFS per board cell
        // against it is what keeps this at O(rows*cols*4^L): the DFS is shared across every
        // word and a branch dies the moment no word's prefix matches, instead of repeating a
        // full O(rows*cols*4^L) board search independently for each of the `words` entries
        // (which would cost O(words * rows*cols*4^L)).
        Node root = new Node();
        for (String word : words) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                cur = cur.children.computeIfAbsent(c, k -> new Node());
            }
            cur.word = word;
        }

        List<String> result = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int r, int c, Node node, List<String> result) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '#') {
            return;
        }
        char ch = board[r][c];
        Node next = node.children.get(ch);
        if (next == null) {
            return;
        }
        if (next.word != null) {
            result.add(next.word);
            next.word = null;
        }
        board[r][c] = '#';
        dfs(board, r + 1, c, next, result);
        dfs(board, r - 1, c, next, result);
        dfs(board, r, c + 1, next, result);
        dfs(board, r, c - 1, next, result);
        board[r][c] = ch;
    }

    public static class Node {
        Map<Character, Node> children = new HashMap<>();
        String word;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(new WordSearchII().findWords(board, words));

        // Edge case: no words to search for.
        System.out.println(new WordSearchII().findWords(board, new String[0]));
    }
}
