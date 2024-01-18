package codility;

import java.util.ArrayList;
import java.util.List;

/**
 *  You are given non-empty array of Integers a[]
 *  A PEAK in array is an index P such that A[P-1] < A[P] && A[P] < A[P+1]
 *
 *  You are going to the journey, and set flags at the peaks. But you have to follow the rule:
 *  if you take with you N flags you can set flags only on those peaks which have distance between them
 *  not less than the total number of flags you have taken.
 *
 *  Write a method, which given the array a[], returns the maximum number of flags that can be set:
 *
 *  public int maximumFlags(int[] a)
 *
 *  Example:
 *  given array {1,5,3,4,3,4,1,2,3,4,6,2} method should return 3.
 *
 *  here are the PEAKS at indices: {1, 3, 5, 10}
 *  3 flags can be set on PEAKS: 1, 5, 10 however 4 flags can not be set
 *
 */
public class Task29_MaximumFlags {

    // find max and min peaks, in terms of indexes
    // loop from SQRT(max-min) down to 1, because number of flags can never be greater the SQRT(max-min) + 1
    // e.g. if we take flag and successfully install them all - we step the distance = 3 flags times 3 step = 3^2

    public int maximumFlags(int[] a) {

        // discover peaks
        // example: should be - 3, 5, 10
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i - 1] < a[i] && a[i] > a[i + 1]) {
                peaks.add(i);
            }
        }

        // either a valley, or a single peak
        if (peaks.size() <= 1) {
            return peaks.size();
        }

        int maxFlags = (int)Math.floor(Math.sqrt(peaks.get(peaks.size() - 1) - peaks.get(0))) + 1;

        for (int takenFlags = maxFlags; takenFlags > 1; takenFlags--) {

            int previousPeak = 0;
            int peak = 1;
            int flags = takenFlags;
            flags--;    // this goes into the 1-st peak
            while (peak < peaks.size()) {
                if (peaks.get(peak) - peaks.get(previousPeak) < takenFlags) {
                    peak++;
                } else {
                    flags--;
                    previousPeak = peak;
                    peak++;
                }
            }

            if (flags == 0) {
                return takenFlags;
            }
        }

        return 0;

    }

    public static void main(String[] args) {
        Task29_MaximumFlags maximumFlags = new Task29_MaximumFlags();
//        System.out.println(maximumFlags.maximumFlags(new int[]{1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
        System.out.println(maximumFlags.maximumFlags(new int[]{1, 5, 3, 3, 4, 3, 2, 4, 3, 3, 6, 2}));
//        System.out.println(maximumFlags.maximumFlags(new int[]{1, 5, 3, 3, 3, 4, 3, 2, 3, 4, 3, 4, 3, 6, 2}));
//        System.out.println(maximumFlags.maximumFlags(new int[]{1, 5, 3, 3, 3, 4, 3, 2, 1, 4, 3, 2, 2, 1, 3, 4, 6, 2}));
    }
}
