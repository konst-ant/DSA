package dp.knapsack.unbounded;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
 *
 *
 * Here, properly organized class
 *
 */
public class KnapsackTabular {

    // see tests

    private int[][] dp;
    private List<String> items;
    private int[] weights;
    private int[] profits;
    private int capacity;

    public KnapsackTabular(List<String> items, int[] weights, int[] profits, int capacity) {
        this.items = items;
        this.weights = weights;
        this.profits = profits;
        this.capacity = capacity;
        dp = new int[weights.length][capacity + 1];
    }

    public int maxProfit() {
        return maxProfit(weights, profits, capacity);
    }

    private int maxProfit(int[] weights, int[] profits, int availableCapacity) {
        // base checks
        if (availableCapacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;


        // for 0 capacity we would get 0 profit irrespective of items
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        // for single item (0-item) we can fill knapsack if that item is not heavier than capacity
        // Note: here we try to fit as many things of item[0] as fits into knapsack hence i / weights[0]
        for (int i = 0; i <= availableCapacity; i++) {
            int quotinent = i / weights[0];
            dp[0][i] = profits[0] * quotinent;
        }


        /**
         * Here we're populating dp[][] array in a bottom-up fashion.
         * Essentially, what we want to achieve is:
         * Find the maximum profit for every sub-array and for every possible capacity
         */

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                /**
                 * Note (!): j semantic here is remaining knapsack capacity, as in all other DP tasks
                 */

                /**
                 *  1-st possibility - throw out current item
                 *  take whatever profit we get from sub-array excluding this item i.e. dp[i-1][j]
                 */
                int sum1 = dp[i - 1][j];
                int sum2 = 0;
                if (j >= weights[i]) {
                    /**
                     * 2-nd possibility - include the item if it's weight is no more than capacity (j).
                     * We get the profit = sum of this item's profit and whatever profit we can get from remaining
                     * capacity with the same item subset
                     */
                    sum2 = profits[i] + dp[i][j - weights[i]];
                }
                dp[i][j] = Math.max(sum1, sum2);
            }
        }

        return dp[weights.length - 1][availableCapacity];
    }

    public List<String> maxProfitItems() {
        maxProfit(weights, profits, capacity);

        List<String> result = new ArrayList<>();
        int c = capacity;
        int i = weights.length - 1;

        /**
         * if we reach i = 0, no way to check top cell, and the item should be included only if
         * it's weight is not exceeding remaining capacity
         */
        while (i > 0 && c > 0) {
            if (dp[i][c] != dp[i - 1][c]) {
                // top cell is the same, so need to include this item
                result.add(items.get(i));
                c -= weights[i];
            } else {
                /**
                 * Note (!): we decrease i index here only if cell on top is equal to current cell
                 * in controversy with limited algo where i is decreased unconditionally.
                 * This is because item can be put in knapsack multiple times!
                 */
                i--;
            }
        }

        // we may end up on 0-item, taken into knapsack multiple times, to accounting for this
        while (weights[i] <= c) {
            result.add(items.get(i));
            c -= weights[i];
        }

        Collections.reverse(result);
        return result;
    }

}
