package Google;

import java.util.HashSet;
import java.util.Stack;

public class EvaluateExpression {
	public int evaluate(String exp) throws Exception{
		Stack<Character> stack = new Stack<>();
		Stack<Integer> pre = new Stack<>();
		HashSet<Character> ops = new HashSet<>();
		ops.add('+'); ops.add('-'); ops.add('*'); ops.add('/');
		int res = 0;
		int cur = 0;
		char op = '+';
		boolean flag = false;
		for (int i = 0; i < exp.length(); i++){
			char c = exp.charAt(i);
			if ((c==' ' || c == '(' || c == ')')&&flag) {
				if (!ops.contains(op)) throw new Exception("no operation");
				switch (op) {
				case '+': res = res + cur; break;
				case '-': res = res - cur; break;
				case '*': res = res * cur; break;
				case '/': res = res / cur; break;
				}
				cur = 0;
				flag = false;
			}
			if (exp.charAt(i) == '('){
				stack.push(op);
				pre.push(res);
				op = '$';
				cur = 0;
				res = 0;
			}
			if (exp.charAt(i) == ')'){
				op = stack.pop();
				cur = res;
				res = pre.pop();
				switch (op) {
				case '+': res = res + cur; break;
				case '-': res = res - cur; break;
				case '*': res = res * cur; break;
				case '/': res = res / cur; break;
				}
				cur = 0;
				flag = false;
			}
			if (Character.isDigit(exp.charAt(i))){
				if (!ops.contains(op)) throw new Exception("no operation");
				cur = cur * 10 + exp.charAt(i) - '0';
				flag = true;
			}
			if (ops.contains(c)) {
				if (op != '$') throw new Exception("multi operation");
				op = c;
				if (c == '*') res = 1;
			}
		}
		return res;
	}
	
	public static void main (String args[]) throws Exception{
		EvaluateExpression ee = new EvaluateExpression();
		System.out.println(ee.evaluate("(+- 7 (+ 9 9))"));
	}
}
