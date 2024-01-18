package codility;

import java.util.Arrays;

/**
 * Array A consist of N positive (non-zero) integers.
 * A triplet (B, M, F) is triangular if it's possible to build a triangle from A[B], A[M], A[F], that is:
 * A[B] + A[M] > A[F]
 * A[B] + A[F] > A[M]
 * A[M] + A[F] > A[B]
 *
 * For example, given array {10, 2, 5, 1, 8, 12} there are 4 triangular triplets:
 *
 * in indexes
 * (0,2,4)
 * (0,2,5)
 * (2,4,5)
 * (0,4,5)
 *
 * in numbers
 * (10,5,8)
 * (10,5,12)
 * (5,8,12)
 * (10,8,12)
 *
 * Write a method, which will return number of triangular triplets in given array A.
 *
 * public int solution(int[] A)
 *
 *
 *
 * Use the catapilar method to move back, mid, and front to evaluate if this triple can make a triangel.
 * Work on sorted array because then we will need to evaluate only one condition:
 * a < b < c - enough to evaluate that c < a + b.
 */
public class Task42_CountTriangles {
    public int solution(int[] A) {
        Arrays.sort(A);

        // 1,2,5,8,10,12
        int triangles = 0;
        for (int back = 0; back < A.length - 2; back++) {
            int front = back + 2;
            for (int middle = back + 1;  middle < A.length - 1; middle++) {
                while (front < A.length && A[back] + A[middle] > A[front]) {
                    front++;
                }
                triangles += front - middle - 1;
            }
        }
        return triangles;
    }
    public static void main(String[] args) {
        Task42_CountTriangles countTriangles = new Task42_CountTriangles();
        System.out.println(countTriangles.solution(new int[] {10, 2, 5, 1, 8, 12}));
    }
}
