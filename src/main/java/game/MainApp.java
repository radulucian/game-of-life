package game;

public class MainApp {

public static void main( String[] args ) {
  
	Creator generation = new Creator();
  
	for (int i = 0; i <= 2; i++) {
	    System.out.println(generation.toString());
	    generation.next();
	}	
}

}