package dp.fibonacci;

/**
 * You are given a sequence of integers. You can select any number of integer from given array, with one limitation
 * that no two elements selected are consecutive to each other. Write an algorithm to do a selection, which will
 * provide the biggest possible sum of number
 *
 * public int maximum(int[] arr)
 *
 * Examples:
 * arr = {2, 5, 1, 3, 6, 2, 4}
 * Result: 15
 * Max selection is 5 + 6 + 4
 *
 * arr = {2, 10, 14, 8, 1}
 * Result: 18
 * Max selection is 10 + 8
 *
 */
public class MaximumNonConsecutiveRecursive {

    public int maximum(int[] arr) {
        int[] dp = new int[arr.length];
        return maximumRecursive(arr, 0, dp);
    }

    private int maximumRecursive(int[] arr, int index, int[] dp) {

        // recursion base
        if (index >= arr.length) {
            return 0;
        }

        if (dp[index] != 0) {
            return dp[index];
        }

        // case 1: select current element
        int sum1 = arr[index] + maximumRecursive(arr, index + 2, dp);

        // case 2: skip current element
        int sum2 = maximumRecursive(arr, index + 1, dp);

        dp[index] = Math.max(sum2, sum1);
        return dp[index];
    }
}
