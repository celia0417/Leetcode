package Google;

import java.util.*;

public class MorrisInorder {
	public List<Integer> inorder(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		TreeNode cur = root, pre = null;
		while (cur != null) {
			if (cur.left == null){  
				res.add(cur.val);
				cur = cur.right;
			}else{
				pre = cur.left;
				while (pre.right != null && pre.right != cur){
					pre = pre.right;
				}
				if (pre.right == null){
					pre.right = cur;
					cur = cur.left;
				}else{
					pre.right = null;
					res.add(cur.val);
					cur = cur.right;
				}
			}
		}
		return res;
	}
}
