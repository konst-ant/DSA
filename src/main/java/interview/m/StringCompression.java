package interview.m;

public class StringCompression {

	public static String compress(String input) {
		StringBuilder result = new StringBuilder();

		char previousChar = input.charAt(0);
		int counter = 1;
		for (int i = 1; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			if (previousChar == currentChar) {
				counter++;
			} else {
				append(result, previousChar, counter);
				counter = 1;
			}
			previousChar = currentChar;
		}
		append(result, previousChar, counter);

		return result.toString();
	}

	public static void append(StringBuilder builder, char symbol, int amount) {
		builder.append(symbol);
		if (amount > 1) {
			builder.append(amount);
		}
	}

	public static void main(String[] args) {
//		String result = compress("aabcdaaaa");
		String result = compress("");
		System.out.println(result);
	}

}
