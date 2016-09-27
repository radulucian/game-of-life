package com.lifegame;

public class App {
	
	
	public static void main(String[] args) {
		
		int[][] first,second,third = new int[10][10];
		
		LifeCreator life = new LifeCreator(10,10);
		first = life.createLife();
		second = life.evolve(first);
		third = life.evolve(second);

	}
}
