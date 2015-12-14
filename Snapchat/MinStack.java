package Snapchat;

import java.util.*;

public class MinStack {
//	Stack<Integer> stack = new Stack<Integer>();
//	Stack<Integer> minStack = new Stack<Integer>();
//
//	public void push(int x) {
//		stack.push(x);
//		if (minStack.isEmpty() || x <= minStack.peek()) {
//			minStack.push(x);
//		}
//	}
//
//	public void pop() {
//		int p = stack.pop();
//		if (p == minStack.peek()) {
//			minStack.pop();
//		}
//	}
//
//	public int top() {
//		return stack.peek();
//	}
//
//	public int getMin() {
//		return minStack.peek();
//	}
	
	
	Stack<Long> stack = new Stack<Long>();
    long min;
    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(0L);
            min = x;
        }else{
            stack.push((long) (x - min));
            if (x < min) min = x;
        }
    }

    public void pop() {
        long pop = stack.pop();
        if (pop < 0) min -= pop;
    }

    public int top() {
        long top = stack.peek();
        if (top > 0) return (int)(top + min);
        else return (int) min;
    }

    public int getMin() {
        return (int) min;
    }
	

	public static void main(String args[]) {
		MinStack ms = new MinStack();
		ms.push(512);
		ms.push(-1024);
		ms.push(-1024);
		ms.push(512);
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
	}
}
