package codility;

/**
 *
 * A non-empty array A of N integers is given.
 * A triplet (X, Y, Z) such as 0 <= X < Y < Z < N is called a double slice.
 * The sum of double slice is the sum of all elements between X and Y plus the sum of all elements between Y and Z, not including X, Y, Z.
 *
 * Write a method that given a non-empty array A[] returns the maximum sum of all possible slices of that array
 *
 * public int solution(int[] A)
 *
 */

public class Task25_MaxDoubleSliceSum {


    public int solution(int[] A) {
        int[] s = new int[A.length];
        int[] e = new int[A.length];

        for (int i = 1; i < A.length - 1; i++) {
            s[i] = Math.max(A[i], s[i - 1] + A[i]);
        }

        for (int i = A.length-2; i > 0; i--) {
            e[i] = Math.max(A[i], e[i + 1] + A[i]);
        }

        int max=Integer.MIN_VALUE;
        for (int i = 1; i < A.length - 1; i++) {
            max = Math.max(s[i - 1] + e[i + 1], max);
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        Task25_MaxDoubleSliceSum dominator = new Task25_MaxDoubleSliceSum();
        System.out.println(dominator.solution(new int[] {3,2,6,-1,4,5,-1,2}));
    }
}
