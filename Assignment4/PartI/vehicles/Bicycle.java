//Written by: Su Win

package vehicles;

public class Bicycle extends Vehicle {
	
	private String type = "electric";

	/*In the instruction, ""Bicycles and motorcycles have 2 wheels and 0 cargo space."
	 * So, set wheels as 2 and then, cargo space as 0.
	 * "Bicycles and CargoCycles can be electric." 
	 * So, set the default type as electric
	 */
	public Bicycle() {
		this.type = "elecric";
		super.setWheels(2);
		super.setCargoSpace(0);
	}
	
	public Bicycle(String type) {
		this();
		if (type != null)
			this.type = type;
	}
	
	public Bicycle(int wheels, double cargoSpace, String color, String type) {
		super(wheels,cargoSpace, color);
		if (wheels != 2) //if statement to make sure create and object with 2 wheels
			super.setWheels(2);
		if (cargoSpace != 0) //bicycle have 0 cargo space. So, set it as 0
			super.setCargoSpace(0);
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		if (type != null)
			this.type = type;
	}
	
	public String Pedal() {
		return "pedaling";
	}

	@Override
	public String toString() {
		return "\n"+ super.toString() + ", Type: " + this.type;
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if(!super.equals(otherObject)) return false;
		Bicycle other = (Bicycle) otherObject;
		return type == other.type;
	}
}
