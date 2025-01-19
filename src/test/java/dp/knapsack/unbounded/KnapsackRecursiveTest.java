package dp.knapsack.unbounded;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnapsackRecursiveTest {

    public static KnapsackRecursive knapsack;

    @BeforeAll
    public static void setup() {
        knapsack = new KnapsackRecursive();
    }

    @Test
    public void shouldReturn80() {
        int[] weights = new int[]{1, 2, 3};
        int[] profits = new int[]{15, 20, 50};
        int capacity = 5;
        int[][] dp = new int[weights.length][capacity + 1];
        assertEquals(80, knapsack.solution(weights, profits, weights.length - 1, capacity, dp));
    }

}