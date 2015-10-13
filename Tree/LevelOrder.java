package Tree;

import java.util.*;

public class LevelOrder {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        List<Integer> list = new ArrayList<Integer>();
        List<TreeNode> temp = new ArrayList<TreeNode>();	
        TreeNode flag = root;
        temp.add(root);
        while (!temp.isEmpty()){
            TreeNode cur = temp.remove(0);
            list.add(cur.val);
            if (cur.left != null) temp.add(cur.left);
            if (cur.right != null) temp.add(cur.right); 
            if (cur == flag){
                res.add(list);
                list = new ArrayList<Integer>();
                if (!temp.isEmpty()){
                    flag = temp.get(temp.size()-1);
                }
            }
        }
        return res;
    }
	
	public static void main (String args[]){
		LevelOrder lo = new LevelOrder();
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode forth = new TreeNode(4);

		root.left = left;
		root.right = right;
		left.left = third;
		left.right = forth;
		List<List<Integer>> list = lo.levelOrder(root);
		for (List<Integer> l : list){
			for (int i : l){
				System.out.print(i+ " ");
			}
			System.out.println();
		}
	}
}
