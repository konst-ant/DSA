package dp.knapsack;

/**
 * You are given an array of positive numbers.
 * Write a method returning the number of subsets of an array that deliver in sum of elements given integer number:
 *
 * public int subsets(int[] arr, int s)
 *
 */
public class DoesExistSubsetOfSumRecursive {
    public static void main(String[] args) {
        DoesExistSubsetOfSumRecursive doesExistSubsetOfSumTabular = new DoesExistSubsetOfSumRecursive();
        /*
          Should return true : {1, 2, 3}
         */
        int[] arr = new int[]{1, 2, 3, 7};
        int s = 14;
        System.out.println(doesExistSubsetOfSumTabular.existSubset(arr, new Boolean[arr.length][s + 1], 0, s));

        /*
          Should return false :
         */
//        int[] arr = new int[]{1, 3, 4, 8};
//        int s = 6;
//        System.out.println(doesExistSubsetOfSumTabular.existSubset(arr, new Boolean[arr.length][s + 1], 0, s));
    }

    private boolean existSubset(int[] arr, Boolean[][] dp, int index, int s) {
        /* Note: it's important to check first the sum == 0 and then the break on index overflow
           otherwise if we swap this checks we will lose the last element in array
         */
        if (s == 0) {
            return true;
        }

        if (index >= arr.length) {
            return false;
        }

        if (dp[index][s] != null) {
            return dp[index][s];
        }

        boolean result = false;
        if (arr[index] <= s) {
            result = existSubset(arr, dp, index + 1, s - arr[index]);
        }

        if (!result) {
            result = existSubset(arr, dp, index + 1, s);
        }

        dp[index][s] = result;
        return result;
    }
}
