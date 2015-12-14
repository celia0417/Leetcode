package Google;

public class ConstructBSTPreorder {
	public TreeNode buildTree(int[] preorder) {
		int[] index = new int[1];

		return helper(preorder, preorder.length, index, preorder[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public TreeNode helper(int[] p, int size, int[] index, int key, int min, int max) {
		if (index[0] >= size) return null;
		TreeNode root = null;
		if (key > min && key < max){
			root = new TreeNode(key);
			index[0] = index[0] + 1;
			if (index[0] < size){
				root.left = helper(p, size, index, p[index[0]], min, key);
				root.right = helper(p, size, index, p[index[0]], key, max);
			}
		}
		return root;
	}

	public void print (TreeNode root){
		if (root == null) return;
		print(root.left);
		System.out.print(root.val + " ");
		print(root.right);
	}
	
	public static void main(String args[]) {
		ConstructBSTPreorder cbst = new ConstructBSTPreorder();
		TreeNode root = cbst.buildTree(new int[] { 5, 3, 1, 4, 7, 6, 9 });
		cbst.print(root);
	}
}
