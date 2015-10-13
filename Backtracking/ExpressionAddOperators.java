package Backtracking;

import java.util.*;

public class ExpressionAddOperators {
	List<String> res = new ArrayList<String>();

	public List<String> addOperators(String num, int target) {
		helper(num, target, 0, 0, 0, new StringBuilder());
		return res;
	}

	public void helper(String num, int target, long value, long multi, int pos, StringBuilder exp) {
		if (pos == num.length()) {
			if (value == target) {
				res.add(exp.toString());
				return;
			}
		}

		for (int i = pos; i < num.length(); i++) {
			if (pos != i && num.charAt(i) == '0')
				break;
			long cur = Long.parseLong(num.substring(pos, i + 1));
			if (pos == 0) {
				helper(num, target, cur, cur, i + 1, exp.append(cur));
			} else {
				helper(num, target, value - cur, -cur, i + 1, exp.append("-").append(cur));
				helper(num, target, value + cur, cur, i + 1, exp.append("+").append(cur));
				helper(num, target, value - multi + multi * cur, cur * multi, i + 1, exp.append("*").append("cur"));
			}
		}
	}
}
