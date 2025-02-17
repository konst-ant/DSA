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
public class MinimumLeapsWithCostBottomUp
{
    public int cost(int n, int[] costs) {

        // dp - semantically stores the minimum cost of REACHING THAT STAIR
        // (not hopping over! which is different from task definition about hopping over)
        // and that kind of dp will allow us to calculate the cost of reaching top
        // (with hopping over the highest stair semantic)
        int[] dp = new int[costs.length];

        dp[0] = costs[0];
        dp[1] = costs[0] + costs[1];
        dp[2] = costs[0] + costs[2];

        for (int i = 3; i < costs.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 3; i < costs.length; i++) {
            // we can reach the top either jumping off the current stair from (dp) of stair -1, or (dp) of stair -2
            // (that is possible)
            //
            // or through the current stair => then cost of current stair plus (dp) of stair -3
            int c1 = dp[i-1];
            int c2 = dp[i-2];
            int c3 = dp[i-3] + costs[i];
            dp[i] = Math.min(Math.min(c1, c2), c3);
        }

        return dp[costs.length - 1];
    }
}
