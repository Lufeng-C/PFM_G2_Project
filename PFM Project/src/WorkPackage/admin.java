package WorkPackage;

import java.io.*;
import java.util.*;

public class admin { //extends unregisteredUser{			

	static Scanner userInputInt = new Scanner(System.in); 
	static Scanner userInputString = new Scanner(System.in); 
	static Scanner userInputDouble = new Scanner(System.in);

	private final static String adminID = "adminPFM";
	private final static String adminPassword = "admin";

	private ArrayList<car> carArrayList; //car array list
	Scanner scanner=new Scanner(System.in);
		


	public static void adminMenu () {
		admin runcarOps = new admin();
		
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
			runcarOps.opsCar(); //call Main class to execute
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
		System.out.print("\nWould you like to approve another user:[Enter: 1: Yes || 2: No (return to User Operations): ");
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
			System.out.print("There is an I/O error in overwriting the file!"
					+ "Catch source: overWriteTempFile, unregisteredUser:217");		
		}
	}




	//Method to approve user from tempList to permList
	public static void appendPermFile (String line) { 

		try {
			PrintWriter wr1 = new PrintWriter ( new BufferedWriter (new FileWriter("permRegistration.txt", true)));
			wr1.println(line);
			wr1.close();

		} catch (IOException ex) {
			System.out.println ("Something went wrong for I/O!"
					+ "Catch source: appendPermFile, unregisteredUser:233");
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
			System.out.print("There is an I/O error in overwriting the file!"
					+ "Catch source: overWritePermFile, unregisteredUser:375");		
		}
	}


	
	
	//admin operations concerning cars such as 
	//adding cars, viewing cars, deleting cars and editing cars

	   
	public void opsCar(){
			
			
			while (true) {
			
				//admin choices for car operations (menu)
				
			 	System.out.println("\n-----------------------------");
				System.out.println("CAR OPERATIONS");
				System.out.println("-----------------------------");
				System.out.println("\nYou have 4 choices:");
				System.out.println("Choose 1 to Add a new Car");
				System.out.println("Choose 2 to View all Cars");
				System.out.println("Choose 3 to Delete a Car");
				System.out.println("Choose 4 to Edit a Car");
				System.out.println("\nChoose 0 to return to the main menu");
				System.out.print("\nWhat would you want to choose? "); 
			
			int Choice = scanner.nextInt();
	        scanner.nextLine();
	        
			if (Choice == 1) {
				addCar();
				
				
				//return message
				System.out.print("\n\nWould you like to perform another Car operation? Enter: 1: Yes || 2: No (return to Admin Menu): ");
				int adminchoice = scanner.nextInt();

				switch (adminchoice) {
				case 1: 
					saveCarList();
					opsCar();
					break;
				case 2:
					saveCarList();
					adminMenu();
					break;
				default:
					saveCarList();
					System.out.println("\nInvalid Choice! Returning to admin main menu...");
					adminMenu();	
				}
			}
			
			else if (Choice == 2){
				viewAllCars();
				
				
				//return message
				System.out.print("\n\nWould you like to perform another Car operation? Enter: 1: Yes || 2: No (return to Admin Menu): ");
				int adminchoice = scanner.nextInt();

				switch (adminchoice) {
				case 1: 
					saveCarList();
					opsCar();
					break;
				case 2:
					saveCarList();
					adminMenu();
					break;
				default:
					saveCarList();
					System.out.println("\nInvalid Choice! Returning to admin main menu...");
					adminMenu();
				}
			}
			else if(Choice == 3){
				deleteCar();
				
				System.out.print("\n\nWould you like to perform another Car operation? Enter: 1: Yes || 2: No (return to Admin Menu): ");
				int adminchoice = scanner.nextInt();

				switch (adminchoice) {
				case 1: 
					saveCarList();
					opsCar();
					break;
				case 2:
					saveCarList();
					adminMenu();
					break;
				default:
					saveCarList();
					System.out.println("\nInvalid Choice! Returning to admin main menu...");
					adminMenu();
				}
	        }
	        else if (Choice == 4) {
	        	editCar();
	        	
	        	System.out.print("\n\nWould you like to perform another Car operation? Enter: 1: Yes || 2: No (return to Admin Menu): ");
				int adminchoice = scanner.nextInt();

				switch (adminchoice) {
				case 1: 
					saveCarList();
					opsCar();
					break;
				case 2:
					saveCarList();
					adminMenu();
					break;
				default:
					saveCarList();
					System.out.println("\nInvalid Choice! Returning to admin main menu...");
					adminMenu();
				}
			}
			
			else;
				saveCarList();
				admin.adminMenu();
			break;
			}
		}
		
			//method for adding car
	
		    private void addCar(){
		    	System.out.println("\nYou have chosen to add a new Car to the System: ");
		        System.out.print("Enter Car ID: ");
		        String carID=scanner.nextLine();
		        
		        System.out.print("Enter Car name: ");
		        String carName=scanner.nextLine();
		    	
		        System.out.print("Enter Car Type: ");
		        String carType=scanner.nextLine();

		        System.out.print("Enter Base Price: ");
		        double basePrice=scanner.nextDouble();
		        scanner.nextLine();

		        System.out.print("Enter Car Size: ");
		        String size=scanner.nextLine();

		        System.out.print("Is Sport: ");
		        String sport=scanner.nextLine();

		        System.out.print("Enter Fuel Type: ");
		        String fuelType=scanner.nextLine();

		        car car = new car (carID, carName, carType, basePrice, size, sport, fuelType);
		        carArrayList.add(car); //add to car arrayList
		    }
		    
		    //method for deleting a car
		    
		    private void deleteCar(){
		    	System.out.println("\nYou have chosen to delete a Car from the system.");
		    	System.out.println("\nThese are all the Cars in the List:\n");
		        for(int i=0;i<this.carArrayList.size();i++){
		            System.out.println("Index: "+i+" "+this.carArrayList.get(i).toString());
		        }

		        System.out.print("\nEnter the index of the car you want to delete: ");
		        int index=scanner.nextInt();
		        scanner.nextLine();

		        if(index>=0 && index<this.carArrayList.size()){
		            //remove from car list
		            this.carArrayList.remove(index);
		            System.out.println("\nRemoved!");
		        }
		        else {
		            System.out.println("Invalid Choice!");
		        }
		    }
		    
		    //method for viewing all cars
		    
		    private void viewAllCars(){
		    	System.out.println("\nHere is a list of all the cars within the System: \n");
		        for(int i=0;i<this.carArrayList.size();i++){
		            System.out.println(this.carArrayList.get(i).toString());
		        }
		    }
		    
		    //method for editing cars
		    
		    private void editCar(){
		    	System.out.println("\nYou have chosen to Edit a car from the system.");
		        System.out.println("\nThese are all the Cars in the List:\n");
		        for(int i=0;i<this.carArrayList.size();i++){
		            System.out.println("Index: "+ i +" "+this.carArrayList.get(i).toString());
		        }

		        System.out.print("\nEnter the index of the car you want to edit: ");
		        int index=scanner.nextInt();
		        scanner.nextLine();

		        if(index>=0 && index<this.carArrayList.size()){

		            boolean editCompleted=false;
		            while(!editCompleted) {

		                System.out.println("\nWhat do you need to edit? \n" +
		                        "1) car ID\n" +
		                        "2) car name\n" +
		                        "3) car type:\n" +
		                        "4) Base price\n" +
		                        "5) Car size\n" +
		                        "6) sport\n" +
		                        "7) fuel type");
		                

		                while(true) {
		                	
		                	System.out.print("\nEnter choice (number): ");
			                int choiceEdit = scanner.nextInt();
			                scanner.nextLine();
			                
		                if (choiceEdit == 1) {
		                    System.out.print("Enter Car ID: ");
		                    String carID = scanner.nextLine();

		                    this.carArrayList.get(index).setCarID(carID);
		                    System.out.println("\nChanged!");
		                    break;
		                } else if (choiceEdit == 2) {
		                    System.out.print("Enter Car Name: ");
		                    String carName = scanner.nextLine();

		                    this.carArrayList.get(index).setCarName(carName);
		                    System.out.println("\nChanged!");
		                    break;
		                } else if (choiceEdit == 3) {
		                    System.out.print("Enter Car type: ");
		                    String carType = scanner.nextLine();

		                    this.carArrayList.get(index).setCarType(carType);
		                    System.out.println("\nChanged!");
		                    break;
		                } else if (choiceEdit == 4) {
		                    System.out.print("Enter Base Price: ");
		                    double basePrice = scanner.nextDouble();
		                    scanner.nextLine();

		                    this.carArrayList.get(index).setBasePrice(basePrice);
		                    System.out.println("\nChanged!");
		                    break;
		                } else if (choiceEdit == 5) {
		                    System.out.print("Enter Car Size: ");
		                    String size = scanner.nextLine();

		                    this.carArrayList.get(index).setSize(size);
		                    System.out.println("\nChanged!");
		                    break;
		                } else if (choiceEdit == 6) {
		                    System.out.print("Is sport: ");
		                    String sport = scanner.nextLine();

		                    this.carArrayList.get(index).setSport(sport);
		                    System.out.println("\nChanged!");
		                    break;
		                } else if (choiceEdit == 7) {
		                    System.out.print("Enter Fuel Type: ");
		                    String fuelType = scanner.nextLine();

		                    this.carArrayList.get(index).setFuelType(fuelType);
		                    System.out.println("\nChanged!");
		                    break;
		                } else {
		                    System.out.println("\nInvalid Input!");
		                	}
		                }
		                System.out.print("\nEditing Completed? \n" +
		                        "1) Yes\n" +
		                        "2) No\n" +
		                        "Enter choice:  ");
		                int reRun = scanner.nextInt();
		                scanner.nextLine();

		                if(reRun==1){
		                    editCompleted=true;
		                }
		            }

		        }
		        else {
		            System.out.println("Invalid Choice!");
		        }
		    }
		    
		    
		        //below codes for save and read car array list
		    
		        public void saveCarList(){
		        Object obj= this.carArrayList;
		            FileOutputStream f = null;
		            try {
		                f = new FileOutputStream(new File("car_List.txt"));

		                ObjectOutputStream o = new ObjectOutputStream(f);

		                // Write objects to file
		                o.writeObject(obj);

		                o.close();
		                f.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		                System.out.println("Error Saving car List");
		            }   
		        
		    }
		   
		        public ArrayList<car> readCarList(){
		        FileInputStream fi = null;
		        try {
		            fi = new FileInputStream("car_List.txt");

		            ObjectInputStream oi = new ObjectInputStream(fi);

		            // Read objects
		            @SuppressWarnings("unchecked")
					ArrayList<car> carArrayList = (ArrayList<car>) oi.readObject();

		            oi.close();
		            fi.close();
		            return carArrayList;

		        } catch (IOException | ClassNotFoundException e) {
		            e.printStackTrace();
		            System.out.println("Error Loading Car List");
		        }
		     mainClass.setCarArrayList(carArrayList);
		        return new ArrayList<car>();
		    }

	
	
		        
		        
		        
	//Third admin option: Logout
	
	public static void adminLogout() {

		System.out.println("\nThanks for your time Admin. You have now been logged out!");
		System.out.println("Have a great day!");
		mainClass.setUserList(registeredUser.createObjects());
		unregisteredUser.beginMenu(mainClass.userList); 	//move back to starting screen of application
	
	}


	public static String getAdminID() {
		return adminID;
	}


	public static String getAdminPassword() {
		return adminPassword;
	}
}
