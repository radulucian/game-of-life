package com.lifegame;

public class LifeCreator {

	private int row;
	private int column;

	public int[][] matrix, tempMatrix;
//	public static int[][] points = { { 8, 2 }, { 8, 3 }, { 3, 6 }, { 2, 6 }, { 4, 6 }, { 3, 5 }, { 2, 5 }, { 4, 5 }, { 6, 8 } };
	public static int[][] points = { { 8, 2 }, { 8, 3 }, { 8, 4 }};
	
	public LifeCreator(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public void createLife() {
		int rows = this.row;
		int columns = this.column;
		
		matrix = new int[row][column];
		tempMatrix = new int[row][column];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = 0;
				tempMatrix[i][j] = 0;
			}
		}

		for (int x = 0; x < points.length; x++) {
			int a = points[x][0] - 1;
			int b = points[x][1] - 1;

			matrix[a][b] = 1;
		}

		displayMatrix(matrix);	
	}

	
	public void evolve(){
		
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){	
				if (countNeighbours(i,j) == 3){
					tempMatrix[i-1][j-1] = 1; //Empty cell with three neighbors becomes populated
				}
			}
		}
		
		
		for (int inputSize = 0; inputSize < points.length; inputSize++) {
			int a = points[inputSize][0] - 1;
			int b = points[inputSize][1] - 1;

			tempMatrix[a][b] = countNeighbours(points[inputSize][0], points[inputSize][1]);
			
			if (tempMatrix[a][b] <= 1) {
				tempMatrix[a][b] = 0; //Each cell with one or no neighbors dies
			}
			else if (tempMatrix[a][b] >= 4){
				tempMatrix[a][b] = 0; //Each cell with four or more neighbors dies
			}
			else if ((tempMatrix[a][b] == 2) || (tempMatrix[a][b] == 3)){
				tempMatrix[a][b] = 1; //Each cell with two or three neighbors survives
			}
		}
		
		displayMatrix(tempMatrix);
		matrix = tempMatrix;
		
	}

	public int countNeighbours(int row, int column) {

		int count = 0;

		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = column - 1; j <= column + 1; j++)
				if (i != row || j != column)
					try {
						if (matrix[i - 1][j - 1] == 1)
							count++;
					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}

		}
//		System.out.println("\nrow:" + row + ", column:" + column + " has " + count + " neighb.");
		return count;
	}
	
	private void displayMatrix(int[][] matrixName) {
		
		int rows = this.row;
		int columns = this.column;
		int[][] grid = matrixName;
		
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(grid[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}

}