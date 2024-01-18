package codility;


import java.util.Stack;

/**
 * N fishes start flowing along the river from their initial positions
 * You are given two non-empty arrays A[ ] and B[ ] of size N.
 *
 * Array A[ ] stores sizes of the fish. All values are unique
 * Array B[ ] stores direction of fish flow: 0 - if the fish flows upstream, 1 - if the fish flows downstream
 *
 * Values in arrays A and B are ordered by position of the fish upstream to downstream.
 *
 * If two fishes move in opposite direction and there is no fish between them they will meet. Then the bigger fish will
 * eat the smaller and continue to flow in it's direction
 *
 * Write a method
 *
 * public int solution(int[] A, int[] B)
 *
 * that will return the number of fish in the river that will ultimately stay in the river
 *
 */
public class Task20_Fish {

    public int solution(int A[], int B[]) {
        Stack<Integer> fishFlowingDown = new Stack<>();

        int fishStay = 0;
        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) {
                fishFlowingDown.push(A[i]);
            } else {
                boolean eaten = false;
                while (!eaten && !fishFlowingDown.isEmpty()) {
                    if (A[i] > fishFlowingDown.peek()) {
                        fishFlowingDown.pop();
                    } else {
                        eaten = true;
                    }
                }
                if (!eaten) {
                    fishStay++;
                }
            }
        }
        fishStay += fishFlowingDown.size();
        return fishStay;
    }

    public static void main(String[] args) throws Exception {
        Task20_Fish triangle = new Task20_Fish();
//        System.out.println(triangle.solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));
        System.out.println(triangle.solution(new int[]{4, 3, 2, 1, 5}, new int[]{1, 0, 1, 1, 1}));
    }
}
