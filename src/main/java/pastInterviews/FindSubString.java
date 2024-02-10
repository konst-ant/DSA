package pastInterviews;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * You are given a Character array and a string.
 *
 * Find mimimal substrings in given string, that include all Characters of given array.
 * In addition, each of the target substring must be unique within the whole given string.
 *
 *
 * @author Konstantin Antipin
 */
public class FindSubString {

    public Set<String> findSubstring(Character[] symbols, String string) {
        Set<Character> set = new HashSet<>();
        set.addAll(Arrays.asList(symbols));

        Set<String> candidates = new HashSet<>();

        for (int i = 0; i < string.length() - 2; i++) {
            HashSet<Character> tmp = new HashSet<>(set);
            tmp.remove(string.charAt(i));
            tmp.remove(string.charAt(i + 1));
            tmp.remove(string.charAt(i + 2));
            if (tmp.isEmpty()) {
                String candidate = string.substring(i, i + 3);
                if (candidates.contains(candidate)) {
                    candidates.remove(candidate);
                } else {
                    candidates.add(candidate);
                }
            }
        }
        return candidates;
    }

    public static void main(String[] args) {
        Character[] symbols = {'x', 'y', 'z'};
//        String string = "xyyzyzyxxyzyyy";
        String string = "xyyzyzyxxyzyyyxyz";

        FindSubString find = new FindSubString();
        System.out.println(find.findSubstring(symbols, string));
    }
}
