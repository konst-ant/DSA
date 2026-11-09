package faang.advancedgraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LC 743: Network Delay Time.
 * Returns the time for a signal sent from node k to reach all n nodes, or -1
 * if impossible, using Dijkstra's shortest path algorithm with a min-heap.
 * Precondition: times must be non-null with non-negative edge weights (Dijkstra is undefined
 * for negative weights), n must be positive, and k must be a valid node in [1, n].
 */
public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        if (times == null) {
            throw new IllegalArgumentException("times must not be null");
        }
        if (n < 1) {
            throw new IllegalArgumentException("n must be positive");
        }
        if (k < 1 || k > n) {
            throw new IllegalArgumentException("k must be a valid node between 1 and n");
        }
        for (int[] time : times) {
            if (time[2] < 0) {
                throw new IllegalArgumentException("edge weights must not be negative");
            }
        }

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        int[] dist = new int[n + 1];
        java.util.Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Dijkstra with a min-heap always expands the closest known unvisited node next, giving
        // O(E log V) overall; since all weights are non-negative this reaches the optimum
        // without Bellman-Ford's O(V*E) full relaxation passes.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{k, 0});

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[0];
            int d = current[1];
            if (d > dist[node]) {
                continue;
            }
            for (int[] edge : graph.get(node)) {
                int next = edge[0];
                int weight = edge[1];
                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    minHeap.offer(new int[]{next, dist[next]});
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, dist[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        NetworkDelayTime solver = new NetworkDelayTime();
        System.out.println(solver.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println(solver.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1));

        // Edge case: node 1 is unreachable from node 2, so no signal can ever arrive.
        System.out.println(solver.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2));
    }
}
