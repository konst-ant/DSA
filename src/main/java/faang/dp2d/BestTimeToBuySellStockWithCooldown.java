package faang.dp2d;

/**
 * LC 309: Best Time to Buy and Sell Stock with Cooldown.
 * Maximize profit from stock trades where after selling you must cooldown one day before buying again.
 * Precondition: prices must be non-null.
 */
public class BestTimeToBuySellStockWithCooldown {

    public int maxProfit(int[] prices) {
        if (prices == null) {
            throw new IllegalArgumentException("prices must be non-null");
        }
        if (prices.length == 0) {
            return 0;
        }
        int hold = -prices[0];
        int sold = 0;
        int rest = 0;
        for (int i = 1; i < prices.length; i++) {
            int prevSold = sold;
            sold = hold + prices[i];
            hold = Math.max(hold, rest - prices[i]);
            rest = Math.max(rest, prevSold);
        }
        return Math.max(sold, rest);
    }

    public static void main(String[] args) {
        BestTimeToBuySellStockWithCooldown solution = new BestTimeToBuySellStockWithCooldown();
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(solution.maxProfit(new int[]{1}));
        System.out.println(solution.maxProfit(new int[]{1, 2, 4}));
    }
}
