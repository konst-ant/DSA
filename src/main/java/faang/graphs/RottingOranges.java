package faang.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC 994: Rotting Oranges.
 * Returns the minimum number of minutes until no cell has a fresh orange,
 * using multi-source BFS from all initially rotten oranges.
 * Precondition: grid must not be null; an empty grid is a valid corner case and yields 0 minutes.
 */
public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        if (grid == null) {
            throw new IllegalArgumentException("grid must not be null");
        }
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        int freshCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        int minutes = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] dir : dirs) {
                    int nr = cell[0] + dir[0];
                    int nc = cell[1] + dir[1];
                    if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshCount--;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            minutes++;
        }
        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        RottingOranges solver = new RottingOranges();
        System.out.println(solver.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(solver.orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));

        // Edge case: fresh oranges exist but no rotten source can ever reach them.
        System.out.println(solver.orangesRotting(new int[][]{{0, 1}, {0, 1}}));
    }
}
