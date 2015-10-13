package Tree;

import java.util.Stack;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper (root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right){
        if(left == null || right == null) return left == right;
        return left.val == right.val && helper (left.left, right.right) && helper (left.right, right.left); 
    }
    
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode left, right;
        if (root.left != null){
        	if (root.right == null) return false;
        	stack.push(root.left);
        	stack.push(root.right);
        }
        else if (root.right != null)
        	return false;
        
        while(!stack.isEmpty()){
        	if (stack.size() % 2 != 0) return false;
        	right = stack.pop();
        	left = stack.pop();
        	if(right.val != left.val) return false;
        	if (left.left != null){
        		if (right.right == null) return false;
        		stack.push(left.left);
        		stack.push(right.right);
        	}
        	else if (right.right != null)
        		return false;
        	
        	if (left.right != null){
        		if (right.left == null) return false;
        		stack.push(left.right);
        		stack.push(right.left);
        	}
        	else if (right.left != null)
        		return false;

        }
        return true;
    }
}
