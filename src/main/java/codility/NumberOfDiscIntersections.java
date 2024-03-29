package codility;

public class NumberOfDiscIntersections {

    public int solution(int[] A) {
        int[] starts = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int radius = A[i];
            int startPos = i - radius;
            if (startPos < 0) {
                startPos = 0;
            }
            starts[startPos]++;
        }

        int total = 0;
        for (int i = 0; i < starts.length; i++) {
            total += starts[i];
            starts[i] = total;
        }

        int totalIntersections = 0;
        for (int i = 0; i < A.length; i++) {
            int radius = A[i];
            int endPos = i + radius;
            if (endPos > A.length - 1) {
                endPos = A.length -1;
            }
            int intersections = starts[endPos] - (i + 1);
            totalIntersections += intersections;
            if (totalIntersections > 1000000000) {
                return -1;
            }
        }

        return totalIntersections;

    }

    public static void main(String[] args) {
        NumberOfDiscIntersections nodi = new NumberOfDiscIntersections();
        System.out.println(nodi.solution(new int[] {1, 5, 2, 1, 4, 0}));
    }
}

