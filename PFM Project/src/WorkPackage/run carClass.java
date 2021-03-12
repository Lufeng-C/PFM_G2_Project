package Benz;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private ArrayList<carClass> carArrayList; //car arraylist
	Scanner scanner=new Scanner(System.in);
	
    public void main() {
    this.carArrayList = readCarList();
 
    }
	public void run(){
		
		while (true) {
		System.out.println("WELCOME ADMIN");
        System.out.println("1) Add Car\n" +
                "2) View All Cars\n" +
                "3) Delete Car\n" + 
                "4) Edit car details\n" +
                "5) Exit system\n" +
                "Please enter your choice: ");
		
		int Choice = scanner.nextInt();
        scanner.nextLine();
        
		if (Choice == 1) {
			addCar();
			run();
		}
		else if (Choice == 2){
			viewAllCars();
			run();
		}
		else if(Choice == 3){
			deleteCar();
			run();
        }
        else if (Choice == 4) {
        	editCar();
        	run();
		}
		else;
			saveCarList();
		break;
		}
      }
	
		//add car
	    private void addCar(){
	        System.out.print("Enter Car Type: ");
	        String carType=scanner.nextLine();

	        System.out.print("Enter Car Model: ");
	        String carModel=scanner.nextLine();

	        System.out.print("Enter electric Equivalent: ");
	        String electricEquivalent=scanner.nextLine();

	        System.out.print("Enter Base Price: ");
	        double basePrice=scanner.nextDouble();
	        scanner.nextLine();

	        System.out.print("Enter Car Size: ");
	        String size=scanner.nextLine();

	        System.out.print("Is Sport: ");
	        String sport=scanner.nextLine();

	        System.out.print("Enter Body Type: ");
	        String bodyType=scanner.nextLine();

	        System.out.print("Enter Fuel Type: ");
	        String fuelType=scanner.nextLine();

	        carClass car = new carClass (carType, carModel, electricEquivalent, basePrice, size, sport, bodyType, fuelType);
	        carArrayList.add(car); //add to car arrayList
	    }
	    private void deleteCar(){
	        System.out.println("Available Car List...");
	        for(int i=0;i<this.carArrayList.size();i++){
	            System.out.println("Index: "+i+" "+this.carArrayList.get(i).toString());
	        }

	        System.out.print("Enter Selected index to delete car: ");
	        int index=scanner.nextInt();
	        scanner.nextLine();

	        if(index>=0 && index<this.carArrayList.size()){
	            //remove from car list
	            this.carArrayList.remove(index);
	            System.out.println("Removed!");
	        }
	        else {
	            System.out.println("Invalid Choice!");
	        }
	    }
	    private void viewAllCars(){
	        for(int i=0;i<this.carArrayList.size();i++){
	            System.out.println(this.carArrayList.get(i).toString());
	        }
	    }
	    
	    private void editCar(){
	        System.out.println("Available Car List");
	        for(int i=0;i<this.carArrayList.size();i++){
	            System.out.println("Index: "+ i +" "+this.carArrayList.get(i).toString());
	        }

	        System.out.print("Enter Selected index to edit car: ");
	        int index=scanner.nextInt();
	        scanner.nextLine();

	        if(index>=0 && index<this.carArrayList.size()){

	            boolean editCompleted=false;
	            while(!editCompleted) {

	                System.out.println("What do you need to edit? \n" +
	                        "1) car type\n" +
	                        "2) car model\n" +
	                        "3) electric Equivalent:\n" +
	                        "4) Base price\n" +
	                        "5) Car size\n" +
	                        "6) sport\n" +
	                        "7) body type\n" +
	                        "8) fuel type");
	                System.out.print("Enter choice (number): ");
	                int choiceEdit = scanner.nextInt();
	                scanner.nextLine();

	                if (choiceEdit == 1) {
	                    System.out.print("Enter Car Type: ");
	                    String carType = scanner.nextLine();

	                    this.carArrayList.get(index).setCarType(carType);
	                    System.out.println("Changed!");
	                } else if (choiceEdit == 2) {
	                    System.out.print("Enter Car Model: ");
	                    String carModel = scanner.nextLine();

	                    this.carArrayList.get(index).setCarModel(carModel);
	                    System.out.println("Changed!");
	                } else if (choiceEdit == 3) {
	                    System.out.print("Enter electric Equivalent: ");
	                    String electricEquivalent = scanner.nextLine();

	                    this.carArrayList.get(index).setElectricEquivalent(electricEquivalent);
	                    System.out.println("Changed!");
	                } else if (choiceEdit == 4) {
	                    System.out.print("Enter Base Price: ");
	                    double basePrice = scanner.nextDouble();
	                    scanner.nextLine();

	                    this.carArrayList.get(index).setBasePrice(basePrice);
	                    System.out.println("Changed!");
	                } else if (choiceEdit == 5) {
	                    System.out.print("Enter Car Size: ");
	                    String size = scanner.nextLine();

	                    this.carArrayList.get(index).setSize(size);
	                    System.out.println("Changed!");
	                } else if (choiceEdit == 6) {
	                    System.out.print("Is Sport: ");
	                    String sport = scanner.nextLine();

	                    this.carArrayList.get(index).setSport(sport);
	                    System.out.println("Changed!");
	                } else if (choiceEdit == 7) {
	                    System.out.print("Enter Body Type: ");
	                    String bodyType = scanner.nextLine();

	                    this.carArrayList.get(index).setBodyType(bodyType);
	                    System.out.println("Changed!");
	                } else if (choiceEdit == 8) {
	                    System.out.print("Enter Fuel Type: ");
	                    String fuelType = scanner.nextLine();

	                    this.carArrayList.get(index).setFuelType(fuelType);
	                    System.out.println("Changed!");
	                } else {
	                    System.out.println("Invalid Input!");
	                }

	                System.out.print("Editing Completed? \n" +
	                        "1) Yes\n" +
	                        "2) No\n" +
	                        "Enter number:  ");
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
	                f = new FileOutputStream(new File("car_List.dat"));

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
	    public ArrayList<carClass> readCarList(){
	        FileInputStream fi = null;
	        try {
	            fi = new FileInputStream("car_List.dat");

	            ObjectInputStream oi = new ObjectInputStream(fi);

	            // Read objects
	            ArrayList<carClass> carArrayList = (ArrayList<carClass>) oi.readObject();

	            oi.close();
	            fi.close();
	            return carArrayList;

	        } catch (IOException | ClassNotFoundException e) {
//	            e.printStackTrace();
//	            System.out.println("Error Loading Car List");
	        }

	        return new ArrayList<carClass>();
	    }
public static void main(String[] args) {
	// TODO Auto-generated method stub
	Main mainDriver = new Main();
	mainDriver.main();
    mainDriver.run();
    
}
}
