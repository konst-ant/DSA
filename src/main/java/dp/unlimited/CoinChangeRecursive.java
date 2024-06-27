package dp.unlimited;

/**
 * Given unlimited supply of coins of given denominations and the required sum amount,
 * count number of variants the sum can be composed of coins
 *
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
