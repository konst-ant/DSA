package dp.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StairCaseRecursiveTest {
    @Test
    public void shouldReturn4() {
        int stairs = 3;
        StairCaseRecursive stairCase = new StairCaseRecursive();
        assertEquals(4, stairCase.countWays(stairs));
    }

    @Test
    public void shouldReturn7() {
        int stairs = 4;
        StairCaseRecursive stairCase = new StairCaseRecursive();
        assertEquals(7, stairCase.countWays(stairs));
    }
}