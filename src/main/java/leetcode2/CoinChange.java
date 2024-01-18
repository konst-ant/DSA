package leetcode2;


import java.util.*;

/**
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount representing
 * a total amount of money.
 *
 * Write a method given array of coins int[] C and the amount, returns the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1
 *
 * public int solution(int[] C, int amount);
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 * For example
 * given C = {1, 2, 5} and amount 11, returns 3
 *
 */
public class CoinChange {

    int recursiveCalls;


    public int coinChangeMinimum(Integer[] coins, int sum) {
        recursiveCalls = 0;
        /**
         * Sorting to descending doesn't help niether in amount of resursive calls nor in amount of calculated map
         * puts, because we still will be passing all combinations and still caching intermediate results,
         * but in reverse order, if array is sorted from big coins to small
         */
//        Arrays.sort(coins, Collections.reverseOrder());
        return coinChangeMinimum(coins, sum, new HashMap<>());
    }

    private int coinChangeMinimum(Integer[] coins, int amount, Map<Integer, Integer> calculated) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        Integer c = calculated.get(amount);
        if (c != null) return c;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {

            int subAmount = coinChangeMinimum(coins, amount - coins[i], calculated);

            if (subAmount >= 0) min = Math.min(subAmount + 1, min);
        }
        min = min == Integer.MAX_VALUE ? -1 : min;
        calculated.put(amount, min);

        return min;
    }

    /**
     * to calculate correctly number of combinations we can not use cache, as in coinChangeMinimum()
     * Note(!): we can not run for big enough amounts this algorithm because it is not using cache
     */
    public int coinChangeCombinations(Integer[] coins, int sum) {
        int[] usedCoins = new int[coins.length];
        Set<String> uniqueChanges = new HashSet<>();


        coinChangeCombinations(coins, sum, usedCoins, uniqueChanges);
        // debug printing out
        for (String combination : uniqueChanges) {
            System.out.println(combination);
        }
        return uniqueChanges.size();
    }

    /**
     * This method calculates number of possible combinations instead of minimum amount of coins as done in coinChange()
     */
    private int coinChangeCombinations(Integer[] coins,
                                       int amount,
                                       int[] usedCoins,
                                       Set<String> uniqueChanges) {
        recursiveCalls++;
        if (amount < 0) return -1;
        if (amount == 0) {
            String digest = usedCoinsDigest(coins, usedCoins);
            if (digest.length() > 0) uniqueChanges.add(digest);
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            usedCoins[i]++;
            int subAmount = coinChangeCombinations(coins, amount - coins[i], usedCoins, uniqueChanges);

            if (subAmount >= 0) min = Math.min(subAmount + 1, min);
            usedCoins[i]--;
        }
        min = min == Integer.MAX_VALUE ? -1 : min;

        return min;
    }

    private String usedCoinsDigest(Integer[] coins, int[] usedCoins) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < usedCoins.length; i++) {
            if (usedCoins[i] > 0) result.append(coins[i] + "=" + usedCoins[i] + ",");
        }
        return result.toString();
    }

    public void run(Integer[] coins, int amount) {
        System.out.println(coinChangeMinimum(coins, amount));
        System.out.println("Iterations: " + recursiveCalls);

//        System.out.println(coinChangeCombinations(coins, amount));

    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        coinChange.run(new Integer[]{186, 419, 83, 408}, 6249);
        coinChange.run(new Integer[]{1, 2, 5}, 7);
    }
}
