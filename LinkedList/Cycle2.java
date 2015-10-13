package LinkedList;

public class Cycle2 {
	public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast.next == null || fast.next.next == null){
            return null;
        }
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
	
	public static void main(String args[]){
		Cycle2 cc = new Cycle2();
		ListNode head = new ListNode(0);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n2;
		System.out.println(cc.detectCycle(head).val);
	}
}
