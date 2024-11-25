public class Car extends Vehicle {
    // One unique property for Car
    private boolean hasAirConditioning; //simple true or false variable to determine if the car has air conditioning
    
    public Car(String make, String model, int year, double mileage) {
        super(make, model, year, mileage); // Call the parent (Vehicle) constructor
        this.hasAirConditioning = true;  // Most modern cars have AC so we can set this to true by default
    }
    
    public void toggleAC() {
        hasAirConditioning = !hasAirConditioning;
        System.out.println("AC is now " + (hasAirConditioning ? "on" : "off")); //if the AC is on, print "on", if its off, print "off"
    }
}