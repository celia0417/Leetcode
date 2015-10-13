package LinkedList;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k ==0) return head;
		ListNode dummy = head;
		ListNode pre = null;
		int length = 0;
		ListNode fakeHead = head;
		while(fakeHead != null){
			length ++;
			fakeHead = fakeHead.next;
		}
		int cnt = 0;
		k = length-k % length;
		if (k == 0) return head;
		while (cnt < k){
			cnt ++;
			pre = dummy;
			dummy = dummy.next;
		}
		ListNode newHead = dummy;
		ListNode node = newHead;
		if (pre!=null){
			pre.next = null;
		}
		while (node.next != null){
			node = node.next;
		}
		node.next = head;
		return newHead;
	}
	
	public static void main (String args[]){
		RotateList rl = new RotateList();
		ListNode head = new ListNode(3);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(4);
		ListNode l4 = new ListNode(5);

		head.next = l1;
//		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
		System.out.println(rl.rotateRight(head, 5).val);
	}
}
