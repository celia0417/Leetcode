package Snapchat;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class FlattenBinaryTreeDoublyLinkedList {
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode dummy = new TreeNode(0);
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.add(root);
				root = root.left;
			}
			TreeNode cur = stack.pop();
			cur.left= dummy;
			dummy.right = cur;
			dummy = cur;
			cur = cur.right;
		}
	}
}
