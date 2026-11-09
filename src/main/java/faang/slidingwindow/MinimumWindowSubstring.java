package faang.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 76: Minimum Window Substring.
 * Find the smallest substring of s that contains every character of t, including duplicates.
 * Throws IllegalArgumentException if s or t is null.
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("s and t must not be null");
        }
        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.merge(c, 1, Integer::sum);
        }

        Map<Character, Integer> window = new HashMap<>();
        int required = need.size();
        int formed = 0;
        int left = 0;
        int bestLength = Integer.MAX_VALUE;
        int bestStart = 0;

        // Time: O(|s| + |t|), Space: O(|t|) (window/need maps are bounded by distinct chars in t).
        // left only ever advances, never resets, so each character is added/removed from the
        // window at most once across the whole scan - the window shrink loop doesn't make this
        // quadratic.
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.merge(c, 1, Integer::sum);
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            while (formed == required) {
                if (right - left + 1 < bestLength) {
                    bestLength = right - left + 1;
                    bestStart = left;
                }
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }
                left++;
            }
        }

        return bestLength == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLength);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution.minWindow("a", "a"));
        System.out.println(solution.minWindow("a", "aa")); // no valid window exists: returns ""
        System.out.println(solution.minWindow("", "a")); // empty s: returns ""
    }
}
