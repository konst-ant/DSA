package codility;


import java.util.HashMap;

public class Task24_Equileader {


    public int solution(int[] A) {
        HashMap<Integer, Integer> elements = new HashMap<>();


        int dominator = 0;
        boolean dominatorFound = false;
        int dominatorCount = 0;
        for (int i = 0; i < A.length; i++) {
            elements.merge(A[i], 1, (a, b) -> {return a+b;});
            if (elements.get(A[i]) > A.length/2) {
                dominator = A[i];
                dominatorFound = true;
                dominatorCount = elements.get(A[i]);
            }
        }

        if (!dominatorFound) {
            return 0;
        }

        int equileaders = 0;
        int leadersInRightSide = dominatorCount;
        int leadersInLeftSide=0;
        int countLeftSide=0;
        int countRightSide=A.length;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == dominator) {
                leadersInLeftSide++;
                leadersInRightSide--;
            }
            countRightSide--;
            countLeftSide++;
            if (leadersInLeftSide > countLeftSide / 2) {
                if (leadersInRightSide > countRightSide / 2) {
                    equileaders++;
                }
            }
        }
        return equileaders;
    }

    public static void main(String[] args) throws Exception {
        Task24_Equileader dominator = new Task24_Equileader();
//        System.out.println(dominator.solution(new int[] {3,4,3,2,3,-1,3,3}));
        System.out.println(dominator.solution(new int[] {4,3,4,4,4,2}));
    }
}
