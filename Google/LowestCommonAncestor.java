package Google;

public class LowestCommonAncestor {
	public TreeNode lowestCommon(TreeNode p, TreeNode q){
		int hp = height(p);
		int hq = height(q);
		if (hp > hq) return lowestCommon(q, p);
		int dif = hq - hp;
		
		while (dif > 0){
			q = q.parent;
		}
		
		while (p != null && q != null){
			if (p == q) return p;
			q = q.parent;
			p = p.parent;
		}
		
		return null;
	}
	
	public int height (TreeNode node){
		if (node == null) return 0;
		return Math.max(height(node.left), height(node.right)) + 1;
	}
}
