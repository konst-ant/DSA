package dp.knapsack.unbounded;

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

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // for sum = 0 we need 0 coins with any coin set
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < sum + 1; j++) {
                // first case: exclude coin i
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                }

                // second case: include coin i
                // Second condition is being safely checked, i.e. only when j - coins[i] >= 0
                //
                // Note also, second condition assures that the "step back" cell is the legitimate one that is was matched before
                // To understand it better, set breakpoint on return line and see dp matrix result, starting from it's 1-st line
                if (coins[i] <= j && dp[i][j - coins[i]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i]] + 1);
                }
            }
        }
        return dp[coins.length - 1][sum] == Integer.MAX_VALUE ? 0 : dp[coins.length - 1][sum];
    }
}
