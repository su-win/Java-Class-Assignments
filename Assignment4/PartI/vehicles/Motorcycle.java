//Written by: Su Win

package vehicles;
import java.util.ArrayList;

public class Motorcycle extends Vehicle{
	
//In the instruction, it said, "Motorcycle have 2 wheels and 0 cargo space"
	private ArrayList<String> accessories = new ArrayList<String>();
	
	public Motorcycle() {
		this.accessories = null;
		super.setWheels(2);
		super.setCargoSpace(0);
	}

	public Motorcycle(ArrayList<String> accessories) {
		this();
		this.accessories = accessories;
	}
	
	/*we decided to override the setWheels and setCargoSpace*/
	public Motorcycle(int wheels, double cargoSpace, String color, ArrayList<String> accessories) {
		super(wheels, cargoSpace, color);
		setWheels(wheels);
		setCargoSpace(cargoSpace);
		/*We could simply use the override method to check valid number of wheels and
		 * valid cargo space OR we could check with if statement*/
//		if (wheels == 2) {//if statement to make sure create and object with 2 wheels
//			super.setWheels(wheels);
//		}else {
//			throw new IllegalArgumentException("Motorcycle wheels have to be 2");
//		}
//		if (cargoSpace == 0) {//if cargo space is 0 assign it. if not throw exception
//			super.setCargoSpace(cargoSpace);
//		}else {
//			throw new IllegalArgumentException("Motorcycle cannot have cargo space. Cargo space must be 0.");
//		}
		this.accessories = accessories;
	}
	
	//getter & setter methods
	public ArrayList<String> getAccessories(){
		return accessories;
	}

	public void addAccessories(ArrayList<String> accessories) {
		if (accessories != null)
		this.accessories = accessories;
	}

	public String TwistThrottle() {
		return "accelerating";
	}
	
	@Override //number of wheels
	public void setWheels(int wheels) { 
		if (wheels == 2) {
			super.setWheels(wheels);
		}else {
			throw new IllegalArgumentException("Motorcycle can only have 2 wheels.");
		}
	}
	
	@Override //override cargo space
	public void setCargoSpace(double cargoSpace) { 
		if (cargoSpace == 0) {//if cargo space is 0 assign it. if not throw exception
			super.setCargoSpace(cargoSpace);
		}else {
			throw new IllegalArgumentException("Motorcycle cannot have cargo space. Cargo space must be 0.");
		}
	}
	
	@Override
	public String toString() {
		return "\n"+ super.toString() + 
				", Accessories: " + this.accessories;
	}

	@Override
	public boolean equals(Object otherObject) {
		if(!super.equals(otherObject)) return false;
		Motorcycle other = (Motorcycle) otherObject;
		return accessories == other.accessories;
	}
}