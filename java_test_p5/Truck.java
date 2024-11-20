//truck is a subclass of vehicle
public class Truck extends Vehicle {
    /* PROPERTIES */
    private boolean isTrailerAttached; // Property to track if a trailer is attached
    
    /* CONSTRUCTOR */
    public Truck(String make, String model, int year, int fuelCapacity, Engine engine) {
        super(make, model, year, fuelCapacity, engine);
        this.isTrailerAttached = false; // Trucks start with no trailer
    }
    
    /* METHODS */
    @Override
    public void start() {
        System.out.println("Truck starts with a heavy roar."); //unique starting msg for trucks
        System.out.println(getMake() + " " + getModel() + " starts.");
        getEngine().start();
    }

    public void loadCargo() {
        System.out.println("Loading cargo into " + getMake() + " " + getModel());
    }
    
    // Unique method for trucks to attach/detach trailer
    public void toggleTrailer() {
        isTrailerAttached = !isTrailerAttached;
        System.out.println("Trailer " + (isTrailerAttached ? "attached to" : "detached from") + " " + getMake() + " " + getModel());
    }
}