package faang.arrayshashing;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 128: Longest Consecutive Sequence.
 * Return the length of the longest run of consecutive integers in an unsorted array, in O(n) time.
 * Throws IllegalArgumentException if nums is null.
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("nums must not be null");
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;
        for (int num : numSet) {
            if (numSet.contains(num - 1)) {
                continue;
            }
            int length = 1;
            while (numSet.contains(num + length)) {
                length++;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(solution.longestConsecutive(new int[]{})); // empty array edge case
        System.out.println(solution.longestConsecutive(new int[]{5})); // single element edge case
    }
}
