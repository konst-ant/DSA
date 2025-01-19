package dp.unlimited;

/**
 * You're given a ribbon of length n, which need to be cut into pieces of given lengths int[] pieces.
 * The goal is to get maximum possible amount of pieces out of the ribbon, assuming the ribbon is cut without left over
 * <p>
 * public int maximumAmountOfPieces(int length, int[] pieces)
 * <p>
 * Examples:
 * n= 5
 * pieces= {2,3,5}
 * Result: 2
 * Pieces will result in {2,3}.
 * <p>
 * n= 13
 * pieces= {3,5,7}
 * Result: 3
 * Pieces will result in {3,3,7}.
 */
public class MaximumRibbonCutRecursive {

    private Integer[][] memo;

    public int maximumAmountOfPieces(int length, int[] pieces) {
        memo = new Integer[pieces.length][length + 1];
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < length + 1; j++) {
                memo[i][j] = null;
            }
        }
        return count(pieces, length, 0);
    }

    private int count(int[] pieces, int length, int piecesIndex) {
        int result;

        // recursion base
        if (piecesIndex == pieces.length || length == 0) {
            return 0;
        }

        // memoized
        if (memo[piecesIndex][length] != null) {
            return memo[piecesIndex][length];
        }

        // If with this recursion stack ribbon can't be cut without left over, return Integer.MIN_VALUE being propagated up stack.
        // Then Integer.MIN_VALUE even with + 1 add-on to it the result up-the-stack will remain very big negative integer,
        // which will be ignored in favour of any other constructive call chain and effectively exclude call chain with the piece
        // not fitted the ribbon.
        //
        // Without it the algo will be counting for left over cases as legitimate
        if (pieces[piecesIndex] > length) {
            memo[piecesIndex][length] = Integer.MIN_VALUE;
            return memo[piecesIndex][length];
        }

        // 1-st case - include piece if it fits into remaining ribbon
        int count1 = 0;
        if (pieces[piecesIndex] <= length) {
            count1 = count(pieces, length - pieces[piecesIndex], piecesIndex) + 1;
        }

        // 2-nd case - exclude piece
        int count2 = count(pieces, length, piecesIndex + 1);

        // memoize
        result = Math.max(count1, count2);
        memo[piecesIndex][length] = result;

        System.out.println(String.format("count() recursive: length=%d piecesIndex=%d return=%d", length, piecesIndex, result));
        return result;
    }
}
