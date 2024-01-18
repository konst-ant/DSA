package leetcode;

import java.util.PriorityQueue;


/**
 * Note: this is a bit weird solution:
 * 1. pull 7 first elements into min priority queue - at the top of the queue is min (ensuring queue is 7 elem in size)
 * 2. traverse the rest elements checking and swapping top with upcoming if the top is smaller than the next upcoming
 * 3. at the top stands the K-th Largest
 *
 *
 * Each of the n elements is processed once. However, heap operations take O(log(k)) time, leading to an overall complexity of O(nlog(k)).
 */
public class KthLargestArrayElement {

    public static void main(String[] args) {
        KthLargestArrayElement kthLargestArrayElement = new KthLargestArrayElement();
        System.out.println(kthLargestArrayElement.findKthLargest(new int[]{7, 89, 2, 43, 35, 34, 7, 56, 8}, 3));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }
}
