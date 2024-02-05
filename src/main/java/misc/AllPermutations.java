package misc;


/**
 * Given an array of integers, write a method that would print out all permutations of it's elements
 */
public class AllPermutations {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};

        AllPermutations allPermutations = new AllPermutations();
        allPermutations.permutations(arr, arr.length - 1);
    }


    public void permutations(int[] arr, int index) {

        if (index == 0) {
            print(arr);
        }

        for (int i = index ; i >= 0; i--) {
            swap(arr, index, i);
            permutations(arr, index-1 );
            swap(arr, index, i);
        }
    }

    private void swap(int[] arr, int index, int i) {
        int temp = arr[index];
        arr[index] = arr[i];
        arr[i] = temp;
    }

    private void print(int[] arr) {
        System.out.println();
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
