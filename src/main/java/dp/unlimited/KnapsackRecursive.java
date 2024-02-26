package dp.unlimited;


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
    public static void main(String[] args) {
        KnapsackRecursive knapsackRecursive = new KnapsackRecursive();
        int[] weights = new int[]{1, 2, 3};
        int[] profits = new int[]{15, 20, 50};
        int capacity  = 5;
        int[][] dp = new int[weights.length][capacity + 1];
        System.out.println(knapsackRecursive.solution(weights, profits, weights.length - 1, capacity, dp));
    }

    int solution(int[] weight, int[] profit, int index, int sum, int[][] dp) {
        if (sum < 0 || index < 0) {
            return 0;
        }

        if (dp[index][sum] != 0) {
            return dp[index][sum];
        }

        /* two cases:
            - we take an item and continue with unchanged item set (with opportunity to take it more later)
            - we skip an item
         */
        int sum1 = 0;
        if (sum - weight[index] >= 0) {
            sum1 = profit[index] + solution(weight, profit, index, sum - weight[index], dp);
        }
        int sum2 = solution(weight, profit, index - 1, sum, dp);
        dp[index][sum] = Math.max(sum1, sum2);
        return dp[index][sum];
    }
}
