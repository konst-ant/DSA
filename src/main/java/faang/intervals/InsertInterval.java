package faang.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 57: Insert Interval.
 * Insert a new interval into a sorted, non-overlapping list of intervals, merging as needed.
 * Precondition: intervals and newInterval must be non-null, and newInterval must have exactly 2 elements.
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || newInterval == null) {
            throw new IllegalArgumentException("intervals and newInterval must be non-null");
        }
        if (newInterval.length != 2) {
            throw new IllegalArgumentException("newInterval must have exactly 2 elements");
        }
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval solution = new InsertInterval();
        System.out.println(java.util.Arrays.deepToString(
                solution.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(java.util.Arrays.deepToString(
                solution.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
        System.out.println(java.util.Arrays.deepToString(
                solution.insert(new int[][]{}, new int[]{5, 7})));
    }
}
