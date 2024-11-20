public class Truck extends Vehicle {
    /* PROPERTIES */
    private boolean isTrailerAttached; // Property to track if a trailer is attached
    
    /* CONSTRUCTOR */
    public Truck(String make, String model, int year, double mileage) {
        super(make, model, year, mileage);
        this.isTrailerAttached = false; // Trucks start with no trailer
    }
    
    // Unique method for trucks to attach/detach trailer
    public void toggleTrailer() {
        isTrailerAttached = !isTrailerAttached;
        System.out.println("Trailer " + (isTrailerAttached ? "attached to" : "detached from") + " " + getMake() + " " + getModel());
    }
}