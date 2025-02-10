package dp.fibonacci;

/**
 * Note this is completely equivalent problem as StairCase.
 * Solving it recursively is exactly the same, but for tabular algo we're using a O(1) implementation
 * <p>
 * Given a number 'n', implement a method to count how many possible ways there are to express 'n' as
 * the sum of 1, 3, or 4.
 *
 * public int countAddendWays(int n)
 *
 * Examples:
 * Number = 4
 * Result = 4 -> {1,1,1,1}, {1,3}, {3,1}, {4}
 * <p>
 * Number = 5
 * Result = 6 -> {1,1,1,1,1}, {1,1,3}, {1,3,1}, {3,1,1}, {1,4}, {4,1}
 *
 */
public class NumberAddendsTabular {

    /**
     * for n = 0 let result be 1 way for algo to be consistent (actually 0)
     * for n = 1 result is 1 {1}
     * for n = 1 there is also only 1 way to represent with addends {1, 1}
     * for n = 2 there are 2 possible ways {3} {1,1,1}
     */
    public int countAddendWays(int n) {
        int a0 = 1;
        int a1 = 1;
        int a2 = 1;
        int a3 = 2;

        int tmp = a3;
        for (int i = 4; i <= n; i++) {
            a3 = a3 + a1 + a0;
            a0 = a1;
            a1 = a2;
            a2 = tmp;
        }
        return a3;
    }
}
