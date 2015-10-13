package LinkedList;

public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode (0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null && cur.next != null){
        	pre.next = cur.next;
        	cur.next = cur.next.next;
        	pre.next.next = cur;
        	pre = cur;
        	cur = cur.next;
        }
        return dummy.next;
    }
}
