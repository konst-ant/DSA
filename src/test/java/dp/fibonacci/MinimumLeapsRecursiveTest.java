package dp.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumLeapsRecursiveTest {

    @Test
    public void shouldReturn3() {
        MinimumLeapsRecursive minimumLeapsRecursive = new MinimumLeapsRecursive();
        int leaps = minimumLeapsRecursive.minLeaps(new int[]{2, 1, 1, 1, 4});
        assertEquals(3, leaps);
    }

    @Test
    public void shouldReturn4() {
        MinimumLeapsRecursive minimumLeapsRecursive = new MinimumLeapsRecursive();
        int leaps = minimumLeapsRecursive.minLeaps(new int[]{1,1,3,6,9,3,0,1,3});
        assertEquals(4, leaps);
    }

}