package dp.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberAddendsTabularTest {

    @Test
    public void shouldReturn4() {
        NumberAddendsTabular numberAddendsTabular = new NumberAddendsTabular();
        int w = numberAddendsTabular.countAddendWays(4);
        assertEquals(4, w);
    }

    @Test
    public void shouldReturn6() {
        NumberAddendsTabular numberAddendsTabular = new NumberAddendsTabular();
        int w = numberAddendsTabular.countAddendWays(5);
        assertEquals(6, w);
    }

}