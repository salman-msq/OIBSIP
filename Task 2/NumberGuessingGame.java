package game;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		title();
		game();

	}
	
	static int score = 0;
	static int easy = 0;
	static int hard = 0;
	
	public static void title() {
		System.out.println("\n******************************************");
		System.out.println("********** NUMBER GUESSING GAME **********");
		System.out.println("********* Numbers Range: 1 - 100 *********");
		System.out.println("****** Presented By MOHAMMAD SALMAN ******");
		
	}
	
	public static void game() {
		while (true) {
			menu();
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			
			if (choice == 1) {
				play();
			} else if (choice == 2) {
				score();
			} else if (choice == 3) {
				inst();
			} else if (choice == 4) {
				exit();
				break;
			} else {
				System.out.println("\nPlease enter the valid choice.");
			}
		}
	}

	public static void menu() {
		System.out.println("******************************************");
		System.out.println("\n1. Play\n2. Score\n3. Instructions\n4. Exit");
	}
	
	public static void play() {
		
		while (true) {
			System.out.println("******************************************");
			subMenu();
			
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			
			if (choice == 1) {
				int secretNum = randomNumber();
				int attempt = 1;
				
				while (true) {
					
					System.out.println("\nAttempt: " + attempt);
					System.out.print("Enter your guess (1 - 100): ");
					int guess = sc.nextInt();
					
					if (guess > 100 || guess < 1) {
						System.out.println("\nGuess is out of range.");
					} else if (guess > secretNum) {
						System.out.println("\nGuess is higher.");
						attempt++;
					} else if (guess < secretNum) {
						System.out.println("\nGuess is lower.");
						attempt++;
					} else {
						System.out.println("\nCongartulations! You guessed the number in " + attempt + " attempts.");
						if (attempt <= 4) {
							System.out.println("You won 30 points.");
							score += 30;
						} else if (attempt <= 10) {
							System.out.println("You won 20 points.");
							score += 20;
						} else {
							System.out.println("You won 10 points.");
							score += 10;
						}
						
						easy++;
						return;
					}
				}
				
			} else if (choice == 2) {
				int secretNum = randomNumber();
				int maxAttempts = 3;
				int noAttempts = 0;
				
				while (noAttempts < maxAttempts) {
					System.out.println("\nAttempts remaining: " + (maxAttempts - noAttempts));
					System.out.print("Enter your guess (1 - 100): ");
					int guess = sc.nextInt();
					
					if (guess > 100 || guess < 1) {
						System.out.println("\nGuess is out of range.");
						continue;
					} else if (guess > secretNum) {
						System.out.println("\nGuess is higher.");
					} else if (guess < secretNum) {
						System.out.println("\nGuess is lower.");
					} else {
						System.out.println("\nCongartulations! Your guess is correct.");
						System.out.println("You won 50 points.");
						hard++;
						score += 50;
						return;
					}
					
					noAttempts++;
				}
				
				System.out.println("\nSorry! You have 0 attempts remaining.");
				System.out.println("You cannot further guess the number.");
				System.out.println("You lose 20 points.");
				hard++;
				score -= 20;
				return;
				
			} else if (choice == 3) {
				game();
			} else {
				System.out.println("\nPlease enter the valid choice.");
			}
		}
		
	}
	
    public static void score() {
		System.out.println("\nNumber of times game played:");
		System.out.print("Easy: " + easy);
		System.out.println("\t\tHard: " + hard);
		System.out.println("\nScore: " + score);
	}
    
    public static void subMenu() {
    	System.out.println("\n1. Easy\n2. Hard\n3. Back");
    }
    
    public static int randomNumber() {
    	Random rm = new Random();
    	
    	return rm.nextInt(100) + 1;
    }
    
    public static void inst() {
    	System.out.println("\nIntroduction -> Number Guessing Game in which computer generate a sectret number between 1 and 100");
    	System.out.println("\t\tand user/player guesses a number between 1 and 100.");
    	System.out.println("Play -> Player can play the game in either Easy mode or Hard mode.");
    	System.out.println("\tEasy -> In this mode, player has unlimited attempts to guess the number and win the points according");
    	System.out.println("\t\tto the number of attempts, if player takes at most 4 attempts then player win 30 points, if");
    	System.out.println("\t\tplayer takes at most 10 attempts then player win 20 points otherwise 10 points.");
    	System.out.println("\tHard -> In this mode, player has 3 attempts to guess the number and win the 50 points.");
    	System.out.println("\t\tIf player does not guess the number in 3 attempts then 20 points deduct from the score.");
    	System.out.println("Score -> Player can check the score here and number of times game played.");
    	System.out.println("Exit -> Player can exit from the game.");
    }
    
    public static void exit() {
    	System.out.println("\nThank you for playing the \"Number Guessing Game\".");
		System.out.println("**************************************************");
		System.out.println("---------- Presented By MOHAMMAD SALMAN ----------");
		System.out.println("**************************************************");
    }

}
