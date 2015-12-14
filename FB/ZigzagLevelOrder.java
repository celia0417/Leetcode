package FB;

import java.util.*;

public class ZigzagLevelOrder {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		TreeNode flag = root;
		List<Integer> list = new ArrayList<Integer>();
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			list.add(cur.val);
			if (cur.left != null)
				stack.add(cur.left);
			if (cur.right != null)
				stack.add(cur.right);
			if (cur == flag) {
				res.add(list);
				list = new ArrayList<Integer>();
				flag = stack.get(stack.size()-1);
			}
		}
		return res;
	}
	
	public void zigzagLevelOrder2(TreeNode root) {
        if (root == null) return;
		List<TreeNode> queue = new ArrayList<TreeNode>();
		int level = 0;
		queue.add(root);
		while (!queue.isEmpty()) {
		    List<Integer> list = new ArrayList<Integer>();
		    int size = queue.size();
		    for (int i = 0; i < size; i++){
		        TreeNode cur = queue.remove(0);
			    if (level % 2 == 0){
			        list.add(cur.val);
			    } else {
			        list.add(0,cur.val);
			    }
			    if (cur.left != null) queue.add(cur.left);
			    if (cur.right != null) queue.add(cur.right);
		    }
		    for (int i : list){
		    	System.out.print(i +" ");
		    }
		    System.out.println();
		    level ++;
		}
    }
	
	public static void main (String args[]){
		ZigzagLevelOrder zlo = new ZigzagLevelOrder();
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
		
		zlo.zigzagLevelOrder2(root);
	}
}
