package dp.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumLeapsWithCostRecursiveTest {
    @Test
    public void shouldReturn3() {
        MinimumLeapsWithCostRecursive leaps = new MinimumLeapsWithCostRecursive();
        int cost = leaps.cost(6, new int[]{1, 2, 5, 2, 1, 2});
        assertEquals(3, cost);
    }

}