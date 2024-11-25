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
        //returning the make, model, year, and mileage of the vehicle. %.1f is used to format the mileage to one decimal place. %s is needed to format the strings, %d for integers in java and %f for floating point numbers
        return String.format("Make: %s, Model: %s, Year: %d, Mileage: %.1f",  
         
        make, model, year, mileage);
    }
}
