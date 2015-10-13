package Stack;

import java.util.Stack;

public class BasicCalculator {
	public int calculate(String s) {
		s = s.replace(" ", "");
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		int sign = 1;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(stack.peek() * sign);
				sign = 1;
			} else if (s.charAt(i) == '+') {
				sign = 1;
			} else if (s.charAt(i) == '-') {
				sign = -1;
			} else if (s.charAt(i) == ')') {
				stack.pop();
			} else {
				int digit = s.charAt(i) - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					digit = digit * 10 + (s.charAt(++i) - '0');
				}
				res += sign * stack.peek() * digit;
			}
		}
		return res;
	}

	public static void main(String args[]) {
		BasicCalculator bc = new BasicCalculator();
		System.out.println(bc.calculate("3 -(1+2)"));
	}
}
