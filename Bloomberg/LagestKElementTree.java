package Bloomberg;

public class LagestKElementTree {
	int count = 0;

	public void inorderTraversal(TreeNode root, int target, int k) {
		if (root == null || k < 0)
			return;
		inorderTraversal(root.right, target, k);
		count++;
		if (k == count) {
			System.out.println(root.val);
			return;
		}
		inorderTraversal(root.left, target, k);
	}

	public static void main(String args[]) {
		LagestKElementTree ts = new LagestKElementTree();
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
		ts.inorderTraversal(root, 10, 4);
	}
}
