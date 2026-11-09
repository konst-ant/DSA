package faang.heap;

import java.util.Arrays;

/**
 * LC 621: Task Scheduler.
 * Given tasks and a cooldown n between identical tasks, returns the minimum
 * number of intervals (including idles) needed to finish all tasks.
 * Precondition: tasks must be non-null and the cooldown period n must not be negative.
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if (tasks == null) {
            throw new IllegalArgumentException("tasks must not be null");
        }
        if (n < 0) {
            throw new IllegalArgumentException("cooldown period n must not be negative");
        }
        if (tasks.length == 0) {
            return 0;
        }
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }
        Arrays.sort(counts);
        int maxCount = counts[25];
        // The most frequent task forces (maxCount - 1) cooldown gaps of size n. Every other
        // task can fill at most (maxCount - 1) of those gap slots (one per gap, since it can't
        // repeat within a single cooldown window), so we can compute the leftover idle slots
        // directly from the counts without simulating the schedule slot by slot.
        int idleSlots = (maxCount - 1) * n;

        for (int i = 24; i >= 0 && counts[i] > 0; i--) {
            idleSlots -= Math.min(counts[i], maxCount - 1);
        }
        idleSlots = Math.max(0, idleSlots);
        return tasks.length + idleSlots;
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        System.out.println(scheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(scheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0));

        // Edge case: no tasks to schedule.
        System.out.println(scheduler.leastInterval(new char[0], 2));
    }
}
