package codility;


import java.util.HashSet;

public class Task10_PermCheck {

    public int solution(int[] A) {
        HashSet<Integer> elements = new HashSet<>();

        for (int i = 1; i <= A.length; i++) {
            elements.add(i);
        }

        for (int a : A) {
            // this check if optional only to speed up on big non-permutation arrays
            if (!elements.contains(a)) {
                return 0;
            }
            elements.remove(a);
        }

        return elements.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Task10_PermCheck permCheck = new Task10_PermCheck();
//        System.out.println(permCheck.solution(new int[]{1, 3, 6, 4, 1, 2}));
//        System.out.println(permCheck.solution(new int[]{3, 6, 4, 1, 2}));
        System.out.println(permCheck.solution(new int[]{3, 5, 4, 1, 2}));

    }
}
