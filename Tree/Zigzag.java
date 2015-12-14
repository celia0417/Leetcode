package Tree;

import java.util.*;

public class Zigzag {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		List<TreeNode> queue = new ArrayList<TreeNode>();
		List<TreeNode> temp = new ArrayList<TreeNode>();
		int level = 0;
		queue.add(root);
		TreeNode flag = root;
		List<Integer> list = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode cur = queue.remove(0);
			list.add(cur.val);
			if (level % 2 == 0) {
				if (cur.left != null)
					temp.add(0, cur.left);
				if (cur.right != null)
					temp.add(0, cur.right);
			} else {
				if (cur.right != null)
					temp.add(0, cur.right);
				if (cur.left != null)
					temp.add(0, cur.left);
			}
			if (cur == flag) {
				res.add(list);
				list = new ArrayList<Integer>();
				if (!queue.isEmpty()) {
					flag = queue.get(queue.size() - 1);
				}
				level++;

			}
		}
		return res;
	}
	
	public static void main (String args[]){
		Zigzag zz = new Zigzag();
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode third = new TreeNode(4);
		TreeNode forth = new TreeNode(5);
		TreeNode fifth = new TreeNode(6);

		root.left = left;
		root.right = right;
		left.left = third;
		left.right = forth;
		right.left = fifth;
		List<List<Integer>> res = zz.zigzagLevelOrder(root);
		for (List<Integer> list :res){
			for (int i : list){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
