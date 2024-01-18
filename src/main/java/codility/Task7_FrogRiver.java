package codility;


import java.util.HashSet;

/**
 *
 * A small frog wants to get to the other side of the river.
 * The frog is initially located on one bank of the river (Position 0) and wants to get to the opposite bank (Position X+1).
 * Leaves start falling onto the surface of the river. The frog can cross only when leaves appear at every position across the river from 1 to X.
 * The speed of the current in the river is negligibly small, i.e. the leaves don't change their positions once fallen on the river.
 *
 * Write a method which returns the minimum time in seconds since the leaves start falling at which the frog can cross the river.
 * The method is given number of positions X, and non-empty array of integers A of size N, in which A[P] is a position at which a leave falls at second P since start.
 * Return -1 if the frog can not cross the river with given inputs.
 *
 * public int solution(int X, int[] A)
 *
 * For example, given X = 5 and A[] = {1, 3, 1, 4, 2, 3, 5, 4}
 * the method should return 6 as this is the earliest time at which leaves appear at every position across the river
 *
 */

public class Task7_FrogRiver {

    public int solution(int x, int[] A) {
        // all the leaves - in HashSet
        HashSet<Integer> leaves = new HashSet<>();
        for (int i=1; i<=x; i++) {
            leaves.add(i);
        }

        // Walk through time moments removing leaves from the set.
        // The moment when the set get empty is the searched time
        for (int i = 0; i < A.length; i++) {
            leaves.remove(A[i]);
            if (leaves.isEmpty()) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Task7_FrogRiver tapeEquilibrium = new Task7_FrogRiver();
        System.out.println(tapeEquilibrium.solution(5, new int[] {1,3,1,4,2,3,5,4}));
    }
}
