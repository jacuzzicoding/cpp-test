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
public class Main { // Changed to uppercase M to follow Java conventions
    
/* CONSTANTS */
    private static final int MAX_VEHICLES = 100; // Maximum number of vehicles as per requirements
    private static final String WELCOME_MSG = "Welcome to Tom's Garage!\n"; // Changed to constant naming convention

/* PROPERTIES */
    private final Scanner scanner = new Scanner(System.in);
    private Vehicle[] garage = new Vehicle[MAX_VEHICLES]; // Array to store vehicles
    private int vehicleCount = 0; // Track number of vehicles in garage

/* FUNCTIONS FOR MAIN */
    private String getInput(String prompt) { //function to get the user input, condensed into one function
        System.out.print("Enter " + prompt + ": ");
        return scanner.nextLine();
    }

    private Vehicle createVehicle() {
        // First ask what type of vehicle they want to create
        System.out.print("Enter vehicle type (Car/Truck/Bike): ");
        String type = scanner.nextLine().toLowerCase();

        // Get common vehicle details
        String make = getInput("make");
        String model = getInput("model");
        int year = Integer.parseInt(getInput("year"));
        int fuelCapacity = Integer.parseInt(getInput("fuel capacity"));

        // Create appropriate engine based on vehicle type
        Engine engine;
        switch(type) {
            case "car":
                engine = new Engine(6, "Car Engine");
                return new Car(make, model, year, fuelCapacity, engine);
            case "truck":
                engine = new Engine(8, "Truck Engine");
                return new Truck(make, model, year, fuelCapacity, engine);
            case "bike":
                engine = new Engine(2, "Bike Engine");
                return new Bike(make, model, year, fuelCapacity, engine);
            default:
                System.out.println("Invalid vehicle type. Creating a basic car.");
                engine = new Engine(4, "Basic Engine");
                return new Car(make, model, year, fuelCapacity, engine);
        }
    }

    private void displayAllVehicles() {
        System.out.println("\n--- Vehicle Information in Tom's Garage ---");
        for (int i = 0; i < vehicleCount; i++) {
            System.out.println("---Vehicle #" + (i + 1) + "---");
            System.out.println(garage[i].toString());
        }
    }

    private void startAllVehicles() {
        System.out.println("\n---Starting All Vehicles---");
        for (int i = 0; i < vehicleCount; i++) {
            garage[i].start();
        }
    }

    private void refuelAllVehicles() {
        System.out.println("\n---Refueling All Vehicles---");
        for (int i = 0; i < vehicleCount; i++) {
            garage[i].refuel();
        }
    }

    private void stopAllVehicles() {
        System.out.println("\n---Stopping All Vehicles---");
        for (int i = 0; i < vehicleCount; i++) {
            garage[i].stop();
        }
    }

    private void run() {
        System.out.println(WELCOME_MSG);
        
        // Add vehicles
        String addMore;
        do {
            if (vehicleCount >= MAX_VEHICLES) {
                System.out.println("Garage is full! Cannot add more vehicles.");
                break;
            }
            
            garage[vehicleCount] = createVehicle();
            vehicleCount++;
            
            System.out.print("Do you want to enter another vehicle? (yes/no): ");
            addMore = scanner.nextLine().toLowerCase();
        } while (addMore.equals("yes") || addMore.equals("y"));

        // Display and operate all vehicles
        displayAllVehicles();
        startAllVehicles();
        refuelAllVehicles();
        stopAllVehicles();
        
        scanner.close();
    }

    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    }
}