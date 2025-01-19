package dp.unlimited;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumCoinChangeTabularTest {
    @Test
    public void shouldReturn2() {
        int[] coins = new int[]{1,2,3};
        int amount = 5;
        MinimumCoinChangeTabular2 minimumCoinChangeTabular = new MinimumCoinChangeTabular2();
        assertEquals(2, minimumCoinChangeTabular.minimumNumberOfCoins(coins, amount));
    }


    @Test
    public void shouldReturn4() {
        int[] coins = new int[]{1, 2, 3};
        int amount = 11;
        MinimumCoinChangeTabular2 minimumCoinChangeTabular = new MinimumCoinChangeTabular2();
        assertEquals(4, minimumCoinChangeTabular.minimumNumberOfCoins(coins, amount));
    }

}