package crackingCodingInterview;

/**
 * page 192
 *
 * Implement an algorithm to determine if a string has all unique characters.
 *
 * write a method:
 *
 * public static boolean solution(String str)
 *
 *
 * Follow up questions:
 * How to reduce space usage? What if you cannot use additional data structures?
 *
 */
public class AllUniqueCharacters {
    public static void main(String[] args) {
        System.out.println();
    }

    public static boolean solution(String str) {
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {//Already found this char in string
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    /**
     * Reduce space usage
     * @param str
     * @return
     */
    boolean solution2(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker = (1 << val);
        }
        return true;
    }

}
