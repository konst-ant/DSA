package interview.m;

public class StringCompression2 {

	/**
	 * Input: "aabbbbccdaaa"
	 * Output: "a2b4c2da3"
	 */


	public static String compress(String input) {
		if (input == null || input.isEmpty()) {
			return "";
		}

		StringBuilder result = new StringBuilder();

		int count = 1;
		char current = input.charAt(0);
		for (int index = 1; index < input.length(); index++) {
			if (current == input.charAt(index)) {
				count++;
			} else {
				append(result, current, count);
				count = 1;
			}
			current = input.charAt(index);
		}
		append(result, current, count);

		return result.toString();
	}

	private static void append(StringBuilder result, char current, int count) {
		result.append(current);
		if (count > 1) {
			result.append(count);
		}
	}

	public static void main(String[] args) {
		String compressed = compress("aabbbbccdaaa");
		System.out.println(compressed);
	}

}
