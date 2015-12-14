package FB;

import java.util.*;

public class LRUCache {
	private class Node{
        int val, key;
        Node pre, next;
        public Node(int key, int value){
            this.key = key;
            this.val = value;
        }
    }
    
    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        else {
            moveToEnd(map.get(key));
            return map.get(key).val;
        }
    }
    
    public void set(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() == capacity){
                map.remove(head.key);
                remove(head);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToEnd(newNode);
        }else{
            map.get(key).val = value;
            moveToEnd(map.get(key));
        }
    }
    
    public void moveToEnd(Node node){
        if (tail == null) return;
        remove(node);
        addToEnd(node);
    }
    
    public void remove(Node node){
        if (head  == node){
            head = head.next;
            if (head != null) head.pre = null;
        }else if (tail == node){
            tail = tail.pre;
            tail.next = null;
        }else{
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }
    
    public void addToEnd(Node node){
        if (head == null) {
        	head = node;
            tail = node;
        }
        else {
        	node.pre = tail;
            tail.next = node;
            tail = node;
        }
    }
    
    public static void main (String args[]){
    	LRUCache lru = new LRUCache(1);
    	lru.set(2, 1);
    	System.out.println(lru.get(2));
    	lru.set(3, 2);
    	System.out.println(lru.get(2));
    }
}
