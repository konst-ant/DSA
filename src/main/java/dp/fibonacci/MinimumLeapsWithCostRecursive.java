package dp.fibonacci;


/**
 * You climb a staircase with n stairs. You also have an array of 'n' numbers representing the cost to be payed if you
 * step on corresponding stair. Calculate minimum cost required to climb up the staircase (step away from staircase).
 * You can step either 1 stair, 2 stairs, or 3 stairs with each step, and you start from stair 1 (index 0)
 *
 * public int cost(int n, int[] costs)
 *
 * Examples:
 *
 * n : 6
 * costs = {1,2,5,2,1,2}
 * Result: 3
 * Cost is 1+2 with path {0, 3, top}
 *
 */
public class MinimumLeapsWithCostRecursive
{
    public int cost(int n, int[] costs) {
        int[] dp = new int[costs.length];
        return costRecursive(costs, 0, dp);
    }

    public int costRecursive(int[] costs, int index, int[] dp) {

        // recursion base
        if (index >= costs.length) {
            return 0;
        }

        if (dp[index] != 0) {
            return dp[index];
        }

        int c1 = costs[index] + costRecursive(costs, index + 1, dp);
        int c2 = costs[index] + costRecursive(costs, index + 2, dp);
        int c3 = costs[index] + costRecursive(costs, index + 3, dp);
        dp[index] = Math.min(Math.min(c1, c2), c3);

        return dp[index];
    }
}
