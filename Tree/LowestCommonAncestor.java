package Tree;

public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return root;
		if (root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}

	public static void main(String args[]) {
		LowestCommonAncestor lca = new LowestCommonAncestor();
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode third = new TreeNode(5);
		TreeNode forth = new TreeNode(4);

		root.left = left;
		root.right = right;
		left.left = forth;
		left.right = third;

		TreeNode res = lca.lowestCommonAncestor(root, third, forth);
		System.out.println(res.val);
	}
}
