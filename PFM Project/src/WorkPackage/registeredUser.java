package WorkPackage;

public class registeredUser {

<<<<<<< Updated upstream
=======
	static Scanner userInputInt = new Scanner(System.in); 
	static Scanner userInputString = new Scanner(System.in); 
	static Scanner userInputDouble = new Scanner(System.in);

	private String email, password, phoneNumber;
	public String firstName, lastName;
	public int UserID;
	static int numberOfRegisteredUsers; //to keep count of the number of users

	public registeredUser(int UserID, String firstName, String lastName, String email, String password, String phoneNumber){
		this.UserID = UserID;
		this.firstName = firstName;
		this.lastName = lastName;	
		this.email = email;			
		this.password = password;
		this.phoneNumber = phoneNumber;

	}
	//idk where to put the rest tbh, nothing I try works and is full of errors for now:

	public static void logInSystem () {


		System.out.println("-----------------------------");
		System.out.println("Welcome to the car rec system.");
		System.out.println("-----------------------------");
		System.out.println("You have 3 choices");
		System.out.println("Choose 1 to log in");
		System.out.println("Choose 2 to register as a new user");
		System.out.println("Choose 3 to continue as guest");
		System.out.print("What would you want to choose?");

		int Choice = userInputInt.nextInt();

		if (Choice == 1) {
			System.out.print("Email address: ");
			String inputEmail = userInputString.nextLine();
			System.out.print("Password: ");
			String inputPassword = userInputString.nextLine();

			//now check if username and password match a registeredUser account (,then check if they match an admin account

			for(int i=0;i<registeredUser.numberOfRegisteredUsers;i++){
				logInID = LogOnMethod(inputEmail, inputPassword);

			}
		}


		if (Choice == 2) {
			// or??? public registeredUser (String email, String passsword, String firstName, String lastName, String phoneNumber, int userID) {
			// ask for input and send to tempRegistration.txt

			System.out.print("Welcome to register process!\nPlease type relevant info when prompted.\n");

			System.out.print("Your email address (used for log in): ");
			email = userInputString.nextLine();	

			System.out.print("Your password: ");
			this.password = userInputString.nextLine();		

			System.out.print("Your first name: ");
			this.firstName = userInputString.nextLine();	

			System.out.print("Your last name: ");
			this.lastName = userInputString.nextLine();

			System.out.print("Your phone number: ");
			this.phoneNumber = userInputString.nextLine();		

			this.userID = (int) (Math.random() * 10000);

			registeredUser User1 = new registeredUser(this.email, this.password, this.firstName, this.lastName, this.phoneNumber, this.userID);

		}	// end register()


		if (Choice == 3) {
			//enter as guest.
		}

		//LogOnMethod

		public int LogOnMethod(String inputEmail, String inputPassword){ //returns the ID if login correct

			if(email.equals(inputEmail) && password.equals(inputPassword)){ //
				//Login Success:

				System.out.println("--------------------------------------------------------");
				System.out.println("Welcome "+ firstName + " " + lastName);
				return(1);
			}
			else return(0);

	}
>>>>>>> Stashed changes
}
