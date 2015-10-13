package Zillow;

import java.util.Stack;

public class TrenarySearchTree {
	private static Node root;
	public void delete(int value){
		Delete(root, value);
		printTree();
	}
	public Node Delete(Node node, int value) {
		if (node.value > value) {
			node.left = Delete(node.left, value);
		} else if (node.value < value) {
			node.right = Delete(node.right, value);
		} else {
			if (node.middle != null) {
				node.middle = Delete(node.middle, value);
			} else if (node.right != null) {
				int min = minimum(node.right).value;
				node.value = min;
				node.right = Delete(node.right, min);
			} else {
				node = node.left;
			}
		}
		return node;
	}
	public void in(int val){
		insert(root, val);
		printTree();
	}
	public Node insert(Node root, int val) {
		if (root == null)
			return new Node(val);
		if (val < root.value) {
			root.left = insert(root.left, val);
		} else if (val > root.value) {
			root.right = insert(root.right, val);
		} else {
			root.middle = insert(root.middle, val); 
		}
		return root;
	}
	
	public Node minimum(Node node) {
		if (node.left == null)
			return node;
		return minimum(node.left);
	}
	
	public static void printTree(){
		Stack<Node> stack = new Stack<>();
		Node temp = root;
		while (temp != null || !stack.isEmpty()){
			while (temp != null){
				stack.add(temp);
				if (temp.middle != null) stack.add(temp.middle);
				temp = temp.left;
			}
			Node node = stack.pop();
			System.out.println(node.value);
			temp = node.right;
		}
	}
	
	public static void main (String args[]){
		TrenarySearchTree tst = new TrenarySearchTree();
		root = new Node (1);
		Node left = new Node(0);
		Node right = new Node (2);
		root.left = left;
		root.right = right;
		tst.in(1);
	}
}
