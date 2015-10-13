package LinkedList;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		ListNode newHead = new ListNode (Integer.MIN_VALUE);
		while (head != null){
			ListNode cur = head;
			ListNode pointer = newHead;
			head = head.next;
			while (pointer.next != null && pointer.next.val < cur.val){
				pointer = pointer.next;
			}
			cur.next = pointer.next;
			pointer.next = cur;
		}
		head = newHead.next;
        newHead = null;
        return head;
	}

}
