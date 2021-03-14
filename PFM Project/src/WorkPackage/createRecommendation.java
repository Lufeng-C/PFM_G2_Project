package rec;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class rec {
	Scanner scanner=new Scanner(System.in);
	private ArrayList<carClass> carArrayList; //car arraylist
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rec mainDriver = new rec();
		mainDriver.main();
	    mainDriver.recommendation();
	}
	
	public void main() {
	this.carArrayList = readCarList();
	
	}
	public void recommendation () {
		
		while (true) {
		System.out.println("WELCOME USER");
        System.out.println("2) Recommendation\n" +
                "Please enter your choice: ");
		
		int Choice = scanner.nextInt();
        scanner.nextLine();

		if (Choice == 2){
			createRecommendation();
			recommendation();
		}
		else;
		break;
		}
      }
			
private void createRecommendation() {
	 System.out.println("What cartype would you prefer ?" );	
	 System.out.println("(1) Sedan" );
	 System.out.println("(2) Van" );
	 System.out.println("(3) Hatchback" );
	 System.out.println("(4) Luxurious" );
	 System.out.println("(5) SUV" );

	 	int CarType = scanner.nextInt();
	 	scanner.nextLine();
	 if (CarType == 1) {
		 Sedan();
	 }
	 if (CarType == 2) {          
	 Van();
	 }
	 if (CarType == 3) {
		 Hatchback();
	 }
	 if (CarType == 4) {
	 Luxurious();
	 }
	 if (CarType == 5) {
	 SUV();
	 }
}
	public void Sedan() {
		String carType = "Sedan";
		
	    System.out.print("what is your budget? Enter Minimum: ");
        double minBudget=scanner.nextDouble();
        scanner.nextLine();
        
		System.out.print("what is your budget? Enter Maximum: ");
        double maxBudget=scanner.nextDouble();
        scanner.nextLine();

		 System.out.println("What fueltype do you prefer? ");
		 System.out.println("(1) Petrol"); //c250 or s500
		 System.out.println("(2) Diesel"); //c220d or s400d
		 System.out.println("(3) Hybrid"); //c300e or s400e
		 System.out.println("(4) Electric"); //EQS
		 int choiceFuel = scanner.nextInt();
		 
	      String fuelType = "Petrol";//default
          if (choiceFuel == 1) {
              fuelType = "Petrol";
          } else if (choiceFuel == 2) {
              fuelType = "Diesel";
          } else if (choiceFuel == 3) {
              fuelType = "Hybrid";
          }
		 
		 System.out.println("What sized car do you prefer? ");
		 System.out.println("(1) Medium"); //c class
		 System.out.println("(2) Large"); //s class
		 int choiceSize = scanner.nextInt();
		 
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
		 int choiceSport = scanner.nextInt();
		 
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
        double minBudget=scanner.nextDouble();
        scanner.nextLine();
        
		System.out.print("what is your budget? Enter Maximum: ");
        double maxBudget=scanner.nextDouble();
        scanner.nextLine();
				
		System.out.println("What fueltype do you prefer? ");
		 System.out.println("(1) Diesel"); //v200, v220 or v300
		 System.out.println("(2) Electric"); //eqv
		 System.out.println("(4) I don't have a preference");
		 int choiceFuel = scanner.nextInt();
		 
		 String fuelType = "Petrol";//default
         if (choiceFuel == 1) {
             fuelType = "Petrol";
         } else if (choiceFuel == 2) {
             fuelType = "Diesel";
         } else if (choiceFuel == 3) {
             fuelType = "Hybrid";
         }
         System.out.println("What sized van do you prefer? ");
		 System.out.println("(1) Standard"); //v class
		 System.out.println("(2) Extra long"); //v class L
		 int choiceSize = scanner.nextInt();
		 
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
		 int choiceSport = scanner.nextInt();
		 
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
        double minBudget=scanner.nextDouble();
        scanner.nextLine();
        
		System.out.print("what is your budget? Enter Maximum: ");
        double maxBudget=scanner.nextDouble();
        scanner.nextLine();

		 System.out.println("What fueltype do you prefer? ");
		 System.out.println("(1) Petrol"); //a200, a45
		 System.out.println("(2) Diesel"); //a220d
		 int choiceFuel = scanner.nextInt();
		 
	      String fuelType = "Petrol";//default
          if (choiceFuel == 1) {
              fuelType = "Petrol";
          } else if (choiceFuel == 2) {
              fuelType = "Diesel";
          } 
		 
		 System.out.println("What sized car do you prefer? ");
		 System.out.println("(1) Small"); //a class
		 System.out.println("(2) Medium"); //gla class
		 int choiceSize = scanner.nextInt();
		 
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
		 int choiceSport = scanner.nextInt();
		 
		 String sport="No";//by default
         if(choiceSport==1){
             sport="Yes";
         }
         else if(choiceSport==2){
             sport="No";
         }
	 
		 viewByFilter (minBudget, maxBudget, sport, fuelType,carType,carSize);
	}
	public void Luxurious() {
		String carType = "Luxurious";
		
	    System.out.print("what is your budget? Enter Minimum: ");
        double minBudget=scanner.nextDouble();
        scanner.nextLine();
        
		System.out.print("what is your budget? Enter Maximum: ");
        double maxBudget=scanner.nextDouble();
        scanner.nextLine();

        System.out.println("What fueltype do you prefer? ");
		System.out.println("(1) Petrol");
		System.out.println("(2) Diesel");
		System.out.println("(3) Hybrid");
		int choiceFuel = scanner.nextInt();
		 
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
		 int choiceSize = scanner.nextInt();
		 
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
		 int choiceSport = scanner.nextInt();
		 
		 String sport="No";//by default
         if(choiceSport==1){
             sport="Yes";
         }
         else if(choiceSport==2){
             sport="No";
         }

		 viewByFilter (minBudget, maxBudget, sport, fuelType,carType,carSize);
	}
	public void SUV() {
		String carType = "SUV";
		
	    System.out.print("what is your budget? Enter Minimum: ");
        double minBudget=scanner.nextDouble();
        scanner.nextLine();
        
		System.out.print("what is your budget? Enter Maximum: ");
        double maxBudget=scanner.nextDouble();
        scanner.nextLine();

        System.out.println("What fueltype do you prefer? "); //all can be gle or gls
		 System.out.println("(1) Petrol"); //gle400 //gle63s amg
		 System.out.println("(2) Diesel"); //gle300d
		 System.out.println("(3) Hybrid"); //gle400e
		 int choiceFuel = scanner.nextInt();
		 
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
		 int choiceSize = scanner.nextInt();
		 
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
		 int choiceSport = scanner.nextInt();
		 
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
    private carClass viewByFilter(Double min, Double max, String sport, String fuelType,String carType,String carSize){
        carClass foundCar=null;

        System.out.println("Your filters were: ");
        System.out.println("Car Type= " + carType +"\n"+
                " min Price= " + min +"\n"+
                " max Price= " + max +"\n"+
                " size= "+ sport +"\n"+
                " size= "+ carSize +"\n"+
                " fuelType= " + fuelType+"\n");
        System.out.println("Searching our database. please wait...");

        for(int i=0;i<this.carArrayList.size();i++){
            if(this.carArrayList.get(i).getBasePrice() <=max && this.carArrayList.get(i).getBasePrice() >=min &&
            this.carArrayList.get(i).getFuelType().equalsIgnoreCase(fuelType) &&
            this.carArrayList.get(i).isSport().equalsIgnoreCase(sport)&&
            this.carArrayList.get(i).getCarType().equalsIgnoreCase(carType) &&
            this.carArrayList.get(i).getSize().equalsIgnoreCase(carSize)
            ) {

                        System.out.println("Congratulations! Found a Matching. Recommended Car for you: \n"
                        +this.carArrayList.get(i).getCarName());
                        foundCar=this.carArrayList.get(i);
            }


        }

        if(foundCar==null){
            System.out.println("Sorry, No matching Found!");
        }
        return foundCar;
