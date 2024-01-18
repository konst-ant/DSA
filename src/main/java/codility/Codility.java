package codility;

import java.util.Arrays;

public class Codility {


    public int solution(int[] A) {

        Arrays.sort(A);

        boolean firstPositive = true;
        for (int i=0; i < A.length; i++) {
            if (firstPositive && A[i] > 1) {
                return A[i] - 1;
            } else if (A[i] > 0) {
                firstPositive = false;
                if (i < A.length - 1 && (A[i + 1] == A[i] + 1 || A[i + 1] == A[i])) {

                } else {
                    return A[i] + 1;
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        Codility codility = new Codility();
        System.out.println(codility.solution(new int[] {1, 3, 6, 4, 1, 2}));
    }
}
