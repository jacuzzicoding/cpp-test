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
    public String inputMake() { //function to get the make of the vehicle
        System.out.println("Enter make: "); //msg to the user to prompt them to enter the make
        Scanner scanner = new Scanner(System.in); //create a scanner object to read the user input (java does this instead of something like cin in c++)
        String make = scanner.nextLine(); //read the user input
        return make; //return the make, so it is stored for the new vehicle
    }
    public String inputModel() { //function to get the model of the vehicle
        System.out.println("Enter model: "); //msg to the user to prompt them to enter the model
        Scanner scanner = new Scanner(System.in);
        String model = scanner.nextLine(); 
        return model; //return the model, so it is stored for the new vehicle
    }
    public String inputYear() { //function to get the year of the vehicle
        System.out.println("Enter year: "); //msg to the user to prompt them to enter the year
        Scanner scanner = new Scanner(System.in);
        String year = scanner.nextLine(); 
        return year; //return the year, so it is stored for the new vehicle
    }
    public String inputFuelCapacity() { //function to get the fuel capacity 
        System.out.println("Enter the fuel capacity: "); //msg to the user to prompt them to enter the fuel capacity
        Scanner scanner = new Scanner(System.in);
        String fuelCapacity = scanner.nextLine();
        return fuelCapacity; //return the fuel capacity, so it is stored for the new vehicle
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 2020, 50); //create a new vehicle object
        //create a new vehicle object
        Vehicle vehicle = new Vehicle(String make, String model, int year, int fuelCapacity); //create a new vehicle object
    }
}
