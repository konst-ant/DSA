package faang.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LC 973: K Closest Points to Origin.
 * Returns the k points closest to the origin using a max-heap of size k.
 * Precondition: points must be non-null and k must not be negative; if k exceeds
 * points.length, all points are returned.
 */
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        if (points == null) {
            throw new IllegalArgumentException("points must not be null");
        }
        if (k < 0) {
            throw new IllegalArgumentException("k must not be negative");
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin solver = new KClosestPointsToOrigin();
        System.out.println(Arrays.deepToString(solver.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
        System.out.println(Arrays.deepToString(
                solver.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));

        // Edge case: k larger than the number of available points returns them all.
        System.out.println(Arrays.deepToString(solver.kClosest(new int[][]{{1, 1}, {2, 2}}, 5)));
    }
}
