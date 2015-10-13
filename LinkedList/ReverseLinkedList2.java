package LinkedList;

public class ReverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = head;
		int cnt = 1;
		ListNode pre = null;
		ListNode nextNode = null;
		ListNode lastPre = new ListNode(0);
		ListNode firstReverse = new ListNode(0);
		while (cnt <= n) {
			nextNode = head.next;
			if (cnt >= m) {
				if (cnt == 1 && cnt == m) {
					head.next = null;
				} else {
					head.next = pre;
				}
				if (cnt == m) {
					lastPre = pre;
					firstReverse = head;
				}
			}
			pre = head;
			head = nextNode;
			cnt++;
		}
		if (lastPre != null) {
			lastPre.next = pre;
		}
		firstReverse.next = head;
		if (m == 1)
			dummy = pre;
		return dummy;
	}

	public ListNode reverse(ListNode node, int n) {
		return null;
	}

	public static void main(String args[]) {
		ReverseLinkedList2 rl = new ReverseLinkedList2();
		ListNode head = new ListNode(0);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		head.next = l1;
		l1.next = l2;
		l2.next = l3;
		System.out.println(rl.reverseBetween(head, 1, 3).next.next.val);
	}
}
