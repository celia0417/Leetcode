package Yahoo;

import java.util.Stack;

import Google.TreeNode;

public class ValidBST {
	public boolean valid(TreeNode root) {
		return helper(root, null, null);
	}

	public boolean helper(TreeNode root, Integer low, Integer high) {
	    if (root == null) return true;
		return (low == null || root.val > low) && (high == null || root.val < high) && helper(root.left, low, root.val)
				&& helper(root.right, root.val, high);
	}
	
	public boolean valid2(TreeNode root){
		if (root == null) return true;
		Stack<TreeNode> stack = new Stack<>();
		Integer pre = null;
		while(!stack.isEmpty() || root != null){
			while (root != null){
				stack.push(root);
				root = root.left;
			}
			TreeNode cur = stack.pop();
			if (pre != null && pre >= cur.val) return false;
			pre = cur.val;
			root = cur.right;
		}
		return true;
	}
}
