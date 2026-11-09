package faang.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC 133: Clone Graph.
 * Returns a deep copy of a connected undirected graph given a reference node,
 * using DFS with a visited map to avoid infinite recursion on cycles.
 * Precondition: none beyond accepting a null node, which maps to a null clone.
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return clone(node, new HashMap<>());
    }

    private Node clone(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node copy = new Node(node.val);
        visited.put(node, copy);
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(clone(neighbor, visited));
        }
        return copy;
    }

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.neighbors.add(n2);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);

        CloneGraph solver = new CloneGraph();
        Node cloned = solver.cloneGraph(n1);
        System.out.println(cloned.val + " neighbors: " + cloned.neighbors.size());
        System.out.println(cloned != n1);

        // Edge case: a single node with no neighbors.
        Node isolated = new Node(42);
        Node clonedIsolated = solver.cloneGraph(isolated);
        System.out.println(clonedIsolated.val + " neighbors: " + clonedIsolated.neighbors.size());

        // Edge case: null input produces a null clone rather than throwing.
        System.out.println(solver.cloneGraph(null));
    }
}
