package faang.advancedgraphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * LC 269: Alien Dictionary.
 * Given a sorted list of words from an alien language, derives a valid character
 * ordering via topological sort, returning "" if no valid ordering exists.
 * Precondition: words must be non-null and must not contain null entries.
 */
public class AlienDictionary {

    public String alienOrder(String[] words) {
        if (words == null) {
            throw new IllegalArgumentException("words must not be null");
        }
        for (String word : words) {
            if (word == null) {
                throw new IllegalArgumentException("words must not contain null entries");
            }
        }
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        // Each adjacent pair of words only ever needs to be compared up to their first
        // differing character to derive one ordering edge - comparing every pair of words
        // against each other (rather than just neighbors in the already-sorted list) would be
        // wasteful and still only yield the same edges. This keeps edge derivation at O(total
        // characters), and the subsequent Kahn's-style BFS topological sort is O(V+E) in the
        // resulting character graph.
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            if (first.length() > second.length() && first.startsWith(second)) {
                return "";
            }
            int minLen = Math.min(first.length(), second.length());
            for (int j = 0; j < minLen; j++) {
                char c1 = first.charAt(j);
                char c2 = second.charAt(j);
                if (c1 != c2) {
                    if (graph.get(c1).add(c2)) {
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        Deque<Character> queue = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            result.append(c);
            for (char next : graph.get(c)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        return result.length() == inDegree.size() ? result.toString() : "";
    }

    public static void main(String[] args) {
        AlienDictionary solver = new AlienDictionary();
        System.out.println(solver.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
        System.out.println(solver.alienOrder(new String[]{"z", "x"}));
        System.out.println(solver.alienOrder(new String[]{"z", "x", "z"}));

        // Edge case: a single word just yields its own distinct characters, in any valid order.
        System.out.println(solver.alienOrder(new String[]{"abc"}));
    }
}
