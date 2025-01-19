package dp.knapsack.unbounded;

/**
 * Given unlimited amount of coins of given denominations (int[] coins) and sum
 * find number of all possible ways to make up the sum using that denominations.
 *
 *  public int count(int[] coins, int sum)
 * <p>
 * Example:
 * Coins: {1,2,3}
 * sum: 5
 * Result: 5
 * All possibilities to change 5 with coin set:
 * {1,1,1,1,1}, {1,1,1,2}, {1,2,2}, {1,1,3}, {2,3}
 */
public class CoinChangeRecursive {

    public long count(int[] coins, int sum) {
        int[][] dp = new int[coins.length][sum + 1];
        return countRecursive(coins, 0, sum, dp);
    }

    /**
     * @param coins - full set of coins
     * @param index - index limiting subset with which to apply for the sum
     * @param sum
     * @return
     */
    private int countRecursive(int[] coins, int index, int sum, int[][] dp) {
        System.out.println("countRecursive: index=" +  index + " sum=" + sum);
        if (sum == 0) {
            return 1;
        }

        if (dp[index][sum] != 0) {
            return dp[index][sum];
        }

        int count = 0;
        for (int i = index; i < coins.length; i++) {
            if (sum - coins[i] >= 0) {
                count += countRecursive(coins, i, sum - coins[i], dp);

            }
        }
        System.out.println("countRecursive: return=" + count);
        dp[index][sum] = count;
        return count;
    }
}
