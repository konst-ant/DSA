package codility;


import java.util.Arrays;

public class Task18_Triangle {

    public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        Arrays.sort(A);

        for (int i = 0; i < A.length - 2; i++) {
            /**
             * if a, b, c - segments of triangle - and a < b < c, then guaranteed:
             *  1. b + c > a (because each b,c > a)
             *  2. a + c > b (because c > b)
             *
             *  Means for it to be a triangle needed to hold only this:
             *  a + b > c
              */

            if (A[i] + A[i + 1] > A[i + 2]) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        Task18_Triangle triangle = new Task18_Triangle();
//        System.out.println(triangle.solution(new int[] {10,2,5,1,8,20}));
        System.out.println(triangle.solution(new int[] {10,50,5,1}));
    }
}
