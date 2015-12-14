package Google;

public class MinPathTree {
	int min, cnt;
	public int min(TreeNode root, TreeNode target){
		helper(root, target, 0);
		return cnt;
	}
	
	public void helper (TreeNode root, TreeNode target, int cur){
		if (root == target) {
			if (cur < min) {
				min = cur;
				cnt = 1;
			}else if (cur == min) cnt ++;
			return;
		}
		helper (root.left, target, cur + 1);
		helper (root.right, target, cur + 1);
	}
}
