package WorkPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//public class carOperations { 
	private ArrayList<car> carArrayList; //car arraylist
	Scanner scanner=new Scanner(System.in);
	
    public void main() {
    this.carArrayList = readCarList();
 
    }
	//public void run(){
		
		while (true) {
		
			//choices for addCar 
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
			
			System.out.print("\n\nWould you like to perform another Car operation? Enter: 1: Yes || 2: No (return to Admin Menu): ");
			int adminchoice = scanner.nextInt();

			switch (adminchoice) {
			case 1: 
				run();
				saveCarList();
				break;
			case 2:
				saveCarList();
				admin.adminMenu();
				break;
			}
		}
		else if (Choice == 2){
			viewAllCars();
			
			System.out.print("\n\nWould you like to perform another Car operation? Enter: 1: Yes || 2: No (return to Admin Menu): ");
			int adminchoice = scanner.nextInt();

			switch (adminchoice) {
			case 1: 
				saveCarList();
				run();
				break;
			case 2:
				saveCarList();
				admin.adminMenu();
				break;
			}
		}
		else if(Choice == 3){
			deleteCar();
			
			System.out.print("\n\nWould you like to perform another Car operation? Enter: 1: Yes || 2: No (return to Admin Menu): ");
			int adminchoice = scanner.nextInt();

			switch (adminchoice) {
			case 1: 
				saveCarList();
				run();
				break;
			case 2:
				saveCarList();
				admin.adminMenu();
				break;
			}
        }
        else if (Choice == 4) {
        	editCar();
        	
        	System.out.print("\n\nWould you like to perform another Car operation? Enter: 1: Yes || 2: No (return to Admin Menu): ");
			int adminchoice = scanner.nextInt();

			switch (adminchoice) {
			case 1: 
				run();
				saveCarList();
				break;
			case 2:
				saveCarList();
				admin.adminMenu();
				break;
			}
		}
		else;
			saveCarList();
			admin.adminMenu();
		break;
		}
      }
	
		//add car
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
	    private void viewAllCars(){
	    	System.out.println("\nHere is a list of all the cars within the System: \n");
	        for(int i=0;i<this.carArrayList.size();i++){
	            System.out.println(this.carArrayList.get(i).toString());
	        }
	    }
	    
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
	        //below codes for save and load car array list
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
	            ArrayList<car> carArrayList = (ArrayList<car>) oi.readObject();

	            oi.close();
	            fi.close();
	            return carArrayList;

	        } catch (IOException | ClassNotFoundException e) {
//	            e.printStackTrace();
//	            System.out.println("Error Loading Car List");
	        }

	        return new ArrayList<car>();
	    }

}
