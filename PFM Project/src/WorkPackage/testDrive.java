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
		
	}

}
