package dp.knapsack;

/**
 * You are given array of positive number.
 * Write a method that will find the way to split array into two subsets so that the difference between sums of
 * those subsets is minimum possible, and return that difference.
 * <p>
 * public int minimumDiff(int[] arr)
 */
public class TwoSubsetsWithMinimumDifferenceRecursive {
    public static void main(String[] args) {
        TwoSubsetsWithMinimumDifferenceRecursive twoEqualSubsetsRecursive = new TwoSubsetsWithMinimumDifferenceRecursive();
        /*
         Should return : 3
         */
//        System.out.println(twoEqualSubsetsRecursive.minimumDiff(new int[]{1, 2, 3, 9}));


        /*
         Should return : 0, meaning we can find two equal on the sum subsets
         */
        System.out.println(twoEqualSubsetsRecursive.minimumDiff(new int[]{1, 2, 7, 1, 5}));
    }

    public int minimumDiff(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        Integer[][] dp = new Integer[arr.length][sum + 1];
        return minimumDiff(arr, dp, 0, 0, 0);
    }

    public int minimumDiff(int[] arr, Integer[][] dp, int index, int sum1, int sum2) {
        if (index >= arr.length) {
            return Math.abs(sum1 - sum2);
        }

        // as sum1 determines sum2, let's use sum1 as the second index of dp[][]
        if (dp[index][sum1] != null) {
            return dp[index][sum1];
        }

        int diff1 = minimumDiff(arr, dp, index + 1, sum1 + arr[index], sum2);
        int diff2 = minimumDiff(arr, dp, index + 1, sum1, sum2 + arr[index]);
        int result = Math.min(diff1, diff2);
        dp[index][sum1] = result;

        return result;
    }
}
