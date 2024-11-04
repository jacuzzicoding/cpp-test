//truck is a subclass of vehicle
public class Truck extends Vehicle { 
    //call the vehicle constructor, but with the truck subclass name so that the properties are inherited
	public Truck(String make, String model, int year, int capacity) {
		super(make, model, year, capacity); //super will call the constructor of the parent class
	}
	
}
