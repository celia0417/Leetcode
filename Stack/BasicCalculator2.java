package Stack;

import java.util.Stack;

public class BasicCalculator2 {
	public int calculate(String s) {
		s = s.replace(" ", "");
		Stack<Integer> stack = new Stack<Integer>();
		int res =0;
		int num = 0;
		char sign = '+';
		for (int i =0; i < s.length(); i++){
			if (Character.isDigit(s.charAt(i))){
				num = num * 10 + (s.charAt(i) - '0');
			}
			if (!Character.isDigit(s.charAt(i)) || i == s.length()-1){
				if (sign == '+'){
					stack.push(num);
				}else if (sign == '-'){
					stack.push(-num);
				}else if (sign == '*'){
					stack.push(stack.pop()*num);
				}else if (sign == '/'){
					stack.push(stack.pop() / num);
				}
				num = 0;
				sign = s.charAt(i);
			}
		}
		for (int i : stack){
			res += i;
		}
		return res;
	}
	
	public static void main (String args[]){
		BasicCalculator2 bc2 = new BasicCalculator2();
		System.out.println(bc2.calculate("3+2*2"));
	}
}
