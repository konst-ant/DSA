package dp.fibonacci;

import java.sql.ClientInfoStatus;

/**
 * You have array of positive numbers, where each element value is max number of leaps that can be made from this element
 * ahead the array end. You need to find the minimum number of leaps to reach the end of the array. You start from the
 * 0-element of the array. If an element value is 0 you can not leap from that element.
 *
 * Example:
 *
 * array = {2,1,1,1,4}
 * Result = 3 ->  path {0, 2, 3, 4}
 *
 * array = {1,1,3,6,9,3,0,1,3}
 * Result = 4 ->  path {0, 1, 2, 3, 8}
 */
public class MinimumLeapsRecursive {
    public int minLeaps(int[] array) {
        return minLeapsRecursive(array, 0, new int[array.length]);
    }

    private int minLeapsRecursive(int[] array, int position, int[] dp) {

        // recursion base
        if (position == array.length - 1) {
            return 0;
        }

        if (dp[position] != 0) {
            return dp[position];
        }

        int ultimateLeaps = Integer.MAX_VALUE;
        int idx = position + 1;
        int end = position + array[position];
        while (idx < array.length && idx <= end) {
            int leaps = minLeapsRecursive(array, idx, dp);
            if (leaps != Integer.MAX_VALUE) {
                ultimateLeaps = Math.min(ultimateLeaps, leaps + 1);
            }
            idx++;
        }
        dp[position] = ultimateLeaps;
        return dp[position];
    }

}
