package Zenefits;

import java.util.*;

public class NumsOfIslandModification {
	// This is the text editor interface.
	// Anything you type or change here will be seen by the other person in real
	// time.

	// 1 1 1 1 1 0
	// 1 0 0 1 0 1
	// 1 1 1 0 1 1 part i => 3
	// 0 1 0 1 0 0 part ii => 1

	// part i) count the number of islands, connected clump of 1's
	// part ii) count the number of lakes, (connected clump of 0's completely
	// surrounded by a single island)

	// part 1
	public int numOfIslandPart1(int[][] grid) {
		if (grid.length == 0)
			return 0;

		int m = grid.length, n = grid[0].length;

		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					dfs(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	public void dfs(int[][] grid, int x, int y) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
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

	// part 2
	public int numOflake(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		numOfIsland(grid);
		for (int i = 0; i < grid.length; i++) { // top and bottom
			if (grid[i][0] == 0) {
				openWater(grid, i, 0);
			}
			if (grid[i][grid[0].length - 1] == 0) {
				openWater(grid, i, grid[0].length - 1);
			}
		}
		for (int j = 0; j < grid[0].length; j++) {
			if (grid[0][j] == 0) {
				openWater(grid, 0, j);
			}
			if (grid[grid.length - 1][j] == 0) {
				openWater(grid, grid.length - 1, j);
			}
		}

		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) { // it can not be edge of this matrix
					if (findLake(grid, i, j, grid[i - 1][j])) { // i - 1 > 0
						count++;
					}
				}
			}
		}

		return count;
	}

	public boolean findLake(int[][] grid, int x, int y, int dye) {
		// if(x < 0 || x >= grid.length || y < 0 || y >=grid[0].length){
		// return;
		// }
		if (grid[x][y] != 0) {
			return grid[x][y] == dye ? true : false;
		}
		grid[x][y] = dye;
		boolean left = findLake(grid, x - 1, y, dye);
		boolean right = findLake(grid, x + 1, y, dye);
		boolean up = findLake(grid, x, y - 1, dye);
		boolean down = findLake(grid, x, y + 1, dye);
		return left && right && up && down;
	}

	public void openWater(int[][] grid, int x, int y) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 0) {
			return;
		}
		grid[x][y] = -1;
		openWater(grid, x - 1, y);
		openWater(grid, x + 1, y);
		openWater(grid, x, y - 1);
		openWater(grid, x, y + 1);
	}

	public void numOfIsland(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return;
		}
		int dye = 5;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					dfs(grid, i, j, dye);
					dye++;
				}
			}
		}
		return;
	}

	public void dfs(int[][] grid, int x, int y, int dye) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
			return;
		}

		grid[x][y] = dye;
		dfs(grid, x - 1, y, dye);
		dfs(grid, x + 1, y, dye);
		dfs(grid, x, y - 1, dye);
		dfs(grid, x, y + 1, dye);
	}

	public static void main(String args[]) {
		NumsOfIslandModification nm = new NumsOfIslandModification();
		int [][] grid = new int[][] { { 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 1, 0, 1 }, { 1, 1, 1, 0, 1, 1 },
			{ 0, 1, 0, 1, 0, 0 } };
		System.out.println(nm.numOfIslandPart1(grid));
//		System.out.println(nm.numOflake(grid));
	}
}
