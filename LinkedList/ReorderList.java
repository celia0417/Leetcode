package LinkedList;

public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) return;
        ListNode left = head;
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightNode = slow.next;
        slow.next = null;
        ListNode right = reverse(rightNode);
        merge(left,right);
	}
	
	public ListNode reverse(ListNode rightNode){
		if (rightNode == null || rightNode.next == null) return rightNode;
        ListNode pre = null;
		while (rightNode.next != null){
            ListNode next = rightNode.next;
            rightNode.next = pre;
            pre = rightNode;
            rightNode = next;
        }
		rightNode.next = pre;
		
		return rightNode;
	}
	
	public void merge(ListNode l, ListNode r){
		while (r.next != null){
			ListNode temp1 = l.next;
			ListNode temp2 = r.next;
			l.next = r;
			r.next = temp1;
			l = temp1;
			r = temp2;
		}
	}
}
