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

        // dp - for each index i stores min cost to step next to the topest staircase, for a staircase
        // consisting of only i stairs

        // so dp[0] will be null
        // dp[1] == dp[2] == dp[3] = costs[0], as we start from 1-st stair and can leap over 2, and 3 without
        // extra cost

        // Note: keeping cost for "empty staircase" in element 0. Then dp[i] will semantically store solution
        // for staircase of i stairs
        int[] dp = new int[costs.length + 1];

        dp[0] = 0;
        dp[1] = costs[0];
        dp[2] = costs[0];
        dp[3] = costs[0];

        for (int i = 3; i < costs.length; i++) {
            // calculating dp[i + 1], we can reach stair next to i + 1 in 3 ways:
            //
            // - if we step over stair i, then step stair i + 1, then next behind i + 1 => then dp[i] + costs[i]
            //      (Note: costs[i] - is cost for stair i + 1 in fact, cause index starts from 0)
            // - if we step over stair i - 1 that is stair i, then step over stair i + 1 => dp[i - 1] + costs [i -1]
            // - if we step over stair i - 2 that is stair i - 1, then step over stairs i and i + 1 => dp[i - 2] + costs[i - 2]
            //
            // or through the current stair => then cost of current stair plus (dp) of stair -3
            int c1 = dp[i] + costs[i];
            int c2 = dp[i - 1] + costs[i - 1];
            int c3 = dp[i - 2] + costs[i - 2];
            dp[i + 1] = Math.min(Math.min(c1, c2), c3);
        }

        return dp[dp.length - 1];
    }
}
