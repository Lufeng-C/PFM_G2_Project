package WorkPackage;

import java.io.*;
import java.util.*;

public class admin { //extends unregisteredUser{			

	static Scanner userInputInt = new Scanner(System.in); 
	static Scanner userInputString = new Scanner(System.in); 
	static Scanner userInputDouble = new Scanner(System.in);

	private final static String adminID = "adminPFM";
	private final static String adminPassword = "admin";



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
		default: 
			System.out.println("\nInvalid Choice!");
			adminMenu();
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
		default: 
			System.out.println("\nInvalid Choice!");
			opsUser();
			break;
		}
	}



	//METHODS FOR CHOICE 1: Approve Users, viewUsers and removeUsers

	public static void approveUsers () {
		System.out.println("\nLIST OF TO BE APPROVED USERS");

		String[] tempFile = readTempFile();

		for (int i=0; i < tempFile.length; i++) {
			System.out.println("[" + i + "]" + tempFile[i]); 		//printing contents of tempRegistration.txt, line by line
		}

		if (tempFile.length < 1) {
			System.out.println("\nThere are no more users in the list!"
					+ "Returning to User Operations.");
			opsUser();
		}

		else {
			System.out.print("\nSelect the index [number] of the user you would like to approve? "); 

			int approvedUser = userInputInt.nextInt();

			int indexSearch = -1;
			for (int i = 0; i < tempFile.length; i++) {
				if (i ==(approvedUser)) {
					indexSearch = i; //capture index of removed User
				}
			}

			if(indexSearch < 0) {
				System.out.println("\nThis User is not in the list."); 
			}

			else {
				//Add user to permanent File
				appendPermFile(tempFile[approvedUser]);

				//create new arrays with .length -1, as one item is removed
				String[] newtempFile = new String[tempFile.length - 1]; 

				//assign values to new arrays
				int newindexSearch = 0;
				for(int i=0; i < tempFile.length; i++) {
					if (i!= indexSearch) {
						newtempFile[newindexSearch] = tempFile[i];
						newindexSearch++;
					}
				}
				overWriteTempFile(newtempFile);
				System.out.println("\nThe User has successfully been approved!");
			}	
		}
		System.out.print("\nWould you like to approve another user:[1] YES  [2] NO (Return to User Operations)? ");
		int adminchoice = userInputInt.nextInt();
		switch (adminchoice) {
		case 1: 
			approveUsers();
		case 2:
			opsUser();
			break;
		default: 
			System.out.println("\nInvalid Choice! Returning to admin main menu...");
			adminMenu();
			break;
		}
	}	





	//method for reading temporary File

	public static String[] readTempFile(){

		String[] temp = new String[1000]; //temporary array for storing values
		int lineNumber = 0;


		try {
			BufferedReader br = new BufferedReader(new FileReader("tempRegistration.txt"));
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null){

				temp[lineNumber]= (sCurrentLine); 
				lineNumber++;
			}	

			br.close();

		} catch (IOException e) {
			System.out.println("There is no temporary Users at the moment!");	
		}

		String[] tempFile = new String[lineNumber];
		System.arraycopy(temp, 0, tempFile, 0, lineNumber);
		return tempFile;

	}



	//Method for overWriting TempFile

	public static void overWriteTempFile(String[] tempFile){

		try {
			PrintWriter wr = new PrintWriter(
					new BufferedWriter (new FileWriter("tempRegistration.txt", false)));

			for(int i = 0; i < tempFile.length; i++) 
				wr.println(tempFile[i]); 
			wr.close();

		}
		catch(IOException e) {
			System.out.print("There is an I/O error in overwriting the file!");		
		}
	}




	//Method to approve user from tempList to permList
	public static void appendPermFile (String line) { 

		try {
			PrintWriter wr1 = new PrintWriter ( new BufferedWriter (new FileWriter("permRegistration.txt", true)));
			wr1.println(line);
			wr1.close();

		} catch (IOException ex) {
			System.out.println ("Something went wrong for I/O!");
		}
	}



	public static String[] readPermFile(){

		String[] temp = new String[100]; //temporary array for storing values
		int lineNumber = 0;


		try {
			BufferedReader br = new BufferedReader(new FileReader("permRegistration.txt"));
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null){

				temp[lineNumber]= (sCurrentLine); 
				lineNumber++;
			}	

			br.close();

		} catch (IOException e) {
			System.out.println("There is no temporary Users at the moment!");	
		}
		String[] permFile = new String[lineNumber];
		System.arraycopy(temp, 0, permFile, 0, lineNumber);
		return permFile;

	}



	//Read and print permRegistered.txt
	public static void viewUsers () {


		String[] permFile = readPermFile();
		System.out.println("\nThese are all the approved registered users:"); 
		for (int j=0; j < permFile.length; j++) {
			System.out.println("[" + j + "]" + permFile[j]); 
		}

		System.out.print("\n\nWould you like to perform another User operation? Enter: 1: Yes || 2: No (return to Admin Menu): ");
		int adminchoice = userInputInt.nextInt();

		switch (adminchoice) {
		case 1: 
			opsUser();
		case 2:
			adminMenu();
			break;
		default:
			System.out.println("\nInvalid Choice! Returning to admin main menu...");
			adminMenu();
			break;
		}
	}


	public static void removeUsers () {

		System.out.println("REMOVE A USER");

		String[] permFile = readPermFile();

		System.out.println("\nThese are all the approved registered users"); 
		for (int i=0; i < permFile.length; i++) {
			System.out.println("[" + i + "]" + permFile[i]); 			//Prints list of all users including index
		}


		System.out.print("What is the index [number] of the User you would like to remove? ");
		int removedUser = userInputInt.nextInt();


		int indexSearch = -1;
		for (int i = 0; i < permFile.length; i++) {
			if (i ==(removedUser)) {
				indexSearch = i; //capture index of removed User
			}
		}

		if(indexSearch < 0) {
			System.out.println("This User is not in the list."); 
		}

		else {
			//create new arrays with .length -1, as one item is removed
			String[] newpermFile = new String[permFile.length - 1]; 

			//assign values to new arrays
			int newindexSearch = 0;
			for(int i=0; i < permFile.length; i++) {
				if (i!= indexSearch) {
					newpermFile[newindexSearch] = permFile[i];
					newindexSearch++;
				}
			}
			overWritePermFile(newpermFile);
			System.out.println("\nThe User has successfully been removed!");
		}



		System.out.print("\n\nWould you like to perform another User operation? Enter: 1: Yes || 2: No (return to Admin Menu): ");

		int adminchoice = userInputInt.nextInt();

		switch (adminchoice) {
		case 1: 
			opsUser();
		case 2:
			adminMenu();
			break;
		default: 
			System.out.println("\nInvalid Choice! Returning to admin main menu...");
			adminMenu();
			break;
		}
	}



	//Method for overWriting PermFile

	public static void overWritePermFile(String[] permFile){

		try {
			PrintWriter wr = new PrintWriter(
					new BufferedWriter (new FileWriter("permRegistration.txt", false)));

			for(int i = 0; i < permFile.length; i++) 
				wr.println(permFile[i]); //
			wr.close();

		}
		catch(IOException e) {
			System.out.print("There is an I/O error in overwriting the file!");		
		}
	}





	public static void adminLogout() {

		System.out.println("\nThanks for your time Admin. You have now been logged out!");
		System.out.println("Have a great day!");

		testDrive.main(null); 	//move back to main menu

	}


	public static String getAdminID() {
		return adminID;
	}


	public static String getAdminPassword() {
		return adminPassword;
	}
}
