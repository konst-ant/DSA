package graphs;

import java.util.*;


/**
 * You are given graph represented with the following vertex data structure
 *
 * class Vertex {
 * 	public int value;
 * 	public List<Vertex> adjacent;
 * }
 *
 * 1. write a method that makes and returns a deep copy of given input graph
 * public Vertex graphCopy(Vertex root)
 *
 * For example, given an input graph: 1 - 2
 * 								      |   |
 * 								      4 - 3
 *
 * the method will return a graph consisting of Vertexes all different from  original graph Vertexes, but having
 * the same structure and same values as in original graph.
 * 2. write a method that
 */
public class CopyGraph {

    private static class Vertex {
        public int value;
        public List<Vertex> adjacent;

        public Vertex(int value) {
            this.value = value;
            this.adjacent = new ArrayList<>();
        }

        public Vertex(int value, List<Vertex> adjacent) {
            this.value = value;
            this.adjacent = adjacent;
        }
    }

    public Vertex graphDeepCopy(Vertex root) {
        Vertex copy = new Vertex(root.value);
        dfs(root, copy, new HashMap<>());
        return copy;
    }

    private void dfs(Vertex vertex, Vertex newVertex, Map<Vertex, Vertex> visited) {
        visited.put(vertex, newVertex);
        for (Vertex v : vertex.adjacent) {
            if (!visited.containsKey(v)) {
                Vertex newV = new Vertex(v.value);
                newVertex.adjacent.add(newV);
                dfs(v, newV, visited);
            } else {
                newVertex.adjacent.add(visited.get(v));
            }
        }
    }

    public void print(Vertex vertex) {
        print(vertex, new HashSet());
    }

    private void print(Vertex vertex, Set visited) {
        visited.add(vertex);
        for (Vertex v : vertex.adjacent) {
            System.out.println("(hashcode=" + System.identityHashCode(vertex) + ") " + vertex.value + " - " + v.value);
            if (!visited.contains(v)) {
                print(v, visited);
            }
        }
    }


    public static void main(String[] args) {
        Vertex fourth = new Vertex(4);
        Vertex third = new Vertex(3, List.of(fourth));
        Vertex second = new Vertex(2, List.of(third));
        Vertex first = new Vertex(1, List.of(second));
        fourth.adjacent.add(first);

        CopyGraph copyGraph = new CopyGraph();

        Vertex copy = copyGraph.graphDeepCopy(first);
        copyGraph.print(first);
        copyGraph.print(copy);
    }
}
