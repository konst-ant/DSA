package dp.fibonacci;

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
 *
 *
 * This is the bottom-up algo (or Tabular)
 */
public class MinimumLeapsBottomUp {
    public int minLeaps(int[] array) {
        return minLeapsTabular(array, 0);
    }

    private int minLeapsTabular(int[] array, int position) {

        int[] dp = new int[array.length];

        // 0-th element should be 0, for we need zero leaps to reach there
        // the rest will set to "infinite" Integer.MAX_VALUE
        for (int i = 1; i < array.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // now, iterating till we've not reached the end, i.e. to pre-last index, cause if we're at last we know it
        for (int start = 0; start < array.length - 1; start++) {
            int end = start + array[start];
            for (int index = start + 1; index < array.length && index <= end; index++) {
                // take min of - either already calculated (or infinity as of inicialization) or
                // the cost of getting here with a 1 leap
                dp[index] = Math.min(dp[index], dp[start] + 1);
            }
        }

        // last element value - is what we need
        return dp[array.length - 1];
    }

}
