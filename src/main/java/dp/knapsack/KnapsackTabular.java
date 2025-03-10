package dp.knapsack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given two integer arrays representing weights and profits of 'N' items, and integer C (weight capacity).
 * Write Java method, that will return the subset of items that give maximum profit that can be achieved when
 * selecting this subset of items so that the joint weight of selected items does not exceed C.
 * <p>
 * You can select each item only once, meaning that you either we put an item in the knapsack or not
 *
 */
public class KnapsackTabular {

    public static void main(String[] args) {
        KnapsackTabular knapsack = new KnapsackTabular();
        /* Find max profit.
           Should return 10 : for subset indexes {2, 3}
         */
        System.out.println("max profit: " + knapsack.dp(new int[]{ 2, 3, 1, 4 }, new int[]{ 4, 5, 3, 7 }, 5));

        System.out.println("max profit: " + knapsack.dp(new int[]{2, 1, 2}, new int[]{2, 4, 6}, 4));
        System.out.println("max profit: " + knapsack.dp(new int[]{2, 1, 2}, new int[]{2, 4, 6}, 5));
        System.out.println("max profit: " + knapsack.dp(new int[]{1,2,3,5}, new int[]{1,6,10,16}, 7));
        System.out.println("max profit: " + knapsack.dp(new int[]{2, 1, 2, 6, 3, 5, 4, 7}, new int[]{2, 4, 6, 8, 5, 7, 9, 1}, 15));

        /* find item set delivering max profit */
        Integer[] items = knapsack.dpItems(new int[]{ 2, 3, 1, 4 }, new int[]{ 4, 5, 3, 7 }, 5);
        System.out.println("Max profit item set (indexes): ");
        knapsack.print(items);
        items = knapsack.dpItems(new int[]{2, 1, 2}, new int[]{2, 4, 6}, 4);
        System.out.println("Max profit item set (indexes): ");
        knapsack.print(items);
        items = knapsack.dpItems(new int[]{2, 1, 2}, new int[]{2, 4, 6}, 5);
        System.out.println("Max profit item set (indexes): ");
        knapsack.print(items);
        items = knapsack.dpItems(new int[]{1,2,3,5}, new int[]{1,6,10,16}, 7);
        System.out.println("Max profit item set (indexes): ");
        knapsack.print(items);
        items = knapsack.dpItems(new int[]{2, 1, 2, 6, 3, 5, 4, 7}, new int[]{2, 4, 6, 8, 5, 7, 9, 1}, 15);
        System.out.println("Max profit item set (indexes): ");
        knapsack.print(items);
    }


    public void print(Integer[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * Tabular, or bottom-up DP
     *
     * As in resursion, we compose the algo of two possible cases
     * - using next item in hand if it fits current capacity + add profit of remaining items with remaining capacity
     * - skip next item, with profit from the remaining items for the same capacity
     *
     * And we're moving here bottom-up, starting of the 0-indexes, which are pre-filled in dp[][] matrix row and column,
     * and relying on already pre-filled values
     *
     * Time complexity - O(dp[][].length * dp[0][].length)
     *
     */
    public int dp(int[] weights, int[] profits, int capacity) {
        int[][] dp = new int[profits.length][capacity + 1];

        /*
          With 0 capacity we can get zero profit irrespectable of items
         */
        for (int i = 0; i < profits.length; i++) {
            dp[i][0] = 0;
        }

        /*
          If we have only 1 item - we can put it in knapsack if it fits the capacity
         */
        for (int i = 0; i <= capacity; i++) {
            if (profits[0] <= i) dp[0][i] = weights[0];
        }

        for (int i = 1; i < profits.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0;
                int profit2 = 0;
                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i-1][c - weights[i]];
                }
                profit2 = dp[i - 1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        /*
         The bottom-right element should hold profit in search
         */
        return dp[profits.length - 1][capacity];
    }

    /**
     *
     * This method is for the case when you need to know not just the optimal (max) profit, but as well
     * the combination of items which deliver the one.
     *
     * Note: there is boilerplate repetition from the dp() method to keep it whole thing, however you can
     * refactor it accordingly on the demand
     *
     * @return - the array of item indicies composing the optimal subset
     */
    public Integer[] dpItems(int[] weights, int[] profits, int capacity) {
        int[][] dp = new int[profits.length][capacity + 1];

        /*
          With 0 capacity we can get zero profit irrespectable of items
         */
        for (int i = 0; i < profits.length; i++) {
            dp[i][0] = 0;
        }

        /*
          If we have only 1 item - we can put it in knapsack if it fits the capacity
         */
        for (int i = 0; i <= capacity; i++) {
            if (profits[0] <= i) dp[0][i] = weights[0];
        }

        for (int i = 1; i < profits.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0;
                int profit2 = 0;
                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i-1][c - weights[i]];
                }
                profit2 = dp[i - 1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        /*
         Now we are travelling back from optimal dp[][] cell with the rule:
         - if the adjacent up cell is equal to current one ->
           optimal path taken at this point was to exclude item, optimizing the rest on same capacity

         - otherwise, we would jump along the current row back on the length of included item weight

         */

        int c = capacity;
        int i = profits.length -1;
        List<Integer> result = new ArrayList<>();
        /*
           As soon as we reach 0-item, we can't check horizontally up,
           hence 0-item is included only if it is not-greater than remaining c
         */
        while (c > 0 && i > 0) {
            if (dp[i - 1][c] != dp[i][c]) {
                result.add(i);
                c = c - weights[i];
            }
            i--;
        }

        if (weights[i] <= c) {
            result.add(i);
        }

        Collections.reverse(result);
        return result.toArray(new Integer[0]);

    }

}
