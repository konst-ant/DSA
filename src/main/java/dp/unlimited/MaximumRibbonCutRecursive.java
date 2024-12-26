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
        memo = new Integer[length + 1][pieces.length];
        for (int i = 0; i < length + 1; i++) {
            for (int j = 0; j < pieces.length; j++) {
                memo[i][j] = null;
            }
        }
        return count(length, pieces, 0);
    }

    private int count(int length, int[] pieces, int piecesIndex) {
        int result;

        // recursion base
        if (piecesIndex == pieces.length || length == 0) {
            return 0;
        }

        // memoized
        if (memo[length][piecesIndex] != null) {
            return memo[length][piecesIndex];
        }

        // if with this recursion stack ribbon can't be cut without left over, return -1 being propagated up stack.
        // without it the algo will be counting for left over cases as legitimate
        if (pieces[piecesIndex] > length) {
            memo[length][piecesIndex] = Integer.MIN_VALUE;
            return memo[length][piecesIndex];
        }

        // 2-nd case - include piece if it fits into remaining ribbon
        int count2 = 0;
        if (pieces[piecesIndex] <= length) {
            count2 = count(length - pieces[piecesIndex], pieces, piecesIndex) + 1;
        }

        // 1-st case - exclude piece
        int count1 = count(length, pieces, piecesIndex + 1);

        // memoize
        result = Math.max(count1, count2);
        memo[length][piecesIndex] = result;

        System.out.println(String.format("count() recursive all: length=%d piecesIndex=%d return=%d", length, piecesIndex, result));
        return result;
    }
}
