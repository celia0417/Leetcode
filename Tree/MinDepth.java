package Tree;

public class MinDepth {
	public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftDepth = min(root.left);
        int rightDepth = min(root.right);
        return (leftDepth != 0 ? rightDepth == 0 ? leftDepth : Math.min(leftDepth,rightDepth): rightDepth) +1;
    }
    
    public int min(TreeNode root){
        if (root == null) return 0;
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
    
    public static void main (String args[]){
    	MinDepth cct = new MinDepth();
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode third = new TreeNode(5);
		TreeNode forth = new TreeNode(4);

		root.left = left;
//		root.right = right;
//		left.right = third;
//		left.left = forth;
		System.out.println(cct.minDepth(root));
	}
}
