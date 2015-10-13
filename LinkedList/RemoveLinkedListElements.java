package LinkedList;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = head;
        while (dummy != null && dummy.val == val){
        	ListNode next = dummy.next;
        	dummy = null;
        	dummy = next;
        }
        head = dummy;
        ListNode pre = new ListNode(0);
        while (dummy != null){
        	if (dummy.val == val){
        		while (dummy != null && dummy.val == val ){
        			dummy = dummy.next;
        		}
        		pre.next = dummy;
        	}
            pre = dummy;
            if (dummy != null)
            	dummy = dummy.next;
        }
        return head;
    }
	
	public ListNode removeElements2(ListNode head, int val){
		if (head == null) return null;
	    ListNode pointer = head;
	    while (pointer.next != null) {
	        if (pointer.next.val == val) pointer.next = pointer.next.next;
	        else pointer = pointer.next;
	    }
	    return head.val == val ? head.next : head;
	}
	
	public static void main(String args[]){
		RemoveLinkedListElements rle = new RemoveLinkedListElements();
		ListNode head = new ListNode(1);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(1);
		head.next = l1;
		l1.next = l2;
		l2.next = l3;
		System.out.println(rle.removeElements(head, 1).val);
	}
}
