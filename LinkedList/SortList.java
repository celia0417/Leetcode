package LinkedList;

public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		int cnt = 0;
		ListNode dummy1 = head;
		while (dummy1 != null) {
			cnt++;
			dummy1 = dummy1.next;
		}
		int mid = cnt / 2;
		int halfCnt = 0;
		ListNode l = head, r = null;
		ListNode dummy2 = head;
		while (dummy2 != null) {
			halfCnt++;
			ListNode next = dummy2.next;
			if (mid == halfCnt){
				dummy2.next = null;
				r = next;
			}
			dummy2 = next;
		}

		ListNode left = sortList(l);
		ListNode right = sortList(r);
		ListNode returnHead = merge(left, right);
		return returnHead;
	}
	
	public ListNode sortList2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode l = head;
		ListNode slow = head,fast = head.next, pre = null;
		while (fast.next != null && fast.next.next != null){
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast.next != null){
			pre = slow;
			slow = slow.next;
		}
		pre.next = null;
		ListNode r = slow;
		ListNode left = sortList(l);
		ListNode right = sortList(r);
		ListNode returnHead = merge(left, right);
		return returnHead;
	} 

	public ListNode merge(ListNode l, ListNode r) {
		ListNode n1 = l, n2 = r;
		ListNode dummy = new ListNode(0);
		ListNode fakeHead = dummy;
		
		while (n1 != null && n2 != null) {
			if (n1.val < n2.val) {
				fakeHead.next = n1;
				n1 = n1.next;
				fakeHead = fakeHead.next;
			}else {
				fakeHead.next = n2; 
				n2 = n2.next;
				fakeHead = fakeHead.next;
			}
		}
		if (n1 != null){
			fakeHead.next = n1;
		}else if (n2 != null){
			fakeHead.next = n2;
		}
		return dummy.next;
	}
	
	public static void main (String args[]){
		SortList sl = new SortList();
		ListNode head = new ListNode(3);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(4);
		head.next = l1;
		l1.next = l2;
		l2.next = l3;
		System.out.println(sl.sortList(head).val);
	}
}
