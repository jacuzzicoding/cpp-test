public class Motorcycle extends Vehicle {
    /* PROPERTIES */
    private boolean isKickstandDown; // Property to track kickstand position
    
    /* CONSTRUCTOR */
    public Motorcycle(String make, String model, int year, double mileage) {
        super(make, model, year, mileage);
        this.isKickstandDown = true; // Bikes start with kickstand down by default 
    }
    
    // Unique method for motorcycles to toggle kickstand
    public void toggleKickstand() {
        isKickstandDown = !isKickstandDown;
        System.out.println("Kickstand " + (isKickstandDown ? "lowered" : "raised") + " on " + getMake() + " " + getModel());
    }
}