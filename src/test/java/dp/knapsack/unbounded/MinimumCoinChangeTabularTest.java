package dp.knapsack.unbounded;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * change MinimumCoinChangeTabular to MinimumCoinChangeTabular to test different algo
 */
class MinimumCoinChangeTabularTest {
    @Test
    public void shouldReturn2() {
        int[] coins = new int[]{1,2};
        int amount = 3;
        MinimumCoinChangeTabular minimumCoinChangeTabular = new MinimumCoinChangeTabular();
        assertEquals(2, minimumCoinChangeTabular.minimumNumberOfCoins(coins, amount));
    }


    @Test
    public void shouldReturn4() {
        int[] coins = new int[]{1, 2, 3};
        int amount = 11;
        MinimumCoinChangeTabular minimumCoinChangeTabular = new MinimumCoinChangeTabular();
        assertEquals(4, minimumCoinChangeTabular.minimumNumberOfCoins(coins, amount));
    }

}