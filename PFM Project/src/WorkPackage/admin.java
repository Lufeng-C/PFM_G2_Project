package WorkPackage;

import java.io.*;
import java.util.*;

public class Admin { //extends unregisteredUser{			
	
	static Scanner userInputInt = new Scanner(System.in); 
		static Scanner userInputString = new Scanner(System.in); 
		static Scanner userInputDouble = new Scanner(System.in);
		
		private final static String adminID = "adminPFM";
		private final static String password = "admin";

		

	 public static void adminMenu () {
	 
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
				opsCar();
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


	
	 
	 
	 // CHOICE 2 CAR OPERATIONS
	 //Method for adding Cars to the recommendation System
	 
	 public static void opsCar() {
		 
		  	//choices for addCar 
		 	System.out.println("\n-----------------------------");
			System.out.println("CAR OPERATIONS");
			System.out.println("-----------------------------");
			System.out.println("\nYou have 3 choices:");
			System.out.println("Choose 1 to add a new car to the system");
			System.out.println("Choose 2 to remove a new car from the system");
			System.out.println("Choose 3 to modify a car in the system");
			System.out.println("\nChoose 0 to return to the main menu");
			System.out.print("\nWhat would you want to choose? ");
			
			int adminchoice = userInputInt.nextInt();

			switch (adminchoice) {
			case 0: 
				adminMenu();
			case 1:
				addCar();
				break;
			case 2:
				removeCar();
				break;
			case 3:
				modifyCar();
				break;
			
		}	
	 }
	 
	 
	 
	//all methods concerning cars		
			
		
	public static void addCar () {
				
			System.out.println("\nThis method allows adding cars");
				
				
			System.out.print("\nHow many cars would you like to add? ");
			int noOfCars = userInputInt.nextInt();
				
			for(int i=0; i<noOfCars; i++) {
				//ASK USER ALL CAR DETAILS
				System.out.print("\nWhat is the name of the car? ");
				String carName = userInputInt.next();
				System.out.print("\nWhat is the type of the car? ");
				String carType = userInputInt.next();
//TODO			//create new line which constitutes a car in the file by: carName \t carType \t etc \t
//TODO			//append new line to car file	
			}
			
			
			System.out.print("\n\nWould you like to perform another Car operation? Enter: 1: Yes || 2: No (return to Admin Menu): ");
				int adminchoice = userInputInt.nextInt();
	
				switch (adminchoice) {
				case 1: 
					opsCar();
				case 2:
					adminMenu();
					break;
				}
	}	
		
		
	public static void removeCar () {
			
			System.out.println("\nThis method allows removing cars");
			
			System.out.print("\nHow many cars would you like to remove? ");
			int noOfCars = userInputInt.nextInt();
			
			for(int i=0; i<noOfCars; i++) {
				//ASK NAME OF CAR
				System.out.print("\nWhat is the name of the car you want to remove? ");
				String carName = userInputString.next();
				
			}
				
//TODO			//From car file remove lines that contain carName
//TODO			//As in A3
			
			
			
			System.out.print("\n\nWould you like to perform another Car operation? Enter: 1: Yes || 2: No (return to Admin Menu): ");
				int adminchoice = userInputInt.nextInt();

				switch (adminchoice) {
				case 1: 
					opsCar();
				case 2:
					adminMenu();
					break;
			}
			
		}	
			
			
	public static void modifyCar () {
			System.out.println("\nThis method allows modifying cars");
			
				System.out.println("\nWhat is the name of the car you want to modify? ");
				String carName = userInputString.next();
				
//TODO			//System print line of car file that contains car name, so print all data of the car
				System.out.println("\nWhat details of the car would you want to modify? ");
				String carDetail = userInputString.next();
				
				System.out.println("To what would you like to change " + carDetail + "? ");
				String carDetail2 = userInputString.next();
				
				System.out.println("\nFor" + carName + "," + carDetail + "has been changed to " + carDetail2 + ". ");
				carDetail = carDetail2; //change values
			
				
			System.out.print("\n\nWould you like to perform another Car operation? Enter: 1: Yes || 2: No (return to Admin Menu): ");
				int adminchoice = userInputInt.nextInt();

				switch (adminchoice) {
				case 1: 
					opsCar();
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
}
