package faang.intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LC 252 & 253: Meeting Rooms I and II.
 * Determine whether a person can attend all meetings, and find the minimum number of rooms
 * needed to schedule all meetings.
 * Precondition: intervals must be non-null.
 */
public class MeetingRooms {

    public boolean canAttendAll(int[][] intervals) {
        if (intervals == null) {
            throw new IllegalArgumentException("intervals must be non-null");
        }
        int[][] sorted = intervals.clone();
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i][0] < sorted[i - 1][1]) {
                return false;
            }
        }
        return true;
    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null) {
            throw new IllegalArgumentException("intervals must be non-null");
        }
        if (intervals.length == 0) {
            return 0;
        }
        int[][] sorted = intervals.clone();
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        for (int[] interval : sorted) {
            if (!endTimes.isEmpty() && endTimes.peek() <= interval[0]) {
                endTimes.poll();
            }
            endTimes.offer(interval[1]);
        }
        return endTimes.size();
    }

    public static void main(String[] args) {
        MeetingRooms solution = new MeetingRooms();
        System.out.println(solution.canAttendAll(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(solution.canAttendAll(new int[][]{{7, 10}, {2, 4}}));
        System.out.println(solution.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(solution.minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));
    }
}
