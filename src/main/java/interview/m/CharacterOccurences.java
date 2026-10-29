package interview.m;

import java.util.Map;
import java.util.TreeMap;

public class CharacterOccurences {
	public static void main(String[] args) {
		printOccurences(countOccurences("aaaaacuuttt"));
	}

	public static Map<Character, Integer> countOccurences(String input) {
		// use TreeMap to output in order of keys
		Map<Character, Integer> charToCount = new TreeMap();

		for (int i = 0; i < input.length(); i++) {
			char nextChar = input.charAt(i);
			charToCount.merge(nextChar, 1, (a, b) -> a + 1);
		}

		return charToCount;
	}

	public static void printOccurences(Map<Character, Integer> occurences) {
		for (Map.Entry entry : occurences.entrySet()) {
			System.out.printf("%4s : %4d\n", entry.getKey(), entry.getValue());
		}
	}
}
