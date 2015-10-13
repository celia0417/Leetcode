package LinkedList;

import java.util.*;

public class MergeKSortedLinkedList {
	private static final Comparator<ListNode> listComparator = new Comparator<ListNode>() {
		@Override
		public int compare(ListNode x, ListNode y) {
			return x.val - y.val;
		}
	};

	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists.isEmpty())
			return null;
		Queue<ListNode> queue = new PriorityQueue<>(lists.size(), listComparator);
		for (ListNode node : lists) {
			if (node != null) {
				queue.add(node);
			}
		}
		ListNode dummyHead = new ListNode(0);
		ListNode p = dummyHead;
		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			p.next = node;
			p = p.next;
			if (node.next != null) {
				queue.add(node.next);
			}
		}
		return dummyHead.next;
	}
}
