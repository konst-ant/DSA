package dp.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Use for both {@link MaximumNonConsecutiveRecursive} and {@link MaximumNonConsecutiveRecursive}
 */
class MaximumNonConsecutiveTest {
    @Test
    public void shouldReturn15() {
        MaximumNonConsecutiveRecursive select = new MaximumNonConsecutiveRecursive();
        int result = select.maximum(new int[]{2, 5, 1, 3, 6, 2, 4});
        assertEquals(15, result);
    }

    @Test
    public void shouldReturn18() {
        MaximumNonConsecutiveRecursive select = new MaximumNonConsecutiveRecursive();
        int result = select.maximum(new int[]{2, 10, 14, 8, 1});
        assertEquals(18, result);
    }
}