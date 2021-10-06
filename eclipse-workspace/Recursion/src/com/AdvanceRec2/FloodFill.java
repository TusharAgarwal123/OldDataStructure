package com.AdvanceRec2;

public class FloodFill {

	/*
	 * we have a 2D matrix we have to go to bootom right from to top left. but there
	 * are some obstacle in the grid denoted by 1.we can't travel from 1. and we can
	 * go in 4 direction i.e top,bottom,left,right.
	 */

	public static void main(String[] args) {

		int maze[][] = { { 0, 0, 0, 1, 0 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 0 } };

		boolean visit[][] = new boolean[5][5];

		floodFill(maze, 0, 0, "", visit);

	}

	public static void floodFill(int[][] maze, int row, int col, String psf, boolean visit[][]) {

		if (row < 0 || col < 0 || row >= maze.length || col >= maze.length || maze[row][col] == 1
				|| visit[row][col] == true) {
			return;
		}

		if (row == maze.length - 1 && col == maze.length - 1) {
			System.out.println(psf);
			return;
		}

		visit[row][col] = true;

		floodFill(maze, row - 1, col, psf + "t", visit); // top
		floodFill(maze, row, col - 1, psf + "l", visit); // left
		floodFill(maze, row + 1, col, psf + "b", visit); // bottom
		floodFill(maze, row, col + 1, psf + "r", visit); // right

		// visit[row][col]=false; //it is backtracting,it will print all possible ways.

	}

}
