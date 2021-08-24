package com.bridgelabz.gamblingsimulator;

public class GamblingSimulator {
	static final int TOTALSTAKE = 100;
	static final int BET = 1;	
	
	private static boolean GamblingGame() {
		int i = (int) Math.floor(Math.random()*10)%2;
		if(i == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	public static void main(String[] args) {
		
		System.out.println("Starting with stake of $100 and betting $1 every game");
		boolean win = GamblingGame();
		if(win) {
			System.out.println("Gmabler has won the game");
		}
		else {
			System.out.println("Gambler has lost the game");
		}
		
	}

}
