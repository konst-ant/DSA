package faang.slidingwindow;

/**
 * LeetCode 424: Longest Repeating Character Replacement.
 * Find the longest substring achievable by replacing at most k characters with any character.
 * Throws IllegalArgumentException if s is null or k is negative.
 */
public class LongestRepeatingCharacterReplacement {

    private static final int ALPHABET_SIZE = 26;

    public int characterReplacement(String s, int k) {
        if (s == null) {
            throw new IllegalArgumentException("s must not be null");
        }
        if (k < 0) {
            throw new IllegalArgumentException("k must not be negative");
        }

        int[] counts = new int[ALPHABET_SIZE];
        int left = 0;
        int maxCount = 0;
        int longest = 0;

        // Time: O(n), Space: O(1) (fixed 26-letter alphabet). maxCount is never decremented when
        // the window shrinks, even though it may become stale. That's fine: the window only ever
        // shrinks by one when it becomes invalid, so it can't grow again until a new character
        // pushes maxCount higher - meaning longest (tracked below) can never regress from a stale
        // maxCount, so the window size still converges to the true answer.
        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'A';
            counts[idx]++;
            maxCount = Math.max(maxCount, counts[idx]);

            while ((right - left + 1) - maxCount > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
        System.out.println(solution.characterReplacement("ABAB", 2));
        System.out.println(solution.characterReplacement("AABABBA", 1));
        System.out.println(solution.characterReplacement("AAAA", 0));
        System.out.println(solution.characterReplacement("", 2)); // empty string: no window to extend, length 0
    }
}
