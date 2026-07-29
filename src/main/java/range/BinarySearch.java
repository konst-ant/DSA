package range;

import java.util.List;

/**
 * Helper class to provided lowerBoundary() and upperBoundary() semantics,
 * as opposed to Arrays.binarySearch(), which is only point index if element was found in the array or
 * index where to insert element if it's missing in the array
 */
public class BinarySearch {

	/**
	 * Find left-most element >= given left range boundary (l)
	 * @param array
	 * @param l
	 * @return value of element
	 */
	public int lowerBoundary(List<Integer> array, int l) {
		int left = 0;
		int right = array.size();
		System.out.println(array);

		int mid;
		while (left < right) {
			mid = left + (right - left) / 2;
			System.out.println(String.format("left=%d right=%d, mid=%d", left, right, mid));
			if (array.get(mid) >= l) {
				right = mid;
			} else {
				left = mid +1;
			}
		}
		return left; // return left or right - any, cuz on last iteration left == right
	}

	/**
	 * Find first element > given right range boundary (r)
	 * @param array
	 * @param r
	 * @return
	 */
	public int upperBoundary(List<Integer> array, int r) {
		int left = 0;
		int right = array.size();
		System.out.println(array);

		int mid;
		while (left < right) {
			mid = left + (right - left) / 2;
			System.out.println(String.format("left=%d right=%d, mid=%d", left, right, mid));
			if (array.get(mid) > r) {
				right = mid;
			} else {
				left = mid +1;
			}
		}
		return left; // return left or right - any, cuz on last iteration left == right
	}
}
