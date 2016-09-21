package game;

public class Creator {

private boolean[][] cells;

public Creator() {
	int row,col,peer;
	int world = 10;
	
	int[][] points = {{5,5},{5,6},{5,7}};
	cells = new boolean[world][world];
	
	for (row = 0; row < world; row ++) {
		cells[row] = new boolean[world] ;
	}
	
	for (peer = 0; peer < points.length; peer++) {
		row = points[peer][0];
		col = points[peer][1];
		cells[row][col] = true;
	}
	
}


public void next() {

	int world = 0;
	world=cells.length;
	boolean[][] tempCells = new boolean [world] [world]; 

	for(int i=0; i<world; i++) {
		for( int j=0; j<world; j++ ) {
			tempCells[i][j] = cells[i][j];
		}
	} 
  
	for (int row = 0; row < cells.length ; row++) {
	    for (int col = 0 ; col < cells[row].length ; col++) {
	    	if ( neighbours(row, col) > 3  ||  neighbours(row, col) < 2 ) {
	    		tempCells[row][col] = false;
	    	}
	    	else if (neighbours(row, col) == 3 ) {
	    		tempCells[row][col] = true;
	    	}      
	    }
	}
	
	cells = tempCells;
}


public int neighbours (int row, int col) {
	
	int acc=0;
	
	for ( int i = row -1; i <= row + 1 ; i++) {
		for (int j = col -1 ; j <= col + 1 ; j++) {
			try {
				if (cells[i][j]==true && (i != row || j!=col)) {
				acc++;
				}          
			} catch (ArrayIndexOutOfBoundsException f) {
				continue;
			}
		}
	}
	
	return acc;
}

@Override
public String toString() {
	String result = "";

	for (int row = 0; row < cells.length; row ++) {
		final boolean[] column = cells[ row ];
			for (int col = 0; col < column.length; col ++) {
				result = result + (column[ col ] ? " O " : " . ");
			}
		result = result + "\n";
	}
	
	return result;
}

}