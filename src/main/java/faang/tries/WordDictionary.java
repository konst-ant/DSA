package faang.tries;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 211: Design Add and Search Words Data Structure.
 * Supports adding words and searching with '.' as a wildcard matching any single character.
 * Preconditions: addWord and search reject a null word.
 */
public class WordDictionary {

    private final Node root = new Node();

    public void addWord(String word) {
        if (word == null) {
            throw new IllegalArgumentException("word must not be null");
        }
        Node cur = root;
        for (char c : word.toCharArray()) {
            cur = cur.children.computeIfAbsent(c, k -> new Node());
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        if (word == null) {
            throw new IllegalArgumentException("word must not be null");
        }
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Node node) {
        if (node == null) {
            return false;
        }
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (Node child : node.children.values()) {
                if (dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        }
        return dfs(word, index + 1, node.children.get(c));
    }

    public static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isWord;
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println(wd.search("pad"));
        System.out.println(wd.search(".ad"));
        System.out.println(wd.search("b.."));

        // Edge case: pattern made entirely of wildcards, same length as a stored word.
        System.out.println(wd.search("..."));
    }
}
