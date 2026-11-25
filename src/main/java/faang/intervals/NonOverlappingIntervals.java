package faang.intervals;

import java.util.Arrays;

/**
 * LC 435: Non-overlapping Intervals.
 * Find the minimum number of intervals to remove so that the rest do not overlap.
 * Precondition: intervals must be non-null.
 */
public class NonOverlappingIntervals {

    // R-isotopic version - retain earlier-finish intervals, more left-to-right
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null) {
            throw new IllegalArgumentException("intervals must be non-null");
        }
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int lastEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                count++;
            } else {
                lastEnd = intervals[i][1];
            }
        }
        return count;
    }

    // L-isotopic version - retain the later-start intervals, move right-to-left
    public int eraseOverlapIntervals_L(int[][] intervals) {
        if (intervals == null) {
            throw new IllegalArgumentException(
                    "intervals must be non-null"
            );
        }
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals,
                (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        int lastStart = intervals[intervals.length - 1][0];

        for (int i = intervals.length - 2; i >= 0; i--) {
            if (intervals[i][1] > lastStart) {
                count++;
            } else {
                lastStart = intervals[i][0];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals solution = new NonOverlappingIntervals();
        System.out.println(solution.eraseOverlapIntervals_L(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
    }
}
