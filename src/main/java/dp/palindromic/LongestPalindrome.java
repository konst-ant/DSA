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
public class LongestPalindrome {

    public int lp(String str) {
        int f = 0;
        int b = str.length() - 1;
        int lpLength = 0;

        boolean equalFound = false;
        while (f <= b) {
            if (f == b) {
                lpLength++;
                f++;
            } else if (str.charAt(f) == str.charAt(b)) {
                lpLength = lpLength + 2;
                f++;
                b--;
            } else if (str.charAt(f) == str.charAt(b - 1)) {
                b--;
            } else if (str.charAt(f + 1) == str.charAt(b)) {
                f++;
            } else {
                f++;
                b--;
            }
            System.out.println("position=" + str.substring(f, b + 1) + " lpLength=" + lpLength);
        }
        return lpLength;
    }
}
