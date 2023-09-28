//Written by: Su Win

package vehicles;

public class Car extends Vehicle{
	private int doors = 0;
	
	/*In the instruction, "Cars have 4 wheels and cargo space. 
	 * Cars also have either 2 or 4 doors." So, set the default as 2 doors 
	 * since car can have at least 2 doors.
	 */
	public Car() {
		this.doors = 2;
		super.setWheels(4);
	}

	public Car(int doors) {
		this();
		if(doors == 2 || doors == 4) {
			this.doors = doors;
		}else {
			throw new IllegalArgumentException("Car doors can only be 2 or 4.");
		}
	}
	
	public Car(int wheels, double cargoSpace, String color, int doors) {
		super(wheels, cargoSpace, color);
		if (wheels == 4) {
			super.setWheels(wheels);
		}else {
			throw new IllegalArgumentException("Car can only have 4 wheels.");
		}
		setDoors(doors);
	}
	
	//getter and setter
	public int getDoors() {
		return this.doors;
	}
	
//Cars have either 2 or 4 doors. If not throw IllegallArguemntException
	public void setDoors(int doors) {
		if(doors == 2 || doors == 4) {
			this.doors = doors;
		}else {
			throw new IllegalArgumentException("Car doors can only be 2 or 4.");
		}
	}
	
	public String PressGasPedal() {
		return "accelerating";
	}
	
	@Override
	public String toString() {
		return "\n"+ super.toString() + ", Doors: " + this.doors ;
	}
	
	//return true if the field values of the class and its superclass(es) are equal
	@Override
	public boolean equals(Object otherObject) {
		if(!super.equals(otherObject)) return false;
		Car other = (Car) otherObject;
		return doors == other.doors;
	}
}