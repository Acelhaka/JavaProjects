
import java.util.Random;
public class WumpusWorld extends Square {

	Random random = new Random();
	
	private String [] [] gameboard = new String[4][4];
	
	private int humanX = 3;
	private int humanY = 0;

	private int goldX = random.nextInt(gameboard.length);
	private int goldY = random.nextInt(gameboard.length);

	private int wumpusX;
	private int wumpusY;

	private int pitX;
	private int pitY;

	/** Create a default constructor */
	// public WumpusWorld(){
	// }

	/** Create a constructor that creates a two dimensional array */

	public WumpusWorld() {
		initializeArray();
		
		gameboard[humanX][humanY] = getHuman();

		while (humanPositionIsTaken(goldX, goldY) == true) {
			goldX = generateRandomNumber();
			goldY = generateRandomNumber();
		}

		gameboard[goldX][goldY] = getGold();

		boolean uniquePosition = false;

		do {

			wumpusX = generateRandomNumber();
			wumpusY = generateRandomNumber();

			if (humanPositionIsTaken(wumpusX, wumpusY) == true) {
				uniquePosition = false;
			}

			else if (goldX == wumpusX && goldY == wumpusY) {
				uniquePosition = false;
			}

			else {
				uniquePosition = true;
			}

		} while (uniquePosition == false);

		gameboard[wumpusX][wumpusY] = getWumpus();

		positionEl(wumpusX, wumpusY, getStench());

		int i = 0;
		while (i < 3) {

			do {

				pitX = generateRandomNumber();
				pitY = generateRandomNumber();
			
				if (humanPositionIsTaken(pitX, pitY) == true) {
					uniquePosition = false;
				}

				else if (goldX == pitX && goldY == pitY) {
					uniquePosition = false;
				} else if (wumpusX == pitX && wumpusY == pitY) {
					uniquePosition = false;
				} else if (gameboard[pitX][pitY].indexOf('P') >= 0) {
					uniquePosition = false;
				}else {
					uniquePosition = true;
				}
				               
				             

			} while (uniquePosition == false);

			gameboard[pitX][pitY] += getPit();
			positionEl(pitX, pitY, getBreeze());
			i++;
		}

	}

	public void displayGameBoard() {

		for (int i = 0; i < gameboard.length; i++) {
			for (int j = 0; j < gameboard[i].length; j++) {

				System.out.printf("%10s", gameboard[i][j]);
				System.out.print(" | ");
			}

			System.out.println();

		}
	}

	public void displayHumanState() {
		
		System.out.println("Human is in position:");
		System.out.println("Row = " + humanX);
		System.out.println("Column = " + humanY);
					
	}

	public int generateRandomNumber() {
		int randomNum = random.nextInt(gameboard.length);
		return randomNum;
	}

	public boolean humanPositionIsTaken(int x, int y) {
		boolean humanPosition = false;
		if (x == humanX && y == humanY) {
			humanPosition = true;
		}
		return humanPosition;
	}

	public void initializeArray() {
		for (int i = 0; i < gameboard.length; i++) {
			for (int j = 0; j < gameboard[i].length; j++) {
				gameboard[i][j] = " ";
			}
		}

	}

	public void positionEl(int X, int Y, String method) {
		if (X == 0 && Y == 0) {
			gameboard[X][Y + 1] += method;
			gameboard[X + 1][Y] += method;
		}

		else if (X == 3 && Y == 3) {
			gameboard[X][Y - 1] += method;
			gameboard[X - 1][Y] += method;

		}

		else if (X == 0 && Y == 3) {
			gameboard[X][Y - 1] += method;
			gameboard[X + 1][Y] += method;
		}

		else if (X == 3 && Y == 0) {

			gameboard[X][Y + 1] += method;
			gameboard[X - 1][Y] += method;

		}

		else if (X == 3 && Y < 3) {
			gameboard[X][Y - 1] += method;
			gameboard[X][Y + 1] += method;
			gameboard[X - 1][Y] += method;

		} else if (X == 0 && Y < 3) {
			gameboard[X][Y - 1] += method;
			gameboard[X][Y + 1] += method;
			gameboard[X + 1][Y] += method;
		}

		else if (X > 0 && Y == 3) {
			gameboard[X][Y - 1] += method;
			gameboard[X - 1][Y] += method;
			gameboard[X + 1][Y] += method;
		}

		else if (X > 0 && Y == 0) {

			gameboard[X][Y + 1] += method;
			gameboard[X - 1][Y] += method;
			gameboard[X + 1][Y] += method;

		}

		else {
			gameboard[X][Y - 1] += method;
			gameboard[X][Y + 1] += method;
			gameboard[X - 1][Y] += method;
			gameboard[X + 1][Y] += method;
		}
	}

	public void moveHumanNorth() {
		gameboard[humanX][humanY]=
				gameboard[humanX][humanY].replace("H", "");
		
		humanX = humanX - 1;
		gameboard[humanX][humanY] += getHuman();
		
	}

	public void moveHumanEast() {
		
		gameboard[humanX][humanY]=
				gameboard[humanX][humanY].replace("H", "");
		humanY = humanY + 1;
		gameboard[humanX][humanY] += getHuman();

	}

	public void moveHumanSouth() {
		gameboard[humanX][humanY]=
				gameboard[humanX][humanY].replace("H", "");
		humanX = humanX + 1;
		gameboard[humanX][humanY] += getHuman();
	}

	public void moveHumanWest() {
		gameboard[humanX][humanY]=
				gameboard[humanX][humanY].replace("H", "");
		humanY = humanY - 1;
		gameboard[humanX][humanY] += getHuman();
	}

}


	
