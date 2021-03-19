package WorkPackage;

import java.io.*;
import java.util.*;

public class mainClass {

	static Scanner userInputInt = new Scanner(System.in); 
	static Scanner userInputString = new Scanner(System.in); 
	static Scanner userInputDouble = new Scanner(System.in);
	static ArrayList<car> carArrayList;
	static ArrayList<registeredUser> userList;
	
	public static void main(String[] args) {
		
		/*
		 *  creates user & car objects
		 *  
		 * TODO !!! These arrayLists should be updated after relevant admin operations
		 * 
		 */
	
		userList = registeredUser.createObjects(); 
		carArrayList = unregisteredUser.main();
		
		
		// go to the first menu (and subsequent ones from there)
		unregisteredUser.beginMenu(userList);


	}
}




