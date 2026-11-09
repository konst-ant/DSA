package faang.slidingwindow;

/**
 * LeetCode 567: Permutation in String.
 * Determine whether s2 contains a permutation of s1 as a contiguous substring.
 * Throws IllegalArgumentException if s1 or s2 is null.
 */
public class PermutationInString {

    private static final int ALPHABET_SIZE = 26;

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("s1 and s2 must not be null");
        }
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] need = new int[ALPHABET_SIZE];
        int[] window = new int[ALPHABET_SIZE];
        for (char c : s1.toCharArray()) {
            need[c - 'a']++;
        }

        int windowSize = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            window[s2.charAt(i) - 'a']++;
            if (i >= windowSize) {
                window[s2.charAt(i - windowSize) - 'a']--;
            }
            if (i >= windowSize - 1 && matches(need, window)) {
                return true;
            }
        }
        return false;
    }

    private boolean matches(int[] need, int[] window) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (need[i] != window[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationInString solution = new PermutationInString();
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
        System.out.println(solution.checkInclusion("adc", "dcda"));
        System.out.println(solution.checkInclusion("abc", "ab")); // s1 longer than s2: no permutation possible
    }
}
