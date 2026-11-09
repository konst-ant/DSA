package faang.linkedlist;

/**
 * LeetCode 143: Reorder List.
 * Reorder a linked list L0->L1->...->Ln-1->Ln into L0->Ln->L1->Ln-1->... in place, O(n) time.
 */
public class ReorderList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;

        ListNode prev = null;
        ListNode curr = secondHead;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode second = prev;

        ListNode first = head;
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next = second;
            second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }
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
        ReorderList solution = new ReorderList();
        ListNode l1 = build(new int[]{1, 2, 3, 4});
        solution.reorderList(l1);
        System.out.println(toStr(l1));

        ListNode l2 = build(new int[]{1, 2, 3, 4, 5});
        solution.reorderList(l2);
        System.out.println(toStr(l2));

        ListNode l3 = build(new int[]{1});
        solution.reorderList(l3);
        System.out.println(toStr(l3));
    }
}
