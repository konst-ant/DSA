package leetcode2;

/**
 * Mountain array is integer array of size >= 3 in which there exists element with index P so as:
 * a[0] < a[1] < ... < a[P-1] > a[P] > a[P+1] > ... a[length-2] > a[length-1]
 * <p>
 * Write a method that given mountain array, and integer k, efficiently returns the smallest index i,
 * for which a[i] == k if such element exist or -1 otherwise
 * <p>
 * public int smallestIndex(int[] mArray, int k)
 */
public class FindInMountainArray {

    /**
     * to get us smallest index:
     * - search - descending-wise - on the left from peak, if not found
     * - search - ascending-wise - on the right from peak
     */
    public int smallestIndex(int[] arr, int target) {

        int p = peak(arr);

        if (p == -1) {
            return p;
        }

        int l = 0;
        int r = p;
        while (l <= r) {
//            System.out.println("First cycle");
            if (arr[l] == target) {
                return l;
            }

            int m = (l + r) / 2;
            if (arr[m] < target) {
                l = m + 1;
            } else if (arr[m] > target) {
                r = m - 1;
            } else {
                // as the sequence of elements is strictly increasing / decreasing (no adjacent equal values)
                // arr[m] == target means we found result
                return m;
            }
        }

        l = p;
        r = arr.length - 1;
        while (l <= r) {
//            System.out.println("Second cycle");
            if (arr[l] == target) {
                return l;
            }

            int m = (l + r) / 2;
            if (arr[m] < target) {
                r = m - 1;
            } else if (arr[m] > target) {
                l = m + 1;
            } else {
                return m;
            }
        }

        return -1;
    }

    /**
     * @param arr
     * @return index of peak in array, -1 if it's not a peak array
     */
    private int peak(int[] arr) {

        // to have a peak array must have at least 3 elements
        if (arr.length < 3) {
            return -1;
        }

        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            /**
             * Note: median (m) can never become pointing to array boundary (0 or length - 1), because:
             * - the size of array is > 3
             * - and if we have a proper mountain array we will identify the peak earlier than
             *   we will be calculating mid between boundary, and the adjacent element e.g. between 0 and 1
             *
             * Meaning that, if m hits the boundary - this is a sign it's not a mountain array
             */
            int m = (l + r) / 2;

            if (m == 0 || m == arr.length - 1) {
                return -1;
            }

            if (arr[m - 1] > arr[m]) {
                // peak is at left hand of m -> move right boundary
                r = m - 1;
            } else if (arr[m + 1] > arr[m]) {
                // peak is at right hand of m -> move left boundary
                l = m + 1;
            } else {
                // peak found
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindInMountainArray findInMountainArray = new FindInMountainArray();

        /**
         * test peak()
         */
        System.out.println(findInMountainArray.peak(new int[]{0, 5, 3, 1}));
        // two-peak array - can't be distinguished with half division algo though - it will show non-existing
        // peak or occasionally pick-up some of the peaks
//        System.out.println(findInMountainArray.peak(new int[]{0, 5, 3, 1, 6, 4, 3}));
//        System.out.println(findInMountainArray.peak(new int[]{0, 5, 3, 1, 6, 4}));

        /**
         * test smallextIndex()
         */
        System.out.println(findInMountainArray.smallestIndex(new int[]{0, 5, 3, 1}, 3));
        System.out.println(findInMountainArray.smallestIndex(new int[]{0, 5, 3, 1}, 1));
        System.out.println(findInMountainArray.smallestIndex(new int[]{0, 5, 3, 1}, 5));
        System.out.println(findInMountainArray.smallestIndex(new int[]{0, 5, 3, 1}, 0));

    }
}
