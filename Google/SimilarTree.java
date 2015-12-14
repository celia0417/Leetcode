package Google;

public class SimilarTree {
	public boolean isSimilarTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && (isSimilarTree(p.left, q.left) && isSimilarTree(p.right, q.right)
        		|| (isSimilarTree(p.left, q.right) && isSimilarTree(p.right, q.left)));
    }
	
	public static void main (String args[]){
		SimilarTree st = new SimilarTree();
//		st.isSimilarTree();
	}
}
