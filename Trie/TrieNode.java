package Trie;

public class TrieNode {
    // Initialize your data structure here.
	public TrieNode [] children;
	public boolean isEnd;
	
    public TrieNode() {
    	this.isEnd = false;
        this.children = new TrieNode[26];
    }  
}