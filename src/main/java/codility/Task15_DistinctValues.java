package codility;


import java.util.HashSet;

/**
 * Understood differently the task definition - meaning return those elements in array which are distinct throughout
 * the array, means appearing only once.
 * The other definition (given in video) is like distinct in select - e.g. count and return the number of elements
 * that will be there if we remove all duplications. Solution is even more trivial - just walk through putting
 * them all into hash and return size of the hash
 * */
public class Task15_DistinctValues {

    public int solution(int[] A) throws Exception {
        HashSet<Integer> seenValues = new HashSet<>();
        HashSet<Integer> distinctValues = new HashSet<>();


        for (int a : A) {
            if (!seenValues.contains(a)) {
                if (distinctValues.contains(a)) {
                    seenValues.add(a);
                    distinctValues.remove(a);
                } else {
                    distinctValues.add(a);
                }
            }
        }
        return distinctValues.size();
    }

    public static void main(String[] args) throws Exception {
        Task15_DistinctValues distinctValues = new Task15_DistinctValues();
//        System.out.println(distinctValues.solution(new int[] {2,1,1,2,3,1}));
        System.out.println(distinctValues.solution(new int[] {2,1,1,2,3,1,3}));
    }
}
