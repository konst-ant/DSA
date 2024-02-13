package dp;

/**
 * You are given an array of positive numbers.
 * Write a method defining if it exists a subset of array, delivering the sum of it's elements equal to given positive integer s:
 * <p>
 * public int existSubset(int[] arr, int s)
 */
public class DoesExistSubsetOfSumTabular {
    public static void main(String[] args) {
        DoesExistSubsetOfSumTabular doesExistSubsetOfSumTabular = new DoesExistSubsetOfSumTabular();
        /*
          Should return true : {1, 2, 3}
         */
//        int[] arr = new int[]{1, 2, 3, 7};
//        int s = 6;
//        System.out.println(doesExistSubsetOfSumTabular.existSubset(arr, s));

        /*
          Should return false :
         */
        int[] arr = new int[]{1, 3, 4, 8};
        int s = 6;
        System.out.println(doesExistSubsetOfSumTabular.existSubset(arr, s));
    }

    private boolean existSubset(int[] arr, int s) {
        boolean[][] dp = new boolean[arr.length][s + 1];


        /*
         We can always find subset for s == 0 - it's an empty subset
         */
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = arr[0] == j ? true : false;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                boolean result = false;
                if (j >= arr[i]) {
                    result = dp[i - 1][j - arr[i]];
                }
                if (!result) {
                    result = dp[i-1][j];
                }
                dp[i][j] = result;
            }
        }

        return dp[arr.length - 1][s];
    }
}
