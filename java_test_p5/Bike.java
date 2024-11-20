//bike is a subclass of vehicle
public class Bike extends Vehicle {
    /* PROPERTIES */
    private boolean isKickstandDown; // Property to track kickstand position
    
    /* CONSTRUCTOR */
    public Bike(String make, String model, int year, int fuelCapacity, Engine engine) {
        super(make, model, year, fuelCapacity, engine);
        this.isKickstandDown = true; // Bikes start with kickstand down by default 
    }
    
    /* METHODS */
    @Override //unique starting method for bikes
    public void start() {
        System.out.println("Bike starts with a vroom.");
        System.out.println(getMake() + " " + getModel() + " starts.");
        getEngine().start();
    }
    
    // Unique method for bikes to toggle kickstand
    public void toggleKickstand() {
        isKickstandDown = !isKickstandDown;
        System.out.println("Kickstand " + (isKickstandDown ? "lowered" : "raised") + " on " + getMake() + " " + getModel());
    }
}