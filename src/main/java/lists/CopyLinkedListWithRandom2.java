package lists;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CopyLinkedListWithRandom2 {

    public static void main(String[] args) {

    }

    public static Node copyListWithRandom(Node node){
        Map<Node,Integer> nodeMap = new LinkedHashMap<>();
        int idx = 1;
        while(node!=null){
            nodeMap.put(node,idx++);
        }

        if(node==null)
            return null;
        Node prev= new Node(node.val);
        Node newHead = prev;
        while(node.next!=null){
            Node head1 = new Node(node.val);
            prev.next = head1;
            prev = head1;
            node = node.next;
        }
        Map<Node,Integer> newNodeMap = new LinkedHashMap<>();
        int idx2 = 1;
        while(node!=null){
            newNodeMap.put(node,idx2++);
        }
        Set<Node> keyset = nodeMap.keySet();
        for(Node key:keyset){
            int i = nodeMap.get(key);
            int j = nodeMap.get(key.random);
        }

        return newHead;
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
