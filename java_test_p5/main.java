//main.java
//this is the main class for the program that will be ran 
/*it should:
-prompt the user to enter the details of a new vehicle
-ask if they want to enter another vehicle, 
-if yes, prompt the user to enter the details of a new vehicle
-if no, print the details of the vehicles entered
    -details include: make, model, year, fuel capacity
    -simulate "starting" the vehicle(s) and print the fuel level
    -should allow user to refuel the vehicle(s) and print the fuel as being full
    -simulate "stopping" the vehicle(s) and print the fuel level
*/
public class main {
/*FUNCTIONS FOR MAIN */
    public static String welcomeMsg = "Welcome to Tom's Garage!\n Enter details for a new vehicle.\n"; //welcome message to the user
    public String getMake() { //function to get the make of the vehicle
        System.out.println("Enter make: "); //msg to the user to prompt them to enter the make
        String make = System.inlin.readLine(); //read the user input
        return make; //return the make, so it is stored for the new vehicle
    }
    public String getModel() { //function to get the model of the vehicle
        System.out.println("Enter model: "); //msg to the user to prompt them to enter the model
        String model = System.inlin.readLine(); //read the user input
        return model; //return the model, so it is stored for the new vehicle
    }

    public static void main(String[] args) {
        System.out.println(welcomeMsg); //print the welcome message to the user
    }
}
\