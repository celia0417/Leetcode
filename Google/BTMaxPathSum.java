package Google;

public class BTMaxPathSum {
	private static class TreeNode {
		private int val;
		private TreeNode left, right;

		public TreeNode(int value) {
			val = value;
		}
	}

	private int max = Integer.MIN_VALUE;

	private class Result {
		private int has;
		private int notHas;

		public Result(int has, int not) {
			this.has = has;
			this.notHas = not;
		}
	}

	public int maxPathSum(TreeNode root) {
		this.max = Integer.MIN_VALUE;
		helper(root);
		return max;
	}

	private Result helper(TreeNode x) {
		if (x == null)
			return new Result(0, 0);
		Result left = helper(x.left);
		Result right = helper(x.right);

		int sum = x.val;
		if (left.notHas > 0)
			sum += left.notHas;
		if (right.notHas > 0)
			sum += right.notHas;
		max = Math.max(max, sum);

		sum = 0;
		sum += Math.max(0, Math.max(left.has, left.notHas));
		sum += Math.max(0, Math.max(right.has, right.notHas));
		max = Math.max(max, sum);

		int has = x.val + Math.max(0, Math.max(left.notHas, right.notHas));
		int notHas = Math.max(left.has, left.notHas);
		notHas = Math.max(notHas, Math.max(right.has, right.notHas));
		notHas = Math.max(0, notHas);

		return new Result(has, notHas);
	}

	public static void main(String args[]) {
		BTMaxPathSum bt = new BTMaxPathSum();
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode third = new TreeNode(5);
		TreeNode forth = new TreeNode(4);

		root.left = left;
		root.right = right;
//		left.right = third;
		left.left = forth;
		System.out.println(bt.maxPathSum(root));
	}
}
