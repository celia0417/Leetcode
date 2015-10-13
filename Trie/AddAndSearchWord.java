package Trie;

public class AddAndSearchWord {
	private TrieNode root = new TrieNode();;

	// Adds a word into the data structure.
	public void addWord(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			if (node.children[word.charAt(i) - 'a'] == null) {
				node.children[word.charAt(i) - 'a'] = new TrieNode();
			}
			node = node.children[word.charAt(i) - 'a'];
		}
		node.isEnd = true;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return recursiveSearch(word,root);
	}

	public boolean recursiveSearch(String word, TrieNode root) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			Character w = word.charAt(i);
			if (w == '.') {
				String str = word.substring(i + 1, word.length());
				for (TrieNode n : node.children){
					if(n != null)
						if (recursiveSearch(str, n))
							return true;
				}
				return false;
			} else if (node.children[w - 'a'] == null)
				return false;
			else
				node = node.children[w - 'a'];
		}
		return node.isEnd;
	}
	
	public static void main (String args[]){
		AddAndSearchWord asw = new AddAndSearchWord();
		asw.addWord("abs");
		System.out.println(asw.search("..."));
	}
}
