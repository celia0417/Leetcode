package Yahoo;

import Google.TreeNode;

public class KthSmallest {
	int k = 2;
	public int kthSmallest(TreeNode root) {
        if (root == null) return -1;
        int n = kthSmallest(root.left);
        if (n != -1) return n;
        k--;
        if (k == 0) return root.val;
        return kthSmallest(root.right);
    }
	
	public static void main (String args[]){
		KthSmallest ks = new KthSmallest();
		TreeNode root= new TreeNode(2);
		TreeNode l= new TreeNode(1);
		root.left = l;
		System.out.println(ks.kthSmallest(root));
		
	}
}
