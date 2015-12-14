package FB;

public class LongestPathTree {
	public int longest(TreeNode root, TreeNode n1, TreeNode n2){
		TreeNode ancestor = ancestor (root, n1, n2);
		int l1 = findLength (ancestor, n1, 1);
		int l2 = findLength (ancestor, n2, 1);
		return (l1 + l2) -1;
	}
	
	public TreeNode ancestor(TreeNode root, TreeNode n1, TreeNode n2){
		if (root == null) return null;
		if (root == n1 || root == n2) return root;
		TreeNode left =  ancestor(root.left, n1, n2);
		TreeNode right =  ancestor(root.right, n1, n2);
		if (left != null && right != null) return root;
		return left != null ? left : right;
	}
	
	public int findLength(TreeNode root, TreeNode node, int n){
		if (root == null) return -1;
		if (root == node) return n;
		int left = findLength(root.left, node, n + 1);
		int right = findLength(root.right, node, n + 1);
		return left != -1 ? left : right;
	}
	
	int max_len;
	public int height(TreeNode root){
		if(root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        max_len = Math.max(max_len, l + r + 1);
        return Math.max(l, r) + 1;
	}
	
	int long_path(TreeNode root) {
        max_len = 0;
        height(root);
        return max_len;
	}
	
	
	public static void main (String args[]){
		LongestPathTree lp = new LongestPathTree();
		
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode third = new TreeNode(4);
		TreeNode forth = new TreeNode(5);
		TreeNode fifth = new TreeNode(6);
		
		root.left = left;
		root.right = right;
		left.left = third;
		right.right = forth;
		forth.left = fifth;
		
		System.out.println(lp.long_path(root));
	}
}
