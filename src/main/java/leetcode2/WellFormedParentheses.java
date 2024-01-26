package leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * You are given n pairs of parentheses '()'.
 * Write a method that will return a list of all possible well-formed parentheses that
 * can be composed of the given ones.
 *
 */
public class WellFormedParentheses {

    public static void main(String[] args) {
        WellFormedParentheses wellFormedParentheses = new WellFormedParentheses();
        wellFormedParentheses.generate(3).forEach(System.out::println);

    }

    public List<String> generate(int n) {
        List<String> strings = new ArrayList<>();
        if (n > 0) {
            recursive("", n, n, 0, strings);
        }
        return strings;
    }

    private void recursive(String s, int open, int close, int balance, List<String> strings) {
        if (open > 0)
            recursive(s + "(", open - 1, close, balance + 1, strings);
        if (close > 0 && balance > 0)
            recursive(s + ")", open, close - 1, balance - 1, strings);
        if (open == 0 && close == 0)
            strings.add(s);
    }
}
