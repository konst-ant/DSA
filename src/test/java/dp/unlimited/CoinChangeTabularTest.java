package dp.unlimited;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTabularTest {

    @Test
    public void shouldReturn2() {
        int[] coins = new int[]{1, 2};
        int amount = 3;
        CoinChangeTabular coinChangeTabular = new CoinChangeTabular();
        assertEquals(2, coinChangeTabular.count(coins, amount));
    }


    @Test
    public void shouldReturn5() {
        int[] coins = new int[]{1, 2, 3};
        int amount = 5;
        CoinChangeTabular CoinChangeTabular = new CoinChangeTabular();
        assertEquals(5, CoinChangeTabular.count(coins, amount));
    }

}