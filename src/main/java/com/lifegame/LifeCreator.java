package com.lifegame;

import java.util.Arrays;

public class LifeCreator {

	private int row;
	private int column;
	public int counter = 0;

	public int[][] matrix, tempMatrix;
//	public static int[][] points = { { 8, 2 }, { 8, 3 }, { 3, 6 }, { 2, 6 }, { 4, 6 }, { 3, 5 }, { 2, 5 }, { 4, 5 }, { 6, 8 } };
	public static int[][] points = { { 8, 2 }, { 8, 3 }, { 8, 4 }};
//	public static int[][] points = { { 9, 3 }, { 9, 4 }, { 9, 5 }};
//	public static int[][] points = {{5,4},{6,4},{7,4},{8,4}};
	
	public LifeCreator(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public void createLife() {
		int rows = this.row;
		int columns = this.column;
		
		matrix = new int[rows][columns];
		tempMatrix = new int[rows][columns];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = 0;
				tempMatrix[i][j] = 0;
			}
		}
		
//		for (int i = 0; i<10; i++){
//			Arrays.fill(matrix[0], 0);
//			Arrays.fill(tempMatrix[0], 0);
//		}
		
		int a,b;
		for (int x = 0; x < points.length; x++) {
			a = points[x][0];
			b = points[x][1];

			matrix[a][b] = 1;
			counter = counter+1;
		}
		displayMatrix(matrix);	

	}

	
	public void evolve(){
		
		int[][] contents = new int[counter][2];
	    int step = 0;
		
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
		
//		for (int i = 0; i < tempMatrix.length; i++) {
//		    for (int j = 0; j < tempMatrix[i].length; j++) {		    	
//		    	if ((tempMatrix[i][j] == 0) && (countNeighbours(i,j) == 3)){
//					
//					tempMatrix[i][j] = 1; //Empty cell with three neighbours becomes populated
//				}
//		    }
//		}
    		
		
		
		
		
		
		
//		if (tempMatrix[a][b] <= 1) {
//		tempMatrix[a][b] = 0; //Each cell with one or no neighbours dies
//	}
//	else if (tempMatrix[a][b] >= 4){
//		tempMatrix[a][b] = 0; //Each cell with four or more neighbours dies
//	}
//	else if ((tempMatrix[a][b] == 2) || (tempMatrix[a][b] == 3)){
//		tempMatrix[a][b] = 1; //Each cell with two or three neighbours survives
//	}
		
//		for (int i = 0; i < matrix.length; i++) {
//		    for (int j = 0; j < matrix[i].length; j++) {
//		    	if (matrix[i][j] == 1) {  
//			    	contents[step][0] = i;
//			    	contents[step][1] = j;  	
//			    	step = step + 1;
//		    	}
//		    }
//		  }

//		System.out.println("content length:"+contents.length);
//		for (int inputSize = 0; inputSize < 10; inputSize++) {
//			
//			int a = contents[inputSize][0] -1;
//			int b = contents[inputSize][1] -1;
//
//			System.out.println(a + "," + b);
//			
//			try{
//			tempMatrix[a][b] = countNeighbours(a, b);
//			System.out.println(contents[inputSize][0] + "," + contents[inputSize][1] + "has" + countNeighbours(contents[inputSize][0], contents[inputSize][1]) +"neighb");
//			}
//			catch (ArrayIndexOutOfBoundsException e) {
//				continue;
//			}
//			
//			
//			if (tempMatrix[a][b] <= 1) {
//				tempMatrix[a][b] = 0; //Each cell with one or no neighbours dies
//			}
//			else if (tempMatrix[a][b] >= 4){
//				tempMatrix[a][b] = 0; //Each cell with four or more neighbours dies
//			}
//			else if ((tempMatrix[a][b] == 2) || (tempMatrix[a][b] == 3)){
//				tempMatrix[a][b] = 1; //Each cell with two or three neighbours survives
//			}
//		}
		
//		for (int i = 0; i < 10; i++){
//			for (int j = 0; j < 10; j++){	
//				System.out.println(i + "," + j + "has" + countNeighbours(i, j) +"neighb1");
//				if ((tempMatrix[i][j] == 0) && (countNeighbours(i,j) == 3)){
//					
//					tempMatrix[i][j] = 1; //Empty cell with three neighbours becomes populated
//				}
//			}
//		}
//		System.out.println("MATRIX");
//		displayMatrix(matrix);
//		System.out.println();
//		System.out.println("TEMP");
		displayMatrix(tempMatrix);
		matrix = tempMatrix;
		
	}

	public int countNeighbours(int row, int column) {

		int count = 0;

		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = column - 1; j <= column + 1; j++)
				try {
					if ((i != row || j != column) && (matrix[i][j] == 1)) {
							count++;}}
					catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}

		}
//		System.out.println("\nrow:" + row + ", column:" + column + " has " + count + " neighb.");
		return count;
	}
	
	private void displayMatrix(int[][] matrixName) {

		int[][] grid = matrixName;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
