package codility;


import java.util.Stack;

public class Task22_StoneWall {


    public int solution(int[] A) {
        Stack<Integer> heights = new Stack<>();

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            while (!heights.isEmpty() && A[i] < heights.peek()) {
                heights.pop();
                count++;
            }
            if (heights.isEmpty() || A[i] > heights.peek()) {
                heights.push(A[i]);
            }
        }
        count += heights.size();
        return count;
    }

    public int solution2(int[] A) {
        Stack<Integer> heights = new Stack<>();

        int count = 0;
        for(int i = 0; i < A.length; i++) {
            while (!heights.isEmpty() && A[i] < heights.peek()) {
                heights.pop();
            }
            if (heights.isEmpty() || A[i] > heights.peek()) {
                heights.push(A[i]);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        Task22_StoneWall triangle = new Task22_StoneWall();
        System.out.println(triangle.solution(new int[] {8,8,5,7,9,8,7,4,8}));
    }
}
