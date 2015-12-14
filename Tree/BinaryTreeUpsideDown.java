package Tree;

public class BinaryTreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode next = null;
        TreeNode temp = null;

        while (curr != null) {
            next = curr.left;
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
	
	public static void main (String args[]){
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode third = new TreeNode(4);
		TreeNode forth = new TreeNode(5);

		root.left = left;
		root.right = right;
		left.left = third;
		left.right = forth;
		BinaryTreeUpsideDown bt = new BinaryTreeUpsideDown();
		bt.upsideDownBinaryTree(root);
	}
}
