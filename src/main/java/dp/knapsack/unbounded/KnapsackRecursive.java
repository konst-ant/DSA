package dp.knapsack.unbounded;


/**
 * Given unlimited supply of items, described by two arrays:
 * - weight[]
 * - profit[]
 * <p>
 * write a method that will return maximum possible profit not greater than given integer c,
 * which will give reached by combination of items
 * <p>
 * public int solution(int[] weight, int[] profit, int index, int sum)
 * <p>
 * Example:
 * Items: {Apple, Orange, Melon}
 * Weights: {1, 2, 5}
 * Profits: {15, 20, 50}
 * <p>
 * and busket size = 5
 * <p>
 * would return 80 for the combination {2 - Apple, 1 - Melon}
 */
public class KnapsackRecursive {
    // See tests

    public int solution(int[] weight, int[] profit, int index, int availableCapacity, int[][] dp) {
        if (availableCapacity < 0 || index < 0) {
            return 0;
        }

        if (dp[index][availableCapacity] != 0) {
            return dp[index][availableCapacity];
        }

        /* two cases:
            - we take an item and continue with unchanged item set (with opportunity to take it more later)
            - we skip an item
         */
        int sum1 = 0;
        if (availableCapacity - weight[index] >= 0) {
            sum1 = profit[index] + solution(weight, profit, index, availableCapacity - weight[index], dp);
        }
        int sum2 = solution(weight, profit, index - 1, availableCapacity, dp);
        dp[index][availableCapacity] = Math.max(sum1, sum2);
        return dp[index][availableCapacity];
    }
}
