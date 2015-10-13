package Tree;

public class VerifyPreorderSequence {
	public boolean verifyPreorder(int[] preorder) {
        return verify(preorder, 0, preorder.length-1);
    }
    
    public boolean verify(int[] preorder, int left, int right){
        if (left > right) return true;
        int target = preorder[left];
        int index = lookup (preorder, target,left+1,right);
        boolean leftSide = verify (preorder, left+1, index-1);
        boolean rightSide = verify (preorder, index, right);
        return leftSide && rightSide;
    }
    
    public int lookup (int[] preorder, int target, int left, int right){
        for (int i = left; i <= right; i ++){
            if (preorder[i] > target){
                return i;
            }
        }
        return -1;
    }
}
