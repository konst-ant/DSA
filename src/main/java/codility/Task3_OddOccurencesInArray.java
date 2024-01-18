package codility;


import java.util.HashSet;

/**
 *
 * A non-empty array A consisting of N integers is given.
 * The array contains odd number of elements, and each element of the array can be paired with another element that has the same value, except for the one element that is unpaired.
 *
 * Write an efficient method, which returns the value of the unpaired element given the input array A:
 * public int solution(int[] A);
 *
 * For example for array {9, 3, 9, 3, 9, 7, 9} the solution would return 7.
 *
 */

public class Task3_OddOccurencesInArray {

    public int solution(int[] A) {
        HashSet<Integer> paired = new HashSet<>();
        for (int i : A) {
            if (paired.contains(i)) {
                paired.remove(i);
            } else {
                paired.add(i);
            }
        }
        return paired.iterator().next();
    }

    public static void main(String[] args) {
        Task3_OddOccurencesInArray oddOccurencesArray = new Task3_OddOccurencesInArray();
        System.out.println(oddOccurencesArray.solution(new int[] {9,3,9,3,9,7,9}));

    }
}
