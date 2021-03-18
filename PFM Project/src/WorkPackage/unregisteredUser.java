package WorkPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*; //combined and import everything

// import WorkPackage.car; Might not be needed

public class unregisteredUser {

	static Scanner userInputInt = new Scanner(System.in); 
	static Scanner userInputString = new Scanner(System.in); 
	static Scanner userInputDouble = new Scanner(System.in);
	private static ArrayList<car> carArrayList; //car arraylist
	admin runcarOps = new admin();
	

	// This is reserved space for the main method

	public static void main() {
		carArrayList = readCarList();
		
	}
	
	// This is the very first menu
	public static void beginMenu(ArrayList<registeredUser> userList) {

        
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
		System.out.println("\n\n--------------------------------");
		System.out.println("Mercedes Benz-Recommendation System");
		System.out.println("--------------------------------");
		System.out.println("\nWelcome! You have 3 choices:\n ");
		System.out.println("Choose 1 to log in");
		System.out.println("Choose 2 to register as a new user");
		System.out.println("Choose 3 to continue as guest");
		System.out.print("What do you want to choose? ");

		int Choice = userInputInt.nextInt();
		switch (Choice) {
		case 1:
			registeredUser me = registeredUser.logIn(userList);
			if (me.getUserID() != 99999) me.userInterface();
			else beginMenu(userList);
			break;
		case 2:
			registeredUser.register(userList);
			beginMenu(userList);
			break;
		case 3:
	        System.out.println("Welcome guest, please register for more facilities.\n" +
	                "for now, you can create one recommendation. Thank You!");
			unregisteredUserMethod();
			System.out.println("You created one recommendation. Please register for more facilities. You exited the system now");
			break;
		}
	}
	
	// This method is used to create a recommendation
	public static void unregisteredUserMethod() {

		//this callingObject is used to call non-static method in a static method
		unregisteredUser callingObject = new unregisteredUser(); 
		

		System.out.println("\nThese are the car types for Mercedes Benz:" );	
		System.out.println("(1) Sedan" );
		System.out.println("(2) Van" );
		System.out.println("(3) Hatchback" );
		System.out.println("(4) Luxurious" );
		System.out.println("(5) SUV" );
		System.out.print("What cartype would you prefer? ");
		
		int userChoice= userInputInt.nextInt();
		switch (userChoice) {	
		

		case 1:
			callingObject.Sedan();
			break;

		case 2:
			callingObject.Van();
			break;

		case 3:
			callingObject.Hatchback();
			break;

		case 4:
			callingObject.Luxurious();
			break;

		case 5:
			callingObject.SUV();
			break;
		default: 
			System.out.println("\nInvalid Choice!");
			unregisteredUserMethod();
			break;

			} //end unregisterUserMethod()
		}
	

	
	public void Sedan() {
		String carType = "Sedan";
		
		System.out.println("\nYou have chosen the Sedan car type!");
		
		System.out.print("\nWhat is your budget? Enter Minimum: ");
		double minBudget = userInputDouble.nextDouble();

		System.out.print("What is your budget? Enter Maximum: ");
		double maxBudget = userInputDouble.nextDouble();

		System.out.println("\nThese are the fueltypes for car Type " + carType + ":");
		System.out.println("(1) Petrol"); //c250 or s500
		System.out.println("(2) Diesel"); //c220d or s400d
		System.out.println("(3) Hybrid"); //c300e or s400e
		System.out.println("(4) Electric"); //EQS
		System.out.print("What fueltype do you prefer? ");
		int choiceFuel = userInputInt.nextInt();

		String fuelType = "Petrol";//default
		if (choiceFuel == 1) {
			fuelType = "Petrol";
		} else if (choiceFuel == 2) {
			fuelType = "Diesel";
		} else if (choiceFuel == 3) {
			fuelType = "Hybrid";
		} else if (choiceFuel == 4) {
			fuelType = "Electric";
		}

		System.out.println("\nAvailable car sizes: ");
		System.out.println("(1) Medium"); //c class
		System.out.println("(2) Large"); //s class
		System.out.print("What car size do you prefer? ");
		int choiceSize = userInputInt.nextInt();

		String carSize="small";//by default
		if(choiceSize==1){
			carSize="Medium";
		}
		else if(choiceSize==2){
			carSize="Large";
		}
		System.out.println("\nDo you prefer a car sport look? ");
		System.out.println("(1) Yes"); //c63 or s63 amg,
		System.out.println("(2) No"); 
		System.out.print("Enter your choice: ");
		int choiceSport = userInputInt.nextInt();

		String sport="No";//by default
		if(choiceSport==1){
			sport="Yes";
		}
		else if(choiceSport==2){
			sport="No";
		}

		viewByFilter (minBudget, maxBudget, sport, fuelType,carType,carSize);
	}
	public void Van () {
		String carType = "Van";

		System.out.println("\nYou have chosen the " + carType + " car type!");
		
		System.out.print("\nWhat is your budget? Enter Minimum: ");
		double minBudget = userInputDouble.nextDouble();

		System.out.print("What is your budget? Enter Maximum: ");
		double maxBudget = userInputDouble.nextDouble();

		System.out.println("\nThese are the fueltypes for car Type " + carType + ":");
		System.out.println("(1) Diesel"); //v200, v220 or v300
		System.out.println("(2) Electric"); //eqv
		System.out.print("What fueltype do you prefer? ");
		int choiceFuel = userInputInt.nextInt();

		String fuelType = "Diesel";//default
		if (choiceFuel == 1) {
			fuelType = "Diesel";
		} else if (choiceFuel == 2) {
			fuelType = "Electric";
		}
		System.out.println("\nAvailable " + carType + " sizes:");
		System.out.println("(1) Standard"); //v class
		System.out.println("(2) Extra long"); //v class L
		System.out.print("What size " + carType + " do you prefer? ");
		int choiceSize = userInputInt.nextInt();

		String carSize="Standard";//by default
		if(choiceSize==1){
			carSize="Standard";
		}
		else if(choiceSize==2){
			carSize="Extra long";
		}
		System.out.println("\nDo you prefer a " + carType + " with a sport look? ");
		System.out.println("(1) Yes"); //amg line,
		System.out.println("(2) No"); //default v class
		System.out.print("Enter your choice: ");
		int choiceSport = userInputInt.nextInt();

		String sport="No";//by default
		if(choiceSport==1){
			sport="Yes";
		}
		else if(choiceSport==2){
			sport="No";
		}

		viewByFilter (minBudget, maxBudget, sport, fuelType,carType,carSize);
	}
	public void Hatchback() {
		String carType = "Hatchback";

		System.out.println("\nYou have chosen the " + carType + " car type!");
		
		System.out.print("\nWhat is your budget? Enter Minimum: ");
		double minBudget = userInputDouble.nextDouble();

		System.out.print("What is your budget? Enter Maximum: ");
		double maxBudget = userInputDouble.nextDouble();


		System.out.println("\nThese are the fueltypes for car type " + carType + ":");
		System.out.println("(1) Petrol"); //a200, a45
		System.out.println("(2) Diesel"); //a220d
		System.out.println("What fueltype do you prefer? ");
		int choiceFuel = userInputInt.nextInt();

		String fuelType = "Petrol";//default
		if (choiceFuel == 1) {
			fuelType = "Petrol";
		} else if (choiceFuel == 2) {
			fuelType = "Diesel";
		} 

		System.out.println("\nAvailable " + carType + " sizes:");
		System.out.println("(1) Small"); //a class
		System.out.println("(2) Medium"); //gla class
		System.out.print("What size " + carType + " do you prefer? ");
		int choiceSize = userInputInt.nextInt();

		String carSize="Small";//by default
		if(choiceSize==1){
			carSize="Small";
		}
		else if(choiceSize==2){
			carSize="Medium";
		}
		System.out.println("\nDo you prefer a " + carType + " with a sport look? ");
		System.out.println("(1) Yes"); //a45 or a220 amg line
		System.out.println("(2) No"); 
		System.out.print("Enter choice: "); 
		int choiceSport = userInputInt.nextInt();

		String sport="No";//by default
		if(choiceSport==1){
			sport="Yes";
		}
		else if(choiceSport==2){
			sport="No";
		}

		viewByFilter (minBudget, maxBudget, sport, fuelType, carType, carSize);
	}
	public void Luxurious() {
		String carType = "Luxurious";

		System.out.println("\nYou have chosen the " + carType + " car type!");
		
		System.out.print("\nWhat is your budget? Enter Minimum: ");
		double minBudget = userInputDouble.nextDouble();

		System.out.print("What is your budget? Enter Maximum: ");
		double maxBudget = userInputDouble.nextDouble();

		System.out.println("\nThese are the fueltypes for car Type " + carType + ":");
		System.out.println("(1) Petrol");
		System.out.println("(2) Diesel");
		System.out.println("(3) Hybrid");
		System.out.print("What fueltype do you prefer? ");
		int choiceFuel = userInputInt.nextInt();

		String fuelType = "Petrol";//default
		if (choiceFuel == 1) {
			fuelType = "Petrol";
		} else if (choiceFuel == 2) {
			fuelType = "Diesel";
		} else if (choiceFuel == 3) {
			fuelType = "Hybrid";
		}

		System.out.println("\nAvailable " + carType + " car sizes:");
		System.out.println("(1) Medium"); //s class
		System.out.println("(2) Large"); //gls class, v class luxury edition
		System.out.print("What size " + carType + " do you prefer? ");
		int choiceSize = userInputInt.nextInt();

		String carSize="Medium";//by default
		if(choiceSize==1){
			carSize="Medium";
		}
		else if(choiceSize==2){
			carSize="Large";
		}
		System.out.println("\nDo you prefer a " + carType + " car with a sport look? ");
		System.out.println("(1) Yes"); //amg line
		System.out.println("(2) No"); 
		System.out.print("Enter choice: ");
		int choiceSport = userInputInt.nextInt();

		String sport="No";//by default
		if(choiceSport==1){
			sport="Yes";
		}
		else if(choiceSport==2){
			sport="No";
		}

		viewByFilter (minBudget, maxBudget, sport, fuelType, carType, carSize);
	}
	public void SUV() {
		String carType = "SUV";


		System.out.println("\nYou have chosen the " + carType + " car type!");
		
		System.out.print("\nWhat is your budget? Enter Minimum: ");
		double minBudget = userInputDouble.nextDouble();

		System.out.print("What is your budget? Enter Maximum: ");
		double maxBudget = userInputDouble.nextDouble();


		System.out.println("\nThese are the fueltypes for car Type " + carType + ":");
		System.out.println("(1) Petrol"); //gle400 //gle63s amg
		System.out.println("(2) Diesel"); //gle300d
		System.out.println("(3) Hybrid"); //gle400e
		System.out.print("What fueltype do you prefer? "); //all can be gle or gls
		int choiceFuel = userInputInt.nextInt();

		String fuelType = "Petrol";//default
		if (choiceFuel == 1) {
			fuelType = "Petrol";
		} else if (choiceFuel == 2) {
			fuelType = "Diesel";
		} else if (choiceFuel == 3) {
			fuelType = "Hybrid";
		}

		System.out.println("\nAvailable " + carType + " sizes:");
		System.out.println("(1) Medium"); //glc, gle coupe
		System.out.println("(2) Large"); //gle, gls class
		System.out.print("What size " + carType + " do you prefer? ");
		int choiceSize = userInputInt.nextInt();

		String carSize="Medium";//by default
		if(choiceSize==1){
			carSize="Medium";
		}
		else if(choiceSize==2){
			carSize="Large";
		}
		System.out.println("\nDo you prefer a " + carType + " with a sport look? ");
		System.out.println("(1) Yes"); //amg
		System.out.println("(2) No"); 
		System.out.print("Enter choice: "); 
		int choiceSport = userInputInt.nextInt();

		String sport="No";//by default
		if(choiceSport==1){
			sport="Yes";
		}
		else if(choiceSport==2){
			sport="No";
		}

		viewByFilter (minBudget, maxBudget, sport, fuelType,carType,carSize);
	}


	//This method filters cars by car user choice
	private static car viewByFilter(Double min, Double max, String sport, String fuelType,
			String carType,String carSize){
		car foundCar=null;


		System.out.println("Your filters were: ");
		System.out.println("Car Type = " + carType +"\n"+
				"Min Price= " + min +"\n"+
				"Max Price= " + max +"\n"+
				"Size= "+ sport +"\n"+
				"Size= "+ carSize +"\n"+
				"FuelType= " + fuelType+"\n");
		System.out.println("Searching our database. please wait....");

		for(int i=0;i<carArrayList.size();i++){
			if(carArrayList.get(i).getBasePrice() <=max && carArrayList.get(i).getBasePrice() >=min &&
					carArrayList.get(i).getFuelType().equalsIgnoreCase(fuelType) &&
					carArrayList.get(i).isSport().equalsIgnoreCase(sport)&&
					carArrayList.get(i).getCarType().equalsIgnoreCase(carType) &&
					carArrayList.get(i).getSize().equalsIgnoreCase(carSize)
					){

				System.out.println("Congratulations! Found a match. Recommended car for you: " 
						+ "Car name: " + carArrayList.get(i).getCarName() + "\t" +
						"Car price: " + carArrayList.get(i).getBasePrice());
				foundCar = carArrayList.get(i);

				System.out.println("Do you want to see all the details of the recommended car?:\n"
						+ "(1) Yes\n"
						+ "(2) No");
				int choiceDetails = userInputInt.nextInt();

				if(choiceDetails == 1){
					System.out.println("Details of recommended car: " + carArrayList.get(i).toString());
				}		                
			}
		} //end for loop     
		if(foundCar==null){;
		viewByFilterPrice (sport, fuelType, carType, carSize);
		}      
		return foundCar;
	}

	private static car viewByFilterPrice (String sport, String fuelType,String carType,String carSize){
		car foundCar=null;

		for(int i=0;i<carArrayList.size();i++){
			if(carArrayList.get(i).getFuelType().equalsIgnoreCase(fuelType) &&
					carArrayList.get(i).isSport().equalsIgnoreCase(sport)&&
					carArrayList.get(i).getCarType().equalsIgnoreCase(carType) &&
					carArrayList.get(i).getSize().equalsIgnoreCase(carSize)
					) {

				System.out.println("Sorry, No match found! We only found a car outside your price range: "
						+ "Car name: " + carArrayList.get(i).getCarName() + "\t" 
						+ "Car price: " + carArrayList.get(i).getBasePrice());
				foundCar = carArrayList.get(i);

				System.out.println("Do you want to see all the details of the recommended car?\n"
						+ "(1) Yes\n"
						+ "(2) No");
				int choiceDetails = userInputInt.nextInt();

				if(choiceDetails == 1){
					System.out.println("Details of recommended car: " + carArrayList.get(i).toString());
					
				}		                
			}
		}

		if(foundCar==null){
			System.out.println("Sorry, no match found!");
		}
		
		return foundCar;
		
	}

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

	public static ArrayList<car> readCarList(){
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

return new ArrayList<car>();
}
	}