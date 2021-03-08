package WorkPackage;

import java.io.*;
import java.util.*;

public class logIn {

	static Scanner userInputInt = new Scanner(System.in); 
	static Scanner userInputString = new Scanner(System.in); 
	static Scanner userInputDouble = new Scanner(System.in);

	public static void logInSystem () {
		/*
		 * 0. Prompt welcome message, ask to choose from
		 * 1. Log in
		 * 2. Register new user
		 * 3. Continue as guest
		 */

		System.out.println("-----------------------------");
		System.out.println("Welcome to the car rec system.");
		System.out.println("-----------------------------");
		System.out.println("You have 3 choices");
		System.out.println("Choose 1 to log in");
		System.out.println("Choose 2 to register as a new user");
		System.out.println("Choose 3 to continue as guest");
		System.out.println("What would you want to choose?");

		int Choice = userInputInt.nextInt();
		switch (Choice) {
		case 1:
			logInWithEmail();
			break;
		case 2:
			register();
			break;
		case 3:
			guestOption();
			break;
		}
	}

	public static void logInWithEmail () {
		/*
		 * Take user input
		 * 
		 * If == admin code -> then do admin stuff
		 * Else -> search perm database and compare
		 * 
		 * Successful 
		 * -> change logInStatus to TRUE
		 * -> use a reader to parse his data from text file 
		 * -> create member object and give proper attributes
		 *  
		 */
	}

	public static void guestOption () {
		/*
		 * Proceed to the next steps
		 */
	}

	public static void register () {
		// ask for input and send to tempRegistration.txt

		System.out.print("Welcome to register process!\nPlease type relevant info when prompted.\n");

		System.out.print("Your email address (used for log in): ");
		String email = userInputString.nextLine();	

		System.out.print("Your password: ");
		String password = userInputString.nextLine();		

		System.out.print("Your first name: ");
		String firstName = userInputString.nextLine();	

		System.out.print("Your last name: ");
		String lastName = userInputString.nextLine();

		System.out.print("Your phone number: ");
		String phoneNumber = userInputString.nextLine();		

		int userID = (int) (Math.random() * 10000);

		boolean logInStatus = false; // reserved for any possible future use

		String line = (email + "\t" + password + "\t" + firstName + "\t" + lastName + 
				"\t" + phoneNumber + "\t" + userID + "\t" + logInStatus);

		appendFileTemp(line); // store in temp file, awaiting admin approval
	}	

	public static void appendFileTemp (String line) { 

		try {
			PrintWriter wr1 = new PrintWriter ( new BufferedWriter (new FileWriter("tempRegistration.txt", true)));
			wr1.println(line);
			wr1.close();

		} catch (IOException ex) {
			System.out.println ("Something went wrong for I/O!");
		}
	}



	// Reserved for when admin approves registration
	// To remove line from temp and add line in perm
	public static void removeLineTemp (String line) { 

	}

	public static void appendFilePerm (String line) { 

		try {
			PrintWriter wr2 = new PrintWriter ( new BufferedWriter (new FileWriter("permRegistration.txt", true)));
			wr2.println(line);
			wr2.close();

		} catch (IOException ex) {
			System.out.println ("Something went wrong for I/O!");
		}
	}



} // end class
