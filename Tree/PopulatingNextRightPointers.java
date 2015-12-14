package Tree;

import java.util.*;

public class PopulatingNextRightPointers {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		List<TreeLinkNode> q = new LinkedList<>();
		List<TreeLinkNode> level = new LinkedList<>();
		q.add(root);
		level.add(root);
		TreeLinkNode flag = root;
		while (!q.isEmpty()) {
			TreeLinkNode cur = q.remove(0);
			if (cur == flag) {
				while (!level.isEmpty()) {
					TreeLinkNode node = level.remove(0);
					if (!level.isEmpty())node.next = level.get(0);
					else node.next = null;
				}
			}
			if (cur.left != null) {
				q.add(cur.left);
				level.add(cur.left);
			}
			if (cur.right != null) {
				q.add(cur.right);
				level.add(cur.right);
			}
			if (cur == flag) {
				if (!q.isEmpty()) flag = q.get(q.size() - 1);
			}
		}
	}

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
}
