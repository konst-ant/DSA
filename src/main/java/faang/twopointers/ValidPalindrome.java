package faang.twopointers;

/**
 * LeetCode 125: Valid Palindrome.
 * Determine if a string is a palindrome considering only alphanumeric characters, ignoring case.
 * Throws IllegalArgumentException if s is null.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException("s must not be null");
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome(" "));
        // Edge case: empty string is trivially a palindrome.
        System.out.println(solution.isPalindrome(""));
    }
}
