package leetcode2;

import java.util.*;

public class BalancedBrackets {


    Map<Character, Character> brackets = Map.of('{', '}', '[', ']', '(', ')');

    public boolean isBalancedBrackets(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (brackets.keySet().contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (!c.equals(brackets.get(stack.pop()))) return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isBalancedBracketsLettersAllowed(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (brackets.keySet().contains(c)) {
                stack.push(c);
            } else if (brackets.values().contains(c)) {
                if (stack.isEmpty()) return false;
                if (!c.equals(brackets.get(stack.pop()))) return false;
            }
        }
        return stack.isEmpty();
    }


    boolean isBalancedBrackets2(String s) {
        char[] arr = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (Character c : arr) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                Character last = stack.pop();
                if (c == '}' && last != '{') return false;
                if (c == ']' && last != '[') return false;
                if (c == ')' && last != '(') return false;
            }
        }
        return stack.isEmpty();
    }

    public void run(String s) {
        System.out.println(isBalancedBrackets(s));
    }

    public static void main(String[] args) {
        BalancedBrackets balancedBrackets = new BalancedBrackets();
        balancedBrackets.run("({[([])]})");
        balancedBrackets.run("({[([])]}){}{}()");
        balancedBrackets.run("");
        balancedBrackets.run("({[a(q[W])=]-}){ashda}{}()!ccc");
        balancedBrackets.run("(((");
        balancedBrackets.run("}(({[([])]})");
        balancedBrackets.run("(({[[(])]})");
        balancedBrackets.run("(({[([a])]})");
        balancedBrackets.run("(({[(])]})");
        System.out.println();
        balancedBrackets.run("{[()]}");
        balancedBrackets.run("{[(])}");
        balancedBrackets.run("{{[[(())]]}}");
        balancedBrackets.run("{{)[](}}");
        balancedBrackets.run("{(([])[])[]}");
        balancedBrackets.run("{(([])[])[]]}");
        balancedBrackets.run("{(([])[])[]}[]");
    }
}
