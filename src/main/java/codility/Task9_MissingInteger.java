package codility;


import java.util.HashSet;

public class Task9_MissingInteger {

    public int solution(int[] A) {
        HashSet<Integer> elements = new HashSet<>();

        for (int i : A) {
            if (i >= 0) {
                elements.add(i);
            }
        }

        // If returned -1 - something wrong in our algorithm. Should never return this
        int result = -1;
        // here we walk through the sequence of ints from 1 to arrays size
        // although the ints stored in array can be very high, it doesn't matter - we will definitely encounter
        // the lowest missing int will definitely be in the range from 1 to A.length
        for (int i = 1; i <= A.length; i++) {
            if (!elements.contains(i)) {
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Task9_MissingInteger missingInteger = new Task9_MissingInteger();
        System.out.println(missingInteger.solution(new int[]{1, 3, 6, 4, 1, 2}));

    }
}
