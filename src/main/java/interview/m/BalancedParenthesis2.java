package interview.m;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class BalancedParenthesis2 {

	private static final int PARANTHESIS_OPEN = 1;
	private static final int PARANTHESIS_CLOSE = -1;
	private static final int BRACKET_OPEN = 2;
	private static final int BRACKET_CLOSE = -2;
	private static final int CURLY_BRACKET_OPEN = 3;
	private static final int CURLY_BRACKET_CLOSE = -3;

	public static void main(String[] args) throws Exception {
		System.out.println(solution("(()())")); // good
		System.out.println(solution("(()")); // bad
		System.out.println(solution("(()[])")); // good
		System.out.println(solution("[((()[]{}{{}}))]")); // good
		System.out.println(solution("(({)[}])")); // bad
		System.out.println(solution("(()[[]})")); // bad
		System.out.println(solution("((_))")); // bad symbol (exception)

	}

	public static boolean solution(String input) throws Exception{

		List<Integer> integerRepresentation = translate(input);

		Stack<Integer> stack = new Stack<>();
		for (int i : integerRepresentation) {
			if (i < 0) {
				// it's a closing symbol - try to match with existing one in top of the stack; otherwise save it into the stack
				if (!stack.isEmpty()) {
					if (stack.peek() + i == 0) {
						stack.pop();
					} else {
						stack.push(i);
					}
				}
			} else {
				// it's an openning symbol - always save it into the stack
				stack.push(i);
			}
		}
		return stack.isEmpty();
	}

	private static List<Integer> translate(String input) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			char nextChar = input.charAt(i);
			switch (nextChar) {
				case '(':
					result.add(PARANTHESIS_OPEN);
					break;
				case ')':
					result.add(PARANTHESIS_CLOSE);
					break;
				case '[':
					result.add(BRACKET_OPEN);
					break;
				case ']':
					result.add(BRACKET_CLOSE);
					break;
				case '{':
					result.add(CURLY_BRACKET_OPEN);
					break;
				case '}':
					result.add(CURLY_BRACKET_CLOSE);
					break;
				default:
					throw new IllegalArgumentException("Incorrect symbol in input String. Allowed symbols: ()[]{}");
			}
		}
		return result;
	}
}
