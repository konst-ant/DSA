package faang.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LeetCode 739: Daily Temperatures.
 * For each day, find how many days until a warmer temperature occurs, using a monotonic stack.
 * Precondition: {@code temperatures} must not be null (empty arrays are valid and return an empty result).
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            throw new IllegalArgumentException("temperatures must not be null");
        }
        int[] result = new int[temperatures.length];
        Deque<Integer> indices = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!indices.isEmpty() && temperatures[i] > temperatures[indices.peek()]) {
                int prevIndex = indices.pop();
                result[prevIndex] = i - prevIndex;
            }
            indices.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{30, 40, 50, 60})));
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{30, 60, 90})));
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{}))); // edge case: empty input
    }
}
