package faang.arrayshashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1: Two Sum.
 * Given an array of integers and a target, return indices of the two numbers that add up to target.
 * Throws IllegalArgumentException if nums is null or has fewer than 2 elements.
 * Returns {-1, -1} if no valid pair exists.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("nums must contain at least two elements");
        }
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // Compute in long first: target - nums[i] can exceed the int range when both
            // are near Integer.MIN_VALUE/MAX_VALUE, and such a complement can never match
            // an actual int element anyway.
            long complementLong = (long) target - nums[i];
            if (complementLong >= Integer.MIN_VALUE && complementLong <= Integer.MAX_VALUE) {
                int complement = (int) complementLong;
                if (seen.containsKey(complement)) {
                    return new int[]{seen.get(complement), i};
                }
            }
            seen.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{1, 2}, 10))); // no valid pair edge case
        System.out.println(Arrays.toString(solution.twoSum(
                new int[]{Integer.MIN_VALUE, 1}, Integer.MAX_VALUE))); // overflow-safe complement edge case
    }
}
