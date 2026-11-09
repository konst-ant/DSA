package faang.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * LeetCode 20: Valid Parentheses.
 * Determine if a string of brackets is valid, meaning every bracket is properly closed and nested.
 * Precondition: {@code s} must not be null (an empty string is valid and returns true).
 */
public class ValidParentheses {

    private static final Map<Character, Character> PAIRS = Map.of(')', '(', ']', '[', '}', '{');

    public boolean isValid(String s) {
        if (s == null) {
            throw new IllegalArgumentException("s must not be null");
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (PAIRS.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != PAIRS.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("")); // edge case: empty string is vacuously valid
        System.out.println(solution.isValid("(")); // edge case: unmatched opening bracket
    }
}
