package misc;

import java.util.Stack;

/**
 * From Gudrich & Tamassia DSA old edition, page 192
 * Given the graph of market share rate per day throughout the period,
 * calculate the rate (or course) interval function - that is the max number of days up till current day
 * during which the rate was no higher than the rate at that day
 *
 * See the screenshot ComputeSpans for task definition and solution.
 *
 * Below are two solutions:
 *
 * solution1() - O(n^2) ineffective
 * solution2() - O(n) effective
 *
 *
 * ----------------- Alternative description -----------------
 *
 * You are given array of stock share rate for N consecutive days.
 * The interval for day i is the number of days during which the rate was not bigger than at this day, including this day.
 * In case there is no such day, the interval will be -1.
 *
 *
 * Write an effective method that will calculate the interval for each of N days and return it in array of size N where each element hold value for corresponding day of input array.
 * The method need to be computationally efficient.
 *
 * public int[] solution(int[] A)
 *
 * For example given array of share rates: {7, 5, 2, 3, 2, 4, 6} the method should return {-1, 1, 1, 2, 1, 4, 6}
 *
 *
 * What is the computation complexity of solution?
 *
 */
public class ComputeSpans {

    Stack<Integer> D = new Stack<>();



    public int[] solution1(int[] shareCourseDaily) {

        int[] result = new int[shareCourseDaily.length];

        for (int i = 0; i < shareCourseDaily.length; i++) {
            int k = 0;
            boolean done = false;
            while (i - k >= 0  && !done) {
                if (shareCourseDaily[i - k] > shareCourseDaily[i]) {
                    done = true;
                } else {
                    k++;
                }
            }
            if (k <= i) {
                result[i] = k;
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    public int[] solution2(int[] shareCourseDaily) {

        // test sequence: 7, 5, 2, 3, 2, 4, 6

        int[] result = new int[shareCourseDaily.length];

        for (int i = 0; i < shareCourseDaily.length; i++) {

            boolean done = false;
            int h;

            while (!D.isEmpty() && !done) {
                if (shareCourseDaily[i] >= shareCourseDaily[D.peek()]) {
                    D.pop();
                } else {
                    done = true;
                }
            }

            if (D.isEmpty()) {
                result[i] = -1;
            } else {
                h = D.peek();
                result[i] = i - h;
            }
            D.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        ComputeSpans computeSpans = new ComputeSpans();

        // expected result: 1, 1, 1, 2, 1, 4, 6
        for (int i : computeSpans.solution2(new int[] { 7, 5, 2, 3, 2, 4, 6 })) {
            System.out.print(i + " ");
        }
    }
}
