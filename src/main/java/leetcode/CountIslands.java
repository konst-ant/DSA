package leetcode;

import javax.crypto.spec.PSource;

/**
 *
 * Given a 2D grid map of '1's (island) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacet lands horizontally or vertically.
 * All for edges of the grid are surrounded by water.
 *
 * Example:
 *
 * Input
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 * Input
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */

public class CountIslands {

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        CountIslands countIslands = new CountIslands();
        System.out.println(countIslands.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    callBFS(grid, i, j);
                }
            }
        }
        return count;
    }

    private void callBFS(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        callBFS(grid, i+1, j);
        callBFS(grid, i-1, j);
        callBFS(grid, i, j + 1);
        callBFS(grid, i, j - 1);
    }
}
