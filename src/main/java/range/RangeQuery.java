package range;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * For given array, check if values exist in given array index range [l, r]
 *
 */
public class RangeQuery {
	Map<Integer, List<Integer>> valueToIndexes;

	public RangeQuery(int[] array) {
		valueToIndexes = preprocess(array);
	}

	/**
	 * Preprocessing, mapping values existing in array into the list of indexes where they appear
	 * Note: List(s) are naturally store increasing indexes cuz we traverse left-to-right
	 * @param array
	 * @return
	 */
	private Map<Integer, List<Integer>> preprocess(int[] array) {
		Map<Integer, List<Integer>> result = new HashMap<>();

		for (int i = 0; i < array.length; i++) {
			Integer value = array[i];
			result.computeIfAbsent(value, k -> new ArrayList<Integer>()).add(i);
		}
		return result;
	}

	/**
	 * Check value existing in interval [l, r]
	 * @param l
	 * @param r
	 * @param targetValue
	 * @return
	 */
	public boolean isValueExistingInArrayRange(int l, int r, int targetValue) {
		if (!valueToIndexes.containsKey(targetValue)) {
			return false;
		}

		List<Integer> indexes = valueToIndexes.get(targetValue);
		BinarySearch binarySearch = new BinarySearch();
		int index = binarySearch.lowerBoundary(indexes, l);

		return index >= indexes.size() ? false : index <= r;
	}



	public static void main(String[] args) {
		RangeQuery rangeQuery = new RangeQuery(new int[]{1, 2, 3, 2, 5, 2, 7});
		System.out.println(rangeQuery.isValueExistingInArrayRange(1, 4, 2));
	}
}
