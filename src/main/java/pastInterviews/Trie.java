package pastInterviews;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsW
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 */

class Trie {
    public static final Character SENTINEL = '$';

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        System.out.println(trie.search("app"));
//        System.out.println(trie.startsWith("app"));
    }

    private Node root;

    private static class Node {
        Character symbol;
        Map<Character, Node> children;

        public Node() {
            this.children = new HashMap<>(26);
        }

        public Node(Character symbol) {
            this.symbol = symbol;
            this.children = new HashMap<>(26);
        }


    }

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node next = root;

        for (Character c : word.toCharArray()) {
            Node node = new Node(c);
            if (next.children.containsKey(c)) {
                next = next.children.get(c);
            } else {
                next.children.put(c, node);
                next = node;
            }
        }
        next.children.put(SENTINEL, null);
    }

    public boolean search(String word) {
        Node node = searchInternally(word);
        if (node == null) {
            return false;
        } else if (node.children.containsKey(SENTINEL)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        Node node = searchInternally(prefix);
        return node != null;
    }

    private Node searchInternally(String word) {
        Node next = root;

        for (Character c : word.toCharArray()) {
            if (next.children.containsKey(c)) {
                next = next.children.get(c);
            } else {
                return null;
            }
        }
        return next;
    }
}