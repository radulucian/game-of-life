package com.lifegame;

public class LifeCreator {

	private int row;
	private int column;

	public int[][] matrix, tempMatrix;
	public static int[][] points = { { 8, 2 }, { 8, 3 }, { 3, 6 }, { 2, 6 }, { 4, 6 }, { 3, 5 }, { 2, 5 }, { 4, 5 }, { 6, 8 } };
//	public static int[][] points = { { 5, 2 }, { 1, 3 }, { 5, 4 }};
	
	public LifeCreator(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int[][] createLife() {
		int rows = this.row;
		int columns = this.column;
		
		matrix = new int[rows][columns];
		
		for (int size = 0; size < points.length; size++) {
			matrix[points[size][0]][points[size][1]] = 1;
		}
		
		displayMatrix(matrix);
		
		return matrix;
	}

	public int[][] evolve(){
		
		tempMatrix = new int[this.row][this.column];
		

		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[i].length; j++) {
		    	if (matrix[i][j] == 1) {  
		    		tempMatrix[i][j] = countNeighbours(i, j);
		    	}
		    }
		}
		
		
		for (int i = 0; i < tempMatrix.length; i++) {
		    for (int j = 0; j < tempMatrix[i].length; j++) {
		    	if (tempMatrix[i][j] <= 1) {
					tempMatrix[i][j] = 0; //Each cell with one or no neighbours dies
				}
				else if (tempMatrix[i][j] >= 4){
					tempMatrix[i][j] = 0; //Each cell with four or more neighbours dies
				}
				else if ((tempMatrix[i][j] == 2) || (tempMatrix[i][j] == 3)){
					tempMatrix[i][j] = 1; //Each cell with two or three neighbours survives
				}
		    	if ((tempMatrix[i][j] == 0) && (countNeighbours(i,j) == 3)){
					tempMatrix[i][j] = 1; //Empty cell with three neighbours becomes populated
				}
		    }
		}

		
		matrix = tempMatrix;
		displayMatrix(matrix);
		
		return matrix;
		
	}
	
	public int countNeighbours(int row, int column) {

		int count = 0;
		
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = column - 1; j <= column + 1; j++)
				try {if (i != row || j != column)
						if (matrix[i][j] == 1)
						count++;
					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}
		}
		return count;
	}
	
	private void displayMatrix(int[][] matrixName) {

		int[][] grid = matrixName;
		String transform,buffer;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				buffer = Integer.toString(grid[i][j]);
				
				if (grid[i][j] == 1) {
					transform = buffer.replace("1","O");
				}
				else{
					transform = buffer.replace("0",".");
				}
				
				System.out.print(transform + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
