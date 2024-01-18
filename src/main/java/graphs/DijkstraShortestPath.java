package graphs;

import java.util.*;

/**
 * You are given a directed graph G in matrix representation:
 * <p>
 * n Vertexes of G identified each by their index (i).
 * <p>
 * Edges between Vertexes are defined in a matrix square Integer array of size N: e[n][n].
 * If Vertex i is connected to Vertex j, the cell e[i][j] contains positive number denoting
 * the weight (length) of connection i -> j. Otherwise, if i is disconnected with j it contains 0.
 * <p>
 * Write a method, which given array e[n][n] and two indexes: start Vertex, and end Vertex, returns array of indexes,
 * representing the shortest path from start to end, or empty array if no such path exist:
 * <p>
 * int[] shortestPath(int e[][], int start, int end);
 * <p>
 * For example, given array:
 * <p>
 * new int[][]{
 * {0, 4, 0, 0, 0, 0, 0, 8, 0},
 * {4, 0, 8, 0, 0, 0, 0, 11, 0},
 * {0, 8, 0, 7, 0, 4, 0, 0, 2},
 * {0, 0, 7, 0, 9, 14, 0, 0, 0},
 * {0, 0, 0, 9, 0, 10, 0, 0, 0},
 * {0, 0, 4, 14, 10, 0, 2, 0, 0},
 * {0, 0, 0, 0, 0, 2, 0, 1, 6},
 * {8, 11, 0, 0, 0, 0, 1, 0, 7},
 * {0, 0, 2, 0, 0, 0, 6, 7, 0}
 * <p>
 * start = 0, end =4,
 * the method should return array : {0, 7, 6 ,5 ,4}
 */
public class DijkstraShortestPath {

    private static class Vertex implements Comparable<Vertex> {
        int index;
        // distance to this Vertex from start in the shortest path
        int distance;
        int previous;

        public Vertex(int index, int distance) {
            this.index = index;
            this.distance = distance;
            this.previous = index;
        }

        @Override
        public int compareTo(Vertex v) {
            return Integer.compare(this.distance, v.distance);
            // will also work
//            return this.distance - v.distance;
        }
    }

    Integer[] shortestPath(int e[][], int start, int end) {
        PriorityQueue<Vertex> pool = new PriorityQueue<>(e.length);
        Vertex[] vertexes = new Vertex[e.length];
        for (int i = 0; i < e.length; i++) {
            vertexes[i] = new Vertex(i, i == start ? 0 : Integer.MAX_VALUE);
            pool.add(vertexes[i]);
        }

        while (!pool.isEmpty()) {
            Vertex v = pool.poll();

            for (int i = 0; i < e[v.index].length; i++) {
                int distanceVToU = e[v.index][i];
                Vertex u = vertexes[i];
                if (distanceVToU != 0 && pool.contains(u) && u.distance > v.distance + distanceVToU) {
                    u.previous = v.index;
                    u.distance = v.distance + distanceVToU;
                    pool.remove(u);
                    pool.add(u);
                }
            }
        }

// debug
//        for (Vertex v : vertexes) {
//            System.out.println("Vertex " + v.index + " distance " + v.distance + " previous " + v.previous);
//        }

        List<Integer> result = new ArrayList<>();
        int i = end;
        int j = 0;
        while (vertexes[i].previous != vertexes[i].index) {
            result.add(i);
            i = vertexes[i].previous;
        }
        result.add(i);
        Collections.reverse(result);

        return result.toArray(new Integer[result.size()]);
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath();
        Integer[] path = dijkstraShortestPath.shortestPath(graph, 0, 4);
        for (int i = 0; i < path.length - 1; i++) {
            System.out.print(path[i] + " -> ");
        }
        System.out.println(path[path.length - 1]);
    }
}
