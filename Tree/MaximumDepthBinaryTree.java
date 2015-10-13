package Tree;

public class MaximumDepthBinaryTree {
	public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left) +1 ;
        int rightDepth = maxDepth(root.right) +1;
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
