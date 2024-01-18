package codility;


import java.util.HashSet;

public class Task5_PermMissingElem {

    public int solution(int[] A) {
        HashSet<Integer> numbers = new HashSet<>();

        // fill in numbers up to the biggest possible in array A
        for (int i = 1; i <= A.length; i++) {
            numbers.add(i);
        }

        for (int i : A) {
            numbers.remove(i);
        }

        return numbers.iterator().next();
    }

    public static void main(String[] args) {
        Task5_PermMissingElem permMissingElem = new Task5_PermMissingElem();
        System.out.println(permMissingElem.solution(new int[] {2,3,1,5}));

    }
}
