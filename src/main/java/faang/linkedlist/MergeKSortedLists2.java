
package faang.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 23: Merge k Sorted Lists.
 *
 * Merge k sorted linked lists into one sorted list.
 * Time: O(N * k), Space: O(k) for the pointers array.
 *
 * Precondition: lists must not be null.
 * An empty list array is valid and yields an empty list.
 */
public class MergeKSortedLists2 {

	public static void main(String[] args) {
		MergeKSortedLists2 merger = new MergeKSortedLists2();

		ListNode l1 = merger.build(new int[]{1, 3, 5, 7});
		ListNode l2 = merger.build(new int[]{2, 6, 20});
		ListNode l3 = merger.build(new int[]{4, 8, 9, 10});
		ListNode l4 = merger.build(new int[]{4, 8, 11, 12});

		ListNode result = merger.merge(
				Arrays.asList(new ListNode[]{l1, l2, l3, l4})
		);
		// expected output 1 > 2 > 3 > 4 > 4 > 5 > 6 > 7 > 8 > 8 > 9 > 10 > 11 > 12 > 20
		merger.print(result);
	}

	public class ListNode {
		ListNode next;
		int value;

		public ListNode(ListNode next, int value) {
			this.next = next;
			this.value = value;
		}
	}

	public ListNode merge(List<ListNode> kLists) {
		if (kLists == null) {
			throw new IllegalArgumentException("kLists must not be null");
		}

		ListNode dummy = new ListNode(null, 0);
		ListNode tail = dummy;

		ListNode[] pointers = new ListNode[kLists.size()];

		for (int i = 0; i < kLists.size(); i++) {
			pointers[i] = kLists.get(i);
		}

		while (true) {
			if (isAllPointersNull(pointers)) {
				break;
			}

			// Find an initial non-null candidate.
			int minPointerIndex = 0;

			for (int i = 0; i < pointers.length; i++) {
				if (pointers[i] != null) {
					minPointerIndex = i;
					break;
				}
			}

			// Find the pointer with the smallest current node.
			for (int i = 0; i < pointers.length; i++) {
				if (pointers[i] != null) {
					minPointerIndex =
							pointers[i].value < pointers[minPointerIndex].value
									? i
									: minPointerIndex;
				}
			}

			// Append the selected node.
			tail.next = pointers[minPointerIndex];
			tail = tail.next;

			// Advance the selected list pointer.
			pointers[minPointerIndex] = pointers[minPointerIndex].next;

			// Detach the appended node from its original successor.
			tail.next = null;
		}

		return dummy.next;
	}

	private boolean isAllPointersNull(ListNode[] pointers) {
		for (ListNode pointer : pointers) {
			if (pointer != null) {
				return false;
			}
		}
		return true;
	}

	public ListNode build(int[] values) {
		ListNode dummy = new ListNode(null, -1);
		ListNode current = dummy;

		for (int value : values) {
			current.next = new ListNode(null, value);
			current = current.next;
		}

		return dummy.next;
	}

	// Do not use with cyclic lists.
	public void print(ListNode head) {
		while (head != null) {
			System.out.printf("%d", head.value);

			if (head.next != null) {
				System.out.printf(" > ");
			}

			head = head.next;
		}

		System.out.println();
	}
}
