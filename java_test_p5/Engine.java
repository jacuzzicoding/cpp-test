//the engine class is a separate class that will be used to create the engine object for the vehicle class
public class Engine {
    private int numCylinders; //need to take in the number of cylinders for the engine
    private String engineType; //and what type of engine it is

/*CONSTRUCTOR */
    public Engine(int numCylinders, String engineType) { 
        this.numCylinders = numCylinders;
        this.engineType = engineType;
    }
/*METHODS */
    public void start() {
        System.out.println("Engine with " + numCylinders + " cylinders starts.");
    }

    public void stop() {
        System.out.println("Engine stops.");
    }

    @Override //
    public String toString() {
        return numCylinders + " Cylinder " + engineType;
    }

    
}