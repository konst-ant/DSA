package range;

import java.util.*;
import java.util.stream.Collectors;

/**
 * For given array, how many elements fall into *value* range given [l, r]
 *
 */
public class RangeQuery2 {
	final private List<Integer> sortedArray;

	public RangeQuery2(int[] array) {
		Arrays.sort(array);
		sortedArray = Arrays.stream(array).boxed().collect(Collectors.toList());
	}


	/**
	 * Check value existing in interval [l, r]
	 * @param l
	 * @param r
	 * @return
	 */
	public int howManyElementsHaveValueInRange(int l, int r) {

		BinarySearch binarySearch = new BinarySearch();
		int lowerBound = binarySearch.lowerBoundary(sortedArray,l);
		int upperBound = binarySearch.upperBoundary(sortedArray, r);

		// we may not bother about ArrayOutOfBounds here because upperBound and lowerBound have semantics
		// of next insert index in binary tree - so the cals would be always correct,
		// whilst we don't access array itself
		return upperBound - lowerBound;
	}



	public static void main(String[] args) {
		RangeQuery2 rangeQuery = new RangeQuery2(new int[]{5, 1, 2, 2, 3, 7, 4});
		System.out.println(rangeQuery.howManyElementsHaveValueInRange(2, 4));
		System.out.println(rangeQuery.howManyElementsHaveValueInRange(10, 20));
		System.out.println(rangeQuery.howManyElementsHaveValueInRange(2, 20));
		System.out.println(rangeQuery.howManyElementsHaveValueInRange(0, 20));
	}
}
