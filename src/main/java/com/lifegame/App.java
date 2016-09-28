package com.lifegame;

public class App {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		int dimension = 10;
	
		LifeCreator life = new LifeCreator(dimension,dimension);
		life.createLife();
		
		//to create method which stops the thread when results are the same for two iterations
		for (int i = 0; i < dimension; i++){
			Thread.sleep(700);
			life.evolve();
		}
		
	}
}
