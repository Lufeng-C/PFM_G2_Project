package WorkPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class testDrive {

	static Scanner userInputInt = new Scanner(System.in); 
	static Scanner userInputString = new Scanner(System.in); 
	static Scanner userInputDouble = new Scanner(System.in);
	private ArrayList<car> carArrayList; //car arraylist
	/*
	 * The main method is located here for testing
	 */

	public static void main(String[] args) {
		
		// creates the user objects from permRegistration.txt and store them in userList
		ArrayList<registeredUser> userList = new ArrayList<registeredUser>();
		userList = registeredUser.createObjects(); 
		
		// go to the first menu (and subsequent ones from there)
		unregisteredUser.main();
		unregisteredUser.beginMenu(userList);

	}
}




