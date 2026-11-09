package faang.twopointers;

/**
 * LeetCode 11: Container With Most Water.
 * Find two lines that, together with the x-axis, form a container that holds the most water.
 * Throws IllegalArgumentException if height is null or has fewer than 2 elements.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            throw new IllegalArgumentException("height must contain at least 2 elements");
        }
        int left = 0;
        int right = height.length - 1;
        int best = 0;
        // Time: O(n), Space: O(1). Moving the pointer at the shorter line is always safe:
        // the container's width can only shrink from here on, so keeping the shorter line
        // (the current bottleneck) can never yield a larger area than discarding it.
        while (left < right) {
            int width = right - left;
            int area = width * Math.min(height[left], height[right]);
            best = Math.max(best, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(solution.maxArea(new int[]{1, 1}));
        System.out.println(solution.maxArea(new int[]{4, 3, 2, 1, 4}));
        // Edge case: minimum valid size (exactly 2 elements).
        System.out.println(solution.maxArea(new int[]{5, 9}));
    }
}
