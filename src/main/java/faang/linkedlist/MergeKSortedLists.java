package faang.linkedlist;

import java.util.PriorityQueue;

/**
 * LeetCode 23: Merge k Sorted Lists.
 * Merge k sorted linked lists into one sorted list using a min-heap, O(N log k) time.
 * Precondition: the lists array must not be null (an empty array, i.e. k=0, is valid and yields an empty list).
 */
public class MergeKSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            throw new IllegalArgumentException("lists must not be null");
        }
        // A min-heap holding at most k nodes at a time lets us repeatedly pull the smallest head
        // in O(log k) instead of scanning all k list heads (O(k)) per step, giving O(N log k)
        // overall rather than the O(N*k) a naive "compare all heads" merge would cost.
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!heap.isEmpty()) {
            ListNode smallest = heap.poll();
            curr.next = smallest;
            curr = curr.next;
            if (smallest.next != null) {
                heap.offer(smallest.next);
            }
        }
        return dummy.next;
    }

    private static ListNode build(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : values) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    private static String toStr(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(" -> ");
            }
            head = head.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();
        ListNode[] lists1 = {build(new int[]{1, 4, 5}), build(new int[]{1, 3, 4}), build(new int[]{2, 6})};
        System.out.println(toStr(solution.mergeKLists(lists1)));

        ListNode[] lists2 = {};
        System.out.println(toStr(solution.mergeKLists(lists2)));

        ListNode[] lists3 = {build(new int[]{})};
        System.out.println(toStr(solution.mergeKLists(lists3)));

        ListNode[] lists4 = {build(new int[]{1, 2, 3})}; // k=1 edge case
        System.out.println(toStr(solution.mergeKLists(lists4)));
    }
}
