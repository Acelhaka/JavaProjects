//**************************************************************//
//                         Project1                             //
//                    Amarilda Celhaka                          //
//Date: 9/10/2018                                               //  
//This project a user pick a player and plays against the       //
//computer which randomly generates a number for its player     //
//After each iteration, statistics of the game are displayed    //
//**************************************************************//


import java.util.Scanner;

public class Hunter_Bear_Ninja {
	
	public static void main(String[] args) {
		
		System.out.println("This is a Hunter-Bear-Ninja Game\n");
		
		// create a scanner object
		Scanner input = new Scanner(System.in);
		
		 String choice,
				userPick, 
				computerPick, 
				previousPick = "";  //to keep track of last user pick 

		 	int wins = 0, 
				ties = 0, 
				gamesPlayed = 0;

		boolean valid = true, 		//for input validation
				lost = false;		//to check when the user lost to manipulate 
									//the next computer pick

		
		// first do-while loop is to ask the user for another game
		do {
			
			
			// this do-while loop is for input validation
			do {
				
				System.out.println("Pick a player: ");
				System.out.println("Hunter (H)\nBear (B)\nNinja (N)");

				userPick = input.next();
				userPick = userPick.toUpperCase();

				switch (userPick) {
				
				case "H":
					System.out.println("You picked the Hunter");
					valid = true;
					break;
					
				case "B":
					System.out.println("You picked the Bear");
					valid = true;
					break;
					
				case "N":
					System.out.println("You picked the Ninja");
					valid = true;
					break;
					
				default:
					System.out.println("Error: Invalid Status");
					valid = false;
				}

			} while (valid == false);

			
			//to manipulate the computer choice
			if (lost == false) {
				computerPick = computerChoice();
			} 
			else {
				computerPick = manipulatedComputerChoice(previousPick);
			}
			
			System.out.println();
			

			// Comparing who will win over the other
			//and counting the number of wins and ties
			if (userPick.equals(computerPick)) {
				System.out.println("EVEN");
				ties++;
			} 
			else if (userPick.equals("H")) {
				if (computerPick.equals("B")) {
					System.out.println("YOU WON!");
					System.out.println("HUNTER shoots the BEAR");
					wins++;
					lost = false;
				} 
				else if (computerPick.equals("N")) {
					System.out.println("YOU LOST!");
					lost = true;
				}
			}
			else if (userPick.equals("B")) {
				if (computerPick.equals("H")) {
					System.out.println("YOU LOST!");
					lost = true;
					}
				else if (computerPick.equals("N")) {
					System.out.println("YOU WON!");
					System.out.println("BEAR eats NINJA");
					wins++;
					lost = false;
				}
			} 
			else if (userPick.equals("N")) {
				if (computerPick.equals("H")) {
					System.out.println("YOU WON!");
					System.out.println("NINJA kills the HUNTER");
					wins++;
					lost = false;
				}
				else if (computerPick.equals("B")) {
					System.out.println("YOU LOST!");
					lost = true;
				}
			}
			
			previousPick = userPick;
			gamesPlayed++;

			// calling the method to display statistics
			statistics(gamesPlayed, wins, ties);

			System.out.println("\nWould you like to play again(Y/N)?");
			choice = input.next();
			choice = choice.toUpperCase();
			
			//validating the user input if is not N n or Y y
			while (!(choice.equals("Y") || choice.equals("N"))) {
				System.out.println("Invalid choice!\nRe-enter the choice: ");
				choice = input.next();
				choice = choice.toUpperCase();
			}
			previousPick = userPick;

		} while (choice.toUpperCase().equals("Y"));

		input.close();
		
		System.out.println("You exit the game!\nThank you for playing!");
	}

	
	
	/*This methods generates three random numbers and assigns each 
	  number to a specific player                                  */
	public static String computerChoice() {
		String computerChoice = null;
		
		// Generate 3 random numbers
		int randomNumber = 1 + (int) (Math.random() * 3);

		// assigning each value of a random number to a player
		if (randomNumber == 1) {
			computerChoice = "H";
			System.out.println("Computer picked the Hunter");
		} else if (randomNumber == 2) {
			computerChoice = "B";
			System.out.println("Computer picked the Bear");
		} else if (randomNumber == 3) {
			computerChoice = "N";
			System.out.println("Computer picked the Ninja");
		}
		return computerChoice;
	}
	
	
	

	/* This method is used to display statistics
	 *  number of games, loses, wins and ties    */
	public static void statistics(int games, int win, int tie) {

		System.out.println("\n************STATISTICS**************");
		System.out.println("Number of games   Wins  Losts   Ties");
		System.out.println(games + "                  " + win + "     " + (games - win - tie) + "      " + tie);

	}

	
	
	/* this method is to used to favor the computer player
	 * It will keep track of the last move of the player and 
	 * check if with the last move the user won or not
	 * In case it loses it will call the below method which 
	 * makes the computer player pick a possible winning player */
	public static String manipulatedComputerChoice(String previousPick) {
		String computerChoice = "";
		if (previousPick.equals("H")) {
			computerChoice = "B";
			System.out.println("Computer picked the Bear");
		} 
		else if (previousPick.equals("B")) {
			computerChoice = "N";
			System.out.println("Computer picked the Ninja");
		} 
		else {
			computerChoice = "H";
			System.out.println("Computer picked the Hunter");
		}
		return computerChoice;
	}

}
