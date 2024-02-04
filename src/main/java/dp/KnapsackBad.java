package dp;


import java.util.HashMap;
import java.util.Map;

/**
 * You are given two integer arrays representing weights and profits of 'N' items, and integer C (weight capacity).
 * Write Java method, that will return the subset of items that give maximum profit that can be achieved when
 * selecting this subset of items so that the joint weight of selected items does not exceed C.
 *
 * You can select each item only once, meaning that you either we put an item in the knapsack or not
 *
 */
public class KnapsackBad {

    public static void main(String[] args) {
        KnapsackBad knapsack = new KnapsackBad();
        System.out.println("max profit: " + knapsack.solution(new int[]{2, 4, 6}, new int[]{2, 1, 2}, 4) + ", max combination: ");
        System.out.println("max profit: " + knapsack.solution(new int[]{2, 4, 6}, new int[]{2, 1, 2}, 5) + ", max combination: ");
        System.out.println("max profit: " + knapsack.solution(new int[]{1,6,10,16}, new int[]{1,2,3,5}, 7) + ", max combination: ");
        System.out.println("max profit: " + knapsack.solution(new int[]{2, 4, 6, 8, 5, 7, 9, 1}, new int[]{2, 1, 2, 6, 3, 5, 4, 7}, 15) + ", max combination: ");
    }

    /**
     *
     * Note: we memoizing here on the signature of chosen[] - for with any unique chosen combination of items
     * the capacity to go will be pre-defined (contrary is not valid though)
     *
     */
    public int solution(int[] profits, int[] weights, int capacity) {
        Map<String, Integer> known = new HashMap<>();
        return dp(profits, weights, new int[profits.length], capacity, known);
    }

    private int dp(int[] profits, int[] weights, int[] chosen, int capacity, Map<String, Integer> known) {

        /*
          shortcutting with memoization here - try to delete this block and see how changes the number of
          printouts below

          shortcutting with memoization - drastically improves performance!
          because we are breaking early the tree of recursive sub-calls once we know already memoized result

         */
        String signature = signature(chosen);
        if (known.containsKey(signature(chosen))) {
            return known.get(signature);
        }

        System.out.println("dp called with capacity: " + capacity + " and chosen: " + signature(chosen));

        int profit = 0;
        for (int i = 0; i < profits.length; i++) {
            if (chosen[i] != 1 && capacity >= weights[i]) {
                chosen[i] = 1;
                profit = Math.max(profit, profits[i] + dp(profits, weights, chosen, capacity - weights[i], known));
                chosen[i] = 0;
            }
        }
        known.put(signature, profit);
        return profit;
    }

    private String signature(int[] arr) {
        StringBuilder result = new StringBuilder();
        if (arr.length != 0) {
            result.append(arr[0]);
            for (int i = 1; i< arr.length; i++) {
                result.append(',').append(arr[i]);
            }
        }
        return result.toString();
    }
}
