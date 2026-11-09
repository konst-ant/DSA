package faang.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC 90: Subsets II.
 * Returns all possible unique subsets of a collection that may contain duplicates.
 * Precondition: nums must be non-null.
 */
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("nums must not be null");
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsII solver = new SubsetsII();
        System.out.println(solver.subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(solver.subsetsWithDup(new int[]{0}));

        // Edge case: every element duplicated should still only produce distinct subsets.
        System.out.println(solver.subsetsWithDup(new int[]{2, 2, 2}));
    }
}
