package Snapchat;

import java.util.*;

import Google.TreeNode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return helper(root.left, root.right);
	}

	public boolean helper(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		if (left.val != right.val)
			return false;
		return helper(left.left, right.right) && helper(left.right, right.left);
	}

	public boolean isSymmetric2(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return true;
		}
		if (root.left == null || root.right == null) {
			return false;
		}
		Queue<TreeNode> leftQueue = new LinkedList<TreeNode>();
		Queue<TreeNode> rightQueue = new LinkedList<TreeNode>();
		leftQueue.add(root.left);
		rightQueue.add(root.right);
		while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
			if (leftQueue.size() != rightQueue.size())
				return false;
			TreeNode left = leftQueue.poll();
			TreeNode right = rightQueue.poll();
			if (left.val != right.val)
				return false;
			if ((left.left == null && right.right != null) || (left.left != null && right.right == null))
				return false;
			else if (left.left != null) {
				leftQueue.offer(left.left);
				leftQueue.offer(right.right);
			}
			if ((left.right == null && right.left != null) || (left.right != null && right.left == null))
				return false;
			else if (left.right != null) {
				leftQueue.offer(left.right);
				rightQueue.offer(right.left);
			}

		}
		return true;
	}
}
