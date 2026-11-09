package faang.arrayshashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 49: Group Anagrams.
 * Group an array of strings into lists of anagrams of each other.
 * Throws IllegalArgumentException if strs is null or contains a null element.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            throw new IllegalArgumentException("strs must not be null");
        }
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            if (str == null) {
                throw new IllegalArgumentException("strs must not contain null elements");
            }
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(solution.groupAnagrams(new String[]{""}));
        System.out.println(solution.groupAnagrams(new String[]{"a"}));
        System.out.println(solution.groupAnagrams(new String[]{})); // empty input edge case
    }
}
