package interview.m;

public class MultiplicationTable2 {

	private static final int MULTIPLICATION_MAX_VALUE = 9;

	public static void printMultiplicationTable(int size) {
		for (int i = 0; i <= size; i++) {
			System.out.printf("%4d", i);
		}
		System.out.println();

		for (int row = 1; row <= size; row++) {
			System.out.printf("%4d", row);
			for (int column = 1; column <= size; column++) {
				System.out.printf("%4d", row * column);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		printMultiplicationTable(MULTIPLICATION_MAX_VALUE);
	}
}
