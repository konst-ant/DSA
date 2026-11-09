package faang.tries;

/**
 * LC 208: Implement Trie (Prefix Tree).
 * Supports insert, search for an exact word, and startsWith for a prefix.
 * Preconditions: none of insert/search/startsWith accept a null argument (empty strings are allowed).
 */
public class ImplementTrie {

    private final Node root = new Node();

    public void insert(String word) {
        requireNonNull(word, "word");
        Node cur = root;
        for (char c : word.toCharArray()) {
            cur = cur.children.computeIfAbsent(c, k -> new Node());
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        requireNonNull(word, "word");
        Node node = find(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        requireNonNull(prefix, "prefix");
        return find(prefix) != null;
    }

    private void requireNonNull(String s, String paramName) {
        if (s == null) {
            throw new IllegalArgumentException(paramName + " must not be null");
        }
    }

    private Node find(String s) {
        Node cur = root;
        for (char c : s.toCharArray()) {
            cur = cur.children.get(c);
            if (cur == null) {
                return null;
            }
        }
        return cur;
    }

    public static class Node {
        java.util.Map<Character, Node> children = new java.util.HashMap<>();
        boolean isWord;
    }

    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));

        // Edge case: empty-string key is a valid word distinct from "app".
        trie.insert("");
        System.out.println(trie.search(""));
    }
}
