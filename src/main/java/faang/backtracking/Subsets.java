package faang.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 78: Subsets.
 * Returns all possible subsets (the power set) of a set of distinct integers.
 * Precondition: nums must be non-null.
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("nums must not be null");
        }
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets solver = new Subsets();
        System.out.println(solver.subsets(new int[]{1, 2, 3}));
        System.out.println(solver.subsets(new int[]{0}));

        // Edge case: empty input set has exactly one subset - the empty set itself.
        System.out.println(solver.subsets(new int[]{}));
    }
}
