package misc;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 */
public class KMostFrequentElements {
    public static void main(String[] args) {
        KMostFrequentElements frequestElements = new KMostFrequentElements();
        int k = 5;
        int[] elements = frequestElements.get(new int[]{1, 2, 1, 2, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 4, 12, 12, 15}, k);

        for (int element : elements) {
            System.out.print(element + " ");
        }
    }

    private int[] get(int[] arr, int k) {
        Map<Integer, Integer> frequency = new HashMap<>(arr.length);
        for (int i : arr) {
            frequency.put(i, frequency.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparing(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry: frequency.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] result = new int[k];
        int i=result.length - 1;
        for (Map.Entry<Integer, Integer> entry : queue) {
            result[i--] = entry.getKey();
        }

        return result;
    }
}
