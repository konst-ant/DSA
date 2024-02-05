package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a set of positive integers.
 * Write a method to determine if it is feasible to divide the input set into two subsets equal on the sum
 */
public class EqualSubsetsBad {
    public static void main(String[] args) {
        EqualSubsetsBad equalSubsetsBad = new EqualSubsetsBad();
//        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6};
        Integer[] arr = new Integer[]{1, 1, 3, 4, 7};
        List<Integer> subset= new ArrayList<>();
        int fullSum = equalSubsetsBad.sum(List.of(arr));
        System.out.println(equalSubsetsBad.canDivide(arr, subset, arr.length - 1, fullSum) ? "Yes" : "No");
    }

    private boolean canDivide(Integer[] arr, List<Integer> subset, int index, int fullSum) {
        if (index >= 0) {
            // pass two paths: with current element excluded and current element included
            if (canDivide(arr, subset, index - 1, fullSum)) return true;

            subset.add(arr[index]);
            if (canDivide(arr, subset, index - 1, fullSum)) return true;
            subset.remove(Integer.valueOf(arr[index]));
        } else {
            if (2 * sum(subset) == fullSum) {
                print(subset);
                return true;
            }
        }
        return false;
    }

    private int sum(Iterable<Integer> collection) {
        int sum = 0;
        for (int i : collection) {
            sum += i;
        }
        return sum;
    }

    private void print(Iterable<Integer> collection) {
        for (int i : collection) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
