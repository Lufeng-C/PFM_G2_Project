# PFM_G2_Project Instruction

Hi Yashar/Ayman/Project Evaluator!

Thank you for trying the Mercedes-Benz car-recommendation system.
This system is designed to provide you with the best possible Mercedes car for your needs. The system consists of a few parts (classes), we will cover them one by one:

BEFORE STARTING(!): MAGNIFY THE ECLIPSE CONSOLE TO OPTIMALLY ENJOY THE RECOMMENDATION SYSTEM.

Main class:
  The main class is the engine of the code. It redirects the user to a welcoming message and beginning menu. Here you enter the System and can navigate to other     parts of the system. There are a few options you can choose from:
   
   1: log In (for registered users & the admin)
        When you want to login, you first need to have registered as a user. 
        Private:
        If you want to login as admin, you need to fill in the following details:
        email: adminPFM
        password: admin
        
   2: register as a user
        Once you register, you need admin approval before you can login. So, after registering, make sure to log in as admin to approve yourself. 
   
   3: continue as a guest
        If you continue as a guest, you can obtain only one car recommendation and miss out on the great perks of being a registered user...
   
   4: exit the system


Registered User:
  The registered User class allows the user to obtain great car recommendations. From a wide variety of Mercedes Benz cars, the system picks the best car according   to the users preferences.
  Consequently, the user can save a car as a favorite, after which he will be notified about the favorite car by email.
  Also, the user can delete his account or logout and return to the starting main menu. 
  Registered users are stored in the permRegistration.txt


Unregistered User (guest):
  The unregistered (guest) user can only obtain only one car recommendation, after which the guest user will exit the system. He would have to re-run the program before and will be asked to register. 
Unregistered users are stored in the tempRegistration.txt

Admin:
  When logged in as admin, the following type of operations can be performed: User Operations and Car Operations.
  User operations consist of:
        1: approving registered users
        2: viewing a list of all registered users
        3: removing a registered user

  Car Operations consist of:
        1: adding a new car to the recommendation system
        2: view a list of all cars
        3: delete a car
        4: edit the details of a car

Car:
The car class is used for creating objects of class car and is used throughout the user and admin classes.

For further questions, I refer you to the java code, in which we put a wide variety of comments. 

Enjoy the car recommendation system and we hope to find you a great car!




