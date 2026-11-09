package faang.linkedlist;

/**
 * LeetCode 21: Merge Two Sorted Lists.
 * Merge two sorted linked lists into one sorted linked list in O(n + m) time.
 */
public class MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = (list1 != null) ? list1 : list2;
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
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        System.out.println(toStr(solution.mergeTwoLists(build(new int[]{1, 2, 4}), build(new int[]{1, 3, 4}))));
        System.out.println(toStr(solution.mergeTwoLists(build(new int[]{}), build(new int[]{}))));
        System.out.println(toStr(solution.mergeTwoLists(build(new int[]{}), build(new int[]{0}))));
    }
}
