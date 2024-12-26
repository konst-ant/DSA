package dp.unlimited;

/**
 * Given unlimited amount of coins of given denominations (int[] coins) and sum
 * find minimum number of coins needed to make up the sum.
 *
 *  public int minimumNumberOfCoins(int[] coins, int sum)
 * <p>
 * Examples:
 * Coins= {1,2,3}
 * sum: 5
 * Result: 2
 * Min set of two coins {2,3} will make 5
 *
 * Coins: {1,2,3}
 * sum: 11
 * Result: 4
 * Min set of two coins {2,3,3,3} will make 11
 */
public class MinimumCoinChangeTabular {

    public int minimumNumberOfCoins(int[] coins, int sum) {
        int[][] dp = new int[coins.length][sum + 1];

        // for sum = 0 we need 0 coins with any coin set
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < sum + 1; j++) {
                // first case: exclude coin i
                int minCandidate1 = Integer.MAX_VALUE;
                if (i > 0) {
                    minCandidate1 = dp[i - 1][j];
                }

                // second case: include coin i
                int minCandidate2 = Integer.MAX_VALUE;
                if (coins[i] <= j) {
                    minCandidate2 = dp[i][j - coins[i]] + 1;
                }

                int min = Math.min(minCandidate2, minCandidate1);
                dp[i][j] = min != Integer.MAX_VALUE ? min : 0;
            }
        }
        return dp[coins.length - 1][sum];
    }
}
