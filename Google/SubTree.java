package Google;

public class SubTree {
	public TreeNode findNode(TreeNode root, TreeNode subnode) {
		if (root == null || subnode == null)
			return null;
		if (root.val == subnode.val)
			return root;
		else {
			if (root.val > subnode.val)
				return findNode(root.left, subnode);
			else
				return findNode(root.right, subnode);
		}
	}

}
