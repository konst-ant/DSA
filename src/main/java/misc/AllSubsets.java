package misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, write a method that would print out all subsets produceable of it's elements
 *
 */
public class AllSubsets {
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3};
        int[] arr = new int[]{2, 3, 6, 7};
        List<Integer> subset= new ArrayList<>();

        subsets(arr, subset, arr.length - 1);
    }

    private static void subsets(int[] arr, List<Integer> subset, int index) {
        if (index >= 0) {
            // pass two paths: with current element excluded and current element included
            subsets(arr, subset, index - 1);

            subset.add(arr[index]);
            subsets(arr, subset, index - 1);
            subset.remove(new Integer(arr[index]));
        } else {
            for (int i : subset) {
                System.out.print(i + " ");
            }
            int sum=0;
            for (int i : subset) {
                sum += i;
            }
            System.out.println(", Subset sum: " + sum);
        }
    }
}
