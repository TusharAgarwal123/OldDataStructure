package co.tushar.graph;

//leet code problem
public class NoOfIslands {

	public static void main(String[] args) {

		char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '0', '1', '1' },
				{ '1', '0', '1', '0', '0' } };

		System.out.println(numOfIslands(grid));

	}

	public static int numOfIslands(char[][] grid) {

		boolean[][] vis = new boolean[grid.length][grid[0].length];

		int noOfIslands = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1' && !vis[i][j]) {
					noOfIslands++;
					dfs_gcc(grid, vis, i, j);
				}
			}
		}
		return noOfIslands;
	}

	public static void dfs_gcc(char[][] grid, boolean[][] vis, int row, int col) {

		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0'
				|| vis[row][col] == true) {
			return;
		}

		vis[row][col] = true;

		dfs_gcc(grid, vis, row + 1, col);
		dfs_gcc(grid, vis, row, col + 1);
		dfs_gcc(grid, vis, row - 1, col);
		dfs_gcc(grid, vis, row, col - 1);

	}

}
