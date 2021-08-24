package com.bridgelabz.gamblingsimulator;

public class GamblingSimulator {
	static final int TOTALSTAKE = 100;
	static final int BET = 1;	
	static int stake = TOTALSTAKE;
	static final int TOTALDAYS = 20;
	static int finalAmount  = 0;
	static int amountLost = 0;
	static int amountGained =0;
	private static int TotalAmount() {
		int days = 0;
		while(days < TOTALDAYS) {
		stake = TOTALSTAKE;
		finalAmount += playGame(stake);
		days++;
		}
		return finalAmount;
	}
	
	
	private static int playGame (int currentStake) {
		int maxLimit = TOTALSTAKE + TOTALSTAKE / 2;
		int minLimit = TOTALSTAKE - TOTALSTAKE / 2;
		while(currentStake > minLimit && currentStake < maxLimit) {
			currentStake = GamblingGame(currentStake);
		}
		return currentStake;
	}
	
	private static int GamblingGame(int currentStake) {
		int i = (int) Math.floor(Math.random()*10)%2;
		if(i == 0) {
			System.out.println("Gambler has lost the game");
			amountLost += 1;
			return currentStake-1;
			
		}
		else {
			System.out.println("Gambler has won the game");
			amountGained += 1;
			return currentStake+1;
		}
	}

	public static void main(String[] args) {
		
		System.out.println("Starting with stake of $100 and betting $1 every game");
		
		stake = playGame(stake);
		finalAmount = TotalAmount();
		System.out.println("Final Amount" + finalAmount);
		System.out.println("Amount lost : "+ amountLost+" Amount Gained : "+ amountGained);
	}

}
