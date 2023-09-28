//Written by: Su Win

package vehicles;

public class Bicycle extends Vehicle {
	private String type = "electric";

	public Bicycle() {
		this.type = "elecric";
	}
	
	public Bicycle(int wheels, double cargoSpace, String color, String type) throws VehicleException{
		super(wheels,cargoSpace, color);
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
