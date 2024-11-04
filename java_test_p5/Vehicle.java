//this will be the parent class for all vehicle types



public class Vehicle {
    
    private String make; // Property "make" to store the make of the vehicle
    private String model; // Property "model" to store the model of the vehicle
    private int year; // Property "year" to store the year of the vehicle
    private int fuelCapacity; // Property "fuelCapacity" to store the fuel capacity of the vehicle
    
    // Getter for make
    public String getMake() {
        return make;
    }
    // Getter for model
    public String getModel() {
        return model;
    }
    // Getter for year
    public int getYear() {
        return year;
    }
    // Getter for fuelCapacity
    public int getFuelCapacity() {
        return fuelCapacity;
    }
}
    //here we will create the child classes for the different vehicle types
    public class Truck extends Vehicle {
        //code here
    }
    public class Car extends Vehicle {
        //code here
    }
    public class Engine extends Vehicle {
        //code here
    }
    public class Bike extends Vehicle {
        //code here
    }
    public class main extends Vehicle {
        //code here
    }

