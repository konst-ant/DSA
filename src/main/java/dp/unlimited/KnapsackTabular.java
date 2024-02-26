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
public class KnapsackTabular {
    public static void main(String[] args) {
        KnapsackTabular knapsackTabular = new KnapsackTabular();

        int[] weights = new int[]{1, 2, 3};
        int[] profits = new int[]{15, 20, 50};
        int capacity  = 5;
        System.out.println(knapsackTabular.solution(weights, profits, capacity));

        weights = new int[]{1, 3, 4, 5};
        profits = new int[]{15, 50, 60, 90};
        capacity  = 8;
        System.out.println(knapsackTabular.solution(weights, profits, capacity));
    }

    public int solution(int[] weights, int[] profits, int sum) {
        // base checks
        if (sum <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int[][] dp = new int[weights.length][sum + 1];

        // for 0 capacity we would get 0 profit irrespective of items
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        // for single item (0-item) we can fill knapsack if that item is not heavier than capacity
        for (int i = 0; i <= sum; i++) {
            int quotinent = i / weights[0];
            dp[0][i] = profits[0] * quotinent;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int sum1 = dp[i - 1][j];
                int sum2 = 0;
                if (j >= weights[i]) {
                    sum2 = profits[i] + dp[i][j - weights[i]];
                }
                dp[i][j] = Math.max(sum1, sum2);
            }
        }

        return dp[weights.length - 1][sum];
    }
}
