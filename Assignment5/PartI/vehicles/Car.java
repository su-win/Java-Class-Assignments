//Written by: Su Win

package vehicles;

public class Car extends Vehicle {

private int doors = 2;
	
	/*In the assign 4 instruction, "Cars have 4 wheels and cargo space. 
	 * Cars also have either 2 or 4 doors." So, set the default as 2 doors 
	 * since car can have at least 2 doors.
	 */

	public Car() {
		this.doors = 2;
	}

	public Car(int wheels, double cargoSpace, String color, int doors) throws VehicleException{
		super(wheels, cargoSpace, color);
		//in addition to the assign 4's rules, we add one more rule here: car doors cannot be less than 2.
		//So, if car doors is less than 2 throw VehicleException
		//if car doors equal to 2 or 4, set the door. If not throw VehicleException
		if (doors <2) {
			throw new VehicleException("Cars cannot have fewer than 2 doors");
		}else if (doors == 2 || doors == 4){
			this.setDoors(doors);
		}else{
			throw new VehicleException("Cars can only have either 2 or 4 doors.");
		}
		
		//based on previous assignment, we set rules for car wheels as 4
		//if wheels is not 4, it throw VehicleException
		if (wheels == 4) {
			this.setWheels(wheels);
		}else {
			throw new VehicleException("Car can only have 4 wheels.");
		}

	}
	
	//getter and setter
	public int getDoors() {
		return this.doors;
	}
	
	public void setDoors(int doors) {
		this.doors = doors;
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
