package faang.linkedlist;

/**
 * LeetCode 141: Linked List Cycle.
 * Detect whether a linked list has a cycle using Floyd's tortoise-and-hare algorithm, O(n) time.
 */
public class LinkedListCycle {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();

        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;
        System.out.println(solution.hasCycle(a));

        ListNode e = new ListNode(1);
        ListNode f = new ListNode(2);
        e.next = f;
        f.next = e;
        System.out.println(solution.hasCycle(e));

        ListNode g = new ListNode(1);
        System.out.println(solution.hasCycle(g));

        System.out.println(solution.hasCycle(null)); // empty list edge case
    }
}
