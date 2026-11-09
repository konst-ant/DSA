package faang.arrayshashing;

import java.util.Arrays;

/**
 * LeetCode 238: Product of Array Except Self.
 * Return an array where each element is the product of all other elements, without using division.
 * Throws IllegalArgumentException if nums is null or has fewer than 2 elements.
 * The suffix accumulator is kept as a long so the running multiply itself never overflows before
 * the final Math.toIntExact narrowing check.
 */
public class ProductOfArrayExceptSelf {

    // Time: O(n), Space: O(1) extra (excluding the required output array). The prefix products
    // are written directly into result[] on the forward pass, so no separate prefix array is needed;
    // the backward pass then folds the suffix product in place.
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("nums must contain at least two elements");
        }
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        long suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = Math.toIntExact(result[i] * suffix);
            suffix *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{2, 3})));
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{0, 0, 5}))); // multiple zeros edge case
    }
}
