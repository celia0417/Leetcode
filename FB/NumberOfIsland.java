package FB;


public class NumberOfIsland {
	private int max = 0;
	private int count = 0;
	public int numOfIslandPart1(int[][] grid) {
		if (grid.length == 0)
			return 0;

		int m = grid.length, n = grid[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == max) {
					dfs(grid, i, j);
					count++;
				}else if (grid[i][j] > max){
					max = grid[i][j];
					count = 0;
				}
			}
		}
		return count;
	}

	public void dfs(int[][] grid, int x, int y) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < max) {
			return;
		}
		if (grid[x][y] > max){
			max = grid[x][y];
			count = 0;
			return;
		}
		if (grid[x][y] == 0) {
			return;
		}
		grid[x][y] = 0;
		dfs(grid, x - 1, y);
		dfs(grid, x + 1, y);
		dfs(grid, x, y - 1);
		dfs(grid, x, y + 1);
	}
	
	public static void main(String args[]) {
		NumberOfIsland nm = new NumberOfIsland();
		int [][] grid = new int[][] { 
			{ 1, 2, 1, 3, 1, 0 }, 
			{ 1, 2, 0, 3, 0, 1 }, 
			{ 1, 1, 1, 0, 3, 1 },
			{ 0, 1, 0, 3, 3, 0 } };
		System.out.println(nm.numOfIslandPart1(grid));
//		System.out.println(nm.numOflake(grid));
	}
}
