package faang.twopointers;

/**
 * LeetCode 42: Trapping Rain Water.
 * Compute how much water can be trapped between bars after raining, given an elevation map.
 * Throws IllegalArgumentException if height is null.
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null) {
            throw new IllegalArgumentException("height must not be null");
        }
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        // Accumulated over up to ~2*10^4 bars each up to ~10^5 tall, so the running
        // total is kept in a long to stay safely clear of int overflow.
        long water = 0;

        // Time: O(n), Space: O(1). Whichever side currently has the smaller max height is the
        // one whose water level is already determined: the opposite side is guaranteed to have
        // a wall at least as tall somewhere between it and the other max, so that side's trapped
        // water only depends on its own running max, letting both pointers advance in one pass.
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
        }
        return (int) water;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(solution.trap(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(solution.trap(new int[]{}));
    }
}
