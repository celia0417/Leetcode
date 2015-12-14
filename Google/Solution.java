package Google;

public class Solution {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.print(solution.countPattern());
	}
	
	public int countPattern() {
		int[] visited = new int[10];
		int[] pattern = new int[10];
		pattern[0] = 0;
		int[] res = new int[1];
		int[] len = new int[1];
		count(pattern, 1, visited, res, len);
		return res[0];
	}

	private void count(int[] pattern, int pos, int[] visited, int[] res, int[] len) {
		if (pos == 10) return;
		for (int i = 1; i < 10; i++) {
			if (visited[i] == 0) {				
				if (i + pattern[pos - 1] == 10) {visited[5] ++; len[0] ++;}
				if ((i == 1 && pattern[pos - 1] == 3) || (i == 3 && pattern[pos - 1] == 1)) {visited[2] ++; len[0] ++;}
				if ((i == 3 && pattern[pos - 1] == 9) || (i == 9 && pattern[pos - 1] == 3)) {visited[6] ++; len[0] ++;}
				if ((i == 7 && pattern[pos - 1] == 9) || (i == 9 && pattern[pos - 1] == 7)) {visited[8] ++; len[0] ++;}
				if ((i == 1 && pattern[pos - 1] == 7) || (i == 7 && pattern[pos - 1] == 1)) {visited[4] ++; len[0] ++;}
				len[0] ++;
				if (len[0] >= 4) {
					res[0] ++;
					if (pos >= 3 && pattern[pos - 1] == 5 && i + pattern[pos - 2] == 10) res[0] --;
//					if (pos >= 3 && pattern[pos - 1] == 2 && i == + pattern[pos - 2] == 10) res[0] --;
				}
				visited[i] ++;
				pattern[pos] = i;
				count(pattern, pos + 1, visited, res, len);
				pattern[pos] = 0;
				visited[i] --;
				if (i + pattern[pos - 1] == 10) {visited[5] --; len[0] --;}
				if ((i == 1 && pattern[pos - 1] == 3) || (i == 3 && pattern[pos - 1] == 1)) {visited[2] --; len[0] --;}
				if ((i == 3 && pattern[pos - 1] == 9) || (i == 9 && pattern[pos - 1] == 3)) {visited[6] --; len[0] --;}
				if ((i == 7 && pattern[pos - 1] == 9) || (i == 9 && pattern[pos - 1] == 7)) {visited[8] --; len[0] --;}
				if ((i == 1 && pattern[pos - 1] == 7) || (i == 7 && pattern[pos - 1] == 1)) {visited[4] --; len[0] --;}
				len[0] --;
			}
		}
	}
}
