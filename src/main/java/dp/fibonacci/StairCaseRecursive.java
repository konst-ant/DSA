package dp.fibonacci;

/**
 * Given a stair with 'n' steps, implement a method to count how many possible ways are there to reach the top of the staircase, given that, at every step you can either take 1 step, 2 steps, or 3 steps.
 *
 * public int countWays(int n)
 *
 * Examples:
 * Stairs = 3
 * Result = 4 -> {1,1,1}, {1,2} {2,1}, {3}
 *
 * Stairs = 4
 * Result = 7 -> {1,1,1,1}, {1,1,2}, {1,2,1}, {2,1,1}, {2,2}, {1,3}, {3,1}
 *
 *
 * See same from "Cracking coding interview" {@link crackingCodingInterview.StairCaseClimbing}
 *
 * Note: alternative way to implement is to take all permutations {@link misc.AllPermutations} and count
 * all that in sum give n
 */
public class StairCaseRecursive {

    public int countWays(int n) {
        int[] dp = new int[n + 1];
        return count(n, dp);
    }

    private int count(int n, int[] dp) {
        // recursion base
        if (n == 0) {
            return 1; // we done
        }
        if (n == 1) {
            return 1; // one step and we done
        }
        if (n == 2) {
            return 2; // two ways: one step over two, or two steps by 1 and we done
        }

        // memoization - if not saved, calculate it and save, otherwise just return
        if (dp[n] == 0) {
            dp[n] = countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
        return dp[n];
    }
}
