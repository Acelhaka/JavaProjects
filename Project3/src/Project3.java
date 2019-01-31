
import java.util.Scanner;

public class Project3 {

	public static void main(String[] args) {
		
		/** Main method  */
		System.out.println("*******************Project 3*********************\n");
		Scanner input = new Scanner(System.in);
		
		WumpusWorld game = new WumpusWorld();
		game.displayHumanState();
		String moves;
		
		boolean gameOver = true;
		menu();
		game.displayGameBoard();
		System.out.println("\n");
		
	while(gameOver) {
			System.out.println("Choose the direction you would like to move (N/S/E/W) or C:");
			moves = input.next();
			moves = moves.toUpperCase();
			
			switch(moves) {
					
				case "N" :
					game.moveHumanNorth();
					break;
				case "S" :
					game.moveHumanSouth();
					break;
				case "E" :
					game.moveHumanEast();
					break;
				case "W":
					game.moveHumanWest();
					break;
				case "C":
					game.displayGameBoard();
					break;
				default:
					System.out.println("Your selection was invalid");
			}
			
			
			
			game.displayGameBoard();
			
			game.displayHumanState();
			
		}
		game.displayGameBoard();
		System.out.println();
		
	}
	
	public static void menu() {
		System.out.println("Human player aiming for thr gold.");
		System.out.println("If there is a breeze close to you, be careful from the pits, they might be pretty close");
		System.out.println("Wumpus is also surronded by stenches, stay away from them.");
		System.out.println("You can move North(N), South(S), East(E) and West(W) to get to the gold");
		System.out.println("You can also get a little help by choosing C (Cheat) to display the gameboard\n\n");
		
	}
}


