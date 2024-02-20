package misc;

import java.util.HashMap;
import java.util.Map;

public class FindTwoNumbers {

    public static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement is already in the map
            if (numIndices.containsKey(complement)) {
                // Return the indices of the two numbers
                return new int[]{numIndices.get(complement), i};
            }

            // Put the current number and its index into the map
            numIndices.put(nums[i], i);
        }

        // If no such pair is found
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = findTwoSum(nums, target);

        if (result[0] != -1) {
            System.out.println("Indices of two numbers: [" + result[0] + ", " + result[1] + "]");
            System.out.println("The two numbers: [" + nums[result[0]] + ", " + nums[result[1]] + "]");
        } else {
            System.out.println("No such pair found.");
        }
    }
}