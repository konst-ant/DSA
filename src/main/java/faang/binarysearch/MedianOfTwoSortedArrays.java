package faang.binarysearch;

/**
 * LeetCode 4: Median of Two Sorted Arrays.
 * Find the median of two sorted arrays in O(log(min(m,n))) time using a partition binary search.
 * Precondition: nums1 and nums2 must be non-null, and must not both be empty.
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("nums1 and nums2 must not be null");
        }
        if (nums1.length == 0 && nums2.length == 0) {
            throw new IllegalArgumentException("nums1 and nums2 must not both be empty");
        }
        int[] a = nums1, b = nums2;
        if (a.length > b.length) {
            int[] tmp = a;
            a = b;
            b = tmp;
        }
        int m = a.length, n = b.length;
        int lo = 0, hi = m;
        int half = (m + n + 1) / 2;
        // Binary search over the number of elements taken from the shorter array `a` (cutA),
        // which fixes cutB = half - cutA. We're not searching for a value, but for the partition
        // point where every left-side element <= every right-side element across both arrays.
        // Since we only binary search the shorter array, this is O(log(min(m,n))) instead of
        // the O(m+n) a merge-based approach would need.
        while (lo <= hi) {
            int cutA = lo + (hi - lo) / 2;
            int cutB = half - cutA;

            int leftA = cutA == 0 ? Integer.MIN_VALUE : a[cutA - 1];
            int leftB = cutB == 0 ? Integer.MIN_VALUE : b[cutB - 1];
            int rightA = cutA == m ? Integer.MAX_VALUE : a[cutA];
            int rightB = cutB == n ? Integer.MAX_VALUE : b[cutB];

            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                } else {
                    return Math.max(leftA, leftB);
                }
            } else if (leftA > rightB) {
                hi = cutA - 1;
            } else {
                lo = cutA + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted");
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[]{1}));
    }
}
