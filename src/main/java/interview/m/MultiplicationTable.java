package interview.m;

public class MultiplicationTable {

	private static final int TABLE_SIZE = 10;

	public static void printMultiplicationTable() {

		// print horizontal index
		System.out.printf("%4d", -1);
		for (int index = 1; index <= TABLE_SIZE; index++) {
			System.out.printf("%4d", index);
		}
		System.out.println();

		for (int row = 1; row <= TABLE_SIZE; row++) {
			// print vertical index
			System.out.printf("%4d", row);
			for (int column = 1; column <= TABLE_SIZE; column++) {
				int product = row * column;
				System.out.printf("%4d", product);

			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		printMultiplicationTable();
	}
}
