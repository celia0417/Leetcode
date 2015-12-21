
class TrieNode {
    boolean isEnd;
    TrieNode[] children = new TrieNode [26];
    // Initialize your data structure here.
    public TrieNode() {
        isEnd = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
        	if (node.children[word.charAt(i) - 'a'] == null){
                TrieNode t = new TrieNode();
        		node.children[word.charAt(i) - 'a'] = t;
        	}
            node = node.children[word.charAt(i) - 'a'];
        }
        node.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            if (node.children[word.charAt(i) - 'a'] != null){
                node = node.children[word.charAt(i) - 'a'];
            }else{
                return false;
            }
        }
        return node.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++){
            if (node.children[prefix.charAt(i) - 'a'] != null){
                node = node.children[prefix.charAt(i) - 'a'];
            }else{
                return false;
            }
        }
        return true;
    }
    
    public static void main (String args[]){
    	Trie trie = new Trie();
    	trie.insert("app");
    	trie.insert("apple");
    	System.out.println(trie.startsWith("apps"));
    	System.out.println(trie.startsWith("app"));
    }
}
