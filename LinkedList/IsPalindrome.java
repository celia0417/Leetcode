package LinkedList;
import java.util.*;
public class IsPalindrome {

	public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<Integer>(); 
        while(head != null){
            list.add (head.val);
            head = head.next;
        }
        int n = list.size()-1;
        for (int i =0; i < list.size()/2; i ++){
            if (list.get(i) != list.get(n-i)){
                return false;
            }
        }
        return true;
    }
	ListNode h;

	public boolean isPalindrome2(ListNode head) {
        if (head == null) return true;
        if (h == null) h = head;
        boolean flag = true;
        if (head.next != null) flag &= isPalindrome(head);
        flag &= (head.val == h.val);
        h = h.next;
        return flag;
    }

	
	public static void main (String args[]){
		IsPalindrome ip = new IsPalindrome();
		ListNode head = new ListNode(0);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(0);
		ListNode l3 = new ListNode(0);
		head.next = l1;
		l1.next = l2;
		l2.next = l3;
		System.out.println(ip.isPalindrome2(head));
	}
}
