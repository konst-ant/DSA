package faang.dp1d;

/**
 * LC 213: House Robber II.
 * Houses are arranged in a circle, so find the maximum money robbable without robbing two adjacent houses.
 * Precondition: nums must be non-null and non-empty.
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums must be non-null and non-empty");
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robLinear(nums, 0, nums.length - 2), robLinear(nums, 1, nums.length - 1));
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;
        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        HouseRobberII solution = new HouseRobberII();
        System.out.println(solution.rob(new int[]{5}));
        System.out.println(solution.rob(new int[]{2, 3, 2}));
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println(solution.rob(new int[]{1, 2, 3}));

        System.out.println("Check with same circle but from different perspectives e.g. break points (0, n-1), (1, 0) etc");
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(solution.rob(new int[]{7, 9, 3, 1, 2}));
        System.out.println(solution.rob(new int[]{9, 3, 1, 2, 7}));
        System.out.println(solution.rob(new int[]{3, 1, 2, 7, 9}));
        System.out.println(solution.rob(new int[]{1, 2, 7, 9, 3}));

    }
}
