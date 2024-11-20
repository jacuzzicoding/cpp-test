public class Car extends Vehicle {
    // One unique property for Car
    private boolean hasAirConditioning;
    
    public Car(String make, String model, int year, int fuelCapacity, Engine engine) {
        super(make, model, year, fuelCapacity, engine);
        this.hasAirConditioning = true;  // Most modern cars have AC
    }
    
    // One unique method for Car
    public void toggleAC() {
        hasAirConditioning = !hasAirConditioning; //if the AC is on, turn it off. if it is off, turn it on
        System.out.println("AC is now " + (hasAirConditioning ? "on" : "off")); //print out the status of the AC depending on the value of hasAirConditioning
    }
    
    @Override
    public void start() {
        System.out.println("Car starts smoothly.");
        System.out.println(getMake() + " " + getModel() + " starts.");
        getEngine().start();
    }
}