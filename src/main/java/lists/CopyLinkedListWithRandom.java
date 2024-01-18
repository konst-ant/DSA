package lists;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * A singly linked list of length N is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 *
 * Write a method, making a deep copy of the list.
 * The deep copy should consist of N brand new nodes, where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list.
 * None of the pointers in the new list should point to nodes in the original list.
 *
 * public Node solution(Node head);
 *
 */

class CopyLinkedListWithRandom {

    public Node copyListWithRandom(Node head) {
        if(head == null) return null;
        Map<Node,Node> map = new HashMap();
        Node curr = head;
        // First Pass - Copy Nodes
        while(curr != null){
            map.put(curr,new Node(curr.val));
            curr = curr.next;
        }
        // Second Pass - Connect Nodes
        for(Node currentNode : map.keySet()){
            Node newNode = map.get(currentNode);
            newNode.next = map.get(currentNode.next);
            newNode.random = map.get(currentNode.random);
        }
        return map.get(head);
    }

    public static void main(String[] args) {

    }

    private static class Node {
        Node next;
        Node random;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
