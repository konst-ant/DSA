package faang.graphs;

/**
 * LC 200: Number of Islands.
 * Counts the number of islands (connected groups of '1's) in a 2D grid using DFS.
 * Precondition: grid must not be null; an empty grid is a valid corner case and yields 0 islands.
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null) {
            throw new IllegalArgumentException("grid must not be null");
        }
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    sink(grid, r, c);
                }
            }
        }
        return count;
    }

    private void sink(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '0';
        sink(grid, r + 1, c);
        sink(grid, r - 1, c);
        sink(grid, r, c + 1);
        sink(grid, r, c - 1);
    }

    public static void main(String[] args) {
        NumberOfIslands solver = new NumberOfIslands();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(solver.numIslands(grid));

        // Edge case: empty grid has no islands.
        System.out.println(solver.numIslands(new char[0][0]));
    }
}
