package life;

public class LifeCreator {
	
	private int row;
	private int column;
	
	public LifeCreator (int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public void createLife(){
		int rows = this.row;
		int columns = this.column;
		
		int[][] points = {{8,2},{8,3},{3,6},{2,6},{4,6},{3,5},{2,5},{4,5}};
		int[][] array = new int[rows][columns];
		
		for(int i = 0; i<rows; i++) {
		    for(int j = 0; j<columns; j++) {
		        array[i][j] = 0;
		    }
		}
		
		for (int x = 0; x < points.length; x++){
				int a = points[x][0] - 1;
				int b = points[x][1] - 1;
				
				array[a][b] = 1;
		}

		for(int i = 0; i<rows; i++){
			for(int j = 0; j<columns; j++){
		        System.out.print(array[i][j] + " ");
		    }
			System.out.println();
		}
		
		int count = 0;
		row = 3;
		column = 6;
		
	     for(int i = row - 1; i <= row + 1; i++) {    
	    		 for(int j = column - 1; j <= column + 1; j++) 
	    				 if (i != row || j != column)
	    					 try { 
	    						 if (array[i-1][j-1] == 1)
	    							 count++;
	    					 } catch (ArrayIndexOutOfBoundsException f) {
	    						 continue;
	    					 }
	                                
	        }
		System.out.println("\nrow:"+ row + ", column:" + column + " has "+count+" neighb.");
	}
	

}
