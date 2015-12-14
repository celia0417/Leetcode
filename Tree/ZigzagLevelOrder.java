package Tree;

import java.util.*;

public class ZigzagLevelOrder {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		TreeNode flag = root;
		List<Integer> list = new ArrayList<Integer>();
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			list.add(cur.val);
			if (cur.left != null)
				stack.add(cur.left);
			if (cur.right != null)
				stack.add(cur.right);
			if (cur == flag) {
				res.add(list);
				list = new ArrayList<Integer>();
				flag = stack.get(stack.size()-1);
			}
		}
		return res;
	}
}
