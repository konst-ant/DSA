package faang.linkedlist;

/**
 * LeetCode 206: Reverse Linked List.
 * Reverse a singly linked list in place in O(n) time.
 */
public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
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
        ReverseLinkedList solution = new ReverseLinkedList();
        System.out.println(toStr(solution.reverseList(build(new int[]{1, 2, 3, 4, 5}))));
        System.out.println(toStr(solution.reverseList(build(new int[]{1, 2}))));
        System.out.println(toStr(solution.reverseList(build(new int[]{}))));
    }
}
