package faang.mathgeometry;

import java.util.Arrays;

/**
 * LC 73: Set Matrix Zeroes.
 * If an element is 0, set its entire row and column to 0, using O(1) extra space
 * by marking the first row/column.
 * Precondition: matrix must be non-null, with at least one row and one column.
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("matrix must be non-null with at least one row and column");
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        // The first row/column double as the O(1)-space marker storage for all other rows and
        // columns, but that means matrix[0][*] and matrix[*][0] get overwritten as markers
        // before we could otherwise tell whether row 0 / column 0 themselves originally
        // contained a zero. So their own zero-ness must be recorded up front, before marking.
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        for (int col = 0; col < cols; col++) {
            if (matrix[0][col] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        for (int row = 0; row < rows; row++) {
            if (matrix[row][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (firstRowHasZero) {
            Arrays.fill(matrix[0], 0);
        }
        if (firstColHasZero) {
            for (int row = 0; row < rows; row++) {
                matrix[row][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes solution = new SetMatrixZeroes();
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution.setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution.setZeroes(matrix2);
        System.out.println(Arrays.deepToString(matrix2));

        int[][] matrix3 = {{0, 0}, {0, 0}};
        solution.setZeroes(matrix3);
        System.out.println(Arrays.deepToString(matrix3));
    }
}
