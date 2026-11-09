package faang.graphs;

/**
 * LC 695: Max Area of Island.
 * Returns the maximum area of an island (connected group of 1's) in a grid using DFS.
 * Precondition: grid must not be null; an empty grid is a valid corner case and yields area 0.
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            throw new IllegalArgumentException("grid must not be null");
        }
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int max = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    max = Math.max(max, area(grid, r, c));
                }
            }
        }
        return max;
    }

    private int area(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 0;
        return 1 + area(grid, r + 1, c) + area(grid, r - 1, c) + area(grid, r, c + 1) + area(grid, r, c - 1);
    }

    public static void main(String[] args) {
        MaxAreaOfIsland solver = new MaxAreaOfIsland();
        int[][] grid = {
                {0, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(solver.maxAreaOfIsland(grid));

        // Edge case: empty grid has no islands.
        System.out.println(solver.maxAreaOfIsland(new int[0][0]));
    }
}
