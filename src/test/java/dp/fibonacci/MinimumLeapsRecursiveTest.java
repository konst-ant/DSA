package dp.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Use for both {@link MinimumLeapsRecursive} && {@link MinimumLeapsBottomUp}
 */

class MinimumLeapsRecursiveTest {

    @Test
    public void shouldReturn3() {
        MinimumLeapsBottomUp leapsAlgo = new MinimumLeapsBottomUp();
        int leaps = leapsAlgo.minLeaps(new int[]{2, 1, 1, 1, 4});
        assertEquals(3, leaps);
    }

    @Test
    public void shouldReturn4() {
        MinimumLeapsBottomUp leapsAlgo = new MinimumLeapsBottomUp();
        int leaps = leapsAlgo.minLeaps(new int[]{1,1,3,6,9,3,0,1,3});
        assertEquals(4, leaps);
    }

}