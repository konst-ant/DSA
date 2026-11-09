package faang.twopointers;

import java.util.Arrays;

/**
 * LeetCode 75: Sort Colors.
 * Sort an array containing only 0s, 1s, and 2s in-place in one pass using the Dutch National Flag algorithm.
 * Throws IllegalArgumentException if nums is null.
 */
public class SortColors {

    public void sortColors(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("nums must not be null");
        }
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        // Time: O(n), Space: O(1). Dutch National Flag invariant: [0, low) are all 0s,
        // [low, mid) are all 1s, (high, n) are all 2s, and [mid, high] is unexamined.
        // Each iteration either advances mid or shrinks the unexamined range, so one pass suffices.
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors solution = new SortColors();
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums1);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {2, 0, 1};
        solution.sortColors(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {0};
        solution.sortColors(nums3);
        System.out.println(Arrays.toString(nums3));

        // Edge case: empty array.
        int[] nums4 = {};
        solution.sortColors(nums4);
        System.out.println(Arrays.toString(nums4));
    }
}
