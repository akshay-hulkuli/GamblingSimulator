package com.bridgelabz.gamblingsimulator;

public class GamblingSimulator {
	static final int TOTALSTAKE = 100;
	static final int BET = 1;	
	
	private static int GamblingGame(int currentBalance) {
		int i = (int) Math.floor(Math.random()*10)%2;
		if(i == 0) {
			System.out.println("Gambler has lost the game");
			return currentBalance-1;
		}
		else {
			System.out.println("Gambler has won the game");
			return currentBalance+1;
		}
	}

	public static void main(String[] args) {
		
		System.out.println("Starting with stake of $100 and betting $1 every game");
		int currentBalance = TOTALSTAKE;
		currentBalance = GamblingGame(currentBalance);
		
		
	}

}
