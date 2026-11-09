package faang.linkedlist;

/**
 * LeetCode 19: Remove Nth Node From End of List.
 * Remove the nth node from the end of a linked list in a single O(n) pass.
 * Precondition: head must not be null and n must be a positive integer no greater than the list length.
 */
public class RemoveNthNodeFromEndOfList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            throw new IllegalArgumentException("head must not be null");
        }
        if (n <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
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
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        System.out.println(toStr(solution.removeNthFromEnd(build(new int[]{1, 2, 3, 4, 5}), 2)));
        System.out.println(toStr(solution.removeNthFromEnd(build(new int[]{1}), 1)));
        System.out.println(toStr(solution.removeNthFromEnd(build(new int[]{1, 2}), 1)));
    }
}
