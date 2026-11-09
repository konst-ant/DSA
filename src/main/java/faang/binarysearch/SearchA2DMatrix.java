package faang.binarysearch;

/**
 * LeetCode 74: Search a 2D Matrix.
 * Search a target value in an m x n matrix whose rows are sorted and whose first elements
 * increase row over row, in O(log(m*n)) time.
 * Precondition: matrix must be non-null with at least one row and one column.
 */
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("matrix must not be null or empty");
        }
        int rows = matrix.length, cols = matrix[0].length;
        int lo = 0, hi = rows * cols - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int value = matrix[mid / cols][mid % cols];
            if (value == target) {
                return true;
            } else if (value < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrix solution = new SearchA2DMatrix();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(solution.searchMatrix(matrix, 3));
        System.out.println(solution.searchMatrix(matrix, 13));
        System.out.println(solution.searchMatrix(matrix, 60));
        System.out.println(solution.searchMatrix(new int[][]{{1}}, 1)); // single-cell edge case
    }
}
