package LinkedList;

public class ReverseNodesKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k == 0)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy;
		while (p.next != null && p.next.next != null) {
			ListNode pre = p.next, cur = pre.next;
			int cnt = 0;
			while (cur != null && cnt < k-1){
				ListNode temp = cur.next;
				cur.next = pre;
				pre = cur;
				cur = temp;
				cnt ++;
			}
			if (cnt == k-1){
				ListNode temp = p.next;
				p.next.next = cur;
				p.next = pre;
				p = temp;
			}else{
				cur = pre.next;
				pre.next = null;
				while (cur != p.next){
					ListNode temp = cur.next;
					cur.next = pre;
					pre = cur;
					cur = temp;
				}
				break;
			}
		}

		return dummy.next;
	}
	
	public static void main (String args[]){
		ReverseNodesKGroup rg = new ReverseNodesKGroup();
		ListNode head = new ListNode(0);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);

		head.next = l1;
		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
		ListNode res = rg.reverseKGroup(head, 3);
		int cnt = 0;
		while(res!=null && cnt < 8){
			cnt ++;
			System.out.println(res.val);
			res = res.next;
		}
	}
}
