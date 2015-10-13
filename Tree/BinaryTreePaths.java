package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        String path = ""+root.val;
        Stack<String> record  = new Stack<String>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node != root)
            	path += "->" + node.val;
            if (node.left != null){
                stack.push(node.left);
            } 
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null && node.right != null){
            	record.push(path);
            }
            if (node.right == null && node.left == null){
                res.add(path);
                if (!record.isEmpty())
                	path = record.pop();
                else
                	path = ""+root.val;
            }
        }
        return res;
    }
	public static void main (String args[]){
		BinaryTreePaths btp = new BinaryTreePaths();
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode third = new TreeNode(5);
		TreeNode forth = new TreeNode(4);

		root.left = left;
		root.right = right;
		left.right = third;
		left.left = forth;
		List<String> res =btp.binaryTreePaths(root);
		for (String str :res){
			System.out.println(str);
		}
	}
}
