package faang.bitmanipulation;

import java.util.Arrays;

/**
 * LC 338: Counting Bits.
 * For every number from 0 to n, compute the number of set bits in its binary representation.
 * Precondition: n must be non-negative.
 */
public class CountingBits {

    public int[] countBits(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // i >> 1 drops the lowest bit, and that bit's own value is (i & 1), so the bit
            // count of i is just the already-computed count for i >> 1 plus that one bit.
            // This reuses prior results in O(1) per i, giving O(n) total instead of O(n log n)
            // from popcounting each number independently.
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }

    public static void main(String[] args) {
        CountingBits solution = new CountingBits();
        System.out.println(Arrays.toString(solution.countBits(2)));
        System.out.println(Arrays.toString(solution.countBits(5)));
        System.out.println(Arrays.toString(solution.countBits(0)));
    }
}
