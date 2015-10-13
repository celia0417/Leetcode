package Tree;

public class ConstructTreeInorderPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length-1, 0,postorder.length-1);
    }
    
    public TreeNode build (int[] inorder, int[] postorder, int inL, int inR, int postL, int postR){
        if (inL > inR || postR < postL) 
            return null;
        TreeNode node = new TreeNode (postorder[postR]);
        int inIndex = lookup (inorder, postorder[postR]);
        node.left = build (inorder, postorder, inL, inIndex -1, postL, postL+inIndex-inL-1);
        node.right = build (inorder, postorder, inIndex + 1, inR, postL+inIndex-inL, postR-1);
        return node;
    }
    
    public int lookup (int[] inorder, int target){
        for (int i =0; i < inorder.length; i++){
            if (inorder[i] == target){
                return i;
            }
        }
        return -1;
    }
    
    public static void main (String args[]){
    	ConstructTreeInorderPostorderTraversal ipt = new ConstructTreeInorderPostorderTraversal();
    	int inorder [] = {4,2,7,5,1,3,9};
    	int postorder [] = {4,7,5,2,9,3,1};
    	ipt.buildTree(inorder, postorder);
    }
}
