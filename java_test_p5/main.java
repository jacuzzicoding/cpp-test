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
-demonstrate unique features of each vehicle type CHECK!
*/
public class Main {
    
/* CONSTANTS */
    private static final int MAX_VEHICLES = 100; // Maximum number of vehicles as per requirements
    private static final String WELCOME_MSG = "Welcome to Tom's Garage!\n"; 

/* PROPERTIES */
    private final Scanner scanner = new Scanner(System.in);
    private Vehicle[] garage = new Vehicle[MAX_VEHICLES]; // Array to store vehicles in garage
    private int vehicleCount = 0; // variable to keep track of how many vehicles are in the garage, ititialized to 0

/* FUNCTIONS FOR MAIN */
    private String getInput(String prompt) { //function to get the user input as a string
        System.out.print("Enter " + prompt + ": "); //prompt the user to enter the details of the vehicle
        return scanner.nextLine(); 
    }

    //function to demonstrate unique features of each vehicle type
    private void demonstrateUniqueFeatures() {
        System.out.println("\n---Demonstrating Unique Vehicle Features---");
        for (int i = 0; i < vehicleCount; i++) {
            if (garage[i] instanceof Car) {
                ((Car) garage[i]).toggleAC();
            } else if (garage[i] instanceof Truck) {
                ((Truck) garage[i]).loadCargo();
                ((Truck) garage[i]).toggleTrailer();
            } else if (garage[i] instanceof Bike) {
                ((Bike) garage[i]).toggleKickstand();
            }
        }
    }

    private Vehicle createVehicle() { 
        // First ask what type of vehicle they want to create
        System.out.print("Enter vehicle type (Car/Truck/Bike): ");
        String type = scanner.nextLine().toLowerCase(); //get the user input for the type of vehicle, convert to lowercase so it wont be case sensitive

        // Get common vehicle details
        String make = getInput("make"); //get the user input for the make of the vehicle
        String model = getInput("model"); //model input
        int year = Integer.parseInt(getInput("year")); //year input
        int fuelCapacity = Integer.parseInt(getInput("fuel capacity")); //fuel capacity input

        // Create appropriate engine based on vehicle type
        Engine engine; //create an engine object to go with the new vehicle
        switch(type) { //using a switch statement to select the type of vehicle and then create the correct engine object
            case "car":
                engine = new Engine(6, "Car Engine"); //if its a car, create a car engine with 6 cylinders
                return new Car(make, model, year, fuelCapacity, engine); //return a new car object with the details entered by the user
            case "truck":
                engine = new Engine(8, "Truck Engine"); //8 cylinder truck engine
                return new Truck(make, model, year, fuelCapacity, engine); //returns a new truck
            case "bike":
                engine = new Engine(2, "Bike Engine"); //2 cylinder bike engine
                return new Bike(make, model, year, fuelCapacity, engine); //returns a new bike
            default:
                System.out.println("Invalid vehicle type. Creating a basic car."); //If the user enters an invalid vehicle type, create a basic car as a default option
                engine = new Engine(4, "Basic Engine"); //basic engine with 4 cylinders 
                return new Car(make, model, year, fuelCapacity, engine); //return a new car object
        }
    }

    private void displayAllVehicles() { //function to display all the vehicles currently in the garage
        System.out.println("\n--- Vehicle Information in Tom's Garage ---");
        for (int i = 0; i < vehicleCount; i++) { //loop through the vehicles in the garage
            System.out.println("---Vehicle #" + (i + 1) + "---"); //print the vehicle number
            System.out.println(garage[i].toString()); //print the vehicle details to go with the vehicle number
        }
    }

    private void startAllVehicles() { //function to start all the vehicles in the garage
        System.out.println("\n---Starting All Vehicles---");
        for (int i = 0; i < vehicleCount; i++) { //loop through all vehicles
            garage[i].start(); //start the vehicle(s)
        }
    }

    private void refuelAllVehicles() { //function to refuel all the vehicles in the garage at once
        System.out.println("\n---Refueling All Vehicles---");
        for (int i = 0; i < vehicleCount; i++) { 
            garage[i].refuel();
        }
    }

    private void stopAllVehicles() { //function to stop all the vehicles in the garage
        System.out.println("\n---Stopping All Vehicles---");
        for (int i = 0; i < vehicleCount; i++) {
            garage[i].stop();
        }
    }

    private void run() { //main function to run the program
        System.out.println(WELCOME_MSG); //print the welcome message
        
        // here we will prompt the user to enter the details of a new vehicle, and then ask if they want to enter another vehicle
        String addMore; //new variable to keep track of whether the user wants to add more vehicles or not
        do { //do while loop to keep asking the user if they want to add more vehicles until they say no (or n)
            if (vehicleCount >= MAX_VEHICLES) { //if the garage is full, print a message and break out of the loop (unlikely as it is set to 100)
                System.out.println("Garage is full! Cannot add more vehicles.");
                break;
            }
            
            garage[vehicleCount] = createVehicle(); // create a new vehicle object with the createVehicle function, this goes within the garage array
            vehicleCount++; //increment the vehicle count by 1 to keep track of how many vehicles are in the garage
            
            System.out.print("Do you want to enter another vehicle? (yes/no): ");
            addMore = scanner.nextLine().toLowerCase(); //converting to lowercase again to make sure it is not case sensitive
        } while (addMore.equals("yes") || addMore.equals("y")); //loop will continue as long as the user enters yes or y 

        // Display and operate all vehicles
        displayAllVehicles(); 
        startAllVehicles();
        refuelAllVehicles();
        stopAllVehicles();
        
        // Demonstrate unique features of each vehicle type
        demonstrateUniqueFeatures();
        
        scanner.close(); //close the scanner object
    }

    public static void main(String[] args) { //main function to run the program
        Main program = new Main();
        program.run(); //run the program using the giant run function 
    }
}