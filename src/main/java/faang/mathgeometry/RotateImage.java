package faang.mathgeometry;

import java.util.Arrays;

/**
 * LC 48: Rotate Image.
 * Rotate an n x n matrix 90 degrees clockwise in place.
 * Precondition: matrix must be non-null, non-empty, and square (same number of rows and columns).
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("matrix must be non-null and non-empty");
        }
        int n = matrix.length;
        for (int[] row : matrix) {
            if (row.length != n) {
                throw new IllegalArgumentException("matrix must be square");
            }
        }
        // Transposing (swap across the main diagonal) followed by reversing each row is
        // equivalent to a 90-degree clockwise rotation, and both steps work purely by
        // swapping elements within the same matrix, so no second matrix is needed: O(1)
        // extra space instead of the O(n^2) a copy-into-a-new-matrix approach would use.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage solution = new RotateImage();
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

        int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        solution.rotate(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }
}
