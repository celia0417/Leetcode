package Tree;

public class CountUnivalSubtrees {
	int cnt = 0;

	public int countUnivalSubtrees(TreeNode root) {
		helper(root, root.left, root.right);
		return cnt;
	}

	public boolean helper(TreeNode root, TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			cnt++;
			return true;
		}
		boolean l = left == null ? true : helper(left, left.left, left.right);
		boolean r = right == null ? true: helper(right, right.left, right.right);
		int val = root.val;
		int leftVal = left != null ? left.val : val;
		int rightVal = right != null ? right.val : val;
		if (l && r && val ==leftVal && val== rightVal){
			cnt++;
		}else{
			return false;
		}
		return l && r;
	}

	public static void main(String args[]) {
		CountUnivalSubtrees cus = new CountUnivalSubtrees();
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		TreeNode third = new TreeNode(5);
		TreeNode forth = new TreeNode(4);

		root.left = left;
		root.right = right;
		// left.right = third;
		// left.left = forth;
		System.out.println(cus.countUnivalSubtrees(root));
	}
}
