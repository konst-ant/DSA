package leetcode2;

public class MaximalRectangle {

    public int[][] matrix;

    /**
     * these are in terms of x and y coordinates of visible matrix (as normal in Math)
     */
    public int rectangleLeft;
    public int rectangleRight;
    public int rectangleTop;        // not inclusively
    public int rectangleBottom;     // not inclusively

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        MaximalRectangle maximalRectangle = new MaximalRectangle(matrix);
        System.out.println("Biggest rectangle size: " + maximalRectangle.maximalRectangle());
        System.out.println(
                String.format("Biggest rectangle coordinates: {%d, %d}, {%d, %d}",
                        maximalRectangle.rectangleLeft,
                        maximalRectangle.rectangleTop,
                        maximalRectangle.rectangleRight - 1,
                        maximalRectangle.rectangleBottom - 1));

    }

    public MaximalRectangle(int[][] matrix) {
        this.matrix = matrix;
    }

    public int maximalRectangle() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    recursive(j, i, j, j + 1, i, i + 1);
                }
            }
        }
        return rectangleSize();
    }

    /**
     * check if the cell with coordinates is wihtin matrix
     */
    private boolean isCell(int x, int y) {
        return (y >= 0 && y < matrix.length && x >= 0 && x < matrix[y].length);
    }


    private void recursive(int x, int y, int left, int right, int top, int bottom) {
        // register rectangle
        if (rectangleSize() < rectangleSize(left, right, top, bottom)) {
            rectangleLeft = left;
            rectangleRight = right;
            rectangleTop  = top;
            rectangleBottom = bottom;
        }

        /**
         * traverse left-right and top-down trying to find next filled line on each direction
         *
         * Note: there is no point to look all directions around next point (x, y), because otherwise
         * we will be returning back and cycling infinitely
         */
        if (isCell(x, y + 1) && hasHorizontalLine(y + 1, left, right)) {
            recursive(x, y + 1, left, right, top, bottom + 1);
        }
        else if (isCell(x + 1, y) && hasVerticalLine(x + 1, top, bottom)) {
            recursive(x + 1, y, left, right + 1, top, bottom);
        }
    }

    private boolean hasHorizontalLine(int y, int left, int right) {
        for (int i = left; i < right; i++) {
            if (matrix[y][i] == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean hasVerticalLine(int x, int top, int bottom) {
        for (int i = top; i < bottom; i++) {
            if (matrix[i][x] == 0) {
                return false;
            }
        }
        return true;
    }

    public int rectangleSize() {
        return rectangleSize(rectangleLeft, rectangleRight, rectangleTop, rectangleBottom);
    }

    public int rectangleSize(int left, int right, int top, int bottom) {
        return (right - left) * (bottom - top);
    }
}
