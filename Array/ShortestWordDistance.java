package Array;

public class ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
		int p1 = -1, p2 = -1;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i] == word1) {
				p1 = i;
			} else if (words[i] == word2) {
				p2 = i;
			}
			res = Math.min(res, Math.abs(p1 - p2));
		}
		return res;
	}
}
