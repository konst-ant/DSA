package faang.binarysearch;

/**
 * LeetCode 704: Binary Search.
 * Given a sorted array of integers and a target, return the index of the target or -1 if not found.
 * Precondition: nums must not be null (an empty array is valid and simply yields -1).
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException("nums must not be null");
        }
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        System.out.println(solution.search(new int[]{5}, 5));
        System.out.println(solution.search(new int[]{}, 1)); // empty array edge case -> -1
    }
}
