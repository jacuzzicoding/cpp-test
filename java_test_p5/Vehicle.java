//this will be the parent class for all vehicle types and provide general functionality for all vehicles

public abstract class Vehicle { // Made abstract since this is a base class that other vehicles will inherit from
   
    /* PROPERTIES */
       private String make; // Property "make" to store the make of the vehicle
       private String model; // Property "model" to store the model of the vehicle
       private int year; // Property "year" to store the year of the vehicle
       private double mileage; //new variable instead of fuel capacity


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
       public int getMileage() {
           return mileage
       }
       public Engine getEngine() { // Getter for the engine object
           return engine;
       }
       public double getCurrentFuel() { // Getter for current fuel level
           return currentFuel;
       }
    
  
    /* CONSTRUCTOR */
        public Vehicle(String make, String model, int year, double mileage) {
            this.make = make;
            this.model = model;
            this.year = year;
            this.mileage = mileage;
    }
    

    // toString method for displaying in the list
    @Override
    public String toString() {
        return String.format("Make: %s, Model: %s, Year: %d, Mileage: %.1f", 
            make, model, year, mileage);
    }
}
        /* METHODS //COMMENTED OUT FOR NOW
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
      */