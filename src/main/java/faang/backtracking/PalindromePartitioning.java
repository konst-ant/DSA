package faang.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 131: Palindrome Partitioning.
 * Returns all ways to partition a string such that every substring is a palindrome.
 * Precondition: s must be non-null (an empty string is allowed and yields one empty partition).
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        if (s == null) {
            throw new IllegalArgumentException("s must not be null");
        }
        int n = s.length();
        // Precomputing which substrings are palindromes in O(n^2) up front turns each
        // palindrome check inside the backtracking loop into an O(1) lookup. Without this,
        // every one of the exponentially many branches would re-scan its candidate substring
        // from scratch, multiplying the overall cost by an extra O(n) factor
        // (O(n^2 * 2^n) instead of O(n * 2^n)).
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || isPalindrome[i + 1][j - 1]);
            }
        }

        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, isPalindrome, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, boolean[][] isPalindrome,
                            List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome[start][end]) {
                current.add(s.substring(start, end + 1));
                backtrack(s, end + 1, isPalindrome, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PalindromePartitioning solver = new PalindromePartitioning();
        System.out.println(solver.partition("aab"));
        System.out.println(solver.partition("a"));

        // Edge case: empty string yields a single empty partition.
        System.out.println(solver.partition(""));
    }
}
