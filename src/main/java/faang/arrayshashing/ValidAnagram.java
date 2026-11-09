package faang.arrayshashing;

/**
 * LeetCode 242: Valid Anagram.
 * Return true if string t is an anagram of string s.
 * Assumes s and t consist only of lowercase English letters ('a'-'z'), per the LeetCode constraint.
 * Throws IllegalArgumentException if s or t is null.
 */
public class ValidAnagram {

    private static final int ALPHABET_SIZE = 26;

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("s and t must not be null");
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[ALPHABET_SIZE];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "car"));
        System.out.println(solution.isAnagram("listen", "silent"));
        System.out.println(solution.isAnagram("", "")); // empty string edge case
    }
}
