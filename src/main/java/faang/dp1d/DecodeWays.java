package faang.dp1d;

/**
 * LC 91: Decode Ways.
 * Count the number of ways to decode a digit string where 'A'-'Z' map to 1-26.
 * Precondition: s must be non-null.
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null) {
            throw new IllegalArgumentException("s must be non-null");
        }
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int prev2 = 1;
        int prev1 = 1;
        for (int i = 1; i < n; i++) {
            int current = 0;
            if (s.charAt(i) != '0') {
                current += prev1;
            }
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += prev2;
            }
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        DecodeWays solution = new DecodeWays();
        System.out.println(solution.numDecodings("12"));
        System.out.println(solution.numDecodings("226"));
        System.out.println(solution.numDecodings("06"));
    }
}
