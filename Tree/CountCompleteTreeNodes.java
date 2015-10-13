package Tree;

public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		if (root == null)
	        return 0;
	    return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	public static void main (String args[]){
		CountCompleteTreeNodes cct = new CountCompleteTreeNodes();
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode third = new TreeNode(5);
		TreeNode forth = new TreeNode(4);

		root.left = left;
		root.right = right;
		left.right = third;
		left.left = forth;
		System.out.println(cct.countNodes(root));
	}
}
