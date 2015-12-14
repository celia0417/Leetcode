package Google;

import java.util.*;

public class MaxStack {
	Stack<Long> stack = new Stack<Long>();
    long max;
    public void push(int x) {
        if (stack.isEmpty()){
        	stack.push(0L);
        	max = x;
        } else {
        	stack.push(max - x);
        	if (x > max) max = x;
        }
    }

    public void pop() {
    	long pop = stack.pop();
    	if (pop < 0) max -= pop;
    }

    public int top() {
        long top = stack.peek();
        if (top > 0) return (int) (max - top);
        else return (int) max;
    }

    public int getMax() {
        return (int) max;
    }
}
