package faang.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 46: Permutations.
 * Returns all possible permutations of an array of distinct integers.
 * Precondition: nums must be non-null.
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("nums must not be null");
        }
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, current, used, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutations solver = new Permutations();
        System.out.println(solver.permute(new int[]{1, 2, 3}));
        System.out.println(solver.permute(new int[]{0, 1}));

        // Edge case: single-element array has exactly one permutation.
        System.out.println(solver.permute(new int[]{7}));
    }
}
