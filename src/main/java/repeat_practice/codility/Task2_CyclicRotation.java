package repeat_practice.codility;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Task2_CyclicRotation {

    public int[] solution(int[] arr, int k) {
        if (arr.length == 0 || arr.length == k) {
            return arr;
        }

        // copy to be rotated elements from tail of original array - into helper array
        int[] helper = new int[k];
        System.arraycopy(arr, arr.length - k, helper, 0, k);

        // move not rotated elements within the original array - to the end of array
        System.arraycopy(arr, 0, arr, k, arr.length - k);

        // copy helper to the beginning of original array - into the released positions
        System.arraycopy(helper, 0, arr, 0, k);

        return arr;

    }

    public Integer[] solution2(Integer[] arr, int k) {
        if (arr.length == 0 || arr.length == k) {
            return arr;
        }

        List<Integer> arrList = new LinkedList<Integer>(List.of(arr));
        for (int i = 0; i < k; i++) {
            Integer next = arrList.remove(arrList.size() - 1);
            arrList.add(0, next);
        }
        return arrList.toArray(new Integer[] {0});
    }

    // solution forehead straight
    public int[] solution3(int[] a, int k) {
        if (a.length == 0 || a.length == k) {
            return a;
        }
        for (int i = 0; i < k; i++) {
            int lastValue = a[a.length - 1];
            for (int j = a.length - 2; j >= 0; j--) {
                a[j + 1] = a[j];
            }
            a[0] = lastValue;
        }
        return a;
    }

    public static void main(String[] args) {
        Task2_CyclicRotation cyclicRotation = new Task2_CyclicRotation();
//        System.out.println(cyclicRotation.solution(9));

        System.out.println(Arrays.toString(cyclicRotation.solution3(new int[]{3, 8, 9, 7, 6}, 3)));
        System.out.println(Arrays.toString(cyclicRotation.solution3(new int[]{1, 2, 3, 4}, 1)));
        System.out.println(Arrays.toString(cyclicRotation.solution3(new int[]{1, 2, 3, 4}, 3)));
        System.out.println(Arrays.toString(cyclicRotation.solution3(new int[]{1, 2, 3, 4}, 4)));
        System.out.println(Arrays.toString(cyclicRotation.solution(new int[]{}, 4)));
        System.out.println();

        System.out.println(Arrays.toString(cyclicRotation.solution2(new Integer[]{3, 8, 9, 7, 6}, 3)));
        System.out.println(Arrays.toString(cyclicRotation.solution2(new Integer[]{1, 2, 3, 4}, 1)));
        System.out.println(Arrays.toString(cyclicRotation.solution2(new Integer[]{1, 2, 3, 4}, 3)));
        System.out.println(Arrays.toString(cyclicRotation.solution2(new Integer[]{1, 2, 3, 4}, 4)));
        System.out.println(Arrays.toString(cyclicRotation.solution2(new Integer[]{}, 4)));
    }
}
