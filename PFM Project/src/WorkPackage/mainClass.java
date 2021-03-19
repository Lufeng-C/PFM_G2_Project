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
		
		// creates user & car objects
		
	
		userList = registeredUser.createObjects(); 
		carArrayList = unregisteredUser.readCarList();
		    	
		
		
		// go to the first menu (and subsequent ones from there)
		unregisteredUser.beginMenu(userList);

	}

	public static ArrayList<car> getCarArrayList() {
		return carArrayList;
	}

	public static ArrayList<registeredUser> getUserList() {
		return userList;
	}

	public static void setUserList(ArrayList<registeredUser> userList) {
		mainClass.userList = userList;
	}

	public static void setCarArrayList(ArrayList<car> carArrayList) {
		mainClass.carArrayList = carArrayList;
	}

}


