package WorkPackage;

import java.io.*;
import java.util.*;

public class registeredUser {

	static Scanner userInputInt = new Scanner(System.in); 
	static Scanner userInputString = new Scanner(System.in); 
	static Scanner userInputDouble = new Scanner(System.in);

	private String emailAddress;
	private String password;
	private String firstName;
	private String lastName;
	private int phoneNumber;
	private int userID;
	private boolean logInStatus;
	private int favorite;

	static int num_registeredUser = getTotalLines();


	public void userInterface() {

		System.out.println("                   _____________\r\n"
				+ "                                  ..---:::::::-----------. ::::;;.\r\n"
				+ "                               .'\"\"\"\"\"\"                  ;;   \\  \":.\r\n"
				+ "                            .''                          ;     \\   \"\\__.\r\n"
				+ "                          .'                            ;;      ;   \\\\\";\r\n"
				+ "                        .'                              ;   _____;   \\\\/\r\n"
				+ "                      .'                               :; ;\"     \\ ___:'.\r\n"
				+ "                    .'--...........................    : =   ____:\"    \\ \\\r\n"
				+ "               ..-\"\"                               \"\"\"'  o\"\"\"     ;     ; :\r\n"
				+ "          .--\"\"  .----- ..----...    _.-    --.  ..-\"     ;       ;     ; ;\r\n"
				+ "       .\"\"_-     \"--\"\"-----'\"\"    _-\"        .-\"\"         ;        ;    .-.\r\n"
				+ "    .'  .'                      .\"         .\"              ;       ;   /. |\r\n"
				+ "   /-./'                      .\"          /           _..  ;       ;   ;;;|\r\n"
				+ "  :  ;-.______               /       _________==.    /_  \\ ;       ;   ;;;;\r\n"
				+ "  ;  / |      \"\"\"\"\"\"\"\"\"\"\".---.\"\"\"\"\"\"\"          :    /\" \". |;       ; _; ;;;\r\n"
				+ " /\"-/  |                /   /                  /   /     ;|;      ;-\" | ;';\r\n"
				+ ":-  :   \"\"\"----______  /   /              ____.   .  .\"'. ;;   .-\"..T\"   .\r\n"
				+ "'. \"  ___            \"\":   '\"\"\"\"\"\"\"\"\"\"\"\"\"\"    .   ; ;    ;; ;.\" .\"   '--\"\r\n"
				+ " \",   __ \"\"\"  \"\"---... :- - - - - - - - - ' '  ; ;  ;    ;;\"  .\"\r\n"
				+ "  /. ;  \"\"\"---___                             ;  ; ;     ;|.\"\"\r\n"
				+ " :  \":           \"\"\"----.    .-------.       ;   ; ;     ;:\r\n"
				+ "  \\  '--__               \\   \\        \\     /    | ;     ;;\r\n"
				+ "   '-..   \"\"\"\"---___      :   .______..\\ __/..-\"\"|  ;   ; ;\r\n"
				+ "       \"\"--..       \"\"\"--\"                      .   \". . ;\r\n"
				+ "             \"\"------...                  ..--\"\"      \" :\r\n"
				+ "                        \"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"    \\        /\r\n"
				+ "                                               \"------\"");
		System.out.println("   ,--------------------------------------------------------------.\r\n"
				+ "  |============================,------.============================|\r\n"
				+ "  |==========================,'   ::   `.==========================|\r\n"
				+ "  |=========================/     ::     \\=========================|\r\n"
				+ "  |========================:      ::      :========================|\r\n"
				+ "  |=======================:       ::       :=======================|\r\n"
				+ "  |=======================|      .::.      |=======================|\r\n"
				+ "  |=======================:    .:'  `:.    :=======================|\r\n"
				+ "  |========================: .:'      `:. :========================|\r\n"
				+ "  |=========================\\            /=========================|\r\n"
				+ "  |==========================`.        ,'==========================|\r\n"
				+ "  |============================`--..--'============================|\r\n"
				+ "   `--------------------------------------------------------------'");
		System.out.println("Welcome: " + this.getFirstName() + " " + this.getLastName());

		System.out.println("-----------------------------");
		System.out.println("User Overview");
		System.out.println("-----------------------------");
		System.out.println("You have 3 choices");
		System.out.println("Choose 1 to request a car recommendation.");
		System.out.println("Choose 2 to view your list of favourite car recommendations.");
		System.out.println("Choose 3 to delete your account.");
		System.out.println("What do you want to choose?");


		int Choice = userInputInt.nextInt();
		switch (Choice) {
		case 1:
			unregisteredUser.getUserChoice();
			break;
		case 2:
			getFavorite();
			break;
		case 3:
			this.deleteAccount(); //insert a user object here
			break;

		}
	}


	// This method creates a number of registeredUser objects with appropriate attributes
	public static ArrayList<registeredUser> createObjects () {
		ArrayList<registeredUser> userList = new ArrayList<registeredUser>();

		// create a list of registeredUser objects
		for (int i = 0; i < num_registeredUser; i++) {
			userList.add(new registeredUser());			
		}		
		userList = assignAttributes (userList); 

		return userList;
	} // end createObjects()

	// This method reads and give proper attributes to the registeredUser objects
	public static ArrayList<registeredUser> assignAttributes (ArrayList<registeredUser> userList){ 

		try {
			String textline; // stores a line of text from the reader function
			String[] uCurrent = new String [8]; // to store elements of textline
			BufferedReader br2 = new BufferedReader (new FileReader ("permRegistration.txt"));

			int i = 0;				
			while ((textline = br2.readLine()) != null) {					
				uCurrent = textline.split("\t"); // uCurrent [0] is email; [1] password; 
				//[2]first name; [3] last name; [4] phone; [5] userID [6] logInStatus [7] favList
				userList.get(i).setEmailAddress (uCurrent [0]);
				userList.get(i).setPassword (uCurrent [1]);	
				userList.get(i).setFirstName (uCurrent [2]);
				userList.get(i).setLastName (uCurrent [3]);
				userList.get(i).setPhoneNumber (Integer.parseInt(uCurrent [4]));
				userList.get(i).setUserID (Integer.parseInt(uCurrent [5]));
				userList.get(i).setLogInStatus (false); // default no one is logged in
				userList.get(i).setFavorite (Integer.parseInt(uCurrent[7]));
				i++;
			}
			br2.close();

		}	catch (IOException ex) {
			System.out.println ("Something went wrong for I/O!");
		}

		return userList;
	} // end assignAttributes (ArrayList<registeredUser> userList)

	// This method asks for input and try to log in
	public static boolean logIn (ArrayList<registeredUser> userList) {

		int loginAttempts = 3;			
		int userIndex = -1; 
		while (loginAttempts > 0) {

			System.out.print("Enter your email adress: ");
			String entered_email = userInputString.nextLine();

			System.out.print("Enter your password: ");
			String entered_password = userInputString.nextLine();
			
//TODO			// create a login option for admin that calls the admin menu.

			for (int i = 0; i < num_registeredUser; i++) {
				if (entered_email.equals(userList.get(i).emailAddress) 
						&& entered_password.equals(userList.get(i).password)) {
					userIndex = i;
					break;
				}
			} // end for loop

			
			if (userIndex == -1) {
				loginAttempts--;
				System.out.println("Email/password incorrect. Please try again!");
				System.out.println("You have " + loginAttempts + " login attempts left.");	
				System.out.println("");
			}
			else if (userIndex != (-1)) break;
		} // end while loop

		if (userIndex == -1) {
			System.out.println("You failed 3 times. This session is terminated!");
			return false;
		}
		else {
			System.out.println("Login Successful! Welcome, " 
					+ userList.get(userIndex).firstName 
					+ " " + userList.get(userIndex).lastName);
			userList.get(userIndex).logInStatus = true;	
			return (userList.get(userIndex).logInStatus);
		}

	} // end logIn (ArrayList<registeredUser> userList) -> user UX / admin UX (if username == admin & password == adminPassword)

	// This method asks for input and record in tempRegistration.txt
	public static void register (ArrayList<registeredUser> userList) {

		System.out.print("Welcome to register process!\nPlease type relevant info when prompted.\n");

		System.out.print("Your email address (used for log in): ");
		String email = userInputString.nextLine();	

		System.out.print("Your password: ");
		String password = userInputString.nextLine();		

		System.out.print("Your first name: ");
		String firstName = userInputString.nextLine();	

		System.out.print("Your last name: ");
		String lastName = userInputString.nextLine();

		System.out.print("Your phone number: ");
		String phoneNumber = userInputString.nextLine();		

		// find out the biggest userID and add 1 
		ArrayList<Integer> userIDList = new ArrayList<Integer>();
		for (int i = 0; i < userList.size(); i++) {
			userIDList.add(userList.get(i).getUserID());
		}
		int userID = Collections.max(userIDList) + 1;

		boolean logInStatus = false; // reserved for any possible future use

		String line = (email + "\t" + password + "\t" + firstName + "\t" + lastName + 
				"\t" + phoneNumber + "\t" + userID + "\t" + logInStatus);

		appendFileTemp(line); // store in temp file, awaiting admin approval
		// while awaiting aproval, you are redirected to login where you can either wait for approval or continue as guest.
		// print a message where users find out they are awaiting approval and can either continue as a guest or go back to login screen.

	}	// end register()

	public void deleteAccount() {
		/* confirm email and password? If possible

		System.out.print("To delete your account, confirm your email address and password: ");
		System.out.print("Your email address (used for log in): ");
		String email = userInputString.nextLine();	

		System.out.print("Your password: ");
		String password = userInputString.nextLine();
		 */

		System.out.print("Are you sure you want to delete your account? Enter 1 for yes, enter 2 to cancel and go back to the user interface: ");
		int confirmation = userInputInt.nextInt();

		if(confirmation == 1) {
			boolean flag = removeUser(this.getUserID());
			if 	(flag) {
				//delete object from the userList, call userList, remove user.
				System.out.println("Your account was succesfully deleted. You are redirected to the register page.");
				//register(); // this shouldn't be necessary
			}
			else {
				System.out.println("Your account was not deleted. You will return to the user interface");

				this.userInterface();
			}
		}
		if (confirmation == 2) {
			System.out.println("\nYour delete request was cancelled. You will return to the user interface.");
			this.userInterface();
		}
	}




	public boolean removeUser(int userID) {

		ArrayList <String> userIDList = new ArrayList <String>();
		ArrayList <String> storedLine = new ArrayList <String>();

		try {
			String textline; // stores a line of text from the reader function
			String[] uCurrent = new String [8]; // to store elements of textline
			BufferedReader br = new BufferedReader (new FileReader ("permRegistration.txt"));

			while ((textline = br.readLine()) != null) {
				storedLine.add(textline);
				uCurrent = textline.split("\t"); // uCurrent [0] is email; [1] password; 
				//[2]first name; [3] last name; [4] phone; [5] userID [6] logInStatus [7] favorite
				userIDList.add(uCurrent[5]);
			}
			br.close();

		}	catch (IOException ex) {
			System.out.println ("Something went wrong for I/O!");
		}

		boolean flag = false;
		int indx = userIDList.indexOf(Integer.toString(userID));
		if (indx != -1) {
			flag = true;
			storedLine.remove(indx);
		} 

		//overwrite the new txt file, with the removed index.
		try {
			PrintWriter wr = new PrintWriter(
					new BufferedWriter (new FileWriter("permRegistration.txt", false)));

			for(int i = 0; i < storedLine.size(); i++) 
				wr.println(storedLine.get(i)); //
			wr.close();
		}
		catch(IOException e) {
			System.out.print("There is an I/O error in overwriting the file!");		
		} // end catch & try
		return flag;
	} //end removeUser(int userID)

	// This method takes a car object and modifies permRegistration.txt
	public void addFavorite(car carObject) {
		ArrayList <String> userIDList = new ArrayList <String>();
		ArrayList <String> favoriteList = new ArrayList <String>();
		ArrayList <String> storedLine = new ArrayList <String>();

		try {
			String textline; // stores a line of text from the reader function
			String[] uCurrent = new String [8]; // to store elements of textline
			BufferedReader br = new BufferedReader (new FileReader ("permRegistration.txt"));

			while ((textline = br.readLine()) != null) {
				storedLine.add(textline);
				uCurrent = textline.split("\t"); // uCurrent [0] is email; [1] password; 
				//[2]first name; [3] last name; [4] phone; [5] userID [6] logInStatus [7] favorite
				userIDList.add(uCurrent[5]);
				favoriteList.add(uCurrent[7]);
			} //end while loop
			br.close();

		}	catch (IOException ex) {
			System.out.println ("Something went wrong for I/O!");
		} //end catch & try

		// update storedLine with new favorite
		int indx = userIDList.indexOf(Integer.toString(this.getUserID()));
		String originalLine = storedLine.get(indx);
		storedLine.remove(indx);
		String updatedLine;
		String [] uCurrent = new String [8];
		uCurrent = originalLine.split("\t"); // uCurrent [0] is email; [1] password; 
		//[2]first name; [3] last name; [4] phone; [5] userID [6] logInStatus [7] favorite
		updatedLine = uCurrent[0] + "\t" + uCurrent[1] + "\t" + uCurrent[2] + "\t" + uCurrent[3] + "\t" 
				+ uCurrent[4] + uCurrent[5] + "\t" + uCurrent[6] + "\t" + carObject.getCarID();
		storedLine.add(updatedLine);

		// write the permRegistration database again
		try {
			PrintWriter wr = new PrintWriter(
					new BufferedWriter (new FileWriter("permRegistration.txt", false)));

			for(int i = 0; i < storedLine.size(); i++) 
				wr.println(storedLine.get(i)); //
			wr.close();		
		} 
		catch(IOException e) {
			System.out.print("There is an I/O error in overwriting the file!");		
		} //end catch & try

	} //end addFavorite()

	// This method returns details of a user's fav car
	public void viewFavorite(car favCar) {
		System.out.print("Your favorite car model is " + favCar.getCarID());
	}
	// This method appends a line to the tempRegistration.txt
	public static void appendFileTemp (String line) { 

		try {
			PrintWriter wr1 = new PrintWriter ( new BufferedWriter (new FileWriter("tempRegistration.txt", true)));
			wr1.println(line);
			wr1.close();

		} catch (IOException ex) {
			System.out.println ("Something went wrong for I/O!");
		}
	}

	// This method sees how many perm registered user are there
	public static int getTotalLines (){ 

		int countlines = 0;			
		try {
			BufferedReader br1 = new BufferedReader (new FileReader ("permRegistration.txt"));

			while ((br1.readLine()) != null) {
				countlines++;
			}
			br1.close();

		} catch (IOException ex) {
			System.out.println ("Something went wrong for I/O!");
		}

		return countlines;
	} // end getTotalLines ()




	public String getEmailAddress() {
		return emailAddress;
	}




	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public int getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public int getUserID() {
		return userID;
	}




	public void setUserID(int userID) {
		this.userID = userID;
	}




	public boolean isLogInStatus() {
		return logInStatus;
	}




	public void setLogInStatus(boolean logInStatus) {
		this.logInStatus = logInStatus;
	}




	public int getFavorite() {
		return favorite;
	}




	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}

} // end class registeredUser
