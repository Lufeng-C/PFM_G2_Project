package WorkPackage;

import java.util.*;

public class testDrive {

	static Scanner userInputInt = new Scanner(System.in); 
	static Scanner userInputString = new Scanner(System.in); 
	static Scanner userInputDouble = new Scanner(System.in);
	/*
	 * The main method is located here for testing
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		System.out.println(registeredUser.logIn(userList));

		System.out.println("-----------------------------");
		System.out.println("Welcome to the car rec system.");
		System.out.println("-----------------------------");
		System.out.println("You have 3 choices");
		System.out.println("Choose 1 to log in");
		System.out.println("Choose 2 to register as a new user");
		System.out.println("Choose 3 to continue as guest");
		System.out.println("What do you want to choose?");

		int Choice = userInputInt.nextInt();
		switch (Choice) {
		case 1:
			registeredUser.logIn(ArrayList<registeredUser> userList);
			break;
		case 2:
			registeredUser.register();
			break;
		case 3:
			unregisteredUser.unregisterUserMethod();
			break;

			ArrayList <registeredUser> userList = registeredUser.createObjects();

			for (int i = 0; i < 5; i++) {
				System.out.println(userList.get(i).emailAddress);
			}

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
}



