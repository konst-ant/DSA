package faang.bitmanipulation;

/**
 * LC 268: Missing Number.
 * Given n distinct numbers in range [0, n], find the one number missing from the range.
 * Precondition: nums must be non-null.
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("nums must be non-null");
        }
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= i ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();
        System.out.println(solution.missingNumber(new int[]{3, 0, 1}));
        System.out.println(solution.missingNumber(new int[]{0, 1}));
        System.out.println(solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
