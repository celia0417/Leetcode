package FB;

import java.util.*;


public class VerticalPrintBinaryTree {

	Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
	public List<List<Integer>> verticalPrint(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root != null)
			radd(root, 0);
		for (int i : map.keySet())
			result.add(map.get(i));
		return result;
	}

	public void radd(TreeNode root, int x) {
		if (map.containsKey(x))
			map.get(x).add(root.val);
		else {
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.add(root.val);
			map.put(x, tmp);
		}
		if (root.left != null)
			radd(root.left, x - 1);
		if (root.right != null)
			radd(root.right, x + 1);
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode third = new TreeNode(5);
		TreeNode forth = new TreeNode(4);

		root.left = left;
		root.right = right;
		left.right = third;
		left.left = forth;
		VerticalPrintBinaryTree vpb = new VerticalPrintBinaryTree();
		List<List<Integer>> list = vpb.verticalPrint(root);
		for (List<Integer> l : list){
			for (int i : l){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
