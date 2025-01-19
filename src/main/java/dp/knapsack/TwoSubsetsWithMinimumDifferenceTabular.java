package dp.knapsack;

/**
 * You are given array of positive number.
 * Write a method that will find the way to split array into two subsets so that the difference between sums of
 * those subsets is minimum possible, and return that difference.
 * <p>
 * public int minimumDiff(int[] arr)
 */
public class TwoSubsetsWithMinimumDifferenceTabular {
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

    /**
     * For tabular method the algo goes down to finding a subset with a sum == S/2,
     * where S is the sum of arr elements. So we exploit the same concept as in TwoEqualSubsetsTabular
     *
     * If we're not able to find equal - we return the next closer to the half from dp[][]
     */
    public int minimumDiff(int[] arr) {
        int s = 0;
        for (int i : arr) {
            s += i;
        }

        int halfSum = s/2;
        boolean[][] dp = new boolean[arr.length][halfSum + 1];

        /**
         * We are thinking of only one subset everywhere along the algo.
         * So for sum 0 we can always find matching subset - empty one
         */
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        /**
         * For single item we can compose a sum if item is equal to that sum - only
         */
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = arr[0] == i ? true : false;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                // option 1 - include current element + algo applied to the remaining with reduced sum
                boolean option = dp[i - 1][j - arr[i]];
                if (!option) {
                    // option 2 - exclude current element
                    option = dp[i - 1][j];
                }
                dp[i][j] = option;
            }
        }

        if (dp[arr.length - 1][halfSum]) {
            // we can equally divide, the min diff is 0
            // Note: in fact we could abandon this if in the interest of the next else, which does both cases
            return 0;
        } else {
            // dp[][] holds answer basically for all cases starting from half sum equal 0 all the way to s/2.
            // we need to find the first case value of dp's second index where happened true for
            // case of all elements inclusion. meaning, we consider only the bottom row of tha matrix and move
            // backwards. diff of that found index with halfSum will give the answer
            int j = halfSum;
            while (j >= 0 && dp[arr.length][j] == false) {
                j--;
            }
            return halfSum - j;
        }
    }
}
