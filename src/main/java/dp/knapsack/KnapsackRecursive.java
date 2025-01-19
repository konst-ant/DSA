package dp.knapsack;


/**
 * You are given two integer arrays representing weights and profits of 'N' items, and integer C (weight capacity).
 * Write Java method, that will return the subset of items that give maximum profit that can be achieved when
 * selecting this subset of items so that the joint weight of selected items does not exceed C.
 * <p>
 * You can select each item only once, meaning that you either we put an item in the knapsack or not
 *
 */
public class KnapsackRecursive {

    public static void main(String[] args) {
        KnapsackRecursive knapsack = new KnapsackRecursive();
        /*
         Should return 10 : for subset indexes {2, 3}
         */
        System.out.println("max profit: " + knapsack.solution(new int[]{ 2, 3, 1, 4 }, new int[]{ 4, 5, 3, 7 }, 5));


//        System.out.println("max profit: " + knapsack.solution(new int[]{2, 1, 2}, new int[]{2, 4, 6},4));
//        System.out.println("max profit: " + knapsack.solution(new int[]{2, 1, 2}, new int[]{2, 4, 6}, 5));
//        System.out.println("max profit: " + knapsack.solution(new int[]{1,2,3,5}, new int[]{1,6,10,16}, 7));
//        System.out.println("max profit: " + knapsack.solution(new int[]{2, 1, 2, 6, 3, 5, 4, 7}, new int[]{2, 4, 6, 8, 5, 7, 9, 1}, 15));
    }

    public int solution(int[] weights, int[] profits, int capacity) {
        int[][] dp = new int[profits.length][capacity + 1];
        return dp(profits, weights, dp, 0, capacity);
    }

    /**
     * Recursive, or up-bottom DP
     *
     * For all combinations - we can either include or exclude the current item, so two cases, and max() between them:
     * - profit of current  item + profit of remaining items for remaining capacity reduced by capacity of current item
     * - profit of remaining items excluding current item for same capacity
     *
     */
    private int dp(int[] profits, int[] weights, int[][] dp, int item, int capacity) {

        if (item >= profits.length || capacity <= 0) {
            return 0;
        }

        if (dp[item][capacity] != 0) {
            return dp[item][capacity];
        }

        int profit1 = 0;
        int profit2 = 0;
        if (weights[item] <= capacity) {
            profit1 = profits[item] + dp(profits, weights, dp, item + 1, capacity - weights[item]);
        }
        profit2 = dp(profits, weights, dp, item + 1, capacity);

        int result = Math.max(profit1, profit2);

        dp[item][capacity] = result;

        return result;
    }

}
