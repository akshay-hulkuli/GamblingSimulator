package com.bridgelabz.gamblingsimulator;

public class GamblingSimulator {
	static final int TOTALSTAKE = 100;
	static final int BET = 1;	
	static final int TOTALDAYS = 30;
	static final int TOTALMONTHS = 12;
	static int stake = TOTALSTAKE;
	static int luckiestMonth = 0;
	static int unluckiestMonth = 0;
	static int finalAmount  = 0;
	static int amountLost = 0;
	static int amountGained =0;
	static int daysWon = 0;
	static int daysLost = 0;
	
	
	private static void monthlyReport() {
		int months = 0;
		int maxGain = 0;
		int minGain = Integer.MAX_VALUE;
		while(months < TOTALMONTHS) {
			amountPerMonth();
			System.out.println("Month "+(months+1)+" Report :");
			System.out.println("Final Amount : " + finalAmount);
			System.out.println("Number of days won : "+daysWon);
			System.out.println("Number of days lost : "+daysLost);
			System.out.println("Amount lost : "+ amountLost+" Amount Gained : "+ amountGained);
			System.out.println();			
			if(finalAmount > maxGain) { 
				maxGain  = finalAmount;
				luckiestMonth = months;
			}
			if(finalAmount < minGain) {
				minGain = finalAmount;
				unluckiestMonth = months; 
			}
			finalAmount = 0; amountLost =0; amountGained = 0; daysLost = 0; daysWon = 0; 
			months++;
		}
		System.out.println("LuckiestMonth : "+(luckiestMonth+1) +" UnluckiestMonth : "+ (unluckiestMonth+1));
	}
	
	private static void amountPerMonth() {
		int days = 0;
		while(days < TOTALDAYS) {
		stake = TOTALSTAKE;
		int gainOrLose =  playGame(stake);
//		if(gainOrLose == TOTALSTAKE - TOTALSTAKE / 2 && unluckiestDay == 0) unluckiestDay = days;
//		if(gainOrLose == TOTALSTAKE + TOTALSTAKE / 2 && luckiestDay == 0) luckiestDay = days;
		finalAmount += gainOrLose;
		days++;
		}
		
	}
	
	
	private static int playGame (int currentStake) {
		int maxLimit = TOTALSTAKE + TOTALSTAKE / 2;
		int minLimit = TOTALSTAKE - TOTALSTAKE / 2;
		while(currentStake > minLimit && currentStake < maxLimit) {
			currentStake = GamblingGame(currentStake);
		}
		if(currentStake == minLimit) daysLost++;
		else daysWon++;
		return currentStake;
	}
	
	private static int GamblingGame(int currentStake) {
		int i = (int) Math.floor(Math.random()*10)%2;
		if(i == 0) {
			amountLost += 1;
			return currentStake-1;
		}
		else {
			amountGained += 1;
			return currentStake+1;
		}
	}

	public static void main(String[] args) {
		
		System.out.println("Starting with stake of $100 and betting $1 every game");
			
		monthlyReport();
		
	}

}
