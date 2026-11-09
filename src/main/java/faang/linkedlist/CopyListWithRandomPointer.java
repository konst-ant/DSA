package faang.linkedlist;

/**
 * LeetCode 138: Copy List with Random Pointer.
 * Deep-copy a linked list where each node also has a random pointer to any node or null, O(n)
 * time and O(1) extra space (excluding the output copy).
 */
public class CopyListWithRandomPointer {

    public static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // Weave each copy directly after its original node: orig1 -> copy1 -> orig2 -> copy2 -> ...
        // That lets us resolve copy.random as curr.random.next (the copy immediately following the
        // original's random target) without any auxiliary map, so we need O(1) extra space instead
        // of the O(n) a HashMap<original, copy> would use.
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node newHead = head.next;
        Node original = head;
        Node copy = head.next;
        while (original != null) {
            original.next = copy.next;
            original = original.next;
            copy.next = (original != null) ? original.next : null;
            copy = copy.next;
        }
        return newHead;
    }

    private static String toStr(Node head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append("[").append(head.val).append(",")
                    .append(head.random == null ? "null" : head.random.val).append("]");
            if (head.next != null) {
                sb.append(" -> ");
            }
            head = head.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();

        Node a = new Node(7);
        Node b = new Node(13);
        Node c = new Node(11);
        Node d = new Node(10);
        Node e = new Node(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        b.random = a;
        c.random = e;
        d.random = c;
        e.random = a;

        Node copy = solution.copyRandomList(a);
        System.out.println(toStr(copy));
        System.out.println(copy != a);
        System.out.println(solution.copyRandomList(null));
    }
}
