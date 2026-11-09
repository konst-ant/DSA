package faang.dp1d;

/**
 * LC 70: Climbing Stairs.
 * Count the distinct ways to climb n stairs taking 1 or 2 steps at a time.
 * Precondition: n must be positive (1 &lt;= n &lt;= 45 per the LeetCode constraints).
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be positive");
        }
        if (n <= 2) {
            return n;
        }
        int prev2 = 1;
        int prev1 = 2;
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        System.out.println(solution.climbStairs(1));
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(5));
        System.out.println(solution.climbStairs(10));
    }
}
