//main.java
import java.util.Scanner;
//this is the main class for the program that will be ran 
/*it should:
-prompt the user to enter the details of a new vehicle CHECK!
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

    private final Scanner scanner = new Scanner(System.in); //create a scanner object to get user input for the getInput function
    public String getInput(String prompt) { //function to get the user input, condensed into one function
        System.out.println("Enter " + prompt + ": ");
        return scanner.nextLine();
    }
    public static void main(String[] args) {
        main program = new main();
        System.out.println(welcomeMsg); //print the welcome message first off
        String make = program.getInput("make");
        String model = program.getInput("model");
        int year = Integer.parseInt(program.getInput("year"));
        int fuelCapacity = Integer.parseInt(program.getInput("fuel capacity"));
        Vehicle vehicle = new Vehicle(make, model, year, fuelCapacity); //create a new vehicle object to store the user input above
        //now lets "start" the vehicle
        vehicle.start();
    }
}
