package Google;

public class TreeTwoSum {

	TreeNode[] res;
	public TreeNode[] inorderTraversal(TreeNode root, int target) {
		TreeNode dummy = root;
		helper(root, dummy, target);
		return res;
	}

	public void helper(TreeNode root, TreeNode root2, int target) {
		if (root == null || root2 == null)
			return;
		helper(root.left, root2, target);
		helper(root, root2.right, target);
		if (root2 != root && (root.val + root2.val) == target) {
			res = new TreeNode[] { root, root2 };
		} else {
			if (root.val + root2.val > target) {
				helper(root, root2.left, target);
				return;
			} else {
				helper(root.right, root2, target);
			}
		}
		return;
	}

	public static void main(String args[]) {
		TreeTwoSum ts = new TreeTwoSum();
		TreeNode root = new TreeNode(4);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(7);
		TreeNode n6 = new TreeNode(6);
		root.left = n2;
		n2.left = n3;
		n2.right = n4;
		root.right = n5;
		n5.left = n6;
		TreeNode[] res = ts.inorderTraversal(root, 10);
		for (TreeNode t : res) {
			System.out.println(t.val);
		}
	}
}
