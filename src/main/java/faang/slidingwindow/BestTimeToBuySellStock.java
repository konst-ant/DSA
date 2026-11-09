package faang.slidingwindow;

/**
 * LeetCode 121: Best Time to Buy and Sell Stock.
 * Find the maximum profit from a single buy and a single sell of one share.
 * Throws IllegalArgumentException if prices is null.
 */
public class BestTimeToBuySellStock {

    public int maxProfit(int[] prices) {
        if (prices == null) {
            throw new IllegalArgumentException("prices must not be null");
        }
        if (prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuySellStock solution = new BestTimeToBuySellStock();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(solution.maxProfit(new int[]{2, 4, 1}));
        System.out.println(solution.maxProfit(new int[]{5})); // single element: no sale possible, profit 0
        System.out.println(solution.maxProfit(new int[]{})); // empty array: no sale possible, profit 0
    }
}
