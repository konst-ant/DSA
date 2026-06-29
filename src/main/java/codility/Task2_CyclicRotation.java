package codility;


import java.util.Arrays;

public class Task2_CyclicRotation {

    public int[] solution(int[] A, int K) {
        // copy to be rotated elements from tail of original array - into helper array
        int[] helper = new int[K];
        System.arraycopy(A, A.length - K, helper, 0, K);

        // move not rotated elements within the original array - to the end of array
        System.arraycopy(A, 0, A, K, A.length - K);

        // copy helper to the beginning of original array - into the released positions
        System.arraycopy(helper, 0, A, 0, K);

        return A;

    }

    public static void main(String[] args) {
        Task2_CyclicRotation cyclicRotation = new Task2_CyclicRotation();
//        System.out.println(cyclicRotation.solution(9));

        System.out.println(Arrays.toString(cyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 3)));
        System.out.println(Arrays.toString(cyclicRotation.solution(new int[]{1, 2, 3, 4}, 1)));
        System.out.println(Arrays.toString(cyclicRotation.solution(new int[]{1, 2, 3, 4}, 3)));
        System.out.println(Arrays.toString(cyclicRotation.solution(new int[]{1, 2, 3, 4}, 4)));
    }
}
