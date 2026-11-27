package faang.linkedlist;

public class LinkedListCycle2 {

	public static void main(String[] args) {
		LinkedListCycle2 llc = new LinkedListCycle2();
		ListNode normal = llc.build(new int[]{11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23});
		llc.print(normal);
		ListNode cyclic = llc.buildCyclic();
//		llc.print(cyclic);
		System.out.println(llc.hasCycle(normal));
		System.out.println(llc.hasCycle(cyclic));

	}

	public static class ListNode {
		public ListNode next;
		public int value;

		public ListNode(ListNode next, int value) {
			this.next = next;
			this.value = value;
		}
	}

	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	public ListNode build(int[] values) {
		ListNode dummy = new ListNode(null, -1);
		ListNode current = dummy;
		for (int i = 0; i < values.length; i++) {
			int value = values[i];
			current.next = new ListNode(null, value);
			current = current.next;
		}
		return dummy.next;
	}

	// be careful to not use this method with cyclic list - will be infinite loop!
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

	public ListNode buildCyclic() {
		ListNode cyclic = build(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		ListNode tmp = cyclic;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		// creating a cycle now 10-th pointing back to 3-rd
		tmp.next = cyclic.next.next;
		return cyclic;
	}


}
