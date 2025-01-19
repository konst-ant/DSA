package dp.knapsack.unbounded;

/**
 * See inputs in {@link MaximumRibbonCutRecursive}
 */
public class MaximumRibbonCutTabular {


    public int maximumAmountOfPieces(int length, int[] pieces) {
        int[][] dp = new int[pieces.length][length + 1];

        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < length + 1; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for (int i = 0; i < pieces.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < pieces.length; i++) {
            for (int j = 1; j < length + 1; j++) {
                // case 1: exclude piece, only if we have at least two pieces
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                }

                // case 2: include piece
                // Second condition is being safely checked, i.e. only when j - pieces[i] >= 0
                //
                // Note also, second condition assures that the "step back" cell is the legitimate one that is was matched before
                // To understand it better, set breakpoint on return line and see dp matrix result, starting from it's 1-st line
                if (pieces[i] <= j && dp[i][j - pieces[i]] != Integer.MIN_VALUE) {
                    dp[i][j] =  Math.max(dp[i][j], dp[i][j - pieces[i]] + 1);
                }
            }
        }

        // returns 0 if cutting not possible
        return dp[pieces.length - 1][length] == Integer.MIN_VALUE ? 0 : dp[pieces.length - 1][length];
    }
}
