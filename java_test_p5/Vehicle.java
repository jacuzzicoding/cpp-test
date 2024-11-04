//this will be the parent class for all vehicle types and provide general functionality for all vehicles

public abstract class Vehicle { // Made abstract since this is a base class that other vehicles will inherit from
   
    /* PROPERTIES */
       private String make; // Property "make" to store the make of the vehicle
       private String model; // Property "model" to store the model of the vehicle
       private int year; // Property "year" to store the year of the vehicle
       private int fuelCapacity; // Property "fuelCapacity" to store the fuel capacity of the vehicle
       private Engine engine; // Property "engine" to store the Engine object for this vehicle (composition)
       private double currentFuel; // Property to track how much fuel is currently in the vehicle
    
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
       public Engine getEngine() { // Getter for the engine object
           return engine;
       }
       public double getCurrentFuel() { // Getter for current fuel level
           return currentFuel;
       }
    
    /* SETTERS */
       public void setMake(String make) {// Setter for make, these are the methods that will be used to set the values of the properties to the child classes
           this.make = make;
       }
       public void setModel(String model) {
           this.model = model;
       }
       public void setYear(int year) {
           this.year = year;
       }
       public void setFuelCapacity(int fuelCapacity) {
           this.fuelCapacity = fuelCapacity;
       }
    
    /* CONSTRUCTOR */
       public Vehicle(String make, String model, int year, int fuelCapacity, Engine engine) { //creating the constructor using the properties declared above
           this.make = make;
           this.model = model;
           this.year = year;
           this.fuelCapacity = fuelCapacity;
           this.engine = engine;
           this.currentFuel = 0; // Vehicle starts with empty tank
       }
    
    /* METHODS */
       public abstract void start(); // Abstract method that all vehicles must implement - this ensures each vehicle type has its own unique starting behavior
       
       public void stop() { // Method to stop the vehicle
           System.out.println(make + " " + model + " stopped.");
       }
    
       // Method overloading example for refuel - we have two versions of the same method:
       // This version fills the tank completely
       public void refuel() {
           this.currentFuel = this.fuelCapacity;
           System.out.println(make + " " + model + " Refueling done - Fuel tank full.");
       }
    
       // This version adds a specific amount of fuel
       public void refuel(double amount) {
           if (this.currentFuel + amount > this.fuelCapacity) {
               System.out.println("Cannot overfill tank. Maximum capacity is " + this.fuelCapacity);
               return;
           }
           this.currentFuel += amount;
           System.out.println(make + " " + model + " Refueled with " + amount + " units of fuel.");
       }
    
       // toString method for printing vehicle information in a formatted way
       @Override
       public String toString() {
           return String.format("Make: %s%nModel: %s%nYear: %d%nEngine Type: %s", 
               make, model, year, engine.toString());
       }
    }