package Square;

public class WordPuzzle{
	
	private class Node {
		char c;
		int w;
		Node fail;
		Node [] s = new Node [26];
		
	}
	
	Node root;
	int len, ny, nx, n, i, face;
	int t[][] = {{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1}};
	
	void buildTree(Node h, int k){
		if (k == len) {
			h.w = i;
			return;
		}
		if (h.s[str.charAt(k) - 'A'] == null){
			
		}
	}
}