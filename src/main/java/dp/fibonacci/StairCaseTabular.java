package dp.fibonacci;

/**
 * See task definition in {@link StairCaseRecursive}
 */
public class StairCaseTabular {

    public int countWays(int n) {
        int dpSize = n < 3 ? 3 : n + 1;

        int dp[] = new int[dpSize];
        dp[0] = 1;  // this is to be one, because then using dp[] countWays(3) will return correct value 4
        dp[1] = 1;
        dp[2] = 2;

        // bottom-up filling dp[] array
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

}
