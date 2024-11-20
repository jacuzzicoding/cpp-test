import java.util.Scanner;
public class Main {
    
/* CONSTANTS */
    private static final int MAX_VEHICLES = 100; // Maximum number of vehicles as per requirements is 100
    private static final String WELCOME_MSG = "Welcome to Tom's Garage!\n"; //keeping all of this from last week's assignment

/* PROPERTIES */
    private final Scanner scanner = new Scanner(System.in);
    private Vehicle[] garage = new Vehicle[MAX_VEHICLES]; // Array to store vehicles in garage
    private int vehicleCount = 0; // variable to keep track of how many vehicles are in the garage, initialized to 0

/* FUNCTIONS FOR MAIN */
    private String getInput(String prompt) { //function to get the user input as a string
        System.out.print("Enter " + prompt + ": "); //prompt the user to enter the details of the vehicle
        return scanner.nextLine();  //return the user input using the scanner object
    }

    //function to demonstrate unique features of each vehicle type
    private void demonstrateUniqueFeatures() {
        System.out.println("\n---Demonstrating Unique Vehicle Features---");
        for (int i = 0; i < vehicleCount; i++) {
            if (garage[i] instanceof Car) {
                ((Car) garage[i]).toggleAC();
            } else if (garage[i] instanceof Truck) {
                ((Truck) garage[i]).toggleTrailer();
            } else if (garage[i] instanceof Motorcycle) {
                ((Motorcycle) garage[i]).toggleKickstand();
            }
        }
    }

    private Vehicle createVehicle() { 
        // First ask what type of vehicle they want to create
        System.out.print("Enter vehicle type (Car/Truck/Motorcycle): ");
        String type = scanner.nextLine().toLowerCase(); //get the user input for the type of vehicle, convert to lowercase

        // Get common vehicle details
        String make = getInput("make"); //get the user input for the make of the vehicle
        String model = getInput("model"); //model input
        int year = Integer.parseInt(getInput("year")); //year input
        double mileage = Double.parseDouble(getInput("mileage")); //mileage input (changed from fuel capacity)

        // Create and return the appropriate vehicle type
        switch (type) {
            case "car":
                return new Car(make, model, year, mileage);
            case "truck":
                return new Truck(make, model, year, mileage);
            case "motorcycle":
            case "bike": // allow 'bike' as an alternative input
                return new Motorcycle(make, model, year, mileage);
            default:
                System.out.println("Invalid vehicle type! Creating a Car by default.");
                return new Car(make, model, year, mileage);
        }
    }
    
    private void displayAllVehicles() { //function to display all the vehicles currently in the garage
        System.out.println("\n--- Vehicle Information in Tom's Garage ---");
        for (int i = 0; i < vehicleCount; i++) { //loop through the vehicles in the garage
            System.out.println("---Vehicle #" + (i + 1) + "---"); //print the vehicle number
            System.out.println(garage[i].toString()); //print the vehicle details to go with the vehicle number
        }
    }

    private void run() { //main function to run the program
        System.out.println(WELCOME_MSG); //print the welcome message
        
        String addMore; //new variable to keep track of whether the user wants to add more vehicles or not
        do { //do while loop to keep asking the user if they want to add more vehicles until they say no (or n)
            if (vehicleCount >= MAX_VEHICLES) { //if the garage is full, print a message and break out of the loop (unlikely as it is set to 100)
                System.out.println("Garage is full! Cannot add more vehicles.");
                break;
            }
            
            garage[vehicleCount] = createVehicle(); // create a new vehicle object with the createVehicle function
            vehicleCount++; //increment the vehicle count
            
            System.out.print("Do you want to enter another vehicle? (yes/no): ");
            addMore = scanner.nextLine().toLowerCase(); //converting to lowercase again for case insensitivity
        } while (addMore.equals("yes") || addMore.equals("y")); //loop will continue as long as the user enters yes or y 

        // Display vehicles and demonstrate features
        displayAllVehicles(); 
        demonstrateUniqueFeatures();
        
        scanner.close(); //close the scanner object
    }

    public static void main(String[] args) { //main function to run the program
        Main program = new Main();
        program.run(); //run the program using the giant run function 
    }
}