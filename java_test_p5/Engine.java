//the engine class is a separate class that will be used to create the engine object for the vehicle class
public class Engine {
    /* PROPERTIES */
    private int numCylinders; //need to take in the number of cylinders for the engine
    private String engineType; //and what type of engine it is

    /* CONSTRUCTOR */
    public Engine(int numCylinders, String engineType) {  //constructor for the engine class, taking in the number of cylinders and the type of engine
        this.numCylinders = numCylinders; //initializing the number of cylinders
        this.engineType = engineType; //initializing the type of engine
    }

    /* METHODS */
    public void start() { //method to start the engine, will print out a message saying the engine has started
        System.out.println("Engine with " + numCylinders + " cylinders starts.");
    }

    @Override
    public String toString() { //override the toString method to print out the engine details in a nice format
        return numCylinders + " Cylinder " + engineType;
    }
}