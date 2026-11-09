package faang.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC 56: Merge Intervals.
 * Merge all overlapping intervals in a collection into a minimal set of non-overlapping intervals.
 * Precondition: intervals must be non-null.
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            throw new IllegalArgumentException("intervals must be non-null");
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1, 4}, {4, 5}})));
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1, 4}, {0, 4}})));
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1, 2}, {3, 4}})));
    }
}
