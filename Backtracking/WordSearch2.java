package Backtracking;

import java.util.*;

import Trie.Trie;

public class WordSearch2 {
	List<String> res = new ArrayList<String>();

	public List<String> findWords(char[][] board, String[] words) {
		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}
		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				findSingle(board, visited, "", i, j, trie);
			}
		}

		return new ArrayList<String>(res);
	}

	public void findSingle(char[][] board, boolean[][] visited, String str, int i, int j, Trie trie) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j])
			return;

		str += board[i][j];

		if (!trie.startsWith(str))
			return;

		if (trie.search(str))
			res.add(str);

		visited[i][j] = true;
		findSingle(board, visited, str, i - 1, j, trie);
		findSingle(board, visited, str, i + 1, j, trie);
		findSingle(board, visited, str, i, j - 1, trie);
		findSingle(board, visited, str, i, j + 1, trie);
		visited[i][j] = false;
	}

	public static void main(String args[]) {
		WordSearch2 ws2 = new WordSearch2();
		char board[][] = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
				// char board [][] ={{'a','a'}};

		// String words[] = {"a"};
		String words[] = { "oath", "pea", "eat", "rain" };
		List<String> res = ws2.findWords(board, words);
		for (String s : res) {
			System.out.println(s);
		}
	}
}
