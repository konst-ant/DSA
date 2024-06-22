package lists;

import org.junit.jupiter.api.Test;

import static lists.DetectLinkedListCycle.Node;
import static org.junit.jupiter.api.Assertions.*;

class DetectLinkedListCycleTest {
    DetectLinkedListCycle detect = new DetectLinkedListCycle();

    @Test
    public void shouldReturnTrueWhenListHasNoCycle() {
        Node head = new Node(5, null);
        head = new Node(4, head);
        head = new Node(3, head);
        head = new Node(2, head);
        head = new Node(1, head);
        detect.print(head);
        assertFalse(detect.hasCycle(head));
    }

    @Test
    public void shouldReturFalseWhenListHasCycle() {
        // make a linear list
        Node head = new Node(8, null);
        Node cycleFrom = head;
        head = new Node(7, head);
        head = new Node(6, head);
        head = new Node(5, head);
        head = new Node(4, head);
        Node cycledTo = head;
        head = new Node(3, head);
        head = new Node(2, head);
        head = new Node(1, head);
        // make a cycle
        cycleFrom.next = cycledTo;
        detect.print(head);
        assertTrue(detect.hasCycle(head));

    }
}