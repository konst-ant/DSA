package dp;

/**
 * You are given an array of positive numbers.
 * Write a method returning the number of subsets of an array that deliver in sum of elements given integer number:
 * <p>
 * public int subsets(int[] arr, int s)
 */
public class SubsetSumTabular {
    public static void main(String[] args) {
        SubsetSumTabular subsetSumTabularRecursive = new SubsetSumTabular();
        int[] arr = new int[]{1, 1, 2, 3};
        int sum = 4;
//        int[] arr = new int[]{1, 2, 7, 1, 5};
//        int sum = 9;
        System.out.println(subsetSumTabularRecursive.subsets(arr, sum));
    }

    private int subsets(int[] arr, int s) {
        int[][] dp = new int[arr.length][s + 1];


        /*
          a subtle thing here, for sum == 0 we can always find subset regardless of what arr[] is,
          that will be empty subset. It's contr-intuiteve, however with tabular method you need to be very formal
         */
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j < dp[0].length; j++) {
            if (arr[0] == j) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int s1 = 0;
                int s2 = 0;
                s1 = dp[i - 1][j];
                if (j >= arr[i]) {
                    s2 = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = s1 + s2;
            }
        }

        return dp[arr.length - 1][s];

    }
}
