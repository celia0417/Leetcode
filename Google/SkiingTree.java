package Google;

import java.util.*;

public class SkiingTree {
	
	// binary tree		
//	private int max = 0;
//    public int longestConsecutive(TreeNode root) {
//        if (root == null) return 0;
//        dfs(root, 0, root.val);
//        return max;
//    }
//    
//    public void dfs(TreeNode root, int cur, int target){
//        if (root == null) return;
//        if (root.val == target) cur ++;
//        else cur = 1;
//        max = Math.max(cur, max);
//        dfs(root.left, cur, root.val + 1);
//        dfs(root.right, cur, root.val + 1);
//    } 
	
	private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0, root.val);
        return max;
    }
    
    public void dfs(TreeNode root, int cnt, int val){
        if (root == null) return;
        if (root.val != val) cnt =  1;
        else cnt ++;
        max = Math.max(cnt, max);
        dfs(root.left, cnt, root.val + 1);
        dfs(root.right, cnt,root.val + 1);
    } 
    
    // multi tree
    private int maxMulti = 0;
    public int longestConsecutiveMulti(MultiTreeNode root) {
        if (root == null) return 0;
        helper(root, 0, root.val);
        return max;
    }
    
    public void helper(MultiTreeNode root, int cur, int target){
        if (root == null) return;
        if (root.val == target) cur ++;
        else cur = 1;
        maxMulti = Math.max(cur, maxMulti);
        for (MultiTreeNode mn : root.neighbors){
        	helper(mn, cur, root.val + 1);
        }
    } 
    
    class MultiTreeNode{
    	Set<MultiTreeNode> neighbors;
    	int val;
    	public MultiTreeNode(int val){
    		this.val = val;
    	}
    }
    
    public static void main (String args[]){
    	SkiingTree st = new SkiingTree();
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(3);
		TreeNode right = new TreeNode(2);
		TreeNode third = new TreeNode(4);
		TreeNode forth = new TreeNode(5);

		root.right = left;
		left.left = right;
		left.right = third;
		third.right = forth;
    	System.out.println(st.longestConsecutive(root));
    }
}
