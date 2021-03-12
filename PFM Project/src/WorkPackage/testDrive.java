package WorkPackage;

import java.util.*;

public class testDrive {

	/*
	 * The main method is located here for testing
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList <registeredUser> userList = registeredUser.createObjects();

		for (int i = 0; i < 5; i++) {
			System.out.println(userList.get(i).emailAddress);
		}

		System.out.println(registeredUser.logIn(userList));

		/*
		 * SO= upon entering the system, in the main class the user gets offered three options:
		 * 1. login -> enters the login method. So if login == successful -> we store a value = true, which gives you access to addfavourites after recommendation.
		 * 2. register -> enter the register method
		 * 3. continue as guest -> move straight to recommendation. 
		 * 
		 * Recommendation System starts here
		 * 1. ...
		 * ..
		 * 3. if logInStatus == true, you can access add favorate function
		 */


	}

}



