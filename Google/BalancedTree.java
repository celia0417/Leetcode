package Google;

public class BalancedTree {

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	private TreeNode root;

	public BalancedTree() {
		root = null;
	}

	public void delete(TreeNode root, int k) {
		if (root == null)
			return;
		if (k < root.val) {
			delete(root.left, k);
			if (height(root.right) - height(root.left) == 2) {
				if (root.right.left != null && (height(root.right.left) > height(root.right.right))) {
					doubleWithRightChild(root);
				} else {
					rotateWithRightChild(root);
				}
			}
		} else if (k > root.val) {
			delete(root.right, k);
			if (height(root.left) - height(root.right) == 2) {
				if (root.left.right != null && (height(root.left.right) > height(root.left.left))) {
					doubleWithLeftChild(root);
				} else
					rotateWithLeftChild(root);
			}
		} else {
			if (root.left != null && root.right != null) {
				TreeNode temp = root.right;
				while (temp.left != null)
					temp = temp.left;
				root.val = temp.val;
				delete(root.right, temp.val);
				if (height(root.left) - height(root.right) == 2) {
					if (root.left.right != null && (height(root.left.right) > height(root.left.left))) {
						doubleWithLeftChild(root);
					} else
						rotateWithLeftChild(root);
				}
			} else {
				TreeNode temp = root;
				if (root.left == null)
					root = root.right;
				else if (root.right == null)
					root = root.left;
				delete(root, temp.val);
				temp = null;
			}
		}
	}

	public TreeNode insert(int k) {
		return insert(root, k);
	}

	private TreeNode insert(TreeNode root, int k) {
		if (root == null) {
			return new TreeNode(k);
		}

		if (root.val > k) {
			root.left = insert(root.left, k);
			if (height(root.left) - height(root.right) == 2) {
				if (k < root.left.val)
					// LL
					root = rotateWithLeftChild(root);
				else
					// LR
					root = doubleWithLeftChild(root);
			}
		} else if (root.val < k) {
			root.right = insert(root.right, k);
			if (height(root.right) - height(root.left) == 2) {
				if (k > root.right.val)
					// RR
					root = rotateWithRightChild(root);
				else
					// RL
					root = doubleWithRightChild(root);
			}
		}
		return root;
	}

	// LR
	private TreeNode doubleWithLeftChild(TreeNode k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	// LL
	private TreeNode rotateWithLeftChild(TreeNode k2) {
		TreeNode k1 = root.left;
		k2.left = k1.right;
		k1.right = k2;
		return k1;
	}

	// RL
	private TreeNode doubleWithRightChild(TreeNode k1) {
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}

	// RR
	private TreeNode rotateWithRightChild(TreeNode k2) {
		TreeNode k1 = k2.right;
		k2.right = k1.left;
		k1.left = k2;
		return k1;
	}

	private int height(TreeNode node) {
		if (node == null)
			return 0;
		return Math.max(height(node.left), height(node.right)) + 1;
	}
}
