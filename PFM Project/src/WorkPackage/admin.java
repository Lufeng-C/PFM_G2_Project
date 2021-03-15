package WorkPackage;

import java.io.*;
import java.util.*;

public class admin { //registeredUser{			
	
	static Scanner userInputInt = new Scanner(System.in); 
		static Scanner userInputString = new Scanner(System.in); 
		static Scanner userInputDouble = new Scanner(System.in);
		
		private final static String adminID = "adminPFM";
		private final static String password = "admin";

		

	 public static void adminMenu () {
		 
		 	carOperations carOpsDriver = new carOperations();
		 	carOpsDriver.main();			//creating instance of class Main (from Abdannor)
		 
		 	System.out.println("\n-----------------------------");
			System.out.println("ADMIN MAIN MENU");
			System.out.println("-----------------------------");
			System.out.println("\nWelcome Admin! What would you like to do today?");
			System.out.println("\nYou have 3 choices:");
			System.out.println("Choose 1 for operations concerning Users");
			System.out.println("Choose 2 for operations concerning Cars");
			System.out.println("Choose 3 for logging out as Admin");
			System.out.print("\nWhat would you want to choose? ");
	 
			int adminchoice = userInputInt.nextInt();
			
			switch (adminchoice) {
			case 1:
				opsUser();
				break;
			case 2:
				carOpsDriver.run(); //call Main class to execute
				break;
			case 3:
				adminLogout();
				break;
			}
	 }
	 
	 
	 
	 // CHOICE 1 userOverview
	 //Method for approving users, removing them from the system or simply viewing the list of options
	
	 public static void opsUser() {
		 
		  	//choices for userOverview 
		 	System.out.println("\n-----------------------------");
			System.out.println("USER OPERATIONS!");
			System.out.println("-----------------------------");
			System.out.println("\nYou have 3 choices:");
			System.out.println("Choose 1 to approve registered users");
			System.out.println("Choose 2 to view the list of registered users");
			System.out.println("Choose 3 to remove a user from the list");
			System.out.println("\nChoose 0 to return to the Admin Main Menu");
			System.out.print("\nWhat would you want to choose? ");
		
			int adminchoice = userInputInt.nextInt();
			
			switch (adminchoice) {
			case 0: 
				adminMenu();
				break;
			case 1:
				approveUsers();
				break;
			case 2:
				viewUsers();
				break;
			case 3:
				removeUsers();
				break;
			}
	 }
			


//METHODS FOR CHOICE 1: Approve Users, viewUsers and removeUsers

		public static void approveUsers () {
		
			System.out.println("\nThis method allows user approval");
			
//TODO		read data from temp file, while loop for each noOfusers in tempRegistration.txt ask admin: would you like to approve user: *first_name*, *second_name*
			//remove line from temp file
			//then transfer approved users to permRegistration.txt
			
			
			//
			System.out.print("\n\nWould you like to perform another User operation? Enter: 1: Yes || 2: No (return to Admin Menu): ");
			int adminchoice = userInputInt.nextInt();

			switch (adminchoice) {
			case 1: 
				opsUser();
			case 2:
				adminMenu();
				break;
			}
		}	

		public static void viewUsers () {
			
			System.out.println("\nThis method allows viewing users");		
		
//TODO		//print list of PermRegistration.txt
			
			
			
			System.out.print("\n\nWould you like to perform another User operation? Enter: 1: Yes || 2: No (return to Admin Menu): ");
			int adminchoice = userInputInt.nextInt();

			switch (adminchoice) {
			case 1: 
				opsUser();
			case 2:
				adminMenu();
				break;
			}
		}
	
	
		public static void removeUsers () {
			
			System.out.println("\nThis method allows user removal");
		
//TODO		//print list of PermRegistration.txt and allow admin to remove a line.
			
			
			
			System.out.print("\n\nWould you like to perform another User operation? Enter: 1: Yes || 2: No (return to Admin Menu): ");
			
			int adminchoice = userInputInt.nextInt();

			switch (adminchoice) {
			case 1: 
				opsUser();
			case 2:
				adminMenu();
				break;
			}
		}
	
	public static void adminLogout() {
		
		System.out.println("\nThanks for your time Admin. You have now been logged out!");
		System.out.println("Have a great day!");
		
		//Go To login first method
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		admin.adminMenu();
		
	    
	}
}


