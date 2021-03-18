package WorkPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class testDrive {

	static Scanner userInputInt = new Scanner(System.in); 
	static Scanner userInputString = new Scanner(System.in); 
	static Scanner userInputDouble = new Scanner(System.in);
	/*
	 * The main method is located here for testing
	 */

	public static void main(String[] args) {

		ArrayList<registeredUser> userList = new ArrayList<registeredUser>();

		userList = registeredUser.createObjects(); // creates the user objects from 
		// permRegistration.txt and store them in userList



		unregisteredUser.beginMenu(userList);


		/*
		 * SO= upon entering the system, in the main class the user gets offered three options:
		 * 1. login -> enters the login method. So if login == successful -> we store a value = true, which gives you access to addfavourites after recommendation.
		 * 2. register -> enter the register method
		 * 3. continue as guest -> move straight to recommendation. 
		 * 
		 * Recommendation System starts here
		 * 1. ...
		 * ..
		 * 3. if logInStatus == true, you can access add favourite function
		 */


	}
}




