package faang.binarysearch;

/**
 * LeetCode 875: Koko Eating Bananas.
 * Find the minimum integer eating speed so Koko can eat all banana piles within h hours.
 * Precondition: piles must be non-null and non-empty, and h must be positive.
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0) {
            throw new IllegalArgumentException("piles must not be null or empty");
        }
        if (h <= 0) {
            throw new IllegalArgumentException("h must be positive");
        }
        int lo = 1, hi = 0;
        for (int pile : piles) {
            hi = Math.max(hi, pile);
        }
        // Binary search on the answer space (possible eating speeds), not on the piles themselves:
        // hoursNeeded(speed) is monotonically non-increasing in speed, so we can binary search for
        // the smallest speed that still satisfies the hour budget. This gives O(n log(max(piles)))
        // instead of a linear scan over every candidate speed.
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (hoursNeeded(piles, mid) <= h) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private long hoursNeeded(int[] piles, int speed) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
        }
        return hours;
    }

    public static void main(String[] args) {
        KokoEatingBananas solution = new KokoEatingBananas();
        System.out.println(solution.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
        System.out.println(solution.minEatingSpeed(new int[]{1}, 1)); // single pile edge case
    }
}
