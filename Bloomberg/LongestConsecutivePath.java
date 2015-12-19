package Bloomberg;

public class LongestConsecutivePath {
	Results calculate(TreeNode node) {
		if (node == null)
			return new Results(0, 0, 0);
		else {
			Results leftResults = calculate(node.left);
			Results rightResults = calculate(node.right);
			int leftLength = 1 + leftResults.rightLength;
			int rightLength = 1 + rightResults.leftLength;
			int maxLength = Math.max(Math.max(leftLength, rightLength),
					Math.max(leftResults.maxLength, rightResults.maxLength));
			return new Results(leftLength, rightLength, maxLength);
		}
	}

	public class LongestConsecutiveAscendingPath {
		Results calculate(TreeNode node) {
			if (node == null)
				return new Results(0, 0, 0);
			else {
				Results leftResults = calculate(node.left);
				Results rightResults = calculate(node.right);
				int leftLength = 1 + leftResults.leftLength;
				int rightLength = 1 + rightResults.rightLength;
				int maxLength = Math.max(Math.max(leftLength, rightLength),
						Math.max(leftResults.maxLength, rightResults.maxLength));
				return new Results(leftLength, rightLength, maxLength);
			}
		}
	}

	public static void main(String args[]) {
		LongestConsecutivePath lc = new LongestConsecutivePath();
		TreeNode root = new TreeNode(5);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(15);
		TreeNode n3 = new TreeNode(10);
		TreeNode n4 = new TreeNode(7);
		TreeNode n44 = new TreeNode(6);

		TreeNode n5 = new TreeNode(14);
		root.left = n1;
		root.right = n2;
		n2.left = n3;
		n3.left = n4;
		// n4.left = n44;
		n4.right = n5;
		Results re = lc.calculate(root);
		System.out.println(re.rightLength);
	}
}

class Results {
	int leftLength;
	int rightLength;
	int maxLength;

	public Results(int i, int j, int p) {
		leftLength = i;
		rightLength = j;
		maxLength = p;
	}
}
