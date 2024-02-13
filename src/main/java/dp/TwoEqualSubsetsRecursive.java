package dp;


/**
 * You are given a set of positive integers.
 * Write a method to determine if it is feasible to divide the input set into two subsets equal on the sum
 *
 */
public class TwoEqualSubsetsRecursive {
    public static void main(String[] args) {
        TwoEqualSubsetsRecursive twoEqualSubsetsRecursive = new TwoEqualSubsetsRecursive();

        /*
         Should be true : {1, 4} & {2, 3}
         */
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(twoEqualSubsetsRecursive.canDivide(arr) ? "Yes" : "No");

        /*
         Should be true : {1, 3, 4} & {1, 7}
         */
//        int[] arr = new int[]{1, 1, 3, 4, 7};
//        System.out.println(twoEqualSubsetsRecursive.canDivide(arr) ? "Yes" : "No");

        /*
         Should be false :
         */
//        int[] arr = new int[]{2, 3, 4, 6};
//        System.out.println(twoEqualSubsetsRecursive.canDivide(arr) ? "Yes" : "No");
    }

    public boolean canDivide(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        // we can't divide equally odd sum
        if (sum % 2 != 0) {
            return false;
        }

        // memoization matrix - we lay it on two parameters defining recursive iteration: index and sum
        Boolean[][] dp = new Boolean[arr.length][sum / 2 + 1];

        return canDivide(arr, dp, sum / 2, arr.length - 1);
    }

    private boolean canDivide(int[] arr, Boolean[][] dp, int sum, int index) {
        if (sum == 0) {
            return true;
        }

        if (index < 0) {
            return false;
        }

        if (dp[index][sum] == null) {
            /* use current element and the rest

               Note: essential thing here we return on the first recursive branch only if we get 'true', otherwise
               we go to check the second branch
             */
            if (arr[index] <= sum) {
                if (canDivide(arr, dp, sum - arr[index], index - 1)) {
                    dp[index][sum] = true;
                    return dp[index][sum];
                }
            }

            // exclude current element
            dp[index][sum] = canDivide(arr, dp, sum, index - 1);
            return dp[index][sum];
        }
        return dp[index][sum];
    }

    private void print(Iterable<Integer> collection) {
        for (int i : collection) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
