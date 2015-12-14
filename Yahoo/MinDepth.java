package Yahoo;

import java.util.Iterator;

import Google.TreeNode;

public class MinDepth {
	public int minDepth(TreeNode root){
		Iterator<Integer> iterator;
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}
}
