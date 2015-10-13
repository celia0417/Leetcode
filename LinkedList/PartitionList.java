package LinkedList;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		ListNode newList = new ListNode(0);
		ListNode l2 = newList;
		ListNode dummy = head;
		while (dummy.next != null) {
			if (dummy.next.val >= x) {
				l2.next = dummy.next;
				dummy.next = dummy.next.next;
				l2 = l2.next;
				l2.next = null;
			} else {
				dummy = dummy.next;
			}
		}
		if (head.val >= x && head != dummy) {
			ListNode next = head.next;
			dummy.next = head;
			head.next = newList.next;
			head = next;
		}else{
			dummy.next = newList.next;
		}
		l2 = null;
		newList = null;
		return head;
	}
	
	public ListNode partition2 (ListNode head, int x){
		ListNode h1 = new ListNode(0);
        ListNode h2 = new ListNode(0);
        ListNode t2 = h2;
        h1.next = head;
        head = h1;
        
        while(head.next != null) {
            if(head.next.val<x)   // skip node
                head = head.next;
            else {  // remove node from h1 and insert to the tail of h2
                t2.next = head.next;
                head.next = head.next.next;
                t2 = t2.next;
                t2.next = null;
            }
        }
        
        head.next = h2.next;
        head = h1.next;
        h1 = null;
        h2 = null;
        return head;
	}
	
	public static void main (String args[]){
		PartitionList pl = new PartitionList();
		ListNode head = new ListNode(3);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(5);
		ListNode l4 = new ListNode(1);
		ListNode l5 = new ListNode(4);
		head.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		System.out.println(pl.partition(head, 1).next.val);
	}
}
