/*
 * 
 * This class has been abandoned
 * Codes are here for reference only
 * 
 * log in method and registration will be moved to ...User classes
 * 
 */


package WorkPackage;

import java.io.*;
import java.util.*;

public class logIn {

	static Scanner userInputInt = new Scanner(System.in); 
	static Scanner userInputString = new Scanner(System.in); 
	static Scanner userInputDouble = new Scanner(System.in);

	String firstName;
	String lastName;
	String userName;
	String emailAddress;
	int phoneNumber;
	String password;
	String [] favorites;

	static int newUserID = readEmailList().length;

	public void logInSystem () {
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

	public void logInWithEmail () {

		/*
		 * Read the permRegistration file
		 * Create a whole bunch of registeredUser objects
		 * 
		 * Take user input
		 * 
		 * If == admin code -> then do admin stuff
		 * Else -> search perm database and compare
		 * 
		 * Successful 
		 * -> change logInStatus to TRUE
		 * -> use a reader to parse his data from text file 
		 *  
		 *  if unsuccessful, try 0 -> 1. After 3 tries, exit the system.
		 */

		
		/*
		 * for (int i = 0; i < newUserID; i++) {
			String userName = "user" + newUserID;
			logIn user = new logIn ();

		}
		 */





		System.out.println("You picked choice 1: login with email adress and password.");

		int loginAttempts = 3;
		while(loginAttempts > 0) {

			System.out.print("Enter your email adress: ");
			String entered_email = userInputString.nextLine();

			System.out.print("Enter your password: ");
			String entered_password = userInputString.nextLine();

			int userIndex = checkLogIn(entered_email, entered_password); // is -1 if user not verified

			if (userIndex != (-1)) {
				String name = getName (userIndex);
				System.out.println("--------------------------------------------------------");
				System.out.println("Welcome "+ name + "!");
			}
			else if (userIndex == (-1)) {
				System.out.println("Email/password incorrect. Please try again!");
				loginAttempts--;
			}
			System.out.println("You have "+ loginAttempts + " login attempts left.");	
			System.out.println("");
		}

		/// to check email and password we could use this? We just need to create the arrays in the main that hold the private arrays
		//public int LoginMethod(String entered_email, String entered_password){ //returns the ID if login correct
		//for (i=0; i <= email.length; i++){	
		//if(email[i].equals(entered_email) && password[i].equals(entered_password)){ //
		//Login Success:
		//System.out.println("--------------------------------------------------------");
		//System.out.println("Welcome "+ firstName + " " + lastName);
		//return(UserID);
		//}
		//else return(-1); //this will let the main method now that there is no match.
		//}
	}

	public static void guestOption () {
		/*
		 * Proceed to the next steps
		 */
	}

	public void register () {
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

		int userID = newUserID;
		newUserID++;

		boolean logInStatus = false; // reserved for any possible future use

		String line = (email + "\t" + password + "\t" + firstName + "\t" + lastName + 
				"\t" + phoneNumber + "\t" + userID + "\t" + logInStatus);

		appendFileTemp(line); // store in temp file, awaiting admin approval
	}	// end register()

	public int checkLogIn (String email, String password) {

		int h = readEmailList().length;
		String[] emailList = new String [h];
		String[] passwordList = new String [h];

		for (int i = 0; i < h; i++) { // create local arrays of email and password
			emailList [i] = readEmailList()[i];
			passwordList [i] = readPasswordList()[i];			
		}

		// look for email
		int userIndex = -1;
		boolean emailFound = false;
		for (int i = 0; i < h; i++) {
			if (email.equals(emailList[i])) {
				userIndex = i;
				emailFound = true;
				break;
			}
		}

		// compare password
		boolean userVarified = false;
		if (emailFound) {
			if (password.equals(passwordList[userIndex])) {
				userVarified = true;
			}
		}

		if (userVarified) {
			return userIndex;
		}
		else {
			return -1;
		}
	} // end checkLogIn()

	public static String[] readEmailList(){ 

		// Determine how many lines are there in the database
		int countlines = 0;			
		try {
			BufferedReader br1 = new BufferedReader (new FileReader ("permRegistration.txt"));

			while ((br1.readLine()) != null) {
				countlines++;
			}
			br1.close();

		} catch (IOException ex) {
			System.out.println ("Something went wrong for I/O!");
		}

		String[] emailList = new String [countlines];
		String[] passwordList = new String [countlines];

		try {
			String textline; // stores a line of text from the reader function
			String[] uCurrent = new String [2]; // to store elements of textline
			BufferedReader br2 = new BufferedReader (new FileReader ("permRegistration.txt"));

			int i = 0;				
			while ((textline = br2.readLine()) != null) {					
				uCurrent = textline.split("\t"); // uCurrent [0] is email; [1] password; 
				//[2]first name; [3] last name; [4] phone; [5] userID [6] logInStatus
				emailList[i] = uCurrent [0];
				passwordList[i] = uCurrent [1];			
				i++;
			}
			br2.close();

		}	catch (IOException ex) {
			System.out.println ("Something went wrong for I/O!");
		}

		return emailList;
	}

	public static String[] readPasswordList(){ 

		// Determine how many lines are there in the database
		int countlines = 0;			
		try {
			BufferedReader br1 = new BufferedReader (new FileReader ("permRegistration.txt"));

			while ((br1.readLine()) != null) {
				countlines++;
			}
			br1.close();

		} catch (IOException ex) {
			System.out.println ("Something went wrong for I/O!");
		}

		String[] passwordList = new String [countlines];

		try {
			String textline; // stores a line of text from the reader function
			String[] uCurrent = new String [2]; // to store elements of textline
			BufferedReader br2 = new BufferedReader (new FileReader ("permRegistration.txt"));

			int i = 0;				
			while ((textline = br2.readLine()) != null) {					
				uCurrent = textline.split("\t"); // uCurrent [0] is email; [1] password; 
				//[2]first name; [3] last name; [4] phone; [5] userID [6] logInStatus
				passwordList[i] = uCurrent [1];			
				i++;
			}
			br2.close();

		}	catch (IOException ex) {
			System.out.println ("Something went wrong for I/O!");
		}

		return passwordList;
	}

	// This method takes the index of a verified user and returns its name
	public static String getName (int userIndex){ 

		int countlines = 0;			
		try {
			BufferedReader br1 = new BufferedReader (new FileReader ("permRegistration.txt"));

			while ((br1.readLine()) != null) {
				countlines++;
			}
			br1.close();

		} catch (IOException ex) {
			System.out.println ("Something went wrong for I/O!");
		}

		String[] nameList = new String [countlines];

		try {
			String textline; // stores a line of text from the reader function
			String[] uCurrent = new String [2]; // to store elements of textline
			BufferedReader br2 = new BufferedReader (new FileReader ("permRegistration.txt"));

			int i = 0;				
			while ((textline = br2.readLine()) != null) {					
				uCurrent = textline.split("\t"); // uCurrent [0] is email; [1] password; 
				//[2]first name; [3] last name; [4] phone; [5] userID [6] logInStatus
				nameList[i] = uCurrent [2] + " " + uCurrent [3];			
				i++;
			}
			br2.close();

		}	catch (IOException ex) {
			System.out.println ("Something went wrong for I/O!");
		}

		return nameList[userIndex];
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
