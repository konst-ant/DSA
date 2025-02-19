package dp.palindromic;

/**
 * You have a string of English symbols, and need to find the longest subsequence of that, which is a Palindrom,
 * i.e. reading symbols in forward and backward directions are same.
 * <p>
 * A subsequence is any selection of elements from array, without changing their existing order
 * <p>
 * public int lp(String str)
 *
 * Example
 * String: "abdbca"
 * Result: 5
 * Longest palindrome is "abdba"
 *
 * String: "cddpd"
 * Result: 3
 * Longest palindrome is "ddd"
 *
 * String: "pqr"
 * Result: 1
 * Longest palindrome is any "p", "q", "r"
 *
 */
public class LongestPalindromeRecursive {

    public int lp(String str) {
        Integer[][] dp = new Integer[str.length()][str.length()];
        return lpRecursive(str, 0, str.length() - 1, dp);
    }

    private int lpRecursive(String str, int f, int b, Integer[][] dp) {
        if (f > b) {
            return 0;
        }

        if (f == b) {
            return 1;
        }

        if (dp[f][b] == null) {
            if (str.charAt(f) == str.charAt(b)) {
                dp[f][b] = lpRecursive(str, f + 1, b - 1, dp) + 2;
            } else {
                int l1 = lpRecursive(str, f + 1, b, dp);
                int l2 = lpRecursive(str, f, b - 1, dp);
                dp[f][b] = Math.max(l1, l2);
            }
        }
        return dp[f][b];
    }
}
