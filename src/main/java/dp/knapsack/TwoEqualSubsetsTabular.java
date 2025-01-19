package dp.knapsack;


/**
 * You are given a set of positive integers.
 * Write a method to determine if it is feasible to divide the input set into two subsets equal on the sum
 */
public class TwoEqualSubsetsTabular {
    public static void main(String[] args) {
        TwoEqualSubsetsTabular equalSubsetRecursive = new TwoEqualSubsetsTabular();
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(equalSubsetRecursive.canDivide(arr) ? "Yes" : "No");
    }


    /**
     * Tabular, or bottom-up DP
     * <p>
     * To understand solution, we have to transform task to the following concept.
     * It's possible to equally divide the array if we can find a subset, which gives s/2 in sum.
     * (here s - is the sum of all array elements). So we shift our mindset to considering only one subset,
     * not two (!) and find that subset.
     *
     * Note: as side effect, it directly follows that is s is odd - the answer is false right away
     *
     * Then with tabular dp, our mindset is: we are considering one subset, and building up the sequence
     * from 0 items and 0 sum all the way to all arr[] items and sum = s/2. And we need to see if we can
     * compose that sum for that subset or not.
     *
     * <p>
     * So, for each number at index 'i' (0 <= i < num.length) and sum 's' (0 <= s <= S/2), we have two options:
     * <p>
     * Exclude the number. In this case, we will see if we can get 's' from the subset excluding this number: dp[i-1][s]
     * Include the number if its value is not more than 's'. In this case, we will see if we can find a subset to get
     * the remaining sum: dp[i-1][s-num[i]]
     *
     */
    public boolean canDivide(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        // we can't divide equally odd sum
        if (sum % 2 != 0) {
            return false;
        }

        int halfSum = sum / 2;
        boolean[][] dp = new boolean[arr.length][halfSum + 1];

        // halfSum = 0 can always be made from empty subset
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }


        // if we have only one array element, dp will be true if it exactly matches the halfSum
        for (int s = 0; s <= halfSum; s++) {
                dp[0][s] = arr[0] == s ? true : false;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int s = 1; s <= halfSum; s++) {
                if (arr[i] <= s) {
                    dp[i][s] = dp[i][s - arr[i]];
                } else {
                    dp[i][s] = dp[i-1][s];
                }
            }
        }

        // the result sits in right-bottom corner
        return dp[arr.length - 1][halfSum];
    }
}
