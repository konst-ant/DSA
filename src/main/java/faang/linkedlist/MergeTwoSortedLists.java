    package faang.linkedlist;


    import java.util.*;

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


        /**
         * Alternatively is you had two JCF lists to merge
         * Note: prefer to not use LinkedList in arguments, as get() is not much efficient with those, especially for long lists
         *
         * @param list1
         * @param list2
         * @return
         */
        public List<Integer> mergeTwoLists(List<Integer> list1, List<Integer> list2) {
            List<Integer> result = new ArrayList<>(list1.size() + list2.size());

            int i1 = 0;
            int i2 = 0;
            while (i1 < list1.size() && i2 < list2.size()) {
                // to not call get() twice
                int one = list1.get(i1);
                int two = list2.get(i2);
                if ( one <= two) {
                    result.add(one);
                    i1++;
                } else {
                    result.add(two);
                    i2++;
                }
            }
            if (i1 == list1.size()) {
                result.addAll(list2.subList(i2, list2.size()));
            } else {
                result.addAll(list1.subList(i1, list1.size()));
            }
            return result;
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
