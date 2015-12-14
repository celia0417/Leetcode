package Google;

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			if (node.children[word.charAt(i) - 'a'] == null) {
				node.children[word.charAt(i) - 'a'] = new TrieNode();
			}
			node = node.children[word.charAt(i) - 'a'];
		}
		node.isEnd = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode node = root;
		for (Character w : word.toCharArray()) {
			if (node.children[w - 'a'] == null)
				return false;
			else
				node = node.children[w - 'a'];
		}
		return node.isEnd;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode node = root;
		for (Character w : prefix.toCharArray()) {
			if (node.children[w - 'a'] == null)
				return false;
			else
				node = node.children[w - 'a'];
		}
		return true;
	}

	public int height() {
		TrieNode node = root;
		return dfs(node, 0);
	}

	int max = 0;

	public int dfs(TrieNode node, int max) {
		if (node == null)
			return 0;
		int temp = max;
		for (TrieNode child : node.children) {
			max = Math.max(dfs(child, temp) + 1, max);
		}
		return max;
	}

	public static void main(String args[]) {
		Trie trie = new Trie();
		trie.insert("somestring");
		trie.insert("somewhere");
		trie.insert("abcdefghijklmnop");
		System.out.println(trie.height());
		System.out.println(trie.startsWith("some"));
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
