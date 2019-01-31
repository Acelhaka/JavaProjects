
		
		/******************************************************************
		 * 																  *
		 * 						Amarilda Celhaka						  *
		 * 					Programming Assignment #4					  *
		 * 					     CMP SCI 2261							  *
		 * 				      Due Date: 10/29/2018						  *
		 * In this programming assignment we will be doing a simulation   *
		 * of multiple humans and dogs. There are 3 classes: Mammal		  *
		 * a superclass, Human and Dog that extends Mammal and a Class to *
		 * Test our simulation. Human has 1-2 dogs, generated randomly.   *
		 * Relation of Human and Dog class is composition, and between    *
		 * Mammal with dogs and human is inheritance					  *
		 * 																  *
		 * ****************************************************************/





import java.util.*;

public class TestOurSimulation {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("*******************Project #4*********************");
		
		int humanNum,				//stores human Number
			dogNum ; 				//to generate Random number of dogs (1-2)
		String humanName,			//Stores human Name
			   moveAgain;			//to ask the user if wants to continue moving any human
				
		
		System.out.print("How many humans would you like to create?");
		humanNum = digitValidation(input);
		humanNum = minAndMaxValueAllowed(1, 100, humanNum, input);
		
		
		/**Create an array list of human objects */
		ArrayList <Human> human = new ArrayList <Human>(humanNum);
		
		for (int i = 0; i < humanNum; i++) {
			
			System.out.println("What is the name of Human " + (i + 1) + " : " );
			humanName = input.next();
			
		
			dogNum = 1 + (int)(Math.random() * 2 );
			
			System.out.println("Human " + humanName + " has " + dogNum  + " dogs");
			
			/**creating an array of dogNames,  the names of dogs for e specific human created, 
			 * and pass it to the human constructor which will call Dog class to create the dogs
			 * with a user input of name choice */
			String [] dogNames = new String[dogNum];
			
			
			/**Prompting the user for the name and sex of each dog that a human owns*/
			for(int j = 0; j < dogNum; j++) {
				
				System.out.println("What is the name of the dog " + (j + 1) );	
				dogNames[j] = input.next();
			
			}
			
			/**Creating a new human, by passing user input of human name, sex and his dogs names and sex*/
			human.add(new Human(humanName, dogNames, dogNum));
			
			
			/**calling toString method of humans, which will the display the human object as well as
			 * a call to the Dog class toString */
			System.out.println(human.get(i).toString());
			System.out.println();
		}
		
		
		
		
		
		
		do {
		
			menu(human, humanNum, input);
			
			/**checking the number of humans left, if 0, terminate the program*/
			if(human.size() == 0){
				System.out.println("There are no more dogs for the humans you created!");
				System.out.println("Humans did not feed or entertain the dogs");
				break;
			}
			
			
			for(int i = 0; i < humanNum; i++){
				
				/**Before each new iteration pass the time will all human objects */
				human.get(i).passTheTime();
				
			}
		
			
		System.out.println("Would you like to move again another human (Y/N)? ");
		moveAgain = input.next();

		/** Calling YandNvalidation() method to validate user input Y or N only */
		moveAgain= YandNvalidation(moveAgain, input);

	} while (moveAgain.toUpperCase().equals("Y"));
	
		
		System.out.println("End of program");
		//to avoid leaks
		input.close();
	}



	
	
/****************************************************************
 *                menu() method									*
 *  This function will display a menu to walk, feed, bathe or   *
 *  buy food for the dog. After each move will check for the    *
 *  loyalty of the dogs. If it has hit zero, it will remove that*
 *  human from the list											*
 *  *************************************************************/
 
		
public static void menu(ArrayList<Human>human, int humanNum, Scanner input) {
	
	int moveHuman;
	String choice;
	System.out.println("\n\n\n");
	System.out.println("Pick a human you would like to move 1-"+ humanNum);
	moveHuman = digitValidation(input);
	moveHuman = minAndMaxValueAllowed(1, humanNum, moveHuman, input) ;
	moveHuman--;
	System.out.println("You picked " + human.get(moveHuman).getName());
	System.out.println("Chooce  action(a/b/c/d): ");
	System.out.println("a)Walk the dog \t\t b)Feed the dog");
	System.out.println("c)Bathe the dog \t d)Buy food for the dog");
	choice = input.next();
	choice = choice.toLowerCase();
	
	
	switch(choice) {
		case "a":
			//walk the dog
			human.get(moveHuman).walkTheDog();
			break;
		case "b":
			//Feed the dog
			human.get(moveHuman).feedTheDog();
			break;
		case "c":
			//Bathe the dog
			human.get(moveHuman).batheTheDog();
			break;
		case "d":
			//Buy food for the dog
			human.get(moveHuman).buyFood();
			break;
		default:
			System.out.println("Invalid choice!");
				
	}
	System.out.println(human.get(moveHuman).toString());
	System.out.println("\n\n");
	
	/**checking if dog is loyal, if not dog run away, remove that human from the list*/
	if(human.get(moveHuman).isDogLoyal() == false) {
		System.out.println("Dog loyalty hit 0!");
		System.out.println("Sorry, but you did not take good care for the dog");
		human.remove(moveHuman);
		humanNum--;
		System.out.println("Humans left are: ");
		System.out.println(human.toString());

	}
	
}





/***************************************************************
 * 	             											   *
 * 				 YandNValidation method 					   *
 * Checks if the user is entering only the characters Y and N  *
 * If mistakenly enters digits, or any other character it      *
 * will display an error message and ask for input again       *
 * 															   *
 * ************************************************************/

public static String YandNvalidation(String userInput, Scanner input) {

	userInput = userInput.toUpperCase();

	while (!(userInput.equals("Y") || userInput.equals("N"))) {
		System.out.println("Invalid choice!\nRe-enter the choice: ");
		userInput = input.next();
		userInput = userInput.toUpperCase();

	}

	return userInput;
}





/***************************************************************
 * 	             											   *
 * 				 digitValidation method 					   *
 * Checks if the user is entering only numbers and if is 	   *
 * mistakenly enters alphabetic, or special characters it      *
 * will display an error message and ask for input again       *
 * 															   *
 * ************************************************************/

public static int digitValidation(Scanner input) {
	
	
	while(!input.hasNextInt() )
	{
		
		System.out.println("ERROR! You input is not a digit");
		input.next();
		
	}
	
	/**storing the correct input at number variable */
	 int number = input.nextInt();
	
	 return number;
 }





/***************************************************************
 * 															   *
 * 				minAndMaxValueAllowed()						   *
 * 	checks if the value entered from the user will be within   *
 * the range, of min-max. If not it will re-ask user for the   *
 * input, when the right value is entered it will return it    *
 * from the function 										   *
 * *************************************************************/

public static int minAndMaxValueAllowed(int min, int max, int number, Scanner input) {
	
	while(number < min || number > max) {
		System.out.println("Your input should be in the range (" + min + " - " + max + ")");
		System.out.println("Re-enter the number");
		number = digitValidation(input);
	}
	
	return number;
 }

}
