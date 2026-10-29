package interview.m;

import java.util.Stack;

public class BalancedParenthesis {

	/**
	 * Valid Input: "(()())" > balanced
	 * Invalid Input: "(()" > inbalanced
	 * Invalid Input: ")(" > inbalanced
	 *
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solution("(()())"));
		System.out.println(solution("(()"));
	}

	public static boolean solution(String input) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < input.length(); i++) {
			char nextCharacter = input.charAt(i);
			char topCharacter;
			if (stack.isEmpty()) {
				stack.push(nextCharacter);
			} else {
				topCharacter = stack.peek();
				if (topCharacter != nextCharacter) {
					stack.pop();
				} else {
					stack.push(nextCharacter);
				}
			}
		}
		return stack.isEmpty();
	}
}
