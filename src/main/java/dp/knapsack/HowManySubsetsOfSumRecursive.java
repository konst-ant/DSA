package dp.knapsack;

/**
 * You are given an array of positive numbers.
 * Write a method returning the number of subsets of an array that deliver in sum of elements given integer number:
 *
 * public int subsets(int[] arr, int s)
 *
 */
public class HowManySubsetsOfSumRecursive {
    public static void main(String[] args) {
        HowManySubsetsOfSumRecursive howManySubsetsOfSumRecursive = new HowManySubsetsOfSumRecursive();
        /*
        should deliver 3 : {1, 1, 2}, {1, 3}, {1, 3}
         */
//        int[] arr = new int[]{1, 1, 2, 3};
//        int sum = 4;

        /*
        should deliver 3 : {2, 7}, {1, 7, 1}, {1, 2, 1, 5}
         */
        int[] arr = new int[]{1, 2, 7, 1, 5};
        int sum = 9;
        System.out.println(howManySubsetsOfSumRecursive.subsets(arr, new Integer[arr.length][sum + 1], 0, sum));
    }

    private int subsets(int[] arr, Integer[][] dp, int index, int s) {
        /* Note: it's important to check first the sum == 0 and then the break on index overflow
           otherwise if we swap this checks we will lose the last element in array
         */
        if (s == 0) {
            return 1;
        }

        if (index >= arr.length) {
            return 0;
        }

        if (dp[index][s] != null) {
            return dp[index][s];
        }


        int subsets1 = 0;
        int subsets2 = 0;

        if (arr[index] <= s) {
            subsets1 = subsets(arr, dp, index + 1, s - arr[index]);
        }
        subsets2 = subsets(arr, dp, index + 1, s);
        dp[index][s] = subsets1 + subsets2;
        return dp[index][s];
    }
}
