package codility;


public class Task2_CyclicRotation {

    public int[] solution(int[] A, int K) {
        // copy to be rotated elements into helper array
        int[] helper = new int[K];
        System.arraycopy(A, 0, helper, 0, K);

        // copy tail to the start of original array
        System.arraycopy(A, K, A, 0, A.length - K);

        // copy helper to the tail - into the release positions
        System.arraycopy(helper, 0, A, A.length - K, K);

        return A;

    }

    public static void main(String[] args) {
        Task2_CyclicRotation cyclicRotation = new Task2_CyclicRotation();
//        System.out.println(cyclicRotation.solution(9));

        for (int i : cyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 3)) {
            System.out.println(i + " ");
        }

    }
}
