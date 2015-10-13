package LinkedList;

public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode newhead = reverseList(head.next);
		head.next.next = head;
		head.next = null;

		return newhead;
	}

	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pre = null;
		ListNode nextNode = null;
		while (head.next != null) {
			nextNode = head.next;
			head.next = pre;
			pre = head;
			head = nextNode;
		}
		head.next = pre;
		return head;
	}

	public static void main(String args[]) {
		ReverseLinkedList rl = new ReverseLinkedList();
		ListNode head = new ListNode(0);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		head.next = l1;
		l1.next = l2;
		l2.next = l3;
		System.out.println(rl.reverseList2(head).next.next.next);
	}
}
