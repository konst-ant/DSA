package faang.dp2d;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 494: Target Sum.
 * Count the number of ways to assign + or - signs to each number so the expression evaluates to target.
 * Precondition: nums must be non-null.
 */
public class TargetSum {

    // LC constraint: sum of nums[i] <= 1000, so the running sum lies in [-1000, 1000].
    private static final int SUM_OFFSET = 1000;
    // Width of the sum range (SUM_OFFSET to -SUM_OFFSET inclusive) used to make memo keys unique per index.
    private static final int SUM_RANGE_WIDTH = 2 * SUM_OFFSET + 1;

    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException("nums must be non-null");
        }
        // Although written as +/- recursion, the reachable (index, sum) pairs are bounded by
        // index in [0, n] and sum in [-SUM_OFFSET, SUM_OFFSET], so memoizing on that key caps
        // the state space at O(n * SUM_RANGE_WIDTH): the same O(n * sum) bound a bottom-up
        // subset-sum reformulation would achieve, rather than the naive O(2^n) branching.
        Map<Integer, Integer> memo = new HashMap<>();
        return helper(nums, 0, 0, target, memo);
    }

    private int helper(int[] nums, int index, int sum, int target, Map<Integer, Integer> memo) {
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }
        int key = index * SUM_RANGE_WIDTH + sum + SUM_OFFSET;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int add = helper(nums, index + 1, sum + nums[index], target, memo);
        int subtract = helper(nums, index + 1, sum - nums[index], target, memo);
        int result = add + subtract;
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        TargetSum solution = new TargetSum();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution.findTargetSumWays(new int[]{1}, 1));
        System.out.println(solution.findTargetSumWays(new int[]{1, 0}, 1));
    }
}
