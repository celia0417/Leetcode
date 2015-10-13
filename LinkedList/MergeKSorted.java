package LinkedList;

import java.util.*;

public class MergeKSorted {
	private static final Comparator<ListNode> comparator = new Comparator<ListNode>() {
		@Override
		public int compare(ListNode x, ListNode y) {
			return x.val - y.val;
		}
	};

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, comparator);
		for (ListNode node : lists) {
			if (node != null) {
				queue.add(node);
			}
		}
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			p.next = node;
			if (node.next != null)
				queue.add(node.next);
			p = p.next;
		}
		return dummy.next;
	}

}
