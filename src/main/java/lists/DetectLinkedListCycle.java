package lists;

/**
 * Detect if a linked list has a cycle.
 * <p>
 * Floyd's Turtle and Hare algorithm
 * Let's have two pointers t - turtle, and h - hare starting simultaneously from head of the list. At that turtle step is
 * one position ahead, and hare step is two positions ahead. Otherwise, hare will reach the end of the list.
 * <p>
 * Let's prove that:
 * in case the list has a cycle, at some iteration positions of turtle and hare will coincide.
 * <p>
 * True, if the list has a cycle, at some moment in time moving around the cycle hair will happen to be "behind" turtle.
 * He will be catching up turtle, both creatures moving around the cycle. With each step the distance between them will
 * be reducing by 1 node because hare covers 2 nodes with a step, while turtle covers 1 node at a step. Consequently, at
 * one of the subsequent steps hare will appear in the same position with turtle.
 */
public class DetectLinkedListCycle {
    // see tests

    public static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public boolean hasCycle(Node head) {
        if (head == null || head.next == null)
            return false;

        Node turtle = head;
        Node hare = head.next;

        while (turtle != hare) {
            if (hare == null || hare.next == null) {
                return false;
            }

            turtle = turtle.next;
            hare = hare.next.next;
        }
        return true;
    }

    public void print(Node node) {
        StringBuilder output = new StringBuilder();
        int counter = 0;

        Node tmp = node;
        while (tmp != null && counter++ < 1000) {
            output.append(tmp.value).append("->");
            tmp = tmp.next;
        }

        if (counter > 1000) {
            System.out.println("Your probably made a cycled list");
        } else {
            output.append("null");
            System.out.println(output.toString());
        }

    }

}
