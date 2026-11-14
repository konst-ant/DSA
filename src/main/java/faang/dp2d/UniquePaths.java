package faang.dp2d;

/**
 * LC 62: Unique Paths.
 * Count the number of distinct paths from the top-left to the bottom-right of an m x n grid,
 * moving only down or right.
 * Precondition: m and n must both be positive.
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            throw new IllegalArgumentException("m and n must be positive");
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[col] += dp[col - 1];
            }
        }
        return dp[n - 1];
    }

    public int uniquePaths2(int m, int n) {
        if (m <= 0 || n <= 0) {
            throw new IllegalArgumentException("m and n must be positive");
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        System.out.println(solution.uniquePaths(3, 7));
        System.out.println(solution.uniquePaths(3, 2));
        System.out.println(solution.uniquePaths(1, 1));
    }
}
