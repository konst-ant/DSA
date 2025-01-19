package dp.knapsack.unbounded;

/**
 * See inputs in {@link MinimumCoinChangeTabular}
 */
public class MinimumCoinChangeRecursive {

    public int minimumNumberOfCoins(int[] coins, int sum) {
//        return countWithDebug(coins, sum, 0, "");
        return count(coins, sum, 0);
    }

    private int count(int[] coins, int sum, int coinIndex) {

        // base of recursion

        // Note: we get here only through case 2 (include coin) and never through case 1, so safely returning 0 here
        if (sum == 0) {
            return 0;
        }
        // Note: we get here only through case 1 (exclude coin) and never through case 2, so safely returning huge MAX here (abandon chain)
        if (coinIndex == coins.length) {
            return Integer.MAX_VALUE;
        }



        // case 1: exclude coin
        int count1 = count(coins, sum, coinIndex + 1);

        // case 2: include coin
        int count2 = Integer.MAX_VALUE;
        if (coins[coinIndex] <= sum) {
            int value = count(coins, sum - coins[coinIndex], coinIndex);
            // (!) Need check here because it may be that case 2 will return Integer.MAX_VALUE -
            // This will happen with case 1 reaches last coin AND last coin is bigger than remaining sum
            //
            // Without this check will get Integer overflow and broken result
            if(value != Integer.MAX_VALUE){
                count2 = value + 1;
            }
        }

        return Math.min(count1, count2);
    }

    private int countWithDebug(int[] coins, int sum, int coinIndex, String debug) {

        // base of recursion

        // Note: we get here only through case 2 (include coin) and never through case 1, so safely returning 0 here
        if (sum == 0) {
            return 0;
        }
        // Note: we get here only through case 1 (exclude coin) and never through case 2, so safely returning huge MAX here (abandon chain)
        if (coinIndex == coins.length) {
            return Integer.MAX_VALUE;
        }


        int value;
        String theDebug;

        // case 1: exclude coin
        theDebug = debug + " case 1";
        value = countWithDebug(coins, sum, coinIndex + 1, theDebug);
        System.out.println(String.format("%s  arg=(sum=%d coinIndex=%d) return=%d", theDebug, sum, coinIndex + 1, value));
        int count1 = value;

        // case 2: include coin
        int count2 = Integer.MAX_VALUE;
        if (coins[coinIndex] <= sum) {
            theDebug = debug + " case 2";
            value = countWithDebug(coins, sum - coins[coinIndex], coinIndex, theDebug);
            System.out.println(String.format("%s arg=(sum=%d coinIndex=%d) return=%d", theDebug, sum - coins[coinIndex], coinIndex, value));
            // (!) Need check here because it may be that case 2 will return Integer.MAX_VALUE -
            // This will happen with case 1 reaches last coin AND last coin is bigger than remaining sum
            //
            // Without this check will get Integer overflow and broken result
            if(value != Integer.MAX_VALUE){
                count2 = value + 1;
            }
        }

        int result = Math.min(count1, count2);
        System.out.println(String.format("%s : RETURN=%d", debug, result));
        return result;
    }
}
