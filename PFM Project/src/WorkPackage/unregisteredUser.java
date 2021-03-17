package WorkPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import WorkPackage.car;

public class unregisteredUser {

	static Scanner userInputInt = new Scanner(System.in); 
	static Scanner userInputString = new Scanner(System.in); 
	static Scanner userInputDouble = new Scanner(System.in);
	private ArrayList<car> carArrayList; //car arraylist
	carOperations carOpsDriver = new carOperations();

	public void main() {
	}
	public static void unregisterUserMethod() {

		//this callingObject is used to call non-static method in a static method
		unregisteredUser callingObject = new unregisteredUser(); 

		int userChoice= getUserChoice();
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
		}


	}
	public static int getUserChoice()	{

		System.out.println("What cartype would you prefer ?" );	
		System.out.println("(1) Sedan" );
		System.out.println("(2) Van" );
		System.out.println("(3) Hatchback" );
		System.out.println("(4) Luxurious" );
		System.out.println("(5) SUV" );

		int CarType = userInputInt.nextInt();
		return CarType;

	}
	public void Sedan() {
		String carType = "Sedan";

		System.out.print("what is your budget? Enter Minimum: ");
		double minBudget = userInputDouble.nextDouble();

		System.out.print("what is your budget? Enter Maximum: ");
		double maxBudget = userInputDouble.nextDouble();

		System.out.println("What fueltype do you prefer? ");
		System.out.println("(1) Petrol"); //c250 or s500
		System.out.println("(2) Diesel"); //c220d or s400d
		System.out.println("(3) Hybrid"); //c300e or s400e
		System.out.println("(4) Electric"); //EQS
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

		System.out.println("What sized car do you prefer? ");
		System.out.println("(1) Medium"); //c class
		System.out.println("(2) Large"); //s class
		int choiceSize = userInputInt.nextInt();

		String carSize="small";//by default
		if(choiceSize==1){
			carSize="Medium";
		}
		else if(choiceSize==2){
			carSize="Large";
		}
		System.out.println("Do you prefer a car sport look? ");
		System.out.println("(1) Yes"); //c63 or s63 amg,
		System.out.println("(2) No"); 
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

		System.out.print("what is your budget? Enter Minimum: ");
		double minBudget = userInputDouble.nextDouble();


		System.out.print("what is your budget? Enter Maximum: ");
		double maxBudget = userInputDouble.nextDouble();


		System.out.println("What fueltype do you prefer? ");
		System.out.println("(1) Diesel"); //v200, v220 or v300
		System.out.println("(2) Electric"); //eqv
		int choiceFuel = userInputInt.nextInt();

		String fuelType = "Diesel";//default
		if (choiceFuel == 1) {
			fuelType = "Diesel";
		} else if (choiceFuel == 2) {
			fuelType = "Electric";
		}
		System.out.println("What sized van do you prefer? ");
		System.out.println("(1) Standard"); //v class
		System.out.println("(2) Extra long"); //v class L
		int choiceSize = userInputInt.nextInt();

		String carSize="Standard";//by default
		if(choiceSize==1){
			carSize="Standard";
		}
		else if(choiceSize==2){
			carSize="Extra long";
		}
		System.out.println("Do you prefer a van with a sport look? ");
		System.out.println("(1) Yes"); //amg line,
		System.out.println("(2) No"); //default v class
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

		System.out.print("what is your budget? Enter Minimum: ");
		double minBudget = userInputDouble.nextDouble();

		System.out.print("what is your budget? Enter Maximum: ");
		double maxBudget = userInputDouble.nextDouble();


		System.out.println("What fueltype do you prefer? ");
		System.out.println("(1) Petrol"); //a200, a45
		System.out.println("(2) Diesel"); //a220d
		int choiceFuel = userInputInt.nextInt();

		String fuelType = "Petrol";//default
		if (choiceFuel == 1) {
			fuelType = "Petrol";
		} else if (choiceFuel == 2) {
			fuelType = "Diesel";
		} 

		System.out.println("What sized car do you prefer? ");
		System.out.println("(1) Small"); //a class
		System.out.println("(2) Medium"); //gla class
		int choiceSize = userInputInt.nextInt();

		String carSize="Small";//by default
		if(choiceSize==1){
			carSize="Small";
		}
		else if(choiceSize==2){
			carSize="Medium";
		}
		System.out.println("Do you prefer a car with a sport look? ");
		System.out.println("(1) Yes"); //a45 or a220 amg line
		System.out.println("(2) No"); 
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

		System.out.print("what is your budget? Enter Minimum: ");
		double minBudget = userInputDouble.nextDouble();

		System.out.print("what is your budget? Enter Maximum: ");
		double maxBudget = userInputDouble.nextDouble();


		System.out.println("What fueltype do you prefer? ");
		System.out.println("(1) Petrol");
		System.out.println("(2) Diesel");
		System.out.println("(3) Hybrid");
		int choiceFuel = userInputInt.nextInt();

		String fuelType = "Petrol";//default
		if (choiceFuel == 1) {
			fuelType = "Petrol";
		} else if (choiceFuel == 2) {
			fuelType = "Diesel";
		} else if (choiceFuel == 3) {
			fuelType = "Hybrid";
		}

		System.out.println("What sized car do you prefer? ");
		System.out.println("(1) Medium"); //s class
		System.out.println("(2) Large"); //gls class, v class luxury edition
		int choiceSize = userInputInt.nextInt();

		String carSize="Medium";//by default
		if(choiceSize==1){
			carSize="Medium";
		}
		else if(choiceSize==2){
			carSize="Large";
		}
		System.out.println("Do you prefer a car with a sport look? ");
		System.out.println("(1) Yes"); //amg line
		System.out.println("(2) No"); 
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

		System.out.print("what is your budget? Enter Minimum: ");
		double minBudget = userInputDouble.nextDouble();

		System.out.print("what is your budget? Enter Maximum: ");
		double maxBudget = userInputDouble.nextDouble();


		System.out.println("What fueltype do you prefer? "); //all can be gle or gls
		System.out.println("(1) Petrol"); //gle400 //gle63s amg
		System.out.println("(2) Diesel"); //gle300d
		System.out.println("(3) Hybrid"); //gle400e
		int choiceFuel = userInputInt.nextInt();

		String fuelType = "Petrol";//default
		if (choiceFuel == 1) {
			fuelType = "Petrol";
		} else if (choiceFuel == 2) {
			fuelType = "Diesel";
		} else if (choiceFuel == 3) {
			fuelType = "Hybrid";
		}

		System.out.println("What sized car do you prefer? ");
		System.out.println("(1) Medium"); //glc, gle coupe
		System.out.println("(2) Large"); //gle, gls class
		int choiceSize = userInputInt.nextInt();

		String carSize="Medium";//by default
		if(choiceSize==1){
			carSize="Medium";
		}
		else if(choiceSize==2){
			carSize="Large";
		}
		System.out.println("Do you prefer a car with a sport look? ");
		System.out.println("(1) Yes"); //amg
		System.out.println("(2) No"); 
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
	//filter cars by car user Choice
	private car viewByFilter(Double min, Double max, String sport, String fuelType,
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

		for(int i=0;i<this.carArrayList.size();i++){
			if(this.carArrayList.get(i).getBasePrice() <=max && this.carArrayList.get(i).getBasePrice() >=min &&
					this.carArrayList.get(i).getFuelType().equalsIgnoreCase(fuelType) &&
					this.carArrayList.get(i).isSport().equalsIgnoreCase(sport)&&
					this.carArrayList.get(i).getCarType().equalsIgnoreCase(carType) &&
					this.carArrayList.get(i).getSize().equalsIgnoreCase(carSize)
					){

				System.out.println("Congratulations! Found a Matching. Recommended Car for you: " 
						+ "Car name: " + this.carArrayList.get(i).getCarName() + "\t" +
						"Car price: " + this.carArrayList.get(i).getBasePrice());
				foundCar = this.carArrayList.get(i);

				System.out.println("Do you want to see all the details of the recommended car?:\n"
						+ "(1) Yes\n"
						+ "(2) No");
				int choiceDetails = userInputInt.nextInt();

				if(choiceDetails == 1){
					System.out.println("Details of recommended car: " + this.carArrayList.get(i).toString());
				}		                
			}
		}     
		if(foundCar==null){;
		viewByFilterPrice (sport, fuelType, carType, carSize);
		}      
		return foundCar;
	}

	public car viewByFilterPrice (String sport, String fuelType,String carType,String carSize){
		car foundCar=null;

		for(int i=0;i<this.carArrayList.size();i++){
			if(this.carArrayList.get(i).getFuelType().equalsIgnoreCase(fuelType) &&
					this.carArrayList.get(i).isSport().equalsIgnoreCase(sport)&&
					this.carArrayList.get(i).getCarType().equalsIgnoreCase(carType) &&
					this.carArrayList.get(i).getSize().equalsIgnoreCase(carSize)
					) {

				System.out.println("Sorry, No matching Found! We only found a car outside your price range: "
						+ "Car name: " + this.carArrayList.get(i).getCarName() + "\t" 
						+ "Car price: " + this.carArrayList.get(i).getBasePrice());
				foundCar = this.carArrayList.get(i);

				System.out.println("Do you want to see all the details of the recommended car?\n"
						+ "(1) Yes\n"
						+ "(2) No");
				int choiceDetails = userInputInt.nextInt();

				if(choiceDetails == 1){
					System.out.println("Details of recommended car: " + this.carArrayList.get(i).toString());
				}		                
			}
		}

		if(foundCar==null){
			System.out.println("Sorry, No matching Found!");
		}
		return foundCar;
	}
}