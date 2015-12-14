package Microsoft;

import Tree.TreeNode;
import java.util.*;

public class SerializeDeserializeBinaryTree {
	private static final String tag = "null";
    private static final String spliter = ",";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    public void buildString(TreeNode root, StringBuilder sb){
        if (root == null) sb.append(tag).append(spliter);
        else {
            sb.append(root.val).append(spliter);;
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }
    
    public TreeNode buildTree(List<String> nodes){
        String val = nodes.remove(0);
        if (val.equals(tag)) return null;
        else {
        	TreeNode node = new TreeNode(Integer.valueOf(val));
        	node.left = buildTree(nodes);
        	node.right = buildTree(nodes);
        	return node;
        }
    }
    
    public static void main (String args[]){
    	SerializeDeserializeBinaryTree sd = new SerializeDeserializeBinaryTree();
    	TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode third = new TreeNode(5);
		TreeNode forth = new TreeNode(4);

		root.left = left;
		root.right = right;
		left.right = third;
		left.left = forth;
    	System.out.println(sd.serialize(root));
    }
}
