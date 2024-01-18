package codility;


import java.util.ArrayList;
import java.util.List;

/**
 * You are given non-empty array of Integers a[]
 * A PEAK in array is an index P such that A[P-1] < A[P] && A[P] < A[P+1]
 * <p>
 * Now we want to break up the a[] into number of blocks of equal size K, so that in each of the resulting
 * blocks there is at least 1 PEAK present. Note that PEAK can happen to be at a boundary of the block (left or right),
 * it is still considered a PEAK within a block. E.g. let's say A[P] is the right-most element of some block, and the
 * value less than this PEAK A[P+1] is the left-most of the next block.
 * <p>
 * Write a method, which given the array a[] returns the maximum number of blocks how the array can be split so that
 * each block has at least 1 PEAK:
 * <p>
 * public int maximumBlocks(int[] a)
 * <p>
 * Example:
 * for array {1,2,3,4,3,4,1,2,3,4,6,2} the method should return 3 with blocks being: {1,2,3,4} {3,4,1,2} {3,4,6,2}
 */
public class Task31_MaximumPeakBlocks {

    public int maximumBlocks(int[] a) {

        // need at least 3 elements to identify a peak
        if (a.length < 3) {
            return 0;
        }

        // discover peaks
        // example: should be - 3, 5, 10
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i - 1] < a[i] && a[i] > a[i + 1]) {
                peaks.add(i);
            }
        }

        // either a valley, or a single peak
        if (peaks.size() == 0 || peaks.size() == 1) {
            return peaks.size();
        }


        int result = 0;

        // blockSize can't be 2 - see 1,2,1,2,1,2 - the a.length will be even, but we will not be able to qualify the
        // rightmost peak here
        for (int blockSize = 3; blockSize <= a.length / 2; blockSize++) {

            // drop out if a[] can't be divided by blockSize in whole
            if (a.length % blockSize != 0) {
                continue;
            }

            int currentPeak=0;
            boolean ok = true;
            for (int blockStart = 0; blockStart < a.length; blockStart+=blockSize ) {

                boolean foundPeak = false;
                while (currentPeak < peaks.size()) {
                    int currentPeakIndex = peaks.get(currentPeak);
                    if (currentPeakIndex >= blockStart && currentPeakIndex < blockStart + blockSize) {
                        foundPeak = true;
                    } else {
                        break;
                    }
                    currentPeak++;
                }

                if (!foundPeak) {
                    ok = false;
                    break;
                }
            }

            // this block satisfied task condition
            if (ok) {
                // we know already it divides in whole
                result = a.length / blockSize;
                break;
            }
        }

        return result;
    }


    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        int[] a = {1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1};
        int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] a = {1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
        Task31_MaximumPeakBlocks maximumPeakBlocks = new Task31_MaximumPeakBlocks();
        System.out.println(maximumPeakBlocks.maximumBlocks(a));
    }
}
