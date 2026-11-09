package faang.arrayshashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 347: Top K Frequent Elements.
 * Return the k most frequent elements in the array using bucket sort for O(n) time.
 * Throws IllegalArgumentException if nums is null/empty, k is not positive,
 * or k exceeds the number of distinct elements in nums.
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums must not be null or empty");
        }
        if (k <= 0) {
            throw new IllegalArgumentException("k must be positive");
        }
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.merge(num, 1, Integer::sum);
        }
        if (k > frequency.size()) {
            throw new IllegalArgumentException("k must not exceed the number of distinct elements");
        }

        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int freq = entry.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;
        for (int freq = buckets.length - 1; freq >= 0 && index < k; freq--) {
            if (buckets[freq] == null) {
                continue;
            }
            for (int num : buckets[freq]) {
                if (index == k) {
                    break;
                }
                result[index++] = num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1}, 1)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 2, 3}, 3))); // k equals distinct count edge case
    }
}
