package Tree;

import java.util.*;

public class InorderSuccessor {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        boolean flag = false;
        while (root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            if (flag) return cur;
            if (cur == p) flag = true;
            root = cur.right;
        }
        return null;
    }
	
	public static void main (String args[]){
		InorderSuccessor is = new InorderSuccessor();
		TreeNode root = new TreeNode (1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		System.out.println(is.inorderSuccessor(root, left).val);
	}
}
