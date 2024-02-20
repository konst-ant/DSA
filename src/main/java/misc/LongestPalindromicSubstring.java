package misc;

/**
 *
 * Given a string, find the longest palindromic substring
 *
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring palindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(palindromicSubstring.find("456WOW1raddddddar23"));
    }

    private int find(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < input.length(); i++) {
            if (i > 0 && i < input.length() - 1) {
                if (input.charAt(i - 1) == input.charAt(i + 1)) {
                    max = Math.max(max, countOdd(input, i));
                }
                if (input.charAt(i) == input.charAt(i - 1)) {
                    max = Math.max(max, countEven(input, i));
                }
            }
        }
        return max;
    }

    private int countOdd(String input, int i) {
        int count = 0;
        while (i-(count+1) >= 0 && i+(count+1) < input.length()
                && input.charAt(i - (count+1)) == input.charAt(i + (count+1))) {
            count++;
        }
        System.out.println("palindrom " + input.substring(i - count, i + count + 1));
        return count*2 + 1;
    }

    private int countEven(String input, int i) {
        int count = 0;
        while (i - count - 2 >= 0 && i + count + 1 < input.length()
                && input.charAt(i - count - 2) == input.charAt(i + count + 1)) {
            count++;
        }
        System.out.println("palindrom " + input.substring(i - count - 1, i + count + 1));
        return (count + 1) * 2;
    }
}
