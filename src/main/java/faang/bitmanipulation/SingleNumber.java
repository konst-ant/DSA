package faang.bitmanipulation;

/**
 * LC 136: Single Number.
 * Find the element that appears only once in an array where every other element appears exactly twice.
 * Precondition: nums must be non-null and non-empty.
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums must be non-null and non-empty");
        }
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();
        System.out.println(solution.singleNumber(new int[]{2, 2, 1}));
        System.out.println(solution.singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(solution.singleNumber(new int[]{1}));
        System.out.println(solution.singleNumber(new int[]{0, 1, 0}));
    }
}
