package dp.unlimited;

public class CoinChangeTabular {

    public int count(int[] coins, int sum) {
        int[][] dp = new int[coins.length][sum + 1];

        // for 0 sum - we reckon any subset of coins to deliver one possible combination. strangely though
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }


        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < sum + 1; j++) {
                /**
                 * possibility 1 - exclude coin
                 * Note: not possible to exclude coin if it's a single one
                 */
                int s1 = 0;
                if (i > 0) {
                    s1 = dp[i - 1][j];
                }

                // possibility 2 - include coin if it fits
                int s2 = 0;
                if (coins[i] <= j) {
                    s2 = dp[i][j - coins[i]];
                }
                dp[i][j] = s1 + s2;
            }
        }

        return dp[coins.length - 1][sum];
    }

}
