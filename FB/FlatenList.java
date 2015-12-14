package FB;

import java.util.*;

public class FlatenList {
	public int[] flatternList(List<Object> list){
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<List> s = new Stack<>();
		Stack<Integer> sn = new Stack<>();
		int k = 0;
		while (true) {
			if (k >= list.size()) {
				if (!s.isEmpty()) {
					list = s.pop();
					k = sn.pop();
				} else {
					break;
				}
			} else if (isNumber(list.get(k))) res.add(list.get(k));
			else {
				s.push(list);
				sn.push(k);
				k = -1;
				list = list.get(k);
			}
			k ++;
		}
		return null;
	}
}
