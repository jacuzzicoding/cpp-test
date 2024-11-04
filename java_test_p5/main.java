//main.java
//this is the main class for the program that will be ran 

public class main {
    //functions that main will call
    public static String welcomeMsg = "Welcome to Brock's Garage!\n Enter details for a new vehicle.\n"; //welcome message to the user
    public String getMake() {
        System.out.println("Enter make: "); //msg to the user to prompt them to enter the make
        String make = System.inlin.readLine(); //read the user input
    }
    public static void main(String[] args) {
        System.out.println(welcomeMsg); //print the welcome message to the user
    }
}

/* FUNCTIONS */

//this function will be used to get the user input for the vehicle make

