package pastInterviews;


/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 * <p>
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * <p>
 * Constraints:
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 */
public class ColorsInPlaceSort {

    /**
     * basically the insert sort algorithm, as described at Tamassia
     * @param a
     */
    private static void sortColors(int a[]) {
        if (a == null || a.length == 0)
            return;
        int n = a.length;
        int start = 0;
        int end = n - 1;
        int mid = 0;
        int temp = 0;
        while (mid <= end) {
            if (a[mid] == 0) {
                temp = a[start];
                a[start] = a[mid];
                a[mid] = temp;
                start++;
                mid++;
            } else if (a[mid] == 2) {
                temp = a[mid];
                a[mid] = a[end];
                a[end] = temp;
                end--;
            } else {
                mid++;
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    public static void main(String[] args) {
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

}
