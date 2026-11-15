package faang.linkedlist;

/**
 * LeetCode 143: Reorder List.
 * Reorder a linked list L0->L1->...->Ln-1->Ln into L0->Ln->L1->Ln-1->... in place, O(n) time.
 */
public class ReorderList2 {


	public class ListNode {
		public int value;
		public ListNode next;

		public ListNode(int value) {
			this.value = value;
		}
	}

	/**
	 *
	 * L0->L1->...->Ln-1->Ln into L0->Ln->L1->Ln-1->...
	 *
	 * 1. from middle of the list revert pointers back
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		ReorderList2 reorderList = new ReorderList2();
//		ListNode list = reorderList.build(new int[]{1, 2, 3, 4, 5, 6, 7});
		ListNode list = reorderList.build(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10 , 11, 12, 13, 14, 15});
		reorderList.print(list);
		reorderList.transform(list);
		reorderList.print(list);
	}

	private ListNode reverseTail(ListNode root) {
		int size = size(root);
		if (size <= 1) {
			return null;
		}

		int count = 0;
		ListNode next = root;
		ListNode secondHalf = null;
		while (next != null) {
			count++;
			if (count == size / 2) {
				// 2-nd half of the list
				secondHalf = next.next;
				// 1-st half list set end -> null
				next.next = null;
			}
			next = next.next;
		}

		ListNode prev = null;
		ListNode cur = secondHalf;
		while (cur != null) {
			// prev > cur > next  ====>  prev < cur < next
			ListNode tmp = cur.next;
			cur.next = prev;

			// reset pointers
			prev = cur;
			cur = tmp;
		}

		return prev;
	}

	public int size(ListNode root) {
		int count = 0;
		while (root != null) {
			root = root.next;
			count++;
		}
		return count;
	}

	public void transform(ListNode root) {
		ListNode reverse = reverseTail(root);
		print(reverse);
		print(root);
		if (reverse == null) {
			return;
		}

		ListNode forward = root;
		while (forward != null && reverse != null) {
			// forward > tmp > ...... reverse > tmp2 >  =======> forward > reverse > tmp  .......... tmp2 >
			ListNode tmp = forward.next;
			ListNode tmp2 = reverse.next;
			forward.next = reverse;
			// reverse list is longer than forward if original list has odd number of elements
			reverse.next = tmp != null ? tmp : reverse.next;

			forward = tmp;
			reverse = tmp2;
		}
	}

	public void print(ListNode root) {
		while (root != null) {
			System.out.printf("%s %s ", root.value, root.next != null ? ">" : "");
			root = root.next;
		}
		System.out.println();
	}

	public ListNode build(int[] val) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		for (int i : val) {
			cur.next = new ListNode(i);
			cur = cur.next;
		}
		return dummy.next;
	}

}
