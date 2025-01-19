package dp.knapsack.unbounded;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinChangeRecursiveTest {

    @Test
    public void shouldReturn2() {
        int[] coins = new int[]{1, 2};
        int amount = 3;
        CoinChangeRecursive coinChangeRecursive = new CoinChangeRecursive();
        assertEquals(2, coinChangeRecursive.count(coins, amount));
    }


    @Test
    public void shouldReturn5() {
        int[] coins = new int[]{1, 2, 3};
        int amount = 5;
        CoinChangeRecursive coinChangeRecursive = new CoinChangeRecursive();
        assertEquals(5, coinChangeRecursive.count(coins, amount));
    }

}