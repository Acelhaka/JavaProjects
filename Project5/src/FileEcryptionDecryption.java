package src;


		/******************************************************************
		 * 																  *
		 * 						Amarilda Celhaka						  *
		 * 					Programming Assignment #5					  *
		 * 					     CMP SCI 2261							  *
		 * 				      Due Date: 11/25/2018						  *
		 * In this programming assignment we will be asking the user to   *
		 * to enter a key and will encrypt the file byte by byte    	  *
		 * Encrypted file will be saved adding the extension .encrypted	  *
		 * Second part will ask the user for a key to decrypt a file and  *
		 * will save the unecrypted file, with the additional extension	  *
		 * .decrypted													  *
		 * 																  *
		 * ****************************************************************/

import java.util.*;
import java.util.Scanner;
import java.io.*;

public class FileEcryptionDecryption {

	public static void main(String[] args) throws IOException {

		// create a scanner object
		Scanner input = new Scanner(System.in);

		System.out.println("*******************Project #5*********************");

		String choice; // holds the value of the user input if would like to continue
						// encrypting/decrpting files
		int key; // holds the value of the user input for the key

		/** Promt the user for the key */
		System.out.println("\nEnter a key to encrypt files: ");
		key = input.nextInt();

		/** validating key to be only an integer between (-128 and 127)*/
		minAndMaxValueAllowed(-128, 127, key, input);

		do {

			/** Prompt the user for the filename */
			System.out.println("\nEnter the file name you would like to encrypt? ");
			String filename = input.next();

			File originalFile = new File(filename);

			File encryptedFile = new File(filename + ".encrypted");
			File decryptedFile = new File(filename + ".decrypted");

			if (!originalFile.exists()) {
				System.out.println("File does not exists");
				System.exit(1);
			}

			try (

					FileInputStream inputStream = new FileInputStream(originalFile);

					// If the below line in uncommented a new original empty file will be created,
					// with 0 byte
					// FileOutputStream outputStream = new FileOutputStream(originalFile);
					FileOutputStream encryptedOutput = new FileOutputStream(encryptedFile);
					FileInputStream encryptedInput = new FileInputStream(encryptedFile);
					FileOutputStream decryptedOutput = new FileOutputStream(decryptedFile);
					FileInputStream decryptedInput = new FileInputStream(decryptedFile);) {
				int b;
				int count = 0;
				while ((b = inputStream.read()) != -1) {
					count++;
					encryptedOutput.write((byte) (b + key));

				}
				System.out.println("bytes read = " + count);
				int a;
				System.out.println("Contents of  " + encryptedFile + " file are:");

				while ((a = encryptedInput.read()) != -1) {

					System.out.print((char) a);
					decryptedOutput.write((byte) (a - key));

				}

				System.out.println("\n\nWould you like to decrypt the file(Y/N)? ");
				choice = input.next();

				/** Calling YandNvalidation() method to validate user input Y or N only */
				choice = YandNvalidation(choice, input);

				if (choice.equals("Y")) {
					System.out.println("\n");
					System.out.println("\nContents of " + decryptedFile + " file are: ");

					int e;
					while ((e = decryptedInput.read()) != -1) {
						System.out.print((char) e);
					}

				}

			} catch (EOFException ex) {
				System.out.println("All data were read");
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			System.out.println("\n\nWould you like to encrypt/decrypt another file (Y/N): ");

			choice = input.next();

			/** Calling YandNvalidation() method to validate user input Y or N only */
			choice = YandNvalidation(choice, input);

		} while (choice.toUpperCase().equals("Y"));

		System.out.println("\n\nEnd of program");
		input.close(); 

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

}
