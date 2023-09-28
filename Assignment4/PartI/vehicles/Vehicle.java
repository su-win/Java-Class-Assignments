//Written by: Su Win

package vehicles;

import java.util.Objects;

public class Vehicle {
	private static int next_id = 0;
	private int id = 0;
	private int wheels = 0; //number of wheels
	private double cargoSpace = 0;
	private String color = "";
	
	 /*in the instruction, it said "A Vehicle is any vehicle with wheels and 
	  * has a color and has a certain amount of cargo space". It doesn't
	  * mention specific value. We assume all vehicle could have at least 2 wheels. 
	  * So, we set default wheels as 2. We set color to be white as default.
	  * We also assume some vehicle might not have cargo space at all.
	  * So, we set the cargoSpace to be 0 as default.
	  */
	
	//Default Constructor
	public Vehicle() {
		this.color = "white"; 
		this.wheels=2;
		this.cargoSpace=0;
		Vehicle.next_id++;
		this.id = Vehicle.next_id;		
	}
	
	//argument Constructor
	public Vehicle(int wheels, double cargoSpace, String color) {
		this();
		this.cargoSpace = cargoSpace;
		if (color != null)
			this.color = color;
	}
	
	//getter and setter Methods
	public int getWheels() {
		return wheels;
	}
	
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	
	public double getCargoSpace() {
		return cargoSpace;
	}
	
	public void setCargoSpace(double cargoSpace) {
		this.cargoSpace = cargoSpace;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		if(color != null)
			this.color = color;
	}
	
	//other methods
	public String toString() {
		return  "Vehicle ID: " + this.id + 
				"\nClass: " + this.getClass().getName() + //returns the class name
				"\nNumber of Wheels: " + this.wheels +
				", Cargo Space: " + this.cargoSpace + 
				", Color: " + this.color;
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean equals(Object otherObject) {
		if(this == otherObject) return true; //return true if objects are identical
		if(otherObject == null) return false; //return false if explicit parameter is null
		if(getClass() != otherObject.getClass()) return false; //if classes don't match return false
		Vehicle other = (Vehicle) otherObject; //cast obj to variable of class type
		return wheels == other.wheels //testing whether data fields have identical values
				&& cargoSpace == other.cargoSpace
				&& Objects.equals(color, other.color);
	}
	
}
