package Snapchat;

import java.util.*;


public class TreeMap<K, V> {

	TreeNode root = null;
	private final Comparator<? super K> comparator;

	public TreeMap() {
		root = null;
		comparator = null;
	}

	public TreeMap(Comparator<? super K> comparator) {
		this.comparator = comparator;
	}

	static class Entry<K, V> {
		K key;
		V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	class TreeNode {
		K key;
		V val;
		TreeNode left, right;

		public TreeNode(K key, V val) {
			this.key = key;
			this.val = val;
		}
	}
	// public TreeMap(Comparator<? super K> comparator){
	// this.comparator = comparator;
	// }

	public void put(K key, V value) {
		if (root == null) {
			root = new TreeNode(key, value);
		} else {
			TreeNode cur = root;
			TreeNode parent = null;
			Comparator<? super K> cpr = comparator;

			while (cur != null && cur.key != key) {
				parent = cur;
				cur = cpr.compare(cur.key, key) < 0 ? cur.right : cur.left;
			}
			if (cur != null && cur.key == key) { // has node with same key
				cur.val = value;
			} else {
				TreeNode newNode = new TreeNode(key, value);
				if (cpr.compare(newNode.key, parent.key) < 0) {
					parent.left = newNode;
				} else {
					parent.right = newNode;
				}
			}
		}
	}

	public V get(K key) {
		TreeNode cur = root;
		Comparator<? super K> cpr = comparator;

		while (cur != null) {
			if (cur.key.equals(key)) {
				return cur.val;
			}
			cur = cpr.compare(cur.key, key) < 0 ? cur.right : cur.left;
		}
		throw new IllegalArgumentException();
	}

	public boolean containsKey(K key) {
		TreeNode cur = root;
		Comparator<? super K> cpr = comparator;

		while (cur != null) {
			if (cur.key.equals(key)) {
				return true;
			}
			cur = cpr.compare(cur.key, key) < 0 ? cur.right : cur.left;
		}
		return false;
	}
	
	public static void main(String args[]){
		TreeMap<Integer, String> tree = new TreeMap<>();
		tree.put(2, "c");
		tree.put(1, "celia");
		System.out.println(tree.get(1));
		
	}
}
