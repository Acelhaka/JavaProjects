
/**************************************************************
 * 			         										  *
 * 					 Amarilda Celhaka						  *
 * 				        Project #2							  *
 * 				        9/26/2018							  *
 * 															  *
 * Writing two classes LinearEquation and TestLinearEquation  *
 * two solve two linear equation, display X and Y and         *
 * output an error message if unsolvable, denominator=0       *
 *                                                            *
 **************************************************************/


import java.util.Scanner;

public class TestLinearEquations {

	public static void main(String[] args) {
		
		/** Main method  */
		System.out.println("***************Project 2****************\n");
		
		
		System.out.println("Enter values from a - e to find  x and y\n"
				+ "x = (ed - bf) / (ad - bc) \n"
				+ "y = (af - ec) / (ad - bc)\n\n");
		
		
		
		/** Create a scanner object */
		Scanner input = new Scanner(System.in);
		
		
		
		/** Defining 5 variables used in equations */
		double a, b, c, d, e, f;
		
		/** choice variable holds the user input Y/N */
		String choice;    
		
		

	
		
		/** do-while loop is used to ask the user if wants to solve another equation */
		do {

			
			/** Prompting the user to input a */
			System.out.println("Enter a:");

			/** Validating user input, calling digitValidation method */
			a = digitValidation(input);

			
			
			
			/** Prompting the user to input b */
			System.out.println("Enter b:");

			/** Validating user input, calling digitValidation method */
			b = digitValidation(input);

			
			
			
			/** Prompting the user to input c */
			System.out.println("Enter c:");

			/** Validating user input, calling digitValidation method */
			c = digitValidation(input);
			
			
			

			/** Prompting the user to input d */
			System.out.println("Enter d:");

			/** Validating user input, calling digitValidation method */
			d = digitValidation(input);

			
			
			
			/** Prompting the user to input e */
			System.out.println("Enter e:");

			/** Validating user input, calling digitValidation method */
			e = digitValidation(input);

			
			
			
			/** Prompting the user to input f */
			System.out.println("Enter f:");

			/** Validating user input, calling digitValidation method */
			f = digitValidation(input);

			
			
			System.out.println("\n");
			
			
			
			/** Create a LinearEquation object and passing user input */
			LinearEquation equation = new LinearEquation(a, b, c, d, e, f);

			
			
			
			/** Displaying equation */
			System.out.println("Your system of two equation: ");
			
			System.out.println(equation.getA() + "x " + "+ " + equation.getB()+"y"+ " = " + equation.getE());
			
			System.out.println(equation.getC() + "x " + "+ " + equation.getD()+"y"+ " = " + equation.getF());
			
			System.out.println("\n");
			
			
			
			/** Checking if the equations are solvable */
			if (equation.isSolvable() == true)
			{
				/** Calling getX() method that returns the solution for X */
				System.out.println("X = " + equation.getX());
				
				/** Calling getY() method that returns the solution for Y */
				System.out.println("Y = " + equation.getY());
				
			}
			
			else
				
			{
				/** Displaying an error message if it is not solvable */
				System.out.println("ERROR! This Equation is undefined.\n" + "The Denominator equals zero.");
			
			}

			
			
			System.out.println("\n");
			
			
			
			/** Prompting the user if wants to solve another equation */
			System.out.println("Would you like to solve another equation (Y/N): ");
			
			choice = input.next();
			
			
			/** Calling YandNvalidation() method to validate user input Y or N only */
			choice = YandNvalidation(choice, input);
			
			

		} while (choice.toUpperCase().equals("Y"));
		
		
		

       input.close();
	
	   System.out.println("End of program.");


	
	}
	
	
	
	
	
	
	
	
/***************************************************************
 * 	             											   *
 * 				 digitValidation method 					   *
 * Checks if the user is entering only numbers and if is 	   *
 * mistakenly enters alphabetic, or special characters it      *
 * will display an error message and ask for input again       *
 * 															   *
 * ************************************************************/

public static double digitValidation(Scanner input) {
	
	
	while(!input.hasNextDouble() )
	{
		
		System.out.println("ERROR! You input is not a digit");
		input.next();
		
	}
	
	/**storing the correct input at number variable */
	 double number = input.nextDouble();
	
	 return number;
 }






/***************************************************************
 * 	             											   *
 * 				 YandNValidation method 					   *
 * Checks if the user is entering only the characters Y and N  *
 * If mistakenly enters digits, or any other character it      *
 * will display an error message and ask for input again       *
 * 															   *
 * ************************************************************/
	
	public static String YandNvalidation(String userInput, Scanner input)
	{
			
			userInput = userInput.toUpperCase();
	
				while (!(userInput.equals("Y") || userInput.equals("N"))) 
				{
					System.out.println("Invalid choice!\nRe-enter the choice: ");
					userInput = input.next();
					userInput = userInput.toUpperCase();
					
				}
				
			
		 return userInput;
	}
	
	
	
	
	
	

}




