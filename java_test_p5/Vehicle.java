//this will be the parent class for all vehicle types



public class Vehicle {
    
/* PROPERTIES */
    private String make; // Property "make" to store the make of the vehicle
    private String model; // Property "model" to store the model of the vehicle
    private int year; // Property "year" to store the year of the vehicle
    private int fuelCapacity; // Property "fuelCapacity" to store the fuel capacity of the vehicle

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
/* CONSTRUCTOR */
    public Vehicle(String make, String model, int year, int fuelCapacity) { //creating the constructor using the properties i declared above
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelCapacity = fuelCapacity;
    }
}
/* CHILD CLASSES // commented out because they are in separate files
    public class Truck extends Vehicle {
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
*/
