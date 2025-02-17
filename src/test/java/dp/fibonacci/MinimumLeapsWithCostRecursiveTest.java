package dp.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Use for testing both {@link MinimumLeapsWithCostRecursive} and {@link MinimumLeapsWithCostBottomUp}
 */
class MinimumLeapsWithCostRecursiveTest {
    @Test
    public void shouldReturn3() {
        MinimumLeapsWithCostBottomUp leaps = new MinimumLeapsWithCostBottomUp();
        int cost = leaps.cost(6, new int[]{1, 2, 5, 2, 1, 2});
        assertEquals(3, cost);
    }

    @Test
    public void shouldReturn5() {
        MinimumLeapsWithCostBottomUp leaps = new MinimumLeapsWithCostBottomUp();
        int cost = leaps.cost(4, new int[]{2,3,4,5});
        assertEquals(5, cost);
    }
}