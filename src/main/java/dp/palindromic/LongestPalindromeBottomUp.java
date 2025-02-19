package dp.palindromic;

/**
 * You have a string of English symbols, and need to find the longest subsequence of that, which is a Palindrom,
 * i.e. reading symbols in forward and backward directions are same.
 * <p>
 * A subsequence is any selection of elements from array, without changing their existing order
 * <p>
 * public int lp(String str)
 * <p>
 * Example
 * String: "abdbca"
 * Result: 5
 * Longest palindrome is "abdba"
 * <p>
 * String: "cddpd"
 * Result: 3
 * Longest palindrome is "ddd"
 * <p>
 * String: "pqr"
 * Result: 1
 * Longest palindrome is any "p", "q", "r"
 */
public class LongestPalindromeBottomUp {

    public int lp(String str) {
        int[][] dp = new int[str.length()][str.length()];

        // initialize dp: each element is a palindrome of itself
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }

        // Note: in recursive algo we were consecutively moving pointers across the string (both start and end)
        // So here, iterating to get all possible substrings, and applying the same formula as in recursive
        for (int start = str.length() - 1; start >= 0; start--) {
            for (int end = start + 1; end < str.length(); end++) {
                if (str.charAt(start) == str.charAt(end)) {
                    dp[start][end] = 2 + dp[start + 1][end - 1];
                } else {
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                }
                printOut(start, end, dp);
            }
        }
        return dp[0][str.length() - 1];
    }

    private void printOut(int start, int end, int[][] dp) {
        System.out.println("-------------------- start=" + start + ", end=" +end);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
