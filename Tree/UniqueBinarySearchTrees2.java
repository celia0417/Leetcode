package Tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {
	public List<TreeNode> generateTrees(int n) {
		return generate(1, n);
	}

	public List<TreeNode> generate(int min, int max) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (min > max) {
			res.add(null);
			return res;
		}
		for (int i = min; i <= max; i++) {
			List<TreeNode> left = generate(min, i - 1);
			List<TreeNode> right = generate(i + 1, max);
			for (int j = 0; j < left.size(); j++) {
				for (int p = 0; p < right.size(); p++) {
					TreeNode node = new TreeNode(i);
					node.left = left.get(j);
					node.right = right.get(p);
					res.add(node);
				}
			}
		}
		return res;
	}

	public static void main(String args[]) {
		UniqueBinarySearchTrees2 ubs = new UniqueBinarySearchTrees2();
		List<TreeNode> list = ubs.generateTrees(2);
		for (TreeNode t : list) {
			System.out.println(t.val);
		}
	}
}
