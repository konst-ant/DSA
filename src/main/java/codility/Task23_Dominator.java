package codility;


import java.util.HashMap;

public class Task23_Dominator {


    public int solution(int[] A) {
        HashMap<Integer, Integer> elements = new HashMap<>();

        int dominatorCount = (int)(A.length/2) + 1;

        for (int i = 0; i < A.length; i++) {
            elements.merge(A[i], 1, (a, b) -> {return a+b;});
            if (elements.get(A[i]) >= dominatorCount) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        Task23_Dominator dominator = new Task23_Dominator();
        System.out.println(dominator.solution(new int[] {3,4,3,2,3,-1,3,3}));
    }
}
