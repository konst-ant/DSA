package codility;


import java.util.HashSet;
import java.util.Set;

/**
 * Find minimum number of Substrings with unique characters
 *
 * Input: s = “abacaba”
 * Output: 4
 * Explanation: Two possible partitions are (“a”, “ba”, “cab”, “a”) and (“ab”, “a”, “ca”, “ba”).
 * It can be shown that 4 is the minimum number of substrings needed.
 *
 * Input: s = “ssssss”
 * Output: 6
 * Explanation: The only valid partition is (“s”, “s”, “s”, “s”, “s”, “s”).
 */
public class MinimumSplitStringToUnique {

    static int partitionString(String s)
    {
        // Create a HashSet to store unique characters
        Set<Character> set = new HashSet<>();
        // Initialize the answer variable to 1
        int ans = 1;
        // Iterate through the given string
        for (int i = 0; i < s.length(); i++) {
            // Check if the current character is already
            // present in the set
            if (set.contains(s.charAt(i))) {
                // If it is, increment the answer variable
                // and clear the set to start a new
                // substring
                ans++;
                set.clear();
            }
            // Add the current character to the set
            set.add(s.charAt(i));
        }
        // Return the answer variable, which gives the
        // minimum number of substrings required
        return ans;
    }

    public static void main(String[] args)
    {
//        String S = "abba";
//        String S = "dddd";
//        String S = "world";
        String S = "cycle";

        System.out.print(partitionString(S));
    }
}
