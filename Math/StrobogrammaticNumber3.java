package Math;

import java.util.*;

public class StrobogrammaticNumber3 {
	int res = 0;

	public int strobogrammaticInRange(String low, String high) {
		List<String> sol = new ArrayList<>();
		for (int i = low.length(); i <= high.length(); i++) {
			sol.addAll(helper(i, i));
		}
		for (String str : sol) {
			if (str.length() == low.length() && str.compareTo(low) < 0
					|| str.length() == high.length() && str.compareTo(high) > 0) {
				continue;
			}
			res++;
		}
		return res;
	}

	public List<String> helper(int num, int n) {
		if (num == 0)
			return new ArrayList<String>(Arrays.asList(""));
		if (num == 1)
			return new ArrayList<String>(Arrays.asList("0", "1", "8"));
		List<String> list = helper(num - 2, n);
		List<String> res = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			if (num != n)
				res.add("0" + str + "0");
			res.add("1" + str + "1");
			res.add("8" + str + "8");
			res.add("6" + str + "9");
			res.add("9" + str + "6");
		}
		return res;
	}
}
