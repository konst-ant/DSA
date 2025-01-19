package dp.knapsack;

import java.util.Arrays;

/**
 * Given an array arr[] of size N, the task is to find the length of the Longest Increasing Subsequence (LIS)
 * i.e., the longest possible subsequence in which the elements of the subsequence are sorted in increasing order.
 * LIS
 *
 * For example, for array {10, 22, 9, 33, 21, 50, 41, 60, 80} - result should be 6
 *
 */
public class LongestIncreasingSequence {

    public static int findLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return findLISRecursive(nums, n, -1, 0, memo);
    }

    private static int findLISRecursive(int[] nums, int n, int prevIndex, int currentIndex, int[][] memo) {
        if (currentIndex == n) {
            return 0;
        }

        if (memo[prevIndex + 1][currentIndex] != -1) {
            return memo[prevIndex + 1][currentIndex];
        }

        int excludeCurrent = findLISRecursive(nums, n, prevIndex, currentIndex + 1, memo);

        int includeCurrent = 0;
        if (prevIndex == -1 || nums[currentIndex] > nums[prevIndex]) {
            includeCurrent = 1 + findLISRecursive(nums, n, currentIndex, currentIndex + 1, memo);
        }

        memo[prevIndex + 1][currentIndex] = Math.max(includeCurrent, excludeCurrent);
        return memo[prevIndex + 1][currentIndex];
    }

    public static void main(String[] args) {
        int[] nums = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int result = findLIS(nums);
        System.out.println("Length of the Longest Increasing Subsequence: " + result);
    }
}