package GroupAssigment;

import java.util.Arrays;
import java.util.Scanner;

public class GroupAss {
	static Scanner userInputInt= new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int userChoice= getUserChoice();
		switch (userChoice) {
	
	case 1:
		Sedan();
		break;
	
	case 2:
		Van();
		break;
	
	case 3:
		Hatchback();
		break;

	case 4:
		Luxurious();
		break;
	
	case 5:
		SUV();
		break;
		}
		
		
	}
		public static int getUserChoice()	{
		
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
	
 
 System.out.println("What cartype would you prefer ?" );	
 System.out.println("(1) Sedan" );
 System.out.println("(2) Van" );
 System.out.println("(3) Hatchback" );
 System.out.println("(4) Luxurious" );
 System.out.println("(5) SUV" );

 	int CarType = userInputInt.nextInt();
	return CarType;
 
	
	
	}
		
		
		public static void Sedan() {
			 System.out.println("What fueltype do you prefer? ");
			 System.out.println("(1) Petrol");
			 System.out.println("(2) Diesel");
			 System.out.println("(3) Hybrid");
			 System.out.println("(4) I don't have a preference");
			 int FuelChoice = userInputInt.nextInt();
			 
			 
			 System.out.println("What sized car do you prefer? ");
			 System.out.println("(1) Medium");
			 System.out.println("(2) Large");
			 System.out.println("(3) I don't have a preference");
			 int CarSize = userInputInt.nextInt();
			 
			 System.out.println("Do you prefer a car with a sporty look? ");
			 System.out.println("(1) Yes");
			 System.out.println("(2) No");
			 System.out.println("(3) I don't have a preference");
			 int SportsCar = userInputInt.nextInt();
			 
			
		int[] ChoicesSedan = new int[] {SportsCar, CarSize, FuelChoice};

		
		System.out.println(Arrays.toString(ChoicesSedan));
		}
		
		public static void Van() {
			 System.out.println("What fueltype do you prefer? ");
			 System.out.println("(1) Petrol");
			 System.out.println("(2) Diesel");
			 System.out.println("(3) Hybrid");
			 System.out.println("(4) I don't have a preference");
			 int FuelChoice = userInputInt.nextInt();
			 
			 
			 System.out.println("What sized car do you prefer? ");
			 System.out.println("(1) Medium");
			 System.out.println("(2) Large");
			 System.out.println("(3) I don't have a preference");
			 int CarSize = userInputInt.nextInt();
			 
			 System.out.println("Do you prefer a car with a sporty look? ");
			 System.out.println("(1) Yes");
			 System.out.println("(2) No");
			 System.out.println("(3) I don't have a preference");
			 int SportsCar = userInputInt.nextInt();
			 
			
		int[] ChoicesVan = new int[] {SportsCar, CarSize, FuelChoice};

		}
			
			
			
			
		public static void Hatchback() {
			 System.out.println("What fueltype do you prefer? ");
			 System.out.println("(1) Petrol");
			 System.out.println("(2) Diesel");
			 System.out.println("(3) Hybrid");
			 System.out.println("(4) I don't have a preference");
			 int FuelChoice = userInputInt.nextInt();
			 
			 
			 System.out.println("What sized car do you prefer? ");
			 System.out.println("(1) Small");
			 System.out.println("(2) Medium");
			 System.out.println("(3) I don't have a preference");
			 int CarSize = userInputInt.nextInt();
			 
			 System.out.println("Do you prefer a car with a sporty look? ");
			 System.out.println("(1) Yes");
			 System.out.println("(2) No");
			 System.out.println("(3) I don't have a preference");
			 int SportsCar = userInputInt.nextInt();
			 
			
		int[] ChoicesHatchback = new int[] {SportsCar, CarSize, FuelChoice};

		}
							
				
				
		public static void Luxurious() {
			 
			 System.out.println("What fueltype do you prefer? ");
			 System.out.println("(1) Petrol");
			 System.out.println("(2) Diesel");
			 System.out.println("(3) Hybrid");
			 System.out.println("(4) I don't have a preference");
			 int FuelChoice = userInputInt.nextInt();
			 
			 
			 System.out.println("What sized car do you prefer? ");
			 System.out.println("(1) Medium");
			 System.out.println("(2) Large");
			 System.out.println("(3) I don't have a preference");
			 int CarSize = userInputInt.nextInt();
			 
			 System.out.println("Do you prefer a car with a sporty look? ");
			 System.out.println("(1) Yes");
			 System.out.println("(2) No");
			 System.out.println("(3) I don't have a preference");
			 int SportsCar = userInputInt.nextInt();
			 
			
		int[] ChoicesLuxurious = new int[] {SportsCar, CarSize, FuelChoice};

		}
					
					
					
					
		public static void SUV() {
		
		 System.out.println("What fueltype do you prefer? ");
		 System.out.println("(1) Petrol");
		 System.out.println("(2) Diesel");
		 System.out.println("(3) Hybrid");
		 System.out.println("(4) I don't have a preference");
		 int FuelChoice = userInputInt.nextInt();
		 
		 
		 System.out.println("What sized car do you prefer? ");
		 System.out.println("(1) Medium");
		 System.out.println("(2) Large");
		 System.out.println("(3) I don't have a preference");
		 int CarSize = userInputInt.nextInt();
		 
		 System.out.println("Do you prefer a car with a sporty look? ");
		 System.out.println("(1) Yes");
		 System.out.println("(2) No");
		 System.out.println("(3) I don't have a preference");
		 int SportsCar = userInputInt.nextInt();
		 
		
	int[] ChoicesSUV = new int[] {SportsCar, CarSize, FuelChoice};

				}
			}
		 
