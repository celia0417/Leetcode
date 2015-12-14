package FB;

public class ValidBST {
	public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) < 2 && isValidBST(root.left) && isValidBST(root.right);
    }
    
    public int height (TreeNode node){
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
