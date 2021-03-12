package WorkPackage;

import java.io.*;
import java.util.*;

public class Admin { //extends unregisteredUser{			
	
	static Scanner userInputInt = new Scanner(System.in); 
	static Scanner userInputString = new Scanner(System.in); 
	static Scanner userInputDouble = new Scanner(System.in);
	
	private final static String adminID = "adminPFM";
	private final static String password = "admin";

	//test

 public static void adminMenu () {
 
	 	System.out.println("\n-----------------------------");
		System.out.println("Welcome adminPFM! What would you like to do today?");
		System.out.println("-----------------------------");
		System.out.println("You have 3 choices:");
		System.out.println("Choose 1 to view overview of users");
		System.out.println("Choose 2 to add a new car to or remove a car from the system");
		System.out.println("Choose 3 to modify features of a car in the system");
		System.out.print("What would you want to choose? ");
 
		int adminchoice = userInputInt.nextInt();
		
		switch (adminchoice) {
		case 1:
			userOverview();
			break;
		case 2:
			addCar();
			break;
		case 3:
			modifyCar();
			break;
		}
 }
 
 
 
 // CHOICE 1 userOverview
 //Method for approving users, removing them from the system or simply viewing the list of options
 
 public static void userOverview() {
	 
	  	//choices for userOverview 
	 	System.out.println("\n-----------------------------");
		System.out.println("You have chosen to view an overview of the users!");
		System.out.println("You have 3 choices:");
		System.out.println("Choose 1 to approve registered users");
		System.out.println("Choose 2 to view the list of registered users");
		System.out.println("Choose 3 to remove a user from the list");
		System.out.println("Choose 0 to return to the Admin Main Menu");
		System.out.print("What would you want to choose? ");
	
		int adminchoice = userInputInt.nextInt();
		
		
		
		//Only break out of loop once user enters "0" and if that happens, he returns to the main menu
		while(true) {
		
	
		if(adminchoice ==0) {	
			break;
		}
			
		if(adminchoice ==1) {
			System.out.println("\nThe following users have registered to the system");
			
//TODO		read data from temp file, while loop for each noOfusers in tempRegistration.txt ask admin: would you like to approve user: *first_name*, *second_name*
			//remove line from temp file
			//then transfer approved users to permRegistration.txt
		}	
			
		
		if(adminchoice ==2) {
			System.out.println("\nThese are the registered users");	
			
//TODO		//print list of PermRegistration.txt
			
		}
		
		if(adminchoice ==3) {
			System.out.println("\nWhich of the registered users would you like to remove?");
			
//TODO		//print list of PermRegistration.txt and allow admin to remove a line.
		}
		
		System.out.println("\nWould you like to perform another action ? ");
		System.out.println("Choose 1 to approve registered users");
		System.out.println("Choose 2 to view the list of registered users");
		System.out.println("Choose 3 to remove a user from the list");
		System.out.println("Choose 0 to return to the Admin Main Menu");
		System.out.print("What would you want to choose? ");
		adminchoice = userInputInt.nextInt();
		} 
		
			adminMenu(); 		//return to main admin menu
 }
		

 
 
 
 // CHOICE 2 addCar
 //Method for adding Cars to the recommendation System
 
 public static void addCar() {
	 
	  	//choices for addCar 
	 	System.out.println("\n-----------------------------");
		System.out.println("You have chosen to add a new car to the system!");
		System.out.println("You have 3 choices:");
		System.out.println("Choose 1 to add a new car to the system");
		System.out.println("Choose 2 to remove a new car from the system");
		System.out.println("Choose 0 to return to the main menu");
		System.out.print("What would you want to choose? ");
		
		int adminchoice = userInputInt.nextInt();

		//Only break out of loop once user enters "0" and if that happens, he returns to the main menu
		while(true) {
		
		if(adminchoice ==0) {	
			break;
		}
		
		//adding a car to the system
		if(adminchoice ==1) {
			System.out.print("\nHow many cars would you like to add? ");
			int noOfCars = userInputInt.nextInt();
			
			for(int i=0; i<noOfCars; i++) {
				//ASK USER ALL CAR DETAILS
				System.out.print("\nWhat is the name of the car? ");
				String carName = userInputInt.next();
				System.out.print("\nWhat is the type of the car? ");
				String carType = userInputInt.next();
				
//HELP			//Accidentally made infinite loop here, how to continue?
//TODO			//create new line which constitutes a car in the file by: carName \t carType \t etc \t
//TODO			//append new line to car file
			}
		}
		
		//removing a car from the system
		if(adminchoice ==2) {
			System.out.print("\nHow many cars would you like to remove? ");
			int noOfCars = userInputInt.nextInt();
			
			for(int i=0; i<noOfCars; i++) {
				//ASK NAME OF CAR
				System.out.print("\nWhat is the name of the car you want to remove? ");
				String carName = userInputString.next();
				
				//From car file remove lines that contain carName
				//As in A3
			}
			System.out.println("\nWould you add or remove another car to the system? ");
			System.out.println("Choose 1 to add more cars");
			System.out.println("Choose 2 to remove more cars");
			System.out.println("Choose 0 to return to the Admin Main Menu");
			System.out.print("What would you want to choose? ");
			adminchoice = userInputInt.nextInt();
		}
	}
		adminMenu();	
	
 }
 
 
 
 
 // CHOICE 3 modifyCar
 //Method for modifying Cars in the recommendation System
 
		public static void modifyCar() {
			
			//choices for modify Car 
		 	System.out.println("\n-----------------------------");
			System.out.println("You have chosen modify car details in the system!");
			System.out.println("You have 2 choices:");
			System.out.println("Choose 1 to modify car details in the system");
			System.out.println("Choose 0 to return to the main menu");
			System.out.print("What would you want to choose? ");
			
			int adminchoice = userInputInt.nextInt();
			
			
		//Only break out of loop once user enters "0" and if that happens, he returns to the main menu
		while(true) {
			
			if(adminchoice ==0) {	
				break;
			}
			
			//modify car details
			if(adminchoice ==1) {
				System.out.print("\nWhat is the name of the car you want to modify? ");
				String carName = userInputString.next();
				
				//System print line of car file that contains car name, so print all data of the car
				System.out.print("\nWhat details of the car would you want to modify? ");
				String carDetail = userInputString.next();
				
				System.out.println("To what would you like to change " + carDetail + "? ");
				String carDetail2 = userInputString.next();
				
				carDetail = carDetail2; //change values
				
				//line of carName is overwritten in file, using the new value of carDetail2
				
				System.out.println("For" + carName + "," + carDetail + "has been changed to " + carDetail2 + ". ");	
			}
			
			System.out.println("\nWould you add modify another car? ");
			System.out.println("Choose 1 to add modify more cars");
			System.out.println("Choose 0 to return to the Admin Main Menu");
			System.out.print("What would you want to choose? ");
			adminchoice = userInputInt.nextInt();
			
		}
		 adminMenu();					
	}
		
		
		
		
		
		
		
 
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Admin.adminMenu();
		
	}

}

	

}
