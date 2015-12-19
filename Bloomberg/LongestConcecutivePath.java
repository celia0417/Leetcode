package Bloomberg;

import java.util.*;

public class LongestConcecutivePath {
	List<Integer> res = new ArrayList<Integer>();
	int maxLen = 0;

	public List<Integer> longestConcecutivePath(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		dfs(list, root, root.val - 1, 0);
		return res;
	}

	public void dfs(List<Integer> list, TreeNode root, int val, int len) {
		if (root == null || val != root.val + 1) {
			if (len > maxLen)
				res.addAll(new ArrayList<Integer>(list));
			return;
		}
		list.add(root.val);
		dfs(list, root.left, val, len);
		dfs(list, root.right, val, len);
	}

	public static void main(String args[]) {
		LongestConcecutivePath lc = new LongestConcecutivePath();
		TreeNode root = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		root.left = n1;
		root.right = n2;
		lc.longestConcecutivePath(root);
	}
}
