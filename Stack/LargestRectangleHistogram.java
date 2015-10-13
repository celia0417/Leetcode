package Stack;

import java.util.*;

public class LargestRectangleHistogram {
	public int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0, i = 0, n = height.length;
		while (i <= n) {
			if (stack.isEmpty() || height[stack.peek()] <= ((i == n) ? 0 : height[i])) {
				stack.push(i++);
			} else {
				int t = stack.pop();
				maxArea = Math.max(maxArea, (stack.isEmpty() ? i : i - stack.peek() - 1) * height[t]);
			}
		}
		return maxArea;
	}

	public static void main(String args[]) {
		LargestRectangleHistogram lr = new LargestRectangleHistogram();
		int height[] = { 2, 1, 5, 6, 2, 3 };
		System.out.println(lr.largestRectangleArea(height));
	}
}
