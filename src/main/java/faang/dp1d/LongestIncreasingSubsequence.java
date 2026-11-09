package faang.dp1d;

import java.util.Arrays;

/**
 * LC 300: Longest Increasing Subsequence.
 * Find the length of the longest strictly increasing subsequence of an array, in O(n log n).
 * Precondition: nums must be non-null.
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("nums must be non-null");
        }
        // tails[k] holds the smallest possible tail value of an increasing subsequence of
        // length k + 1 seen so far; tails is always sorted, so each num is placed via binary
        // search in O(log n), giving O(n log n) total instead of the naive O(n^2) DP.
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int lo = 0;
            int hi = size;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (tails[mid] < num) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            tails[lo] = num;
            if (lo == size) {
                size++;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(solution.lengthOfLIS(new int[]{7, 7, 7, 7}));
    }
}
