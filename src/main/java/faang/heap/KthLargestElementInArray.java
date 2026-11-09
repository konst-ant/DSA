package faang.heap;

import java.util.PriorityQueue;

/**
 * LC 215: Kth Largest Element in an Array.
 * Returns the kth largest element using a min-heap of size k.
 * Precondition: nums must be non-null/non-empty and 1 &lt;= k &lt;= nums.length.
 */
public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums must not be null or empty");
        }
        if (k < 1 || k > nums.length) {
            throw new IllegalArgumentException("k must be between 1 and nums.length");
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInArray solver = new KthLargestElementInArray();
        System.out.println(solver.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(solver.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));

        // Edge case: k equal to the array length returns the smallest element.
        System.out.println(solver.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 6));
    }
}
