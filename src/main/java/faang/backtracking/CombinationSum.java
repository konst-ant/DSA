package faang.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC 39: Combination Sum.
 * Returns all unique combinations of candidates that sum to target, where
 * each candidate may be reused an unlimited number of times.
 * Precondition: candidates must be non-null and target must not be negative.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
            throw new IllegalArgumentException("candidates must not be null");
        }
        if (target < 0) {
            throw new IllegalArgumentException("target must not be negative");
        }
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remaining, int start,
                            List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining) {
                break;
            }
            current.add(candidates[i]);
            backtrack(candidates, remaining - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum solver = new CombinationSum();
        System.out.println(solver.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solver.combinationSum(new int[]{2, 3, 5}, 8));

        // Edge case: no combination of candidates can reach the target.
        System.out.println(solver.combinationSum(new int[]{5}, 3));
    }
}
