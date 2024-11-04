//this will be the parent class for all vehicle types



public abstract class Vehicle { //parent class, abstract because its the base class for all vehicle types
    
/* PROPERTIES */
    private String make; // Property "make" to store the make of the vehicle
    private String model; // Property "model" to store the model of the vehicle
    private int year; // Property "year" to store the year of the vehicle
    private int fuelCapacity; // Property "fuelCapacity" to store the fuel capacity of the vehicle
    private Engine engine; // Property "engine" to store the engine of the vehicle as its own object
    private double currentFuelLevel; // Property "currentFuelLevel" to store the current fuel level of the vehicle

/* CONSTRUCTOR */
public Vehicle(String make, String model, int year, int fuelCapacity) { //creating the constructor using the properties i declared above
    this.make = make;
    this.model = model;
    this.year = year;
    this.fuelCapacity = fuelCapacity;
}

 /* GETTERS */
    public String getMake() { // Getter for make, these are the methods that will be used to give the values of the properties to the child classes
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public int getFuelCapacity() {
        return fuelCapacity;
    }
    public Engine getEngine() {
        return engine;
    }
    public double getCurrentFuel() {
        return currentFuelLevel;
    }
/* SETTERS */
    public void setMake(String make) {// Setter for make, these are the methods that will be used to set the values of the properties to the child classes
        this.make = make;
    }
    // Setter for model
    public void setModel(String model) {
        this.model = model;
    }
    // Setter for year
    public void setYear(int year) {
        this.year = year;
    }
    // Setter for fuelCapacity
    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

/* METHODS */
    public void start() {
        System.out.println("---Starting All Vehicles---");
        //now we need to use the vehicle objects to start the vehicles
        System.out.println("Starting the " + year + " " + make + " " + model + "...");
    }
}
