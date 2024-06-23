package dp.unlimited;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTabularTest {

    @Test
    public void shouldReturn80AndTwoApple() {
        List<String> items = List.of("Apple", "Orange", "Melon");
        int[] weights = new int[]{1, 2, 3};
        int[] profits = new int[]{15, 20, 50};
        int capacity = 5;
        KnapsackTabular knapsack = new KnapsackTabular(items, weights, profits, capacity);

        int maxProfit = knapsack.maxProfit();
        List<String> maxProfitItems = knapsack.maxProfitItems();

        assertEquals(80, maxProfit);
        assertEquals(List.of("Apple", "Apple", "Melon"), maxProfitItems);
        System.out.println("Max profit: " + maxProfit + ", Max profit item set" + maxProfitItems);
    }

    @Test
    public void shouldReturn115AndTwoMellon() {
        List<String> items = List.of("Apple", "Orange", "Melon");
        int[] weights = new int[]{1, 2, 3};
        int[] profits = new int[]{15, 20, 50};
        int capacity = 7;
        KnapsackTabular knapsack = new KnapsackTabular(items, weights, profits, capacity);

        int maxProfit = knapsack.maxProfit();
        List<String> maxProfitItems = knapsack.maxProfitItems();

        assertEquals(115, maxProfit);
        assertEquals(List.of("Apple", "Melon", "Melon"), maxProfitItems);
        System.out.println("Max profit: " + maxProfit + ", Max profit item set" + maxProfitItems);
    }

    @Test
    public void shouldReturn140() {
        List<String> items = List.of("A", "B", "C", "D");
        int[] weights = new int[]{1, 3, 4, 5};
        int[] profits = new int[]{15, 50, 60, 90};
        int capacity  = 8;
        KnapsackTabular knapsack = new KnapsackTabular(items, weights, profits, capacity);

        int maxProfit = knapsack.maxProfit();
        List<String> maxProfitItems = knapsack.maxProfitItems();

        assertEquals(140, maxProfit);
        assertEquals(List.of("B", "D"), maxProfitItems);
        System.out.println("Max profit: " + maxProfit + ", Max profit item set" + maxProfitItems);
    }

}