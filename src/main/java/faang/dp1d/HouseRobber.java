package faang.dp1d;

/**
 * LC 198: House Robber.
 * Find the maximum money that can be robbed from houses in a row without robbing two adjacent houses.
 * Precondition: nums must be non-null.
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("nums must be non-null");
        }
        int prev2 = 0;
        int prev1 = 0;
        for (int num : nums) {
            int current = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        HouseRobber solution = new HouseRobber();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(solution.rob(new int[]{5}));
    }
}
