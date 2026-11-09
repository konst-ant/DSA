package faang.greedy;

/**
 * LC 45: Jump Game II.
 * Find the minimum number of jumps needed to reach the last index of the array.
 * Precondition: nums must be non-null and non-empty.
 */
public class JumpGameII {

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums must be non-null and non-empty");
        }
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGameII solution = new JumpGameII();
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution.jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(solution.jump(new int[]{1, 1, 1, 1}));
    }
}
