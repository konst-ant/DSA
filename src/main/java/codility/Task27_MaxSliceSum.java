package codility;

/**
 *
 * A non-empty array A of N integers is given. A pair of indexes (P,Q) such that 0 <= P <= Q < N is called a slice of array.
 * The sum of the slice is the total of A[P] + A[P+1] + ...+ A[Q]
 *
 * Write an effective method that given an array A returns the maximum sum of any slice of A
 *
 * public int solution(int[] A)
 *
 * For example, with A = {3, 2, -6, 4, 0} the method should return 5
 *
 */

public class Task27_MaxSliceSum {
    public static void main(String[] args) {
        System.out.println(new Task27_MaxSliceSum().solution(new int[] {2,3,-6,4,0}));
    }

    public int solution(int[] A) {
        long sum = 0;
        long maxSum = 0;

        for (int a : A) {
            sum = Math.max(sum + a, a);
            maxSum = Math.max(sum, maxSum);
        }
        return (int) maxSum;
    }
}
