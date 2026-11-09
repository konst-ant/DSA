package faang.dp1d;

import java.util.Arrays;

/**
 * LC 322: Coin Change.
 * Find the minimum number of coins needed to make up a given amount, or -1 if impossible.
 * Precondition: coins must be non-null and non-empty, and amount must be non-negative.
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            throw new IllegalArgumentException("coins must be non-null and non-empty");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be non-negative");
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(solution.coinChange(new int[]{2}, 3));
        System.out.println(solution.coinChange(new int[]{1}, 0));
    }
}
