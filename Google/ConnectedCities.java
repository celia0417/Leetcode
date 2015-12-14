package Google;

import java.util.*;

public class ConnectedCities {
	public int connected (List<ListNode> list){
		Set<ListNode> set = new HashSet<>();
		for (ListNode node : list){
			set.add(node);
		}
		
		int num = 0;
		for (ListNode n : list){
			if (set.contains(n)){
				num++;
				if (set.contains(n.pre)) set.remove(n.pre);
				if (set.contains(n.next)) set.remove(n.next);
			}
		}
		return num;
	}
	
	public static void main (String args[]){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.pre = n1;
		n2.next = n3;
		n3.pre=n2;
		n3.next = n4;
		n4.pre = n3;
		n4.next = n5;
		n5.pre = n4;
		List<ListNode> list = new ArrayList<>();
		list.add(n1);
		list.add(n4);
		list.add(n5);
		ConnectedCities cc = new ConnectedCities();
		System.out.println(cc.connected(list));
	}
}
