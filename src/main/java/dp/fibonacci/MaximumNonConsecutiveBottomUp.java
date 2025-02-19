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
public class MaximumNonConsecutiveBottomUp {

    public int maximum(int[] arr) {
        if(arr.length == 0) return 0;
        int dp[] = new int[arr.length+1]; // '+1' to handle the zero element
        dp[0] = 0; // for empty array
        dp[1] = arr[0]; // one-element array gives this element

        // on each step try to sum up pre-previos result with new element & compare with previous result
        for(int i=1; i < arr.length; i++)
            dp[i+1] = Math.max(arr[i] + dp[i-1], dp[i]);

        return dp[arr.length];
    }
}
