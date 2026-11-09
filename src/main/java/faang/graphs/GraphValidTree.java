package faang.graphs;

/**
 * LC 261: Graph Valid Tree.
 * Determines whether an undirected graph with n nodes and a list of edges forms
 * a valid tree (connected and acyclic), using union-find.
 * Precondition: n must be positive and edges must not be null.
 */
public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be positive");
        }
        if (edges == null) {
            throw new IllegalArgumentException("edges must not be null");
        }
        if (edges.length != n - 1) {
            return false;
        }
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int rootA = find(parent, edge[0]);
            int rootB = find(parent, edge[1]);
            if (rootA == rootB) {
                return false;
            }
            parent[rootA] = rootB;
        }
        return true;
    }

    private int find(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public static void main(String[] args) {
        GraphValidTree solver = new GraphValidTree();
        System.out.println(solver.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        System.out.println(solver.validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));

        // Edge case: a single node with no edges is trivially a valid tree.
        System.out.println(solver.validTree(1, new int[][]{}));
    }
}
