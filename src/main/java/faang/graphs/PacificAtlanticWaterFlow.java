package faang.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 417: Pacific Atlantic Water Flow.
 * Returns all grid cells from which water can flow to both the Pacific (top/left edges)
 * and Atlantic (bottom/right edges) oceans, using DFS from each ocean's border.
 * Precondition: heights must not be null; an empty grid is a valid corner case and yields no cells.
 */
public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null) {
            throw new IllegalArgumentException("heights must not be null");
        }
        List<List<Integer>> result = new ArrayList<>();
        if (heights.length == 0 || heights[0].length == 0) {
            return result;
        }
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int c = 0; c < cols; c++) {
            dfs(heights, pacific, 0, c);
            dfs(heights, atlantic, rows - 1, c);
        }
        for (int r = 0; r < rows; r++) {
            dfs(heights, pacific, r, 0);
            dfs(heights, atlantic, r, cols - 1);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr < 0 || nc < 0 || nr >= heights.length || nc >= heights[0].length
                    || visited[nr][nc] || heights[nr][nc] < heights[r][c]) {
                continue;
            }
            dfs(heights, visited, nr, nc);
        }
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow solver = new PacificAtlanticWaterFlow();
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        System.out.println(solver.pacificAtlantic(heights));

        // Edge case: a single cell always touches both oceans.
        System.out.println(solver.pacificAtlantic(new int[][]{{5}}));
    }
}
