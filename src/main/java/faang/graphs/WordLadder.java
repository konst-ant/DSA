package faang.graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * LC 127: Word Ladder.
 * Returns the length of the shortest transformation sequence from beginWord to endWord,
 * changing one letter at a time and only passing through words in the word list, via BFS.
 * Precondition: beginWord, endWord, and wordList must all be non-null.
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, java.util.List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) {
            throw new IllegalArgumentException("beginWord, endWord, and wordList must not be null");
        }
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        dict.remove(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return level;
                }
                char[] chars = word.toCharArray();
                for (int pos = 0; pos < chars.length; pos++) {
                    char original = chars[pos];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) {
                            continue;
                        }
                        chars[pos] = c;
                        String candidate = new String(chars);
                        if (dict.remove(candidate)) {
                            queue.offer(candidate);
                        }
                    }
                    chars[pos] = original;
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder solver = new WordLadder();
        System.out.println(solver.ladderLength("hit", "cog",
                java.util.List.of("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(solver.ladderLength("hit", "cog",
                java.util.List.of("hot", "dot", "dog", "lot", "log")));
    }
}
